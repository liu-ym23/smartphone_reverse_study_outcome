package org.apache.commons.collections4;

import java.util.Collection;
import java.util.Set;

/* JADX INFO: loaded from: classes6.dex */
public interface SetValuedMap<K, V> extends MultiValuedMap<K, V> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.collections4.MultiValuedMap
    /* bridge */ /* synthetic */ default Collection get(Object r1) {
        return get(r1);
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    Set<V> get(K r1);

    @Override // org.apache.commons.collections4.MultiValuedMap
    /* bridge */ /* synthetic */ default Collection remove(Object r1) {
        return remove(r1);
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    Set<V> remove(Object r1);
}
