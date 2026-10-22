package com.bytedance.boringssl.so;

import android.util.Log;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f1953a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile boolean f1954b = false;
    private static volatile b c = null;
    private static volatile String d = "ttboringssl";
    private static volatile String e = "ttcrypto";
    private static Lock f;

    static {
        f = new ReentrantLock();
    }

    public static boolean a() {
        f.lock();     // Catch: Throwable -> L15 Error -> L17
        if (c == null) goto L9;
        boolean r0 = c.a();     // Catch: Throwable -> L15 Error -> L17
        f.unlock();
        return r0;
    L9:
        if (f1954b == true) goto L12;
        System.loadLibrary(e);     // Catch: Throwable -> L15 Error -> L17
        f1954b = true;     // Catch: Throwable -> L15 Error -> L17
    L12:
        if (f1953a == true) goto L14;
        System.loadLibrary(d);     // Catch: Throwable -> L15 Error -> L17
        f1953a = true;     // Catch: Throwable -> L15 Error -> L17
    L14:
        f.unlock();
        if (f1953a == true) goto L23;
    L25:
        return false;
    L23:
        if (f1954b == false) goto L25;
        return true;
    L15:
        th = move-exception;
        f.unlock();
        throw th;
    L17:
        e = move-exception;
        Log.e("BoringsslLoaderWrapper", "load boringssl:" + f1953a + " load crypto:" + f1954b + "  err:" + e.toString());     // Catch: Throwable -> L15
        goto L14
    }
}
