package com.bytedance.map.api.thread;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes2.dex */
public class ThreadManager {
    public static volatile ThreadManager d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExecutorService f6940a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ExecutorService f6941b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Executor f6942c;

    public static class MainThreadExecutor implements Executor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Handler f6943a;

        public MainThreadExecutor() {
            this.f6943a = new Handler(Looper.getMainLooper());
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable r5) {
            this.f6943a.post(r5);
        }
    }

    public ThreadManager(ExecutorService r5, ExecutorService r10, Executor r11) {
        this.f6940a = r5;
        this.f6941b = r10;
        this.f6942c = r11;
    }

    public static ThreadManager a() {
        if (d != null) goto L16;
        monitor-enter(ThreadManager.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (d != null) goto L11;
        d = new ThreadManager(Executors.newFixedThreadPool(3), Executors.newSingleThreadExecutor(), new MainThreadExecutor());     // Catch: Throwable -> L9
    L11:
        monitor-exit(ThreadManager.class);     // Catch: Throwable -> L9
    L16:
        return d;
    }
}
