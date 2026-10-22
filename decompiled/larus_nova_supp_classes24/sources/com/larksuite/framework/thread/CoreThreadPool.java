package com.larksuite.framework.thread;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.larksuite.component.ui.toast.LKUIToast;
import com.ss.android.lark.log.Log;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.lang.reflect.Field;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.SynchronousQueue;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class CoreThreadPool {
    private static final String ASYNC_TASK_POOLNAME = "lk-asynctask";
    private static final int BACKGROUND_HANDLER_MAX_DELAY_TIME = 2000;
    private static final int BACKGROUND_HANDLER_MAX_RUNTIME = 1000;
    public static final String DEFAULT_CPU_POOLNAME = "lk-cpu";
    public static final String DEFAULT_IO_POOLNAME = "lk-io";
    public static final String DEFAULT_PREFIX = "lk-";
    public static final String DEFAULT_SCHEDULE_POOLNAME = "lk-schedule";
    private static final int NEW_THREAD_HANDLER_MAX_DELAY_TIME = 2000;
    private static final int NEW_THREAD_HANDLER_MAX_RUNTIME = 5000;
    private static final int NON_BLOCKING_HANDLER_MAX_DELAY_TIME = 500;
    private static final int NON_BLOCKING_HANDLER_MAX_RUNTIME = 200;
    private static final int SERIAL_TASK_MAX_DELAY_TIME = 1000;
    private static final int SERIAL_TASK_MAX_RUNTIME = 500;
    static final String TAG = "CoreThreadPool";
    public static long mAppToBackTime = 0;
    public static a mCoreThreadPoolDep = null;
    public static volatile boolean mDuringCoreScene = false;
    public static boolean mIsDebug = false;
    public static volatile boolean sAppFront = true;
    protected static volatile Handler sBackgroundHandler = null;
    protected static HandlerThread sBackgroundHandlerThread = null;
    private static volatile CoreThreadPool sCoreThreadPoolInst = null;
    protected static volatile Handler sHighPriorityHandler = null;
    protected static HandlerThread sHighPriorityHandlerThread = null;
    private static boolean sNeedMonitor = true;
    protected static volatile Handler sNonblockingHandler;
    protected static HandlerThread sNonblockingHandlerThread;
    private p mCacheThreadPool;
    private p mFixedThreadPool;
    private b mSceneDependency;
    private ScheduledExecutorService mScheduleThreadPool;
    private Executor mUIExecutor;

    public interface a {
        boolean a();

        void b();

        Context getContext();
    }

    public interface b {
    }

    public static class c implements Executor {
        public final Handler a;

        public c() {
            this.a = new Handler(Looper.getMainLooper());
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable r3) {
            Runnable r4 = qqb.c.a(r3);
            if (ThreadMethodProxy.currentThread() != ThreadMethodProxy.getLooperThread(Looper.getMainLooper())) goto L5;
            r4.run();
            return;
        L5:
            this.a.post(r4);
        }
    }

    public static Handler getBackgroundHandler() {
        if (sBackgroundHandler != null) goto L15;
        monitor-enter(CoreThreadPool.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sBackgroundHandler != null) goto L9;
        PthreadHandlerThreadV2 r2 = new PthreadHandlerThreadV2("lark_background_sub", 10);     // Catch: Throwable -> L11
        sBackgroundHandlerThread = r2;     // Catch: Throwable -> L11
        ThreadMethodProxy.start(r2);     // Catch: Throwable -> L11
        sBackgroundHandler = new w(sBackgroundHandlerThread.getLooper(), "lark_background_sub");     // Catch: Throwable -> L11
        w r0 = (w) sBackgroundHandler;     // Catch: Throwable -> L11
        r0.a = LKUIToast.DURATION_SHORT;     // Catch: Throwable -> L11
        r0.b = 1000;     // Catch: Throwable -> L11
    L9:
        monitor-exit(CoreThreadPool.class);     // Catch: Throwable -> L11
    L15:
        return sBackgroundHandler;
    }

    public static boolean getCoreThreadPoolServiceSwitch() {
        a r0 = mCoreThreadPoolDep;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.a();
    }

    public static CoreThreadPool getDefault() {
        if (sCoreThreadPoolInst != null) goto L15;
        monitor-enter(CoreThreadPool.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sCoreThreadPoolInst != null) goto L9;
        sCoreThreadPoolInst = new CoreThreadPool();     // Catch: Throwable -> L11
    L9:
        monitor-exit(CoreThreadPool.class);     // Catch: Throwable -> L11
    L15:
        return sCoreThreadPoolInst;
    }

    public static Handler getNonblockingHandler() {
        if (sNonblockingHandler != null) goto L15;
        monitor-enter(CoreThreadPool.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sNonblockingHandler != null) goto L9;
        PthreadHandlerThreadV2 r2 = new PthreadHandlerThreadV2("lark_nonblocking_sub");     // Catch: Throwable -> L11
        sNonblockingHandlerThread = r2;     // Catch: Throwable -> L11
        ThreadMethodProxy.start(r2);     // Catch: Throwable -> L11
        sNonblockingHandler = new w(sNonblockingHandlerThread.getLooper(), "lark_nonblocking_sub");     // Catch: Throwable -> L11
        w r0 = (w) sNonblockingHandler;     // Catch: Throwable -> L11
        r0.a = 500;     // Catch: Throwable -> L11
        r0.b = 200;     // Catch: Throwable -> L11
    L9:
        monitor-exit(CoreThreadPool.class);     // Catch: Throwable -> L11
    L15:
        return sNonblockingHandler;
    }

    public static Handler getSerialTaskHandler() {
        if (sHighPriorityHandler != null) goto L15;
        monitor-enter(CoreThreadPool.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sHighPriorityHandler != null) goto L9;
        PthreadHandlerThreadV2 r2 = new PthreadHandlerThreadV2("lark_sub");     // Catch: Throwable -> L11
        sHighPriorityHandlerThread = r2;     // Catch: Throwable -> L11
        ThreadMethodProxy.start(r2);     // Catch: Throwable -> L11
        sHighPriorityHandler = new w(sHighPriorityHandlerThread.getLooper(), "lark_sub");     // Catch: Throwable -> L11
        w r0 = (w) sHighPriorityHandler;     // Catch: Throwable -> L11
        r0.a = 1000;     // Catch: Throwable -> L11
        r0.b = 500;     // Catch: Throwable -> L11
    L9:
        monitor-exit(CoreThreadPool.class);     // Catch: Throwable -> L11
    L15:
        return sHighPriorityHandler;
    }

    public String getCurScene() {
        com.ss.android.lark.monitor.p r0 = this.mSceneDependency;
        if (r0 != null) goto L7;
        return "";
    L7:
        return r0.a.d();
    }

    private CoreThreadPool() {
        this.mCacheThreadPool = new d(new SynchronousQueue(), new n(DEFAULT_IO_POOLNAME, 1));
        this.mFixedThreadPool = new com.larksuite.framework.thread.b(DEFAULT_CPU_POOLNAME, com.larksuite.framework.thread.b.j, com.larksuite.framework.thread.b.k, new LinkedBlockingDeque(512), new n(DEFAULT_CPU_POOLNAME, 3));
        this.mScheduleThreadPool = new g(DEFAULT_SCHEDULE_POOLNAME, 3, new n(DEFAULT_SCHEDULE_POOLNAME));
        this.mUIExecutor = new c();
    }

    public static boolean needMonitorTask() {
        return sNeedMonitor;
    }

    public ExecutorService getCachedThreadPool() {
        return this.mCacheThreadPool;
    }

    public ExecutorService getFixedThreadPool() {
        return this.mFixedThreadPool;
    }

    public ScheduledExecutorService getScheduleThreadPool() {
        return this.mScheduleThreadPool;
    }

    public Executor getUIExecutor() {
        return this.mUIExecutor;
    }

    public boolean isDuringCoreScene() {
        return mDuringCoreScene;
    }

    public static Handler newThreadHandler(String r1) {
        return newThreadHandler(r1, null);
    }

    private static void reflectAsyncTaskPool(ExecutorService r2) {
        Objects.toString(AsyncTask.THREAD_POOL_EXECUTOR);     // Catch: Throwable -> L4
        Field r0 = AsyncTask.class.getDeclaredField("THREAD_POOL_EXECUTOR");     // Catch: Throwable -> L4
        r0.setAccessible(true);     // Catch: Throwable -> L4
        r0.set(null, r2);     // Catch: Throwable -> L4
        Objects.toString(AsyncTask.THREAD_POOL_EXECUTOR);     // Catch: Throwable -> L4
        return;
    }

    public static void setAppCoreScene(boolean r0) {
        mDuringCoreScene = r0;
    }

    public static void setAppFrontStats(boolean r2) {
        sAppFront = r2;
        if (r2 == false) goto L5;
        mAppToBackTime = 0;
        b0.d();
        return;
    L5:
        mAppToBackTime = System.currentTimeMillis();
        b0.d = 0;
        b0.e = 0;
        monitor-enter(b0.class);
        Log.i("TestThreadPoolDelay", "stopScheduleThreadPoolTest");     // Catch: Throwable -> L12
        ScheduledFuture<?> r0 = b0.c;     // Catch: Throwable -> L12
        if (r0 == null) goto L10;
        r0.cancel(true);     // Catch: Throwable -> L12
        b0.c = null;     // Catch: Throwable -> L12
    L10:
        monitor-exit(b0.class);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public static void setDebug(boolean r0) {
        mIsDebug = r0;
    }

    public static void setDenpency(a r0) {
        mCoreThreadPoolDep = r0;
    }

    public static void setNeedMonitor(boolean r0) {
        sNeedMonitor = r0;
    }

    public ScheduledExecutorService getSingleScheduledThreadPool(String r5) {
        return new j(r5, new n("lk-ssc-" + r5));
    }

    public ExecutorService newSerialCpuDensityThreadPool(String r3) {
        return new h(r3, 1);
    }

    public ExecutorService newSerialHighPriorityThreadPool(String r3) {
        return new h(r3, 0);
    }

    public ExecutorService newSerialIODensityThreadPool(String r3) {
        return new h(r3, 2);
    }

    public void setSceneDependency(b r1) {
        this.mSceneDependency = r1;
    }

    public static Handler newThreadHandler(String r3, Handler.Callback r4) {
        PthreadHandlerThreadV2 r0 = new PthreadHandlerThreadV2("lk_th_" + r3);
        ThreadMethodProxy.start(r0);
        w r5 = new w(r0.getLooper(), r4);
        r5.a = LKUIToast.DURATION_SHORT;
        r5.b = 5000;
        return r5;
    }

    public ExecutorService newCpuThreadPool(String r8, int r9, int r10) {
        return new com.larksuite.framework.thread.b(r8, r9, r10, new LinkedBlockingDeque(512), new n(r8 + "-lk-cpu", 3));
    }
}
