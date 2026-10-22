package org.apache.commons.collections4.map;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Comparator;
import java.util.SortedMap;
import org.apache.commons.collections4.Predicate;

/* JADX INFO: loaded from: classes6.dex */
public class PredicatedSortedMap<K, V> extends PredicatedMap<K, V> implements SortedMap<K, V> {
    private static final long serialVersionUID = 3359846175935304332L;

    public PredicatedSortedMap(SortedMap<K, V> r3, Predicate<? super K> r4, Predicate<? super V> r5) {
        super((SortedMap) ZeusTransformUtils.wrapperContextForParams(r3, SortedMap.class, "com.obric.memorydata.plugin"), (Predicate) ZeusTransformUtils.wrapperContextForParams(r4, Predicate.class, "com.obric.memorydata.plugin"), (Predicate) ZeusTransformUtils.wrapperContextForParams(r5, Predicate.class, "com.obric.memorydata.plugin"));
    }

    public static <K, V> PredicatedSortedMap<K, V> predicatedSortedMap(SortedMap<K, V> r2, Predicate<? super K> r3, Predicate<? super V> r4) {
        return new PredicatedSortedMap((SortedMap) ZeusTransformUtils.wrapperContextForParams(r2, SortedMap.class, "com.obric.memorydata.plugin"), (Predicate) ZeusTransformUtils.wrapperContextForParams(r3, Predicate.class, "com.obric.memorydata.plugin"), (Predicate) ZeusTransformUtils.wrapperContextForParams(r4, Predicate.class, "com.obric.memorydata.plugin"));
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
        return new PredicatedSortedMap(getSortedMap().headMap(r3), this.keyPredicate, this.valuePredicate);
    }

    @Override // java.util.SortedMap
    public K lastKey() {
        return getSortedMap().lastKey();
    }

    @Override // java.util.SortedMap
    public SortedMap<K, V> subMap(K r2, K r3) {
        return new PredicatedSortedMap(getSortedMap().subMap(r2, r3), this.keyPredicate, this.valuePredicate);
    }

    @Override // java.util.SortedMap
    public SortedMap<K, V> tailMap(K r3) {
        return new PredicatedSortedMap(getSortedMap().tailMap(r3), this.keyPredicate, this.valuePredicate);
    }
}
