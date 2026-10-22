package com.bytedance.crash.diagnose;

import android.os.SystemClock;
import com.bytedance.crash.runtime.DefaultWorkThread;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class InitMonitor {
    private static InitMonitor sInstance;
    private final JSONObject mJsonObject;
    private long mLastStepTime;
    private final long mStartTime;

    private InitMonitor() {
        this.mJsonObject = new JSONObject();
        long r10 = SystemClock.uptimeMillis();
        this.mStartTime = r10;
        this.mLastStepTime = r10;
    }

    public static void end() {
        if (sInstance != null) goto L9;
        return;
    L9:
        long r10 = SystemClock.uptimeMillis();     // Catch: Throwable -> L8
        InitMonitor r11 = sInstance;     // Catch: Throwable -> L8
        long r12 = r10 - r11.mStartTime;     // Catch: Throwable -> L8
        r11.mJsonObject.put("total", r12);     // Catch: Throwable -> L8
    L6:
        DefaultWorkThread.post(new AnonymousClass1());
    }

    public static void start() {
        if (sInstance != null) goto L6;
        sInstance = new InitMonitor();
        return;
    }

    public static void step(String r10) {
        if (sInstance != null) goto L8;
        return;
    L8:
        long r11 = SystemClock.uptimeMillis();     // Catch: Throwable -> L7
        InitMonitor r12 = sInstance;     // Catch: Throwable -> L7
        r12.mJsonObject.put(r10, r11 - r12.mLastStepTime);     // Catch: Throwable -> L7
        sInstance.mLastStepTime = r11;     // Catch: Throwable -> L7
        return;
    }

    public static void upload() {
        if (sInstance == null) goto L6;
        new NpthMonitor.Event("npthStart").addMetrics(sInstance.mJsonObject).upload();
        sInstance = null;
        return;
    }
}
