package androidx.room.jarjarred.org.antlr.v4.runtime.misc;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class FlexibleHashMap<K, V> implements Map<K, V> {
    public static final int INITAL_BUCKET_CAPACITY = 8;
    public static final int INITAL_CAPACITY = 16;
    public static final double LOAD_FACTOR = 0.75d;
    protected LinkedList<Entry<K, V>>[] buckets;
    protected final AbstractEqualityComparator<? super K> comparator;
    protected int currentPrime;
    protected int initialBucketCapacity;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    protected int f664n;
    protected int threshold;

    public static class Entry<K, V> {
        public final K key;
        public V value;

        public Entry(K r5, V r10) {
            this.key = r5;
            this.value = r10;
        }

        public String toString() {
            return this.key.toString() + ":" + this.value.toString();
        }
    }

    public FlexibleHashMap() {
        this(null, 16, 8);
    }

    private static <K, V> LinkedList<Entry<K, V>>[] createEntryListArray(int r5) {
        return new LinkedList[r5];
    }

    public static void main(String[] r5) {
        FlexibleHashMap r10 = new FlexibleHashMap();
        r10.put("hi", 1);
        r10.put("mom", 2);
        r10.put("foo", 3);
        r10.put("ach", 4);
        r10.put("cbba", 5);
        r10.put("d", 6);
        r10.put("edf", 7);
        r10.put("mom", 8);
        r10.put("hi", 9);
        PrintStream r11 = System.out;
        r11.println(r10);
        r11.println(r10.toTableString());
    }

    @Override // java.util.Map
    public void clear() {
        this.buckets = createEntryListArray(16);
        this.f664n = 0;
    }

    @Override // java.util.Map
    public boolean containsKey(Object r5) {
        if (get(r5) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Map
    public boolean containsValue(Object r5) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public boolean equals(Object r5) {
        throw new UnsupportedOperationException();
    }

    public void expand() {
        LinkedList<Entry<K, V>>[] r5 = this.buckets;
        this.currentPrime += 4;
        int r10 = r5.length * 2;
        this.buckets = createEntryListArray(r10);
        this.threshold = (int) (((double) r10) * 0.75d);
        int r11 = size();
        int r12 = r5.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L15;
        LinkedList<Entry<K, V>> r14 = r5[r13];
        if (r14 == null) goto L14;
        Iterator<Entry<K, V>> r15 = r14.iterator();
    L9:
        if (r15.hasNext() == false) goto L14;
        Entry<K, V> r16 = r15.next();
        if (r16 == null) goto L14;
        put(r16.key, r16.value);
    L14:
        r13 = r13 + 1;
        goto L3
    L15:
        this.f664n = r11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public V get(Object r10) {
        if (r10 != 0) goto L5;
        return null;
    L5:
        int r5 = getBucket(r10);
        LinkedList<Entry<K, V>> r11 = this.buckets[r5];
        if (r11 != null) goto L8;
        return null;
    L8:
        Iterator<Entry<K, V>> r12 = r11.iterator();
    L10:
        if (r12.hasNext() == false) goto L15;
        Entry<K, V> r13 = r12.next();
        if (this.comparator.equals(r13.key, r10) == false) goto L10;
        return r13.value;
    L15:
        return null;
    }

    public int getBucket(K r5) {
        return (this.buckets.length - 1) & this.comparator.hashCode(r5);
    }

    @Override // java.util.Map
    public int hashCode() {
        int r5 = MurmurHash.initialize();
        LinkedList<Entry<K, V>>[] r10 = this.buckets;
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L16;
        LinkedList<Entry<K, V>> r13 = r10[r12];
        if (r13 == null) goto L14;
        Iterator<Entry<K, V>> r14 = r13.iterator();
    L9:
        if (r14.hasNext() == false) goto L14;
        Entry<K, V> r15 = r14.next();
        if (r15 == null) goto L14;
        r5 = MurmurHash.update(r5, this.comparator.hashCode(r15.key));
    L14:
        r12 = r12 + 1;
        goto L3
    L16:
        return MurmurHash.finish(r5, size());
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        if (this.f664n != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public V put(K r10, V r11) {
        if (r10 != null) goto L6;
        return null;
    L6:
        if (this.f664n <= this.threshold) goto L8;
        expand();
    L8:
        int r5 = getBucket(r10);
        LinkedList<Entry<K, V>>[] r12 = this.buckets;
        LinkedList<Entry<K, V>> r13 = r12[r5];
        if (r13 != null) goto L11;
        r13 = new LinkedList();
        r12[r5] = r13;
    L11:
        Iterator<Entry<K, V>> r14 = r13.iterator();
    L13:
        if (r14.hasNext() == false) goto L18;
        Entry<K, V> r15 = r14.next();
        if (this.comparator.equals(r15.key, r10) == false) goto L13;
        V r16 = r15.value;
        r15.value = r11;
        this.f664n++;
        return r16;
    L18:
        r13.add(new Entry(r10, r11));
        this.f664n++;
        return null;
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> r5) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public V remove(Object r5) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public int size() {
        return this.f664n;
    }

    public String toString() {
        if (size() != 0) goto L6;
        return "{}";
    L6:
        StringBuilder r5 = new StringBuilder("{");
        LinkedList<Entry<K, V>>[] r10 = this.buckets;
        int r11 = r10.length;
        boolean r12 = true;
        int r13 = 0;
    L7:
        if (r13 >= r11) goto L22;
        LinkedList<Entry<K, V>> r14 = r10[r13];
        if (r14 == null) goto L21;
        Iterator<Entry<K, V>> r15 = r14.iterator();
    L13:
        if (r15.hasNext() == false) goto L21;
        Entry<K, V> r16 = r15.next();
        if (r16 == null) goto L21;
        if (r12 == false) goto L19;
        r12 = false;
    L20:
        r5.append(r16.toString());
        goto L13
    L19:
        r5.append(", ");
    L21:
        r13 = r13 + 1;
        goto L7
    L22:
        r5.append('}');
        return r5.toString();
    }

    public String toTableString() {
        StringBuilder r5 = new StringBuilder();
        LinkedList<Entry<K, V>>[] r10 = this.buckets;
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L20;
        LinkedList<Entry<K, V>> r13 = r10[r12];
        if (r13 != null) goto L7;
        r5.append("null\n");
    L18:
        r12 = r12 + 1;
        goto L3
    L7:
        r5.append('[');
        Iterator<Entry<K, V>> r14 = r13.iterator();
        boolean r15 = true;
    L9:
        if (r14.hasNext() == false) goto L17;
        Entry<K, V> r16 = r14.next();
        if (r15 == false) goto L13;
        r15 = false;
    L14:
        if (r16 == null) goto L15;
        r5.append(r16.toString());
        goto L9
    L15:
        r5.append("_");
        goto L9
    L13:
        r5.append(" ");
        goto L14
    L17:
        r5.append("]\n");
        goto L18
    L20:
        return r5.toString();
    }

    @Override // java.util.Map
    public Collection<V> values() {
        ArrayList r5 = new ArrayList(size());
        LinkedList<Entry<K, V>>[] r10 = this.buckets;
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L12;
        LinkedList<Entry<K, V>> r13 = r10[r12];
        if (r13 == null) goto L11;
        Iterator<Entry<K, V>> r14 = r13.iterator();
    L9:
        if (r14.hasNext() == false) goto L11;
        r5.add(r14.next().value);
    L11:
        r12 = r12 + 1;
        goto L3
    L12:
        return r5;
    }

    public FlexibleHashMap(AbstractEqualityComparator<? super K> r5) {
        this(r5, 16, 8);
    }

    public FlexibleHashMap(AbstractEqualityComparator<? super K> r5, int r10, int r11) {
        this.f664n = 0;
        this.threshold = 12;
        this.currentPrime = 1;
        this.initialBucketCapacity = 8;
        if (r5 != null) goto L5;
        r5 = ObjectEqualityComparator.INSTANCE;
    L5:
        this.comparator = r5;
        this.buckets = createEntryListArray(r11);
        this.initialBucketCapacity = r11;
    }
}
