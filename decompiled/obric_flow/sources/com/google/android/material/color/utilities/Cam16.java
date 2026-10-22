package com.google.android.material.color.utilities;

import ai.j0;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class Cam16 {
    static final double[][] CAM16RGB_TO_XYZ = null;
    static final double[][] XYZ_TO_CAM16RGB = null;
    private final double astar;
    private final double bstar;
    private final double chroma;
    private final double hue;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final double f8522j;
    private final double jstar;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final double f8523m;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final double f8524q;
    private final double s;
    private final double[] tempArray;

    static {
        XYZ_TO_CAM16RGB = new double[][]{new double[]{0.401288d, 0.650173d, -0.051461d}, new double[]{-0.250268d, 1.204414d, 0.045854d}, new double[]{-0.002079d, 0.048952d, 0.953127d}};
        CAM16RGB_TO_XYZ = new double[][]{new double[]{1.8620678d, -1.0112547d, 0.14918678d}, new double[]{0.38752654d, 0.62144744d, -0.00897398d}, new double[]{-0.0158415d, -0.03412294d, 1.0499644d}};
    }

    private Cam16(double r5, double r10, double r11, double r12, double r13, double r14, double r16, double r18, double r20) {
        this.tempArray = new double[]{0.0d, 0.0d, 0.0d};
        this.hue = r5;
        this.chroma = r10;
        this.f8522j = r11;
        this.f8524q = r12;
        this.f8523m = r13;
        this.s = r14;
        this.jstar = r16;
        this.astar = r18;
        this.bstar = r20;
    }

    public static Cam16 fromInt(int r5) {
        return fromIntInViewingConditions(r5, ViewingConditions.DEFAULT);
    }

    public static Cam16 fromIntInViewingConditions(int r18, ViewingConditions r19) {
        double r5 = ColorUtils.linearized((16711680 & r18) >> 16);
        double r10 = ColorUtils.linearized((65280 & r18) >> 8);
        double r11 = ColorUtils.linearized(r18 & 255);
        double r12 = 0.35762064d * r10;
        double r13 = r12 + (0.41233895d * r5);
        double r14 = (0.18051042d * r11) + r13;
        double r15 = 0.7152d * r10;
        double r16 = r15 + (0.2126d * r5);
        double r17 = (0.0722d * r11) + r16;
        double r20 = r10 * 0.11916382d;
        double r21 = r11 * 0.95034478d;
        return fromXyzInViewingConditions(r14, r17, r21 + (r20 + (r5 * 0.01932141d)), r19);
    }

    public static Cam16 fromJch(double r10, double r11, double r12) {
        return fromJchInViewingConditions(r10, r11, r12, ViewingConditions.DEFAULT);
    }

    private static Cam16 fromJchInViewingConditions(double r23, double r25, double r27, ViewingConditions r29) {
        double r10 = 4.0d / r29.getC();
        double r13 = r23 / 100.0d;
        double r11 = Math.sqrt(r13) * r10;
        double r12 = ((r29.getAw() + 4.0d) * r11) * r29.getFlRoot();
        double r15 = r29.getFlRoot() * r25;
        double r14 = r25 / Math.sqrt(r13);
        double r16 = Math.sqrt((r29.getC() * r14) / (r29.getAw() + 4.0d)) * 50.0d;
        double r17 = Math.toRadians(r27);
        double r18 = (1.7000000000000002d * r23) / ((0.007d * r23) + 1.0d);
        double r19 = 43.859649122807014d * Math.log1p(r15 * 0.0228d);
        return new Cam16(r27, r25, r23, r12, r15, r16, r18, Math.cos(r17) * r19, Math.sin(r17) * r19);
    }

    public static Cam16 fromUcs(double r10, double r11, double r12) {
        return fromUcsInViewingConditions(r10, r11, r12, ViewingConditions.DEFAULT);
    }

    public static Cam16 fromUcsInViewingConditions(double r11, double r13, double r15, ViewingConditions r17) {
        double r10 = (Math.expm1(Math.hypot(r13, r15) * 0.0228d) / 0.0228d) / r17.getFlRoot();
        double r5 = Math.atan2(r15, r13) * 57.29577951308232d;
        if (r5 >= 0.0d) goto L5;
        r5 = r5 + 360.0d;
    L5:
        double r12 = r5;
        return fromJchInViewingConditions(r11 / (1.0d - ((r11 - 100.0d) * 0.007d)), r10, r12, r17);
    }

    public static Cam16 fromXyzInViewingConditions(double r39, double r41, double r43, ViewingConditions r45) {
        double[][] r5 = XYZ_TO_CAM16RGB;
        double[] r10 = r5[0];
        double r11 = r10[0] * r39;
        double r12 = (r10[1] * r41) + r11;
        double r13 = (r10[2] * r43) + r12;
        double[] r14 = r5[1];
        double r15 = r14[0] * r39;
        double r16 = (r14[1] * r41) + r15;
        double r17 = (r14[2] * r43) + r16;
        double[] r18 = r5[2];
        double r19 = r18[0] * r39;
        double r110 = (r18[1] * r41) + r19;
        double r111 = (r18[2] * r43) + r110;
        double r20 = r45.getRgbD()[0] * r13;
        double r21 = r45.getRgbD()[1] * r17;
        double r22 = r45.getRgbD()[2] * r111;
        double r23 = r45.getFl();
        double r24 = Math.pow((Math.abs(r20) * r23) / 100.0d, 0.42d);
        double r112 = r45.getFl();
        double r113 = Math.pow((Math.abs(r21) * r112) / 100.0d, 0.42d);
        double r114 = r45.getFl();
        double r115 = Math.pow((Math.abs(r22) * r114) / 100.0d, 0.42d);
        double r25 = ((Math.signum(r20) * 400.0d) * r24) / (r24 + 27.13d);
        double r26 = ((Math.signum(r21) * 400.0d) * r113) / (r113 + 27.13d);
        double r27 = ((Math.signum(r22) * 400.0d) * r115) / (r115 + 27.13d);
        double r116 = (-12.0d) * r26;
        double r117 = ((r116 + (r25 * 11.0d)) + r27) / 11.0d;
        double r28 = ((r25 + r26) - (r27 * 2.0d)) / 9.0d;
        double r29 = r26 * 20.0d;
        double r118 = 21.0d * r27;
        double r119 = (r118 + ((r25 * 20.0d) + r29)) / 20.0d;
        double r30 = (((r25 * 40.0d) + r29) + r27) / 20.0d;
        double r31 = Math.toDegrees(Math.atan2(r28, r117));
        if (r31 >= 0.0d) goto L7;
        r31 = r31 + 360.0d;
    L5:
        double r210 = r31;
        double r32 = Math.toRadians(r210);
        double r211 = Math.pow((r45.getNbb() * r30) / r45.getAw(), r45.getC() * r45.getZ()) * 100.0d;
        double r33 = 4.0d / r45.getC();
        double r34 = r211 / 100.0d;
        double r120 = Math.sqrt(r34) * r33;
        double r35 = (r45.getAw() + 4.0d) * r120;
        double r212 = r45.getFlRoot() * r35;
        if (r210 >= 20.14d) goto L12;
        double r121 = r210 + 360.0d;
    L13:
        double r36 = ((Math.cos(Math.toRadians(r121) + 2.0d) + 3.8d) * 0.25d) * 3846.153846153846d;
        double r122 = r45.getNc() * r36;
        double r37 = r45.getNcb() * r122;
        double r38 = (Math.hypot(r117, r28) * r37) / (r119 + 0.305d);
        double r40 = Math.pow(1.64d - Math.pow(0.29d, r45.getN()), 0.73d);
        double r42 = Math.pow(r38, 0.9d) * r40;
        double r44 = Math.sqrt(r34) * r42;
        double r46 = r45.getFlRoot() * r44;
        double r310 = Math.sqrt((r45.getC() * r42) / (r45.getAw() + 4.0d)) * 50.0d;
        double r311 = (1.7000000000000002d * r211) / ((0.007d * r211) + 1.0d);
        double r47 = Math.log1p(r46 * 0.0228d) * 43.859649122807014d;
        return new Cam16(r210, r44, r211, r212, r46, r310, r311, Math.cos(r32) * r47, Math.sin(r32) * r47);
    L12:
        r121 = r210;
        goto L13
    L7:
        if (r31 < 360.0d) goto L5;
        r31 = r31 - 360.0d;
        goto L5
    }

    public double distance(Cam16 r10) {
        double r5 = getJstar() - r10.getJstar();
        double r11 = getAstar() - r10.getAstar();
        double r12 = getBstar() - r10.getBstar();
        double r13 = r11 * r11;
        double r14 = r12 * r12;
        return Math.pow(Math.sqrt(r14 + (r13 + (r5 * r5))), 0.63d) * 1.41d;
    }

    public double getAstar() {
        return this.astar;
    }

    public double getBstar() {
        return this.bstar;
    }

    public double getChroma() {
        return this.chroma;
    }

    public double getHue() {
        return this.hue;
    }

    public double getJ() {
        return this.f8522j;
    }

    public double getJstar() {
        return this.jstar;
    }

    public double getM() {
        return this.f8523m;
    }

    public double getQ() {
        return this.f8524q;
    }

    public double getS() {
        return this.s;
    }

    public int toInt() {
        return viewed(ViewingConditions.DEFAULT);
    }

    public int viewed(ViewingConditions r10) {
        double[] r11 = xyzInViewingConditions(r10, this.tempArray);
        return ColorUtils.argbFromXyz(r11[0], r11[1], r11[2]);
    }

    public double[] xyzInViewingConditions(ViewingConditions r24, double[] r25) {
        if (getChroma() != 0.0d) goto L5;
    L8:
        double r5 = 0.0d;
    L9:
        double r10 = Math.pow(r5 / Math.pow(1.64d - Math.pow(0.29d, r24.getN()), 0.73d), 1.1111111111111112d);
        double r11 = Math.toRadians(getHue());
        double r12 = (Math.cos(2.0d + r11) + 3.8d) * 0.25d;
        double r13 = Math.pow(getJ() / 100.0d, (1.0d / r24.getC()) / r24.getZ()) * r24.getAw();
        double r14 = r24.getNcb() * (r24.getNc() * (r12 * 3846.153846153846d));
        double r15 = r13 / r24.getNbb();
        double r16 = Math.sin(r11);
        double r17 = Math.cos(r11);
        double r21 = (((0.305d + r15) * 23.0d) * r10) / (((r10 * 108.0d) * r16) + j0.B(r10, 11.0d, r17, r14 * 23.0d));
        double r18 = r17 * r21;
        double r22 = r21 * r16;
        double r19 = r15 * 460.0d;
        double r20 = ((288.0d * r22) + ((451.0d * r18) + r19)) / 1403.0d;
        double r110 = ((r19 - (891.0d * r18)) - (261.0d * r22)) / 1403.0d;
        double r23 = ((r19 - (r18 * 220.0d)) - (r22 * 6300.0d)) / 1403.0d;
        double r26 = Math.pow(Math.max(0.0d, (Math.abs(r20) * 27.13d) / (400.0d - Math.abs(r20))), 2.380952380952381d) * ((100.0d / r24.getFl()) * Math.signum(r20));
        double r111 = Math.pow(Math.max(0.0d, (Math.abs(r110) * 27.13d) / (400.0d - Math.abs(r110))), 2.380952380952381d) * ((100.0d / r24.getFl()) * Math.signum(r110));
        double r27 = Math.pow(Math.max(0.0d, (Math.abs(r23) * 27.13d) / (400.0d - Math.abs(r23))), 2.380952380952381d) * ((100.0d / r24.getFl()) * Math.signum(r23));
        double r28 = r26 / r24.getRgbD()[0];
        double r112 = r111 / r24.getRgbD()[1];
        double r29 = r27 / r24.getRgbD()[2];
        double[][] r30 = CAM16RGB_TO_XYZ;
        double[] r31 = r30[0];
        double r32 = (r31[2] * r29) + ((r31[1] * r112) + (r31[0] * r28));
        double[] r113 = r30[1];
        double r114 = (r113[2] * r29) + ((r113[1] * r112) + (r113[0] * r28));
        double[] r33 = r30[2];
        double r34 = (r29 * r33[2]) + ((r112 * r33[1]) + (r28 * r33[0]));
        if (r25 == null) goto L14;
        r25[0] = r32;
        r25[1] = r114;
        r25[2] = r34;
        return r25;
    L14:
        return new double[]{r32, r114, r34};
    L5:
        if (getJ() == 0.0d) goto L8;
        r5 = getChroma() / Math.sqrt(getJ() / 100.0d);
        goto L9
    }
}
