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

    public ArraySet(int r10) {
        if (r10 != 0) goto L5;
        this.mHashes = INT;
        this.mArray = OBJECT;
    L6:
        this.mSize = 0;
        return;
    L5:
        allocArrays(r10);
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ArraySet(@Nullable ArraySet<E> r10) {
        this();
        if (r10 == 0) goto L6;
        addAll(r10);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ArraySet(@Nullable Collection<E> r10) {
        this();
        if (r10 == 0) goto L6;
        addAll(r10);
        return;
    }

    private void allocArrays(int r10) {
        if (r10 != 8) goto L17;
        monitor-enter(ArraySet.class);
        Object[] r11 = sTwiceBaseCache;     // Catch: Throwable -> L13
        if (r11 == null) goto L11;
        this.mArray = r11;     // Catch: Throwable -> L13
        sTwiceBaseCache = (Object[]) r11[0];     // Catch: Throwable -> L13
        this.mHashes = (int[]) r11[1];     // Catch: Throwable -> L13
        r11[1] = null;     // Catch: Throwable -> L13
        r11[0] = null;     // Catch: Throwable -> L13
        sTwiceBaseCacheSize--;     // Catch: Throwable -> L13
        monitor-exit(ArraySet.class);     // Catch: Throwable -> L13
        return;
    L11:
        monitor-exit(ArraySet.class);     // Catch: Throwable -> L13
    L30:
        this.mHashes = new int[r10];
        this.mArray = new Object[r10];
        return;
    L13:
        th = move-exception;
        throw th;
    L17:
        if (r10 != 4) goto L30;
        monitor-enter(ArraySet.class);
        Object[] r12 = sBaseCache;     // Catch: Throwable -> L27
        if (r12 == null) goto L25;
        this.mArray = r12;     // Catch: Throwable -> L27
        sBaseCache = (Object[]) r12[0];     // Catch: Throwable -> L27
        this.mHashes = (int[]) r12[1];     // Catch: Throwable -> L27
        r12[1] = null;     // Catch: Throwable -> L27
        r12[0] = null;     // Catch: Throwable -> L27
        sBaseCacheSize--;     // Catch: Throwable -> L27
        monitor-exit(ArraySet.class);     // Catch: Throwable -> L27
        return;
    L25:
        monitor-exit(ArraySet.class);     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        throw th;
    }

    private static void freeArrays(int[] r10, Object[] r11, int r12) {
        if (r10.length != 8) goto L18;
        monitor-enter(ArraySet.class);
    L14:
        th = move-exception;
        throw th;
    L7:
        if (sTwiceBaseCacheSize >= 10) goto L12;
        r11[0] = sTwiceBaseCache;     // Catch: Throwable -> L14
        r11[1] = r10;     // Catch: Throwable -> L14
        int r13 = r12 - 1;     // Catch: Throwable -> L14
    L9:
        if (r13 < 2) goto L11;
        r11[r13] = null;     // Catch: Throwable -> L14
        r13 = r13 - 1;     // Catch: Throwable -> L14
        goto L9
    L11:
        sTwiceBaseCache = r11;     // Catch: Throwable -> L14
        sTwiceBaseCacheSize++;     // Catch: Throwable -> L14
    L12:
        monitor-exit(ArraySet.class);     // Catch: Throwable -> L14
        return;
    L18:
        if (r10.length == 4) goto L20;
        return;
    L20:
        monitor-enter(ArraySet.class);
    L29:
        th = move-exception;
        throw th;
    L22:
        if (sBaseCacheSize >= 10) goto L27;
        r11[0] = sBaseCache;     // Catch: Throwable -> L29
        r11[1] = r10;     // Catch: Throwable -> L29
        int r14 = r12 - 1;     // Catch: Throwable -> L29
    L24:
        if (r14 < 2) goto L26;
        r11[r14] = null;     // Catch: Throwable -> L29
        r14 = r14 - 1;     // Catch: Throwable -> L29
        goto L24
    L26:
        sBaseCache = r11;     // Catch: Throwable -> L29
        sBaseCacheSize++;     // Catch: Throwable -> L29
    L27:
        monitor-exit(ArraySet.class);     // Catch: Throwable -> L29
    }

    private MapCollections<E, E> getCollection() {
        if (this.mCollections != null) goto L6;
        this.mCollections = new AnonymousClass1(this);
    L6:
        return this.mCollections;
    }

    private int indexOf(Object r10, int r11) {
        int r12 = this.mSize;
        if (r12 != 0) goto L6;
        return -1;
    L6:
        int r13 = ContainerHelpers.binarySearch(this.mHashes, r12, r11);
        if (r13 >= 0) goto L10;
        return r13;
    L10:
        if (r10.equals(this.mArray[r13]) == false) goto L12;
        return r13;
    L12:
        int r14 = r13 + 1;
    L13:
        if (r14 >= r12) goto L20;
        if (this.mHashes[r14] != r11) goto L20;
        if (r10.equals(this.mArray[r14]) == true) goto L18;
        r14 = r14 + 1;
        goto L13
    L18:
        return r14;
    L20:
        int r15 = r13 - 1;
    L21:
        if (r15 < 0) goto L29;
        if (this.mHashes[r15] != r11) goto L29;
        if (r10.equals(this.mArray[r15]) == true) goto L26;
        r15 = r15 - 1;
        goto L21
    L26:
        return r15;
    L29:
        return ~r14;
    }

    private int indexOfNull() {
        int r10 = this.mSize;
        if (r10 != 0) goto L6;
        return -1;
    L6:
        int r11 = ContainerHelpers.binarySearch(this.mHashes, r10, 0);
        if (r11 >= 0) goto L10;
        return r11;
    L10:
        if (this.mArray[r11] != null) goto L12;
        return r11;
    L12:
        int r12 = r11 + 1;
    L13:
        if (r12 >= r10) goto L20;
        if (this.mHashes[r12] != 0) goto L20;
        if (this.mArray[r12] == null) goto L18;
        r12 = r12 + 1;
        goto L13
    L18:
        return r12;
    L20:
        int r13 = r11 - 1;
    L21:
        if (r13 < 0) goto L29;
        if (this.mHashes[r13] != 0) goto L29;
        if (this.mArray[r13] == null) goto L26;
        r13 = r13 - 1;
        goto L21
    L26:
        return r13;
    L29:
        return ~r12;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(@Nullable E r10) {
        if (r10 != null) goto L5;
        int r11 = indexOfNull();
        int r12 = 0;
    L6:
        if (r11 < 0) goto L8;
        return false;
    L8:
        int r13 = ~r11;
        int r14 = this.mSize;
        int[] r15 = this.mHashes;
        if (r14 < r15.length) goto L19;
        int r16 = 4;
        if (r14 < 8) goto L13;
        r16 = (r14 >> 1) + r14;
    L15:
        Object[] r17 = this.mArray;
        allocArrays(r16);
        int[] r18 = this.mHashes;
        if (r18.length <= 0) goto L18;
        System.arraycopy(r15, 0, r18, 0, r15.length);
        System.arraycopy(r17, 0, this.mArray, 0, r17.length);
    L18:
        freeArrays(r15, r17, this.mSize);
        goto L19
    L13:
        if (r14 < 4) goto L15;
        r16 = 8;
    L19:
        int r19 = this.mSize;
        if (r13 >= r19) goto L22;
        int[] r20 = this.mHashes;
        int r21 = r13 + 1;
        System.arraycopy(r20, r13, r20, r21, r19 - r13);
        Object[] r22 = this.mArray;
        System.arraycopy(r22, r13, r22, r21, this.mSize - r13);
    L22:
        this.mHashes[r13] = r12;
        this.mArray[r13] = r10;
        this.mSize++;
        return true;
    L5:
        int r23 = r10.hashCode();
        r12 = r23;
        r11 = indexOf(r10, r23);
        goto L6
    }

    public void addAll(@NonNull ArraySet<? extends E> r10) {
        int r11 = r10.mSize;
        ensureCapacity(this.mSize + r11);
        int r12 = 0;
        if (this.mSize != 0) goto L6;
        if (r11 <= 0) goto L8;
        System.arraycopy(r10.mHashes, 0, this.mHashes, 0, r11);
        System.arraycopy(r10.mArray, 0, this.mArray, 0, r11);
        this.mSize = r11;
        return;
    L8:
        return;
    L6:
        if (r12 >= r11) goto L11;
        add(r10.valueAt(r12));
        r12 = r12 + 1;
        goto L6
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(@NonNull Collection<? extends E> r10) {
        ensureCapacity(this.mSize + r10.size());
        Iterator<? extends E> r11 = r10.iterator();
        boolean r12 = false;
    L4:
        if (r11.hasNext() == false) goto L6;
        r12 = r12 | add(r11.next());
        goto L4
    L6:
        return r12;
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        int r10 = this.mSize;
        if (r10 == 0) goto L6;
        freeArrays(this.mHashes, this.mArray, r10);
        this.mHashes = INT;
        this.mArray = OBJECT;
        this.mSize = 0;
        return;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(@Nullable Object r10) {
        if (indexOf(r10) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(@NonNull Collection<?> r10) {
        Iterator<?> r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L9;
        if (contains(r11.next()) == true) goto L4;
        return false;
    L9:
        return true;
    }

    public void ensureCapacity(int r10) {
        int[] r11 = this.mHashes;
        if (r11.length >= r10) goto L9;
        Object[] r12 = this.mArray;
        allocArrays(r10);
        int r13 = this.mSize;
        if (r13 <= 0) goto L7;
        System.arraycopy(r11, 0, this.mHashes, 0, r13);
        System.arraycopy(r12, 0, this.mArray, 0, this.mSize);
    L7:
        freeArrays(r11, r12, this.mSize);
        return;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof Set) == false) goto L18;
        Set r11 = (Set) r10;
        if (size() == r11.size()) goto L10;
        return false;
    L10:
        int r12 = 0;
    L20:
        if (r12 >= this.mSize) goto L17;
        if (r11.contains(valueAt(r12)) == false) goto L15;
        r12 = r12 + 1;
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
        int[] r10 = this.mHashes;
        int r11 = this.mSize;
        int r12 = 0;
        int r13 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r13 = r13 + r10[r12];
        r12 = r12 + 1;
        goto L3
    L5:
        return r13;
    }

    public int indexOf(@Nullable Object r10) {
        if (r10 != null) goto L5;
        return indexOfNull();
    L5:
        return indexOf(r10, r10.hashCode());
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
    public boolean remove(@Nullable Object r10) {
        int r11 = indexOf(r10);
        if (r11 < 0) goto L6;
        removeAt(r11);
        return true;
    L6:
        return false;
    }

    public boolean removeAll(@NonNull ArraySet<? extends E> r10) {
        int r11 = r10.mSize;
        int r12 = this.mSize;
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L6;
        remove(r10.valueAt(r13));
        r13 = r13 + 1;
        goto L3
    L6:
        if (r12 == this.mSize) goto L10;
        return true;
    L10:
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(@NonNull Collection<?> r10) {
        Iterator<?> r11 = r10.iterator();
        boolean r12 = false;
    L4:
        if (r11.hasNext() == false) goto L6;
        r12 = r12 | remove(r11.next());
        goto L4
    L6:
        return r12;
    }

    public E removeAt(int r10) {
        Object[] r11 = this.mArray;
        E r12 = (E) r11[r10];
        int r13 = this.mSize;
        if (r13 > 1) goto L5;
        freeArrays(this.mHashes, r11, r13);
        this.mHashes = INT;
        this.mArray = OBJECT;
        this.mSize = 0;
    L21:
        return r12;
    L5:
        int[] r14 = this.mHashes;
        int r15 = 8;
        if (r14.length > 8) goto L8;
    L17:
        int r16 = r13 - 1;
        this.mSize = r16;
        if (r10 >= r16) goto L20;
        int r17 = r10 + 1;
        System.arraycopy(r14, r17, r14, r10, r16 - r10);
        Object[] r18 = this.mArray;
        System.arraycopy(r18, r17, r18, r10, this.mSize - r10);
    L20:
        this.mArray[this.mSize] = null;
        goto L21
    L8:
        if (r13 >= (r14.length / 3)) goto L17;
        if (r13 <= 8) goto L11;
        r15 = r13 + (r13 >> 1);
    L11:
        allocArrays(r15);
        this.mSize--;
        if (r10 <= 0) goto L14;
        System.arraycopy(r14, 0, this.mHashes, 0, r10);
        System.arraycopy(r11, 0, this.mArray, 0, r10);
    L14:
        int r19 = this.mSize;
        if (r10 >= r19) goto L21;
        int r20 = r10 + 1;
        System.arraycopy(r14, r20, this.mHashes, r10, r19 - r10);
        System.arraycopy(r11, r20, this.mArray, r10, this.mSize - r10);
        goto L21
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(@NonNull Collection<?> r10) {
        int r11 = this.mSize - 1;
        boolean r12 = false;
    L3:
        if (r11 < 0) goto L8;
        if (r10.contains(this.mArray[r11]) == true) goto L7;
        removeAt(r11);
        r12 = true;
    L7:
        r11 = r11 - 1;
        goto L3
    L8:
        return r12;
    }

    @Override // java.util.Collection, java.util.Set
    public int size() {
        return this.mSize;
    }

    @Override // java.util.Collection, java.util.Set
    @NonNull
    public Object[] toArray() {
        int r10 = this.mSize;
        Object[] r11 = new Object[r10];
        System.arraycopy(this.mArray, 0, r11, 0, r10);
        return r11;
    }

    @Override // java.util.Collection, java.util.Set
    @NonNull
    public <T> T[] toArray(@NonNull T[] r10) {
        if (r10.length >= this.mSize) goto L5;
        r10 = (T[]) ((Object[]) Array.newInstance(r10.getClass().getComponentType(), this.mSize));
    L5:
        T[] r11 = r10;
        System.arraycopy(this.mArray, 0, r11, 0, this.mSize);
        int r12 = r10.length;
        int r13 = this.mSize;
        if (r12 <= r13) goto L8;
        r10[r13] = null;
    L8:
        return r10;
    }

    public String toString() {
        if (isEmpty() == false) goto L6;
        return "{}";
    L6:
        StringBuilder r10 = new StringBuilder(this.mSize * 14);
        r10.append('{');
        int r11 = 0;
    L8:
        if (r11 >= this.mSize) goto L16;
        if (r11 <= 0) goto L11;
        r10.append(", ");
    L11:
        E r12 = valueAt(r11);
        if (r12 == this) goto L14;
        r10.append(r12);
    L15:
        r11 = r11 + 1;
        goto L8
    L14:
        r10.append("(this Set)");
        goto L15
    L16:
        r10.append('}');
        return r10.toString();
    }

    @Nullable
    public E valueAt(int r10) {
        return (E) this.mArray[r10];
    }
}
