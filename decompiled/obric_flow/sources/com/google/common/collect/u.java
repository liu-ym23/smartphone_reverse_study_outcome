package com.google.common.collect;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Spliterator;

/* JADX INFO: loaded from: classes2.dex */
public class u extends AbstractCollection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f9172a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Collection f9173b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final u f9174c;
    public final Collection d;
    public final /* synthetic */ AbstractMapBasedMultimap e;

    public u(AbstractMapBasedMultimap r5, Object r10, Collection r11, u r12) {
        this.e = r5;
        this.f9172a = r10;
        this.f9173b = r11;
        this.f9174c = r12;
        if (r12 != null) goto L5;
        Collection r13 = null;
    L6:
        this.d = r13;
        return;
    L5:
        r13 = r12.f9173b;
        goto L6
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean add(Object r5) {
        c();
        boolean r10 = this.f9173b.isEmpty();
        boolean r11 = this.f9173b.add(r5);
        if (r11 == false) goto L7;
        AbstractMapBasedMultimap.access$208(this.e);
        if (r10 == false) goto L7;
        b();
    L7:
        return r11;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean addAll(Collection r5) {
        if (r5.isEmpty() == false) goto L6;
        return false;
    L6:
        int r10 = size();
        boolean r11 = this.f9173b.addAll(r5);
        if (r11 == false) goto L11;
        int r12 = this.f9173b.size();
        AbstractMapBasedMultimap.access$212(this.e, r12 - r10);
        if (r10 != 0) goto L11;
        b();
    L11:
        return r11;
    }

    public final void b() {
        u r5 = this.f9174c;
        if (r5 == null) goto L5;
        r5.b();
        return;
    L5:
        AbstractMapBasedMultimap.access$000(this.e).put(this.f9172a, this.f9173b);
    }

    public final void c() {
        u r5 = this.f9174c;
        if (r5 == null) goto L10;
        r5.c();
        if (r5.f9173b != this.d) goto L8;
        return;
    L8:
        throw new ConcurrentModificationException();
    L10:
        if (this.f9173b.isEmpty() == false) goto L15;
        Collection r10 = (Collection) AbstractMapBasedMultimap.access$000(this.e).get(this.f9172a);
        if (r10 == null) goto L16;
        this.f9173b = r10;
        return;
    L16:
        return;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        int r5 = size();
        if (r5 != 0) goto L5;
        return;
    L5:
        this.f9173b.clear();
        AbstractMapBasedMultimap.access$220(this.e, r5);
        d();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object r5) {
        c();
        return this.f9173b.contains(r5);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean containsAll(Collection r5) {
        c();
        return this.f9173b.containsAll(r5);
    }

    public final void d() {
        u r5 = this.f9174c;
        if (r5 == null) goto L6;
        r5.d();
        return;
    L6:
        if (this.f9173b.isEmpty() == false) goto L10;
        AbstractMapBasedMultimap.access$000(this.e).remove(this.f9172a);
        return;
    }

    @Override // java.util.Collection
    public final boolean equals(Object r5) {
        if (r5 != this) goto L5;
        return true;
    L5:
        c();
        return this.f9173b.equals(r5);
    }

    @Override // java.util.Collection
    public final int hashCode() {
        c();
        return this.f9173b.hashCode();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        c();
        return new m(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean remove(Object r5) {
        c();
        boolean r10 = this.f9173b.remove(r5);
        if (r10 == false) goto L5;
        AbstractMapBasedMultimap.access$210(this.e);
        d();
    L5:
        return r10;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean removeAll(Collection r5) {
        if (r5.isEmpty() == false) goto L6;
        return false;
    L6:
        int r10 = size();
        boolean r11 = this.f9173b.removeAll(r5);
        if (r11 == false) goto L9;
        int r12 = this.f9173b.size();
        AbstractMapBasedMultimap.access$212(this.e, r12 - r10);
        d();
    L9:
        return r11;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean retainAll(Collection r5) {
        r5.getClass();
        int r10 = size();
        boolean r11 = this.f9173b.retainAll(r5);
        if (r11 == false) goto L5;
        int r12 = this.f9173b.size();
        AbstractMapBasedMultimap.access$212(this.e, r12 - r10);
        d();
    L5:
        return r11;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        c();
        return this.f9173b.size();
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Spliterator spliterator() {
        c();
        return this.f9173b.spliterator();
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        c();
        return this.f9173b.toString();
    }
}
