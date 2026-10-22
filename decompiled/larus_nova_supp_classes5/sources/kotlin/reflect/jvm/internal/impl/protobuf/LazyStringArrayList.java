package kotlin.reflect.jvm.internal.impl.protobuf;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class LazyStringArrayList extends AbstractList<String> implements RandomAccess, LazyStringList {
    public static final LazyStringList EMPTY = null;
    private final List<Object> list;

    static {
        EMPTY = new LazyStringArrayList().getUnmodifiableView();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.list.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.LazyStringList
    public List<?> getUnderlyingElements() {
        return Collections.unmodifiableList(this.list);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.LazyStringList
    public LazyStringList getUnmodifiableView() {
        return new UnmodifiableLazyStringList(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.list.size();
    }

    public LazyStringArrayList() {
        this.list = new ArrayList();
    }

    public LazyStringArrayList(LazyStringList r3) {
        this.list = new ArrayList(r3.size());
        addAll(r3);
    }

    private static ByteString asByteString(Object r1) {
        if ((r1 instanceof ByteString) == false) goto L7;
        return (ByteString) r1;
    L7:
        if ((r1 instanceof String) == false) goto L11;
        return ByteString.copyFromUtf8((String) r1);
    L11:
        return ByteString.copyFrom((byte[]) r1);
    }

    private static String asString(Object r1) {
        if ((r1 instanceof String) == false) goto L7;
        return (String) r1;
    L7:
        if ((r1 instanceof ByteString) == false) goto L11;
        return ((ByteString) r1).toStringUtf8();
    L11:
        return Internal.toStringUtf8((byte[]) r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.LazyStringList
    public void add(ByteString r2) {
        this.list.add(r2);
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends String> r2) {
        return addAll(size(), r2);
    }

    @Override // java.util.AbstractList, java.util.List
    public String get(int r3) {
        Object r0 = ListProtector.get(this.list, r3);
        if ((r0 instanceof String) == false) goto L7;
        return (String) r0;
    L7:
        if ((r0 instanceof ByteString) == false) goto L12;
        ByteString r1 = (ByteString) r0;
        String r2 = r1.toStringUtf8();
        if (r1.isValidUtf8() == false) goto L11;
        ListProtector.set(this.list, r3, r2);
    L11:
        return r2;
    L12:
        byte[] r4 = (byte[]) r0;
        String r5 = Internal.toStringUtf8(r4);
        if (Internal.isValidUtf8(r4) == false) goto L15;
        ListProtector.set(this.list, r3, r5);
    L15:
        return r5;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.LazyStringList
    public ByteString getByteString(int r3) {
        Object r0 = ListProtector.get(this.list, r3);
        ByteString r1 = asByteString(r0);
        if (r1 == r0) goto L5;
        ListProtector.set(this.list, r3, r1);
    L5:
        return r1;
    }

    @Override // java.util.AbstractList, java.util.List
    public String remove(int r2) {
        Object r3 = ListProtector.remove(this.list, r2);
        ((AbstractList) this).modCount++;
        return asString(r3);
    }

    @Override // java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object get(int r1) {
        return get(r1);
    }

    @Override // java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object remove(int r1) {
        return remove(r1);
    }

    public void add(int r2, String r3) {
        ListProtector.add(this.list, r2, r3);
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int r2, Collection<? extends String> r3) {
        if ((r3 instanceof LazyStringList) == false) goto L5;
        r3 = ((LazyStringList) r3).getUnderlyingElements();
    L5:
        boolean r4 = this.list.addAll(r2, r3);
        ((AbstractList) this).modCount++;
        return r4;
    }

    public String set(int r2, String r3) {
        return asString(ListProtector.set(this.list, r2, r3));
    }

    @Override // java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ void add(int r1, Object r2) {
        add(r1, (String) r2);
    }

    @Override // java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object set(int r1, Object r2) {
        return set(r1, (String) r2);
    }
}
