package com.google.common.collect;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public abstract class j0 extends AbstractCollection implements z7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient Set f9030a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient Set f9031b;

    public j0() {
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean add(Object r5) {
        add(r5, 1);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean addAll(Collection<Object> r5) {
        return p7.k(this, r5);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object r5) {
        if (count(r5) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public Set<Object> createElementSet() {
        return new h0(this);
    }

    public Set<y7> createEntrySet() {
        return new i0(this, 0);
    }

    public abstract int distinctElements();

    public abstract Iterator elementIterator();

    public Set<Object> elementSet() {
        Set<Object> r5 = this.f9030a;
        if (r5 != null) goto L6;
        Set<Object> r10 = createElementSet();
        this.f9030a = r10;
        return r10;
    L6:
        return r5;
    }

    public abstract Iterator entryIterator();

    public Set entrySet() {
        Set r5 = this.f9031b;
        if (r5 != null) goto L6;
        Set<y7> r10 = createEntrySet();
        this.f9031b = r10;
        return r10;
    L6:
        return r5;
    }

    @Override // java.util.Collection, com.google.common.collect.z7
    public final boolean equals(Object r5) {
        return p7.z(this, r5);
    }

    @Override // java.util.Collection, com.google.common.collect.z7
    public final int hashCode() {
        return entrySet().hashCode();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return entrySet().isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean remove(Object r5) {
        if (remove(r5, 1) > 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean removeAll(Collection<?> r5) {
        if ((r5 instanceof z7) == false) goto L6;
        r5 = ((z7) r5).elementSet();
    L6:
        return elementSet().removeAll(r5);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean retainAll(Collection<?> r5) {
        r5.getClass();
        if ((r5 instanceof z7) == false) goto L6;
        r5 = ((z7) r5).elementSet();
    L6:
        return elementSet().retainAll(r5);
    }

    public int setCount(Object r5, int r10) {
        p7.q(r10, "count");
        int r11 = count(r5);
        int r12 = r10 - r11;
        if (r12 <= 0) goto L5;
        add(r5, r12);
    L7:
        return r11;
    L5:
        if (r12 >= 0) goto L7;
        remove(r5, -r12);
        goto L7
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        return entrySet().toString();
    }

    public int add(Object r5, int r10) {
        throw new UnsupportedOperationException();
    }

    public boolean setCount(Object r5, int r10, int r11) {
        p7.q(r10, "oldCount");
        p7.q(r11, "newCount");
        if (count(r5) != r10) goto L5;
        setCount(r5, r11);
        return true;
    L5:
        return false;
    }
}
