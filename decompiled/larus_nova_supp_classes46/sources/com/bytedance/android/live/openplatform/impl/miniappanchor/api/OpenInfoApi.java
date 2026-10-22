package com.bytedance.android.live.openplatform.impl.miniappanchor.api;

import com.bytedance.android.live.network.response.e;
import com.bytedance.android.live.openplatform.impl.miniappanchor.api.request.a;
import com.bytedance.android.live.openplatform.impl.miniappanchor.api.response.d;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.POST;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/api/OpenInfoApi;", "", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/api/request/a;", "body", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/e;", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/api/response/d;", "getMicroAppOpenInfo", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface OpenInfoApi {
    @POST("/webcast/microapp/get/micro_app_open_info/")
    Observable<e<d>> getMicroAppOpenInfo(@Body a r1);
}
