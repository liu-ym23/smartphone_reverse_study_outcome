package com.bytedance.android.live.openplatform.impl.openapi.api;

import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.openplatform.impl.base.api.response.OpenPlatformRespExtra;
import com.bytedance.android.live.openplatform.impl.openapi.api.response.a;
import com.bytedance.android.live.openplatform.impl.openapi.api.response.b;
import com.bytedance.android.live.openplatform.impl.openapi.api.response.c;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J.\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H'J.\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t0\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H'J.\u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\t0\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H'¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/openapi/api/OpenPlatformApi;", "", "", "appId", "", "roomId", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/ExtraResponse;", "Lcom/bytedance/android/live/openplatform/impl/openapi/api/response/b;", "Lcom/bytedance/android/live/openplatform/impl/base/api/response/OpenPlatformRespExtra;", "getRoomInfo", "Lcom/bytedance/android/live/openplatform/impl/openapi/api/response/c;", "getCurrentUserInfo", "Lcom/bytedance/android/live/openplatform/impl/openapi/api/response/a;", "isFollowAnchor", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface OpenPlatformApi {
    @GET("/webcast/openapi/user/info/mine/")
    Observable<ExtraResponse<c, OpenPlatformRespExtra>> getCurrentUserInfo(@Query("app_id") String r1, @Query("room_id") long r2);

    @GET("/webcast/openapi/room/info/")
    Observable<ExtraResponse<b, OpenPlatformRespExtra>> getRoomInfo(@Query("app_id") String r1, @Query("room_id") long r2);

    @GET("/webcast/openapi/follow/status/")
    Observable<ExtraResponse<a, OpenPlatformRespExtra>> isFollowAnchor(@Query("app_id") String r1, @Query("room_id") long r2);
}
