package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.Enum;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes2.dex */
final class ImmutableEnumSet<E extends Enum<E>> extends ImmutableSet<E> {
    private final transient EnumSet<E> delegate;
    private transient int hashCode;

    /* JADX INFO: renamed from: com.google.common.collect.ImmutableEnumSet$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class EnumSerializedForm<E extends Enum<E>> implements Serializable {
        private static final long serialVersionUID = 0;
        final EnumSet<E> delegate;

        EnumSerializedForm(EnumSet<E> r1) {
            this.delegate = r1;
        }

        Object readResolve() {
            return new ImmutableEnumSet(this.delegate.clone(), null);
        }
    }

    private ImmutableEnumSet(EnumSet<E> r1) {
        this.delegate = r1;
    }

    /* synthetic */ ImmutableEnumSet(EnumSet r1, AnonymousClass1 r2) {
        this(r1);
    }

    static <E extends Enum<E>> ImmutableSet<E> asImmutable(EnumSet<E> r2) {
        int r0 = r2.size();
        if (r0 == 0) goto L11;
        if (r0 == 1) goto L9;
        return new ImmutableEnumSet(r2);
    L9:
        return ImmutableSet.of((Enum) ZeusTransformUtils.preCheckCast(aj.b(r2), Enum.class, "com.obric.memorydata.plugin"));
    L11:
        return ImmutableSet.of();
    }

    private void readObject(ObjectInputStream r1) {
        throw new InvalidObjectException("Use SerializedForm");
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object r1) {
        return this.delegate.contains(r1);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> r4) {
        Collection r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, ImmutableEnumSet.class) == false) goto L6;
        r5 = ((ImmutableEnumSet) ZeusTransformUtils.preCheckCast(r5, ImmutableEnumSet.class, "com.obric.memorydata.plugin")).delegate;
    L6:
        return this.delegate.containsAll(r5);
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public boolean equals(Object r3) {
        if (r3 != this) goto L7;
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r3, ImmutableEnumSet.class) == false) goto L10;
        r3 = ((ImmutableEnumSet) ZeusTransformUtils.preCheckCast(r3, ImmutableEnumSet.class, "com.obric.memorydata.plugin")).delegate;
    L10:
        return this.delegate.equals(r3);
    }

    @Override // java.lang.Iterable
    public void forEach(Consumer<? super E> r3) {
        Consumer r4 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r3, Consumer.class, "com.obric.memorydata.plugin");
        this.delegate.forEach(r4);
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L6;
        int r1 = this.delegate.hashCode();
        this.hashCode = r1;
        return r1;
    L6:
        return r0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.delegate.isEmpty();
    }

    @Override // com.google.common.collect.ImmutableSet
    boolean isHashCodeFast() {
        return true;
    }

    @Override // com.google.common.collect.ImmutableCollection
    boolean isPartialView() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public bj<E> iterator() {
        return Iterators.a(this.delegate.iterator());
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return iterator();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.delegate.size();
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.lang.Iterable
    public Spliterator<E> spliterator() {
        return this.delegate.spliterator();
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return this.delegate.toString();
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
    Object writeReplace() {
        return new EnumSerializedForm(this.delegate);
    }
}
