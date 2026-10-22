package com.facebook.imagepipeline.producers;

import java.util.ArrayDeque;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes2.dex */
public class ThreadHandoffProducerQueueImpl implements ThreadHandoffProducerQueue {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayDeque f8398a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ExecutorService f8399b;

    public ThreadHandoffProducerQueueImpl(ExecutorService r5) {
        r5.getClass();
        this.f8399b = r5;
        this.f8398a = new ArrayDeque();
    }

    public final synchronized void a(Runnable r5) {
        monitor-enter(this);
        this.f8399b.execute(r5);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void b(Runnable r5) {
        monitor-enter(this);
        this.f8398a.remove(r5);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
