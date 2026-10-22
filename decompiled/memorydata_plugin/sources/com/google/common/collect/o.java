package com.google.common.collect;

/* JADX INFO: loaded from: classes2.dex */
final class o {
    static int a(int r2, String r3) {
        if (r2 < 0) goto L5;
        return r2;
    L5:
        throw new IllegalArgumentException(r3 + " cannot be negative but was: " + r2);
    }

    static long a(long r2, String r4) {
        if (r2 < 0) goto L6;
        return r2;
    L6:
        throw new IllegalArgumentException(r4 + " cannot be negative but was: " + r2);
    }

    static void a(Object r2, Object r3) {
        if (r2 == null) goto L8;
        if (r3 == null) goto L6;
        return;
    L6:
        throw new NullPointerException("null value in entry: " + r2 + "=null");
    L8:
        throw new NullPointerException("null key in entry: null=" + r3);
    }

    static void a(boolean r1) {
        com.google.common.base.n.b(r1, "no calls to next() since the last call to remove()");
    }

    static void b(int r2, String r3) {
        if (r2 <= 0) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(r3 + " must be positive but was: " + r2);
    }
}
