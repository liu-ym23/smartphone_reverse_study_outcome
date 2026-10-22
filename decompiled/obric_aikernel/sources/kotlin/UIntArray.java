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
@SourceDebugExtension({"SMAP\nUIntArray.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UIntArray.kt\nkotlin/UIntArray\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,86:1\n1726#2,3:87\n*S KotlinDebug\n*F\n+ 1 UIntArray.kt\nkotlin/UIntArray\n*L\n62#1:87,3\n*E\n"})
public final class UIntArray implements Collection<UInt>, KMappedMarker {
    private final int[] storage;

    private static final class Iterator implements java.util.Iterator<UInt>, KMappedMarker {
        private final int[] array;
        private int index;

        public Iterator(int[] r10) {
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
        public /* bridge */ /* synthetic */ UInt next() {
            return UInt.m121boximpl(m197nextpVg5ArA());
        }

        /* JADX INFO: renamed from: next-pVg5ArA, reason: not valid java name */
        public int m197nextpVg5ArA() {
            int r10 = this.index;
            int[] r11 = this.array;
            if (r10 >= r11.length) goto L7;
            this.index = r10 + 1;
            return UInt.m127constructorimpl(r11[r10]);
        L7:
            throw new NoSuchElementException(String.valueOf(this.index));
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @PublishedApi
    private /* synthetic */ UIntArray(int[] r10) {
        this.storage = r10;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ UIntArray m180boximpl(int[] r10) {
        return new UIntArray(r10);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int[] m181constructorimpl(int r10) {
        return m182constructorimpl(new int[r10]);
    }

    @PublishedApi
    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int[] m182constructorimpl(int[] r10) {
        Intrinsics.checkNotNullParameter(r10, Scraps.STORAGE);
        return r10;
    }

    /* JADX INFO: renamed from: contains-WZ4Q5Ns, reason: not valid java name */
    public static boolean m183containsWZ4Q5Ns(int[] r10, int r11) {
        return ArraysKt.contains(r10, r11);
    }

    /* JADX INFO: renamed from: containsAll-impl, reason: not valid java name */
    public static boolean m184containsAllimpl(int[] r10, Collection<UInt> r11) {
        Intrinsics.checkNotNullParameter(r11, "elements");
        if (r11.isEmpty() == true) goto L15;
        java.util.Iterator<T> r12 = r11.iterator();
    L7:
        if (r12.hasNext() == false) goto L15;
        Object r13 = r12.next();
        if ((r13 instanceof UInt) == true) goto L11;
    L13:
        boolean r14 = false;
    L14:
        if (r14 == true) goto L7;
        return false;
    L11:
        if (ArraysKt.contains(r10, ((UInt) r13).m179unboximpl()) == false) goto L13;
        r14 = true;
    L15:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m185equalsimpl(int[] r10, Object r11) {
        if ((r11 instanceof UIntArray) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(r10, ((UIntArray) r11).m196unboximpl()) == true) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m186equalsimpl0(int[] r10, int[] r11) {
        return Intrinsics.areEqual(r10, r11);
    }

    /* JADX INFO: renamed from: get-pVg5ArA, reason: not valid java name */
    public static final int m187getpVg5ArA(int[] r10, int r11) {
        return UInt.m127constructorimpl(r10[r11]);
    }

    /* JADX INFO: renamed from: getSize-impl, reason: not valid java name */
    public static int m188getSizeimpl(int[] r10) {
        return r10.length;
    }

    @PublishedApi
    public static /* synthetic */ void getStorage$annotations() {
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m189hashCodeimpl(int[] r10) {
        return Arrays.hashCode(r10);
    }

    /* JADX INFO: renamed from: isEmpty-impl, reason: not valid java name */
    public static boolean m190isEmptyimpl(int[] r10) {
        if (r10.length != 0) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: iterator-impl, reason: not valid java name */
    public static java.util.Iterator<UInt> m191iteratorimpl(int[] r10) {
        return new Iterator(r10);
    }

    /* JADX INFO: renamed from: set-VXSXFK8, reason: not valid java name */
    public static final void m192setVXSXFK8(int[] r10, int r11, int r12) {
        r10[r11] = r12;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m193toStringimpl(int[] r10) {
        return "UIntArray(storage=" + Arrays.toString(r10) + ')';
    }

    @Override // java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(UInt r10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX INFO: renamed from: add-WZ4Q5Ns, reason: not valid java name */
    public boolean m194addWZ4Q5Ns(int r10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends UInt> r10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object r10) {
        if ((r10 instanceof UInt) == true) goto L7;
        return false;
    L7:
        return m195containsWZ4Q5Ns(((UInt) r10).m179unboximpl());
    }

    /* JADX INFO: renamed from: contains-WZ4Q5Ns, reason: not valid java name */
    public boolean m195containsWZ4Q5Ns(int r10) {
        return m183containsWZ4Q5Ns(this.storage, r10);
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "elements");
        return m184containsAllimpl(this.storage, r10);
    }

    @Override // java.util.Collection
    public boolean equals(Object r10) {
        return m185equalsimpl(this.storage, r10);
    }

    public int getSize() {
        return m188getSizeimpl(this.storage);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return m189hashCodeimpl(this.storage);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return m190isEmptyimpl(this.storage);
    }

    @Override // java.util.Collection, java.lang.Iterable
    public java.util.Iterator<UInt> iterator() {
        return m191iteratorimpl(this.storage);
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
        return m193toStringimpl(this.storage);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int[] m196unboximpl() {
        return this.storage;
    }
}
