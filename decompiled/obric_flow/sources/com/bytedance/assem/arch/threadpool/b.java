package com.bytedance.assem.arch.threadpool;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements Executor {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f3941c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedBlockingQueue f3942a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Runnable f3943b;

    static {
        f3941c = LazyKt.lazy(LazyThreadSafetyMode.NONE, SerialExecutor$Companion$WORKER$2.f3938a);
    }

    public b() {
        this.f3942a = new LinkedBlockingQueue();
    }

    public final synchronized void a() {
        monitor-enter(this);
        Runnable r5 = (Runnable) this.f3942a.poll();     // Catch: Throwable -> L6
        if (r5 == null) goto L8;
        ((ExecutorService) f3941c.getValue()).execute(r5);     // Catch: Throwable -> L6
    L9:
        this.f3943b = r5;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L8:
        r5 = null;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.util.concurrent.Executor
    public final synchronized void execute(Runnable r5) {
        monitor-enter(this);
        this.f3942a.offer(new ab.b(5, this, r5));     // Catch: Throwable -> L8
        if (this.f3943b != null) goto L10;
        a();     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L10:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
