package com.lynx.component.svg.parser;

import android.graphics.Matrix;
import android.graphics.Path;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f9797a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f9798b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f9799c;

    public d(float r5, float r10) {
        this.f9799c = null;
        this.f9797a = r5;
        this.f9798b = r10;
    }

    public d(r0 r42) {
        d r5 = this;
        r0 r10 = r42;
        r5.f9799c = new Path();
        if (r10 == null) goto L86;
        int r11 = 0;
        int r12 = 0;
    L7:
        if (r11 >= r10.f9864a) goto L96;
        byte r13 = ((byte[]) r10.f9866c)[r11];
        if (r13 == 8) goto L84;
        if (r13 == 0) goto L83;
        boolean r14 = true;
        if (r13 != 1) goto L14;
        int r18 = r11;
        d r15 = r5;
        r0 r16 = r10;
        float[] r17 = (float[]) r16.d;
        int r19 = r12 + 1;
        float r20 = r17[r12];
        r12 = r12 + 2;
        float r21 = r17[r19];
        ((Path) r15.f9799c).lineTo(r20, r21);
        r15.f9797a = r20;
        r15.f9798b = r21;
    L85:
        r10 = r16;
        r5 = r15;
        r11 = r18 + 1;
        goto L7
    L14:
        if (r13 != 2) goto L16;
        r18 = r11;
        r15 = r5;
        r16 = r10;
        float[] r22 = (float[]) r16.d;
        float r23 = r22[r12];
        float r24 = r22[r12 + 1];
        float r25 = r22[r12 + 2];
        float r26 = r22[r12 + 3];
        int r27 = r12 + 5;
        float r110 = r22[r12 + 4];
        r12 = r12 + 6;
        float r28 = r22[r27];
        ((Path) r15.f9799c).cubicTo(r23, r24, r25, r26, r110, r28);
        r15.f9797a = r110;
        r15.f9798b = r28;
        goto L85
    L16:
        if (r13 != 3) goto L18;
        r18 = r11;
        r15 = r5;
        r16 = r10;
        float[] r29 = (float[]) r16.d;
        float r30 = r29[r12];
        float r31 = r29[r12 + 1];
        int r32 = r12 + 3;
        float r33 = r29[r12 + 2];
        r12 = r12 + 4;
        float r34 = r29[r32];
        ((Path) r15.f9799c).quadTo(r30, r31, r33, r34);
        r15.f9797a = r33;
        r15.f9798b = r34;
        goto L85
    L18:
        if ((r13 & 2) == 0) goto L20;
        boolean r35 = true;
    L22:
        if ((r13 & 1) != 0) goto L25;
        r14 = false;
    L25:
        float[] r36 = (float[]) r10.d;
        float r37 = r36[r12];
        float r38 = r36[r12 + 1];
        float r111 = r36[r12 + 2];
        int r112 = r12 + 4;
        float r113 = r36[r12 + 3];
        int r39 = r12 + 5;
        float r40 = r36[r112];
        float r114 = r5.f9797a;
        float r115 = r5.f9798b;
        if (r114 != r113) goto L31;
        if (r115 != r40) goto L31;
        r18 = r11;
        int r210 = r39;
        float r41 = r40;
        float r43 = r113;
        r15 = r5;
    L79:
        r15.f9797a = r43;
        r15.f9798b = r41;
        r16 = r42;
        r12 = r210;
    L31:
        if (r37 != 0.0f) goto L33;
    L34:
        r18 = r11;
        r210 = r39;
        r15 = r5;
        r43 = r113;
        r41 = r40;
        ((Path) r15.f9799c).lineTo(r43, r41);
        r15.f9797a = r43;
        r15.f9798b = r41;
        goto L79
    L33:
        if (r38 == 0.0f) goto L34;
        float r44 = Math.abs(r37);
        float r45 = Math.abs(r38);
        double r116 = Math.toRadians(((double) r111) % 360.0d);
        double r117 = Math.cos(r116);
        double r118 = Math.sin(r116);
        r18 = r11;
        double r46 = ((double) (r114 - r113)) / 2.0d;
        r210 = r39;
        double r47 = ((double) (r115 - r40)) / 2.0d;
        double r48 = (r118 * r47) + (r117 * r46);
        double r49 = (r47 * r117) + ((-r118) * r46);
        double r50 = r44 * r44;
        double r119 = r45 * r45;
        double r211 = r48 * r48;
        double r212 = r49 * r49;
        double r310 = (r212 / r119) + (r211 / r50);
        if (r310 <= 0.99999d) goto L39;
        double r51 = Math.sqrt(r310) * 1.00001d;
        r44 = (float) (((double) r44) * r51);
        r45 = (float) (r51 * ((double) r45));
        r50 = r44 * r44;
        r119 = r45 * r45;
    L39:
        if (r35 != r14) goto L41;
        double r311 = -1.0d;
    L42:
        double r312 = r50 * r119;
        double r52 = r50 * r212;
        double r120 = r119 * r211;
        double r313 = ((r312 - r52) - r120) / (r52 + r120);
        if (r313 >= 0.0d) goto L45;
        r313 = 0.0d;
    L45:
        double r121 = Math.sqrt(r313) * r311;
        double r53 = r44;
        boolean r314 = r14;
        double r54 = r45;
        double r213 = ((r53 * r49) / r54) * r121;
        float r315 = r45;
        float r316 = r44;
        double r122 = r121 * (-((r54 * r48) / r53));
        double r55 = ((r117 * r213) - (r118 * r122)) + (((double) (r114 + r113)) / 2.0d);
        double r123 = ((r117 * r122) + (r118 * r213)) + (((double) (r115 + r40)) / 2.0d);
        double r124 = (r48 - r213) / r53;
        double r125 = (r49 - r122) / r54;
        double r56 = ((-r48) - r213) / r53;
        double r57 = ((-r49) - r122) / r54;
        double r58 = (r125 * r125) + (r124 * r124);
        double r59 = Math.sqrt(r58);
        if (r125 >= 0.0d) goto L48;
        double r126 = -1.0d;
    L49:
        double r60 = Math.acos(r124 / r59) * r126;
        double r61 = Math.sqrt(((r57 * r57) + (r56 * r56)) * r58);
        double r214 = (r125 * r57) + (r124 * r56);
        if (((r124 * r57) - (r125 * r56)) >= 0.0d) goto L52;
        double r62 = -1.0d;
    L53:
        double r215 = r214 / r61;
        if (r215 >= (-1.0d)) goto L57;
        double r127 = 3.141592653589793d;
    L60:
        double r63 = r62 * r127;
        if (r63 != 0.0d) goto L63;
        ((Path) this.f9799c).lineTo(r113, r40);
        this.f9797a = r113;
        this.f9798b = r40;
        r15 = this;
        r43 = r113;
        r41 = r40;
        goto L79
    L63:
        float r128 = r113;
        float r129 = r40;
        if (r314 == true) goto L67;
        if (r63 <= 0.0d) goto L67;
        r63 = r63 - 6.283185307179586d;
    L71:
        double r64 = r63 % 6.283185307179586d;
        double r65 = r60 % 6.283185307179586d;
        int r66 = (int) Math.ceil((Math.abs(r64) * 2.0d) / 3.141592653589793d);
        double r67 = r64 / ((double) r66);
        double r68 = r67 / 2.0d;
        double r130 = (Math.sin(r68) * 1.3333333333333333d) / (Math.cos(r68) + 1.0d);
        int r69 = r66 * 6;
        float[] r70 = new float[r69];
        int r71 = 0;
        int r131 = 0;
    L72:
        if (r71 >= r66) goto L74;
        float r216 = r128;
        double r132 = (((double) r71) * r67) + r65;
        double r133 = Math.cos(r132);
        double r217 = Math.sin(r132);
        r70[r131] = (float) (r133 - (r130 * r217));
        r70[r131 + 1] = (float) ((r133 * r130) + r217);
        double r134 = r132 + r67;
        double r72 = Math.cos(r134);
        double r135 = Math.sin(r134);
        r70[r131 + 2] = (float) ((r130 * r135) + r72);
        r70[r131 + 3] = (float) (r135 - (r130 * r72));
        int r73 = r131 + 5;
        r70[r131 + 4] = (float) r72;
        r131 = r131 + 6;
        r70[r73] = (float) r135;
        r71 = r71 + 1;
        r128 = r216;
        r67 = r67;
        r129 = r129;
        r66 = r66;
        r65 = r65;
        goto L72
    L74:
        float r218 = r128;
        float r219 = r129;
        Matrix r74 = new Matrix();
        r74.postScale(r316, r315);
        r74.postRotate(r111);
        r74.postTranslate((float) r55, (float) r123);
        r74.mapPoints(r70);
        r70[r69 - 2] = r218;
        r70[r69 - 1] = r219;
        int r75 = 0;
    L75:
        if (r75 >= r69) goto L77;
        float r76 = r70[r75];
        float r77 = r70[r75 + 1];
        float r136 = r70[r75 + 2];
        float r137 = r70[r75 + 3];
        float r78 = r70[r75 + 4];
        float r79 = r70[r75 + 5];
        ((Path) this.f9799c).cubicTo(r76, r77, r136, r137, r78, r79);
        this.f9797a = r78;
        this.f9798b = r79;
        r75 = r75 + 6;
        goto L75
    L77:
        r15 = this;
        r43 = r218;
        r41 = r219;
    L67:
        if (r314 == false) goto L71;
        if (r63 >= 0.0d) goto L71;
        r63 = r63 + 6.283185307179586d;
        goto L71
    L57:
        if (r215 <= 1.0d) goto L59;
        r127 = 0.0d;
        goto L60
    L59:
        r127 = Math.acos(r215);
        goto L60
    L52:
        r62 = 1.0d;
        goto L53
    L48:
        r126 = 1.0d;
        goto L49
    L41:
        r311 = 1.0d;
        goto L42
    L20:
        r35 = false;
        goto L22
    L83:
        r18 = r11;
        r15 = r5;
        r16 = r10;
        float[] r80 = (float[]) r16.d;
        int r81 = r12 + 1;
        float r82 = r80[r12];
        r12 = r12 + 2;
        float r83 = r80[r81];
        ((Path) r15.f9799c).moveTo(r82, r83);
        r15.f9797a = r82;
        r15.f9798b = r83;
        goto L85
    L84:
        r18 = r11;
        r15 = r5;
        r16 = r10;
        ((Path) r15.f9799c).close();
        goto L85
    L96:
        return;
    }
}
