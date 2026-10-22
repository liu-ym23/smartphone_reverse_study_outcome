package androidx.room.jarjarred.kotlinx.metadata.internal.protobuf;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
public class LazyStringArrayList extends AbstractList<String> implements LazyStringList, RandomAccess {
    public static final LazyStringList EMPTY = null;
    private final List<Object> list;

    public static class ByteArrayListView extends AbstractList<byte[]> implements RandomAccess {
        private final List<Object> list;

        public ByteArrayListView(List<Object> r5) {
            this.list = r5;
        }

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ void add(int r5, Object r10) {
            add(r5, (byte[]) r10);
        }

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object get(int r5) {
            return get(r5);
        }

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object remove(int r5) {
            return remove(r5);
        }

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object set(int r5, Object r10) {
            return set(r5, (byte[]) r10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.list.size();
        }

        public void add(int r5, byte[] r10) {
            this.list.add(r5, r10);
            ((AbstractList) this).modCount++;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.AbstractList, java.util.List
        public byte[] get(int r5) {
            Object r10 = this.list.get(r5);
            byte[] r11 = LazyStringArrayList.access$000(r10);
            if (r11 == r10) goto L5;
            this.list.set(r5, r11);
        L5:
            return r11;
        }

        @Override // java.util.AbstractList, java.util.List
        public byte[] remove(int r5) {
            Object r10 = this.list.remove(r5);
            ((AbstractList) this).modCount++;
            return LazyStringArrayList.access$000(r10);
        }

        public byte[] set(int r5, byte[] r10) {
            Object r11 = this.list.set(r5, r10);
            ((AbstractList) this).modCount++;
            return LazyStringArrayList.access$000(r11);
        }
    }

    public static class ByteStringListView extends AbstractList<ByteString> implements RandomAccess {
        private final List<Object> list;

        public ByteStringListView(List<Object> r5) {
            this.list = r5;
        }

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ void add(int r5, Object r10) {
            add(r5, (ByteString) r10);
        }

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object get(int r5) {
            return get(r5);
        }

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object remove(int r5) {
            return remove(r5);
        }

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object set(int r5, Object r10) {
            return set(r5, (ByteString) r10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.list.size();
        }

        public void add(int r5, ByteString r10) {
            this.list.add(r5, r10);
            ((AbstractList) this).modCount++;
        }

        @Override // java.util.AbstractList, java.util.List
        public ByteString get(int r5) {
            Object r10 = this.list.get(r5);
            ByteString r11 = LazyStringArrayList.access$100(r10);
            if (r11 == r10) goto L5;
            this.list.set(r5, r11);
        L5:
            return r11;
        }

        @Override // java.util.AbstractList, java.util.List
        public ByteString remove(int r5) {
            Object r10 = this.list.remove(r5);
            ((AbstractList) this).modCount++;
            return LazyStringArrayList.access$100(r10);
        }

        public ByteString set(int r5, ByteString r10) {
            Object r11 = this.list.set(r5, r10);
            ((AbstractList) this).modCount++;
            return LazyStringArrayList.access$100(r11);
        }
    }

    static {
        EMPTY = new LazyStringArrayList().getUnmodifiableView();
    }

    public LazyStringArrayList() {
        this.list = new ArrayList();
    }

    public static /* synthetic */ byte[] access$000(Object r5) {
        return asByteArray(r5);
    }

    public static /* synthetic */ ByteString access$100(Object r5) {
        return asByteString(r5);
    }

    private static byte[] asByteArray(Object r5) {
        if ((r5 instanceof byte[]) == false) goto L7;
        return (byte[]) r5;
    L7:
        if ((r5 instanceof String) == false) goto L11;
        return Internal.toByteArray((String) r5);
    L11:
        return ((ByteString) r5).toByteArray();
    }

    private static ByteString asByteString(Object r5) {
        if ((r5 instanceof ByteString) == false) goto L7;
        return (ByteString) r5;
    L7:
        if ((r5 instanceof String) == false) goto L11;
        return ByteString.copyFromUtf8((String) r5);
    L11:
        return ByteString.copyFrom((byte[]) r5);
    }

    private static String asString(Object r5) {
        if ((r5 instanceof String) == false) goto L7;
        return (String) r5;
    L7:
        if ((r5 instanceof ByteString) == false) goto L11;
        return ((ByteString) r5).toStringUtf8();
    L11:
        return Internal.toStringUtf8((byte[]) r5);
    }

    @Override // java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ void add(int r5, Object r10) {
        add(r5, (String) r10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends String> r5) {
        return addAll(size(), r5);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.LazyStringList
    public boolean addAllByteArray(Collection<byte[]> r5) {
        boolean r10 = this.list.addAll(r5);
        ((AbstractList) this).modCount++;
        return r10;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.LazyStringList
    public boolean addAllByteString(Collection<? extends ByteString> r5) {
        boolean r10 = this.list.addAll(r5);
        ((AbstractList) this).modCount++;
        return r10;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.LazyStringList
    public List<byte[]> asByteArrayList() {
        return new ByteArrayListView(this.list);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.ProtocolStringList
    public List<ByteString> asByteStringList() {
        return new ByteStringListView(this.list);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.list.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object get(int r5) {
        return get(r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.LazyStringList
    public byte[] getByteArray(int r5) {
        Object r10 = this.list.get(r5);
        byte[] r11 = asByteArray(r10);
        if (r11 == r10) goto L5;
        this.list.set(r5, r11);
    L5:
        return r11;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.LazyStringList
    public ByteString getByteString(int r5) {
        Object r10 = this.list.get(r5);
        ByteString r11 = asByteString(r10);
        if (r11 == r10) goto L5;
        this.list.set(r5, r11);
    L5:
        return r11;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.LazyStringList
    public List<?> getUnderlyingElements() {
        return Collections.unmodifiableList(this.list);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.LazyStringList
    public LazyStringList getUnmodifiableView() {
        return new UnmodifiableLazyStringList(this);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.LazyStringList
    public void mergeFrom(LazyStringList r5) {
        Iterator<?> r10 = r5.getUnderlyingElements().iterator();
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

    @Override // java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object remove(int r5) {
        return remove(r5);
    }

    @Override // java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object set(int r5, Object r10) {
        return set(r5, (String) r10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.list.size();
    }

    public void add(int r5, String r10) {
        this.list.add(r5, r10);
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int r5, Collection<? extends String> r10) {
        if ((r10 instanceof LazyStringList) == false) goto L5;
        r10 = ((LazyStringList) r10).getUnderlyingElements();
    L5:
        boolean r11 = this.list.addAll(r5, r10);
        ((AbstractList) this).modCount++;
        return r11;
    }

    @Override // java.util.AbstractList, java.util.List
    public String get(int r5) {
        Object r10 = this.list.get(r5);
        if ((r10 instanceof String) == false) goto L7;
        return (String) r10;
    L7:
        if ((r10 instanceof ByteString) == false) goto L12;
        ByteString r11 = (ByteString) r10;
        String r12 = r11.toStringUtf8();
        if (r11.isValidUtf8() == false) goto L11;
        this.list.set(r5, r12);
    L11:
        return r12;
    L12:
        byte[] r13 = (byte[]) r10;
        String r14 = Internal.toStringUtf8(r13);
        if (Internal.isValidUtf8(r13) == false) goto L15;
        this.list.set(r5, r14);
    L15:
        return r14;
    }

    @Override // java.util.AbstractList, java.util.List
    public String remove(int r5) {
        Object r10 = this.list.remove(r5);
        ((AbstractList) this).modCount++;
        return asString(r10);
    }

    public String set(int r5, String r10) {
        return asString(this.list.set(r5, r10));
    }

    public LazyStringArrayList(LazyStringList r5) {
        this.list = new ArrayList(r5.size());
        addAll(r5);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.LazyStringList
    public void add(ByteString r5) {
        this.list.add(r5);
        ((AbstractList) this).modCount++;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.LazyStringList
    public void set(int r5, ByteString r10) {
        this.list.set(r5, r10);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.LazyStringList
    public void set(int r5, byte[] r10) {
        this.list.set(r5, r10);
    }

    public LazyStringArrayList(List<String> r5) {
        this.list = new ArrayList(r5);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.LazyStringList
    public void add(byte[] r5) {
        this.list.add(r5);
        ((AbstractList) this).modCount++;
    }
}
