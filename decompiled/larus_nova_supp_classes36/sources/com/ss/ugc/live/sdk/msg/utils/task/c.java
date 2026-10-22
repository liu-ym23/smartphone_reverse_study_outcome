package com.ss.ugc.live.sdk.msg.utils.task;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.ugc.live.sdk.msg.utils.MainTaskScheduler;
import com.ss.ugc.live.sdk.msg.utils.g;
import com.ss.ugc.live.sdk.msg.utils.j;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c {
    public final ReentrantLock a;
    public final AtomicReference<a> b;
    public final ConcurrentLinkedQueue<a> c;
    public final ExecutorService d;

    public static final class a implements Runnable {
        public Future<?> a;
        public final b<?, ?> b;
        public final Runnable c;

        @Override // java.lang.Runnable
        public final void run() {
            this.c.run();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(b r2, d.b r3) {
            Intrinsics.checkNotNullParameter(r2, "task");
            Intrinsics.checkNotNullParameter(r3, "taskExecute");
            this.b = r2;
            this.c = r3;
        }
    }

    public c(ExecutorService r2) {
        Intrinsics.checkNotNullParameter(r2, "executor");
        this.d = r2;
        this.a = new ReentrantLock();
        this.b = new AtomicReference();
        this.c = new ConcurrentLinkedQueue();
    }

    public static final void a(c r2, a r3) {
        r2.a.lock();
        if (r3 != null) goto L20;
    L5:
        a r0 = r2.c.poll();     // Catch: Throwable -> L9
        if (r0 == null) goto L15;
        r2.b.getAndSet(r0);     // Catch: Throwable -> L9
        r0.a = r2.d.submit(r0);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L17
        if (r3 == null) goto L15;
        b<?, ?> r4 = r3.b;     // Catch: Throwable -> L17
        if (r4 == null) goto L15;
        TaskState<?, ?, b<?, ?>> r5 = r4.a;     // Catch: Throwable -> L17
        int r1 = g.a;     // Catch: Throwable -> L17
        g.b r6 = g.a.a(new Throwable("Task cancel"));     // Catch: Throwable -> L17
        r5.getClass();     // Catch: Throwable -> L17
        Intrinsics.checkNotNullParameter(r6, "result");     // Catch: Throwable -> L17
        r5.d.d(new TaskState.a.C0233a(r6));     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        r2.a.unlock();
        throw th;
    L15:
        r2.a.unlock();
        return;
    L20:
        r2.c.offer(r3);     // Catch: Throwable -> L9
        goto L5
    }

    public final void b(com.ss.ugc.live.sdk.msg.utils.task.a r2, Object r3, j r4) {
        Intrinsics.checkNotNullParameter(r2, "task");
        Intrinsics.checkNotNullParameter(r4, "resultHandler");
        MainTaskScheduler.a(new d(this, r2, r4, r3));
    }
}
