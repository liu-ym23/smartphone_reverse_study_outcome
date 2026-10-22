package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b)\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B!\b\u0016\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0006\b\u0001\u0012\u00028\u0001\u0018\u00010\u0000¢\u0006\u0002\u0010\u0005B\u0011\b\u0007\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0015\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0014J\u0015\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0014J\u0010\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0007H\u0016J\u0013\u0010\u0019\u001a\u00020\u00122\b\u0010\u001a\u001a\u0004\u0018\u00010\u0003H\u0096\u0002J\u0018\u0010\u001b\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0013\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u001cJ\u001f\u0010\u001d\u001a\u00028\u00012\b\u0010\u0013\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001e\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001fJ,\u0010 \u001a\u0002H!\"\n\b\u0002\u0010!*\u0004\u0018\u00018\u00012\b\u0010\u0013\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001e\u001a\u0002H!H\u0082\b¢\u0006\u0002\u0010\u001fJ\b\u0010\"\u001a\u00020\u0007H\u0016J\u001d\u0010#\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00028\u00002\u0006\u0010$\u001a\u00020\u0007H\u0002¢\u0006\u0002\u0010%J\u0015\u0010&\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010'J\b\u0010(\u001a\u00020\u0007H\u0002J\u0017\u0010)\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00028\u0001H\u0001¢\u0006\u0004\b*\u0010'J\b\u0010+\u001a\u00020\u0012H\u0016J\u0015\u0010,\u001a\u00028\u00002\u0006\u0010-\u001a\u00020\u0007H\u0016¢\u0006\u0002\u0010.J\u001f\u0010/\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001fJ \u00100\u001a\u00020\u00102\u0016\u0010\u0004\u001a\u0012\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0006\b\u0001\u0012\u00028\u00010\u0000H\u0016J\u001f\u00101\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001fJ\u0017\u00102\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0013\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001cJ\u001d\u00102\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00028\u0001H\u0016¢\u0006\u0002\u00103J\u0015\u00104\u001a\u00028\u00012\u0006\u0010-\u001a\u00020\u0007H\u0016¢\u0006\u0002\u0010.J\u001f\u00105\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001fJ%\u00105\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00028\u00002\u0006\u00106\u001a\u00028\u00012\u0006\u00107\u001a\u00028\u0001H\u0016¢\u0006\u0002\u00108J\u001d\u00109\u001a\u00028\u00012\u0006\u0010-\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010:J\b\u0010\u000e\u001a\u00020\u0007H\u0016J\b\u0010;\u001a\u00020<H\u0016J\u0015\u0010=\u001a\u00028\u00012\u0006\u0010-\u001a\u00020\u0007H\u0016¢\u0006\u0002\u0010.R\u0018\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Landroidx/collection/SimpleArrayMap;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "map", "(Landroidx/collection/SimpleArrayMap;)V", "capacity", "", "(I)V", "array", "", "[Ljava/lang/Object;", "hashes", "", "size", "clear", "", "containsKey", "", "key", "(Ljava/lang/Object;)Z", "containsValue", EventBody.KEY_VALUE, "ensureCapacity", "minimumCapacity", "equals", "other", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "getOrDefault", "defaultValue", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "getOrDefaultInternal", ExifInterface.GPS_DIRECTION_TRUE, "hashCode", "indexOf", "hash", "(Ljava/lang/Object;I)I", "indexOfKey", "(Ljava/lang/Object;)I", "indexOfNull", "indexOfValue", "__restricted$indexOfValue", "isEmpty", "keyAt", "index", "(I)Ljava/lang/Object;", "put", "putAll", "putIfAbsent", "remove", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "removeAt", "replace", "oldValue", "newValue", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z", "setValueAt", "(ILjava/lang/Object;)Ljava/lang/Object;", "toString", "", "valueAt", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class SimpleArrayMap<K, V> {
    private Object[] array;
    private int[] hashes;
    private int size;

    public SimpleArrayMap() {
        this(0, 1, null);
    }

    public SimpleArrayMap(int r2) {
        if (r2 != 0) goto L5;
        int[] r0 = ContainerHelpersKt.EMPTY_INTS;
    L6:
        this.hashes = r0;
        if (r2 != 0) goto L9;
        Object[] r3 = ContainerHelpersKt.EMPTY_OBJECTS;
    L10:
        this.array = r3;
        return;
    L9:
        r3 = new Object[r2 << 1];
        goto L10
    L5:
        r0 = new int[r2];
        goto L6
    }

    public /* synthetic */ SimpleArrayMap(int r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = 0;
    L5:
        this(r1);
    }

    public SimpleArrayMap(SimpleArrayMap<? extends K, ? extends V> r4) {
        this(0, 1, null);
        if (r4 == null) goto L6;
        putAll(r4);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final <T extends V> T getOrDefaultInternal(Object r1, T r2) {
        int r3 = indexOfKey(r1);
        if (r3 >= 0) goto L5;
        return r2;
    L5:
        return (T) this.array[(r3 << 1) + 1];
    }

    private final int indexOf(K r6, int r7) {
        int r0 = this.size;
        if (r0 != 0) goto L6;
        return -1;
    L6:
        int r1 = ContainerHelpersKt.binarySearch(this.hashes, r0, r7);
        if (r1 >= 0) goto L10;
        return r1;
    L10:
        if (Intrinsics.areEqual(r6, this.array[r1 << 1]) == false) goto L12;
        return r1;
    L12:
        int r2 = r1 + 1;
    L13:
        if (r2 >= r0) goto L20;
        if (this.hashes[r2] != r7) goto L20;
        if (Intrinsics.areEqual(r6, this.array[r2 << 1]) == true) goto L18;
        r2 = r2 + 1;
        goto L13
    L18:
        return r2;
    L20:
        int r3 = r1 - 1;
    L21:
        if (r3 < 0) goto L29;
        if (this.hashes[r3] != r7) goto L29;
        if (Intrinsics.areEqual(r6, this.array[r3 << 1]) == true) goto L26;
        r3 = r3 - 1;
        goto L21
    L26:
        return r3;
    L29:
        return ~r2;
    }

    private final int indexOfNull() {
        int r0 = this.size;
        if (r0 != 0) goto L6;
        return -1;
    L6:
        int r1 = ContainerHelpersKt.binarySearch(this.hashes, r0, 0);
        if (r1 >= 0) goto L10;
        return r1;
    L10:
        if (this.array[r1 << 1] != null) goto L12;
        return r1;
    L12:
        int r2 = r1 + 1;
    L13:
        if (r2 >= r0) goto L20;
        if (this.hashes[r2] != 0) goto L20;
        if (this.array[r2 << 1] == null) goto L18;
        r2 = r2 + 1;
        goto L13
    L18:
        return r2;
    L20:
        int r3 = r1 - 1;
    L21:
        if (r3 < 0) goto L29;
        if (this.hashes[r3] != 0) goto L29;
        if (this.array[r3 << 1] == null) goto L26;
        r3 = r3 - 1;
        goto L21
    L26:
        return r3;
    L29:
        return ~r2;
    }

    public final int __restricted$indexOfValue(V r5) {
        int r0 = this.size * 2;
        Object[] r4 = this.array;
        if (r5 != null) goto L11;
        int r6 = 1;
    L5:
        if (r6 >= r0) goto L18;
        if (r4[r6] == null) goto L9;
        r6 = r6 + 2;
        goto L5
    L9:
        return r6 >> 1;
    L18:
        return -1;
    L11:
        int r2 = 1;
    L12:
        if (r2 >= r0) goto L24;
        if (Intrinsics.areEqual(r5, r4[r2]) == true) goto L16;
        r2 = r2 + 2;
        goto L12
    L16:
        return r2 >> 1;
    L24:
        return -1;
    }

    public void clear() {
        if (this.size <= 0) goto L6;
        this.hashes = ContainerHelpersKt.EMPTY_INTS;
        this.array = ContainerHelpersKt.EMPTY_OBJECTS;
        this.size = 0;
    L6:
        if (this.size > 0) goto L9;
        return;
    L9:
        throw new ConcurrentModificationException();
    }

    public boolean containsKey(K r1) {
        if (indexOfKey(r1) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean containsValue(V r1) {
        if (__restricted$indexOfValue(r1) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void ensureCapacity(int r4) {
        int r0 = this.size;
        int[] r1 = this.hashes;
        if (r1.length >= r4) goto L6;
        int[] r2 = Arrays.copyOf(r1, r4);
        Intrinsics.checkNotNullExpressionValue(r2, "copyOf(this, newSize)");
        this.hashes = r2;
        Object[] r5 = Arrays.copyOf(this.array, r4 * 2);
        Intrinsics.checkNotNullExpressionValue(r5, "copyOf(this, newSize)");
        this.array = r5;
    L6:
        if (this.size != r0) goto L9;
        return;
    L9:
        throw new ConcurrentModificationException();
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L45;
        return true;
    L45:
        if (ZeusTransformUtils.instanceOf(r9, SimpleArrayMap.class) == false) goto L26;
        if (size() == ((SimpleArrayMap) ZeusTransformUtils.preCheckCast(r9, SimpleArrayMap.class, "com.obric.memorydata.plugin")).size()) goto L12;
        return false;
    L12:
        SimpleArrayMap r10 = (SimpleArrayMap) ZeusTransformUtils.preCheckCast(r9, SimpleArrayMap.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L44 Throwable -> L44
        int r0 = this.size;     // Catch: Throwable -> L44 Throwable -> L44
        int r3 = 0;
    L13:
        if (r3 >= r0) goto L24;
        K r4 = keyAt(r3);     // Catch: Throwable -> L44 Throwable -> L44
        V r5 = valueAt(r3);     // Catch: Throwable -> L44 Throwable -> L44
        Object r6 = r10.get(r4);     // Catch: Throwable -> L44 Throwable -> L44
        if (r5 != null) goto L21;
        if (r6 != null) goto L19;
        if (r10.containsKey(r4) == false) goto L19;
    L23:
        r3 = r3 + 1;     // Catch: Throwable -> L44 Throwable -> L44
    L19:
        return false;
    L21:
        if (Intrinsics.areEqual(r5, r6) == true) goto L23;
        return false;
    L24:
        return true;
    L26:
        if (ZeusTransformUtils.instanceOf(r9, Map.class) == false) goto L43;
        if (size() == ((Map) ZeusTransformUtils.preCheckCast(r9, Map.class, "com.obric.memorydata.plugin")).size()) goto L30;
        return false;
    L30:
        int r1 = this.size;     // Catch: Throwable -> L44 Throwable -> L44
        int r7 = 0;
    L31:
        if (r7 >= r1) goto L42;
        K r8 = keyAt(r7);     // Catch: Throwable -> L44 Throwable -> L44
        V r11 = valueAt(r7);     // Catch: Throwable -> L44 Throwable -> L44
        Object r12 = ((Map) ZeusTransformUtils.preCheckCast(r9, Map.class, "com.obric.memorydata.plugin")).get(r8);     // Catch: Throwable -> L44 Throwable -> L44
        if (r11 != null) goto L39;
        if (r12 != null) goto L37;
        if (((Map) ZeusTransformUtils.preCheckCast(r9, Map.class, "com.obric.memorydata.plugin")).containsKey(r8) == false) goto L37;
    L41:
        r7 = r7 + 1;
    L37:
        return false;
    L39:
        if (Intrinsics.areEqual(r11, r12) == true) goto L41;
        return false;
    L42:
        return true;
    L43:
        return false;
    }

    public V get(K r1) {
        int r2 = indexOfKey(r1);
        if (r2 >= 0) goto L7;
        return null;
    L7:
        return (V) this.array[(r2 << 1) + 1];
    }

    /* JADX WARN: Multi-variable type inference failed */
    public V getOrDefault(Object r1, V r2) {
        int r3 = indexOfKey(r1);
        if (r3 >= 0) goto L5;
        return r2;
    L5:
        return (V) this.array[(r3 << 1) + 1];
    }

    public int hashCode() {
        int[] r0 = this.hashes;
        Object[] r1 = this.array;
        int r8 = this.size;
        int r2 = 1;
        int r4 = 0;
        int r5 = 0;
    L3:
        if (r4 >= r8) goto L9;
        Object r6 = r1[r2];
        int r7 = r0[r4];
        if (r6 == null) goto L7;
        int r9 = r6.hashCode();
    L8:
        r5 = r5 + (r9 ^ r7);
        r4 = r4 + 1;
        r2 = r2 + 2;
        goto L3
    L7:
        r9 = 0;
        goto L8
    L9:
        return r5;
    }

    public int indexOfKey(K r2) {
        if (r2 != null) goto L5;
        return indexOfNull();
    L5:
        return indexOf(r2, r2.hashCode());
    }

    public boolean isEmpty() {
        if (this.size > 0) goto L5;
        return true;
    L5:
        return false;
    }

    public K keyAt(int r4) {
        boolean r1 = false;
        if (r4 >= 0) goto L5;
    L7:
        if (r1 == false) goto L11;
        return (K) this.array[r4 << 1];
    L11:
        throw new IllegalArgumentException(("Expected index to be within 0..size()-1, but was " + r4).toString());
    L5:
        if (r4 >= this.size) goto L7;
        r1 = true;
        goto L7
    }

    public V put(K r8, V r9) {
        int r0 = this.size;
        if (r8 == null) goto L5;
        int r1 = r8.hashCode();
    L6:
        if (r8 == null) goto L8;
        int r2 = indexOf(r8, r1);
    L9:
        if (r2 < 0) goto L12;
        int r10 = (r2 << 1) + 1;
        Object[] r7 = this.array;
        V r3 = (V) r7[r10];
        r7[r10] = r9;
        return r3;
    L12:
        int r4 = ~r2;
        int[] r5 = this.hashes;
        if (r0 < r5.length) goto L24;
        int r6 = 4;
        if (r0 < 8) goto L17;
        r6 = (r0 >> 1) + r0;
    L19:
        int[] r11 = Arrays.copyOf(r5, r6);
        Intrinsics.checkNotNullExpressionValue(r11, "copyOf(this, newSize)");
        this.hashes = r11;
        Object[] r12 = Arrays.copyOf(this.array, r6 << 1);
        Intrinsics.checkNotNullExpressionValue(r12, "copyOf(this, newSize)");
        this.array = r12;
        if (r0 == this.size) goto L24;
        throw new ConcurrentModificationException();
    L17:
        if (r0 < 4) goto L19;
        r6 = 8;
    L24:
        if (r4 >= r0) goto L26;
        int[] r13 = this.hashes;
        int r14 = r4 + 1;
        ArraysKt.copyInto(r13, r13, r14, r4, r0);
        Object[] r15 = this.array;
        ArraysKt.copyInto(r15, r15, r14 << 1, r4 << 1, this.size << 1);
    L26:
        int r16 = this.size;
        if (r0 != r16) goto L33;
        int[] r17 = this.hashes;
        if (r4 >= r17.length) goto L33;
        r17[r4] = r1;
        Object[] r18 = this.array;
        int r19 = r4 << 1;
        r18[r19] = r8;
        r18[r19 + 1] = r9;
        this.size = r16 + 1;
        return null;
    L33:
        throw new ConcurrentModificationException();
    L8:
        r2 = indexOfNull();
        goto L9
    L5:
        r1 = 0;
        goto L6
    }

    public void putAll(SimpleArrayMap<? extends K, ? extends V> r5) {
        Intrinsics.checkNotNullParameter(r5, "map");
        int r0 = r5.size;
        ensureCapacity(this.size + r0);
        int r2 = 0;
        if (this.size != 0) goto L6;
        if (r0 <= 0) goto L8;
        ArraysKt.copyInto(r5.hashes, this.hashes, 0, 0, r0);
        ArraysKt.copyInto(r5.array, this.array, 0, 0, r0 << 1);
        this.size = r0;
        return;
    L8:
        return;
    L6:
        if (r2 >= r0) goto L11;
        put(r5.keyAt(r2), r5.valueAt(r2));
        r2 = r2 + 1;
        goto L6
    }

    public V putIfAbsent(K r2, V r3) {
        V r0 = get(r2);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return put(r2, r3);
    }

    public V remove(K r1) {
        int r2 = indexOfKey(r1);
        if (r2 >= 0) goto L7;
        return null;
    L7:
        return removeAt(r2);
    }

    public boolean remove(K r2, V r3) {
        int r4 = indexOfKey(r2);
        if (r4 >= 0) goto L5;
        return false;
    L5:
        if (Intrinsics.areEqual(r3, valueAt(r4)) == false) goto L10;
        removeAt(r4);
        return true;
    L10:
        return false;
    }

    public V removeAt(int r12) {
        if (r12 >= 0) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L36;
        Object[] r3 = this.array;
        int r4 = r12 << 1;
        V r5 = (V) r3[r4 + 1];
        int r6 = this.size;
        if (r6 > 1) goto L12;
        clear();
    L32:
        return r5;
    L12:
        int r7 = r6 - 1;
        int[] r8 = this.hashes;
        int r9 = 8;
        if (r8.length > 8) goto L15;
    L26:
        if (r12 >= r7) goto L28;
        int r0 = r12 + 1;
        int r10 = r7 + 1;
        ArraysKt.copyInto(r8, r8, r12, r0, r10);
        Object[] r13 = this.array;
        ArraysKt.copyInto(r13, r13, r4, r0 << 1, r10 << 1);
    L28:
        Object[] r14 = this.array;
        int r1 = r7 << 1;
        r14[r1] = null;
        r14[r1 + 1] = null;
    L30:
        if (r6 != this.size) goto L34;
        this.size = r7;
        goto L32
    L34:
        throw new ConcurrentModificationException();
    L15:
        if (r6 >= (r8.length / 3)) goto L26;
        if (r6 <= 8) goto L18;
        r9 = r6 + (r6 >> 1);
    L18:
        int[] r11 = Arrays.copyOf(r8, r9);
        Intrinsics.checkNotNullExpressionValue(r11, "copyOf(this, newSize)");
        this.hashes = r11;
        Object[] r15 = Arrays.copyOf(this.array, r9 << 1);
        Intrinsics.checkNotNullExpressionValue(r15, "copyOf(this, newSize)");
        this.array = r15;
        if (r6 != this.size) goto L25;
        if (r12 <= 0) goto L22;
        ArraysKt.copyInto(r8, this.hashes, 0, 0, r12);
        ArraysKt.copyInto(r3, this.array, 0, 0, r4);
    L22:
        if (r12 >= r7) goto L30;
        int r16 = r12 + 1;
        int r17 = r7 + 1;
        ArraysKt.copyInto(r8, this.hashes, r12, r16, r17);
        ArraysKt.copyInto(r3, this.array, r4, r16 << 1, r17 << 1);
        goto L30
    L25:
        throw new ConcurrentModificationException();
    L36:
        throw new IllegalArgumentException(("Expected index to be within 0..size()-1, but was " + r12).toString());
    L5:
        if (r12 >= this.size) goto L7;
        r2 = true;
        goto L8
    }

    public V replace(K r1, V r2) {
        int r3 = indexOfKey(r1);
        if (r3 >= 0) goto L7;
        return null;
    L7:
        return setValueAt(r3, r2);
    }

    public boolean replace(K r2, V r3, V r4) {
        int r5 = indexOfKey(r2);
        if (r5 >= 0) goto L5;
        return false;
    L5:
        if (Intrinsics.areEqual(r3, valueAt(r5)) == false) goto L10;
        setValueAt(r5, r4);
        return true;
    L10:
        return false;
    }

    public V setValueAt(int r4, V r5) {
        boolean r0 = false;
        if (r4 >= 0) goto L5;
    L7:
        if (r0 == false) goto L11;
        int r6 = (r4 << 1) + 1;
        Object[] r3 = this.array;
        V r1 = (V) r3[r6];
        r3[r6] = r5;
        return r1;
    L11:
        throw new IllegalArgumentException(("Expected index to be within 0..size()-1, but was " + r4).toString());
    L5:
        if (r4 >= this.size) goto L7;
        r0 = true;
        goto L7
    }

    public int size() {
        return this.size;
    }

    public String toString() {
        if (isEmpty() == false) goto L6;
        return "{}";
    L6:
        StringBuilder r1 = new StringBuilder(this.size * 28);
        r1.append('{');
        int r0 = 0;
        int r2 = this.size;
    L7:
        if (r0 >= r2) goto L19;
        if (r0 <= 0) goto L10;
        r1.append(", ");
    L10:
        K r3 = keyAt(r0);
        if (r3 == r1) goto L13;
        r1.append(r3);
    L14:
        r1.append('=');
        V r4 = valueAt(r0);
        if (r4 == r1) goto L17;
        r1.append(r4);
    L18:
        r0 = r0 + 1;
        goto L7
    L17:
        r1.append("(this Map)");
        goto L18
    L13:
        r1.append("(this Map)");
        goto L14
    L19:
        r1.append('}');
        String r5 = r1.toString();
        Intrinsics.checkNotNullExpressionValue(r5, "StringBuilder(capacity).…builderAction).toString()");
        return r5;
    }

    public V valueAt(int r4) {
        boolean r0 = false;
        if (r4 >= 0) goto L5;
    L7:
        if (r0 == false) goto L11;
        return (V) this.array[(r4 << 1) + 1];
    L11:
        throw new IllegalArgumentException(("Expected index to be within 0..size()-1, but was " + r4).toString());
    L5:
        if (r4 >= this.size) goto L7;
        r0 = true;
        goto L7
    }
}
