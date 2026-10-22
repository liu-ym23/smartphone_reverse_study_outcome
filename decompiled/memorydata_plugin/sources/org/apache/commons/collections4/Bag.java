package org.apache.commons.collections4;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes6.dex */
public interface Bag<E> extends Collection<E> {
    boolean add(E r1, int r2);

    int getCount(Object r1);

    @Override // java.util.Collection, java.lang.Iterable
    Iterator<E> iterator();

    boolean remove(Object r1, int r2);

    @Override // java.util.Collection
    boolean removeAll(Collection<?> r1);

    @Override // java.util.Collection
    boolean retainAll(Collection<?> r1);

    @Override // java.util.Collection
    int size();

    Set<E> uniqueSet();
}
