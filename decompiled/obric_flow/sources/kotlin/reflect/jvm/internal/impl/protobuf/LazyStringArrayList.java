package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes3.dex */
public class LazyStringArrayList extends AbstractList<String> implements RandomAccess, LazyStringList {
    public static final LazyStringList EMPTY = null;
    private final List<Object> list;

    static {
        EMPTY = new LazyStringArrayList().getUnmodifiableView();
    }

    public LazyStringArrayList() {
        this.list = new ArrayList();
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

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.list.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object get(int r5) {
        return get(r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.LazyStringList
    public ByteString getByteString(int r5) {
        Object r10 = this.list.get(r5);
        ByteString r11 = asByteString(r10);
        if (r11 == r10) goto L5;
        this.list.set(r5, r11);
    L5:
        return r11;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.LazyStringList
    public List<?> getUnderlyingElements() {
        return Collections.unmodifiableList(this.list);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.LazyStringList
    public LazyStringList getUnmodifiableView() {
        return new UnmodifiableLazyStringList(this);
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

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.LazyStringList
    public void add(ByteString r5) {
        this.list.add(r5);
        ((AbstractList) this).modCount++;
    }
}
