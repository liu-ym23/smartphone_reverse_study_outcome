package com.google.common.collect;

/* JADX INFO: loaded from: classes2.dex */
final class ai {
    static int a(int r4) {
        return (int) (((long) Integer.rotateLeft((int) (((long) r4) * (-862048943)), 15)) * 461845907);
    }

    static int a(int r3, double r4) {
        int r5 = Math.max(r3, 2);
        int r0 = Integer.highestOneBit(r5);
        if (r5 <= ((int) (r4 * ((double) r0)))) goto L9;
        int r6 = r0 << 1;
        if (r6 > 0) goto L10;
        return 1073741824;
    L10:
        return r6;
    L9:
        return r0;
    }

    static int a(Object r0) {
        if (r0 != null) goto L4;
        int r1 = 0;
    L6:
        return a(r1);
    L4:
        r1 = r0.hashCode();
        goto L6
    }

    static boolean a(int r4, int r5, double r6) {
        if (r4 > (r6 * ((double) r5))) goto L5;
    L7:
        return false;
    L5:
        if (r5 >= 1073741824) goto L7;
        return true;
    }
}
