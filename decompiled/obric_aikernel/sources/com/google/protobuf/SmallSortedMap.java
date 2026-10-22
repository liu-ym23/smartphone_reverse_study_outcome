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

/* JADX INFO: loaded from: classes2.dex */
class SmallSortedMap<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    static final int DEFAULT_FIELD_MAP_ARRAY_SIZE = 16;
    private Object[] entries;
    private int entriesSize;
    private boolean isImmutable;
    private volatile SmallSortedMap<K, V>.EntrySet lazyEntrySet;
    private Map<K, V> overflowEntries;
    private Map<K, V> overflowEntriesDescending;

    private class DescendingEntryIterator implements Iterator<Map.Entry<K, V>> {
        private Iterator<Map.Entry<K, V>> lazyOverflowIterator;
        private int pos;
        final /* synthetic */ SmallSortedMap this$0;

        private DescendingEntryIterator(SmallSortedMap r10) {
            this.this$0 = r10;
            this.pos = SmallSortedMap.access$600(r10);
        }

        /* synthetic */ DescendingEntryIterator(SmallSortedMap r10, AnonymousClass1 r11) {
            this(r10);
        }

        private Iterator<Map.Entry<K, V>> getOverflowIterator() {
            if (this.lazyOverflowIterator != null) goto L6;
            this.lazyOverflowIterator = SmallSortedMap.access$1000(this.this$0).entrySet().iterator();
        L6:
            return this.lazyOverflowIterator;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            int r10 = this.pos;
            if (r10 <= 0) goto L7;
            if (r10 > SmallSortedMap.access$600(this.this$0)) goto L7;
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
        public Map.Entry<K, V> next() {
            if (getOverflowIterator().hasNext() == true) goto L5;
            Object[] r10 = SmallSortedMap.access$800(this.this$0);
            int r11 = this.pos - 1;
            this.pos = r11;
            return (Entry) r10[r11];
        L5:
            return getOverflowIterator().next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private class DescendingEntrySet extends SmallSortedMap<K, V>.EntrySet {
        final /* synthetic */ SmallSortedMap this$0;

        private DescendingEntrySet(SmallSortedMap r10) {
            this.this$0 = r10;
            super(r10, null);
        }

        /* synthetic */ DescendingEntrySet(SmallSortedMap r10, AnonymousClass1 r11) {
            this(r10);
        }

        @Override // com.google.protobuf.SmallSortedMap.EntrySet, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new DescendingEntryIterator(this.this$0, null);
        }
    }

    private class Entry implements Map.Entry<K, V>, Comparable<SmallSortedMap<K, V>.Entry> {
        private final K key;
        final /* synthetic */ SmallSortedMap this$0;
        private V value;

        Entry(SmallSortedMap r10, K r11, V r12) {
            this.this$0 = r10;
            this.key = r11;
            this.value = r12;
        }

        Entry(SmallSortedMap r10, Map.Entry<K, V> r11) {
            this(r10, r11.getKey(), r11.getValue());
        }

        private boolean equals(Object r10, Object r11) {
            if (r10 != null) goto L7;
            if (r11 != null) goto L5;
            return true;
        L5:
            return false;
        L7:
            return r10.equals(r11);
        }

        public int compareTo(SmallSortedMap<K, V>.Entry r10) {
            return getKey().compareTo(r10.getKey());
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object r10) {
            return compareTo((Entry) r10);
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object r10) {
            if (r10 != this) goto L6;
            return true;
        L6:
            if ((r10 instanceof Map.Entry) == true) goto L8;
            return false;
        L8:
            Map.Entry r11 = (Map.Entry) r10;
            if (equals(this.key, r11.getKey()) == false) goto L14;
            if (equals(this.value, r11.getValue()) == false) goto L14;
            return true;
        L14:
            return false;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public /* bridge */ /* synthetic */ Object getKey() {
            return getKey();
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.value;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K r10 = this.key;
            int r11 = 0;
            if (r10 != null) goto L5;
            int r12 = 0;
        L6:
            V r13 = this.value;
            if (r13 == null) goto L11;
            r11 = r13.hashCode();
        L11:
            return r12 ^ r11;
        L5:
            r12 = r10.hashCode();
            goto L6
        }

        @Override // java.util.Map.Entry
        public V setValue(V r10) {
            SmallSortedMap.access$300(this.this$0);
            V r11 = this.value;
            this.value = r10;
            return r11;
        }

        public String toString() {
            return this.key + "=" + this.value;
        }
    }

    private class EntryIterator implements Iterator<Map.Entry<K, V>> {
        private Iterator<Map.Entry<K, V>> lazyOverflowIterator;
        private boolean nextCalledBeforeRemove;
        private int pos;
        final /* synthetic */ SmallSortedMap this$0;

        private EntryIterator(SmallSortedMap r10) {
            this.this$0 = r10;
            this.pos = -1;
        }

        /* synthetic */ EntryIterator(SmallSortedMap r10, AnonymousClass1 r11) {
            this(r10);
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
        public Map.Entry<K, V> next() {
            this.nextCalledBeforeRemove = true;
            int r10 = this.pos + 1;
            this.pos = r10;
            if (r10 >= SmallSortedMap.access$600(this.this$0)) goto L7;
            return (Entry) SmallSortedMap.access$800(this.this$0)[this.pos];
        L7:
            return getOverflowIterator().next();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.nextCalledBeforeRemove == false) goto L10;
            this.nextCalledBeforeRemove = false;
            SmallSortedMap.access$300(this.this$0);
            if (this.pos >= SmallSortedMap.access$600(this.this$0)) goto L7;
            SmallSortedMap r10 = this.this$0;
            int r11 = this.pos;
            this.pos = r11 - 1;
            SmallSortedMap.access$900(r10, r11);
            return;
        L7:
            getOverflowIterator().remove();
            return;
        L10:
            throw new IllegalStateException("remove() was called before next()");
        }
    }

    private class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        final /* synthetic */ SmallSortedMap this$0;

        private EntrySet(SmallSortedMap r10) {
            this.this$0 = r10;
        }

        /* synthetic */ EntrySet(SmallSortedMap r10, AnonymousClass1 r11) {
            this(r10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public /* bridge */ /* synthetic */ boolean add(Object r10) {
            return add((Map.Entry) r10);
        }

        public boolean add(Map.Entry<K, V> r10) {
            if (contains(r10) == true) goto L6;
            this.this$0.put(r10.getKey(), r10.getValue());
            return true;
        L6:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.this$0.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r10) {
            Map.Entry r11 = (Map.Entry) r10;
            Object r12 = this.this$0.get(r11.getKey());
            Object r13 = r11.getValue();
            if (r12 == r13) goto L9;
            if (r12 != null) goto L6;
        L8:
            return false;
        L6:
            if (r12.equals(r13) == false) goto L8;
        L9:
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new EntryIterator(this.this$0, null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object r10) {
            Map.Entry r11 = (Map.Entry) r10;
            if (contains(r11) == false) goto L6;
            this.this$0.remove(r11.getKey());
            return true;
        L6:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.this$0.size();
        }
    }

    private SmallSortedMap() {
        this.overflowEntries = Collections.emptyMap();
        this.overflowEntriesDescending = Collections.emptyMap();
    }

    /* synthetic */ SmallSortedMap(AnonymousClass1 r10) {
        this();
    }

    static /* synthetic */ Map access$1000(SmallSortedMap r10) {
        return r10.overflowEntriesDescending;
    }

    static /* synthetic */ void access$300(SmallSortedMap r10) {
        r10.checkMutable();
    }

    static /* synthetic */ int access$600(SmallSortedMap r10) {
        return r10.entriesSize;
    }

    static /* synthetic */ Map access$700(SmallSortedMap r10) {
        return r10.overflowEntries;
    }

    static /* synthetic */ Object[] access$800(SmallSortedMap r10) {
        return r10.entries;
    }

    static /* synthetic */ Object access$900(SmallSortedMap r10, int r11) {
        return r10.removeArrayEntryAt(r11);
    }

    private int binarySearchInArray(K r10) {
        int r11 = this.entriesSize - 1;
        if (r11 < 0) goto L10;
        int r12 = r10.compareTo(((Entry) this.entries[r11]).getKey());
        if (r12 > 0) goto L7;
        if (r12 != 0) goto L10;
        return r11;
    L7:
        return -(r11 + 2);
    L10:
        int r13 = 0;
    L11:
        if (r13 > r11) goto L19;
        int r14 = (r13 + r11) / 2;
        int r15 = r10.compareTo(((Entry) this.entries[r14]).getKey());
        if (r15 < 0) goto L14;
        if (r15 <= 0) goto L17;
        r13 = r14 + 1;
        goto L11
    L17:
        return r14;
    L14:
        r11 = r14 - 1;
        goto L11
    L19:
        return -(r13 + 1);
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
        TreeMap r10 = new TreeMap();
        this.overflowEntries = r10;
        this.overflowEntriesDescending = r10.descendingMap();
    L8:
        return (SortedMap) this.overflowEntries;
    }

    static <FieldDescriptorT extends FieldSet.FieldDescriptorLite<FieldDescriptorT>> SmallSortedMap<FieldDescriptorT, Object> newFieldMap() {
        return (SmallSortedMap<FieldDescriptorT, Object>) new AnonymousClass1();
    }

    static <K extends Comparable<K>, V> SmallSortedMap<K, V> newInstanceForTest() {
        return new SmallSortedMap();
    }

    private V removeArrayEntryAt(int r10) {
        checkMutable();
        V r11 = (V) ((Entry) this.entries[r10]).getValue();
        Object[] r12 = this.entries;
        System.arraycopy(r12, r10 + 1, r12, r10, (this.entriesSize - r10) - 1);
        this.entriesSize--;
        if (this.overflowEntries.isEmpty() == true) goto L5;
        Iterator<Map.Entry<K, V>> r13 = getOverflowEntriesMutable().entrySet().iterator();
        this.entries[this.entriesSize] = new Entry(this, r13.next());
        this.entriesSize++;
        r13.remove();
    L5:
        return r11;
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
    public boolean containsKey(Object r10) {
        Comparable r11 = (Comparable) r10;
        if (binarySearchInArray(r11) < 0) goto L5;
    L8:
        return true;
    L5:
        if (this.overflowEntries.containsKey(r11) == true) goto L8;
        return false;
    }

    Set<Map.Entry<K, V>> descendingEntrySet() {
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
    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof SmallSortedMap) == false) goto L8;
        SmallSortedMap r11 = (SmallSortedMap) r10;
        int r12 = size();
        if (r12 == r11.size()) goto L12;
        return false;
    L12:
        int r13 = getNumArrayEntries();
        if (r13 != r11.getNumArrayEntries()) goto L15;
        int r14 = 0;
    L17:
        if (r14 >= r13) goto L22;
        if (getArrayEntryAt(r14).equals(r11.getArrayEntryAt(r14)) == false) goto L20;
        r14 = r14 + 1;
        goto L17
    L20:
        return false;
    L22:
        if (r13 != r12) goto L24;
        return true;
    L24:
        return this.overflowEntries.equals(r11.overflowEntries);
    L15:
        return entrySet().equals(r11.entrySet());
    L8:
        return super.equals(r10);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object r10) {
        Comparable r11 = (Comparable) r10;
        int r12 = binarySearchInArray(r11);
        if (r12 < 0) goto L7;
        return (V) ((Entry) this.entries[r12]).getValue();
    L7:
        return this.overflowEntries.get(r11);
    }

    public Map.Entry<K, V> getArrayEntryAt(int r10) {
        if (r10 >= this.entriesSize) goto L7;
        return (Entry) this.entries[r10];
    L7:
        throw new ArrayIndexOutOfBoundsException(r10);
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
        int r10 = getNumArrayEntries();
        int r11 = 0;
        int r12 = 0;
    L3:
        if (r11 >= r10) goto L6;
        r12 = r12 + this.entries[r11].hashCode();
        r11 = r11 + 1;
        goto L3
    L6:
        if (getNumOverflowEntries() > 0) goto L8;
        return r12;
    L8:
        return r12 + this.overflowEntries.hashCode();
    }

    public boolean isImmutable() {
        return this.isImmutable;
    }

    public void makeImmutable() {
        if (this.isImmutable == false) goto L5;
        return;
    L5:
        if (this.overflowEntries.isEmpty() == false) goto L7;
        Map<K, V> r10 = Collections.emptyMap();
    L8:
        this.overflowEntries = r10;
        if (this.overflowEntriesDescending.isEmpty() == false) goto L11;
        Map<K, V> r11 = Collections.emptyMap();
    L12:
        this.overflowEntriesDescending = r11;
        this.isImmutable = true;
        return;
    L11:
        r11 = Collections.unmodifiableMap(this.overflowEntriesDescending);
        goto L12
    L7:
        r10 = Collections.unmodifiableMap(this.overflowEntries);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public V put(K r10, V r11) {
        checkMutable();
        int r12 = binarySearchInArray(r10);
        if (r12 >= 0) goto L5;
        ensureEntryArrayMutable();
        int r13 = -(r12 + 1);
        if (r13 >= 16) goto L9;
        int r14 = this.entriesSize;
        if (r14 != 16) goto L13;
        Entry r15 = (Entry) this.entries[15];
        this.entriesSize = r14 - 1;
        getOverflowEntriesMutable().put(r15.getKey(), r15.getValue());
    L13:
        Object[] r16 = this.entries;
        System.arraycopy(r16, r13, r16, r13 + 1, (r16.length - r13) - 1);
        this.entries[r13] = new Entry(this, r10, r11);
        this.entriesSize++;
        return null;
    L9:
        return getOverflowEntriesMutable().put(r10, r11);
    L5:
        return (V) ((Entry) this.entries[r12]).setValue(r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public /* bridge */ /* synthetic */ Object put(Object r10, Object r11) {
        return put((Comparable) r10, r11);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object r10) {
        checkMutable();
        Comparable r11 = (Comparable) r10;
        int r12 = binarySearchInArray(r11);
        if (r12 < 0) goto L7;
        return removeArrayEntryAt(r12);
    L7:
        if (this.overflowEntries.isEmpty() == false) goto L11;
        return null;
    L11:
        return this.overflowEntries.remove(r11);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.entriesSize + this.overflowEntries.size();
    }
}
