package com.google.common.collect;

import java.io.Serializable;
import java.lang.Enum;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes2.dex */
final class ImmutableEnumSet<E extends Enum<E>> extends ImmutableSet<E> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final transient EnumSet f8817b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient int f8818c;

    public static class EnumSerializedForm<E extends Enum<E>> implements Serializable {
        private static final long serialVersionUID = 0;
        final EnumSet<E> delegate;

        public EnumSerializedForm(EnumSet<E> r5) {
            this.delegate = r5;
        }

        public Object readResolve() {
            return new ImmutableEnumSet(this.delegate.clone(), null);
        }
    }

    public /* synthetic */ ImmutableEnumSet(EnumSet r5, t3 r10) {
        this(r5);
    }

    public static ImmutableSet asImmutable(EnumSet r5) {
        int r10 = r5.size();
        if (r10 == 0) goto L11;
        if (r10 == 1) goto L9;
        return new ImmutableEnumSet(r5);
    L9:
        return ImmutableSet.of(p7.H(r5));
    L11:
        return ImmutableSet.of();
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object r5) {
        return this.f8817b.contains(r5);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> r5) {
        if ((r5 instanceof ImmutableEnumSet) == false) goto L6;
        r5 = ((ImmutableEnumSet) r5).f8817b;
    L6:
        return this.f8817b.containsAll(r5);
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof ImmutableEnumSet) == false) goto L9;
        r5 = ((ImmutableEnumSet) r5).f8817b;
    L9:
        return this.f8817b.equals(r5);
    }

    @Override // java.lang.Iterable
    public void forEach(Consumer<? super E> r5) {
        this.f8817b.forEach(r5);
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public int hashCode() {
        int r5 = this.f8818c;
        if (r5 != 0) goto L6;
        int r10 = this.f8817b.hashCode();
        this.f8818c = r10;
        return r10;
    L6:
        return r5;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f8817b.isEmpty();
    }

    @Override // com.google.common.collect.ImmutableSet
    public boolean isHashCodeFast() {
        return true;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return iterator();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.f8817b.size();
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.lang.Iterable
    public Spliterator<E> spliterator() {
        return this.f8817b.spliterator();
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return this.f8817b.toString();
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
    public Object writeReplace() {
        return new EnumSerializedForm(this.f8817b);
    }

    public ImmutableEnumSet(EnumSet r5) {
        this.f8817b = r5;
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public ga iterator() {
        return p7.w0(this.f8817b.iterator());
    }
}
