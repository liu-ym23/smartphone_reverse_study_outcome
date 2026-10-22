package com.lynx.clay.util;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a {
    public static final Object a = null;
    public static volatile Handler b;

    public a() {
    }

    static {
        a = new Object();
    }

    public static Handler a() {
        if (b != null) goto L5;
        Looper r0 = Looper.getMainLooper();
        Object r2 = a;
        monitor-enter(r2);
    L18:
        th = move-exception;
        throw th;
    L9:
        if (b != null) goto L12;
        b = new Handler(r0);     // Catch: Throwable -> L18
    L13:
        monitor-exit(r2);     // Catch: Throwable -> L18
        return b;
    L12:
        if (b.getLooper() == r0) goto L13;
        throw new RuntimeException("UI thread looper is already set to " + b.getLooper() + " (Main thread looper is " + Looper.getMainLooper() + "), cannot set to new looper " + r0);     // Catch: Throwable -> L18
    L5:
        return b;
    }
}
