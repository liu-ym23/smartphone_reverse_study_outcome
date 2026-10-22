package com.ss.android.lark.chameleon.util;

import android.os.Handler;
import android.os.Looper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class MainLooper {
    private static Handler mainLooperHandler;

    public MainLooper() {
    }

    static {
        mainLooperHandler = new Handler(Looper.getMainLooper());
    }

    public static boolean isRunningInMainThread() {
        if (ThreadMethodProxy.currentThread() != ThreadMethodProxy.getLooperThread(mainLooperHandler.getLooper())) goto L5;
        return true;
    L5:
        return false;
    }

    public static void post(Runnable r1) {
        mainLooperHandler.post(r1);
    }

    public static void removeCallbacks(Runnable r1) {
        mainLooperHandler.removeCallbacks(r1);
    }

    public static void runOnMainThread(Runnable r2) {
        if (Looper.getMainLooper() != Looper.myLooper()) goto L5;
        r2.run();
        return;
    L5:
        post(r2);
    }

    public static void postDelayed(Runnable r1, long r2) {
        mainLooperHandler.postDelayed(r1, r2);
    }

    public static void runOnMainThreadDelayed(Runnable r3, long r4) {
        if (Looper.getMainLooper() == Looper.myLooper()) goto L5;
    L7:
        postDelayed(r3, r4);
        return;
    L5:
        if (r4 > 0) goto L7;
        r3.run();
    }
}
