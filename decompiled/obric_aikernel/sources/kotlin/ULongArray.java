package kotlin;

import com.bytedance.crash.dumper.Scraps;
import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes2.dex */
@SinceKotlin(version = "1.3")
@ExperimentalUnsignedTypes
@JvmInline
@SourceDebugExtension({"SMAP\nULongArray.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ULongArray.kt\nkotlin/ULongArray\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,86:1\n1726#2,3:87\n*S KotlinDebug\n*F\n+ 1 ULongArray.kt\nkotlin/ULongArray\n*L\n62#1:87,3\n*E\n"})
public final class ULongArray implements Collection<ULong>, KMappedMarker {
    private final long[] storage;

    private static final class Iterator implements java.util.Iterator<ULong>, KMappedMarker {
        private final long[] array;
        private int index;

        public Iterator(long[] r10) {
            Intrinsics.checkNotNullParameter(r10, "array");
            this.array = r10;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.index >= this.array.length) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ ULong next() {
            return ULong.m200boximpl(m276nextsVKNKU());
        }

        /* JADX INFO: renamed from: next-s-VKNKU, reason: not valid java name */
        public long m276nextsVKNKU() {
            int r10 = this.index;
            long[] r11 = this.array;
            if (r10 >= r11.length) goto L7;
            this.index = r10 + 1;
            return ULong.m206constructorimpl(r11[r10]);
        L7:
            throw new NoSuchElementException(String.valueOf(this.index));
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @PublishedApi
    private /* synthetic */ ULongArray(long[] r10) {
        this.storage = r10;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ ULongArray m259boximpl(long[] r10) {
        return new ULongArray(r10);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long[] m260constructorimpl(int r10) {
        return m261constructorimpl(new long[r10]);
    }

    @PublishedApi
    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long[] m261constructorimpl(long[] r10) {
        Intrinsics.checkNotNullParameter(r10, Scraps.STORAGE);
        return r10;
    }

    /* JADX INFO: renamed from: contains-VKZWuLQ, reason: not valid java name */
    public static boolean m262containsVKZWuLQ(long[] r10, long r11) {
        return ArraysKt.contains(r10, r11);
    }

    /* JADX INFO: renamed from: containsAll-impl, reason: not valid java name */
    public static boolean m263containsAllimpl(long[] r10, Collection<ULong> r11) {
        Intrinsics.checkNotNullParameter(r11, "elements");
        if (r11.isEmpty() == true) goto L15;
        java.util.Iterator<T> r12 = r11.iterator();
    L7:
        if (r12.hasNext() == false) goto L15;
        Object r13 = r12.next();
        if ((r13 instanceof ULong) == true) goto L11;
    L13:
        boolean r14 = false;
    L14:
        if (r14 == true) goto L7;
        return false;
    L11:
        if (ArraysKt.contains(r10, ((ULong) r13).m258unboximpl()) == false) goto L13;
        r14 = true;
    L15:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m264equalsimpl(long[] r10, Object r11) {
        if ((r11 instanceof ULongArray) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(r10, ((ULongArray) r11).m275unboximpl()) == true) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m265equalsimpl0(long[] r10, long[] r11) {
        return Intrinsics.areEqual(r10, r11);
    }

    /* JADX INFO: renamed from: get-s-VKNKU, reason: not valid java name */
    public static final long m266getsVKNKU(long[] r10, int r11) {
        return ULong.m206constructorimpl(r10[r11]);
    }

    /* JADX INFO: renamed from: getSize-impl, reason: not valid java name */
    public static int m267getSizeimpl(long[] r10) {
        return r10.length;
    }

    @PublishedApi
    public static /* synthetic */ void getStorage$annotations() {
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m268hashCodeimpl(long[] r10) {
        return Arrays.hashCode(r10);
    }

    /* JADX INFO: renamed from: isEmpty-impl, reason: not valid java name */
    public static boolean m269isEmptyimpl(long[] r10) {
        if (r10.length != 0) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: iterator-impl, reason: not valid java name */
    public static java.util.Iterator<ULong> m270iteratorimpl(long[] r10) {
        return new Iterator(r10);
    }

    /* JADX INFO: renamed from: set-k8EXiF4, reason: not valid java name */
    public static final void m271setk8EXiF4(long[] r10, int r11, long r12) {
        r10[r11] = r12;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m272toStringimpl(long[] r10) {
        return "ULongArray(storage=" + Arrays.toString(r10) + ')';
    }

    @Override // java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(ULong r10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX INFO: renamed from: add-VKZWuLQ, reason: not valid java name */
    public boolean m273addVKZWuLQ(long r10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends ULong> r10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object r10) {
        if ((r10 instanceof ULong) == true) goto L7;
        return false;
    L7:
        return m274containsVKZWuLQ(((ULong) r10).m258unboximpl());
    }

    /* JADX INFO: renamed from: contains-VKZWuLQ, reason: not valid java name */
    public boolean m274containsVKZWuLQ(long r10) {
        return m262containsVKZWuLQ(this.storage, r10);
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "elements");
        return m263containsAllimpl(this.storage, r10);
    }

    @Override // java.util.Collection
    public boolean equals(Object r10) {
        return m264equalsimpl(this.storage, r10);
    }

    public int getSize() {
        return m267getSizeimpl(this.storage);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return m268hashCodeimpl(this.storage);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return m269isEmptyimpl(this.storage);
    }

    @Override // java.util.Collection, java.lang.Iterable
    public java.util.Iterator<ULong> iterator() {
        return m270iteratorimpl(this.storage);
    }

    @Override // java.util.Collection
    public boolean remove(Object r10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<? extends Object> r10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<? extends Object> r10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public /* bridge */ /* synthetic */ int size() {
        return getSize();
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] r10) {
        Intrinsics.checkNotNullParameter(r10, "array");
        return (T[]) CollectionToArray.toArray(this, r10);
    }

    public String toString() {
        return m272toStringimpl(this.storage);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long[] m275unboximpl() {
        return this.storage;
    }
}
