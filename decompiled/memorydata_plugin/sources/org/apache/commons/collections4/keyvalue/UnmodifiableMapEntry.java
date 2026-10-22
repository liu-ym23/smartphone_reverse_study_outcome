package org.apache.commons.collections4.keyvalue;

import org.apache.commons.collections4.Unmodifiable;

/* JADX INFO: loaded from: classes6.dex */
public final class UnmodifiableMapEntry<K, V> extends AbstractMapEntry<K, V> implements Unmodifiable {
    public UnmodifiableMapEntry(K r1, V r2) {
        super(r1, r2);
    }

    @Override // org.apache.commons.collections4.keyvalue.AbstractMapEntry, org.apache.commons.collections4.keyvalue.AbstractKeyValue, java.util.Map.Entry
    public V setValue(V r1) {
        throw new UnsupportedOperationException("setValue() is not supported");
    }
}
