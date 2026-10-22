package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001a\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b \n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0011\b\u0007\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u001d\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0014J\b\u0010\u0015\u001a\u00020\u0010H\u0016J\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0016J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0015\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0017J\u0018\u0010\u001b\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0011\u001a\u00020\u0012H\u0096\u0002¢\u0006\u0002\u0010\u001cJ\u001d\u0010\u001b\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0015\u0010 \u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010!J\b\u0010\"\u001a\u00020\u0007H\u0016J\u0010\u0010#\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\u0004H\u0016J\u001d\u0010%\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0014J\u0018\u0010&\u001a\u00020\u00102\u000e\u0010'\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0000H\u0016J\u001f\u0010(\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001eJ\u0010\u0010)\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u001d\u0010)\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010*J\u0010\u0010+\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u0004H\u0016J\u001f\u0010,\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001eJ%\u0010,\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010-\u001a\u00028\u00002\u0006\u0010.\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010/J\u001d\u00100\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00101J\b\u0010\n\u001a\u00020\u0004H\u0016J\b\u00102\u001a\u000203H\u0016J\u0015\u00104\u001a\u00028\u00002\u0006\u0010$\u001a\u00020\u0004H\u0016¢\u0006\u0002\u00105R\u0012\u0010\u0006\u001a\u00020\u00078\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\t8\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00048\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\f8\u0000@\u0000X\u0081\u000e¢\u0006\u0004\n\u0002\u0010\u000e¨\u00066"}, d2 = {"Landroidx/collection/LongSparseArray;", ExifInterface.LONGITUDE_EAST, "", "initialCapacity", "", "(I)V", "garbage", "", "keys", "", "size", "values", "", "", "[Ljava/lang/Object;", "append", "", "key", "", EventBody.KEY_VALUE, "(JLjava/lang/Object;)V", "clear", "clone", "containsKey", "containsValue", "(Ljava/lang/Object;)Z", "delete", "get", "(J)Ljava/lang/Object;", "defaultValue", "(JLjava/lang/Object;)Ljava/lang/Object;", "indexOfKey", "indexOfValue", "(Ljava/lang/Object;)I", "isEmpty", "keyAt", "index", "put", "putAll", "other", "putIfAbsent", "remove", "(JLjava/lang/Object;)Z", "removeAt", "replace", "oldValue", "newValue", "(JLjava/lang/Object;Ljava/lang/Object;)Z", "setValueAt", "(ILjava/lang/Object;)V", "toString", "", "valueAt", "(I)Ljava/lang/Object;", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class LongSparseArray<E> implements Cloneable {
    public /* synthetic */ boolean garbage;
    public /* synthetic */ long[] keys;
    public /* synthetic */ int size;
    public /* synthetic */ Object[] values;

    public LongSparseArray() {
        this(0, 1, null);
    }

    public LongSparseArray(int r2) {
        if (r2 != 0) goto L5;
        this.keys = ContainerHelpersKt.EMPTY_LONGS;
        this.values = ContainerHelpersKt.EMPTY_OBJECTS;
        return;
    L5:
        int r3 = ContainerHelpersKt.idealLongArraySize(r2);
        this.keys = new long[r3];
        this.values = new Object[r3];
    }

    public /* synthetic */ LongSparseArray(int r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = 10;
    L5:
        this(r1);
    }

    public void append(long r10, E r12) {
        int r0 = this.size;
        if (r0 == 0) goto L8;
        if (r10 > this.keys[r0 - 1]) goto L8;
        put(r10, r12);
        return;
    L8:
        if (this.garbage == false) goto L20;
        long[] r1 = this.keys;
        if (r0 < r1.length) goto L20;
        Object[] r2 = this.values;
        int r4 = 0;
        int r5 = 0;
    L12:
        if (r4 >= r0) goto L19;
        Object r6 = r2[r4];
        if (r6 == LongSparseArrayKt.access$getDELETED$p()) goto L18;
        if (r4 == r5) goto L17;
        r1[r5] = r1[r4];
        r2[r5] = r6;
        r2[r4] = null;
    L17:
        r5 = r5 + 1;
    L18:
        r4 = r4 + 1;
        goto L12
    L19:
        this.garbage = false;
        this.size = r5;
    L20:
        int r3 = this.size;
        if (r3 < this.keys.length) goto L23;
        int r7 = ContainerHelpersKt.idealLongArraySize(r3 + 1);
        long[] r8 = Arrays.copyOf(this.keys, r7);
        Intrinsics.checkNotNullExpressionValue(r8, "copyOf(this, newSize)");
        this.keys = r8;
        Object[] r9 = Arrays.copyOf(this.values, r7);
        Intrinsics.checkNotNullExpressionValue(r9, "copyOf(this, newSize)");
        this.values = r9;
    L23:
        this.keys[r3] = r10;
        this.values[r3] = r12;
        this.size = r3 + 1;
    }

    public void clear() {
        int r0 = this.size;
        Object[] r1 = this.values;
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L5;
        r1[r3] = null;
        r3 = r3 + 1;
        goto L3
    L5:
        this.size = 0;
        this.garbage = false;
    }

    public LongSparseArray<E> clone() {
        Object r0 = super.clone();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type androidx.collection.LongSparseArray<E of androidx.collection.LongSparseArray>");
        LongSparseArray<E> r1 = (LongSparseArray) ZeusTransformUtils.preCheckCast(r0, LongSparseArray.class, "com.obric.memorydata.plugin");
        r1.keys = (long[]) ZeusTransformUtils.preCheckCast(this.keys.clone(), long[].class, "com.obric.memorydata.plugin");
        r1.values = (Object[]) ZeusTransformUtils.preCheckCast(this.values.clone(), Object[].class, "com.obric.memorydata.plugin");
        return r1;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m33clone() {
        return clone();
    }

    public boolean containsKey(long r1) {
        if (indexOfKey(r1) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean containsValue(E r1) {
        if (indexOfValue(r1) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Deprecated(message = "Alias for `remove(key)`.", replaceWith = @ReplaceWith(expression = "remove(key)", imports = {}))
    public void delete(long r3) {
        int r4 = ContainerHelpersKt.binarySearch(this.keys, this.size, r3);
        if (r4 >= 0) goto L5;
        return;
    L5:
        if (this.values[r4] == LongSparseArrayKt.access$getDELETED$p()) goto L9;
        this.values[r4] = LongSparseArrayKt.access$getDELETED$p();
        this.garbage = true;
        return;
    }

    public E get(long r3) {
        int r4 = ContainerHelpersKt.binarySearch(this.keys, this.size, r3);
        if (r4 >= 0) goto L5;
    L8:
        return null;
    L5:
        if (this.values[r4] == LongSparseArrayKt.access$getDELETED$p()) goto L8;
        return (E) this.values[r4];
    }

    public E get(long r3, E r5) {
        int r4 = ContainerHelpersKt.binarySearch(this.keys, this.size, r3);
        if (r4 >= 0) goto L5;
        return r5;
    L5:
        if (this.values[r4] != LongSparseArrayKt.access$getDELETED$p()) goto L8;
        return r5;
    L8:
        return (E) this.values[r4];
    }

    public int indexOfKey(long r10) {
        if (this.garbage == false) goto L14;
        int r0 = this.size;
        long[] r1 = this.keys;
        Object[] r2 = this.values;
        int r4 = 0;
        int r5 = 0;
    L5:
        if (r4 >= r0) goto L12;
        Object r6 = r2[r4];
        if (r6 == LongSparseArrayKt.access$getDELETED$p()) goto L11;
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
        this.garbage = false;
        this.size = r5;
    L14:
        return ContainerHelpersKt.binarySearch(this.keys, this.size, r10);
    }

    public int indexOfValue(E r10) {
        int r1 = 0;
        if (this.garbage == false) goto L13;
        int r0 = this.size;
        long[] r2 = this.keys;
        Object[] r3 = this.values;
        int r4 = 0;
        int r5 = 0;
    L5:
        if (r4 >= r0) goto L12;
        Object r6 = r3[r4];
        if (r6 == LongSparseArrayKt.access$getDELETED$p()) goto L11;
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
        this.garbage = false;
        this.size = r5;
    L13:
        int r7 = this.size;
    L14:
        if (r1 >= r7) goto L19;
        if (this.values[r1] == r10) goto L26;
        r1 = r1 + 1;
        goto L14
    L26:
        return r1;
    L19:
        return -1;
    }

    public boolean isEmpty() {
        if (size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public long keyAt(int r10) {
        if (r10 >= 0) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L23;
        if (this.garbage == false) goto L21;
        int r2 = this.size;
        long[] r3 = this.keys;
        Object[] r4 = this.values;
        int r5 = 0;
        int r6 = 0;
    L12:
        if (r5 >= r2) goto L19;
        Object r7 = r4[r5];
        if (r7 == LongSparseArrayKt.access$getDELETED$p()) goto L18;
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
        this.garbage = false;
        this.size = r6;
    L21:
        return this.keys[r10];
    L23:
        throw new IllegalArgumentException(("Expected index to be within 0..size()-1, but was " + r10).toString());
    L5:
        if (r10 >= this.size) goto L7;
        r1 = true;
        goto L8
    }

    public void put(long r10, E r12) {
        int r0 = ContainerHelpersKt.binarySearch(this.keys, this.size, r10);
        if (r0 < 0) goto L5;
        this.values[r0] = r12;
        return;
    L5:
        int r1 = ~r0;
        if (r1 >= this.size) goto L11;
        if (this.values[r1] != LongSparseArrayKt.access$getDELETED$p()) goto L11;
        this.keys[r1] = r10;
        this.values[r1] = r12;
        return;
    L11:
        if (this.garbage == false) goto L23;
        int r2 = this.size;
        long[] r3 = this.keys;
        if (r2 < r3.length) goto L23;
        Object[] r4 = this.values;
        int r5 = 0;
        int r6 = 0;
    L15:
        if (r5 >= r2) goto L22;
        Object r7 = r4[r5];
        if (r7 == LongSparseArrayKt.access$getDELETED$p()) goto L21;
        if (r5 == r6) goto L20;
        r3[r6] = r3[r5];
        r4[r6] = r7;
        r4[r5] = null;
    L20:
        r6 = r6 + 1;
    L21:
        r5 = r5 + 1;
        goto L15
    L22:
        this.garbage = false;
        this.size = r6;
        r1 = ~ContainerHelpersKt.binarySearch(this.keys, r6, r10);
    L23:
        int r8 = this.size;
        if (r8 < this.keys.length) goto L26;
        int r9 = ContainerHelpersKt.idealLongArraySize(r8 + 1);
        long[] r11 = Arrays.copyOf(this.keys, r9);
        Intrinsics.checkNotNullExpressionValue(r11, "copyOf(this, newSize)");
        this.keys = r11;
        Object[] r13 = Arrays.copyOf(this.values, r9);
        Intrinsics.checkNotNullExpressionValue(r13, "copyOf(this, newSize)");
        this.values = r13;
    L26:
        int r14 = this.size;
        if ((r14 - r1) == 0) goto L29;
        long[] r15 = this.keys;
        int r16 = r1 + 1;
        ArraysKt.copyInto(r15, r15, r16, r1, r14);
        Object[] r17 = this.values;
        ArraysKt.copyInto(r17, r17, r16, r1, this.size);
    L29:
        this.keys[r1] = r10;
        this.values[r1] = r12;
        this.size++;
    }

    public void putAll(LongSparseArray<? extends E> r6) {
        Intrinsics.checkNotNullParameter(r6, "other");
        int r0 = r6.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        put(r6.keyAt(r1), r6.valueAt(r1));
        r1 = r1 + 1;
        goto L3
    }

    public E putIfAbsent(long r2, E r4) {
        E r0 = get(r2);
        if (r0 != null) goto L5;
        put(r2, r4);
    L5:
        return r0;
    }

    public void remove(long r3) {
        int r4 = ContainerHelpersKt.binarySearch(this.keys, this.size, r3);
        if (r4 >= 0) goto L5;
        return;
    L5:
        if (this.values[r4] == LongSparseArrayKt.access$getDELETED$p()) goto L9;
        this.values[r4] = LongSparseArrayKt.access$getDELETED$p();
        this.garbage = true;
        return;
    }

    public boolean remove(long r1, E r3) {
        int r2 = indexOfKey(r1);
        if (r2 >= 0) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(r3, valueAt(r2)) == false) goto L7;
        removeAt(r2);
        return true;
    }

    public void removeAt(int r3) {
        if (this.values[r3] == LongSparseArrayKt.access$getDELETED$p()) goto L6;
        this.values[r3] = LongSparseArrayKt.access$getDELETED$p();
        this.garbage = true;
        return;
    }

    public E replace(long r1, E r3) {
        int r2 = indexOfKey(r1);
        if (r2 < 0) goto L5;
        Object[] r0 = this.values;
        E r4 = (E) r0[r2];
        r0[r2] = r3;
        return r4;
    L5:
        return null;
    }

    public boolean replace(long r1, E r3, E r4) {
        int r2 = indexOfKey(r1);
        if (r2 >= 0) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(this.values[r2], r3) == false) goto L7;
        this.values[r2] = r4;
        return true;
    }

    public void setValueAt(int r10, E r11) {
        if (r10 >= 0) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L23;
        if (this.garbage == false) goto L20;
        int r2 = this.size;
        long[] r3 = this.keys;
        Object[] r4 = this.values;
        int r5 = 0;
        int r6 = 0;
    L12:
        if (r5 >= r2) goto L19;
        Object r7 = r4[r5];
        if (r7 == LongSparseArrayKt.access$getDELETED$p()) goto L18;
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
        this.garbage = false;
        this.size = r6;
    L20:
        this.values[r10] = r11;
        return;
    L23:
        throw new IllegalArgumentException(("Expected index to be within 0..size()-1, but was " + r10).toString());
    L5:
        if (r10 >= this.size) goto L7;
        r1 = true;
        goto L8
    }

    public int size() {
        if (this.garbage == false) goto L14;
        int r0 = this.size;
        long[] r1 = this.keys;
        Object[] r2 = this.values;
        int r4 = 0;
        int r5 = 0;
    L5:
        if (r4 >= r0) goto L12;
        Object r6 = r2[r4];
        if (r6 == LongSparseArrayKt.access$getDELETED$p()) goto L11;
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
        this.garbage = false;
        this.size = r5;
    L14:
        return this.size;
    }

    public String toString() {
        if (size() > 0) goto L5;
        return "{}";
    L5:
        StringBuilder r1 = new StringBuilder(this.size * 28);
        r1.append('{');
        int r0 = 0;
        int r2 = this.size;
    L6:
        if (r0 >= r2) goto L14;
        if (r0 <= 0) goto L9;
        r1.append(", ");
    L9:
        r1.append(keyAt(r0));
        r1.append('=');
        E r3 = valueAt(r0);
        if (r3 == r1) goto L12;
        r1.append(r3);
    L13:
        r0 = r0 + 1;
        goto L6
    L12:
        r1.append("(this Map)");
        goto L13
    L14:
        r1.append('}');
        String r5 = r1.toString();
        Intrinsics.checkNotNullExpressionValue(r5, "StringBuilder(capacity).…builderAction).toString()");
        return r5;
    }

    public E valueAt(int r10) {
        if (r10 >= 0) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L23;
        if (this.garbage == false) goto L21;
        int r2 = this.size;
        long[] r3 = this.keys;
        Object[] r4 = this.values;
        int r5 = 0;
        int r6 = 0;
    L12:
        if (r5 >= r2) goto L19;
        Object r7 = r4[r5];
        if (r7 == LongSparseArrayKt.access$getDELETED$p()) goto L18;
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
        this.garbage = false;
        this.size = r6;
    L21:
        return (E) this.values[r10];
    L23:
        throw new IllegalArgumentException(("Expected index to be within 0..size()-1, but was " + r10).toString());
    L5:
        if (r10 >= this.size) goto L7;
        r1 = true;
        goto L8
    }
}
