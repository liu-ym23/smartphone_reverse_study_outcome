package com.google.common.base;

import java.io.Serializable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
class Suppliers$SupplierOfInstance<T> implements e0, Serializable {
    private static final long serialVersionUID = 0;
    final T instance;

    public Suppliers$SupplierOfInstance(T r5) {
        this.instance = r5;
    }

    public boolean equals(Object r5) {
        if ((r5 instanceof Suppliers$SupplierOfInstance) == true) goto L5;
        return false;
    L5:
        return b0.w(this.instance, ((Suppliers$SupplierOfInstance) r5).instance);
    }

    @Override // java.util.function.Supplier
    public T get() {
        return this.instance;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.instance});
    }

    public String toString() {
        String r5 = String.valueOf(this.instance);
        return androidx.room.jarjarred.org.antlr.runtime.a.m(r5.length() + 22, "Suppliers.ofInstance(", r5, ")");
    }
}
