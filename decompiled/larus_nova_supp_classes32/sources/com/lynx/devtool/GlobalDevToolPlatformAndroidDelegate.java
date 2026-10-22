package com.lynx.devtool;

import android.util.Log;
import com.lynx.devtool.memory.MemoryController;
import com.lynx.devtool.memory.MemoryUsageResultSerializer;
import com.lynx.devtool.tracing.FPSTrace;
import com.lynx.devtool.tracing.FrameViewTrace;
import com.lynx.devtool.tracing.InstanceTrace;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceController;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class GlobalDevToolPlatformAndroidDelegate {
    private static final String EMPTY_RESULT_JSON = "{}";
    private static final String TAG = "GlobalDevToolPlatformAndroidDelegate";

    public GlobalDevToolPlatformAndroidDelegate() {
    }

    private static native void nativeOnMemoryUsageResult(long r0, String r2, String r3);

    public static long getFPSTracePlugin() {
        return FPSTrace.getInstance().getNativeFPSTrace();
    }

    public static long getFrameViewTracePlugin() {
        return FrameViewTrace.getInstance().getNativeFrameViewTrace();
    }

    public static long getInstanceTracePlugin() {
        return InstanceTrace.getInstance().getNativeInstanceTrace();
    }

    public static String getLynxVersion() {
        return LynxEnv.inst().getLynxVersion();
    }

    public static long getTraceController() {
        return TraceController.getInstance().getNativeTraceController();
    }

    public static void startMemoryTracing() {
        MemoryController.getInstance().startMemoryTracing();
    }

    public static void stopMemoryTracing() {
        MemoryController.getInstance().stopMemoryTracing();
    }

    private static String memoryUsageQueryFailure(Throwable r2) {
        String r0 = r2.getMessage();
        if (r0 != null) goto L5;
    L6:
        r0 = r2.getClass().getSimpleName();
    L8:
        return "Failed to query Lynx memory usage: ".concat(r0);
    L5:
        if (r0.isEmpty() == false) goto L8;
        goto L6
    }

    public static void queryAllMemoryUsage(long r2, final long r4) {
        final AtomicBoolean r0 = new AtomicBoolean(false);
        MemoryUsageResultSerializer.queryAllMemoryUsage(r2, new AnonymousClass1(r4, r0));     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        completeMemoryUsageQuery(r4, r0, EMPTY_RESULT_JSON, memoryUsageQueryFailure(th));
    }

    public static /* synthetic */ void access$000(long r0, AtomicBoolean r2, String r3, String r4) {
        completeMemoryUsageQuery(r0, r2, r3, r4);
    }

    private static void completeMemoryUsageQuery(long r2, AtomicBoolean r4, String r5, String r6) {
        if (r4.compareAndSet(false, true) == false) goto L11;
        nativeOnMemoryUsageResult(r2, r5, r6);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        LLog.e(TAG, "Failed to deliver Lynx memory usage result: " + Log.getStackTraceString(th));
        return;
    }
}
