package com.bytedance.ies.abmock.datacenter;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f2667a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f2668b = 1;
    public static int c = 2;

    static {
    }

    public static boolean a(int r1) {
        if (r1 != f2668b) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean b(int r1) {
        if (r1 != c) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean c(int r0) {
        return a(r0);
    }
}
