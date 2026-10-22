package org.apache.commons.collections4.iterators;

import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.ResettableIterator;

/* JADX INFO: loaded from: classes6.dex */
public class EmptyOrderedMapIterator<K, V> extends AbstractEmptyMapIterator<K, V> implements OrderedMapIterator<K, V>, ResettableIterator<K> {
    public static final OrderedMapIterator INSTANCE = null;

    static {
        INSTANCE = new EmptyOrderedMapIterator();
    }

    public EmptyOrderedMapIterator() {
    }

    public static <K, V> OrderedMapIterator<K, V> emptyOrderedMapIterator() {
        return INSTANCE;
    }
}
