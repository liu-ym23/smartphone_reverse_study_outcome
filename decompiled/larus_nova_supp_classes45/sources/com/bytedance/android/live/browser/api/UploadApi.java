package com.bytedance.android.live.browser.api;

import com.bytedance.android.live.base.model.user.UploadResult;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Url;
import com.bytedance.retrofit2.mime.TypedOutput;
import io.reactivex.Single;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface UploadApi {
    @POST("/webcast/certification/submit_cert_data/")
    Single<Response<UploadResult>> upload(@Body TypedOutput r1);

    @POST
    Single<Response<UploadResult>> upload(@Url String r1, @Body TypedOutput r2);
}
