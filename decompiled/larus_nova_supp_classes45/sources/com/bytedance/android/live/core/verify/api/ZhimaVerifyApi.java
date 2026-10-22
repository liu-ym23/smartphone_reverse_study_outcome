package com.bytedance.android.live.core.verify.api;

import com.bytedance.android.live.base.model.verify.a;
import com.bytedance.android.live.base.model.verify.b;
import com.bytedance.android.live.base.model.verify.c;
import com.bytedance.android.live.core.verify.responbean.CertificationQuery;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.model.GetCertificationEntranceResponse;
import com.bytedance.android.livesdk.model.ZhimaStatusResponse;
import com.bytedance.retrofit2.http.FieldMap;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import com.bytedance.retrofit2.http.QueryMap;
import com.google.gson.JsonObject;
import io.reactivex.Observable;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface ZhimaVerifyApi {
    @PbRequest("preview")
    @GET("/webcast/anchor/permission/creator_certification_chk/")
    Observable<Response<a>> getCertificationCheck();

    @FormUrlEncoded
    @POST("/webcast/certification/common/submit/")
    Observable<Response<w80.a>> getCertificationCommonSubmit(@FieldMap Map<String, String> r1);

    @GET("/webcast/certification/get_certification_entrance/")
    Observable<Response<GetCertificationEntranceResponse>> getCertificationEntrance();

    @GET("/webcast/certification/get_certification_status/")
    Observable<Response<ZhimaStatusResponse>> getCertificationStatus();

    @GET("/webcast/certification/certification_page_init/")
    Observable<Response<b>> getCertificationStatusForAll();

    @GET("/webcast/openapi/certification/get_certification_status/")
    Observable<Response<c>> getCertificationStatusForSaaS(@Query("open_app_id") int r1, @Query("third_user_id") String r2, @Query("open_cert_token") String r3);

    @FormUrlEncoded
    @POST("/webcast/certification/submit/")
    Observable<Response<w80.a>> getCertificationSubmit(@FieldMap Map<String, String> r1);

    @GET("/webcast/certification/common/query/")
    Observable<Response<CertificationQuery>> queryCertificationCommonResult(@QueryMap Map<String, String> r1);

    @GET("/webcast/certification/common/query/")
    Observable<Response<JsonObject>> queryCertificationCommonResultForString(@QueryMap Map<String, String> r1);

    @GET("/webcast/certification/query/")
    Observable<Response<CertificationQuery>> queryCertificationResult(@QueryMap Map<String, String> r1);

    @GET("/webcast/certification/query/")
    Observable<Response<JsonObject>> queryCertificationResultForString(@QueryMap Map<String, String> r1);
}
