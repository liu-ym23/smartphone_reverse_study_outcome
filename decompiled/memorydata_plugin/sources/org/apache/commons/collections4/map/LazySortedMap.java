package org.apache.commons.collections4.map;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Comparator;
import java.util.SortedMap;
import org.apache.commons.collections4.Factory;
import org.apache.commons.collections4.Transformer;

/* JADX INFO: loaded from: classes6.dex */
public class LazySortedMap<K, V> extends LazyMap<K, V> implements SortedMap<K, V> {
    private static final long serialVersionUID = 2715322183617658933L;

    public LazySortedMap(SortedMap<K, V> r3, Factory<? extends V> r4) {
        super((SortedMap) ZeusTransformUtils.wrapperContextForParams(r3, SortedMap.class, "com.obric.memorydata.plugin"), (Factory) ZeusTransformUtils.wrapperContextForParams(r4, Factory.class, "com.obric.memorydata.plugin"));
    }

    public LazySortedMap(SortedMap<K, V> r3, Transformer<? super K, ? extends V> r4) {
        super((SortedMap) ZeusTransformUtils.wrapperContextForParams(r3, SortedMap.class, "com.obric.memorydata.plugin"), (Transformer) ZeusTransformUtils.wrapperContextForParams(r4, Transformer.class, "com.obric.memorydata.plugin"));
    }

    public static <K, V> LazySortedMap<K, V> lazySortedMap(SortedMap<K, V> r2, Factory<? extends V> r3) {
        return new LazySortedMap((SortedMap) ZeusTransformUtils.wrapperContextForParams(r2, SortedMap.class, "com.obric.memorydata.plugin"), (Factory) ZeusTransformUtils.wrapperContextForParams(r3, Factory.class, "com.obric.memorydata.plugin"));
    }

    public static <K, V> LazySortedMap<K, V> lazySortedMap(SortedMap<K, V> r2, Transformer<? super K, ? extends V> r3) {
        return new LazySortedMap((SortedMap) ZeusTransformUtils.wrapperContextForParams(r2, SortedMap.class, "com.obric.memorydata.plugin"), (Transformer) ZeusTransformUtils.wrapperContextForParams(r3, Transformer.class, "com.obric.memorydata.plugin"));
    }

    @Override // java.util.SortedMap
    public Comparator<? super K> comparator() {
        return getSortedMap().comparator();
    }

    @Override // java.util.SortedMap
    public K firstKey() {
        return getSortedMap().firstKey();
    }

    public SortedMap<K, V> getSortedMap() {
        return (SortedMap) ZeusTransformUtils.preCheckCast(this.map, SortedMap.class, "com.obric.memorydata.plugin");
    }

    @Override // java.util.SortedMap
    public SortedMap<K, V> headMap(K r2) {
        return new LazySortedMap(getSortedMap().headMap(r2), this.factory);
    }

    @Override // java.util.SortedMap
    public K lastKey() {
        return getSortedMap().lastKey();
    }

    @Override // java.util.SortedMap
    public SortedMap<K, V> subMap(K r2, K r3) {
        return new LazySortedMap(getSortedMap().subMap(r2, r3), this.factory);
    }

    @Override // java.util.SortedMap
    public SortedMap<K, V> tailMap(K r2) {
        return new LazySortedMap(getSortedMap().tailMap(r2), this.factory);
    }
}
