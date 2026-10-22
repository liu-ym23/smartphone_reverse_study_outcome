package com.google.common.base;

import java.io.Serializable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
final class FunctionalEquivalence<F, T> extends p implements Serializable {
    private static final long serialVersionUID = 0;
    private final q function;
    private final p resultEquivalence;

    public FunctionalEquivalence(q r5, p r10) {
        r5.getClass();
        this.function = r5;
        r10.getClass();
        this.resultEquivalence = r10;
    }

    @Override // com.google.common.base.p
    public boolean doEquivalent(F r5, F r10) {
        return this.resultEquivalence.equivalent(this.function.apply(r5), this.function.apply(r10));
    }

    @Override // com.google.common.base.p
    public int doHash(F r5) {
        return this.resultEquivalence.hash(this.function.apply(r5));
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof FunctionalEquivalence) == false) goto L14;
        FunctionalEquivalence r10 = (FunctionalEquivalence) r5;
        if (this.function.equals(r10.function) == false) goto L13;
        if (this.resultEquivalence.equals(r10.resultEquivalence) == false) goto L13;
        return true;
    L13:
        return false;
    L14:
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.function, this.resultEquivalence});
    }

    public String toString() {
        String r5 = String.valueOf(this.resultEquivalence);
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
