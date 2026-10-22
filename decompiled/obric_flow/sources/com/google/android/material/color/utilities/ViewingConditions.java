package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class ViewingConditions {
    public static final ViewingConditions DEFAULT = null;
    private final double aw;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final double f8534c;

    /* JADX INFO: renamed from: fl, reason: collision with root package name */
    private final double f8535fl;
    private final double flRoot;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final double f8536n;
    private final double nbb;
    private final double nc;
    private final double ncb;
    private final double[] rgbD;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final double f8537z;

    static {
        DEFAULT = defaultWithBackgroundLstar(50.0d);
    }

    private ViewingConditions(double r5, double r10, double r11, double r12, double r13, double r14, double[] r16, double r17, double r19, double r21) {
        this.f8536n = r5;
        this.aw = r10;
        this.nbb = r11;
        this.ncb = r12;
        this.f8534c = r13;
        this.nc = r14;
        this.rgbD = r16;
        this.f8535fl = r17;
        this.flRoot = r19;
        this.f8537z = r21;
    }

    public static ViewingConditions defaultWithBackgroundLstar(double r10) {
        return make(ColorUtils.whitePointD65(), (ColorUtils.yFromLstar(50.0d) * 63.66197723675813d) / 100.0d, r10, 2.0d, false);
    }

    public static ViewingConditions make(double[] r45, double r46, double r48, double r50, boolean r52) {
        double r5 = Math.max(0.1d, r48);
        double[][] r10 = Cam16.XYZ_TO_CAM16RGB;
        double r11 = r45[0];
        double[] r12 = r10[0];
        double r13 = r12[0] * r11;
        double r15 = r45[1];
        double r17 = (r12[1] * r15) + r13;
        double r19 = r45[2];
        double r21 = (r12[2] * r19) + r17;
        double[] r14 = r10[1];
        double r18 = (r14[2] * r19) + ((r14[1] * r15) + (r14[0] * r11));
        double[] r16 = r10[2];
        double r110 = (r19 * r16[2]) + ((r15 * r16[1]) + (r11 * r16[0]));
        double r36 = (r50 / 10.0d) + 0.8d;
        if (r36 < 0.9d) goto L6;
        double r20 = MathUtils.lerp(0.59d, 0.69d, (r36 - 0.9d) * 10.0d);
    L5:
        double r34 = r20;
        if (r52 == false) goto L10;
        double r27 = 1.0d;
    L11:
        double r22 = MathUtils.clampDouble(0.0d, 1.0d, r27);
        double[] r23 = {(((100.0d / r21) * r22) + 1.0d) - r22, (((100.0d / r18) * r22) + 1.0d) - r22, (((100.0d / r110) * r22) + 1.0d) - r22};
        double r25 = 5.0d * r46;
        double r28 = 1.0d / (r25 + 1.0d);
        double r29 = ((r28 * r28) * r28) * r28;
        double r24 = 1.0d - r29;
        double r26 = (Math.cbrt(r25) * ((0.1d * r24) * r24)) + (r29 * r46);
        double r30 = ColorUtils.yFromLstar(r5) / r45[1];
        double r43 = Math.sqrt(r30) + 1.48d;
        double r31 = 0.725d / Math.pow(r30, 0.2d);
        double[] r32 = {Math.pow(((r23[0] * r26) * r21) / 100.0d, 0.42d), Math.pow(((r23[1] * r26) * r18) / 100.0d, 0.42d), Math.pow(((r23[2] * r26) * r110) / 100.0d, 0.42d)};
        double r33 = r32[0];
        double r111 = (r33 * 400.0d) / (r33 + 27.13d);
        double r35 = r32[1];
        double r112 = (r35 * 400.0d) / (r35 + 27.13d);
        double r37 = r32[2];
        double[] r38 = {r111, r112, (400.0d * r37) / (r37 + 27.13d)};
        return new ViewingConditions(r30, ((r38[2] * 0.05d) + ((r38[0] * 2.0d) + r38[1])) * r31, r31, r31, r34, r36, r23, r26, Math.pow(r26, 0.25d), r43);
    L10:
        r27 = (1.0d - (Math.exp(((-r46) - 42.0d) / 92.0d) * 0.2777777777777778d)) * r36;
        goto L11
    L6:
        r20 = MathUtils.lerp(0.525d, 0.59d, (r36 - 0.8d) * 10.0d);
        goto L5
    }

    public double getAw() {
        return this.aw;
    }

    public double getC() {
        return this.f8534c;
    }

    public double getFl() {
        return this.f8535fl;
    }

    public double getFlRoot() {
        return this.flRoot;
    }

    public double getN() {
        return this.f8536n;
    }

    public double getNbb() {
        return this.nbb;
    }

    public double getNc() {
        return this.nc;
    }

    public double getNcb() {
        return this.ncb;
    }

    public double[] getRgbD() {
        return this.rgbD;
    }

    public double getZ() {
        return this.f8537z;
    }
}
