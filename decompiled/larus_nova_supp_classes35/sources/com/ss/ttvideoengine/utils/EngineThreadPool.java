package com.ss.ttvideoengine.utils;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class EngineThreadPool {
    private static final String TAG = "EngineThreadPool";
    private static final int THREADPOOL_ALIVE_TIME_SEC = 60;
    private static final int THREADPOOL_CORE_POOL_SIZE = 0;
    private static final int THREADPOOL_MAX_POOL_SIZE = Integer.MAX_VALUE;
    private static final int THREADPOOL_MAX_RUNNING_TASK_SIZE = 5;
    private static volatile boolean mEnableLockOptimize;
    private static volatile boolean mEnableThreadPoolOptimize;
    private static volatile ThreadPoolExecutor mExecutorInstance;
    private static Deque<AsyncRunnable> mReadyRunnables;
    private static Deque<AsyncRunnable> mRunningRunnables;

    public static class AsyncRunnable implements Runnable {
        private Runnable mRunnable;

        @Override // java.lang.Runnable
        public void run() {
            com_ss_ttvideoengine_utils_EngineThreadPool$AsyncRunnable_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_ss_ttvideoengine_utils_EngineThreadPool$AsyncRunnable__run$___twin___() {
            this.mRunnable.run();
            EngineThreadPool.access$000(this);
        }

        public AsyncRunnable(Runnable r1) {
            this.mRunnable = r1;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_ss_ttvideoengine_utils_EngineThreadPool$AsyncRunnable_com_larus_apm_impl_protector_RunnableLancet_run(AsyncRunnable r1) {
            r1.com_ss_ttvideoengine_utils_EngineThreadPool$AsyncRunnable__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public EngineThreadPool() {
    }

    static {
        mReadyRunnables = new ArrayDeque();
        mRunningRunnables = new ArrayDeque();
        mEnableThreadPoolOptimize = true;
    }

    private static void _promoteRunnable() {
        if (mReadyRunnables.size() <= 0) goto L8;
        Iterator<AsyncRunnable> r0 = mReadyRunnables.iterator();
        if (r0.hasNext() == false) goto L9;
        AsyncRunnable r1 = r0.next();
        r0.remove();
        mRunningRunnables.add(r1);
        mExecutorInstance.execute(r1);
        return;
    L9:
        return;
    }

    public static ThreadPoolExecutor getExecutorInstance() {
        if (mExecutorInstance != null) goto L18;
        monitor-enter(EngineThreadPool.class);
    L14:
        th = move-exception;
        throw th;
    L7:
        if (mExecutorInstance == null) goto L9;
    L12:
        monitor-exit(EngineThreadPool.class);     // Catch: Throwable -> L14
        goto L18
    L9:
        if (mEnableThreadPoolOptimize == false) goto L11;
        TTVideoEngineInternalLog.i(TAG, "mEnableThreadPoolOptimize true");     // Catch: Throwable -> L14
        mExecutorInstance = new PThreadPoolExecutor(5, 5, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory(TAG));     // Catch: Throwable -> L14
        mExecutorInstance.allowCoreThreadTimeOut(true);     // Catch: Throwable -> L14
        goto L12
    L11:
        mExecutorInstance = new PThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), new DefaultThreadFactory(TAG));     // Catch: Throwable -> L14
    L18:
        return mExecutorInstance;
    }

    public static int getPoolSize() {
        if (mExecutorInstance != null) goto L6;
        getExecutorInstance();
    L6:
        return mExecutorInstance.getPoolSize();
    }

    public static void shutdown() {
        if (mExecutorInstance == null) goto L6;
        mExecutorInstance.shutdown();
        return;
    }

    private static synchronized void _finished(AsyncRunnable r2) {
        monitor-enter(EngineThreadPool.class);
        mRunningRunnables.remove(r2);     // Catch: Throwable -> L7
        _promoteRunnable();     // Catch: Throwable -> L7
        monitor-exit(EngineThreadPool.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ void access$000(AsyncRunnable r0) {
        _finished(r0);
    }

    public static Future addExecuteTask(Runnable r1) {
        if (mEnableLockOptimize == false) goto L7;
        return addExecuteTaskInternal(r1);
    L7:
        monitor-enter(EngineThreadPool.class);
        Future r2 = addExecuteTaskInternal(r1);     // Catch: Throwable -> L11
        monitor-exit(EngineThreadPool.class);     // Catch: Throwable -> L11
        return r2;
    L11:
        th = move-exception;
        throw th;
    }

    private static Future addExecuteTaskInternal(Runnable r5) {
        if (r5 != null) goto L6;
        return null;
    L6:
        if (mExecutorInstance != null) goto L30;
        getExecutorInstance();
    L30:
        TTVideoEngineInternalLog.i(TAG, "addExecuteTask,pool size:" + getPoolSize() + ", active:" + mExecutorInstance.getActiveCount());     // Catch: Exception -> L10
    L13:
        if (mEnableThreadPoolOptimize == false) goto L17;
        return mExecutorInstance.submit(r5);
    L17:
        monitor-enter(EngineThreadPool.class);
        TTVideoEngineInternalLog.i(TAG, "running:" + mRunningRunnables.size() + ", ready:" + mReadyRunnables.size());     // Catch: Throwable -> L26
        AsyncRunnable r0 = new AsyncRunnable(r5);     // Catch: Throwable -> L26
        if (mRunningRunnables.size() < 5) goto L23;
        mReadyRunnables.add(r0);     // Catch: Throwable -> L26
        monitor-exit(EngineThreadPool.class);     // Catch: Throwable -> L26
        return null;
    L23:
        mRunningRunnables.add(r0);     // Catch: Throwable -> L26
        Future<?> r6 = mExecutorInstance.submit(r0);     // Catch: Throwable -> L26
        monitor-exit(EngineThreadPool.class);     // Catch: Throwable -> L26
        return r6;
    L26:
        th = move-exception;
        throw th;
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L13
    }

    public static void setExecutorInstance(ThreadPoolExecutor r1) {
        monitor-enter(EngineThreadPool.class);
        mExecutorInstance = r1;     // Catch: Throwable -> L7
        monitor-exit(EngineThreadPool.class);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized void setOptimizeEnabled(boolean r1) {
        monitor-enter(EngineThreadPool.class);
        mEnableThreadPoolOptimize = r1;     // Catch: Throwable -> L7
        monitor-exit(EngineThreadPool.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void setOptimizeLock(boolean r0) {
        mEnableLockOptimize = r0;
    }

    public static Future addExecuteTaskSync(Runnable r1, long r2) {
        if (mEnableLockOptimize == false) goto L7;
        return addExecuteTaskSyncInternal(r1, r2);
    L7:
        monitor-enter(EngineThreadPool.class);
        Future r3 = addExecuteTaskSyncInternal(r1, r2);     // Catch: Throwable -> L11
        monitor-exit(EngineThreadPool.class);     // Catch: Throwable -> L11
        return r3;
    L11:
        th = move-exception;
        throw th;
    }

    private static Future addExecuteTaskSyncInternal(Runnable r2, long r3) {
        TTVideoEngineInternalLog.i(TAG, "addExecuteTaskSync timeout:" + r3);
        Future r4 = addExecuteTaskInternal(r2);
        if (r4 != null) goto L8;
    L7:
        return r4;
    L8:
        r4.get(r3, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L6
    L6:
        TTVideoEngineInternalLog.e(TAG, "set surface time out");
        goto L7
    }
}
