package com.lynx.tasm.base;

import androidx.core.util.Consumer;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class h<T> implements Runnable {
    public final AtomicBoolean a;
    public final FutureTask<T> b;
    public final Consumer<Exception> c;

    public final T a() {
        return this.b.get();
    L4:
        e = move-exception;
        LLog.e("OnceTask", "Get result from OnceTask failed since: " + e.toString());
        Consumer<Exception> r1 = this.c;
        if (r1 == null) goto L12;
        r1.accept(e);
        return null;
    L12:
        return null;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    L13:
        return;
    L3:
        if (this.a.compareAndSet(false, true) == false) goto L9;
        this.b.run();     // Catch: Throwable -> L6
        return;
    }

    public h(Callable<T> r3, Consumer<Exception> r4) {
        this.a = new AtomicBoolean(false);
        this.c = null;
        this.b = new FutureTask(r3);
        this.c = r4;
    }
}
