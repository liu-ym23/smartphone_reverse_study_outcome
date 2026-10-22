package com.larus.call_plugins_doubao_common.manager;

import android.os.Handler;
import android.os.Looper;
import com.larus.media.MediaLevel;
import com.larus.media.MediaResourceManager;
import com.larus.media.model.SceneConfig;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.impl.plugins.y1;
import com.larus.voicecall.impl.plugins.z1;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public class n0 {
    public final Function0<Unit> a;
    public final Function0<Unit> b;
    public final Function0<Unit> c;
    public final Function1<Float, Unit> d;
    public final Function0<Boolean> e;
    public final Function0<Boolean> f;
    public final Function0<Boolean> g;
    public final Function0<Boolean> h;
    public final boolean i;
    public final String j;
    public boolean k;
    public boolean l;
    public final Handler m;
    public final Lazy n;
    public final com.larus.media.model.a o;
    public final com.larus.media.model.a p;
    public final g0 q;
    public final Lazy r;
    public final Lazy s;
    public com.larus.media.model.a t;

    public void j(float r1) {
    }

    public void m() {
    }

    public final com.larus.media.model.a c() {
        com.larus.media.model.a r0 = this.t;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return (com.larus.media.model.a) this.r.getValue();
    }

    public boolean f() {
        lq9.k r0 = z2.a.continueTalkV2Config();
        boolean r2 = false;
        if (r0.a() == false) goto L6;
        FLogger.a.i(h(), "getPlayGainApplicantMixResult: enableContinueTalkV2=true, return false. config=" + r0);
        return false;
    L6:
        boolean r1 = com.larus.media.o.a();
        SceneConfig.SceneConfigBean.ConfigBean.MediaActionBean r3 = com.larus.media.m0.b("CALL_TTS_PLAY", 2);
        if (r3 == null) goto L9;
        boolean r4 = r3.getMixWithOthers();
    L10:
        if (r1 == false) goto L13;
        if (r4 == false) goto L13;
        r2 = true;
    L13:
        FLogger.a.i(h(), "getPlayGainApplicantMixResult: enableV2=false, mediaEnabled=" + r1 + ", sceneMix=" + r4 + ", result=" + r2);
        return r2;
    L9:
        r4 = false;
        goto L10
    }

    public void k() {
        FLogger.a.i(h(), "onRelease: currentPlayApplicant: " + c());
        Lazy r0 = MediaResourceManager.a;
        MediaResourceManager.c(this.o);
        MediaResourceManager.a(g());
        MediaResourceManager.a(c());
    }

    public final void l() {
        FLogger.a.i(h(), "releaseMediaFocusSync: currentPlayApplicant: " + c());
        Lazy r0 = MediaResourceManager.a;
        MediaResourceManager.c(this.o);
        MediaResourceManager.a(g());
        MediaResourceManager.a(c());
    }

    public boolean e() {
        boolean r0 = com.larus.media.o.a();
        SceneConfig.SceneConfigBean.ConfigBean.MediaActionBean r1 = com.larus.media.m0.b("CALL_TTS_PLAY", 2);
        boolean r2 = false;
        if (r1 == null) goto L5;
        boolean r3 = r1.getMixWithOthers();
    L6:
        if (r0 == false) goto L9;
        if (r3 == false) goto L9;
        r2 = true;
    L9:
        FLogger.a.i(h(), "getPlayDuckApplicantMixResult: mediaEnabled=" + r0 + ", sceneMix=" + r3 + ", result=" + r2);
        return r2;
    L5:
        r3 = false;
        goto L6
    }

    public com.larus.media.v d() {
        return this.q;
    }

    public com.larus.media.model.a g() {
        return this.p;
    }

    public String h() {
        return this.j;
    }

    public static /* synthetic */ void b(r r2) {
        r2.a(-1, "");
    }

    public final boolean i(int r2) {
        if (((Boolean) this.n.getValue()).booleanValue() == true) goto L5;
    L9:
        return false;
    L5:
        if (this.i == false) goto L9;
        if (r2 != (-3)) goto L9;
        return true;
    }

    public void a(int r11, String r12) {
        if (r11 != 2) goto L5;
    L57:
        Lazy r0 = MediaResourceManager.a;
        com.larus.media.model.a r1 = this.o;
        Function1 r2 = new s();
        Function1 r3 = new v(this);
        Intrinsics.checkNotNullParameter(r1, "applicant");
        ((com.larus.media.j0) MediaResourceManager.a.getValue()).b(r1, r3, r2);
        FLogger.a.i(h(), "dealWithMediaRequestOnStateChange: state: " + r11 + ", callId: " + r12 + ", currentPlayApplicant: " + c());
        if (((Boolean) this.f.invoke()).booleanValue() == false) goto L60;
    L63:
        MediaResourceManager.j(g(), c(), new w(), new x());
        return;
    L60:
        if (((Boolean) this.g.invoke()).booleanValue() == true) goto L63;
        MediaResourceManager.a(c());
        return;
    L5:
        if (r11 == 3) goto L57;
        boolean r4 = false;
        if (r11 != 4) goto L9;
        boolean r13 = z2.a.realtimeSceneMixEnable();
        FLogger r5 = FLogger.a;
        r5.i(h(), "dealWithMediaRequestOnStateChange: state: THINKING, callId: " + r12 + ", before assignment currentPlayApplicant: " + c() + " sceneMixable=" + r13);
        if (((Boolean) this.h.invoke()).booleanValue() == true) goto L51;
        IFlowSdkDepend r6 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r6 == null) goto L46;
        r6.K0();
        if (com.larus.music.i.a.h() != true) goto L46;
        r4 = true;
    L46:
        if (r4 == true) goto L51;
        if (((Boolean) this.e.invoke()).booleanValue() == false) goto L51;
        com.larus.media.model.a r7 = (com.larus.media.model.a) this.r.getValue();
    L53:
        if (Intrinsics.areEqual(r7.b, c().b) == false) goto L56;
        if (r13 == false) goto L56;
        Lazy r8 = MediaResourceManager.a;
        MediaResourceManager.a(c());
    L56:
        Intrinsics.checkNotNullParameter(r7, "value");
        this.t = r7;
        r5.i(h(), "dealWithMediaRequestOnStateChange: state: THINKING, callId: " + r12 + ", after assignment currentPlayApplicant: " + c() + " sceneMixable=" + r13);
        Lazy r14 = MediaResourceManager.a;
        MediaResourceManager.j(c(), g(), new y(this), new z(this));
        return;
    L51:
        r7 = (com.larus.media.model.a) this.s.getValue();
        goto L53
    L9:
        if (r11 == 5) goto L20;
        if (r11 != 7) goto L13;
        FLogger.a.i(h(), "dealWithMediaRequestOnStateChange: state: PAUSED, callId: " + r12 + ", currentPlayApplicant: " + c() + ", hasPausedPlay: " + this.l);
        Lazy r15 = MediaResourceManager.a;
        MediaResourceManager.c(this.o);
        MediaResourceManager.a(g());
        MediaResourceManager.a(c());
        return;
    L13:
        if (r11 == 17) goto L16;
        return;
    L16:
        if (com.larus.audio.call.f.f() == false) goto L65;
        FLogger.a.i(h(), "dealWithMediaRequestOnStateChange: LISTEN_AND_SPEAK -> handle as SPEAKING");
        a(5, r12);
        return;
    L65:
        return;
    L20:
        if (com.larus.media.o.a() == false) goto L68;
        boolean r16 = z2.a.realtimeSceneMixEnable();
        Lazy r9 = MediaResourceManager.a;
        MediaResourceManager.c(this.o);
        FLogger r10 = FLogger.a;
        r10.i(h(), "dealWithMediaRequestOnStateChange: state: SPEAKING, callId: " + r12 + ", before assignment currentPlayApplicant: " + c() + " sceneMixable=" + r16);
        if (((Boolean) this.h.invoke()).booleanValue() == true) goto L33;
        IFlowSdkDepend r17 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r17 == null) goto L28;
        r17.K0();
        if (com.larus.music.i.a.h() != true) goto L28;
        r4 = true;
    L28:
        if (r4 == true) goto L33;
        if (((Boolean) this.e.invoke()).booleanValue() == false) goto L33;
        com.larus.media.model.a r18 = (com.larus.media.model.a) this.r.getValue();
    L35:
        if (Intrinsics.areEqual(r18.b, c().b) == false) goto L38;
        if (r16 == false) goto L38;
        MediaResourceManager.a(c());
    L38:
        Intrinsics.checkNotNullParameter(r18, "value");
        this.t = r18;
        r10.i(h(), "dealWithMediaRequestOnStateChange: state: SPEAKING, callId: " + r12 + ", after assignment currentPlayApplicant: " + c() + " sceneMixable=" + r16);
        MediaResourceManager.j(c(), g(), new a0(this), new b0(this));
        return;
    L33:
        r18 = (com.larus.media.model.a) this.s.getValue();
        goto L35
    }

    public n0(Function0 r41, Function0 r42, Function0 r43, Function1 r44, Function0 r45, Function0 r46, y1 r47, z1 r48, boolean r49, boolean r50, int r51) {
        if ((r51 & 16) == 0) goto L5;
        Function0 r6 = new com.bytedance.applet.aibridge.p();
    L7:
        if ((r51 & 32) == 0) goto L9;
        Function0 r7 = new com.bytedance.applet.aibridge.p();
    L11:
        if ((r51 & 64) == 0) goto L13;
        y1 r8 = new zb8.c();
    L15:
        if ((r51 & 128) == 0) goto L17;
        z1 r9 = new zb8.c();
    L19:
        if ((r51 & 512) == 0) goto L21;
        boolean r10 = false;
    L23:
        if ((r51 & 1024) == 0) goto L25;
        boolean r5 = false;
    L26:
        Intrinsics.checkNotNullParameter(r41, "onFinish");
        Intrinsics.checkNotNullParameter(r42, "onPause");
        Intrinsics.checkNotNullParameter(r43, "onResume");
        Intrinsics.checkNotNullParameter(r44, "onMediaVolumeChange");
        Intrinsics.checkNotNullParameter(r6, "shouldPauseWhenOtherStart");
        Intrinsics.checkNotNullParameter(r7, "shouldPauseOtherWhenRecording");
        Intrinsics.checkNotNullParameter(r8, "shouldDuckOtherWhenRecording");
        Intrinsics.checkNotNullParameter(r9, "shouldDuckOtherWhenPlaying");
        this.a = r41;
        this.b = r42;
        this.c = r43;
        this.d = r44;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = "RealtimeCallMediaManager";
        this.m = new Handler(Looper.getMainLooper());
        this.n = LazyKt.lazy(new c0(this));
        if (r5 == false) goto L29;
        String r14 = "O_CALL";
    L30:
        this.o = new com.larus.media.model.a(null, r14, false, 0, 1, false, 0, false, false, 0, false, new j0(this), 2029);
        if (r5 == false) goto L33;
        String r28 = "O_CALL";
    L34:
        int r36 = MediaLevel.PLAY_HIGH.getValue();
        if (((Boolean) r8.invoke()).booleanValue() == false) goto L37;
    L40:
        int r30 = 1;
    L41:
        com.larus.media.model.a r2 = new com.larus.media.model.a(null, r28, false, r30, 2, false, 0, false, false, r36, false, new m0(this), 1509);
        Function0 r1 = new d0(this);
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        r2.q = r1;
        this.p = r2;
        this.q = new g0(this);
        this.r = LazyKt.lazy(new t(this));
        this.s = LazyKt.lazy(new u(this));
        return;
    L37:
        if (z2.a.realtimeSceneMixEnable() == true) goto L40;
        r30 = 0;
        goto L41
    L33:
        r28 = "CALL";
        goto L34
    L29:
        r14 = "CALL";
        goto L30
    L25:
        r5 = r50;
        goto L26
    L21:
        r10 = r49;
        goto L23
    L17:
        r9 = r48;
        goto L19
    L13:
        r8 = r47;
        goto L15
    L9:
        r7 = r46;
        goto L11
    L5:
        r6 = r45;
        goto L7
    }
}
