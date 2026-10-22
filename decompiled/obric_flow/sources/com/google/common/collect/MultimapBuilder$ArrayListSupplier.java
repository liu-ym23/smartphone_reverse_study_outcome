package com.google.common.collect;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
final class MultimapBuilder$ArrayListSupplier<V> implements com.google.common.base.e0, Serializable {
    private final int expectedValuesPerKey;

    public MultimapBuilder$ArrayListSupplier(int r5) {
        p7.q(r5, "expectedValuesPerKey");
        this.expectedValuesPerKey = r5;
    }

    @Override // java.util.function.Supplier
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    @Override // java.util.function.Supplier
    public List<V> get() {
        return new ArrayList(this.expectedValuesPerKey);
    }
}
