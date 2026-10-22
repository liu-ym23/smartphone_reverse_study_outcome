package com.bytedance.common.graphics;

import ai.j0;
import android.annotation.SuppressLint;
import androidx.annotation.Keep;
import com.bytedance.android.bytehook.ByteHook;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import jg.k;
import s7.a;

/* JADX INFO: loaded from: classes2.dex */
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
    private static a lifecycleService;
    private static long sCollectInterval;
    private static long sCollectWindow;
    private static int startTime;

    public GraphicsMonitor() {
    }

    public static /* synthetic */ boolean access$000() {
        return isPause;
    }

    public static /* synthetic */ boolean access$002(boolean r5) {
        isPause = r5;
        return r5;
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

    public static /* synthetic */ double access$402(double r5) {
        gpuLoadDataOnce = r5;
        return r5;
    }

    public static /* synthetic */ double access$500() {
        return getStatisticOnceData();
    }

    @Keep
    private static native void closeStatistical();

    public static synchronized double getByteGpu() {
        monitor-enter(GraphicsMonitor.class);
        double r5 = gpuLoadDataOnce;     // Catch: Throwable -> L7
        monitor-exit(GraphicsMonitor.class);
        return r5;
    L7:
        th = move-exception;
        throw th;
    }

    @Keep
    private static native double getStatisticOnceData();

    public static synchronized void init() {
        monitor-enter(GraphicsMonitor.class);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (isInit == false) goto L9;
        monitor-exit(GraphicsMonitor.class);
        return;
    L9:
        isInit = true;     // Catch: Throwable -> L11
        sCollectInterval = POLL_INTERVAL;     // Catch: Throwable -> L11
        sCollectWindow = COLLECT_WINDOWS;     // Catch: Throwable -> L11
        j0.A(r7.a.a(a.class));     // Catch: Throwable -> L11
        throw null;     // Catch: Throwable -> L11
    }

    @SuppressLint({"CI_NotAllowInvokeExecutorsMethods"})
    private static void initGraphicsLoad() {
        isInitGraphicsLoad = true;
        monitor-enter(k.class);     // Catch: Throwable -> L16
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L6:
        if (k.f18337c == true) goto L11;
        k.f18337c = lg.a.a();     // Catch: Throwable -> L9
        ByteHook.init();     // Catch: Throwable -> L9
    L11:
        monitor-exit(k.class);     // Catch: Throwable -> L16
        startHook();     // Catch: Throwable -> L16
        gpuScheduleService = Executors.newScheduledThreadPool(0);     // Catch: Throwable -> L16
        return;
    L16:
        isInitGraphicsLoad = false;
    }

    public static synchronized boolean isStart() {
        monitor-enter(GraphicsMonitor.class);
        if (startTime <= 0) goto L7;
        boolean r5 = true;
    L8:
        monitor-exit(GraphicsMonitor.class);
        return r5;
    L7:
        r5 = false;
    L10:
        th = move-exception;
        throw th;
    }

    @Keep
    private static native void openStatistical();

    public static synchronized void start() {
        monitor-enter(GraphicsMonitor.class);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (isInit == true) goto L9;
        monitor-exit(GraphicsMonitor.class);
        return;
    L9:
        if (isInitGraphicsLoad == true) goto L13;
        initGraphicsLoad();     // Catch: Throwable -> L11
    L13:
        ScheduledExecutorService r5 = gpuScheduleService;     // Catch: Throwable -> L11
        if (r5 != null) goto L17;
        monitor-exit(GraphicsMonitor.class);
        return;
    L17:
        int r10 = startTime + 1;     // Catch: Throwable -> L11
        startTime = r10;     // Catch: Throwable -> L11
        if (r10 <= 1) goto L21;
        monitor-exit(GraphicsMonitor.class);
        return;
    L21:
        com.bytedance.android.anniex.worker.a r11 = new com.bytedance.android.anniex.worker.a(19);     // Catch: Throwable -> L11
        long r12 = sCollectInterval;     // Catch: Throwable -> L11
        gpuFuture = r5.scheduleWithFixedDelay(r11, r12, r12, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L11
        monitor-exit(GraphicsMonitor.class);
    }

    @Keep
    private static native boolean startHook();

    public static synchronized void stop() {
        monitor-enter(GraphicsMonitor.class);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (isInit == true) goto L7;
    L21:
        monitor-exit(GraphicsMonitor.class);
        return;
    L7:
        if (isStart() == false) goto L21;
        int r5 = startTime - 1;     // Catch: Throwable -> L16
        startTime = r5;     // Catch: Throwable -> L16
        if (r5 <= 0) goto L13;
        monitor-exit(GraphicsMonitor.class);
        return;
    L13:
        ScheduledFuture<?> r10 = gpuFuture;     // Catch: Throwable -> L16
        if (r10 == null) goto L18;
        r10.cancel(true);     // Catch: Throwable -> L16
    L18:
        gpuLoadDataOnce = -1.0d;     // Catch: Throwable -> L16
        monitor-exit(GraphicsMonitor.class);
    }
}
