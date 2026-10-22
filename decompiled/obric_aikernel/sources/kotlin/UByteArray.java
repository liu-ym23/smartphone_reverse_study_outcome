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
@SourceDebugExtension({"SMAP\nUByteArray.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UByteArray.kt\nkotlin/UByteArray\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,86:1\n1726#2,3:87\n*S KotlinDebug\n*F\n+ 1 UByteArray.kt\nkotlin/UByteArray\n*L\n62#1:87,3\n*E\n"})
public final class UByteArray implements Collection<UByte>, KMappedMarker {
    private final byte[] storage;

    private static final class Iterator implements java.util.Iterator<UByte>, KMappedMarker {
        private final byte[] array;
        private int index;

        public Iterator(byte[] r10) {
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
        public /* bridge */ /* synthetic */ UByte next() {
            return UByte.m44boximpl(m118nextw2LRezQ());
        }

        /* JADX INFO: renamed from: next-w2LRezQ, reason: not valid java name */
        public byte m118nextw2LRezQ() {
            int r10 = this.index;
            byte[] r11 = this.array;
            if (r10 >= r11.length) goto L7;
            this.index = r10 + 1;
            return UByte.m50constructorimpl(r11[r10]);
        L7:
            throw new NoSuchElementException(String.valueOf(this.index));
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @PublishedApi
    private /* synthetic */ UByteArray(byte[] r10) {
        this.storage = r10;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ UByteArray m101boximpl(byte[] r10) {
        return new UByteArray(r10);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static byte[] m102constructorimpl(int r10) {
        return m103constructorimpl(new byte[r10]);
    }

    @PublishedApi
    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static byte[] m103constructorimpl(byte[] r10) {
        Intrinsics.checkNotNullParameter(r10, Scraps.STORAGE);
        return r10;
    }

    /* JADX INFO: renamed from: contains-7apg3OU, reason: not valid java name */
    public static boolean m104contains7apg3OU(byte[] r10, byte r11) {
        return ArraysKt.contains(r10, r11);
    }

    /* JADX INFO: renamed from: containsAll-impl, reason: not valid java name */
    public static boolean m105containsAllimpl(byte[] r10, Collection<UByte> r11) {
        Intrinsics.checkNotNullParameter(r11, "elements");
        if (r11.isEmpty() == true) goto L15;
        java.util.Iterator<T> r12 = r11.iterator();
    L7:
        if (r12.hasNext() == false) goto L15;
        Object r13 = r12.next();
        if ((r13 instanceof UByte) == true) goto L11;
    L13:
        boolean r14 = false;
    L14:
        if (r14 == true) goto L7;
        return false;
    L11:
        if (ArraysKt.contains(r10, ((UByte) r13).m100unboximpl()) == false) goto L13;
        r14 = true;
    L15:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m106equalsimpl(byte[] r10, Object r11) {
        if ((r11 instanceof UByteArray) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(r10, ((UByteArray) r11).m117unboximpl()) == true) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m107equalsimpl0(byte[] r10, byte[] r11) {
        return Intrinsics.areEqual(r10, r11);
    }

    /* JADX INFO: renamed from: get-w2LRezQ, reason: not valid java name */
    public static final byte m108getw2LRezQ(byte[] r10, int r11) {
        return UByte.m50constructorimpl(r10[r11]);
    }

    /* JADX INFO: renamed from: getSize-impl, reason: not valid java name */
    public static int m109getSizeimpl(byte[] r10) {
        return r10.length;
    }

    @PublishedApi
    public static /* synthetic */ void getStorage$annotations() {
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m110hashCodeimpl(byte[] r10) {
        return Arrays.hashCode(r10);
    }

    /* JADX INFO: renamed from: isEmpty-impl, reason: not valid java name */
    public static boolean m111isEmptyimpl(byte[] r10) {
        if (r10.length != 0) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: iterator-impl, reason: not valid java name */
    public static java.util.Iterator<UByte> m112iteratorimpl(byte[] r10) {
        return new Iterator(r10);
    }

    /* JADX INFO: renamed from: set-VurrAj0, reason: not valid java name */
    public static final void m113setVurrAj0(byte[] r10, int r11, byte r12) {
        r10[r11] = r12;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m114toStringimpl(byte[] r10) {
        return "UByteArray(storage=" + Arrays.toString(r10) + ')';
    }

    @Override // java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(UByte r10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX INFO: renamed from: add-7apg3OU, reason: not valid java name */
    public boolean m115add7apg3OU(byte r10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends UByte> r10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object r10) {
        if ((r10 instanceof UByte) == true) goto L7;
        return false;
    L7:
        return m116contains7apg3OU(((UByte) r10).m100unboximpl());
    }

    /* JADX INFO: renamed from: contains-7apg3OU, reason: not valid java name */
    public boolean m116contains7apg3OU(byte r10) {
        return m104contains7apg3OU(this.storage, r10);
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "elements");
        return m105containsAllimpl(this.storage, r10);
    }

    @Override // java.util.Collection
    public boolean equals(Object r10) {
        return m106equalsimpl(this.storage, r10);
    }

    public int getSize() {
        return m109getSizeimpl(this.storage);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return m110hashCodeimpl(this.storage);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return m111isEmptyimpl(this.storage);
    }

    @Override // java.util.Collection, java.lang.Iterable
    public java.util.Iterator<UByte> iterator() {
        return m112iteratorimpl(this.storage);
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
        return m114toStringimpl(this.storage);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ byte[] m117unboximpl() {
        return this.storage;
    }
}
