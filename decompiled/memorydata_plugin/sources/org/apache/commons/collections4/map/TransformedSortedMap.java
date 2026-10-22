package org.apache.commons.collections4.map;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import org.apache.commons.collections4.Transformer;

/* JADX INFO: loaded from: classes6.dex */
public class TransformedSortedMap<K, V> extends TransformedMap<K, V> implements SortedMap<K, V> {
    private static final long serialVersionUID = -8751771676410385778L;

    public TransformedSortedMap(SortedMap<K, V> r3, Transformer<? super K, ? extends K> r4, Transformer<? super V, ? extends V> r5) {
        super((SortedMap) ZeusTransformUtils.wrapperContextForParams(r3, SortedMap.class, "com.obric.memorydata.plugin"), (Transformer) ZeusTransformUtils.wrapperContextForParams(r4, Transformer.class, "com.obric.memorydata.plugin"), (Transformer) ZeusTransformUtils.wrapperContextForParams(r5, Transformer.class, "com.obric.memorydata.plugin"));
    }

    public static <K, V> TransformedSortedMap<K, V> transformedSortedMap(SortedMap<K, V> r2, Transformer<? super K, ? extends K> r3, Transformer<? super V, ? extends V> r4) {
        SortedMap r5 = (SortedMap) ZeusTransformUtils.wrapperContextForParams(r2, SortedMap.class, "com.obric.memorydata.plugin");
        TransformedSortedMap<K, V> r0 = new TransformedSortedMap(r5, (Transformer) ZeusTransformUtils.wrapperContextForParams(r3, Transformer.class, "com.obric.memorydata.plugin"), (Transformer) ZeusTransformUtils.wrapperContextForParams(r4, Transformer.class, "com.obric.memorydata.plugin"));
        if (r5.size() <= 0) goto L5;
        Map<K, V> r6 = r0.transformMap(r5);
        r0.clear();
        r0.decorated().putAll(r6);
    L5:
        return r0;
    }

    public static <K, V> TransformedSortedMap<K, V> transformingSortedMap(SortedMap<K, V> r2, Transformer<? super K, ? extends K> r3, Transformer<? super V, ? extends V> r4) {
        return new TransformedSortedMap((SortedMap) ZeusTransformUtils.wrapperContextForParams(r2, SortedMap.class, "com.obric.memorydata.plugin"), (Transformer) ZeusTransformUtils.wrapperContextForParams(r3, Transformer.class, "com.obric.memorydata.plugin"), (Transformer) ZeusTransformUtils.wrapperContextForParams(r4, Transformer.class, "com.obric.memorydata.plugin"));
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
    public SortedMap<K, V> headMap(K r3) {
        return new TransformedSortedMap(getSortedMap().headMap(r3), this.keyTransformer, this.valueTransformer);
    }

    @Override // java.util.SortedMap
    public K lastKey() {
        return getSortedMap().lastKey();
    }

    @Override // java.util.SortedMap
    public SortedMap<K, V> subMap(K r2, K r3) {
        return new TransformedSortedMap(getSortedMap().subMap(r2, r3), this.keyTransformer, this.valueTransformer);
    }

    @Override // java.util.SortedMap
    public SortedMap<K, V> tailMap(K r3) {
        return new TransformedSortedMap(getSortedMap().tailMap(r3), this.keyTransformer, this.valueTransformer);
    }
}
