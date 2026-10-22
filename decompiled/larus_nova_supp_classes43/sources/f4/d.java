package f4;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static a a(double r41, double r43) {
        if (r43 >= 72.004d) goto L5;
    L13:
        boolean r10 = true;
    L14:
        if (r10 == false) goto L16;
        a r11 = new a(r41, r43);
    L17:
        double r12 = 2;
        return new a((r41 * r12) - r11.a, (r43 * r12) - r11.b);
    L16:
        double r13 = r43 - 105.0d;
        double r14 = r41 - 35.0d;
        double r15 = r13 * 2.0d;
        double r21 = r13 * 0.1d;
        double r23 = r21 * r14;
        double r16 = (((((-100.0d) + r15) + (r14 * 3.0d)) + ((r14 * 0.2d) * r14)) + r23) + (Math.sqrt(Math.abs(r13)) * 0.2d);
        double r17 = (6.0d * r13) * 3.141592653589793d;
        double r18 = r15 * 3.141592653589793d;
        double r27 = r14 * 3.141592653589793d;
        double r19 = ((r16 + ((((Math.sin(r17) * 20.0d) + (Math.sin(r18) * 20.0d)) * 2.0d) / 3.0d)) + ((((Math.sin(r27) * 20.0d) + (Math.sin((r14 / 3.0d) * 3.141592653589793d) * 40.0d)) * 2.0d) / 3.0d)) + ((((Math.sin((r14 / 12.0d) * 3.141592653589793d) * 160.0d) + (((double) 320) * Math.sin(r27 / 30.0d))) * 2.0d) / 3.0d);
        double r33 = (((((((r13 + 300.0d) + (r14 * 2.0d)) + (r21 * r13)) + r23) + (Math.sqrt(Math.abs(r13)) * 0.1d)) + ((((Math.sin(r17) * 20.0d) + (Math.sin(r18) * 20.0d)) * 2.0d) / 3.0d)) + ((((Math.sin(r13 * 3.141592653589793d) * 20.0d) + (Math.sin((r13 / 3.0d) * 3.141592653589793d) * 40.0d)) * 2.0d) / 3.0d)) + ((((Math.sin((r13 / 12.0d) * 3.141592653589793d) * 150.0d) + (Math.sin((r13 / 30.0d) * 3.141592653589793d) * 300.0d)) * 2.0d) / 3.0d);
        double r20 = (r41 / 180.0d) * 3.141592653589793d;
        double r22 = Math.sin(r20);
        double r110 = ((double) 1) - ((0.006693421622965943d * r22) * r22);
        double r24 = Math.sqrt(r110);
        r11 = new a(r41 + ((r19 * 180.0d) / ((6335552.717000426d / (r110 * r24)) * 3.141592653589793d)), r43 + ((r33 * 180.0d) / (((6378245.0d / r24) * Math.cos(r20)) * 3.141592653589793d)));
        goto L17
    L5:
        if (r43 > 137.8347d) goto L13;
        if (r41 < 0.8293d) goto L13;
        if (r41 > 55.8271d) goto L13;
        r10 = false;
        goto L14
    }
}
