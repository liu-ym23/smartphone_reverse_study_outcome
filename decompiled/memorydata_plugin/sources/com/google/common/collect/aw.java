package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public interface aw<K, V> extends am<K, V> {
    @Override // com.google.common.collect.am
    /* bridge */ /* synthetic */ default Collection entries() {
        return entries();
    }

    @Override // com.google.common.collect.am
    Set<Map.Entry<K, V>> entries();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.am, com.google.common.collect.ak
    /* bridge */ /* synthetic */ default Collection get(Object r1) {
        return get(r1);
    }

    @Override // com.google.common.collect.am, com.google.common.collect.ak
    Set<V> get(K r1);

    @Override // com.google.common.collect.am, com.google.common.collect.ak
    /* bridge */ /* synthetic */ default Collection removeAll(Object r1) {
        return removeAll(r1);
    }

    @Override // com.google.common.collect.am, com.google.common.collect.ak
    Set<V> removeAll(Object r1);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.am, com.google.common.collect.ak
    /* synthetic */ default Collection replaceValues(Object r3, Iterable r4) {
        return replaceValues(r3, (Iterable) ZeusTransformUtils.wrapperContextForParams(r4, Iterable.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.google.common.collect.am, com.google.common.collect.ak
    Set<V> replaceValues(K r1, Iterable<? extends V> r2);
}
