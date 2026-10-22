package com.bytedance.applog.util;

/* JADX INFO: loaded from: classes.dex */
public class BlockHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f1251a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile int f1252b;

    static {
    }

    public BlockHelper() {
    }

    private static void a() {
        if (f1251a == true) goto L14;
        f1252b = 0;
        return;
    L14:
    L10:
        e = move-exception;
        e.printStackTrace();
        return;
    L5:
        if (f1252b >= 100) goto L7;
        Thread.sleep(100);     // Catch: InterruptedException -> L10
    L8:
        f1252b++;     // Catch: InterruptedException -> L10
        return;
    L7:
        f1251a = false;     // Catch: InterruptedException -> L10
        goto L8
    }

    public static void beginBlock() {
        f1251a = true;
        f1252b = 0;
    }

    public static void endBlock() {
        f1251a = false;
        f1252b = 0;
    }

    public static void tryBlock() {
    L3:
        if (f1251a == false) goto L5;
        a();
        goto L3
    }
}
