package com.google.common.base;

import java.util.function.Predicate;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c extends g {
    @Override // com.google.common.base.z
    public final boolean apply(Object r5) {
        return b(((Character) r5).charValue());
    }

    public g c() {
        return new f(this);
    }

    @Override // java.util.function.Predicate
    public /* bridge */ /* synthetic */ Predicate negate() {
        return c();
    }
}
