package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils;

import com.bytedance.android.live.network.response.Response;
import com.bytedance.retrofit2.http.Field;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J2\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u0004H'J$\u0010\u000e\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f\u0018\u00010\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u000bH'ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000fÀ\u0006\u0001"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar_behavior/utils/ToolbarBehaviorApi;", "", "", "roomId", "", "switchStatus", "switchType", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/e;", "", "roomToolbar", "", "Lcom/bytedance/android/live/network/response/Response;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar_behavior/utils/GetStreamPullDataResponse;", "getStreamPullData", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ToolbarBehaviorApi {
    @FormUrlEncoded
    @POST("/webcast/room/get_stream_pull_data/")
    Observable<Response<GetStreamPullDataResponse>> getStreamPullData(@Field("room_id_str") String r1);

    @POST("/webcast/paid/room_toolbar")
    Observable<com.bytedance.android.live.network.response.e<Unit>> roomToolbar(@Query("room_id") long r1, @Query("switch_status") int r3, @Query("switch_type") int r4);
}
