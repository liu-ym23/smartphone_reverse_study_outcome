package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.control;

import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J6\u0010\u000b\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0018\u00010\b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0003\u0010\u0005\u001a\u00020\u00042\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0006H'ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0001"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/control/MorePanelControlApi;", "", "", "roomId", "", "occasion", "", "extraParams", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/e;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/control/MorePanelInfoData;", "queryMorePanelControlData", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface MorePanelControlApi {
    @GET("/webcast/room/more_panel/info/")
    Observable<com.bytedance.android.live.network.response.e<MorePanelInfoData>> queryMorePanelControlData(@Query("room_id") long r1, @Query("occasion") int r3, @Query("common_params") String r4);
}
