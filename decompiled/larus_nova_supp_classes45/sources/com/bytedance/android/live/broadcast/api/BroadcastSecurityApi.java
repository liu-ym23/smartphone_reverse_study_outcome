package com.bytedance.android.live.broadcast.api;

import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdkapi.depend.model.live.security.TextCorrection;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface BroadcastSecurityApi {
    @POST("/webcast/security/ignorecorrection/")
    Observable<Response<Object>> ignoreCorrection(@Query("ignored_text") String r1);

    @POST("/webcast/security/textcorrection/")
    Observable<Response<TextCorrection>> textCorrection(@Query("text") String r1);
}
