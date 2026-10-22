package com.bytedance.android.livesdk.chatroom.vs_base.base.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.vs_base.base.setting.ReplayABSettingKeys;
import com.bytedance.android.livesdk.chatroom.vs_base.util.r;
import com.bytedance.android.livesdk.player.e0;
import com.bytedance.android.livesdkapi.replay.ReplayPlayerConfiger;
import com.bytedance.android.scope.m;
import com.ss.android.videoshop.context.VideoContext;
import com.ss.android.videoshop.mediaview.SimpleMediaView;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.TTVideoEngine;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mq1.q;
import pm1.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ReplayVideoPlayerView implements jm1.g {
    public SimpleMediaView a;
    public ReplayPlayerConfiger b;
    public String c;
    public String d;
    public List<? extends Resolution> e;
    public boolean f;
    public boolean g;
    public Function1<? super TTVideoEngine, Unit> h;

    public static final class a {
    }

    public static final class b implements nic.f {
        public final /* synthetic */ ReplayVideoPlayerView a;

        public b(ReplayVideoPlayerView r1) {
            this.a = r1;
        }

        public final TTVideoEngine b(Context r1, tic.a r2, nic.e r3) {
            TTVideoEngine r4 = new TTVideoEngine(r1, 0);
            r4.setIntOption(17, 1);
            r4.setIntOption(160, 1);
            r4.setIntOption(198, 1);
            r4.setIntOption(7, 1);
            r4.setIntOption(5, 3);
            this.a.getClass();
            r4.setVideoEngineInfoListener(null);
            this.a.h.invoke(r4);
            return r4;
        }
    }

    static {
    }

    public final boolean isPlaying() {
        SimpleMediaView r0 = this.a;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.h() != true) goto L7;
        return true;
    }

    public final void pause() {
        SimpleMediaView r0 = this.a;
        if (r0 == null) goto L6;
        r0.j();
        return;
    }

    public final void release() {
        SimpleMediaView r0 = this.a;
        if (r0 == null) goto L5;
        r0.setAsyncRelease(true);
    L5:
        SimpleMediaView r1 = this.a;
        if (r1 == null) goto L8;
        r1.m();
    L8:
        SimpleMediaView r2 = this.a;
        if (r2 == null) goto L11;
        ViewParent r3 = r2.getParent();
    L13:
        if ((r3 instanceof ViewGroup) == true) goto L15;
        r3 = null;
    L15:
        ViewGroup r4 = (ViewGroup) r3;
        if (r4 == null) goto L18;
        r4.removeView(this.a);
    L18:
        this.a = null;
        return;
    L11:
        r3 = null;
        goto L13
    }

    public final void resume() {
        SimpleMediaView r0 = this.a;
        if (r0 == null) goto L6;
        r0.k();
        return;
    }

    public ReplayVideoPlayerView() {
        this.c = "vs_long_video";
        this.d = "vs_video_unknown";
        this.h = ReplayVideoPlayerView$videoEngineInit$1.INSTANCE;
    }

    public final void play(String r7, FrameLayout r8, long r9, tic.a r11) {
        Intrinsics.checkNotNullParameter(r7, "videoInfo");
        Intrinsics.checkNotNullParameter(r8, "container");
        boolean r1 = true;
        if (this.a != null) goto L36;
        this.a = new SimpleMediaView(r8.getContext());
        int r0 = e0.a;
        VideoContext r2 = VideoContext.n0(r8.getContext());
        if (r2 == null) goto L7;
        r2.a.s = false;
    L7:
        ReplayPlayerConfiger r3 = this.b;
        if (r3 == null) goto L10;
        Integer r4 = Integer.valueOf(r3.useSurfaceView);
    L11:
        if (r4 != null) goto L14;
    L21:
        if (r4 != null) goto L24;
    L28:
        if (r4 == null) goto L36;
        if (r4.intValue() != 2) goto L36;
        SimpleMediaView r5 = this.a;
        if (r5 == null) goto L36;
        r5.setUseSurfaceView(false);
        goto L36
    L24:
        if (r4.intValue() != 1) goto L28;
        SimpleMediaView r6 = this.a;
        if (r6 == null) goto L36;
        r6.setUseSurfaceView(true);
        goto L36
    L14:
        if (r4.intValue() != 0) goto L21;
        SimpleMediaView r10 = this.a;
        if (r10 == null) goto L36;
        r10.setUseSurfaceView(((Boolean) ReplayABSettingKeys.LIVE_REPLAY_PLAYER_USE_SURFACEVIEW.getValue()).booleanValue());     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        ALogger.e("ReplayVideoPlayerView", "setUseSurfaceViewFor", th);
        goto L36
    L10:
        r4 = null;
    L36:
        if (r8.indexOfChild(this.a) >= 0) goto L49;
        SimpleMediaView r12 = this.a;
        if (r12 == null) goto L45;
        r12.setVisibility(8);
        ViewParent r13 = r12.getParent();
        if ((r13 instanceof ViewGroup) == true) goto L42;
        r13 = null;
    L42:
        ViewGroup r14 = (ViewGroup) r13;
        if (r14 == null) goto L45;
        r14.removeView(this.a);
    L45:
        SimpleMediaView r15 = this.a;
        if (r15 == null) goto L48;
        r15.setVisibility(0);
    L48:
        r8.addView(this.a, 0);
    L49:
        if (r11 == null) goto L53;
        SimpleMediaView r16 = this.a;
        if (r16 == null) goto L68;
        r16.setPlayEntity(r11);
    L68:
        SimpleMediaView r17 = this.a;
        if (r17 == null) goto L72;
        r17.setVideoEngineFactory(new b(this));
    L72:
        if (this.b != null) goto L75;
        this.b = new ReplayPlayerConfiger();
    L75:
        if (this.e != null) goto L81;
        q r18 = (q) m.e.d(h.d.b(), q.class);
        if (r18 == null) goto L81;
        List<Resolution> r19 = r18.a(r7);
        if (r19 == null) goto L81;
        this.e = r19;
    L81:
        ReplayPlayerConfiger r20 = this.b;
        if (r20 == null) goto L84;
        Resolution r21 = r20.targetResolution;
    L85:
        if (r21 != null) goto L93;
        q r22 = (q) m.e.d(h.d.b(), q.class);
        if (r22 == null) goto L93;
        Resolution r23 = r22.c(r7);
        if (r23 == null) goto L93;
        ReplayPlayerConfiger r24 = this.b;
        if (r24 == null) goto L93;
        r24.targetResolution = r23;
    L93:
        SimpleMediaView r25 = this.a;
        if (r25 == null) goto L96;
        r25.setVideoPlayConfiger(this.b);
    L96:
        SimpleMediaView r26 = this.a;
        if (r26 == null) goto L99;
        r26.setReleaseEngineEnabled(true);
    L99:
        SimpleMediaView r27 = this.a;
        if (r27 == null) goto L102;
        r27.setPlayUrlConstructor(new sic.a());
    L102:
        SimpleMediaView r28 = this.a;
        if (r28 == null) goto L105;
        r28.setAttachListener(null);
    L105:
        SimpleMediaView r29 = this.a;
        if (r29 == null) goto L108;
        r29.setMute(this.g);
    L108:
        SimpleMediaView r30 = this.a;
        if (r30 == null) goto L111;
        r30.setLoop(this.f);
    L111:
        SimpleMediaView r31 = this.a;
        if (r31 == null) goto L114;
        r31.k();
    L114:
        SimpleMediaView r32 = this.a;
        if (r32 == null) goto L123;
        ReplayPlayerConfiger r33 = this.b;
        if (r33 == null) goto L119;
        r1 = r33.isZoomingEnable;
    L119:
        r32.setZoomingEnabled(r1);
        return;
    L123:
        return;
    L84:
        r21 = null;
        goto L85
    L53:
        tic.a r34 = new tic.a();
        if (TextUtils.isEmpty(null) == false) goto L56;
    L58:
        int r110 = r.a;
        r34.d = r.e(r7);
    L59:
        ejc.b r111 = ejc.b.a();
        if (r9 <= 0) goto L62;
        r111.b = false;
        r34.c = r9;
    L62:
        ReplayPlayerConfiger r35 = this.b;
        if (r35 == null) goto L65;
        r111.g = r35.textureLayout;
    L65:
        r34.o = r111;
        r34.k = this.c;
        r34.l = this.d;
        SimpleMediaView r36 = this.a;
        if (r36 == null) goto L68;
        r36.setPlayEntity(r34);
        goto L68
    L56:
        if (TextUtils.equals(null, r7) == false) goto L58;
        r34.d = null;
        goto L59
    }
}
