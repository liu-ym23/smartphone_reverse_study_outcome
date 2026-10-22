package com.google.common.base;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
class Predicates$InstanceOfPredicate<T> implements z, Serializable {
    private static final long serialVersionUID = 0;
    private final Class<?> clazz;

    public Predicates$InstanceOfPredicate(Class r5, a0 r10) {
        r5.getClass();
        this.clazz = r5;
    }

    @Override // com.google.common.base.z
    public boolean apply(T r5) {
        return this.clazz.isInstance(r5);
    }

    @Override // com.google.common.base.z
    public boolean equals(Object r5) {
        if ((r5 instanceof Predicates$InstanceOfPredicate) == true) goto L5;
        return false;
    L5:
        if (this.clazz != ((Predicates$InstanceOfPredicate) r5).clazz) goto L9;
        return true;
    L9:
        return false;
    }

    public int hashCode() {
        return this.clazz.hashCode();
    }

    @Override // com.google.common.base.z, java.util.function.Predicate
    public boolean test(Object r5) {
        return apply(r5);
    }

    public String toString() {
        String r5 = this.clazz.getName();
        return androidx.room.jarjarred.org.antlr.runtime.a.m(r5.length() + 23, "Predicates.instanceOf(", r5, ")");
    }
}
