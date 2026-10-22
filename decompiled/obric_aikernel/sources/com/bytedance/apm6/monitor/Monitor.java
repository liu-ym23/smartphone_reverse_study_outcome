package com.bytedance.apm6.monitor;

import android.os.Build;
import com.bytedance.apm6.util.ApmBaseContext;
import com.bytedance.apm6.util.log.Logger;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes.dex */
public class Monitor {
    private static final long DROP_LOG_INTERVAL_MS = 60000;
    private static final String LOG_TAG = "APM-Monitor";
    private static final int MAX_QUEUE_SIZE = 2000;
    private static final String THREAD_NAME = "APM-Monitor";
    private static final AtomicInteger droppedCount = null;
    private static List<MonitorableHandler> handlers;
    private static List<MonitorableInterceptor> interceptors;
    private static volatile boolean isWorking;
    private static final AtomicLong lastDropLogTime = null;
    private static final BlockingQueue<Monitorable> queue = null;
    private static final AtomicInteger queueSize = null;

    static {
        handlers = new CopyOnWriteArrayList();
        interceptors = new CopyOnWriteArrayList();
        queueSize = new AtomicInteger();
        droppedCount = new AtomicInteger();
        lastDropLogTime = new AtomicLong();
        if (Build.VERSION.SDK_INT < 21) goto L5;
        BlockingQueue<Monitorable> r10 = new LinkedTransferQueue();
    L6:
        queue = r10;
        isWorking = false;
        return;
    L5:
        r10 = new LinkedBlockingQueue();
        goto L6
    }

    public Monitor() {
    }

    static /* synthetic */ BlockingQueue access$000() {
        return queue;
    }

    static /* synthetic */ void access$100() {
        decreaseQueueSize();
    }

    static /* synthetic */ List access$200() {
        return interceptors;
    }

    static /* synthetic */ List access$300() {
        return handlers;
    }

    private static void decreaseQueueSize() {
    L2:
        AtomicInteger r10 = queueSize;
        int r11 = r10.get();
        if (r11 <= 0) goto L4;
        if (r10.compareAndSet(r11, r11 - 1) == false) goto L2;
        return;
    }

    private static void onQueueFull(Monitorable r10) {
        int r11 = droppedCount.incrementAndGet();
        long r12 = System.currentTimeMillis();
        AtomicLong r13 = lastDropLogTime;
        long r14 = r13.get();
        if (ApmBaseContext.isDebugMode() == true) goto L7;
        if ((r12 - r14) >= 60000) goto L7;
        return;
    L7:
        if (r13.compareAndSet(r14, r12) == false) goto L9;
    L10:
        Logger.e("APM-Monitor", "monitor queue is full. droppedCount=" + r11 + ", maxQueueSize=" + MAX_QUEUE_SIZE + ", currentQueueSize=" + queueSize.get() + ", logType=" + safeLogType(r10));
        return;
    L9:
        if (ApmBaseContext.isDebugMode() == true) goto L10;
    }

    public static void record(Monitorable r10) {
        if (r10 != null) goto L6;
        return;
    L6:
        if (tryIncreaseQueueSize() == true) goto L9;
        onQueueFull(r10);
        return;
    L9:
        boolean r11 = false;
        r11 = queue.offer(r10);     // Catch: Throwable -> L15
        if (r11 == true) goto L13;
        Logger.e("APM-Monitor", "queue offer failed. monitorable=" + r10);     // Catch: Throwable -> L15
    L13:
        if (r11 == true) goto L19;
    L14:
        decreaseQueueSize();
    L19:
        if (r11 == true) goto L21;
        return;
    L21:
        if (isWorking == true) goto L33;
        startWork();
        return;
    L33:
        return;
    L15:
        th = move-exception;
        Logger.e("APM-Monitor", "queue offer failed. monitorable=" + r10, th);     // Catch: Throwable -> L24
        if (r11 == true) goto L19;
    L24:
        th = move-exception;
        if (r11 == true) goto L27;
        decreaseQueueSize();
    L27:
        throw th;
    }

    public static void registerHandler(MonitorableHandler r10) {
        if (handlers.contains(r10) == true) goto L6;
        handlers.add(r10);
        return;
    }

    public static void registerInterceptor(MonitorableInterceptor r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (interceptors.contains(r10) == true) goto L8;
        interceptors.add(r10);
        return;
    }

    private static String safeLogType(Monitorable r10) {
        if (r10 == null) goto L10;
        return r10.getLogType();
    L6:
        return "unknown";
    L10:
        return "null";
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

    private static boolean tryIncreaseQueueSize() {
    L2:
        AtomicInteger r10 = queueSize;
        int r11 = r10.get();
        if (r11 >= MAX_QUEUE_SIZE) goto L4;
        if (r10.compareAndSet(r11, r11 + 1) == false) goto L2;
        return true;
    L4:
        return false;
    }
}
