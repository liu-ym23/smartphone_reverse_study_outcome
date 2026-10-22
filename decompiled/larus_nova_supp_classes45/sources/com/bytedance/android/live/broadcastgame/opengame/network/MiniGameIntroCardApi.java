package com.bytedance.android.live.broadcastgame.opengame.network;

import com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformBaseDebugger;
import com.bytedance.retrofit2.http.Field;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H'J\u001e\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00070\u00062\b\b\u0001\u0010\u0005\u001a\u00020\u0004H'J,\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\r\u001a\u00020\fH'¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/network/MiniGameIntroCardApi;", "", "", "appId", "", "roomId", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/e;", "Lcom/bytedance/android/live/broadcastgame/opengame/network/model/k;", "getMiniGameIntroCardStatus", "Lcom/bytedance/android/live/broadcastgame/opengame/network/model/j;", "getIntroCardInfo", "", "displayStatus", "Lcom/bytedance/android/live/network/response/a;", "updateGameCardStatus", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface MiniGameIntroCardApi {
    @GET("/webcast/stamp/game_card_info/")
    Observable<com.bytedance.android.live.network.response.e<com.bytedance.android.live.broadcastgame.opengame.network.model.j>> getIntroCardInfo(@Query("room_id") long r1);

    @GET("/webcast/stamp/game_card_status/")
    Observable<com.bytedance.android.live.network.response.e<com.bytedance.android.live.broadcastgame.opengame.network.model.k>> getMiniGameIntroCardStatus(@Query(OpenPlatformBaseDebugger.APP_ID) String r1, @Query("room_id") long r2);

    @FormUrlEncoded
    @POST("/webcast/stamp/game_card_status_update/")
    Observable<com.bytedance.android.live.network.response.a> updateGameCardStatus(@Field(OpenPlatformBaseDebugger.APP_ID) String r1, @Field("room_id") long r2, @Field("display_status") int r4);
}
