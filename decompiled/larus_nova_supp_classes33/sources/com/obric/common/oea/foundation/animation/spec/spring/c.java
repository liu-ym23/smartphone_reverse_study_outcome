package com.obric.common.oea.foundation.animation.spec.spring;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class c {
    public static final a a(double r3) {
        if (r3 >= 0.0d) goto L6;
        return new a(0.0d, Math.sqrt(Math.abs(r3)));
    L6:
        return new a(Math.sqrt(r3), 0.0d);
    }

    /* JADX WARN: Type inference failed for: r6v4, types: [com.obric.common.oea.foundation.animation.spec.spring.FloatSpringSpecKt$estimateOverDamped$1] */
    public static final long b(float r37, float r38, float r39, float r40, float r41) {
        if (r38 != 0.0f) goto L6;
        return 9223372036854L;
    L6:
        double r1 = r37;
        double r3 = r38;
        double r5 = r39;
        double r7 = r40;
        double r9 = r41;
        double r13 = (r3 * 2.0d) * Math.sqrt(r1);
        double r15 = (r13 * r13) - (r1 * 4.0d);
        double r0 = -r13;
        a r2 = a(r15);
        r2.a = (r2.a + r0) * 0.5d;
        r2.b *= 0.5d;
        a r14 = a(r15);
        double r11 = -1;
        double r16 = r14.a * r11;
        double r10 = r14.b * r11;
        r14.a = (r16 + r0) * 0.5d;
        r14.b = r10 * 0.5d;
        if (r7 == 0.0d) goto L9;
    L11:
        int r12 = 0;
        double r17 = 0;
        if (r7 >= r17) goto L14;
        r5 = -r5;
    L14:
        double r8 = Math.abs(r7);
        double r18 = Double.MAX_VALUE;
        if (r3 <= 1.0d) goto L62;
        final double r4 = r2.a;
        final double r19 = r14.a;
        double r6 = r4 - r19;
        final double r110 = ((r4 * r8) - r5) / r6;
        final double r20 = r8 - r110;
        double r21 = r9;
        double r111 = Math.log(Math.abs(r21 / r20)) / r4;
        double r22 = Math.log(Math.abs(r21 / r110)) / r19;
        if (Double.isInfinite(r111) == false) goto L19;
    L21:
        boolean r23 = false;
    L23:
        if ((!r23) == false) goto L26;
    L36:
        double r112 = r20 * r4;
        double r310 = r22;
        final double r24 = Math.log(r112 / ((-r110) * r19)) / (r19 - r4);
        ?? r25 = new FloatSpringSpecKt$estimateOverDamped$1(r20, r4, r24, r110, r19);
        if (Double.isNaN(r24) == false) goto L39;
    L51:
        double r33 = r310;
    L52:
        r21 = -r21;
        double r26 = r33;
    L53:
        double r27 = r110 * r19;
        if (Math.abs((Math.exp(r4 * r26) * r112) + (Math.exp(r19 * r26) * r27)) < 1.0E-4d) goto L112;
        double r113 = 0.001d;
    L58:
        if (r18 <= r113) goto L112;
        if (r12 >= 100) goto L112;
        r12 = r12 + 1;
        double r114 = r4 * r26;
        double r28 = r19 * r26;
        double r115 = r26 - ((((Math.exp(r114) * r20) + (Math.exp(r28) * r110)) + r21) / ((Math.exp(r114) * r112) + (Math.exp(r28) * r27)));
        double r29 = Math.abs(r26 - r115);
        r113 = 0.001d;
        r26 = r115;
        r18 = r29;
    L112:
        return (long) (r26 * 1000.0d);
    L39:
        if (r24 <= 0.0d) goto L51;
        if (r24 > 0.0d) goto L44;
    L50:
        r26 = Math.log((-((r110 * r19) * r19)) / (r112 * r4)) / r6;
        goto L53
    L44:
        if ((-r25.invoke()) >= r21) goto L50;
        if (r110 <= 0.0d) goto L51;
        if (r20 >= 0.0d) goto L51;
        r33 = 0.0d;
        goto L52
    L26:
        if (Double.isInfinite(r22) == false) goto L28;
    L30:
        boolean r30 = false;
    L32:
        if ((!r30) == true) goto L35;
        r111 = Math.max(r111, r22);
    L35:
        r22 = r111;
        goto L36
    L28:
        if (Double.isNaN(r22) == true) goto L30;
        r30 = true;
        goto L32
    L19:
        if (Double.isNaN(r111) == true) goto L21;
        r23 = true;
        goto L23
    L62:
        double r31 = r9;
        if (r3 >= 1.0d) goto L65;
        double r32 = r2.a;
        double r34 = (r5 - (r32 * r8)) / r2.b;
        r26 = Math.log(r31 / Math.sqrt((r8 * r8) + (r34 * r34))) / r32;
        goto L112
    L65:
        double r35 = r2.a;
        double r116 = r35 * r8;
        double r36 = r5 - r116;
        double r117 = Math.log(Math.abs(r31 / r8)) / r35;
        double r118 = Math.log(Math.abs(r31 / r36));
        double r210 = r118;
        int r42 = 0;
    L67:
        if (r42 > 5) goto L69;
        r210 = r118 - Math.log(Math.abs(r210 / r35));
        r42 = r42 + 1;
        goto L67
    L69:
        double r43 = r210 / r35;
        if (Double.isInfinite(r117) == false) goto L72;
    L74:
        boolean r44 = false;
    L76:
        if ((!r44) == false) goto L79;
        r117 = r43;
    L88:
        double r45 = (-(r116 + r36)) / (r35 * r36);
        double r119 = r35 * r45;
        double r211 = Math.exp(r119) * r8;
        double r212 = (r36 * r45) * Math.exp(r119);
        double r120 = r117;
        double r121 = r211 + r212;
        if (Double.isNaN(r45) == false) goto L91;
    L103:
        r31 = -r31;
        double r46 = r120;
    L104:
        double r122 = r46;
        int r47 = 0;
    L106:
        if (r18 <= 0.001d) goto L110;
        if (r47 >= 100) goto L110;
        r47 = r47 + 1;
        double r123 = r35 * r122;
        double r124 = r122 - (((((r36 * r122) + r8) * Math.exp(r123)) + r31) / ((((((double) 1) + r123) * r36) + r116) * Math.exp(r123)));
        r18 = Math.abs(r122 - r124);
        r122 = r124;
    L110:
        r26 = r122;
        goto L112
    L91:
        if (r45 <= 0.0d) goto L103;
        if (r45 > 0.0d) goto L96;
    L102:
        r46 = (-(2.0d / r35)) - (r8 / r36);
        goto L104
    L96:
        if ((-r121) >= r31) goto L102;
        if (r36 >= r17) goto L103;
        if (r8 <= r17) goto L103;
        r120 = 0.0d;
        goto L103
    L79:
        if (Double.isInfinite(r43) == false) goto L81;
    L83:
        boolean r48 = false;
    L85:
        if ((!r48) == true) goto L88;
        r117 = Math.max(r117, r43);
        goto L88
    L81:
        if (Double.isNaN(r43) == true) goto L83;
        r48 = true;
        goto L85
    L72:
        if (Double.isNaN(r117) == true) goto L74;
        r44 = true;
        goto L76
    L9:
        if (r5 != 0.0d) goto L11;
        return 0;
    }
}
