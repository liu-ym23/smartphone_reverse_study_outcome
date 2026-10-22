package com.obric.performance.power.monitor.cpu;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class c {
    public double a;
    public double b;
    public double c;
    public double d;
    public long e;
    public long f;
    public Map<Integer, Map<Long, Long>> g;
    public long h;
    public long i;
    public Map<Integer, Long> j;
    public Map<Integer, Map<Integer, Long>> k;

    public c() {
        this(null);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof c) == true) goto L8;
        return false;
    L8:
        c r9 = (c) r8;
        if (Double.compare(this.a, r9.a) == 0) goto L12;
        return false;
    L12:
        if (Double.compare(this.b, r9.b) == 0) goto L15;
        return false;
    L15:
        if (Double.compare(this.c, r9.c) == 0) goto L18;
        return false;
    L18:
        if (Double.compare(this.d, r9.d) == 0) goto L21;
        return false;
    L21:
        if (this.e == r9.e) goto L24;
        return false;
    L24:
        if (this.f == r9.f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r9.g) == true) goto L30;
        return false;
    L30:
        if (this.h == r9.h) goto L33;
        return false;
    L33:
        if (this.i == r9.i) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r9.j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r9.k) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        long r0 = Double.doubleToLongBits(this.a);
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = Double.doubleToLongBits(this.b);
        int r2 = (r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        long r4 = Double.doubleToLongBits(this.c);
        int r5 = (r2 + ((int) (r4 ^ (r4 >>> 32)))) * 31;
        long r6 = Double.doubleToLongBits(this.d);
        int r7 = (r5 + ((int) (r6 ^ (r6 >>> 32)))) * 31;
        long r8 = this.e;
        int r9 = (r7 + ((int) (r8 ^ (r8 >>> 32)))) * 31;
        long r10 = this.f;
        int r11 = (r9 + ((int) (r10 ^ (r10 >>> 32)))) * 31;
        Map<Integer, Map<Long, Long>> r12 = this.g;
        int r13 = 0;
        if (r12 != null) goto L5;
        int r14 = 0;
    L6:
        long r15 = this.h;
        int r16 = (((r11 + r14) * 31) + ((int) (r15 ^ (r15 >>> 32)))) * 31;
        long r17 = this.i;
        int r18 = (r16 + ((int) (r17 ^ (r17 >>> 32)))) * 31;
        Map<Integer, Long> r19 = this.j;
        if (r19 != null) goto L9;
        int r20 = 0;
    L10:
        int r21 = (r18 + r20) * 31;
        Map<Integer, Map<Integer, Long>> r22 = this.k;
        if (r22 == null) goto L15;
        r13 = r22.hashCode();
    L15:
        return r21 + r13;
    L9:
        r20 = r19.hashCode();
        goto L10
    L5:
        r14 = r12.hashCode();
        goto L6
    }

    public final String toString() {
        StringBuilder r0 = new StringBuilder("(cpuUsage:");
        r0.append(this.a);
        r0.append(", cpuSpeed:");
        r0.append(this.b);
        r0.append(", normalizerCpuUsage:");
        r0.append(this.c);
        r0.append(", systemCpuUsage:");
        r0.append(this.d);
        r0.append(", deviceCpuTime:");
        r0.append(this.e);
        r0.append(", deviceIdleTime:");
        r0.append(this.f);
        r0.append(", deviceFreqCpuMap:");
        Object r1 = this.g;
        Object r2 = "null";
        if (r1 != null) goto L5;
        r1 = "null";
    L5:
        r0.append(r1);
        r0.append(", processCpuTime:");
        r0.append(this.h);
        r0.append(", processWallTime:");
        r0.append(this.i);
        r0.append(", threadCpuMap:");
        r0.append(this.j);
        r0.append(", threadPolicyCpuMap:");
        Map<Integer, Map<Integer, Long>> r3 = this.k;
        if (r3 == null) goto L9;
        r2 = r3;
    L9:
        r0.append(r2);
        r0.append(')');
        return r0.toString();
    }

    public c(Object r3) {
        this.a = 0.0d;
        this.b = 0.0d;
        this.c = 0.0d;
        this.d = 0.0d;
        this.e = 0;
        this.f = 0;
        this.g = null;
        this.h = 0;
        this.i = 0;
        this.j = null;
        this.k = null;
    }
}
