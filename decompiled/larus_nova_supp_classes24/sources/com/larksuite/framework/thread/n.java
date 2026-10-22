package com.larksuite.framework.thread;

import android.os.Process;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class n implements ThreadFactory {
    public final AtomicInteger a;
    public final String b;
    public final boolean c;
    public final ThreadGroup d;
    public final int e;
    public final ConcurrentLinkedQueue<WeakReference<Thread>> f;
    public long g;

    public static class a implements Runnable {
        public final int a;
        public final Runnable b;

        @Override // java.lang.Runnable
        public final void run() {
            Process.setThreadPriority(this.a);     // Catch: SecurityException -> L5 IllegalArgumentException -> L7 Throwable -> L11
        L9:
            this.b.run();     // Catch: Throwable -> L11
            return;
        L11:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L15;
            return;
        L15:
            throw th;
        L7:
            e = move-exception;
            Log.e("CoreThreadFactory", "AdjustPoolThreadPriority run: ", e);     // Catch: Throwable -> L11
        L5:
            e = move-exception;
            Log.e("CoreThreadFactory", "AdjustPoolThreadPriority run: ", e);     // Catch: Throwable -> L11
            goto L9
        }

        public a(int r1, Runnable r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public final void b() {
        monitor-enter(this);
    L24:
        th = move-exception;
        throw th;
    L5:
        if ((System.currentTimeMillis() - this.g) >= 5000) goto L9;
        Log.w("CoreThreadFactory", "threadpool print stack too frequency! poolname is: " + this.b);     // Catch: Throwable -> L24
        monitor-exit(this);     // Catch: Throwable -> L24
        return;
    L9:
        this.g = System.currentTimeMillis();     // Catch: Throwable -> L24
        monitor-exit(this);     // Catch: Throwable -> L24
        Iterator<WeakReference<Thread>> r0 = this.f.iterator();     // Catch: Throwable -> L21
    L12:
        if (r0.hasNext() == false) goto L37;
        Thread r1 = r0.next().get();     // Catch: Throwable -> L21
        if (r1 == null) goto L19;
        if (ThreadMethodProxy.isAlive(r1) == false) goto L19;
        a(r1);     // Catch: Throwable -> L21
    L19:
        r0.remove();     // Catch: Throwable -> L21
        goto L12
    L37:
        return;
    L21:
        th = move-exception;
        Log.e("CoreThreadFactory", "printThreadFactoryThreads exception", th, true);
    }

    public n(String r2) {
        this(r2, 10);
    }

    public static void a(Thread r8) {
        StackTraceElement[] r0 = r8.getStackTrace();
        Throwable r1 = new Throwable();
        r1.setStackTrace(r0);
        int r2 = r0.length;
        boolean r3 = false;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L8;
        StackTraceElement r5 = r0[r4];
        if ((r5.getClassName() + "." + r5.getMethodName()).contains("java.util.concurrent.ThreadPoolExecutor.getTask") == true) goto L9;
        r4 = r4 + 1;
    L9:
        Log.e("CoreThreadFactory", "thread: " + r8.getName() + ", stackTrace is： ", r1, r3);
        return;
    L8:
        r3 = true;
        goto L9
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable r9) {
        PthreadThreadV2 r0 = new PthreadThreadV2(this.d, new a(this.e, r9), this.b + "-" + this.a.getAndIncrement(), 0);
        r0.setDaemon(this.c);
        this.f.add(new WeakReference(r0));
        return r0;
    }

    public n(String r3, int r4) {
        this.a = new AtomicInteger(1);
        this.f = new ConcurrentLinkedQueue();
        this.g = 0;
        if (r4 >= 19) goto L13;
        if (r4 < (-4)) goto L13;
        this.b = r3;
        this.c = false;
        this.e = r4;
        SecurityManager r5 = System.getSecurityManager();
        if (r5 != null) goto L9;
        ThreadGroup r6 = ThreadMethodProxy.currentThread().getThreadGroup();
    L10:
        this.d = r6;
        return;
    L9:
        r6 = r5.getThreadGroup();
    L13:
        throw new IllegalArgumentException("CoreThreadFactory priority is not illegal! please use android.os.Process define priority!");
    }
}
