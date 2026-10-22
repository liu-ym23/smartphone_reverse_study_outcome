package com.google.common.base;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
class Predicates$IsEqualToPredicate implements z, Serializable {
    private static final long serialVersionUID = 0;
    private final Object target;

    public Predicates$IsEqualToPredicate(Object r5, a0 r10) {
        this.target = r5;
    }

    @Override // com.google.common.base.z
    public boolean apply(Object r5) {
        return this.target.equals(r5);
    }

    @Override // com.google.common.base.z
    public boolean equals(Object r5) {
        if ((r5 instanceof Predicates$IsEqualToPredicate) == true) goto L5;
        return false;
    L5:
        return this.target.equals(((Predicates$IsEqualToPredicate) r5).target);
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
        return androidx.room.jarjarred.org.antlr.runtime.a.m(r5.length() + 20, "Predicates.equalTo(", r5, ")");
    }

    public <T> z withNarrowedType() {
        return this;
    }
}
