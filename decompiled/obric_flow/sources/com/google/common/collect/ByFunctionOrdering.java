package com.google.common.collect;

import java.io.Serializable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
final class ByFunctionOrdering<F, T> extends g8 implements Serializable {
    private static final long serialVersionUID = 0;
    final com.google.common.base.q function;
    final g8 ordering;

    public ByFunctionOrdering(com.google.common.base.q r5, g8 r10) {
        r5.getClass();
        this.function = r5;
        r10.getClass();
        this.ordering = r10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public int compare(F r5, F r10) {
        return this.ordering.compare(this.function.apply(r5), this.function.apply(r10));
    }

    @Override // java.util.Comparator
    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof ByFunctionOrdering) == false) goto L14;
        ByFunctionOrdering r10 = (ByFunctionOrdering) r5;
        if (this.function.equals(r10.function) == false) goto L13;
        if (this.ordering.equals(r10.ordering) == false) goto L13;
        return true;
    L13:
        return false;
    L14:
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.function, this.ordering});
    }

    public String toString() {
        String r5 = String.valueOf(this.ordering);
        String r10 = String.valueOf(this.function);
        int r11 = r5.length() + 13;
        StringBuilder r12 = new StringBuilder(r10.length() + r11);
        r12.append(r5);
        r12.append(".onResultOf(");
        r12.append(r10);
        r12.append(")");
        return r12.toString();
    }
}
