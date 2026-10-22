package com.bytedance.ai.applet.app.foundation.performance;

import java.util.Locale;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class k {
    public static final AtomicLong g = null;
    public final c a;
    public final long b;
    public final long c;
    public final Object d;
    public boolean e;
    public boolean f;

    public static final class a {
    }

    public abstract e b(AppletPerformanceOutcome r1, long r10, AppletPerformanceErrorCode r11, String r12);

    static {
        g = new AtomicLong(0);
    }

    public final boolean a(long r10) {
        if (this.e == false) goto L5;
    L9:
        return false;
    L5:
        if (h.a(r10) == false) goto L9;
        if (r10 < this.b) goto L9;
        return true;
    }

    public k(c r10, long r11) {
        Intrinsics.checkNotNullParameter(r10, "owner");
        this.a = r10;
        this.b = r11;
        this.c = g.incrementAndGet();
        this.d = new Object();
    }

    public final boolean c(AppletPerformanceErrorCode r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "errorCode");
        return d(this, AppletPerformanceOutcome.FAILED, 0, r10, r11, 2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean d(k r10, AppletPerformanceOutcome r11, long r12, AppletPerformanceErrorCode r14, String r15, int r16) {
        if ((r16 & 2) == 0) goto L5;
        long r1 = RangesKt.coerceAtLeast(System.currentTimeMillis(), r10.b);
    L6:
        Object r13 = null;
        if ((r16 & 8) == 0) goto L9;
        String r17 = null;
    L10:
        Object r18 = r10.d;
        monitor-enter(r18);
    L37:
        th = move-exception;
        throw th;
    L13:
        if (r10.e == false) goto L15;
        Pair r19 = TuplesKt.to(Boolean.FALSE, null);     // Catch: Throwable -> L37
    L31:
        monitor-exit(r18);
        if (((Boolean) r19.getFirst()).booleanValue() == true) goto L35;
        c r20 = r10.a;
        String r0 = "trace already closed: " + r10.c;
        r20.getClass();
        c.k(com.bytedance.android.ec.core.event.a.VALUE_CLOSE, r0);
        return false;
    L35:
        r10.a.i(r10, (e) r19.getSecond());
        return true;
    L15:
        r10.e = true;     // Catch: Throwable -> L37
        if (r10.f == true) goto L30;
        r10.f = true;     // Catch: Throwable -> L37
        long r21 = RangesKt.coerceAtLeast(r1, r10.b);     // Catch: Throwable -> L37
        if (r11 == AppletPerformanceOutcome.SUCCESS) goto L27;
        if (r17 != null) goto L23;
    L28:
        Object r22 = r11.name().toLowerCase(Locale.ROOT);     // Catch: Throwable -> L37
    L29:
        r13 = r10.b(r11, r21, r14, r22);     // Catch: Throwable -> L37
        goto L30
    L23:
        if ((!StringsKt.isBlank(r17)) == false) goto L25;
        r13 = r17;
    L25:
        if (r13 == null) goto L28;
    L27:
        r22 = r13;
    L30:
        r19 = TuplesKt.to(Boolean.TRUE, r13);     // Catch: Throwable -> L37
        goto L31
    L9:
        r17 = r15;
        goto L10
    L5:
        r1 = r12;
        goto L6
    }
}
