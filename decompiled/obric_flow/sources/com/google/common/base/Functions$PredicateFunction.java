package com.google.common.base;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
class Functions$PredicateFunction<T> implements q, Serializable {
    private static final long serialVersionUID = 0;
    private final z predicate;

    public Functions$PredicateFunction(z r5, r r10) {
        r5.getClass();
        this.predicate = r5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.function.Function
    public /* bridge */ /* synthetic */ Object apply(Object r5) {
        return apply(r5);
    }

    @Override // com.google.common.base.q
    public boolean equals(Object r5) {
        if ((r5 instanceof Functions$PredicateFunction) == true) goto L5;
        return false;
    L5:
        return this.predicate.equals(((Functions$PredicateFunction) r5).predicate);
    }

    public int hashCode() {
        return this.predicate.hashCode();
    }

    public String toString() {
        String r5 = String.valueOf(this.predicate);
        return androidx.room.jarjarred.org.antlr.runtime.a.m(r5.length() + 24, "Functions.forPredicate(", r5, ")");
    }

    @Override // java.util.function.Function
    public Boolean apply(T r5) {
        return Boolean.valueOf(this.predicate.apply(r5));
    }
}
