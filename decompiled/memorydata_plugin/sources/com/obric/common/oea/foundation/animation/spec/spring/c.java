package com.obric.common.oea.foundation.animation.spec.spring;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a.\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005\u001a.\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f\u001a(\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0002\u001a8\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0002\u001a0\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0002\u001a(\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0002\u001a9\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00052\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00192\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0019H\u0082\b\u001a\u0019\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0005H\u0086\b\u001a\r\u0010\u001e\u001a\u00020\u001f*\u00020\u0005H\u0082\b\u001a\u0015\u0010 \u001a\u00020\u0003*\u00020\u00052\u0006\u0010!\u001a\u00020\u0003H\u0080\n\u001a\u0015\u0010\"\u001a\u00020\u0003*\u00020\u00052\u0006\u0010!\u001a\u00020\u0003H\u0080\n\u001a\u0015\u0010#\u001a\u00020\u0003*\u00020\u00052\u0006\u0010!\u001a\u00020\u0003H\u0080\n\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"MAX_LONG_MILLIS", "", "complexSqrt", "Lcom/obric/common/oea/foundation/animation/spec/spring/ComplexDouble;", "num", "", "estimateAnimationDurationMillis", "stiffness", "dampingRatio", "initialVelocity", "initialDisplacement", "delta", "", "estimateCriticallyDamped", "firstRoot", "p0", "v0", "estimateDurationInternal", "secondRoot", "initialPosition", "estimateOverDamped", "estimateUnderDamped", "iterateNewtonsMethod", "x", "fn", "Lkotlin/Function1;", "fnPrime", "max", "a", "b", "isNotFinite", "", "minus", "other", "plus", "times", "foundation_standardRelease"}, k = 2, mv = {1, 4, 3})
public final class c {
    private static final double a(a r4, double r5, double r7, double r9) {
        double r0 = r4.a();
        double r8 = (r7 - (r0 * r5)) / r4.b();
        return Math.log(r9 / Math.sqrt((r5 * r5) + (r8 * r8))) / r0;
    }

    private static final double a(a r31, a r32, double r33, double r35, double r37) {
        double r0 = r37;
        final double r13 = r31.a();
        final double r15 = r32.a();
        double r17 = r13 - r15;
        final double r11 = ((r13 * r33) - r35) / r17;
        final double r19 = r33 - r11;
        double r2 = Math.log(Math.abs(r0 / r19)) / r13;
        double r4 = Math.log(Math.abs(r0 / r11)) / r15;
        if (Double.isInfinite(r2) == false) goto L5;
    L7:
        boolean r6 = false;
    L9:
        if ((!r6) == false) goto L12;
        double r22 = r4;
    L22:
        double r24 = r19 * r13;
        final double r26 = Math.log(r24 / ((-r11) * r15)) / (r15 - r13);
        Function0<Double> r28 = new FloatSpringSpecKt$estimateOverDamped$1(r19, r13, r26, r11, r15);
        if (Double.isNaN(r26) == false) goto L25;
    L37:
        r0 = -r0;
    L38:
        double r12 = r11 * r15;
        if (Math.abs((Math.exp(r13 * r22) * r24) + (Math.exp(r15 * r22) * r12)) >= 1.0E-4d) goto L41;
        return r22;
    L41:
        double r3 = Double.MAX_VALUE;
        int r5 = 0;
    L43:
        if (r3 <= 0.001d) goto L47;
        if (r5 >= 100) goto L47;
        r5 = r5 + 1;
        double r7 = r13 * r22;
        double r8 = r15 * r22;
        double r9 = r22 - ((((Math.exp(r7) * r19) + (Math.exp(r8) * r11)) + r0) / ((Math.exp(r7) * r24) + (Math.exp(r8) * r12)));
        double r10 = Math.abs(r22 - r9);
        r22 = r9;
        r3 = r10;
    L47:
        return r22;
    L25:
        if (r26 <= 0.0d) goto L37;
        if (r26 > 0.0d) goto L30;
    L36:
        r22 = Math.log((-((r11 * r15) * r15)) / (r24 * r13)) / r17;
        goto L38
    L30:
        if ((-r28.invoke2()) >= r0) goto L36;
        if (r11 <= 0.0d) goto L37;
        if (r19 >= 0.0d) goto L37;
        r22 = 0.0d;
        goto L37
    L12:
        if (Double.isInfinite(r4) == false) goto L14;
    L16:
        boolean r14 = false;
    L18:
        if ((!r14) == true) goto L21;
        r2 = Math.max(r2, r4);
    L21:
        r22 = r2;
        goto L22
    L14:
        if (Double.isNaN(r4) == true) goto L16;
        r14 = true;
        goto L18
    L5:
        if (Double.isNaN(r2) == true) goto L7;
        r6 = true;
        goto L9
    }

    public static final long a(double r12, double r14, double r16, double r18, double r20) {
        double r0 = (2.0d * r14) * Math.sqrt(r12);
        double r2 = (r0 * r0) - (4.0d * r12);
        double r1 = -r0;
        a r4 = a(r2);
        a.a(r4, a.a(r4) + r1);
        a.a(r4, a.a(r4) * 0.5d);
        a.b(r4, a.b(r4) * 0.5d);
        a r3 = a(r2);
        double r9 = -1;
        a.a(r3, a.a(r3) * r9);
        a.b(r3, a.b(r3) * r9);
        a.a(r3, a.a(r3) + r1);
        a.a(r3, a.a(r3) * 0.5d);
        a.b(r3, a.b(r3) * 0.5d);
        return a(r4, r3, r14, r16, r18, r20);
    }

    public static final long a(float r10, float r11, float r12, float r13, float r14) {
        if (r11 != 0.0f) goto L7;
        return 9223372036854L;
    L7:
        return a(r10, r11, r12, r13, r14);
    }

    private static final long a(a r10, a r11, double r12, double r14, double r16, double r18) {
        double r0 = r14;
        if (r16 != 0.0d) goto L9;
        if (r0 != 0.0d) goto L9;
        return 0;
    L9:
        if (r16 >= 0) goto L11;
        r0 = -r0;
    L11:
        double r4 = Math.abs(r16);
        if (r12 <= 1.0d) goto L14;
        double r1 = a(r10, r11, r4, r0, r18);
    L19:
        return (long) (r1 * 1000.0d);
    L14:
        double r13 = r0;
        if (r12 >= 1.0d) goto L17;
        r1 = a(r10, r4, r13, r18);
        goto L19
    L17:
        r1 = b(r10, r4, r13, r18);
        goto L19
    }

    public static final a a(double r3) {
        if (r3 >= 0.0d) goto L6;
        return new a(0.0d, Math.sqrt(Math.abs(r3)));
    L6:
        return new a(Math.sqrt(r3), 0.0d);
    }

    private static final double b(a r20, double r21, double r23, double r25) {
        double r0 = r25;
        double r2 = r20.a();
        double r4 = r2 * r21;
        double r6 = r23 - r4;
        double r8 = Math.log(Math.abs(r0 / r21)) / r2;
        double r10 = Math.log(Math.abs(r0 / r6));
        double r14 = r10;
        int r13 = 0;
    L3:
        double r15 = r14 / r2;
        if (r13 > 5) goto L7;
        r14 = r10 - Math.log(Math.abs(r15));
        r13 = r13 + 1;
        goto L3
    L7:
        if (Double.isInfinite(r8) == false) goto L9;
    L11:
        boolean r11 = false;
    L13:
        if ((!r11) == false) goto L16;
        r8 = r15;
    L25:
        double r12 = (-(r4 + r6)) / (r2 * r6);
        double r16 = r2 * r12;
        double r17 = (Math.exp(r16) * r21) + ((r6 * r12) * Math.exp(r16));
        if (Double.isNaN(r12) == false) goto L28;
    L40:
        int r18 = 0;
    L41:
        r0 = -r0;
    L42:
        double r19 = Double.MAX_VALUE;
    L44:
        if (r19 <= 0.001d) goto L48;
        if (r18 >= 100) goto L48;
        r18 = r18 + 1;
        double r110 = r2 * r8;
        double r24 = r0;
        double r1 = r8 - ((((r21 + (r6 * r8)) * Math.exp(r110)) + r0) / ((((((double) 1) + r110) * r6) + r4) * Math.exp(r110)));
        r19 = Math.abs(r8 - r1);
        r8 = r1;
        r0 = r24;
    L48:
        return r8;
    L28:
        if (r12 <= 0.0d) goto L40;
        if (r12 > 0.0d) goto L33;
    L39:
        r18 = 0;
        r8 = (-(2.0d / r2)) - (r21 / r6);
        goto L42
    L33:
        if ((-r17) >= r0) goto L39;
        r18 = 0;
        double r111 = 0;
        if (r6 >= r111) goto L41;
        if (r21 <= r111) goto L41;
        r8 = 0.0d;
        goto L41
    L16:
        if (Double.isInfinite(r15) == false) goto L18;
    L20:
        boolean r112 = false;
    L22:
        if ((!r112) == true) goto L25;
        r8 = Math.max(r8, r15);
        goto L25
    L18:
        if (Double.isNaN(r15) == true) goto L20;
        r112 = true;
        goto L22
    L9:
        if (Double.isNaN(r8) == true) goto L11;
        r11 = true;
        goto L13
    }
}
