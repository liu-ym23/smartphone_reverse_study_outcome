package com.ss.mediakit.vcnlib;

import android.util.Log;

/* JADX INFO: loaded from: classes6.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f15766a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f15767b = false;
    private static boolean c = false;

    static {
    }

    public a() {
    }

    public static boolean a() {
        monitor-enter(a.class);
        boolean r2 = true;
        if (f15766a == false) goto L19;
        monitor-exit(a.class);     // Catch: Throwable -> L15
        return true;
    L19:
        System.loadLibrary("vcn");     // Catch: UnsatisfiedLinkError -> L10 Throwable -> L15
    L12:
        f15766a = r2;     // Catch: Throwable -> L15
        monitor-exit(a.class);     // Catch: Throwable -> L15
        return r2;
    L10:
        e = move-exception;
        Log.e("vcn", "Can't load vcn library: " + e);     // Catch: Throwable -> L15
        r2 = false;
    L15:
        th = move-exception;
        throw th;
    }

    public static boolean b() {
        monitor-enter(a.class);
        boolean r2 = true;
        if (f15767b == false) goto L24;
        monitor-exit(a.class);     // Catch: Throwable -> L21
        return true;
    L24:
        System.loadLibrary("vcnverify");     // Catch: UnsatisfiedLinkError -> L11 Throwable -> L21
        boolean r3 = true;
    L13:
        f15767b = r3;     // Catch: Throwable -> L21
        if (r3 == false) goto L16;
    L19:
        monitor-exit(a.class);     // Catch: Throwable -> L21
        return r2;
    L16:
        if (c() == true) goto L19;
        r2 = false;
        goto L19
    L11:
        e = move-exception;
        Log.e("vcn", "Can't load vcnverify library: " + e);     // Catch: Throwable -> L21
        r3 = false;
    L21:
        th = move-exception;
        throw th;
    }

    public static boolean c() {
        monitor-enter(a.class);
        boolean r2 = true;
        if (c == false) goto L19;
        monitor-exit(a.class);     // Catch: Throwable -> L15
        return true;
    L19:
        System.loadLibrary("vcnverifylite");     // Catch: UnsatisfiedLinkError -> L10 Throwable -> L15
        Log.e("vcn", "load vcnverifylite suc");     // Catch: UnsatisfiedLinkError -> L10 Throwable -> L15
        CustomVerify.a();     // Catch: UnsatisfiedLinkError -> L10 Throwable -> L15
    L12:
        c = r2;     // Catch: Throwable -> L15
        monitor-exit(a.class);     // Catch: Throwable -> L15
        return r2;
    L10:
        e = move-exception;
        Log.e("vcn", "Can't load vcnverifylite library: " + e);     // Catch: Throwable -> L15
        r2 = false;
    L15:
        th = move-exception;
        throw th;
    }
}
