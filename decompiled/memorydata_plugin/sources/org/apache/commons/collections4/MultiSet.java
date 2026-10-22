package org.apache.commons.collections4;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes6.dex */
public interface MultiSet<E> extends Collection<E> {

    public interface Entry<E> {
        int getCount();

        E getElement();
    }

    int add(E r1, int r2);

    Set<Entry<E>> entrySet();

    @Override // java.util.Collection
    boolean equals(Object r1);

    int getCount(Object r1);

    @Override // java.util.Collection
    int hashCode();

    @Override // java.util.Collection, java.lang.Iterable
    Iterator<E> iterator();

    int remove(Object r1, int r2);

    int setCount(E r1, int r2);

    @Override // java.util.Collection
    int size();

    Set<E> uniqueSet();
}
