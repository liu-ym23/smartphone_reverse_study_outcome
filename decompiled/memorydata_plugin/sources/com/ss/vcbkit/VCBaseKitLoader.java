package com.ss.vcbkit;

import android.util.Log;

/* JADX INFO: loaded from: classes6.dex */
public class VCBaseKitLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f15816a = false;

    static {
    }

    private VCBaseKitLoader() {
    }

    public static synchronized boolean loadLibrary() {
        monitor-enter(VCBaseKitLoader.class);
    L20:
        th = move-exception;
        throw th;
    L6:
        if (f15816a == false) goto L9;
        monitor-exit(VCBaseKitLoader.class);
        return true;
    L9:
        UnExpected.a();     // Catch: Throwable -> L20
        System.loadLibrary("vcbasekit");     // Catch: Throwable -> L12 UnsatisfiedLinkError -> L15
        f15816a = true;     // Catch: Throwable -> L12 UnsatisfiedLinkError -> L15
    L17:
        boolean r1 = f15816a;     // Catch: Throwable -> L20
        monitor-exit(VCBaseKitLoader.class);
        return r1;
    L12:
        th = move-exception;
        String r2 = "vcbasekit";
        String r3 = "Can't load vcbasekit:" + th.getMessage();     // Catch: Throwable -> L20
    L14:
        Log.e(r2, r3);     // Catch: Throwable -> L20
    L15:
        e = move-exception;
        r2 = "vcbasekit";
        r3 = "Can't link vcbasekit:" + e.getMessage();     // Catch: Throwable -> L20
        goto L14
    }
}
