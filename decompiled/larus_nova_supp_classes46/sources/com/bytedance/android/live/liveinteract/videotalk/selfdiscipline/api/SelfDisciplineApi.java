package com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.api;

import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.network.response.e;
import com.bytedance.android.livesdk.chatroom.model.interact.k1;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H'J2\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000e0\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u000b\u001a\u00020\n2\b\b\u0003\u0010\r\u001a\u00020\fH'J<\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000e0\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u000b\u001a\u00020\n2\b\b\u0003\u0010\r\u001a\u00020\f2\b\b\u0001\u0010\u0010\u001a\u00020\u0002H'J(\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000e0\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0011\u001a\u00020\nH'J(\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0013\u001a\u00020\fH'¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/live/liveinteract/videotalk/selfdiscipline/api/SelfDisciplineApi;", "", "", "roomId", "", "usePlayModeInfo", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/e;", "Lcom/bytedance/android/livesdk/chatroom/model/interact/k1;", "getPlayModeInfo", "", "status", "", "target", "Lcom/bytedance/android/live/network/response/Response;", "setStatus", "punchDuration", "contentType", "sendSelfSignal", "userIds", "Lcom/bytedance/android/live/liveinteract/videotalk/selfdiscipline/api/SelfDisciplinePunchInfoResponse;", "getPunchInfo", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface SelfDisciplineApi {
    @GET("/webcast/linkmic_audience/get_play_mode_info/")
    Observable<e<k1>> getPlayModeInfo(@Query("room_id") long r1, @Query("use_play_mode_info") boolean r3);

    @GET("/webcast/linkmic_profit/self_discipline_config/punch_info/")
    Observable<e<SelfDisciplinePunchInfoResponse>> getPunchInfo(@Query("room_id") long r1, @Query("user_ids") String r3);

    @GET("/webcast/linkmic_profit/self_discipline_config/send_signal/")
    Observable<Response<Object>> sendSelfSignal(@Query("room_id") long r1, @Query("content_type") int r3);

    @GET("/webcast/linkmic_audience/self_discipline_config/")
    Observable<Response<Object>> setStatus(@Query("room_id") long r1, @Query("switch_status") int r3, @Query("target") String r4);

    @GET("/webcast/linkmic_audience/self_discipline_config/")
    Observable<Response<Object>> setStatus(@Query("room_id") long r1, @Query("switch_status") int r3, @Query("target") String r4, @Query("punch_duration") long r5);
}
