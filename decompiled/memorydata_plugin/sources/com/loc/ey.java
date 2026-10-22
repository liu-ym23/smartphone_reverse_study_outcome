package com.loc;

import android.content.Context;
import com.amap.api.location.DPoint;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class ey {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static double f5517a = 3.141592653589793d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final List<DPoint> f5518b = null;

    static {
        f5518b = new ArrayList(Arrays.asList(new DPoint[]{new DPoint(23.379947d, 119.757001d), new DPoint(24.983296d, 120.474496d), new DPoint(25.518722d, 121.359866d), new DPoint(25.41329d, 122.443582d), new DPoint(24.862708d, 122.288354d), new DPoint(24.461292d, 122.188319d), new DPoint(21.584761d, 120.968923d), new DPoint(21.830837d, 120.654445d)}));
    }

    private static double a(double r4) {
        return Math.sin((r4 * 3000.0d) * (f5517a / 180.0d)) * 2.0E-5d;
    }

    private static double a(double r6, double r8) {
        return (Math.cos(r8 / 100000.0d) * (r6 / 18000.0d)) + (Math.sin(r6 / 100000.0d) * (r8 / 9000.0d));
    }

    private static DPoint a(double r2, double r4, double r6, double r8) {
        DPoint r0 = new DPoint();
        double r7 = r2 - r6;
        double r9 = r4 - r8;
        DPoint r1 = d(r7, r9);
        r0.setLongitude(c((r2 + r7) - r1.getLongitude()));
        r0.setLatitude(c((r4 + r9) - r1.getLatitude()));
        return r0;
    }

    public static DPoint a(Context r2, DPoint r3) {
        if (((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")) != null) goto L7;
        return null;
    L7:
        return b(r3);
    }

    public static DPoint a(DPoint r5) {
        if (r5 != null) goto L14;
    L13:
        return r5;
    L14:
    L11:
        th = move-exception;
        ev.a(th, "OffsetUtil", "b2G");
        goto L13
    L4:
        if (ev.a(r5.getLatitude(), r5.getLongitude()) == false) goto L8;
        return c(r5);
    L8:
        if (e(r5.getLatitude(), r5.getLongitude()) == false) goto L15;
        DPoint r0 = c(r5);     // Catch: Throwable -> L11
        return f(r0.getLatitude(), r0.getLongitude());
    L15:
        return r5;
    }

    private static double b(double r4) {
        return Math.cos((r4 * 3000.0d) * (f5517a / 180.0d)) * 3.0E-6d;
    }

    private static double b(double r6, double r8) {
        return (Math.sin(r8 / 100000.0d) * (r6 / 18000.0d)) + (Math.cos(r6 / 100000.0d) * (r8 / 9000.0d));
    }

    public static DPoint b(Context r4, DPoint r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
    L8:
        th = move-exception;
        ev.a(th, "OffsetUtil", "marbar2G");
        return r5;
    L4:
        if (ev.a(r5.getLatitude(), r5.getLongitude()) == true) goto L6;
        return r5;
    L6:
        return a(r6, c(r5.getLongitude(), r5.getLatitude()));
    }

    private static DPoint b(DPoint r6) {
    L7:
        th = move-exception;
        ev.a(th, "OffsetUtil", "cover part2");
        return r6;
    L3:
        if (ev.a(r6.getLatitude(), r6.getLongitude()) == false) goto L6;
        double[] r0 = fe.a(r6.getLongitude(), r6.getLatitude());     // Catch: Throwable -> L7
        return new DPoint(r0[1], r0[0]);
    L6:
        return r6;
    }

    private static double c(double r1) {
        return new BigDecimal(r1).setScale(8, 4).doubleValue();
    }

    private static DPoint c(double r11, double r13) {
        double r12 = ((long) (r11 * 100000.0d)) % 36000000;
        double r14 = ((long) (r13 * 100000.0d)) % 36000000;
        double r4 = (int) ((-a(r12, r14)) + r12);
        double r2 = (int) ((-b(r12, r14)) + r14);
        double r5 = (-a(r4, r2)) + r12;
        int r15 = 1;
        if (r12 <= 0.0d) goto L5;
        int r16 = 1;
    L6:
        double r6 = (int) (r5 + ((double) r16));
        double r3 = (-b(r6, r2)) + r14;
        if (r14 > 0.0d) goto L11;
        r15 = -1;
    L11:
        return new DPoint(((double) ((int) (r3 + ((double) r15)))) / 100000.0d, r6 / 100000.0d);
    L5:
        r16 = -1;
        goto L6
    }

    private static DPoint c(DPoint r14) {
        DPoint r4 = null;
        int r5 = 0;
        double r10 = 0.006401062d;
        double r12 = 0.0060424805d;
    L4:
        if (r5 >= 2) goto L6;
        r4 = a(r14.getLongitude(), r14.getLatitude(), r10, r12);
        r10 = r14.getLongitude() - r4.getLongitude();
        r12 = r14.getLatitude() - r4.getLatitude();
        r5 = r5 + 1;
        goto L4
    L6:
        return r4;
    }

    private static DPoint d(double r9, double r11) {
        DPoint r0 = new DPoint();
        double r5 = (r9 * r9) + (r11 * r11);
        double r1 = (Math.cos(b(r9) + Math.atan2(r11, r9)) * (a(r11) + Math.sqrt(r5))) + 0.0065d;
        double r10 = (Math.sin(b(r9) + Math.atan2(r11, r9)) * (a(r11) + Math.sqrt(r5))) + 0.006d;
        r0.setLongitude(c(r1));
        r0.setLatitude(c(r10));
        return r0;
    }

    private static boolean e(double r1, double r3) {
        if (ev.a(new DPoint(r1, r3), f5518b) == false) goto L6;
        return true;
    L6:
        return false;
    }

    private static DPoint f(double r5, double r7) {
        DPoint r0 = g(r5, r7);
        double r8 = (r7 * 2.0d) - r0.getLongitude();
        return new DPoint((r5 * 2.0d) - r0.getLatitude(), r8);
    }

    private static DPoint g(double r14, double r16) {
        double r0 = r16 - 105.0d;
        double r2 = r14 - 35.0d;
        double r4 = h(r0, r2);
        double r1 = i(r0, r2);
        double r6 = (r14 / 180.0d) * f5517a;
        double r8 = Math.sin(r6);
        double r9 = 1.0d - ((0.006693421622965943d * r8) * r8);
        double r10 = Math.sqrt(r9);
        double r5 = (r4 * 180.0d) / ((6335552.717000426d / (r9 * r10)) * f5517a);
        double r3 = (r1 * 180.0d) / (((6378245.0d / r10) * Math.cos(r6)) * f5517a);
        return new DPoint(r14 + r5, r16 + r3);
    }

    private static double h(double r12, double r14) {
        double r2 = r12 * 2.0d;
        return ((((((((-100.0d) + r2) + (r14 * 3.0d)) + ((r14 * 0.2d) * r14)) + ((0.1d * r12) * r14)) + (Math.sqrt(Math.abs(r12)) * 0.2d)) + ((((Math.sin((r12 * 6.0d) * f5517a) * 20.0d) + (Math.sin(r2 * f5517a) * 20.0d)) * 2.0d) / 3.0d)) + ((((Math.sin(f5517a * r14) * 20.0d) + (Math.sin((r14 / 3.0d) * f5517a) * 40.0d)) * 2.0d) / 3.0d)) + ((((Math.sin((r14 / 12.0d) * f5517a) * 160.0d) + (Math.sin((r14 * f5517a) / 30.0d) * 320.0d)) * 2.0d) / 3.0d);
    }

    private static double i(double r12, double r14) {
        double r8 = r12 * 0.1d;
        return (((((((r12 + 300.0d) + (r14 * 2.0d)) + (r8 * r12)) + (r8 * r14)) + (Math.sqrt(Math.abs(r12)) * 0.1d)) + ((((Math.sin((6.0d * r12) * f5517a) * 20.0d) + (Math.sin((r12 * 2.0d) * f5517a) * 20.0d)) * 2.0d) / 3.0d)) + ((((Math.sin(f5517a * r12) * 20.0d) + (Math.sin((r12 / 3.0d) * f5517a) * 40.0d)) * 2.0d) / 3.0d)) + ((((Math.sin((r12 / 12.0d) * f5517a) * 150.0d) + (Math.sin((r12 / 30.0d) * f5517a) * 300.0d)) * 2.0d) / 3.0d);
    }
}
