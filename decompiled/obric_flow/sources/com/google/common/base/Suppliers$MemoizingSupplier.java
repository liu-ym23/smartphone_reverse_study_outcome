package com.google.common.base;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
class Suppliers$MemoizingSupplier<T> implements e0, Serializable {
    private static final long serialVersionUID = 0;
    final e0 delegate;
    volatile transient boolean initialized;
    transient T value;

    public Suppliers$MemoizingSupplier(e0 r5) {
        r5.getClass();
        this.delegate = r5;
    }

    @Override // java.util.function.Supplier
    public T get() {
        if (this.initialized == true) goto L17;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.initialized == true) goto L12;
        T r5 = (T) this.delegate.get();
        this.value = r5;     // Catch: Throwable -> L10
        this.initialized = true;     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        return r5;
    L12:
        monitor-exit(this);     // Catch: Throwable -> L10
    L17:
        return this.value;
    }

    public String toString() {
        if (this.initialized == false) goto L5;
        String r5 = String.valueOf(this.value);
        Object r10 = androidx.room.jarjarred.org.antlr.runtime.a.m(r5.length() + 25, "<supplier that returned ", r5, ">");
    L6:
        String r11 = String.valueOf(r10);
        return androidx.room.jarjarred.org.antlr.runtime.a.m(r11.length() + 19, "Suppliers.memoize(", r11, ")");
    L5:
        r10 = this.delegate;
        goto L6
    }
}
