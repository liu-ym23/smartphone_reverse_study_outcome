package com.larksuite.framework.thread;

import android.os.Debug;
import android.os.SystemClock;
import com.ss.android.lark.log.Log;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class c<V> implements Callable<V>, Comparable {
    public final t a;
    public final Callable<V> b;
    public final long c;
    public long d;
    public long e;

    public final int hashCode() {
        return this.b.hashCode();
    }

    @Override // java.util.concurrent.Callable
    public V call() throws Exception {
        this.d = SystemClock.uptimeMillis();
        long r0 = Debug.threadCpuTimeNanos();
        if (CoreThreadPool.sAppFront == true) goto L12;
        Log.i("CoreThreadPool CoreCallableTask", this.b.getClass() + " background executor");
    L12:
        this.a.b(this.b.getClass().toString(), hashCode());     // Catch: Throwable -> L9
        V r4 = this.b.call();     // Catch: Throwable -> L9
        this.a.c(this.b.getClass().toString(), hashCode());
        this.e = SystemClock.uptimeMillis();
        long r5 = (Debug.threadCpuTimeNanos() - r0) / 1000000;
        long r1 = this.d;
        m.a(r1 - this.c, this.e - r1, this.b.getClass().toString(), this.a);
        return r4;
    L9:
        th = move-exception;
        this.a.c(this.b.getClass().toString(), hashCode());
        this.e = SystemClock.uptimeMillis();
        long r6 = (Debug.threadCpuTimeNanos() - r0) / 1000000;
        long r2 = this.d;
        m.a(r2 - this.c, this.e - r2, this.b.getClass().toString(), this.a);
        throw th;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object r3) {
        Callable<V> r0 = this.b;
        if ((r0 instanceof Comparable) == true) goto L5;
        return -1;
    L5:
        if ((r3 instanceof c) == true) goto L7;
        return -1;
    L7:
        return ((Comparable) r0).compareTo(((c) r3).b);
    }

    public final boolean equals(Object r2) {
        if ((r2 instanceof c) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.b.equals(((c) r2).b) == false) goto L7;
        return true;
    }

    public c(Callable<V> r3, t r4) {
        this.d = 0;
        this.e = 0;
        this.c = SystemClock.uptimeMillis();
        this.a = r4;
        this.b = r3;
    }
}
