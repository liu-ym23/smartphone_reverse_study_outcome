package androidx.room.jarjarred.kotlinx.metadata.internal.protobuf;

import androidx.constraintlayout.motion.widget.a;
import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
class SmallSortedMap<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    private List<SmallSortedMap<K, V>.Entry> entryList;
    private boolean isImmutable;
    private volatile SmallSortedMap<K, V>.EntrySet lazyEntrySet;
    private final int maxArraySize;
    private Map<K, V> overflowEntries;

    public static class EmptySet {
        private static final Iterable<Object> ITERABLE = null;
        private static final Iterator<Object> ITERATOR = null;

        static {
            ITERATOR = new AnonymousClass1();
            ITERABLE = new AnonymousClass2();
        }

        private EmptySet() {
        }

        public static /* synthetic */ Iterator access$700() {
            return ITERATOR;
        }

        public static <T> Iterable<T> iterable() {
            return (Iterable<T>) ITERABLE;
        }
    }

    public class Entry implements Map.Entry<K, V>, Comparable<SmallSortedMap<K, V>.Entry> {
        private final K key;
        final /* synthetic */ SmallSortedMap this$0;
        private V value;

        public Entry(SmallSortedMap r5, Map.Entry<K, V> r10) {
            this(r5, r10.getKey(), r10.getValue());
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object r5) {
            return compareTo((Entry) r5);
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object r5) {
            if (r5 != this) goto L6;
            return true;
        L6:
            if ((r5 instanceof Map.Entry) == true) goto L8;
            return false;
        L8:
            Map.Entry r10 = (Map.Entry) r5;
            if (equals(this.key, r10.getKey()) == false) goto L14;
            if (equals(this.value, r10.getValue()) == false) goto L14;
            return true;
        L14:
            return false;
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
            K r5 = this.key;
            int r10 = 0;
            if (r5 != null) goto L5;
            int r11 = 0;
        L6:
            V r12 = this.value;
            if (r12 == null) goto L11;
            r10 = r12.hashCode();
        L11:
            return r11 ^ r10;
        L5:
            r11 = r5.hashCode();
            goto L6
        }

        @Override // java.util.Map.Entry
        public V setValue(V r5) {
            SmallSortedMap.access$200(this.this$0);
            V r10 = this.value;
            this.value = r5;
            return r10;
        }

        public String toString() {
            String r5 = String.valueOf(this.key);
            String r10 = String.valueOf(this.value);
            int r11 = r5.length() + 1;
            return a.t(new StringBuilder(r10.length() + r11), r5, "=", r10);
        }

        public Entry(SmallSortedMap r5, K r10, V r11) {
            this.this$0 = r5;
            this.key = r10;
            this.value = r11;
        }

        public int compareTo(SmallSortedMap<K, V>.Entry r5) {
            return getKey().compareTo(r5.getKey());
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.key;
        }

        private boolean equals(Object r5, Object r10) {
            if (r5 != null) goto L7;
            if (r10 != null) goto L5;
            return true;
        L5:
            return false;
        L7:
            return r5.equals(r10);
        }
    }

    public class EntryIterator implements Iterator<Map.Entry<K, V>> {
        private Iterator<Map.Entry<K, V>> lazyOverflowIterator;
        private boolean nextCalledBeforeRemove;
        private int pos;
        final /* synthetic */ SmallSortedMap this$0;

        private EntryIterator(SmallSortedMap r5) {
            this.this$0 = r5;
            this.pos = -1;
        }

        private Iterator<Map.Entry<K, V>> getOverflowIterator() {
            if (this.lazyOverflowIterator != null) goto L6;
            this.lazyOverflowIterator = SmallSortedMap.access$600(this.this$0).entrySet().iterator();
        L6:
            return this.lazyOverflowIterator;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if ((this.pos + 1) >= SmallSortedMap.access$400(this.this$0).size()) goto L5;
            return true;
        L5:
            if (getOverflowIterator().hasNext() == true) goto L10;
            return false;
        L10:
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
            SmallSortedMap.access$200(this.this$0);
            if (this.pos >= SmallSortedMap.access$400(this.this$0).size()) goto L7;
            SmallSortedMap r5 = this.this$0;
            int r10 = this.pos;
            this.pos = r10 - 1;
            SmallSortedMap.access$500(r5, r10);
            return;
        L7:
            getOverflowIterator().remove();
            return;
        L10:
            throw new IllegalStateException("remove() was called before next()");
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            this.nextCalledBeforeRemove = true;
            int r5 = this.pos + 1;
            this.pos = r5;
            if (r5 >= SmallSortedMap.access$400(this.this$0).size()) goto L7;
            return (Map.Entry) SmallSortedMap.access$400(this.this$0).get(this.pos);
        L7:
            return getOverflowIterator().next();
        }

        public /* synthetic */ EntryIterator(SmallSortedMap r5, AnonymousClass1 r10) {
            this(r5);
        }
    }

    public class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        final /* synthetic */ SmallSortedMap this$0;

        private EntrySet(SmallSortedMap r5) {
            this.this$0 = r5;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public /* bridge */ /* synthetic */ boolean add(Object r5) {
            return add((Map.Entry) r5);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.this$0.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r5) {
            Map.Entry r10 = (Map.Entry) r5;
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
        public boolean remove(Object r5) {
            Map.Entry r10 = (Map.Entry) r5;
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

        public /* synthetic */ EntrySet(SmallSortedMap r5, AnonymousClass1 r10) {
            this(r5);
        }

        public boolean add(Map.Entry<K, V> r5) {
            if (contains(r5) == true) goto L6;
            this.this$0.put(r5.getKey(), r5.getValue());
            return true;
        L6:
            return false;
        }
    }

    public /* synthetic */ SmallSortedMap(int r5, AnonymousClass1 r10) {
        this(r5);
    }

    public static /* synthetic */ void access$200(SmallSortedMap r5) {
        r5.checkMutable();
    }

    public static /* synthetic */ List access$400(SmallSortedMap r5) {
        return r5.entryList;
    }

    public static /* synthetic */ Object access$500(SmallSortedMap r5, int r10) {
        return r5.removeArrayEntryAt(r10);
    }

    public static /* synthetic */ Map access$600(SmallSortedMap r5) {
        return r5.overflowEntries;
    }

    private int binarySearchInArray(K r5) {
        int r10 = this.entryList.size();
        int r11 = r10 - 1;
        if (r11 < 0) goto L11;
        int r12 = r5.compareTo(this.entryList.get(r11).getKey());
        if (r12 <= 0) goto L9;
        int r13 = r10 + 1;
    L8:
        return -r13;
    L9:
        if (r12 != 0) goto L11;
        return r11;
    L11:
        int r14 = 0;
    L12:
        if (r14 > r11) goto L19;
        int r15 = (r14 + r11) / 2;
        int r16 = r5.compareTo(this.entryList.get(r15).getKey());
        if (r16 < 0) goto L15;
        if (r16 <= 0) goto L18;
        r14 = r15 + 1;
        goto L12
    L18:
        return r15;
    L15:
        r11 = r15 - 1;
        goto L12
    L19:
        r13 = r14 + 1;
        goto L8
    }

    private void checkMutable() {
        if (this.isImmutable == true) goto L6;
        return;
    L6:
        throw new UnsupportedOperationException();
    }

    private void ensureEntryArrayMutable() {
        checkMutable();
        if (this.entryList.isEmpty() == true) goto L5;
        return;
    L5:
        if ((this.entryList instanceof ArrayList) == true) goto L9;
        this.entryList = new ArrayList(this.maxArraySize);
        return;
    }

    private SortedMap<K, V> getOverflowEntriesMutable() {
        checkMutable();
        if (this.overflowEntries.isEmpty() == false) goto L8;
        if ((this.overflowEntries instanceof TreeMap) == true) goto L8;
        this.overflowEntries = new TreeMap();
    L8:
        return (SortedMap) this.overflowEntries;
    }

    public static <FieldDescriptorType extends FieldSet.FieldDescriptorLite<FieldDescriptorType>> SmallSortedMap<FieldDescriptorType, Object> newFieldMap(final int r5) {
        return (SmallSortedMap<FieldDescriptorType, Object>) new AnonymousClass1(r5);
    }

    public static <K extends Comparable<K>, V> SmallSortedMap<K, V> newInstanceForTest(int r5) {
        return new SmallSortedMap(r5);
    }

    private V removeArrayEntryAt(int r5) {
        checkMutable();
        V r10 = this.entryList.remove(r5).getValue();
        if (this.overflowEntries.isEmpty() == true) goto L5;
        Iterator<Map.Entry<K, V>> r11 = getOverflowEntriesMutable().entrySet().iterator();
        this.entryList.add(new Entry(this, r11.next()));
        r11.remove();
    L5:
        return r10;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        checkMutable();
        if (this.entryList.isEmpty() == true) goto L6;
        this.entryList.clear();
    L6:
        if (this.overflowEntries.isEmpty() == true) goto L9;
        this.overflowEntries.clear();
        return;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object r5) {
        Comparable r10 = (Comparable) r5;
        if (binarySearchInArray(r10) < 0) goto L5;
    L8:
        return true;
    L5:
        if (this.overflowEntries.containsKey(r10) == true) goto L8;
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.lazyEntrySet != null) goto L6;
        this.lazyEntrySet = new EntrySet(this, null);
    L6:
        return this.lazyEntrySet;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object r5) {
        Comparable r10 = (Comparable) r5;
        int r11 = binarySearchInArray(r10);
        if (r11 < 0) goto L7;
        return this.entryList.get(r11).getValue();
    L7:
        return this.overflowEntries.get(r10);
    }

    public Map.Entry<K, V> getArrayEntryAt(int r5) {
        return this.entryList.get(r5);
    }

    public int getNumArrayEntries() {
        return this.entryList.size();
    }

    public int getNumOverflowEntries() {
        return this.overflowEntries.size();
    }

    public Iterable<Map.Entry<K, V>> getOverflowEntries() {
        if (this.overflowEntries.isEmpty() == false) goto L6;
        return EmptySet.iterable();
    L6:
        return this.overflowEntries.entrySet();
    }

    public boolean isImmutable() {
        return this.isImmutable;
    }

    public void makeImmutable() {
        if (this.isImmutable == false) goto L5;
        return;
    L5:
        if (this.overflowEntries.isEmpty() == false) goto L7;
        Map<K, V> r5 = Collections.emptyMap();
    L8:
        this.overflowEntries = r5;
        this.isImmutable = true;
        return;
    L7:
        r5 = Collections.unmodifiableMap(this.overflowEntries);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public /* bridge */ /* synthetic */ Object put(Object r5, Object r10) {
        return put((Comparable) r5, r10);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object r5) {
        checkMutable();
        Comparable r10 = (Comparable) r5;
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
        int r5 = this.entryList.size();
        return this.overflowEntries.size() + r5;
    }

    private SmallSortedMap(int r5) {
        this.maxArraySize = r5;
        this.entryList = Collections.emptyList();
        this.overflowEntries = Collections.emptyMap();
    }

    public V put(K r5, V r10) {
        checkMutable();
        int r11 = binarySearchInArray(r5);
        if (r11 >= 0) goto L5;
        ensureEntryArrayMutable();
        int r12 = -(r11 + 1);
        if (r12 >= this.maxArraySize) goto L9;
        int r13 = this.entryList.size();
        int r14 = this.maxArraySize;
        if (r13 != r14) goto L13;
        SmallSortedMap<K, V>.Entry r15 = this.entryList.remove(r14 - 1);
        getOverflowEntriesMutable().put(r15.getKey(), r15.getValue());
    L13:
        this.entryList.add(r12, new Entry(this, r5, r10));
        return null;
    L9:
        return getOverflowEntriesMutable().put(r5, r10);
    L5:
        return this.entryList.get(r11).setValue(r10);
    }
}
