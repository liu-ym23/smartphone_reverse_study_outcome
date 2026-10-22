package com.larus.avlink;

import com.larus.audio.call.RealtimeCallParam;
import com.larus.audio.call.arch.LLMCallController;
import com.larus.audio.call.tracer.IRealtimeCallTracer;
import com.larus.avlink.model.DoraCallStateCode;
import com.larus.avlink.model.FlowDoraSceneState;
import com.larus.avlink.platform.AndroidPlatformKt;
import com.larus.avlink.plugins.DoraAppletPlugin;
import com.larus.avlink.plugins.DoraAudioFrameReceiver;
import com.larus.avlink.plugins.DoraCameraSoundPluginEvent;
import com.larus.avlink.plugins.DoraCustomSignalPlugin;
import com.larus.avlink.plugins.DoraETracePlugin;
import com.larus.avlink.plugins.DoraFirstPartyAuthPlugin;
import com.larus.avlink.plugins.DoraIMPlugin;
import com.larus.avlink.plugins.DoraIntentPlugin;
import com.larus.avlink.plugins.DoraIsolatedCallSessionMonitor;
import com.larus.avlink.plugins.DoraLightPlugin;
import com.larus.avlink.plugins.DoraLiteLiveActivityPlugin;
import com.larus.avlink.plugins.DoraLiveAILiveActivityPlugin;
import com.larus.avlink.plugins.DoraMediaFocusPlugin;
import com.larus.avlink.plugins.DoraNotificationSummaryPlugin;
import com.larus.avlink.plugins.DoraTaskPlugin;
import com.larus.avlink.plugins.DoraTimerPlugin;
import com.larus.avlink.plugins.a4;
import com.larus.avlink.plugins.b3;
import com.larus.avlink.plugins.c2;
import com.larus.avlink.plugins.d3;
import com.larus.avlink.plugins.d4;
import com.larus.avlink.plugins.f4;
import com.larus.avlink.plugins.g4;
import com.larus.avlink.plugins.h4;
import com.larus.avlink.plugins.l4;
import com.larus.avlink.plugins.n2;
import com.larus.avlink.plugins.n4;
import com.larus.avlink.plugins.o2;
import com.larus.avlink.plugins.p3;
import com.larus.avlink.plugins.r4;
import com.larus.avlink.plugins.s3;
import com.larus.avlink.plugins.t2;
import com.larus.avlink.plugins.u2;
import com.larus.avlink.plugins.x1;
import com.larus.avlink.plugins.y3;
import com.larus.avlink.simulInterpret.plugin.SimultaneousInterpretPlugin;
import com.larus.dora.api.IDoraService;
import com.larus.dora.api.LightEffectBrightness;
import com.larus.dora.api.LightEffectStatus;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.dora.impl.serviceimpl.SessionService;
import com.larus.settings.value.e10;
import com.larus.settings.value.vz;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.impl.util.RealtimeCallUtil;
import com.obric.assistant.spi.dora.IObricDoraService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CompletableDeferred;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class DoraCallLLMController extends o {
    public final String F;
    public final DoraRealtimeCallTracer G;
    public final Lazy H;
    public final Lazy I;

    @Override // com.larus.audio.call.arch.LLMCallController
    public final boolean P() {
        return false;
    }

    @Override // com.larus.avlink.o
    public final void Y() {
        l4 r0 = (l4) this.D.getValue();
        if (r0 == null) goto L5;
        r0.a();
    L5:
        l4 r1 = (l4) this.D.getValue();
        if (r1 == null) goto L8;
        r1.R0(null);
    L8:
        X().a();
        LLMCallController.w(this, Reflection.getOrCreateKotlinClass(com.larus.call_plugins_doubao_common.k.class)).m1(new z());
        l0.a.execute(new a0(this));
    }

    @Override // com.larus.avlink.o
    public final void Z() {
        if (v88.a.b(Integer.valueOf(this.v)) == false) goto L6;
        boolean r0 = com.larus.avlink.plugins.k0.i;
        com.larus.avlink.plugins.k0.i = false;
        return;
    }

    @Override // com.larus.avlink.o, com.larus.audio.call.arch.LLMCallController
    public final String A() {
        return this.F;
    }

    @Override // com.larus.audio.call.arch.LLMCallController
    public final IRealtimeCallTracer B() {
        return this.G;
    }

    @Override // com.larus.avlink.o
    public final CompletableDeferred V(int r5) {
        if (com.larus.avlink.plugins.k0.i == false) goto L5;
        n1.d(this.F, "callBeforeStop set inEnvObserveMode to false");
        com.larus.avlink.plugins.k0.i = false;
    L5:
        com.larus.avlink.rtc.e r0 = this.C;
        r0.getClass();
        Intrinsics.checkNotNullParameter("callBeforeStop", "caller");
        if (r0.a == false) goto L9;
        r0.a = false;
    L9:
        j0(2);
        return super.V(r5);
    }

    @Override // com.larus.avlink.o
    public final void e0(m r3) {
        Intrinsics.checkNotNullParameter(r3, "onStopCallback");
        LLMCallController.w(this, Reflection.getOrCreateKotlinClass(com.larus.call_plugins_doubao_common.k.class)).c1(true, r3);
    }

    @Override // com.larus.avlink.o
    public final void i0(Map r3) {
        Intrinsics.checkNotNullParameter("DoraRealtimeCallTaskNew", "tag");
        Intrinsics.checkNotNullParameter(r3, "payload");
        com.larus.call_plugins_doubao_common.i r0 = LLMCallController.y(this, Reflection.getOrCreateKotlinClass(com.larus.call_plugins_doubao_common.i.class));
        if (r0 == null) goto L6;
        r0.r1("DoraRealtimeCallTaskNew", r3);
        return;
    }

    public final void j0(@FlowDoraSceneState int r4) {
        if (r4 != 1) goto L5;
        boolean r0 = this.z.a(false, true);
    L9:
        if (r0 == false) goto L12;
        b98.b.f(0, r4);
        return;
    L12:
        return;
    L5:
        if (r4 == 2) goto L7;
        r0 = false;
        goto L9
    L7:
        r0 = this.z.a(true, false);
        goto L9
    }

    @Override // com.larus.avlink.o
    public final void b0(final String r4, final Function0 r5) {
        Intrinsics.checkNotNullParameter(r4, "name");
        Intrinsics.checkNotNullParameter(r5, "block");
        if (this.x.a(false, true) == false) goto L5;
        l0.a.execute(new y(r5, r4, this));
        return;
    L5:
        n1.d(this.F, "current stop operation running, skip " + r4 + " (serialized)");
    }

    @Override // com.larus.audio.call.arch.LLMCallController
    public final void p(com.larus.audio.call.arch.c r10, com.larus.audio.call.arch.k0 r11) {
        n4 r12 = (n4) r10;
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r11, "registry");
        if (c78.a.b == false) goto L5;
        r11.a(new com.larus.audio.call.plugins.c(r12));
    L5:
        r11.a(new com.larus.audio.call.mgr.d(r12));
        r11.a(new f4(r12));
        e10 r0 = e10.a;
        int r1 = com.larus.utils.l0.a;
        boolean r2 = ((Boolean) com.larus.utils.l0.a(Boolean.TRUE, new vz())).booleanValue();
        n1.d(this.F, "enableDoraIsolatedCallMonitor: " + r2);
        if (r2 == false) goto L8;
        n1.d(this.F, "register DoraIsolatedCallSessionMonitor");
        r11.a(new DoraIsolatedCallSessionMonitor(r12));
    L9:
        r11.a(new SimultaneousInterpretPlugin(r12));
        if (e10.m() == false) goto L12;
        r11.a(new aa8.a(r12));
    L12:
        r11.a(new com.larus.avlink.plugins.q(r12));
        r11.a(new com.larus.avlink.plugins.c1(r12));
        r11.a(new com.larus.avlink.plugins.r0(r12));
        r11.a(new DoraAppletPlugin(r12));
        boolean r3 = false;
        if (Intrinsics.areEqual(r12.params().k.o, "dora_si") == false) goto L25;
        IDoraService r4 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r4 == null) goto L21;
        DeviceService r5 = r4.device();
        if (r5 == null) goto L21;
        if (r5.b0() != true) goto L21;
        boolean r6 = true;
    L22:
        if (r6 == false) goto L25;
        r11.a(new com.larus.avlink.simulInterpret.plugin.b(r12, this.j));
    L37:
        r11.a(new com.larus.audio.call.plugins.h(r12, this.b.a(), this.i));
        r11.a(new com.larus.call_plugins_doubao_common.c(r12));
        r11.a(new y3(r12));
        r11.a(new DoraTaskPlugin(r12));
        r11.a(new o2(r12));
        IDoraService r7 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r7 == null) goto L42;
        com.larus.dora.impl.serviceimpl.a r8 = r7.X0();
        if (r8 == null) goto L42;
        r11.a(r8.a(r12));
    L42:
        r11.a(new DoraIMPlugin(r12));
        r11.a(new DoraNotificationSummaryPlugin(r12));
        r11.a(new DoraFirstPartyAuthPlugin(r12));
        r11.a(new a4(r12));
        r11.a(new DoraCustomSignalPlugin(r12));
        AndroidPlatformKt.a();
        r11.a(new d3(r12));
        r11.a(new DoraMediaFocusPlugin(r12));
        r11.a(new com.larus.avlink.plugins.b1(r12));
        IDoraService r9 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r9 == null) goto L49;
        DeviceService r13 = r9.device();
        if (r13 == null) goto L49;
        if (r13.f() != true) goto L49;
        boolean r14 = true;
    L50:
        if (r14 == true) goto L60;
        IDoraService r15 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r15 == null) goto L58;
        DeviceService r16 = r15.device();
        if (r16 == null) goto L58;
        if (r16.n0("vuiAbilityShift") != true) goto L58;
        boolean r17 = true;
    L59:
        if (r17 == true) goto L60;
    L90:
        if (d98.a.a == false) goto L92;
        r11.a(new com.larus.avlink.plugins.b0(r12));
    L92:
        r11.a(new t2(r12));
        IObricDoraService r19 = (IObricDoraService) ServiceManager.get().getService(IObricDoraService.class);
        if (r19 != null) goto L95;
    L97:
        boolean r20 = false;
    L99:
        if (r20 == false) goto L109;
        IObricDoraService r21 = (IObricDoraService) ServiceManager.get().getService(IObricDoraService.class);
        if (r21 == null) goto L103;
        Object r22 = r21.o(r12);
    L105:
        if ((r22 instanceof com.larus.audio.call.arch.a) == false) goto L107;
        r11.a((com.larus.audio.call.arch.a) r22);
        goto L109
    L107:
        if (r22 == null) goto L109;
        FLogger.a.w(this.F, "skip DoraObricPlugin register, invalid plugin type=".concat(r22.getClass().getName()));
        goto L109
    L103:
        r22 = null;
    L109:
        IDoraService r23 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r23 == null) goto L116;
        DeviceService r24 = r23.device();
        if (r24 == null) goto L116;
        if (r24.C() != true) goto L116;
        boolean r25 = true;
    L117:
        if (r25 == true) goto L119;
        AndroidPlatformKt.a();
    L130:
        IDoraService r26 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r26 == null) goto L137;
        DeviceService r27 = r26.device();
        if (r27 == null) goto L137;
        if (r27.p0(null) != true) goto L137;
        r3 = true;
    L137:
        if (r3 == false) goto L139;
        r11.a(new n2(r12));
        r11.a(new d4(r12));
    L140:
        r11.a(new DoraIntentPlugin(r12));
        return;
    L139:
        n1.d(this.F, "collectPlugins, isSupportConversation = false");
        goto L140
    L119:
        r11.a(new DoraETracePlugin(r12));
        r11.a(new h4(r12));
        r11.a(new c2(r12));
        if (v88.a.c(Integer.valueOf(this.v)) == false) goto L122;
        r11.a(new DoraLiveAILiveActivityPlugin(r12));
    L122:
        r11.a(new g4(r12));
        r11.a(new u2(r12));
        if (v88.a.b(Integer.valueOf(this.v)) == false) goto L125;
        r11.a(new com.larus.avlink.plugins.k0(r12));
    L125:
        r11.a(new DoraCameraSoundPluginEvent(r12));
        r11.a(new com.larus.avlink.plugins.d0(r12));
        r11.a(new DoraLightPlugin(r12));
        r11.a(new com.larus.avlink.plugins.z0(r12));
        IDoraService r29 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r29 == null) goto L130;
        com.larus.dora.impl.serviceimpl.s r30 = r29.R();
        if (r30 == null) goto L130;
        r11.a(r30.a(r12));
    L116:
        r25 = false;
        goto L117
    L95:
        if (r19.k() != true) goto L97;
        r20 = true;
    L58:
        r17 = false;
    L60:
        DoraTimerPlugin r31 = new DoraTimerPlugin(r12);
        com.larus.avlink.plugins.d r32 = new com.larus.avlink.plugins.d(r12);
        s3 r33 = new s3(r12);
        Intrinsics.checkNotNullParameter(r33, "plugin");
        com.larus.avlink.plugins.d r34 = b3.a;
        b3.a = r32;
        List r35 = r32.f;
        if ((r35 instanceof Collection) == true) goto L63;
    L65:
        Iterator r36 = ((ArrayList) r35).iterator();
    L67:
        if (r36.hasNext() == false) goto L74;
        if (((com.larus.audio.call.arch.a) r36.next()).getClass() != s3.class) goto L71;
        boolean r37 = true;
    L72:
        if (r37 == false) goto L67;
        boolean r38 = true;
    L76:
        if (r38 == false) goto L78;
        n1.d("DoraSessionKMPPlugin", "kmp plugin already registered: DoraTimeoutKMPPlugin");
    L79:
        r11.a(new p3(r12, r31, r32));
        IDoraService r39 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r39 == null) goto L86;
        DeviceService r40 = r39.device();
        if (r40 == null) goto L86;
        if (r40.b0() != true) goto L86;
        boolean r41 = true;
    L87:
        if (r41 == false) goto L90;
        r11.a(new x1(r12));
        r11.a(new DoraLiteLiveActivityPlugin(r12));
    L86:
        r41 = false;
        goto L87
    L78:
        r33.j3(r32.g);
        ((ArrayList) r32.f).add(r33);
        n1.d("DoraSessionKMPPlugin", "register kmp plugin: DoraTimeoutKMPPlugin");
        goto L79
    L71:
        r37 = false;
    L74:
        r38 = false;
        goto L76
    L63:
        if (((ArrayList) r35).isEmpty() == false) goto L65;
    L49:
        r14 = false;
    L21:
        r6 = false;
    L25:
        if (Intrinsics.areEqual(r12.params().k.o, "dora_si") == false) goto L36;
        IDoraService r42 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r42 == null) goto L33;
        DeviceService r43 = r42.device();
        if (r43 == null) goto L33;
        if (r43.M() != true) goto L33;
        boolean r44 = true;
    L34:
        if (r44 == false) goto L36;
        r11.a(new com.larus.avlink.plugins.a1(r12, this.j));
    L33:
        r44 = false;
    L36:
        r11.a(new DoraAudioFrameReceiver(r12, this.j, true));
        goto L37
    L8:
        n1.d(this.F, "register DoraCallSessionMonitor");
        r11.a(new com.larus.avlink.plugins.x(r12));
        goto L9
    }

    @Override // com.larus.avlink.o
    public final void f0(boolean r6, int r7, int r8) {
        r4 r0 = LLMCallController.y(this, Reflection.getOrCreateKotlinClass(r4.class));
        if (r0 == null) goto L5;
        r0.N2(LightEffectStatus.TURN_OFF, LightEffectBrightness.LOW, "stopVUI");
    L5:
        n1.d(this.F, "try stopVUI call: isSilent: " + r6 + ", scene: " + r7 + ", code: " + r8);
        if (v88.a.b(Integer.valueOf(this.v)) == false) goto L30;
        DoraCallStateCode.Companion.getClass();
        boolean r3 = true;
        if ((!CollectionsKt.listOf(new Integer[]{171, 129, 130}).contains(Integer.valueOf(r8))) == false) goto L30;
        if (r8 != 101) goto L19;
        IDoraService r1 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r1 != null) goto L14;
    L16:
        boolean r2 = false;
    L17:
        if (r2 == false) goto L19;
    L20:
        if (r3 == true) goto L30;
        if (r6 == false) goto L23;
        int r9 = 9;
    L24:
        IDoraService r10 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r10 == null) goto L29;
        SessionService r11 = r10.d();
        if (r11 == null) goto L29;
        r11.y(r9, r8, false);
    L29:
        g0(r8);
        return;
    L23:
        r9 = 8;
        goto L24
    L14:
        if (r1.d0() != 0) goto L16;
        r2 = true;
    L19:
        r3 = false;
    L30:
        super.f0(r6, r7, r8);
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [com.larus.avlink.c0, java.lang.Object] */
    public DoraCallLLMController(b78.c r2, com.larus.voicecall.impl.tracer.q r3, int r4, t r5) {
        Intrinsics.checkNotNullParameter(r2, "sessionCreator");
        Intrinsics.checkNotNullParameter(r3, "traceSpan");
        Intrinsics.checkNotNullParameter(r5, "lifecycleScope");
        super(r2, r3, r4, r5);
        this.F = "DoraCallLLMController_" + hashCode();
        int r6 = DoraRealtimeCallTracer.u;
        ?? r7 = new c0(this);
        Intrinsics.checkNotNullParameter(r7, "callParam");
        this.G = new DoraRealtimeCallTracer(r7);
        this.H = LazyKt.lazy(new d0());
        this.I = LazyKt.lazy(new e0(this));
    }

    @Override // com.larus.avlink.o
    public final void c0(final RealtimeCallParam r9, final int r10, final String r11, final String r12) {
        Intrinsics.checkNotNullParameter(r9, "callParam");
        Intrinsics.checkNotNullParameter(r11, "keyword");
        this.x.d(false);
        this.y.d(false);
        this.z.d(false);
        com.larus.avlink.rtc.e r0 = this.C;
        r0.a = false;
        com.larus.avlink.rtc.d.a.getClass();
        r0.a = Intrinsics.areEqual(com.larus.avlink.rtc.d.a(r12), Boolean.TRUE);
        r9.A = ((Boolean) this.I.getValue()).booleanValue();
        Intrinsics.checkNotNullParameter(r9, "<set-?>");
        this.f = r9;
        Intrinsics.checkNotNullParameter(r11, "<set-?>");
        r9.f = r11;
        RealtimeCallParam.k r1 = this.f.p;
        Lazy r2 = DoraWakeupSoundController.a;
        r1.R = DoraWakeupSoundController.f;
        RealtimeCallUtil r3 = RealtimeCallUtil.a;
        boolean r4 = ((Boolean) this.I.getValue()).booleanValue();
        r3.getClass();
        RealtimeCallUtil.r = r4;
        l0.a.execute(new b0(r10, r9, this, r11, r12));
    }
}
