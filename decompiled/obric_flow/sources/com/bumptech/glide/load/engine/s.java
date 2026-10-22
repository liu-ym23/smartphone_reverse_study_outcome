package com.bumptech.glide.load.engine;

import ai.j0;
import android.os.SystemClock;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.util.CachedHashCodeArrayMap;
import java.util.HashMap;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class s {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final boolean f1557h = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final jg.k f1558a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s6.b f1559b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b0.d f1560c;
    public final q d;
    public final h0 e;
    public final o f;
    public final ja.d g;

    static {
        f1557h = Log.isLoggable("Engine", 2);
    }

    public s(b0.d r10, sj.k r11, c0.b r12, c0.b r13, c0.b r14, c0.b r15) {
        this.f1560c = r10;
        r r5 = new r(r11);
        ja.d r16 = new ja.d(1);
        this.g = r16;
        monitor-enter(this);
        monitor-enter(r16);     // Catch: Throwable -> L10
        r16.d = this;     // Catch: Throwable -> L12
        monitor-exit(r16);     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L10
        this.f1559b = new s6.b(2);
        this.f1558a = new jg.k(2);
        this.d = new q(r12, r13, r14, r15, this, this);
        this.f = new o(r5);
        this.e = new h0();
        r10.d = this;
        return;
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public static void c(String r5, long r10, x r11) {
        StringBuilder r12 = j0.w(r5, " in ");
        r12.append(q0.f.a(r10));
        r12.append("ms, key: ");
        r12.append(r11);
        Log.v("Engine", r12.toString());
    }

    public static void f(d0 r5) {
        if ((r5 instanceof y) == false) goto L7;
        ((y) r5).d();
        return;
    L7:
        throw new IllegalArgumentException("Cannot release anything but an EngineResource");
    }

    public final com.google.common.reflect.w a(com.bumptech.glide.c r23, Object r24, z.c r25, int r26, int r27, Class r28, Class r29, Priority r30, m r31, CachedHashCodeArrayMap r32, boolean r33, boolean r34, z.f r35, boolean r36, boolean r37, com.bumptech.glide.request.d r38, ai.y r39) {
        if (f1557h == false) goto L6;
        int r5 = q0.f.f21454b;
        long r10 = SystemClock.elapsedRealtimeNanos();
    L5:
        long r13 = r10;
        this.f1559b.getClass();
        x r11 = new x(r24, r25, r26, r27, r32, r28, r29, r35);
        monitor-enter(this);
        y r12 = b(r11, r36, r13);     // Catch: Throwable -> L15
        if (r12 != null) goto L17;
        com.google.common.reflect.w r14 = g(r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r11, r13);     // Catch: Throwable -> L15
        monitor-exit(this);     // Catch: Throwable -> L15
        return r14;
    L17:
        monitor-exit(this);     // Catch: Throwable -> L15
        r38.j(r12, DataSource.MEMORY_CACHE);
        return null;
    L15:
        th = move-exception;
        throw th;
    L6:
        r10 = 0;
        goto L5
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final y b(x r10, boolean r11, long r12) {
        if (r11 == true) goto L5;
        return null;
    L5:
        ja.d r13 = this.g;
        monitor-enter(r13);
        b r5 = (b) ((HashMap) r13.f18302b).get(r10);     // Catch: Throwable -> L15
        if (r5 != null) goto L11;
        monitor-exit(r13);
        y r14 = null;
    L18:
        if (r14 == null) goto L20;
        r14.b();
    L20:
        if (r14 != null) goto L22;
        b0.d r15 = this.f1560c;
        monitor-enter(r15);
        Object r16 = ((LinkedHashMap) r15.f9667c).remove(r10);     // Catch: Throwable -> L31
        if (r16 == null) goto L33;
        r15.f9666b -= (long) r15.b(r16);     // Catch: Throwable -> L31
    L33:
        monitor-exit(r15);
        d0 r17 = (d0) r16;
        if (r17 != null) goto L38;
        y r18 = null;
    L41:
        if (r18 == null) goto L43;
        r18.b();
        this.g.f(r10, r18);
    L43:
        if (r18 != null) goto L45;
        return null;
    L45:
        if (f1557h == false) goto L47;
        c("Loaded resource from cache", r12, r10);
    L47:
        return r18;
    L38:
        if ((r17 instanceof y) == false) goto L40;
        r18 = (y) r17;
        goto L41
    L40:
        r18 = new y(r17, true, true, r10, this);
    L31:
        th = move-exception;
        throw th;
    L22:
        if (f1557h == false) goto L24;
        c("Loaded resource from active resources", r12, r10);
    L24:
        return r14;
    L11:
        r14 = (y) r5.get();     // Catch: Throwable -> L15
        if (r14 != null) goto L17;
        r13.g(r5);     // Catch: Throwable -> L15
    L17:
        monitor-exit(r13);
    L15:
        th = move-exception;
        throw th;
    }

    public final synchronized void d(w r5, x r10, y r11) {
        monitor-enter(this);
        if (r11 != null) goto L16;
    L9:
        jg.k r12 = this.f1558a;     // Catch: Throwable -> L7
        r12.getClass();     // Catch: Throwable -> L7
        r5.getClass();     // Catch: Throwable -> L7
        HashMap r13 = (HashMap) r12.f18339b;     // Catch: Throwable -> L7
        if (r5.equals(r13.get(r10)) == false) goto L12;
        r13.remove(r10);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    L12:
        monitor-exit(this);
        return;
    L16:
        if (r11.f1590a == false) goto L9;
        this.g.f(r10, r11);     // Catch: Throwable -> L7
        goto L9
    }

    public final void e(x r5, y r10) {
        ja.d r11 = this.g;
        monitor-enter(r11);
        b r12 = (b) ((HashMap) r11.f18302b).remove(r5);     // Catch: Throwable -> L13
        if (r12 == null) goto L7;
        r12.f1442c = null;     // Catch: Throwable -> L13
        r12.clear();     // Catch: Throwable -> L13
    L7:
        monitor-exit(r11);
        if (r10.f1590a == false) goto L11;
        d0 r13 = (d0) this.f1560c.e(r5, r10);
        return;
    L11:
        this.e.b(r10, false);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public final com.google.common.reflect.w g(com.bumptech.glide.c r17, Object r18, z.c r19, int r20, int r21, Class r22, Class r23, Priority r24, m r25, CachedHashCodeArrayMap r26, boolean r27, boolean r28, z.f r29, boolean r30, boolean r31, com.bumptech.glide.request.d r32, ai.y r33, x r34, long r35) {
        w r14 = (w) ((HashMap) this.f1558a.f18339b).get(r34);
        if (r14 == null) goto L9;
        r14.a(r32, r33);
        if (f1557h == false) goto L8;
        c("Added to existing load", r35, r34);
    L8:
        return new com.google.common.reflect.w(this, r32, r14);
    L9:
        w r15 = (w) this.d.g.acquire();
        monitor-enter(r15);
        r15.f1575k = r34;     // Catch: Throwable -> L35
        r15.f1576l = r30;     // Catch: Throwable -> L35
        r15.f1577m = r31;     // Catch: Throwable -> L35
        monitor-exit(r15);
        o r16 = this.f;
        k r12 = (k) r16.f1549b.acquire();
        int r13 = r16.f1550c;
        r16.f1550c = r13 + 1;
        g r10 = r12.f1520a;
        r10.f1494c = r17;
        r10.d = r18;
        r10.f1501n = r19;
        r10.e = r20;
        r10.f = r21;
        r10.f1503p = r25;
        r10.g = r22;
        r10.f1495h = r12.d;
        r10.f1498k = r23;
        r10.f1502o = r24;
        r10.f1496i = r29;
        r10.f1497j = r26;
        r10.f1504q = r27;
        r10.f1505r = r28;
        r12.f1523h = r17;
        r12.f1524i = r19;
        r12.f1525j = r24;
        r12.f1526k = r34;
        r12.f1527l = r20;
        r12.f1528m = r21;
        r12.f1529n = r25;
        r12.f1530o = r29;
        r12.f1531p = r15;
        r12.f1532q = r13;
        r12.s = DecodeJob$RunReason.INITIALIZE;
        r12.f1535u = r18;
        jg.k r5 = this.f1558a;
        r5.getClass();
        ((HashMap) r5.f18339b).put(r34, r15);
        r15.a(r32, r33);
        monitor-enter(r15);
        r15.f1583t = r12;     // Catch: Throwable -> L32
        DecodeJob$Stage r11 = r12.h(DecodeJob$Stage.INITIALIZE);     // Catch: Throwable -> L32
        if (r11 != DecodeJob$Stage.RESOURCE_CACHE) goto L18;
    L24:
        c0.b r36 = r15.g;     // Catch: Throwable -> L32
    L25:
        r36.execute(r12);     // Catch: Throwable -> L32
        monitor-exit(r15);
        if (f1557h == false) goto L31;
        c("Started new load", r35, r34);
    L31:
        return new com.google.common.reflect.w(this, r32, r15);
    L18:
        if (r11 == DecodeJob$Stage.DATA_CACHE) goto L24;
        if (r15.f1577m == false) goto L23;
        r36 = r15.f1573i;     // Catch: Throwable -> L32
        goto L25
    L23:
        r36 = r15.f1572h;     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        throw th;
    L35:
        th = move-exception;
        throw th;
    }
}
