package com.google.protobuf;

import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
class SmallSortedMap<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    static final int DEFAULT_FIELD_MAP_ARRAY_SIZE = 16;
    private Object[] entries;
    private int entriesSize;
    private boolean isImmutable;
    private volatile SmallSortedMap<K, V>.EntrySet lazyEntrySet;
    private Map<K, V> overflowEntries;
    private Map<K, V> overflowEntriesDescending;

    public class DescendingEntryIterator implements Iterator<Map.Entry<K, V>> {
        private Iterator<Map.Entry<K, V>> lazyOverflowIterator;
        private int pos;
        final /* synthetic */ SmallSortedMap this$0;

        private DescendingEntryIterator(SmallSortedMap r8) {
            this.this$0 = r8;
            this.pos = SmallSortedMap.access$600(r8);
        }

        private Iterator<Map.Entry<K, V>> getOverflowIterator() {
            if (this.lazyOverflowIterator != null) goto L6;
            this.lazyOverflowIterator = SmallSortedMap.access$1000(this.this$0).entrySet().iterator();
        L6:
            return this.lazyOverflowIterator;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            int r8 = this.pos;
            if (r8 <= 0) goto L7;
            if (r8 > SmallSortedMap.access$600(this.this$0)) goto L7;
        L8:
            return true;
        L7:
            if (getOverflowIterator().hasNext() == true) goto L8;
            return false;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        public /* synthetic */ DescendingEntryIterator(SmallSortedMap r8, AnonymousClass1 r10) {
            this(r8);
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            if (getOverflowIterator().hasNext() == true) goto L5;
            Object[] r8 = SmallSortedMap.access$800(this.this$0);
            int r10 = this.pos - 1;
            this.pos = r10;
            return (Entry) r8[r10];
        L5:
            return getOverflowIterator().next();
        }
    }

    public class DescendingEntrySet extends SmallSortedMap<K, V>.EntrySet {
        final /* synthetic */ SmallSortedMap this$0;

        private DescendingEntrySet(SmallSortedMap r8) {
            this.this$0 = r8;
            super(r8, null);
        }

        @Override // com.google.protobuf.SmallSortedMap.EntrySet, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new DescendingEntryIterator(this.this$0, null);
        }

        public /* synthetic */ DescendingEntrySet(SmallSortedMap r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    public class Entry implements Map.Entry<K, V>, Comparable<SmallSortedMap<K, V>.Entry> {
        private final K key;
        final /* synthetic */ SmallSortedMap this$0;
        private V value;

        public Entry(SmallSortedMap r8, K r10, V r11) {
            this.this$0 = r8;
            this.key = r10;
            this.value = r11;
        }

        public int compareTo(SmallSortedMap<K, V>.Entry r8) {
            return getKey().compareTo(r8.getKey());
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object r8) {
            if (r8 != this) goto L6;
            return true;
        L6:
            if ((r8 instanceof Map.Entry) == true) goto L8;
            return false;
        L8:
            Map.Entry r10 = (Map.Entry) r8;
            if (equals(this.key, r10.getKey()) == false) goto L14;
            if (equals(this.value, r10.getValue()) == false) goto L14;
            return true;
        L14:
            return false;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.value;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K r8 = this.key;
            int r10 = 0;
            if (r8 != null) goto L5;
            int r11 = 0;
        L6:
            V r12 = this.value;
            if (r12 == null) goto L11;
            r10 = r12.hashCode();
        L11:
            return r11 ^ r10;
        L5:
            r11 = r8.hashCode();
            goto L6
        }

        @Override // java.util.Map.Entry
        public V setValue(V r8) {
            SmallSortedMap.access$300(this.this$0);
            V r10 = this.value;
            this.value = r8;
            return r10;
        }

        public String toString() {
            return this.key + "=" + this.value;
        }

        public Entry(SmallSortedMap r8, Map.Entry<K, V> r10) {
            this(r8, r10.getKey(), r10.getValue());
        }

        private boolean equals(Object r8, Object r10) {
            if (r8 != null) goto L7;
            if (r10 != null) goto L5;
            return true;
        L5:
            return false;
        L7:
            return r8.equals(r10);
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object r8) {
            return compareTo((Entry) r8);
        }

        @Override // java.util.Map.Entry
        public /* bridge */ /* synthetic */ Object getKey() {
            return getKey();
        }
    }

    public class EntryIterator implements Iterator<Map.Entry<K, V>> {
        private Iterator<Map.Entry<K, V>> lazyOverflowIterator;
        private boolean nextCalledBeforeRemove;
        private int pos;
        final /* synthetic */ SmallSortedMap this$0;

        private EntryIterator(SmallSortedMap r8) {
            this.this$0 = r8;
            this.pos = -1;
        }

        private Iterator<Map.Entry<K, V>> getOverflowIterator() {
            if (this.lazyOverflowIterator != null) goto L6;
            this.lazyOverflowIterator = SmallSortedMap.access$700(this.this$0).entrySet().iterator();
        L6:
            return this.lazyOverflowIterator;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if ((this.pos + 1) >= SmallSortedMap.access$600(this.this$0)) goto L5;
            return true;
        L5:
            if (SmallSortedMap.access$700(this.this$0).isEmpty() == false) goto L7;
        L9:
            return false;
        L7:
            if (getOverflowIterator().hasNext() == false) goto L9;
            return true;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return next();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.nextCalledBeforeRemove == false) goto L10;
            this.nextCalledBeforeRemove = false;
            SmallSortedMap.access$300(this.this$0);
            if (this.pos >= SmallSortedMap.access$600(this.this$0)) goto L7;
            SmallSortedMap r8 = this.this$0;
            int r10 = this.pos;
            this.pos = r10 - 1;
            SmallSortedMap.access$900(r8, r10);
            return;
        L7:
            getOverflowIterator().remove();
            return;
        L10:
            throw new IllegalStateException("remove() was called before next()");
        }

        public /* synthetic */ EntryIterator(SmallSortedMap r8, AnonymousClass1 r10) {
            this(r8);
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            this.nextCalledBeforeRemove = true;
            int r8 = this.pos + 1;
            this.pos = r8;
            if (r8 >= SmallSortedMap.access$600(this.this$0)) goto L7;
            return (Entry) SmallSortedMap.access$800(this.this$0)[this.pos];
        L7:
            return getOverflowIterator().next();
        }
    }

    public class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        final /* synthetic */ SmallSortedMap this$0;

        private EntrySet(SmallSortedMap r8) {
            this.this$0 = r8;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public /* bridge */ /* synthetic */ boolean add(Object r8) {
            return add((Map.Entry) r8);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.this$0.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r8) {
            Map.Entry r10 = (Map.Entry) r8;
            Object r11 = this.this$0.get(r10.getKey());
            Object r12 = r10.getValue();
            if (r11 == r12) goto L9;
            if (r11 != null) goto L6;
        L8:
            return false;
        L6:
            if (r11.equals(r12) == false) goto L8;
        L9:
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new EntryIterator(this.this$0, null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object r8) {
            Map.Entry r10 = (Map.Entry) r8;
            if (contains(r10) == false) goto L6;
            this.this$0.remove(r10.getKey());
            return true;
        L6:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.this$0.size();
        }

        public /* synthetic */ EntrySet(SmallSortedMap r8, AnonymousClass1 r10) {
            this(r8);
        }

        public boolean add(Map.Entry<K, V> r8) {
            if (contains(r8) == true) goto L6;
            this.this$0.put(r8.getKey(), r8.getValue());
            return true;
        L6:
            return false;
        }
    }

    private SmallSortedMap() {
        this.overflowEntries = Collections.emptyMap();
        this.overflowEntriesDescending = Collections.emptyMap();
    }

    public static /* synthetic */ Map access$1000(SmallSortedMap r8) {
        return r8.overflowEntriesDescending;
    }

    public static /* synthetic */ void access$300(SmallSortedMap r8) {
        r8.checkMutable();
    }

    public static /* synthetic */ int access$600(SmallSortedMap r8) {
        return r8.entriesSize;
    }

    public static /* synthetic */ Map access$700(SmallSortedMap r8) {
        return r8.overflowEntries;
    }

    public static /* synthetic */ Object[] access$800(SmallSortedMap r8) {
        return r8.entries;
    }

    public static /* synthetic */ Object access$900(SmallSortedMap r8, int r10) {
        return r8.removeArrayEntryAt(r10);
    }

    private int binarySearchInArray(K r8) {
        int r10 = this.entriesSize - 1;
        if (r10 < 0) goto L10;
        int r11 = r8.compareTo(((Entry) this.entries[r10]).getKey());
        if (r11 > 0) goto L7;
        if (r11 != 0) goto L10;
        return r10;
    L7:
        return -(r10 + 2);
    L10:
        int r12 = 0;
    L11:
        if (r12 > r10) goto L19;
        int r13 = (r12 + r10) / 2;
        int r14 = r8.compareTo(((Entry) this.entries[r13]).getKey());
        if (r14 < 0) goto L14;
        if (r14 <= 0) goto L17;
        r12 = r13 + 1;
        goto L11
    L17:
        return r13;
    L14:
        r10 = r13 - 1;
        goto L11
    L19:
        return -(r12 + 1);
    }

    private void checkMutable() {
        if (this.isImmutable == true) goto L6;
        return;
    L6:
        throw new UnsupportedOperationException();
    }

    private void ensureEntryArrayMutable() {
        checkMutable();
        if (this.entries != null) goto L6;
        this.entries = new Object[16];
        return;
    }

    private SortedMap<K, V> getOverflowEntriesMutable() {
        checkMutable();
        if (this.overflowEntries.isEmpty() == false) goto L8;
        if ((this.overflowEntries instanceof TreeMap) == true) goto L8;
        TreeMap r8 = new TreeMap();
        this.overflowEntries = r8;
        this.overflowEntriesDescending = r8.descendingMap();
    L8:
        return (SortedMap) this.overflowEntries;
    }

    public static <FieldDescriptorT extends FieldSet.FieldDescriptorLite<FieldDescriptorT>> SmallSortedMap<FieldDescriptorT, Object> newFieldMap() {
        return (SmallSortedMap<FieldDescriptorT, Object>) new AnonymousClass1();
    }

    public static <K extends Comparable<K>, V> SmallSortedMap<K, V> newInstanceForTest() {
        return new SmallSortedMap();
    }

    private V removeArrayEntryAt(int r8) {
        checkMutable();
        V r10 = (V) ((Entry) this.entries[r8]).getValue();
        Object[] r11 = this.entries;
        System.arraycopy(r11, r8 + 1, r11, r8, (this.entriesSize - r8) - 1);
        this.entriesSize--;
        if (this.overflowEntries.isEmpty() == true) goto L5;
        Iterator<Map.Entry<K, V>> r12 = getOverflowEntriesMutable().entrySet().iterator();
        this.entries[this.entriesSize] = new Entry(this, r12.next());
        this.entriesSize++;
        r12.remove();
    L5:
        return r10;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        checkMutable();
        if (this.entriesSize == 0) goto L6;
        this.entries = null;
        this.entriesSize = 0;
    L6:
        if (this.overflowEntries.isEmpty() == true) goto L9;
        this.overflowEntries.clear();
        return;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object r8) {
        Comparable r10 = (Comparable) r8;
        if (binarySearchInArray(r10) < 0) goto L5;
    L8:
        return true;
    L5:
        if (this.overflowEntries.containsKey(r10) == true) goto L8;
        return false;
    }

    public Set<Map.Entry<K, V>> descendingEntrySet() {
        return new DescendingEntrySet(this, null);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.lazyEntrySet != null) goto L6;
        this.lazyEntrySet = new EntrySet(this, null);
    L6:
        return this.lazyEntrySet;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof SmallSortedMap) == false) goto L8;
        SmallSortedMap r10 = (SmallSortedMap) r8;
        int r11 = size();
        if (r11 == r10.size()) goto L12;
        return false;
    L12:
        int r12 = getNumArrayEntries();
        if (r12 != r10.getNumArrayEntries()) goto L15;
        int r13 = 0;
    L17:
        if (r13 >= r12) goto L22;
        if (getArrayEntryAt(r13).equals(r10.getArrayEntryAt(r13)) == false) goto L20;
        r13 = r13 + 1;
        goto L17
    L20:
        return false;
    L22:
        if (r12 != r11) goto L24;
        return true;
    L24:
        return this.overflowEntries.equals(r10.overflowEntries);
    L15:
        return entrySet().equals(r10.entrySet());
    L8:
        return super.equals(r8);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object r8) {
        Comparable r10 = (Comparable) r8;
        int r11 = binarySearchInArray(r10);
        if (r11 < 0) goto L7;
        return (V) ((Entry) this.entries[r11]).getValue();
    L7:
        return this.overflowEntries.get(r10);
    }

    public Map.Entry<K, V> getArrayEntryAt(int r8) {
        if (r8 >= this.entriesSize) goto L7;
        return (Entry) this.entries[r8];
    L7:
        throw new ArrayIndexOutOfBoundsException(r8);
    }

    public int getNumArrayEntries() {
        return this.entriesSize;
    }

    public int getNumOverflowEntries() {
        return this.overflowEntries.size();
    }

    public Iterable<Map.Entry<K, V>> getOverflowEntries() {
        if (this.overflowEntries.isEmpty() == false) goto L6;
        return Collections.emptySet();
    L6:
        return this.overflowEntries.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int r8 = getNumArrayEntries();
        int r10 = 0;
        int r11 = 0;
    L3:
        if (r10 >= r8) goto L6;
        r11 = r11 + this.entries[r10].hashCode();
        r10 = r10 + 1;
        goto L3
    L6:
        if (getNumOverflowEntries() > 0) goto L8;
        return r11;
    L8:
        return r11 + this.overflowEntries.hashCode();
    }

    public boolean isImmutable() {
        return this.isImmutable;
    }

    public void makeImmutable() {
        if (this.isImmutable == false) goto L5;
        return;
    L5:
        if (this.overflowEntries.isEmpty() == false) goto L7;
        Map<K, V> r8 = Collections.emptyMap();
    L8:
        this.overflowEntries = r8;
        if (this.overflowEntriesDescending.isEmpty() == false) goto L11;
        Map<K, V> r10 = Collections.emptyMap();
    L12:
        this.overflowEntriesDescending = r10;
        this.isImmutable = true;
        return;
    L11:
        r10 = Collections.unmodifiableMap(this.overflowEntriesDescending);
        goto L12
    L7:
        r8 = Collections.unmodifiableMap(this.overflowEntries);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public V put(K r8, V r10) {
        checkMutable();
        int r11 = binarySearchInArray(r8);
        if (r11 >= 0) goto L5;
        ensureEntryArrayMutable();
        int r12 = -(r11 + 1);
        if (r12 >= 16) goto L9;
        int r13 = this.entriesSize;
        if (r13 != 16) goto L13;
        Entry r14 = (Entry) this.entries[15];
        this.entriesSize = r13 - 1;
        getOverflowEntriesMutable().put(r14.getKey(), r14.getValue());
    L13:
        Object[] r15 = this.entries;
        System.arraycopy(r15, r12, r15, r12 + 1, (r15.length - r12) - 1);
        this.entries[r12] = new Entry(this, r8, r10);
        this.entriesSize++;
        return null;
    L9:
        return getOverflowEntriesMutable().put(r8, r10);
    L5:
        return (V) ((Entry) this.entries[r11]).setValue(r10);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object r8) {
        checkMutable();
        Comparable r10 = (Comparable) r8;
        int r11 = binarySearchInArray(r10);
        if (r11 < 0) goto L7;
        return removeArrayEntryAt(r11);
    L7:
        if (this.overflowEntries.isEmpty() == false) goto L11;
        return null;
    L11:
        return this.overflowEntries.remove(r10);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        int r8 = this.entriesSize;
        return this.overflowEntries.size() + r8;
    }

    public /* synthetic */ SmallSortedMap(AnonymousClass1 r8) {
        this();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public /* bridge */ /* synthetic */ Object put(Object r8, Object r10) {
        return put((Comparable) r8, r10);
    }
}
