package com.google.common.base;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
class Predicates$OrPredicate<T> implements z, Serializable {
    private static final long serialVersionUID = 0;
    private final List<? extends z> components;

    public Predicates$OrPredicate(List r5, a0 r10) {
        this.components = r5;
    }

    @Override // com.google.common.base.z
    public boolean apply(T r5) {
        int r10 = 0;
    L4:
        if (r10 >= this.components.size()) goto L10;
        if (this.components.get(r10).apply(r5) == true) goto L7;
        r10 = r10 + 1;
        goto L4
    L7:
        return true;
    L10:
        return false;
    }

    @Override // com.google.common.base.z
    public boolean equals(Object r5) {
        if ((r5 instanceof Predicates$OrPredicate) == true) goto L5;
        return false;
    L5:
        return this.components.equals(((Predicates$OrPredicate) r5).components);
    }

    public int hashCode() {
        return this.components.hashCode() + 87855567;
    }

    @Override // com.google.common.base.z, java.util.function.Predicate
    public boolean test(Object r5) {
        return apply(r5);
    }

    public String toString() {
        return b0.a("or", this.components);
    }
}
