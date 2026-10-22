package com.google.common.collect;

import java.io.Serializable;
import java.lang.Enum;
import java.util.EnumSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
final class MultimapBuilder$EnumSetSupplier<V extends Enum<V>> implements com.google.common.base.e0, Serializable {
    private final Class<V> clazz;

    public MultimapBuilder$EnumSetSupplier(Class<V> r5) {
        r5.getClass();
        this.clazz = r5;
    }

    @Override // java.util.function.Supplier
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    @Override // java.util.function.Supplier
    public Set<V> get() {
        return EnumSet.noneOf(this.clazz);
    }
}
