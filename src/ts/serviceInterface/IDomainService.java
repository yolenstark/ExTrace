package ts.serviceInterface;

import java.sql.Timestamp;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.hibernate.annotations.Parameter;

import ts.model.ExpressSheet;
import ts.model.PackageRoute;
import ts.model.TransPackage;
import ts.smodel.LocXY;

@Path("/Domain")	//业务操作
public interface IDomainService {
    //快件操作访问接口=======================================================================
	/**
	 *JAX-RS 定义了 @POST、@GET、@PUT 和 @DELETE，分别对应 4 种 HTTP 方法
	 *用于对资源进行创建、检索、更新和删除的操作。 
	 */
    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Path("/getExpressList/{Property}/{Restrictions}/{Value}") 
	public List<ExpressSheet> getExpressList(@PathParam("Property")String property, @PathParam("Restrictions")String restrictions, @PathParam("Value")String value);

    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Path("/getExpressListInPackage/PackageId/{PackageId}") 
	public List<ExpressSheet> getExpressListInPackage(@PathParam("PackageId")String packageId);

    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Path("/getExpressSheet/{id}") 
	public Response getExpressSheet(@PathParam("id")String id);

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Path("/newExpressSheet/id/{id}/uid/{uid}") 
	public Response newExpressSheet(@PathParam("id")String id, @PathParam("uid")int uid);
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Path("/saveExpressSheet") 
	public Response saveExpressSheet(ExpressSheet obj);
    
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Path("/receiveExpressSheetId/id/{id}/uid/{uid}") 
	public Response ReceiveExpressSheetId(@PathParam("id")String id, @PathParam("uid")int uid);
    
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Path("/dispatchExpressSheetId/id/{id}/uid/{uid}") 
	public Response DispatchExpressSheet(@PathParam("id")String id, @PathParam("uid")int uid);
    
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Path("/deliveryExpressSheetId/id/{id}/uid/{uid}") 
	public Response DeliveryExpressSheetId(@PathParam("id")String id, @PathParam("uid")int uid);

    //包裹操作访问接口=======================================================================
    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Path("/getTransPackageList/{Property}/{Restrictions}/{Value}") 
	public List<TransPackage> getTransPackageList(@PathParam("Property")String property, @PathParam("Restrictions")String restrictions, @PathParam("Value")String value);

    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Path("/getTransPackage/{id}") 
	public Response getTransPackage(@PathParam("id")String id);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/newTransPackage") 
    public Response newTransPackage(String id, int uid);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/saveTransPackage") 
	public Response saveTransPackage(TransPackage obj);
    
  //画路径使用  
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/savePackageRoutePos/{packagetId}/{x}/{y}")
    public Response saveRoutePos(@PathParam("packagetId")String packageId,@PathParam("x")double x,@PathParam("y")double y);
    
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/getPackageRoutePos/{ExpressSheetid}/{time}")
    public List<LocXY> getPackageRoutePos(@PathParam("ExpressSheetid")String ExpressSheetid, @PathParam("time")String time);
    
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/getPackageRoutePos/{ExpressSheetid}")
    public List<LocXY> getPackageRoutePos(@PathParam("ExpressSheetid")String ExpressSheetid);
    
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/getPostCode/{pro}/{city}/{town}")
    public String getPostCode(@PathParam("pro")String pro, @PathParam("city")String city, @PathParam("town")String town);

   //转运
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/putExpressIntoPkg/{ExpressSheetid}/{packageid}")
    public Response putExpressIntoPkg(@PathParam("expressSheetId")String ExpressSheetid,
    								  @PathParam("packageId")String packageId);
    
    //拆包
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/unBoxingPackage/{packageId}")
    public Response unBoxingPackage(@PathParam("packageId")String packageId);
    
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/unBoxingExpressSheet/{expressSheetId}")
    //这个方法没用
    public Response unBoxingExpressSheet(@PathParam("expressSheetId")String expressSheetId);
    
    //历史信息
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getTransHistory/{expreeSheetId}")
    public Response getTransHistroy(@PathParam("expressSheetId") String expressSheetId);
    
    
    
    
    
    
    //test
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getString")
    public String getString(LocXY local);
    
    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    @Path("/fun")
    public Response fun(@FormParam("shihu") String shihu);
}
