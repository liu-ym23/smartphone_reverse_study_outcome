package gr;

import ai.j0;
import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes3.dex */
public final class h extends qo.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final double[] f17152a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final double[][] f17153b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final double[][] f17154c;
    public final double[] d;

    public h(double[] r22, double[][] r23) {
        int r5 = r22.length;
        int r10 = r23[0].length;
        this.d = new double[r10];
        int r11 = r5 - 1;
        Class r12 = Double.TYPE;
        double[][] r13 = (double[][]) Array.newInstance(r12, new int[]{r11, r10});
        double[][] r14 = (double[][]) Array.newInstance(r12, new int[]{r5, r10});
        int r15 = 0;
    L3:
        if (r15 >= r10) goto L12;
        int r16 = 0;
    L5:
        if (r16 >= r11) goto L11;
        int r17 = r16 + 1;
        double r18 = r22[r17] - r22[r16];
        double[] r19 = r13[r16];
        double r110 = (r23[r17][r15] - r23[r16][r15]) / r18;
        r19[r15] = r110;
        if (r16 != 0) goto L9;
        r14[r16][r15] = r110;
    L10:
        r16 = r17;
        goto L5
    L9:
        r14[r16][r15] = (r13[r16 - 1][r15] + r110) * 0.5d;
        goto L10
    L11:
        r14[r11][r15] = r13[r5 - 2][r15];
        r15 = r15 + 1;
        goto L3
    L12:
        int r20 = 0;
    L13:
        if (r20 >= r11) goto L24;
        int r21 = 0;
    L15:
        if (r21 >= r10) goto L23;
        double r111 = r13[r20][r21];
        if (r111 != 0.0d) goto L19;
        r14[r20][r21] = 0.0d;
        r14[r20 + 1][r21] = 0.0d;
    L22:
        r21 = r21 + 1;
        goto L15
    L19:
        double r112 = r14[r20][r21] / r111;
        int r113 = r20 + 1;
        double r114 = r14[r113][r21] / r111;
        double r115 = Math.hypot(r112, r114);
        if (r115 <= 9.0d) goto L22;
        double r116 = 3.0d / r115;
        double[] r117 = r14[r20];
        double[] r118 = r13[r20];
        r117[r21] = (r112 * r116) * r118[r21];
        r14[r113][r21] = (r116 * r114) * r118[r21];
        goto L22
    L23:
        r20 = r20 + 1;
        goto L13
    L24:
        this.f17152a = r22;
        this.f17153b = r23;
        this.f17154c = r14;
    }

    public static double B(double r12, double r14, double r16, double r18, double r20, double r22) {
        double r10 = r14 * r14;
        double r11 = r14 * 6.0d;
        double r5 = r11 * r18;
        double r13 = j0.B(r10, 6.0d, r16, r5 + (((-6.0d) * r10) * r18)) - (r11 * r16);
        double r15 = r12 * 3.0d;
        double r17 = (j0.B(r15, r20, r10, j0.B(r15, r22, r10, r13)) - (((2.0d * r12) * r22) * r14)) - (((4.0d * r12) * r20) * r14);
        return (r12 * r20) + r17;
    }

    public static double C(double r16, double r18, double r20, double r22, double r24, double r26) {
        double r10 = r18 * r18;
        double r11 = r10 * r18;
        double r12 = r10 * 3.0d;
        double r5 = r12 * r22;
        double r13 = (j0.B(r11, 2.0d, r20, r5 + (((-2.0d) * r11) * r22)) - (r12 * r20)) + r20;
        double r14 = r16 * r26;
        double r15 = (r14 * r11) + r13;
        double r17 = r16 * r24;
        double r19 = (((r11 * r17) + r15) - (r14 * r10)) - (((r16 * 2.0d) * r24) * r10);
        return (r17 * r18) + r19;
    }

    @Override // qo.a
    public final double[] A() {
        return this.f17152a;
    }

    @Override // qo.a
    public final double v(double r25) {
        double[] r5 = this.f17152a;
        int r10 = r5.length;
        double r11 = r5[0];
        double[][] r12 = this.f17153b;
        if (r25 > r11) goto L7;
        double r13 = r12[0][0];
        double r14 = r25 - r11;
        double r15 = y(r11);
    L6:
        return (r15 * r14) + r13;
    L7:
        int r16 = r10 - 1;
        double r17 = r5[r16];
        if (r25 < r17) goto L10;
        r13 = r12[r16][0];
        r14 = r25 - r17;
        r15 = y(r17);
        goto L6
    L10:
        int r18 = 0;
    L11:
        if (r18 >= r16) goto L21;
        double r19 = r5[r18];
        if (r25 == r19) goto L15;
        int r20 = r18 + 1;
        double r21 = r5[r20];
        if (r25 < r21) goto L18;
        r18 = r20;
        goto L11
    L18:
        double r110 = r21 - r19;
        double r111 = (r25 - r19) / r110;
        double r112 = r12[r18][0];
        double r113 = r12[r20][0];
        double[][] r22 = this.f17154c;
        return C(r110, r111, r112, r113, r22[r18][0], r22[r20][0]);
    L15:
        return r12[r18][0];
    L21:
        return 0.0d;
    }

    @Override // qo.a
    public final void w(double r23, double[] r25) {
        double[] r5 = this.f17152a;
        int r10 = r5.length;
        double[][] r11 = this.f17153b;
        int r12 = 0;
        int r13 = r11[0].length;
        double r14 = r5[0];
        double[] r15 = this.d;
        if (r23 > r14) goto L8;
        z(r14, r15);
        int r16 = 0;
    L5:
        if (r16 >= r13) goto L7;
        r25[r16] = ((r23 - r5[0]) * r15[r16]) + r11[0][r16];
        r16 = r16 + 1;
        goto L5
    L7:
        return;
    L8:
        int r17 = r10 - 1;
        double r18 = r5[r17];
        if (r23 < r18) goto L14;
        z(r18, r15);
    L11:
        if (r12 >= r13) goto L13;
        r25[r12] = ((r23 - r5[r17]) * r15[r12]) + r11[r17][r12];
        r12 = r12 + 1;
        goto L11
    L13:
        return;
    L14:
        int r19 = 0;
    L16:
        if (r19 >= (r10 - 1)) goto L29;
        if (r23 != r5[r19]) goto L22;
        int r20 = 0;
    L20:
        if (r20 >= r13) goto L22;
        r25[r20] = r11[r19][r20];
        r20 = r20 + 1;
    L22:
        int r21 = r19 + 1;
        double r22 = r5[r21];
        if (r23 < r22) goto L24;
        r19 = r21;
        goto L16
    L24:
        double r24 = r5[r19];
        double r26 = r22 - r24;
        double r27 = (r23 - r24) / r26;
    L25:
        if (r12 >= r13) goto L27;
        double r110 = r11[r19][r12];
        double r111 = r11[r21][r12];
        double[][] r112 = this.f17154c;
        r25[r12] = C(r26, r27, r110, r111, r112[r19][r12], r112[r21][r12]);
        r12 = r12 + 1;
        goto L25
    L27:
        return;
    }

    @Override // qo.a
    public final void x(double r23, float[] r25) {
        double[] r5 = this.f17152a;
        int r10 = r5.length;
        double[][] r11 = this.f17153b;
        int r12 = 0;
        int r13 = r11[0].length;
        double r14 = r5[0];
        double[] r15 = this.d;
        if (r23 > r14) goto L8;
        z(r14, r15);
        int r16 = 0;
    L5:
        if (r16 >= r13) goto L7;
        r25[r16] = (float) (((r23 - r5[0]) * r15[r16]) + r11[0][r16]);
        r16 = r16 + 1;
        goto L5
    L7:
        return;
    L8:
        int r17 = r10 - 1;
        double r18 = r5[r17];
        if (r23 < r18) goto L14;
        z(r18, r15);
    L11:
        if (r12 >= r13) goto L13;
        r25[r12] = (float) (((r23 - r5[r17]) * r15[r12]) + r11[r17][r12]);
        r12 = r12 + 1;
        goto L11
    L13:
        return;
    L14:
        int r19 = 0;
    L16:
        if (r19 >= (r10 - 1)) goto L29;
        if (r23 != r5[r19]) goto L22;
        int r20 = 0;
    L20:
        if (r20 >= r13) goto L22;
        r25[r20] = (float) r11[r19][r20];
        r20 = r20 + 1;
    L22:
        int r21 = r19 + 1;
        double r22 = r5[r21];
        if (r23 < r22) goto L24;
        r19 = r21;
        goto L16
    L24:
        double r24 = r5[r19];
        double r26 = r22 - r24;
        double r27 = (r23 - r24) / r26;
    L25:
        if (r12 >= r13) goto L27;
        double r110 = r11[r19][r12];
        double r111 = r11[r21][r12];
        double[][] r112 = this.f17154c;
        r25[r12] = (float) C(r26, r27, r110, r111, r112[r19][r12], r112[r21][r12]);
        r12 = r12 + 1;
        goto L25
    L27:
        return;
    }

    @Override // qo.a
    public final double y(double r23) {
        double[] r5 = this.f17152a;
        int r10 = r5.length;
        double r11 = r5[0];
        if (r23 < r11) goto L9;
        r11 = r5[r10 - 1];
        if (r23 >= r11) goto L9;
        r11 = r23;
    L9:
        int r12 = 0;
    L11:
        if (r12 >= (r10 - 1)) goto L17;
        int r13 = r12 + 1;
        double r14 = r5[r13];
        if (r11 <= r14) goto L14;
        r12 = r13;
        goto L11
    L14:
        double r15 = r5[r12];
        double r16 = r14 - r15;
        double r17 = (r11 - r15) / r16;
        double[][] r18 = this.f17153b;
        double r19 = r18[r12][0];
        double r110 = r18[r13][0];
        double[][] r20 = this.f17154c;
        return B(r16, r17, r19, r110, r20[r12][0], r20[r13][0]) / r16;
    L17:
        return 0.0d;
    }

    @Override // qo.a
    public final void z(double r25, double[] r27) {
        double[] r5 = this.f17152a;
        int r10 = r5.length;
        double[][] r11 = this.f17153b;
        int r12 = 0;
        int r13 = r11[0].length;
        double r14 = r5[0];
        if (r25 <= r14) goto L9;
        r14 = r5[r10 - 1];
        if (r25 >= r14) goto L9;
        r14 = r25;
    L9:
        int r15 = 0;
    L11:
        if (r15 >= (r10 - 1)) goto L18;
        int r16 = r15 + 1;
        double r17 = r5[r16];
        if (r14 <= r17) goto L14;
        r15 = r16;
        goto L11
    L14:
        double r18 = r5[r15];
        double r19 = r17 - r18;
        double r20 = (r14 - r18) / r19;
    L15:
        if (r12 >= r13) goto L22;
        double r110 = r11[r15][r12];
        double r111 = r11[r16][r12];
        double[][] r21 = this.f17154c;
        r27[r12] = B(r19, r20, r110, r111, r21[r15][r12], r21[r16][r12]) / r19;
        r12 = r12 + 1;
        goto L15
    L22:
        return;
    }
}
