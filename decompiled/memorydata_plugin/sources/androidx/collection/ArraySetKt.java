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
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0015\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u0004H\u0086\b\u001a+\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u00042\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00040\u0006\"\u0002H\u0004¢\u0006\u0002\u0010\u0007\u001a)\u0010\b\u001a\u00020\t\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u00032\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\n0\u0003H\u0080\b\u001a'\u0010\b\u001a\u00020\f\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\n0\u000eH\u0080\b\u001a&\u0010\u000f\u001a\u00020\f\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u00032\u0006\u0010\u0010\u001a\u0002H\nH\u0080\b¢\u0006\u0002\u0010\u0011\u001a \u0010\u0012\u001a\u00020\t\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u00032\u0006\u0010\u0013\u001a\u00020\u0001H\u0000\u001a \u0010\u0014\u001a\u00020\u0001\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u00032\u0006\u0010\u0015\u001a\u00020\u0001H\u0000\u001a\u0019\u0010\u0016\u001a\u00020\t\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u0003H\u0080\b\u001a'\u0010\u0017\u001a\u00020\f\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\n0\u000eH\u0080\b\u001a&\u0010\u0018\u001a\u00020\f\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u00032\u0006\u0010\u0010\u001a\u0002H\nH\u0080\b¢\u0006\u0002\u0010\u0011\u001a!\u0010\u0019\u001a\u00020\t\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u00032\u0006\u0010\u001a\u001a\u00020\u0001H\u0080\b\u001a#\u0010\u001b\u001a\u00020\f\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0080\b\u001a\u0019\u0010\u001e\u001a\u00020\u0001\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u0003H\u0080\b\u001a*\u0010\u001f\u001a\u00020\u0001\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u00032\b\u0010 \u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0015\u001a\u00020\u0001H\u0000\u001a#\u0010!\u001a\u00020\u0001\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u00032\b\u0010 \u001a\u0004\u0018\u00010\u001dH\u0080\b\u001a\u0018\u0010\"\u001a\u00020\u0001\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u0003H\u0000\u001a\u0019\u0010#\u001a\u00020\f\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u0003H\u0080\b\u001a)\u0010$\u001a\u00020\f\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u00032\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\n0\u0003H\u0080\b\u001a'\u0010$\u001a\u00020\f\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\n0\u000eH\u0080\b\u001a&\u0010%\u001a\u0002H\n\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u00032\u0006\u0010&\u001a\u00020\u0001H\u0080\b¢\u0006\u0002\u0010'\u001a&\u0010(\u001a\u00020\f\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u00032\u0006\u0010\u0010\u001a\u0002H\nH\u0080\b¢\u0006\u0002\u0010\u0011\u001a'\u0010)\u001a\u00020\f\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\n0\u000eH\u0080\b\u001a\u0019\u0010*\u001a\u00020+\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u0003H\u0080\b\u001a&\u0010,\u001a\u0002H\n\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u00032\u0006\u0010&\u001a\u00020\u0001H\u0080\b¢\u0006\u0002\u0010'\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"ARRAY_SET_BASE_SIZE", "", "arraySetOf", "Landroidx/collection/ArraySet;", ExifInterface.GPS_DIRECTION_TRUE, "values", "", "([Ljava/lang/Object;)Landroidx/collection/ArraySet;", "addAllInternal", "", ExifInterface.LONGITUDE_EAST, "array", "", "elements", "", "addInternal", "element", "(Landroidx/collection/ArraySet;Ljava/lang/Object;)Z", "allocArrays", "size", "binarySearchInternal", "hash", "clearInternal", "containsAllInternal", "containsInternal", "ensureCapacityInternal", "minimumCapacity", "equalsInternal", "other", "", "hashCodeInternal", "indexOf", "key", "indexOfInternal", "indexOfNull", "isEmptyInternal", "removeAllInternal", "removeAtInternal", "index", "(Landroidx/collection/ArraySet;I)Ljava/lang/Object;", "removeInternal", "retainAllInternal", "toStringInternal", "", "valueAtInternal", "collection"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ArraySetKt {
    public static final int ARRAY_SET_BASE_SIZE = 4;

    public static final <E> void addAllInternal(ArraySet<E> r8, ArraySet<? extends E> r9) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Intrinsics.checkNotNullParameter(r9, "array");
        int r0 = r9.get_size$collection();
        r8.ensureCapacity(r8.get_size$collection() + r0);
        if (r8.get_size$collection() != 0) goto L10;
        if (r0 <= 0) goto L13;
        ArraysKt.copyInto$default(r9.getHashes$collection(), r8.getHashes$collection(), 0, 0, r0, 6, null);
        ArraysKt.copyInto$default(r9.getArray$collection(), r8.getArray$collection(), 0, 0, r0, 6, null);
        if (r8.get_size$collection() != 0) goto L9;
        r8.set_size$collection(r0);
        return;
    L9:
        throw new ConcurrentModificationException();
    L13:
        return;
    L10:
        int r1 = 0;
    L11:
        if (r1 >= r0) goto L16;
        r8.add(r9.valueAt(r1));
        r1 = r1 + 1;
        goto L11
    }

    public static final <E> boolean addAllInternal(ArraySet<E> r2, Collection<? extends E> r3) {
        Collection r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r4, "elements");
        r2.ensureCapacity(r2.get_size$collection() + r4.size());
        Iterator<E> r5 = r4.iterator();
        boolean r0 = false;
    L4:
        if (r5.hasNext() == false) goto L6;
        r0 = r0 | r2.add(r5.next());
        goto L4
    L6:
        return r0;
    }

    public static final <E> boolean addInternal(ArraySet<E> r17, E r18) {
        Intrinsics.checkNotNullParameter(r17, "<this>");
        int r2 = r17.get_size$collection();
        boolean r3 = false;
        if (r18 != null) goto L5;
        int r4 = indexOfNull(r17);
        int r5 = 0;
    L6:
        if (r4 < 0) goto L8;
        return false;
    L8:
        int r6 = ~r4;
        if (r2 < r17.getHashes$collection().length) goto L25;
        int r7 = 4;
        if (r2 < 8) goto L13;
        r7 = (r2 >> 1) + r2;
    L15:
        int[] r8 = r17.getHashes$collection();
        Object[] r15 = r17.getArray$collection();
        allocArrays(r17, r7);
        if (r2 != r17.get_size$collection()) goto L24;
        if (r17.getHashes$collection().length != 0) goto L21;
        r3 = true;
    L21:
        if ((!r3) == false) goto L25;
        ArraysKt.copyInto$default(r8, r17.getHashes$collection(), 0, 0, r8.length, 6, null);
        ArraysKt.copyInto$default(r15, r17.getArray$collection(), 0, 0, r15.length, 6, null);
        goto L25
    L24:
        throw new ConcurrentModificationException();
    L13:
        if (r2 < 4) goto L15;
        r7 = 8;
    L25:
        if (r6 >= r2) goto L28;
        int r9 = r6 + 1;
        ArraysKt.copyInto(r17.getHashes$collection(), r17.getHashes$collection(), r9, r6, r2);
        ArraysKt.copyInto(r17.getArray$collection(), r17.getArray$collection(), r9, r6, r2);
    L28:
        if (r2 != r17.get_size$collection()) goto L34;
        if (r6 >= r17.getHashes$collection().length) goto L34;
        r17.getHashes$collection()[r6] = r5;
        r17.getArray$collection()[r6] = r18;
        r17.set_size$collection(r17.get_size$collection() + 1);
        return true;
    L34:
        throw new ConcurrentModificationException();
    L5:
        int r10 = r18.hashCode();
        r5 = r10;
        r4 = indexOf(r17, r18, r10);
        goto L6
    }

    public static final <E> void allocArrays(ArraySet<E> r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        r1.setHashes$collection(new int[r2]);
        r1.setArray$collection(new Object[r2]);
    }

    public static final <T> ArraySet<T> arraySetOf() {
        return new ArraySet(0, 1, null);
    }

    public static final <T> ArraySet<T> arraySetOf(T... r4) {
        Intrinsics.checkNotNullParameter(r4, "values");
        ArraySet<T> r0 = new ArraySet(r4.length);
        int r1 = r4.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        r0.add(r4[r2]);
        r2 = r2 + 1;
        goto L3
    L5:
        return r0;
    }

    public static final <E> int binarySearchInternal(ArraySet<E> r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return ContainerHelpersKt.binarySearch(r1.getHashes$collection(), r1.get_size$collection(), r2);
    L6:
        throw new ConcurrentModificationException();
    }

    public static final <E> void clearInternal(ArraySet<E> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r1.get_size$collection() == 0) goto L6;
        r1.setHashes$collection(ContainerHelpersKt.EMPTY_INTS);
        r1.setArray$collection(ContainerHelpersKt.EMPTY_OBJECTS);
        r1.set_size$collection(0);
    L6:
        if (r1.get_size$collection() != 0) goto L9;
        return;
    L9:
        throw new ConcurrentModificationException();
    }

    public static final <E> boolean containsAllInternal(ArraySet<E> r2, Collection<? extends E> r3) {
        Collection r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r4, "elements");
        Iterator<E> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L9;
        if (r2.contains(r5.next()) == true) goto L4;
        return false;
    L9:
        return true;
    }

    public static final <E> boolean containsInternal(ArraySet<E> r1, E r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r1.indexOf(r2) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final <E> void ensureCapacityInternal(ArraySet<E> r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        int r0 = r10.get_size$collection();
        if (r10.getHashes$collection().length >= r11) goto L8;
        int[] r2 = r10.getHashes$collection();
        Object[] r1 = r10.getArray$collection();
        allocArrays(r10, r11);
        if (r10.get_size$collection() <= 0) goto L8;
        ArraysKt.copyInto$default(r2, r10.getHashes$collection(), 0, 0, r10.get_size$collection(), 6, null);
        ArraysKt.copyInto$default(r1, r10.getArray$collection(), 0, 0, r10.get_size$collection(), 6, null);
    L8:
        if (r10.get_size$collection() != r0) goto L11;
        return;
    L11:
        throw new ConcurrentModificationException();
    }

    public static final <E> boolean equalsInternal(ArraySet<E> r7, Object r8) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        if (r7 != r8) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r8, Set.class) == true) goto L8;
    L17:
        return false;
    L8:
        if (r7.size() == ((Set) ZeusTransformUtils.preCheckCast(r8, Set.class, "com.obric.memorydata.plugin")).size()) goto L19;
        return false;
    L19:
        int r1 = r7.get_size$collection();     // Catch: Throwable -> L18
        int r3 = 0;
    L11:
        if (r3 >= r1) goto L16;
        if (((Set) ZeusTransformUtils.preCheckCast(r8, Set.class, "com.obric.memorydata.plugin")).contains(r7.valueAt(r3)) == false) goto L14;
        r3 = r3 + 1;
        goto L11
    L14:
        return false;
    L16:
        return true;
    }

    public static final <E> int hashCodeInternal(ArraySet<E> r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        int[] r0 = r4.getHashes$collection();
        int r5 = r4.get_size$collection();
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r1 >= r5) goto L5;
        r2 = r2 + r0[r1];
        r1 = r1 + 1;
        goto L3
    L5:
        return r2;
    }

    public static final <E> int indexOf(ArraySet<E> r4, Object r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        int r0 = r4.get_size$collection();
        if (r0 != 0) goto L6;
        return -1;
    L6:
        int r1 = binarySearchInternal(r4, r6);
        if (r1 >= 0) goto L10;
        return r1;
    L10:
        if (Intrinsics.areEqual(r5, r4.getArray$collection()[r1]) == false) goto L12;
        return r1;
    L12:
        int r2 = r1 + 1;
    L13:
        if (r2 >= r0) goto L20;
        if (r4.getHashes$collection()[r2] != r6) goto L20;
        if (Intrinsics.areEqual(r5, r4.getArray$collection()[r2]) == true) goto L18;
        r2 = r2 + 1;
        goto L13
    L18:
        return r2;
    L20:
        int r3 = r1 - 1;
    L21:
        if (r3 < 0) goto L29;
        if (r4.getHashes$collection()[r3] != r6) goto L29;
        if (Intrinsics.areEqual(r5, r4.getArray$collection()[r3]) == true) goto L26;
        r3 = r3 - 1;
        goto L21
    L26:
        return r3;
    L29:
        return ~r2;
    }

    public static final <E> int indexOfInternal(ArraySet<E> r1, Object r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r2 != null) goto L6;
        return indexOfNull(r1);
    L6:
        return indexOf(r1, r2, r2.hashCode());
    }

    public static final <E> int indexOfNull(ArraySet<E> r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return indexOf(r2, null, 0);
    }

    public static final <E> boolean isEmptyInternal(ArraySet<E> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r1.get_size$collection() > 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final <E> boolean removeAllInternal(ArraySet<E> r5, ArraySet<? extends E> r6) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r6, "array");
        int r0 = r6.get_size$collection();
        int r1 = r5.get_size$collection();
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L6;
        r5.remove(r6.valueAt(r3));
        r3 = r3 + 1;
        goto L3
    L6:
        if (r1 == r5.get_size$collection()) goto L10;
        return true;
    L10:
        return false;
    }

    public static final <E> boolean removeAllInternal(ArraySet<E> r2, Collection<? extends E> r3) {
        Collection r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r4, "elements");
        Iterator<E> r5 = r4.iterator();
        boolean r0 = false;
    L4:
        if (r5.hasNext() == false) goto L6;
        r0 = r0 | r2.remove(r5.next());
        goto L4
    L6:
        return r0;
    }

    public static final <E> E removeAtInternal(ArraySet<E> r13, int r14) {
        Intrinsics.checkNotNullParameter(r13, "<this>");
        int r0 = r13.get_size$collection();
        E r1 = (E) r13.getArray$collection()[r14];
        if (r0 > 1) goto L5;
        r13.clear();
    L23:
        return r1;
    L5:
        int r3 = r0 - 1;
        int r5 = 8;
        if (r13.getHashes$collection().length > 8) goto L8;
    L17:
        if (r14 >= r3) goto L19;
        int r6 = r14 + 1;
        int r7 = r3 + 1;
        ArraysKt.copyInto(r13.getHashes$collection(), r13.getHashes$collection(), r14, r6, r7);
        ArraysKt.copyInto(r13.getArray$collection(), r13.getArray$collection(), r14, r6, r7);
    L19:
        r13.getArray$collection()[r3] = null;
    L21:
        if (r0 != r13.get_size$collection()) goto L25;
        r13.set_size$collection(r3);
        goto L23
    L25:
        throw new ConcurrentModificationException();
    L8:
        if (r13.get_size$collection() >= (r13.getHashes$collection().length / 3)) goto L17;
        if (r13.get_size$collection() <= 8) goto L12;
        r5 = r13.get_size$collection() + (r13.get_size$collection() >> 1);
    L12:
        int[] r2 = r13.getHashes$collection();
        Object[] r4 = r13.getArray$collection();
        allocArrays(r13, r5);
        if (r14 <= 0) goto L15;
        ArraysKt.copyInto$default(r2, r13.getHashes$collection(), 0, 0, r14, 6, null);
        ArraysKt.copyInto$default(r4, r13.getArray$collection(), 0, 0, r14, 6, null);
    L15:
        if (r14 >= r3) goto L21;
        int r8 = r14 + 1;
        int r9 = r3 + 1;
        ArraysKt.copyInto(r2, r13.getHashes$collection(), r14, r8, r9);
        ArraysKt.copyInto(r4, r13.getArray$collection(), r14, r8, r9);
        goto L21
    }

    public static final <E> boolean removeInternal(ArraySet<E> r1, E r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        int r3 = r1.indexOf(r2);
        if (r3 < 0) goto L6;
        r1.removeAt(r3);
        return true;
    L6:
        return false;
    }

    public static final <E> boolean retainAllInternal(ArraySet<E> r6, Collection<? extends E> r7) {
        Collection r8 = (Collection) ZeusTransformUtils.wrapperContextForParams(r7, Collection.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r8, "elements");
        int r0 = r6.get_size$collection() - 1;
        boolean r3 = false;
    L4:
        if ((-1) >= r0) goto L9;
        if (CollectionsKt.contains((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin"), r6.getArray$collection()[r0]) == true) goto L8;
        r6.removeAt(r0);
        r3 = true;
    L8:
        r0 = r0 - 1;
        goto L4
    L9:
        return r3;
    }

    public static final <E> String toStringInternal(ArraySet<E> r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        if (r4.isEmpty() == false) goto L6;
        return "{}";
    L6:
        StringBuilder r1 = new StringBuilder(r4.get_size$collection() * 14);
        r1.append('{');
        int r0 = 0;
        int r2 = r4.get_size$collection();
    L7:
        if (r0 >= r2) goto L15;
        if (r0 <= 0) goto L10;
        r1.append(", ");
    L10:
        E r3 = r4.valueAt(r0);
        if (r3 == r4) goto L13;
        r1.append(r3);
    L14:
        r0 = r0 + 1;
        goto L7
    L13:
        r1.append("(this Set)");
        goto L14
    L15:
        r1.append('}');
        String r5 = r1.toString();
        Intrinsics.checkNotNullExpressionValue(r5, "StringBuilder(capacity).…builderAction).toString()");
        return r5;
    }

    public static final <E> E valueAtInternal(ArraySet<E> r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return (E) r1.getArray$collection()[r2];
    }
}
