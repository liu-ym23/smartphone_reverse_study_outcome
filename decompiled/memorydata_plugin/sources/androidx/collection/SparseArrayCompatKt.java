package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.entity.EventBody;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0010\u000e\n\u0002\b\u0005\u001a.\u0010\u0002\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u0002H\u0004H\u0080\b¢\u0006\u0002\u0010\t\u001a\u0019\u0010\n\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u0005H\u0080\b\u001a!\u0010\u000b\u001a\u00020\f\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0080\b\u001a&\u0010\r\u001a\u00020\f\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\b\u001a\u0002H\u0004H\u0080\b¢\u0006\u0002\u0010\u000e\u001a'\u0010\u000f\u001a\u0004\u0018\u0001H\u0004\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000¢\u0006\u0002\u0010\u0010\u001a-\u0010\u000f\u001a\u0002H\u0004\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u0002H\u0004H\u0000¢\u0006\u0002\u0010\u0012\u001a!\u0010\u0013\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0080\b\u001a&\u0010\u0014\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\b\u001a\u0002H\u0004H\u0080\b¢\u0006\u0002\u0010\u0015\u001a\u0019\u0010\u0016\u001a\u00020\f\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u0005H\u0080\b\u001a!\u0010\u0017\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\u0018\u001a\u00020\u0007H\u0080\b\u001a.\u0010\u0019\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u0002H\u0004H\u0080\b¢\u0006\u0002\u0010\t\u001a)\u0010\u001a\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00052\u000e\u0010\u001b\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00040\u0005H\u0080\b\u001a0\u0010\u001c\u001a\u0004\u0018\u0001H\u0004\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u0002H\u0004H\u0080\b¢\u0006\u0002\u0010\u0012\u001a \u0010\u001d\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a+\u0010\u001d\u001a\u00020\f\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u0080\b\u001a!\u0010\u001e\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\u0018\u001a\u00020\u0007H\u0080\b\u001a)\u0010\u001f\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0007H\u0080\b\u001a0\u0010!\u001a\u0004\u0018\u0001H\u0004\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u0002H\u0004H\u0080\b¢\u0006\u0002\u0010\u0012\u001a6\u0010!\u001a\u00020\f\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\"\u001a\u0002H\u00042\u0006\u0010#\u001a\u0002H\u0004H\u0080\b¢\u0006\u0002\u0010$\u001a.\u0010%\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\b\u001a\u0002H\u0004H\u0080\b¢\u0006\u0002\u0010\t\u001a\u0019\u0010&\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u0005H\u0080\b\u001a\u0019\u0010'\u001a\u00020(\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u0005H\u0080\b\u001a&\u0010)\u001a\u0002H\u0004\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\u0018\u001a\u00020\u0007H\u0080\b¢\u0006\u0002\u0010\u0010\u001a\u0018\u0010*\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u0005H\u0002\u001a:\u0010+\u001a\u0002H,\"\u0004\b\u0000\u0010\u0004\"\n\b\u0001\u0010,*\u0004\u0018\u0001H\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u0002H,H\u0082\b¢\u0006\u0002\u0010\u0012\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"DELETED", "", "commonAppend", "", ExifInterface.LONGITUDE_EAST, "Landroidx/collection/SparseArrayCompat;", "key", "", EventBody.KEY_VALUE, "(Landroidx/collection/SparseArrayCompat;ILjava/lang/Object;)V", "commonClear", "commonContainsKey", "", "commonContainsValue", "(Landroidx/collection/SparseArrayCompat;Ljava/lang/Object;)Z", "commonGet", "(Landroidx/collection/SparseArrayCompat;I)Ljava/lang/Object;", "defaultValue", "(Landroidx/collection/SparseArrayCompat;ILjava/lang/Object;)Ljava/lang/Object;", "commonIndexOfKey", "commonIndexOfValue", "(Landroidx/collection/SparseArrayCompat;Ljava/lang/Object;)I", "commonIsEmpty", "commonKeyAt", "index", "commonPut", "commonPutAll", "other", "commonPutIfAbsent", "commonRemove", "commonRemoveAt", "commonRemoveAtRange", "size", "commonReplace", "oldValue", "newValue", "(Landroidx/collection/SparseArrayCompat;ILjava/lang/Object;Ljava/lang/Object;)Z", "commonSetValueAt", "commonSize", "commonToString", "", "commonValueAt", "gc", "internalGet", ExifInterface.GPS_DIRECTION_TRUE, "collection"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SparseArrayCompatKt {
    private static final Object DELETED = null;

    static {
        DELETED = new Object();
    }

    public static final /* synthetic */ void access$gc(SparseArrayCompat r0) {
        gc(r0);
    }

    public static final /* synthetic */ Object access$getDELETED$p() {
        return DELETED;
    }

    public static final <E> void commonAppend(SparseArrayCompat<E> r4, int r5, E r6) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        if (r4.size == 0) goto L9;
        if (r5 > r4.keys[r4.size - 1]) goto L9;
        r4.put(r5, r6);
        return;
    L9:
        if (r4.garbage == true) goto L11;
    L13:
        int r0 = r4.size;
        if (r0 < r4.keys.length) goto L16;
        int r1 = ContainerHelpersKt.idealIntArraySize(r0 + 1);
        int[] r2 = Arrays.copyOf(r4.keys, r1);
        Intrinsics.checkNotNullExpressionValue(r2, "copyOf(this, newSize)");
        r4.keys = r2;
        Object[] r3 = Arrays.copyOf(r4.values, r1);
        Intrinsics.checkNotNullExpressionValue(r3, "copyOf(this, newSize)");
        r4.values = r3;
    L16:
        r4.keys[r0] = r5;
        r4.values[r0] = r6;
        r4.size = r0 + 1;
        return;
    L11:
        if (r4.size < r4.keys.length) goto L13;
        access$gc(r4);
        goto L13
    }

    public static final <E> void commonClear(SparseArrayCompat<E> r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        int r0 = r5.size;
        Object[] r1 = r5.values;
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L5;
        r1[r3] = null;
        r3 = r3 + 1;
        goto L3
    L5:
        r5.size = 0;
        r5.garbage = false;
    }

    public static final <E> boolean commonContainsKey(SparseArrayCompat<E> r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r1.indexOfKey(r2) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final <E> boolean commonContainsValue(SparseArrayCompat<E> r4, E r5) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        if (r4.garbage == false) goto L5;
        access$gc(r4);
    L5:
        int r0 = r4.size;
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L11;
        if (r4.values[r2] == r5) goto L12;
        r2 = r2 + 1;
    L12:
        if (r2 < 0) goto L17;
        return true;
    L17:
        return false;
    L11:
        r2 = -1;
        goto L12
    }

    public static final <E> E commonGet(SparseArrayCompat<E> r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        int r4 = ContainerHelpersKt.binarySearch(r2.keys, r2.size, r3);
        if (r4 >= 0) goto L5;
    L8:
        return null;
    L5:
        if (r2.values[r4] == DELETED) goto L8;
        return (E) r2.values[r4];
    }

    public static final <E> E commonGet(SparseArrayCompat<E> r2, int r3, E r4) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        int r5 = ContainerHelpersKt.binarySearch(r2.keys, r2.size, r3);
        if (r5 >= 0) goto L5;
        return r4;
    L5:
        if (r2.values[r5] != DELETED) goto L8;
        return r4;
    L8:
        return (E) r2.values[r5];
    }

    public static final <E> int commonIndexOfKey(SparseArrayCompat<E> r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r1.garbage == false) goto L6;
        access$gc(r1);
    L6:
        return ContainerHelpersKt.binarySearch(r1.keys, r1.size, r2);
    }

    public static final <E> int commonIndexOfValue(SparseArrayCompat<E> r3, E r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if (r3.garbage == false) goto L5;
        access$gc(r3);
    L5:
        int r0 = 0;
        int r1 = r3.size;
    L6:
        if (r0 >= r1) goto L11;
        if (r3.values[r0] == r4) goto L9;
        r0 = r0 + 1;
        goto L6
    L9:
        return r0;
    L11:
        return -1;
    }

    public static final <E> boolean commonIsEmpty(SparseArrayCompat<E> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r1.size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final <E> int commonKeyAt(SparseArrayCompat<E> r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r1.garbage == false) goto L6;
        access$gc(r1);
    L6:
        return r1.keys[r2];
    }

    public static final <E> void commonPut(SparseArrayCompat<E> r5, int r6, E r7) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        int r0 = ContainerHelpersKt.binarySearch(r5.keys, r5.size, r6);
        if (r0 < 0) goto L5;
        r5.values[r0] = r7;
        return;
    L5:
        int r1 = ~r0;
        if (r1 >= r5.size) goto L12;
        if (r5.values[r1] != access$getDELETED$p()) goto L12;
        r5.keys[r1] = r6;
        r5.values[r1] = r7;
        return;
    L12:
        if (r5.garbage == false) goto L17;
        if (r5.size < r5.keys.length) goto L17;
        access$gc(r5);
        r1 = ~ContainerHelpersKt.binarySearch(r5.keys, r5.size, r6);
    L17:
        if (r5.size < r5.keys.length) goto L20;
        int r2 = ContainerHelpersKt.idealIntArraySize(r5.size + 1);
        int[] r3 = Arrays.copyOf(r5.keys, r2);
        Intrinsics.checkNotNullExpressionValue(r3, "copyOf(this, newSize)");
        r5.keys = r3;
        Object[] r4 = Arrays.copyOf(r5.values, r2);
        Intrinsics.checkNotNullExpressionValue(r4, "copyOf(this, newSize)");
        r5.values = r4;
    L20:
        if ((r5.size - r1) == 0) goto L22;
        int r8 = r1 + 1;
        ArraysKt.copyInto(r5.keys, r5.keys, r8, r1, r5.size);
        ArraysKt.copyInto(r5.values, r5.values, r8, r1, r5.size);
    L22:
        r5.keys[r1] = r6;
        r5.values[r1] = r7;
        r5.size++;
    }

    public static final <E> void commonPutAll(SparseArrayCompat<E> r9, SparseArrayCompat<? extends E> r10) {
        Intrinsics.checkNotNullParameter(r9, "<this>");
        Intrinsics.checkNotNullParameter(r10, "other");
        int r0 = r10.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L25;
        int r2 = r10.keyAt(r1);
        E r3 = r10.valueAt(r1);
        int r4 = ContainerHelpersKt.binarySearch(r9.keys, r9.size, r2);
        if (r4 < 0) goto L7;
        r9.values[r4] = r3;
    L24:
        r1 = r1 + 1;
        goto L3
    L7:
        int r5 = ~r4;
        if (r5 >= r9.size) goto L13;
        if (r9.values[r5] != access$getDELETED$p()) goto L13;
        r9.keys[r5] = r2;
        r9.values[r5] = r3;
    L13:
        if (r9.garbage == false) goto L18;
        if (r9.size < r9.keys.length) goto L18;
        access$gc(r9);
        r5 = ~ContainerHelpersKt.binarySearch(r9.keys, r9.size, r2);
    L18:
        if (r9.size < r9.keys.length) goto L21;
        int r6 = ContainerHelpersKt.idealIntArraySize(r9.size + 1);
        int[] r7 = Arrays.copyOf(r9.keys, r6);
        Intrinsics.checkNotNullExpressionValue(r7, "copyOf(this, newSize)");
        r9.keys = r7;
        Object[] r8 = Arrays.copyOf(r9.values, r6);
        Intrinsics.checkNotNullExpressionValue(r8, "copyOf(this, newSize)");
        r9.values = r8;
    L21:
        if ((r9.size - r5) == 0) goto L23;
        int r11 = r5 + 1;
        ArraysKt.copyInto(r9.keys, r9.keys, r11, r5, r9.size);
        ArraysKt.copyInto(r9.values, r9.values, r11, r5, r9.size);
    L23:
        r9.keys[r5] = r2;
        r9.values[r5] = r3;
        r9.size++;
        goto L24
    }

    public static final <E> E commonPutIfAbsent(SparseArrayCompat<E> r6, int r7, E r8) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        E r0 = (E) commonGet(r6, r7);
        if (r0 != null) goto L24;
        int r1 = ContainerHelpersKt.binarySearch(r6.keys, r6.size, r7);
        if (r1 < 0) goto L7;
        r6.values[r1] = r8;
        goto L24
    L7:
        int r2 = ~r1;
        if (r2 >= r6.size) goto L13;
        if (r6.values[r2] != access$getDELETED$p()) goto L13;
        r6.keys[r2] = r7;
        r6.values[r2] = r8;
    L13:
        if (r6.garbage == false) goto L18;
        if (r6.size < r6.keys.length) goto L18;
        access$gc(r6);
        r2 = ~ContainerHelpersKt.binarySearch(r6.keys, r6.size, r7);
    L18:
        if (r6.size < r6.keys.length) goto L21;
        int r3 = ContainerHelpersKt.idealIntArraySize(r6.size + 1);
        int[] r4 = Arrays.copyOf(r6.keys, r3);
        Intrinsics.checkNotNullExpressionValue(r4, "copyOf(this, newSize)");
        r6.keys = r4;
        Object[] r5 = Arrays.copyOf(r6.values, r3);
        Intrinsics.checkNotNullExpressionValue(r5, "copyOf(this, newSize)");
        r6.values = r5;
    L21:
        if ((r6.size - r2) == 0) goto L23;
        int r9 = r2 + 1;
        ArraysKt.copyInto(r6.keys, r6.keys, r9, r2, r6.size);
        ArraysKt.copyInto(r6.values, r6.values, r9, r2, r6.size);
    L23:
        r6.keys[r2] = r7;
        r6.values[r2] = r8;
        r6.size++;
    L24:
        return r0;
    }

    public static final <E> void commonRemove(SparseArrayCompat<E> r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        int r4 = ContainerHelpersKt.binarySearch(r2.keys, r2.size, r3);
        if (r4 < 0) goto L8;
        Object r0 = r2.values[r4];
        Object r1 = DELETED;
        if (r0 == r1) goto L9;
        r2.values[r4] = r1;
        r2.garbage = true;
        return;
    L9:
        return;
    }

    public static final <E> boolean commonRemove(SparseArrayCompat<E> r1, int r2, Object r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        int r4 = r1.indexOfKey(r2);
        if (r4 >= 0) goto L5;
        return false;
    L5:
        if (Intrinsics.areEqual(r3, r1.valueAt(r4)) == false) goto L10;
        r1.removeAt(r4);
        return true;
    L10:
        return false;
    }

    public static final <E> void commonRemoveAt(SparseArrayCompat<E> r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (r2.values[r3] == access$getDELETED$p()) goto L6;
        r2.values[r3] = access$getDELETED$p();
        r2.garbage = true;
        return;
    }

    public static final <E> void commonRemoveAtRange(SparseArrayCompat<E> r1, int r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        int r4 = Math.min(r3, r2 + r3);
    L3:
        if (r2 >= r4) goto L5;
        r1.removeAt(r2);
        r2 = r2 + 1;
        goto L3
    }

    public static final <E> E commonReplace(SparseArrayCompat<E> r1, int r2, E r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        int r4 = r1.indexOfKey(r2);
        if (r4 < 0) goto L6;
        E r0 = (E) r1.values[r4];
        r1.values[r4] = r3;
        return r0;
    L6:
        return null;
    }

    public static final <E> boolean commonReplace(SparseArrayCompat<E> r1, int r2, E r3, E r4) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        int r5 = r1.indexOfKey(r2);
        if (r5 >= 0) goto L5;
        return false;
    L5:
        if (Intrinsics.areEqual(r1.values[r5], r3) == false) goto L10;
        r1.values[r5] = r4;
        return true;
    L10:
        return false;
    }

    public static final <E> void commonSetValueAt(SparseArrayCompat<E> r1, int r2, E r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r1.garbage == false) goto L5;
        access$gc(r1);
    L5:
        r1.values[r2] = r3;
    }

    public static final <E> int commonSize(SparseArrayCompat<E> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r1.garbage == false) goto L6;
        access$gc(r1);
    L6:
        return r1.size;
    }

    public static final <E> String commonToString(SparseArrayCompat<E> r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        if (r4.size() > 0) goto L6;
        return "{}";
    L6:
        StringBuilder r0 = new StringBuilder(r4.size * 28);
        r0.append('{');
        int r1 = 0;
        int r2 = r4.size;
    L7:
        if (r1 >= r2) goto L15;
        if (r1 <= 0) goto L10;
        r0.append(", ");
    L10:
        r0.append(r4.keyAt(r1));
        r0.append('=');
        E r3 = r4.valueAt(r1);
        if (r3 == r4) goto L13;
        r0.append(r3);
    L14:
        r1 = r1 + 1;
        goto L7
    L13:
        r0.append("(this Map)");
        goto L14
    L15:
        r0.append('}');
        String r5 = r0.toString();
        Intrinsics.checkNotNullExpressionValue(r5, "buffer.toString()");
        return r5;
    }

    public static final <E> E commonValueAt(SparseArrayCompat<E> r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r1.garbage == false) goto L6;
        access$gc(r1);
    L6:
        return (E) r1.values[r2];
    }

    private static final <E> void gc(SparseArrayCompat<E> r8) {
        int r0 = r8.size;
        int[] r1 = r8.keys;
        Object[] r2 = r8.values;
        int r4 = 0;
        int r5 = 0;
    L3:
        if (r4 >= r0) goto L10;
        Object r6 = r2[r4];
        if (r6 == DELETED) goto L9;
        if (r4 == r5) goto L8;
        r1[r5] = r1[r4];
        r2[r5] = r6;
        r2[r4] = null;
    L8:
        r5 = r5 + 1;
    L9:
        r4 = r4 + 1;
        goto L3
    L10:
        r8.garbage = false;
        r8.size = r5;
    }

    private static final <E, T extends E> T internalGet(SparseArrayCompat<E> r2, int r3, T r4) {
        int r5 = ContainerHelpersKt.binarySearch(r2.keys, r2.size, r3);
        if (r5 >= 0) goto L5;
        return r4;
    L5:
        if (r2.values[r5] != DELETED) goto L8;
        return r4;
    L8:
        return (T) r2.values[r5];
    }
}
