package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes2.dex */
public final class v7 extends j0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g0 f9198c;

    public v7(g0 r5) {
        this.f9198c = r5;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        this.f9198c.clear();
    }

    @Override // com.google.common.collect.j0, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object r5) {
        return this.f9198c.containsKey(r5);
    }

    @Override // com.google.common.collect.z7
    public final int count(Object r5) {
        Collection r10 = (Collection) p7.l0(this.f9198c.asMap(), r5);
        if (r10 != null) goto L6;
        return 0;
    L6:
        return r10.size();
    }

    @Override // com.google.common.collect.j0
    public final int distinctElements() {
        return this.f9198c.asMap().size();
    }

    @Override // com.google.common.collect.j0
    public final Iterator elementIterator() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.j0, com.google.common.collect.z7
    public final Set elementSet() {
        return this.f9198c.keySet();
    }

    @Override // com.google.common.collect.j0
    public final Iterator entryIterator() {
        return new q0(this.f9198c.asMap().entrySet().iterator(), 2);
    }

    @Override // java.lang.Iterable, com.google.common.collect.z7
    public final void forEach(Consumer r5) {
        r5.getClass();
        this.f9198c.entries().forEach(new t7(r5, 0));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new c7(this.f9198c.entries().iterator());
    }

    @Override // com.google.common.collect.z7
    public final int remove(Object r5, int r10) {
        p7.q(r10, "occurrences");
        if (r10 == 0) goto L5;
        Collection r11 = (Collection) p7.l0(this.f9198c.asMap(), r5);
        int r12 = 0;
        if (r11 != null) goto L9;
        return 0;
    L9:
        int r13 = r11.size();
        if (r10 < r13) goto L12;
        r11.clear();
    L15:
        return r13;
    L12:
        Iterator r14 = r11.iterator();
    L13:
        if (r12 >= r10) goto L15;
        r14.next();
        r14.remove();
        r12 = r12 + 1;
        goto L13
    L5:
        return count(r5);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        return this.f9198c.size();
    }

    @Override // java.util.Collection, java.lang.Iterable, com.google.common.collect.z7
    public final Spliterator spliterator() {
        return p7.R(this.f9198c.entries().spliterator(), new h(19));
    }
}
