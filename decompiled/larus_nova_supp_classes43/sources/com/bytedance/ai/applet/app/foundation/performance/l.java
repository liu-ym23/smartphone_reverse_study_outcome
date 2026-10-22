package com.bytedance.ai.applet.app.foundation.performance;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class l extends k {
    public final com.bytedance.ai.applet.base.log.d h;
    public final i i;
    public final String j;
    public o k;
    public Long l;
    public Long m;
    public Long n;
    public Long o;
    public boolean p;
    public Long q;
    public Long r;
    public Long s;
    public Long t;
    public Long u;

    public static final class a {
    }

    static {
    }

    public abstract void p(long r1);

    public final boolean j() {
        long r0 = System.currentTimeMillis();
        Object r10 = this.d;
        monitor-enter(r10);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (a(r0) == true) goto L7;
    L11:
        boolean r1 = false;
    L12:
        monitor-exit(r10);
        return r1;
    L7:
        if (this.n != null) goto L11;
        this.n = Long.valueOf(r0);     // Catch: Throwable -> L14
        r1 = true;
        goto L12
    }

    public final boolean k() {
        long r0 = System.currentTimeMillis();
        Object r10 = this.d;
        monitor-enter(r10);
        Long r11 = this.s;     // Catch: Throwable -> L17
        if (a(r0) == false) goto L14;
        if (r11 == null) goto L14;
        if (r0 < r11.longValue()) goto L14;
        if (this.t != null) goto L14;
        this.t = Long.valueOf(r0);     // Catch: Throwable -> L17
        boolean r1 = true;
    L15:
        monitor-exit(r10);
        return r1;
    L14:
        r1 = false;
    L17:
        th = move-exception;
        throw th;
    }

    public final boolean l() {
        long r0 = System.currentTimeMillis();
        Object r10 = this.d;
        monitor-enter(r10);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (a(r0) == true) goto L7;
    L11:
        boolean r1 = false;
    L12:
        monitor-exit(r10);
        return r1;
    L7:
        if (this.s != null) goto L11;
        this.s = Long.valueOf(r0);     // Catch: Throwable -> L14
        r1 = true;
        goto L12
    }

    public final boolean m() {
        long r0 = System.currentTimeMillis();
        Object r10 = this.d;
        monitor-enter(r10);
        Long r11 = this.q;     // Catch: Throwable -> L17
        if (a(r0) == false) goto L14;
        if (r11 == null) goto L14;
        if (r0 < r11.longValue()) goto L14;
        if (this.r != null) goto L14;
        this.r = Long.valueOf(r0);     // Catch: Throwable -> L17
        boolean r1 = true;
    L15:
        monitor-exit(r10);
        return r1;
    L14:
        r1 = false;
    L17:
        th = move-exception;
        throw th;
    }

    public final boolean n() {
        long r0 = System.currentTimeMillis();
        Object r10 = this.d;
        monitor-enter(r10);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (a(r0) == true) goto L7;
    L11:
        boolean r1 = false;
    L12:
        monitor-exit(r10);
        return r1;
    L7:
        if (this.q != null) goto L11;
        this.q = Long.valueOf(r0);     // Catch: Throwable -> L14
        r1 = true;
        goto L12
    }

    public long f() {
        return this.b;
    }

    public final void g(long r10) {
        Object r0 = this.d;
        monitor-enter(r0);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (a(r10) == true) goto L7;
    L11:
        f.d r1 = null;
    L12:
        monitor-exit(r0);
        q("markFirstContentfulPaint", r1);
        return;
    L7:
        if (this.m != null) goto L11;
        this.m = Long.valueOf(r10);     // Catch: Throwable -> L15
        r1 = new f.d(r10, this.i);     // Catch: Throwable -> L15
        goto L12
    }

    public final void h(long r10) {
        Object r0 = this.d;
        monitor-enter(r0);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (a(r10) == true) goto L7;
    L11:
        f.e r1 = null;
    L12:
        monitor-exit(r0);
        q("markFirstPaint", r1);
        return;
    L7:
        if (this.l != null) goto L11;
        this.l = Long.valueOf(r10);     // Catch: Throwable -> L15
        r1 = new f.e(r10, this.i);     // Catch: Throwable -> L15
        goto L12
    }

    public final boolean i(boolean r10) {
        long r0 = System.currentTimeMillis();
        Object r11 = this.d;
        monitor-enter(r11);
        Long r12 = this.n;     // Catch: Throwable -> L17
        if (a(r0) == false) goto L14;
        if (r12 == null) goto L14;
        if (r0 < r12.longValue()) goto L14;
        if (this.o != null) goto L14;
        this.o = Long.valueOf(r0);     // Catch: Throwable -> L17
        this.p = r10;     // Catch: Throwable -> L17
        boolean r13 = true;
    L15:
        monitor-exit(r11);
        return r13;
    L14:
        r13 = false;
    L17:
        th = move-exception;
        throw th;
    }

    public final void o(Map<String, ? extends Object> r13) {
        Intrinsics.checkNotNullParameter(r13, "timingInfo");
        Object r14 = r13.get("setup_timing");
        if ((r14 instanceof Map) == false) goto L5;
        Map r15 = (Map) r14;
    L6:
        if (r15 != null) goto L9;
        com.bytedance.ai.applet.base.log.d r0 = this.h;
        AtomicInteger r10 = com.bytedance.ai.applet.base.log.d.d;
        r0.a("onLynxRenderCompleted: setup_timing is missing or invalid", null);
        c(AppletPerformanceErrorCode.INVALID_RENDER_TIMING, "setup_timing is missing or invalid");
        return;
    L9:
        Long r1 = m.a(r15, "draw_end");
        if (r1 == null) goto L41;
        long r11 = r1.longValue();
        r(new o(f(), r11, m.a(r15, "lepus_excute_end"), m.a(r15, "create_vdom_start"), m.a(r15, "load_template_end")));
        h(r11);
        g(r11);
        Long r12 = m.a(r15, "load_app_start");
        if (r12 != null) goto L14;
        com.bytedance.ai.applet.base.log.d r16 = this.h;
        AtomicInteger r17 = com.bytedance.ai.applet.base.log.d.d;
        r16.a("onLynxRenderCompleted: load_app_start is missing or invalid", null);
    L14:
        Long r18 = m.a(r15, "load_app_end");
        if (r18 != null) goto L17;
        com.bytedance.ai.applet.base.log.d r19 = this.h;
        AtomicInteger r20 = com.bytedance.ai.applet.base.log.d.d;
        r19.a("onLynxRenderCompleted: load_app_end is missing or invalid", null);
    L17:
        if (r12 == null) goto L34;
        if (r18 == null) goto L34;
        Object r21 = this.d;
        monitor-enter(r21);
    L31:
        th = move-exception;
        throw th;
    L22:
        if (this.e == false) goto L24;
    L28:
        Unit r22 = Unit.INSTANCE;     // Catch: Throwable -> L31
        monitor-exit(r21);
        goto L34
    L24:
        if (r18.longValue() < r12.longValue()) goto L28;
        if (this.u != null) goto L28;
        this.u = Long.valueOf(r18.longValue() - r12.longValue());     // Catch: Throwable -> L31
    L34:
        String r23 = this.j;
        if (r12 == null) goto L39;
        if (r18 == null) goto L39;
        if (r23 == null) goto L39;
        s(new u(r12.longValue(), r18.longValue(), r23));
    L39:
        p(r11);
        return;
    L41:
        com.bytedance.ai.applet.base.log.d r24 = this.h;
        AtomicInteger r25 = com.bytedance.ai.applet.base.log.d.d;
        r24.a("onLynxRenderCompleted: draw_end is missing or invalid", null);
        c(AppletPerformanceErrorCode.INVALID_RENDER_TIMING, "draw_end is missing or invalid");
        return;
    L5:
        r15 = null;
        goto L6
    }

    public final void r(o r12) {
        Intrinsics.checkNotNullParameter(r12, "timing");
        Object r0 = this.d;
        monitor-enter(r0);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (this.e == false) goto L7;
    L13:
        f.C0016f r1 = null;
    L14:
        monitor-exit(r0);
        q("recordFirstRender", r1);
        return;
    L7:
        if (this.k != null) goto L13;
        if (r12.a(this.b) == false) goto L13;
        this.k = r12;     // Catch: Throwable -> L17
        long r10 = r12.a;     // Catch: Throwable -> L17
        r1 = new f.C0016f(r10, r12.b - r10, this.i, r12.c, r12.d, r12.e);     // Catch: Throwable -> L17
        goto L14
    }

    public final void s(u r11) {
        Intrinsics.checkNotNullParameter(r11, "timing");
        Object r0 = this.d;
        monitor-enter(r0);
    L22:
        th = move-exception;
        throw th;
    L5:
        if (this.e == true) goto L18;
        long r1 = this.b;     // Catch: Throwable -> L22
        long r10 = r11.a;     // Catch: Throwable -> L22
        if (r10 >= r1) goto L9;
    L13:
        boolean r12 = false;
    L14:
        if (r12 == false) goto L18;
        long r13 = r11.a;     // Catch: Throwable -> L22
        f.c r14 = new f.c(r13, r11.b - r13, this.i, r11.c);     // Catch: Throwable -> L22
    L19:
        monitor-exit(r0);
        q("recordScriptEvaluation", r14);
        return;
    L9:
        if (r11.b < r10) goto L13;
        r12 = true;
        if ((!StringsKt.isBlank(r11.c)) == false) goto L13;
    L18:
        r14 = null;
        goto L19
    }

    public static Long e(Long r10, Long r11) {
        if (r10 == null) goto L7;
        if (r11 == null) goto L7;
        if (r11.longValue() < r10.longValue()) goto L7;
        return Long.valueOf(r11.longValue() - r10.longValue());
    L7:
        return null;
    }

    public final boolean q(String r10, f r11) {
        if (r11 != null) goto L5;
        c r12 = this.a;
        String r0 = "invalid, duplicate, or closed trace: " + this.c;
        r12.getClass();
        c.k(r10, r0);
        return false;
    L5:
        this.a.j(r11);
        return true;
    }

    public l(c r10, long r11, Function1<? super Long, ? extends i> r12) {
        Intrinsics.checkNotNullParameter(r10, "owner");
        Intrinsics.checkNotNullParameter(r12, "sourceFactory");
        super(r10, r11);
        this.h = new com.bytedance.ai.applet.base.log.d("BaseRenderPerformanceTracker", String.valueOf(this.c));
        i r13 = (i) r12.invoke(Long.valueOf(this.c));
        this.i = r13;
        String r14 = null;
        if ((r13 instanceof g.a) == false) goto L5;
        g.a r15 = (g.a) r13;
    L6:
        if (r15 == null) goto L8;
        r14 = r15.b;
    L8:
        this.j = r14;
        return;
    L5:
        r15 = null;
        goto L6
    }
}
