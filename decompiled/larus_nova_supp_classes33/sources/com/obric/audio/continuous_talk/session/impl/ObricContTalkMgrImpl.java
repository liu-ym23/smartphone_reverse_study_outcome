package com.obric.audio.continuous_talk.session.impl;

import android.media.AudioManager;
import com.larus.audio.call.RealtimeCallParam;
import com.larus.audio.call.arch.LLMCallController;
import com.larus.audio.call.mgr.AVKitDuplexState;
import com.larus.audio.call.plugins.t0;
import com.larus.audio.call.tracer.IRealtimeCallTracer;
import com.larus.audio.call.utils.AvBizType;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.im.service.audio.cmd.TriggerMode;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.audio.sessionstate.AutoHalfDuplexModeServiceDelegate;
import com.obric.assistant.state.api.v2.core.IObricStateDispatcherService;
import com.obric.assistant.voice.IObricVoiceService;
import com.obric.audio.continuous_talk.k0;
import com.obric.audio.continuous_talk.n0;
import com.obric.audio.continuous_talk.session.impl.plugin.ObricContTalkAudioPlugin;
import com.obric.audio.continuous_talk.session.impl.plugin.ObricContTalkConnectTimeoutPlugin;
import com.obric.audio.continuous_talk.session.impl.plugin.ObricContTalkPlugin;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.i1;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class ObricContTalkMgrImpl extends LLMCallController<com.obric.audio.continuous_talk.session.impl.a> implements hia.a {
    public final int A;
    public volatile String B;
    public volatile String C;
    public volatile String D;
    public volatile boolean E;
    public volatile String F;
    public Job G;
    public Function1<? super hia.a.d, Unit> H;
    public Job I;
    public volatile boolean J;
    public final com.larus.audio.call.e K;
    public final String v;
    public final AtomicInteger w;
    public q x;
    public Job y;
    public volatile boolean z;

    public final class a extends LLMCallController<com.obric.audio.continuous_talk.session.impl.a>.a implements com.obric.audio.continuous_talk.session.impl.a {
        public final /* synthetic */ ObricContTalkMgrImpl b;

        @Override // com.obric.audio.continuous_talk.session.impl.a
        public final void l() {
            this.b.c();
        }

        public a(ObricContTalkMgrImpl r1) {
            this.b = r1;
            super(r1);
        }

        @Override // com.obric.audio.continuous_talk.session.impl.a
        public final void g(String r2) {
            this.b.Y(r2);
        }
    }

    public final void X() {
        this.z = false;
        Job r0 = this.y;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.y = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L12
        q r2 = this.x;     // Catch: Throwable -> L12
        if (r2 == null) goto L9;
        r2.b();     // Catch: Throwable -> L12
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L12
    L10:
        Object r4 = Result.constructor-impl(r3);     // Catch: Throwable -> L12
    L14:
        Throwable r5 = Result.exceptionOrNull-impl(r4);
        if (r5 == null) goto L17;
        com.larus.audio.call.util.e.a.e(this.v, "stopSilentAudioPlayer failed: " + r5);
    L17:
        this.x = null;
        com.larus.audio.call.util.e.a.i(this.v, "silent audio player stopped");
        return;
    L9:
        r3 = null;
    L12:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }

    public final com.larus.audio.call.arch.c K() {
        return new a(this);
    }

    @Override // hia.a
    public final boolean a0() {
        t0 r0 = LLMCallController.y(this, Reflection.getOrCreateKotlinClass(t0.class));
        if (r0 != null) goto L6;
        return false;
    L6:
        if (this.J == false) goto L8;
        return false;
    L8:
        if (r0.a0() == false) goto L12;
        return true;
    L12:
        return false;
    }

    @Override // hia.a
    public final hia.a.d.b c() {
        boolean r1 = true;
        if (this.w.compareAndSet(1, 2) == false) goto L30;
        W(false);
        X();
        Job r2 = this.I;
        if (r2 == null) goto L7;
        Job.DefaultImpls.cancel$default(r2, null, 1, null);
    L7:
        this.I = null;
        V(false);
        T(new RealtimeCallParam());
        L();
        Job r3 = this.G;
        if (r3 == null) goto L10;
        Job.DefaultImpls.cancel$default(r3, null, 1, null);
    L10:
        this.G = null;
        Function1<? super hia.a.d, Unit> r4 = this.H;
        if (r4 == null) goto L13;
        r4.invoke(hia.a.d.b.a);
    L13:
        this.H = null;
        String r5 = this.B;
        if (r5 != null) goto L16;
    L19:
        if (r1 == false) goto L31;
        com.larus.audio.call.util.e.a.w(this.v, "exitAutoHalfDuplexMode skipped because botId is empty");
    L28:
        com.larus.audio.call.util.e.a.i(this.v, "stopImmediately result: SUCCESS");
        goto L30
    L31:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L23
        AutoHalfDuplexModeServiceDelegate.b.stop(r5);     // Catch: Throwable -> L23
        Object r6 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L23
    L26:
        if (Result.exceptionOrNull-impl(r6) == null) goto L28;
        com.larus.audio.call.util.e.a.w(this.v, "exitAutoHalfDuplexMode failed, botId:" + r5);
    L23:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L26
    L16:
        if (r5.length() == 0) goto L19;
        r1 = false;
    L30:
        return hia.a.d.b.a;
    }

    @Override // hia.a
    public final void g() {
        com.larus.audio.call.util.e.a.i(this.v, "muteRecord");
        com.larus.audio.call.arch.e r0 = LLMCallController.w(this, Reflection.getOrCreateKotlinClass(com.obric.audio.continuous_talk.session.impl.plugin.a.class));
        if ((r0 instanceof ObricContTalkAudioPlugin) == false) goto L5;
        ObricContTalkAudioPlugin r1 = (ObricContTalkAudioPlugin) r0;
    L6:
        if (r1 == null) goto L9;
        r1.Y2();
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // hia.a
    public final i1<AVKitDuplexState> h() {
        return LLMCallController.w(this, Reflection.getOrCreateKotlinClass(com.larus.audio.call.mgr.f.class)).y();
    }

    @Override // hia.a
    public final Flow<r58.d> i() {
        return ((com.obric.audio.continuous_talk.session.impl.plugin.a) LLMCallController.w(this, Reflection.getOrCreateKotlinClass(com.obric.audio.continuous_talk.session.impl.plugin.a.class))).j1();
    }

    @Override // hia.a
    public final Flow<hia.b> s() {
        return ((com.obric.audio.continuous_talk.session.impl.plugin.b) LLMCallController.w(this, Reflection.getOrCreateKotlinClass(com.obric.audio.continuous_talk.session.impl.plugin.b.class))).s();
    }

    @Override // hia.a
    public final void b() {
        if (a0() == false) goto L5;
        LLMCallController.D(this, ((LLMCallController) this).f, false, 2);
    L5:
        V(false);
        Y(null);
        zh8.a.a.x1().c().r6(null);
    }

    @Override // hia.a
    public final boolean isActive() {
        return ((AVKitDuplexState) h().getValue()).getUpState() instanceof AVKitDuplexState.UpState.Active;
    }

    public final String A() {
        return this.v;
    }

    public final IRealtimeCallTracer B() {
        return this.K;
    }

    @Override // hia.a
    public final boolean k() {
        return this.J;
    }

    public ObricContTalkMgrImpl(n0 r5) {
        Intrinsics.checkNotNullParameter(r5, "lifecycleScope");
        b78.f r0 = new b78.f(AvBizType.OBRIC_CONTINUOUS_TALK);
        int r2 = z2a.g.a;
        super(r0, new iia.a(z2a.g.e("obric_cont_talk", new JSONObject())), r5);
        this.v = "ObricContTalkMgr";
        this.w = new AtomicInteger(0);
        this.A = 960;
        this.K = new com.larus.audio.call.e("obric_continuous_talk");
    }

    @Override // hia.a
    public final hia.a.d I0(JSONObject r3) {
        Intrinsics.checkNotNullParameter(r3, "params");
        if (((com.obric.audio.continuous_talk.session.impl.plugin.b) LLMCallController.w(this, Reflection.getOrCreateKotlinClass(com.obric.audio.continuous_talk.session.impl.plugin.b.class))).I0(r3) == false) goto L6;
        return hia.a.d.b.a;
    L6:
        return new hia.a.d.C0058a(0, "REQUEST_CHAT_FAILED");
    }

    public final void V(boolean r5) {
        if (r5 != this.E) goto L5;
        return;
    L5:
        this.E = r5;
        if (r5 == true) goto L8;
        Y(null);
    L8:
        com.larus.audio.call.util.e.a.i(this.v, "dispatchContinuousTtsIslandState: isPlaying=" + r5 + ", conversationId=" + this.C + ", taskId=" + this.D);
        IObricStateDispatcherService r0 = (IObricStateDispatcherService) ServiceManager.get().getService(IObricStateDispatcherService.class);
        if (r0 == null) goto L12;
        r0.f(this.C, this.D, r5);
        return;
    }

    public final void W(boolean r12) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        iaa.b.a.getClass();     // Catch: Throwable -> L4
        Object r1 = Result.constructor-impl(Boolean.valueOf(iaa.b.b("obric.bt.assistant.fdx")));     // Catch: Throwable -> L4
    L6:
        Boolean r2 = Boolean.FALSE;
        if (Result.isFailure-impl(r1) == false) goto L9;
        r1 = r2;
    L9:
        boolean r3 = ((Boolean) r1).booleanValue();
        com.larus.audio.call.util.e r4 = com.larus.audio.call.util.e.a;
        r4.i(this.v, "enableAssistantFdx: hasFdxFeature:? " + r3);
        AudioManager r5 = null;
        if (r3 == false) goto L31;
        Object r6 = AppHost.a.getApplication().getSystemService("audio");
        if ((r6 instanceof AudioManager) == false) goto L14;
        AudioManager r7 = (AudioManager) r6;
    L15:
        boolean r8 = false;
        if (r7 != null) goto L40;
        r4.e(this.v, "setAssistantFdxActive: audioManager is null, active=" + r12);
    L29:
        if (r8 == false) goto L31;
        com.larus.audio.call.util.e.a.i(this.v, "enableAssistantFdx: setAssistantFdxActive succeeded, enable=" + r12);
        return;
    L40:
        AudioManager.class.getMethod("setAssistantFdxActive", new Class[]{Boolean.TYPE}).invoke(r7, new Object[]{Boolean.valueOf(r12)});     // Catch: Throwable -> L20
        r4.i(this.v, "setAssistantFdxActive: success, active=" + r12);     // Catch: Throwable -> L20
        Object r9 = Result.constructor-impl(Boolean.TRUE);     // Catch: Throwable -> L20
    L22:
        Throwable r10 = Result.exceptionOrNull-impl(r9);
        if (r10 == null) goto L25;
        com.larus.audio.call.util.e.a.e(this.v, "setAssistantFdxActive: failed, active=" + r12 + ", error=" + r10);
    L25:
        Boolean r11 = Boolean.FALSE;
        if (Result.isFailure-impl(r9) == false) goto L28;
        r9 = r11;
    L28:
        r8 = ((Boolean) r9).booleanValue();
    L20:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L22
    L14:
        r7 = null;
    L31:
        com.larus.audio.call.util.e r14 = com.larus.audio.call.util.e.a;
        r14.i(this.v, "enableAssistantFdx: setAssistantFdxActive failed, fallback to setParameters, enable=" + r12);
        Object r15 = AppHost.a.getApplication().getSystemService("audio");
        if ((r15 instanceof AudioManager) == false) goto L34;
        r5 = (AudioManager) r15;
    L34:
        if (r5 == null) goto L36;
        r5.setParameters("bt_sco_assistant_fdx=" + (r12 ? 1 : 0));
    L36:
        r14.i(this.v, "setBtScoAssistantFdx: " + (r12 ? 1 : 0));
        return;
    L4:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L6
    }

    public final void Y(String r8) {
        String r0 = this.F;
        if (Intrinsics.areEqual(r0, r8) == false) goto L5;
        return;
    L5:
        this.F = r8;
        com.larus.audio.call.util.e.a.i(this.v, "updateContinuousTtsMessageId: oldMessageId=" + r0 + ", messageId=" + r8);
        AtomicReference<hia.a> r1 = hia.c.a;
        FLogger r2 = FLogger.a;
        StringBuilder r3 = new StringBuilder("notifyContinuousTtsMessageIdChanged, oldMessageId=");
        r3.append(r0);
        r3.append(", newMessageId=");
        r3.append(r8);
        r3.append(", observerSize=");
        CopyOnWriteArraySet<hga.a> r4 = hia.c.b;
        r3.append(r4.size());
        r2.i("ObricContTalkSessionStore", r3.toString());
        Iterator<hga.a> r5 = r4.iterator();
    L7:
        if (r5.hasNext() == false) goto L13;
        hga.a r6 = r5.next();
        r6.a(r0, r8);     // Catch: Exception -> L11
    L11:
        e = move-exception;
        FLogger.a.e("ObricContTalkSessionStore", "notifyContinuousTtsMessageIdChanged: observer failed, observer=".concat(r6.getClass().getName()), e);
        goto L7
    }

    @Override // hia.a
    public final boolean a(String r4) {
        if (r4 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        return false;
    L11:
        if (Intrinsics.areEqual(r4, this.F) == true) goto L13;
        return false;
    L13:
        if (a0() == false) goto L18;
        return true;
    L18:
        return false;
    L5:
        if (r4.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    @Override // hia.a
    public final hia.a.d d(JSONObject r5) {
        Intrinsics.checkNotNullParameter(r5, "contextData");
        id9.d r0 = ((LLMCallController) this).g;
        if (r0 == null) goto L5;
        jd9.c r1 = r0.state();
    L7:
        if ((r1 instanceof jd9.c.a) == true) goto L10;
        com.larus.audio.call.util.e.a.w(this.v, "updatePersonalContext failed: session not connected");
        return new hia.a.d.C0058a(0, "SESSION_NOT_CONNECTED");
    L10:
        JSONObject r2 = new JSONObject();
        r2.put("context_data", r5);
        r0.p(TriggerMode.UPDATE_PERSONAL_CONTEXT, r2.toString());
        com.larus.audio.call.util.e.a.i(this.v, "updatePersonalContext: " + r2);
        return hia.a.d.b.a;
    L5:
        r1 = null;
        goto L7
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [com.obric.audio.continuous_talk.session.impl.n, kotlin.jvm.functions.Function0] */
    @Override // hia.a
    public final void e(final k0 r9) {
        Intrinsics.checkNotNullParameter(r9, "onResult");
        boolean r1 = true;
        if (this.w.get() == 1) goto L6;
        r9.invoke(hia.a.d.b.a);
        com.larus.audio.call.util.e.a.i(this.v, "stopAsync result: SUCCESS NotRunning");
        return;
    L6:
        Job r0 = this.G;
        if (r0 != null) goto L9;
    L11:
        r1 = false;
    L13:
        if (r1 == false) goto L16;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new ObricContTalkMgrImpl$stopAsync$1(this, r9, null), 3, null);
        return;
    L16:
        ?? r2 = new n(this, r9);
        if (((Boolean) r2.invoke()).booleanValue() == false) goto L20;
        com.larus.audio.call.util.e.a.i(this.v, "stopAsync result: SUCCESS State Not Speaking");
        return;
    L20:
        this.H = r9;
        this.G = BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new ObricContTalkMgrImpl$stopAsync$2(this, r2, null), 3, null);
        return;
    L9:
        if (r0.isCompleted() == true) goto L11;
        goto L11
    }

    @Override // hia.a
    public final void j(boolean r5) {
        com.larus.audio.call.util.e r0 = com.larus.audio.call.util.e.a;
        r0.i(this.v, "setTtsMute: " + r5);
        this.J = r5;
        t0 r1 = LLMCallController.y(this, Reflection.getOrCreateKotlinClass(t0.class));
        if (r1 != null) goto L6;
        r0.w(this.v, "setTtsMute: audioPlugin is null");
        return;
    L6:
        if (r5 == false) goto L8;
        r1.f0();
    L9:
        V(a0());
        return;
    L8:
        r1.b0();
        goto L9
    }

    public final void p(com.larus.audio.call.arch.c r4, com.larus.audio.call.arch.k0 r5) {
        com.obric.audio.continuous_talk.session.impl.a r6 = (com.obric.audio.continuous_talk.session.impl.a) r4;
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r5, "registry");
        if (c78.a.a == false) goto L5;
        r5.a(new com.larus.audio.call.plugins.c(r6));
    L5:
        r5.a(new com.larus.audio.call.mgr.g(r6));
        ((LLMCallController) this).b.async();
        r5.a(new ObricContTalkAudioPlugin(r6));
        r5.a(new ObricContTalkMobMonitor(r6));
        r5.a(new com.obric.audio.continuous_talk.session.impl.plugin.c(r6, ((LLMCallController) this).j));
        r5.a(new com.larus.audio.call.plugins.h(r6, ((LLMCallController) this).b.a(), ((LLMCallController) this).i));
        r5.a(new com.obric.audio.continuous_talk.session.impl.plugin.q(r6));
        r5.a(new ObricContTalkConnectTimeoutPlugin(r6, z2.a.L3()));
        r5.a(new ObricContTalkPlugin(r6));
    }

    @Override // hia.a
    public final hia.a.d f(String r22, String r23, Integer r24, Integer r25, String r26, String r27, SpeakerVoice r28, de8.c r29, by7.e r30, String r31, String r32, String r33, RealtimeCallParam.l r34) {
        Intrinsics.checkNotNullParameter(r22, "callId");
        Intrinsics.checkNotNullParameter(r23, "taskId");
        Intrinsics.checkNotNullParameter(r26, "convId");
        Intrinsics.checkNotNullParameter(r27, "botId");
        Intrinsics.checkNotNullParameter(r29, "chatArgumentData");
        Intrinsics.checkNotNullParameter(r34, "oneshotParams");
        boolean r1 = false;
        if (this.w.compareAndSet(0, 1) == false) goto L43;
        this.B = r27;
        this.C = r26;
        this.D = r23;
        IObricVoiceService.a.getClass();
        IObricVoiceService r0 = IObricVoiceService.a.a();
        if (r0 == null) goto L10;
        if (r0.n() != true) goto L10;
        r1 = true;
    L10:
        if (r1 == false) goto L14;
        IObricVoiceService r2 = IObricVoiceService.a.a();
        if (r2 == null) goto L14;
        Integer r5 = r2.q();
    L15:
        com.larus.audio.call.tracer.b r3 = ((com.obric.audio.continuous_talk.session.impl.a) x().getContext()).i();
        if ((r3 instanceof iia.a) == false) goto L18;
        iia.a r4 = (iia.a) r3;
    L19:
        if (r4 == null) goto L26;
        JSONObject r6 = new JSONObject();
        r6.put("bot_id", r27);
        r6.put("conversation_id", r26);
        r6.put("recommend_from", r29.d);
        r6.put("llm_model", r32);
        if (r28 == null) goto L23;
        String r7 = r28.getStyleName();
    L24:
        r6.put("voice_style", r7);
        r6.put("call_id", r22);
        r6.put("task_id", r23);
        Intrinsics.checkNotNullParameter(r6, "params");
        r4.a.b(r6);
        goto L26
    L23:
        r7 = null;
    L26:
        CoroutineScope r17 = (CoroutineScope) ((LLMCallController) this).d.invoke();
        if (r17 == null) goto L29;
        Job r12 = BuildersKt.launch$default(r17, Dispatchers.getIO(), null, new ObricContTalkMgrImpl$start$job$1(this, r22, r23, r24, r5, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, null), 2, null);
    L30:
        if (r12 != null) goto L32;
        hia.a.d r8 = new hia.a.d.C0058a(-1, "NO_LIFECYCLE_SCOPE");
        ObricContTalkMgrImpl r9 = this;
    L44:
        com.larus.audio.call.util.e.a.i(r9.v, "start result: " + r8);
        return r8;
    L32:
        r9 = this;
        Job r10 = r9.I;
        if (r10 == null) goto L35;
        Job.DefaultImpls.cancel$default(r10, null, 1, null);
    L35:
        CoroutineScope r11 = (CoroutineScope) ((LLMCallController) r9).d.invoke();
        if (r11 == null) goto L38;
        Job r13 = BuildersKt.launch$default(r11, null, null, new ObricContTalkMgrImpl$startContinuousTtsIslandStateObserver$1(r9, null), 3, null);
    L39:
        r9.I = r13;
        if (r13 != null) goto L42;
        com.larus.audio.call.util.e.a.w(r9.v, "startContinuousTtsIslandStateObserver skipped, lifecycleScope is null");
    L42:
        r8 = hia.a.d.b.a;
        goto L44
    L38:
        r13 = null;
        goto L39
    L29:
        r12 = null;
        goto L30
    L18:
        r4 = null;
    L14:
        r5 = null;
        goto L15
    L43:
        r9 = this;
        r8 = new hia.a.d.C0058a(r9.w.get(), "WRONG_STATE");
        goto L44
    }
}
