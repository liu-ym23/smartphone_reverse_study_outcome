package com.google.common.cache;

import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes2.dex */
public final class h0 extends AbstractCollection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q0 f8718a;

    public h0(q0 r5) {
        this.f8718a = r5;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        this.f8718a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object r5) {
        return this.f8718a.containsValue(r5);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return this.f8718a.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new u(this.f8718a, 2);
    }

    @Override // java.util.Collection
    public final boolean removeIf(Predicate r5) {
        r5.getClass();
        v r10 = new v(r5, 1);
        return this.f8718a.h(r10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        return this.f8718a.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray() {
        return q0.a(this).toArray();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray(Object[] r5) {
        return q0.a(this).toArray(r5);
    }
}
