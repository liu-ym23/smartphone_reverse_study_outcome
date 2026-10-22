package com.bytedance.crash.diagnose;

import android.os.SystemClock;
import com.bytedance.bdlocation.monitor.LBSLightLocationTraceLogger;
import com.bytedance.crash.runtime.DefaultWorkThread;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class InitMonitor {
    private static InitMonitor sInstance;
    private final JSONObject mJsonObject;
    private long mLastStepTime;
    private final long mStartTime;

    private InitMonitor() {
        this.mJsonObject = new JSONObject();
        long r0 = SystemClock.uptimeMillis();
        this.mStartTime = r0;
        this.mLastStepTime = r0;
    }

    public static void end() {
        if (sInstance != null) goto L9;
        return;
    L9:
        long r0 = SystemClock.uptimeMillis();     // Catch: Throwable -> L8
        InitMonitor r2 = sInstance;     // Catch: Throwable -> L8
        long r1 = r0 - r2.mStartTime;     // Catch: Throwable -> L8
        r2.mJsonObject.put(LBSLightLocationTraceLogger.TOTAL, r1);     // Catch: Throwable -> L8
    L6:
        DefaultWorkThread.post(new AnonymousClass1());
    }

    public static void start() {
        if (sInstance != null) goto L6;
        sInstance = new InitMonitor();
        return;
    }

    public static void step(String r6) {
        if (sInstance != null) goto L8;
        return;
    L8:
        long r0 = SystemClock.uptimeMillis();     // Catch: Throwable -> L7
        InitMonitor r2 = sInstance;     // Catch: Throwable -> L7
        r2.mJsonObject.put(r6, r0 - r2.mLastStepTime);     // Catch: Throwable -> L7
        sInstance.mLastStepTime = r0;     // Catch: Throwable -> L7
        return;
    }

    public static void upload() {
        if (sInstance == null) goto L6;
        new NpthMonitor.Event("npthStart").addMetrics(sInstance.mJsonObject).upload();
        sInstance = null;
        return;
    }
}
