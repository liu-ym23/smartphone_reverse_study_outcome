package org.apache.commons.collections4;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes6.dex */
public interface MultiValuedMap<K, V> {
    Map<K, Collection<V>> asMap();

    void clear();

    boolean containsKey(Object r1);

    boolean containsMapping(Object r1, Object r2);

    boolean containsValue(Object r1);

    Collection<Map.Entry<K, V>> entries();

    Collection<V> get(K r1);

    boolean isEmpty();

    Set<K> keySet();

    MultiSet<K> keys();

    MapIterator<K, V> mapIterator();

    boolean put(K r1, V r2);

    boolean putAll(K r1, Iterable<? extends V> r2);

    boolean putAll(Map<? extends K, ? extends V> r1);

    boolean putAll(MultiValuedMap<? extends K, ? extends V> r1);

    Collection<V> remove(Object r1);

    boolean removeMapping(Object r1, Object r2);

    int size();

    Collection<V> values();
}
