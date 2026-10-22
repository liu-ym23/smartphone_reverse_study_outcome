package c;

import java.util.HashMap;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/* JADX INFO: loaded from: classes.dex */
interface w {
    @GET("place/text")
    mt.n<Object> a(@QueryMap HashMap<String, String> r5);
}
