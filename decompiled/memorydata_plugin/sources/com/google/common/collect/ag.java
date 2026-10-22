package com.google.common.collect;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ag<E> extends ae<E> implements SortedSet<E> {
    public ag() {
    }

    @Override // java.util.SortedSet
    public Comparator<? super E> comparator() {
        return delegate().comparator();
    }

    @Override // com.google.common.collect.ae, com.google.common.collect.v, com.google.common.collect.ac
    public /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.ae, com.google.common.collect.v, com.google.common.collect.ac
    public /* bridge */ /* synthetic */ Collection delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.ae, com.google.common.collect.v, com.google.common.collect.ac
    public /* bridge */ /* synthetic */ Set delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.ae, com.google.common.collect.v, com.google.common.collect.ac
    public abstract SortedSet<E> delegate();

    @Override // java.util.SortedSet
    public E first() {
        return delegate().first();
    }

    @Override // java.util.SortedSet
    public SortedSet<E> headSet(E r1) {
        return delegate().headSet(r1);
    }

    @Override // java.util.SortedSet
    public E last() {
        return delegate().last();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.v
    public boolean standardContains(Object r3) {
        E r1 = tailSet(r3).first();     // Catch: Throwable -> L7
        if (af.unsafeCompare(comparator(), r1, r3) != 0) goto L10;
        return true;
    L10:
        return false;
    L11:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.v
    public boolean standardRemove(Object r4) {
        Iterator<E> r1 = tailSet(r4).iterator();     // Catch: Throwable -> L11
        if (r1.hasNext() == false) goto L10;
        E r2 = r1.next();     // Catch: Throwable -> L11
        if (af.unsafeCompare(comparator(), r2, r4) != 0) goto L10;
        r1.remove();     // Catch: Throwable -> L11
        return true;
    L10:
        return false;
    }

    public SortedSet<E> standardSubSet(E r1, E r2) {
        return tailSet(r1).headSet(r2);
    }

    @Override // java.util.SortedSet
    public SortedSet<E> subSet(E r1, E r2) {
        return delegate().subSet(r1, r2);
    }

    @Override // java.util.SortedSet
    public SortedSet<E> tailSet(E r1) {
        return delegate().tailSet(r1);
    }
}
