package com.lynx.debugrouter;

import android.os.Handler;
import android.os.HandlerThread;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class ThreadManager {
    private static volatile ThreadManager sInstance;
    private Handler mHandler;
    private HandlerThread mWorkThread;

    public static ThreadManager getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(ThreadManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new ThreadManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(ThreadManager.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private ThreadManager() {
        PthreadHandlerThreadV2 r0 = new PthreadHandlerThreadV2("DebugRouterThread", 10);
        this.mWorkThread = r0;
        ThreadMethodProxy.start(r0);
        this.mHandler = new Handler(this.mWorkThread.getLooper());
    }

    public void post(Runnable r2) {
        this.mHandler.post(r2);
    }
}
