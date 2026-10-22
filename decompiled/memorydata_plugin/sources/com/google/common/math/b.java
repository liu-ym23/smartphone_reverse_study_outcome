package com.google.common.math;

import com.google.common.base.n;

/* JADX INFO: loaded from: classes2.dex */
final class b {
    static long a(double r3) {
        n.a(b(r3), "not a normal value");
        int r0 = Math.getExponent(r3);
        long r4 = Double.doubleToRawLongBits(r3) & 4503599627370495L;
        if (r0 != (-1023)) goto L6;
        return r4 << 1;
    L6:
        return r4 | 4503599627370496L;
    }

    static boolean b(double r0) {
        if (Math.getExponent(r0) > 1023) goto L5;
        return true;
    L5:
        return false;
    }

    static double c(double r2) {
        n.a(!Double.isNaN(r2));
        return Math.max(r2, 0.0d);
    }
}
