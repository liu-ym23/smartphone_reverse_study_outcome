package com.google.common.collect;

import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class p3 extends x3 {
    @Override // com.google.common.collect.x3
    public final ImmutableMap a() {
        return j();
    }

    @Override // com.google.common.collect.x3
    public final ImmutableMap c() {
        throw new UnsupportedOperationException("Not supported for bimaps");
    }

    @Override // com.google.common.collect.x3
    public final /* bridge */ /* synthetic */ ImmutableMap d() {
        return j();
    }

    @Override // com.google.common.collect.x3
    public final x3 e(x3 r5) {
        super.e(r5);
        return this;
    }

    @Override // com.google.common.collect.x3
    public final x3 g(Object r5, Object r10) {
        super.g(r5, r10);
        return this;
    }

    @Override // com.google.common.collect.x3
    public final x3 h(Set r5) {
        super.h(r5);
        return this;
    }

    public final ImmutableBiMap j() {
        int r5 = this.f9221b;
        if (r5 == 0) goto L11;
        if (r5 != 1) goto L7;
        Map.Entry r10 = this.f9220a[0];
        Objects.requireNonNull(r10);
        return ImmutableBiMap.of(r10.getKey(), r10.getValue());
    L7:
        return RegularImmutableBiMap.fromEntryArray(r5, this.f9220a);
    L11:
        return ImmutableBiMap.of();
    }

    public final void k(p3 r5) {
        super.e(r5);
    }

    public final void l(Object r5, Object r10) {
        super.g(r5, r10);
    }
}
