package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableCollection;
import kotlin.jvm.internal.markers.KMutableSet;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001f\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010)\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001?B\u0019\b\u0016\u0012\u0010\u0010\u0004\u001a\f\u0012\u0006\b\u0001\u0012\u00028\u0000\u0018\u00010\u0000¢\u0006\u0002\u0010\u0005B\u0017\b\u0016\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B\u0019\b\u0016\u0012\u0010\u0010\b\u001a\f\u0012\u0006\b\u0001\u0012\u00028\u0000\u0018\u00010\t¢\u0006\u0002\u0010\nB\u0011\b\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0015\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\"J\u0016\u0010#\u001a\u00020$2\u000e\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0000J\u0016\u0010#\u001a\u00020 2\f\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0016J\b\u0010&\u001a\u00020$H\u0016J\u0016\u0010'\u001a\u00020 2\u0006\u0010!\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\"J\u0016\u0010(\u001a\u00020 2\f\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0016J\u000e\u0010)\u001a\u00020$2\u0006\u0010*\u001a\u00020\fJ\u0013\u0010+\u001a\u00020 2\b\u0010,\u001a\u0004\u0018\u00010\u0012H\u0096\u0002J\b\u0010-\u001a\u00020\fH\u0016J\u0010\u0010.\u001a\u00020\f2\b\u0010/\u001a\u0004\u0018\u00010\u0012J\b\u00100\u001a\u00020 H\u0016J\u000f\u00101\u001a\b\u0012\u0004\u0012\u00028\u000002H\u0096\u0002J\u0015\u00103\u001a\u00020 2\u0006\u0010!\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\"J\u0016\u00104\u001a\u00020 2\u000e\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0000J\u0016\u00104\u001a\u00020 2\f\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0016J\u0013\u00105\u001a\u00028\u00002\u0006\u00106\u001a\u00020\f¢\u0006\u0002\u00107J\u0016\u00108\u001a\u00020 2\f\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0016J\u0013\u00109\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\t¢\u0006\u0002\u0010\u0014J%\u00109\u001a\b\u0012\u0004\u0012\u0002H:0\t\"\u0004\b\u0001\u0010:2\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H:0\t¢\u0006\u0002\u0010;J\b\u0010<\u001a\u00020=H\u0016J\u0013\u0010>\u001a\u00028\u00002\u0006\u00106\u001a\u00020\f¢\u0006\u0002\u00107R\u001a\u0010\u000e\u001a\u00020\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\rR$\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\tX\u0080\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\nR\u001a\u0010\u0017\u001a\u00020\u0018X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0010¨\u0006@"}, d2 = {"Landroidx/collection/ArraySet;", ExifInterface.LONGITUDE_EAST, "", "", "set", "(Landroidx/collection/ArraySet;)V", "", "(Ljava/util/Collection;)V", "array", "", "([Ljava/lang/Object;)V", "capacity", "", "(I)V", "_size", "get_size$collection", "()I", "set_size$collection", "", "getArray$collection", "()[Ljava/lang/Object;", "setArray$collection", "[Ljava/lang/Object;", "hashes", "", "getHashes$collection", "()[I", "setHashes$collection", "([I)V", "size", "getSize", "add", "", "element", "(Ljava/lang/Object;)Z", "addAll", "", "elements", "clear", "contains", "containsAll", "ensureCapacity", "minimumCapacity", "equals", "other", "hashCode", "indexOf", "key", "isEmpty", "iterator", "", "remove", "removeAll", "removeAt", "index", "(I)Ljava/lang/Object;", "retainAll", "toArray", ExifInterface.GPS_DIRECTION_TRUE, "([Ljava/lang/Object;)[Ljava/lang/Object;", "toString", "", "valueAt", "ElementIterator", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ArraySet<E> implements Collection<E>, Set<E>, KMutableCollection, KMutableSet {
    private int _size;
    private Object[] array;
    private int[] hashes;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u0005H\u0014¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0014¨\u0006\t"}, d2 = {"Landroidx/collection/ArraySet$ElementIterator;", "Landroidx/collection/IndexBasedArrayIterator;", "(Landroidx/collection/ArraySet;)V", "elementAt", "index", "", "(I)Ljava/lang/Object;", "removeAt", "", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class ElementIterator extends IndexBasedArrayIterator<E> {
        final /* synthetic */ ArraySet<E> this$0;

        public ElementIterator(ArraySet r1) {
            this.this$0 = r1;
            super(r1.get_size$collection());
        }

        @Override // androidx.collection.IndexBasedArrayIterator
        public E elementAt(int r1) {
            return this.this$0.valueAt(r1);
        }

        @Override // androidx.collection.IndexBasedArrayIterator
        public void removeAt(int r1) {
            this.this$0.removeAt(r1);
        }
    }

    public ArraySet() {
        this(0, 1, null);
    }

    public ArraySet(int r2) {
        this.hashes = ContainerHelpersKt.EMPTY_INTS;
        this.array = ContainerHelpersKt.EMPTY_OBJECTS;
        if (r2 <= 0) goto L6;
        ArraySetKt.allocArrays(this, r2);
        return;
    }

    public /* synthetic */ ArraySet(int r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = 0;
    L5:
        this(r1);
    }

    public ArraySet(ArraySet<? extends E> r2) {
        this(0);
        if (r2 == null) goto L6;
        addAll(r2);
        return;
    }

    public ArraySet(Collection<? extends E> r3) {
        Collection<? extends E> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        this(0);
        if (r4 == null) goto L6;
        addAll(r4);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ArraySet(E[] r2) {
        this(0);
        if (r2 == null) goto L8;
        Iterator r3 = ArrayIteratorKt.iterator(r2);
    L6:
        if (r3.hasNext() == false) goto L10;
        add(r3.next());
        goto L6
    L10:
        return;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(E r18) {
        int r2 = get_size$collection();
        boolean r3 = false;
        if (r18 != null) goto L5;
        int r4 = ArraySetKt.indexOfNull(this);
        int r5 = 0;
    L7:
        if (r4 >= 0) goto L36;
        int r6 = ~r4;
        if (r2 < getHashes$collection().length) goto L26;
        int r7 = 4;
        if (r2 < 8) goto L14;
        r7 = (r2 >> 1) + r2;
    L16:
        int[] r8 = getHashes$collection();
        Object[] r15 = getArray$collection();
        ArraySetKt.allocArrays(this, r7);
        if (r2 != get_size$collection()) goto L25;
        if (getHashes$collection().length != 0) goto L22;
        r3 = true;
    L22:
        if ((!r3) == false) goto L26;
        ArraysKt.copyInto$default(r8, getHashes$collection(), 0, 0, r8.length, 6, null);
        ArraysKt.copyInto$default(r15, getArray$collection(), 0, 0, r15.length, 6, null);
        goto L26
    L25:
        throw new ConcurrentModificationException();
    L14:
        if (r2 < 4) goto L16;
        r7 = 8;
    L26:
        if (r6 >= r2) goto L29;
        int r9 = r6 + 1;
        ArraysKt.copyInto(getHashes$collection(), getHashes$collection(), r9, r6, r2);
        ArraysKt.copyInto(getArray$collection(), getArray$collection(), r9, r6, r2);
    L29:
        if (r2 != get_size$collection()) goto L35;
        if (r6 >= getHashes$collection().length) goto L35;
        getHashes$collection()[r6] = r5;
        getArray$collection()[r6] = r18;
        set_size$collection(get_size$collection() + 1);
        return true;
    L35:
        throw new ConcurrentModificationException();
    L36:
        return false;
    L5:
        int r10 = r18.hashCode();
        r5 = r10;
        r4 = ArraySetKt.indexOf(this, r18, r10);
        goto L7
    }

    public final void addAll(ArraySet<? extends E> r9) {
        Intrinsics.checkNotNullParameter(r9, "array");
        int r0 = r9.get_size$collection();
        ensureCapacity(get_size$collection() + r0);
        if (get_size$collection() != 0) goto L10;
        if (r0 <= 0) goto L13;
        ArraysKt.copyInto$default(r9.getHashes$collection(), getHashes$collection(), 0, 0, r0, 6, null);
        ArraysKt.copyInto$default(r9.getArray$collection(), getArray$collection(), 0, 0, r0, 6, null);
        if (get_size$collection() != 0) goto L9;
        set_size$collection(r0);
        return;
    L9:
        throw new ConcurrentModificationException();
    L13:
        return;
    L10:
        int r1 = 0;
    L11:
        if (r1 >= r0) goto L16;
        add(r9.valueAt(r1));
        r1 = r1 + 1;
        goto L11
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> r3) {
        Collection r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "elements");
        ensureCapacity(get_size$collection() + r4.size());
        Iterator<E> r5 = r4.iterator();
        boolean r0 = false;
    L4:
        if (r5.hasNext() == false) goto L6;
        r0 = r0 | add(r5.next());
        goto L4
    L6:
        return r0;
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        if (get_size$collection() == 0) goto L6;
        setHashes$collection(ContainerHelpersKt.EMPTY_INTS);
        setArray$collection(ContainerHelpersKt.EMPTY_OBJECTS);
        set_size$collection(0);
    L6:
        if (get_size$collection() != 0) goto L9;
        return;
    L9:
        throw new ConcurrentModificationException();
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object r1) {
        if (indexOf(r1) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection<? extends Object> r3) {
        Collection r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "elements");
        Iterator<E> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        if (contains(r5.next()) == true) goto L4;
        return false;
    L8:
        return true;
    }

    public final void ensureCapacity(int r11) {
        int r0 = get_size$collection();
        if (getHashes$collection().length >= r11) goto L8;
        int[] r2 = getHashes$collection();
        Object[] r1 = getArray$collection();
        ArraySetKt.allocArrays(this, r11);
        if (get_size$collection() <= 0) goto L8;
        ArraysKt.copyInto$default(r2, getHashes$collection(), 0, 0, get_size$collection(), 6, null);
        ArraysKt.copyInto$default(r1, getArray$collection(), 0, 0, get_size$collection(), 6, null);
    L8:
        if (get_size$collection() != r0) goto L11;
        return;
    L11:
        throw new ConcurrentModificationException();
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r8, Set.class) == false) goto L17;
        if (size() != ((Set) ZeusTransformUtils.preCheckCast(r8, Set.class, "com.obric.memorydata.plugin")).size()) goto L17;
        int r2 = get_size$collection();     // Catch: Throwable -> L18
        int r3 = 0;
    L11:
        if (r3 >= r2) goto L24;
        if (((Set) ZeusTransformUtils.preCheckCast(r8, Set.class, "com.obric.memorydata.plugin")).contains(valueAt(r3)) == false) goto L17;
        r3 = r3 + 1;
        goto L11
    L24:
        return true;
    L17:
        return false;
    }

    public final Object[] getArray$collection() {
        return this.array;
    }

    public final int[] getHashes$collection() {
        return this.hashes;
    }

    public int getSize() {
        return this._size;
    }

    public final int get_size$collection() {
        return this._size;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] r0 = getHashes$collection();
        int r4 = get_size$collection();
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r1 >= r4) goto L5;
        r2 = r2 + r0[r1];
        r1 = r1 + 1;
        goto L3
    L5:
        return r2;
    }

    public final int indexOf(Object r2) {
        if (r2 != null) goto L5;
        return ArraySetKt.indexOfNull(this);
    L5:
        return ArraySetKt.indexOf(this, r2, r2.hashCode());
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        if (get_size$collection() > 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return (Iterator) ZeusTransformUtils.preCheckCast(new ElementIterator(this), Iterator.class, "com.obric.memorydata.plugin");
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object r1) {
        int r2 = indexOf(r1);
        if (r2 < 0) goto L5;
        removeAt(r2);
        return true;
    L5:
        return false;
    }

    public final boolean removeAll(ArraySet<? extends E> r6) {
        Intrinsics.checkNotNullParameter(r6, "array");
        int r0 = r6.get_size$collection();
        int r1 = get_size$collection();
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L6;
        remove(r6.valueAt(r3));
        r3 = r3 + 1;
        goto L3
    L6:
        if (r1 == get_size$collection()) goto L10;
        return true;
    L10:
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection<? extends Object> r3) {
        Collection r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "elements");
        Iterator<E> r5 = r4.iterator();
        boolean r0 = false;
    L4:
        if (r5.hasNext() == false) goto L6;
        r0 = r0 | remove(r5.next());
        goto L4
    L6:
        return r0;
    }

    public final E removeAt(int r14) {
        int r0 = get_size$collection();
        E r1 = (E) getArray$collection()[r14];
        if (r0 > 1) goto L5;
        clear();
    L23:
        return r1;
    L5:
        int r3 = r0 - 1;
        int r5 = 8;
        if (getHashes$collection().length > 8) goto L8;
    L17:
        if (r14 >= r3) goto L19;
        int r6 = r14 + 1;
        int r7 = r3 + 1;
        ArraysKt.copyInto(getHashes$collection(), getHashes$collection(), r14, r6, r7);
        ArraysKt.copyInto(getArray$collection(), getArray$collection(), r14, r6, r7);
    L19:
        getArray$collection()[r3] = null;
    L21:
        if (r0 != get_size$collection()) goto L25;
        set_size$collection(r3);
        goto L23
    L25:
        throw new ConcurrentModificationException();
    L8:
        if (get_size$collection() >= (getHashes$collection().length / 3)) goto L17;
        if (get_size$collection() <= 8) goto L12;
        r5 = get_size$collection() + (get_size$collection() >> 1);
    L12:
        int[] r2 = getHashes$collection();
        Object[] r4 = getArray$collection();
        ArraySetKt.allocArrays(this, r5);
        if (r14 <= 0) goto L15;
        ArraysKt.copyInto$default(r2, getHashes$collection(), 0, 0, r14, 6, null);
        ArraysKt.copyInto$default(r4, getArray$collection(), 0, 0, r14, 6, null);
    L15:
        if (r14 >= r3) goto L21;
        int r8 = r14 + 1;
        int r9 = r3 + 1;
        ArraysKt.copyInto(r2, getHashes$collection(), r14, r8, r9);
        ArraysKt.copyInto(r4, getArray$collection(), r14, r8, r9);
        goto L21
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection<? extends Object> r7) {
        Collection r8 = (Collection) ZeusTransformUtils.wrapperContextForParams(r7, Collection.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "elements");
        int r0 = get_size$collection() - 1;
        boolean r3 = false;
    L4:
        if ((-1) >= r0) goto L9;
        if (CollectionsKt.contains((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin"), getArray$collection()[r0]) == true) goto L8;
        removeAt(r0);
        r3 = true;
    L8:
        r0 = r0 - 1;
        goto L4
    L9:
        return r3;
    }

    public final void setArray$collection(Object[] r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.array = r2;
    }

    public final void setHashes$collection(int[] r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.hashes = r2;
    }

    public final void set_size$collection(int r1) {
        this._size = r1;
    }

    @Override // java.util.Collection, java.util.Set
    public final int size() {
        return getSize();
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray() {
        return ArraysKt.copyOfRange(this.array, 0, this._size);
    }

    @Override // java.util.Collection, java.util.Set
    public final <T> T[] toArray(T[] r3) {
        Intrinsics.checkNotNullParameter(r3, "array");
        T[] r4 = (T[]) ArraySetJvmUtil.resizeForToArray(r3, this._size);
        ArraysKt.copyInto(this.array, r4, 0, 0, this._size);
        Intrinsics.checkNotNullExpressionValue(r4, "result");
        return r4;
    }

    public String toString() {
        if (isEmpty() == false) goto L5;
        return "{}";
    L5:
        StringBuilder r1 = new StringBuilder(get_size$collection() * 14);
        r1.append('{');
        int r0 = 0;
        int r2 = get_size$collection();
    L6:
        if (r0 >= r2) goto L14;
        if (r0 <= 0) goto L9;
        r1.append(", ");
    L9:
        E r3 = valueAt(r0);
        if (r3 == this) goto L12;
        r1.append(r3);
    L13:
        r0 = r0 + 1;
        goto L6
    L12:
        r1.append("(this Set)");
        goto L13
    L14:
        r1.append('}');
        String r4 = r1.toString();
        Intrinsics.checkNotNullExpressionValue(r4, "StringBuilder(capacity).…builderAction).toString()");
        return r4;
    }

    public final E valueAt(int r1) {
        return (E) getArray$collection()[r1];
    }
}
