package org.apache.commons.collections4;

import java.util.Collection;
import java.util.Set;

/* JADX INFO: loaded from: classes6.dex */
public interface BidiMap<K, V> extends IterableMap<K, V> {
    @Override // java.util.Map
    /* bridge */ /* synthetic */ default Collection values() {
        return values();
    }

    @Override // java.util.Map
    Set<V> values();
}
