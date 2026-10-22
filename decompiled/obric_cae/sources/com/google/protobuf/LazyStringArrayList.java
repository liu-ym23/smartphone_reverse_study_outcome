package com.google.protobuf;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
public class LazyStringArrayList extends AbstractProtobufList<String> implements LazyStringList, RandomAccess {

    @Deprecated
    public static final LazyStringList EMPTY = null;
    private static final LazyStringArrayList EMPTY_LIST = null;
    private final List<Object> list;

    public static class ByteArrayListView extends AbstractList<byte[]> implements RandomAccess {
        private final LazyStringArrayList list;

        public ByteArrayListView(LazyStringArrayList r8) {
            this.list = r8;
        }

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ void add(int r8, Object r10) {
            add(r8, (byte[]) r10);
        }

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object get(int r8) {
            return get(r8);
        }

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object remove(int r8) {
            return remove(r8);
        }

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object set(int r8, Object r10) {
            return set(r8, (byte[]) r10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.list.size();
        }

        public void add(int r8, byte[] r10) {
            LazyStringArrayList.access$200(this.list, r8, r10);
            ((AbstractList) this).modCount++;
        }

        @Override // java.util.AbstractList, java.util.List
        public byte[] get(int r8) {
            return this.list.getByteArray(r8);
        }

        @Override // java.util.AbstractList, java.util.List
        public byte[] remove(int r8) {
            String r10 = this.list.remove(r8);
            ((AbstractList) this).modCount++;
            return LazyStringArrayList.access$100(r10);
        }

        public byte[] set(int r8, byte[] r10) {
            Object r11 = LazyStringArrayList.access$000(this.list, r8, r10);
            ((AbstractList) this).modCount++;
            return LazyStringArrayList.access$100(r11);
        }
    }

    public static class ByteStringListView extends AbstractList<ByteString> implements RandomAccess {
        private final LazyStringArrayList list;

        public ByteStringListView(LazyStringArrayList r8) {
            this.list = r8;
        }

        public void add(int r8, ByteString r10) {
            LazyStringArrayList.access$500(this.list, r8, r10);
            ((AbstractList) this).modCount++;
        }

        @Override // java.util.AbstractList, java.util.List
        public ByteString get(int r8) {
            return this.list.getByteString(r8);
        }

        @Override // java.util.AbstractList, java.util.List
        public ByteString remove(int r8) {
            String r10 = this.list.remove(r8);
            ((AbstractList) this).modCount++;
            return LazyStringArrayList.access$400(r10);
        }

        public ByteString set(int r8, ByteString r10) {
            Object r11 = LazyStringArrayList.access$300(this.list, r8, r10);
            ((AbstractList) this).modCount++;
            return LazyStringArrayList.access$400(r11);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.list.size();
        }

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ void add(int r8, Object r10) {
            add(r8, (ByteString) r10);
        }

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object get(int r8) {
            return get(r8);
        }

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object remove(int r8) {
            return remove(r8);
        }

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object set(int r8, Object r10) {
            return set(r8, (ByteString) r10);
        }
    }

    static {
        EMPTY_LIST = new LazyStringArrayList(false);
        EMPTY = emptyList();
    }

    public LazyStringArrayList() {
        this(10);
    }

    public static /* synthetic */ Object access$000(LazyStringArrayList r8, int r10, byte[] r11) {
        return r8.setAndReturn(r10, r11);
    }

    public static /* synthetic */ byte[] access$100(Object r8) {
        return asByteArray(r8);
    }

    public static /* synthetic */ void access$200(LazyStringArrayList r8, int r10, byte[] r11) {
        r8.add(r10, r11);
    }

    public static /* synthetic */ Object access$300(LazyStringArrayList r8, int r10, ByteString r11) {
        return r8.setAndReturn(r10, r11);
    }

    public static /* synthetic */ ByteString access$400(Object r8) {
        return asByteString(r8);
    }

    public static /* synthetic */ void access$500(LazyStringArrayList r8, int r10, ByteString r11) {
        r8.add(r10, r11);
    }

    private void add(int r8, ByteString r10) {
        ensureIsMutable();
        this.list.add(r8, r10);
        ((AbstractList) this).modCount++;
    }

    private static byte[] asByteArray(Object r8) {
        if ((r8 instanceof byte[]) == false) goto L7;
        return (byte[]) r8;
    L7:
        if ((r8 instanceof String) == false) goto L11;
        return Internal.toByteArray((String) r8);
    L11:
        return ((ByteString) r8).toByteArray();
    }

    private static ByteString asByteString(Object r8) {
        if ((r8 instanceof ByteString) == false) goto L7;
        return (ByteString) r8;
    L7:
        if ((r8 instanceof String) == false) goto L11;
        return ByteString.copyFromUtf8((String) r8);
    L11:
        return ByteString.copyFrom((byte[]) r8);
    }

    private static String asString(Object r8) {
        if ((r8 instanceof String) == false) goto L7;
        return (String) r8;
    L7:
        if ((r8 instanceof ByteString) == false) goto L11;
        return ((ByteString) r8).toStringUtf8();
    L11:
        return Internal.toStringUtf8((byte[]) r8);
    }

    public static LazyStringArrayList emptyList() {
        return EMPTY_LIST;
    }

    private Object setAndReturn(int r8, ByteString r10) {
        ensureIsMutable();
        return this.list.set(r8, r10);
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public boolean addAll(int r8, Collection<? extends String> r10) {
        ensureIsMutable();
        if ((r10 instanceof LazyStringList) == false) goto L5;
        r10 = ((LazyStringList) r10).getUnderlyingElements();
    L5:
        boolean r11 = this.list.addAll(r8, r10);
        ((AbstractList) this).modCount++;
        return r11;
    }

    @Override // com.google.protobuf.LazyStringList
    public boolean addAllByteArray(Collection<byte[]> r8) {
        ensureIsMutable();
        boolean r10 = this.list.addAll(r8);
        ((AbstractList) this).modCount++;
        return r10;
    }

    @Override // com.google.protobuf.LazyStringList
    public boolean addAllByteString(Collection<? extends ByteString> r8) {
        ensureIsMutable();
        boolean r10 = this.list.addAll(r8);
        ((AbstractList) this).modCount++;
        return r10;
    }

    @Override // com.google.protobuf.LazyStringList
    public List<byte[]> asByteArrayList() {
        return new ByteArrayListView(this);
    }

    @Override // com.google.protobuf.ProtocolStringList
    public List<ByteString> asByteStringList() {
        return new ByteStringListView(this);
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        ensureIsMutable();
        this.list.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean equals(Object r8) {
        return super.equals(r8);
    }

    @Override // java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object get(int r8) {
        return get(r8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.LazyStringList
    public byte[] getByteArray(int r8) {
        Object r10 = this.list.get(r8);
        byte[] r11 = asByteArray(r10);
        if (r11 == r10) goto L5;
        this.list.set(r8, r11);
    L5:
        return r11;
    }

    @Override // com.google.protobuf.LazyStringList
    public ByteString getByteString(int r8) {
        Object r10 = this.list.get(r8);
        ByteString r11 = asByteString(r10);
        if (r11 == r10) goto L5;
        this.list.set(r8, r11);
    L5:
        return r11;
    }

    @Override // com.google.protobuf.LazyStringList
    public Object getRaw(int r8) {
        return this.list.get(r8);
    }

    @Override // com.google.protobuf.LazyStringList
    public List<?> getUnderlyingElements() {
        return Collections.unmodifiableList(this.list);
    }

    @Override // com.google.protobuf.LazyStringList
    public LazyStringList getUnmodifiableView() {
        if (isModifiable() == true) goto L5;
        return this;
    L5:
        return new UnmodifiableLazyStringList(this);
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.protobuf.AbstractProtobufList, com.google.protobuf.Internal.ProtobufList
    public /* bridge */ /* synthetic */ boolean isModifiable() {
        return super.isModifiable();
    }

    @Override // com.google.protobuf.LazyStringList
    public void mergeFrom(LazyStringList r8) {
        ensureIsMutable();
        Iterator<?> r10 = r8.getUnderlyingElements().iterator();
    L4:
        if (r10.hasNext() == false) goto L9;
        Object r11 = r10.next();
        if ((r11 instanceof byte[]) == true) goto L7;
        this.list.add(r11);
        goto L4
    L7:
        byte[] r12 = (byte[]) r11;
        this.list.add(Arrays.copyOf(r12, r12.length));
        goto L4
    }

    @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
    public /* bridge */ /* synthetic */ Internal.ProtobufList mutableCopyWithCapacity(int r8) {
        return mutableCopyWithCapacity(r8);
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object remove(int r8) {
        return remove(r8);
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean removeAll(Collection r8) {
        return super.removeAll(r8);
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean retainAll(Collection r8) {
        return super.retainAll(r8);
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object set(int r8, Object r10) {
        return set(r8, (String) r10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.list.size();
    }

    public LazyStringArrayList(int r8) {
        this(new ArrayList(r8));
    }

    private Object setAndReturn(int r8, byte[] r10) {
        ensureIsMutable();
        return this.list.set(r8, r10);
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ void add(int r8, Object r10) {
        add(r8, (String) r10);
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends String> r8) {
        return addAll(size(), r8);
    }

    @Override // java.util.AbstractList, java.util.List
    public String get(int r8) {
        Object r10 = this.list.get(r8);
        if ((r10 instanceof String) == false) goto L7;
        return (String) r10;
    L7:
        if ((r10 instanceof ByteString) == false) goto L12;
        ByteString r11 = (ByteString) r10;
        String r12 = r11.toStringUtf8();
        if (r11.isValidUtf8() == false) goto L11;
        this.list.set(r8, r12);
    L11:
        return r12;
    L12:
        byte[] r13 = (byte[]) r10;
        String r14 = Internal.toStringUtf8(r13);
        if (Internal.isValidUtf8(r13) == false) goto L15;
        this.list.set(r8, r14);
    L15:
        return r14;
    }

    @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
    public LazyStringArrayList mutableCopyWithCapacity(int r8) {
        if (r8 < size()) goto L7;
        ArrayList r10 = new ArrayList(r8);
        r10.addAll(this.list);
        return new LazyStringArrayList(r10);
    L7:
        throw new IllegalArgumentException();
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public String remove(int r8) {
        ensureIsMutable();
        Object r10 = this.list.remove(r8);
        ((AbstractList) this).modCount++;
        return asString(r10);
    }

    public String set(int r8, String r10) {
        ensureIsMutable();
        return asString(this.list.set(r8, r10));
    }

    public LazyStringArrayList(LazyStringList r8) {
        this.list = new ArrayList(r8.size());
        addAll(r8);
    }

    public void add(int r8, String r10) {
        ensureIsMutable();
        this.list.add(r8, r10);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean remove(Object r8) {
        return super.remove(r8);
    }

    @Override // com.google.protobuf.LazyStringList
    public void set(int r8, ByteString r10) {
        setAndReturn(r8, r10);
    }

    private LazyStringArrayList(ArrayList<Object> r8) {
        this.list = r8;
    }

    private void add(int r8, byte[] r10) {
        ensureIsMutable();
        this.list.add(r8, r10);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.protobuf.LazyStringList
    public void set(int r8, byte[] r10) {
        setAndReturn(r8, r10);
    }

    public LazyStringArrayList(List<String> r8) {
        this(new ArrayList(r8));
    }

    @Override // com.google.protobuf.LazyStringList
    public void add(ByteString r8) {
        ensureIsMutable();
        this.list.add(r8);
        ((AbstractList) this).modCount++;
    }

    private LazyStringArrayList(boolean r8) {
        super(r8);
        this.list = Collections.emptyList();
    }

    @Override // com.google.protobuf.LazyStringList
    public void add(byte[] r8) {
        ensureIsMutable();
        this.list.add(r8);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean add(Object r8) {
        return add((String) r8);
    }

    @CanIgnoreReturnValue
    public boolean add(String r8) {
        ensureIsMutable();
        this.list.add(r8);
        ((AbstractList) this).modCount++;
        return true;
    }
}
