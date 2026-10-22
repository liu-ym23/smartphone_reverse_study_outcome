package com.google.common.base;

import java.io.Serializable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
final class Equivalence$EquivalentToPredicate<T> implements z, Serializable {
    private static final long serialVersionUID = 0;
    private final p equivalence;
    private final T target;

    public Equivalence$EquivalentToPredicate(p r5, T r10) {
        r5.getClass();
        this.equivalence = r5;
        this.target = r10;
    }

    @Override // com.google.common.base.z
    public boolean apply(T r5) {
        return this.equivalence.equivalent(r5, this.target);
    }

    @Override // com.google.common.base.z
    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof Equivalence$EquivalentToPredicate) == false) goto L14;
        Equivalence$EquivalentToPredicate r10 = (Equivalence$EquivalentToPredicate) r5;
        if (this.equivalence.equals(r10.equivalence) == false) goto L13;
        if (b0.w(this.target, r10.target) == false) goto L13;
        return true;
    L13:
        return false;
    L14:
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.equivalence, this.target});
    }

    @Override // com.google.common.base.z, java.util.function.Predicate
    public boolean test(Object r5) {
        return apply(r5);
    }

    public String toString() {
        String r5 = String.valueOf(this.equivalence);
        String r10 = String.valueOf(this.target);
        int r11 = r5.length() + 15;
        StringBuilder r12 = new StringBuilder(r10.length() + r11);
        r12.append(r5);
        r12.append(".equivalentTo(");
        r12.append(r10);
        r12.append(")");
        return r12.toString();
    }
}
