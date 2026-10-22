package androidx.collection;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ConcurrentModificationException;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class SimpleArrayMap<K, V> {
    private static final int BASE_SIZE = 4;
    private static final int CACHE_SIZE = 10;
    private static final boolean CONCURRENT_MODIFICATION_EXCEPTIONS = true;
    private static final boolean DEBUG = false;
    private static final String TAG = "ArrayMap";

    @Nullable
    static Object[] mBaseCache;
    static int mBaseCacheSize;

    @Nullable
    static Object[] mTwiceBaseCache;
    static int mTwiceBaseCacheSize;
    Object[] mArray;
    int[] mHashes;
    int mSize;

    public SimpleArrayMap() {
        this.mHashes = ContainerHelpers.EMPTY_INTS;
        this.mArray = ContainerHelpers.EMPTY_OBJECTS;
        this.mSize = 0;
    }

    private void allocArrays(int r10) {
        if (r10 != 8) goto L18;
        monitor-enter(SimpleArrayMap.class);
        Object[] r5 = mTwiceBaseCache;     // Catch: Throwable -> L11
        if (r5 == null) goto L13;
        this.mArray = r5;     // Catch: Throwable -> L11
        mTwiceBaseCache = (Object[]) r5[0];     // Catch: Throwable -> L11
        this.mHashes = (int[]) r5[1];     // Catch: Throwable -> L11
        r5[1] = null;     // Catch: Throwable -> L11
        r5[0] = null;     // Catch: Throwable -> L11
        mTwiceBaseCacheSize--;     // Catch: Throwable -> L11
        monitor-exit(SimpleArrayMap.class);     // Catch: Throwable -> L11
        return;
    L13:
        monitor-exit(SimpleArrayMap.class);     // Catch: Throwable -> L11
    L32:
        this.mHashes = new int[r10];
        this.mArray = new Object[r10 << 1];
        return;
    L11:
        th = move-exception;
        throw th;
    L18:
        if (r10 != 4) goto L32;
        monitor-enter(SimpleArrayMap.class);
        Object[] r11 = mBaseCache;     // Catch: Throwable -> L26
        if (r11 == null) goto L28;
        this.mArray = r11;     // Catch: Throwable -> L26
        mBaseCache = (Object[]) r11[0];     // Catch: Throwable -> L26
        this.mHashes = (int[]) r11[1];     // Catch: Throwable -> L26
        r11[1] = null;     // Catch: Throwable -> L26
        r11[0] = null;     // Catch: Throwable -> L26
        mBaseCacheSize--;     // Catch: Throwable -> L26
        monitor-exit(SimpleArrayMap.class);     // Catch: Throwable -> L26
        return;
    L28:
        monitor-exit(SimpleArrayMap.class);     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;
    }

    private static int binarySearchHashes(int[] r5, int r10, int r11) {
        return ContainerHelpers.binarySearch(r5, r10, r11);
    L5:
        throw new ConcurrentModificationException();
    }

    private static void freeArrays(int[] r10, Object[] r11, int r12) {
        if (r10.length != 8) goto L19;
        monitor-enter(SimpleArrayMap.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mTwiceBaseCacheSize >= 10) goto L14;
        r11[0] = mTwiceBaseCache;     // Catch: Throwable -> L11
        r11[1] = r10;     // Catch: Throwable -> L11
        int r13 = (r12 << 1) - 1;     // Catch: Throwable -> L11
    L9:
        if (r13 < 2) goto L13;
        r11[r13] = null;     // Catch: Throwable -> L11
        r13 = r13 - 1;     // Catch: Throwable -> L11
        goto L9
    L13:
        mTwiceBaseCache = r11;     // Catch: Throwable -> L11
        mTwiceBaseCacheSize++;     // Catch: Throwable -> L11
    L14:
        monitor-exit(SimpleArrayMap.class);     // Catch: Throwable -> L11
        return;
    L19:
        if (r10.length == 4) goto L21;
        return;
    L21:
        monitor-enter(SimpleArrayMap.class);
    L27:
        th = move-exception;
        throw th;
    L23:
        if (mBaseCacheSize >= 10) goto L30;
        r11[0] = mBaseCache;     // Catch: Throwable -> L27
        r11[1] = r10;     // Catch: Throwable -> L27
        int r14 = (r12 << 1) - 1;     // Catch: Throwable -> L27
    L25:
        if (r14 < 2) goto L29;
        r11[r14] = null;     // Catch: Throwable -> L27
        r14 = r14 - 1;     // Catch: Throwable -> L27
        goto L25
    L29:
        mBaseCache = r11;     // Catch: Throwable -> L27
        mBaseCacheSize++;     // Catch: Throwable -> L27
    L30:
        monitor-exit(SimpleArrayMap.class);     // Catch: Throwable -> L27
    }

    public void clear() {
        int r5 = this.mSize;
        if (r5 <= 0) goto L6;
        int[] r10 = this.mHashes;
        Object[] r11 = this.mArray;
        this.mHashes = ContainerHelpers.EMPTY_INTS;
        this.mArray = ContainerHelpers.EMPTY_OBJECTS;
        this.mSize = 0;
        freeArrays(r10, r11, r5);
    L6:
        if (this.mSize > 0) goto L9;
        return;
    L9:
        throw new ConcurrentModificationException();
    }

    public boolean containsKey(@Nullable Object r5) {
        if (indexOfKey(r5) < 0) goto L5;
        return CONCURRENT_MODIFICATION_EXCEPTIONS;
    L5:
        return false;
    }

    public boolean containsValue(Object r5) {
        if (indexOfValue(r5) < 0) goto L5;
        return CONCURRENT_MODIFICATION_EXCEPTIONS;
    L5:
        return false;
    }

    public void ensureCapacity(int r10) {
        int r5 = this.mSize;
        int[] r11 = this.mHashes;
        if (r11.length >= r10) goto L9;
        Object[] r12 = this.mArray;
        allocArrays(r10);
        if (this.mSize <= 0) goto L7;
        System.arraycopy(r11, 0, this.mHashes, 0, r5);
        System.arraycopy(r12, 0, this.mArray, 0, r5 << 1);
    L7:
        freeArrays(r11, r12, r5);
    L9:
        if (this.mSize != r5) goto L12;
        return;
    L12:
        throw new ConcurrentModificationException();
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return CONCURRENT_MODIFICATION_EXCEPTIONS;
    L6:
        if ((r10 instanceof SimpleArrayMap) == false) goto L26;
        SimpleArrayMap r11 = (SimpleArrayMap) r10;
        if (size() == r11.size()) goto L10;
        return false;
    L10:
        int r5 = 0;
    L48:
        if (r5 >= this.mSize) goto L23;
        K r12 = keyAt(r5);     // Catch: Throwable -> L24
        V r13 = valueAt(r5);     // Catch: Throwable -> L24
        Object r14 = r11.get(r12);     // Catch: Throwable -> L24
        if (r13 != null) goto L20;
        if (r14 != null) goto L18;
        if (r11.containsKey(r12) == false) goto L18;
    L22:
        r5 = r5 + 1;
    L18:
        return false;
    L20:
        if (r13.equals(r14) == true) goto L22;
        return false;
    L23:
        return CONCURRENT_MODIFICATION_EXCEPTIONS;
    L24:
        return false;
    L26:
        if ((r10 instanceof Map) == false) goto L44;
        Map r15 = (Map) r10;
        if (size() == r15.size()) goto L30;
        return false;
    L30:
        int r16 = 0;
    L46:
        if (r16 >= this.mSize) goto L43;
        K r17 = keyAt(r16);     // Catch: Throwable -> L45
        V r18 = valueAt(r16);     // Catch: Throwable -> L45
        Object r19 = r15.get(r17);     // Catch: Throwable -> L45
        if (r18 != null) goto L40;
        if (r19 != null) goto L38;
        if (r15.containsKey(r17) == false) goto L38;
    L42:
        r16 = r16 + 1;
    L38:
        return false;
    L40:
        if (r18.equals(r19) == true) goto L42;
        return false;
    L43:
        return CONCURRENT_MODIFICATION_EXCEPTIONS;
    L44:
        return false;
    }

    @Nullable
    public V get(Object r5) {
        return getOrDefault(r5, null);
    }

    public V getOrDefault(Object r5, V r10) {
        int r11 = indexOfKey(r5);
        if (r11 >= 0) goto L5;
        return r10;
    L5:
        return (V) this.mArray[(r11 << 1) + 1];
    }

    public int hashCode() {
        int[] r5 = this.mHashes;
        Object[] r10 = this.mArray;
        int r11 = this.mSize;
        int r12 = 1;
        int r13 = 0;
        int r14 = 0;
    L3:
        if (r13 >= r11) goto L9;
        Object r15 = r10[r12];
        int r16 = r5[r13];
        if (r15 != null) goto L7;
        int r17 = 0;
    L8:
        r14 = r14 + (r17 ^ r16);
        r13 = r13 + 1;
        r12 = r12 + 2;
        goto L3
    L7:
        r17 = r15.hashCode();
        goto L8
    L9:
        return r14;
    }

    public int indexOf(Object r10, int r11) {
        int r5 = this.mSize;
        if (r5 != 0) goto L6;
        return -1;
    L6:
        int r12 = binarySearchHashes(this.mHashes, r5, r11);
        if (r12 >= 0) goto L10;
        return r12;
    L10:
        if (r10.equals(this.mArray[r12 << 1]) == false) goto L12;
        return r12;
    L12:
        int r13 = r12 + 1;
    L13:
        if (r13 >= r5) goto L20;
        if (this.mHashes[r13] != r11) goto L20;
        if (r10.equals(this.mArray[r13 << 1]) == true) goto L18;
        r13 = r13 + 1;
        goto L13
    L18:
        return r13;
    L20:
        int r14 = r12 - 1;
    L21:
        if (r14 < 0) goto L29;
        if (this.mHashes[r14] != r11) goto L29;
        if (r10.equals(this.mArray[r14 << 1]) == true) goto L26;
        r14 = r14 - 1;
        goto L21
    L26:
        return r14;
    L29:
        return ~r13;
    }

    public int indexOfKey(@Nullable Object r5) {
        if (r5 != null) goto L5;
        return indexOfNull();
    L5:
        return indexOf(r5, r5.hashCode());
    }

    public int indexOfNull() {
        int r5 = this.mSize;
        if (r5 != 0) goto L6;
        return -1;
    L6:
        int r10 = binarySearchHashes(this.mHashes, r5, 0);
        if (r10 >= 0) goto L10;
        return r10;
    L10:
        if (this.mArray[r10 << 1] != null) goto L12;
        return r10;
    L12:
        int r11 = r10 + 1;
    L13:
        if (r11 >= r5) goto L20;
        if (this.mHashes[r11] != 0) goto L20;
        if (this.mArray[r11 << 1] == null) goto L18;
        r11 = r11 + 1;
        goto L13
    L18:
        return r11;
    L20:
        int r12 = r10 - 1;
    L21:
        if (r12 < 0) goto L29;
        if (this.mHashes[r12] != 0) goto L29;
        if (this.mArray[r12 << 1] == null) goto L26;
        r12 = r12 - 1;
        goto L21
    L26:
        return r12;
    L29:
        return ~r11;
    }

    public int indexOfValue(Object r5) {
        int r10 = this.mSize * 2;
        Object[] r11 = this.mArray;
        if (r5 != null) goto L11;
        int r12 = 1;
    L5:
        if (r12 >= r10) goto L18;
        if (r11[r12] == null) goto L9;
        r12 = r12 + 2;
        goto L5
    L9:
        return r12 >> 1;
    L18:
        return -1;
    L11:
        int r13 = 1;
    L12:
        if (r13 >= r10) goto L24;
        if (r5.equals(r11[r13]) == true) goto L16;
        r13 = r13 + 2;
        goto L12
    L16:
        return r13 >> 1;
    L24:
        return -1;
    }

    public boolean isEmpty() {
        if (this.mSize > 0) goto L5;
        return CONCURRENT_MODIFICATION_EXCEPTIONS;
    L5:
        return false;
    }

    public K keyAt(int r5) {
        return (K) this.mArray[r5 << 1];
    }

    @Nullable
    public V put(K r10, V r11) {
        int r5 = this.mSize;
        if (r10 != null) goto L5;
        int r12 = indexOfNull();
        int r13 = 0;
    L6:
        if (r12 < 0) goto L9;
        int r14 = (r12 << 1) + 1;
        Object[] r15 = this.mArray;
        V r16 = (V) r15[r14];
        r15[r14] = r11;
        return r16;
    L9:
        int r17 = ~r12;
        int[] r18 = this.mHashes;
        if (r5 < r18.length) goto L26;
        int r19 = 8;
        if (r5 < 8) goto L15;
        r19 = (r5 >> 1) + r5;
    L18:
        Object[] r20 = this.mArray;
        allocArrays(r19);
        if (r5 != this.mSize) goto L25;
        int[] r21 = this.mHashes;
        if (r21.length <= 0) goto L23;
        System.arraycopy(r18, 0, r21, 0, r18.length);
        System.arraycopy(r20, 0, this.mArray, 0, r20.length);
    L23:
        freeArrays(r18, r20, r5);
        goto L26
    L25:
        throw new ConcurrentModificationException();
    L15:
        if (r5 >= 4) goto L18;
        r19 = 4;
    L26:
        if (r17 >= r5) goto L28;
        int[] r22 = this.mHashes;
        int r23 = r17 + 1;
        System.arraycopy(r22, r17, r22, r23, r5 - r17);
        Object[] r24 = this.mArray;
        System.arraycopy(r24, r17 << 1, r24, r23 << 1, (this.mSize - r17) << 1);
    L28:
        int r25 = this.mSize;
        if (r5 != r25) goto L35;
        int[] r26 = this.mHashes;
        if (r17 >= r26.length) goto L35;
        r26[r17] = r13;
        Object[] r27 = this.mArray;
        int r28 = r17 << 1;
        r27[r28] = r10;
        r27[r28 + 1] = r11;
        this.mSize = r25 + 1;
        return null;
    L35:
        throw new ConcurrentModificationException();
    L5:
        int r29 = r10.hashCode();
        r13 = r29;
        r12 = indexOf(r10, r29);
        goto L6
    }

    public void putAll(@NonNull SimpleArrayMap<? extends K, ? extends V> r5) {
        int r10 = r5.mSize;
        ensureCapacity(this.mSize + r10);
        int r11 = 0;
        if (this.mSize != 0) goto L6;
        if (r10 <= 0) goto L8;
        System.arraycopy(r5.mHashes, 0, this.mHashes, 0, r10);
        System.arraycopy(r5.mArray, 0, this.mArray, 0, r10 << 1);
        this.mSize = r10;
        return;
    L8:
        return;
    L6:
        if (r11 >= r10) goto L11;
        put(r5.keyAt(r11), r5.valueAt(r11));
        r11 = r11 + 1;
        goto L6
    }

    @Nullable
    public V putIfAbsent(K r5, V r10) {
        V r11 = get(r5);
        if (r11 == null) goto L5;
        return r11;
    L5:
        return put(r5, r10);
    }

    @Nullable
    public V remove(Object r5) {
        int r10 = indexOfKey(r5);
        if (r10 >= 0) goto L5;
        return null;
    L5:
        return removeAt(r10);
    }

    public V removeAt(int r11) {
        Object[] r5 = this.mArray;
        int r10 = r11 << 1;
        V r12 = (V) r5[r10 + 1];
        int r13 = this.mSize;
        int r14 = 0;
        if (r13 > 1) goto L5;
        freeArrays(this.mHashes, r5, r13);
        this.mHashes = ContainerHelpers.EMPTY_INTS;
        this.mArray = ContainerHelpers.EMPTY_OBJECTS;
    L24:
        if (r13 != this.mSize) goto L28;
        this.mSize = r14;
        return r12;
    L28:
        throw new ConcurrentModificationException();
    L5:
        int r15 = r13 - 1;
        int[] r16 = this.mHashes;
        int r17 = 8;
        if (r16.length > 8) goto L8;
    L19:
        if (r11 >= r15) goto L21;
        int r18 = r11 + 1;
        int r19 = r15 - r11;
        System.arraycopy(r16, r18, r16, r11, r19);
        Object[] r110 = this.mArray;
        System.arraycopy(r110, r18 << 1, r110, r10, r19 << 1);
    L21:
        Object[] r111 = this.mArray;
        int r20 = r15 << 1;
        r111[r20] = null;
        r111[r20 + 1] = null;
    L22:
        r14 = r15;
        goto L24
    L8:
        if (r13 >= (r16.length / 3)) goto L19;
        if (r13 <= 8) goto L11;
        r17 = r13 + (r13 >> 1);
    L11:
        allocArrays(r17);
        if (r13 != this.mSize) goto L18;
        if (r11 <= 0) goto L15;
        System.arraycopy(r16, 0, this.mHashes, 0, r11);
        System.arraycopy(r5, 0, this.mArray, 0, r10);
    L15:
        if (r11 >= r15) goto L22;
        int r21 = r11 + 1;
        int r22 = r15 - r11;
        System.arraycopy(r16, r21, this.mHashes, r11, r22);
        System.arraycopy(r5, r21 << 1, this.mArray, r10, r22 << 1);
        goto L22
    L18:
        throw new ConcurrentModificationException();
    }

    @Nullable
    public V replace(K r5, V r10) {
        int r11 = indexOfKey(r5);
        if (r11 >= 0) goto L5;
        return null;
    L5:
        return setValueAt(r11, r10);
    }

    public V setValueAt(int r5, V r10) {
        int r11 = (r5 << 1) + 1;
        Object[] r12 = this.mArray;
        V r13 = (V) r12[r11];
        r12[r11] = r10;
        return r13;
    }

    public int size() {
        return this.mSize;
    }

    public String toString() {
        if (isEmpty() == false) goto L6;
        return "{}";
    L6:
        StringBuilder r5 = new StringBuilder(this.mSize * 28);
        r5.append('{');
        int r10 = 0;
    L8:
        if (r10 >= this.mSize) goto L20;
        if (r10 <= 0) goto L11;
        r5.append(", ");
    L11:
        K r11 = keyAt(r10);
        if (r11 == this) goto L14;
        r5.append(r11);
    L15:
        r5.append('=');
        V r12 = valueAt(r10);
        if (r12 == this) goto L18;
        r5.append(r12);
    L19:
        r10 = r10 + 1;
        goto L8
    L18:
        r5.append("(this Map)");
        goto L19
    L14:
        r5.append("(this Map)");
        goto L15
    L20:
        r5.append('}');
        return r5.toString();
    }

    public V valueAt(int r5) {
        return (V) this.mArray[(r5 << 1) + 1];
    }

    public boolean remove(Object r5, Object r10) {
        int r11 = indexOfKey(r5);
        if (r11 < 0) goto L11;
        V r12 = valueAt(r11);
        if (r10 == r12) goto L9;
        if (r10 != null) goto L8;
        return false;
    L8:
        if (r10.equals(r12) == true) goto L9;
        return false;
    L9:
        removeAt(r11);
        return CONCURRENT_MODIFICATION_EXCEPTIONS;
    L11:
        return false;
    }

    public boolean replace(K r5, V r10, V r11) {
        int r12 = indexOfKey(r5);
        if (r12 < 0) goto L11;
        V r13 = valueAt(r12);
        if (r13 == r10) goto L9;
        if (r10 != null) goto L8;
        return false;
    L8:
        if (r10.equals(r13) == true) goto L9;
        return false;
    L9:
        setValueAt(r12, r11);
        return CONCURRENT_MODIFICATION_EXCEPTIONS;
    L11:
        return false;
    }

    public SimpleArrayMap(int r5) {
        if (r5 != 0) goto L5;
        this.mHashes = ContainerHelpers.EMPTY_INTS;
        this.mArray = ContainerHelpers.EMPTY_OBJECTS;
    L6:
        this.mSize = 0;
        return;
    L5:
        allocArrays(r5);
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SimpleArrayMap(SimpleArrayMap<K, V> r5) {
        this();
        if (r5 == 0) goto L6;
        putAll(r5);
        return;
    }
}
