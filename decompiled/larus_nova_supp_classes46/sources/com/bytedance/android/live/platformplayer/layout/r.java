package com.bytedance.android.live.platformplayer.layout;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.roomplayer.AbsLivePlayerView;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerScene;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerConfig;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerView;
import com.bytedance.android.livesdkapi.view.IRenderView;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class r implements Function0<Pair<? extends Boolean, ? extends String>> {
    public final /* synthetic */ LivePlayerWidget a;

    public final Object invoke() {
        ALogger.e("LivePlayer", "内流onMixedAudioDetected " + ((com.bytedance.android.live.platformplayer.b) this.a.ar().invoke()).isUserVisible());
        LivePlayerWidget r0 = this.a;
        if (r0.c == null) goto L43;
        IRenderView r1 = r0.R8().getRenderView();
        ILivePlayerClient r2 = this.a.dr();
        ILivePlayerScene r4 = null;
        if (r2 == null) goto L8;
        IRenderView r3 = r2.getRenderView();
    L9:
        boolean r5 = Intrinsics.areEqual(r1, r3);
        ILivePlayerClient r6 = this.a.dr();
        boolean r7 = false;
        if (r6 != null) goto L12;
    L14:
        boolean r8 = false;
    L15:
        ILivePlayerClient r9 = this.a.dr();
        if (r9 != null) goto L18;
    L20:
        boolean r10 = false;
    L22:
        if (((com.bytedance.android.live.platformplayer.b) this.a.ar().invoke()).b() == true) goto L24;
    L26:
        if (r5 == false) goto L42;
        if (this.a.yr() == false) goto L42;
        if (r10 == false) goto L42;
        if (r8 == false) goto L42;
        if (r7 == true) goto L42;
        ALogger.e("LivePlayer", "内流业务侧串音");
        Boolean r11 = Boolean.TRUE;
        StringBuilder r12 = new StringBuilder("scene:");
        AbsLivePlayerView r13 = this.a.R8();
        if ((r13 instanceof LivePlayerView) == true) goto L35;
        r13 = null;
    L35:
        LivePlayerView r14 = (LivePlayerView) r13;
        if (r14 == null) goto L40;
        LivePlayerConfig r15 = r14.getConfig();
        if (r15 == null) goto L40;
        r4 = r15.getScene();
    L40:
        r12.append(r4);
        r12.append(",isResumed:");
        r12.append(((com.bytedance.android.live.platformplayer.b) this.a.ar().invoke()).b());
        r12.append(",isUserVisible:");
        r12.append(((com.bytedance.android.live.platformplayer.b) this.a.ar().invoke()).isUserVisible());
        return new Pair(r11, r12.toString());
    L42:
        return new Pair(Boolean.FALSE, "");
    L24:
        if (((com.bytedance.android.live.platformplayer.b) this.a.ar().invoke()).isUserVisible() == false) goto L26;
        r7 = true;
        goto L26
    L18:
        if (r9.isPlaying() != true) goto L20;
        r10 = true;
        goto L22
    L12:
        if (r6.isMute() == true) goto L14;
        r8 = true;
        goto L15
    L8:
        r3 = null;
        goto L9
    L43:
        return new Pair(Boolean.FALSE, "");
    }

    public r(LivePlayerWidget r1) {
        this.a = r1;
    }
}
