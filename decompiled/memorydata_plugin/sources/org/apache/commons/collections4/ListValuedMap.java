package org.apache.commons.collections4;

import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public interface ListValuedMap<K, V> extends MultiValuedMap<K, V> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.collections4.MultiValuedMap
    /* bridge */ /* synthetic */ default Collection get(Object r1) {
        return get(r1);
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    List<V> get(K r1);

    @Override // org.apache.commons.collections4.MultiValuedMap
    /* bridge */ /* synthetic */ default Collection remove(Object r1) {
        return remove(r1);
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    List<V> remove(Object r1);
}
