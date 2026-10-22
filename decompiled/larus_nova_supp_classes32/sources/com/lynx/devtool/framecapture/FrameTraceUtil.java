package com.lynx.devtool.framecapture;

import android.os.SystemClock;
import android.view.Choreographer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class FrameTraceUtil {
    private static long mFrameIntervalNanos = 16666666;

    public FrameTraceUtil() {
    }

    public static long getSystemBootTimeNs() {
        return SystemClock.elapsedRealtimeNanos();
    }

    public static long getFrameIntervalNanos() {
        return mFrameIntervalNanos;
    }

    public static void addFrameCallback(final Runnable r2) {
        Choreographer.getInstance().postFrameCallback(new AnonymousClass1(r2));
    }
}
