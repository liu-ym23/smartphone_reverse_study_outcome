package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Comparator;
import java.util.Set;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes2.dex */
public interface bc<K, V> extends aw<K, V> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.aw, com.google.common.collect.am, com.google.common.collect.ak
    /* bridge */ /* synthetic */ default Collection get(Object r1) {
        return get(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.aw, com.google.common.collect.am, com.google.common.collect.ak
    /* bridge */ /* synthetic */ default Set get(Object r1) {
        return get(r1);
    }

    @Override // com.google.common.collect.aw, com.google.common.collect.am, com.google.common.collect.ak
    SortedSet<V> get(K r1);

    @Override // com.google.common.collect.aw, com.google.common.collect.am, com.google.common.collect.ak
    /* bridge */ /* synthetic */ default Collection removeAll(Object r1) {
        return removeAll(r1);
    }

    @Override // com.google.common.collect.aw, com.google.common.collect.am, com.google.common.collect.ak
    /* bridge */ /* synthetic */ default Set removeAll(Object r1) {
        return removeAll(r1);
    }

    @Override // com.google.common.collect.aw, com.google.common.collect.am, com.google.common.collect.ak
    SortedSet<V> removeAll(Object r1);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.aw, com.google.common.collect.am, com.google.common.collect.ak
    /* synthetic */ default Collection replaceValues(Object r3, Iterable r4) {
        return replaceValues(r3, (Iterable) ZeusTransformUtils.wrapperContextForParams(r4, Iterable.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.aw, com.google.common.collect.am, com.google.common.collect.ak
    /* synthetic */ default Set replaceValues(Object r3, Iterable r4) {
        return replaceValues(r3, (Iterable) ZeusTransformUtils.wrapperContextForParams(r4, Iterable.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.google.common.collect.aw, com.google.common.collect.am, com.google.common.collect.ak
    SortedSet<V> replaceValues(K r1, Iterable<? extends V> r2);

    Comparator<? super V> valueComparator();
}
