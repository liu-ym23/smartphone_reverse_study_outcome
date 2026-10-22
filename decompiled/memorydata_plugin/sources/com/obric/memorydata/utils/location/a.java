package com.obric.memorydata.utils.location;

/* JADX INFO: loaded from: classes5.dex */
public class a {
    public static Point a(double r3, double r5) {
        double[] r0 = b(r3, r5);
        double r6 = r5 + r0[1];
        return new Point(r3 + r0[0], r6);
    }

    public static double[] b(double r17, double r19) {
        double r1 = r17 - 35.0d;
        double r3 = r19 - 105.0d;
        double r5 = c(r1, r3);
        double r2 = d(r1, r3);
        double r7 = (r17 / 180.0d) * 3.141592653589793d;
        double r11 = Math.sin(r7);
        double r12 = 1.0d - ((0.006693421622965943d * r11) * r11);
        double r13 = Math.sqrt(r12);
        return new double[]{(r2 * 180.0d) / ((6335552.717000426d / (r12 * r13)) * 3.141592653589793d), (r5 * 180.0d) / (((6378245.0d / r13) * Math.cos(r7)) * 3.141592653589793d)};
    }

    private static double c(double r16, double r18) {
        double r8 = r18 * 0.1d;
        return (((((((r18 + 300.0d) + (r16 * 2.0d)) + (r8 * r18)) + (r8 * r16)) + (Math.sqrt(Math.abs(r18)) * 0.1d)) + ((((Math.sin((6.0d * r18) * 3.141592653589793d) * 20.0d) + (Math.sin((r18 * 2.0d) * 3.141592653589793d) * 20.0d)) * 2.0d) / 3.0d)) + ((((Math.sin(r18 * 3.141592653589793d) * 20.0d) + (Math.sin((r18 / 3.0d) * 3.141592653589793d) * 40.0d)) * 2.0d) / 3.0d)) + ((((Math.sin((r18 / 12.0d) * 3.141592653589793d) * 150.0d) + (Math.sin((r18 / 30.0d) * 3.141592653589793d) * 300.0d)) * 2.0d) / 3.0d);
    }

    private static double d(double r16, double r18) {
        double r2 = r18 * 2.0d;
        double r4 = ((((((-100.0d) + r2) + (r16 * 3.0d)) + ((r16 * 0.2d) * r16)) + ((0.1d * r18) * r16)) + (Math.sqrt(Math.abs(r18)) * 0.2d)) + ((((Math.sin((6.0d * r18) * 3.141592653589793d) * 20.0d) + (Math.sin(r2 * 3.141592653589793d) * 20.0d)) * 2.0d) / 3.0d);
        double r3 = r16 * 3.141592653589793d;
        return (r4 + ((((Math.sin(r3) * 20.0d) + (Math.sin((r16 / 3.0d) * 3.141592653589793d) * 40.0d)) * 2.0d) / 3.0d)) + ((((Math.sin((r16 / 12.0d) * 3.141592653589793d) * 160.0d) + (Math.sin(r3 / 30.0d) * 320.0d)) * 2.0d) / 3.0d);
    }
}
