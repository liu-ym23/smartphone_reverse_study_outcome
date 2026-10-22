package c;

import com.google.gson.JsonObject;
import com.zte.miboard.cards.express.data.ExpressDetailBean;
import com.zte.miboard.cards.express.data.ExpressRequestBean;
import com.zte.miboard.cards.express.data.GetSFH5Request;
import com.zte.miboard.cards.express.data.GetSFH5Result;
import com.zte.miboard.cards.express.data.LimitedResultBean;
import com.zte.miboard.cards.express.data.MoreResultBean;
import com.zte.miboard.cards.express.data.SimpleResultBean;
import java.util.Map;
import retrofit2.http.Body;
import retrofit2.http.HeaderMap;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/* JADX INFO: loaded from: classes.dex */
interface l {
    @Headers({"Content-Type: application/json"})
    @POST("query")
    mt.n<ExpressDetailBean> a(@Body JsonObject r5);

    @Headers({"Content-Type: application/json"})
    @POST("sms/verify")
    mt.n<SimpleResultBean> b(@Body JsonObject r5);

    @Headers({"Content-Type: application/json"})
    @POST("sms/get")
    mt.n<SimpleResultBean> c(@Body JsonObject r5);

    @Headers({"Content-Type: application/json"})
    @POST("mailno/delete")
    mt.n<SimpleResultBean> d(@Body JsonObject r5);

    @POST("getSFH5Url")
    mt.n<GetSFH5Result> e(@Body GetSFH5Request r5, @HeaderMap Map<String, String> r10);

    @POST("fetch/more2")
    mt.n<MoreResultBean> f(@Body ExpressRequestBean r5, @HeaderMap Map<String, String> r10);

    @Headers({"Content-Type: application/json"})
    @POST("follow")
    mt.n<SimpleResultBean> g(@Body JsonObject r5);

    @POST("fetch/limited2")
    mt.n<LimitedResultBean> h(@Body ExpressRequestBean r5, @HeaderMap Map<String, String> r10);

    @Headers({"Content-Type: application/json"})
    @POST("subscribe")
    mt.n<SimpleResultBean> i(@Body JsonObject r5);
}
