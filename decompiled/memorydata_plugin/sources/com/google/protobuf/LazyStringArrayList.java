package com.google.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes3.dex */
public class LazyStringArrayList extends AbstractProtobufList<String> implements LazyStringList, RandomAccess {

    @Deprecated
    public static final LazyStringList EMPTY = null;
    private static final LazyStringArrayList EMPTY_LIST = null;
    private final List<Object> list;

    private static class ByteArrayListView extends AbstractList<byte[]> implements RandomAccess {
        private final LazyStringArrayList list;

        ByteArrayListView(LazyStringArrayList r1) {
            this.list = r1;
        }

        @Override // java.util.AbstractList, java.util.List
        public /* synthetic */ void add(int r3, Object r4) {
            add(r3, (byte[]) ZeusTransformUtils.preCheckCast(r4, byte[].class, "com.obric.memorydata.plugin"));
        }

        public void add(int r2, byte[] r3) {
            LazyStringArrayList.access$200(this.list, r2, r3);
            this.modCount++;
        }

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object get(int r1) {
            return get(r1);
        }

        @Override // java.util.AbstractList, java.util.List
        public byte[] get(int r1) {
            return this.list.getByteArray(r1);
        }

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object remove(int r1) {
            return remove(r1);
        }

        @Override // java.util.AbstractList, java.util.List
        public byte[] remove(int r2) {
            String r3 = this.list.remove(r2);
            this.modCount++;
            return LazyStringArrayList.access$100(r3);
        }

        @Override // java.util.AbstractList, java.util.List
        public /* synthetic */ Object set(int r3, Object r4) {
            return set(r3, (byte[]) ZeusTransformUtils.preCheckCast(r4, byte[].class, "com.obric.memorydata.plugin"));
        }

        public byte[] set(int r2, byte[] r3) {
            Object r4 = LazyStringArrayList.access$000(this.list, r2, r3);
            this.modCount++;
            return LazyStringArrayList.access$100(r4);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.list.size();
        }
    }

    private static class ByteStringListView extends AbstractList<ByteString> implements RandomAccess {
        private final LazyStringArrayList list;

        ByteStringListView(LazyStringArrayList r1) {
            this.list = r1;
        }

        public void add(int r2, ByteString r3) {
            LazyStringArrayList.access$500(this.list, r2, r3);
            this.modCount++;
        }

        @Override // java.util.AbstractList, java.util.List
        public /* synthetic */ void add(int r3, Object r4) {
            add(r3, (ByteString) ZeusTransformUtils.preCheckCast(r4, ByteString.class, "com.obric.memorydata.plugin"));
        }

        @Override // java.util.AbstractList, java.util.List
        public ByteString get(int r1) {
            return this.list.getByteString(r1);
        }

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object get(int r1) {
            return get(r1);
        }

        @Override // java.util.AbstractList, java.util.List
        public ByteString remove(int r2) {
            String r3 = this.list.remove(r2);
            this.modCount++;
            return LazyStringArrayList.access$400(r3);
        }

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object remove(int r1) {
            return remove(r1);
        }

        public ByteString set(int r2, ByteString r3) {
            Object r4 = LazyStringArrayList.access$300(this.list, r2, r3);
            this.modCount++;
            return LazyStringArrayList.access$400(r4);
        }

        @Override // java.util.AbstractList, java.util.List
        public /* synthetic */ Object set(int r3, Object r4) {
            return set(r3, (ByteString) ZeusTransformUtils.preCheckCast(r4, ByteString.class, "com.obric.memorydata.plugin"));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.list.size();
        }
    }

    static {
        EMPTY_LIST = new LazyStringArrayList(false);
        EMPTY = emptyList();
    }

    public LazyStringArrayList() {
        this(10);
    }

    public LazyStringArrayList(int r2) {
        this(new ArrayList(r2));
    }

    public LazyStringArrayList(LazyStringList r3) {
        LazyStringList r4 = (LazyStringList) ZeusTransformUtils.wrapperContextForParams(r3, LazyStringList.class, "com.obric.memorydata.plugin");
        this.list = new ArrayList(r4.size());
        addAll(r4);
    }

    private LazyStringArrayList(ArrayList<Object> r1) {
        this.list = r1;
    }

    public LazyStringArrayList(List<String> r3) {
        this(new ArrayList((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin")));
    }

    private LazyStringArrayList(boolean r1) {
        super(r1);
        this.list = Collections.emptyList();
    }

    static /* synthetic */ Object access$000(LazyStringArrayList r0, int r1, byte[] r2) {
        return r0.setAndReturn(r1, r2);
    }

    static /* synthetic */ byte[] access$100(Object r0) {
        return asByteArray(r0);
    }

    static /* synthetic */ void access$200(LazyStringArrayList r0, int r1, byte[] r2) {
        r0.add(r1, r2);
    }

    static /* synthetic */ Object access$300(LazyStringArrayList r0, int r1, ByteString r2) {
        return r0.setAndReturn(r1, r2);
    }

    static /* synthetic */ ByteString access$400(Object r0) {
        return asByteString(r0);
    }

    static /* synthetic */ void access$500(LazyStringArrayList r0, int r1, ByteString r2) {
        r0.add(r1, r2);
    }

    private void add(int r2, ByteString r3) {
        ensureIsMutable();
        this.list.add(r2, r3);
        this.modCount++;
    }

    private void add(int r2, byte[] r3) {
        ensureIsMutable();
        this.list.add(r2, r3);
        this.modCount++;
    }

    private static byte[] asByteArray(Object r2) {
        if ((r2 instanceof byte[]) == false) goto L7;
        return (byte[]) ZeusTransformUtils.preCheckCast(r2, byte[].class, "com.obric.memorydata.plugin");
    L7:
        if (ZeusTransformUtils.instanceOf(r2, String.class) == false) goto L11;
        return Internal.toByteArray((String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.memorydata.plugin"));
    L11:
        return ((ByteString) ZeusTransformUtils.preCheckCast(r2, ByteString.class, "com.obric.memorydata.plugin")).toByteArray();
    }

    private static ByteString asByteString(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, ByteString.class) == false) goto L7;
        return (ByteString) ZeusTransformUtils.preCheckCast(r2, ByteString.class, "com.obric.memorydata.plugin");
    L7:
        if (ZeusTransformUtils.instanceOf(r2, String.class) == false) goto L11;
        return ByteString.copyFromUtf8((String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.memorydata.plugin"));
    L11:
        return ByteString.copyFrom((byte[]) ZeusTransformUtils.preCheckCast(r2, byte[].class, "com.obric.memorydata.plugin"));
    }

    private static String asString(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, String.class) == false) goto L7;
        return (String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.memorydata.plugin");
    L7:
        if (ZeusTransformUtils.instanceOf(r2, ByteString.class) == false) goto L11;
        return ((ByteString) ZeusTransformUtils.preCheckCast(r2, ByteString.class, "com.obric.memorydata.plugin")).toStringUtf8();
    L11:
        return Internal.toStringUtf8((byte[]) ZeusTransformUtils.preCheckCast(r2, byte[].class, "com.obric.memorydata.plugin"));
    }

    public static LazyStringArrayList emptyList() {
        return EMPTY_LIST;
    }

    private Object setAndReturn(int r1, ByteString r2) {
        ensureIsMutable();
        return this.list.set(r1, r2);
    }

    private Object setAndReturn(int r1, byte[] r2) {
        ensureIsMutable();
        return this.list.set(r1, r2);
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public /* synthetic */ void add(int r3, Object r4) {
        add(r3, (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin"));
    }

    public void add(int r2, String r3) {
        ensureIsMutable();
        this.list.add(r2, r3);
        this.modCount++;
    }

    @Override // com.google.protobuf.LazyStringList
    public void add(ByteString r2) {
        ensureIsMutable();
        this.list.add(r2);
        this.modCount++;
    }

    @Override // com.google.protobuf.LazyStringList
    public void add(byte[] r2) {
        ensureIsMutable();
        this.list.add(r2);
        this.modCount++;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* synthetic */ boolean add(Object r3) {
        return add((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));
    }

    public boolean add(String r2) {
        ensureIsMutable();
        this.list.add(r2);
        this.modCount++;
        return true;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public boolean addAll(int r3, Collection<? extends String> r4) {
        Collection<? extends Object> r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.memorydata.plugin");
        ensureIsMutable();
        if (ZeusTransformUtils.instanceOf(r5, LazyStringList.class) == false) goto L5;
        r5 = ((LazyStringList) ZeusTransformUtils.preCheckCast(r5, LazyStringList.class, "com.obric.memorydata.plugin")).getUnderlyingElements();
    L5:
        boolean r6 = this.list.addAll(r3, r5);
        this.modCount++;
        return r6;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends String> r3) {
        Collection<? extends String> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        return addAll(size(), r4);
    }

    @Override // com.google.protobuf.LazyStringList
    public boolean addAllByteArray(Collection<byte[]> r3) {
        Collection<? extends Object> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        ensureIsMutable();
        boolean r5 = this.list.addAll(r4);
        this.modCount++;
        return r5;
    }

    @Override // com.google.protobuf.LazyStringList
    public boolean addAllByteString(Collection<? extends ByteString> r3) {
        Collection<? extends Object> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        ensureIsMutable();
        boolean r5 = this.list.addAll(r4);
        this.modCount++;
        return r5;
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
        this.modCount++;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean equals(Object r1) {
        return super.equals(r1);
    }

    @Override // java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object get(int r1) {
        return get(r1);
    }

    @Override // java.util.AbstractList, java.util.List
    public String get(int r4) {
        Object r0 = this.list.get(r4);
        if (ZeusTransformUtils.instanceOf(r0, String.class) == false) goto L7;
        return (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin");
    L7:
        if (ZeusTransformUtils.instanceOf(r0, ByteString.class) == false) goto L12;
        ByteString r1 = (ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.memorydata.plugin");
        String r2 = r1.toStringUtf8();
        if (r1.isValidUtf8() == false) goto L11;
        this.list.set(r4, r2);
    L11:
        return r2;
    L12:
        byte[] r3 = (byte[]) ZeusTransformUtils.preCheckCast(r0, byte[].class, "com.obric.memorydata.plugin");
        String r5 = Internal.toStringUtf8(r3);
        if (Internal.isValidUtf8(r3) == false) goto L15;
        this.list.set(r4, r5);
    L15:
        return r5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.LazyStringList
    public byte[] getByteArray(int r3) {
        Object r0 = this.list.get(r3);
        byte[] r1 = asByteArray(r0);
        if (r1 == r0) goto L5;
        this.list.set(r3, r1);
    L5:
        return r1;
    }

    @Override // com.google.protobuf.LazyStringList
    public ByteString getByteString(int r3) {
        Object r0 = this.list.get(r3);
        ByteString r1 = asByteString(r0);
        if (r1 == r0) goto L5;
        this.list.set(r3, r1);
    L5:
        return r1;
    }

    @Override // com.google.protobuf.LazyStringList
    public Object getRaw(int r1) {
        return this.list.get(r1);
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
    public void mergeFrom(LazyStringList r5) {
        LazyStringList r6 = (LazyStringList) ZeusTransformUtils.wrapperContextForParams(r5, LazyStringList.class, "com.obric.memorydata.plugin");
        ensureIsMutable();
        Iterator<?> r7 = r6.getUnderlyingElements().iterator();
    L4:
        if (r7.hasNext() == false) goto L9;
        Object r0 = r7.next();
        if ((r0 instanceof byte[]) == true) goto L7;
        this.list.add(r0);
        goto L4
    L7:
        byte[] r1 = (byte[]) ZeusTransformUtils.preCheckCast(r0, byte[].class, "com.obric.memorydata.plugin");
        this.list.add(Arrays.copyOf(r1, r1.length));
        goto L4
    }

    @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
    public /* bridge */ /* synthetic */ Internal.ProtobufList mutableCopyWithCapacity(int r1) {
        return mutableCopyWithCapacity(r1);
    }

    @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
    public LazyStringArrayList mutableCopyWithCapacity(int r2) {
        if (r2 < size()) goto L7;
        ArrayList r0 = new ArrayList(r2);
        r0.addAll(this.list);
        return new LazyStringArrayList(r0);
    L7:
        throw new IllegalArgumentException();
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object remove(int r1) {
        return remove(r1);
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public String remove(int r2) {
        ensureIsMutable();
        Object r3 = this.list.remove(r2);
        this.modCount++;
        return asString(r3);
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean remove(Object r1) {
        return super.remove(r1);
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* synthetic */ boolean removeAll(Collection r3) {
        return super.removeAll((Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* synthetic */ boolean retainAll(Collection r3) {
        return super.retainAll((Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public /* synthetic */ Object set(int r3, Object r4) {
        return set(r3, (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin"));
    }

    public String set(int r1, String r2) {
        ensureIsMutable();
        return asString(this.list.set(r1, r2));
    }

    @Override // com.google.protobuf.LazyStringList
    public void set(int r1, ByteString r2) {
        setAndReturn(r1, r2);
    }

    @Override // com.google.protobuf.LazyStringList
    public void set(int r1, byte[] r2) {
        setAndReturn(r1, r2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.list.size();
    }
}
