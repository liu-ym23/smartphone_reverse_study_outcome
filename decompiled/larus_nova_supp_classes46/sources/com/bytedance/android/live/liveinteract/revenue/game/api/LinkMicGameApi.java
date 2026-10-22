package com.bytedance.android.live.liveinteract.revenue.game.api;

import am3.g;
import com.bytedance.android.live.network.response.e;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import com.google.gson.annotations.SerializedName;
import io.reactivex.Single;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\rJ(\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H'J(\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\n\u001a\u00020\tH'¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/liveinteract/revenue/game/api/LinkMicGameApi;", "", "", "roomId", "", "status", "Lio/reactivex/Single;", "Lcom/bytedance/android/live/network/response/e;", "positionStashPop", "", "toUserIds", "Lcom/bytedance/android/live/liveinteract/revenue/game/api/LinkMicGameApi$a;", "groupLiveGameInviteFriend", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface LinkMicGameApi {

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/liveinteract/revenue/game/api/LinkMicGameApi$a;", "", "", "", "successUids", "Ljava/util/List;", "a", "()Ljava/util/List;", "setSuccessUids", "(Ljava/util/List;)V", "toast", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setToast", "(Ljava/lang/String;)V", "<init>", "()V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class a implements h {

        @SerializedName("success_uids")
        protected List<String> successUids;

        @SerializedName("toast")
        protected String toast;

        public a() {
        }

        public a(g r5) {
            this.successUids = new ArrayList();
            long r0 = r5.c();
        L3:
            int r2 = r5.f();
            if (r2 == (-1)) goto L12;
            if (r2 != 1) goto L8;
            this.successUids.add(am3.h.c(r5));
            goto L3
        L8:
            if (r2 != 2) goto L9;
            this.toast = am3.h.c(r5);
            goto L3
        L9:
            am3.h.e(r5);
            goto L3
        L12:
            r5.d(r0);
        }

        public final List<String> a() {
            return this.successUids;
        }

        public final String b() {
            return this.toast;
        }
    }

    @GET("/webcast/linkmic_profit/group_game_invite_friend/")
    Single<e<a>> groupLiveGameInviteFriend(@Query("room_id") long r1, @Query("to_user_ids") String r3);

    @GET("/webcast/linkmic_audience/position_stash_pop/")
    Single<e<Object>> positionStashPop(@Query("room_id") long r1, @Query("status") int r3);
}
