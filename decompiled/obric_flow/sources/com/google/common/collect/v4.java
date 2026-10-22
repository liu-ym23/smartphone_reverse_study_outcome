package com.google.common.collect;

import java.util.Comparator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class v4 extends x3 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Comparator f9193c;

    public v4(Comparator r5) {
        super(4);
        r5.getClass();
        this.f9193c = r5;
    }

    @Override // com.google.common.collect.x3
    public final ImmutableMap a() {
        return j();
    }

    @Override // com.google.common.collect.x3
    public final ImmutableMap c() {
        throw new UnsupportedOperationException("ImmutableSortedMap.Builder does not yet implement buildKeepingLast()");
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

    public final ImmutableSortedMap j() {
        int r5 = this.f9221b;
        Comparator r10 = this.f9193c;
        if (r5 == 0) goto L11;
        if (r5 != 1) goto L7;
        Map.Entry r11 = this.f9220a[0];
        Objects.requireNonNull(r11);
        Map.Entry r12 = r11;
        return ImmutableSortedMap.access$000(r10, r12.getKey(), r12.getValue());
    L7:
        return ImmutableSortedMap.access$100(r10, false, this.f9220a, r5);
    L11:
        return ImmutableSortedMap.emptyMap(r10);
    }

    public final void k(v4 r5) {
        super.e(r5);
    }

    public final void l(Object r5, Object r10) {
        super.g(r5, r10);
    }
}
