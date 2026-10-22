package org.apache.commons.collections4.iterators;

import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.ResettableIterator;

/* JADX INFO: loaded from: classes6.dex */
public class EmptyMapIterator<K, V> extends AbstractEmptyMapIterator<K, V> implements MapIterator<K, V>, ResettableIterator<K> {
    public static final MapIterator INSTANCE = null;

    static {
        INSTANCE = new EmptyMapIterator();
    }

    public EmptyMapIterator() {
    }

    public static <K, V> MapIterator<K, V> emptyMapIterator() {
        return INSTANCE;
    }
}
