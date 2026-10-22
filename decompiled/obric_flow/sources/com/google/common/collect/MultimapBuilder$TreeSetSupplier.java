package com.google.common.collect;

import java.io.Serializable;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes2.dex */
final class MultimapBuilder$TreeSetSupplier<V> implements com.google.common.base.e0, Serializable {
    private final Comparator<? super V> comparator;

    public MultimapBuilder$TreeSetSupplier(Comparator<? super V> r5) {
        r5.getClass();
        this.comparator = r5;
    }

    @Override // java.util.function.Supplier
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    @Override // java.util.function.Supplier
    public SortedSet<V> get() {
        return new TreeSet(this.comparator);
    }
}
