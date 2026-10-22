package com.google.common.base;

import java.io.Serializable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
class Predicates$ContainsPatternPredicate implements z, Serializable {
    private static final long serialVersionUID = 0;
    final j pattern;

    public Predicates$ContainsPatternPredicate(j r5) {
        r5.getClass();
        this.pattern = r5;
    }

    @Override // com.google.common.base.z
    public /* bridge */ /* synthetic */ boolean apply(Object r5) {
        return apply((CharSequence) r5);
    }

    @Override // com.google.common.base.z
    public boolean equals(Object r5) {
        if ((r5 instanceof Predicates$ContainsPatternPredicate) == false) goto L10;
        Predicates$ContainsPatternPredicate r10 = (Predicates$ContainsPatternPredicate) r5;
        if (b0.w(this.pattern.pattern(), r10.pattern.pattern()) == true) goto L7;
        return false;
    L7:
        if (this.pattern.flags() != r10.pattern.flags()) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.pattern.pattern(), Integer.valueOf(this.pattern.flags())});
    }

    @Override // com.google.common.base.z, java.util.function.Predicate
    public boolean test(Object r5) {
        return apply(r5);
    }

    public String toString() {
        w r5 = b0.E(this.pattern);
        r5.b(this.pattern.pattern(), "pattern");
        r5.c("pattern.flags", String.valueOf(this.pattern.flags()));
        String r10 = r5.toString();
        return androidx.room.jarjarred.org.antlr.runtime.a.m(androidx.room.jarjarred.org.antlr.runtime.a.g(21, r10), "Predicates.contains(", r10, ")");
    }

    public boolean apply(CharSequence r5) {
        return ((s) this.pattern.matcher(r5)).f8667a.find();
    }
}
