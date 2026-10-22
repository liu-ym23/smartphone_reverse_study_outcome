package com.bytedance.android.live.openplatform.impl.miniappaudience.api;

import com.bytedance.android.live.network.response.e;
import com.bytedance.android.live.openplatform.impl.miniappaudience.api.response.a;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J2\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u0005H'¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappaudience/api/AudiencePrivateMsgApi;", "", "", "appId", "token", "", "roomId", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/e;", "Lcom/bytedance/android/live/openplatform/impl/miniappaudience/api/response/a;", "getPrivateMsgByToken", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface AudiencePrivateMsgApi {
    @GET("/webcast/microapp/private_msg_tab/show/")
    Observable<e<a>> getPrivateMsgByToken(@Query("app_id") String r1, @Query("token") String r2, @Query("room_id") long r3);
}
