package com.obric.audio.continuous_talk.session.impl;

import com.larus.call_plugins_doubao_common.manager.n0;
import com.larus.media.MediaLevel;
import com.larus.media.MediaResourceManager;
import com.larus.media.m0;
import com.larus.media.model.SceneConfig;
import com.larus.media.v;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.common.spi.audio.ObricAudioServiceDelegate;
import com.obric.assistant.spi.audio.ObricTtsControlDelegate;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class m extends n0 {
    public final i A;
    public final Function1<Boolean, Unit> u;
    public final Function0<Unit> v;
    public final Function0<Unit> w;
    public volatile boolean x;
    public volatile boolean y;
    public final com.larus.media.model.a z;

    public final String h() {
        return "ObricContTalkMediaManager";
    }

    public final boolean e() {
        SceneConfig.SceneConfigBean.ConfigBean.MediaActionBean r0 = m0.b("CALL_TTS_PLAY", 2);
        if (r0 == null) goto L5;
        boolean r1 = r0.getMixWithOthers();
    L6:
        FLogger.a.i("ObricContTalkMediaManager", "getPlayDuckApplicantMixResult: O-side override, sceneMix=" + r1);
        return r1;
    L5:
        r1 = false;
        goto L6
    }

    public final boolean f() {
        SceneConfig.SceneConfigBean.ConfigBean.MediaActionBean r0 = m0.b("CALL_TTS_PLAY", 2);
        if (r0 == null) goto L5;
        boolean r1 = r0.getMixWithOthers();
    L6:
        FLogger.a.i("ObricContTalkMediaManager", "getPlayGainApplicantMixResult: O-side override, sceneMix=" + r1);
        return r1;
    L5:
        r1 = false;
        goto L6
    }

    public final void k() {
        FLogger.a.i("ObricContTalkMediaManager", "onReleaseRecord: currentPlayApplicant: " + c());
        Lazy r0 = MediaResourceManager.a;
        MediaResourceManager.c(((n0) this).o);
        MediaResourceManager.a(this.z);
    }

    public final v d() {
        return this.A;
    }

    public final com.larus.media.model.a g() {
        return this.z;
    }

    public static boolean n(lk9.g r1) {
        Intrinsics.checkNotNullParameter(r1, "applicant");
        if (Intrinsics.areEqual(r1.getScene(), "SYSTEM") == true) goto L5;
    L7:
        return false;
    L5:
        if (ObricAudioServiceDelegate.a.d() == true) goto L7;
        return true;
    }

    public final void j(float r4) {
        FLogger.a.i("ObricContTalkMediaManager", "onMediaFocusVolumeChanged, volumeFactor=" + r4);
        ((n0) this).d.invoke(Float.valueOf(r4));
    }

    public final void a(int r4, String r5) {
        FLogger.a.i("ObricContTalkMediaManager", "dealWithMediaRequestOnStateChange, state: " + r4 + ", callId: " + r5);
        super.a(r4, r5);
        if (r4 != (-1)) goto L6;
        Lazy r6 = MediaResourceManager.a;
        MediaResourceManager.a(c());
        ObricTtsControlDelegate.b.t();
        return;
    }

    public m(com.obric.audio.continuous_talk.session.impl.plugin.j r28, com.obric.audio.continuous_talk.session.impl.plugin.k r29, com.obric.audio.continuous_talk.session.impl.plugin.l r30, com.obric.audio.continuous_talk.session.impl.plugin.m r31, com.obric.audio.continuous_talk.session.impl.plugin.n r32, com.obric.audio.continuous_talk.session.impl.plugin.o r33, com.obric.audio.continuous_talk.session.impl.plugin.p r34, final zb8.c r35, boolean r36) {
        com.bytedance.applet.aibridge.p r6 = new com.bytedance.applet.aibridge.p();
        Intrinsics.checkNotNullParameter(r28, "onInterrupt");
        Intrinsics.checkNotNullParameter(r29, "onFinish");
        Intrinsics.checkNotNullParameter(r30, "onPause");
        Intrinsics.checkNotNullParameter(r31, "onResume");
        Intrinsics.checkNotNullParameter(r32, "onMediaVolumeChange");
        Intrinsics.checkNotNullParameter(r33, "onTtsPause");
        Intrinsics.checkNotNullParameter(r34, "onTtsResume");
        Intrinsics.checkNotNullParameter(r35, "shouldPauseWhenOtherStart");
        Intrinsics.checkNotNullParameter(r6, "shouldPauseOtherWhenRecording");
        super(r29, r30, r31, r32, r35, r6, null, null, false, r36, 448);
        this.u = r28;
        this.v = r33;
        this.w = r34;
        if (r36 == false) goto L5;
        String r0 = "O_CALL";
    L6:
        String r15 = r0;
        int r23 = MediaLevel.PLAY_HIGH.getValue();
        boolean r17 = z2.a.realtimeSceneMixEnable();
        l r1 = new l(this, r35, r31);
        com.larus.media.model.a r2 = new com.larus.media.model.a(null, r15, false, r17 ? 1 : 0, 2, false, 0, false, false, r23, false, r1, 1509);
        Function0 r3 = new c(r35);
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r2.q = r3;
        this.z = r2;
        this.A = new i(this, r32);
        return;
    L5:
        r0 = "CALL";
        goto L6
    }
}
