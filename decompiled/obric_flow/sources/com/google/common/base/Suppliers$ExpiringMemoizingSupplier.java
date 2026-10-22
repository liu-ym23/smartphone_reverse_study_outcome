package com.google.common.base;

import ai.j0;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
class Suppliers$ExpiringMemoizingSupplier<T> implements e0, Serializable {
    private static final long serialVersionUID = 0;
    final e0 delegate;
    final long durationNanos;
    volatile transient long expirationNanos;
    volatile transient T value;

    public Suppliers$ExpiringMemoizingSupplier(e0 r5, long r10, TimeUnit r11) {
        r5.getClass();
        this.delegate = r5;
        this.durationNanos = r11.toNanos(r10);
        if (r10 <= 0) goto L5;
        boolean r12 = true;
    L6:
        b0.j(r12, "duration (%s %s) must be > 0", r10, r11);
        return;
    L5:
        r12 = false;
        goto L6
    }

    @Override // java.util.function.Supplier
    public T get() {
        long r5 = this.expirationNanos;
        com.bytedance.sdk.xbridge.cn.auth.g r10 = y.f8677a;
        long r11 = System.nanoTime();
        if (r5 != 0) goto L5;
    L6:
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L8:
        if (r5 != this.expirationNanos) goto L17;
        T r12 = (T) this.delegate.get();
        this.value = r12;     // Catch: Throwable -> L15
        long r13 = r11 + this.durationNanos;     // Catch: Throwable -> L15
        if (r13 != 0) goto L12;
        r13 = 1;
    L12:
        this.expirationNanos = r13;     // Catch: Throwable -> L15
        monitor-exit(this);     // Catch: Throwable -> L15
        return r12;
    L17:
        monitor-exit(this);     // Catch: Throwable -> L15
    L19:
        return this.value;
    L5:
        if ((r11 - r5) < 0) goto L19;
        goto L6
    }

    public String toString() {
        String r5 = String.valueOf(this.delegate);
        long r10 = this.durationNanos;
        StringBuilder r11 = new StringBuilder(r5.length() + 62);
        r11.append("Suppliers.memoizeWithExpiration(");
        r11.append(r5);
        r11.append(", ");
        return j0.o(r11, r10, ", NANOS)");
    }
}
