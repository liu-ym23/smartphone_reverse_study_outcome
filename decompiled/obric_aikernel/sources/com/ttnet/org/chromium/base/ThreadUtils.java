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

    public static class ThreadChecker {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final long mThreadId;

        static {
        }

        public ThreadChecker() {
            this.mThreadId = Process.myTid();
        }

        public void assertOnValidThread() {
        }
    }

    static {
        sLock = new Object();
    }

    public ThreadUtils() {
    }

    static /* synthetic */ boolean access$000() {
        return sThreadAssertsDisabled;
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
        Object r10 = sLock;
        monitor-enter(r10);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (sUiThreadHandler == null) goto L7;
        boolean r11 = false;
    L12:
        monitor-exit(r10);     // Catch: Throwable -> L17
        if (r11 == false) goto L16;
        TraceEvent.onUiThreadReady();
    L16:
        return sUiThreadHandler;
    L7:
        if (sWillOverride == true) goto L10;
        sUiThreadHandler = new Handler(Looper.getMainLooper());     // Catch: Throwable -> L17
        r11 = true;
        goto L12
    L10:
        throw new RuntimeException("Did not yet override the UI thread");     // Catch: Throwable -> L17
    }

    public static Looper getUiThreadLooper() {
        return getUiThreadHandler().getLooper();
    }

    @CalledByNative
    private static boolean isThreadPriorityAudio(int r10) {
        if (Process.getThreadPriority(r10) != (-16)) goto L5;
        return true;
    L5:
        return false;
    }

    @Deprecated
    public static <T> FutureTask<T> postOnUiThread(FutureTask<T> r10) {
        getUiThreadHandler().post(r10);
        return r10;
    }

    @Deprecated
    public static void postOnUiThread(Runnable r10) {
        getUiThreadHandler().post(r10);
    }

    @Deprecated
    public static void postOnUiThreadDelayed(Runnable r10, long r11) {
        getUiThreadHandler().postDelayed(r10, r11);
    }

    @Deprecated
    public static <T> FutureTask<T> runOnUiThread(Callable<T> r10) {
        return runOnUiThread(new FutureTask(r10));
    }

    @Deprecated
    public static <T> FutureTask<T> runOnUiThread(FutureTask<T> r10) {
        if (runningOnUiThread() == false) goto L5;
        r10.run();
    L6:
        return r10;
    L5:
        postOnUiThread(r10);
        goto L6
    }

    @Deprecated
    public static void runOnUiThread(Runnable r10) {
        if (runningOnUiThread() == false) goto L5;
        r10.run();
        return;
    L5:
        getUiThreadHandler().post(r10);
    }

    @Deprecated
    public static <T> T runOnUiThreadBlocking(Callable<T> r10) {
        FutureTask r11 = new FutureTask(r10);
        runOnUiThread(r11);
        return (T) r11.get();
    L5:
        e = move-exception;
        throw new RuntimeException("Interrupted waiting for callable", e);
    }

    @Deprecated
    public static void runOnUiThreadBlocking(Runnable r10) {
        if (runningOnUiThread() == false) goto L5;
        r10.run();
        return;
    L5:
        FutureTask r11 = new FutureTask(r10, null);
        postOnUiThread(r11);
        r11.get();     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        throw new RuntimeException("Exception occurred while waiting for runnable", e);
    }

    @Deprecated
    public static <T> T runOnUiThreadBlockingNoException(Callable<T> r10) {
        return (T) runOnUiThreadBlocking(r10);
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

    public static void setThreadAssertsDisabledForTesting(boolean r10) {
        sThreadAssertsDisabled = r10;
    }

    @CalledByNative
    public static void setThreadPriorityAudio(int r10) {
        Process.setThreadPriority(r10, -16);
    }

    public static void setUiThread(Looper r10) {
        Object r11 = sLock;
        monitor-enter(r11);
        if (r10 == null) goto L6;
        Handler r12 = sUiThreadHandler;     // Catch: Throwable -> L20
        if (r12 != null) goto L12;
    L16:
        sUiThreadHandler = new Handler(r10);     // Catch: Throwable -> L20
        monitor-exit(r11);     // Catch: Throwable -> L20
        TraceEvent.onUiThreadReady();
        return;
    L12:
        if (r12.getLooper() == r10) goto L16;
        throw new RuntimeException("UI thread looper is already set to " + sUiThreadHandler.getLooper() + " (Main thread looper is " + Looper.getMainLooper() + "), cannot set to new looper " + r10);     // Catch: Throwable -> L20
    L6:
        sUiThreadHandler = null;     // Catch: Throwable -> L20
        monitor-exit(r11);     // Catch: Throwable -> L20
        return;
    L20:
        th = move-exception;
        throw th;
    }

    public static void setWillOverrideUiThread(boolean r10) {
        Object r11 = sLock;
        monitor-enter(r11);
        sWillOverride = r10;     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
