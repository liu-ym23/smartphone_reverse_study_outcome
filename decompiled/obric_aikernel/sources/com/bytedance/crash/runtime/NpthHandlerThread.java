package com.bytedance.crash.runtime;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class NpthHandlerThread {
    private static final String THREAD_NAME = "default_npth_thread";
    private static volatile ThreadWithHandler defaultHandlerThread;
    private static volatile Handler defaultMainHandler;

    public NpthHandlerThread() {
    }

    public static ThreadWithHandler getDefaultHandler() {
        if (defaultHandlerThread != null) goto L6;
        getDefaultHandlerThread();
    L6:
        return defaultHandlerThread;
    }

    public static HandlerThread getDefaultHandlerThread() {
        if (defaultHandlerThread != null) goto L15;
        monitor-enter(NpthHandlerThread.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (defaultHandlerThread != null) goto L9;
        defaultHandlerThread = new ThreadWithHandler(THREAD_NAME);     // Catch: Throwable -> L11
        defaultHandlerThread.start();     // Catch: Throwable -> L11
    L9:
        monitor-exit(NpthHandlerThread.class);     // Catch: Throwable -> L11
    L15:
        return defaultHandlerThread.getThread();
    }

    public static Handler getMainThreadHandler() {
        if (defaultMainHandler != null) goto L6;
        defaultMainHandler = new Handler(Looper.getMainLooper());
    L6:
        return defaultMainHandler;
    }

    public static void stopOtherTask() {
    }
}
