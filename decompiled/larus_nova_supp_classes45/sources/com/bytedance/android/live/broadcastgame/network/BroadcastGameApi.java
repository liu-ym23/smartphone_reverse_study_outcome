package com.bytedance.android.live.broadcastgame.network;

import com.bytedance.android.live.broadcastgame.api.model.e0;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.network.response.e;
import com.bytedance.retrofit2.http.Multipart;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Part;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;
import j10.a;
import j10.b;
import kotlin.Metadata;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J<\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0007\u001a\u00020\u0002H'JZ\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\t0\b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\f\u001a\u00020\u00022\b\b\u0001\u0010\r\u001a\u00020\u00052\b\b\u0001\u0010\u000f\u001a\u00020\u000e2\b\b\u0001\u0010\u0011\u001a\u00020\u00102\b\b\u0001\u0010\u0007\u001a\u00020\u0002H'J2\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\t0\b2\b\b\u0003\u0010\u0003\u001a\u00020\u00022\b\b\u0003\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0013\u001a\u00020\u0010H'J\u0018\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\b2\b\b\u0001\u0010\u0017\u001a\u00020\u0016H'¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/network/BroadcastGameApi;", "", "", "gameId", "roomId", "", "openType", "gameToken", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/e;", "Lcom/bytedance/android/live/broadcastgame/api/model/e0;", "notifyServerGameStart", "playId", "gameData", "", "isCutShort", "", "stopReason", "notifyServerGameStop", "gameKind", "Lj10/a;", "getGameFeedbackTagList", "Lokhttp3/RequestBody;", "context", "Lj10/b;", "postGameFeedback", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface BroadcastGameApi {
    @PbRequest("live_game")
    @POST("/webcast/game/resource/config/")
    Observable<e<a>> getGameFeedbackTagList(@Query("game_id") long r1, @Query("room_id") long r3, @Query("play_kind") int r5);

    @POST("/webcast/game/status/start/")
    Observable<e<e0>> notifyServerGameStart(@Query("game_id") long r1, @Query("room_id") long r3, @Query("open_type") String r5, @Query("game_token") long r6);

    @POST("/webcast/game/status/stop/")
    Observable<e<Object>> notifyServerGameStop(@Query("game_id") long r1, @Query("room_id") long r3, @Query("play_id") long r5, @Query("game_data") String r7, @Query("is_cut_short") boolean r8, @Query("stop_reason") int r9, @Query("game_token") long r11);

    @Multipart
    @POST("https://i.snssdk.com/feedback/2/post_message/")
    Observable<b> postGameFeedback(@Part("content") RequestBody r1);
}
