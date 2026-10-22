package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;

/* JADX INFO: loaded from: classes2.dex */
public abstract class af<K, V> extends y<K, V> implements SortedMap<K, V> {
    public af() {
    }

    static int unsafeCompare(Comparator<?> r2, Object r3, Object r4) {
        Comparator r5 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r2, Comparator.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L7;
        return ((Comparable) ZeusTransformUtils.preCheckCast(r3, Comparable.class, "com.obric.memorydata.plugin")).compareTo(r4);
    L7:
        return r5.compare(r3, r4);
    }

    @Override // java.util.SortedMap
    public Comparator<? super K> comparator() {
        return delegate().comparator();
    }

    @Override // com.google.common.collect.y, com.google.common.collect.ac
    public /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.y, com.google.common.collect.ac
    public /* bridge */ /* synthetic */ Map delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.y, com.google.common.collect.ac
    public abstract SortedMap<K, V> delegate();

    @Override // java.util.SortedMap
    public K firstKey() {
        return delegate().firstKey();
    }

    public SortedMap<K, V> headMap(K r1) {
        return delegate().headMap(r1);
    }

    @Override // java.util.SortedMap
    public K lastKey() {
        return delegate().lastKey();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.y
    public boolean standardContainsKey(Object r3) {
        K r1 = tailMap(r3).firstKey();     // Catch: Throwable -> L7
        if (unsafeCompare(comparator(), r1, r3) != 0) goto L10;
        return true;
    L10:
        return false;
    L11:
        return false;
    }

    public SortedMap<K, V> standardSubMap(K r3, K r4) {
        if (unsafeCompare(comparator(), r3, r4) > 0) goto L5;
        boolean r0 = true;
    L6:
        com.google.common.base.n.a(r0, "fromKey must be <= toKey");
        return tailMap(r3).headMap(r4);
    L5:
        r0 = false;
        goto L6
    }

    public SortedMap<K, V> subMap(K r1, K r2) {
        return delegate().subMap(r1, r2);
    }

    public SortedMap<K, V> tailMap(K r1) {
        return delegate().tailMap(r1);
    }
}
