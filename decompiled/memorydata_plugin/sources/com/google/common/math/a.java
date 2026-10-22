package com.google.common.math;

import java.math.RoundingMode;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final double[] f4741a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final double f4742b = 0.0d;

    /* JADX INFO: renamed from: com.google.common.math.a$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4743a = null;

        static {
            int[] r0 = new int[RoundingMode.values().length];
            f4743a = r0;
            r0[RoundingMode.UNNECESSARY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L20:
            f4743a[RoundingMode.FLOOR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L24:
            f4743a[RoundingMode.CEILING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L34:
            f4743a[RoundingMode.DOWN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L22:
            f4743a[RoundingMode.UP.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L26:
            f4743a[RoundingMode.HALF_EVEN.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L28:
            f4743a[RoundingMode.HALF_UP.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L30:
            f4743a[RoundingMode.HALF_DOWN.ordinal()] = 8;     // Catch: NoSuchFieldError -> L19
            return;
        }
    }

    static {
        f4742b = Math.log(2.0d);
        f4741a = new double[]{1.0d, 2.0922789888E13d, 2.631308369336935E35d, 1.2413915592536073E61d, 1.2688693218588417E89d, 7.156945704626381E118d, 9.916779348709496E149d, 1.974506857221074E182d, 3.856204823625804E215d, 5.5502938327393044E249d, 4.7147236359920616E284d};
    }

    static double a(double r6, RoundingMode r8) {
        if (b.b(r6) == false) goto L45;
        switch(AnonymousClass1.f4743a[r8.ordinal()]) {
            case 1: goto L42;
            case 2: goto L36;
            case 3: goto L29;
            case 4: goto L46;
            case 5: goto L20;
            case 6: goto L18;
            case 7: goto L12;
            case 8: goto L8;
            default: goto L7;
        };
    L8:
        double r0 = Math.rint(r6);
        if (Math.abs(r6 - r0) != 0.5d) goto L11;
        return r6;
    L11:
        return r0;
    L12:
        double r1 = Math.rint(r6);
        if (Math.abs(r6 - r1) == 0.5d) goto L15;
        return r1;
    L15:
        return r6 + Math.copySign(0.5d, r6);
    L42:
        e.a(a(r6));
        return r6;
    L46:
        return r6;
    L7:
        throw new AssertionError();
    L18:
        return Math.rint(r6);
    L20:
        if (a(r6) == false) goto L22;
        return r6;
    L22:
        long r2 = (long) r6;
        if (r6 <= 0.0d) goto L25;
        int r7 = 1;
    L27:
        return r2 + ((long) r7);
    L25:
        r7 = -1;
        goto L27
    L29:
        if (r6 > 0.0d) goto L31;
        return r6;
    L31:
        if (a(r6) == false) goto L34;
        return r6;
    L34:
        return ((long) r6) + 1;
    L36:
        if (r6 < 0.0d) goto L38;
        return r6;
    L38:
        if (a(r6) == false) goto L41;
        return r6;
    L41:
        return ((long) r6) - 1;
    L45:
        throw new ArithmeticException("input is infinite or NaN");
    }

    public static boolean a(double r2) {
        if (b.b(r2) == true) goto L5;
    L9:
        return false;
    L5:
        if (r2 != 0.0d) goto L7;
    L8:
        return true;
    L7:
        if ((52 - Long.numberOfTrailingZeros(b.a(r2))) > Math.getExponent(r2)) goto L9;
        goto L8
    }

    public static long b(double r7, RoundingMode r9) {
        double r0 = a(r7, r9);
        boolean r3 = true;
        if (((-9.223372036854776E18d) - r0) >= 1.0d) goto L5;
        boolean r2 = true;
    L7:
        if (r0 < 9.223372036854776E18d) goto L10;
        r3 = false;
    L10:
        e.a(r2 & r3, r7, r9);
        return (long) r0;
    L5:
        r2 = false;
        goto L7
    }
}
