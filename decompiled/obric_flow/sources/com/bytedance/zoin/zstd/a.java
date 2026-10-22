package com.bytedance.zoin.zstd;

import java.io.Closeable;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements Closeable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f7567b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile int f7568a;

    static {
        f7567b = AtomicIntegerFieldUpdater.newUpdater(a.class, "a");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        monitor-enter(this);
    L7:
        th = move-exception;
        throw th;
    L4:
        if (this.f7568a != (-1)) goto L10;
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L10:
        if (f7567b.compareAndSet(this, 0, -1) == false) goto L14;
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L14:
        throw new IllegalStateException("Attempt to close while in use");     // Catch: Throwable -> L7
    }
}
