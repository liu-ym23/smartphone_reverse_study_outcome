package com.byted.mgl.merge.service.model;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class BdpCoordinateTransformUtil {
    static double a = 6378245.0d;

    /* JADX INFO: renamed from: ee, reason: collision with root package name */
    static double f6ee = 0.006693421622965943d;
    static double pi = 3.141592653589793d;
    static double x_pi = 52.35987755982988d;

    public BdpCoordinateTransformUtil() {
    }

    public static boolean isValidLatLng(double r10, double r11) {
        if (r10 >= (-90.0d)) goto L5;
    L14:
        return false;
    L5:
        if (r10 > 90.0d) goto L14;
        if (r11 < (-180.0d)) goto L14;
        if (r11 > 180.0d) goto L14;
        return true;
    }

    public static boolean outOfChina(double r10, double r11) {
        if (r10 >= 72.004d) goto L5;
    L14:
        return true;
    L5:
        if (r10 > 137.8347d) goto L14;
        if (r11 < 0.8293d) goto L14;
        if (r11 > 55.8271d) goto L14;
        return false;
    }

    public static double[] bd09togcj02(double r10, double r11) {
        double r12 = r10 - 0.0065d;
        double r13 = r11 - 0.006d;
        double r0 = Math.sqrt((r12 * r12) + (r13 * r13)) - (Math.sin(x_pi * r13) * 2.0E-5d);
        double r14 = Math.atan2(r13, r12) - (Math.cos(r12 * x_pi) * 3.0E-6d);
        return new double[]{Math.cos(r14) * r0, r0 * Math.sin(r14)};
    }

    public static double[] bd09towgs84(double r10, double r11) {
        double[] r12 = bd09togcj02(r10, r11);
        return gcj02towgs84(r12[0], r12[1]);
    }

    public static double[] gcj02tobd09(double r10, double r11) {
        double r0 = Math.sqrt((r10 * r10) + (r11 * r11)) + (Math.sin(x_pi * r11) * 2.0E-5d);
        double r12 = Math.atan2(r11, r10) + (Math.cos(r10 * x_pi) * 3.0E-6d);
        return new double[]{(Math.cos(r12) * r0) + 0.0065d, (r0 * Math.sin(r12)) + 0.006d};
    }

    public static double[] gcj02towgs84(double r22, double r24) {
        if (outOfChina(r22, r24) == true) goto L5;
        double r10 = r22 - 105.0d;
        double r11 = r24 - 35.0d;
        double r12 = transformlat(r10, r11);
        double r13 = transformlng(r10, r11);
        double r14 = (r24 / 180.0d) * pi;
        double r15 = Math.sin(r14);
        double r16 = 1.0d - ((f6ee * r15) * r15);
        double r17 = Math.sqrt(r16);
        double r18 = a;
        double r19 = (r12 * 180.0d) / ((((1.0d - f6ee) * r18) / (r16 * r17)) * pi);
        double r20 = (r13 * 180.0d) / (((r18 / r17) * Math.cos(r14)) * pi);
        return new double[]{(r22 * 2.0d) - (r22 + r20), (r24 * 2.0d) - (r24 + r19)};
    L5:
        return new double[]{r22, r24};
    }

    public static double transformlat(double r12, double r14) {
        double r10 = r12 * 2.0d;
        return ((((((((-100.0d) + r10) + (r14 * 3.0d)) + ((r14 * 0.2d) * r14)) + ((0.1d * r12) * r14)) + (Math.sqrt(Math.abs(r12)) * 0.2d)) + ((((Math.sin((r12 * 6.0d) * pi) * 20.0d) + (Math.sin(r10 * pi) * 20.0d)) * 2.0d) / 3.0d)) + ((((Math.sin(pi * r14) * 20.0d) + (Math.sin((r14 / 3.0d) * pi) * 40.0d)) * 2.0d) / 3.0d)) + ((((Math.sin((r14 / 12.0d) * pi) * 160.0d) + (Math.sin((r14 * pi) / 30.0d) * 320.0d)) * 2.0d) / 3.0d);
    }

    public static double transformlng(double r12, double r14) {
        double r10 = r12 * 0.1d;
        return (((((((r12 + 300.0d) + (r14 * 2.0d)) + (r10 * r12)) + (r10 * r14)) + (Math.sqrt(Math.abs(r12)) * 0.1d)) + ((((Math.sin((6.0d * r12) * pi) * 20.0d) + (Math.sin((r12 * 2.0d) * pi) * 20.0d)) * 2.0d) / 3.0d)) + ((((Math.sin(pi * r12) * 20.0d) + (Math.sin((r12 / 3.0d) * pi) * 40.0d)) * 2.0d) / 3.0d)) + ((((Math.sin((r12 / 12.0d) * pi) * 150.0d) + (Math.sin((r12 / 30.0d) * pi) * 300.0d)) * 2.0d) / 3.0d);
    }

    public static double[] wgs84tobd09(double r10, double r11) {
        double[] r12 = wgs84togcj02(r10, r11);
        return gcj02tobd09(r12[0], r12[1]);
    }

    public static double[] wgs84togcj02(double r22, double r24) {
        if (outOfChina(r22, r24) == true) goto L5;
        double r10 = r22 - 105.0d;
        double r11 = r24 - 35.0d;
        double r12 = transformlat(r10, r11);
        double r13 = transformlng(r10, r11);
        double r14 = (r24 / 180.0d) * pi;
        double r15 = Math.sin(r14);
        double r16 = 1.0d - ((f6ee * r15) * r15);
        double r17 = Math.sqrt(r16);
        double r18 = a;
        double r19 = (r12 * 180.0d) / ((((1.0d - f6ee) * r18) / (r16 * r17)) * pi);
        return new double[]{r22 + ((r13 * 180.0d) / (((r18 / r17) * Math.cos(r14)) * pi)), r24 + r19};
    L5:
        return new double[]{r22, r24};
    }
}
