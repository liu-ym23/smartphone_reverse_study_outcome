package com.larus.audio.call;

import com.larus.audio.call.tracer.IRealtimeCallTracer;
import java.util.Map;
import jd9.c;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import ouc.d0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class e implements IRealtimeCallTracer {
    public boolean a;

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void C(RealtimeCallParam r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void D(boolean r1) {
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void E() {
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void F(boolean r1) {
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
    public final void L(RealtimeCallParam r1, int r2, String r3, String r4, Long r5, Long r6, String r7) {
        Intrinsics.checkNotNullParameter(r1, "params");
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void M(String r1, String r2, String r3, Long r4, String r5) {
    }

    @Override // com.larus.audio.call.tracer.c
    public final void N(RealtimeCallParam r1, String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r3, "comfortType");
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void O(String r1, RealtimeCallParam r2) {
        Intrinsics.checkNotNullParameter(r1, "endReason");
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void P(RealtimeCallParam r1, Long r2, String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r1, "params");
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void Q(IRealtimeCallTracer.HelloStatus r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "status");
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void S() {
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void U(int r1, String r2, long r3, RealtimeCallParam r5, Boolean r6, int r7, String r8, String r9) {
        Intrinsics.checkNotNullParameter(r5, "params");
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void W() {
    }

    @Override // com.larus.audio.call.tracer.c
    public final void X(String r1, RealtimeCallParam r2) {
    }

    @Override // com.larus.audio.call.tracer.c
    public final void Y(long r1, long r3, long r5) {
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void Z(RealtimeCallParam r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "params");
    }

    @Override // com.larus.audio.call.tracer.c
    public final void a(String r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "comfortType");
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void a0(Flow<Integer> r1, CoroutineScope r2, RealtimeCallParam r3) {
        Intrinsics.checkNotNullParameter(r1, "callStateFlow");
        Intrinsics.checkNotNullParameter(r3, "params");
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void b0(RealtimeCallParam r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void c() {
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void c0(long r1) {
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void d0(RealtimeCallParam r1, int r2, long r3, long r5, boolean r7, String r8, String r9, String r10, Long r11, Long r12, String r13) {
        Intrinsics.checkNotNullParameter(r1, "params");
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void e(String r1, String r2, String r3, String r4) {
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void f(RealtimeCallParam r1, String r2, boolean r3, IRealtimeCallTracer.EnterCallSessionStatus r4, Integer r5, long r6, boolean r8) {
        Intrinsics.checkNotNullParameter(r1, "params");
        Intrinsics.checkNotNullParameter(r2, "reason");
        Intrinsics.checkNotNullParameter(r4, "sessionStatus");
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void f0(boolean r1) {
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void g() {
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void g0(String r1, String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r1, "enterMethod");
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void h0(long r1, long r3, String r5, String r6) {
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void i0() {
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void j(RealtimeCallParam r1, boolean r2, IRealtimeCallTracer.EnterCallSessionStatus r3, long r4, long r6, boolean r8) {
        Intrinsics.checkNotNullParameter(r1, "params");
        Intrinsics.checkNotNullParameter(r3, "sessionStatus");
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void j0(boolean r1) {
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void k(long r1) {
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void l(String r1, String r2, String r3, String r4, String r5) {
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void l0(RealtimeCallParam r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r3, "botFromStatus");
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
    public final void n0() {
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void o(String r1, long r2, boolean r4, boolean r5, boolean r6, long r7, long r9, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r1, "audioRoute");
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void o0() {
    }

    @Override // com.larus.audio.call.tracer.c
    public final void onSessionStarted() {
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void p0(RealtimeCallParam r1, IRealtimeCallTracer.EnterCallSessionStatus r2, String r3, int r4, String r5, Boolean r6) {
        Intrinsics.checkNotNullParameter(r1, "params");
        Intrinsics.checkNotNullParameter(r5, "errorMsg");
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void q(boolean r1, long r2) {
    }

    @Override // com.larus.audio.call.tracer.c
    public final void q0(String r1, boolean r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "result");
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void r() {
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void r0(int r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8) {
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void s0() {
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void t() {
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void t0() {
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void u0() {
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void w(RealtimeCallParam r1, int r2, boolean r3, String r4, String r5, long r6, String r8) {
        Intrinsics.checkNotNullParameter(r1, "params");
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final d0 x(d0 r2) {
        Intrinsics.checkNotNullParameter(r2, "jsonObject");
        return r2;
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void y(String r2, RealtimeCallParam r3, d0 r4) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        Intrinsics.checkNotNullParameter(r3, "params");
        Intrinsics.checkNotNullParameter(r4, "extraParams");
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void z(String r1, String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r1, "enterMethod");
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final boolean R() {
        return this.a;
    }

    public e(String r2) {
        Intrinsics.checkNotNullParameter(r2, "scene");
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void K(Map<String, ? extends Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "serverInfo");
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void d(com.larus.audio.call.play.h.a r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void h(c r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void i(byte[] r2) {
        Intrinsics.checkNotNullParameter(r2, "audio");
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
        this.a = r1;
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void B(IRealtimeCallTracer.TotalTimeType r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "type");
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void H(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "txt");
        Intrinsics.checkNotNullParameter(r3, "serverParamJson");
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void T(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r2, "content");
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void reportEvent(String r2, Map<String, Object> r3) {
        Intrinsics.checkNotNullParameter(r2, "event");
        Intrinsics.checkNotNullParameter(r3, "params");
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void A(RealtimeCallParam r1, String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r1, "params");
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void e0(String r1, String r2, RealtimeCallParam r3, e3a.a r4) {
        Intrinsics.checkNotNullParameter(r1, "enterMethod");
        Intrinsics.checkNotNullParameter(r3, "param");
        Intrinsics.checkNotNullParameter(r4, "argumentData");
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void k0(String r1, RealtimeCallParam r2, boolean r3, e3a.a r4) {
        Intrinsics.checkNotNullParameter(r2, "param");
        Intrinsics.checkNotNullParameter(r4, "argumentData");
    }

    @Override // com.larus.audio.call.tracer.c
    public final void b(String r2, String r3, String r4, String r5, String r6, String r7, String r8) {
        Intrinsics.checkNotNullParameter(r2, "startType");
        Intrinsics.checkNotNullParameter(r3, "taskId");
        Intrinsics.checkNotNullParameter(r4, "ownerInputLanguage");
        Intrinsics.checkNotNullParameter(r5, "ownerOutputLanguage");
        Intrinsics.checkNotNullParameter(r6, "guestInputLanguage");
        Intrinsics.checkNotNullParameter(r7, "guestOutputLanguage");
        Intrinsics.checkNotNullParameter(r8, "translateMode");
        com.larus.audio.call.tracer.c.a.c(r2, r3, r4, r5, r6, r7, r8);
    }

    @Override // com.larus.audio.call.tracer.c
    public final void V(String r1, Integer r2, String r3, Long r4, Long r5, Long r6, Long r7, Integer r8) {
        Intrinsics.checkNotNullParameter(r1, "scene");
        Intrinsics.checkNotNullParameter(r1, "scene");
    }

    @Override // com.larus.audio.call.tracer.c
    public final void u(String r9, String r10, long r11, String r13, String r14, String r15, String r16, String r17, long r19) {
        Intrinsics.checkNotNullParameter(r9, "endType");
        Intrinsics.checkNotNullParameter(r10, "taskId");
        Intrinsics.checkNotNullParameter(r13, "ownerInputLanguage");
        Intrinsics.checkNotNullParameter(r14, "ownerOutputLanguage");
        Intrinsics.checkNotNullParameter(r15, "guestInputLanguage");
        Intrinsics.checkNotNullParameter(r16, "guestOutputLanguage");
        Intrinsics.checkNotNullParameter(r17, "translateMode");
        com.larus.audio.call.tracer.c.a.b(r9, r10, r13, r14, r15, r16, r17);
    }
}
