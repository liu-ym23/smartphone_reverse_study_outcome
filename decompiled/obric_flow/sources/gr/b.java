package gr;

import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends qo.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final double[] f17138a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a[] f17139b;

    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v7 */
    public b(int[] r33, double[] r34, double[][] r35) {
        b r5 = this;
        double[] r10 = r34;
        r5.f17138a = r10;
        int r11 = 1;
        r5.f17139b = new a[r10.length - 1];
        ?? r12 = 0;
        int r13 = 0;
        int r14 = 1;
        int r15 = 1;
    L3:
        a[] r16 = r5.f17139b;
        if (r13 >= r16.length) goto L91;
        int r17 = r33[r13];
        if (r17 == 0) goto L21;
        if (r17 != r11) goto L9;
    L20:
        r14 = r11;
    L18:
        r15 = r14;
    L22:
        double r18 = r10[r13];
        int r19 = r13 + 1;
        double r110 = r10[r19];
        double[] r111 = r35[r13];
        double r20 = r111[r12];
        double r21 = r111[r11];
        double[] r112 = r35[r19];
        double r113 = r112[r12];
        int r22 = r13;
        int r23 = r14;
        double r24 = r112[r11];
        a r25 = new a();
        r25.f17137r = r12;
        double r26 = r113 - r20;
        double r114 = r24 - r21;
        boolean r115 = true;
        if (r15 != 1) goto L25;
        r25.f17136q = true;
    L40:
        r25.f17126c = r16;
        r25.d = r110;
        double r116 = r110 - r18;
        double r27 = 1.0d / r116;
        r25.f17128i = r27;
        if (3 != r15) goto L44;
        r25.f17137r = r115;
    L44:
        if (r25.f17137r == false) goto L46;
    L49:
        a r28 = r25;
        r28.f17137r = true;
        r28.e = r20;
        r28.f = r113;
        r28.g = r21;
        r28.f17127h = r24;
        double r29 = Math.hypot(r114, r26);
        r28.f17125b = r29;
        r28.f17133n = r29 * r27;
        r28.f17131l = r26 / r116;
        r28.f17132m = r114 / r116;
    L90:
        r16[r22] = r28;
        r5 = this;
        r10 = r34;
        r13 = r19;
        r14 = r23;
        r12 = 0;
        r11 = 1;
        goto L3
    L46:
        if (Math.abs(r26) < 0.001d) goto L49;
        if (Math.abs(r114) < 0.001d) goto L49;
        r25.f17124a = new double[101];
        boolean r30 = r25.f17136q;
        if (r30 == false) goto L53;
        int r117 = -1;
    L54:
        r25.f17129j = ((double) r117) * r26;
        if (r30 == false) goto L57;
        int r118 = 1;
    L58:
        r25.f17130k = r114 * ((double) r118);
        if (r30 == false) goto L61;
        double r119 = r113;
    L62:
        r25.f17131l = r119;
        if (r30 == false) goto L65;
        double r120 = r21;
    L66:
        r25.f17132m = r120;
        double r31 = r21 - r24;
        double r121 = 0.0d;
        double r122 = 0.0d;
        double r123 = 0.0d;
        int r32 = 0;
    L67:
        double[] r36 = a.s;
        if (r32 >= 91) goto L74;
        a r210 = r25;
        double r211 = r121;
        double r37 = Math.toRadians((((double) r32) * 90.0d) / ((double) 90));
        double r38 = Math.sin(r37) * r26;
        double r39 = Math.cos(r37) * r31;
        if (r32 <= 0) goto L72;
        r121 = Math.hypot(r38 - r122, r39 - r123) + r211;
        r36[r32] = r121;
    L73:
        r32 = r32 + 1;
        r123 = r39;
        r122 = r38;
        r25 = r210;
        goto L67
    L72:
        r121 = r211;
        goto L73
    L74:
        r28 = r25;
        r28.f17125b = r121;
        int r40 = 0;
    L75:
        if (r40 >= 91) goto L77;
        r36[r40] = r36[r40] / r121;
        r40 = r40 + 1;
        goto L75
    L77:
        int r41 = 0;
    L78:
        double[] r42 = r28.f17124a;
        if (r41 >= r42.length) goto L88;
        double r43 = ((double) r41) / ((double) (r42.length - 1));
        int r44 = Arrays.binarySearch(r36, r43);
        if (r44 < 0) goto L84;
        r42[r41] = ((double) r44) / ((double) 90);
    L87:
        r41 = r41 + 1;
        goto L78
    L84:
        if (r44 != (-1)) goto L86;
        r42[r41] = 0.0d;
        goto L87
    L86:
        int r45 = -r44;
        int r46 = r45 - 2;
        double r124 = r36[r46];
        r42[r41] = (((r43 - r124) / (r36[r45 - 1] - r124)) + ((double) r46)) / ((double) 90);
        goto L87
    L88:
        r28.f17133n = r28.f17125b * r28.f17128i;
        goto L90
    L65:
        r120 = r24;
        goto L66
    L61:
        r119 = r20;
        goto L62
    L57:
        r118 = -1;
        goto L58
    L53:
        r117 = 1;
        goto L54
    L25:
        if (r15 == 4) goto L35;
        if (r15 == 5) goto L30;
        r25.f17136q = false;
    L29:
        r115 = true;
        goto L40
    L30:
        boolean r125 = false;
        if (r114 >= 0.0d) goto L33;
        r125 = true;
    L33:
        r25.f17136q = r125;
        goto L29
    L35:
        if (r114 <= 0.0d) goto L37;
        boolean r126 = true;
    L38:
        r25.f17136q = r126;
        goto L29
    L37:
        r126 = false;
        goto L38
    L9:
        if (r17 == 2) goto L19;
        if (r17 == 3) goto L16;
        if (r17 == 4) goto L15;
        if (r17 != 5) goto L22;
        r15 = 5;
        goto L22
    L15:
        r15 = 4;
        goto L22
    L16:
        if (r14 != r11) goto L20;
    L19:
        r14 = 2;
        goto L18
    L21:
        r15 = 3;
        goto L22
    }

    @Override // qo.a
    public final double[] A() {
        return this.f17138a;
    }

    @Override // qo.a
    public final double v(double r10) {
        a[] r5 = this.f17139b;
        int r11 = 0;
        a r12 = r5[0];
        double r13 = r12.f17126c;
        if (r10 >= r13) goto L11;
        double r14 = r10 - r13;
        if (r12.f17137r == true) goto L7;
        r12.g(r13);
        return (r5[0].a() * r14) + r5[0].e();
    L7:
        return (r14 * r5[0].f17131l) + r12.c(r13);
    L11:
        if (r10 <= r5[r5.length - 1].d) goto L15;
        double r15 = r5[r5.length - 1].d;
        double r16 = r10 - r15;
        int r17 = r5.length - 1;
        return (r16 * r5[r17].f17131l) + r5[r17].c(r15);
    L15:
        if (r11 >= r5.length) goto L25;
        a r18 = r5[r11];
        if (r10 <= r18.d) goto L19;
        r11 = r11 + 1;
        goto L15
    L19:
        if (r18.f17137r == true) goto L21;
        r18.g(r10);
        return r5[r11].e();
    L21:
        return r18.c(r10);
    L25:
        return Double.NaN;
    }

    @Override // qo.a
    public final void w(double r11, double[] r13) {
        a[] r10 = this.f17139b;
        a r5 = r10[0];
        double r12 = r5.f17126c;
        if (r11 >= r12) goto L10;
        double r14 = r11 - r12;
        if (r5.f17137r == false) goto L7;
        double r15 = r5.c(r12);
        a r16 = r10[0];
        r13[0] = (r16.f17131l * r14) + r15;
        r13[1] = (r14 * r10[0].f17132m) + r16.d(r12);
        return;
    L7:
        r5.g(r12);
        r13[0] = (r10[0].a() * r14) + r10[0].e();
        r13[1] = (r10[0].b() * r14) + r10[0].f();
        return;
    L10:
        if (r11 <= r10[r10.length - 1].d) goto L16;
        double r17 = r10[r10.length - 1].d;
        double r18 = r11 - r17;
        int r19 = r10.length - 1;
        a r20 = r10[r19];
        if (r20.f17137r == false) goto L14;
        double r110 = r20.c(r17);
        a r21 = r10[r19];
        r13[0] = (r21.f17131l * r18) + r110;
        r13[1] = (r18 * r10[r19].f17132m) + r21.d(r17);
        return;
    L14:
        r20.g(r11);
        r13[0] = (r10[r19].a() * r18) + r10[r19].e();
        r13[1] = (r10[r19].b() * r18) + r10[r19].f();
        return;
    L16:
        int r22 = 0;
    L18:
        if (r22 >= r10.length) goto L28;
        a r23 = r10[r22];
        if (r11 <= r23.d) goto L22;
        r22 = r22 + 1;
        goto L18
    L22:
        if (r23.f17137r == false) goto L25;
        r13[0] = r23.c(r11);
        r13[1] = r10[r22].d(r11);
        return;
    L25:
        r23.g(r11);
        r13[0] = r10[r22].e();
        r13[1] = r10[r22].f();
        return;
    }

    @Override // qo.a
    public final void x(double r11, float[] r13) {
        a[] r10 = this.f17139b;
        a r5 = r10[0];
        double r12 = r5.f17126c;
        if (r11 >= r12) goto L10;
        double r14 = r11 - r12;
        if (r5.f17137r == false) goto L7;
        double r15 = r5.c(r12);
        a r16 = r10[0];
        r13[0] = (float) ((r16.f17131l * r14) + r15);
        r13[1] = (float) ((r14 * r10[0].f17132m) + r16.d(r12));
        return;
    L7:
        r5.g(r12);
        r13[0] = (float) ((r10[0].a() * r14) + r10[0].e());
        r13[1] = (float) ((r10[0].b() * r14) + r10[0].f());
        return;
    L10:
        if (r11 <= r10[r10.length - 1].d) goto L16;
        double r17 = r10[r10.length - 1].d;
        double r18 = r11 - r17;
        int r19 = r10.length - 1;
        a r20 = r10[r19];
        if (r20.f17137r == false) goto L14;
        double r110 = r20.c(r17);
        a r21 = r10[r19];
        r13[0] = (float) ((r21.f17131l * r18) + r110);
        r13[1] = (float) ((r18 * r10[r19].f17132m) + r21.d(r17));
        return;
    L14:
        r20.g(r11);
        r13[0] = (float) r10[r19].e();
        r13[1] = (float) r10[r19].f();
        return;
    L16:
        int r22 = 0;
    L18:
        if (r22 >= r10.length) goto L28;
        a r23 = r10[r22];
        if (r11 <= r23.d) goto L22;
        r22 = r22 + 1;
        goto L18
    L22:
        if (r23.f17137r == false) goto L25;
        r13[0] = (float) r23.c(r11);
        r13[1] = (float) r10[r22].d(r11);
        return;
    L25:
        r23.g(r11);
        r13[0] = (float) r10[r22].e();
        r13[1] = (float) r10[r22].f();
        return;
    }

    @Override // qo.a
    public final double y(double r5) {
        a[] r10 = this.f17139b;
        int r11 = 0;
        double r12 = r10[0].f17126c;
        if (r5 >= r12) goto L6;
        r5 = r12;
    L6:
        if (r5 <= r10[r10.length - 1].d) goto L9;
        r5 = r10[r10.length - 1].d;
    L9:
        if (r11 >= r10.length) goto L19;
        a r13 = r10[r11];
        if (r5 <= r13.d) goto L13;
        r11 = r11 + 1;
        goto L9
    L13:
        if (r13.f17137r == true) goto L15;
        r13.g(r5);
        return r10[r11].a();
    L15:
        return r13.f17131l;
    L19:
        return Double.NaN;
    }

    @Override // qo.a
    public final void z(double r10, double[] r11) {
        a[] r12 = this.f17139b;
        double r5 = r12[0].f17126c;
        if (r10 >= r5) goto L6;
        r10 = r5;
    L8:
        int r13 = 0;
    L10:
        if (r13 >= r12.length) goto L20;
        a r14 = r12[r13];
        if (r10 <= r14.d) goto L14;
        r13 = r13 + 1;
        goto L10
    L14:
        if (r14.f17137r == false) goto L17;
        r11[0] = r14.f17131l;
        r11[1] = r14.f17132m;
        return;
    L17:
        r14.g(r10);
        r11[0] = r12[r13].a();
        r11[1] = r12[r13].b();
        return;
    L20:
        return;
    L6:
        if (r10 <= r12[r12.length - 1].d) goto L8;
        r10 = r12[r12.length - 1].d;
        goto L8
    }
}
