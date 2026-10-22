package androidx.room.jarjarred.kotlinx.metadata.internal.protobuf;

import java.util.AbstractList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
public class UnmodifiableLazyStringList extends AbstractList<String> implements LazyStringList, RandomAccess {
    private final LazyStringList list;

    public UnmodifiableLazyStringList(LazyStringList r5) {
        this.list = r5;
    }

    public static /* synthetic */ LazyStringList access$000(UnmodifiableLazyStringList r5) {
        return r5.list;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.LazyStringList
    public void add(ByteString r5) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.LazyStringList
    public boolean addAllByteArray(Collection<byte[]> r5) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.LazyStringList
    public boolean addAllByteString(Collection<? extends ByteString> r5) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.LazyStringList
    public List<byte[]> asByteArrayList() {
        return Collections.unmodifiableList(this.list.asByteArrayList());
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.ProtocolStringList
    public List<ByteString> asByteStringList() {
        return Collections.unmodifiableList(this.list.asByteStringList());
    }

    @Override // java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object get(int r5) {
        return get(r5);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.LazyStringList
    public byte[] getByteArray(int r5) {
        return this.list.getByteArray(r5);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.LazyStringList
    public ByteString getByteString(int r5) {
        return this.list.getByteString(r5);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.LazyStringList
    public List<?> getUnderlyingElements() {
        return this.list.getUnderlyingElements();
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.LazyStringList
    public LazyStringList getUnmodifiableView() {
        return this;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<String> iterator() {
        return new AnonymousClass2(this);
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<String> listIterator(final int r5) {
        return new AnonymousClass1(this, r5);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.LazyStringList
    public void mergeFrom(LazyStringList r5) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.LazyStringList
    public void set(int r5, ByteString r10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.list.size();
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.LazyStringList
    public void add(byte[] r5) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractList, java.util.List
    public String get(int r5) {
        return this.list.get(r5);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.LazyStringList
    public void set(int r5, byte[] r10) {
        throw new UnsupportedOperationException();
    }
}
