package com.google.common.base;

import java.io.Serializable;
import java.util.Collection;

/* JADX INFO: loaded from: classes2.dex */
class Predicates$InPredicate<T> implements z, Serializable {
    private static final long serialVersionUID = 0;
    private final Collection<?> target;

    public Predicates$InPredicate(Collection r5, a0 r10) {
        r5.getClass();
        this.target = r5;
    }

    @Override // com.google.common.base.z
    public boolean apply(T r5) {
        return this.target.contains(r5);
    L4:
        return false;
    }

    @Override // com.google.common.base.z
    public boolean equals(Object r5) {
        if ((r5 instanceof Predicates$InPredicate) == true) goto L5;
        return false;
    L5:
        return this.target.equals(((Predicates$InPredicate) r5).target);
    }

    public int hashCode() {
        return this.target.hashCode();
    }

    @Override // com.google.common.base.z, java.util.function.Predicate
    public boolean test(Object r5) {
        return apply(r5);
    }

    public String toString() {
        String r5 = String.valueOf(this.target);
        return androidx.room.jarjarred.org.antlr.runtime.a.m(r5.length() + 15, "Predicates.in(", r5, ")");
    }
}
