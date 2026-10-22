package org.apache.commons.collections4;

/* JADX INFO: loaded from: classes6.dex */
public interface OrderedMap<K, V> extends IterableMap<K, V> {
    K firstKey();

    K lastKey();

    @Override // org.apache.commons.collections4.IterableGet
    /* bridge */ /* synthetic */ default MapIterator mapIterator() {
        return mapIterator();
    }

    @Override // org.apache.commons.collections4.IterableGet
    OrderedMapIterator<K, V> mapIterator();

    K nextKey(K r1);

    K previousKey(K r1);
}
