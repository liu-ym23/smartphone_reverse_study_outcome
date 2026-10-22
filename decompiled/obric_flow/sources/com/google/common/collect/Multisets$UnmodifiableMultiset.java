package com.google.common.collect;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.ObjIntConsumer;

/* JADX INFO: loaded from: classes2.dex */
class Multisets$UnmodifiableMultiset<E> extends y2 implements Serializable {
    private static final long serialVersionUID = 0;
    final z7 delegate;
    transient Set<E> elementSet;
    transient Set<y7> entrySet;

    public Multisets$UnmodifiableMultiset(z7 r5) {
        this.delegate = r5;
    }

    @Override // com.google.common.collect.t2, java.util.Collection, java.util.Queue
    public boolean add(E r5) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.t2, java.util.Collection
    public boolean addAll(Collection<? extends E> r5) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.t2, java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException();
    }

    public Set<E> createElementSet() {
        return Collections.unmodifiableSet(this.delegate.elementSet());
    }

    @Override // com.google.common.collect.z2
    public /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.z7
    public Set<E> elementSet() {
        Set<E> r5 = this.elementSet;
        if (r5 != null) goto L6;
        Set<E> r10 = createElementSet();
        this.elementSet = r10;
        return r10;
    L6:
        return r5;
    }

    @Override // com.google.common.collect.z7
    public Set<y7> entrySet() {
        Set<y7> r5 = this.entrySet;
        if (r5 != null) goto L6;
        Set<y7> r10 = Collections.unmodifiableSet(this.delegate.entrySet());
        this.entrySet = r10;
        return r10;
    L6:
        return r5;
    }

    @Override // java.lang.Iterable, com.google.common.collect.z7
    public /* bridge */ /* synthetic */ void forEach(Consumer r5) {
        super.forEach(r5);
    }

    @Override // com.google.common.collect.z7
    public /* bridge */ /* synthetic */ void forEachEntry(ObjIntConsumer r5) {
        super.forEachEntry(r5);
    }

    @Override // com.google.common.collect.t2, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return p7.w0(this.delegate.iterator());
    }

    @Override // com.google.common.collect.t2, java.util.Collection
    public boolean remove(Object r5) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.t2, java.util.Collection
    public boolean removeAll(Collection<?> r5) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.t2, java.util.Collection
    public boolean retainAll(Collection<?> r5) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.y2, com.google.common.collect.z7
    public int setCount(E r5, int r10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection, java.lang.Iterable, com.google.common.collect.z7
    public /* bridge */ /* synthetic */ Spliterator spliterator() {
        return super.spliterator();
    }

    @Override // com.google.common.collect.y2, com.google.common.collect.z7
    public int add(E r5, int r10) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.t2, com.google.common.collect.z2
    public /* bridge */ /* synthetic */ Collection delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.y2, com.google.common.collect.z7
    public int remove(Object r5, int r10) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.y2, com.google.common.collect.z7
    public boolean setCount(E r5, int r10, int r11) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.y2, com.google.common.collect.t2, com.google.common.collect.z2
    public z7 delegate() {
        return this.delegate;
    }
}
