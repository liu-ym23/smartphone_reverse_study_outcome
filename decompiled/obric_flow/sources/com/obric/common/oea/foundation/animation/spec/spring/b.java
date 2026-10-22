package com.obric.common.oea.foundation.animation.spec.spring;

import gp.c;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f11322a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f11323b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f11324c;
    public final float d;
    public final int e;
    public final float f;

    public b(float r10, float r11, int r12) {
        this.f11324c = r10;
        this.d = r11;
        this.e = r12;
        this.f = 0.01f;
        c r13 = new c();
        r13.g = 1.0f;
        double r5 = Math.sqrt(50.0f);
        r13.f17121a = r5;
        r13.f = 1.0f;
        float r14 = 0;
        if (r10 < r14) goto L11;
        r13.f = r10;
        r13.f17122b = false;
        if (((float) (r5 * r5)) <= r14) goto L9;
        r13.f17121a = Math.sqrt(r11);
        r13.f17122b = false;
        Unit r15 = Unit.INSTANCE;
        this.f11322a = r13;
        this.f11323b = 1.0f;
        return;
    L9:
        throw new IllegalArgumentException("Spring stiffness constant must be positive.");
    L11:
        throw new IllegalArgumentException("Damping ratio must be non-negative");
    }

    public final long a(float r38, float r39, float r40) {
        c r5 = this.f11322a;
        double r10 = r5.f17121a;
        float r11 = (float) (r10 * r10);
        float r12 = r5.f;
        float r13 = this.f;
        float r14 = (r38 - r39) / r13;
        float r15 = r40 / r13;
        float r16 = this.f11323b;
        if (r12 != 0.0f) goto L5;
        long r17 = 9223372036854L;
    L103:
        return r17 * 1000000;
    L5:
        double r18 = r11;
        double r19 = r12;
        double r20 = r15;
        double r21 = r14;
        double r22 = r16;
        double r110 = (r19 * 2.0d) * Math.sqrt(r18);
        double r111 = (r110 * r110) - (r18 * 4.0d);
        double r23 = -r110;
        if (r111 >= 0.0d) goto L8;
        a r112 = new a(0.0d, Math.sqrt(Math.abs(r111)));
    L9:
        r112.f11320a = (r112.f11320a + r23) * 0.5d;
        r112.f11321b *= 0.5d;
        if (r111 >= 0.0d) goto L12;
        a r24 = new a(0.0d, Math.sqrt(Math.abs(r111)));
    L13:
        double r113 = -1;
        double r25 = r24.f11320a * r113;
        a r114 = r112;
        double r115 = r24.f11321b * r113;
        r24.f11320a = (r25 + r23) * 0.5d;
        r24.f11321b = r115 * 0.5d;
        if (r21 == 0.0d) goto L16;
    L18:
        double r26 = 0;
        if (r21 >= r26) goto L21;
        r20 = -r20;
    L21:
        double r27 = Math.abs(r21);
        double r28 = Double.MAX_VALUE;
        if (r19 <= 1.0d) goto L62;
        final double r29 = r114.f11320a;
        final double r30 = r24.f11320a;
        double r31 = r29 - r30;
        final double r116 = ((r29 * r27) - r20) / r31;
        final double r32 = r27 - r116;
        double r117 = r22;
        double r33 = Math.log(Math.abs(r117 / r32)) / r29;
        double r34 = Math.log(Math.abs(r117 / r116)) / r30;
        if (Double.isInfinite(r33) == false) goto L26;
    L32:
        r33 = r34;
    L33:
        double r35 = r32 * r29;
        final double r36 = Math.log(r35 / ((-r116) * r30)) / (r30 - r29);
        Function0<Double> r37 = new FloatSpringSpecKt$estimateOverDamped$1(r32, r29, r36, r116, r30);
        if (Double.isNaN(r36) == false) goto L36;
    L50:
        r117 = -r117;
    L51:
        double r118 = r116 * r30;
        if (Math.abs((Math.exp(r30 * r33) * r118) + (Math.exp(r29 * r33) * r35)) < 1.0E-4d) goto L101;
        double r41 = r33;
        int r42 = 0;
    L56:
        if (r28 <= 0.001d) goto L60;
        if (r42 >= 100) goto L60;
        r42 = r42 + 1;
        double r119 = r29 * r41;
        double r210 = r30 * r41;
        double r120 = r41 - ((((Math.exp(r210) * r116) + (Math.exp(r119) * r32)) + r117) / ((Math.exp(r210) * r118) + (Math.exp(r119) * r35)));
        double r43 = Math.abs(r41 - r120);
        r41 = r120;
        r28 = r43;
    L60:
        r33 = r41;
    L101:
        r17 = (long) (r33 * 1000.0d);
        goto L103
    L36:
        if (r36 <= 0.0d) goto L50;
        if (r36 > 0.0d) goto L41;
    L49:
        r33 = Math.log((-((r116 * r30) * r30)) / (r35 * r29)) / r31;
        goto L51
    L41:
        if ((-r37.invoke2()) >= r117) goto L49;
        if (r116 > 0.0d) goto L45;
    L47:
        double r121 = r33;
    L48:
        r117 = -r117;
        r33 = r121;
        goto L51
    L45:
        if (r32 >= 0.0d) goto L47;
        r121 = 0.0d;
        goto L48
    L26:
        if (Double.isNaN(r33) == true) goto L32;
        if (Double.isInfinite(r34) == true) goto L33;
        if (Double.isNaN(r34) == true) goto L33;
        r33 = Math.max(r33, r34);
        goto L33
    L62:
        if (r19 >= 1.0d) goto L64;
        double r44 = r114.f11320a;
        double r45 = (r20 - (r44 * r27)) / r114.f11321b;
        r33 = Math.log(r22 / Math.sqrt((r45 * r45) + (r27 * r27))) / r44;
        goto L101
    L64:
        double r46 = r114.f11320a;
        double r47 = r46 * r27;
        double r48 = r20 - r47;
        double r122 = Math.log(Math.abs(r22 / r27)) / r46;
        double r211 = Math.log(Math.abs(r22 / r48));
        double r212 = r211;
        int r49 = 0;
    L66:
        if (r49 > 5) goto L68;
        r212 = r211 - Math.log(Math.abs(r212 / r46));
        r49 = r49 + 1;
        goto L66
    L68:
        double r50 = r212 / r46;
        if (Double.isInfinite(r122) == false) goto L71;
    L77:
        r122 = r50;
    L78:
        double r51 = (-(r47 + r48)) / (r46 * r48);
        double r213 = r46 * r51;
        double r214 = Math.exp(r213) * r27;
        double r215 = r122;
        double r123 = (Math.exp(r213) * (r48 * r51)) + r214;
        if (Double.isNaN(r51) == false) goto L81;
    L92:
        double r52 = -r22;
        double r124 = r215;
    L94:
        int r53 = 0;
    L96:
        if (r28 <= 0.001d) goto L100;
        if (r53 >= 100) goto L100;
        r53 = r53 + 1;
        double r125 = r46 * r124;
        double r126 = r124 - (((Math.exp(r125) * ((r48 * r124) + r27)) + r52) / (Math.exp(r125) * (((r125 + ((double) 1)) * r48) + r47)));
        r28 = Math.abs(r124 - r126);
        r124 = r126;
    L100:
        r33 = r124;
        goto L101
    L81:
        if (r51 <= 0.0d) goto L92;
        if (r51 > 0.0d) goto L86;
    L93:
        r124 = (-(2.0d / r46)) - (r27 / r48);
        r52 = r22;
        goto L94
    L86:
        if ((-r123) >= r22) goto L93;
        if (r48 >= r26) goto L92;
        if (r27 <= r26) goto L92;
        r215 = 0.0d;
        goto L92
    L71:
        if (Double.isNaN(r122) == true) goto L77;
        if (Double.isInfinite(r50) == true) goto L78;
        if (Double.isNaN(r50) == true) goto L78;
        r122 = Math.max(r122, r50);
        goto L78
    L16:
        if (r20 != 0.0d) goto L18;
        r17 = 0;
        goto L103
    L12:
        r24 = new a(Math.sqrt(r111), 0.0d);
        goto L13
    L8:
        r112 = new a(Math.sqrt(r111), 0.0d);
        goto L9
    }

    public final Float b(long r17, Number r19, Number r20, float r21) {
        float r5 = r19.floatValue();
        float r10 = r20.floatValue();
        long r11 = a(r5, r10, r21);
        long r12 = r17 - (((long) this.e) * 1000000);
        if (r11 < 0) goto L5;
        long r14 = r11;
    L6:
        long r13 = RangesKt.coerceIn(r12, 0, r14) / 1000000;
        c r15 = this.f11322a;
        r15.g = r10;
        return Float.valueOf(Float.intBitsToFloat((int) (r15.a(r5, r21, r13).f10098b >> 32)));
    L5:
        r14 = 0;
        goto L6
    }

    public final float c(long r17, Number r19, Number r20, float r21) {
        float r5 = r19.floatValue();
        float r10 = r20.floatValue();
        long r11 = a(r5, r10, r21);
        long r12 = r17 - (((long) this.e) * 1000000);
        if (r11 < 0) goto L5;
        long r14 = r11;
    L6:
        long r13 = RangesKt.coerceIn(r12, 0, r14) / 1000000;
        c r15 = this.f11322a;
        r15.g = r10;
        return Float.intBitsToFloat((int) (r15.a(r5, r21, r13).f10098b & 4294967295L));
    L5:
        r14 = 0;
        goto L6
    }
}
