package com.google.common.collect;

import java.util.Collection;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes2.dex */
public final class s4 extends e4 {
    @Override // com.google.common.collect.e4
    public final Collection b() {
        int r5 = h8.f9015a;
        return new LinkedHashSet();
    }

    @Override // com.google.common.collect.e4
    public final e4 c(Object r5, Object r10) {
        super.c(r5, r10);
        return this;
    }

    public final ImmutableSetMultimap e() {
        return ImmutableSetMultimap.fromMapEntries(this.f8953a.entrySet(), null);
    }

    public final void f(Object r5, Object r10) {
        super.c(r5, r10);
    }
}
