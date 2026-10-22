package qa;

import android.content.Context;
import com.amap.api.location.DPoint;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class u3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ArrayList f11151a = null;

    static {
        f11151a = new ArrayList(Arrays.asList(new DPoint[]{new DPoint(23.379947d, 119.757001d), new DPoint(24.983296d, 120.474496d), new DPoint(25.518722d, 121.359866d), new DPoint(25.41329d, 122.443582d), new DPoint(24.862708d, 122.288354d), new DPoint(24.461292d, 122.188319d), new DPoint(21.584761d, 120.968923d), new DPoint(21.830837d, 120.654445d)}));
    }

    public static double a(double r8, double r10) {
        double r11 = r8 / 18000.0d;
        double r12 = r11 * Math.cos(r10 / 100000.0d);
        double r13 = r10 / 9000.0d;
        return (r13 * Math.sin(r8 / 100000.0d)) + r12;
    }

    public static DPoint b(Context r8, DPoint r10) {
        if (r8 != null) goto L12;
        return null;
    L12:
    L9:
        th = move-exception;
        t3.g("OffsetUtil", "cover part2", th);
        return r10;
    L6:
        if (t3.h(r10.f3678b, r10.f3677a) == false) goto L14;
        double[] r11 = defpackage.c.m(r10.f3677a, r10.f3678b);     // Catch: Throwable -> L9
        return new DPoint(r11[1], r11[0]);
    L14:
        return r10;
    }

    public static DPoint c(DPoint r8) {
        if (r8 != null) goto L14;
    L13:
        return r8;
    L14:
    L11:
        th = move-exception;
        t3.g("OffsetUtil", "b2G", th);
        goto L13
    L4:
        if (t3.h(r8.f3678b, r8.f3677a) == false) goto L8;
        return g(r8);
    L8:
        if (h(r8.f3678b, r8.f3677a) == false) goto L15;
        DPoint r10 = g(r8);     // Catch: Throwable -> L11
        return i(r10.f3678b, r10.f3677a);
    L15:
        return r8;
    }

    public static double d(double r8, double r10) {
        double r11 = r8 / 18000.0d;
        double r12 = r11 * Math.sin(r10 / 100000.0d);
        double r13 = r10 / 9000.0d;
        return (r13 * Math.cos(r8 / 100000.0d)) + r12;
    }

    public static DPoint e(Context r16, DPoint r17) {
    L16:
        th = move-exception;
        t3.g("OffsetUtil", "marbar2G", th);
        return r17;
    L4:
        if (t3.h(r17.f3678b, r17.f3677a) == true) goto L6;
        return r17;
    L6:
        double r8 = ((long) (r17.f3677a * 100000.0d)) % 36000000;     // Catch: Throwable -> L16
        double r10 = ((long) (r17.f3678b * 100000.0d)) % 36000000;     // Catch: Throwable -> L16
        int r11 = (int) ((-a(r8, r10)) + r8);     // Catch: Throwable -> L16
        double r12 = (int) ((-d(r8, r10)) + r10);     // Catch: Throwable -> L16
        double r13 = (-a(r11, r12)) + r8;     // Catch: Throwable -> L16
        if (r8 <= 0.0d) goto L9;
        int r14 = 1;
    L10:
        double r15 = (int) (r13 + ((double) r14));     // Catch: Throwable -> L16
        double r18 = (-d(r15, r12)) + r10;     // Catch: Throwable -> L16
        if (r10 <= 0.0d) goto L13;
        int r19 = 1;
    L14:
        return b(r16, new DPoint(((double) ((int) (r18 + ((double) r19)))) / 100000.0d, r15 / 100000.0d));
    L13:
        r19 = -1;
        goto L14
    L9:
        r14 = -1;
        goto L10
    }

    public static double f(double r8) {
        return new BigDecimal(r8).setScale(8, 4).doubleValue();
    }

    public static DPoint g(DPoint r28) {
        double r8 = 0.006401062d;
        double r10 = 0.0060424805d;
        DPoint r11 = null;
        int r12 = 0;
    L4:
        if (r12 >= 2) goto L6;
        double r13 = r28.f3677a;
        double r14 = r28.f3678b;
        r11 = new DPoint();
        double r15 = r13 - r8;
        double r16 = r14 - r10;
        DPoint r17 = new DPoint();
        double r18 = (r15 * 3000.0d) * 0.017453292519943295d;
        double r19 = Math.cos(r18) * 3.0E-6d;
        double r110 = Math.cos(Math.atan2(r16, r15) + r19);
        double r111 = (3000.0d * r16) * 0.017453292519943295d;
        double r112 = Math.sin(r111) * 2.0E-5d;
        double r26 = r16 * r16;
        double r27 = r26 + (r15 * r15);
        double r24 = ((Math.sqrt(r27) + r112) * r110) + 0.0065d;
        double r113 = Math.cos(r18) * 3.0E-6d;
        double r114 = Math.sin(Math.atan2(r16, r15) + r113);
        double r115 = Math.sin(r111) * 2.0E-5d;
        double r116 = ((Math.sqrt(r27) + r115) * r114) + 0.006d;
        r17.u(f(r24));
        r17.t(f(r116));
        r11.u(f((r15 + r13) - r17.f3677a));
        r11.t(f((r14 + r16) - r17.f3678b));
        r8 = r28.f3677a - r11.f3677a;
        r10 = r28.f3678b - r11.f3678b;
        r12 = r12 + 1;
        goto L4
    L6:
        return r11;
    }

    public static boolean h(double r31, double r33) {
        DPoint r8 = new DPoint(r31, r33);
        ArrayList r10 = f11151a;
        double r14 = r8.f3677a;
        double r12 = r8.f3678b;
        if (((DPoint) r10.get(0)).equals(r10.get(r10.size() - 1)) == true) goto L5;
        r10.add(r10.get(0));
    L5:
        int r11 = 0;
        int r16 = 0;
    L6:
        boolean r17 = true;
        if (r11 >= (r10.size() - 1)) goto L39;
        double r13 = ((DPoint) r10.get(r11)).f3677a;
        double r15 = ((DPoint) r10.get(r11)).f3678b;
        int r18 = r11 + 1;
        double r19 = ((DPoint) r10.get(r18)).f3677a;
        double r20 = ((DPoint) r10.get(r18)).f3678b;
        double r27 = r12;
        if (t3.i(r14, r12, r13, r15, r19, r20) == true) goto L40;
        double r29 = r20 - r15;
        if (Math.abs(r29) < 1.0E-9d) goto L37;
        if (t3.i(r13, r15, r14, r27, 180.0d, r27) == false) goto L19;
        if (r15 <= r20) goto L37;
    L36:
        r16 = r16 + 1;
        goto L37
    L19:
        if (t3.i(r19, r20, r14, r27, 180.0d, r27) == true) goto L21;
        double r21 = r19 - r13;
        double r110 = r27 - r27;
        double r22 = 180.0d - r14;
        double r23 = (r21 * r110) - (r29 * r22);
        if (r23 == 0.0d) goto L34;
        double r111 = r15 - r27;
        double r112 = r13 - r14;
        double r24 = ((r22 * r111) - (r110 * r112)) / r23;
        double r113 = ((r111 * r21) - (r112 * r29)) / r23;
        if (r24 < 0.0d) goto L34;
        if (r24 > 1.0d) goto L34;
        if (r113 < 0.0d) goto L34;
        if (r113 > 1.0d) goto L34;
    L35:
        if (r17 == false) goto L37;
    L34:
        r17 = false;
        goto L35
    L21:
        if (r20 > r15) goto L36;
    L37:
        r11 = r18;
        r12 = r27;
    L40:
        boolean r25 = true;
    L42:
        if (r25 == false) goto L44;
        return true;
    L44:
        return false;
    L39:
        if ((r16 % 2) != 0) goto L40;
        r25 = false;
        goto L42
    }

    public static DPoint i(double r36, double r38) {
        double r8 = r38 - 105.0d;
        double r10 = r36 - 35.0d;
        double r11 = r8 * 2.0d;
        double r12 = r10 * 3.0d;
        double r14 = (r10 * 0.2d) * r10;
        double r16 = r8 * 0.1d;
        double r18 = r16 * r10;
        double r20 = Math.sqrt(Math.abs(r8)) * 0.2d;
        double r21 = r20 + (r18 + (r14 + (r12 + ((-100.0d) + r11))));
        double r13 = (6.0d * r8) * 3.141592653589793d;
        double r22 = Math.sin(r13) * 20.0d;
        double r15 = r11 * 3.141592653589793d;
        double r26 = ((((Math.sin(r15) * 20.0d) + r22) * 2.0d) / 3.0d) + r21;
        double r23 = r10 * 3.141592653589793d;
        double r24 = Math.sin(r23) * 20.0d;
        double r28 = ((((Math.sin((r10 / 3.0d) * 3.141592653589793d) * 40.0d) + r24) * 2.0d) / 3.0d) + r26;
        double r27 = Math.sin((r10 / 12.0d) * 3.141592653589793d) * 160.0d;
        double r25 = ((((Math.sin(r23 / 30.0d) * 320.0d) + r27) * 2.0d) / 3.0d) + r28;
        double r17 = r10 * 2.0d;
        double r19 = r16 * r8;
        double r110 = (r19 + (r17 + (r8 + 300.0d))) + r18;
        double r29 = (Math.sqrt(Math.abs(r8)) * 0.1d) + r110;
        double r30 = Math.sin(r13) * 20.0d;
        double r31 = ((((Math.sin(r15) * 20.0d) + r30) * 2.0d) / 3.0d) + r29;
        double r32 = Math.sin(r8 * 3.141592653589793d) * 20.0d;
        double r33 = ((((Math.sin((r8 / 3.0d) * 3.141592653589793d) * 40.0d) + r32) * 2.0d) / 3.0d) + r31;
        double r34 = Math.sin((r8 / 12.0d) * 3.141592653589793d) * 150.0d;
        double r35 = ((((Math.sin((r8 / 30.0d) * 3.141592653589793d) * 300.0d) + r34) * 2.0d) / 3.0d) + r33;
        double r37 = (r36 / 180.0d) * 3.141592653589793d;
        double r39 = Math.sin(r37);
        double r40 = 1.0d - ((0.006693421622965943d * r39) * r39);
        double r111 = Math.sqrt(r40);
        double r41 = Math.cos(r37);
        double r42 = (r35 * 180.0d) / ((r41 * (6378245.0d / r111)) * 3.141592653589793d);
        DPoint r43 = new DPoint(r36 + ((r25 * 180.0d) / ((6335552.717000426d / (r40 * r111)) * 3.141592653589793d)), r38 + r42);
        double r44 = (r38 * 2.0d) - r43.f3677a;
        return new DPoint((r36 * 2.0d) - r43.f3678b, r44);
    }
}
