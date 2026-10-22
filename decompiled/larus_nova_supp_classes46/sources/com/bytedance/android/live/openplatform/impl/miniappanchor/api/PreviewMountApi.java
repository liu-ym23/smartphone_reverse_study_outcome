package com.bytedance.android.live.openplatform.impl.miniappanchor.api;

import com.bytedance.android.live.network.response.e;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00050\u00042\b\b\u0003\u0010\u0003\u001a\u00020\u0002H'¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/api/PreviewMountApi;", "", "", "appId", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/e;", "preAppStart", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface PreviewMountApi {
    @POST("/webcast/stamp/pre/app/start/")
    Observable<e<Object>> preAppStart(@Query("app_id") String r1);
}
