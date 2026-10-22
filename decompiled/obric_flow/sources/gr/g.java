package gr;

/* JADX INFO: loaded from: classes3.dex */
public final class g extends qo.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public double[] f17149a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public double[][] f17150b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public double[] f17151c;

    @Override // qo.a
    public final double[] A() {
        return this.f17149a;
    }

    @Override // qo.a
    public final double v(double r11) {
        double[] r5 = this.f17149a;
        int r10 = r5.length;
        double r12 = r5[0];
        double[][] r13 = this.f17150b;
        if (r11 <= r12) goto L5;
        int r14 = r10 - 1;
        double r15 = r5[r14];
        if (r11 >= r15) goto L9;
        int r16 = 0;
    L11:
        if (r16 >= r14) goto L21;
        double r17 = r5[r16];
        if (r11 == r17) goto L15;
        int r18 = r16 + 1;
        double r19 = r5[r18];
        if (r11 < r19) goto L18;
        r16 = r18;
        goto L11
    L18:
        double r110 = (r11 - r17) / (r19 - r17);
        double r20 = r13[r16][0];
        return (r13[r18][0] * r110) + ((1.0d - r110) * r20);
    L15:
        return r13[r16][0];
    L21:
        return 0.0d;
    L9:
        return (y(r15) * (r11 - r15)) + r13[r14][0];
    L5:
        return (y(r12) * (r11 - r12)) + r13[0][0];
    }

    @Override // qo.a
    public final void w(double r15, double[] r17) {
        double[] r5 = this.f17149a;
        int r10 = r5.length;
        double[][] r11 = this.f17150b;
        int r12 = 0;
        int r13 = r11[0].length;
        double r14 = r5[0];
        double[] r16 = this.f17151c;
        if (r15 > r14) goto L8;
        z(r14, r16);
        int r18 = 0;
    L5:
        if (r18 >= r13) goto L7;
        r17[r18] = ((r15 - r5[0]) * r16[r18]) + r11[0][r18];
        r18 = r18 + 1;
        goto L5
    L7:
        return;
    L8:
        int r19 = r10 - 1;
        double r20 = r5[r19];
        if (r15 < r20) goto L14;
        z(r20, r16);
    L11:
        if (r12 >= r13) goto L13;
        r17[r12] = ((r15 - r5[r19]) * r16[r12]) + r11[r19][r12];
        r12 = r12 + 1;
        goto L11
    L13:
        return;
    L14:
        int r21 = 0;
    L16:
        if (r21 >= (r10 - 1)) goto L29;
        if (r15 != r5[r21]) goto L22;
        int r22 = 0;
    L20:
        if (r22 >= r13) goto L22;
        r17[r22] = r11[r21][r22];
        r22 = r22 + 1;
    L22:
        int r23 = r21 + 1;
        double r24 = r5[r23];
        if (r15 < r24) goto L24;
        r21 = r23;
        goto L16
    L24:
        double r25 = r5[r21];
        double r26 = (r15 - r25) / (r24 - r25);
    L25:
        if (r12 >= r13) goto L27;
        double r27 = r11[r21][r12];
        r17[r12] = (r11[r23][r12] * r26) + ((1.0d - r26) * r27);
        r12 = r12 + 1;
        goto L25
    L27:
        return;
    }

    @Override // qo.a
    public final void x(double r15, float[] r17) {
        double[] r5 = this.f17149a;
        int r10 = r5.length;
        double[][] r11 = this.f17150b;
        int r12 = 0;
        int r13 = r11[0].length;
        double r14 = r5[0];
        double[] r16 = this.f17151c;
        if (r15 > r14) goto L8;
        z(r14, r16);
        int r18 = 0;
    L5:
        if (r18 >= r13) goto L7;
        r17[r18] = (float) (((r15 - r5[0]) * r16[r18]) + r11[0][r18]);
        r18 = r18 + 1;
        goto L5
    L7:
        return;
    L8:
        int r19 = r10 - 1;
        double r20 = r5[r19];
        if (r15 < r20) goto L14;
        z(r20, r16);
    L11:
        if (r12 >= r13) goto L13;
        r17[r12] = (float) (((r15 - r5[r19]) * r16[r12]) + r11[r19][r12]);
        r12 = r12 + 1;
        goto L11
    L13:
        return;
    L14:
        int r21 = 0;
    L16:
        if (r21 >= (r10 - 1)) goto L29;
        if (r15 != r5[r21]) goto L22;
        int r22 = 0;
    L20:
        if (r22 >= r13) goto L22;
        r17[r22] = (float) r11[r21][r22];
        r22 = r22 + 1;
    L22:
        int r23 = r21 + 1;
        double r24 = r5[r23];
        if (r15 < r24) goto L24;
        r21 = r23;
        goto L16
    L24:
        double r25 = r5[r21];
        double r26 = (r15 - r25) / (r24 - r25);
    L25:
        if (r12 >= r13) goto L27;
        double r27 = r11[r21][r12];
        r17[r12] = (float) ((r11[r23][r12] * r26) + ((1.0d - r26) * r27));
        r12 = r12 + 1;
        goto L25
    L27:
        return;
    }

    @Override // qo.a
    public final double y(double r10) {
        double[] r5 = this.f17149a;
        int r11 = r5.length;
        double r12 = r5[0];
        if (r10 >= r12) goto L5;
    L4:
        r10 = r12;
    L8:
        int r13 = 0;
    L10:
        if (r13 >= (r11 - 1)) goto L16;
        int r14 = r13 + 1;
        double r15 = r5[r14];
        if (r10 <= r15) goto L13;
        r13 = r14;
        goto L10
    L13:
        double r16 = r15 - r5[r13];
        double[][] r17 = this.f17150b;
        return (r17[r14][0] - r17[r13][0]) / r16;
    L16:
        return 0.0d;
    L5:
        r12 = r5[r11 - 1];
        if (r10 < r12) goto L8;
        goto L8
    }

    @Override // qo.a
    public final void z(double r10, double[] r12) {
        double[] r5 = this.f17149a;
        int r11 = r5.length;
        double[][] r13 = this.f17150b;
        int r14 = 0;
        int r15 = r13[0].length;
        double r16 = r5[0];
        if (r10 > r16) goto L5;
    L4:
        r10 = r16;
    L8:
        int r17 = 0;
    L10:
        if (r17 >= (r11 - 1)) goto L17;
        int r18 = r17 + 1;
        double r19 = r5[r18];
        if (r10 <= r19) goto L13;
        r17 = r18;
        goto L10
    L13:
        double r20 = r19 - r5[r17];
    L14:
        if (r14 >= r15) goto L21;
        r12[r14] = (r13[r18][r14] - r13[r17][r14]) / r20;
        r14 = r14 + 1;
        goto L14
    L21:
        return;
    L17:
        return;
    L5:
        r16 = r5[r11 - 1];
        if (r10 < r16) goto L8;
        goto L8
    }
}
