package com.loc;

/* JADX INFO: loaded from: classes3.dex */
public final class cq extends fh {
    private static int a(fg r0) {
        return r0.b();
    }

    public static int a(fg r1, int r2) {
        r1.b(1);
        b(r1, r2);
        return a(r1);
    }

    public static int a(fg r2, int[] r3) {
        r2.a(4, r3.length, 4);
        int r0 = r3.length - 1;
    L3:
        if (r0 < 0) goto L6;
        r2.a(r3[r0]);
        r0 = r0 - 1;
        goto L3
    L6:
        return r2.a();
    }

    private static void b(fg r1, int r2) {
        r1.b(0, r2);
    }
}
