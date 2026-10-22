package com.larksuite.framework.thread;

import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class p extends PThreadPoolExecutor implements t {
    public static w d;
    public static z e;
    public static final b f = null;
    public static volatile Field g;
    public final String a;
    public String b;
    public final List<a0> c;

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class a<T> extends q<T> {
        public final /* synthetic */ Callable a;
        public final /* synthetic */ Callable b;
        public final /* synthetic */ p c;

        @Override // com.larksuite.framework.thread.q, java.util.concurrent.Callable
        public T call() throws Exception {
            return (T) this.a.call();
        L4:
            e = move-exception;
            Log.e("CoreThreadPool", "calltask exception, task name: " + this.b.getClass());
            com.larksuite.framework.thread.a.c().a(e);
            com.larksuite.framework.thread.a.c().getClass();
            System.currentTimeMillis();
            throw e;
        }

        public a(p r1, c r2, Callable r3) {
            this.c = r1;
            this.a = r2;
            this.b = r3;
        }
    }

    public static class b implements RejectedExecutionHandler {
        public b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v4, types: [com.larksuite.framework.thread.p, java.util.concurrent.ThreadPoolExecutor] */
        @Override // java.util.concurrent.RejectedExecutionHandler
        public final void rejectedExecution(Runnable r5, ThreadPoolExecutor r6) {
            if ((r6 instanceof p) == false) goto L13;
            ?? r0 = (p) r6;
            ThreadFactory r1 = r0.getThreadFactory();
            if ((r1 instanceof n) == false) goto L8;
            ((n) r1).b();
        L8:
            if ((r5 instanceof k) == false) goto L10;
            Runnable r2 = ((k) r5).b;
        L11:
            Log.e("CoreThreadPool", m.c(r2) + " be rejected , pool: " + r0.b, new Throwable(), true);
            goto L13
        L10:
            r2 = r5;
        L13:
            if ((r6 instanceof d) == false) goto L15;
            p.e(r5);
            return;
        L15:
            w r7 = p.d;
            if (r7 != null) goto L28;
            if (r7 != null) goto L28;
            monitor-enter(p.class);
        L25:
            th = move-exception;
            throw th;
        L21:
            if (p.d != null) goto L23;
            PthreadHandlerThreadV2 r3 = new PthreadHandlerThreadV2("core-reject");     // Catch: Throwable -> L25
            ThreadMethodProxy.start(r3);     // Catch: Throwable -> L25
            p.d = new w(r3.getLooper(), "core-reject");     // Catch: Throwable -> L25
        L23:
            monitor-exit(p.class);     // Catch: Throwable -> L25
        L28:
            w r8 = p.d;
            if (r8 == null) goto L35;
            r8.post(r5);
            return;
        }
    }

    static {
        f = new b();
    }

    @Override // com.larksuite.framework.thread.t
    public final List<a0> a() {
        List<a0> r0 = this.c;
        monitor-enter(r0);
        LinkedList r1 = new LinkedList(this.c);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public final void g() {
    L20:
        e = move-exception;
        e.printStackTrace();
        return;
    L3:
        if (g == null) goto L5;
    L18:
        g.set(ThreadMethodProxy.currentThread(), null);     // Catch: Exception -> L20
        return;
    L5:
        monitor-enter(p.class);     // Catch: Exception -> L20
    L15:
        th = move-exception;
        throw th;     // Catch: Exception -> L20
    L7:
        if (g == null) goto L9;
    L13:
        monitor-exit(p.class);     // Catch: Throwable -> L15
    L9:
        if (Build.VERSION.SDK_INT < 24) goto L11;
        g = Thread.class.getDeclaredField("threadLocals");     // Catch: Throwable -> L15
    L12:
        g.setAccessible(true);     // Catch: Throwable -> L15
        goto L13
    L11:
        g = Thread.class.getDeclaredField("localValues");     // Catch: Throwable -> L15
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void shutdown() {
        if (this.a.contains(CoreThreadPool.DEFAULT_PREFIX) == false) goto L5;
        return;
    L5:
        super/*java.util.concurrent.ThreadPoolExecutor*/.shutdown();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public List<Runnable> shutdownNow() {
        if (this.a.contains(CoreThreadPool.DEFAULT_PREFIX) == false) goto L7;
        return Collections.emptyList();
    L7:
        return super/*java.util.concurrent.ThreadPoolExecutor*/.shutdownNow();
    }

    @Override // com.larksuite.framework.thread.t
    public final String d() {
        return this.b;
    }

    public static void e(Runnable r6) {
        if (e == null) goto L5;
    L14:
        e.execute(r6);
        return;
    L5:
        monitor-enter(p.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (e != null) goto L9;
        e = new z(new LinkedBlockingDeque(512), new n("lk-reject", 1));     // Catch: Throwable -> L11
    L9:
        monitor-exit(p.class);     // Catch: Throwable -> L11
        goto L14
    }

    public final void execute(Runnable r2) {
        if ((r2 instanceof FutureTask) == false) goto L6;
    L9:
        super.execute(r2);
        return;
    L6:
        if ((r2 instanceof k) == true) goto L9;
        r2 = new k(r2, this);
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Future<?> submit(Runnable r3) {
        return new x(super/*java.util.concurrent.ThreadPoolExecutor*/.submit(new o(this, new k(r3, this), r3), null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> Future<T> submit(Callable<T> r3) {
        return new x(super/*java.util.concurrent.ThreadPoolExecutor*/.submit(new a(this, new c(r3, this), r3)));
    }

    public final void afterExecute(Runnable r1, Throwable r2) {
    L6:
        e = move-exception;
        e.printStackTrace();
        return;
    L3:
        if (Looper.myLooper() == null) goto L11;
        g();     // Catch: Exception -> L6
        return;
    }

    @Override // com.larksuite.framework.thread.t
    public final void b(String r5, int r6) {
        List<a0> r0 = this.c;
        monitor-enter(r0);
        ((LinkedList) this.c).add(new a0(r5 + "#" + r6, ThreadMethodProxy.currentThread(), System.currentTimeMillis()));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.larksuite.framework.thread.t
    public final void c(String r6, int r7) {
        List<a0> r0 = this.c;
        monitor-enter(r0);
        Iterator<a0> r1 = this.c.iterator();     // Catch: Throwable -> L12
    L6:
        if (r1.hasNext() == false) goto L10;
        if (TextUtils.equals(r1.next().a, r6 + "#" + r7) == false) goto L6;
        r1.remove();     // Catch: Throwable -> L12
        goto L6
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> Future<T> submit(Runnable r3, T r4) {
        return new x(super/*java.util.concurrent.ThreadPoolExecutor*/.submit(new o(this, new k(r3, this), r3), r4));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public p(String r9, int r10, int r11, long r12, BlockingQueue<Runnable> r14, n r15) {
        super(r10, r11, r12, TimeUnit.SECONDS, r14, r15);
        this.c = new LinkedList();
        setRejectedExecutionHandler(f);
        this.a = r9;
        this.b = r9 + "-ThreadExecutor";
    }
}
