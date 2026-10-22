package com.larus.avlink;

import com.larus.audio.call.RealtimeCallParam;
import com.larus.audio.call.tracer.IRealtimeCallTracer;
import com.larus.audio.constant.GlobalAudioSceneEnum;
import com.larus.avlink.annoatation.DoraImageMode;
import com.larus.avlink.dora.DoraMode;
import com.larus.avlink.dora.DoraType;
import com.larus.avlink.env.diary.settings.DiaryImageSwitchManager;
import com.larus.avlink.plugins.BaseDoraLiteLiveAiPlugin;
import com.larus.avlink.plugins.DoraETracePlugin;
import com.larus.avlink.plugins.DoraETracer;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.AbilityService;
import com.larus.im.service.audio.AudioSessionType;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.impl.tracer.RealtimeCallTracer;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class DoraRealtimeCallTracer implements IRealtimeCallTracer {
    public static final /* synthetic */ int u = 0;
    public final Function0<RealtimeCallParam> a;
    public int b;
    public int c;
    public long d;
    public long e;
    public boolean f;
    public long g;
    public long h;
    public long i;
    public boolean j;
    public boolean k;
    public final Lazy l;
    public int m;
    public int n;
    public volatile String o;
    public final Lazy p;
    public final Lazy q;
    public boolean r;
    public final RealtimeCallTracer s;
    public final Lazy t;

    public static final class a {
    }

    static {
    }

    public DoraRealtimeCallTracer() {
        throw null;
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void D(boolean r1) {
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void G(boolean r1) {
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void I() {
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void J(int r1, String r2, int r3) {
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void W() {
        this.s.D = 1;
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void f0(boolean r1) {
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void i0() {
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void j0(boolean r1) {
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void m(RealtimeCallParam r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "params");
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void m0(String r1) {
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void n(RealtimeCallParam r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "params");
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void q(boolean r1, long r2) {
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void t0() {
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final ouc.d0 x(ouc.d0 r2) {
        Intrinsics.checkNotNullParameter(r2, "jsonObject");
        return r2;
    }

    public final IDoraService A0() {
        return (IDoraService) this.l.getValue();
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void E() {
        this.s.E();
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void S() {
        this.s.S();
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void c() {
        this.s.c();
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void g() {
        this.s.E();
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void n0() {
        this.s.n0();
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void o0() {
        this.s.o0();
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void r() {
        this.s.r();
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void s0() {
        if (this.j == false) goto L5;
        this.j = false;
        this.d = -1;
        this.h = 0;
        this.g = -1;
        this.f = true;
        this.k = true;
        this.b++;
    L5:
        this.k = true;
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void t() {
        if (this.j == false) goto L6;
        this.j = false;
        this.g = -1;
        this.f = true;
        this.k = true;
        this.b++;
        return;
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void u0() {
        this.s.u0();
    }

    public final String z0() {
        if (Intrinsics.areEqual(((RealtimeCallParam) this.a.invoke()).k.t, DoraMode.DORA_CALL.getValue()) == false) goto L6;
        return DoraType.DORA.getValue();
    L6:
        return DoraType.DORA_RADIO.getValue();
    }

    @Override // com.larus.audio.call.tracer.c
    public final void onSessionStarted() {
        this.e = System.currentTimeMillis();
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final boolean R() {
        return this.r;
    }

    public DoraRealtimeCallTracer(c0 r4) {
        this.a = r4;
        this.d = -1;
        this.e = -1;
        this.f = true;
        this.g = -1;
        this.h = -1;
        this.j = true;
        this.k = true;
        this.l = LazyKt.lazy(new p0());
        this.o = "";
        this.p = LazyKt.lazy(new q0(this));
        this.q = LazyKt.lazy(new r0(this));
        int r0 = RealtimeCallTracer.s0;
        Intrinsics.checkNotNullParameter(r4, "callParam");
        RealtimeCallTracer r1 = new RealtimeCallTracer(r4);
        DoraRealtimeCallTracer$traceDelegate$1$1 r5 = new DoraRealtimeCallTracer$traceDelegate$1$1(this);
        Intrinsics.checkNotNullParameter(r5, "scene");
        r1.M = r5;
        this.s = r1;
        this.t = LazyKt.lazy(new s0());
    }

    public static boolean B0(RealtimeCallParam r1) {
        if (r1 == null) goto L8;
        RealtimeCallParam.k r2 = r1.p;
        if (r2 == null) goto L8;
        if (r2.R != true) goto L8;
        return true;
    L8:
        return false;
    }

    public static void y0(String r2) {
        FLogger.a.d("DoraRealtimeCallTracer", "dora不需要上报此埋点, method ".concat(r2));
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void C(RealtimeCallParam r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        this.s.C(r2);
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void F(boolean r3) {
        if (this.f == false) goto L6;
        this.f = false;
        this.g = System.currentTimeMillis();
        return;
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void K(Map<String, ? extends Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "serverInfo");
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void b0(RealtimeCallParam r4) {
        Intrinsics.checkNotNullParameter(r4, "params");
        LinkedHashMap r0 = new LinkedHashMap();
        String r1 = r4.p.w;
        if (r1 == null) goto L5;
        r0.put("dora_proactive_id", r1);
    L5:
        int r2 = ia8.n.a;
        String r3 = ia8.n.a(r4.p.x);
        if (r3 == null) goto L8;
        r0.put("dora_proactive_type", r3);
    L8:
        String r5 = r4.p.y;
        if (r5 == null) goto L11;
        r0.put("dora_proactive_sub_type", r5);
    L11:
        String r6 = r4.p.z;
        if (r6 == null) goto L14;
        r0.put("system_notify_version", r6);
    L14:
        IDoraService r7 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r7 == null) goto L18;
        r7.A0("dora_proactive_notice_send", r0);
        return;
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void c0(long r4) {
        if (r4 < 0) goto L6;
        this.i += r4;
        return;
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void d(com.larus.audio.call.play.h.a r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void h(jd9.c r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void i(byte[] r2) {
        Intrinsics.checkNotNullParameter(r2, "audio");
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void k(long r2) {
        this.s.k = r2;
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void p(String r2) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void s(String r2) {
        Intrinsics.checkNotNullParameter(r2, "text");
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void v(boolean r1) {
        this.r = r1;
    }

    public final void x0(Map<String, Object> r4) {
        Intrinsics.checkNotNullParameter(r4, "input");
        r4.put("scene", z0());
        r4.put("call_id", (String) this.p.getValue());
        r4.put("room_id", (String) this.q.getValue());
        RealtimeCallParam r0 = (RealtimeCallParam) this.a.invoke();
        r4.put("task_id", r0.l.a);
        if (Intrinsics.areEqual(z0(), "call") == false) goto L5;
    L7:
        r4.put("is_dora_si", Integer.valueOf(Intrinsics.areEqual(r0.k.o, "dora_si") ? 1 : 0));
        int r1 = com.larus.voicecall.impl.tracer.j.J;
        Intrinsics.checkNotNullParameter(r0, "<this>");
        Intrinsics.checkNotNullParameter(r4, "json");
        r4.put("is_rtc", Boolean.valueOf(com.larus.im.service.audio.y0.e(r0.s)));
        r4.put("is_quic", Boolean.valueOf(com.larus.im.service.audio.y0.d(r0.s)));
        r4.put("is_mmt", Integer.valueOf(com.larus.im.service.audio.y0.b(r0.s) ? 1 : 0));
        r4.put("client_pre_connect", Integer.valueOf(r0.t));
        r4.put("av_session_type", Integer.valueOf(r0.s.getType()));
        return;
    L5:
        if (Intrinsics.areEqual(z0(), "assistant_scene_mode_click_talk") == true) goto L7;
        r4.put("dora_mode", z0());
        goto L7
    }

    public static void E0(String r3, String r4) {
        FLogger.a.w("DoraRealtimeCallTracer", "新架构dora上报时机等效实时通话，invoke event method " + r3 + " trans to " + r4);
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void B(IRealtimeCallTracer.TotalTimeType r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "type");
    }

    public final void D0(RealtimeCallParam r4, boolean r5) {
        final LinkedHashMap r0 = new LinkedHashMap();
        x0(r0);
        if (r4 == null) goto L7;
        String r1 = r4.e;
        if (r1 == null) goto L7;
        r0.put("task_id", r1);
    L7:
        r0.put("fail_type", "");
        if (r5 == false) goto L10;
        String r6 = "success";
    L11:
        r0.put("status", r6);
        r0.put("is_rtc", Boolean.valueOf(com.larus.im.service.audio.y0.e(r4.s)));
        DiaryImageSwitchManager.a.c(new n0(r0, this));
        return;
    L10:
        r6 = "failure";
        goto L11
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void H(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "txt");
        Intrinsics.checkNotNullParameter(r3, "serverParamJson");
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void O(String r2, RealtimeCallParam r3) {
        Intrinsics.checkNotNullParameter(r2, "endReason");
        this.s.O(r2, r3);
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void Q(IRealtimeCallTracer.HelloStatus r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "status");
        y0("reportHelloEvent");
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void T(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r2, "content");
    }

    @Override // com.larus.audio.call.tracer.c
    public final void X(String r6, RealtimeCallParam r7) {
        LinkedHashMap r0 = new LinkedHashMap();
        String r1 = null;
        if (r6 != null) goto L9;
        if (r7 == null) goto L8;
        RealtimeCallParam.p r8 = r7.o;
        if (r8 == null) goto L8;
        r6 = r8.h;
    L8:
        r6 = null;
    L9:
        r0.put("thru_method", z0());
        if (B0(r7) == false) goto L12;
        r0.put("thru_sec_method", "dora_natural_wakeup");
    L12:
        if (r6 == null) goto L14;
        r0.put("bot_id", r6);
    L14:
        if (r7 == null) goto L16;
        String r9 = r7.f;
    L18:
        if (com.larus.utils.o0.d(r9) == false) goto L21;
        r1 = r9;
    L21:
        if (r1 == null) goto L23;
        r0.put("wake_up_word", r1);
    L24:
        if (r7 == null) goto L30;
        RealtimeCallParam.k r10 = r7.p;
        if (r10 == null) goto L30;
        if (r10.w == null) goto L30;
        r0.put("thru_method", "dora_proactive");
    L30:
        IDoraService r11 = A0();
        if (r11 == null) goto L34;
        r11.A0("dora_wake_up", r0);
        return;
    L34:
        return;
    L23:
        r0.put("wake_up_word", "none");
        goto L24
    L16:
        r9 = null;
        goto L18
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void Z(RealtimeCallParam r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "params");
        this.s.Z(r2, r3);
    }

    @Override // com.larus.audio.call.tracer.c
    public final void a(String r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "comfortType");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("comfort_scene", r3);
        r0.put("total", Integer.valueOf(r4));
        AudioSessionType r5 = ((RealtimeCallParam) this.a.invoke()).s;
        r0.put("is_rtc", Integer.valueOf(com.larus.im.service.audio.y0.e(r5) ? 1 : 0));
        r0.put("av_session_type", Integer.valueOf(r5.getType()));
        if (Intrinsics.areEqual(((RealtimeCallParam) this.a.invoke()).k.o, "dora_si") == false) goto L5;
        r0.put("is_dora_si", 1);
    L6:
        x0(r0);
        IDoraService r6 = A0();
        if (r6 == null) goto L10;
        r6.A0("appease_play_duration", r0);
        return;
    L10:
        return;
    L5:
        r0.put("is_dora_si", 0);
        goto L6
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void l0(RealtimeCallParam r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r3, "botFromStatus");
        this.s.l0(r2, r3);
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void reportEvent(String r3, Map<String, Object> r4) {
        Intrinsics.checkNotNullParameter(r3, "event");
        Intrinsics.checkNotNullParameter(r4, "params");
        boolean r1 = true;
        if (BaseDoraLiteLiveAiPlugin.l == false) goto L5;
    L8:
        r4.put("is_live_ai", Boolean.valueOf(r1));
        IDoraService r0 = A0();
        if (r0 == null) goto L12;
        r0.A0(r3, r4);
        return;
    L12:
        return;
    L5:
        if (b98.b.b(1) == true) goto L8;
        r1 = false;
        goto L8
    }

    @Override // com.larus.audio.call.tracer.c
    public final void N(RealtimeCallParam r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "scene");
        Intrinsics.checkNotNullParameter(r5, "comfortType");
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("scene", r4);
        r1.put("comfortScene", r5);
        if (r3 == null) goto L9;
        RealtimeCallParam.p r6 = r3.o;
        if (r6 == null) goto L9;
        String r7 = r6.h;
        if (r7 == null) goto L9;
        r1.put("bot_id", r7);
    L9:
        if (r3 == null) goto L15;
        RealtimeCallParam.p r8 = r3.o;
        if (r8 == null) goto L15;
        String r9 = r8.c;
        if (r9 == null) goto L15;
        r1.put("conversation_id", r9);
    L15:
        if (r3 == null) goto L19;
        String r10 = r3.e;
        if (r10 == null) goto L19;
        r1.put("call_id", r10);
    L19:
        if (r3 == null) goto L25;
        RealtimeCallParam.h r11 = r3.k;
        if (r11 == null) goto L25;
        String r12 = r11.t;
        if (r12 == null) goto L25;
        r1.put("dora_mode", r12);
    L25:
        r1.put("trigger", "invoke_plugin");
        x0(r1);
        IDoraService r13 = A0();
        if (r13 == null) goto L29;
        r13.A0("latency_comfort", r1);
        return;
    }

    @Override // com.larus.audio.call.tracer.c
    public final void Y(final long r12, final long r14, final long r16) {
        FLogger.a.e("AudioTrackPerformance", "costTime " + r12 + ",costTtsResponseToPrepareTime：" + r14 + ",costPrepareToPlayTime: " + r16 + ' ');
        com.larus.utils.l0.b(new o0(r12, r14, r16, this));
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void a0(Flow<Integer> r2, CoroutineScope r3, RealtimeCallParam r4) {
        Intrinsics.checkNotNullParameter(r2, "callStateFlow");
        Intrinsics.checkNotNullParameter(r4, "params");
        this.s.a0(r2, r3, r4);
    }

    @Override // com.larus.audio.call.tracer.c
    public final void q0(String r4, boolean r5, String r6) {
        Intrinsics.checkNotNullParameter(r6, "result");
        LinkedHashMap r1 = new LinkedHashMap();
        if (r4 == null) goto L5;
        r1.put("question_id", r4);
    L5:
        r1.put("begin_is_playing", Boolean.valueOf(r5));
        r1.put("result", r6);
        IDoraService r7 = A0();
        if (r7 == null) goto L9;
        r7.A0("sv_result", r1);
        return;
    }

    public final Map<String, Object> w0(RealtimeCallParam r10, long r11, long r13) {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("scene", z0());
        Integer r1 = null;
        if (r10 == null) goto L5;
        String r3 = r10.f;
    L7:
        if (r3 != null) goto L9;
    L12:
        boolean r4 = true;
    L13:
        if (r4 == false) goto L26;
        if (r10 == null) goto L20;
        RealtimeCallParam.p r5 = r10.o;
        if (r5 == null) goto L20;
        String r6 = r5.h;
        if (r6 == null) goto L20;
        r0.put("bot_id", r6);
    L20:
        if (r10 == null) goto L26;
        RealtimeCallParam.p r7 = r10.o;
        if (r7 == null) goto L26;
        String r8 = r7.c;
        if (r8 == null) goto L26;
        r0.put("conversation_id", r8);
    L26:
        if (r10 == null) goto L30;
        String r9 = r10.e;
        if (r9 == null) goto L30;
        r0.put("call_id", r9);
    L30:
        if (r10 == null) goto L36;
        RealtimeCallParam.h r12 = r10.k;
        if (r12 == null) goto L36;
        String r14 = r12.t;
        if (r14 == null) goto L36;
        r0.put("dora_mode", r14);
    L36:
        r0.put("dora_conversation_type", z0());
        if (B0(r10) == false) goto L39;
        r0.put("dora_conversation_sec_type", "dora_natural_wakeup");
    L39:
        int r15 = ia8.n.a;
        if (r10 == null) goto L44;
        RealtimeCallParam.k r16 = r10.p;
        if (r16 == null) goto L44;
        String r17 = r16.x;
    L45:
        String r19 = ia8.n.a(r17);
        if (r19 == null) goto L48;
        r0.put("dora_proactive_type", r19);
    L48:
        if (r10 == null) goto L54;
        RealtimeCallParam.k r20 = r10.p;
        if (r20 == null) goto L54;
        String r21 = r20.y;
        if (r21 == null) goto L54;
        r0.put("dora_proactive_sub_type", r21);
    L54:
        r0.put("fail_type", "");
        r0.put("status", "success");
        if (r10 == null) goto L59;
        AudioSessionType r22 = r10.s;
        if (r22 == null) goto L59;
        r0.put("is_rtc", Integer.valueOf(com.larus.im.service.audio.y0.e(r22) ? 1 : 0));
        r0.put("av_session_type", Integer.valueOf(r22.getType()));
    L59:
        if (r10 == null) goto L67;
        RealtimeCallParam.j r23 = r10.n;
        if (r23 == null) goto L67;
        if (r23.e == false) goto L65;
        String r24 = GlobalAudioSceneEnum.VIDEO;
    L66:
        r0.put("trans_mode", r24);
        goto L67
    L65:
        r24 = "image";
    L67:
        if (r10 == null) goto L71;
        RealtimeCallParam.h r25 = r10.k;
        if (r25 == null) goto L71;
        String r26 = r25.o;
    L73:
        if (Intrinsics.areEqual(r26, "dora_si") == false) goto L75;
        r0.put("is_dora_si", 1);
    L76:
        r0.put("dora_message_mode", com.larus.avlink.plugins.y.a(r10));
        r0.put("start_session_exp_duration", Long.valueOf(r11));
        r0.put("start_session_duration", Long.valueOf(r13));
        if (r10 == null) goto L81;
        RealtimeCallParam.h r110 = r10.k;
        if (r110 == null) goto L81;
        r1 = Integer.valueOf(r110.s);
    L81:
        r0.put("dora_wakeup_mode", r1);
        x0(r0);
        if (r10 == null) goto L88;
        RealtimeCallParam.k r111 = r10.p;
        if (r111 == null) goto L88;
        String r112 = r111.w;
        if (r112 == null) goto L88;
        r0.put("dora_proactive_id", r112);
        r0.put("scene", "dora_proactive");
        r0.put("dora_conversation_type", "dora_proactive");
    L88:
        return r0;
    L75:
        r0.put("is_dora_si", 0);
    L71:
        r26 = null;
    L44:
        r17 = null;
        goto L45
    L9:
        if (r3.length() == 0) goto L12;
        r4 = false;
        goto L13
    L5:
        r3 = null;
        goto L7
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void y(String r2, RealtimeCallParam r3, ouc.d0 r4) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        Intrinsics.checkNotNullParameter(r3, "params");
        Intrinsics.checkNotNullParameter(r4, "extraParams");
        this.s.y(r2, r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [int] */
    /* JADX WARN: Type inference failed for: r3v5 */
    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void A(RealtimeCallParam r7, String r8, String r9, String r10) {
        Intrinsics.checkNotNullParameter(r7, "params");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("group_type", "private");
        r0.put("success", 1);
        ?? r3 = 0;
        if (r8 == null) goto L14;
        r0.put("message_id", r8);
        this.o = r8;
        Pair r5 = DoraETracer.a;
        if (r5 == null) goto L7;
        String r6 = (String) r5.getFirst();
    L9:
        if (Intrinsics.areEqual(r6, r8) == false) goto L14;
        Pair r11 = DoraETracer.a;
        if (r11 == null) goto L13;
        r3 = ((Boolean) r11.getSecond()).booleanValue();
    L13:
        r0.put("is_dora_exploration_active_message", Integer.valueOf(r3));
        goto L14
    L7:
        r6 = null;
    L14:
        if (r9 == null) goto L16;
        r0.put("agent_id", r9);
    L16:
        if (r10 == null) goto L18;
        r0.put("agent_intention", r10);
    L18:
        r0.put("conversation_id", r7.o.c);
        r0.put("bot_id", r7.o.h);
        Long r12 = StringsKt.toLongOrNull(r7.o.f);
        if (r12 == null) goto L21;
        r0.put("voice_id", Long.valueOf(r12.longValue()));
    L21:
        r0.put("speaker_name", r7.o.g);
        r0.put("speaker_id", r7.o.d);
        r0.put("current_page", r7.p.d);
        r0.put("previous_page", r7.p.b);
        int r13 = ia8.n.a;
        String r14 = ia8.n.a(r7.p.x);
        if (r14 == null) goto L24;
        r0.put("dora_proactive_type", r14);
    L24:
        String r15 = r7.p.y;
        if (r15 == null) goto L27;
        r0.put("dora_proactive_sub_type", r15);
    L27:
        r0.put("voice_type", "default");
        r0.put("type", "text");
        r0.put("is_tts_open", 1);
        r0.put("is_onboarding", 0);
        r0.put("is_soft_link", 0);
        r0.put("message_type", "text");
        r0.put("is_cache", -1);
        r0.put("use_nickname", "0");
        r0.put("is_baike_link", "0");
        if (Intrinsics.areEqual(r7.l.r, "1") == false) goto L37;
        String r16 = r7.p.k;
        if (Intrinsics.areEqual(r16, "dora_new_onboarding_voicewakeup_example") == false) goto L32;
    L35:
        r0.put("sec_scene", r16);
    L39:
        r0.put("dora_mode", r7.k.t);
        r0.put("dora_message_mode", com.larus.avlink.plugins.y.a(r7));
        x0(r0);
        String r17 = r7.p.w;
        if (r17 == null) goto L42;
        r0.put("dora_proactive_id", r17);
        r0.put("scene", "dora_proactive");
        int r19 = this.n + 1;
        this.n = r19;
        r0.put("dora_proactive_response_index", Integer.valueOf(r19));
    L43:
        IDoraService r20 = A0();
        if (r20 == null) goto L47;
        r20.A0("vui_receive_stream", r0);
        return;
    L47:
        return;
    L42:
        r0.put("scene", z0());
        goto L43
    L32:
        if (Intrinsics.areEqual(r16, "dora_new_onboarding_voicewakeup_continue") == true) goto L35;
        r0.put("sec_scene", "dora_onboarding");
        goto L39
    L37:
        if (B0(r7) == false) goto L39;
        r0.put("sec_scene", "dora_natural_wakeup");
        goto L39
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void e(String r1, String r2, String r3, String r4) {
        y0("reportSoothingSoundGenerateStart");
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void e0(String r1, String r2, RealtimeCallParam r3, e3a.a r4) {
        Intrinsics.checkNotNullParameter(r1, "enterMethod");
        Intrinsics.checkNotNullParameter(r3, "param");
        Intrinsics.checkNotNullParameter(r4, "argumentData");
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void g0(String r1, String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r1, "enterMethod");
        y0("reportMicPermissionEntranceShow");
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void h0(long r6, long r8, String r10, String r11) {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("reportCallMessageDisplayEvent, scene=");
        r1.append(z0());
        r1.append(", imTime=");
        r1.append(r6);
        r1.append(", vuiTime=");
        r1.append(r8);
        r1.append(", diff=");
        long r2 = r8 - r6;
        r1.append(r2);
        r0.i("DoraRealtimeCallTracer", r1.toString());
        if (r6 != 0) goto L5;
        return;
    L5:
        if (r8 == 0) goto L13;
        LinkedHashMap r3 = new LinkedHashMap();
        if (r10 == null) goto L10;
        r3.put("task_id", r10);
    L10:
        r3.put("dora_mode", r11);
        r3.put("scene", z0());
        r3.put("im_time", Long.valueOf(r6));
        r3.put("vui_time", Long.valueOf(r8));
        r3.put("duration", Long.valueOf(r2));
        reportEvent("realtime_call_message_display", r3);
        return;
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void k0(String r1, RealtimeCallParam r2, boolean r3, e3a.a r4) {
        Intrinsics.checkNotNullParameter(r2, "param");
        Intrinsics.checkNotNullParameter(r4, "argumentData");
    }

    public final Map<String, Object> v0(RealtimeCallParam r9, String r10, Integer r11, Integer r12) {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("scene", z0());
        if (r9 == null) goto L9;
        RealtimeCallParam.h r1 = r9.k;
        if (r1 == null) goto L9;
        String r2 = r1.t;
        if (r2 == null) goto L9;
        r0.put("dora_mode", r2);
    L9:
        String r3 = null;
        if (r9 == null) goto L12;
        String r4 = r9.f;
    L14:
        if (r4 != null) goto L16;
    L19:
        boolean r5 = true;
    L20:
        if (r5 == false) goto L33;
        if (r9 == null) goto L27;
        RealtimeCallParam.p r6 = r9.o;
        if (r6 == null) goto L27;
        String r7 = r6.h;
        if (r7 == null) goto L27;
        r0.put("bot_id", r7);
    L27:
        if (r9 == null) goto L33;
        RealtimeCallParam.p r8 = r9.o;
        if (r8 == null) goto L33;
        String r13 = r8.c;
        if (r13 == null) goto L33;
        r0.put("conversation_id", r13);
    L33:
        if (r9 == null) goto L37;
        String r14 = r9.e;
        if (r14 == null) goto L37;
        r0.put("call_id", r14);
    L37:
        r0.put("dora_conversation_type", z0());
        if (B0(r9) == false) goto L40;
        r0.put("dora_conversation_sec_type", "dora_natural_wakeup");
    L40:
        r0.put("fail_type", r10);
        if (r11 == null) goto L43;
        r0.put("error_code", Integer.valueOf(r11.intValue()));
    L43:
        if (r12 == null) goto L45;
        r0.put("session_status", Integer.valueOf(r12.intValue()));
    L45:
        int r15 = ia8.n.a;
        if (r9 == null) goto L50;
        RealtimeCallParam.k r16 = r9.p;
        if (r16 == null) goto L50;
        String r17 = r16.x;
    L51:
        String r19 = ia8.n.a(r17);
        if (r19 == null) goto L54;
        r0.put("dora_proactive_type", r19);
    L54:
        if (r9 == null) goto L60;
        RealtimeCallParam.k r110 = r9.p;
        if (r110 == null) goto L60;
        String r111 = r110.y;
        if (r111 == null) goto L60;
        r0.put("dora_proactive_sub_type", r111);
    L60:
        r0.put("status", "failure");
        if (r9 == null) goto L65;
        AudioSessionType r112 = r9.s;
        if (r112 == null) goto L65;
        r0.put("is_rtc", Integer.valueOf(com.larus.im.service.audio.y0.e(r112) ? 1 : 0));
        r0.put("av_session_type", Integer.valueOf(r112.getType()));
    L65:
        if (r9 == null) goto L70;
        RealtimeCallParam.h r113 = r9.k;
        if (r113 == null) goto L70;
        r3 = r113.o;
    L70:
        if (Intrinsics.areEqual(r3, "dora_si") == false) goto L72;
        r0.put("is_dora_si", 1);
    L73:
        r0.put("dora_message_mode", com.larus.avlink.plugins.y.a(r9));
        r0.put("start_session_exp_duration", -1L);
        r0.put("start_session_duration", -1L);
        x0(r0);
        if (r9 == null) goto L80;
        RealtimeCallParam.k r20 = r9.p;
        if (r20 == null) goto L80;
        String r21 = r20.w;
        if (r21 == null) goto L80;
        r0.put("dora_proactive_id", r21);
        r0.put("scene", "dora_proactive");
        r0.put("dora_conversation_type", "dora_proactive");
    L80:
        return r0;
    L72:
        r0.put("is_dora_si", 0);
    L50:
        r17 = null;
        goto L51
    L16:
        if (r4.length() == 0) goto L19;
        r5 = false;
        goto L20
    L12:
        r4 = null;
        goto L14
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void z(String r1, String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r1, "enterMethod");
        y0("reportMicPermissionEntranceClick");
    }

    public final void C0(int r15, String r16, long r17, RealtimeCallParam r19, JSONObject r20) {
        Intrinsics.checkNotNullParameter(r19, "params");
        Intrinsics.checkNotNullParameter(r20, "extraParams");
        BuildersKt.launch$default((CoroutineScope) this.t.getValue(), null, null, new DoraRealtimeCallTracer$reportDoraRealtimeCallError$1(this, r15, r16, r17, r19, r20, null), 3, null);
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void M(String r1, String r2, String r3, Long r4, String r5) {
        y0("reportSoothingSoundGenerateComplete");
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void P(RealtimeCallParam r21, Long r22, String r23, String r24, String r25) {
        Intrinsics.checkNotNullParameter(r21, "params");
        if (this.k == true) goto L5;
    L11:
        this.j = true;
        return;
    L5:
        if (this.d == (-1)) goto L11;
        this.k = false;
        System.currentTimeMillis();
        long r3 = System.currentTimeMillis();
        long r5 = this.g;
        long r7 = r3 - r5;
        long r4 = r5 - this.d;
        if (r23 == null) goto L9;
        JSONObject r10 = new JSONObject(r23);
    L10:
        FLogger.a.i("AudioTrackPerformance", "TTSResponse : appeasePlayDuration :" + r22);
        BuildersKt.launch$default((CoroutineScope) this.t.getValue(), null, null, new DoraRealtimeCallTracer$onTTSResponse$1(this, r21, r4, r7, r22, r25, r24, r10, null), 3, null);
        this.c = this.c + 1;
        goto L11
    L9:
        r10 = new JSONObject();
        goto L10
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void l(String r1, String r2, String r3, String r4, String r5) {
        y0("reportSoundGenerate");
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void j(RealtimeCallParam r7, boolean r8, IRealtimeCallTracer.EnterCallSessionStatus r9, long r10, long r12, boolean r14) {
        Intrinsics.checkNotNullParameter(r7, "params");
        Intrinsics.checkNotNullParameter(r9, "sessionStatus");
        if (r8 == false) goto L14;
        E0("onEnterCallStatus", "reportCallStartEvent");
        long r2 = System.currentTimeMillis() - r7.c;
        DoraImageMode.a r11 = DoraImageMode.Companion;
        Integer r13 = Integer.valueOf(r7.k.s);
        r11.getClass();
        if (DoraImageMode.a.a(r13) == false) goto L7;
        D0(r7, true);
        return;
    L7:
        FLogger.a.b("Dora call", "Dora call start", r7.e);
        Map<String, Object> r15 = w0(r7, r2, r12);
        IDoraService r16 = A0();
        if (r16 == null) goto L10;
        r16.A0("dora_conversation_start", r15);
    L10:
        IDoraService r17 = A0();
        if (r17 == null) goto L16;
        r17.A0("flow_dora_conversation_start", r15);
        return;
    L16:
        return;
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void p0(RealtimeCallParam r10, IRealtimeCallTracer.EnterCallSessionStatus r11, String r12, int r13, String r14, Boolean r15) {
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r14, "errorMsg");
        E0("reportFinishCall", "reportCallEndEvent");
        DoraImageMode.a r16 = DoraImageMode.Companion;
        Integer r0 = Integer.valueOf(r10.k.s);
        r16.getClass();
        boolean r17 = DoraImageMode.a.a(r0);
        Integer r1 = null;
        boolean r3 = true;
        if (r17 == false) goto L35;
        LinkedHashMap r19 = new LinkedHashMap();
        if (this.e <= 0) goto L137;
        r19.put("duration", Long.valueOf(System.currentTimeMillis() - this.e));
        String r110 = r10.e;
        if (r110 == null) goto L9;
        r19.put("task_id", r110);
    L9:
        com.larus.audio.call.o r111 = g98.d.a;
        String r112 = r10.e;
        if (r112 != null) goto L12;
    L15:
        if (r3 == false) goto L18;
        r112 = null;
    L18:
        if (r112 == null) goto L24;
        Object r113 = g98.d.g;
        monitor-enter(r113);
        r1 = (Integer) g98.d.f.remove(r112);     // Catch: Throwable -> L32
        monitor-exit(r113);
    L32:
        th = move-exception;
        throw th;
    L24:
        if (r1 == null) goto L26;
        r19.put("end_code", Integer.valueOf(r1.intValue()));
    L29:
        IDoraService r114 = A0();
        if (r114 == null) goto L138;
        r114.A0("dora_g_observation_end", r19);
        return;
    L138:
        return;
    L26:
        Integer r115 = r10.n.a;
        if (r115 == null) goto L29;
        r19.put("end_code", Integer.valueOf(r115.intValue()));
        goto L29
    L12:
        if (StringsKt.isBlank(r112) == true) goto L15;
        r3 = false;
        goto L15
    L137:
        return;
    L35:
        if (r11 == null) goto L37;
        int r116 = r11.getValue();
    L39:
        if (this.e <= 0) goto L140;
        LinkedHashMap r117 = new LinkedHashMap();
        long r5 = System.currentTimeMillis() - this.e;
        if (r15 == null) goto L43;
        r117.put("is_last_message_read", Integer.valueOf(r15.booleanValue() ? 1 : 0));
    L43:
        r117.put("error_code", Integer.valueOf(r13));
        r117.put("error_message", r14);
        r117.put("session_status", Integer.valueOf(r116));
        Intrinsics.checkNotNullParameter(r117, "otherParam");
        if (this.e <= 0) goto L141;
        FLogger.a.c("Dora call", "Dora call end", r10.e);
        Map<String, Object> r118 = new LinkedHashMap();
        r118.put("scene", z0());
        RealtimeCallParam.p r119 = r10.o;
        if (r119 == null) goto L50;
        Object r120 = r119.h;
        if (r120 == null) goto L50;
        r118.put("bot_id", r120);
    L50:
        RealtimeCallParam.p r121 = r10.o;
        if (r121 == null) goto L55;
        Object r122 = r121.c;
        if (r122 == null) goto L55;
        r118.put("conversation_id", r122);
    L55:
        Object r123 = r10.e;
        if (r123 == null) goto L58;
        r118.put("call_id", r123);
    L58:
        r118.put("dora_conversation_type", z0());
        if (B0(r10) == false) goto L61;
        r118.put("dora_conversation_sec_type", "dora_natural_wakeup");
    L61:
        RealtimeCallParam.h r124 = r10.k;
        if (r124 == null) goto L66;
        Object r125 = r124.t;
        if (r125 == null) goto L66;
        r118.put("dora_mode", r125);
    L66:
        int r126 = ia8.n.a;
        RealtimeCallParam.k r127 = r10.p;
        if (r127 == null) goto L69;
        String r128 = r127.x;
    L70:
        Object r129 = ia8.n.a(r128);
        if (r129 == null) goto L73;
        r118.put("dora_proactive_type", r129);
    L73:
        RealtimeCallParam.k r130 = r10.p;
        if (r130 == null) goto L78;
        Object r131 = r130.y;
        if (r131 == null) goto L78;
        r118.put("dora_proactive_sub_type", r131);
    L78:
        RealtimeCallParam.k r132 = r10.p;
        if (r132 == null) goto L83;
        RealtimeCallParam.DoraEndType r133 = r132.C;
        if (r133 == null) goto L83;
        r118.put("dora_end_type", r133.getType());
    L83:
        RealtimeCallParam.j r134 = r10.n;
        if (r134 == null) goto L88;
        Integer r135 = r134.a;
        if (r135 == null) goto L88;
        int r136 = r135.intValue();
        r118.put("end_code", Integer.valueOf(r136));
        DoraETracePlugin r7 = DoraETracePlugin.p;
        r118.put("unexpected", Integer.valueOf(DoraETracePlugin.a.b(Integer.valueOf(r136)) ? 1 : 0));
    L88:
        r118.put("question_cnt", Integer.valueOf(this.b));
        r118.put("answer_cnt", Integer.valueOf(this.c));
        r118.put("user_speaking_duration", Integer.valueOf((int) this.i));
        r118.put("duration", Integer.valueOf((int) r5));
        r118.put("message_id", this.o);
        AudioSessionType r137 = r10.s;
        if (r137 == null) goto L91;
        r118.put("is_rtc", Integer.valueOf(com.larus.im.service.audio.y0.e(r137) ? 1 : 0));
        r118.put("av_session_type", Integer.valueOf(r137.getType()));
    L91:
        RealtimeCallParam.h r138 = r10.k;
        if (r138 == null) goto L94;
        String r139 = r138.o;
    L96:
        if (Intrinsics.areEqual(r139, "dora_si") == false) goto L98;
        r118.put("is_dora_si", 1);
    L99:
        r118.put("dora_message_mode", com.larus.avlink.plugins.y.a(r10));
        x0(r118);
        RealtimeCallParam.k r140 = r10.p;
        if (r140 == null) goto L104;
        Object r141 = r140.w;
        if (r141 == null) goto L104;
        r118.put("dora_proactive_id", r141);
        r118.put("scene", "dora_proactive");
        r118.put("dora_conversation_type", "dora_proactive");
    L104:
        RealtimeCallParam.h r142 = r10.k;
        if (r142 == null) goto L107;
        r1 = Integer.valueOf(r142.s);
    L107:
        r118.put("dora_wakeup_mode", r1);
        Iterator r143 = r117.entrySet().iterator();
    L109:
        if (r143.hasNext() == false) goto L111;
        Map.Entry r144 = (Map.Entry) r143.next();
        r118.put((String) r144.getKey(), r144.getValue());
        goto L109
    L111:
        RealtimeCallParam.j r145 = r10.n;
        if (r145 != null) goto L114;
    L116:
        boolean r146 = false;
    L117:
        if (r146 == false) goto L130;
        IDoraService r147 = A0();
        if (r147 == null) goto L125;
        AbilityService r148 = r147.o0();
        if (r148 == null) goto L125;
        if (r148.k() != true) goto L125;
    L126:
        if (r3 == false) goto L128;
        int r149 = 2;
    L129:
        r118.put("trans_type", Integer.valueOf(r149));
        goto L130
    L128:
        r149 = 0;
    L125:
        r3 = false;
    L130:
        this.b = 0;
        this.c = 0;
        this.i = 0;
        IDoraService r150 = A0();
        if (r150 == null) goto L142;
        r150.A0("dora_conversation_end", r118);
        return;
    L142:
        return;
    L114:
        if (r145.e != true) goto L116;
        r146 = true;
        goto L117
    L98:
        r118.put("is_dora_si", 0);
        goto L99
    L94:
        r139 = null;
        goto L96
    L69:
        r128 = null;
        goto L70
    L141:
        return;
    L140:
        return;
    L37:
        r116 = 0;
        goto L39
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void L(RealtimeCallParam r1, int r2, String r3, String r4, Long r5, Long r6, String r7) {
        Intrinsics.checkNotNullParameter(r1, "params");
        y0("onInterpretStart");
    }

    @Override // com.larus.audio.call.tracer.c
    public final void b(String r3, String r4, String r5, String r6, String r7, String r8, String r9) {
        Intrinsics.checkNotNullParameter(r3, "startType");
        Intrinsics.checkNotNullParameter(r4, "taskId");
        Intrinsics.checkNotNullParameter(r5, "ownerInputLanguage");
        Intrinsics.checkNotNullParameter(r6, "ownerOutputLanguage");
        Intrinsics.checkNotNullParameter(r7, "guestInputLanguage");
        Intrinsics.checkNotNullParameter(r8, "guestOutputLanguage");
        Intrinsics.checkNotNullParameter(r9, "translateMode");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("start_type", r3);
        r0.put("task_id", r4);
        r0.put("owner_input_language", r5);
        r0.put("owner_output_language", r6);
        r0.put("guest_input_language", r7);
        r0.put("guest_output_language", r8);
        r0.put("translate_mode", r9);
        r0.put("mode_duration", 0L);
        IDoraService r10 = A0();
        if (r10 == null) goto L6;
        r10.A0("dora_interpretation_start", r0);
        return;
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void f(RealtimeCallParam r1, String r2, boolean r3, IRealtimeCallTracer.EnterCallSessionStatus r4, Integer r5, long r6, boolean r8) {
        Intrinsics.checkNotNullParameter(r1, "params");
        Intrinsics.checkNotNullParameter(r2, "reason");
        Intrinsics.checkNotNullParameter(r4, "sessionStatus");
        if (r3 == false) goto L17;
        E0("onEnterCallFailed", "reportCallStartFailedEvent");
        DoraImageMode.a r7 = DoraImageMode.Companion;
        Integer r9 = Integer.valueOf(r1.k.s);
        r7.getClass();
        if (DoraImageMode.a.a(r9) == false) goto L7;
        D0(r1, false);
        return;
    L7:
        Map<String, Object> r10 = v0(r1, r2, r5, Integer.valueOf(r4.getValue()));
        IDoraService r11 = A0();
        if (r11 == null) goto L10;
        r11.A0("dora_conversation_start", r10);
    L10:
        IDoraService r12 = A0();
        if (r12 == null) goto L13;
        r12.A0("flow_dora_conversation_start", r10);
    L13:
        Map<String, Object> r13 = v0(r1, r2, r5, Integer.valueOf(r4.getValue()));
        IDoraService r14 = A0();
        if (r14 == null) goto L19;
        r14.A0("flow_dora_session_start", r13);
        return;
    L19:
        return;
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void w(RealtimeCallParam r11, int r12, boolean r13, String r14, String r15, long r16, String r19) {
        Intrinsics.checkNotNullParameter(r11, "params");
        this.s.w(r11, r12, r13, r14, r15, r16, r19);
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void U(int r20, String r21, long r22, RealtimeCallParam r24, Boolean r25, int r26, String r27, String r29) {
        Intrinsics.checkNotNullParameter(r24, "params");
        BuildersKt.launch$default((CoroutineScope) this.t.getValue(), null, null, new DoraRealtimeCallTracer$onError$1(r24, this, r20, r21, r26, r27, r29, r22, true, r25, "call", null), 3, null);
    }

    @Override // com.larus.audio.call.tracer.c
    public final void V(String r4, Integer r5, String r6, Long r7, Long r8, Long r9, Long r10, Integer r11) {
        Intrinsics.checkNotNullParameter(r4, "scene");
        LinkedHashMap r1 = new LinkedHashMap();
        if (r5 == null) goto L5;
        r1.put("command", Integer.valueOf(r5.intValue()));
    L5:
        r1.put("scene", r4);
        if (r6 == null) goto L8;
        r1.put("msg_id", r6);
    L8:
        if (r7 == null) goto L10;
        r1.put("t1", Long.valueOf(r7.longValue()));
    L10:
        if (r8 == null) goto L12;
        r1.put("t2", Long.valueOf(r8.longValue()));
    L12:
        if (r9 == null) goto L14;
        r1.put("t3", Long.valueOf(r9.longValue()));
    L14:
        if (r10 == null) goto L16;
        r1.put("duration", Long.valueOf(r10.longValue()));
    L16:
        if (r11 == null) goto L18;
        r1.put("err_code", Integer.valueOf(r11.intValue()));
    L18:
        IDoraService r12 = A0();
        if (r12 == null) goto L22;
        r12.A0("dora_command_send", r1);
        return;
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void r0(int r4, int r5, int r6, int r7, int r8, int r9, int r10, int r11) {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("task_id", ((RealtimeCallParam) this.a.invoke()).l.a);
        r0.put("success", Boolean.TRUE);
        r0.put("im_asr_message_num", Integer.valueOf(r4));
        r0.put("im_tts_message_num", Integer.valueOf(r5));
        r0.put("im_tts_query_message_num", Integer.valueOf(r6));
        r0.put("im_pull_asr_message_num", Integer.valueOf(r7));
        r0.put("im_pull_tts_message_num", Integer.valueOf(r8));
        r0.put("vui_asr_message_num", Integer.valueOf(r9));
        r0.put("vui_tts_message_num", Integer.valueOf(r10));
        r0.put("vui_chat_message_num", Integer.valueOf(r11));
        r0.put("scene", z0());
        r0.put("dora_mode", ((RealtimeCallParam) this.a.invoke()).k.t);
        IDoraService r12 = A0();
        if (r12 == null) goto L6;
        r12.A0("realtime_call_message_on_screen", r0);
        return;
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void o(String r4, long r5, boolean r7, boolean r8, boolean r9, long r10, long r12, String r14, String r15) {
        Intrinsics.checkNotNullParameter(r4, "audioRoute");
        FLogger.a.i("DoraRealtimeCallTracer", "reportCallTtsPlayEvent, scene=" + z0() + ", audioRoute=" + r4 + ", firstTtsDuration=" + r5 + ", isFinish=" + r7 + ", isTtsEnd=" + r8);
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("task_id", ((RealtimeCallParam) this.a.invoke()).l.a);
        r0.put("scene", z0());
        r0.put("current_route", r4);
        r0.put("first_tts_duration", Long.valueOf(r5));
        r0.put("is_finish", Boolean.valueOf(r7));
        r0.put("is_tts_end", Boolean.valueOf(r8));
        r0.put("is_pacify", Boolean.valueOf(r9));
        r0.put("dora_mode", ((RealtimeCallParam) this.a.invoke()).k.t);
        AudioSessionType r6 = ((RealtimeCallParam) this.a.invoke()).s;
        r0.put("is_rtc", Integer.valueOf(com.larus.im.service.audio.y0.e(r6) ? 1 : 0));
        r0.put("av_session_type", Integer.valueOf(r6.getType()));
        r0.put("is_rtc", Integer.valueOf(com.larus.im.service.audio.y0.e(((RealtimeCallParam) this.a.invoke()).s) ? 1 : 0));
        if (Intrinsics.areEqual(((RealtimeCallParam) this.a.invoke()).k.o, "dora_si") == false) goto L5;
        r0.put("is_dora_si", 1);
    L6:
        r0.put("answer_start_time", Long.valueOf(r10));
        r0.put("answer_end_time", Long.valueOf(r12));
        r0.put("answer_type", r15);
        r0.put("call_round", r14);
        reportEvent("realtime_call_tts_play", r0);
        return;
    L5:
        r0.put("is_dora_si", 0);
        goto L6
    }

    @Override // com.larus.audio.call.tracer.c
    public final void u(String r3, String r4, long r5, String r7, String r8, String r9, String r10, String r11, long r12) {
        Intrinsics.checkNotNullParameter(r3, "endType");
        Intrinsics.checkNotNullParameter(r4, "taskId");
        Intrinsics.checkNotNullParameter(r7, "ownerInputLanguage");
        Intrinsics.checkNotNullParameter(r8, "ownerOutputLanguage");
        Intrinsics.checkNotNullParameter(r9, "guestInputLanguage");
        Intrinsics.checkNotNullParameter(r10, "guestOutputLanguage");
        Intrinsics.checkNotNullParameter(r11, "translateMode");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("end_type", r3);
        r0.put("task_id", r4);
        r0.put("duration", Long.valueOf(r5));
        r0.put("owner_input_language", r7);
        r0.put("owner_output_language", r8);
        r0.put("guest_input_language", r9);
        r0.put("guest_output_language", r10);
        r0.put("translate_mode", r11);
        r0.put("mode_duration", Long.valueOf(r12));
        IDoraService r6 = A0();
        if (r6 == null) goto L6;
        r6.A0("dora_interpretation_end", r0);
        return;
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void d0(final RealtimeCallParam r11, final int r12, final long r13, long r15, final boolean r17, String r19, final String r110, String r20, Long r21, Long r22, String r23) {
        Intrinsics.checkNotNullParameter(r11, "params");
        this.d = System.currentTimeMillis();
        com.larus.utils.l0.b(new t0(r110, r13, r11, r17, this, r12));
    }
}
