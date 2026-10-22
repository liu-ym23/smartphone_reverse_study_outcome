package com.google.common.base;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f8652a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f8653b;

    public final void a() {
        b0.u(!this.f8652a, "This stopwatch is already running.");
        this.f8652a = true;
        com.bytedance.sdk.xbridge.cn.auth.g r5 = y.f8677a;
        this.f8653b = System.nanoTime();
    }

    public final String toString() {
        if (this.f8652a == false) goto L5;
        com.bytedance.sdk.xbridge.cn.auth.g r5 = y.f8677a;
        long r10 = (System.nanoTime() - this.f8653b) + 0;
    L6:
        TimeUnit r11 = TimeUnit.DAYS;
        TimeUnit r12 = TimeUnit.NANOSECONDS;
        if (r11.convert(r10, r12) > 0) goto L25;
        r11 = TimeUnit.HOURS;
        if (r11.convert(r10, r12) > 0) goto L25;
        r11 = TimeUnit.MINUTES;
        if (r11.convert(r10, r12) > 0) goto L25;
        r11 = TimeUnit.SECONDS;
        if (r11.convert(r10, r12) > 0) goto L25;
        r11 = TimeUnit.MILLISECONDS;
        if (r11.convert(r10, r12) > 0) goto L25;
        r11 = TimeUnit.MICROSECONDS;
        if (r11.convert(r10, r12) > 0) goto L25;
        r11 = r12;
    L25:
        double r13 = r10 / r12.convert(1, r11);
        com.bytedance.sdk.xbridge.cn.auth.g r14 = y.f8677a;
        String r15 = String.format(Locale.ROOT, "%.4g", new Object[]{Double.valueOf(r13)});
        switch(c0.f8649a[r11.ordinal()]) {
            case 1: goto L35;
            case 2: goto L34;
            case 3: goto L33;
            case 4: goto L32;
            case 5: goto L31;
            case 6: goto L30;
            case 7: goto L29;
            default: goto L28;
        };
    L29:
        String r16 = "d";
    L37:
        return androidx.room.jarjarred.org.antlr.runtime.a.m(r16.length() + (r15.length() + 1), r15, " ", r16);
    L30:
        r16 = "h";
        goto L37
    L31:
        r16 = "min";
        goto L37
    L32:
        r16 = "s";
        goto L37
    L33:
        r16 = "ms";
        goto L37
    L34:
        r16 = "μs";
        goto L37
    L35:
        r16 = "ns";
        goto L37
    L28:
        throw new AssertionError();
    L5:
        r10 = 0;
        goto L6
    }
}
