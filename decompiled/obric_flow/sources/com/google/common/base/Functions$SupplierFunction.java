package com.google.common.base;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
class Functions$SupplierFunction<F, T> implements q, Serializable {
    private static final long serialVersionUID = 0;
    private final e0 supplier;

    public Functions$SupplierFunction(e0 r5, r r10) {
        r5.getClass();
        this.supplier = r5;
    }

    @Override // java.util.function.Function
    public T apply(F r5) {
        return (T) this.supplier.get();
    }

    @Override // com.google.common.base.q
    public boolean equals(Object r5) {
        if ((r5 instanceof Functions$SupplierFunction) == true) goto L5;
        return false;
    L5:
        return this.supplier.equals(((Functions$SupplierFunction) r5).supplier);
    }

    public int hashCode() {
        return this.supplier.hashCode();
    }

    public String toString() {
        String r5 = String.valueOf(this.supplier);
        return androidx.room.jarjarred.org.antlr.runtime.a.m(r5.length() + 23, "Functions.forSupplier(", r5, ")");
    }
}
