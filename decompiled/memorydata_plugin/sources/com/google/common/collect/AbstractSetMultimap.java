package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
abstract class AbstractSetMultimap<K, V> extends AbstractMapBasedMultimap<K, V> implements aw<K, V> {
    private static final long serialVersionUID = 7431625294878419160L;

    public AbstractSetMultimap(Map<K, Collection<V>> r3) {
        super((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.google.common.collect.c, com.google.common.collect.am
    public Map<K, Collection<V>> asMap() {
        return super.asMap();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap
    /* bridge */ /* synthetic */ Collection createCollection() {
        return createCollection();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap
    abstract Set<V> createCollection();

    @Override // com.google.common.collect.AbstractMapBasedMultimap
    /* bridge */ /* synthetic */ Collection createUnmodifiableEmptyCollection() {
        return createUnmodifiableEmptyCollection();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap
    Set<V> createUnmodifiableEmptyCollection() {
        return Collections.emptySet();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.c, com.google.common.collect.am
    public /* bridge */ /* synthetic */ Collection entries() {
        return entries();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.c, com.google.common.collect.am
    public Set<Map.Entry<K, V>> entries() {
        return (Set) ZeusTransformUtils.preCheckCast(super.entries(), Set.class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.common.collect.c, com.google.common.collect.am
    public boolean equals(Object r1) {
        return super.equals(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.am, com.google.common.collect.ak
    public /* bridge */ /* synthetic */ Collection get(Object r1) {
        return get(r1);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.am, com.google.common.collect.ak
    public Set<V> get(K r2) {
        return (Set) ZeusTransformUtils.preCheckCast(super.get(r2), Set.class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.c, com.google.common.collect.am
    public boolean put(K r1, V r2) {
        return super.put(r1, r2);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.am, com.google.common.collect.ak
    public /* bridge */ /* synthetic */ Collection removeAll(Object r1) {
        return removeAll(r1);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.am, com.google.common.collect.ak
    public Set<V> removeAll(Object r2) {
        return (Set) ZeusTransformUtils.preCheckCast(super.removeAll(r2), Set.class, "com.obric.memorydata.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.c, com.google.common.collect.am, com.google.common.collect.ak
    public /* synthetic */ Collection replaceValues(Object r3, Iterable r4) {
        return replaceValues(r3, (Iterable) ZeusTransformUtils.wrapperContextForParams(r4, Iterable.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.c, com.google.common.collect.am, com.google.common.collect.ak
    public Set<V> replaceValues(K r3, Iterable<? extends V> r4) {
        return (Set) ZeusTransformUtils.preCheckCast(super.replaceValues(r3, (Iterable) ZeusTransformUtils.wrapperContextForParams(r4, Iterable.class, "com.obric.memorydata.plugin")), Set.class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap
    <E> Collection<E> unmodifiableCollectionSubclass(Collection<E> r2) {
        return Collections.unmodifiableSet((Set) ZeusTransformUtils.preCheckCast((Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin"), Set.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap
    Collection<V> wrapCollection(K r4, Collection<V> r5) {
        return new AbstractMapBasedMultimap.l(this, r4, (Set) ZeusTransformUtils.preCheckCast((Collection) ZeusTransformUtils.wrapperContextForParams(r5, Collection.class, "com.obric.memorydata.plugin"), Set.class, "com.obric.memorydata.plugin"));
    }
}
