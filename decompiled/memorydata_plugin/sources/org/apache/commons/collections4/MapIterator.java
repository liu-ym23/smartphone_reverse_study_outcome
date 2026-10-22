package org.apache.commons.collections4;

import java.util.Iterator;

/* JADX INFO: loaded from: classes6.dex */
public interface MapIterator<K, V> extends Iterator<K> {
    V getValue();

    @Override // java.util.Iterator
    boolean hasNext();

    @Override // java.util.Iterator
    K next();

    @Override // java.util.Iterator
    void remove();
}
