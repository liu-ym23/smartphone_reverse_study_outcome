package androidx.collection;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class ArraySet<E> implements Collection<E>, Set<E> {
    private static final int BASE_SIZE = 4;
    private static final int CACHE_SIZE = 10;
    private static final boolean DEBUG = false;
    private static final int[] INT = null;
    private static final Object[] OBJECT = null;
    private static final String TAG = "ArraySet";

    @Nullable
    private static Object[] sBaseCache;
    private static int sBaseCacheSize;

    @Nullable
    private static Object[] sTwiceBaseCache;
    private static int sTwiceBaseCacheSize;
    Object[] mArray;
    private MapCollections<E, E> mCollections;
    private int[] mHashes;
    int mSize;

    static {
        INT = new int[0];
        OBJECT = new Object[0];
    }

    public ArraySet() {
        this(0);
    }

    private void allocArrays(int r10) {
        if (r10 != 8) goto L18;
        monitor-enter(ArraySet.class);
        Object[] r5 = sTwiceBaseCache;     // Catch: Throwable -> L11
        if (r5 == null) goto L13;
        this.mArray = r5;     // Catch: Throwable -> L11
        sTwiceBaseCache = (Object[]) r5[0];     // Catch: Throwable -> L11
        this.mHashes = (int[]) r5[1];     // Catch: Throwable -> L11
        r5[1] = null;     // Catch: Throwable -> L11
        r5[0] = null;     // Catch: Throwable -> L11
        sTwiceBaseCacheSize--;     // Catch: Throwable -> L11
        monitor-exit(ArraySet.class);     // Catch: Throwable -> L11
        return;
    L13:
        monitor-exit(ArraySet.class);     // Catch: Throwable -> L11
    L32:
        this.mHashes = new int[r10];
        this.mArray = new Object[r10];
        return;
    L11:
        th = move-exception;
        throw th;
    L18:
        if (r10 != 4) goto L32;
        monitor-enter(ArraySet.class);
        Object[] r11 = sBaseCache;     // Catch: Throwable -> L26
        if (r11 == null) goto L28;
        this.mArray = r11;     // Catch: Throwable -> L26
        sBaseCache = (Object[]) r11[0];     // Catch: Throwable -> L26
        this.mHashes = (int[]) r11[1];     // Catch: Throwable -> L26
        r11[1] = null;     // Catch: Throwable -> L26
        r11[0] = null;     // Catch: Throwable -> L26
        sBaseCacheSize--;     // Catch: Throwable -> L26
        monitor-exit(ArraySet.class);     // Catch: Throwable -> L26
        return;
    L28:
        monitor-exit(ArraySet.class);     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;
    }

    private static void freeArrays(int[] r10, Object[] r11, int r12) {
        if (r10.length != 8) goto L19;
        monitor-enter(ArraySet.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sTwiceBaseCacheSize >= 10) goto L14;
        r11[0] = sTwiceBaseCache;     // Catch: Throwable -> L11
        r11[1] = r10;     // Catch: Throwable -> L11
        int r13 = r12 - 1;     // Catch: Throwable -> L11
    L9:
        if (r13 < 2) goto L13;
        r11[r13] = null;     // Catch: Throwable -> L11
        r13 = r13 - 1;     // Catch: Throwable -> L11
        goto L9
    L13:
        sTwiceBaseCache = r11;     // Catch: Throwable -> L11
        sTwiceBaseCacheSize++;     // Catch: Throwable -> L11
    L14:
        monitor-exit(ArraySet.class);     // Catch: Throwable -> L11
        return;
    L19:
        if (r10.length == 4) goto L21;
        return;
    L21:
        monitor-enter(ArraySet.class);
    L27:
        th = move-exception;
        throw th;
    L23:
        if (sBaseCacheSize >= 10) goto L30;
        r11[0] = sBaseCache;     // Catch: Throwable -> L27
        r11[1] = r10;     // Catch: Throwable -> L27
        int r14 = r12 - 1;     // Catch: Throwable -> L27
    L25:
        if (r14 < 2) goto L29;
        r11[r14] = null;     // Catch: Throwable -> L27
        r14 = r14 - 1;     // Catch: Throwable -> L27
        goto L25
    L29:
        sBaseCache = r11;     // Catch: Throwable -> L27
        sBaseCacheSize++;     // Catch: Throwable -> L27
    L30:
        monitor-exit(ArraySet.class);     // Catch: Throwable -> L27
    }

    private MapCollections<E, E> getCollection() {
        if (this.mCollections != null) goto L6;
        this.mCollections = new AnonymousClass1(this);
    L6:
        return this.mCollections;
    }

    private int indexOf(Object r5, int r10) {
        int r11 = this.mSize;
        if (r11 != 0) goto L6;
        return -1;
    L6:
        int r12 = ContainerHelpers.binarySearch(this.mHashes, r11, r10);
        if (r12 >= 0) goto L10;
        return r12;
    L10:
        if (r5.equals(this.mArray[r12]) == false) goto L12;
        return r12;
    L12:
        int r13 = r12 + 1;
    L13:
        if (r13 >= r11) goto L20;
        if (this.mHashes[r13] != r10) goto L20;
        if (r5.equals(this.mArray[r13]) == true) goto L18;
        r13 = r13 + 1;
        goto L13
    L18:
        return r13;
    L20:
        int r14 = r12 - 1;
    L21:
        if (r14 < 0) goto L29;
        if (this.mHashes[r14] != r10) goto L29;
        if (r5.equals(this.mArray[r14]) == true) goto L26;
        r14 = r14 - 1;
        goto L21
    L26:
        return r14;
    L29:
        return ~r13;
    }

    private int indexOfNull() {
        int r5 = this.mSize;
        if (r5 != 0) goto L6;
        return -1;
    L6:
        int r10 = ContainerHelpers.binarySearch(this.mHashes, r5, 0);
        if (r10 >= 0) goto L10;
        return r10;
    L10:
        if (this.mArray[r10] != null) goto L12;
        return r10;
    L12:
        int r11 = r10 + 1;
    L13:
        if (r11 >= r5) goto L20;
        if (this.mHashes[r11] != 0) goto L20;
        if (this.mArray[r11] == null) goto L18;
        r11 = r11 + 1;
        goto L13
    L18:
        return r11;
    L20:
        int r12 = r10 - 1;
    L21:
        if (r12 < 0) goto L29;
        if (this.mHashes[r12] != 0) goto L29;
        if (this.mArray[r12] == null) goto L26;
        r12 = r12 - 1;
        goto L21
    L26:
        return r12;
    L29:
        return ~r11;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(@Nullable E r10) {
        if (r10 != null) goto L5;
        int r5 = indexOfNull();
        int r11 = 0;
    L6:
        if (r5 < 0) goto L8;
        return false;
    L8:
        int r12 = ~r5;
        int r13 = this.mSize;
        int[] r14 = this.mHashes;
        if (r13 < r14.length) goto L21;
        int r15 = 8;
        if (r13 < 8) goto L14;
        r15 = (r13 >> 1) + r13;
    L17:
        Object[] r16 = this.mArray;
        allocArrays(r15);
        int[] r17 = this.mHashes;
        if (r17.length <= 0) goto L20;
        System.arraycopy(r14, 0, r17, 0, r14.length);
        System.arraycopy(r16, 0, this.mArray, 0, r16.length);
    L20:
        freeArrays(r14, r16, this.mSize);
        goto L21
    L14:
        if (r13 >= 4) goto L17;
        r15 = 4;
    L21:
        int r18 = this.mSize;
        if (r12 >= r18) goto L24;
        int[] r19 = this.mHashes;
        int r20 = r12 + 1;
        System.arraycopy(r19, r12, r19, r20, r18 - r12);
        Object[] r21 = this.mArray;
        System.arraycopy(r21, r12, r21, r20, this.mSize - r12);
    L24:
        this.mHashes[r12] = r11;
        this.mArray[r12] = r10;
        this.mSize++;
        return true;
    L5:
        int r22 = r10.hashCode();
        r11 = r22;
        r5 = indexOf(r10, r22);
        goto L6
    }

    public void addAll(@NonNull ArraySet<? extends E> r5) {
        int r10 = r5.mSize;
        ensureCapacity(this.mSize + r10);
        int r11 = 0;
        if (this.mSize != 0) goto L6;
        if (r10 <= 0) goto L8;
        System.arraycopy(r5.mHashes, 0, this.mHashes, 0, r10);
        System.arraycopy(r5.mArray, 0, this.mArray, 0, r10);
        this.mSize = r10;
        return;
    L8:
        return;
    L6:
        if (r11 >= r10) goto L11;
        add(r5.valueAt(r11));
        r11 = r11 + 1;
        goto L6
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        int r5 = this.mSize;
        if (r5 == 0) goto L6;
        freeArrays(this.mHashes, this.mArray, r5);
        this.mHashes = INT;
        this.mArray = OBJECT;
        this.mSize = 0;
        return;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(@Nullable Object r5) {
        if (indexOf(r5) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(@NonNull Collection<?> r5) {
        Iterator<?> r10 = r5.iterator();
    L4:
        if (r10.hasNext() == false) goto L9;
        if (contains(r10.next()) == true) goto L4;
        return false;
    L9:
        return true;
    }

    public void ensureCapacity(int r5) {
        int[] r10 = this.mHashes;
        if (r10.length >= r5) goto L9;
        Object[] r11 = this.mArray;
        allocArrays(r5);
        int r12 = this.mSize;
        if (r12 <= 0) goto L7;
        System.arraycopy(r10, 0, this.mHashes, 0, r12);
        System.arraycopy(r11, 0, this.mArray, 0, this.mSize);
    L7:
        freeArrays(r10, r11, this.mSize);
        return;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof Set) == false) goto L18;
        Set r10 = (Set) r5;
        if (size() == r10.size()) goto L10;
        return false;
    L10:
        int r11 = 0;
    L20:
        if (r11 >= this.mSize) goto L17;
        if (r10.contains(valueAt(r11)) == false) goto L15;
        r11 = r11 + 1;
        goto L20
    L15:
        return false;
    L17:
        return true;
    L18:
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] r5 = this.mHashes;
        int r10 = this.mSize;
        int r11 = 0;
        int r12 = 0;
    L3:
        if (r11 >= r10) goto L5;
        r12 = r12 + r5[r11];
        r11 = r11 + 1;
        goto L3
    L5:
        return r12;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        if (this.mSize > 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return getCollection().getKeySet().iterator();
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(@Nullable Object r5) {
        int r10 = indexOf(r5);
        if (r10 < 0) goto L6;
        removeAt(r10);
        return true;
    L6:
        return false;
    }

    public boolean removeAll(@NonNull ArraySet<? extends E> r10) {
        int r5 = r10.mSize;
        int r11 = this.mSize;
        int r12 = 0;
    L3:
        if (r12 >= r5) goto L6;
        remove(r10.valueAt(r12));
        r12 = r12 + 1;
        goto L3
    L6:
        if (r11 == this.mSize) goto L10;
        return true;
    L10:
        return false;
    }

    public E removeAt(int r10) {
        Object[] r5 = this.mArray;
        E r11 = (E) r5[r10];
        int r12 = this.mSize;
        if (r12 > 1) goto L5;
        freeArrays(this.mHashes, r5, r12);
        this.mHashes = INT;
        this.mArray = OBJECT;
        this.mSize = 0;
    L21:
        return r11;
    L5:
        int[] r13 = this.mHashes;
        int r14 = 8;
        if (r13.length > 8) goto L8;
    L17:
        int r15 = r12 - 1;
        this.mSize = r15;
        if (r10 >= r15) goto L20;
        int r16 = r10 + 1;
        System.arraycopy(r13, r16, r13, r10, r15 - r10);
        Object[] r17 = this.mArray;
        System.arraycopy(r17, r16, r17, r10, this.mSize - r10);
    L20:
        this.mArray[this.mSize] = null;
        goto L21
    L8:
        if (r12 >= (r13.length / 3)) goto L17;
        if (r12 <= 8) goto L11;
        r14 = r12 + (r12 >> 1);
    L11:
        allocArrays(r14);
        this.mSize--;
        if (r10 <= 0) goto L14;
        System.arraycopy(r13, 0, this.mHashes, 0, r10);
        System.arraycopy(r5, 0, this.mArray, 0, r10);
    L14:
        int r18 = this.mSize;
        if (r10 >= r18) goto L21;
        int r19 = r10 + 1;
        System.arraycopy(r13, r19, this.mHashes, r10, r18 - r10);
        System.arraycopy(r5, r19, this.mArray, r10, this.mSize - r10);
        goto L21
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(@NonNull Collection<?> r5) {
        int r10 = this.mSize - 1;
        boolean r11 = false;
    L3:
        if (r10 < 0) goto L8;
        if (r5.contains(this.mArray[r10]) == true) goto L7;
        removeAt(r10);
        r11 = true;
    L7:
        r10 = r10 - 1;
        goto L3
    L8:
        return r11;
    }

    @Override // java.util.Collection, java.util.Set
    public int size() {
        return this.mSize;
    }

    @Override // java.util.Collection, java.util.Set
    @NonNull
    public Object[] toArray() {
        int r5 = this.mSize;
        Object[] r10 = new Object[r5];
        System.arraycopy(this.mArray, 0, r10, 0, r5);
        return r10;
    }

    public String toString() {
        if (isEmpty() == false) goto L6;
        return "{}";
    L6:
        StringBuilder r5 = new StringBuilder(this.mSize * 14);
        r5.append('{');
        int r10 = 0;
    L8:
        if (r10 >= this.mSize) goto L16;
        if (r10 <= 0) goto L11;
        r5.append(", ");
    L11:
        E r11 = valueAt(r10);
        if (r11 == this) goto L14;
        r5.append(r11);
    L15:
        r10 = r10 + 1;
        goto L8
    L14:
        r5.append("(this Set)");
        goto L15
    L16:
        r5.append('}');
        return r5.toString();
    }

    @Nullable
    public E valueAt(int r5) {
        return (E) this.mArray[r5];
    }

    public ArraySet(int r5) {
        if (r5 != 0) goto L5;
        this.mHashes = INT;
        this.mArray = OBJECT;
    L6:
        this.mSize = 0;
        return;
    L5:
        allocArrays(r5);
        goto L6
    }

    @Override // java.util.Collection, java.util.Set
    @NonNull
    public <T> T[] toArray(@NonNull T[] r5) {
        if (r5.length >= this.mSize) goto L5;
        r5 = (T[]) ((Object[]) Array.newInstance(r5.getClass().getComponentType(), this.mSize));
    L5:
        T[] r10 = r5;
        System.arraycopy(this.mArray, 0, r10, 0, this.mSize);
        int r11 = r5.length;
        int r12 = this.mSize;
        if (r11 <= r12) goto L8;
        r5[r12] = null;
    L8:
        return r5;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(@NonNull Collection<?> r5) {
        Iterator<?> r10 = r5.iterator();
        boolean r11 = false;
    L4:
        if (r10.hasNext() == false) goto L6;
        r11 = r11 | remove(r10.next());
        goto L4
    L6:
        return r11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ArraySet(@Nullable ArraySet<E> r5) {
        this();
        if (r5 == 0) goto L6;
        addAll(r5);
        return;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(@NonNull Collection<? extends E> r5) {
        int r10 = this.mSize;
        ensureCapacity(r5.size() + r10);
        Iterator<? extends E> r11 = r5.iterator();
        boolean r12 = false;
    L4:
        if (r11.hasNext() == false) goto L6;
        r12 = r12 | add(r11.next());
        goto L4
    L6:
        return r12;
    }

    public int indexOf(@Nullable Object r5) {
        if (r5 != null) goto L5;
        return indexOfNull();
    L5:
        return indexOf(r5, r5.hashCode());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ArraySet(@Nullable Collection<E> r5) {
        this();
        if (r5 == 0) goto L6;
        addAll(r5);
        return;
    }
}
