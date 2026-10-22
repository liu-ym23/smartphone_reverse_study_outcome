package org.apache.commons.collections4.iterators;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.Unmodifiable;

/* JADX INFO: loaded from: classes6.dex */
public final class UnmodifiableMapIterator<K, V> implements MapIterator<K, V>, Unmodifiable {
    private final MapIterator<? extends K, ? extends V> iterator;

    private UnmodifiableMapIterator(MapIterator<? extends K, ? extends V> r3) {
        this.iterator = (MapIterator) ZeusTransformUtils.wrapperContextForParams(r3, MapIterator.class, "com.obric.memorydata.plugin");
    }

    public static <K, V> MapIterator<K, V> unmodifiableMapIterator(MapIterator<? extends K, ? extends V> r2) {
        MapIterator<K, V> r3 = (MapIterator) ZeusTransformUtils.wrapperContextForParams(r2, MapIterator.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r3, "MapIterator must not be null");
        if (ZeusTransformUtils.instanceOf(r3, Unmodifiable.class) == false) goto L6;
        return r3;
    L6:
        return new UnmodifiableMapIterator(r3);
    }

    @Override // org.apache.commons.collections4.MapIterator
    public V getValue() {
        return this.iterator.getValue();
    }

    @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
    public K next() {
        return this.iterator.next();
    }

    @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("remove() is not supported");
    }
}
