package com.google.android.material.transition;

/* JADX INFO: loaded from: classes2.dex */
class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f4240a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final a f4241b = null;
    private static final a c = null;
    private static final a d = null;

    static {
        f4240a = new AnonymousClass1();
        f4241b = new AnonymousClass2();
        c = new AnonymousClass3();
        d = new AnonymousClass4();
    }

    static a a(int r2, boolean r3) {
        if (r2 != 0) goto L4;
        if (r3 == false) goto L22;
        return f4240a;
    L22:
        return f4241b;
    L4:
        if (r2 != 1) goto L6;
        if (r3 == false) goto L18;
        return f4241b;
    L18:
        return f4240a;
    L6:
        if (r2 == 2) goto L14;
        if (r2 != 3) goto L12;
        return d;
    L12:
        throw new IllegalArgumentException("Invalid fade mode: " + r2);
    L14:
        return c;
    }
}
