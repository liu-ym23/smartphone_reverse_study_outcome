package com.bytedance.monitor.util;

/* JADX INFO: loaded from: classes2.dex */
class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final Class<?>[] f2885a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final Object[] f2886b = null;

    static {
        f2885a = new Class[0];
        f2886b = new Object[0];
    }

    static boolean a(Object[] r1, Object[] r2) {
        if (r1 != null) goto L6;
        if (r2 == null) goto L6;
        if (r2.length <= 0) goto L6;
        return false;
    L6:
        if (r2 != null) goto L10;
        if (r1 == null) goto L10;
        if (r1.length <= 0) goto L10;
        return false;
    L10:
        if (r1 == null) goto L16;
        if (r2 != null) goto L13;
        return true;
    L13:
        if (r1.length == r2.length) goto L21;
        return false;
    L21:
        return true;
    L16:
        return true;
    }

    static Object[] a(Object[] r1) {
        if (r1 == null) goto L7;
        if (r1.length <= 0) goto L7;
        return r1;
    L7:
        return f2886b;
    }

    static Class<?>[] b(Object... r4) {
        if (r4 != null) goto L6;
        return null;
    L6:
        if (r4.length == 0) goto L8;
        Class<?>[] r1 = new Class[r4.length];
        int r2 = 0;
    L11:
        if (r2 >= r4.length) goto L17;
        if (r4[r2] != null) goto L15;
        Class<?> r3 = null;
    L16:
        r1[r2] = r3;
        r2 = r2 + 1;
        goto L11
    L15:
        r3 = r4[r2].getClass();
        goto L16
    L17:
        return r1;
    L8:
        return f2885a;
    }
}
