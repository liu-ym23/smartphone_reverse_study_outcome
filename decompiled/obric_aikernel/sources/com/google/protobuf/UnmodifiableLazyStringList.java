package com.google.protobuf;

import java.util.AbstractList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class UnmodifiableLazyStringList extends AbstractList<String> implements LazyStringList, RandomAccess {
    private final LazyStringList list;

    public UnmodifiableLazyStringList(LazyStringList r10) {
        this.list = r10;
    }

    static /* synthetic */ LazyStringList access$000(UnmodifiableLazyStringList r10) {
        return r10.list;
    }

    @Override // com.google.protobuf.LazyStringList
    public void add(ByteString r10) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.protobuf.LazyStringList
    public void add(byte[] r10) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.protobuf.LazyStringList
    public boolean addAllByteArray(Collection<byte[]> r10) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.protobuf.LazyStringList
    public boolean addAllByteString(Collection<? extends ByteString> r10) {
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
    public /* bridge */ /* synthetic */ Object get(int r10) {
        return get(r10);
    }

    @Override // java.util.AbstractList, java.util.List
    public String get(int r10) {
        return this.list.get(r10);
    }

    @Override // com.google.protobuf.LazyStringList
    public byte[] getByteArray(int r10) {
        return this.list.getByteArray(r10);
    }

    @Override // com.google.protobuf.LazyStringList
    public ByteString getByteString(int r10) {
        return this.list.getByteString(r10);
    }

    @Override // com.google.protobuf.LazyStringList
    public Object getRaw(int r10) {
        return this.list.getRaw(r10);
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
    public ListIterator<String> listIterator(final int r10) {
        return new AnonymousClass1(this, r10);
    }

    @Override // com.google.protobuf.LazyStringList
    public void mergeFrom(LazyStringList r10) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.protobuf.LazyStringList
    public void set(int r10, ByteString r11) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.protobuf.LazyStringList
    public void set(int r10, byte[] r11) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.list.size();
    }
}
