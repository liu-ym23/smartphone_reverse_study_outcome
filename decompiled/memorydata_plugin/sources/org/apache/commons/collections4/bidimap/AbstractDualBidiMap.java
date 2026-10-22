package org.apache.commons.collections4.bidimap;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Predicate;
import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.ResettableIterator;
import org.apache.commons.collections4.collection.AbstractCollectionDecorator;
import org.apache.commons.collections4.iterators.AbstractIteratorDecorator;
import org.apache.commons.collections4.keyvalue.AbstractMapEntryDecorator;

/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractDualBidiMap<K, V> implements BidiMap<K, V> {
    transient Set<Map.Entry<K, V>> entrySet;
    transient BidiMap<V, K> inverseBidiMap;
    transient Set<K> keySet;
    transient Map<K, V> normalMap;
    transient Map<V, K> reverseMap;
    transient Set<V> values;

    protected static class BidiMapIterator<K, V> implements MapIterator<K, V>, ResettableIterator<K> {
        protected boolean canRemove;
        protected Iterator<Map.Entry<K, V>> iterator;
        protected Map.Entry<K, V> last;
        protected final AbstractDualBidiMap<K, V> parent;

        public BidiMapIterator(AbstractDualBidiMap<K, V> r2) {
            this.last = null;
            this.canRemove = false;
            this.parent = r2;
            this.iterator = r2.normalMap.entrySet().iterator();
        }

        public K getKey() {
            Map.Entry<K, V> r1 = this.last;
            if (r1 == null) goto L7;
            return r1.getKey();
        L7:
            throw new IllegalStateException("Iterator getKey() can only be called after next() and before remove()");
        }

        @Override // org.apache.commons.collections4.MapIterator
        public V getValue() {
            Map.Entry<K, V> r1 = this.last;
            if (r1 == null) goto L7;
            return r1.getValue();
        L7:
            throw new IllegalStateException("Iterator getValue() can only be called after next() and before remove()");
        }

        @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
        public K next() {
            Map.Entry<K, V> r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(this.iterator.next(), Map.Entry.class, "com.obric.memorydata.plugin");
            this.last = r0;
            this.canRemove = true;
            return r0.getKey();
        }

        @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
        public void remove() {
            if (this.canRemove == false) goto L7;
            V r0 = this.last.getValue();
            this.iterator.remove();
            this.parent.reverseMap.remove(r0);
            this.last = null;
            this.canRemove = false;
            return;
        L7:
            throw new IllegalStateException("Iterator remove() can only be called once after next()");
        }

        public String toString() {
            if (this.last != null) goto L5;
            return "MapIterator[]";
        L5:
            return "MapIterator[" + getKey() + "=" + getValue() + "]";
        }
    }

    protected static class EntrySet<K, V> extends View<K, V, Map.Entry<K, V>> implements Set<Map.Entry<K, V>> {
        private static final long serialVersionUID = 4040410962603292348L;

        public EntrySet(AbstractDualBidiMap<K, V> r2) {
            super(r2.normalMap.entrySet(), r2);
        }

        @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, java.lang.Iterable, org.apache.commons.collections4.Bag
        public Iterator<Map.Entry<K, V>> iterator() {
            return this.parent.createEntrySetIterator(super.iterator());
        }

        @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection
        public boolean remove(Object r4) {
            if (ZeusTransformUtils.instanceOf(r4, Map.Entry.class) == true) goto L5;
            return false;
        L5:
            Map.Entry r5 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4, Map.Entry.class, "com.obric.memorydata.plugin");
            Object r0 = r5.getKey();
            if (this.parent.containsKey(r0) == false) goto L15;
            V r2 = this.parent.normalMap.get(r0);
            Object r6 = r5.getValue();
            if (r2 != null) goto L12;
            if (r6 != null) goto L15;
        L13:
            this.parent.normalMap.remove(r0);
            this.parent.reverseMap.remove(r2);
            return true;
        L12:
            if (r2.equals(r6) == true) goto L13;
        L15:
            return false;
        }
    }

    protected static class EntrySetIterator<K, V> extends AbstractIteratorDecorator<Map.Entry<K, V>> {
        protected boolean canRemove;
        protected Map.Entry<K, V> last;
        protected final AbstractDualBidiMap<K, V> parent;

        public EntrySetIterator(Iterator<Map.Entry<K, V>> r3, AbstractDualBidiMap<K, V> r4) {
            super((Iterator) ZeusTransformUtils.wrapperContextForParams(r3, Iterator.class, "com.obric.memorydata.plugin"));
            this.last = null;
            this.canRemove = false;
            this.parent = r4;
        }

        @Override // org.apache.commons.collections4.iterators.AbstractIteratorDecorator, java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return next();
        }

        @Override // org.apache.commons.collections4.iterators.AbstractIteratorDecorator, java.util.Iterator
        public Map.Entry<K, V> next() {
            MapEntry r0 = new MapEntry((Map.Entry) ZeusTransformUtils.preCheckCast(super.next(), Map.Entry.class, "com.obric.memorydata.plugin"), this.parent);
            this.last = r0;
            this.canRemove = true;
            return r0;
        }

        @Override // org.apache.commons.collections4.iterators.AbstractUntypedIteratorDecorator, java.util.Iterator
        public void remove() {
            if (this.canRemove == false) goto L7;
            V r0 = this.last.getValue();
            super.remove();
            this.parent.reverseMap.remove(r0);
            this.last = null;
            this.canRemove = false;
            return;
        L7:
            throw new IllegalStateException("Iterator remove() can only be called once after next()");
        }
    }

    protected static class KeySet<K> extends View<K, Object, K> implements Set<K> {
        private static final long serialVersionUID = -7107935777385040694L;

        public KeySet(AbstractDualBidiMap<K, ?> r2) {
            super(r2.normalMap.keySet(), r2);
        }

        @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, java.util.Set
        public boolean contains(Object r1) {
            return this.parent.normalMap.containsKey(r1);
        }

        @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, java.lang.Iterable, org.apache.commons.collections4.Bag
        public Iterator<K> iterator() {
            return this.parent.createKeySetIterator(super.iterator());
        }

        @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection
        public boolean remove(Object r2) {
            if (this.parent.normalMap.containsKey(r2) == false) goto L6;
            V r3 = this.parent.normalMap.remove(r2);
            this.parent.reverseMap.remove(r3);
            return true;
        L6:
            return false;
        }
    }

    protected static class KeySetIterator<K> extends AbstractIteratorDecorator<K> {
        protected boolean canRemove;
        protected K lastKey;
        protected final AbstractDualBidiMap<K, ?> parent;

        public KeySetIterator(Iterator<K> r3, AbstractDualBidiMap<K, ?> r4) {
            super((Iterator) ZeusTransformUtils.wrapperContextForParams(r3, Iterator.class, "com.obric.memorydata.plugin"));
            this.lastKey = null;
            this.canRemove = false;
            this.parent = r4;
        }

        @Override // org.apache.commons.collections4.iterators.AbstractIteratorDecorator, java.util.Iterator
        public K next() {
            K r0 = (K) super.next();
            this.lastKey = r0;
            this.canRemove = true;
            return r0;
        }

        @Override // org.apache.commons.collections4.iterators.AbstractUntypedIteratorDecorator, java.util.Iterator
        public void remove() {
            if (this.canRemove == false) goto L7;
            Object r0 = this.parent.normalMap.get(this.lastKey);
            super.remove();
            this.parent.reverseMap.remove(r0);
            this.lastKey = null;
            this.canRemove = false;
            return;
        L7:
            throw new IllegalStateException("Iterator remove() can only be called once after next()");
        }
    }

    protected static class MapEntry<K, V> extends AbstractMapEntryDecorator<K, V> {
        protected final AbstractDualBidiMap<K, V> parent;

        public MapEntry(Map.Entry<K, V> r3, AbstractDualBidiMap<K, V> r4) {
            super((Map.Entry) ZeusTransformUtils.wrapperContextForParams(r3, Map.Entry.class, "com.obric.memorydata.plugin"));
            this.parent = r4;
        }

        @Override // org.apache.commons.collections4.keyvalue.AbstractMapEntryDecorator, java.util.Map.Entry
        public V setValue(V r3) {
            K r0 = getKey();
            if (this.parent.reverseMap.containsKey(r3) == true) goto L5;
        L9:
            this.parent.put(r0, r3);
            return (V) super.setValue(r3);
        L5:
            if (this.parent.reverseMap.get(r3) == r0) goto L9;
            throw new IllegalArgumentException("Cannot use setValue() when the object being set is already in the map");
        }
    }

    protected static class Values<V> extends View<Object, V, V> implements Set<V> {
        private static final long serialVersionUID = 4023777119829639864L;

        public Values(AbstractDualBidiMap<?, V> r2) {
            super(r2.normalMap.values(), r2);
        }

        @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, java.util.Set
        public boolean contains(Object r1) {
            return this.parent.reverseMap.containsKey(r1);
        }

        @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, java.lang.Iterable, org.apache.commons.collections4.Bag
        public Iterator<V> iterator() {
            return this.parent.createValuesIterator(super.iterator());
        }

        @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection
        public boolean remove(Object r2) {
            if (this.parent.reverseMap.containsKey(r2) == false) goto L6;
            K r3 = this.parent.reverseMap.remove(r2);
            this.parent.normalMap.remove(r3);
            return true;
        L6:
            return false;
        }
    }

    protected static class ValuesIterator<V> extends AbstractIteratorDecorator<V> {
        protected boolean canRemove;
        protected V lastValue;
        protected final AbstractDualBidiMap<Object, V> parent;

        public ValuesIterator(Iterator<V> r3, AbstractDualBidiMap<?, V> r4) {
            super((Iterator) ZeusTransformUtils.wrapperContextForParams(r3, Iterator.class, "com.obric.memorydata.plugin"));
            this.lastValue = null;
            this.canRemove = false;
            this.parent = r4;
        }

        @Override // org.apache.commons.collections4.iterators.AbstractIteratorDecorator, java.util.Iterator
        public V next() {
            V r0 = (V) super.next();
            this.lastValue = r0;
            this.canRemove = true;
            return r0;
        }

        @Override // org.apache.commons.collections4.iterators.AbstractUntypedIteratorDecorator, java.util.Iterator
        public void remove() {
            if (this.canRemove == false) goto L7;
            super.remove();
            this.parent.reverseMap.remove(this.lastValue);
            this.lastValue = null;
            this.canRemove = false;
            return;
        L7:
            throw new IllegalStateException("Iterator remove() can only be called once after next()");
        }
    }

    protected static abstract class View<K, V, E> extends AbstractCollectionDecorator<E> {
        private static final long serialVersionUID = 4621510560119690639L;
        protected final AbstractDualBidiMap<K, V> parent;

        public View(Collection<E> r3, AbstractDualBidiMap<K, V> r4) {
            super((Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin"));
            this.parent = r4;
        }

        @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection
        public void clear() {
            this.parent.clear();
        }

        @Override // java.util.Collection
        public boolean equals(Object r1) {
            if (r1 != this) goto L4;
        L7:
            return true;
        L4:
            if (decorated().equals(r1) == true) goto L7;
            return false;
        }

        @Override // java.util.Collection
        public int hashCode() {
            return decorated().hashCode();
        }

        @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections4.Bag
        public boolean removeAll(Collection<?> r3) {
            Collection r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
            boolean r1 = false;
            if (this.parent.isEmpty() == false) goto L5;
        L11:
            return r1;
        L5:
            if (r4.isEmpty() == true) goto L11;
            Iterator<E> r5 = r4.iterator();
        L9:
            if (r5.hasNext() == false) goto L11;
            r1 = r1 | remove(r5.next());
            goto L9
        }

        @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection
        public boolean removeIf(Predicate<? super E> r3) {
            Predicate r4 = (Predicate) ZeusTransformUtils.wrapperContextForParams(r3, Predicate.class, "com.obric.memorydata.plugin");
            boolean r1 = false;
            if (this.parent.isEmpty() == false) goto L5;
        L13:
            return r1;
        L5:
            if (Objects.isNull(r4) == true) goto L13;
            Iterator<E> r2 = iterator();
        L9:
            if (r2.hasNext() == false) goto L13;
            if (r4.test(r2.next()) == false) goto L9;
            r2.remove();
            r1 = true;
            goto L9
        }

        @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections4.Bag
        public boolean retainAll(Collection<?> r4) {
            Collection r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.memorydata.plugin");
            boolean r1 = false;
            if (this.parent.isEmpty() == false) goto L6;
            return false;
        L6:
            if (r5.isEmpty() == false) goto L9;
            this.parent.clear();
            return true;
        L9:
            Iterator<E> r3 = iterator();
        L11:
            if (r3.hasNext() == false) goto L15;
            if (r5.contains(r3.next()) == true) goto L11;
            r3.remove();
            r1 = true;
            goto L11
        L15:
            return r1;
        }
    }

    public AbstractDualBidiMap() {
        this.inverseBidiMap = null;
        this.keySet = null;
        this.values = null;
        this.entrySet = null;
    }

    public AbstractDualBidiMap(Map<K, V> r3, Map<V, K> r4) {
        Map<K, V> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        Map<V, K> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        this.inverseBidiMap = null;
        this.keySet = null;
        this.values = null;
        this.entrySet = null;
        this.normalMap = r5;
        this.reverseMap = r6;
    }

    public AbstractDualBidiMap(Map<K, V> r3, Map<V, K> r4, BidiMap<V, K> r5) {
        Map<K, V> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        Map<V, K> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        BidiMap<V, K> r8 = (BidiMap) ZeusTransformUtils.wrapperContextForParams(r5, BidiMap.class, "com.obric.memorydata.plugin");
        this.inverseBidiMap = null;
        this.keySet = null;
        this.values = null;
        this.entrySet = null;
        this.normalMap = r6;
        this.reverseMap = r7;
        this.inverseBidiMap = r8;
    }

    @Override // java.util.Map
    public void clear() {
        this.normalMap.clear();
        this.reverseMap.clear();
    }

    @Override // java.util.Map
    public boolean containsKey(Object r1) {
        return this.normalMap.containsKey(r1);
    }

    @Override // java.util.Map
    public boolean containsValue(Object r1) {
        return this.reverseMap.containsKey(r1);
    }

    public abstract BidiMap<V, K> createBidiMap(Map<V, K> r1, Map<K, V> r2, BidiMap<K, V> r3);

    public Iterator<Map.Entry<K, V>> createEntrySetIterator(Iterator<Map.Entry<K, V>> r3) {
        return new EntrySetIterator((Iterator) ZeusTransformUtils.wrapperContextForParams(r3, Iterator.class, "com.obric.memorydata.plugin"), this);
    }

    public Iterator<K> createKeySetIterator(Iterator<K> r3) {
        return new KeySetIterator((Iterator) ZeusTransformUtils.wrapperContextForParams(r3, Iterator.class, "com.obric.memorydata.plugin"), this);
    }

    public Iterator<V> createValuesIterator(Iterator<V> r3) {
        return new ValuesIterator((Iterator) ZeusTransformUtils.wrapperContextForParams(r3, Iterator.class, "com.obric.memorydata.plugin"), this);
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.entrySet != null) goto L6;
        this.entrySet = new EntrySet(this);
    L6:
        return this.entrySet;
    }

    @Override // java.util.Map
    public boolean equals(Object r1) {
        return this.normalMap.equals(r1);
    }

    @Override // java.util.Map
    public V get(Object r1) {
        return this.normalMap.get(r1);
    }

    public K getKey(Object r1) {
        return this.reverseMap.get(r1);
    }

    @Override // java.util.Map
    public int hashCode() {
        return this.normalMap.hashCode();
    }

    public BidiMap<V, K> inverseBidiMap() {
        if (this.inverseBidiMap != null) goto L6;
        this.inverseBidiMap = createBidiMap(this.reverseMap, this.normalMap, this);
    L6:
        return this.inverseBidiMap;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.normalMap.isEmpty();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        if (this.keySet != null) goto L6;
        this.keySet = new KeySet(this);
    L6:
        return this.keySet;
    }

    @Override // org.apache.commons.collections4.IterableGet
    public MapIterator<K, V> mapIterator() {
        return new BidiMapIterator(this);
    }

    @Override // java.util.Map
    public V put(K r3, V r4) {
        if (this.normalMap.containsKey(r3) == false) goto L6;
        this.reverseMap.remove(this.normalMap.get(r3));
    L6:
        if (this.reverseMap.containsKey(r4) == false) goto L8;
        this.normalMap.remove(this.reverseMap.get(r4));
    L8:
        V r0 = this.normalMap.put(r3, r4);
        this.reverseMap.put(r4, r3);
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> r4) {
        Iterator<Map.Entry<K, V>> r5 = ((Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin")).entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        put(r0.getKey(), r0.getValue());
        goto L4
    }

    @Override // java.util.Map
    public V remove(Object r2) {
        if (this.normalMap.containsKey(r2) == false) goto L5;
        V r3 = this.normalMap.remove(r2);
        this.reverseMap.remove(r3);
        return r3;
    L5:
        return null;
    }

    public K removeValue(Object r2) {
        if (this.reverseMap.containsKey(r2) == false) goto L5;
        K r3 = this.reverseMap.remove(r2);
        this.normalMap.remove(r3);
        return r3;
    L5:
        return null;
    }

    @Override // java.util.Map
    public int size() {
        return this.normalMap.size();
    }

    public String toString() {
        return this.normalMap.toString();
    }

    @Override // org.apache.commons.collections4.BidiMap, java.util.Map
    public /* bridge */ /* synthetic */ Collection values() {
        return values();
    }

    @Override // org.apache.commons.collections4.BidiMap, java.util.Map
    public Set<V> values() {
        if (this.values != null) goto L6;
        this.values = new Values(this);
    L6:
        return this.values;
    }
}
