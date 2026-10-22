package com.bytedance.lark.lark_bitable_android;

import com.sun.jna.Pointer;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class v0 implements AutoCloseable {
    public final Pointer a;
    public final AtomicBoolean b;
    public final AtomicLong c;

    public abstract void b();

    @Override // java.lang.AutoCloseable
    public final synchronized void close() {
        monitor-enter(this);
        a();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final void a() {
        if (this.b.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        if (this.c.decrementAndGet() != 0) goto L9;
        b();
        return;
    }

    public v0(Pointer r10) {
        Intrinsics.checkNotNullParameter(r10, "pointer");
        this.a = r10;
        this.b = new AtomicBoolean(false);
        this.c = new AtomicLong(1);
    }
}
