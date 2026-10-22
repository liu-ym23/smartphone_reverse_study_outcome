package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes2.dex */
abstract class IndexedImmutableSet<E> extends ImmutableSet.CachingAsList<E> {
    IndexedImmutableSet() {
    }

    @Override // com.google.common.collect.ImmutableCollection
    int copyIntoArray(Object[] r1, int r2) {
        return asList().copyIntoArray(r1, r2);
    }

    @Override // com.google.common.collect.ImmutableSet.CachingAsList
    ImmutableList<E> createAsList() {
        return new AnonymousClass1(this);
    }

    @Override // java.lang.Iterable
    public void forEach(Consumer<? super E> r4) {
        Consumer r5 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r4, Consumer.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r5);
        int r0 = size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r5.accept(get(r1));
        r1 = r1 + 1;
        goto L3
    }

    abstract E get(int r1);

    @Override // com.google.common.collect.ImmutableSet.CachingAsList, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public bj<E> iterator() {
        return asList().iterator();
    }

    @Override // com.google.common.collect.ImmutableSet.CachingAsList, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return iterator();
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.lang.Iterable
    public Spliterator<E> spliterator() {
        return p.a(size(), 1297, new $$Lambda$JWqlcawkMDz31mCHVR5T5i8cRAs(this));
    }
}
