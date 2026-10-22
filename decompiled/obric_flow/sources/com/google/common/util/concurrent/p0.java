package com.google.common.util.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes2.dex */
public abstract class p0 {
    public static Executor d() {
        return DirectExecutor.INSTANCE;
    }

    public static Object g(Future r5) {
        com.google.common.base.b0.s("Future was expected to be done: %s", r5.isDone(), r5);
        return h(r5);
    }

    public static Object h(Future r5) {
        boolean r10 = false;
    L12:
        Object r11 = r5.get();     // Catch: Throwable -> L7 InterruptedException -> L11
    L4:
        if (r10 == false) goto L6;
        Thread.currentThread().interrupt();
    L6:
        return r11;
    L11:
        r10 = true;
    L7:
        th = move-exception;
        if (r10 == false) goto L10;
        Thread.currentThread().interrupt();
    L10:
        throw th;
    }

    public static p k(w0 r5, com.google.common.cache.x r10, Executor r11) {
        p r12 = new p();
        r12.f9427h = r5;
        r12.f9428i = r10;
        r11.getClass();
        if (r11 == DirectExecutor.INSTANCE) goto L6;
        r11 = new y0(r11, r12);
    L6:
        r5.addListener(r12, r11);
        return r12;
    }

    public abstract boolean a(o r5, c r10, c r11);

    public abstract boolean b(o r5, Object r10, Object r11);

    public abstract boolean c(o r5, n r10, n r11);

    public abstract c e(o r5);

    public abstract n f(o r5);

    public abstract void i(n r5, n r10);

    public abstract void j(n r5, Thread r10);
}
