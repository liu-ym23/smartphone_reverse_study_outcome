package com.larus.voicecall.impl;

import com.larus.audio.call.RealtimeCallParam;
import com.larus.audio.call.arch.LLMCallController;
import com.larus.audio.call.arch.k0;
import com.larus.audio.call.plugins.CommonVideoAutoTestPlugin;
import com.larus.audio.call.plugins.RealtimeCallConnectTimeoutPlugin;
import com.larus.audio.call.plugins.RealtimeCallSubtitlePlugin;
import com.larus.audio.call.plugins.a1;
import com.larus.audio.call.plugins.e;
import com.larus.audio.call.plugins.k1;
import com.larus.audio.call.tracer.IRealtimeCallTracer;
import com.larus.call_plugins_doubao_common.CommonAppletPlugin;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.impl.plugins.RealtimeCallAudioPlugin;
import com.larus.voicecall.impl.plugins.RealtimeCallScenePlugin;
import com.larus.voicecall.impl.plugins.RealtimeMediaFocusPlugin;
import com.larus.voicecall.impl.plugins.RealtimeSwitchMicroPlugin;
import com.larus.voicecall.impl.plugins.TtsPlaybackReportPlugin;
import com.larus.voicecall.impl.plugins.b1;
import com.larus.voicecall.impl.plugins.c1;
import com.larus.voicecall.impl.plugins.e2;
import com.larus.voicecall.impl.plugins.f1;
import com.larus.voicecall.impl.plugins.g1;
import com.larus.voicecall.impl.plugins.h1;
import com.larus.voicecall.impl.plugins.j1;
import com.larus.voicecall.impl.plugins.j2;
import com.larus.voicecall.impl.plugins.l1;
import com.larus.voicecall.impl.plugins.r;
import com.larus.voicecall.impl.plugins.y0;
import com.larus.voicecall.impl.tracer.CommonCallSessionMonitor;
import com.larus.voicecall.impl.tracer.RealtimeCallTracer;
import com.larus.voicecall.impl.util.RealtimeCallUtil;
import com.lynx.jsbridge.LynxResourceModule;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.Deferred;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class x extends LLMCallController<r> {
    public final v A;
    public final boolean v;
    public final boolean w;
    public final String x;
    public final RealtimeCallTracer y;
    public q z;

    public final class a extends LLMCallController<r>.a implements r {
        public final /* synthetic */ x b;

        @Override // com.larus.voicecall.impl.plugins.r
        public final q h() {
            return this.b.z;
        }

        public a(x r1) {
            this.b = r1;
            super(r1);
        }
    }

    public final com.larus.audio.call.arch.c K() {
        return new a(this);
    }

    public final Deferred<LLMCallController.b> L() {
        Deferred<LLMCallController.b> r0 = super.L();
        r0.invokeOnCompletion(new w(this));
        return r0;
    }

    public final String A() {
        return this.x;
    }

    public final IRealtimeCallTracer B() {
        return this.y;
    }

    public final CompletableDeferred R(RealtimeCallParam r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.PARAMS_KEY);
        CompletableDeferred r7 = super.R(r5, r6);
        a1 r8 = x().getContext().c(Reflection.getOrCreateKotlinClass(a1.class), null);
        if (r8 == null) goto L5;
        r8.H0(this.A);
    L5:
        FLogger r0 = FLogger.a;
        String r1 = this.x;
        StringBuilder r2 = new StringBuilder("on start .find plugin=");
        if (r8 == null) goto L8;
        boolean r9 = true;
    L9:
        r2.append(r9);
        r0.i(r1, r2.toString());
        return r7;
    L8:
        r9 = false;
        goto L9
    }

    public final void p(com.larus.audio.call.arch.c r5, k0 r6) {
        r r7 = (r) r5;
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r6, "registry");
        if (c78.a.a == false) goto L5;
        r6.a(new com.larus.audio.call.plugins.c(r7));
        r6.a(new CommonVideoAutoTestPlugin(r7));
    L5:
        RealtimeCallUtil.a.getClass();
        if (RealtimeCallUtil.F == false) goto L8;
        r6.a(new h1(r7));
    L8:
        r6.a(new com.larus.audio.call.mgr.d(r7));
        r6.a(new RealtimeCallAudioPlugin(r7, ((LLMCallController) this).b.async(), ((LLMCallController) this).b.async()));
        r6.a(new l1(r7));
        r6.a(new CommonCallSessionMonitor(r7));
        r6.a(new c1(r7));
        r6.a(new f1(r7));
        r6.a(new RealtimeCallScenePlugin(r7));
        r6.a(new RealtimeCallSubtitlePlugin(r7));
        r6.a(new com.larus.audio.call.plugins.f1(r7));
        r6.a(new j2(r7));
        z2 r0 = z2.a;
        if (r0.enableMuseumExtensionPack() == false) goto L11;
        r6.a(new e2(r7));
    L11:
        r6.a(new TtsPlaybackReportPlugin(r7));
        r6.a(new k1(r7));
        r6.a(new b1(r7));
        r6.a(new RealtimeSwitchMicroPlugin(r7));
        r6.a(new CommonAppletPlugin(r7));
        r6.a(new e(r7, ((LLMCallController) this).j));
        r6.a(new com.larus.audio.call.plugins.h(r7, ((LLMCallController) this).b.a(), ((LLMCallController) this).i));
        r6.a(new com.larus.call_plugins_doubao_common.c(r7));
        r6.a(new g1(r7));
        r6.a(new j1(r7));
        r6.a(new RealtimeMediaFocusPlugin(r7, this.v));
        r6.a(new RealtimeCallConnectTimeoutPlugin(r7, r0.L3()));
        if (r0.enableRealtimeCallDowngrade() == true) goto L14;
        return;
    L14:
        if (this.w == true) goto L18;
        r6.a(new y0(r7));
        return;
    }

    /* JADX WARN: Type inference failed for: r2v6, types: [com.larus.voicecall.impl.v] */
    public x(b78.c r2, com.larus.voicecall.impl.tracer.q r3, Function0 r4, boolean r5, boolean r6, y r7) {
        Intrinsics.checkNotNullParameter(r2, "sessionCreator");
        Intrinsics.checkNotNullParameter(r3, "traceSpan");
        Intrinsics.checkNotNullParameter(r4, "lifecycleScope");
        super(r2, r3, r4);
        this.v = r5;
        this.w = r6;
        this.x = "RealtimeCallLLMController";
        int r8 = RealtimeCallTracer.s0;
        Function0 r9 = new u(this);
        Intrinsics.checkNotNullParameter(r9, "callParam");
        this.y = new RealtimeCallTracer(r9);
        r7.invoke(x().getContext(), x());
        this.A = new v(this);
    }
}
