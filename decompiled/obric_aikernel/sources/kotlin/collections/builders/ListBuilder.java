package kotlin.collections.builders;

import com.bytedance.apm6.consumer.slardar.Constants;
import java.io.NotSerializableException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.collections.AbstractList;
import kotlin.collections.AbstractMutableList;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMutableListIterator;

/* JADX WARN: Unexpected interfaces in signature: [java.io.Serializable, kotlin.jvm.internal.markers.KMutableList] */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nListBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ListBuilder.kt\nkotlin/collections/builders/ListBuilder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,432:1\n1#2:433\n*E\n"})
public final class ListBuilder<E> extends AbstractMutableList<E> implements List<E>, RandomAccess {
    private static final Companion Companion = null;
    private static final ListBuilder Empty = null;
    private E[] array;
    private final ListBuilder<E> backing;
    private boolean isReadOnly;
    private int length;
    private int offset;
    private final ListBuilder<E> root;

    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }
    }

    @SourceDebugExtension({"SMAP\nListBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ListBuilder.kt\nkotlin/collections/builders/ListBuilder$Itr\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,432:1\n1#2:433\n*E\n"})
    private static final class Itr<E> implements ListIterator<E>, KMutableListIterator {
        private int index;
        private int lastIndex;
        private final ListBuilder<E> list;

        public Itr(ListBuilder<E> r10, int r11) {
            Intrinsics.checkNotNullParameter(r10, Constants.KEY_LIST);
            this.list = r10;
            this.index = r11;
            this.lastIndex = -1;
        }

        @Override // java.util.ListIterator
        public void add(E r10) {
            ListBuilder<E> r11 = this.list;
            int r12 = this.index;
            this.index = r12 + 1;
            r11.add(r12, r10);
            this.lastIndex = -1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            if (this.index >= ListBuilder.access$getLength$p(this.list)) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            if (this.index <= 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public E next() {
            if (this.index >= ListBuilder.access$getLength$p(this.list)) goto L7;
            int r10 = this.index;
            this.index = r10 + 1;
            this.lastIndex = r10;
            return (E) ListBuilder.access$getArray$p(this.list)[ListBuilder.access$getOffset$p(this.list) + this.lastIndex];
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.index;
        }

        @Override // java.util.ListIterator
        public E previous() {
            int r10 = this.index;
            if (r10 <= 0) goto L7;
            int r11 = r10 - 1;
            this.index = r11;
            this.lastIndex = r11;
            return (E) ListBuilder.access$getArray$p(this.list)[ListBuilder.access$getOffset$p(this.list) + this.lastIndex];
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.index - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            int r10 = this.lastIndex;
            if (r10 == (-1)) goto L5;
            boolean r11 = true;
        L6:
            if (r11 == false) goto L10;
            this.list.remove(r10);
            this.index = this.lastIndex;
            this.lastIndex = -1;
            return;
        L10:
            throw new IllegalStateException("Call next() or previous() before removing element from the iterator.".toString());
        L5:
            r11 = false;
            goto L6
        }

        @Override // java.util.ListIterator
        public void set(E r10) {
            int r11 = this.lastIndex;
            if (r11 == (-1)) goto L5;
            boolean r12 = true;
        L6:
            if (r12 == false) goto L10;
            this.list.set(r11, r10);
            return;
        L10:
            throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.".toString());
        L5:
            r12 = false;
            goto L6
        }
    }

    static {
        Companion = new Companion(null);
        ListBuilder r10 = new ListBuilder(0);
        r10.isReadOnly = true;
        Empty = r10;
    }

    public ListBuilder() {
        this(10);
    }

    public ListBuilder(int r10) {
        this(ListBuilderKt.arrayOfUninitializedElements(r10), 0, 0, false, null, null);
    }

    private ListBuilder(E[] r10, int r11, int r12, boolean r13, ListBuilder<E> r14, ListBuilder<E> r15) {
        this.array = r10;
        this.offset = r11;
        this.length = r12;
        this.isReadOnly = r13;
        this.backing = r14;
        this.root = r15;
    }

    public static final /* synthetic */ Object[] access$getArray$p(ListBuilder r10) {
        return r10.array;
    }

    public static final /* synthetic */ int access$getLength$p(ListBuilder r10) {
        return r10.length;
    }

    public static final /* synthetic */ int access$getOffset$p(ListBuilder r10) {
        return r10.offset;
    }

    private final void addAllInternal(int r10, Collection<? extends E> r11, int r12) {
        ListBuilder<E> r13 = this.backing;
        if (r13 == null) goto L5;
        r13.addAllInternal(r10, r11, r12);
        this.array = this.backing.array;
        this.length += r12;
        return;
    L5:
        insertAtInternal(r10, r12);
        int r14 = 0;
        Iterator<? extends E> r15 = r11.iterator();
    L6:
        if (r14 >= r12) goto L10;
        this.array[r10 + r14] = r15.next();
        r14 = r14 + 1;
        goto L6
    }

    private final void addAtInternal(int r10, E r11) {
        ListBuilder<E> r12 = this.backing;
        if (r12 == null) goto L5;
        r12.addAtInternal(r10, r11);
        this.array = this.backing.array;
        this.length++;
        return;
    L5:
        insertAtInternal(r10, 1);
        this.array[r10] = r11;
    }

    private final void checkIsMutable() {
        if (isEffectivelyReadOnly() == true) goto L6;
        return;
    L6:
        throw new UnsupportedOperationException();
    }

    private final boolean contentEquals(List<?> r10) {
        return ListBuilderKt.access$subarrayContentEquals(this.array, this.offset, this.length, r10);
    }

    private final void ensureCapacity(int r10) {
        if (this.backing != null) goto L12;
        if (r10 < 0) goto L10;
        E[] r11 = this.array;
        if (r10 <= r11.length) goto L13;
        int r12 = ArrayDeque.Companion.newCapacity$kotlin_stdlib(r11.length, r10);
        this.array = (E[]) ListBuilderKt.copyOfUninitializedElements(this.array, r12);
        return;
    L13:
        return;
    L10:
        throw new OutOfMemoryError();
    L12:
        throw new IllegalStateException();
    }

    private final void ensureExtraCapacity(int r10) {
        ensureCapacity(this.length + r10);
    }

    private final void insertAtInternal(int r10, int r11) {
        ensureExtraCapacity(r11);
        E[] r12 = this.array;
        ArraysKt.copyInto(r12, r12, r10 + r11, r10, this.offset + this.length);
        this.length += r11;
    }

    private final boolean isEffectivelyReadOnly() {
        if (this.isReadOnly == true) goto L10;
        ListBuilder<E> r10 = this.root;
        if (r10 != null) goto L7;
    L9:
        return false;
    L7:
        if (r10.isReadOnly == false) goto L9;
    L10:
        return true;
    }

    private final E removeAtInternal(int r10) {
        ListBuilder<E> r11 = this.backing;
        if (r11 == null) goto L6;
        E r12 = r11.removeAtInternal(r10);
        this.length--;
        return r12;
    L6:
        E[] r13 = this.array;
        E r14 = r13[r10];
        ArraysKt.copyInto(r13, r13, r10, r10 + 1, this.offset + this.length);
        ListBuilderKt.resetAt(this.array, (this.offset + this.length) - 1);
        this.length--;
        return r14;
    }

    private final void removeRangeInternal(int r10, int r11) {
        ListBuilder<E> r12 = this.backing;
        if (r12 == null) goto L5;
        r12.removeRangeInternal(r10, r11);
    L6:
        this.length -= r11;
        return;
    L5:
        E[] r13 = this.array;
        ArraysKt.copyInto(r13, r13, r10, r10 + r11, this.length);
        E[] r14 = this.array;
        int r15 = this.length;
        ListBuilderKt.resetRange(r14, r15 - r11, r15);
        goto L6
    }

    private final int retainOrRemoveAllInternal(int r10, int r11, Collection<? extends E> r12, boolean r13) {
        ListBuilder<E> r14 = this.backing;
        if (r14 == null) goto L6;
        int r15 = r14.retainOrRemoveAllInternal(r10, r11, r12, r13);
        this.length -= r15;
        return r15;
    L6:
        int r16 = 0;
        int r17 = 0;
    L7:
        if (r16 >= r11) goto L12;
        int r18 = r10 + r16;
        if (r12.contains(this.array[r18]) == r13) goto L10;
        r16 = r16 + 1;
        goto L7
    L10:
        E[] r19 = this.array;
        r16 = r16 + 1;
        r19[r17 + r10] = r19[r18];
        r17 = r17 + 1;
        goto L7
    L12:
        int r20 = r11 - r17;
        E[] r21 = this.array;
        ArraysKt.copyInto(r21, r21, r10 + r17, r11 + r10, this.length);
        E[] r22 = this.array;
        int r23 = this.length;
        ListBuilderKt.resetRange(r22, r23 - r20, r23);
        this.length -= r20;
        return r20;
    }

    private final Object writeReplace() {
        if (isEffectivelyReadOnly() == false) goto L7;
        return new SerializedCollection(this, 0);
    L7:
        throw new NotSerializableException("The list cannot be serialized while it is being built.");
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public void add(int r10, E r11) {
        checkIsMutable();
        AbstractList.Companion.checkPositionIndex$kotlin_stdlib(r10, this.length);
        addAtInternal(this.offset + r10, r11);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E r10) {
        checkIsMutable();
        addAtInternal(this.offset + this.length, r10);
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int r10, Collection<? extends E> r11) {
        Intrinsics.checkNotNullParameter(r11, "elements");
        checkIsMutable();
        AbstractList.Companion.checkPositionIndex$kotlin_stdlib(r10, this.length);
        int r12 = r11.size();
        addAllInternal(this.offset + r10, r11, r12);
        if (r12 <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends E> r10) {
        Intrinsics.checkNotNullParameter(r10, "elements");
        checkIsMutable();
        int r11 = r10.size();
        addAllInternal(this.offset + this.length, r10, r11);
        if (r11 <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final List<E> build() {
        if (this.backing != null) goto L10;
        checkIsMutable();
        this.isReadOnly = true;
        if (this.length <= 0) goto L8;
        return this;
    L8:
        return Empty;
    L10:
        throw new IllegalStateException();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        checkIsMutable();
        removeRangeInternal(this.offset, this.length);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object r10) {
        if (r10 != this) goto L4;
    L9:
        return true;
    L4:
        if ((r10 instanceof List) == true) goto L6;
    L8:
        return false;
    L6:
        if (contentEquals((List) r10) == false) goto L8;
        goto L8
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int r10) {
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(r10, this.length);
        return this.array[this.offset + r10];
    }

    @Override // kotlin.collections.AbstractMutableList
    public int getSize() {
        return this.length;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        return ListBuilderKt.access$subarrayContentHashCode(this.array, this.offset, this.length);
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object r10) {
        int r11 = 0;
    L4:
        if (r11 >= this.length) goto L9;
        if (Intrinsics.areEqual(this.array[this.offset + r11], r10) == true) goto L7;
        r11 = r11 + 1;
        goto L4
    L7:
        return r11;
    L9:
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        if (this.length != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<E> iterator() {
        return new Itr(this, 0);
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object r10) {
        int r11 = this.length - 1;
    L3:
        if (r11 < 0) goto L8;
        if (Intrinsics.areEqual(this.array[this.offset + r11], r10) == true) goto L6;
        r11 = r11 - 1;
        goto L3
    L6:
        return r11;
    L8:
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<E> listIterator() {
        return new Itr(this, 0);
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<E> listIterator(int r10) {
        AbstractList.Companion.checkPositionIndex$kotlin_stdlib(r10, this.length);
        return new Itr(this, r10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object r10) {
        checkIsMutable();
        int r11 = indexOf(r10);
        if (r11 < 0) goto L5;
        remove(r11);
    L5:
        if (r11 < 0) goto L7;
        return true;
    L7:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection<? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "elements");
        checkIsMutable();
        if (retainOrRemoveAllInternal(this.offset, this.length, r10, false) <= 0) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // kotlin.collections.AbstractMutableList
    public E removeAt(int r10) {
        checkIsMutable();
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(r10, this.length);
        return removeAtInternal(this.offset + r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection<? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "elements");
        checkIsMutable();
        if (retainOrRemoveAllInternal(this.offset, this.length, r10, true) > 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public E set(int r10, E r11) {
        checkIsMutable();
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(r10, this.length);
        E[] r12 = this.array;
        int r13 = this.offset;
        E r14 = r12[r13 + r10];
        r12[r13 + r10] = r11;
        return r14;
    }

    @Override // java.util.AbstractList, java.util.List
    public List<E> subList(int r10, int r11) {
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(r10, r11, this.length);
        E[] r12 = this.array;
        int r13 = this.offset + r10;
        int r14 = r11 - r10;
        boolean r15 = this.isReadOnly;
        ListBuilder<E> r16 = this.root;
        if (r16 != null) goto L5;
        ListBuilder<E> r17 = this;
    L7:
        return new ListBuilder(r12, r13, r14, r15, this, r17);
    L5:
        r17 = r16;
        goto L7
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        E[] r10 = this.array;
        int r11 = this.offset;
        return ArraysKt.copyOfRange(r10, r11, this.length + r11);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public <T> T[] toArray(T[] r10) {
        Intrinsics.checkNotNullParameter(r10, "destination");
        int r11 = r10.length;
        int r12 = this.length;
        if (r11 >= r12) goto L6;
        E[] r13 = this.array;
        int r14 = this.offset;
        T[] r15 = (T[]) Arrays.copyOfRange(r13, r14, r12 + r14, r10.getClass());
        Intrinsics.checkNotNullExpressionValue(r15, "copyOfRange(array, offse…h, destination.javaClass)");
        return r15;
    L6:
        E[] r16 = this.array;
        int r17 = this.offset;
        ArraysKt.copyInto(r16, r10, 0, r17, r12 + r17);
        int r18 = r10.length;
        int r19 = this.length;
        if (r18 <= r19) goto L9;
        r10[r19] = null;
    L9:
        return r10;
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return ListBuilderKt.access$subarrayContentToString(this.array, this.offset, this.length);
    }
}
