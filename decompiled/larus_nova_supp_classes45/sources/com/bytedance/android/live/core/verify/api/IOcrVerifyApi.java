package com.bytedance.android.live.core.verify.api;

import com.bytedance.android.live.network.response.Response;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import com.bytedance.retrofit2.http.QueryMap;
import com.google.gson.JsonObject;
import io.reactivex.Observable;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface IOcrVerifyApi {
    @GET("/webcast/certification/query/")
    Observable<Response<JsonObject>> queryPollingStatus(@Query("verify_channel") String r1, @Query("byte_token") String r2, @Query("scene") int r3, @Query("enter_from") String r4, @Query("skip_record_verify") boolean r5, @Query("cert_type") String r6, @Query("byte_scene") String r7, @Query("children_cert_token") String r8, @Query("youth_cert_scene") int r9, @QueryMap Map<String, String> r11);

    @GET("/webcast/certification/query/")
    Observable<Response<JsonObject>> queryPollingStatus(@Query("verify_channel") String r1, @Query("byte_token") String r2, @Query("enter_from") String r3, @Query("skip_record_verify") boolean r4, @Query("cert_type") String r5, @Query("byte_scene") String r6, @Query("children_cert_token") String r7, @Query("youth_cert_scene") int r8, @QueryMap Map<String, String> r9);
}
