package com.bytedance.badger.collect.impl.utils;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.badger.collect.impl.abs.Singleton;
import com.bytedance.badger.collect.impl.model.ExecutorOptions;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public class ExecutorManager {
    private static final int CORE_THREAD = 0;
    private static ExecutorManager instance;
    private static final Singleton<Looper> sDefaultLooper = null;
    private ExecutorService defaultIOExecutor;
    private Looper defaultLooper;
    private ExecutorService defaultNetExecutor;
    private Handler handler;

    private ExecutorManager() {
        int r12 = CORE_THREAD;
        TimeUnit r17 = TimeUnit.SECONDS;
        this.defaultNetExecutor = new PThreadPoolExecutor(2, r12 * 10, 30, r17, new LinkedBlockingQueue(), new DefaultThreadFactory("ExecutorManager"), new ThreadPoolExecutor.DiscardOldestPolicy());
        this.defaultIOExecutor = new PThreadPoolExecutor(2, r12 * 10, 30, r17, new LinkedBlockingQueue(), new DefaultThreadFactory("ExecutorManager"), new ThreadPoolExecutor.DiscardOldestPolicy());
    }

    public static ExecutorManager getInstance() {
        if (instance != null) goto L15;
        monitor-enter(ExecutorManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (instance != null) goto L9;
        instance = new ExecutorManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(ExecutorManager.class);     // Catch: Throwable -> L11
    L15:
        return instance;
    }

    public Handler getHandler() {
        if (this.handler != null) goto L6;
        this.handler = new Handler(sDefaultLooper.get(new Object[0]));
    L6:
        return this.handler;
    }

    public Looper getLooper() {
        Looper r0 = this.defaultLooper;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return sDefaultLooper.get(new Object[0]);
    }

    static {
        CORE_THREAD = Runtime.getRuntime().availableProcessors();
        sDefaultLooper = new AnonymousClass1();
    }

    public ExecutorService getDefaultIOExecutor() {
        return this.defaultIOExecutor;
    }

    public ExecutorService getDefaultNetExecutor() {
        return this.defaultNetExecutor;
    }

    public void runOnIOExecutor(Runnable r2) {
        this.defaultIOExecutor.execute(r2);
    }

    public void runOnNetExecutor(Runnable r2) {
        this.defaultNetExecutor.execute(r2);
    }

    public void setExecutorOptions(ExecutorOptions r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        ExecutorService r0 = r2.ioExecutor;
        if (r0 == null) goto L7;
        this.defaultIOExecutor = r0;
    L7:
        ExecutorService r1 = r2.networkExecutor;
        if (r1 == null) goto L10;
        this.defaultNetExecutor = r1;
    L10:
        Looper r3 = r2.looper;
        if (r3 == null) goto L14;
        this.defaultLooper = r3;
        return;
    }

    public <T> Future<T> submitToIOExecutor(Callable<T> r2) {
        return this.defaultIOExecutor.submit(r2);
    }
}
