package com.bytedance.android.live.broadcastgame.opengame.network.outer;

import com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformBaseDebugger;
import com.bytedance.android.live.broadcastgame.opengame.network.model.h;
import com.bytedance.android.live.broadcastgame.opengame.network.model.m;
import com.bytedance.android.live.network.response.e;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J3\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0004H'¢\u0006\u0004\b\t\u0010\nJ3\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00070\u00062\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0004H'¢\u0006\u0004\b\f\u0010\nJ3\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00070\u00062\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0004H'¢\u0006\u0004\b\u000e\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/network/outer/GamePlayApi;", "", "", "appId", "", "gameId", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/e;", "Lcom/bytedance/android/live/broadcastgame/opengame/network/model/h;", "collectGame", "(Ljava/lang/String;Ljava/lang/Long;)Lio/reactivex/Observable;", "Lcom/bytedance/android/live/broadcastgame/opengame/network/model/e;", "cancelCollectGame", "Lcom/bytedance/android/live/broadcastgame/opengame/network/model/m$a;", "fetchCollectStatus", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface GamePlayApi {
    @GET("/webcast/gameplay/applet/collection/remove/")
    Observable<e<com.bytedance.android.live.broadcastgame.opengame.network.model.e>> cancelCollectGame(@Query(OpenPlatformBaseDebugger.APP_ID) String r1, @Query("game_id") Long r2);

    @GET("/webcast/gameplay/applet/collection/add/")
    Observable<e<h>> collectGame(@Query(OpenPlatformBaseDebugger.APP_ID) String r1, @Query("game_id") Long r2);

    @GET("/webcast/gameplay/applet/user/info/")
    Observable<e<m.a>> fetchCollectStatus(@Query(OpenPlatformBaseDebugger.APP_ID) String r1, @Query("game_id") Long r2);
}
