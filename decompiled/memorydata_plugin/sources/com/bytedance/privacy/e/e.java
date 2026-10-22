package com.bytedance.privacy.e;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f3017a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile boolean f3018b = false;

    static {
    }

    public static boolean a() {
        return true;
    }

    public static boolean a(int r1) {
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L9;
        return false;
    L9:
        return f3018b;
    L11:
        return f3017a;
    }
}
