package com.obric.oui.color;

import android.graphics.Color;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class h0 {
    public static boolean a(int r2) {
        int r0 = Color.red(r2);
        int r1 = Color.green(r2);
        int r3 = Color.blue(r2);
        if (r0 != r1) goto L7;
        if (r0 != r3) goto L7;
        return false;
    L7:
        return true;
    }

    public static boolean b(int r8) {
        double r0 = ((double) ((r8 >> 16) & 255)) / 255.0d;
        double r4 = ((double) ((r8 >> 8) & 255)) / 255.0d;
        double r1 = c(r0);
        double r2 = c(r4);
        if ((((r1 * 0.2126d) + (r2 * 0.7152d)) + (c(((double) (r8 & 255)) / 255.0d) * 0.0722d)) >= 0.5d) goto L5;
        return true;
    L5:
        return false;
    }

    public static double c(double r3) {
        if (r3 > 0.04045d) goto L7;
        return r3 / 12.92d;
    L7:
        return Math.pow((r3 + 0.055d) / 1.055d, 2.4d);
    }
}
