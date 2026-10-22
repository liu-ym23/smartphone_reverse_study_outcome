package kotlin.collections;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010*\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u00042\u00060\u0005j\u0002`\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0007J\u0011\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0096\u0002J\u0016\u0010\u0011\u001a\u00020\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u0013H\u0016J\u0013\u0010\u0014\u001a\u00020\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0096\u0002J\u0011\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u000bH\u0096\u0002J\b\u0010\u0019\u001a\u00020\u000bH\u0016J\u0010\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0002H\u0016J\b\u0010\u001b\u001a\u00020\u000fH\u0016J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u001dH\u0096\u0002J\u0010\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0002H\u0016J\u000e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020 H\u0016J\u0016\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020 2\u0006\u0010\u0018\u001a\u00020\u000bH\u0016J\b\u0010!\u001a\u00020\u0016H\u0002J\u001e\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010#\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u000bH\u0016J\b\u0010%\u001a\u00020&H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006'"}, d2 = {"Lkotlin/collections/EmptyList;", "", "", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "()V", "serialVersionUID", "", "size", "", "getSize", "()I", "contains", "", "element", "containsAll", "elements", "", "equals", "other", "", "get", "index", "hashCode", "indexOf", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "readResolve", "subList", "fromIndex", "toIndex", "toString", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class EmptyList implements Serializable, List, RandomAccess, KMappedMarker {
    public static final EmptyList INSTANCE = null;
    private static final long serialVersionUID = -7390468764508069838L;

    static {
        INSTANCE = new EmptyList();
    }

    private EmptyList() {
    }

    private final Object readResolve() {
        return INSTANCE;
    }

    @Override // java.util.List
    public /* synthetic */ void add(int r1, Object r2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void add(int r1, Void r2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public /* synthetic */ boolean add(Object r1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean add(Void r1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public boolean addAll(int r1, Collection r2) {
        Collection r0 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection r2) {
        Collection r1 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final boolean contains(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, Void.class) == true) goto L7;
        return false;
    L7:
        return contains((Void) ZeusTransformUtils.preCheckCast(r3, Void.class, "com.obric.memorydata.plugin"));
    }

    public boolean contains(Void r1) {
        Intrinsics.checkNotNullParameter(r1, "element");
        return false;
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection r2) {
        Collection r1 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "elements");
        return r1.isEmpty();
    }

    @Override // java.util.List, java.util.Collection
    public boolean equals(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, List.class) == true) goto L5;
    L7:
        return false;
    L5:
        if (((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L7;
        return true;
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ Object get(int r1) {
        return get(r1);
    }

    @Override // java.util.List
    public Void get(int r3) {
        throw new IndexOutOfBoundsException("Empty list doesn't contain element at index " + r3 + '.');
    }

    public int getSize() {
        return 0;
    }

    @Override // java.util.List, java.util.Collection
    public int hashCode() {
        return 1;
    }

    @Override // java.util.List
    public final int indexOf(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, Void.class) == true) goto L7;
        return -1;
    L7:
        return indexOf((Void) ZeusTransformUtils.preCheckCast(r3, Void.class, "com.obric.memorydata.plugin"));
    }

    public int indexOf(Void r1) {
        Intrinsics.checkNotNullParameter(r1, "element");
        return -1;
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return true;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return (Iterator) ZeusTransformUtils.preCheckCast(EmptyIterator.INSTANCE, Iterator.class, "com.obric.memorydata.plugin");
    }

    @Override // java.util.List
    public final int lastIndexOf(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, Void.class) == true) goto L7;
        return -1;
    L7:
        return lastIndexOf((Void) ZeusTransformUtils.preCheckCast(r3, Void.class, "com.obric.memorydata.plugin"));
    }

    public int lastIndexOf(Void r1) {
        Intrinsics.checkNotNullParameter(r1, "element");
        return -1;
    }

    @Override // java.util.List
    public ListIterator listIterator() {
        return (ListIterator) ZeusTransformUtils.preCheckCast(EmptyIterator.INSTANCE, ListIterator.class, "com.obric.memorydata.plugin");
    }

    @Override // java.util.List
    public ListIterator listIterator(int r3) {
        if (r3 != 0) goto L6;
        return (ListIterator) ZeusTransformUtils.preCheckCast(EmptyIterator.INSTANCE, ListIterator.class, "com.obric.memorydata.plugin");
    L6:
        throw new IndexOutOfBoundsException("Index: " + r3);
    }

    @Override // java.util.List
    public /* synthetic */ Object remove(int r1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public Void remove(int r1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object r1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection r2) {
        Collection r1 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection r2) {
        Collection r1 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public /* synthetic */ Object set(int r1, Object r2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Void set(int r1, Void r2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final int size() {
        return getSize();
    }

    @Override // java.util.List
    public List subList(int r3, int r4) {
        if (r3 != 0) goto L7;
        if (r4 != 0) goto L7;
        return (List) ZeusTransformUtils.preCheckCast(this, List.class, "com.obric.memorydata.plugin");
    L7:
        throw new IndexOutOfBoundsException("fromIndex: " + r3 + ", toIndex: " + r4);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.toArray((Collection) ZeusTransformUtils.preCheckCast(this, Collection.class, "com.obric.memorydata.plugin"));
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(T[] r3) {
        Intrinsics.checkNotNullParameter(r3, "array");
        return (T[]) CollectionToArray.toArray((Collection) ZeusTransformUtils.preCheckCast(this, Collection.class, "com.obric.memorydata.plugin"), r3);
    }

    public String toString() {
        return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    }
}
