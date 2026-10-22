package com.google.common.base;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
class Predicates$CompositionPredicate<A, B> implements z, Serializable {
    private static final long serialVersionUID = 0;
    final q f;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    final z f8643p;

    public Predicates$CompositionPredicate(z r5, q r10, a0 r11) {
        r5.getClass();
        this.f8643p = r5;
        r10.getClass();
        this.f = r10;
    }

    @Override // com.google.common.base.z
    public boolean apply(A r5) {
        return this.f8643p.apply(this.f.apply(r5));
    }

    @Override // com.google.common.base.z
    public boolean equals(Object r5) {
        if ((r5 instanceof Predicates$CompositionPredicate) == false) goto L10;
        Predicates$CompositionPredicate r10 = (Predicates$CompositionPredicate) r5;
        if (this.f.equals(r10.f) == true) goto L7;
        return false;
    L7:
        if (this.f8643p.equals(r10.f8643p) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    public int hashCode() {
        int r5 = this.f.hashCode();
        return this.f8643p.hashCode() ^ r5;
    }

    @Override // com.google.common.base.z, java.util.function.Predicate
    public boolean test(Object r5) {
        return apply(r5);
    }

    public String toString() {
        String r5 = String.valueOf(this.f8643p);
        String r10 = String.valueOf(this.f);
        int r11 = r5.length() + 2;
        StringBuilder r12 = new StringBuilder(r10.length() + r11);
        r12.append(r5);
        r12.append("(");
        r12.append(r10);
        r12.append(")");
        return r12.toString();
    }
}
