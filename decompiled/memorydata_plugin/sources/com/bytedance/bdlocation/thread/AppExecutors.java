package com.bytedance.bdlocation.thread;

import android.os.Handler;
import android.os.Looper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes.dex */
public class AppExecutors {
    private static volatile AppExecutors instance;
    private final Executor DISK_IO;
    private final ThreadPoolExecutor LBS_LIGHT_LOCATION_EXECUTOR;
    private final Executor MAIN_THREAD;
    private final Executor NETWORK_IO;

    /* JADX INFO: renamed from: com.bytedance.bdlocation.thread.AppExecutors$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class MainThreadExecutor implements Executor {
        private Handler mMainThreadHandler;

        private MainThreadExecutor() {
            this.mMainThreadHandler = new Handler(Looper.getMainLooper());
        }

        /* synthetic */ MainThreadExecutor(AnonymousClass1 r1) {
            this();
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable r3) {
            Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
            this.mMainThreadHandler.post(r4);
        }
    }

    private AppExecutors(Executor r3, Executor r4, Executor r5, ThreadPoolExecutor r6) {
        Executor r7 = (Executor) ZeusTransformUtils.wrapperContextForParams(r3, Executor.class, "com.obric.memorydata.plugin");
        Executor r8 = (Executor) ZeusTransformUtils.wrapperContextForParams(r4, Executor.class, "com.obric.memorydata.plugin");
        Executor r9 = (Executor) ZeusTransformUtils.wrapperContextForParams(r5, Executor.class, "com.obric.memorydata.plugin");
        this.DISK_IO = r7;
        this.NETWORK_IO = r8;
        this.MAIN_THREAD = r9;
        this.LBS_LIGHT_LOCATION_EXECUTOR = r6;
    }

    public static AppExecutors getInstance() {
        if (instance != null) goto L15;
        monitor-enter(AppExecutors.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (instance != null) goto L9;
        instance = new AppExecutors(Executors.newSingleThreadExecutor(), LocationFixedThreadPool.newFixedThreadPool(5), new MainThreadExecutor(null), LocationFixedThreadPool.newFixedThreadPool(3));     // Catch: Throwable -> L11
    L9:
        monitor-exit(AppExecutors.class);     // Catch: Throwable -> L11
    L15:
        return instance;
    }

    public Executor diskIO() {
        return this.DISK_IO;
    }

    public boolean isMainThread() {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) goto L5;
        return true;
    L5:
        return false;
    }

    public ThreadPoolExecutor lbsLightLocationExecutor() {
        return this.LBS_LIGHT_LOCATION_EXECUTOR;
    }

    public Executor mainThread() {
        return this.MAIN_THREAD;
    }

    public Executor networkIO() {
        return this.NETWORK_IO;
    }
}
