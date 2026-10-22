package com.bytedance.lark.lark_biz_feed_android;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public abstract class v0 implements AutoCloseable {
    public final long a;
    public final AtomicBoolean b;
    public final AtomicLong c;

    public abstract void a();

    @Override // java.lang.AutoCloseable
    public final synchronized void close() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.b.compareAndSet(false, true) == true) goto L6;
    L11:
        monitor-exit(this);
        return;
    L6:
        if (this.c.decrementAndGet() != 0) goto L11;
        a();     // Catch: Throwable -> L9
        goto L11
    }

    public v0(long r3) {
        this.a = r3;
        this.b = new AtomicBoolean(false);
        this.c = new AtomicLong(1);
    }
}
