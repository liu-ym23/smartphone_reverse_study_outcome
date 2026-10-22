package com.google.common.util.concurrent;

import java.io.Closeable;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
final class ClosingFuture$CloseableList extends IdentityHashMap<AutoCloseable, Executor> implements Closeable {
    private volatile boolean closed;
    private final d0 closer;
    private volatile CountDownLatch whenClosed;

    private ClosingFuture$CloseableList() {
        this.closer = new d0();
    }

    public static /* synthetic */ d0 access$300(ClosingFuture$CloseableList r5) {
        return r5.closer;
    }

    public void add(AutoCloseable r5, Executor r10) {
        r10.getClass();
        if (r5 != null) goto L5;
        return;
    L5:
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (this.closed == true) goto L13;
        put(r5, r10);     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
        return;
    L13:
        monitor-exit(this);     // Catch: Throwable -> L11
        e0.a(r5, r10);
    }

    public <V, U> o0 applyAsyncClosingFunction(b0 r5, V r10) throws Exception {
        ClosingFuture$CloseableList r11 = new ClosingFuture$CloseableList();
        r5.apply();     // Catch: Throwable -> L5
        Logger r12 = e0.f9411a;     // Catch: Throwable -> L5
        throw null;     // Catch: Throwable -> L5
    L5:
        th = move-exception;
        add(r11, DirectExecutor.INSTANCE);
        throw th;
    }

    public <V, U> w0 applyClosingFunction(c0 r5, V r10) throws Exception {
        ClosingFuture$CloseableList r11 = new ClosingFuture$CloseableList();
        Object r12 = r5.apply();     // Catch: Throwable -> L10
        if (r12 != null) goto L7;
        u0 r13 = u0.f9438b;     // Catch: Throwable -> L10
    L8:
        add(r11, DirectExecutor.INSTANCE);
        return r13;
    L7:
        r13 = new u0(r12);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        add(r11, DirectExecutor.INSTANCE);
        throw th;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.closed == false) goto L5;
        return;
    L5:
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L7:
        if (this.closed == false) goto L12;
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L12:
        this.closed = true;     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        Iterator<Map.Entry<AutoCloseable, Executor>> r5 = entrySet().iterator();
    L16:
        if (r5.hasNext() == false) goto L18;
        Map.Entry<AutoCloseable, Executor> r10 = r5.next();
        e0.a(r10.getKey(), r10.getValue());
        goto L16
    L18:
        clear();
        if (this.whenClosed == null) goto L26;
        this.whenClosed.countDown();
        return;
    }

    public CountDownLatch whenClosedCountDown() {
        boolean r5 = false;
        if (this.closed == true) goto L5;
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L8:
        if (this.closed == false) goto L15;
        CountDownLatch r10 = new CountDownLatch(0);     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L12
        return r10;
    L15:
        if (this.whenClosed != null) goto L17;
        r5 = true;
    L17:
        com.google.common.base.b0.t(r5);     // Catch: Throwable -> L12
        CountDownLatch r11 = new CountDownLatch(1);     // Catch: Throwable -> L12
        this.whenClosed = r11;     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L12
        return r11;
    L5:
        return new CountDownLatch(0);
    }

    public /* synthetic */ ClosingFuture$CloseableList(a0 r5) {
        this();
    }
}
