package org.apache.commons.collections4.iterators;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;
import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.Unmodifiable;

/* JADX INFO: loaded from: classes6.dex */
public final class UnmodifiableOrderedMapIterator<K, V> implements OrderedMapIterator<K, V>, Unmodifiable {
    private final OrderedMapIterator<? extends K, ? extends V> iterator;

    private UnmodifiableOrderedMapIterator(OrderedMapIterator<K, ? extends V> r3) {
        this.iterator = (OrderedMapIterator) ZeusTransformUtils.wrapperContextForParams(r3, OrderedMapIterator.class, "com.obric.memorydata.plugin");
    }

    public static <K, V> OrderedMapIterator<K, V> unmodifiableOrderedMapIterator(OrderedMapIterator<K, ? extends V> r2) {
        OrderedMapIterator<K, V> r3 = (OrderedMapIterator) ZeusTransformUtils.wrapperContextForParams(r2, OrderedMapIterator.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r3, "OrderedMapIterator must not be null");
        if (ZeusTransformUtils.instanceOf(r3, Unmodifiable.class) == false) goto L6;
        return r3;
    L6:
        return new UnmodifiableOrderedMapIterator(r3);
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
