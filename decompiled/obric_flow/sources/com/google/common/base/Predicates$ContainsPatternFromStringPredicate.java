package com.google.common.base;

import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
class Predicates$ContainsPatternFromStringPredicate extends Predicates$ContainsPatternPredicate {
    private static final long serialVersionUID = 0;

    public Predicates$ContainsPatternFromStringPredicate(String r5) {
        com.bytedance.sdk.xbridge.cn.auth.g r10 = y.f8677a;
        r5.getClass();
        y.f8677a.getClass();
        super(new JdkPattern(Pattern.compile(r5)));
    }

    @Override // com.google.common.base.Predicates$ContainsPatternPredicate, com.google.common.base.z, java.util.function.Predicate
    public boolean test(Object r5) {
        return apply(r5);
    }

    @Override // com.google.common.base.Predicates$ContainsPatternPredicate
    public String toString() {
        String r5 = this.pattern.pattern();
        return androidx.room.jarjarred.org.antlr.runtime.a.m(androidx.room.jarjarred.org.antlr.runtime.a.g(28, r5), "Predicates.containsPattern(", r5, ")");
    }
}
