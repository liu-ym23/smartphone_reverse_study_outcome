package com.bytedance.android.live.revenuelink.multimsg.api;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.live.kmp.statemachine.StateMachine;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f {
    public final ReentrantLock a;
    public final AtomicReference<a> b;
    public final ConcurrentLinkedQueue<a> c;
    public final ExecutorService d;

    public static final class a implements Runnable {
        public Future<?> a;
        public final com.bytedance.android.live.revenuelink.multimsg.api.a<?, ?> b;
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

        public a(com.bytedance.android.live.revenuelink.multimsg.api.a r2, g.b r3) {
            Intrinsics.checkNotNullParameter(r2, "task");
            Intrinsics.checkNotNullParameter(r3, "taskExecute");
            this.b = r2;
            this.c = r3;
        }
    }

    public f(ExecutorService r2) {
        Intrinsics.checkNotNullParameter(r2, "executor");
        this.d = r2;
        this.a = new ReentrantLock();
        this.b = new AtomicReference();
        this.c = new ConcurrentLinkedQueue();
    }

    public static final void a(f r3, a r4) {
        r3.a.lock();
        if (r4 != null) goto L23;
    L5:
        a r0 = r3.c.poll();     // Catch: Exception -> L9 Throwable -> L16
        if (r0 == null) goto L18;
        r3.b.getAndSet(r0);     // Catch: Exception -> L9 Throwable -> L16
        r0.a = r3.d.submit(r0);     // Catch: Exception -> L9 Throwable -> L16
    L9:
        e = move-exception;
        ALogger.e("MsgTaskScheduler", "", e);     // Catch: Throwable -> L16
        if (r4 == null) goto L18;
        com.bytedance.android.live.revenuelink.multimsg.api.a<?, ?> r5 = r4.b;     // Catch: Throwable -> L16
        if (r5 == null) goto L18;
        TaskState<?, ?, com.bytedance.android.live.revenuelink.multimsg.api.a<?, ?>> r6 = r5.a;     // Catch: Throwable -> L16
        int r1 = e.a;     // Catch: Throwable -> L16
        Exception r2 = new Exception("Task cancel");     // Catch: Throwable -> L16
        Intrinsics.checkNotNullParameter(r2, "ex");     // Catch: Throwable -> L16
        e.b r7 = new e.b(r2);     // Catch: Throwable -> L16
        r6.getClass();     // Catch: Throwable -> L16
        Intrinsics.checkNotNullParameter(r7, "result");     // Catch: Throwable -> L16
        StateMachine.c(r6.d, new TaskState.a.C0113a(r7));     // Catch: Throwable -> L16
    L18:
        r3.a.unlock();
        return;
    L23:
        r3.c.offer(r4);     // Catch: Exception -> L9 Throwable -> L16
    L16:
        th = move-exception;
        r3.a.unlock();
        throw th;
    }
}
