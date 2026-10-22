package com.google.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.AbstractList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class UnmodifiableLazyStringList extends AbstractList<String> implements LazyStringList, RandomAccess {
    private final LazyStringList list;

    public UnmodifiableLazyStringList(LazyStringList r3) {
        this.list = (LazyStringList) ZeusTransformUtils.wrapperContextForParams(r3, LazyStringList.class, "com.obric.memorydata.plugin");
    }

    static /* synthetic */ LazyStringList access$000(UnmodifiableLazyStringList r0) {
        return r0.list;
    }

    @Override // com.google.protobuf.LazyStringList
    public void add(ByteString r1) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.protobuf.LazyStringList
    public void add(byte[] r1) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.protobuf.LazyStringList
    public boolean addAllByteArray(Collection<byte[]> r2) {
        Collection r1 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
        throw new UnsupportedOperationException();
    }

    @Override // com.google.protobuf.LazyStringList
    public boolean addAllByteString(Collection<? extends ByteString> r2) {
        Collection r1 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
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
    public /* bridge */ /* synthetic */ Object get(int r1) {
        return get(r1);
    }

    @Override // java.util.AbstractList, java.util.List
    public String get(int r2) {
        return (String) ZeusTransformUtils.preCheckCast(this.list.get(r2), String.class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.protobuf.LazyStringList
    public byte[] getByteArray(int r1) {
        return this.list.getByteArray(r1);
    }

    @Override // com.google.protobuf.LazyStringList
    public ByteString getByteString(int r1) {
        return this.list.getByteString(r1);
    }

    @Override // com.google.protobuf.LazyStringList
    public Object getRaw(int r1) {
        return this.list.getRaw(r1);
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
    public ListIterator<String> listIterator(final int r2) {
        return new AnonymousClass1(this, r2);
    }

    @Override // com.google.protobuf.LazyStringList
    public void mergeFrom(LazyStringList r2) {
        LazyStringList r1 = (LazyStringList) ZeusTransformUtils.wrapperContextForParams(r2, LazyStringList.class, "com.obric.memorydata.plugin");
        throw new UnsupportedOperationException();
    }

    @Override // com.google.protobuf.LazyStringList
    public void set(int r1, ByteString r2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.protobuf.LazyStringList
    public void set(int r1, byte[] r2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.list.size();
    }
}
