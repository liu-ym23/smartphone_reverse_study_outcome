package com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.api;

import com.bytedance.android.live.liveinteract.chatroom.chatroom.model.GetPositionPanelResponse;
import com.bytedance.android.live.network.response.a;
import com.bytedance.android.live.network.response.e;
import com.bytedance.android.livesdk.multilink.base.model.d;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J4\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005H'J\"\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\f\u001a\u00020\u000bH'J(\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\b0\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u000f\u001a\u00020\u0005H'¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/dialog/api/LiveAdjustPositionApi;", "", "", "roomId", "toUserId", "", "toUserIdString", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/e;", "Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/model/GetPositionPanelResponse;", "getPositionPanel", "", "pingType", "Lcom/bytedance/android/live/network/response/a;", "pingAdjustPosition", "userPositionContent", "Lcom/bytedance/android/livesdk/multilink/base/model/d;", "adjustPosition", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface LiveAdjustPositionApi {
    @GET("/webcast/linkmic_audience/adjust_position/")
    Observable<e<d>> adjustPosition(@Query("room_id") long r1, @Query("user_position_map") String r3);

    @GET("/webcast/linkmic_audience/get_position_panel/")
    Observable<e<GetPositionPanelResponse>> getPositionPanel(@Query("room_id") long r1, @Query("to_user_id") long r3, @Query("to_open_id") String r5);

    @GET("/webcast/linkmic_audience/adjust_position_ping/")
    Observable<a> pingAdjustPosition(@Query("room_id") long r1, @Query("ping_type") int r3);
}
