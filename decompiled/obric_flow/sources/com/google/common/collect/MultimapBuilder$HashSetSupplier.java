package com.google.common.collect;

import java.io.Serializable;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
final class MultimapBuilder$HashSetSupplier<V> implements com.google.common.base.e0, Serializable {
    private final int expectedValuesPerKey;

    public MultimapBuilder$HashSetSupplier(int r5) {
        p7.q(r5, "expectedValuesPerKey");
        this.expectedValuesPerKey = r5;
    }

    @Override // java.util.function.Supplier
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    @Override // java.util.function.Supplier
    public Set<V> get() {
        int r5 = this.expectedValuesPerKey;
        int r10 = h8.f9015a;
        return p7.Y(r5);
    }
}
