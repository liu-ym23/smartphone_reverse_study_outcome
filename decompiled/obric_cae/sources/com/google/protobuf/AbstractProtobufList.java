package com.google.protobuf;

import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
abstract class AbstractProtobufList<E> extends AbstractList<E> implements Internal.ProtobufList<E> {
    protected static final int DEFAULT_CAPACITY = 10;
    private boolean isMutable;

    public AbstractProtobufList() {
        this(true);
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int r8, E r10) {
        ensureIsMutable();
        super.add(r8, r10);
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int r8, Collection<? extends E> r10) {
        ensureIsMutable();
        return super.addAll(r8, r10);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        ensureIsMutable();
        super.clear();
    }

    public void ensureIsMutable() {
        if (this.isMutable == false) goto L6;
        return;
    L6:
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof List) == true) goto L9;
        return false;
    L9:
        if ((r8 instanceof RandomAccess) == false) goto L11;
        List r10 = (List) r8;
        int r11 = size();
        if (r11 == r10.size()) goto L15;
        return false;
    L15:
        int r12 = 0;
    L16:
        if (r12 >= r11) goto L21;
        if (get(r12).equals(r10.get(r12)) == false) goto L19;
        r12 = r12 + 1;
        goto L16
    L19:
        return false;
    L21:
        return true;
    L11:
        return super.equals(r8);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int r8 = size();
        int r10 = 1;
        int r11 = 0;
    L3:
        if (r11 >= r8) goto L5;
        r10 = (r10 * 31) + get(r11).hashCode();
        r11 = r11 + 1;
        goto L3
    L5:
        return r10;
    }

    @Override // com.google.protobuf.Internal.ProtobufList
    public boolean isModifiable() {
        return this.isMutable;
    }

    @Override // com.google.protobuf.Internal.ProtobufList
    public void makeImmutable() {
        if (this.isMutable == false) goto L6;
        this.isMutable = false;
        return;
    }

    @Override // java.util.AbstractList, java.util.List
    public E remove(int r8) {
        ensureIsMutable();
        return (E) super.remove(r8);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection<?> r8) {
        ensureIsMutable();
        return super.removeAll(r8);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection<?> r8) {
        ensureIsMutable();
        return super.retainAll(r8);
    }

    @Override // java.util.AbstractList, java.util.List
    public E set(int r8, E r10) {
        ensureIsMutable();
        return (E) super.set(r8, r10);
    }

    public AbstractProtobufList(boolean r8) {
        this.isMutable = r8;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E r8) {
        ensureIsMutable();
        return super.add(r8);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends E> r8) {
        ensureIsMutable();
        return super.addAll(r8);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object r8) {
        ensureIsMutable();
        int r10 = indexOf(r8);
        if (r10 != (-1)) goto L6;
        return false;
    L6:
        remove(r10);
        return true;
    }
}
