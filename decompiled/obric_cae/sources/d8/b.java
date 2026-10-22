package d8;

import android.util.Pair;
import c8.g;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class b extends ScheduledThreadPoolExecutor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f6957a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f6958b;

    public b(a r8) {
        super(1, r8);
        this.f6957a = new ConcurrentHashMap();
        this.f6958b = new ConcurrentHashMap();
    }

    public final void a(g r8) {
        super.submit(r8);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public final void afterExecute(Runnable r8, Throwable r10) {
        super.afterExecute(r8, r10);
        if ((r8 instanceof ScheduledFuture) == false) goto L15;
        ScheduledFuture r11 = (ScheduledFuture) r8;
        Pair r12 = (Pair) this.f6958b.get(r11);
        if (r12 == null) goto L16;
        Object r13 = r12.first;
        if (r13 == null) goto L17;
        int r14 = ((Integer) r13).intValue();
        Boolean r15 = (Boolean) r12.second;
        if (r15 != null) goto L11;
        return;
    L11:
        if (r15.booleanValue() == true) goto L19;
        k(Integer.valueOf(r14), r11);
        return;
    L19:
        return;
    L17:
        return;
    L16:
        return;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public final void beforeExecute(Thread r8, Runnable r10) {
        super.beforeExecute(r8, r10);
    }

    public final void i(g r8, long r10) {
        if (r8 != null) goto L4;
        return;
    L4:
        ScheduledFuture<?> r11 = schedule(r8, r10, TimeUnit.MILLISECONDS);
        int r12 = r8.hashCode();
        ConcurrentHashMap r13 = this.f6957a;
        List r14 = (List) r13.get(Integer.valueOf(r12));
        if (r14 != null) goto L7;
        r14 = new CopyOnWriteArrayList();
        r13.put(Integer.valueOf(r12), r14);
    L7:
        r14.add(r11);
        this.f6958b.put(r11, new Pair(Integer.valueOf(r12), Boolean.FALSE));
    }

    public final void k(Integer r8, ScheduledFuture r10) {
        ConcurrentHashMap r11 = this.f6957a;
        List r12 = (List) r11.get(r8);
        if (r12 == null) goto L7;
        r12.remove(r10);
        if (r12.isEmpty() == false) goto L7;
        r11.remove(r8);
    L7:
        this.f6958b.remove(r10);
    }

    public final void n(b3.b.a r8) {
        int r10 = r8.hashCode();
        List r11 = (List) this.f6957a.get(Integer.valueOf(r10));
        if (r11 != null) goto L5;
        return;
    L5:
        if (r11.isEmpty() == true) goto L18;
        Iterator r12 = r11.iterator();
    L8:
        if (r12.hasNext() == false) goto L19;
        ScheduledFuture r13 = (ScheduledFuture) r12.next();
        if (r13.isCancelled() == true) goto L8;
        r13.cancel(true);
        k(Integer.valueOf(r10), r13);
        goto L8
    L19:
        return;
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public final Future<?> submit(Runnable r8) {
        return super.submit(r8);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public final void terminated() {
        super.terminated();
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public final <T> Future<T> submit(Runnable r8, T r10) {
        return super.submit(r8, r10);
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public final <T> Future<T> submit(Callable<T> r8) {
        return super.submit(r8);
    }
}
