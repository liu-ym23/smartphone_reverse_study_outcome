package com.lynx.debugrouter.base;

import android.os.Handler;
import android.os.Looper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class UIThreadUtils {
    private static Handler sMainHandler;

    public UIThreadUtils() {
    }

    public static boolean isOnUiThread() {
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L5;
        return true;
    L5:
        return false;
    }

    public static void runOnUiThread(Runnable r3) {
        monitor-enter(UIThreadUtils.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sMainHandler != null) goto L7;
        sMainHandler = new Handler(Looper.getMainLooper());     // Catch: Throwable -> L10
    L7:
        monitor-exit(UIThreadUtils.class);     // Catch: Throwable -> L10
        sMainHandler.post(r3);
    }

    public static void runOnUiThreadImmediately(Runnable r1) {
        if (isOnUiThread() == false) goto L5;
        r1.run();
        return;
    L5:
        runOnUiThread(r1);
    }

    public static void removeCallbacks(Runnable r3, Object r4) {
        monitor-enter(UIThreadUtils.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sMainHandler != null) goto L7;
        sMainHandler = new Handler(Looper.getMainLooper());     // Catch: Throwable -> L10
    L7:
        monitor-exit(UIThreadUtils.class);     // Catch: Throwable -> L10
        sMainHandler.removeCallbacks(r3, r4);
    }

    public static void runOnUiThread(Runnable r3, long r4) {
        monitor-enter(UIThreadUtils.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sMainHandler != null) goto L7;
        sMainHandler = new Handler(Looper.getMainLooper());     // Catch: Throwable -> L10
    L7:
        monitor-exit(UIThreadUtils.class);     // Catch: Throwable -> L10
        sMainHandler.postDelayed(r3, r4);
    }

    public static void runOnUiThreadAtTime(Runnable r3, Object r4, long r5) {
        monitor-enter(UIThreadUtils.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sMainHandler != null) goto L7;
        sMainHandler = new Handler(Looper.getMainLooper());     // Catch: Throwable -> L10
    L7:
        monitor-exit(UIThreadUtils.class);     // Catch: Throwable -> L10
        sMainHandler.postAtTime(r3, r4, r5);
    }
}
