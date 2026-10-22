package com.google.common.base;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
class Predicates$NotPredicate<T> implements z, Serializable {
    private static final long serialVersionUID = 0;
    final z predicate;

    public Predicates$NotPredicate(z r5) {
        r5.getClass();
        this.predicate = r5;
    }

    @Override // com.google.common.base.z
    public boolean apply(T r5) {
        return !this.predicate.apply(r5);
    }

    @Override // com.google.common.base.z
    public boolean equals(Object r5) {
        if ((r5 instanceof Predicates$NotPredicate) == true) goto L5;
        return false;
    L5:
        return this.predicate.equals(((Predicates$NotPredicate) r5).predicate);
    }

    public int hashCode() {
        return ~this.predicate.hashCode();
    }

    @Override // com.google.common.base.z, java.util.function.Predicate
    public boolean test(Object r5) {
        return apply(r5);
    }

    public String toString() {
        String r5 = String.valueOf(this.predicate);
        return androidx.room.jarjarred.org.antlr.runtime.a.m(r5.length() + 16, "Predicates.not(", r5, ")");
    }
}
