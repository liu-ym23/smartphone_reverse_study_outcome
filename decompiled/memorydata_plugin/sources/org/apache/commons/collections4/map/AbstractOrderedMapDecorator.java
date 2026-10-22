package org.apache.commons.collections4.map;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.OrderedMap;
import org.apache.commons.collections4.OrderedMapIterator;

/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractOrderedMapDecorator<K, V> extends AbstractMapDecorator<K, V> implements OrderedMap<K, V> {
    public AbstractOrderedMapDecorator() {
    }

    public AbstractOrderedMapDecorator(OrderedMap<K, V> r3) {
        super((OrderedMap) ZeusTransformUtils.wrapperContextForParams(r3, OrderedMap.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator
    public /* bridge */ /* synthetic */ Map decorated() {
        return decorated();
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator
    public OrderedMap<K, V> decorated() {
        return (OrderedMap) ZeusTransformUtils.preCheckCast(super.decorated(), OrderedMap.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K firstKey() {
        return decorated().firstKey();
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K lastKey() {
        return decorated().lastKey();
    }

    @Override // org.apache.commons.collections4.map.AbstractIterableMap, org.apache.commons.collections4.IterableGet
    public /* bridge */ /* synthetic */ MapIterator mapIterator() {
        return mapIterator();
    }

    @Override // org.apache.commons.collections4.map.AbstractIterableMap, org.apache.commons.collections4.IterableGet
    public OrderedMapIterator<K, V> mapIterator() {
        return decorated().mapIterator();
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K nextKey(K r1) {
        return decorated().nextKey(r1);
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K previousKey(K r1) {
        return decorated().previousKey(r1);
    }
}
