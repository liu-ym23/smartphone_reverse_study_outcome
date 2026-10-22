package com.google.common.collect;

import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
final class JdkBackedImmutableSet<E> extends IndexedImmutableSet<E> {
    private final Set<?> delegate;
    private final ImmutableList<E> delegateList;

    public JdkBackedImmutableSet(Set<?> r5, ImmutableList<E> r10) {
        this.delegate = r5;
        this.delegateList = r10;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object r5) {
        return this.delegate.contains(r5);
    }

    @Override // com.google.common.collect.IndexedImmutableSet
    public E get(int r5) {
        return this.delegateList.get(r5);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.delegateList.size();
    }
}
