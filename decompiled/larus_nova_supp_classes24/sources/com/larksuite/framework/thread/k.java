package com.larksuite.framework.thread;

import android.os.Debug;
import android.os.SystemClock;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import io.reactivex.internal.schedulers.ExecutorScheduler;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class k implements Runnable, Comparable {
    public final t a;
    public final Runnable b;
    public long c;
    public long d;
    public long e;
    public long f;
    public long g;

    public final void a() {
        Runnable r0 = this.b;
        if ((r0 instanceof ExecutorScheduler.ExecutorWorker) == false) goto L5;
        r0.run();
        return;
    L5:
        long r1 = Debug.threadCpuTimeNanos();
        this.d = SystemClock.uptimeMillis();
        t r4 = this.a;     // Catch: Throwable -> L13 Exception -> L15
        if (r4 == null) goto L9;
        r4.b(this.b.getClass().toString(), hashCode());     // Catch: Throwable -> L13 Exception -> L15
    L9:
        this.b.run();     // Catch: Throwable -> L13 Exception -> L15
        t r5 = this.a;
        if (r5 != null) goto L19;
    L20:
        this.e = this.d - this.c;
        this.f = SystemClock.uptimeMillis() - this.d;
        this.g = (Debug.threadCpuTimeNanos() - r1) / 1000000;
        this.c = SystemClock.uptimeMillis();
        m.a(this.e, this.f, this.b.getClass().toString(), this.a);
        return;
    L19:
        r5.c(this.b.getClass().toString(), hashCode());
        goto L20
    L15:
        e = move-exception;
        Log.e(e.getMessage(), e);     // Catch: Throwable -> L13
        r5 = this.a;
        if (r5 == null) goto L20;
    L13:
        th = move-exception;
        t r6 = this.a;
        if (r6 == null) goto L25;
        r6.c(this.b.getClass().toString(), hashCode());
    L25:
        this.e = this.d - this.c;
        this.f = SystemClock.uptimeMillis() - this.d;
        this.g = (Debug.threadCpuTimeNanos() - r1) / 1000000;
        this.c = SystemClock.uptimeMillis();
        m.a(this.e, this.f, this.b.getClass().toString(), this.a);
        throw th;
    }

    public final int hashCode() {
        return this.b.hashCode();
    }

    @Override // java.lang.Runnable
    public void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object r3) {
        Runnable r0 = this.b;
        if ((r0 instanceof Comparable) == true) goto L5;
        return -1;
    L5:
        if ((r3 instanceof k) == true) goto L7;
        return -1;
    L7:
        return ((Comparable) r0).compareTo(((k) r3).b);
    }

    public final boolean equals(Object r2) {
        if ((r2 instanceof k) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.b.equals(((k) r2).b) == false) goto L7;
        return true;
    }

    public k(Runnable r3, t r4) {
        this.d = 0;
        this.c = SystemClock.uptimeMillis();
        this.a = r4;
        this.b = r3;
    }
}
