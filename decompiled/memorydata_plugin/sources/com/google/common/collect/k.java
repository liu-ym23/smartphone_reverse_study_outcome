package com.google.common.collect;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public interface k<K, V> extends Map<K, V> {
    V forcePut(K r1, V r2);

    k<V, K> inverse();

    /* bridge */ /* synthetic */ default Collection values() {
        return values();
    }

    Set<V> values();
}
