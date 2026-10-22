package org.apache.commons.collections4.map;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.keyvalue.DefaultMapEntry;

/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractReferenceMap<K, V> extends AbstractHashedMap<K, V> {
    private ReferenceStrength keyType;
    private boolean purgeValues;
    private transient ReferenceQueue<Object> queue;
    private ReferenceStrength valueType;

    static class ReferenceBaseIterator<K, V> {
        K currentKey;
        V currentValue;
        ReferenceEntry<K, V> entry;
        int expectedModCount;
        int index;
        K nextKey;
        V nextValue;
        final AbstractReferenceMap<K, V> parent;
        ReferenceEntry<K, V> previous;

        public ReferenceBaseIterator(AbstractReferenceMap<K, V> r2) {
            this.parent = r2;
            if (r2.size() == 0) goto L5;
            int r0 = r2.data.length;
        L6:
            this.index = r0;
            this.expectedModCount = r2.modCount;
            return;
        L5:
            r0 = 0;
            goto L6
        }

        private void checkMod() {
            if (this.parent.modCount != this.expectedModCount) goto L6;
            return;
        L6:
            throw new ConcurrentModificationException();
        }

        private boolean nextNull() {
            if (this.nextKey != null) goto L5;
        L8:
            return true;
        L5:
            if (this.nextValue == null) goto L8;
            return false;
        }

        public ReferenceEntry<K, V> currentEntry() {
            checkMod();
            return this.previous;
        }

        public boolean hasNext() {
            checkMod();
        L4:
            if (nextNull() == false) goto L16;
            ReferenceEntry<K, V> r0 = this.entry;
            int r1 = this.index;
        L6:
            if (r0 != null) goto L9;
            if (r1 <= 0) goto L9;
            r1 = r1 - 1;
            r0 = (ReferenceEntry) ZeusTransformUtils.preCheckCast(this.parent.data[r1], ReferenceEntry.class, "com.obric.memorydata.plugin");
        L9:
            this.entry = r0;
            this.index = r1;
            if (r0 == null) goto L11;
            this.nextKey = r0.getKey();
            this.nextValue = r0.getValue();
            if (nextNull() == false) goto L4;
            this.entry = this.entry.next();
            goto L4
        L11:
            this.currentKey = null;
            this.currentValue = null;
            return false;
        L16:
            return true;
        }

        public ReferenceEntry<K, V> nextEntry() {
            checkMod();
            if (nextNull() == true) goto L5;
        L9:
            ReferenceEntry<K, V> r0 = this.entry;
            this.previous = r0;
            this.entry = r0.next();
            this.currentKey = this.nextKey;
            this.currentValue = this.nextValue;
            this.nextKey = null;
            this.nextValue = null;
            return this.previous;
        L5:
            if (hasNext() == true) goto L9;
            throw new NoSuchElementException();
        }

        public void remove() {
            checkMod();
            if (this.previous == null) goto L7;
            this.parent.remove(this.currentKey);
            this.previous = null;
            this.currentKey = null;
            this.currentValue = null;
            this.expectedModCount = this.parent.modCount;
            return;
        L7:
            throw new IllegalStateException();
        }
    }

    protected static class ReferenceEntry<K, V> extends AbstractHashedMap.HashEntry<K, V> {
        private final AbstractReferenceMap<K, V> parent;

        public ReferenceEntry(AbstractReferenceMap<K, V> r2, AbstractHashedMap.HashEntry<K, V> r3, int r4, K r5, V r6) {
            super(r3, r4, null, null);
            this.parent = r2;
            this.key = toReference(AbstractReferenceMap.access$000(r2), r5, r4);
            this.value = toReference(AbstractReferenceMap.access$100(r2), r6, r4);
        }

        @Override // org.apache.commons.collections4.map.AbstractHashedMap.HashEntry, java.util.Map.Entry
        public boolean equals(Object r6) {
            if (r6 != this) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r6, Map.Entry.class) == true) goto L8;
            return false;
        L8:
            Map.Entry r7 = (Map.Entry) ZeusTransformUtils.preCheckCast(r6, Map.Entry.class, "com.obric.memorydata.plugin");
            Object r1 = r7.getKey();
            Object r8 = r7.getValue();
            if (r1 == null) goto L19;
            if (r8 == null) goto L19;
            if (this.parent.isEqualKey(r1, this.key) == false) goto L18;
            if (this.parent.isEqualValue(r8, getValue()) == false) goto L18;
            return true;
        L18:
            return false;
        L19:
            return false;
        }

        @Override // org.apache.commons.collections4.map.AbstractHashedMap.HashEntry, java.util.Map.Entry, org.apache.commons.collections4.KeyValue
        public K getKey() {
            ReferenceStrength r0 = AbstractReferenceMap.access$000(this.parent);
            ReferenceStrength r1 = ReferenceStrength.HARD;
            K r2 = (K) this.key;
            if (r0 != r1) goto L6;
            return r2;
        L6:
            return (K) ((Reference) ZeusTransformUtils.preCheckCast(r2, Reference.class, "com.obric.memorydata.plugin")).get();
        }

        @Override // org.apache.commons.collections4.map.AbstractHashedMap.HashEntry, java.util.Map.Entry, org.apache.commons.collections4.KeyValue
        public V getValue() {
            ReferenceStrength r0 = AbstractReferenceMap.access$100(this.parent);
            ReferenceStrength r1 = ReferenceStrength.HARD;
            V r2 = (V) this.value;
            if (r0 != r1) goto L6;
            return r2;
        L6:
            return (V) ((Reference) ZeusTransformUtils.preCheckCast(r2, Reference.class, "com.obric.memorydata.plugin")).get();
        }

        @Override // org.apache.commons.collections4.map.AbstractHashedMap.HashEntry, java.util.Map.Entry
        public int hashCode() {
            return this.parent.hashEntry(getKey(), getValue());
        }

        public ReferenceEntry<K, V> next() {
            return (ReferenceEntry) ZeusTransformUtils.preCheckCast(this.next, ReferenceEntry.class, "com.obric.memorydata.plugin");
        }

        public void nullValue() {
            this.value = null;
        }

        public void onPurge() {
        }

        public boolean purge(Reference<?> r5) {
            boolean r2 = true;
            if (AbstractReferenceMap.access$000(this.parent) != ReferenceStrength.HARD) goto L5;
        L7:
            boolean r0 = false;
        L8:
            if (r0 == false) goto L10;
        L15:
            if (r2 == true) goto L17;
        L25:
            return r2;
        L17:
            if (AbstractReferenceMap.access$000(this.parent) == ReferenceStrength.HARD) goto L20;
            ((Reference) ZeusTransformUtils.preCheckCast(this.key, Reference.class, "com.obric.memorydata.plugin")).clear();
        L20:
            if (AbstractReferenceMap.access$100(this.parent) == ReferenceStrength.HARD) goto L23;
            ((Reference) ZeusTransformUtils.preCheckCast(this.value, Reference.class, "com.obric.memorydata.plugin")).clear();
            goto L25
        L23:
            if (AbstractReferenceMap.access$300(this.parent) == false) goto L25;
            nullValue();
            goto L25
        L10:
            if (AbstractReferenceMap.access$100(this.parent) != ReferenceStrength.HARD) goto L12;
        L14:
            r2 = false;
            goto L15
        L12:
            if (this.value != r5) goto L14;
        L5:
            if (this.key != r5) goto L7;
            r0 = true;
            goto L8
        }

        @Override // org.apache.commons.collections4.map.AbstractHashedMap.HashEntry, java.util.Map.Entry
        public V setValue(V r5) {
            V r0 = getValue();
            if (AbstractReferenceMap.access$100(this.parent) == ReferenceStrength.HARD) goto L5;
            ((Reference) ZeusTransformUtils.preCheckCast(this.value, Reference.class, "com.obric.memorydata.plugin")).clear();
        L5:
            this.value = toReference(AbstractReferenceMap.access$100(this.parent), r5, this.hashCode);
            return r0;
        }

        public <T> Object toReference(ReferenceStrength r2, T r3, int r4) {
            if (r2 != ReferenceStrength.HARD) goto L6;
            return r3;
        L6:
            if (r2 != ReferenceStrength.SOFT) goto L10;
            return new SoftRef(r4, r3, AbstractReferenceMap.access$200(this.parent));
        L10:
            if (r2 != ReferenceStrength.WEAK) goto L14;
            return new WeakRef(r4, r3, AbstractReferenceMap.access$200(this.parent));
        L14:
            throw new Error();
        }
    }

    static class ReferenceEntrySet<K, V> extends AbstractHashedMap.EntrySet<K, V> {
        public ReferenceEntrySet(AbstractHashedMap<K, V> r1) {
            super(r1);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return toArray(new Object[size()]);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] r5) {
            ArrayList r0 = new ArrayList(size());
            Iterator<Map.Entry<K, V>> r4 = iterator();
        L4:
            if (r4.hasNext() == false) goto L7;
            r0.add(new DefaultMapEntry((Map.Entry) ZeusTransformUtils.preCheckCast(r4.next(), Map.Entry.class, "com.obric.memorydata.plugin")));
            goto L4
        L7:
            return (T[]) r0.toArray(r5);
        }
    }

    static class ReferenceEntrySetIterator<K, V> extends ReferenceBaseIterator<K, V> implements Iterator<Map.Entry<K, V>> {
        public ReferenceEntrySetIterator(AbstractReferenceMap<K, V> r1) {
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

    static class ReferenceKeySet<K> extends AbstractHashedMap.KeySet<K> {
        public ReferenceKeySet(AbstractHashedMap<K, ?> r1) {
            super(r1);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return toArray(new Object[size()]);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] r3) {
            ArrayList r0 = new ArrayList(size());
            Iterator<K> r2 = iterator();
        L4:
            if (r2.hasNext() == false) goto L7;
            r0.add(r2.next());
            goto L4
        L7:
            return (T[]) r0.toArray(r3);
        }
    }

    static class ReferenceKeySetIterator<K> extends ReferenceBaseIterator<K, Object> implements Iterator<K> {
        ReferenceKeySetIterator(AbstractReferenceMap<K, ?> r1) {
            super(r1);
        }

        @Override // java.util.Iterator
        public K next() {
            return nextEntry().getKey();
        }
    }

    static class ReferenceMapIterator<K, V> extends ReferenceBaseIterator<K, V> implements MapIterator<K, V> {
        public ReferenceMapIterator(AbstractReferenceMap<K, V> r1) {
            super(r1);
        }

        @Override // org.apache.commons.collections4.MapIterator
        public V getValue() {
            ReferenceEntry<K, V> r1 = currentEntry();
            if (r1 == null) goto L7;
            return r1.getValue();
        L7:
            throw new IllegalStateException("getValue() can only be called after next() and before remove()");
        }

        @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
        public K next() {
            return nextEntry().getKey();
        }
    }

    public static final enum ReferenceStrength extends Enum<ReferenceStrength> {
        private static final /* synthetic */ ReferenceStrength[] $VALUES = null;
        public static final ReferenceStrength HARD = null;
        public static final ReferenceStrength SOFT = null;
        public static final ReferenceStrength WEAK = null;
        public final int value;

        static {
            ReferenceStrength r0 = new ReferenceStrength("HARD", 0, 0);
            HARD = r0;
            ReferenceStrength r1 = new ReferenceStrength("SOFT", 1, 1);
            SOFT = r1;
            ReferenceStrength r3 = new ReferenceStrength("WEAK", 2, 2);
            WEAK = r3;
            $VALUES = new ReferenceStrength[]{r0, r1, r3};
        }

        private ReferenceStrength(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }

        public static ReferenceStrength resolve(int r1) {
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L12;
            if (r1 != 2) goto L10;
            return WEAK;
        L10:
            throw new IllegalArgumentException();
        L12:
            return SOFT;
        L14:
            return HARD;
        }

        public static ReferenceStrength valueOf(String r2) {
            return (ReferenceStrength) ZeusTransformUtils.preCheckCast(Enum.valueOf(ReferenceStrength.class, r2), ReferenceStrength.class, "com.obric.memorydata.plugin");
        }

        public static ReferenceStrength[] values() {
            return (ReferenceStrength[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ReferenceStrength[].class, "com.obric.memorydata.plugin");
        }
    }

    static class ReferenceValues<V> extends AbstractHashedMap.Values<V> {
        public ReferenceValues(AbstractHashedMap<?, V> r1) {
            super(r1);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray() {
            return toArray(new Object[size()]);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public <T> T[] toArray(T[] r3) {
            ArrayList r0 = new ArrayList(size());
            Iterator<V> r2 = iterator();
        L4:
            if (r2.hasNext() == false) goto L7;
            r0.add(r2.next());
            goto L4
        L7:
            return (T[]) r0.toArray(r3);
        }
    }

    static class ReferenceValuesIterator<V> extends ReferenceBaseIterator<Object, V> implements Iterator<V> {
        ReferenceValuesIterator(AbstractReferenceMap<?, V> r1) {
            super(r1);
        }

        @Override // java.util.Iterator
        public V next() {
            return nextEntry().getValue();
        }
    }

    static class SoftRef<T> extends SoftReference<T> {
        private final int hash;

        public SoftRef(int r1, T r2, ReferenceQueue<? super T> r3) {
            super(r2, r3);
            this.hash = r1;
        }

        public int hashCode() {
            return this.hash;
        }
    }

    static class WeakRef<T> extends WeakReference<T> {
        private final int hash;

        public WeakRef(int r1, T r2, ReferenceQueue<? super T> r3) {
            super(r2, r3);
            this.hash = r1;
        }

        public int hashCode() {
            return this.hash;
        }
    }

    public AbstractReferenceMap() {
    }

    public AbstractReferenceMap(ReferenceStrength r1, ReferenceStrength r2, int r3, float r4, boolean r5) {
        super(r3, r4);
        this.keyType = r1;
        this.valueType = r2;
        this.purgeValues = r5;
    }

    static /* synthetic */ ReferenceStrength access$000(AbstractReferenceMap r0) {
        return r0.keyType;
    }

    static /* synthetic */ ReferenceStrength access$100(AbstractReferenceMap r0) {
        return r0.valueType;
    }

    static /* synthetic */ ReferenceQueue access$200(AbstractReferenceMap r0) {
        return r0.queue;
    }

    static /* synthetic */ boolean access$300(AbstractReferenceMap r0) {
        return r0.purgeValues;
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap, java.util.AbstractMap, java.util.Map
    public void clear() {
        super.clear();
    L4:
        if (this.queue.poll() != null) goto L4;
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap, java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object r1) {
        purgeBeforeRead();
        AbstractHashedMap.HashEntry<K, V> r0 = getEntry(r1);
        if (r0 != null) goto L6;
        return false;
    L6:
        if (r0.getValue() == null) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap, java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object r1) {
        purgeBeforeRead();
        if (r1 != null) goto L7;
        return false;
    L7:
        return super.containsValue(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    public /* bridge */ /* synthetic */ AbstractHashedMap.HashEntry createEntry(AbstractHashedMap.HashEntry r1, int r2, Object r3, Object r4) {
        return createEntry(r1, r2, r3, r4);
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    public ReferenceEntry<K, V> createEntry(AbstractHashedMap.HashEntry<K, V> r8, int r9, K r10, V r11) {
        return new ReferenceEntry(this, r8, r9, r10, r11);
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    public Iterator<Map.Entry<K, V>> createEntrySetIterator() {
        return new ReferenceEntrySetIterator(this);
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    public Iterator<K> createKeySetIterator() {
        return new ReferenceKeySetIterator(this);
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    public Iterator<V> createValuesIterator() {
        return new ReferenceValuesIterator(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    public void doReadObject(ObjectInputStream r3) {
        this.keyType = ReferenceStrength.resolve(r3.readInt());
        this.valueType = ReferenceStrength.resolve(r3.readInt());
        this.purgeValues = r3.readBoolean();
        this.loadFactor = r3.readFloat();
        int r0 = r3.readInt();
        init();
        this.data = new AbstractHashedMap.HashEntry[r0];
        this.threshold = calculateThreshold(this.data.length, this.loadFactor);
    L3:
        Object r1 = r3.readObject();
        if (r1 == null) goto L5;
        put(r1, r3.readObject());
        goto L3
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    public void doWriteObject(ObjectOutputStream r2) {
        r2.writeInt(this.keyType.value);
        r2.writeInt(this.valueType.value);
        r2.writeBoolean(this.purgeValues);
        r2.writeFloat(this.loadFactor);
        r2.writeInt(this.data.length);
        MapIterator<K, V> r1 = mapIterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r2.writeObject(r1.next());
        r2.writeObject(r1.getValue());
        goto L4
    L6:
        r2.writeObject(null);
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap, java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.entrySet != null) goto L6;
        this.entrySet = new ReferenceEntrySet(this);
    L6:
        return this.entrySet;
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap, java.util.AbstractMap, java.util.Map
    public V get(Object r1) {
        purgeBeforeRead();
        AbstractHashedMap.HashEntry<K, V> r0 = getEntry(r1);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getValue();
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    public AbstractHashedMap.HashEntry<K, V> getEntry(Object r1) {
        if (r1 != null) goto L6;
        return null;
    L6:
        return super.getEntry(r1);
    }

    public int hashEntry(Object r1, Object r2) {
        int r0 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        if (r2 == null) goto L10;
        r0 = r2.hashCode();
    L10:
        return r0 ^ r3;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    public void init() {
        this.queue = new ReferenceQueue();
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap, java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        purgeBeforeRead();
        return super.isEmpty();
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    public boolean isEqualKey(Object r2, Object r3) {
        if (this.keyType == ReferenceStrength.HARD) goto L6;
        r3 = ((Reference) ZeusTransformUtils.preCheckCast(r3, Reference.class, "com.obric.memorydata.plugin")).get();
    L6:
        if (r2 != r3) goto L8;
    L11:
        return true;
    L8:
        if (r2.equals(r3) == true) goto L11;
        return false;
    }

    public boolean isKeyType(ReferenceStrength r1) {
        if (this.keyType != r1) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isValueType(ReferenceStrength r1) {
        if (this.valueType != r1) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap, java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        if (this.keySet != null) goto L6;
        this.keySet = new ReferenceKeySet(this);
    L6:
        return this.keySet;
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap, org.apache.commons.collections4.IterableGet
    public MapIterator<K, V> mapIterator() {
        return new ReferenceMapIterator(this);
    }

    public void purge() {
    L2:
        Reference<? extends Object> r0 = this.queue.poll();
        if (r0 == null) goto L5;
        purge(r0);
        goto L2
    }

    public void purge(Reference<?> r7) {
        int r0 = hashIndex(r7.hashCode(), this.data.length);
        AbstractHashedMap.HashEntry<K, V> r1 = this.data[r0];
        AbstractHashedMap.HashEntry<K, V> r2 = null;
    L3:
        if (r1 == null) goto L12;
        ReferenceEntry r3 = (ReferenceEntry) ZeusTransformUtils.preCheckCast(r1, ReferenceEntry.class, "com.obric.memorydata.plugin");
        if (r3.purge(r7) == true) goto L6;
        r2 = r1;
        r1 = r1.next;
        goto L3
    L6:
        if (r2 != null) goto L8;
        this.data[r0] = r1.next;
    L9:
        this.size--;
        r3.onPurge();
        return;
    L8:
        r2.next = r1.next;
        goto L9
    }

    public void purgeBeforeRead() {
        purge();
    }

    public void purgeBeforeWrite() {
        purge();
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap, java.util.AbstractMap, java.util.Map
    public V put(K r2, V r3) {
        Objects.requireNonNull(r2, "null keys not allowed");
        Objects.requireNonNull(r3, "null values not allowed");
        purgeBeforeWrite();
        return (V) super.put(r2, r3);
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap, java.util.AbstractMap, java.util.Map
    public V remove(Object r1) {
        if (r1 != null) goto L5;
        return null;
    L5:
        purgeBeforeWrite();
        return (V) super.remove(r1);
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap, java.util.AbstractMap, java.util.Map
    public int size() {
        purgeBeforeRead();
        return super.size();
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap, java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        if (this.values != null) goto L6;
        this.values = new ReferenceValues(this);
    L6:
        return this.values;
    }
}
