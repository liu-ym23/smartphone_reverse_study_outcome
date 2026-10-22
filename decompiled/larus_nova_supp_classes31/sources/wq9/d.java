package wq9;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean b(double r3, double r5) {
        if (r5 >= 72.004d) goto L5;
    L13:
        return true;
    L5:
        if (r5 > 137.8347d) goto L13;
        if (r3 < 0.8293d) goto L13;
        if (r3 > 55.8271d) goto L13;
        return false;
    }

    public static a a(double r18, double r20) {
        if (b(r18, r20) == false) goto L5;
        a r4 = new a(r18, r20);
    L6:
        double r5 = 2;
        return new a((r18 * r5) - r4.a, (r20 * r5) - r4.b);
    L5:
        double r6 = r20 - 105.0d;
        double r7 = r18 - 35.0d;
        double r8 = c(r6, r7);
        double r9 = d(r6, r7);
        double r10 = (r18 / 180.0d) * 3.141592653589793d;
        double r14 = Math.sin(r10);
        double r12 = ((double) 1) - ((0.006693421622965943d * r14) * r14);
        double r15 = Math.sqrt(r12);
        r4 = new a(r18 + ((r8 * 180.0d) / ((6335552.717000426d / (r12 * r15)) * 3.141592653589793d)), ((r9 * 180.0d) / (((6378245.0d / r15) * Math.cos(r10)) * 3.141592653589793d)) + r20);
        goto L6
    }

    public static double c(double r16, double r18) {
        double r2 = r16 * 2.0d;
        double r4 = ((((((-100.0d) + r2) + (r18 * 3.0d)) + ((r18 * 0.2d) * r18)) + ((0.1d * r16) * r18)) + (Math.sqrt(Math.abs(r16)) * 0.2d)) + ((((Math.sin((6.0d * r16) * 3.141592653589793d) * 20.0d) + (Math.sin(r2 * 3.141592653589793d) * 20.0d)) * 2.0d) / 3.0d);
        double r3 = r18 * 3.141592653589793d;
        return (r4 + ((((Math.sin(r3) * 20.0d) + (Math.sin((r18 / 3.0d) * 3.141592653589793d) * 40.0d)) * 2.0d) / 3.0d)) + ((((Math.sin((r18 / 12.0d) * 3.141592653589793d) * 160.0d) + (((double) 320) * Math.sin(r3 / 30.0d))) * 2.0d) / 3.0d);
    }

    public static double d(double r16, double r18) {
        double r8 = r16 * 0.1d;
        return (((((((r16 + 300.0d) + (r18 * 2.0d)) + (r8 * r16)) + (r8 * r18)) + (Math.sqrt(Math.abs(r16)) * 0.1d)) + ((((Math.sin((6.0d * r16) * 3.141592653589793d) * 20.0d) + (Math.sin((r16 * 2.0d) * 3.141592653589793d) * 20.0d)) * 2.0d) / 3.0d)) + ((((Math.sin(r16 * 3.141592653589793d) * 20.0d) + (Math.sin((r16 / 3.0d) * 3.141592653589793d) * 40.0d)) * 2.0d) / 3.0d)) + ((((Math.sin((r16 / 12.0d) * 3.141592653589793d) * 150.0d) + (Math.sin((r16 / 30.0d) * 3.141592653589793d) * 300.0d)) * 2.0d) / 3.0d);
    }

    public static a e(double r16, double r18) {
        if (b(r16, r18) == false) goto L6;
        return null;
    L6:
        double r0 = r18 - 105.0d;
        double r2 = r16 - 35.0d;
        double r4 = c(r0, r2);
        double r1 = d(r0, r2);
        double r6 = (r16 / 180.0d) * 3.141592653589793d;
        double r10 = Math.sin(r6);
        double r12 = ((double) 1) - ((0.006693421622965943d * r10) * r10);
        double r11 = Math.sqrt(r12);
        double r3 = (r1 * 180.0d) / (((6378245.0d / r11) * Math.cos(r6)) * 3.141592653589793d);
        return new a(r16 + ((r4 * 180.0d) / ((6335552.717000426d / (r12 * r11)) * 3.141592653589793d)), r18 + r3);
    }
}
