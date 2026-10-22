package org.apache.commons.collections4;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public interface MultiMap<K, V> extends IterableMap<K, Object> {
    @Override // java.util.Map
    Object get(Object r1);

    @Override // java.util.Map
    Object put(K r1, Object r2);

    @Override // java.util.Map
    Object remove(Object r1);
}
