package com.larus.voicecall.impl.plugins;

import com.larus.audio.call.RealtimeCallParam;
import com.larus.audio.call.mgr.MajorState;
import com.larus.audio.call.mgr.ReducerPosition;
import com.larus.audio.call.mgr.StateTriggerEvent;
import com.larus.audio.call.tracer.IRealtimeCallTracer;
import com.larus.audio.ttsV2.TtsGuideDelegate;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.SceneModel;
import com.larus.im.service.audio.AudioSessionType;
import com.larus.im.service.audio.cmd.ReplyStage;
import com.larus.im.service.audio.cmd.ReplyType;
import com.larus.im.service.audio.cmd.TriggerMode;
import com.larus.platform.model.audio.RealtimeCallSceneModeHelloConfig;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.impl.subtitle.SubtitleListUpdateType;
import com.larus.voicecall.impl.util.RealtimeCallUtil;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.NameKeys;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class RealtimeCallScenePlugin extends com.larus.audio.call.arch.a<r> implements n {
    public final String f;
    public boolean g;
    public boolean h;
    public Integer i;
    public final MutableSharedFlow<Integer> j;
    public volatile boolean k;
    public boolean l;
    public final CallEventDispatcher m;
    public boolean n;
    public boolean o;
    public final SceneDownReducer p;
    public Job q;

    public static final class a implements com.larus.audio.call.mgr.f.a {
        public final /* synthetic */ RealtimeCallScenePlugin a;

        public a(RealtimeCallScenePlugin r1) {
            this.a = r1;
        }

        public final void Q(MajorState r3, MajorState r4) {
            Intrinsics.checkNotNullParameter(r3, "prev");
            Intrinsics.checkNotNullParameter(r4, "current");
            if ((r4 instanceof MajorState.j) == false) goto L10;
            if (((r) this.a.getContext()).params().A == false) goto L7;
            return;
        L7:
            if (this.a.U() == true) goto L18;
            this.a.j.tryEmit(2);
            return;
        L18:
            return;
        L10:
            if ((r4 instanceof MajorState.d) == true) goto L12;
            this.a.j.tryEmit(3);
            return;
        L12:
            if ((r3 instanceof MajorState.h) == false) goto L14;
            this.a.j.tryEmit(1);
            return;
        L14:
            this.a.j.tryEmit(2);
        }
    }

    public static final class b implements com.larus.im.service.audio.v {
        public final String a;
        public final /* synthetic */ RealtimeCallScenePlugin b;

        public final String getName() {
            return this.a;
        }

        public b(RealtimeCallScenePlugin r1) {
            this.b = r1;
            this.a = r1.f;
        }

        public final void O1(jd9.c r4, jd9.c r5) {
            Intrinsics.checkNotNullParameter(r4, "oldState");
            Intrinsics.checkNotNullParameter(r5, "newState");
            FLogger.a.d(this.b.f, "onConnectionStateChanged() called with: status = " + r5);
            if ((r5 instanceof jd9.c.a) == false) goto L6;
            this.b.m.i(null, false);
            return;
        L6:
            if ((r5 instanceof jd9.c.d) == false) goto L10;
            this.b.m.d();
            return;
        }
    }

    public static final class c extends com.larus.im.service.audio.z0 {
        public final String a;
        public String b;
        public final /* synthetic */ RealtimeCallScenePlugin c;

        public final String g() {
            return this.a;
        }

        public c(RealtimeCallScenePlugin r1) {
            this.c = r1;
            this.a = r1.f;
            this.b = NameKeys.UnloadStrategy_No_Strategy;
        }

        public final void n(com.larus.im.service.audio.z0.a r8) {
            Intrinsics.checkNotNullParameter(r8, "event");
            boolean r1 = true;
            if ((r8 instanceof pf9.o) == true) goto L5;
            String r3 = null;
            if ((r8 instanceof pf9.i0) == false) goto L50;
            FLogger r9 = FLogger.a;
            String r0 = this.c.f;
            StringBuilder r4 = new StringBuilder();
            r4.append(this.c.f);
            r4.append("_onReceiveEvent FlowLLMSceneSwitchedEvent scene=");
            RealtimeCallUtil.a.getClass();
            com.larus.voicecall.impl.scene.o r5 = RealtimeCallUtil.l;
            if (r5 == null) goto L16;
            SceneModel r6 = r5.a;
            if (r6 == null) goto L16;
            r3 = r6.getName();
        L16:
            r4.append(r3);
            r9.i(r0, r4.toString());
            this.c.k = false;
            RealtimeCallScenePlugin r2 = this.c;
            r2.m.i(r2.i, false);
            final RealtimeCallScenePlugin r7 = this.c;
            r7.getClass();
            boolean r10 = u3a.f.e();
            com.larus.platform.service.z2 r11 = com.larus.platform.service.z2.a;
            if (r11.getRealtimeCallTranslatorConfig().a() == false) goto L36;
            id9.d r12 = ((r) r7.getContext()).j();
            if (r12 == null) goto L27;
            com.larus.im.service.audio.x0 r13 = r12.getSessionConfig();
            if (r13 == null) goto L27;
            AudioSessionType r14 = r13.b;
            if (r14 == null) goto L27;
            if (com.larus.im.service.audio.y0.b(r14) != true) goto L27;
            boolean r15 = true;
        L28:
            if (r15 == false) goto L33;
            if (r10 == false) goto L31;
            com.larus.audio.call.arch.b.a(r7.getContext()).setBluetoothForceToMedia(true);
            goto L36
        L31:
            com.larus.audio.call.arch.b.a(r7.getContext()).setBluetoothForceToMedia(false);
            goto L36
        L33:
            if (r10 == false) goto L35;
            JSONObject r16 = new JSONObject();
            r16.put("rtc.bluetooth_force_to_media", true);
            r7.j3(r16);
            goto L36
        L35:
            JSONObject r17 = new JSONObject();
            r17.put("rtc.bluetooth_force_to_media", false);
            r7.j3(r17);
        L27:
            r15 = false;
        L36:
            if (r10 == true) goto L38;
        L40:
            if (r10 == true) goto L42;
            r7.n = false;
        L42:
            if (r10 == true) goto L44;
            return;
        L44:
            if (r11.getRealtimeCallTranslatorConfig().a() == true) goto L46;
            return;
        L46:
            if (TtsGuideDelegate.b.e() == true) goto L48;
            return;
        L48:
            if (r7.o == true) goto L125;
            r7.o = true;
            r9.d(r7.f, "[showInterpretMicTipDialog] try show dialog");
            com.larus.utils.t0.e(new d1(r7));
            return;
        L125:
            return;
        L38:
            if (r7.n == true) goto L40;
            r7.n = true;
            r7.l3();
            goto L42
        L50:
            boolean r18 = r8 instanceof pf9.z;
            String r19 = NameKeys.UnloadStrategy_No_Strategy;
            if (r18 == false) goto L58;
            RealtimeCallScenePlugin r20 = this.c;
            r20.l = false;
            pf9.z r21 = (pf9.z) r8;
            r20.m.e(r21.b, r21.a);
            String r22 = r21.b;
            if (r22 == null) goto L56;
            r19 = r22;
        L56:
            this.b = r19;
            return;
        L58:
            if ((r8 instanceof pf9.c0) == false) goto L77;
            pf9.a r23 = ((pf9.c0) r8).a;
            if (r23 != null) goto L62;
            return;
        L62:
            String r24 = r23.c;
            if (r24 == null) goto L67;
            r19 = r24;
        L67:
            if (r19.length() == 0) goto L70;
            r1 = false;
        L70:
            if (r1 == false) goto L72;
            r19 = this.b;
        L72:
            CallEventDispatcher r25 = this.c.m;
            boolean r26 = r23.b;
            String r27 = r23.a;
            Map r28 = r23.d;
            if (r28 == null) goto L75;
            r3 = (String) r28.get("semantic_integrity_seg");
        L75:
            r25.l(r26, r27, r3, r19);
            return;
        L77:
            if ((r8 instanceof pf9.a0) == false) goto L80;
            this.c.m.g();
            return;
        L80:
            if ((r8 instanceof pf9.f0) == false) goto L114;
            pf9.f0 r29 = (pf9.f0) r8;
            LinkedHashMap r30 = pf9.i.a;
            Intrinsics.checkNotNullParameter(r29, "<this>");
            Intrinsics.checkNotNullParameter(r29, "<this>");
            ReplyType r31 = r29.getType();
            ReplyType r32 = ReplyType.Think;
            if (r31 != r32) goto L84;
            boolean r33 = true;
        L85:
            if (r33 == true) goto L87;
        L89:
            boolean r34 = false;
        L90:
            if (r34 == false) goto L92;
            this.c.m.k();
            return;
        L92:
            Intrinsics.checkNotNullParameter(r29, "<this>");
            Intrinsics.checkNotNullParameter(r29, "<this>");
            if (r29.getType() != r32) goto L95;
            boolean r35 = true;
        L96:
            if (r35 == true) goto L98;
        L100:
            boolean r36 = false;
        L101:
            if (r36 == false) goto L104;
            this.c.m.m();
            return;
        L104:
            if (this.c.k == false) goto L106;
            return;
        L106:
            if (pf9.i.j(r29) == false) goto L133;
            RealtimeCallUtil.a.getClass();
            if (RealtimeCallUtil.l == null) goto L110;
        L111:
            RealtimeCallScenePlugin r37 = this.c;
            r37.g = true;
            r37.h = false;
        L112:
            this.c.m.c();
            return;
        L110:
            if (this.c.h == false) goto L112;
        L133:
            return;
        L98:
            if (r29.d != ReplyStage.End) goto L100;
            r36 = true;
            goto L101
        L95:
            r35 = false;
            goto L96
        L87:
            if (r29.d != ReplyStage.Begin) goto L89;
            r34 = true;
            goto L90
        L84:
            r33 = false;
            goto L85
        L114:
            if ((r8 instanceof pf9.e0) == true) goto L116;
            return;
        L116:
            if (((pf9.e0) r8).b == false) goto L136;
            this.c.m.b();
            return;
        L136:
            return;
        L5:
            if (u3a.f.e() == false) goto L119;
            RealtimeCallScenePlugin r38 = this.c;
            if (r38.n == true) goto L120;
            r38.n = true;
            r38.l3();
            return;
        L120:
            return;
        }
    }

    @Override // com.larus.voicecall.impl.scene.l
    public final void G1() {
        FLogger.a.d(this.f, "reconnectSession() called");
        RealtimeCallUtil.a.getClass();
        if (((RealtimeCallSceneModeHelloConfig) RealtimeCallUtil.p.getValue()).getEnableSceneGuide() == false) goto L6;
        T1();
        return;
    }

    public final com.larus.im.service.audio.v R2() {
        return new b(this);
    }

    public final com.larus.im.service.audio.z0 S2() {
        return new c(this);
    }

    @Override // com.larus.voicecall.impl.scene.l
    public final void T1() {
        FLogger r0 = FLogger.a;
        r0.d(this.f, "[triggerBotHello] called with: isGuide = false");
        if (u3a.f.e() == false) goto L7;
        r0.d(this.f, "[triggerBotHello] interpret scene, no need to trigger hello.");
        return;
    L7:
        if (this.g == false) goto L10;
        r0.d(this.f, "[triggerBotHello] current scene has said hello and has not guide.");
        return;
    L10:
        JSONObject r1 = new JSONObject();
        r1.put("trigger_event", "scene_mode_introduce");
        r1.putOpt("enter_method", ((r) getContext()).params().p.i);
        String r2 = ((r) getContext()).params().p.p;
        if (r2 != null) goto L13;
    L21:
        com.larus.audio.call.arch.b.a(getContext()).C1();
        ((r) getContext()).a().t();
        id9.d r3 = ((r) getContext()).j();
        if (r3 == null) goto L24;
        r3.p(TriggerMode.HELLO, r1.toString());
    L24:
        ((r) getContext()).a().n2(TriggerSceneHello.a);
        return;
    L13:
        if (r2.length() <= 0) goto L15;
        boolean r4 = true;
    L16:
        if (r4 == true) goto L19;
        r2 = null;
    L19:
        if (r2 == null) goto L21;
        r1.put("bot_say_hello_text_key", r2);
        goto L21
    L15:
        r4 = false;
        goto L16
    }

    @Override // com.larus.voicecall.impl.plugins.n
    public final boolean U() {
        RealtimeCallUtil.a.getClass();
        if (RealtimeCallUtil.l == null) goto L9;
        if (this.g == true) goto L9;
        if (((RealtimeCallSceneModeHelloConfig) RealtimeCallUtil.p.getValue()).getEnableSceneHello() == false) goto L9;
    L12:
        return true;
    L9:
        if (this.h == true) goto L11;
    L13:
        return false;
    L11:
        if (this.g == true) goto L13;
        goto L12
    }

    public final void X2() {
        FLogger.a.d(this.f, "onInterrupt() called with: context = " + getContext());
        this.m.onInterrupt();
    }

    @Override // com.larus.voicecall.impl.scene.l
    public final void f1() {
        FLogger.a.d(this.f, "triggerBotContinue() called");
        id9.d r0 = ((r) getContext()).j();
        if (r0 == null) goto L6;
        r0.p(TriggerMode.CONTINUE, null);
        return;
    }

    @Override // com.larus.voicecall.impl.scene.l
    public final void k1() {
        FLogger.a.d(this.f, "setCurrentCallNeedGuide() called");
        this.h = true;
    }

    public final void l3() {
        if (com.larus.platform.service.z2.a.getRealtimeCallTranslatorConfig().b() == true) goto L5;
        return;
    L5:
        RealtimeCallUtil.a.getClass();
        boolean r0 = RealtimeCallUtil.t();
        boolean r1 = TtsGuideDelegate.b.e();
        FLogger.a.i(this.f, "isDenoiseOpen:" + r0 + " , isEarphoneOn:" + r1);
        if (r1 == true) goto L10;
        if (r0 == false) goto L9;
        t19.s.a.g(AppHost.a.getApplication(), 2131906750, false);
        k3("noise_free_no_headphone");
        return;
    L9:
        t19.s.a.g(AppHost.a.getApplication(), 2131906749, false);
        k3("no_noise_free_no_headphone");
        return;
    L10:
        if (r0 == false) goto L15;
        t19.s.a.g(AppHost.a.getApplication(), 2131906751, false);
        k3("noise_free_headphone");
        return;
    }

    @Override // com.larus.voicecall.impl.plugins.n
    public final boolean y0() {
        RealtimeCallUtil.a.getClass();
        if (RealtimeCallUtil.D() == false) goto L7;
        if (this.l == false) goto L7;
    L12:
        return true;
    L7:
        if (RealtimeCallUtil.l != null) goto L12;
        if (((r) getContext()).params().S == true) goto L12;
        return false;
    }

    public final com.larus.audio.call.mgr.f.a P2() {
        if (com.larus.audio.call.f.f() == false) goto L11;
        Job r0 = this.q;
        if (r0 != null) goto L7;
    L8:
        this.q = U2(new RealtimeCallScenePlugin$createCallStateObserver$1(this, null));
    L9:
        return null;
    L7:
        if (r0.isActive() == true) goto L9;
    L11:
        return new a(this);
    }

    public final void e3() {
        super.e3();
        ((r) getContext()).a().F2(this.p, ReducerPosition.APPEND);
    }

    public final void g3() {
        super.g3();
        this.m.onRelease();
    }

    @Override // com.larus.voicecall.impl.scene.l
    public final RealtimeCallParam i2() {
        return ((r) getContext()).params();
    }

    @Override // com.larus.voicecall.impl.plugins.n
    public final boolean H() {
        return this.k;
    }

    public final String T2() {
        return this.f;
    }

    @Override // com.larus.voicecall.impl.scene.l
    public final MutableSharedFlow d() {
        return this.j;
    }

    @Override // com.larus.voicecall.impl.plugins.n
    public final CallEventDispatcher x0() {
        return this.m;
    }

    public RealtimeCallScenePlugin(r r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4);
        this.f = "RealtimeCallScenePlugin";
        this.j = SharedFlowKt.MutableSharedFlow$default(1, 3, null, 4, null);
        this.m = new CallEventDispatcher();
        this.p = new SceneDownReducer();
    }

    @Override // com.larus.voicecall.impl.scene.l
    public final void C0(com.larus.voicecall.impl.scene.a r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        CallEventDispatcher r1 = this.m;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "listener");
        if (r1.a.contains(r3) == true) goto L6;
        r1.a.add(r3);
        return;
    }

    @Override // com.larus.voicecall.impl.scene.l
    public final void E0(boolean r6) {
        RealtimeCallParam r0 = ((r) getContext()).params();
        FLogger.a.d(this.f, "finishSession, taskId=" + r0.l.a + ", needFinishTask : " + r6);
        if (r6 == false) goto L6;
        ((r) getContext()).n().T(r0);
        return;
    L6:
        com.larus.audio.call.arch.b.a(getContext()).c0();
        ((r) getContext()).k().Q(IRealtimeCallTracer.HelloStatus.INTERRUPT, SubtitleListUpdateType.SCENE_MODE_CHANGE);
        ((r) getContext()).k().Q(IRealtimeCallTracer.HelloStatus.HELLO_RESET, null);
    }

    @Override // com.larus.voicecall.impl.plugins.n
    public final void R(RealtimeCallParam r6) {
        Intrinsics.checkNotNullParameter(r6, LynxResourceModule.PARAMS_KEY);
        MajorState r0 = ((r) getContext()).a().s1();
        FLogger.a.i(this.f, "[sendUplinkHangUpTrigger], currentState:" + r0);
        if (i3() == true) goto L5;
        return;
    L5:
        r6.W = true;
        id9.d r7 = ((r) getContext()).j();
        if (r7 == null) goto L9;
        r7.p(TriggerMode.UPLINK_HANGUP, new JSONObject().toString());
        return;
    }

    public final void j3(JSONObject r5) {
        FLogger r0 = FLogger.a;
        r0.i(this.f, "[setRuntimeParameters] params=" + r5);
        id9.d r1 = ((r) getContext()).j();
        if (r1 == null) goto L5;
        r1.f(r5.toString());
        return;
    L5:
        r0.e(this.f, "[setRuntimeParameters] mediaSession is null or unsupported");
    }

    public final void k3(String r4) {
        com.larus.platform.service.o r0 = com.larus.platform.service.o.a;
        JSONObject r1 = new JSONObject();
        r1.put("toast_type", r4);
        r1.put("call_id", ((r) getContext()).params().e);
        Unit r5 = Unit.INSTANCE;
        r0.reportEvent("translate_toast_show", r1);
    }

    @Override // com.larus.voicecall.impl.scene.l
    public final void q0(com.larus.voicecall.impl.scene.a r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        CallEventDispatcher r1 = this.m;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "listener");
        r1.a.remove(r3);
    }

    @Override // com.larus.voicecall.impl.scene.l
    public final void Z(SceneModel r10, boolean r11, Integer r12) {
        if (r10 != null) goto L5;
        boolean r2 = true;
    L6:
        this.l = r2;
        FLogger.a.d(this.f, "startSession() called with: scene = " + r10 + ", needStartTask = " + r11 + ", clickTraceId = " + r12);
        this.i = r12;
        RealtimeCallParam r13 = ((r) getContext()).params();
        if (r11 == false) goto L10;
        ((r) getContext()).n().N(r13);
        return;
    L10:
        this.g = false;
        if (r10 == null) goto L13;
        this.k = true;
        ((r) getContext()).a().n2(StateTriggerEvent.SceneSwitched.a);
    L14:
        ((r) getContext()).a().a1(MajorState.a.c, this.f);
        Object r3 = null;
        ((r) getContext()).k().Q(IRealtimeCallTracer.HelloStatus.START_SESSION, null);
        if (r10 == null) goto L17;
        this.g = false;
    L17:
        this.m.getClass();
        String r14 = u3a.f.a;
        JSONObject r15 = new JSONObject();
        if (r10 == null) goto L24;
        String r16 = r10.getKey();
        if (r16 == null) goto L24;
        if (r16.equals("interpret_v2") != true) goto L24;
        boolean r17 = true;
    L25:
        if (r17 == false) goto L79;
        r15.put("interrupt_type", "1");
        JSONObject r18 = new JSONObject();
        Object r4 = u3a.f.b();
        if (Result.isFailure-impl(r4) == false) goto L29;
        r4 = null;
    L29:
        com.larus.bmhome.actionbar.model.l0 r5 = (com.larus.bmhome.actionbar.model.l0) r4;
        if (r5 == null) goto L35;
        com.larus.bmhome.actionbar.model.h r6 = r5.b;
        if (r6 == null) goto L35;
        List r7 = r6.e;
        if (r7 == null) goto L35;
    L36:
        List r8 = r7;
        Object r9 = u3a.f.b();
        if (Result.isFailure-impl(r9) == false) goto L39;
        r9 = null;
    L39:
        com.larus.bmhome.actionbar.model.l0 r19 = (com.larus.bmhome.actionbar.model.l0) r9;
        if (r19 == null) goto L46;
        com.larus.bmhome.actionbar.model.h r20 = r19.a;
        if (r20 == null) goto L46;
        List r21 = r20.e;
        if (r21 == null) goto L46;
    L47:
        List r22 = CollectionsKt.plus(r8, r21);
        Iterator r23 = r22.iterator();
    L49:
        if (r23.hasNext() == false) goto L53;
        Object r24 = r23.next();
        if (Intrinsics.areEqual(((com.larus.bmhome.actionbar.model.w) r24).k, u3a.f.c()) == false) goto L49;
    L54:
        com.larus.bmhome.actionbar.model.w r25 = (com.larus.bmhome.actionbar.model.w) r24;
        Iterator r26 = r22.iterator();
    L56:
        if (r26.hasNext() == false) goto L60;
        Object r27 = r26.next();
        if (Intrinsics.areEqual(((com.larus.bmhome.actionbar.model.w) r27).k, u3a.f.d()) == false) goto L56;
        r3 = r27;
    L60:
        com.larus.bmhome.actionbar.model.w r28 = (com.larus.bmhome.actionbar.model.w) r3;
        if (r25 == null) goto L63;
        boolean r29 = Intrinsics.areEqual(r25.n, Boolean.TRUE);
    L65:
        if (r29 == false) goto L77;
        if (r28 == null) goto L68;
        boolean r30 = Intrinsics.areEqual(r28.n, Boolean.TRUE);
    L69:
        if (r30 == false) goto L77;
        Boolean r31 = r25.p;
        Boolean r32 = Boolean.TRUE;
        if (Intrinsics.areEqual(r31, r32) == false) goto L74;
        r18.put("speaker_mode", 1);
        r18.put("src_lang", r25.k + r28.k);
        r18.put("dest_lang", r25.k + r28.k);
    L78:
        JSONObject r33 = new JSONObject();
        JSONArray r34 = new JSONArray();
        r34.put(r18);
        Unit r110 = Unit.INSTANCE;
        r33.put("channels", r34);
        r15.put("ast", r33.toString());
        goto L79
    L74:
        if (Intrinsics.areEqual(r28.p, r32) == false) goto L76;
        r18.put("speaker_mode", 1);
        r18.put("src_lang", r28.k + r25.k);
        r18.put("dest_lang", r28.k + r25.k);
        goto L78
    L76:
        r18.put("speaker_mode", 1);
        r18.put("src_lang", u3a.f.c());
        r18.put("dest_lang", u3a.f.d());
        goto L78
    L68:
        r30 = false;
    L77:
        r18.put("speaker_mode", 1);
        r18.put("src_lang", u3a.f.c());
        r18.put("dest_lang", u3a.f.d());
        goto L78
    L63:
        r29 = false;
        goto L65
    L53:
        r24 = null;
    L46:
        r21 = CollectionsKt.emptyList();
    L35:
        r7 = CollectionsKt.emptyList();
    L79:
        String r111 = NameKeys.UnloadStrategy_No_Strategy;
        if (r10 == null) goto L83;
        String r35 = r10.getSpeakerId();
        if (r35 == null) goto L83;
    L84:
        r15.putOpt("sami_scene_speaker_id", r35);
        if (r10 == null) goto L88;
        String r36 = r10.getKey();
        if (r36 == null) goto L88;
    L89:
        r15.putOpt("sami_scene_type", r36);
        if (r10 == null) goto L92;
        int r37 = r10.getListenWaitingTime();
    L93:
        r15.putOpt("sami_listening_waiting_time", Integer.valueOf(r37));
        if (r10 == null) goto L99;
        String r112 = r10.getSpeakerId();
        if (r112 == null) goto L99;
        r111 = r112;
    L99:
        r15.putOpt("sami_tts_speaker", r111);
        FLogger.a.d("RealtimeInterpretManager", "final buildSwitchSceneExtra() extJson : " + r15);
        id9.d r113 = ((r) getContext()).j();
        if (r113 == null) goto L135;
        Intrinsics.checkNotNullParameter(r15, "<this>");
        HashMap r114 = new HashMap();
        Iterator<String> r38 = r15.keys();
    L103:
        if (r38.hasNext() == false) goto L118;
        String r39 = r38.next();
        if (r39 != null) goto L107;
    L110:
        boolean r40 = true;
    L111:
        if (r40 == true) goto L103;
        Object r41 = r15.opt(r39);
        if (r41 == null) goto L103;
        String r42 = r41.toString();
        if (r42 == null) goto L103;
        r114.put(r39, r42);
        goto L103
    L107:
        if (StringsKt.isBlank(r39) == true) goto L110;
        r40 = false;
        goto L111
    L118:
        r113.y(r114);
        return;
    L135:
        return;
    L92:
        r37 = 0;
    L88:
        r36 = NameKeys.UnloadStrategy_No_Strategy;
    L83:
        r35 = NameKeys.UnloadStrategy_No_Strategy;
    L24:
        r17 = false;
        goto L25
    L13:
        ((r) getContext()).a().n2(StateTriggerEvent.Connect.a);
        goto L14
    L5:
        r2 = false;
        goto L6
    }
}
