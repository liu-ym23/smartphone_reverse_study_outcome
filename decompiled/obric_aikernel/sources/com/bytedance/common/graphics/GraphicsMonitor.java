package com.bytedance.common.graphics;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.util.Log;
import androidx.annotation.Keep;
import com.bytedance.apm6.service.ServiceManager;
import com.bytedance.apm6.service.lifecycle.ActivityLifecycleService;
import com.bytedance.apm6.service.lifecycle.IActivityLifecycleObserver;
import com.bytedance.apm6.util.ApmBaseContext;
import com.bytedance.monitor.collector.k;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

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
    private static ActivityLifecycleService lifecycleService;
    private static long sCollectInterval;
    private static long sCollectWindow;
    private static int startTime;

    static class a implements IActivityLifecycleObserver {
        a() {
        }

        @Override // com.bytedance.apm6.service.lifecycle.IActivityLifecycleObserver
        public void onActivityCreated(Activity r10) {
        }

        @Override // com.bytedance.apm6.service.lifecycle.IActivityLifecycleObserver
        public void onActivityPause(Activity r10) {
        }

        @Override // com.bytedance.apm6.service.lifecycle.IActivityLifecycleObserver
        public void onActivityResume(Activity r10) {
        }

        @Override // com.bytedance.apm6.service.lifecycle.IActivityLifecycleObserver
        public void onActivityStarted(Activity r10) {
        }

        @Override // com.bytedance.apm6.service.lifecycle.IActivityLifecycleObserver
        public void onBackground(Activity r10) {
            GraphicsMonitor.access$002(true);
        }

        @Override // com.bytedance.apm6.service.lifecycle.IActivityLifecycleObserver
        public void onFront(Activity r10) {
            GraphicsMonitor.access$002(false);
        }
    }

    static class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (GraphicsMonitor.access$000() == true) goto L5;
            GraphicsMonitor.access$100();     // Catch: Throwable -> L8
            Thread.sleep(GraphicsMonitor.access$200());     // Catch: Throwable -> L8
            GraphicsMonitor.access$300();     // Catch: Throwable -> L8
            GraphicsMonitor.access$402(GraphicsMonitor.access$500());     // Catch: Throwable -> L8
        L6:
            Log.i("atrace_gpu", "bytegpu: " + GraphicsMonitor.access$400());     // Catch: Throwable -> L8
            return;
        L5:
            GraphicsMonitor.access$402(-1.0d);     // Catch: Throwable -> L8
        }
    }

    static {
    }

    public GraphicsMonitor() {
    }

    static /* synthetic */ boolean access$000() {
        return isPause;
    }

    static /* synthetic */ boolean access$002(boolean r10) {
        isPause = r10;
        return r10;
    }

    static /* synthetic */ void access$100() {
        openStatistical();
    }

    static /* synthetic */ long access$200() {
        return sCollectWindow;
    }

    static /* synthetic */ void access$300() {
        closeStatistical();
    }

    static /* synthetic */ double access$400() {
        return gpuLoadDataOnce;
    }

    static /* synthetic */ double access$402(double r10) {
        gpuLoadDataOnce = r10;
        return r10;
    }

    static /* synthetic */ double access$500() {
        return getStatisticOnceData();
    }

    @Keep
    private static native void closeStatistical();

    public static synchronized double getByteGpu() {
        monitor-enter(GraphicsMonitor.class);
        double r10 = gpuLoadDataOnce;     // Catch: Throwable -> L7
        monitor-exit(GraphicsMonitor.class);
        return r10;
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
        sCollectInterval = POLL_INTERVAL;     // Catch: Throwable -> L14
        sCollectWindow = 100;     // Catch: Throwable -> L14
        ActivityLifecycleService r10 = (ActivityLifecycleService) ServiceManager.getService(ActivityLifecycleService.class);     // Catch: Throwable -> L14
        lifecycleService = r10;     // Catch: Throwable -> L14
        r10.register(new a());     // Catch: Throwable -> L14
        if (lifecycleService.isForeground() == false) goto L12;
        isPause = false;     // Catch: Throwable -> L14
    L12:
        monitor-exit(GraphicsMonitor.class);
    }

    @SuppressLint({"CI_NotAllowInvokeExecutorsMethods"})
    private static void initGraphicsLoad() {
        isInitGraphicsLoad = true;
        k.u(ApmBaseContext.getContext());     // Catch: Throwable -> L5
        startHook();     // Catch: Throwable -> L5
        gpuScheduleService = Executors.newScheduledThreadPool(0);     // Catch: Throwable -> L5
        return;
    L5:
        isInitGraphicsLoad = false;
    }

    public static synchronized boolean isStart() {
        monitor-enter(GraphicsMonitor.class);
        if (startTime <= 0) goto L7;
        boolean r10 = true;
    L8:
        monitor-exit(GraphicsMonitor.class);
        return r10;
    L7:
        r10 = false;
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
        ScheduledExecutorService r10 = gpuScheduleService;     // Catch: Throwable -> L22
        if (r10 != null) goto L15;
        monitor-exit(GraphicsMonitor.class);
        return;
    L15:
        int r11 = startTime + 1;     // Catch: Throwable -> L22
        startTime = r11;     // Catch: Throwable -> L22
        if (r11 <= 1) goto L19;
        monitor-exit(GraphicsMonitor.class);
        return;
    L19:
        b r12 = new b();     // Catch: Throwable -> L22
        long r13 = sCollectInterval;     // Catch: Throwable -> L22
        gpuFuture = r10.scheduleWithFixedDelay(r12, r13, r13, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L22
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
        int r10 = startTime - 1;     // Catch: Throwable -> L21
        startTime = r10;     // Catch: Throwable -> L21
        if (r10 <= 0) goto L13;
        monitor-exit(GraphicsMonitor.class);
        return;
    L13:
        ScheduledFuture<?> r11 = gpuFuture;     // Catch: Throwable -> L21
        if (r11 == null) goto L16;
        r11.cancel(true);     // Catch: Throwable -> L21
    L16:
        gpuLoadDataOnce = -1.0d;     // Catch: Throwable -> L21
        monitor-exit(GraphicsMonitor.class);
    }
}
