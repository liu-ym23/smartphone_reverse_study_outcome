package com.larksuite.framework.thread;

import android.os.SystemClock;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class h extends AbstractExecutorService {
    public static final AtomicInteger i = null;
    public final AtomicInteger a;
    public final ArrayDeque<Runnable> b;
    public final ReentrantLock c;
    public final Condition d;
    public volatile Runnable e;
    public volatile ExecutorService f;
    public volatile AtomicInteger g;
    public final String h;

    public class a extends k {
        public final String h;
        public long i;
        public final /* synthetic */ h j;

        public final void b() {
            this.d = SystemClock.uptimeMillis();
            Callable r2 = null;
            String r3 = this.b.getClass().getName();     // Catch: Throwable -> L21 Exception -> L23
            if ((this.b instanceof FutureTask) == false) goto L13;
            if (CoreThreadPool.needMonitorTask() == false) goto L13;
            Callable r4 = (Callable) m.b(this.b);     // Catch: Throwable -> L21 Exception -> L23
            r3 = r4.getClass().getName();     // Catch: Exception -> L10 Throwable -> L31
            r2 = r4;
        L10:
            Exception e = e;
        L25:
            Log.e("CoreThreadPool CoreSerialThreadPool", "SerialRunnable run exception, poolname" + this.h, e);     // Catch: Throwable -> L31
            if (r4 == null) goto L28;
            String r0 = r4.getClass().getName();
        L29:
            c(r0);
            h r1 = this.j;
        L20:
            AtomicInteger r5 = h.i;
            r1.c();
            return;
        L28:
            r0 = this.b.getClass().toString();
        L31:
            th = th;
            r2 = r4;
        L33:
            if (r2 == null) goto L35;
            String r6 = r2.getClass().getName();
        L36:
            c(r6);
            h r7 = this.j;
            AtomicInteger r8 = h.i;
            r7.c();
            throw th;
        L35:
            r6 = this.b.getClass().toString();
        L13:
            if (CoreThreadPool.sAppFront == true) goto L15;
            Log.i("CoreThreadPool CoreSerialThreadPool", r3 + " background executor, serial poolname is " + this.h);     // Catch: Throwable -> L21 Exception -> L23
        L15:
            this.b.run();     // Catch: Throwable -> L21 Exception -> L23
            if (r2 == null) goto L18;
            String r9 = r2.getClass().getName();
        L19:
            c(r9);
            r1 = this.j;
            goto L20
        L18:
            r9 = this.b.getClass().toString();
            goto L19
        L23:
            e = move-exception;
            r4 = r2;
            e = e;
        L21:
            th = th;
            goto L33
        }

        @Override // com.larksuite.framework.thread.k, java.lang.Runnable
        public final void run() {
            b();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void c(String r29) {
            long r1 = this.i;
            long r12 = r1 - this.c;
            long r14 = this.d - r1;
            long r9 = SystemClock.uptimeMillis() - this.d;
            Log.d("CoreThreadPool CoreSerialThreadPool", this.h + ", " + r29 + ", serialqueuetime& dispatchtime & runtime is(ms) " + r12 + ", " + r14 + ", " + r9);
            if (CoreThreadPool.needMonitorTask() == true) goto L6;
            return;
        L6:
            if ((this.j.f instanceof i) == true) goto L8;
            return;
        L8:
            if (((i) this.j.f).j >= r12) goto L10;
            boolean r2 = true;
        L12:
            if (((i) this.j.f).h >= r14) goto L15;
            r2 = true;
        L15:
            if (((i) this.j.f).i >= r9) goto L17;
            boolean r3 = true;
        L18:
            if (r3 == false) goto L41;
            long r4 = ((i) this.j.f).j;
            long r5 = ((i) this.j.f).h;
            long r11 = ((i) this.j.f).i;
            JSONObject r6 = l.a(r29, this.h, r14, r9, r5, r11);
            r6.put("serialqueuewaittime", r12);     // Catch: Exception -> L35
            long r7 = r4;
            r6.put("maxserialqueuewaittime", r7);     // Catch: Exception -> L34
        L29:
            CoreThreadPool.a r8 = CoreThreadPool.mCoreThreadPoolDep;
            if (r8 == null) goto L32;
            r8.b();
        L32:
            Log.i("CoreThreadPool CoreSerialThreadPool", this.h + ", " + r29 + ", serialqueuetime& dispatchtime & runtime is(ms) " + r12 + ", " + r14 + ", " + r9 + ", limit is " + r7 + ", " + r5 + ", " + r11);
            return;
        L28:
            Log.e("CoreTaskMonitor", "genSerialTaskEvent gen json failed");
        L26:
            r7 = r4;
            goto L28
        L41:
            return;
        L17:
            r3 = r2;
            goto L18
        L10:
            r2 = false;
            goto L12
        }

        public a(h r1, Runnable r2, ExecutorService r3, String r4) {
            this.j = r1;
            if ((r3 instanceof t) == false) goto L5;
            t r5 = (t) r3;
        L6:
            super(r2, r5);
            this.h = r4;
            return;
        L5:
            r5 = null;
            goto L6
        }
    }

    static {
        i = new AtomicInteger(0);
    }

    public final void a() {
        if ((this.f instanceof i) == false) goto L6;
        ((i) this.f).h(false);
        return;
    }

    public final List<Runnable> b() {
        this.c.lock();
        Log.i("CoreThreadPool CoreSerialThreadPool", "drainQueue: remove all undo task!");
        ArrayDeque<Runnable> r2 = this.b;     // Catch: Throwable -> L16 Exception -> L18
        ArrayList r3 = new ArrayList();     // Catch: Throwable -> L16 Exception -> L18
    L14:
        Exception e = e;
    L20:
        Log.e("CoreThreadPool CoreSerialThreadPool", "drainQueue: ", e);     // Catch: Throwable -> L16
    L21:
        this.c.unlock();
        return r3;
    L5:
        if (r2.isEmpty() == true) goto L21;
        Iterator<Runnable> r0 = r2.iterator();     // Catch: Exception -> L14 Throwable -> L16
    L8:
        if (r0.hasNext() == false) goto L12;
        Runnable r4 = r0.next();     // Catch: Exception -> L14 Throwable -> L16
        if (r2.remove(r4) == false) goto L8;
        r3.add(r4);     // Catch: Exception -> L14 Throwable -> L16
        goto L8
    L12:
        this.d.signalAll();     // Catch: Exception -> L14 Throwable -> L16
    L18:
        e = move-exception;
        r3 = null;
        e = e;
    L16:
        th = move-exception;
        this.c.unlock();
        throw th;
    }

    public final void c() {
        this.c.lock();
        Runnable r3 = this.b.poll();     // Catch: Exception -> L8 Throwable -> L15
        this.e = r3;     // Catch: Exception -> L8 Throwable -> L15
        if (r3 == null) goto L12;
        if ((this.e instanceof a) == false) goto L10;
        a r4 = (a) this.e;     // Catch: Exception -> L8 Throwable -> L15
        r4.getClass();     // Catch: Exception -> L8 Throwable -> L15
        r4.i = SystemClock.uptimeMillis();     // Catch: Exception -> L8 Throwable -> L15
    L10:
        this.f.execute(this.e);     // Catch: Exception -> L8 Throwable -> L15
        Log.i("CoreThreadPool CoreSerialThreadPool", "scheduleNext: poolname" + this.h);     // Catch: Exception -> L8 Throwable -> L15
    L14:
        this.c.unlock();
        return;
    L12:
        if (this.a.get() != 0) goto L14;
        Log.i("CoreThreadPool CoreSerialThreadPool", "scheduleNext: found Lark Serial ThreadPool shutdown");     // Catch: Exception -> L8 Throwable -> L15
        this.a.getAndIncrement();     // Catch: Exception -> L8 Throwable -> L15
        this.d.signalAll();     // Catch: Exception -> L8 Throwable -> L15
        a();     // Catch: Exception -> L8 Throwable -> L15
    L8:
        e = move-exception;
        Log.e("CoreThreadPool CoreSerialThreadPool", "scheduleNext exception, poolname" + this.h, e);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        this.c.unlock();
        throw th;
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean isShutdown() {
        if (this.a.get() <= (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean isTerminated() {
        if (this.a.get() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // java.util.concurrent.ExecutorService
    public final void shutdown() {
        this.c.lock();
    L17:
        th = move-exception;
        this.c.unlock();
        if (this.a.get() != 1) goto L21;
        a();
    L21:
        throw th;
    L5:
        if (this.a.get() == (-1)) goto L10;
        this.c.unlock();
        if (this.a.get() != 1) goto L24;
        a();
        return;
    L24:
        return;
    L10:
        this.a.getAndIncrement();     // Catch: Throwable -> L17
        if (this.b.size() != 0) goto L13;
        this.a.getAndIncrement();     // Catch: Throwable -> L17
    L13:
        this.c.unlock();
        if (this.a.get() != 1) goto L25;
        a();
        return;
    }

    @Override // java.util.concurrent.ExecutorService
    public final List<Runnable> shutdownNow() {
        this.c.lock();
        int r0 = this.a.get();     // Catch: Throwable -> L13
        if (r0 != (-1)) goto L6;
        this.a.compareAndSet(r0, 1);     // Catch: Throwable -> L13
    L8:
        List<Runnable> r1 = b();     // Catch: Throwable -> L13
    L9:
        this.c.unlock();
        a();
        return r1;
    L6:
        if (r0 != 0) goto L11;
        this.a.getAndIncrement();     // Catch: Throwable -> L13
        goto L8
    L11:
        r1 = Collections.emptyList();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        this.c.unlock();
        a();
        throw th;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable r9) {
        this.c.lock();
    L17:
        e = move-exception;
        Log.e("CoreThreadPool CoreSerialThreadPool", "execute exception, poolname" + this.h, e);     // Catch: Throwable -> L15
        this.c.unlock();
        StringBuilder r10 = new StringBuilder("add task: poolname");
    L20:
        r10.append(this.h);
        r10.append(", task size: ");
        r10.append(this.b.size());
        Log.i("CoreThreadPool CoreSerialThreadPool", r10.toString());
        return;
    L4:
        if (this.a.get() == (-1)) goto L8;
        Log.w("CoreThreadPool CoreSerialThreadPool", "execute: found SerialThreadPool already shutdown!");     // Catch: Throwable -> L15 Exception -> L17
        this.c.unlock();
        Log.i("CoreThreadPool CoreSerialThreadPool", "add task: poolname" + this.h + ", task size: " + this.b.size());
        return;
    L8:
        this.b.offer(new a(this, r9, this.f, this.h));     // Catch: Throwable -> L15 Exception -> L17
        if (this.b.size() <= this.g.get()) goto L12;
        this.g.set(this.b.size());     // Catch: Throwable -> L15 Exception -> L17
    L12:
        if (this.e != null) goto L14;
        c();     // Catch: Throwable -> L15 Exception -> L17
    L14:
        this.c.unlock();
        r10 = new StringBuilder("add task: poolname");
    L15:
        th = move-exception;
        this.c.unlock();
        Log.i("CoreThreadPool CoreSerialThreadPool", "add task: poolname" + this.h + ", task size: " + this.b.size());
        throw th;
    }

    public h(String r7, int r8) {
        this.a = new AtomicInteger(-1);
        this.b = new ArrayDeque();
        ReentrantLock r0 = new ReentrantLock();
        this.c = r0;
        this.d = r0.newCondition();
        this.e = null;
        this.f = null;
        this.g = new AtomicInteger(0);
        if (r8 != 2) goto L7;
        this.h = r7 + "_IO_" + Integer.valueOf(i.incrementAndGet()).toString();
        this.f = CoreThreadPool.getDefault().getCachedThreadPool();
        return;
    L7:
        if (r8 != 1) goto L10;
        this.h = r7 + "_CPU_" + Integer.valueOf(i.incrementAndGet()).toString();
        this.f = CoreThreadPool.getDefault().getFixedThreadPool();
        return;
    L10:
        if (r8 != 0) goto L28;
        this.h = r7 + "_HIGH_" + Integer.valueOf(i.incrementAndGet()).toString();
        PThreadPoolExecutor r9 = i.m;
        if (r9 == null) goto L15;
    L22:
        this.f = r9;
        ((i) this.f).h(true);
        return;
    L15:
        monitor-enter(i.class);
    L24:
        th = move-exception;
        throw th;
    L17:
        if (i.m != null) goto L19;
        i.m = new i(r7, new LinkedBlockingDeque(128), new n("lk-serial", 0));     // Catch: Throwable -> L24
    L19:
        i r10 = i.m;     // Catch: Throwable -> L24
        r10.h = 300;     // Catch: Throwable -> L24
        r10.i = 500;     // Catch: Throwable -> L24
        r10.j = 400;     // Catch: Throwable -> L24
        monitor-exit(i.class);     // Catch: Throwable -> L24
        r9 = r10;
        goto L22
    L28:
        throw new IllegalArgumentException("Create CoreSerialThreadPool param: serialType illegal!");
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean awaitTermination(long r3, TimeUnit r5) throws InterruptedException {
        long r4 = r5.toNanos(r3);
        this.c.lock();
    L17:
    L14:
        th = move-exception;
        this.c.unlock();
        throw th;
    L5:
        if (this.a.get() == 1) goto L12;
        if (r4 <= 0) goto L8;
        r4 = this.d.awaitNanos(r4);     // Catch: Throwable -> L14
        goto L17
    L8:
        this.c.unlock();
        return false;
    L12:
        this.c.unlock();
        return true;
    }
}
