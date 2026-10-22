package com.google.common.math;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.common.base.n;
import com.google.common.primitives.Ints;
import java.math.RoundingMode;
import org.apache.commons.math3.distribution.PoissonDistribution;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final byte[] f4744a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final int[] f4745b = null;
    static final int[] c = null;
    static int[] d;
    private static final int[] e = null;

    /* JADX INFO: renamed from: com.google.common.math.c$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4746a = null;

        static {
            int[] r0 = new int[RoundingMode.values().length];
            f4746a = r0;
            r0[RoundingMode.UNNECESSARY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L20:
            f4746a[RoundingMode.DOWN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L24:
            f4746a[RoundingMode.FLOOR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L34:
            f4746a[RoundingMode.UP.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L22:
            f4746a[RoundingMode.CEILING.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L26:
            f4746a[RoundingMode.HALF_DOWN.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L28:
            f4746a[RoundingMode.HALF_UP.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L30:
            f4746a[RoundingMode.HALF_EVEN.ordinal()] = 8;     // Catch: NoSuchFieldError -> L19
            return;
        }
    }

    static {
        f4744a = new byte[]{9, 9, 9, 8, 8, 8, 7, 7, 7, 6, 6, 6, 6, 5, 5, 5, 4, 4, 4, 3, 3, 3, 3, 2, 2, 2, 1, 1, 1, 0, 0, 0, 0};
        f4745b = new int[]{1, 10, 100, 1000, 10000, 100000, 1000000, PoissonDistribution.DEFAULT_MAX_ITERATIONS, 100000000, 1000000000};
        c = new int[]{3, 31, TypedValues.AttributesType.TYPE_PATH_ROTATE, 3162, 31622, 316227, 3162277, 31622776, 316227766, Integer.MAX_VALUE};
        e = new int[]{1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600};
        d = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, 65536, 2345, 477, 193, 110, 75, 58, 49, 43, 39, 37, 35, 34, 34, 33};
    }

    static int a(int r0, int r1) {
        return (~(~(r0 - r1))) >>> 31;
    }

    public static int a(int r5, int r6, RoundingMode r7) {
        n.a(r7);
        if (r6 == 0) goto L41;
        int r0 = r5 / r6;
        int r1 = r5 - (r6 * r0);
        if (r1 != 0) goto L7;
        return r0;
    L7:
        boolean r2 = true;
        int r8 = ((r5 ^ r6) >> 31) | 1;
        switch(AnonymousClass1.f4746a[r7.ordinal()]) {
            case 1: goto L32;
            case 2: goto L36;
            case 3: goto L30;
            case 4: goto L37;
            case 5: goto L28;
            case 6: goto L11;
            case 7: goto L11;
            case 8: goto L11;
            default: goto L10;
        };
    L11:
        int r3 = Math.abs(r1);
        int r4 = r3 - (Math.abs(r6) - r3);
        if (r4 == 0) goto L14;
        if (r4 <= 0) goto L36;
    L14:
        if (r7 == RoundingMode.HALF_UP) goto L37;
        if (r7 != RoundingMode.HALF_EVEN) goto L18;
        boolean r9 = true;
    L20:
        if ((r0 & 1) == 0) goto L22;
        boolean r10 = true;
    L24:
        if ((r9 & r10) == false) goto L36;
    L22:
        r10 = false;
        goto L24
    L18:
        r9 = false;
        goto L20
    L28:
        if (r8 <= 0) goto L36;
    L30:
        if (r8 >= 0) goto L36;
    L32:
        if (r1 == 0) goto L35;
        r2 = false;
    L35:
        e.a(r2);
    L36:
        r2 = false;
    L37:
        if (r2 == true) goto L39;
        return r0;
    L39:
        return r0 + r8;
    L10:
        throw new AssertionError();
    L41:
        throw new ArithmeticException("/ by zero");
    }

    public static int a(int r1, RoundingMode r2) {
        e.a("x", r1);
        switch(AnonymousClass1.f4746a[r2.ordinal()]) {
            case 1: goto L10;
            case 2: goto L12;
            case 3: goto L12;
            case 4: goto L9;
            case 5: goto L9;
            case 6: goto L6;
            case 7: goto L6;
            case 8: goto L6;
            default: goto L5;
        };
    L6:
        int r3 = Integer.numberOfLeadingZeros(r1);
        return (31 - r3) + a((-1257966797) >>> r3, r1);
    L10:
        e.a(a(r1));
        goto L12
    L5:
        throw new AssertionError();
    L9:
        return 32 - Integer.numberOfLeadingZeros(r1 - 1);
    L12:
        return 31 - Integer.numberOfLeadingZeros(r1);
    }

    public static boolean a(int r4) {
        boolean r0 = false;
        if (r4 <= 0) goto L5;
        boolean r2 = true;
    L7:
        if ((r4 & (r4 - 1)) != 0) goto L10;
        r0 = true;
    L10:
        return r2 & r0;
    L5:
        r2 = false;
        goto L7
    }

    private static int b(int r2) {
        return (int) Math.sqrt(r2);
    }

    public static int b(int r5, int r6) {
        long r0 = ((long) r5) + ((long) r6);
        int r2 = (int) r0;
        if (r0 != r2) goto L5;
        boolean r1 = true;
    L6:
        e.a(r1, "checkedAdd", r5, r6);
        return r2;
    L5:
        r1 = false;
        goto L6
    }

    public static int b(int r2, RoundingMode r3) {
        e.b("x", r2);
        int r0 = b(r2);
        switch(AnonymousClass1.f4746a[r3.ordinal()]) {
            case 1: goto L11;
            case 2: goto L15;
            case 3: goto L15;
            case 4: goto L9;
            case 5: goto L9;
            case 6: goto L6;
            case 7: goto L6;
            case 8: goto L6;
            default: goto L5;
        };
    L6:
        int r4 = (r0 * r0) + r0;
    L8:
        return r0 + a(r4, r2);
    L9:
        r4 = r0 * r0;
    L15:
        return r0;
    L5:
        throw new AssertionError();
    L11:
        if ((r0 * r0) != r2) goto L13;
        boolean r5 = true;
    L14:
        e.a(r5);
        goto L15
    L13:
        r5 = false;
        goto L14
    }

    public static int c(int r5, int r6) {
        long r0 = ((long) r5) * ((long) r6);
        int r2 = (int) r0;
        if (r0 != r2) goto L5;
        boolean r1 = true;
    L6:
        e.a(r1, "checkedMultiply", r5, r6);
        return r2;
    L5:
        r1 = false;
        goto L6
    }

    public static int d(int r2, int r3) {
        return Ints.b(((long) r2) + ((long) r3));
    }
}
