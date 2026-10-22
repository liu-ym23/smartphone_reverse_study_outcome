package com.bytedance.android.live.broadcast.api;

import com.bytedance.android.live.broadcast.api.model.e1;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.retrofit2.http.Field;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.POST;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H'J2\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u000b\u001a\u00020\nH'J\u001e\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\b\b\u0001\u0010\u0005\u001a\u00020\u0004H'J(\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0003\u0010\u000b\u001a\u00020\nH'J\u0014\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006H'¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/ReplaySettingApi;", "", "", "replaySwitch", "", "enabled", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/Response;", "Lcom/bytedance/android/live/broadcast/api/model/e1;", "updateSetting", "", "roomId", "updateRealTimePlaybackSetting", "getSettingInfo", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ReplaySettingApi {
    @GET("/webcast/room/replay/setting/")
    Observable<Response<e1>> getSettingInfo();

    @FormUrlEncoded
    @POST("/webcast/room/replay/setting_update/")
    Observable<Response<e1>> updateRealTimePlaybackSetting(@Field("realtime_replay_enabled") boolean r1);

    @FormUrlEncoded
    @POST("/webcast/room/replay/setting_update/")
    Observable<Response<e1>> updateRealTimePlaybackSetting(@Field("realtime_replay_enabled") boolean r1, @Field("room_id") long r2);

    @FormUrlEncoded
    @POST("/webcast/room/replay/setting_update/")
    Observable<Response<e1>> updateSetting(@Field("replay_switch") int r1, @Field("enabled") boolean r2);

    @FormUrlEncoded
    @POST("/webcast/room/replay/setting_update/")
    Observable<Response<e1>> updateSetting(@Field("replay_switch") int r1, @Field("enabled") boolean r2, @Field("room_id") long r3);
}
