package com.google.common.base;

import java.io.Serializable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
class Suppliers$SupplierComposition<F, T> implements e0, Serializable {
    private static final long serialVersionUID = 0;
    final q function;
    final e0 supplier;

    public Suppliers$SupplierComposition(q r5, e0 r10) {
        r5.getClass();
        this.function = r5;
        r10.getClass();
        this.supplier = r10;
    }

    public boolean equals(Object r5) {
        if ((r5 instanceof Suppliers$SupplierComposition) == false) goto L10;
        Suppliers$SupplierComposition r10 = (Suppliers$SupplierComposition) r5;
        if (this.function.equals(r10.function) == true) goto L7;
        return false;
    L7:
        if (this.supplier.equals(r10.supplier) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.function.Supplier
    public T get() {
        return (T) this.function.apply(this.supplier.get());
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.function, this.supplier});
    }

    public String toString() {
        String r5 = String.valueOf(this.function);
        String r10 = String.valueOf(this.supplier);
        int r11 = r5.length() + 21;
        StringBuilder r12 = new StringBuilder(r10.length() + r11);
        r12.append("Suppliers.compose(");
        r12.append(r5);
        r12.append(", ");
        r12.append(r10);
        r12.append(")");
        return r12.toString();
    }
}
