package o01;

import com.bytedance.android.livesdk.revenue.service.room.c;
import com.bytedance.android.livesdk.revenue.service.vs.b;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo;
import com.bytedance.android.scope.o;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;
import yz0.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements o, n01.a {
    public final b a;
    public final k b;
    public final c c;

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // n01.a
    public final es2.a E0() {
        return this.a.E0();
    }

    @Override // n01.a
    public final boolean Fm() {
        if (this.a.O6() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.a.s8() == true) goto L8;
        return false;
    }

    @Override // n01.a
    public final boolean Km() {
        return this.a.isVSLive();
    }

    @Override // n01.a
    public final boolean X0() {
        return this.a.O6();
    }

    @Override // n01.a
    public final IEpisode Xc() {
        return (IEpisode) this.b.getDataCenter().get("data_vs_episode_data", new Episode());
    }

    @Override // n01.a
    public final boolean Yd() {
        return this.a.isVerticalVideo();
    }

    @Override // n01.a
    public final boolean a1() {
        return this.a.a1();
    }

    @Override // n01.a
    public final boolean b1() {
        return this.a.b1();
    }

    @Override // n01.a
    public final Episode cl() {
        return this.a.fe(this.b.getDataCenter());
    }

    @Override // n01.a
    public final long getEpisodeId() {
        IEpisodeExtraInfo r0 = this.b.getRoom().getEpisodeExtra();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getId();
    }

    public final com.bytedance.android.livesdk.revenue.room.a getRoomContext() {
        return this.c.getRoomContext();
    }

    @Override // n01.a
    public final boolean gk() {
        return this.a.q3();
    }

    @Override // n01.a
    public final Episode jf() {
        return this.a.getEpisode();
    }

    @Override // n01.a
    public final boolean p4() {
        return this.a.isVsRoom();
    }

    @Override // n01.a
    public final boolean Gk() {
        return getRoomContext().isVSLive();
    }

    @Override // n01.a
    public final long getCameraId() {
        return ((Number) getRoomContext().getCameraId().getValue()).longValue();
    }

    @Override // n01.a
    public final float getVsVerticalProgressBarHeight() {
        return getRoomContext().getVsVerticalProgressBarHeight();
    }

    @Override // n01.a
    public final boolean h9() {
        return getRoomContext().isVSFirstShow();
    }

    @Override // n01.a
    public final boolean i3() {
        return getRoomContext().isVSRoom();
    }

    @Override // n01.a
    public final boolean isVSVerticalStream() {
        return getRoomContext().isVSVerticalStream();
    }

    @Override // n01.a
    public final boolean wm() {
        return getRoomContext().isMediaRoom();
    }

    @Override // n01.a
    public final boolean Q0(DataCenter r2) {
        return this.a.Q0(r2);
    }

    public a(b r2, k r3, c r4) {
        Intrinsics.checkNotNullParameter(r2, "revVsService");
        Intrinsics.checkNotNullParameter(r3, "roomDataService");
        Intrinsics.checkNotNullParameter(r4, "revRoomService");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
