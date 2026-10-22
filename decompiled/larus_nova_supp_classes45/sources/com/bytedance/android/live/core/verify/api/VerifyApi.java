package com.bytedance.android.live.core.verify.api;

import com.bytedance.android.live.network.response.Response;
import com.bytedance.retrofit2.http.FieldMap;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.POST;
import io.reactivex.Observable;
import java.util.Map;
import w80.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface VerifyApi {
    @FormUrlEncoded
    @POST("/webcast/certification/id_card_verify/")
    Observable<Response<a>> getCertificationVerify(@FieldMap Map<String, String> r1);
}
