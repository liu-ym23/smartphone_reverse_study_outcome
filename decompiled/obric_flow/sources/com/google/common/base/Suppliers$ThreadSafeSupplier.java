package com.google.common.base;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
class Suppliers$ThreadSafeSupplier<T> implements e0, Serializable {
    private static final long serialVersionUID = 0;
    final e0 delegate;

    public Suppliers$ThreadSafeSupplier(e0 r5) {
        r5.getClass();
        this.delegate = r5;
    }

    @Override // java.util.function.Supplier
    public T get() {
        e0 r5 = this.delegate;
        monitor-enter(r5);
        T r10 = (T) this.delegate.get();
        monitor-exit(r5);     // Catch: Throwable -> L7
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    public String toString() {
        String r5 = String.valueOf(this.delegate);
        return androidx.room.jarjarred.org.antlr.runtime.a.m(r5.length() + 32, "Suppliers.synchronizedSupplier(", r5, ")");
    }
}
