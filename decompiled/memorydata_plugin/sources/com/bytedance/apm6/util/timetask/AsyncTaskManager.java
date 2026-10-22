package com.bytedance.apm6.util.timetask;

import com.bytedance.apm6.util.TraceUtils;
import com.bytedance.apm6.util.log.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

        private InnerRunnable(AsyncTaskManager r1, AsyncTask r2) {
            this.this$0 = r1;
            this.task = r2;
        }

        /* synthetic */ InnerRunnable(AsyncTaskManager r1, AsyncTask r2, AnonymousClass1 r3) {
            this(r1, r2);
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

    private AsyncTaskManager(String r3) {
        this.futureTasks = new ConcurrentHashMap();
        this.runnableTasks = new ConcurrentHashMap();
        this.pauseTasks = new ConcurrentHashMap();
        this.taskExecutor = new ScheduledThreadPoolExecutor(1, new SingleThreadFactory(r3));
    }

    public static synchronized AsyncTaskManager getInstance(AsyncTaskManagerType r3) {
        monitor-enter(AsyncTaskManager.class);
        if (r3 == null) goto L13;
        AsyncTaskManager r1 = (AsyncTaskManager) ZeusTransformUtils.preCheckCast(map.get(r3), AsyncTaskManager.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r1 != null) goto L8;
        r1 = new AsyncTaskManager(r3.name());     // Catch: Throwable -> L10
        map.put(r3, r1);     // Catch: Throwable -> L10
    L8:
        monitor-exit(AsyncTaskManager.class);
        return r1;
    L13:
        throw new IllegalArgumentException("AsyncTaskManagerType must be not null!");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public void pauseLoopTasks() {
        ConcurrentHashMap<AsyncTask, Runnable> r0 = this.runnableTasks;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.futureTasks == null) goto L34;
        monitor-enter(r0);
        Iterator<AsyncTask> r1 = this.runnableTasks.keySet().iterator();     // Catch: Throwable -> L18
    L9:
        if (r1.hasNext() == false) goto L20;
        AsyncTask r2 = (AsyncTask) ZeusTransformUtils.preCheckCast(r1.next(), AsyncTask.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
        if (r2.isLoop() == false) goto L9;
        this.taskExecutor.remove((Runnable) ZeusTransformUtils.preCheckCast(this.runnableTasks.get(r2), Runnable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L18
        ScheduledFuture r3 = (ScheduledFuture) ZeusTransformUtils.preCheckCast(this.futureTasks.remove(r2), ScheduledFuture.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
        if (r3 == null) goto L16;
        r3.cancel(true);     // Catch: Throwable -> L18
    L16:
        this.pauseTasks.put(r2, this.runnableTasks.get(r2));     // Catch: Throwable -> L18
    L20:
        monitor-exit(r0);     // Catch: Throwable -> L22
        return;
    L18:
        th = move-exception;
        Logger.e(Constant.TAG, "pauseLoopTasks failed.", th);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    }

    public void removeTask(AsyncTask r4) {
        Runnable r1 = (Runnable) ZeusTransformUtils.preCheckCast(this.runnableTasks.remove(r4), Runnable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r1 == null) goto L6;
        this.taskExecutor.remove(r1);     // Catch: Throwable -> L10
    L6:
        ScheduledFuture r3 = (ScheduledFuture) ZeusTransformUtils.preCheckCast(this.futureTasks.remove(r4), ScheduledFuture.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L15;
        r3.cancel(true);     // Catch: Throwable -> L10
        return;
    L15:
        return;
    L10:
        th = move-exception;
        Logger.e(Constant.TAG, "removeTask failed", th);
    }

    public void resumeTasks() {
        ConcurrentHashMap<AsyncTask, Runnable> r0 = this.pauseTasks;
        monitor-enter(r0);
        Iterator<AsyncTask> r1 = this.pauseTasks.keySet().iterator();     // Catch: Throwable -> L10
    L6:
        if (r1.hasNext() == false) goto L8;
        AsyncTask r2 = (AsyncTask) ZeusTransformUtils.preCheckCast(r1.next(), AsyncTask.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        ScheduledFuture<?> r3 = this.taskExecutor.scheduleWithFixedDelay((Runnable) ZeusTransformUtils.preCheckCast(this.pauseTasks.get(r2), Runnable.class, "com.obric.memorydata.plugin"), r2.getInitialDelay(), r2.getLoopInterval(), TimeUnit.MILLISECONDS);     // Catch: Throwable -> L10
        this.runnableTasks.put(r2, this.pauseTasks.get(r2));     // Catch: Throwable -> L10
        this.futureTasks.put(r2, r3);     // Catch: Throwable -> L10
        goto L6
    L8:
        this.pauseTasks.clear();     // Catch: Throwable -> L10
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    L10:
        th = move-exception;
        Logger.e(Constant.TAG, "resumeTasks failed.", th);     // Catch: Throwable -> L14
        goto L12
    }

    public void sendTask(AsyncTask r9) {
        if (r9 != null) goto L13;
        return;
    L13:
        InnerRunnable r7 = new InnerRunnable(this, r9, null);     // Catch: Throwable -> L10
        if (r9.isLoop() == false) goto L7;
        ScheduledFuture<?> r0 = this.taskExecutor.scheduleWithFixedDelay(r7, r9.getInitialDelay(), r9.getLoopInterval(), TimeUnit.MILLISECONDS);     // Catch: Throwable -> L10
    L8:
        this.runnableTasks.put(r9, r7);     // Catch: Throwable -> L10
        this.futureTasks.put(r9, r0);     // Catch: Throwable -> L10
        return;
    L7:
        r0 = this.taskExecutor.schedule(r7, r9.getInitialDelay(), TimeUnit.MILLISECONDS);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        Logger.e(Constant.TAG, "sendTask failed.", th);
    }
}
