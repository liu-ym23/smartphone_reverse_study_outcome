package com.google.protobuf;

import java.util.AbstractList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class UnmodifiableLazyStringList extends AbstractList<String> implements LazyStringList, RandomAccess {
    private final LazyStringList list;

    public UnmodifiableLazyStringList(LazyStringList r8) {
        this.list = r8;
    }

    public static /* synthetic */ LazyStringList access$000(UnmodifiableLazyStringList r8) {
        return r8.list;
    }

    @Override // com.google.protobuf.LazyStringList
    public void add(ByteString r8) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.protobuf.LazyStringList
    public boolean addAllByteArray(Collection<byte[]> r8) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.protobuf.LazyStringList
    public boolean addAllByteString(Collection<? extends ByteString> r8) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.protobuf.LazyStringList
    public List<byte[]> asByteArrayList() {
        return Collections.unmodifiableList(this.list.asByteArrayList());
    }

    @Override // com.google.protobuf.ProtocolStringList
    public List<ByteString> asByteStringList() {
        return Collections.unmodifiableList(this.list.asByteStringList());
    }

    @Override // java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object get(int r8) {
        return get(r8);
    }

    @Override // com.google.protobuf.LazyStringList
    public byte[] getByteArray(int r8) {
        return this.list.getByteArray(r8);
    }

    @Override // com.google.protobuf.LazyStringList
    public ByteString getByteString(int r8) {
        return this.list.getByteString(r8);
    }

    @Override // com.google.protobuf.LazyStringList
    public Object getRaw(int r8) {
        return this.list.getRaw(r8);
    }

    @Override // com.google.protobuf.LazyStringList
    public List<?> getUnderlyingElements() {
        return this.list.getUnderlyingElements();
    }

    @Override // com.google.protobuf.LazyStringList
    public LazyStringList getUnmodifiableView() {
        return this;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<String> iterator() {
        return new AnonymousClass2(this);
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<String> listIterator(final int r8) {
        return new AnonymousClass1(this, r8);
    }

    @Override // com.google.protobuf.LazyStringList
    public void mergeFrom(LazyStringList r8) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.protobuf.LazyStringList
    public void set(int r8, ByteString r10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.list.size();
    }

    @Override // com.google.protobuf.LazyStringList
    public void add(byte[] r8) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractList, java.util.List
    public String get(int r8) {
        return this.list.get(r8);
    }

    @Override // com.google.protobuf.LazyStringList
    public void set(int r8, byte[] r10) {
        throw new UnsupportedOperationException();
    }
}
