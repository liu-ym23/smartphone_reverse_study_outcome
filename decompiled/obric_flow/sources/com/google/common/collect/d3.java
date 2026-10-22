package com.google.common.collect;

import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d3 extends b3 implements SortedSet {
    public d3() {
    }

    @Override // java.util.SortedSet
    public Comparator<Object> comparator() {
        return delegate().comparator();
    }

    @Override // com.google.common.collect.b3, com.google.common.collect.z2
    public abstract SortedSet delegate();

    @Override // java.util.SortedSet
    public Object first() {
        return delegate().first();
    }

    @Override // java.util.SortedSet
    public SortedSet<Object> headSet(Object r5) {
        return delegate().headSet(r5);
    }

    @Override // java.util.SortedSet
    public Object last() {
        return delegate().last();
    }

    @Override // com.google.common.collect.t2
    public boolean standardContains(Object r5) {
        Object r10 = tailSet(r5).first();     // Catch: Throwable -> L7
        if (c3.unsafeCompare(comparator(), r10, r5) != 0) goto L10;
        return true;
    L10:
        return false;
    L11:
        return false;
    }

    @Override // com.google.common.collect.t2
    public boolean standardRemove(Object r5) {
        Iterator r10 = tailSet(r5).iterator();     // Catch: Throwable -> L11
        if (r10.hasNext() == false) goto L10;
        Object r11 = r10.next();     // Catch: Throwable -> L11
        if (c3.unsafeCompare(comparator(), r11, r5) != 0) goto L10;
        r10.remove();     // Catch: Throwable -> L11
        return true;
    L10:
        return false;
    }

    public SortedSet<Object> standardSubSet(Object r5, Object r10) {
        return tailSet(r5).headSet(r10);
    }

    @Override // java.util.SortedSet
    public SortedSet<Object> subSet(Object r5, Object r10) {
        return delegate().subSet(r5, r10);
    }

    @Override // java.util.SortedSet
    public SortedSet<Object> tailSet(Object r5) {
        return delegate().tailSet(r5);
    }
}
