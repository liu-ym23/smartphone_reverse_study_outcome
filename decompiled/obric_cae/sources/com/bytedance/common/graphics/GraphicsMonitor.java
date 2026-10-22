package com.bytedance.common.graphics;

import android.annotation.SuppressLint;
import android.util.Log;
import androidx.annotation.Keep;
import com.bytedance.android.bytehook.ByteHook;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import m3.c;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class GraphicsMonitor {
    private static final long COLLECT_WINDOWS = 100;
    private static final String MTK = "mt";
    private static final long POLL_INTERVAL = 15000;
    private static ScheduledFuture<?> gpuFuture = null;
    private static double gpuLoadDataOnce = -1.0d;
    private static ScheduledExecutorService gpuScheduleService = null;
    private static boolean isInit = false;
    private static boolean isInitGraphicsLoad = false;
    private static volatile boolean isPause = false;
    private static n3.a lifecycleService;
    private static long sCollectInterval;
    private static long sCollectWindow;
    private static int startTime;

    public static class a implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            if (GraphicsMonitor.access$000() == true) goto L6;
            GraphicsMonitor.access$100();     // Catch: Throwable -> L9
            Thread.sleep(GraphicsMonitor.access$200());     // Catch: Throwable -> L9
            GraphicsMonitor.access$300();     // Catch: Throwable -> L9
            GraphicsMonitor.access$402(GraphicsMonitor.access$500());     // Catch: Throwable -> L9
        L7:
            Log.i("atrace_gpu", "bytegpu: " + GraphicsMonitor.access$400());     // Catch: Throwable -> L9
            return;
        L6:
            GraphicsMonitor.access$402(-1.0d);     // Catch: Throwable -> L9
        }
    }

    public GraphicsMonitor() {
    }

    public static /* synthetic */ boolean access$000() {
        return isPause;
    }

    public static /* synthetic */ boolean access$002(boolean r8) {
        isPause = r8;
        return r8;
    }

    public static /* synthetic */ void access$100() {
        openStatistical();
    }

    public static /* synthetic */ long access$200() {
        return sCollectWindow;
    }

    public static /* synthetic */ void access$300() {
        closeStatistical();
    }

    public static /* synthetic */ double access$400() {
        return gpuLoadDataOnce;
    }

    public static /* synthetic */ double access$402(double r8) {
        gpuLoadDataOnce = r8;
        return r8;
    }

    public static /* synthetic */ double access$500() {
        return getStatisticOnceData();
    }

    @Keep
    private static native void closeStatistical();

    public static synchronized double getByteGpu() {
        monitor-enter(GraphicsMonitor.class);
        double r8 = gpuLoadDataOnce;     // Catch: Throwable -> L7
        monitor-exit(GraphicsMonitor.class);
        return r8;
    L7:
        th = move-exception;
        throw th;
    }

    @Keep
    private static native double getStatisticOnceData();

    public static synchronized void init() {
        monitor-enter(GraphicsMonitor.class);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (isInit == false) goto L9;
        monitor-exit(GraphicsMonitor.class);
        return;
    L9:
        isInit = true;     // Catch: Throwable -> L14
        sCollectInterval = 15000;     // Catch: Throwable -> L14
        sCollectWindow = COLLECT_WINDOWS;     // Catch: Throwable -> L14
        n3.a r8 = (n3.a) c.a(n3.a.class);     // Catch: Throwable -> L14
        lifecycleService = r8;     // Catch: Throwable -> L14
        r8.a();     // Catch: Throwable -> L14
        if (lifecycleService.isForeground() == false) goto L12;
        isPause = false;     // Catch: Throwable -> L14
    L12:
        monitor-exit(GraphicsMonitor.class);
    }

    @SuppressLint({"CI_NotAllowInvokeExecutorsMethods"})
    private static void initGraphicsLoad() {
        isInitGraphicsLoad = true;
        monitor-enter(com.bytedance.monitor.collector.a.class);     // Catch: Throwable -> L13
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L6:
        if (com.bytedance.monitor.collector.a.f3967b == true) goto L8;
        com.bytedance.monitor.collector.a.f3967b = b8.a.a();     // Catch: Throwable -> L10
        ByteHook.init();     // Catch: Throwable -> L10
    L8:
        monitor-exit(com.bytedance.monitor.collector.a.class);     // Catch: Throwable -> L13
        startHook();     // Catch: Throwable -> L13
        gpuScheduleService = Executors.newScheduledThreadPool(0);     // Catch: Throwable -> L13
        return;
    L13:
        isInitGraphicsLoad = false;
    }

    public static synchronized boolean isStart() {
        monitor-enter(GraphicsMonitor.class);
        if (startTime <= 0) goto L7;
        boolean r8 = true;
    L8:
        monitor-exit(GraphicsMonitor.class);
        return r8;
    L7:
        r8 = false;
    L10:
        th = move-exception;
        throw th;
    }

    @Keep
    private static native void openStatistical();

    public static synchronized void start() {
        monitor-enter(GraphicsMonitor.class);
    L22:
        th = move-exception;
        throw th;
    L5:
        if (isInit == true) goto L9;
        monitor-exit(GraphicsMonitor.class);
        return;
    L9:
        if (isInitGraphicsLoad == true) goto L11;
        initGraphicsLoad();     // Catch: Throwable -> L22
    L11:
        ScheduledExecutorService r8 = gpuScheduleService;     // Catch: Throwable -> L22
        if (r8 != null) goto L15;
        monitor-exit(GraphicsMonitor.class);
        return;
    L15:
        int r10 = startTime + 1;     // Catch: Throwable -> L22
        startTime = r10;     // Catch: Throwable -> L22
        if (r10 <= 1) goto L19;
        monitor-exit(GraphicsMonitor.class);
        return;
    L19:
        a r11 = new a();     // Catch: Throwable -> L22
        long r12 = sCollectInterval;     // Catch: Throwable -> L22
        gpuFuture = r8.scheduleWithFixedDelay(r11, r12, r12, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L22
        monitor-exit(GraphicsMonitor.class);
    }

    @Keep
    private static native boolean startHook();

    public static synchronized void stop() {
        monitor-enter(GraphicsMonitor.class);
    L21:
        th = move-exception;
        throw th;
    L5:
        if (isInit == true) goto L7;
    L19:
        monitor-exit(GraphicsMonitor.class);
        return;
    L7:
        if (isStart() == false) goto L19;
        int r8 = startTime - 1;     // Catch: Throwable -> L21
        startTime = r8;     // Catch: Throwable -> L21
        if (r8 <= 0) goto L13;
        monitor-exit(GraphicsMonitor.class);
        return;
    L13:
        ScheduledFuture<?> r10 = gpuFuture;     // Catch: Throwable -> L21
        if (r10 == null) goto L16;
        r10.cancel(true);     // Catch: Throwable -> L21
    L16:
        gpuLoadDataOnce = -1.0d;     // Catch: Throwable -> L21
        monitor-exit(GraphicsMonitor.class);
    }
}
