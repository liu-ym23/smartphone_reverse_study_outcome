package com.obric.common.oea.foundation.animation.spec.spring;

import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes2.dex */
public final class FloatSpringSpecKt {
    public static final a a(double r10) {
        if (r10 >= 0.0d) goto L6;
        return new a(0.0d, Math.sqrt(Math.abs(r10)));
    L6:
        return new a(Math.sqrt(r10), 0.0d);
    }

    public static final long b(double r12, double r14, double r16, double r18, double r20) {
        double r10 = (2.0d * r14) * Math.sqrt(r12);
        double r11 = (r10 * r10) - (4.0d * r12);
        double r13 = -r10;
        a r15 = a(r11);
        a.d(r15, a.b(r15) + r13);
        a.d(r15, a.b(r15) * 0.5d);
        a.c(r15, a.a(r15) * 0.5d);
        a r17 = a(r11);
        double r19 = -1;
        a.d(r17, a.b(r17) * r19);
        a.c(r17, a.a(r17) * r19);
        a.d(r17, a.b(r17) + r13);
        a.d(r17, a.b(r17) * 0.5d);
        a.c(r17, a.a(r17) * 0.5d);
        return e(r15, r17, r14, r16, r18, r20);
    }

    public static final long c(float r10, float r11, float r12, float r13, float r14) {
        if (r11 != 0.0f) goto L7;
        return 9223372036854L;
    L7:
        return b(r10, r11, r12, r13, r14);
    }

    private static final double d(a r20, double r21, double r23, double r25) {
        double r10 = r25;
        double r11 = r20.f();
        double r12 = r11 * r21;
        double r13 = r23 - r12;
        double r14 = Math.log(Math.abs(r10 / r21)) / r11;
        double r15 = Math.log(Math.abs(r10 / r13));
        double r16 = r15;
        int r17 = 0;
    L3:
        double r18 = r16 / r11;
        if (r17 > 5) goto L7;
        r16 = r15 - Math.log(Math.abs(r18));
        r17 = r17 + 1;
        goto L3
    L7:
        if (Double.isInfinite(r14) == false) goto L9;
    L11:
        boolean r19 = false;
    L13:
        if ((!r19) == false) goto L16;
        r14 = r18;
    L25:
        double r110 = (-(r12 + r13)) / (r11 * r13);
        double r111 = r11 * r110;
        double r112 = (Math.exp(r111) * r21) + ((r13 * r110) * Math.exp(r111));
        if (Double.isNaN(r110) == false) goto L28;
    L40:
        int r113 = 0;
    L41:
        r10 = -r10;
    L42:
        double r114 = Double.MAX_VALUE;
    L44:
        if (r114 <= 0.001d) goto L48;
        if (r113 >= 100) goto L48;
        r113 = r113 + 1;
        double r115 = r11 * r14;
        double r24 = r10;
        double r22 = r14 - ((((r21 + (r13 * r14)) * Math.exp(r115)) + r10) / ((((((double) 1) + r115) * r13) + r12) * Math.exp(r115)));
        r114 = Math.abs(r14 - r22);
        r14 = r22;
        r10 = r24;
    L48:
        return r14;
    L28:
        if (r110 <= 0.0d) goto L40;
        if (r110 > 0.0d) goto L33;
    L39:
        r113 = 0;
        r14 = (-(2.0d / r11)) - (r21 / r13);
        goto L42
    L33:
        if ((-r112) >= r10) goto L39;
        r113 = 0;
        double r116 = 0;
        if (r13 >= r116) goto L41;
        if (r21 <= r116) goto L41;
        r14 = 0.0d;
        goto L41
    L16:
        if (Double.isInfinite(r18) == false) goto L18;
    L20:
        boolean r117 = false;
    L22:
        if ((!r117) == true) goto L25;
        r14 = Math.max(r14, r18);
        goto L25
    L18:
        if (Double.isNaN(r18) == true) goto L20;
        r117 = true;
        goto L22
    L9:
        if (Double.isNaN(r14) == true) goto L11;
        r19 = true;
        goto L13
    }

    private static final long e(a r10, a r11, double r12, double r14, double r16, double r18) {
        double r13 = r14;
        if (r16 != 0.0d) goto L9;
        if (r13 != 0.0d) goto L9;
        return 0;
    L9:
        if (r16 >= 0) goto L11;
        r13 = -r13;
    L11:
        double r15 = Math.abs(r16);
        if (r12 <= 1.0d) goto L14;
        double r17 = f(r10, r11, r15, r13, r18);
    L19:
        return (long) (r17 * 1000.0d);
    L14:
        double r19 = r13;
        if (r12 >= 1.0d) goto L17;
        r17 = g(r10, r15, r19, r18);
        goto L19
    L17:
        r17 = d(r10, r15, r19, r18);
        goto L19
    }

    private static final double f(a r31, a r32, double r33, double r35, double r37) {
        double r10 = r37;
        final double r13 = r31.f();
        final double r15 = r32.f();
        double r17 = r13 - r15;
        final double r11 = ((r13 * r33) - r35) / r17;
        final double r19 = r33 - r11;
        double r12 = Math.log(Math.abs(r10 / r19)) / r13;
        double r14 = Math.log(Math.abs(r10 / r11)) / r15;
        if (Double.isInfinite(r12) == false) goto L5;
    L7:
        boolean r16 = false;
    L9:
        if ((!r16) == false) goto L12;
        double r22 = r14;
    L22:
        double r24 = r19 * r13;
        final double r26 = Math.log(r24 / ((-r11) * r15)) / (r15 - r13);
        Function0<Double> r28 = new FloatSpringSpecKt$estimateOverDamped$1(r19, r13, r26, r11, r15);
        if (Double.isNaN(r26) == false) goto L25;
    L37:
        r10 = -r10;
    L38:
        double r18 = r11 * r15;
        if (Math.abs((Math.exp(r13 * r22) * r24) + (Math.exp(r15 * r22) * r18)) >= 1.0E-4d) goto L41;
        return r22;
    L41:
        double r20 = Double.MAX_VALUE;
        int r21 = 0;
    L43:
        if (r20 <= 0.001d) goto L47;
        if (r21 >= 100) goto L47;
        r21 = r21 + 1;
        double r23 = r13 * r22;
        double r25 = r15 * r22;
        double r27 = r22 - ((((Math.exp(r23) * r19) + (Math.exp(r25) * r11)) + r10) / ((Math.exp(r23) * r24) + (Math.exp(r25) * r18)));
        double r29 = Math.abs(r22 - r27);
        r22 = r27;
        r20 = r29;
    L47:
        return r22;
    L25:
        if (r26 <= 0.0d) goto L37;
        if (r26 > 0.0d) goto L30;
    L36:
        r22 = Math.log((-((r11 * r15) * r15)) / (r24 * r13)) / r17;
        goto L38
    L30:
        if ((-r28.invoke2()) >= r10) goto L36;
        if (r11 <= 0.0d) goto L37;
        if (r19 >= 0.0d) goto L37;
        r22 = 0.0d;
        goto L37
    L12:
        if (Double.isInfinite(r14) == false) goto L14;
    L16:
        boolean r30 = false;
    L18:
        if ((!r30) == true) goto L21;
        r12 = Math.max(r12, r14);
    L21:
        r22 = r12;
        goto L22
    L14:
        if (Double.isNaN(r14) == true) goto L16;
        r30 = true;
        goto L18
    L5:
        if (Double.isNaN(r12) == true) goto L7;
        r16 = true;
        goto L9
    }

    private static final double g(a r10, double r11, double r12, double r13) {
        double r14 = r10.f();
        double r15 = (r12 - (r14 * r11)) / r10.e();
        return Math.log(r13 / Math.sqrt((r11 * r11) + (r15 * r15))) / r14;
    }
}
