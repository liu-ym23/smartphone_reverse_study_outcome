package com.bytedance.apm6.monitor;

import android.os.Build;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.LinkedTransferQueue;

/* JADX INFO: loaded from: classes.dex */
public class Monitor {
    private static final String LOG_TAG = "APM-Monitor";
    private static final String THREAD_NAME = "APM-Monitor";
    private static List<MonitorableHandler> handlers;
    private static List<MonitorableInterceptor> interceptors;
    private static volatile boolean isWorking;
    private static final BlockingQueue<Monitorable> queue = null;

    static {
        handlers = new CopyOnWriteArrayList();
        interceptors = new CopyOnWriteArrayList();
        if (Build.VERSION.SDK_INT < 21) goto L5;
        BlockingQueue<Monitorable> r0 = new LinkedTransferQueue();
    L6:
        queue = r0;
        isWorking = false;
        return;
    L5:
        r0 = new LinkedBlockingQueue();
        goto L6
    }

    public Monitor() {
    }

    static /* synthetic */ BlockingQueue access$000() {
        return queue;
    }

    static /* synthetic */ List access$100() {
        return interceptors;
    }

    static /* synthetic */ List access$200() {
        return handlers;
    }

    public static void record(Monitorable r2) {
        Monitorable r3 = (Monitorable) ZeusTransformUtils.wrapperContextForParams(r2, Monitorable.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L5;
        return;
    L5:
        queue.offer(r3);
        if (isWorking == true) goto L9;
        startWork();
        return;
    }

    public static void registerHandler(MonitorableHandler r2) {
        MonitorableHandler r3 = (MonitorableHandler) ZeusTransformUtils.wrapperContextForParams(r2, MonitorableHandler.class, "com.obric.memorydata.plugin");
        if (handlers.contains(r3) == true) goto L6;
        handlers.add(r3);
        return;
    }

    public static void registerInterceptor(MonitorableInterceptor r2) {
        MonitorableInterceptor r3 = (MonitorableInterceptor) ZeusTransformUtils.wrapperContextForParams(r2, MonitorableInterceptor.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L5;
        return;
    L5:
        if (interceptors.contains(r3) == true) goto L9;
        interceptors.add(r3);
        return;
    }

    private static synchronized void startWork() {
        monitor-enter(Monitor.class);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (isWorking == false) goto L9;
        monitor-exit(Monitor.class);
        return;
    L9:
        isWorking = true;     // Catch: Throwable -> L12
        new Thread(new AnonymousClass1(), "APM-Monitor").start();     // Catch: Throwable -> L12
        monitor-exit(Monitor.class);
    }
}
