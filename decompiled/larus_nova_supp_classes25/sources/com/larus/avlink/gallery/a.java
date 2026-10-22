package com.larus.avlink.gallery;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a {
    public static final double a(double r5) {
        double r0 = 1.0d;
        int r2 = 0;
    L4:
        if (r2 >= 2) goto L7;
        r0 = r0 * ((double) 10);
        r2 = r2 + 1;
        goto L4
    L7:
        return Math.rint(r5 * r0) / r0;
    }
}
