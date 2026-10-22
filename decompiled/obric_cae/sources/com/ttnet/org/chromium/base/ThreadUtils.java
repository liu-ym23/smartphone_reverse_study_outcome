package com.ttnet.org.chromium.base;

import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes2.dex */
public class ThreadUtils {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Object sLock = null;
    private static boolean sThreadAssertsDisabled;
    private static Handler sUiThreadHandler;
    private static boolean sWillOverride;

    static {
        sLock = new Object();
    }

    public ThreadUtils() {
    }

    public static void assertOnBackgroundThread() {
    }

    public static void assertOnUiThread() {
    }

    public static void checkUiThread() {
        if (sThreadAssertsDisabled == false) goto L5;
        return;
    L5:
        if (runningOnUiThread() == false) goto L8;
        return;
    L8:
        throw new IllegalStateException("Must be called on the UI thread.");
    }

    public static Handler getUiThreadHandler() {
        Object r8 = sLock;
        monitor-enter(r8);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (sUiThreadHandler == null) goto L7;
    L11:
        Handler r10 = sUiThreadHandler;     // Catch: Throwable -> L14
        monitor-exit(r8);     // Catch: Throwable -> L14
        return r10;
    L7:
        if (sWillOverride == true) goto L10;
        sUiThreadHandler = new Handler(Looper.getMainLooper());     // Catch: Throwable -> L14
        goto L11
    L10:
        throw new RuntimeException("Did not yet override the UI thread");     // Catch: Throwable -> L14
    }

    public static Looper getUiThreadLooper() {
        return getUiThreadHandler().getLooper();
    }

    @CalledByNative
    private static boolean isThreadPriorityAudio(int r8) {
        if (Process.getThreadPriority(r8) != (-16)) goto L5;
        return true;
    L5:
        return false;
    }

    @Deprecated
    public static <T> FutureTask<T> postOnUiThread(FutureTask<T> r8) {
        getUiThreadHandler().post(r8);
        return r8;
    }

    @VisibleForTesting
    @Deprecated
    public static void postOnUiThreadDelayed(Runnable r8, long r10) {
        getUiThreadHandler().postDelayed(r8, r10);
    }

    @Deprecated
    public static <T> FutureTask<T> runOnUiThread(Callable<T> r8) {
        return runOnUiThread(new FutureTask(r8));
    }

    @Deprecated
    public static <T> T runOnUiThreadBlocking(Callable<T> r8) {
        FutureTask r10 = new FutureTask(r8);
        runOnUiThread(r10);
        return (T) r10.get();
    L5:
        e = move-exception;
        throw new RuntimeException("Interrupted waiting for callable", e);
    }

    @VisibleForTesting
    @Deprecated
    public static <T> T runOnUiThreadBlockingNoException(Callable<T> r8) {
        return (T) runOnUiThreadBlocking(r8);
    L4:
        e = move-exception;
        throw new RuntimeException("Error occurred waiting for callable", e);
    }

    public static boolean runningOnUiThread() {
        if (getUiThreadHandler().getLooper() != Looper.myLooper()) goto L5;
        return true;
    L5:
        return false;
    }

    public static void setThreadAssertsDisabledForTesting(boolean r8) {
        sThreadAssertsDisabled = r8;
    }

    @CalledByNative
    public static void setThreadPriorityAudio(int r8) {
        Process.setThreadPriority(r8, -16);
    }

    public static void setUiThread(Looper r8) {
        Object r10 = sLock;
        monitor-enter(r10);
        if (r8 == null) goto L6;
        Handler r11 = sUiThreadHandler;     // Catch: Throwable -> L19
        if (r11 != null) goto L12;
    L16:
        sUiThreadHandler = new Handler(r8);     // Catch: Throwable -> L19
        monitor-exit(r10);     // Catch: Throwable -> L19
        return;
    L12:
        if (r11.getLooper() == r8) goto L16;
        throw new RuntimeException("UI thread looper is already set to " + sUiThreadHandler.getLooper() + " (Main thread looper is " + Looper.getMainLooper() + "), cannot set to new looper " + r8);     // Catch: Throwable -> L19
    L6:
        sUiThreadHandler = null;     // Catch: Throwable -> L19
        monitor-exit(r10);     // Catch: Throwable -> L19
        return;
    L19:
        th = move-exception;
        throw th;
    }

    public static void setWillOverrideUiThread(boolean r8) {
        Object r10 = sLock;
        monitor-enter(r10);
        sWillOverride = r8;     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Deprecated
    public static void postOnUiThread(Runnable r8) {
        getUiThreadHandler().post(r8);
    }

    @Deprecated
    public static <T> FutureTask<T> runOnUiThread(FutureTask<T> r8) {
        if (runningOnUiThread() == false) goto L5;
        r8.run();
    L6:
        return r8;
    L5:
        postOnUiThread(r8);
        goto L6
    }

    @Deprecated
    public static void runOnUiThreadBlocking(Runnable r8) {
        if (runningOnUiThread() == false) goto L5;
        r8.run();
        return;
    L5:
        FutureTask r10 = new FutureTask(r8, null);
        postOnUiThread(r10);
        r10.get();     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        throw new RuntimeException("Exception occurred while waiting for runnable", e);
    }

    @Deprecated
    public static void runOnUiThread(Runnable r8) {
        if (runningOnUiThread() == false) goto L5;
        r8.run();
        return;
    L5:
        getUiThreadHandler().post(r8);
    }
}
