package n4a;

import android.content.Context;
import com.amap.api.location.DPoint;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class e4 {
    public static final List<DPoint> a = null;

    static {
        a = new ArrayList(Arrays.asList(new DPoint[]{new DPoint(23.379947d, 119.757001d), new DPoint(24.983296d, 120.474496d), new DPoint(25.518722d, 121.359866d), new DPoint(25.41329d, 122.443582d), new DPoint(24.862708d, 122.288354d), new DPoint(24.461292d, 122.188319d), new DPoint(21.584761d, 120.968923d), new DPoint(21.830837d, 120.654445d)}));
    }

    public static double a(double r6, double r8) {
        return (Math.cos(r8 / 100000.0d) * (r6 / 18000.0d)) + (Math.sin(r6 / 100000.0d) * (r8 / 9000.0d));
    }

    public static double d(double r6, double r8) {
        return (Math.sin(r8 / 100000.0d) * (r6 / 18000.0d)) + (Math.cos(r6 / 100000.0d) * (r8 / 9000.0d));
    }

    public static double f(double r1) {
        return new BigDecimal(r1).setScale(8, 4).doubleValue();
    }

    public static DPoint c(DPoint r5) {
        if (r5 != null) goto L14;
    L13:
        return r5;
    L14:
    L11:
        th = move-exception;
        c4.g(th, "OffsetUtil", "b2G");
        goto L13
    L4:
        if (c4.h(r5.getLatitude(), r5.getLongitude()) == false) goto L8;
        return g(r5);
    L8:
        if (c4.j(new DPoint(r5.getLatitude(), r5.getLongitude()), a) == false) goto L15;
        DPoint r0 = g(r5);     // Catch: Throwable -> L11
        return h(r0.getLatitude(), r0.getLongitude());
    L15:
        return r5;
    }

    public static DPoint g(DPoint r27) {
        double r0 = 0.006401062d;
        double r2 = 0.0060424805d;
        DPoint r4 = null;
        int r5 = 0;
    L4:
        if (r5 >= 2) goto L6;
        double r6 = r27.getLongitude();
        double r8 = r27.getLatitude();
        r4 = new DPoint();
        double r1 = r6 - r0;
        double r3 = r8 - r2;
        DPoint r10 = new DPoint();
        double r13 = (r1 * 3000.0d) * 0.017453292519943295d;
        double r11 = (3000.0d * r3) * 0.017453292519943295d;
        double r23 = (r1 * r1) + (r3 * r3);
        double r17 = (Math.cos((Math.cos(r13) * 3.0E-6d) + Math.atan2(r3, r1)) * ((Math.sin(r11) * 2.0E-5d) + Math.sqrt(r23))) + 0.0065d;
        double r14 = (Math.sin((Math.cos(r13) * 3.0E-6d) + Math.atan2(r3, r1)) * ((Math.sin(r11) * 2.0E-5d) + Math.sqrt(r23))) + 0.006d;
        r10.setLongitude(f(r17));
        r10.setLatitude(f(r14));
        r4.setLongitude(f((r1 + r6) - r10.getLongitude()));
        r4.setLatitude(f((r8 + r3) - r10.getLatitude()));
        r0 = r27.getLongitude() - r4.getLongitude();
        r2 = r27.getLatitude() - r4.getLatitude();
        r5 = r5 + 1;
        goto L4
    L6:
        return r4;
    }

    public static DPoint b(Context r5, DPoint r6) {
        if (r5 != null) goto L12;
        return null;
    L12:
    L9:
        th = move-exception;
        c4.g(th, "OffsetUtil", "cover part2");
        return r6;
    L6:
        if (c4.h(r6.getLatitude(), r6.getLongitude()) == false) goto L14;
        double[] r7 = k4.b(r6.getLongitude(), r6.getLatitude());     // Catch: Throwable -> L9
        return new DPoint(r7[1], r7[0]);
    L14:
        return r6;
    }

    public static DPoint e(Context r15, DPoint r16) {
    L14:
        th = move-exception;
        c4.g(th, "OffsetUtil", "marbar2G");
        return r16;
    L3:
        if (c4.h(r16.getLatitude(), r16.getLongitude()) == true) goto L5;
        return r16;
    L5:
        double r0 = ((long) (r16.getLongitude() * 100000.0d)) % 36000000;     // Catch: Throwable -> L14
        double r2 = ((long) (r16.getLatitude() * 100000.0d)) % 36000000;     // Catch: Throwable -> L14
        double r8 = (int) ((-a(r0, r2)) + r0);     // Catch: Throwable -> L14
        double r6 = (int) ((-d(r0, r2)) + r2);     // Catch: Throwable -> L14
        double r9 = (-a(r8, r6)) + r0;     // Catch: Throwable -> L14
        int r10 = -1;
        if (r0 <= 0.0d) goto L8;
        int r1 = 1;
    L9:
        double r3 = (int) (r9 + ((double) r1));     // Catch: Throwable -> L14
        double r7 = (-d(r3, r6)) + r2;     // Catch: Throwable -> L14
        if (r2 <= 0.0d) goto L12;
        r10 = 1;
    L12:
        return b(r15, new DPoint(((double) ((int) (r7 + ((double) r10)))) / 100000.0d, r3 / 100000.0d));
    L8:
        r1 = -1;
        goto L9
    }

    public static DPoint h(double r36, double r38) {
        double r0 = r38 - 105.0d;
        double r2 = r36 - 35.0d;
        double r6 = r0 * 2.0d;
        double r16 = r0 * 0.1d;
        double r18 = r16 * r2;
        double r8 = (((((-100.0d) + r6) + (r2 * 3.0d)) + ((r2 * 0.2d) * r2)) + r18) + (Math.sqrt(Math.abs(r0)) * 0.2d);
        double r12 = (6.0d * r0) * 3.141592653589793d;
        double r7 = r6 * 3.141592653589793d;
        double r9 = r8 + ((((Math.sin(r12) * 20.0d) + (Math.sin(r7) * 20.0d)) * 2.0d) / 3.0d);
        double r22 = r2 * 3.141592653589793d;
        double r10 = (r9 + ((((Math.sin(r22) * 20.0d) + (Math.sin((r2 / 3.0d) * 3.141592653589793d) * 40.0d)) * 2.0d) / 3.0d)) + ((((Math.sin((r2 / 12.0d) * 3.141592653589793d) * 160.0d) + (Math.sin(r22 / 30.0d) * 320.0d)) * 2.0d) / 3.0d);
        double r28 = (((((((r0 + 300.0d) + (r2 * 2.0d)) + (r16 * r0)) + r18) + (Math.sqrt(Math.abs(r0)) * 0.1d)) + ((((Math.sin(r12) * 20.0d) + (Math.sin(r7) * 20.0d)) * 2.0d) / 3.0d)) + ((((Math.sin(r0 * 3.141592653589793d) * 20.0d) + (Math.sin((r0 / 3.0d) * 3.141592653589793d) * 40.0d)) * 2.0d) / 3.0d)) + ((((Math.sin((r0 / 12.0d) * 3.141592653589793d) * 150.0d) + (Math.sin((r0 / 30.0d) * 3.141592653589793d) * 300.0d)) * 2.0d) / 3.0d);
        double r3 = (r36 / 180.0d) * 3.141592653589793d;
        double r11 = Math.sin(r3);
        double r13 = 1.0d - ((0.006693421622965943d * r11) * r11);
        double r14 = Math.sqrt(r13);
        double r29 = (r28 * 180.0d) / (((6378245.0d / r14) * Math.cos(r3)) * 3.141592653589793d);
        DPoint r15 = new DPoint(r36 + ((r10 * 180.0d) / ((6335552.717000426d / (r13 * r14)) * 3.141592653589793d)), r38 + r29);
        double r1 = (r38 * 2.0d) - r15.getLongitude();
        return new DPoint((r36 * 2.0d) - r15.getLatitude(), r1);
    }
}
