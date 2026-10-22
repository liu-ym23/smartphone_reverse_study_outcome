package com.bytedance.android.livesdk.feed.tab.api;

import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.network.response.BaseListResponse;
import com.bytedance.android.live.network.response.ListResponse;
import com.bytedance.android.livesdk.feed.feed.e;
import com.bytedance.android.livesdk.feed.feed.f;
import com.bytedance.android.livesdk.feed.tab.model.b;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Header;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface FeedTabApi {
    @PbRequest
    @GET("/webcast/v2/tab/")
    Observable<ListResponse<b>> queryNewTab(@Header("x-tt-request-tag") String r1);

    @GET("/webcast/tab/")
    Observable<BaseListResponse<e, f>> queryTab(@Query("show_location") int r1, @Header("x-tt-request-tag") String r2);

    @GET("/webcast/openapi/setting/tab/")
    Observable<BaseListResponse<e, f>> queryTabForSaas(@Query("show_location") int r1);
}
