package androidx.room.jarjarred.org.antlr.v4.runtime.misc;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class Array2DHashSet<T> implements Set<T> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int INITAL_BUCKET_CAPACITY = 8;
    public static final int INITAL_CAPACITY = 16;
    public static final double LOAD_FACTOR = 0.75d;
    protected T[][] buckets;
    protected final AbstractEqualityComparator<? super T> comparator;
    protected int currentPrime;
    protected int initialBucketCapacity;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    protected int f663n;
    protected int threshold;

    public class SetIterator implements Iterator<T> {
        final T[] data;
        int nextIndex;
        boolean removed;
        final /* synthetic */ Array2DHashSet this$0;

        public SetIterator(Array2DHashSet r5, T[] r10) {
            this.this$0 = r5;
            this.nextIndex = 0;
            this.removed = true;
            this.data = r10;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.nextIndex >= this.data.length) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext() == false) goto L7;
            this.removed = false;
            T[] r5 = this.data;
            int r10 = this.nextIndex;
            this.nextIndex = r10 + 1;
            return r5[r10];
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.removed == true) goto L7;
            this.this$0.remove(this.data[this.nextIndex - 1]);
            this.removed = true;
            return;
        L7:
            throw new IllegalStateException();
        }
    }

    public Array2DHashSet() {
        this(null, 16, 8);
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean add(T r5) {
        if (getOrAdd(r5) != r5) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean addAll(Collection<? extends T> r5) {
        Iterator<? extends T> r10 = r5.iterator();
        boolean r11 = false;
    L4:
        if (r10.hasNext() == false) goto L8;
        T r12 = r10.next();
        if (getOrAdd(r12) == r12) goto L4;
        r11 = true;
        goto L4
    L8:
        return r11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T asElementType(Object r5) {
        return r5;
    }

    @Override // java.util.Set, java.util.Collection
    public void clear() {
        this.buckets = createBuckets(16);
        this.f663n = 0;
        this.threshold = (int) Math.floor(12.0d);
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean contains(Object r5) {
        return containsFast(asElementType(r5));
    }

    @Override // java.util.Set, java.util.Collection
    public boolean containsAll(Collection<?> r10) {
        if ((r10 instanceof Array2DHashSet) == false) goto L19;
        T[][] r11 = ((Array2DHashSet) r10).buckets;
        int r5 = r11.length;
        int r12 = 0;
    L5:
        if (r12 >= r5) goto L25;
        T[] r13 = r11[r12];
        if (r13 == null) goto L18;
        int r14 = r13.length;
        int r15 = 0;
    L10:
        if (r15 >= r14) goto L18;
        T r16 = r13[r15];
        if (r16 == null) goto L18;
        if (containsFast(asElementType(r16)) == false) goto L16;
        r15 = r15 + 1;
        goto L10
    L16:
        return false;
    L18:
        r12 = r12 + 1;
        goto L5
    L25:
        return true;
    L19:
        Iterator<?> r17 = r10.iterator();
    L21:
        if (r17.hasNext() == false) goto L35;
        if (containsFast(asElementType(r17.next())) == true) goto L21;
        return false;
    L35:
        return true;
    }

    public boolean containsFast(T r5) {
        if (r5 != null) goto L6;
        return false;
    L6:
        if (get(r5) == null) goto L9;
        return true;
    L9:
        return false;
    }

    public T[] createBucket(int r5) {
        return (T[]) new Object[r5];
    }

    public T[][] createBuckets(int r5) {
        return (T[][]) new Object[r5][];
    }

    @Override // java.util.Set, java.util.Collection
    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof Array2DHashSet) == true) goto L8;
        return false;
    L8:
        Array2DHashSet r10 = (Array2DHashSet) r5;
        if (r10.size() == size()) goto L12;
        return false;
    L12:
        return containsAll(r10);
    }

    public void expand() {
        T[][] r5 = this.buckets;
        this.currentPrime += 4;
        int r10 = r5.length * 2;
        T[][] r11 = createBuckets(r10);
        int[] r12 = new int[r11.length];
        this.buckets = r11;
        this.threshold = (int) (((double) r10) * 0.75d);
        size();
        int r13 = r5.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L20;
        T[] r15 = r5[r14];
        if (r15 == null) goto L19;
        int r16 = r15.length;
        int r17 = 0;
    L8:
        if (r17 >= r16) goto L19;
        T r18 = r15[r17];
        if (r18 == null) goto L19;
        int r19 = getBucket(r18);
        int r110 = r12[r19];
        if (r110 != 0) goto L15;
        T[] r111 = createBucket(this.initialBucketCapacity);
        r11[r19] = r111;
    L18:
        r111[r110] = r18;
        r12[r19] = r12[r19] + 1;
        r17 = r17 + 1;
        goto L8
    L15:
        r111 = r11[r19];
        if (r110 != r111.length) goto L18;
        r111 = (T[]) Arrays.copyOf(r111, r111.length * 2);
        r11[r19] = r111;
    L19:
        r14 = r14 + 1;
        goto L3
    }

    public T get(T r10) {
        if (r10 != null) goto L4;
        return r10;
    L4:
        int r5 = getBucket(r10);
        T[] r11 = this.buckets[r5];
        if (r11 != null) goto L7;
        return null;
    L7:
        int r12 = r11.length;
        int r13 = 0;
    L8:
        if (r13 >= r12) goto L16;
        T r14 = r11[r13];
        if (r14 == null) goto L11;
        if (this.comparator.equals(r14, r10) == true) goto L14;
        r13 = r13 + 1;
        goto L8
    L14:
        return r14;
    L11:
        return null;
    L16:
        return null;
    }

    public final int getBucket(T r5) {
        return (this.buckets.length - 1) & this.comparator.hashCode(r5);
    }

    public final T getOrAdd(T r5) {
        if (this.f663n <= this.threshold) goto L6;
        expand();
    L6:
        return getOrAddImpl(r5);
    }

    public T getOrAddImpl(T r10) {
        int r5 = getBucket(r10);
        T[] r11 = this.buckets[r5];
        int r12 = 0;
        if (r11 != null) goto L7;
        T[] r13 = createBucket(this.initialBucketCapacity);
        r13[0] = r10;
        this.buckets[r5] = r13;
        this.f663n++;
        return r10;
    L7:
        if (r12 >= r11.length) goto L16;
        T r14 = r11[r12];
        if (r14 == null) goto L10;
        if (this.comparator.equals(r14, r10) == true) goto L14;
        r12 = r12 + 1;
        goto L7
    L14:
        return r14;
    L10:
        r11[r12] = r10;
        this.f663n++;
        return r10;
    L16:
        int r15 = r11.length;
        Object[] r16 = Arrays.copyOf(r11, r11.length * 2);
        ((T[][]) this.buckets)[r5] = r16;
        r16[r15] = r10;
        this.f663n++;
        return r10;
    }

    @Override // java.util.Set, java.util.Collection
    public int hashCode() {
        int r5 = MurmurHash.initialize();
        T[][] r10 = this.buckets;
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L15;
        T[] r13 = r10[r12];
        if (r13 == null) goto L13;
        int r14 = r13.length;
        int r15 = 0;
    L8:
        if (r15 >= r14) goto L13;
        T r16 = r13[r15];
        if (r16 == null) goto L13;
        r5 = MurmurHash.update(r5, this.comparator.hashCode(r16));
        r15 = r15 + 1;
    L13:
        r12 = r12 + 1;
        goto L3
    L15:
        return MurmurHash.finish(r5, size());
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean isEmpty() {
        if (this.f663n != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        return new SetIterator(this, toArray());
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean remove(Object r5) {
        return removeFast(asElementType(r5));
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(Collection<?> r5) {
        Iterator<?> r10 = r5.iterator();
        boolean r11 = false;
    L4:
        if (r10.hasNext() == false) goto L6;
        r11 = r11 | removeFast(asElementType(r10.next()));
        goto L4
    L6:
        return r11;
    }

    public boolean removeFast(T r10) {
        if (r10 != null) goto L5;
        return false;
    L5:
        T[] r5 = this.buckets[getBucket(r10)];
        if (r5 != null) goto L8;
        return false;
    L8:
        int r11 = 0;
    L10:
        if (r11 >= r5.length) goto L19;
        T r12 = r5[r11];
        if (r12 == null) goto L13;
        if (this.comparator.equals(r12, r10) == true) goto L16;
        r11 = r11 + 1;
        goto L10
    L16:
        System.arraycopy(r5, r11 + 1, r5, r11, (r5.length - r11) - 1);
        r5[r5.length - 1] = null;
        this.f663n--;
        return true;
    L13:
        return false;
    L19:
        return false;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(Collection<?> r10) {
        T[][] r5 = this.buckets;
        int r11 = r5.length;
        boolean r12 = false;
        int r13 = 0;
        int r14 = 0;
    L3:
        if (r13 >= r11) goto L25;
        T[] r15 = r5[r13];
        if (r15 == null) goto L23;
        int r16 = 0;
        int r17 = 0;
    L9:
        if (r16 >= r15.length) goto L20;
        T r18 = r15[r16];
        if (r18 == null) goto L20;
        if (r10.contains(r18) == false) goto L19;
        if (r16 == r17) goto L18;
        r15[r17] = r15[r16];
    L18:
        r17 = r17 + 1;
        r14 = r14 + 1;
    L19:
        r16 = r16 + 1;
    L20:
        r14 = r14 + r17;
    L21:
        if (r17 >= r16) goto L23;
        r15[r17] = null;
        r17 = r17 + 1;
    L23:
        r13 = r13 + 1;
        goto L3
    L25:
        if (r14 == this.f663n) goto L27;
        r12 = true;
    L27:
        this.f663n = r14;
        return r12;
    }

    @Override // java.util.Set, java.util.Collection
    public final int size() {
        return this.f663n;
    }

    @Override // java.util.Set, java.util.Collection
    public T[] toArray() {
        T[] r5 = createBucket(size());
        T[][] r10 = this.buckets;
        int r11 = r10.length;
        int r12 = 0;
        int r13 = 0;
    L3:
        if (r12 >= r11) goto L14;
        T[] r14 = r10[r12];
        if (r14 == null) goto L13;
        int r15 = r14.length;
        int r16 = 0;
    L8:
        if (r16 >= r15) goto L13;
        T r17 = r14[r16];
        if (r17 == null) goto L13;
        r5[r13] = r17;
        r16 = r16 + 1;
        r13 = r13 + 1;
    L13:
        r12 = r12 + 1;
        goto L3
    L14:
        return r5;
    }

    public String toString() {
        if (size() != 0) goto L6;
        return "{}";
    L6:
        StringBuilder r5 = new StringBuilder("{");
        T[][] r10 = this.buckets;
        int r11 = r10.length;
        boolean r12 = true;
        int r13 = 0;
    L7:
        if (r13 >= r11) goto L21;
        T[] r14 = r10[r13];
        if (r14 == null) goto L20;
        int r15 = r14.length;
        int r16 = 0;
    L12:
        if (r16 >= r15) goto L20;
        T r17 = r14[r16];
        if (r17 == null) goto L20;
        if (r12 == false) goto L18;
        r12 = false;
    L19:
        r5.append(r17.toString());
        r16 = r16 + 1;
        goto L12
    L18:
        r5.append(", ");
    L20:
        r13 = r13 + 1;
        goto L7
    L21:
        r5.append('}');
        return r5.toString();
    }

    public String toTableString() {
        StringBuilder r5 = new StringBuilder();
        T[][] r10 = this.buckets;
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L20;
        T[] r13 = r10[r12];
        if (r13 != null) goto L7;
        r5.append("null\n");
    L18:
        r12 = r12 + 1;
        goto L3
    L7:
        r5.append('[');
        int r14 = r13.length;
        boolean r15 = true;
        int r16 = 0;
    L8:
        if (r16 >= r14) goto L17;
        T r17 = r13[r16];
        if (r15 == false) goto L12;
        r15 = false;
    L13:
        if (r17 != null) goto L15;
        r5.append("_");
    L16:
        r16 = r16 + 1;
        goto L8
    L15:
        r5.append(r17.toString());
        goto L16
    L12:
        r5.append(" ");
        goto L13
    L17:
        r5.append("]\n");
        goto L18
    L20:
        return r5.toString();
    }

    public Array2DHashSet(AbstractEqualityComparator<? super T> r5) {
        this(r5, 16, 8);
    }

    public Array2DHashSet(AbstractEqualityComparator<? super T> r5, int r10, int r11) {
        this.f663n = 0;
        this.threshold = (int) Math.floor(12.0d);
        this.currentPrime = 1;
        this.initialBucketCapacity = 8;
        if (r5 != null) goto L5;
        r5 = ObjectEqualityComparator.INSTANCE;
    L5:
        this.comparator = r5;
        this.buckets = createBuckets(r10);
        this.initialBucketCapacity = r11;
    }

    @Override // java.util.Set, java.util.Collection
    public <U> U[] toArray(U[] r10) {
        if (r10.length >= size()) goto L5;
        r10 = (U[]) Arrays.copyOf(r10, size());
    L5:
        T[][] r11 = this.buckets;
        int r5 = r11.length;
        int r12 = 0;
        int r13 = 0;
    L6:
        if (r12 >= r5) goto L17;
        T[] r14 = r11[r12];
        if (r14 == null) goto L16;
        int r15 = r14.length;
        int r16 = 0;
    L11:
        if (r16 >= r15) goto L16;
        T r17 = r14[r16];
        if (r17 == null) goto L16;
        r10[r13] = r17;
        r16 = r16 + 1;
        r13 = r13 + 1;
    L16:
        r12 = r12 + 1;
        goto L6
    L17:
        return r10;
    }
}
