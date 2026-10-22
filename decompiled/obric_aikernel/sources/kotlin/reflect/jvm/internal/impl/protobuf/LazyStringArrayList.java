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

    public LazyStringArrayList(LazyStringList r10) {
        this.list = new ArrayList(r10.size());
        addAll(r10);
    }

    private static ByteString asByteString(Object r10) {
        if ((r10 instanceof ByteString) == false) goto L7;
        return (ByteString) r10;
    L7:
        if ((r10 instanceof String) == false) goto L11;
        return ByteString.copyFromUtf8((String) r10);
    L11:
        return ByteString.copyFrom((byte[]) r10);
    }

    private static String asString(Object r10) {
        if ((r10 instanceof String) == false) goto L7;
        return (String) r10;
    L7:
        if ((r10 instanceof ByteString) == false) goto L11;
        return ((ByteString) r10).toStringUtf8();
    L11:
        return Internal.toStringUtf8((byte[]) r10);
    }

    @Override // java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ void add(int r10, Object r11) {
        add(r10, (String) r11);
    }

    public void add(int r10, String r11) {
        this.list.add(r10, r11);
        ((AbstractList) this).modCount++;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.LazyStringList
    public void add(ByteString r10) {
        this.list.add(r10);
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int r10, Collection<? extends String> r11) {
        if ((r11 instanceof LazyStringList) == false) goto L5;
        r11 = ((LazyStringList) r11).getUnderlyingElements();
    L5:
        boolean r12 = this.list.addAll(r10, r11);
        ((AbstractList) this).modCount++;
        return r12;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends String> r10) {
        return addAll(size(), r10);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.list.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object get(int r10) {
        return get(r10);
    }

    @Override // java.util.AbstractList, java.util.List
    public String get(int r10) {
        Object r11 = this.list.get(r10);
        if ((r11 instanceof String) == false) goto L7;
        return (String) r11;
    L7:
        if ((r11 instanceof ByteString) == false) goto L12;
        ByteString r12 = (ByteString) r11;
        String r13 = r12.toStringUtf8();
        if (r12.isValidUtf8() == false) goto L11;
        this.list.set(r10, r13);
    L11:
        return r13;
    L12:
        byte[] r14 = (byte[]) r11;
        String r15 = Internal.toStringUtf8(r14);
        if (Internal.isValidUtf8(r14) == false) goto L15;
        this.list.set(r10, r15);
    L15:
        return r15;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.LazyStringList
    public ByteString getByteString(int r10) {
        Object r11 = this.list.get(r10);
        ByteString r12 = asByteString(r11);
        if (r12 == r11) goto L5;
        this.list.set(r10, r12);
    L5:
        return r12;
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
    public /* bridge */ /* synthetic */ Object remove(int r10) {
        return remove(r10);
    }

    @Override // java.util.AbstractList, java.util.List
    public String remove(int r10) {
        Object r11 = this.list.remove(r10);
        ((AbstractList) this).modCount++;
        return asString(r11);
    }

    @Override // java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object set(int r10, Object r11) {
        return set(r10, (String) r11);
    }

    public String set(int r10, String r11) {
        return asString(this.list.set(r10, r11));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.list.size();
    }
}
