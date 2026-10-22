package kotlin.collections;

import com.bytedance.apm6.consumer.slardar.Constants;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX WARN: Unexpected interfaces in signature: [kotlin.jvm.internal.markers.KMappedMarker] */
/* JADX INFO: loaded from: classes2.dex */
@SinceKotlin(version = "1.1")
@SourceDebugExtension({"SMAP\nAbstractList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractList.kt\nkotlin/collections/AbstractList\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,157:1\n350#2,7:158\n378#2,7:165\n*S KotlinDebug\n*F\n+ 1 AbstractList.kt\nkotlin/collections/AbstractList\n*L\n27#1:158,7\n29#1:165,7\n*E\n"})
public abstract class AbstractList<E> extends AbstractCollection<E> implements List<E> {
    public static final Companion Companion = null;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        public final void checkBoundsIndexes$kotlin_stdlib(int r10, int r11, int r12) {
            if (r10 < 0) goto L10;
            if (r11 > r12) goto L10;
            if (r10 > r11) goto L8;
            return;
        L8:
            throw new IllegalArgumentException("startIndex: " + r10 + " > endIndex: " + r11);
        L10:
            throw new IndexOutOfBoundsException("startIndex: " + r10 + ", endIndex: " + r11 + ", size: " + r12);
        }

        public final void checkElementIndex$kotlin_stdlib(int r10, int r11) {
            if (r10 < 0) goto L6;
            if (r10 >= r11) goto L6;
            return;
        L6:
            throw new IndexOutOfBoundsException("index: " + r10 + ", size: " + r11);
        }

        public final void checkPositionIndex$kotlin_stdlib(int r10, int r11) {
            if (r10 < 0) goto L6;
            if (r10 > r11) goto L6;
            return;
        L6:
            throw new IndexOutOfBoundsException("index: " + r10 + ", size: " + r11);
        }

        public final void checkRangeIndexes$kotlin_stdlib(int r10, int r11, int r12) {
            if (r10 < 0) goto L10;
            if (r11 > r12) goto L10;
            if (r10 > r11) goto L8;
            return;
        L8:
            throw new IllegalArgumentException("fromIndex: " + r10 + " > toIndex: " + r11);
        L10:
            throw new IndexOutOfBoundsException("fromIndex: " + r10 + ", toIndex: " + r11 + ", size: " + r12);
        }

        public final boolean orderedEquals$kotlin_stdlib(Collection<?> r10, Collection<?> r11) {
            Intrinsics.checkNotNullParameter(r10, "c");
            Intrinsics.checkNotNullParameter(r11, "other");
            if (r10.size() == r11.size()) goto L5;
            return false;
        L5:
            Iterator<?> r12 = r11.iterator();
            Iterator<?> r13 = r10.iterator();
        L7:
            if (r13.hasNext() == false) goto L11;
            if (Intrinsics.areEqual(r13.next(), r12.next()) == true) goto L7;
            return false;
        L11:
            return true;
        }

        public final int orderedHashCode$kotlin_stdlib(Collection<?> r10) {
            Intrinsics.checkNotNullParameter(r10, "c");
            Iterator<?> r11 = r10.iterator();
            int r12 = 1;
        L4:
            if (r11.hasNext() == false) goto L10;
            Object r13 = r11.next();
            int r14 = r12 * 31;
            if (r13 == null) goto L8;
            int r15 = r13.hashCode();
        L9:
            r12 = r14 + r15;
            goto L4
        L8:
            r15 = 0;
            goto L9
        L10:
            return r12;
        }
    }

    private class IteratorImpl implements Iterator<E>, KMappedMarker {
        private int index;
        final /* synthetic */ AbstractList<E> this$0;

        public IteratorImpl(AbstractList r10) {
            this.this$0 = r10;
        }

        protected final int getIndex() {
            return this.index;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.index >= this.this$0.size()) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Iterator
        public E next() {
            if (hasNext() == false) goto L7;
            AbstractList<E> r10 = this.this$0;
            int r11 = this.index;
            this.index = r11 + 1;
            return r10.get(r11);
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        protected final void setIndex(int r10) {
            this.index = r10;
        }
    }

    /* JADX WARN: Unexpected interfaces in signature: [kotlin.jvm.internal.markers.KMappedMarker] */
    private class ListIteratorImpl extends AbstractList<E>.IteratorImpl implements ListIterator<E> {
        final /* synthetic */ AbstractList<E> this$0;

        public ListIteratorImpl(AbstractList r10, int r11) {
            this.this$0 = r10;
            super(r10);
            AbstractList.Companion.checkPositionIndex$kotlin_stdlib(r11, r10.size());
            setIndex(r11);
        }

        @Override // java.util.ListIterator
        public void add(E r10) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            if (getIndex() <= 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return getIndex();
        }

        @Override // java.util.ListIterator
        public E previous() {
            if (hasPrevious() == false) goto L7;
            AbstractList<E> r10 = this.this$0;
            setIndex(getIndex() - 1);
            return r10.get(getIndex());
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return getIndex() - 1;
        }

        @Override // java.util.ListIterator
        public void set(E r10) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    private static final class SubList<E> extends AbstractList<E> implements RandomAccess {
        private int _size;
        private final int fromIndex;
        private final AbstractList<E> list;

        /* JADX WARN: Multi-variable type inference failed */
        public SubList(AbstractList<? extends E> r10, int r11, int r12) {
            Intrinsics.checkNotNullParameter(r10, Constants.KEY_LIST);
            this.list = r10;
            this.fromIndex = r11;
            AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(r11, r12, r10.size());
            this._size = r12 - r11;
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        public E get(int r10) {
            AbstractList.Companion.checkElementIndex$kotlin_stdlib(r10, this._size);
            return this.list.get(this.fromIndex + r10);
        }

        @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
        public int getSize() {
            return this._size;
        }
    }

    static {
        Companion = new Companion(null);
    }

    protected AbstractList() {
    }

    @Override // java.util.List
    public void add(int r10, E r11) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public boolean addAll(int r10, Collection<? extends E> r11) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof List) == true) goto L10;
        return false;
    L10:
        return Companion.orderedEquals$kotlin_stdlib(this, (Collection) r10);
    }

    @Override // java.util.List
    public abstract E get(int r10);

    @Override // kotlin.collections.AbstractCollection
    public abstract int getSize();

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        return Companion.orderedHashCode$kotlin_stdlib(this);
    }

    @Override // java.util.List
    public int indexOf(E r10) {
        Iterator<E> r11 = iterator();
        int r12 = 0;
    L4:
        if (r11.hasNext() == false) goto L9;
        if (Intrinsics.areEqual(r11.next(), r10) == true) goto L13;
        r12 = r12 + 1;
        goto L4
    L13:
        return r12;
    L9:
        return -1;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return new IteratorImpl(this);
    }

    @Override // java.util.List
    public int lastIndexOf(E r10) {
        ListIterator<E> r11 = listIterator(size());
    L4:
        if (r11.hasPrevious() == false) goto L8;
        if (Intrinsics.areEqual(r11.previous(), r10) == false) goto L4;
        return r11.nextIndex();
    L8:
        return -1;
    }

    @Override // java.util.List
    public ListIterator<E> listIterator() {
        return new ListIteratorImpl(this, 0);
    }

    @Override // java.util.List
    public ListIterator<E> listIterator(int r10) {
        return new ListIteratorImpl(this, r10);
    }

    @Override // java.util.List
    public E remove(int r10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public E set(int r10, E r11) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public List<E> subList(int r10, int r11) {
        return new SubList(this, r10, r11);
    }
}
