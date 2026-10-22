package com.lynx.tasm.utils;

import android.os.Handler;
import android.os.Looper;
import com.lynx.tasm.base.LLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class UIThreadUtils {
    private static final String TAG = "UIThreadUtils";
    private static volatile Handler sMainHandler;

    public UIThreadUtils() {
    }

    private static Handler getUiThreadHandler() {
        if (sMainHandler != null) goto L15;
        monitor-enter(UIThreadUtils.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sMainHandler != null) goto L9;
        sMainHandler = new Handler(Looper.getMainLooper());     // Catch: Throwable -> L11
    L9:
        monitor-exit(UIThreadUtils.class);     // Catch: Throwable -> L11
    L15:
        return sMainHandler;
    }

    public static void assertNotOnUiThread() {
        if ((!isOnUiThread()) == false) goto L6;
        return;
    L6:
        throw new AssertionError("Expected not to run on UI thread!");
    }

    public static void assertOnUiThread() {
        if (isOnUiThread() == false) goto L6;
        return;
    L6:
        throw new AssertionError("Expected to run on UI thread!");
    }

    public static boolean isOnUiThread() {
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L5;
        return true;
    L5:
        return false;
    }

    public static void postAtFrontOfQueueOnUiThread(Runnable r1) {
        getUiThreadHandler().postAtFrontOfQueue(r1);
    }

    public static void runOnUiThread(Runnable r1) {
        getUiThreadHandler().post(r1);
    }

    public static void runOnUiThreadImmediately(Runnable r1) {
        if (isOnUiThread() == false) goto L5;
        r1.run();
        return;
    L5:
        runOnUiThread(r1);
    }

    public static void runOnUiThreadImmediatelyWithPostAtFront(Runnable r1) {
        if (isOnUiThread() == false) goto L5;
        r1.run();
        return;
    L5:
        postAtFrontOfQueueOnUiThread(r1);
    }

    public static boolean runOnUiThreadSync(Runnable r4) {
        if (isOnUiThread() == false) goto L6;
        r4.run();
        return true;
    L6:
        FutureTask r1 = new FutureTask(r4, null);
        runOnUiThread(r1);
        r1.get();     // Catch: ExecutionException -> L9 InterruptedException -> L12
        return true;
    L12:
        e = move-exception;
        ThreadMethodProxy.currentThread().interrupt();
        LLog.e(TAG, "Interrupted while waiting for UI thread task: " + e);
        return false;
    L9:
        e = move-exception;
        LLog.e(TAG, "Exception while running UI thread task: " + e.getCause());
        return false;
    }

    public static void removeCallbacks(Runnable r1, Object r2) {
        getUiThreadHandler().removeCallbacks(r1, r2);
    }

    public static void runOnUiThread(Runnable r1, long r2) {
        getUiThreadHandler().postDelayed(r1, r2);
    }

    public static void runOnUiThreadAtTime(Runnable r1, Object r2, long r3) {
        getUiThreadHandler().postAtTime(r1, r2, r3);
    }
}
