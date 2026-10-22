package com.bytedance.android.live.broadcast.api;

import com.bytedance.android.live.broadcast.api.model.s1;
import com.bytedance.android.live.network.response.e;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J3\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0004H'¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/ToolbarPermissionAlertApi;", "", "", "componentType", "", "clickSource", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/e;", "Lcom/bytedance/android/live/broadcast/api/model/s1;", "toolbarPermissionCheck", "(Ljava/lang/Long;Ljava/lang/String;)Lio/reactivex/Observable;", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ToolbarPermissionAlertApi {
    @GET("/webcast/room/toolbar_permission_alert/")
    Observable<e<s1>> toolbarPermissionCheck(@Query("component_type") Long r1, @Query("click_source") String r2);
}
