package com.google.common.collect;

import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes2.dex */
public final class x extends z implements NavigableSet {
    public final /* synthetic */ AbstractMapBasedMultimap g;

    public x(AbstractMapBasedMultimap r5, Object r10, NavigableSet r11, u r12) {
        this.g = r5;
        super(r5, r10, r11, r12);
    }

    @Override // java.util.NavigableSet
    public final Object ceiling(Object r5) {
        return f().ceiling(r5);
    }

    @Override // java.util.NavigableSet
    public final Iterator descendingIterator() {
        return new m(this, f().descendingIterator());
    }

    @Override // java.util.NavigableSet
    public final NavigableSet descendingSet() {
        return g(f().descendingSet());
    }

    @Override // com.google.common.collect.z
    public final /* bridge */ /* synthetic */ SortedSet e() {
        return f();
    }

    public final NavigableSet f() {
        return (NavigableSet) ((SortedSet) this.f9173b);
    }

    @Override // java.util.NavigableSet
    public final Object floor(Object r5) {
        return f().floor(r5);
    }

    public final x g(NavigableSet r5) {
        u r10 = this.f9174c;
        if (r10 != null) goto L6;
        r10 = this;
    L6:
        return new x(this.g, this.f9172a, r5, r10);
    }

    @Override // java.util.NavigableSet
    public final NavigableSet headSet(Object r5, boolean r10) {
        return g(f().headSet(r5, r10));
    }

    @Override // java.util.NavigableSet
    public final Object higher(Object r5) {
        return f().higher(r5);
    }

    @Override // java.util.NavigableSet
    public final Object lower(Object r5) {
        return f().lower(r5);
    }

    @Override // java.util.NavigableSet
    public final Object pollFirst() {
        return p7.c0(iterator());
    }

    @Override // java.util.NavigableSet
    public final Object pollLast() {
        return p7.c0(descendingIterator());
    }

    @Override // java.util.NavigableSet
    public final NavigableSet subSet(Object r5, boolean r10, Object r11, boolean r12) {
        return g(f().subSet(r5, r10, r11, r12));
    }

    @Override // java.util.NavigableSet
    public final NavigableSet tailSet(Object r5, boolean r10) {
        return g(f().tailSet(r5, r10));
    }
}
