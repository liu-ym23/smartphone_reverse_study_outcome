package com.bytedance.android.live.broadcastgame.channel;

import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001JF\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0007\u001a\u00020\u00052\b\b\u0001\u0010\b\u001a\u00020\u0005H'¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/channel/GameRequestApi;", "", "", "roomId", "gameId", "", "anchorId", "path", "extra", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/e;", "Lcom/bytedance/android/live/broadcastgame/channel/c;", "requestServer", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface GameRequestApi {
    @POST("/webcast/game/effect/data/")
    Observable<com.bytedance.android.live.network.response.e<c>> requestServer(@Query("room_id") long r1, @Query("game_id") long r3, @Query("anchor_id") String r5, @Query("name") String r6, @Query("extra") String r7);
}
