package com.larksuite.framework.thread;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class ThreadUtils {
    private static Handler sHandler;

    public ThreadUtils() {
    }

    static {
        sHandler = new w(Looper.getMainLooper());
    }

    public static void runOnUIThread(Runnable r2) {
        runOnUIThread(r2, 0);
    }

    public static void runOnUIThread(Runnable r3, long r4) {
        if (Looper.getMainLooper() == Looper.myLooper()) goto L5;
    L7:
        sHandler.postDelayed(r3, r4);
        return;
    L5:
        if (r4 > 0) goto L7;
        r3.run();
    }
}
