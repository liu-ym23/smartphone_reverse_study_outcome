package org.apache.commons.collections4.map;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.OrderedIterator;
import org.apache.commons.collections4.OrderedMap;
import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.ResettableIterator;
import org.apache.commons.collections4.iterators.EmptyOrderedIterator;
import org.apache.commons.collections4.iterators.EmptyOrderedMapIterator;

/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractLinkedMap<K, V> extends AbstractHashedMap<K, V> implements OrderedMap<K, V> {
    transient LinkEntry<K, V> header;

    protected static class EntrySetIterator<K, V> extends LinkIterator<K, V> implements OrderedIterator<Map.Entry<K, V>>, ResettableIterator<Map.Entry<K, V>> {
        public EntrySetIterator(AbstractLinkedMap<K, V> r1) {
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

    protected static class KeySetIterator<K> extends LinkIterator<K, Object> implements OrderedIterator<K>, ResettableIterator<K> {
        public KeySetIterator(AbstractLinkedMap<K, ?> r1) {
            super(r1);
        }

        @Override // java.util.Iterator
        public K next() {
            return super.nextEntry().getKey();
        }
    }

    protected static class LinkEntry<K, V> extends AbstractHashedMap.HashEntry<K, V> {
        protected LinkEntry<K, V> after;
        protected LinkEntry<K, V> before;

        public LinkEntry(AbstractHashedMap.HashEntry<K, V> r1, int r2, Object r3, V r4) {
            super(r1, r2, r3, r4);
        }
    }

    protected static abstract class LinkIterator<K, V> {
        protected int expectedModCount;
        protected LinkEntry<K, V> last;
        protected LinkEntry<K, V> next;
        protected final AbstractLinkedMap<K, V> parent;

        public LinkIterator(AbstractLinkedMap<K, V> r2) {
            this.parent = r2;
            this.next = r2.header.after;
            this.expectedModCount = r2.modCount;
        }

        public LinkEntry<K, V> currentEntry() {
            return this.last;
        }

        public boolean hasNext() {
            if (this.next == this.parent.header) goto L5;
            return true;
        L5:
            return false;
        }

        public LinkEntry<K, V> nextEntry() {
            if (this.parent.modCount != this.expectedModCount) goto L11;
            if (this.next == this.parent.header) goto L9;
            LinkEntry<K, V> r0 = this.next;
            this.last = r0;
            this.next = r0.after;
            return this.last;
        L9:
            throw new NoSuchElementException("No next() entry in the iteration");
        L11:
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
            throw new IllegalStateException("remove() can only be called once after next()");
        }

        public String toString() {
            if (this.last != null) goto L5;
            return "Iterator[]";
        L5:
            return "Iterator[" + this.last.getKey() + "=" + this.last.getValue() + "]";
        }
    }

    protected static class LinkMapIterator<K, V> extends LinkIterator<K, V> implements OrderedMapIterator<K, V>, ResettableIterator<K> {
        public LinkMapIterator(AbstractLinkedMap<K, V> r1) {
            super(r1);
        }

        @Override // org.apache.commons.collections4.MapIterator
        public V getValue() {
            LinkEntry<K, V> r1 = currentEntry();
            if (r1 == null) goto L7;
            return r1.getValue();
        L7:
            throw new IllegalStateException("getValue() can only be called after next() and before remove()");
        }

        @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
        public K next() {
            return super.nextEntry().getKey();
        }
    }

    protected static class ValuesIterator<V> extends LinkIterator<Object, V> implements OrderedIterator<V>, ResettableIterator<V> {
        public ValuesIterator(AbstractLinkedMap<?, V> r1) {
            super(r1);
        }

        @Override // java.util.Iterator
        public V next() {
            return super.nextEntry().getValue();
        }
    }

    public AbstractLinkedMap() {
    }

    public AbstractLinkedMap(int r1) {
        super(r1);
    }

    public AbstractLinkedMap(int r1, float r2) {
        super(r1, r2);
    }

    public AbstractLinkedMap(int r1, float r2, int r3) {
        super(r1, r2, r3);
    }

    public AbstractLinkedMap(Map<? extends K, ? extends V> r3) {
        super((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    public void addEntry(AbstractHashedMap.HashEntry<K, V> r3, int r4) {
        LinkEntry<K, V> r5 = (LinkEntry) ZeusTransformUtils.preCheckCast(r3, LinkEntry.class, "com.obric.memorydata.plugin");
        r5.after = this.header;
        r5.before = this.header.before;
        this.header.before.after = r5;
        this.header.before = r5;
        this.data[r4] = r5;
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap, java.util.AbstractMap, java.util.Map
    public void clear() {
        super.clear();
        LinkEntry<K, V> r0 = this.header;
        r0.after = r0;
        r0.before = r0;
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap, java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object r4) {
        if (r4 != null) goto L10;
        LinkEntry<K, V> r5 = this.header;
    L5:
        r5 = r5.after;
        if (r5 == this.header) goto L16;
        if (r5.getValue() != null) goto L5;
        return true;
    L16:
        return false;
    L10:
        LinkEntry<K, V> r1 = this.header;
    L11:
        r1 = r1.after;
        if (r1 == this.header) goto L24;
        if (isEqualValue(r4, r1.getValue()) == false) goto L11;
        return true;
    L24:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    public /* bridge */ /* synthetic */ AbstractHashedMap.HashEntry createEntry(AbstractHashedMap.HashEntry r1, int r2, Object r3, Object r4) {
        return createEntry(r1, r2, r3, r4);
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    public LinkEntry<K, V> createEntry(AbstractHashedMap.HashEntry<K, V> r2, int r3, K r4, V r5) {
        return new LinkEntry(r2, r3, convertKey(r4), r5);
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    public Iterator<Map.Entry<K, V>> createEntrySetIterator() {
        if (size() != 0) goto L7;
        return EmptyOrderedIterator.emptyOrderedIterator();
    L7:
        return new EntrySetIterator(this);
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    public Iterator<K> createKeySetIterator() {
        if (size() != 0) goto L7;
        return EmptyOrderedIterator.emptyOrderedIterator();
    L7:
        return new KeySetIterator(this);
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    public Iterator<V> createValuesIterator() {
        if (size() != 0) goto L7;
        return EmptyOrderedIterator.emptyOrderedIterator();
    L7:
        return new ValuesIterator(this);
    }

    public LinkEntry<K, V> entryAfter(LinkEntry<K, V> r1) {
        return r1.after;
    }

    public LinkEntry<K, V> entryBefore(LinkEntry<K, V> r1) {
        return r1.before;
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K firstKey() {
        if (this.size == 0) goto L7;
        return this.header.after.getKey();
    L7:
        throw new NoSuchElementException("Map is empty");
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    public /* bridge */ /* synthetic */ AbstractHashedMap.HashEntry getEntry(Object r1) {
        return getEntry(r1);
    }

    public LinkEntry<K, V> getEntry(int r4) {
        if (r4 < 0) goto L19;
        if (r4 >= this.size) goto L17;
        if (r4 >= (this.size / 2)) goto L11;
        LinkEntry<K, V> r3 = this.header.after;
        int r0 = 0;
    L9:
        if (r0 >= r4) goto L22;
        r3 = r3.after;
        r0 = r0 + 1;
        goto L9
    L22:
        return r3;
    L11:
        LinkEntry<K, V> r1 = this.header;
        int r5 = this.size;
    L12:
        if (r5 <= r4) goto L15;
        r1 = r1.before;
        r5 = r5 - 1;
        goto L12
    L15:
        return r1;
    L17:
        throw new IndexOutOfBoundsException("Index " + r4 + " is invalid for size " + this.size);
    L19:
        throw new IndexOutOfBoundsException("Index " + r4 + " is less than zero");
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    public LinkEntry<K, V> getEntry(Object r2) {
        return (LinkEntry) ZeusTransformUtils.preCheckCast(super.getEntry(r2), LinkEntry.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    public void init() {
        LinkEntry<K, V> r0 = createEntry(null, -1, null, null);
        this.header = r0;
        r0.after = r0;
        r0.before = r0;
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K lastKey() {
        if (this.size == 0) goto L7;
        return this.header.before.getKey();
    L7:
        throw new NoSuchElementException("Map is empty");
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap, org.apache.commons.collections4.IterableGet
    public /* bridge */ /* synthetic */ MapIterator mapIterator() {
        return mapIterator();
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap, org.apache.commons.collections4.IterableGet
    public OrderedMapIterator<K, V> mapIterator() {
        if (this.size != 0) goto L7;
        return EmptyOrderedMapIterator.emptyOrderedMapIterator();
    L7:
        return new LinkMapIterator(this);
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K nextKey(Object r2) {
        LinkEntry<K, V> r3 = getEntry(r2);
        if (r3 != null) goto L5;
    L8:
        return null;
    L5:
        if (r3.after == this.header) goto L8;
        return r3.after.getKey();
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K previousKey(Object r2) {
        LinkEntry<K, V> r3 = getEntry(r2);
        if (r3 != null) goto L5;
    L8:
        return null;
    L5:
        if (r3.before == this.header) goto L8;
        return r3.before.getKey();
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    public void removeEntry(AbstractHashedMap.HashEntry<K, V> r4, int r5, AbstractHashedMap.HashEntry<K, V> r6) {
        LinkEntry r0 = (LinkEntry) ZeusTransformUtils.preCheckCast(r4, LinkEntry.class, "com.obric.memorydata.plugin");
        LinkEntry<K, V> r1 = r0.before;
        r1.after = r0.after;
        LinkEntry<K, V> r2 = r0.after;
        r2.before = r0.before;
        r0.after = null;
        r0.before = null;
        super.removeEntry(r4, r5, r6);
    }
}
