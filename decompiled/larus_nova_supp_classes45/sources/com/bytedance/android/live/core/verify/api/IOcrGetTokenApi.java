package com.bytedance.android.live.core.verify.api;

import com.bytedance.android.live.core.verify.responbean.CertificationAuthData;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface IOcrGetTokenApi {
    @GET("webcast/certification/auth/")
    Observable<Response<CertificationAuthData>> getCertificationEntrance(@Query("verify_channel") String r1, @Query("cert_scene") String r2, @Query("cert_name") String r3, @Query("cert_id") String r4, @Query("skip_record_verify") boolean r5, @Query("enter_from") String r6);
}
