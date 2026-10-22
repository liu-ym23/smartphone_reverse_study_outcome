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
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001a\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u001f\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0011\b\u0007\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u001d\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0016J\b\u0010\u0017\u001a\u00020\u0013H\u0016J\u000e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0016J\u0010\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0004H\u0016J\u0015\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0004H\u0017J\u0018\u0010\u001d\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0014\u001a\u00020\u0004H\u0096\u0002¢\u0006\u0002\u0010\u001eJ\u001d\u0010\u001d\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010 J\u0010\u0010!\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004H\u0016J\u0015\u0010\"\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010#J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u0004H\u0016J\u001d\u0010&\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0016J\u0018\u0010'\u001a\u00020\u00132\u000e\u0010(\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0000H\u0016J\u001f\u0010)\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010 J\u0010\u0010*\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0004H\u0016J\u001a\u0010*\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010+\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u0004H\u0016J\u0018\u0010,\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004H\u0016J\u001f\u0010-\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010 J%\u0010-\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010.\u001a\u00028\u00002\u0006\u0010/\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00100J\u001d\u00101\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016J\b\u00102\u001a\u000203H\u0016J\u0015\u00104\u001a\u00028\u00002\u0006\u0010%\u001a\u00020\u0004H\u0016¢\u0006\u0002\u0010\u001eR\u0012\u0010\u0006\u001a\u00020\u00078\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\u00078G¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\f8\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u00048\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f8\u0000@\u0000X\u0081\u000e¢\u0006\u0004\n\u0002\u0010\u0011¨\u00065"}, d2 = {"Landroidx/collection/SparseArrayCompat;", ExifInterface.LONGITUDE_EAST, "", "initialCapacity", "", "(I)V", "garbage", "", "isEmpty", "getIsEmpty", "()Z", "keys", "", "size", "values", "", "", "[Ljava/lang/Object;", "append", "", "key", EventBody.KEY_VALUE, "(ILjava/lang/Object;)V", "clear", "clone", "containsKey", "containsValue", "(Ljava/lang/Object;)Z", "delete", "get", "(I)Ljava/lang/Object;", "defaultValue", "(ILjava/lang/Object;)Ljava/lang/Object;", "indexOfKey", "indexOfValue", "(Ljava/lang/Object;)I", "keyAt", "index", "put", "putAll", "other", "putIfAbsent", "remove", "removeAt", "removeAtRange", "replace", "oldValue", "newValue", "(ILjava/lang/Object;Ljava/lang/Object;)Z", "setValueAt", "toString", "", "valueAt", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class SparseArrayCompat<E> implements Cloneable {
    public /* synthetic */ boolean garbage;
    public /* synthetic */ int[] keys;
    public /* synthetic */ int size;
    public /* synthetic */ Object[] values;

    public SparseArrayCompat() {
        this(0, 1, null);
    }

    public SparseArrayCompat(int r2) {
        if (r2 != 0) goto L5;
        this.keys = ContainerHelpersKt.EMPTY_INTS;
        this.values = ContainerHelpersKt.EMPTY_OBJECTS;
        return;
    L5:
        int r3 = ContainerHelpersKt.idealIntArraySize(r2);
        this.keys = new int[r3];
        this.values = new Object[r3];
    }

    public /* synthetic */ SparseArrayCompat(int r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = 10;
    L5:
        this(r1);
    }

    public void append(int r5, E r6) {
        int r0 = this.size;
        if (r0 == 0) goto L8;
        if (r5 > this.keys[r0 - 1]) goto L8;
        put(r5, r6);
        return;
    L8:
        if (this.garbage == true) goto L10;
    L12:
        int r1 = this.size;
        if (r1 < this.keys.length) goto L15;
        int r2 = ContainerHelpersKt.idealIntArraySize(r1 + 1);
        int[] r3 = Arrays.copyOf(this.keys, r2);
        Intrinsics.checkNotNullExpressionValue(r3, "copyOf(this, newSize)");
        this.keys = r3;
        Object[] r4 = Arrays.copyOf(this.values, r2);
        Intrinsics.checkNotNullExpressionValue(r4, "copyOf(this, newSize)");
        this.values = r4;
    L15:
        this.keys[r1] = r5;
        this.values[r1] = r6;
        this.size = r1 + 1;
        return;
    L10:
        if (r0 < this.keys.length) goto L12;
        SparseArrayCompatKt.access$gc(this);
        goto L12
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

    public SparseArrayCompat<E> clone() {
        Object r0 = super.clone();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type androidx.collection.SparseArrayCompat<E of androidx.collection.SparseArrayCompat>");
        SparseArrayCompat<E> r1 = (SparseArrayCompat) ZeusTransformUtils.preCheckCast(r0, SparseArrayCompat.class, "com.obric.memorydata.plugin");
        r1.keys = (int[]) ZeusTransformUtils.preCheckCast(this.keys.clone(), int[].class, "com.obric.memorydata.plugin");
        r1.values = (Object[]) ZeusTransformUtils.preCheckCast(this.values.clone(), Object[].class, "com.obric.memorydata.plugin");
        return r1;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m34clone() {
        return clone();
    }

    public boolean containsKey(int r1) {
        if (indexOfKey(r1) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean containsValue(E r5) {
        if (this.garbage == false) goto L5;
        SparseArrayCompatKt.access$gc(this);
    L5:
        int r0 = this.size;
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L11;
        if (this.values[r2] == r5) goto L12;
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

    @Deprecated(message = "Alias for remove(int).", replaceWith = @ReplaceWith(expression = "remove(key)", imports = {}))
    public void delete(int r1) {
        remove(r1);
    }

    public E get(int r1) {
        return (E) SparseArrayCompatKt.commonGet(this, r1);
    }

    public E get(int r1, E r2) {
        return (E) SparseArrayCompatKt.commonGet(this, r1, r2);
    }

    public final boolean getIsEmpty() {
        return isEmpty();
    }

    public int indexOfKey(int r2) {
        if (this.garbage == false) goto L6;
        SparseArrayCompatKt.access$gc(this);
    L6:
        return ContainerHelpersKt.binarySearch(this.keys, this.size, r2);
    }

    public int indexOfValue(E r4) {
        if (this.garbage == false) goto L5;
        SparseArrayCompatKt.access$gc(this);
    L5:
        int r0 = 0;
        int r1 = this.size;
    L6:
        if (r0 >= r1) goto L11;
        if (this.values[r0] == r4) goto L15;
        r0 = r0 + 1;
        goto L6
    L15:
        return r0;
    L11:
        return -1;
    }

    public boolean isEmpty() {
        if (size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public int keyAt(int r2) {
        if (this.garbage == false) goto L6;
        SparseArrayCompatKt.access$gc(this);
    L6:
        return this.keys[r2];
    }

    public void put(int r5, E r6) {
        int r0 = ContainerHelpersKt.binarySearch(this.keys, this.size, r5);
        if (r0 < 0) goto L5;
        this.values[r0] = r6;
        return;
    L5:
        int r1 = ~r0;
        if (r1 >= this.size) goto L11;
        if (this.values[r1] != SparseArrayCompatKt.access$getDELETED$p()) goto L11;
        this.keys[r1] = r5;
        this.values[r1] = r6;
        return;
    L11:
        if (this.garbage == true) goto L13;
    L15:
        int r2 = this.size;
        if (r2 < this.keys.length) goto L18;
        int r3 = ContainerHelpersKt.idealIntArraySize(r2 + 1);
        int[] r4 = Arrays.copyOf(this.keys, r3);
        Intrinsics.checkNotNullExpressionValue(r4, "copyOf(this, newSize)");
        this.keys = r4;
        Object[] r7 = Arrays.copyOf(this.values, r3);
        Intrinsics.checkNotNullExpressionValue(r7, "copyOf(this, newSize)");
        this.values = r7;
    L18:
        int r8 = this.size;
        if ((r8 - r1) == 0) goto L21;
        int[] r9 = this.keys;
        int r10 = r1 + 1;
        ArraysKt.copyInto(r9, r9, r10, r1, r8);
        Object[] r11 = this.values;
        ArraysKt.copyInto(r11, r11, r10, r1, this.size);
    L21:
        this.keys[r1] = r5;
        this.values[r1] = r6;
        this.size++;
        return;
    L13:
        if (this.size < this.keys.length) goto L15;
        SparseArrayCompatKt.access$gc(this);
        r1 = ~ContainerHelpersKt.binarySearch(this.keys, this.size, r5);
        goto L15
    }

    public void putAll(SparseArrayCompat<? extends E> r9) {
        Intrinsics.checkNotNullParameter(r9, "other");
        int r0 = r9.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L25;
        int r2 = r9.keyAt(r1);
        E r3 = r9.valueAt(r1);
        int r4 = ContainerHelpersKt.binarySearch(this.keys, this.size, r2);
        if (r4 < 0) goto L7;
        this.values[r4] = r3;
    L24:
        r1 = r1 + 1;
        goto L3
    L7:
        int r5 = ~r4;
        if (r5 >= this.size) goto L13;
        if (this.values[r5] != SparseArrayCompatKt.access$getDELETED$p()) goto L13;
        this.keys[r5] = r2;
        this.values[r5] = r3;
    L13:
        if (this.garbage == true) goto L15;
    L17:
        int r6 = this.size;
        if (r6 < this.keys.length) goto L20;
        int r7 = ContainerHelpersKt.idealIntArraySize(r6 + 1);
        int[] r8 = Arrays.copyOf(this.keys, r7);
        Intrinsics.checkNotNullExpressionValue(r8, "copyOf(this, newSize)");
        this.keys = r8;
        Object[] r10 = Arrays.copyOf(this.values, r7);
        Intrinsics.checkNotNullExpressionValue(r10, "copyOf(this, newSize)");
        this.values = r10;
    L20:
        int r11 = this.size;
        if ((r11 - r5) == 0) goto L23;
        int[] r12 = this.keys;
        int r13 = r5 + 1;
        ArraysKt.copyInto(r12, r12, r13, r5, r11);
        Object[] r14 = this.values;
        ArraysKt.copyInto(r14, r14, r13, r5, this.size);
    L23:
        this.keys[r5] = r2;
        this.values[r5] = r3;
        this.size++;
        goto L24
    L15:
        if (this.size < this.keys.length) goto L17;
        SparseArrayCompatKt.access$gc(this);
        r5 = ~ContainerHelpersKt.binarySearch(this.keys, this.size, r2);
        goto L17
    }

    public E putIfAbsent(int r6, E r7) {
        E r0 = (E) SparseArrayCompatKt.commonGet(this, r6);
        if (r0 != null) goto L24;
        int r1 = ContainerHelpersKt.binarySearch(this.keys, this.size, r6);
        if (r1 < 0) goto L7;
        this.values[r1] = r7;
        goto L24
    L7:
        int r2 = ~r1;
        if (r2 >= this.size) goto L13;
        if (this.values[r2] != SparseArrayCompatKt.access$getDELETED$p()) goto L13;
        this.keys[r2] = r6;
        this.values[r2] = r7;
    L13:
        if (this.garbage == true) goto L15;
    L17:
        int r3 = this.size;
        if (r3 < this.keys.length) goto L20;
        int r4 = ContainerHelpersKt.idealIntArraySize(r3 + 1);
        int[] r5 = Arrays.copyOf(this.keys, r4);
        Intrinsics.checkNotNullExpressionValue(r5, "copyOf(this, newSize)");
        this.keys = r5;
        Object[] r8 = Arrays.copyOf(this.values, r4);
        Intrinsics.checkNotNullExpressionValue(r8, "copyOf(this, newSize)");
        this.values = r8;
    L20:
        int r9 = this.size;
        if ((r9 - r2) == 0) goto L23;
        int[] r10 = this.keys;
        int r11 = r2 + 1;
        ArraysKt.copyInto(r10, r10, r11, r2, r9);
        Object[] r12 = this.values;
        ArraysKt.copyInto(r12, r12, r11, r2, this.size);
    L23:
        this.keys[r2] = r6;
        this.values[r2] = r7;
        this.size++;
        goto L24
    L15:
        if (this.size < this.keys.length) goto L17;
        SparseArrayCompatKt.access$gc(this);
        r2 = ~ContainerHelpersKt.binarySearch(this.keys, this.size, r6);
    L24:
        return r0;
    }

    public void remove(int r1) {
        SparseArrayCompatKt.commonRemove(this, r1);
    }

    public boolean remove(int r2, Object r3) {
        int r4 = indexOfKey(r2);
        if (r4 >= 0) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(r3, valueAt(r4)) == false) goto L7;
        removeAt(r4);
        return true;
    }

    public void removeAt(int r3) {
        if (this.values[r3] == SparseArrayCompatKt.access$getDELETED$p()) goto L6;
        this.values[r3] = SparseArrayCompatKt.access$getDELETED$p();
        this.garbage = true;
        return;
    }

    public void removeAtRange(int r2, int r3) {
        int r4 = Math.min(r3, r2 + r3);
    L3:
        if (r2 >= r4) goto L5;
        removeAt(r2);
        r2 = r2 + 1;
        goto L3
    }

    public E replace(int r2, E r3) {
        int r4 = indexOfKey(r2);
        if (r4 < 0) goto L5;
        Object[] r1 = this.values;
        E r0 = (E) r1[r4];
        r1[r4] = r3;
        return r0;
    L5:
        return null;
    }

    public boolean replace(int r2, E r3, E r4) {
        int r5 = indexOfKey(r2);
        if (r5 >= 0) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(this.values[r5], r3) == false) goto L7;
        this.values[r5] = r4;
        return true;
    }

    public void setValueAt(int r2, E r3) {
        if (this.garbage == false) goto L5;
        SparseArrayCompatKt.access$gc(this);
    L5:
        this.values[r2] = r3;
    }

    public int size() {
        if (this.garbage == false) goto L6;
        SparseArrayCompatKt.access$gc(this);
    L6:
        return this.size;
    }

    public String toString() {
        if (size() > 0) goto L5;
        return "{}";
    L5:
        StringBuilder r0 = new StringBuilder(this.size * 28);
        r0.append('{');
        int r1 = 0;
        int r2 = this.size;
    L6:
        if (r1 >= r2) goto L14;
        if (r1 <= 0) goto L9;
        r0.append(", ");
    L9:
        r0.append(keyAt(r1));
        r0.append('=');
        E r3 = valueAt(r1);
        if (r3 == this) goto L12;
        r0.append(r3);
    L13:
        r1 = r1 + 1;
        goto L6
    L12:
        r0.append("(this Map)");
        goto L13
    L14:
        r0.append('}');
        String r4 = r0.toString();
        Intrinsics.checkNotNullExpressionValue(r4, "buffer.toString()");
        return r4;
    }

    public E valueAt(int r2) {
        if (this.garbage == false) goto L6;
        SparseArrayCompatKt.access$gc(this);
    L6:
        return (E) this.values[r2];
    }
}
