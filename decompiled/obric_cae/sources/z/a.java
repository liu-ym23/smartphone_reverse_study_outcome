package z;

import android.graphics.Color;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f14124a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f14125b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f14126c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f14127d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f14128e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f14129f;

    public a(float r8, float r10, float r11, float r12, float r13, float r14) {
        this.f14124a = r8;
        this.f14125b = r10;
        this.f14126c = r11;
        this.f14127d = r12;
        this.f14128e = r13;
        this.f14129f = r14;
    }

    public static a a(int r21) {
        j r8 = j.f14157k;
        float r10 = zc.b.e(Color.red(r21));
        float r11 = zc.b.e(Color.green(r21));
        float r12 = zc.b.e(Color.blue(r21));
        float[][] r13 = zc.b.f14336f;
        float[] r14 = r13[0];
        float r15 = (r14[2] * r12) + ((r14[1] * r11) + (r14[0] * r10));
        float[] r16 = r13[1];
        float r17 = (r16[2] * r12) + ((r16[1] * r11) + (r16[0] * r10));
        float[] r18 = r13[2];
        float r19 = (r12 * r18[2]) + ((r11 * r18[1]) + (r10 * r18[0]));
        float[][] r20 = zc.b.f14333c;
        float[] r22 = r20[0];
        float r23 = (r22[2] * r19) + ((r22[1] * r17) + (r22[0] * r15));
        float[] r24 = r20[1];
        float r25 = (r24[2] * r19) + ((r24[1] * r17) + (r24[0] * r15));
        float[] r26 = r20[2];
        float r27 = (r19 * r26[2]) + ((r17 * r26[1]) + (r15 * r26[0]));
        float[] r28 = r8.f14164g;
        float r29 = r28[0] * r23;
        float r30 = r28[1] * r25;
        float r31 = r28[2] * r27;
        float r32 = Math.abs(r29);
        float r33 = r8.f14165h;
        float r34 = (float) Math.pow(((double) (r32 * r33)) / 100.0d, 0.42d);
        float r35 = (float) Math.pow(((double) (Math.abs(r30) * r33)) / 100.0d, 0.42d);
        float r36 = (float) Math.pow(((double) (Math.abs(r31) * r33)) / 100.0d, 0.42d);
        float r37 = ((Math.signum(r29) * 400.0f) * r34) / (r34 + 27.13f);
        float r38 = ((Math.signum(r30) * 400.0f) * r35) / (r35 + 27.13f);
        float r39 = ((Math.signum(r31) * 400.0f) * r36) / (r36 + 27.13f);
        double r40 = r39;
        float r41 = ((float) (((((double) r38) * (-12.0d)) + (((double) r37) * 11.0d)) + r40)) / 11.0f;
        float r42 = ((float) (((double) (r37 + r38)) - (r40 * 2.0d))) / 9.0f;
        float r43 = r38 * 20.0f;
        float r110 = ((21.0f * r39) + ((r37 * 20.0f) + r43)) / 20.0f;
        float r44 = (((r37 * 40.0f) + r43) + r39) / 20.0f;
        float r45 = (((float) Math.atan2(r42, r41)) * 180.0f) / 3.1415927f;
        if (r45 >= 0.0f) goto L6;
        r45 = r45 + 360.0f;
    L8:
        float r111 = r45;
        float r46 = (3.1415927f * r111) / 180.0f;
        float r47 = r44 * r8.f14159b;
        float r48 = r8.f14158a;
        double r49 = r47 / r48;
        float r50 = r8.f14167j;
        float r51 = r8.f14161d;
        float r52 = ((float) Math.pow(r49, r50 * r51)) * 100.0f;
        Math.sqrt(r52 / 100.0f);
        float r53 = r48 + 4.0f;
        if (r111 >= 20.14d) goto L11;
        float r112 = 360.0f + r111;
    L12:
        float r54 = ((float) Math.pow(1.64d - Math.pow(0.29d, r8.f14163f), 0.73d)) * ((float) Math.pow((((((((float) (Math.cos(((((double) r112) * 3.141592653589793d) / 180.0d) + 2.0d) + 3.8d)) * 0.25f) * 3846.1538f) * r8.f14162e) * r8.f14160c) * ((float) Math.sqrt((r42 * r42) + (r41 * r41)))) / (r110 + 0.305f), 0.9d));
        float r113 = r54 * ((float) Math.sqrt(((double) r52) / 100.0d));
        float r55 = r8.f14166i * r113;
        Math.sqrt((r54 * r51) / r53);
        float r114 = (1.7f * r52) / ((0.007f * r52) + 1.0f);
        float r56 = ((float) Math.log((r55 * 0.0228f) + 1.0f)) * 43.85965f;
        double r57 = r46;
        return new a(r111, r113, r52, r114, r56 * ((float) Math.cos(r57)), r56 * ((float) Math.sin(r57)));
    L11:
        r112 = r111;
        goto L12
    L6:
        if (r45 < 360.0f) goto L8;
        r45 = r45 - 360.0f;
        goto L8
    }

    public static a b(float r12, float r13, float r14) {
        j r8 = j.f14157k;
        float r10 = r8.f14161d;
        double r11 = ((double) r12) / 100.0d;
        Math.sqrt(r11);
        float r15 = r8.f14158a + 4.0f;
        float r16 = r8.f14166i * r13;
        Math.sqrt(((r13 / ((float) Math.sqrt(r11))) * r8.f14161d) / r15);
        float r17 = (1.7f * r12) / ((0.007f * r12) + 1.0f);
        float r18 = ((float) Math.log((((double) r16) * 0.0228d) + 1.0d)) * 43.85965f;
        double r19 = (3.1415927f * r14) / 180.0f;
        return new a(r14, r13, r12, r17, r18 * ((float) Math.cos(r19)), r18 * ((float) Math.sin(r19)));
    }

    public final int c(j r16) {
        float r8 = this.f14125b;
        double r10 = r8;
        float r11 = this.f14126c;
        if (r10 == 0.0d) goto L8;
        double r12 = r11;
        if (r12 == 0.0d) goto L8;
        float r13 = r8 / ((float) Math.sqrt(r12 / 100.0d));
    L9:
        float r14 = (float) Math.pow(((double) r13) / Math.pow(1.64d - Math.pow(0.29d, r16.f14163f), 0.73d), 1.1111111111111112d);
        double r15 = (this.f14124a * 3.1415927f) / 180.0f;
        float r17 = ((float) (Math.cos(2.0d + r15) + 3.8d)) * 0.25f;
        float r18 = r16.f14158a * ((float) Math.pow(((double) r11) / 100.0d, (1.0d / ((double) r16.f14161d)) / ((double) r16.f14167j)));
        float r19 = ((r17 * 3846.1538f) * r16.f14162e) * r16.f14160c;
        float r20 = r18 / r16.f14159b;
        float r21 = (float) Math.sin(r15);
        float r22 = (float) Math.cos(r15);
        float r23 = (11.0f * r14) * r22;
        float r24 = (((0.305f + r20) * 23.0f) * r14) / (((r14 * 108.0f) * r21) + (r23 + (r19 * 23.0f)));
        float r25 = r22 * r24;
        float r26 = r24 * r21;
        float r27 = r20 * 460.0f;
        float r28 = ((288.0f * r26) + ((451.0f * r25) + r27)) / 1403.0f;
        float r29 = ((r27 - (891.0f * r25)) - (261.0f * r26)) / 1403.0f;
        float r30 = ((r27 - (r25 * 220.0f)) - (r26 * 6300.0f)) / 1403.0f;
        float r31 = (float) Math.max(0.0d, (((double) Math.abs(r28)) * 27.13d) / (400.0d - ((double) Math.abs(r28))));
        float r32 = Math.signum(r28);
        float r33 = 100.0f / r16.f14165h;
        float r34 = (r32 * r33) * ((float) Math.pow(r31, 2.380952380952381d));
        float r35 = (Math.signum(r29) * r33) * ((float) Math.pow((float) Math.max(0.0d, (((double) Math.abs(r29)) * 27.13d) / (400.0d - ((double) Math.abs(r29)))), 2.380952380952381d));
        float r36 = (Math.signum(r30) * r33) * ((float) Math.pow((float) Math.max(0.0d, (((double) Math.abs(r30)) * 27.13d) / (400.0d - ((double) Math.abs(r30)))), 2.380952380952381d));
        float[] r37 = r16.f14164g;
        float r38 = r34 / r37[0];
        float r39 = r35 / r37[1];
        float r40 = r36 / r37[2];
        float[][] r41 = zc.b.f14334d;
        float[] r42 = r41[0];
        float r43 = (r42[2] * r40) + ((r42[1] * r39) + (r42[0] * r38));
        float[] r44 = r41[1];
        float r45 = (r44[2] * r40) + ((r44[1] * r39) + (r44[0] * r38));
        float[] r46 = r41[2];
        return a0.a.a(r43, r45, (r40 * r46[2]) + ((r39 * r46[1]) + (r38 * r46[0])));
    L8:
        r13 = 0.0f;
        goto L9
    }
}
