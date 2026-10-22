package org.apache.commons.collections4.map;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import org.apache.commons.collections4.IterableMap;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.ResettableIterator;
import org.apache.commons.collections4.iterators.EmptyIterator;
import org.apache.commons.collections4.iterators.EmptyMapIterator;

/* JADX INFO: loaded from: classes6.dex */
public class Flat3Map<K, V> implements Serializable, Cloneable, IterableMap<K, V> {
    private static final long serialVersionUID = -6701087419741928296L;
    private transient AbstractHashedMap<K, V> delegateMap;
    private transient int hash1;
    private transient int hash2;
    private transient int hash3;
    private transient K key1;
    private transient K key2;
    private transient K key3;
    private transient int size;
    private transient V value1;
    private transient V value2;
    private transient V value3;

    static abstract class EntryIterator<K, V> {
        private FlatMapEntry<K, V> currentEntry;
        private int nextIndex;
        private final Flat3Map<K, V> parent;

        public EntryIterator(Flat3Map<K, V> r2) {
            this.nextIndex = 0;
            this.currentEntry = null;
            this.parent = r2;
        }

        public boolean hasNext() {
            if (this.nextIndex >= Flat3Map.access$000(this.parent)) goto L5;
            return true;
        L5:
            return false;
        }

        public Map.Entry<K, V> nextEntry() {
            if (hasNext() == false) goto L7;
            Flat3Map<K, V> r1 = this.parent;
            int r2 = this.nextIndex + 1;
            this.nextIndex = r2;
            FlatMapEntry<K, V> r0 = new FlatMapEntry(r1, r2);
            this.currentEntry = r0;
            return r0;
        L7:
            throw new NoSuchElementException("No next() entry in the iteration");
        }

        public void remove() {
            FlatMapEntry<K, V> r0 = this.currentEntry;
            if (r0 == null) goto L7;
            r0.setRemoved(true);
            this.parent.remove(this.currentEntry.getKey());
            this.nextIndex--;
            this.currentEntry = null;
            return;
        L7:
            throw new IllegalStateException("remove() can only be called once after next()");
        }
    }

    static class EntrySet<K, V> extends AbstractSet<Map.Entry<K, V>> {
        private final Flat3Map<K, V> parent;

        EntrySet(Flat3Map<K, V> r1) {
            this.parent = r1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.parent.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            if (Flat3Map.access$700(this.parent) == null) goto L7;
            return Flat3Map.access$700(this.parent).entrySet().iterator();
        L7:
            if (this.parent.size() != 0) goto L11;
            return EmptyIterator.emptyIterator();
        L11:
            return new EntrySetIterator(this.parent);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, Map.Entry.class) == true) goto L6;
            return false;
        L6:
            Object r4 = ((Map.Entry) ZeusTransformUtils.preCheckCast(r3, Map.Entry.class, "com.obric.memorydata.plugin")).getKey();
            boolean r0 = this.parent.containsKey(r4);
            this.parent.remove(r4);
            return r0;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.parent.size();
        }
    }

    static class EntrySetIterator<K, V> extends EntryIterator<K, V> implements Iterator<Map.Entry<K, V>> {
        EntrySetIterator(Flat3Map<K, V> r1) {
            super(r1);
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return next();
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            return nextEntry();
        }
    }

    static class FlatMapEntry<K, V> implements Map.Entry<K, V> {
        private final int index;
        private final Flat3Map<K, V> parent;
        private volatile boolean removed;

        public FlatMapEntry(Flat3Map<K, V> r1, int r2) {
            this.parent = r1;
            this.index = r2;
            this.removed = false;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object r4) {
            if (this.removed == false) goto L6;
            return false;
        L6:
            if (ZeusTransformUtils.instanceOf(r4, Map.Entry.class) == true) goto L8;
            return false;
        L8:
            Map.Entry r5 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4, Map.Entry.class, "com.obric.memorydata.plugin");
            K r0 = getKey();
            V r3 = getValue();
            if (r0 != null) goto L14;
            if (r5.getKey() != null) goto L23;
        L15:
            if (r3 != null) goto L20;
            if (r5.getValue() != null) goto L25;
        L21:
            return true;
        L25:
            return false;
        L20:
            if (r3.equals(r5.getValue()) == true) goto L21;
            return false;
        L23:
            return false;
        L14:
            if (r0.equals(r5.getKey()) == true) goto L15;
            return false;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            if (this.removed == true) goto L19;
            int r0 = this.index;
            if (r0 == 1) goto L17;
            if (r0 == 2) goto L15;
            if (r0 != 3) goto L13;
            return (K) Flat3Map.access$100(this.parent);
        L13:
            throw new IllegalStateException("Invalid map index: " + this.index);
        L15:
            return (K) Flat3Map.access$200(this.parent);
        L17:
            return (K) Flat3Map.access$300(this.parent);
        L19:
            throw new IllegalStateException("getKey() can only be called after next() and before remove()");
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            if (this.removed == true) goto L19;
            int r0 = this.index;
            if (r0 == 1) goto L17;
            if (r0 == 2) goto L15;
            if (r0 != 3) goto L13;
            return (V) Flat3Map.access$400(this.parent);
        L13:
            throw new IllegalStateException("Invalid map index: " + this.index);
        L15:
            return (V) Flat3Map.access$500(this.parent);
        L17:
            return (V) Flat3Map.access$600(this.parent);
        L19:
            throw new IllegalStateException("getValue() can only be called after next() and before remove()");
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            int r1 = 0;
            if (this.removed == false) goto L5;
            return 0;
        L5:
            K r0 = getKey();
            V r2 = getValue();
            if (r0 != null) goto L8;
            int r3 = 0;
        L9:
            if (r2 == null) goto L13;
            r1 = r2.hashCode();
        L13:
            return r3 ^ r1;
        L8:
            r3 = r0.hashCode();
            goto L9
        }

        void setRemoved(boolean r1) {
            this.removed = r1;
        }

        @Override // java.util.Map.Entry
        public V setValue(V r4) {
            if (this.removed == true) goto L17;
            V r0 = getValue();
            int r1 = this.index;
            if (r1 != 1) goto L7;
            Flat3Map.access$602(this.parent, r4);
        L15:
            return r0;
        L7:
            if (r1 != 2) goto L9;
            Flat3Map.access$502(this.parent, r4);
            goto L15
        L9:
            if (r1 != 3) goto L12;
            Flat3Map.access$402(this.parent, r4);
            goto L15
        L12:
            throw new IllegalStateException("Invalid map index: " + this.index);
        L17:
            throw new IllegalStateException("setValue() can only be called after next() and before remove()");
        }

        public String toString() {
            if (this.removed == false) goto L5;
            return "";
        L5:
            return getKey() + "=" + getValue();
        }
    }

    static class FlatMapIterator<K, V> implements MapIterator<K, V>, ResettableIterator<K> {
        private boolean canRemove;
        private int nextIndex;
        private final Flat3Map<K, V> parent;

        FlatMapIterator(Flat3Map<K, V> r2) {
            this.nextIndex = 0;
            this.canRemove = false;
            this.parent = r2;
        }

        public K getKey() {
            if (this.canRemove == false) goto L19;
            int r0 = this.nextIndex;
            if (r0 == 1) goto L17;
            if (r0 == 2) goto L15;
            if (r0 != 3) goto L13;
            return (K) Flat3Map.access$100(this.parent);
        L13:
            throw new IllegalStateException("Invalid map index: " + this.nextIndex);
        L15:
            return (K) Flat3Map.access$200(this.parent);
        L17:
            return (K) Flat3Map.access$300(this.parent);
        L19:
            throw new IllegalStateException("getKey() can only be called after next() and before remove()");
        }

        @Override // org.apache.commons.collections4.MapIterator
        public V getValue() {
            if (this.canRemove == false) goto L19;
            int r0 = this.nextIndex;
            if (r0 == 1) goto L17;
            if (r0 == 2) goto L15;
            if (r0 != 3) goto L13;
            return (V) Flat3Map.access$400(this.parent);
        L13:
            throw new IllegalStateException("Invalid map index: " + this.nextIndex);
        L15:
            return (V) Flat3Map.access$500(this.parent);
        L17:
            return (V) Flat3Map.access$600(this.parent);
        L19:
            throw new IllegalStateException("getValue() can only be called after next() and before remove()");
        }

        @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
        public boolean hasNext() {
            if (this.nextIndex >= Flat3Map.access$000(this.parent)) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
        public K next() {
            if (hasNext() == false) goto L7;
            this.canRemove = true;
            this.nextIndex++;
            return getKey();
        L7:
            throw new NoSuchElementException("No next() entry in the iteration");
        }

        @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
        public void remove() {
            if (this.canRemove == false) goto L7;
            this.parent.remove(getKey());
            this.nextIndex--;
            this.canRemove = false;
            return;
        L7:
            throw new IllegalStateException("remove() can only be called once after next()");
        }

        public String toString() {
            if (this.canRemove == true) goto L5;
            return "Iterator[]";
        L5:
            return "Iterator[" + getKey() + "=" + getValue() + "]";
        }
    }

    static class KeySet<K> extends AbstractSet<K> {
        private final Flat3Map<K, ?> parent;

        KeySet(Flat3Map<K, ?> r1) {
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
            if (Flat3Map.access$700(this.parent) == null) goto L7;
            return Flat3Map.access$700(this.parent).keySet().iterator();
        L7:
            if (this.parent.size() != 0) goto L11;
            return EmptyIterator.emptyIterator();
        L11:
            return new KeySetIterator(this.parent);
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

    static class KeySetIterator<K> extends EntryIterator<K, Object> implements Iterator<K> {
        KeySetIterator(Flat3Map<K, ?> r1) {
            super(r1);
        }

        @Override // java.util.Iterator
        public K next() {
            return nextEntry().getKey();
        }
    }

    static class Values<V> extends AbstractCollection<V> {
        private final Flat3Map<?, V> parent;

        Values(Flat3Map<?, V> r1) {
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
            if (Flat3Map.access$700(this.parent) == null) goto L7;
            return Flat3Map.access$700(this.parent).values().iterator();
        L7:
            if (this.parent.size() != 0) goto L11;
            return EmptyIterator.emptyIterator();
        L11:
            return new ValuesIterator(this.parent);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.parent.size();
        }
    }

    static class ValuesIterator<V> extends EntryIterator<Object, V> implements Iterator<V> {
        ValuesIterator(Flat3Map<?, V> r1) {
            super(r1);
        }

        @Override // java.util.Iterator
        public V next() {
            return nextEntry().getValue();
        }
    }

    public Flat3Map() {
    }

    public Flat3Map(Map<? extends K, ? extends V> r3) {
        putAll((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ int access$000(Flat3Map r0) {
        return r0.size;
    }

    static /* synthetic */ Object access$100(Flat3Map r0) {
        return r0.key3;
    }

    static /* synthetic */ Object access$200(Flat3Map r0) {
        return r0.key2;
    }

    static /* synthetic */ Object access$300(Flat3Map r0) {
        return r0.key1;
    }

    static /* synthetic */ Object access$400(Flat3Map r0) {
        return r0.value3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ Object access$402(Flat3Map r0, Object r1) {
        r0.value3 = r1;
        return r1;
    }

    static /* synthetic */ Object access$500(Flat3Map r0) {
        return r0.value2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ Object access$502(Flat3Map r0, Object r1) {
        r0.value2 = r1;
        return r1;
    }

    static /* synthetic */ Object access$600(Flat3Map r0) {
        return r0.value1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ Object access$602(Flat3Map r0, Object r1) {
        r0.value1 = r1;
        return r1;
    }

    static /* synthetic */ AbstractHashedMap access$700(Flat3Map r0) {
        return r0.delegateMap;
    }

    private void convertToMap() {
        AbstractHashedMap<K, V> r0 = createDelegateMap();
        this.delegateMap = r0;
        int r1 = this.size;
        if (r1 != 0) goto L5;
    L15:
        this.size = 0;
        this.hash3 = 0;
        this.hash2 = 0;
        this.hash1 = 0;
        this.key3 = null;
        this.key2 = null;
        this.key1 = null;
        this.value3 = null;
        this.value2 = null;
        this.value1 = null;
        return;
    L5:
        if (r1 != 1) goto L7;
    L14:
        this.delegateMap.put(this.key1, this.value1);
        goto L15
    L7:
        if (r1 != 2) goto L9;
    L13:
        this.delegateMap.put(this.key2, this.value2);
        goto L14
    L9:
        if (r1 != 3) goto L12;
        r0.put(this.key3, this.value3);
        goto L13
    L12:
        throw new IllegalStateException("Invalid map index: " + this.size);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream r4) {
        r4.defaultReadObject();
        int r0 = r4.readInt();
        if (r0 <= 3) goto L5;
        this.delegateMap = createDelegateMap();
    L5:
        if (r0 <= 0) goto L7;
        put(r4.readObject(), r4.readObject());
        r0 = r0 - 1;
        goto L5
    }

    private void writeObject(ObjectOutputStream r2) {
        r2.defaultWriteObject();
        r2.writeInt(size());
        MapIterator<K, V> r1 = mapIterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r2.writeObject(r1.next());
        r2.writeObject(r1.getValue());
        goto L4
    }

    @Override // java.util.Map
    public void clear() {
        AbstractHashedMap<K, V> r0 = this.delegateMap;
        if (r0 == null) goto L5;
        r0.clear();
        this.delegateMap = null;
        return;
    L5:
        this.size = 0;
        this.hash3 = 0;
        this.hash2 = 0;
        this.hash1 = 0;
        this.key3 = null;
        this.key2 = null;
        this.key1 = null;
        this.value3 = null;
        this.value2 = null;
        this.value1 = null;
    }

    public /* bridge */ /* synthetic */ Object clone() {
        return m3070clone();
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public Flat3Map<K, V> m3070clone() {
        Flat3Map<K, V> r2 = (Flat3Map) ZeusTransformUtils.preCheckCast(super.clone(), Flat3Map.class, "com.obric.memorydata.plugin");     // Catch: CloneNotSupportedException -> L6
        AbstractHashedMap<K, V> r0 = r2.delegateMap;     // Catch: CloneNotSupportedException -> L6
        if (r0 == null) goto L5;
        r2.delegateMap = r0.clone();     // Catch: CloneNotSupportedException -> L6
    L5:
        return r2;
    L7:
        throw new InternalError();
    }

    @Override // java.util.Map
    public boolean containsKey(Object r6) {
        AbstractHashedMap<K, V> r0 = this.delegateMap;
        if (r0 == null) goto L7;
        return r0.containsKey(r6);
    L7:
        if (r6 != null) goto L23;
        int r7 = this.size;
        if (r7 == 1) goto L20;
        if (r7 == 2) goto L17;
        if (r7 == 3) goto L14;
        return false;
    L14:
        if (this.key3 != null) goto L17;
        return true;
    L17:
        if (this.key2 != null) goto L20;
        return true;
    L20:
        if (this.key1 != null) goto L44;
        return true;
    L44:
        return false;
    L23:
        if (this.size <= 0) goto L46;
        int r3 = r6.hashCode();
        int r4 = this.size;
        if (r4 == 1) goto L40;
        if (r4 == 2) goto L35;
        if (r4 == 3) goto L30;
        return false;
    L30:
        if (this.hash3 != r3) goto L35;
        if (r6.equals(this.key3) == false) goto L35;
        return true;
    L35:
        if (this.hash2 != r3) goto L40;
        if (r6.equals(this.key2) == false) goto L40;
        return true;
    L40:
        if (this.hash1 == r3) goto L42;
        return false;
    L42:
        if (r6.equals(this.key1) == false) goto L48;
        return true;
    L48:
        return false;
    L46:
        return false;
    }

    @Override // java.util.Map
    public boolean containsValue(Object r5) {
        AbstractHashedMap<K, V> r0 = this.delegateMap;
        if (r0 == null) goto L7;
        return r0.containsValue(r5);
    L7:
        if (r5 != null) goto L22;
        int r6 = this.size;
        if (r6 == 1) goto L20;
        if (r6 == 2) goto L17;
        if (r6 == 3) goto L14;
        return false;
    L14:
        if (this.value3 != null) goto L17;
        return true;
    L17:
        if (this.value2 != null) goto L20;
        return true;
    L20:
        if (this.value1 != null) goto L36;
        return true;
    L36:
        return false;
    L22:
        int r3 = this.size;
        if (r3 == 1) goto L34;
        if (r3 == 2) goto L31;
        if (r3 == 3) goto L28;
        return false;
    L28:
        if (r5.equals(this.value3) == false) goto L31;
        return true;
    L31:
        if (r5.equals(this.value2) == false) goto L34;
        return true;
    L34:
        if (r5.equals(this.value1) == false) goto L38;
        return true;
    L38:
        return false;
    }

    public AbstractHashedMap<K, V> createDelegateMap() {
        return new HashedMap();
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        AbstractHashedMap<K, V> r0 = this.delegateMap;
        if (r0 == null) goto L7;
        return r0.entrySet();
    L7:
        return new EntrySet(this);
    }

    @Override // java.util.Map
    public boolean equals(Object r5) {
        if (r5 != this) goto L5;
        return true;
    L5:
        AbstractHashedMap<K, V> r1 = this.delegateMap;
        if (r1 == null) goto L10;
        return r1.equals(r5);
    L10:
        if (ZeusTransformUtils.instanceOf(r5, Map.class) == true) goto L12;
        return false;
    L12:
        Map r6 = (Map) ZeusTransformUtils.preCheckCast(r5, Map.class, "com.obric.memorydata.plugin");
        if (this.size == r6.size()) goto L15;
        return false;
    L15:
        int r2 = this.size;
        if (r2 <= 0) goto L53;
        if (r2 == 1) goto L44;
        if (r2 == 2) goto L34;
        if (r2 != 3) goto L53;
        if (r6.containsKey(this.key3) == true) goto L26;
        return false;
    L26:
        Object r3 = r6.get(this.key3);
        V r4 = this.value3;
        if (r4 != null) goto L31;
        if (r3 == null) goto L34;
    L32:
        return false;
    L31:
        if (r4.equals(r3) == false) goto L32;
    L34:
        if (r6.containsKey(this.key2) == true) goto L36;
        return false;
    L36:
        Object r7 = r6.get(this.key2);
        V r8 = this.value2;
        if (r8 != null) goto L41;
        if (r7 == null) goto L44;
    L42:
        return false;
    L41:
        if (r8.equals(r7) == false) goto L42;
    L44:
        if (r6.containsKey(this.key1) == true) goto L46;
        return false;
    L46:
        Object r9 = r6.get(this.key1);
        V r10 = this.value1;
        if (r10 != null) goto L51;
        if (r9 == null) goto L53;
    L52:
        return false;
    L51:
        if (r10.equals(r9) == false) goto L52;
    L53:
        return true;
    }

    @Override // java.util.Map
    public V get(Object r6) {
        AbstractHashedMap<K, V> r0 = this.delegateMap;
        if (r0 == null) goto L7;
        return r0.get(r6);
    L7:
        if (r6 != null) goto L26;
        int r7 = this.size;
        if (r7 == 1) goto L22;
        if (r7 == 2) goto L18;
        if (r7 == 3) goto L14;
        return null;
    L14:
        if (this.key3 != null) goto L18;
        return this.value3;
    L18:
        if (this.key2 != null) goto L22;
        return this.value2;
    L22:
        if (this.key1 == null) goto L24;
        return null;
    L24:
        return this.value1;
    L26:
        if (this.size <= 0) goto L52;
        int r3 = r6.hashCode();
        int r4 = this.size;
        if (r4 == 1) goto L45;
        if (r4 == 2) goto L39;
        if (r4 == 3) goto L33;
        return null;
    L33:
        if (this.hash3 != r3) goto L39;
        if (r6.equals(this.key3) == false) goto L39;
        return this.value3;
    L39:
        if (this.hash2 != r3) goto L45;
        if (r6.equals(this.key2) == false) goto L45;
        return this.value2;
    L45:
        if (this.hash1 == r3) goto L47;
        return null;
    L47:
        if (r6.equals(this.key1) == true) goto L49;
        return null;
    L49:
        return this.value1;
    L52:
        return null;
    }

    @Override // java.util.Map
    public int hashCode() {
        AbstractHashedMap<K, V> r0 = this.delegateMap;
        if (r0 != null) goto L5;
        int r1 = this.size;
        int r2 = 0;
        if (r1 != 0) goto L9;
        return 0;
    L9:
        if (r1 != 1) goto L11;
        int r3 = 0;
    L28:
        int r4 = this.hash1;
        V r5 = this.value1;
        if (r5 == null) goto L33;
        r2 = r5.hashCode();
    L33:
        return r3 + (r4 ^ r2);
    L11:
        if (r1 != 2) goto L13;
        int r6 = 0;
    L22:
        int r7 = this.hash2;
        V r8 = this.value2;
        if (r8 != null) goto L25;
        int r9 = 0;
    L26:
        r3 = r6 + (r7 ^ r9);
        goto L28
    L25:
        r9 = r8.hashCode();
        goto L26
    L13:
        if (r1 != 3) goto L20;
        int r10 = this.hash3;
        V r11 = this.value3;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        r6 = (r10 ^ r12) + 0;
        goto L22
    L17:
        r12 = r11.hashCode();
        goto L18
    L20:
        throw new IllegalStateException("Invalid map index: " + this.size);
    L5:
        return r0.hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        if (size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        AbstractHashedMap<K, V> r0 = this.delegateMap;
        if (r0 == null) goto L7;
        return r0.keySet();
    L7:
        return new KeySet(this);
    }

    @Override // org.apache.commons.collections4.IterableGet
    public MapIterator<K, V> mapIterator() {
        AbstractHashedMap<K, V> r0 = this.delegateMap;
        if (r0 == null) goto L7;
        return r0.mapIterator();
    L7:
        if (this.size != 0) goto L11;
        return EmptyMapIterator.emptyMapIterator();
    L11:
        return new FlatMapIterator(this);
    }

    @Override // java.util.Map
    public V put(K r6, V r7) {
        AbstractHashedMap<K, V> r0 = this.delegateMap;
        if (r0 != null) goto L5;
        int r3 = this.size;
        if (r6 != null) goto L24;
        if (r3 == 1) goto L21;
        if (r3 == 2) goto L17;
        if (r3 == 3) goto L13;
    L48:
        int r1 = this.size;
        int r4 = 0;
        if (r1 == 0) goto L62;
        if (r1 == 1) goto L58;
        if (r1 == 2) goto L54;
        convertToMap();
        this.delegateMap.put(r6, r7);
        return null;
    L54:
        if (r6 == null) goto L57;
        r4 = r6.hashCode();
    L57:
        this.hash3 = r4;
        this.key3 = r6;
        this.value3 = r7;
    L66:
        this.size++;
        return null;
    L58:
        if (r6 == null) goto L61;
        r4 = r6.hashCode();
    L61:
        this.hash2 = r4;
        this.key2 = r6;
        this.value2 = r7;
        goto L66
    L62:
        if (r6 == null) goto L65;
        r4 = r6.hashCode();
    L65:
        this.hash1 = r4;
        this.key1 = r6;
        this.value1 = r7;
        goto L66
    L13:
        if (this.key3 != null) goto L17;
        V r8 = this.value3;
        this.value3 = r7;
        return r8;
    L17:
        if (this.key2 != null) goto L21;
        V r9 = this.value2;
        this.value2 = r7;
        return r9;
    L21:
        if (this.key1 != null) goto L48;
        V r10 = this.value1;
        this.value1 = r7;
        return r10;
    L24:
        if (r3 <= 0) goto L48;
        int r5 = r6.hashCode();
        int r11 = this.size;
        if (r11 == 1) goto L43;
        if (r11 == 2) goto L37;
        if (r11 != 3) goto L48;
        if (this.hash3 != r5) goto L37;
        if (r6.equals(this.key3) == false) goto L37;
        V r12 = this.value3;
        this.value3 = r7;
        return r12;
    L37:
        if (this.hash2 != r5) goto L43;
        if (r6.equals(this.key2) == false) goto L43;
        V r13 = this.value2;
        this.value2 = r7;
        return r13;
    L43:
        if (this.hash1 != r5) goto L48;
        if (r6.equals(this.key1) == false) goto L48;
        V r14 = this.value1;
        this.value1 = r7;
        return r14;
    L5:
        return r0.put(r6, r7);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> r4) {
        Map<? extends K, ? extends V> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        int r0 = r5.size();
        if (r0 != 0) goto L5;
        return;
    L5:
        AbstractHashedMap<K, V> r2 = this.delegateMap;
        if (r2 == null) goto L10;
        r2.putAll(r5);
        return;
    L10:
        if (r0 >= 4) goto L15;
        Iterator<Map.Entry<K, V>> r6 = r5.entrySet().iterator();
    L13:
        if (r6.hasNext() == false) goto L18;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r6.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        put(r1.getKey(), r1.getValue());
        goto L13
    L18:
        return;
    L15:
        convertToMap();
        this.delegateMap.putAll(r5);
    }

    @Override // java.util.Map
    public V remove(Object r8) {
        AbstractHashedMap<K, V> r0 = this.delegateMap;
        if (r0 != null) goto L5;
        int r1 = this.size;
        if (r1 != 0) goto L10;
        return null;
    L10:
        if (r8 != null) goto L41;
        if (r1 == 1) goto L38;
        if (r1 == 2) goto L28;
        if (r1 != 3) goto L85;
        K r9 = this.key3;
        if (r9 != null) goto L20;
        V r10 = this.value3;
        this.hash3 = 0;
        this.key3 = null;
        this.value3 = null;
        this.size = 2;
        return r10;
    L20:
        if (this.key2 != null) goto L24;
        V r2 = this.value2;
        this.hash2 = this.hash3;
        this.key2 = r9;
        this.value2 = this.value3;
        this.hash3 = 0;
        this.key3 = null;
        this.value3 = null;
        this.size = 2;
        return r2;
    L24:
        if (this.key1 != null) goto L27;
        V r3 = this.value1;
        this.hash1 = this.hash3;
        this.key1 = r9;
        this.value1 = this.value3;
        this.hash3 = 0;
        this.key3 = null;
        this.value3 = null;
        this.size = 2;
        return r3;
    L27:
        return null;
    L85:
        return null;
    L28:
        K r11 = this.key2;
        if (r11 != null) goto L33;
        V r12 = this.value2;
        this.hash2 = 0;
        this.key2 = null;
        this.value2 = null;
        this.size = 1;
        return r12;
    L33:
        if (this.key1 != null) goto L36;
        V r4 = this.value1;
        this.hash1 = this.hash2;
        this.key1 = r11;
        this.value1 = this.value2;
        this.hash2 = 0;
        this.key2 = null;
        this.value2 = null;
        this.size = 1;
        return r4;
    L36:
        return null;
    L38:
        if (this.key1 != null) goto L85;
        V r13 = this.value1;
        this.hash1 = 0;
        this.key1 = null;
        this.value1 = null;
        this.size = 0;
        return r13;
    L41:
        if (r1 <= 0) goto L85;
        int r5 = r8.hashCode();
        int r6 = this.size;
        if (r6 == 1) goto L80;
        if (r6 == 2) goto L67;
        if (r6 != 3) goto L85;
        if (this.hash3 != r5) goto L54;
        if (r8.equals(this.key3) == false) goto L54;
        V r14 = this.value3;
        this.hash3 = 0;
        this.key3 = null;
        this.value3 = null;
        this.size = 2;
        return r14;
    L54:
        if (this.hash2 != r5) goto L60;
        if (r8.equals(this.key2) == false) goto L60;
        V r15 = this.value2;
        this.hash2 = this.hash3;
        this.key2 = this.key3;
        this.value2 = this.value3;
        this.hash3 = 0;
        this.key3 = null;
        this.value3 = null;
        this.size = 2;
        return r15;
    L60:
        if (this.hash1 == r5) goto L62;
    L65:
        return null;
    L62:
        if (r8.equals(this.key1) == false) goto L65;
        V r16 = this.value1;
        this.hash1 = this.hash3;
        this.key1 = this.key3;
        this.value1 = this.value3;
        this.hash3 = 0;
        this.key3 = null;
        this.value3 = null;
        this.size = 2;
        return r16;
    L67:
        if (this.hash2 != r5) goto L73;
        if (r8.equals(this.key2) == false) goto L73;
        V r17 = this.value2;
        this.hash2 = 0;
        this.key2 = null;
        this.value2 = null;
        this.size = 1;
        return r17;
    L73:
        if (this.hash1 == r5) goto L75;
    L78:
        return null;
    L75:
        if (r8.equals(this.key1) == false) goto L78;
        V r18 = this.value1;
        this.hash1 = this.hash2;
        this.key1 = this.key2;
        this.value1 = this.value2;
        this.hash2 = 0;
        this.key2 = null;
        this.value2 = null;
        this.size = 1;
        return r18;
    L80:
        if (this.hash1 != r5) goto L85;
        if (r8.equals(this.key1) == false) goto L85;
        V r19 = this.value1;
        this.hash1 = 0;
        this.key1 = null;
        this.value1 = null;
        this.size = 0;
        return r19;
    L5:
        return r0.remove(r8);
    }

    @Override // java.util.Map
    public int size() {
        AbstractHashedMap<K, V> r0 = this.delegateMap;
        if (r0 == null) goto L7;
        return r0.size();
    L7:
        return this.size;
    }

    public String toString() {
        AbstractHashedMap<K, V> r0 = this.delegateMap;
        if (r0 == null) goto L7;
        return r0.toString();
    L7:
        if (this.size != 0) goto L10;
        return "{}";
    L10:
        StringBuilder r1 = new StringBuilder(128);
        r1.append('{');
        int r2 = this.size;
        Object r4 = "(this Map)";
        if (r2 != 1) goto L13;
    L32:
        Object r3 = this.key1;
        if (r3 != this) goto L35;
        r3 = "(this Map)";
    L35:
        r1.append(r3);
        r1.append('=');
        V r5 = this.value1;
        if (r5 == this) goto L39;
        r4 = r5;
    L39:
        r1.append(r4);
        r1.append('}');
        return r1.toString();
    L13:
        if (r2 != 2) goto L15;
    L25:
        Object r6 = this.key2;
        if (r6 != this) goto L28;
        r6 = "(this Map)";
    L28:
        r1.append(r6);
        r1.append('=');
        Object r7 = this.value2;
        if (r7 != this) goto L31;
        r7 = "(this Map)";
    L31:
        r1.append(r7);
        r1.append(',');
        goto L32
    L15:
        if (r2 != 3) goto L24;
        Object r8 = this.key3;
        if (r8 != this) goto L19;
        r8 = "(this Map)";
    L19:
        r1.append(r8);
        r1.append('=');
        Object r9 = this.value3;
        if (r9 != this) goto L22;
        r9 = "(this Map)";
    L22:
        r1.append(r9);
        r1.append(',');
        goto L25
    L24:
        throw new IllegalStateException("Invalid map index: " + this.size);
    }

    @Override // java.util.Map
    public Collection<V> values() {
        AbstractHashedMap<K, V> r0 = this.delegateMap;
        if (r0 == null) goto L7;
        return r0.values();
    L7:
        return new Values(this);
    }
}
