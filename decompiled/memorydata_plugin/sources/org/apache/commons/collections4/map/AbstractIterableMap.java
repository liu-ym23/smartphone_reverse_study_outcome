package org.apache.commons.collections4.map;

import org.apache.commons.collections4.IterableMap;
import org.apache.commons.collections4.MapIterator;

/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractIterableMap<K, V> implements IterableMap<K, V> {
    public AbstractIterableMap() {
    }

    @Override // org.apache.commons.collections4.IterableGet
    public MapIterator<K, V> mapIterator() {
        return new EntrySetToMapIteratorAdapter(entrySet());
    }
}
