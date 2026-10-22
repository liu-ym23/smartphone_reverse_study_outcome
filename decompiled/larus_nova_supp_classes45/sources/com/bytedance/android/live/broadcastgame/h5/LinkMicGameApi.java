package com.bytedance.android.live.broadcastgame.h5;

import am3.g;
import com.bytedance.android.live.network.response.e;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import com.google.gson.annotations.SerializedName;
import io.reactivex.Single;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\u0011JV\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\b\u0001\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\t\u001a\u00020\u00072\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0004H'JB\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\f0\u000b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u0004H'¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/h5/LinkMicGameApi;", "", "", "roomId", "", "gameId", "gameCategory", "", "publicStreamType", "runningType", "startSource", "Lio/reactivex/Single;", "Lcom/bytedance/android/live/network/response/e;", "Lcom/bytedance/android/live/broadcastgame/h5/LinkMicGameApi$a;", "startgame", "source", "stopGame", "a", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface LinkMicGameApi {

    @ProtoMessage("webcast.api.linkmic_profit.GameStartResponse.ResponseData")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/h5/LinkMicGameApi$a;", "", "", "targetUiLayout", "J", "a", "()J", "setTargetUiLayout", "(J)V", "<init>", "()V", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a implements h {

        @SerializedName("target_ui_layout")
        protected long targetUiLayout;

        public a() {
        }

        public final String toString() {
            return "GameStartResponse(targetUiLayout=" + this.targetUiLayout + ')';
        }

        public final long a() {
            return this.targetUiLayout;
        }

        public a(g r5) {
            long r0 = r5.c();
        L3:
            int r2 = r5.f();
            if (r2 == (-1)) goto L9;
            if (r2 != 1) goto L7;
            this.targetUiLayout = r5.j();
            goto L3
        L7:
            am3.h.e(r5);
            goto L3
        L9:
            r5.d(r0);
        }
    }

    @GET("/webcast/linkmic_profit/game_start/")
    Single<e<a>> startgame(@Query("room_id") long r1, @Query("game_id") String r3, @Query("game_category") String r4, @Query("public_stream_type") int r5, @Query("running_type") int r6, @Query("start_source") String r7);

    @GET("/webcast/linkmic_profit/game_stop/")
    Single<e<Object>> stopGame(@Query("room_id") long r1, @Query("game_id") String r3, @Query("game_category") String r4, @Query("source") String r5);
}
