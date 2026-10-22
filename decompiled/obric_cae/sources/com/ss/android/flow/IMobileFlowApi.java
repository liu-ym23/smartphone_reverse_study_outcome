package com.ss.android.flow;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.http.FieldMap;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface IMobileFlowApi {
    @GET("/activity/carrier_flow/query_flow/")
    Call<Object> getCarrierFlow(@Query("carrier") String r8);

    @FormUrlEncoded
    @POST("/activity/carrier_flow/update_flow/")
    Call<String> updateCarrierFlow(@FieldMap Map<String, String> r8);
}
