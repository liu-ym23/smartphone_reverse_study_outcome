package com.bytedance.android.live.broadcast.api;

import com.bytedance.android.live.broadcast.api.model.FansClubSwitchResponse;
import com.bytedance.android.live.broadcast.api.model.ScreenChatSettingGetResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.network.response.a;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J<\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u0004H'J\u0014\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\t0\bH'J\u0018\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\b2\b\b\u0001\u0010\u000e\u001a\u00020\u0004H'J\u0018\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\b2\b\b\u0001\u0010\u0011\u001a\u00020\u0004H'¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/LivePrivilegeSettingApi;", "", "", "isAllowed", "", "followType", "fansType", "activeType", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/Response;", "", "setPrivilegeBarrageSetting", "Lcom/bytedance/android/live/broadcast/api/model/ScreenChatSettingGetResponse;", "getPrivilegeBarrageSetting", "switch", "Lcom/bytedance/android/live/network/response/a;", "setBuyVIPSetting", "fansClubType", "Lcom/bytedance/android/live/broadcast/api/model/FansClubSwitchResponse;", "switchFansClubType", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface LivePrivilegeSettingApi {
    @POST("/webcast/privilege/screen_chat/setting/get/")
    Observable<Response<ScreenChatSettingGetResponse>> getPrivilegeBarrageSetting();

    @GET("/webcast/privilege/subscribe/buy_switch")
    Observable<a> setBuyVIPSetting(@Query("switch") int r1);

    @POST("/webcast/privilege/screen_chat/setting/set/")
    Observable<Response<Unit>> setPrivilegeBarrageSetting(@Query("allow") boolean r1, @Query("follow_type") int r2, @Query("fansclub_type") int r3, @Query("active_type") int r4);

    @GET("https://lianmengapi.snssdk.com/live/seller/fansclub/switch/")
    Observable<FansClubSwitchResponse> switchFansClubType(@Query("fans_club_type") int r1);
}
