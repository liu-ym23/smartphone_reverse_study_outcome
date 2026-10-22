package com.google.common.math;

import java.math.RoundingMode;

/* JADX INFO: loaded from: classes2.dex */
final class e {
    static int a(String r2, int r3) {
        if (r3 <= 0) goto L5;
        return r3;
    L5:
        throw new IllegalArgumentException(r2 + " (" + r3 + ") must be > 0");
    }

    static void a(boolean r1) {
        if (r1 == false) goto L5;
        return;
    L5:
        throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
    }

    static void a(boolean r2, double r3, RoundingMode r5) {
        if (r2 == false) goto L5;
        return;
    L5:
        throw new ArithmeticException("rounded value is out of range for input " + r3 + " and rounding mode " + r5);
    }

    static void a(boolean r2, String r3, int r4, int r5) {
        if (r2 == false) goto L5;
        return;
    L5:
        throw new ArithmeticException("overflow: " + r3 + "(" + r4 + ", " + r5 + ")");
    }

    static void a(boolean r2, String r3, long r4, long r6) {
        if (r2 == false) goto L5;
        return;
    L5:
        throw new ArithmeticException("overflow: " + r3 + "(" + r4 + ", " + r6 + ")");
    }

    static int b(String r2, int r3) {
        if (r3 < 0) goto L5;
        return r3;
    L5:
        throw new IllegalArgumentException(r2 + " (" + r3 + ") must be >= 0");
    }
}
