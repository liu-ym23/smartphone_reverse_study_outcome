package com.google.common.base;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
class Functions$ConstantFunction<E> implements q, Serializable {
    private static final long serialVersionUID = 0;
    private final E value;

    public Functions$ConstantFunction(E r5) {
        this.value = r5;
    }

    @Override // java.util.function.Function
    public E apply(Object r5) {
        return this.value;
    }

    @Override // com.google.common.base.q
    public boolean equals(Object r5) {
        if ((r5 instanceof Functions$ConstantFunction) == true) goto L5;
        return false;
    L5:
        return b0.w(this.value, ((Functions$ConstantFunction) r5).value);
    }

    public int hashCode() {
        E r5 = this.value;
        if (r5 != null) goto L6;
        return 0;
    L6:
        return r5.hashCode();
    }

    public String toString() {
        String r5 = String.valueOf(this.value);
        return androidx.room.jarjarred.org.antlr.runtime.a.m(r5.length() + 20, "Functions.constant(", r5, ")");
    }
}
