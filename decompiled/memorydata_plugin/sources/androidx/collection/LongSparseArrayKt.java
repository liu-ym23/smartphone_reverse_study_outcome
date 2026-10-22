package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.LongIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000X\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u001d\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010(\n\u0000\u001a.\u0010\n\u001a\u00020\u000b\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u0002H\f0\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u0002H\fH\u0080\b¢\u0006\u0002\u0010\u0010\u001a\u0019\u0010\u0011\u001a\u00020\u000b\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u0002H\f0\u0005H\u0080\b\u001a!\u0010\u0012\u001a\u00020\u0013\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u0002H\f0\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0080\b\u001a&\u0010\u0014\u001a\u00020\u0013\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u0002H\f0\u00052\u0006\u0010\u000f\u001a\u0002H\fH\u0080\b¢\u0006\u0002\u0010\u0015\u001a\u0019\u0010\u0016\u001a\u00020\u000b\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u0002H\f0\u0005H\u0080\b\u001a(\u0010\u0017\u001a\u0004\u0018\u0001H\f\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u0002H\f0\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0080\b¢\u0006\u0002\u0010\u0018\u001a.\u0010\u0017\u001a\u0002H\f\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u0002H\f0\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u0002H\fH\u0080\b¢\u0006\u0002\u0010\u001a\u001a:\u0010\u001b\u001a\u0002H\u0004\"\n\b\u0000\u0010\u0004*\u0004\u0018\u0001H\f\"\u0004\b\u0001\u0010\f*\b\u0012\u0004\u0012\u0002H\f0\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u0002H\u0004H\u0080\b¢\u0006\u0002\u0010\u001a\u001a!\u0010\u001c\u001a\u00020\u0003\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u0002H\f0\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0080\b\u001a&\u0010\u001d\u001a\u00020\u0003\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u0002H\f0\u00052\u0006\u0010\u000f\u001a\u0002H\fH\u0080\b¢\u0006\u0002\u0010\u001e\u001a\u0019\u0010\u001f\u001a\u00020\u0013\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u0002H\f0\u0005H\u0080\b\u001a!\u0010 \u001a\u00020\u000e\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u0002H\f0\u00052\u0006\u0010!\u001a\u00020\u0003H\u0080\b\u001a.\u0010\"\u001a\u00020\u000b\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u0002H\f0\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u0002H\fH\u0080\b¢\u0006\u0002\u0010\u0010\u001a)\u0010#\u001a\u00020\u000b\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u0002H\f0\u00052\u000e\u0010$\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\f0\u0005H\u0080\b\u001a0\u0010%\u001a\u0004\u0018\u0001H\f\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u0002H\f0\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u0002H\fH\u0080\b¢\u0006\u0002\u0010\u001a\u001a!\u0010&\u001a\u00020\u000b\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u0002H\f0\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0080\b\u001a.\u0010&\u001a\u00020\u0013\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u0002H\f0\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u0002H\fH\u0080\b¢\u0006\u0002\u0010'\u001a!\u0010(\u001a\u00020\u000b\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u0002H\f0\u00052\u0006\u0010!\u001a\u00020\u0003H\u0080\b\u001a0\u0010)\u001a\u0004\u0018\u0001H\f\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u0002H\f0\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u0002H\fH\u0080\b¢\u0006\u0002\u0010\u001a\u001a6\u0010)\u001a\u00020\u0013\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u0002H\f0\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010*\u001a\u0002H\f2\u0006\u0010+\u001a\u0002H\fH\u0080\b¢\u0006\u0002\u0010,\u001a.\u0010-\u001a\u00020\u000b\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u0002H\f0\u00052\u0006\u0010!\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u0002H\fH\u0080\b¢\u0006\u0002\u0010.\u001a\u0019\u0010/\u001a\u00020\u0003\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u0002H\f0\u0005H\u0080\b\u001a\u0019\u00100\u001a\u000201\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u0002H\f0\u0005H\u0080\b\u001a&\u00102\u001a\u0002H\f\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u0002H\f0\u00052\u0006\u0010!\u001a\u00020\u0003H\u0080\b¢\u0006\u0002\u00103\u001a!\u00104\u001a\u00020\u0013\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0086\n\u001aT\u00105\u001a\u00020\u000b\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u000526\u00106\u001a2\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(\r\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u000b07H\u0086\bø\u0001\u0000\u001a.\u0010:\u001a\u0002H\u0004\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u0002H\u0004H\u0086\b¢\u0006\u0002\u0010\u001a\u001a7\u0010;\u001a\u0002H\u0004\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00040<H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010=\u001a\u0019\u0010>\u001a\u00020\u0013\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u0005H\u0086\b\u001a\u0016\u0010?\u001a\u00020@\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u0005\u001a-\u0010A\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0005\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00052\f\u0010$\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0005H\u0086\u0002\u001a-\u0010B\u001a\u00020\u0013\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u0002H\u0004H\u0007¢\u0006\u0002\u0010'\u001a.\u0010C\u001a\u00020\u000b\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u0002H\u0004H\u0086\n¢\u0006\u0002\u0010\u0010\u001a\u001c\u0010D\u001a\b\u0012\u0004\u0012\u0002H\u00040E\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u0005\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"(\u0010\u0002\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00058Æ\u0002¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006F"}, d2 = {"DELETED", "", "size", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/collection/LongSparseArray;", "getSize$annotations", "(Landroidx/collection/LongSparseArray;)V", "getSize", "(Landroidx/collection/LongSparseArray;)I", "commonAppend", "", ExifInterface.LONGITUDE_EAST, "key", "", EventBody.KEY_VALUE, "(Landroidx/collection/LongSparseArray;JLjava/lang/Object;)V", "commonClear", "commonContainsKey", "", "commonContainsValue", "(Landroidx/collection/LongSparseArray;Ljava/lang/Object;)Z", "commonGc", "commonGet", "(Landroidx/collection/LongSparseArray;J)Ljava/lang/Object;", "defaultValue", "(Landroidx/collection/LongSparseArray;JLjava/lang/Object;)Ljava/lang/Object;", "commonGetInternal", "commonIndexOfKey", "commonIndexOfValue", "(Landroidx/collection/LongSparseArray;Ljava/lang/Object;)I", "commonIsEmpty", "commonKeyAt", "index", "commonPut", "commonPutAll", "other", "commonPutIfAbsent", "commonRemove", "(Landroidx/collection/LongSparseArray;JLjava/lang/Object;)Z", "commonRemoveAt", "commonReplace", "oldValue", "newValue", "(Landroidx/collection/LongSparseArray;JLjava/lang/Object;Ljava/lang/Object;)Z", "commonSetValueAt", "(Landroidx/collection/LongSparseArray;ILjava/lang/Object;)V", "commonSize", "commonToString", "", "commonValueAt", "(Landroidx/collection/LongSparseArray;I)Ljava/lang/Object;", "contains", "forEach", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "getOrDefault", "getOrElse", "Lkotlin/Function0;", "(Landroidx/collection/LongSparseArray;JLkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "isNotEmpty", "keyIterator", "Lkotlin/collections/LongIterator;", "plus", "remove", "set", "valueIterator", "", "collection"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LongSparseArrayKt {
    private static final Object DELETED = null;

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.collection.LongSparseArrayKt$valueIterator$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\t\u0010\b\u001a\u00020\tH\u0096\u0002J\u000e\u0010\n\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"androidx/collection/LongSparseArrayKt$valueIterator$1", "", "index", "", "getIndex", "()I", "setIndex", "(I)V", "hasNext", "", "next", "()Ljava/lang/Object;", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class C09161<T> implements Iterator<T>, KMappedMarker {
        final /* synthetic */ LongSparseArray<T> $this_valueIterator;
        private int index;

        C09161(LongSparseArray<T> r1) {
            this.$this_valueIterator = r1;
        }

        public final int getIndex() {
            return this.index;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.index >= this.$this_valueIterator.size()) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Iterator
        public T next() {
            LongSparseArray<T> r0 = this.$this_valueIterator;
            int r1 = this.index;
            this.index = r1 + 1;
            return r0.valueAt(r1);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final void setIndex(int r1) {
            this.index = r1;
        }
    }

    static {
        DELETED = new Object();
    }

    public static final /* synthetic */ Object access$getDELETED$p() {
        return DELETED;
    }

    public static final <E> void commonAppend(LongSparseArray<E> r9, long r10, E r12) {
        Intrinsics.checkNotNullParameter(r9, "<this>");
        if (r9.size == 0) goto L9;
        if (r10 > r9.keys[r9.size - 1]) goto L9;
        r9.put(r10, r12);
        return;
    L9:
        if (r9.garbage == true) goto L11;
    L21:
        int r0 = r9.size;
        if (r0 < r9.keys.length) goto L24;
        int r1 = ContainerHelpersKt.idealLongArraySize(r0 + 1);
        long[] r2 = Arrays.copyOf(r9.keys, r1);
        Intrinsics.checkNotNullExpressionValue(r2, "copyOf(this, newSize)");
        r9.keys = r2;
        Object[] r3 = Arrays.copyOf(r9.values, r1);
        Intrinsics.checkNotNullExpressionValue(r3, "copyOf(this, newSize)");
        r9.values = r3;
    L24:
        r9.keys[r0] = r10;
        r9.values[r0] = r12;
        r9.size = r0 + 1;
        return;
    L11:
        if (r9.size < r9.keys.length) goto L21;
        int r4 = r9.size;
        long[] r5 = r9.keys;
        Object[] r6 = r9.values;
        int r7 = 0;
        int r8 = 0;
    L13:
        if (r7 >= r4) goto L20;
        Object r11 = r6[r7];
        if (r11 == access$getDELETED$p()) goto L19;
        if (r7 == r8) goto L18;
        r5[r8] = r5[r7];
        r6[r8] = r11;
        r6[r7] = null;
    L18:
        r8 = r8 + 1;
    L19:
        r7 = r7 + 1;
        goto L13
    L20:
        r9.garbage = false;
        r9.size = r8;
        goto L21
    }

    public static final <E> void commonClear(LongSparseArray<E> r5) {
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

    public static final <E> boolean commonContainsKey(LongSparseArray<E> r1, long r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r1.indexOfKey(r2) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final <E> boolean commonContainsValue(LongSparseArray<E> r1, E r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r1.indexOfValue(r2) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final <E> void commonGc(LongSparseArray<E> r9) {
        Intrinsics.checkNotNullParameter(r9, "<this>");
        int r0 = r9.size;
        long[] r1 = r9.keys;
        Object[] r2 = r9.values;
        int r4 = 0;
        int r5 = 0;
    L3:
        if (r4 >= r0) goto L10;
        Object r6 = r2[r4];
        if (r6 == access$getDELETED$p()) goto L9;
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
        r9.garbage = false;
        r9.size = r5;
    }

    public static final <E> E commonGet(LongSparseArray<E> r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        int r4 = ContainerHelpersKt.binarySearch(r2.keys, r2.size, r3);
        if (r4 >= 0) goto L5;
    L8:
        return null;
    L5:
        if (r2.values[r4] == access$getDELETED$p()) goto L8;
        return (E) r2.values[r4];
    }

    public static final <E> E commonGet(LongSparseArray<E> r2, long r3, E r5) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        int r4 = ContainerHelpersKt.binarySearch(r2.keys, r2.size, r3);
        if (r4 >= 0) goto L5;
        return r5;
    L5:
        if (r2.values[r4] != access$getDELETED$p()) goto L8;
        return r5;
    L8:
        return (E) r2.values[r4];
    }

    public static final <T extends E, E> T commonGetInternal(LongSparseArray<E> r2, long r3, T r5) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        int r4 = ContainerHelpersKt.binarySearch(r2.keys, r2.size, r3);
        if (r4 >= 0) goto L5;
        return r5;
    L5:
        if (r2.values[r4] != access$getDELETED$p()) goto L8;
        return r5;
    L8:
        return (T) r2.values[r4];
    }

    public static final <E> int commonIndexOfKey(LongSparseArray<E> r9, long r10) {
        Intrinsics.checkNotNullParameter(r9, "<this>");
        if (r9.garbage == false) goto L14;
        int r0 = r9.size;
        long[] r1 = r9.keys;
        Object[] r2 = r9.values;
        int r4 = 0;
        int r5 = 0;
    L5:
        if (r4 >= r0) goto L12;
        Object r6 = r2[r4];
        if (r6 == access$getDELETED$p()) goto L11;
        if (r4 == r5) goto L10;
        r1[r5] = r1[r4];
        r2[r5] = r6;
        r2[r4] = null;
    L10:
        r5 = r5 + 1;
    L11:
        r4 = r4 + 1;
        goto L5
    L12:
        r9.garbage = false;
        r9.size = r5;
    L14:
        return ContainerHelpersKt.binarySearch(r9.keys, r9.size, r10);
    }

    public static final <E> int commonIndexOfValue(LongSparseArray<E> r9, E r10) {
        Intrinsics.checkNotNullParameter(r9, "<this>");
        int r1 = 0;
        if (r9.garbage == false) goto L13;
        int r0 = r9.size;
        long[] r2 = r9.keys;
        Object[] r3 = r9.values;
        int r4 = 0;
        int r5 = 0;
    L5:
        if (r4 >= r0) goto L12;
        Object r6 = r3[r4];
        if (r6 == access$getDELETED$p()) goto L11;
        if (r4 == r5) goto L10;
        r2[r5] = r2[r4];
        r3[r5] = r6;
        r3[r4] = null;
    L10:
        r5 = r5 + 1;
    L11:
        r4 = r4 + 1;
        goto L5
    L12:
        r9.garbage = false;
        r9.size = r5;
    L13:
        int r7 = r9.size;
    L14:
        if (r1 >= r7) goto L19;
        if (r9.values[r1] == r10) goto L17;
        r1 = r1 + 1;
        goto L14
    L17:
        return r1;
    L19:
        return -1;
    }

    public static final <E> boolean commonIsEmpty(LongSparseArray<E> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r1.size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final <E> long commonKeyAt(LongSparseArray<E> r9, int r10) {
        Intrinsics.checkNotNullParameter(r9, "<this>");
        if (r10 >= 0) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L23;
        if (r9.garbage == false) goto L21;
        int r2 = r9.size;
        long[] r3 = r9.keys;
        Object[] r4 = r9.values;
        int r5 = 0;
        int r6 = 0;
    L12:
        if (r5 >= r2) goto L19;
        Object r7 = r4[r5];
        if (r7 == access$getDELETED$p()) goto L18;
        if (r5 == r6) goto L17;
        r3[r6] = r3[r5];
        r4[r6] = r7;
        r4[r5] = null;
    L17:
        r6 = r6 + 1;
    L18:
        r5 = r5 + 1;
        goto L12
    L19:
        r9.garbage = false;
        r9.size = r6;
    L21:
        return r9.keys[r10];
    L23:
        throw new IllegalArgumentException(("Expected index to be within 0..size()-1, but was " + r10).toString());
    L5:
        if (r10 >= r9.size) goto L7;
        r1 = true;
        goto L8
    }

    public static final <E> void commonPut(LongSparseArray<E> r9, long r10, E r12) {
        Intrinsics.checkNotNullParameter(r9, "<this>");
        int r0 = ContainerHelpersKt.binarySearch(r9.keys, r9.size, r10);
        if (r0 < 0) goto L5;
        r9.values[r0] = r12;
        return;
    L5:
        int r1 = ~r0;
        if (r1 >= r9.size) goto L12;
        if (r9.values[r1] != access$getDELETED$p()) goto L12;
        r9.keys[r1] = r10;
        r9.values[r1] = r12;
        return;
    L12:
        if (r9.garbage == false) goto L25;
        if (r9.size < r9.keys.length) goto L25;
        int r2 = r9.size;
        long[] r3 = r9.keys;
        Object[] r4 = r9.values;
        int r5 = 0;
        int r6 = 0;
    L16:
        if (r5 >= r2) goto L23;
        Object r7 = r4[r5];
        if (r7 == access$getDELETED$p()) goto L22;
        if (r5 == r6) goto L21;
        r3[r6] = r3[r5];
        r4[r6] = r7;
        r4[r5] = null;
    L21:
        r6 = r6 + 1;
    L22:
        r5 = r5 + 1;
        goto L16
    L23:
        r9.garbage = false;
        r9.size = r6;
        r1 = ~ContainerHelpersKt.binarySearch(r9.keys, r9.size, r10);
    L25:
        if (r9.size < r9.keys.length) goto L28;
        int r8 = ContainerHelpersKt.idealLongArraySize(r9.size + 1);
        long[] r11 = Arrays.copyOf(r9.keys, r8);
        Intrinsics.checkNotNullExpressionValue(r11, "copyOf(this, newSize)");
        r9.keys = r11;
        Object[] r13 = Arrays.copyOf(r9.values, r8);
        Intrinsics.checkNotNullExpressionValue(r13, "copyOf(this, newSize)");
        r9.values = r13;
    L28:
        if ((r9.size - r1) == 0) goto L30;
        int r14 = r1 + 1;
        ArraysKt.copyInto(r9.keys, r9.keys, r14, r1, r9.size);
        ArraysKt.copyInto(r9.values, r9.values, r14, r1, r9.size);
    L30:
        r9.keys[r1] = r10;
        r9.values[r1] = r12;
        r9.size++;
    }

    public static final <E> void commonPutAll(LongSparseArray<E> r5, LongSparseArray<? extends E> r6) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r6, "other");
        int r0 = r6.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r5.put(r6.keyAt(r1), r6.valueAt(r1));
        r1 = r1 + 1;
        goto L3
    }

    public static final <E> E commonPutIfAbsent(LongSparseArray<E> r1, long r2, E r4) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        E r0 = r1.get(r2);
        if (r0 != null) goto L5;
        r1.put(r2, r4);
    L5:
        return r0;
    }

    public static final <E> void commonRemove(LongSparseArray<E> r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        int r4 = ContainerHelpersKt.binarySearch(r2.keys, r2.size, r3);
        if (r4 >= 0) goto L5;
        return;
    L5:
        if (r2.values[r4] == access$getDELETED$p()) goto L9;
        r2.values[r4] = access$getDELETED$p();
        r2.garbage = true;
        return;
    }

    public static final <E> boolean commonRemove(LongSparseArray<E> r1, long r2, E r4) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        int r3 = r1.indexOfKey(r2);
        if (r3 >= 0) goto L5;
        return false;
    L5:
        if (Intrinsics.areEqual(r4, r1.valueAt(r3)) == false) goto L10;
        r1.removeAt(r3);
        return true;
    L10:
        return false;
    }

    public static final <E> void commonRemoveAt(LongSparseArray<E> r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (r2.values[r3] == access$getDELETED$p()) goto L6;
        r2.values[r3] = access$getDELETED$p();
        r2.garbage = true;
        return;
    }

    public static final <E> E commonReplace(LongSparseArray<E> r1, long r2, E r4) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        int r3 = r1.indexOfKey(r2);
        if (r3 < 0) goto L6;
        E r5 = (E) r1.values[r3];
        r1.values[r3] = r4;
        return r5;
    L6:
        return null;
    }

    public static final <E> boolean commonReplace(LongSparseArray<E> r1, long r2, E r4, E r5) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        int r3 = r1.indexOfKey(r2);
        if (r3 >= 0) goto L5;
        return false;
    L5:
        if (Intrinsics.areEqual(r1.values[r3], r4) == false) goto L10;
        r1.values[r3] = r5;
        return true;
    L10:
        return false;
    }

    public static final <E> void commonSetValueAt(LongSparseArray<E> r9, int r10, E r11) {
        Intrinsics.checkNotNullParameter(r9, "<this>");
        if (r10 >= 0) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L23;
        if (r9.garbage == false) goto L20;
        int r2 = r9.size;
        long[] r3 = r9.keys;
        Object[] r4 = r9.values;
        int r5 = 0;
        int r6 = 0;
    L12:
        if (r5 >= r2) goto L19;
        Object r7 = r4[r5];
        if (r7 == access$getDELETED$p()) goto L18;
        if (r5 == r6) goto L17;
        r3[r6] = r3[r5];
        r4[r6] = r7;
        r4[r5] = null;
    L17:
        r6 = r6 + 1;
    L18:
        r5 = r5 + 1;
        goto L12
    L19:
        r9.garbage = false;
        r9.size = r6;
    L20:
        r9.values[r10] = r11;
        return;
    L23:
        throw new IllegalArgumentException(("Expected index to be within 0..size()-1, but was " + r10).toString());
    L5:
        if (r10 >= r9.size) goto L7;
        r1 = true;
        goto L8
    }

    public static final <E> int commonSize(LongSparseArray<E> r9) {
        Intrinsics.checkNotNullParameter(r9, "<this>");
        if (r9.garbage == false) goto L14;
        int r0 = r9.size;
        long[] r1 = r9.keys;
        Object[] r2 = r9.values;
        int r4 = 0;
        int r5 = 0;
    L5:
        if (r4 >= r0) goto L12;
        Object r6 = r2[r4];
        if (r6 == access$getDELETED$p()) goto L11;
        if (r4 == r5) goto L10;
        r1[r5] = r1[r4];
        r2[r5] = r6;
        r2[r4] = null;
    L10:
        r5 = r5 + 1;
    L11:
        r4 = r4 + 1;
        goto L5
    L12:
        r9.garbage = false;
        r9.size = r5;
    L14:
        return r9.size;
    }

    public static final <E> String commonToString(LongSparseArray<E> r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r5.size() > 0) goto L6;
        return "{}";
    L6:
        StringBuilder r1 = new StringBuilder(r5.size * 28);
        r1.append('{');
        int r0 = 0;
        int r2 = r5.size;
    L7:
        if (r0 >= r2) goto L15;
        if (r0 <= 0) goto L10;
        r1.append(", ");
    L10:
        r1.append(r5.keyAt(r0));
        r1.append('=');
        E r3 = r5.valueAt(r0);
        if (r3 == r1) goto L13;
        r1.append(r3);
    L14:
        r0 = r0 + 1;
        goto L7
    L13:
        r1.append("(this Map)");
        goto L14
    L15:
        r1.append('}');
        String r6 = r1.toString();
        Intrinsics.checkNotNullExpressionValue(r6, "StringBuilder(capacity).…builderAction).toString()");
        return r6;
    }

    public static final <E> E commonValueAt(LongSparseArray<E> r9, int r10) {
        Intrinsics.checkNotNullParameter(r9, "<this>");
        if (r10 >= 0) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L23;
        if (r9.garbage == false) goto L21;
        int r2 = r9.size;
        long[] r3 = r9.keys;
        Object[] r4 = r9.values;
        int r5 = 0;
        int r6 = 0;
    L12:
        if (r5 >= r2) goto L19;
        Object r7 = r4[r5];
        if (r7 == access$getDELETED$p()) goto L18;
        if (r5 == r6) goto L17;
        r3[r6] = r3[r5];
        r4[r6] = r7;
        r4[r5] = null;
    L17:
        r6 = r6 + 1;
    L18:
        r5 = r5 + 1;
        goto L12
    L19:
        r9.garbage = false;
        r9.size = r6;
    L21:
        return (E) r9.values[r10];
    L23:
        throw new IllegalArgumentException(("Expected index to be within 0..size()-1, but was " + r10).toString());
    L5:
        if (r10 >= r9.size) goto L7;
        r1 = true;
        goto L8
    }

    public static final <T> boolean contains(LongSparseArray<T> r1, long r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1.containsKey(r2);
    }

    public static final <T> void forEach(LongSparseArray<T> r4, Function2<? super Long, ? super T, Unit> r5) {
        Function2 r6 = (Function2) ZeusTransformUtils.wrapperContextForParams(r5, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r6, "action");
        int r0 = r4.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r6.invoke(Long.valueOf(r4.keyAt(r1)), r4.valueAt(r1));
        r1 = r1 + 1;
        goto L3
    }

    public static final <T> T getOrDefault(LongSparseArray<T> r1, long r2, T r4) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1.get(r2, r4);
    }

    public static final <T> T getOrElse(LongSparseArray<T> r2, long r3, Function0<? extends T> r5) {
        Function0 r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r6, "defaultValue");
        T r4 = r2.get(r3);
        if (r4 == null) goto L5;
        return r4;
    L5:
        return (T) r6.invoke();
    }

    public static final <T> int getSize(LongSparseArray<T> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1.size();
    }

    public static /* synthetic */ void getSize$annotations(LongSparseArray r0) {
    }

    public static final <T> boolean isNotEmpty(LongSparseArray<T> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return !r1.isEmpty();
    }

    public static final <T> LongIterator keyIterator(final LongSparseArray<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return (LongIterator) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r2), LongIterator.class, "com.obric.memorydata.plugin");
    }

    public static final <T> LongSparseArray<T> plus(LongSparseArray<T> r3, LongSparseArray<T> r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "other");
        LongSparseArray<T> r0 = new LongSparseArray(r3.size() + r4.size());
        r0.putAll(r3);
        r0.putAll(r4);
        return r0;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Replaced with member function. Remove extension import!")
    public static final /* synthetic */ boolean remove(LongSparseArray r1, long r2, Object r4) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1.remove(r2, r4);
    }

    public static final <T> void set(LongSparseArray<T> r1, long r2, T r4) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        r1.put(r2, r4);
    }

    public static final <T> Iterator<T> valueIterator(LongSparseArray<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return (Iterator) ZeusTransformUtils.preCheckCast(new C09161(r2), Iterator.class, "com.obric.memorydata.plugin");
    }
}
