package com.larus.dora.impl.ota.g;

import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class v {
    public static final IntRange a = null;
    public static final IntRange b = null;

    static {
        a = new IntRange(140, 159);
        b = new IntRange(180, 189);
    }

    public static boolean a(int r4) {
        if (r4 == 134) goto L19;
        IntRange r0 = a;
        int r2 = r0.getFirst();
        if (r4 > r0.getLast()) goto L8;
        if (r2 > r4) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == true) goto L20;
        IntRange r3 = b;
        int r5 = r3.getFirst();
        if (r4 > r3.getLast()) goto L14;
        if (r5 > r4) goto L14;
        boolean r6 = true;
    L15:
        if (r6 == true) goto L21;
        return false;
    L21:
        return true;
    L14:
        r6 = false;
        goto L15
    L20:
        return true;
    L8:
        r1 = false;
        goto L9
    L19:
        return true;
    }
}
