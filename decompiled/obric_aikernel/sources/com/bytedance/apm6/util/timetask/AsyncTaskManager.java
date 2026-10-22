package com.bytedance.apm6.util.timetask;

import com.bytedance.apm6.util.TraceUtils;
import com.bytedance.apm6.util.log.Logger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class AsyncTaskManager {
    private static Map<AsyncTaskManagerType, AsyncTaskManager> map;
    private ConcurrentHashMap<AsyncTask, ScheduledFuture> futureTasks;
    private final ConcurrentHashMap<AsyncTask, Runnable> pauseTasks;
    private final ConcurrentHashMap<AsyncTask, Runnable> runnableTasks;
    private ScheduledThreadPoolExecutor taskExecutor;

    /* JADX INFO: renamed from: com.bytedance.apm6.util.timetask.AsyncTaskManager$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private class InnerRunnable implements Runnable {
        private AsyncTask task;
        final /* synthetic */ AsyncTaskManager this$0;

        private InnerRunnable(AsyncTaskManager r10, AsyncTask r11) {
            this.this$0 = r10;
            this.task = r11;
        }

        /* synthetic */ InnerRunnable(AsyncTaskManager r10, AsyncTask r11, AnonymousClass1 r12) {
            this(r10, r11);
        }

        @Override // java.lang.Runnable
        public void run() {
            TraceUtils.beginSection("APM-Task");
            this.task.run();     // Catch: Throwable -> L5
        L7:
            TraceUtils.endSection();
            return;
        L5:
            th = move-exception;
            Logger.e(Constant.TAG, "thread " + Thread.currentThread().getName() + " exception", th);
            goto L7
        }
    }

    static {
        map = new HashMap();
    }

    private AsyncTaskManager(String r10) {
        this.futureTasks = new ConcurrentHashMap();
        this.runnableTasks = new ConcurrentHashMap();
        this.pauseTasks = new ConcurrentHashMap();
        this.taskExecutor = new ScheduledThreadPoolExecutor(1, new SingleThreadFactory(r10));
    }

    public static synchronized AsyncTaskManager getInstance(AsyncTaskManagerType r10) {
        monitor-enter(AsyncTaskManager.class);
        if (r10 == null) goto L13;
        AsyncTaskManager r11 = map.get(r10);     // Catch: Throwable -> L10
        if (r11 != null) goto L8;
        r11 = new AsyncTaskManager(r10.name());     // Catch: Throwable -> L10
        map.put(r10, r11);     // Catch: Throwable -> L10
    L8:
        monitor-exit(AsyncTaskManager.class);
        return r11;
    L13:
        throw new IllegalArgumentException("AsyncTaskManagerType must be not null!");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public void pauseLoopTasks() {
        ConcurrentHashMap<AsyncTask, Runnable> r10 = this.runnableTasks;
        if (r10 != null) goto L5;
        return;
    L5:
        if (this.futureTasks == null) goto L34;
        monitor-enter(r10);
        Iterator<AsyncTask> r11 = this.runnableTasks.keySet().iterator();     // Catch: Throwable -> L18
    L9:
        if (r11.hasNext() == false) goto L20;
        AsyncTask r12 = r11.next();     // Catch: Throwable -> L18
        if (r12.isLoop() == false) goto L9;
        this.taskExecutor.remove(this.runnableTasks.get(r12));     // Catch: Throwable -> L18
        ScheduledFuture r13 = this.futureTasks.remove(r12);     // Catch: Throwable -> L18
        if (r13 == null) goto L16;
        r13.cancel(true);     // Catch: Throwable -> L18
    L16:
        this.pauseTasks.put(r12, this.runnableTasks.get(r12));     // Catch: Throwable -> L18
    L20:
        monitor-exit(r10);     // Catch: Throwable -> L22
        return;
    L22:
        th = move-exception;
        throw th;
    L18:
        th = move-exception;
        Logger.e(Constant.TAG, "pauseLoopTasks failed.", th);     // Catch: Throwable -> L22
        goto L20
    }

    public void removeTask(AsyncTask r10) {
        Runnable r11 = this.runnableTasks.remove(r10);     // Catch: Throwable -> L9
        if (r11 == null) goto L5;
        this.taskExecutor.remove(r11);     // Catch: Throwable -> L9
    L5:
        ScheduledFuture r12 = this.futureTasks.remove(r10);     // Catch: Throwable -> L9
        if (r12 == null) goto L14;
        r12.cancel(true);     // Catch: Throwable -> L9
        return;
    L14:
        return;
    L9:
        th = move-exception;
        Logger.e(Constant.TAG, "removeTask failed", th);
    }

    public void resumeTasks() {
        ConcurrentHashMap<AsyncTask, Runnable> r10 = this.pauseTasks;
        monitor-enter(r10);
        Iterator<AsyncTask> r11 = this.pauseTasks.keySet().iterator();     // Catch: Throwable -> L10
    L6:
        if (r11.hasNext() == false) goto L8;
        AsyncTask r12 = r11.next();     // Catch: Throwable -> L10
        ScheduledFuture<?> r13 = this.taskExecutor.scheduleWithFixedDelay(this.pauseTasks.get(r12), r12.getInitialDelay(), r12.getLoopInterval(), TimeUnit.MILLISECONDS);     // Catch: Throwable -> L10
        this.runnableTasks.put(r12, this.pauseTasks.get(r12));     // Catch: Throwable -> L10
        this.futureTasks.put(r12, r13);     // Catch: Throwable -> L10
        goto L6
    L8:
        this.pauseTasks.clear();     // Catch: Throwable -> L10
    L12:
        monitor-exit(r10);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    L10:
        th = move-exception;
        Logger.e(Constant.TAG, "resumeTasks failed.", th);     // Catch: Throwable -> L14
        goto L12
    }

    public void sendTask(AsyncTask r10) {
        if (r10 != null) goto L13;
        return;
    L13:
        InnerRunnable r11 = new InnerRunnable(this, r10, null);     // Catch: Throwable -> L10
        if (r10.isLoop() == false) goto L7;
        ScheduledFuture<?> r12 = this.taskExecutor.scheduleWithFixedDelay(r11, r10.getInitialDelay(), r10.getLoopInterval(), TimeUnit.MILLISECONDS);     // Catch: Throwable -> L10
    L8:
        this.runnableTasks.put(r10, r11);     // Catch: Throwable -> L10
        this.futureTasks.put(r10, r12);     // Catch: Throwable -> L10
        return;
    L7:
        r12 = this.taskExecutor.schedule(r11, r10.getInitialDelay(), TimeUnit.MILLISECONDS);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        Logger.e(Constant.TAG, "sendTask failed.", th);
    }
}
