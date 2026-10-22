package org.apache.commons.collections4.map;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import org.apache.commons.collections4.IterableMap;
import org.apache.commons.collections4.KeyValue;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.iterators.EmptyIterator;
import org.apache.commons.collections4.iterators.EmptyMapIterator;

/* JADX INFO: loaded from: classes6.dex */
public class AbstractHashedMap<K, V> extends AbstractMap<K, V> implements IterableMap<K, V> {
    protected static final int DEFAULT_CAPACITY = 16;
    protected static final float DEFAULT_LOAD_FACTOR = 0.75f;
    protected static final int DEFAULT_THRESHOLD = 12;
    protected static final String GETKEY_INVALID = "getKey() can only be called after next() and before remove()";
    protected static final String GETVALUE_INVALID = "getValue() can only be called after next() and before remove()";
    protected static final int MAXIMUM_CAPACITY = 1073741824;
    protected static final String NO_NEXT_ENTRY = "No next() entry in the iteration";
    protected static final String NO_PREVIOUS_ENTRY = "No previous() entry in the iteration";
    protected static final Object NULL = null;
    protected static final String REMOVE_INVALID = "remove() can only be called once after next()";
    protected static final String SETVALUE_INVALID = "setValue() can only be called after next() and before remove()";
    transient HashEntry<K, V>[] data;
    transient EntrySet<K, V> entrySet;
    transient KeySet<K> keySet;
    transient float loadFactor;
    transient int modCount;
    transient int size;
    transient int threshold;
    transient Values<V> values;

    protected static class EntrySet<K, V> extends AbstractSet<Map.Entry<K, V>> {
        private final AbstractHashedMap<K, V> parent;

        public EntrySet(AbstractHashedMap<K, V> r1) {
            this.parent = r1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.parent.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r4) {
            if (ZeusTransformUtils.instanceOf(r4, Map.Entry.class) == false) goto L10;
            Map.Entry r5 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4, Map.Entry.class, "com.obric.memorydata.plugin");
            HashEntry<K, V> r3 = this.parent.getEntry(r5.getKey());
            if (r3 != null) goto L7;
            return false;
        L7:
            if (r3.equals(r5) == false) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return this.parent.createEntrySetIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, Map.Entry.class) == true) goto L6;
            return false;
        L6:
            if (contains(r3) == true) goto L8;
            return false;
        L8:
            Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3, Map.Entry.class, "com.obric.memorydata.plugin");
            this.parent.remove(r4.getKey());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.parent.size();
        }
    }

    protected static class EntrySetIterator<K, V> extends HashIterator<K, V> implements Iterator<Map.Entry<K, V>> {
        public EntrySetIterator(AbstractHashedMap<K, V> r1) {
            super(r1);
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return next();
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            return super.nextEntry();
        }
    }

    protected static class HashEntry<K, V> implements Map.Entry<K, V>, KeyValue<K, V> {
        protected int hashCode;
        protected Object key;
        protected HashEntry<K, V> next;
        protected Object value;

        public HashEntry(HashEntry<K, V> r1, int r2, Object r3, V r4) {
            this.next = r1;
            this.hashCode = r2;
            this.key = r3;
            this.value = r4;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object r5) {
            if (r5 != this) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, Map.Entry.class) == true) goto L8;
            return false;
        L8:
            Map.Entry r6 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5, Map.Entry.class, "com.obric.memorydata.plugin");
            if (getKey() != null) goto L14;
            if (r6.getKey() == null) goto L16;
        L24:
            return false;
        L16:
            if (getValue() != null) goto L21;
            if (r6.getValue() != null) goto L24;
            return true;
        L21:
            if (getValue().equals(r6.getValue()) == false) goto L24;
            return true;
        L14:
            if (getKey().equals(r6.getKey()) == false) goto L24;
            goto L24
        }

        @Override // java.util.Map.Entry, org.apache.commons.collections4.KeyValue
        public K getKey() {
            if (this.key != AbstractHashedMap.NULL) goto L7;
            return null;
        L7:
            return (K) this.key;
        }

        @Override // java.util.Map.Entry, org.apache.commons.collections4.KeyValue
        public V getValue() {
            return (V) this.value;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            int r1 = 0;
            if (getKey() != null) goto L5;
            int r0 = 0;
        L7:
            if (getValue() == null) goto L11;
            r1 = getValue().hashCode();
        L11:
            return r0 ^ r1;
        L5:
            r0 = getKey().hashCode();
            goto L7
        }

        @Override // java.util.Map.Entry
        public V setValue(V r2) {
            V r0 = (V) this.value;
            this.value = r2;
            return r0;
        }

        public String toString() {
            return new StringBuilder().append(getKey()).append('=').append(getValue()).toString();
        }
    }

    protected static abstract class HashIterator<K, V> {
        private int expectedModCount;
        private int hashIndex;
        private HashEntry<K, V> last;
        private HashEntry<K, V> next;
        private final AbstractHashedMap<K, V> parent;

        public HashIterator(AbstractHashedMap<K, V> r4) {
            this.parent = r4;
            HashEntry<K, V>[] r0 = r4.data;
            int r1 = r0.length;
            HashEntry<K, V> r2 = null;
        L3:
            if (r1 <= 0) goto L6;
            if (r2 != null) goto L6;
            r1 = r1 - 1;
            r2 = r0[r1];
        L6:
            this.next = r2;
            this.hashIndex = r1;
            this.expectedModCount = r4.modCount;
        }

        public HashEntry<K, V> currentEntry() {
            return this.last;
        }

        public boolean hasNext() {
            if (this.next == null) goto L5;
            return true;
        L5:
            return false;
        }

        public HashEntry<K, V> nextEntry() {
            if (this.parent.modCount != this.expectedModCount) goto L15;
            HashEntry<K, V> r0 = this.next;
            if (r0 == null) goto L13;
            HashEntry<K, V>[] r1 = this.parent.data;
            int r2 = this.hashIndex;
            HashEntry<K, V> r3 = r0.next;
        L7:
            if (r3 != null) goto L10;
            if (r2 <= 0) goto L10;
            r2 = r2 - 1;
            r3 = r1[r2];
        L10:
            this.next = r3;
            this.hashIndex = r2;
            this.last = r0;
            return r0;
        L13:
            throw new NoSuchElementException(AbstractHashedMap.NO_NEXT_ENTRY);
        L15:
            throw new ConcurrentModificationException();
        }

        public void remove() {
            if (this.last == null) goto L11;
            if (this.parent.modCount != this.expectedModCount) goto L9;
            this.parent.remove(this.last.getKey());
            this.last = null;
            this.expectedModCount = this.parent.modCount;
            return;
        L9:
            throw new ConcurrentModificationException();
        L11:
            throw new IllegalStateException(AbstractHashedMap.REMOVE_INVALID);
        }

        public String toString() {
            if (this.last != null) goto L5;
            return "Iterator[]";
        L5:
            return "Iterator[" + this.last.getKey() + "=" + this.last.getValue() + "]";
        }
    }

    protected static class HashMapIterator<K, V> extends HashIterator<K, V> implements MapIterator<K, V> {
        public HashMapIterator(AbstractHashedMap<K, V> r1) {
            super(r1);
        }

        @Override // org.apache.commons.collections4.MapIterator
        public V getValue() {
            HashEntry<K, V> r1 = currentEntry();
            if (r1 == null) goto L7;
            return r1.getValue();
        L7:
            throw new IllegalStateException(AbstractHashedMap.GETVALUE_INVALID);
        }

        @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
        public K next() {
            return super.nextEntry().getKey();
        }
    }

    protected static class KeySet<K> extends AbstractSet<K> {
        private final AbstractHashedMap<K, ?> parent;

        public KeySet(AbstractHashedMap<K, ?> r1) {
            this.parent = r1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.parent.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r1) {
            return this.parent.containsKey(r1);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return this.parent.createKeySetIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object r2) {
            boolean r0 = this.parent.containsKey(r2);
            this.parent.remove(r2);
            return r0;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.parent.size();
        }
    }

    protected static class KeySetIterator<K> extends HashIterator<K, Object> implements Iterator<K> {
        public KeySetIterator(AbstractHashedMap<K, ?> r1) {
            super(r1);
        }

        @Override // java.util.Iterator
        public K next() {
            return super.nextEntry().getKey();
        }
    }

    protected static class Values<V> extends AbstractCollection<V> {
        private final AbstractHashedMap<?, V> parent;

        public Values(AbstractHashedMap<?, V> r1) {
            this.parent = r1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            this.parent.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object r1) {
            return this.parent.containsValue(r1);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return this.parent.createValuesIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.parent.size();
        }
    }

    protected static class ValuesIterator<V> extends HashIterator<Object, V> implements Iterator<V> {
        public ValuesIterator(AbstractHashedMap<?, V> r1) {
            super(r1);
        }

        @Override // java.util.Iterator
        public V next() {
            return super.nextEntry().getValue();
        }
    }

    static {
        NULL = new Object();
    }

    public AbstractHashedMap() {
    }

    public AbstractHashedMap(int r2) {
        this(r2, 0.75f);
    }

    public AbstractHashedMap(int r2, float r3) {
        if (r2 < 0) goto L13;
        if (r3 <= 0.0f) goto L11;
        if (Float.isNaN(r3) == true) goto L11;
        this.loadFactor = r3;
        int r4 = calculateNewCapacity(r2);
        this.threshold = calculateThreshold(r4, r3);
        this.data = new HashEntry[r4];
        init();
        return;
    L11:
        throw new IllegalArgumentException("Load factor must be greater than 0");
    L13:
        throw new IllegalArgumentException("Initial capacity must be a non negative number");
    }

    public AbstractHashedMap(int r1, float r2, int r3) {
        this.loadFactor = r2;
        this.data = new HashEntry[r1];
        this.threshold = r3;
        init();
    }

    public AbstractHashedMap(Map<? extends K, ? extends V> r3) {
        Map<? extends K, ? extends V> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        this(Math.max(r4.size() * 2, 16), 0.75f);
        _putAll(r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void _putAll(Map<? extends K, ? extends V> r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        int r0 = r5.size();
        if (r0 != 0) goto L5;
        return;
    L5:
        ensureCapacity(calculateNewCapacity((int) (((this.size + r0) / this.loadFactor) + 1.0f)));
        Iterator<Map.Entry<K, V>> r6 = r5.entrySet().iterator();
    L7:
        if (r6.hasNext() == false) goto L9;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r6.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        put(r1.getKey(), r1.getValue());
        goto L7
    }

    public void addEntry(HashEntry<K, V> r1, int r2) {
        this.data[r2] = r1;
    }

    public void addMapping(int r2, int r3, K r4, V r5) {
        this.modCount++;
        addEntry(createEntry(this.data[r2], r3, r4, r5), r2);
        this.size++;
        checkCapacity();
    }

    public int calculateNewCapacity(int r2) {
        if (r2 > 1073741824) goto L13;
        int r0 = 1;
    L6:
        if (r0 >= r2) goto L8;
        r0 = r0 << 1;
        goto L6
    L8:
        if (r0 <= 1073741824) goto L11;
        return 1073741824;
    L11:
        return r0;
    L13:
        return 1073741824;
    }

    public int calculateThreshold(int r1, float r2) {
        return (int) (r1 * r2);
    }

    public void checkCapacity() {
        if (this.size < this.threshold) goto L8;
        int r0 = this.data.length * 2;
        if (r0 > 1073741824) goto L9;
        ensureCapacity(r0);
        return;
    L9:
        return;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.modCount++;
        HashEntry<K, V>[] r0 = this.data;
        int r1 = r0.length - 1;
    L3:
        if (r1 < 0) goto L5;
        r0[r1] = null;
        r1 = r1 - 1;
        goto L3
    L5:
        this.size = 0;
    }

    @Override // java.util.AbstractMap
    public /* bridge */ /* synthetic */ Object clone() {
        return clone();
    }

    @Override // java.util.AbstractMap
    public AbstractHashedMap<K, V> clone() {
        AbstractHashedMap<K, V> r0 = (AbstractHashedMap) ZeusTransformUtils.preCheckCast(super.clone(), AbstractHashedMap.class, "com.obric.memorydata.plugin");     // Catch: CloneNotSupportedException -> L4
        r0.data = new HashEntry[this.data.length];     // Catch: CloneNotSupportedException -> L4
        r0.entrySet = null;     // Catch: CloneNotSupportedException -> L4
        r0.keySet = null;     // Catch: CloneNotSupportedException -> L4
        r0.values = null;     // Catch: CloneNotSupportedException -> L4
        r0.modCount = 0;     // Catch: CloneNotSupportedException -> L4
        r0.size = 0;     // Catch: CloneNotSupportedException -> L4
        r0.init();     // Catch: CloneNotSupportedException -> L4
        r0.putAll(this);     // Catch: CloneNotSupportedException -> L4
        return r0;
    L5:
        throw new InternalError();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object r4) {
        Object r5 = convertKey(r4);
        int r0 = hash(r5);
        HashEntry<K, V>[] r1 = this.data;
        HashEntry<K, V> r2 = r1[hashIndex(r0, r1.length)];
    L3:
        if (r2 == null) goto L11;
        if (r2.hashCode != r0) goto L10;
        if (isEqualKey(r5, r2.key) == false) goto L10;
        return true;
    L10:
        r2 = r2.next;
        goto L3
    L11:
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object r8) {
        if (r8 != null) goto L13;
        HashEntry<K, V>[] r7 = this.data;
        int r9 = r7.length;
        int r2 = 0;
    L5:
        if (r2 >= r9) goto L22;
        HashEntry<K, V> r3 = r7[r2];
    L7:
        if (r3 == null) goto L12;
        if (r3.getValue() == null) goto L10;
        r3 = r3.next;
        goto L7
    L10:
        return true;
    L12:
        r2 = r2 + 1;
    L22:
        return false;
    L13:
        HashEntry<K, V>[] r4 = this.data;
        int r5 = r4.length;
        int r6 = 0;
    L14:
        if (r6 >= r5) goto L22;
        HashEntry<K, V> r10 = r4[r6];
    L16:
        if (r10 == null) goto L21;
        if (isEqualValue(r8, r10.getValue()) == true) goto L19;
        r10 = r10.next;
        goto L16
    L19:
        return true;
    L21:
        r6 = r6 + 1;
        goto L14
    }

    public Object convertKey(Object r1) {
        if (r1 == null) goto L4;
        return r1;
    L4:
        return NULL;
    }

    public HashEntry<K, V> createEntry(HashEntry<K, V> r2, int r3, K r4, V r5) {
        return new HashEntry(r2, r3, convertKey(r4), r5);
    }

    public Iterator<Map.Entry<K, V>> createEntrySetIterator() {
        if (size() != 0) goto L7;
        return EmptyIterator.emptyIterator();
    L7:
        return new EntrySetIterator(this);
    }

    public Iterator<K> createKeySetIterator() {
        if (size() != 0) goto L7;
        return EmptyIterator.emptyIterator();
    L7:
        return new KeySetIterator(this);
    }

    public Iterator<V> createValuesIterator() {
        if (size() != 0) goto L7;
        return EmptyIterator.emptyIterator();
    L7:
        return new ValuesIterator(this);
    }

    public void destroyEntry(HashEntry<K, V> r1) {
        r1.next = null;
        r1.key = null;
        r1.value = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void doReadObject(ObjectInputStream r5) {
        this.loadFactor = r5.readFloat();
        int r0 = r5.readInt();
        int r1 = r5.readInt();
        init();
        this.threshold = calculateThreshold(r0, this.loadFactor);
        this.data = new HashEntry[r0];
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        put(r5.readObject(), r5.readObject());
        r2 = r2 + 1;
        goto L3
    }

    public void doWriteObject(ObjectOutputStream r2) {
        r2.writeFloat(this.loadFactor);
        r2.writeInt(this.data.length);
        r2.writeInt(this.size);
        MapIterator<K, V> r1 = mapIterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r2.writeObject(r1.next());
        r2.writeObject(r1.getValue());
        goto L4
    }

    public void ensureCapacity(int r8) {
        HashEntry<K, V>[] r0 = this.data;
        int r1 = r0.length;
        if (r8 > r1) goto L6;
        return;
    L6:
        if (this.size != 0) goto L8;
        this.threshold = calculateThreshold(r8, this.loadFactor);
        this.data = new HashEntry[r8];
        return;
    L8:
        HashEntry<K, V>[] r2 = new HashEntry[r8];
        this.modCount++;
        int r3 = r1 - 1;
    L9:
        if (r3 < 0) goto L18;
        HashEntry<K, V> r4 = r0[r3];
        if (r4 == null) goto L17;
        r0[r3] = null;
    L13:
        HashEntry<K, V> r5 = r4.next;
        int r6 = hashIndex(r4.hashCode, r8);
        r4.next = r2[r6];
        r2[r6] = r4;
        if (r5 == null) goto L17;
        r4 = r5;
    L17:
        r3 = r3 - 1;
        goto L9
    L18:
        this.threshold = calculateThreshold(r8, this.loadFactor);
        this.data = r2;
    }

    public int entryHashCode(HashEntry<K, V> r1) {
        return r1.hashCode;
    }

    public K entryKey(HashEntry<K, V> r1) {
        return r1.getKey();
    }

    public HashEntry<K, V> entryNext(HashEntry<K, V> r1) {
        return r1.next;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.entrySet != null) goto L6;
        this.entrySet = new EntrySet(this);
    L6:
        return this.entrySet;
    }

    public V entryValue(HashEntry<K, V> r1) {
        return r1.getValue();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, Map.class) == true) goto L8;
        return false;
    L8:
        Map r6 = (Map) ZeusTransformUtils.preCheckCast(r5, Map.class, "com.obric.memorydata.plugin");
        if (r6.size() == size()) goto L11;
        return false;
    L11:
        MapIterator<K, V> r4 = mapIterator();
    L26:
        if (r4.hasNext() == false) goto L24;
        K r1 = r4.next();     // Catch: Throwable -> L25
        V r3 = r4.getValue();     // Catch: Throwable -> L25
        if (r3 == null) goto L17;
        if (r3.equals(r6.get(r1)) == true) goto L26;
        return false;
    L17:
        if (r6.get(r1) != null) goto L20;
        if (r6.containsKey(r1) == true) goto L26;
    L20:
        return false;
    L24:
        return true;
    L25:
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object r4) {
        Object r5 = convertKey(r4);
        int r0 = hash(r5);
        HashEntry<K, V>[] r1 = this.data;
        HashEntry<K, V> r2 = r1[hashIndex(r0, r1.length)];
    L3:
        if (r2 == null) goto L11;
        if (r2.hashCode != r0) goto L10;
        if (isEqualKey(r5, r2.key) == false) goto L10;
        return r2.getValue();
    L10:
        r2 = r2.next;
        goto L3
    L11:
        return null;
    }

    public HashEntry<K, V> getEntry(Object r4) {
        Object r5 = convertKey(r4);
        int r0 = hash(r5);
        HashEntry<K, V>[] r1 = this.data;
        HashEntry<K, V> r2 = r1[hashIndex(r0, r1.length)];
    L3:
        if (r2 == null) goto L10;
        if (r2.hashCode != r0) goto L9;
        if (isEqualKey(r5, r2.key) == false) goto L9;
        return r2;
    L9:
        r2 = r2.next;
        goto L3
    L10:
        return null;
    }

    public int hash(Object r1) {
        int r0 = r1.hashCode();
        int r2 = r0 + (~(r0 << 9));
        int r3 = r2 ^ (r2 >>> 14);
        int r4 = r3 + (r3 << 4);
        return r4 ^ (r4 >>> 10);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        Iterator<Map.Entry<K, V>> r4 = createEntrySetIterator();
        int r0 = 0;
    L4:
        if (r4.hasNext() == false) goto L6;
        r0 = r0 + ((Map.Entry) ZeusTransformUtils.preCheckCast(r4.next(), Map.Entry.class, "com.obric.memorydata.plugin")).hashCode();
        goto L4
    L6:
        return r0;
    }

    public int hashIndex(int r1, int r2) {
        return r1 & (r2 - 1);
    }

    public void init() {
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        if (this.size != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isEqualKey(Object r1, Object r2) {
        if (r1 != r2) goto L4;
    L7:
        return true;
    L4:
        if (r1.equals(r2) == true) goto L7;
        return false;
    }

    public boolean isEqualValue(Object r1, Object r2) {
        if (r1 != r2) goto L4;
    L7:
        return true;
    L4:
        if (r1.equals(r2) == true) goto L7;
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        if (this.keySet != null) goto L6;
        this.keySet = new KeySet(this);
    L6:
        return this.keySet;
    }

    @Override // org.apache.commons.collections4.IterableGet
    public MapIterator<K, V> mapIterator() {
        if (this.size != 0) goto L7;
        return EmptyMapIterator.emptyMapIterator();
    L7:
        return new HashMapIterator(this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K r6, V r7) {
        Object r0 = convertKey(r6);
        int r1 = hash(r0);
        int r2 = hashIndex(r1, this.data.length);
        HashEntry<K, V> r3 = this.data[r2];
    L3:
        if (r3 == null) goto L11;
        if (r3.hashCode != r1) goto L10;
        if (isEqualKey(r0, r3.key) == false) goto L10;
        V r8 = r3.getValue();
        updateEntry(r3, r7);
        return r8;
    L10:
        r3 = r3.next;
        goto L3
    L11:
        addMapping(r2, r1, r6, r7);
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> r3) {
        _putAll((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin"));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object r8) {
        Object r9 = convertKey(r8);
        int r0 = hash(r9);
        int r1 = hashIndex(r0, this.data.length);
        HashEntry<K, V> r2 = this.data[r1];
        HashEntry<K, V> r4 = null;
    L3:
        if (r2 == null) goto L11;
        if (r2.hashCode != r0) goto L10;
        if (isEqualKey(r9, r2.key) == false) goto L10;
        V r10 = r2.getValue();
        removeMapping(r2, r1, r4);
        return r10;
    L10:
        r4 = r2;
        r2 = r2.next;
        goto L3
    L11:
        return null;
    }

    public void removeEntry(HashEntry<K, V> r1, int r2, HashEntry<K, V> r3) {
        if (r3 != null) goto L4;
        this.data[r2] = r1.next;
        return;
    L4:
        r3.next = r1.next;
    }

    public void removeMapping(HashEntry<K, V> r2, int r3, HashEntry<K, V> r4) {
        this.modCount++;
        removeEntry(r2, r3, r4);
        this.size--;
        destroyEntry(r2);
    }

    public void reuseEntry(HashEntry<K, V> r1, int r2, int r3, K r4, V r5) {
        r1.next = this.data[r2];
        r1.hashCode = r3;
        r1.key = r4;
        r1.value = r5;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }

    @Override // java.util.AbstractMap
    public String toString() {
        if (size() != 0) goto L6;
        return "{}";
    L6:
        StringBuilder r0 = new StringBuilder(size() * 32);
        r0.append('{');
        MapIterator<K, V> r1 = mapIterator();
        boolean r3 = r1.hasNext();
    L7:
        if (r3 == false) goto L17;
        Object r4 = r1.next();
        Object r5 = r1.getValue();
        if (r4 != this) goto L11;
        r4 = "(this Map)";
    L11:
        StringBuilder r6 = r0.append(r4).append('=');
        if (r5 != this) goto L14;
        r5 = "(this Map)";
    L14:
        r6.append(r5);
        r3 = r1.hasNext();
        if (r3 == false) goto L7;
        r0.append(',').append(' ');
        goto L7
    L17:
        r0.append('}');
        return r0.toString();
    }

    public void updateEntry(HashEntry<K, V> r1, V r2) {
        r1.setValue(r2);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        if (this.values != null) goto L6;
        this.values = new Values(this);
    L6:
        return this.values;
    }
}
