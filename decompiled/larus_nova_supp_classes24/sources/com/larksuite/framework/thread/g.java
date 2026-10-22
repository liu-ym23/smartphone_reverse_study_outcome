package com.larksuite.framework.thread;

import android.text.TextUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadScheduledThreadPoolExecutor;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class g extends PThreadScheduledThreadPoolExecutor implements t {
    public final String a;
    public long b;
    public final List<a0> c;

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

    @Override // com.larksuite.framework.thread.t
    public final String d() {
        return this.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <V> Future<V> submit(Callable<V> r3) {
        return new x(super/*java.util.concurrent.ScheduledThreadPoolExecutor*/.submit(new e(new c(r3, this), r3)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Future<?> submit(Runnable r4) {
        return new x(super/*java.util.concurrent.ScheduledThreadPoolExecutor*/.submit(e(r4, null, -1), null));
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
    public final <V> Future<V> submit(Runnable r4, V r5) {
        return new x(super/*java.util.concurrent.ScheduledThreadPoolExecutor*/.submit(e(r4, null, -1), r5));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g(String r2, int r3, n r4) {
        super(r3, r4);
        this.b = 5000;
        this.c = new LinkedList();
        this.a = r2 + "-ScheduleExecutor";
        this.b = 5000;
        setRejectedExecutionHandler(p.f);
    }

    public final qqb.b e(Runnable r1, TimeUnit r2, long r3) {
        if (r2 != null) goto L4;
        k r4 = new k(r1, this);
    L6:
        return qqb.c.a(new f(r4, r1));
    L4:
        r4 = new o28.a(r1, this);
        goto L6
    }

    public final <V> ScheduledFuture<V> schedule(Callable<V> r3, long r4, TimeUnit r6) {
        return new y(super.schedule(new e(new c(r3, this), r3), r4, r6));
    }

    public final ScheduledFuture<?> schedule(Runnable r1, long r2, TimeUnit r4) {
        return new y(super.schedule(e(r1, r4, r2), r2, r4));
    }

    public final ScheduledFuture<?> scheduleAtFixedRate(Runnable r8, long r9, long r11, TimeUnit r13) {
        return new y(super.scheduleAtFixedRate(e(r8, r13, r11), r9, r11, r13));
    }

    public final ScheduledFuture<?> scheduleWithFixedDelay(Runnable r8, long r9, long r11, TimeUnit r13) {
        return new y(super.scheduleWithFixedDelay(e(r8, r13, r11), r9, r11, r13));
    }
}
