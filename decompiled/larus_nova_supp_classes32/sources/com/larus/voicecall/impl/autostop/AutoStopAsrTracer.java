package com.larus.voicecall.impl.autostop;

import com.larus.audio.call.RealtimeCallParam;
import com.larus.audio.call.tracer.IRealtimeCallTracer;
import com.larus.im.bean.bot.SceneModel;
import com.larus.voicecall.impl.tracer.RealtimeCallTracer;
import com.larus.voicecall.impl.tracer.RealtimeCallTracerReporterKt;
import com.larus.voicecall.impl.util.RealtimeCallUtil;
import com.lynx.jsbridge.LynxAccessibilityModule;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.NameKeys;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.flow.Flow;
import org.json.JSONObject;
import ouc.d0;
import tx9.a1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class AutoStopAsrTracer implements IRealtimeCallTracer {
    public final /* synthetic */ com.larus.audio.call.e a;
    public final Function0<RealtimeCallParam> b;
    public final RealtimeCallTracer c;

    public static final class a {
    }

    static {
    }

    public final void D(boolean r1) {
        this.a.getClass();
    }

    public final void E() {
        this.a.getClass();
    }

    public final void F(boolean r1) {
        this.a.getClass();
    }

    public final void G(boolean r1) {
        this.a.getClass();
    }

    public final void I() {
        this.a.getClass();
    }

    public final void J(int r1, String r2, int r3) {
        this.a.getClass();
    }

    public final void M(String r1, String r2, String r3, Long r4, String r5) {
        this.a.getClass();
    }

    public final void N(RealtimeCallParam r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "scene");
        Intrinsics.checkNotNullParameter(r4, "comfortType");
        this.a.N(r2, r3, r4);
    }

    public final void S() {
        this.a.getClass();
    }

    public final void W() {
        this.a.getClass();
    }

    public final void X(String r1, RealtimeCallParam r2) {
        this.a.getClass();
    }

    public final void Y(long r1, long r3, long r5) {
        this.a.getClass();
    }

    public final void a0(Flow<Integer> r2, CoroutineScope r3, RealtimeCallParam r4) {
        Intrinsics.checkNotNullParameter(r2, "callStateFlow");
        Intrinsics.checkNotNullParameter(r4, LynxResourceModule.PARAMS_KEY);
        this.a.a0(r2, r3, r4);
    }

    public final void b(String r10, String r11, String r12, String r13, String r14, String r15, String r16) {
        Intrinsics.checkNotNullParameter(r10, "startType");
        Intrinsics.checkNotNullParameter(r11, "taskId");
        Intrinsics.checkNotNullParameter(r12, "ownerInputLanguage");
        Intrinsics.checkNotNullParameter(r13, "ownerOutputLanguage");
        Intrinsics.checkNotNullParameter(r14, "guestInputLanguage");
        Intrinsics.checkNotNullParameter(r15, "guestOutputLanguage");
        Intrinsics.checkNotNullParameter(r16, "translateMode");
        this.a.b(r10, r11, r12, r13, r14, r15, r16);
    }

    public final void c() {
        this.a.getClass();
    }

    public final void c0(long r1) {
        this.a.getClass();
    }

    public final void e(String r1, String r2, String r3, String r4) {
        this.a.getClass();
    }

    public final void f0(boolean r1) {
        this.a.getClass();
    }

    public final void g() {
        this.a.getClass();
    }

    public final void h0(long r1, long r3, String r5, String r6) {
        this.a.getClass();
    }

    public final void i0() {
        this.a.getClass();
    }

    public final void j0(boolean r1) {
        this.a.getClass();
    }

    public final void k(long r1) {
        this.a.getClass();
    }

    public final void l(String r1, String r2, String r3, String r4, String r5) {
        this.a.getClass();
    }

    public final void l0(RealtimeCallParam r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r3, "botFromStatus");
        this.a.l0(r2, r3);
    }

    public final void m0(String r1) {
        this.a.getClass();
    }

    public final void n0() {
        this.a.getClass();
    }

    public final void o0() {
        this.a.getClass();
    }

    public final void onSessionStarted() {
        this.a.getClass();
    }

    public final void p0(RealtimeCallParam r9, IRealtimeCallTracer.EnterCallSessionStatus r10, String r11, int r12, String r13, Boolean r14) {
        Intrinsics.checkNotNullParameter(r9, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r13, "errorMsg");
        this.a.p0(r9, r10, r11, r12, r13, r14);
    }

    public final void q(boolean r1, long r2) {
        this.a.getClass();
    }

    public final void r() {
        this.a.getClass();
    }

    public final void r0(int r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8) {
        this.a.getClass();
    }

    public final void s0() {
        this.a.getClass();
    }

    public final void t() {
        this.a.getClass();
    }

    public final void t0() {
        this.a.getClass();
    }

    public final void u(String r14, String r15, long r16, String r18, String r19, String r20, String r21, String r22, long r23) {
        Intrinsics.checkNotNullParameter(r14, "endType");
        Intrinsics.checkNotNullParameter(r15, "taskId");
        Intrinsics.checkNotNullParameter(r18, "ownerInputLanguage");
        Intrinsics.checkNotNullParameter(r19, "ownerOutputLanguage");
        Intrinsics.checkNotNullParameter(r20, "guestInputLanguage");
        Intrinsics.checkNotNullParameter(r21, "guestOutputLanguage");
        Intrinsics.checkNotNullParameter(r22, "translateMode");
        this.a.u(r14, r15, r16, r18, r19, r20, r21, r22, r23);
    }

    public final void u0() {
        this.a.getClass();
    }

    public final void y(String r2, RealtimeCallParam r3, d0 r4) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        Intrinsics.checkNotNullParameter(r3, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r4, "extraParams");
        this.a.y(r2, r3, r4);
    }

    public final boolean R() {
        return this.a.a;
    }

    public AutoStopAsrTracer(c r4) {
        Intrinsics.checkNotNullParameter(r4, "callParam");
        this.a = new com.larus.audio.call.e("auto_stop_asr");
        this.b = r4;
        int r1 = RealtimeCallTracer.s0;
        Intrinsics.checkNotNullParameter(r4, "callParam");
        this.c = new RealtimeCallTracer(r4);
    }

    public final void C(RealtimeCallParam r3) {
        Intrinsics.checkNotNullParameter(r3, LynxResourceModule.PARAMS_KEY);
        this.a.getClass();
        Intrinsics.checkNotNullParameter(r3, LynxResourceModule.PARAMS_KEY);
    }

    public final void K(Map<String, ? extends Object> r3) {
        Intrinsics.checkNotNullParameter(r3, "serverInfo");
        this.a.getClass();
        Intrinsics.checkNotNullParameter(r3, "serverInfo");
    }

    public final void b0(RealtimeCallParam r3) {
        Intrinsics.checkNotNullParameter(r3, LynxResourceModule.PARAMS_KEY);
        this.a.getClass();
        Intrinsics.checkNotNullParameter(r3, LynxResourceModule.PARAMS_KEY);
    }

    public final void d(com.larus.audio.call.play.h.a r3) {
        Intrinsics.checkNotNullParameter(r3, LynxResourceModule.DATA_KEY);
        this.a.getClass();
        Intrinsics.checkNotNullParameter(r3, LynxResourceModule.DATA_KEY);
    }

    public final void h(jd9.c r3) {
        Intrinsics.checkNotNullParameter(r3, "state");
        this.a.getClass();
        Intrinsics.checkNotNullParameter(r3, "state");
    }

    public final void i(byte[] r3) {
        Intrinsics.checkNotNullParameter(r3, LynxResourceModule.AUDIO_TYPE);
        this.a.getClass();
        Intrinsics.checkNotNullParameter(r3, LynxResourceModule.AUDIO_TYPE);
    }

    public final void p(String r3) {
        Intrinsics.checkNotNullParameter(r3, "taskId");
        this.a.getClass();
        Intrinsics.checkNotNullParameter(r3, "taskId");
    }

    public final void s(String r3) {
        Intrinsics.checkNotNullParameter(r3, "text");
        this.a.getClass();
        Intrinsics.checkNotNullParameter(r3, "text");
    }

    public final void v(boolean r2) {
        this.a.a = r2;
    }

    public final d0 x(d0 r3) {
        Intrinsics.checkNotNullParameter(r3, "jsonObject");
        this.a.getClass();
        Intrinsics.checkNotNullParameter(r3, "jsonObject");
        return r3;
    }

    public final void B(IRealtimeCallTracer.TotalTimeType r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "type");
        this.a.getClass();
        Intrinsics.checkNotNullParameter(r2, "type");
    }

    public final void H(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "txt");
        Intrinsics.checkNotNullParameter(r5, "serverParamJson");
        this.a.getClass();
        Intrinsics.checkNotNullParameter(r4, "txt");
        Intrinsics.checkNotNullParameter(r5, "serverParamJson");
    }

    public final void O(String r2, RealtimeCallParam r3) {
        Intrinsics.checkNotNullParameter(r2, "endReason");
        this.a.getClass();
        Intrinsics.checkNotNullParameter(r2, "endReason");
    }

    public final void Q(IRealtimeCallTracer.HelloStatus r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "status");
        this.a.getClass();
        Intrinsics.checkNotNullParameter(r2, "status");
    }

    public final void T(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, LynxAccessibilityModule.MSG_CONTENT);
        this.a.getClass();
        Intrinsics.checkNotNullParameter(r3, LynxAccessibilityModule.MSG_CONTENT);
    }

    public final void Z(RealtimeCallParam r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, LynxResourceModule.PARAMS_KEY);
        this.a.getClass();
        Intrinsics.checkNotNullParameter(r2, LynxResourceModule.PARAMS_KEY);
    }

    public final void a(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "comfortType");
        this.a.getClass();
        Intrinsics.checkNotNullParameter(r2, "comfortType");
    }

    public final void m(RealtimeCallParam r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, LynxResourceModule.PARAMS_KEY);
        this.a.getClass();
        Intrinsics.checkNotNullParameter(r2, LynxResourceModule.PARAMS_KEY);
    }

    public final void n(RealtimeCallParam r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, LynxResourceModule.PARAMS_KEY);
        this.a.getClass();
        Intrinsics.checkNotNullParameter(r2, LynxResourceModule.PARAMS_KEY);
    }

    public final void reportEvent(String r2, Map<String, Object> r3) {
        Intrinsics.checkNotNullParameter(r2, "event");
        Intrinsics.checkNotNullParameter(r3, LynxResourceModule.PARAMS_KEY);
        if (Intrinsics.areEqual(r2, "flow_vui_exp_response") == false) goto L6;
        this.c.reportEvent(r2, r3);
        return;
    }

    public final void q0(String r1, boolean r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "result");
        this.a.getClass();
        Intrinsics.checkNotNullParameter(r3, "result");
    }

    public final void A(RealtimeCallParam r1, String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r1, LynxResourceModule.PARAMS_KEY);
        this.a.getClass();
        Intrinsics.checkNotNullParameter(r1, LynxResourceModule.PARAMS_KEY);
    }

    public final void e0(String r4, String r5, RealtimeCallParam r6, e3a.a r7) {
        Intrinsics.checkNotNullParameter(r4, "enterMethod");
        Intrinsics.checkNotNullParameter(r6, "param");
        Intrinsics.checkNotNullParameter(r7, "argumentData");
        this.a.getClass();
        Intrinsics.checkNotNullParameter(r4, "enterMethod");
        Intrinsics.checkNotNullParameter(r6, "param");
        Intrinsics.checkNotNullParameter(r7, "argumentData");
    }

    public final void g0(String r1, String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r1, "enterMethod");
        this.a.getClass();
        Intrinsics.checkNotNullParameter(r1, "enterMethod");
    }

    public final void k0(String r2, RealtimeCallParam r3, boolean r4, e3a.a r5) {
        Intrinsics.checkNotNullParameter(r3, "param");
        Intrinsics.checkNotNullParameter(r5, "argumentData");
        this.a.getClass();
        Intrinsics.checkNotNullParameter(r3, "param");
        Intrinsics.checkNotNullParameter(r5, "argumentData");
    }

    public final void z(String r1, String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r1, "enterMethod");
        this.a.getClass();
        Intrinsics.checkNotNullParameter(r1, "enterMethod");
    }

    public final void P(RealtimeCallParam r1, Long r2, String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r1, LynxResourceModule.PARAMS_KEY);
        this.a.getClass();
        Intrinsics.checkNotNullParameter(r1, LynxResourceModule.PARAMS_KEY);
    }

    public final void j(RealtimeCallParam r14, boolean r15, IRealtimeCallTracer.EnterCallSessionStatus r16, long r17, long r19, boolean r21) {
        Intrinsics.checkNotNullParameter(r14, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r16, "sessionStatus");
        if (r15 == true) goto L5;
        return;
    L5:
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new AutoStopAsrTracer$onEnterCallStatus$1(this, r14, r16, r19, r17, null), 2, null);
    }

    public final void L(RealtimeCallParam r1, int r2, String r3, String r4, Long r5, Long r6, String r7) {
        Intrinsics.checkNotNullParameter(r1, LynxResourceModule.PARAMS_KEY);
        this.a.getClass();
        Intrinsics.checkNotNullParameter(r1, LynxResourceModule.PARAMS_KEY);
    }

    public final void f(RealtimeCallParam r12, String r13, boolean r14, IRealtimeCallTracer.EnterCallSessionStatus r15, Integer r16, long r17, boolean r19) {
        Intrinsics.checkNotNullParameter(r12, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r13, "reason");
        Intrinsics.checkNotNullParameter(r15, "sessionStatus");
        if (r14 == true) goto L5;
        return;
    L5:
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new AutoStopAsrTracer$onEnterCallFailed$1(this, r12, r15, r13, r16, null), 2, null);
    }

    public final void w(RealtimeCallParam r1, int r2, boolean r3, String r4, String r5, long r6, String r8) {
        Intrinsics.checkNotNullParameter(r1, LynxResourceModule.PARAMS_KEY);
        this.a.getClass();
        Intrinsics.checkNotNullParameter(r1, LynxResourceModule.PARAMS_KEY);
    }

    public final void U(int r1, String r2, long r3, RealtimeCallParam r5, Boolean r6, int r7, String r8, String r9) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.PARAMS_KEY);
        this.a.getClass();
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.PARAMS_KEY);
    }

    public final void V(String r1, Integer r2, String r3, Long r4, Long r5, Long r6, Long r7, Integer r8) {
        Intrinsics.checkNotNullParameter(r1, "scene");
        this.a.getClass();
        Intrinsics.checkNotNullParameter(r1, "scene");
        Intrinsics.checkNotNullParameter(r1, "scene");
    }

    public static void v0(AutoStopAsrTracer r26, RealtimeCallParam r27, IRealtimeCallTracer.EnterCallSessionStatus r28, long r29, String r31, String r32, Integer r33, Long r34, int r35) {
        if ((r35 & 16) == 0) goto L5;
        String r5 = NameKeys.UnloadStrategy_No_Strategy;
    L7:
        if ((r35 & 32) == 0) goto L9;
        Integer r13 = null;
    L11:
        if ((r35 & 64) == 0) goto L13;
        Long r24 = null;
    L14:
        RealtimeCallTracer r1 = r26.c;
        RealtimeCallParam r3 = (RealtimeCallParam) r1.b.invoke();
        JSONObject r15 = new JSONObject();
        RealtimeCallTracer.C0(r3, r15);
        r1.w0(r15);
        r1.v0(r15);
        RealtimeCallParam.c r2 = r27.p.o;
        if (r2 == null) goto L17;
        String r4 = r2.a;
    L18:
        r15.put("action_bar_item_id", r4);
        RealtimeCallParam.c r6 = r27.p.o;
        if (r6 == null) goto L21;
        String r7 = r6.d;
    L22:
        r15.put("action_bar_key", r7);
        RealtimeCallTracerReporterKt.a(r15, r27.r);
        String r8 = r27.o.h;
        String r9 = r27.e;
        String r10 = r27.l.c;
        int r11 = r28.getValue();
        String r14 = r27.w;
        RealtimeCallParam.p r12 = r27.o;
        String r16 = r12.f;
        String r17 = r12.d;
        String r18 = r12.g;
        RealtimeCallParam.k r19 = r27.p;
        String r20 = r19.i;
        String r21 = r19.d;
        boolean r22 = r19.q;
        if (r22 == false) goto L25;
    L28:
        String r110 = "1";
    L30:
        if (r27.b == false) goto L32;
        String r111 = "1";
    L33:
        if (r22 == false) goto L35;
        String r23 = null;
    L37:
        if (Intrinsics.areEqual(r31, "1") == false) goto L39;
        String r25 = r27.p.g;
    L40:
        RealtimeCallParam.c r0 = r27.p.o;
        if (r0 == null) goto L43;
        String r210 = r0.d;
    L44:
        if (r0 == null) goto L46;
        String r30 = r0.a;
    L47:
        RealtimeCallUtil.a.getClass();
        com.larus.voicecall.impl.scene.o r36 = RealtimeCallUtil.l;
        if (r36 == null) goto L52;
        SceneModel r37 = r36.a;
        if (r37 == null) goto L52;
        String r211 = r37.getKey();
    L53:
        a1.a(r8, r9, r10, r5, r31, Integer.valueOf(r11), r20, r21, r16, r17, r18, r13, r14, r15, Long.valueOf(r29), r110, r111, r23, r25, r210, r30, r211, r24, 526216);
        return;
    L52:
        r211 = null;
        goto L53
    L46:
        r30 = null;
        goto L47
    L43:
        r210 = null;
        goto L44
    L39:
        r25 = null;
        goto L40
    L35:
        r23 = r19.v;
        goto L37
    L32:
        r111 = "0";
        goto L33
    L25:
        if (r27.a == true) goto L28;
        r110 = "0";
        goto L30
    L21:
        r7 = null;
        goto L22
    L17:
        r4 = null;
        goto L18
    L13:
        r24 = r34;
        goto L14
    L9:
        r13 = r33;
        goto L11
    L5:
        r5 = r32;
        goto L7
    }

    public final void o(String r1, long r2, boolean r4, boolean r5, boolean r6, long r7, long r9, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r1, "audioRoute");
        this.a.getClass();
        Intrinsics.checkNotNullParameter(r1, "audioRoute");
    }

    public final void d0(RealtimeCallParam r1, int r2, long r3, long r5, boolean r7, String r8, String r9, String r10, Long r11, Long r12, String r13) {
        Intrinsics.checkNotNullParameter(r1, LynxResourceModule.PARAMS_KEY);
        this.a.getClass();
        Intrinsics.checkNotNullParameter(r1, LynxResourceModule.PARAMS_KEY);
    }
}
