package com.bytedance.ai.ex.widget;

import android.os.Looper;
import androidx.annotation.VisibleForTesting;

/* JADX INFO: loaded from: classes2.dex */
public class Assert {
    private static final Looper sMainLooper = null;
    private static Thread sTestThread;

    static {
        sMainLooper = Looper.getMainLooper();
        sTestThread = null;
    }

    public Assert() {
    }

    public static void isCurrentThread(Looper r5) {
        if (r5.isCurrentThread() == true) goto L11;
        Thread r10 = sTestThread;
        if (r10 == null) goto L10;
        if (r10 != Thread.currentThread()) goto L10;
        return;
    L10:
        throw new IllegalStateException("Called on wrong thread thread. wanted " + r5.getThread().getName() + " but instead got Thread.currentThread()=" + Thread.currentThread().getName());
    }

    public static void isMainThread() {
        Looper r5 = sMainLooper;
        if (r5.isCurrentThread() == true) goto L11;
        Thread r10 = sTestThread;
        if (r10 == null) goto L10;
        if (r10 != Thread.currentThread()) goto L10;
        return;
    L10:
        throw new IllegalStateException("should be called from the main thread. sMainLooper.threadName=" + r5.getThread().getName() + " Thread.currentThread()=" + Thread.currentThread().getName());
    }

    public static void isNotMainThread() {
        if (sMainLooper.isCurrentThread() == false) goto L11;
        Thread r5 = sTestThread;
        if (r5 == null) goto L10;
        if (r5 == Thread.currentThread()) goto L10;
        return;
    L10:
        throw new IllegalStateException("should not be called from the main thread.");
    }

    @VisibleForTesting
    public static void runWithCurrentThreadAsMainThread(Runnable r5) {
        if (sMainLooper.isCurrentThread() == false) goto L6;
        r5.run();
        return;
    L6:
        Thread r10 = Thread.currentThread();
        Thread r11 = sTestThread;
        if (r11 != r10) goto L10;
        r5.run();
        return;
    L10:
        if (r11 != null) goto L14;
        sTestThread = r10;
        r5.run();
        sTestThread = null;
        return;
    L14:
        throw new AssertionError("Can't run with current thread (" + r10 + ") as main thread; test thread is already set to " + r11);
    }

    @VisibleForTesting
    public static void setTestThread(Thread r5) {
        sTestThread = r5;
    }

    @VisibleForTesting
    public static void setTestableLooper(Looper r5) {
        if (r5 != null) goto L4;
        Thread r10 = null;
    L5:
        setTestThread(r10);
        return;
    L4:
        r10 = r5.getThread();
        goto L5
    }
}
