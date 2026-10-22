package com.bytedance.android.live.openplatform.impl.miniappanchor.api;

import com.bytedance.android.live.network.response.e;
import com.bytedance.android.live.openplatform.impl.miniappanchor.api.response.f;
import com.bytedance.android.live.openplatform.impl.miniappanchor.api.response.n;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H'J2\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u000b\u001a\u00020\n2\b\b\u0001\u0010\u0005\u001a\u00020\u0004H'¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/api/AnchorPrivateMsgApi;", "", "", "appId", "", "roomId", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/e;", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/api/response/f;", "getPrivateMsgTab", "", "status", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/api/response/n;", "updatePrivateMsgTabStatus", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface AnchorPrivateMsgApi {
    @GET("/webcast/microapp/private_msg_tab/get/")
    Observable<e<f>> getPrivateMsgTab(@Query("app_id") String r1, @Query("room_id") long r2);

    @POST("/webcast/microapp/private_msg_tab/update/")
    Observable<e<n>> updatePrivateMsgTabStatus(@Query("app_id") String r1, @Query("status") int r2, @Query("room_id") long r3);
}
