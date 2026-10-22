package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface ak<K, V> extends am<K, V> {
    /* JADX WARN: Multi-variable type inference failed */
    /* bridge */ /* synthetic */ default Collection get(Object r1) {
        return get(r1);
    }

    @Override // com.google.common.collect.am, com.google.common.collect.ak
    List<V> get(K r1);

    /* bridge */ /* synthetic */ default Collection removeAll(Object r1) {
        return removeAll(r1);
    }

    @Override // com.google.common.collect.am, com.google.common.collect.ak
    List<V> removeAll(Object r1);

    /* JADX WARN: Multi-variable type inference failed */
    /* synthetic */ default Collection replaceValues(Object r3, Iterable r4) {
        return replaceValues(r3, (Iterable) ZeusTransformUtils.wrapperContextForParams(r4, Iterable.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.google.common.collect.am, com.google.common.collect.ak
    List<V> replaceValues(K r1, Iterable<? extends V> r2);
}
