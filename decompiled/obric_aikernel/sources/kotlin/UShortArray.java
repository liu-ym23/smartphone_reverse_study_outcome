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
@SourceDebugExtension({"SMAP\nUShortArray.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UShortArray.kt\nkotlin/UShortArray\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,86:1\n1726#2,3:87\n*S KotlinDebug\n*F\n+ 1 UShortArray.kt\nkotlin/UShortArray\n*L\n62#1:87,3\n*E\n"})
public final class UShortArray implements Collection<UShort>, KMappedMarker {
    private final short[] storage;

    private static final class Iterator implements java.util.Iterator<UShort>, KMappedMarker {
        private final short[] array;
        private int index;

        public Iterator(short[] r10) {
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
        public /* bridge */ /* synthetic */ UShort next() {
            return UShort.m307boximpl(m381nextMh2AYeg());
        }

        /* JADX INFO: renamed from: next-Mh2AYeg, reason: not valid java name */
        public short m381nextMh2AYeg() {
            int r10 = this.index;
            short[] r11 = this.array;
            if (r10 >= r11.length) goto L7;
            this.index = r10 + 1;
            return UShort.m313constructorimpl(r11[r10]);
        L7:
            throw new NoSuchElementException(String.valueOf(this.index));
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @PublishedApi
    private /* synthetic */ UShortArray(short[] r10) {
        this.storage = r10;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ UShortArray m364boximpl(short[] r10) {
        return new UShortArray(r10);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static short[] m365constructorimpl(int r10) {
        return m366constructorimpl(new short[r10]);
    }

    @PublishedApi
    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static short[] m366constructorimpl(short[] r10) {
        Intrinsics.checkNotNullParameter(r10, Scraps.STORAGE);
        return r10;
    }

    /* JADX INFO: renamed from: contains-xj2QHRw, reason: not valid java name */
    public static boolean m367containsxj2QHRw(short[] r10, short r11) {
        return ArraysKt.contains(r10, r11);
    }

    /* JADX INFO: renamed from: containsAll-impl, reason: not valid java name */
    public static boolean m368containsAllimpl(short[] r10, Collection<UShort> r11) {
        Intrinsics.checkNotNullParameter(r11, "elements");
        if (r11.isEmpty() == true) goto L15;
        java.util.Iterator<T> r12 = r11.iterator();
    L7:
        if (r12.hasNext() == false) goto L15;
        Object r13 = r12.next();
        if ((r13 instanceof UShort) == true) goto L11;
    L13:
        boolean r14 = false;
    L14:
        if (r14 == true) goto L7;
        return false;
    L11:
        if (ArraysKt.contains(r10, ((UShort) r13).m363unboximpl()) == false) goto L13;
        r14 = true;
    L15:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m369equalsimpl(short[] r10, Object r11) {
        if ((r11 instanceof UShortArray) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(r10, ((UShortArray) r11).m380unboximpl()) == true) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m370equalsimpl0(short[] r10, short[] r11) {
        return Intrinsics.areEqual(r10, r11);
    }

    /* JADX INFO: renamed from: get-Mh2AYeg, reason: not valid java name */
    public static final short m371getMh2AYeg(short[] r10, int r11) {
        return UShort.m313constructorimpl(r10[r11]);
    }

    /* JADX INFO: renamed from: getSize-impl, reason: not valid java name */
    public static int m372getSizeimpl(short[] r10) {
        return r10.length;
    }

    @PublishedApi
    public static /* synthetic */ void getStorage$annotations() {
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m373hashCodeimpl(short[] r10) {
        return Arrays.hashCode(r10);
    }

    /* JADX INFO: renamed from: isEmpty-impl, reason: not valid java name */
    public static boolean m374isEmptyimpl(short[] r10) {
        if (r10.length != 0) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: iterator-impl, reason: not valid java name */
    public static java.util.Iterator<UShort> m375iteratorimpl(short[] r10) {
        return new Iterator(r10);
    }

    /* JADX INFO: renamed from: set-01HTLdE, reason: not valid java name */
    public static final void m376set01HTLdE(short[] r10, int r11, short r12) {
        r10[r11] = r12;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m377toStringimpl(short[] r10) {
        return "UShortArray(storage=" + Arrays.toString(r10) + ')';
    }

    @Override // java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(UShort r10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX INFO: renamed from: add-xj2QHRw, reason: not valid java name */
    public boolean m378addxj2QHRw(short r10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends UShort> r10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object r10) {
        if ((r10 instanceof UShort) == true) goto L7;
        return false;
    L7:
        return m379containsxj2QHRw(((UShort) r10).m363unboximpl());
    }

    /* JADX INFO: renamed from: contains-xj2QHRw, reason: not valid java name */
    public boolean m379containsxj2QHRw(short r10) {
        return m367containsxj2QHRw(this.storage, r10);
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "elements");
        return m368containsAllimpl(this.storage, r10);
    }

    @Override // java.util.Collection
    public boolean equals(Object r10) {
        return m369equalsimpl(this.storage, r10);
    }

    public int getSize() {
        return m372getSizeimpl(this.storage);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return m373hashCodeimpl(this.storage);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return m374isEmptyimpl(this.storage);
    }

    @Override // java.util.Collection, java.lang.Iterable
    public java.util.Iterator<UShort> iterator() {
        return m375iteratorimpl(this.storage);
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
        return m377toStringimpl(this.storage);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ short[] m380unboximpl() {
        return this.storage;
    }
}
