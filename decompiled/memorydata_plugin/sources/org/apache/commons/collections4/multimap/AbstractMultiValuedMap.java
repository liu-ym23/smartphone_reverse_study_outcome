package org.apache.commons.collections4.multimap;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.IteratorUtils;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.MultiSet;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.iterators.AbstractIteratorDecorator;
import org.apache.commons.collections4.iterators.EmptyMapIterator;
import org.apache.commons.collections4.iterators.IteratorChain;
import org.apache.commons.collections4.keyvalue.AbstractMapEntry;
import org.apache.commons.collections4.keyvalue.UnmodifiableMapEntry;
import org.apache.commons.collections4.multiset.AbstractMultiSet;
import org.apache.commons.collections4.multiset.UnmodifiableMultiSet;

/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractMultiValuedMap<K, V> implements MultiValuedMap<K, V> {
    private transient AbstractMultiValuedMap<K, V>.AsMap asMapView;
    private transient AbstractMultiValuedMap<K, V>.EntryValues entryValuesView;
    private transient MultiSet<K> keysMultiSetView;
    private transient Map<K, Collection<V>> map;
    private transient Collection<V> valuesView;

    /* JADX INFO: renamed from: org.apache.commons.collections4.multimap.AbstractMultiValuedMap$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private class AsMap extends AbstractMap<K, Collection<V>> {
        final transient Map<K, Collection<V>> decoratedMap;
        final /* synthetic */ AbstractMultiValuedMap this$0;

        class AsMapEntrySet extends AbstractSet<Map.Entry<K, Collection<V>>> {
            final /* synthetic */ AsMap this$1;

            AsMapEntrySet(AsMap r1) {
                this.this$1 = r1;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public void clear() {
                this.this$1.clear();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object r1) {
                return this.this$1.decoratedMap.entrySet().contains(r1);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, Collection<V>>> iterator() {
                AsMap r2 = this.this$1;
                return new AsMapEntrySetIterator(r2, r2.decoratedMap.entrySet().iterator());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object r3) {
                if (contains(r3) == true) goto L6;
                return false;
            L6:
                Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3, Map.Entry.class, "com.obric.memorydata.plugin");
                this.this$1.this$0.remove(r4.getKey());
                return true;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return this.this$1.size();
            }
        }

        class AsMapEntrySetIterator extends AbstractIteratorDecorator<Map.Entry<K, Collection<V>>> {
            final /* synthetic */ AsMap this$1;

            AsMapEntrySetIterator(AsMap r3, Iterator<Map.Entry<K, Collection<V>>> r4) {
                Iterator r5 = (Iterator) ZeusTransformUtils.wrapperContextForParams(r4, Iterator.class, "com.obric.memorydata.plugin");
                this.this$1 = r3;
                super(r5);
            }

            @Override // org.apache.commons.collections4.iterators.AbstractIteratorDecorator, java.util.Iterator
            public /* bridge */ /* synthetic */ Object next() {
                return next();
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // org.apache.commons.collections4.iterators.AbstractIteratorDecorator, java.util.Iterator
            public Map.Entry<K, Collection<V>> next() {
                Object r0 = ((Map.Entry) ZeusTransformUtils.preCheckCast(super.next(), Map.Entry.class, "com.obric.memorydata.plugin")).getKey();
                return new UnmodifiableMapEntry(r0, this.this$1.this$0.wrappedCollection(r0));
            }
        }

        AsMap(AbstractMultiValuedMap r3, Map<K, Collection<V>> r4) {
            Map<K, Collection<V>> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.decoratedMap = r5;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            this.this$0.clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object r1) {
            return this.decoratedMap.containsKey(r1);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<K, Collection<V>>> entrySet() {
            return new AsMapEntrySet(this);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean equals(Object r1) {
            if (this != r1) goto L4;
        L7:
            return true;
        L4:
            if (this.decoratedMap.equals(r1) == true) goto L7;
            return false;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public /* bridge */ /* synthetic */ Object get(Object r1) {
            return get(r1);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Collection<V> get(Object r4) {
            if (((Collection) ZeusTransformUtils.preCheckCast(this.decoratedMap.get(r4), Collection.class, "com.obric.memorydata.plugin")) != null) goto L7;
            return null;
        L7:
            return this.this$0.wrappedCollection(r4);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int hashCode() {
            return this.decoratedMap.hashCode();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            return this.this$0.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public /* bridge */ /* synthetic */ Object remove(Object r1) {
            return remove(r1);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Collection<V> remove(Object r3) {
            Collection<? extends V> r4 = (Collection) ZeusTransformUtils.preCheckCast(this.decoratedMap.remove(r3), Collection.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            Collection<V> r2 = this.this$0.createCollection();
            r2.addAll(r4);
            r4.clear();
            return r2;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.decoratedMap.size();
        }

        @Override // java.util.AbstractMap
        public String toString() {
            return this.decoratedMap.toString();
        }
    }

    private class EntryValues extends AbstractCollection<Map.Entry<K, V>> {
        final /* synthetic */ AbstractMultiValuedMap this$0;

        private EntryValues(AbstractMultiValuedMap r1) {
            this.this$0 = r1;
        }

        /* synthetic */ EntryValues(AbstractMultiValuedMap r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            return new AnonymousClass1(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.this$0.size();
        }
    }

    private class KeysMultiSet extends AbstractMultiSet<K> {
        final /* synthetic */ AbstractMultiValuedMap this$0;

        private final class MapEntryTransformer implements Transformer<Map.Entry<K, Collection<V>>, MultiSet.Entry<K>> {
            final /* synthetic */ KeysMultiSet this$1;

            private MapEntryTransformer(KeysMultiSet r1) {
                this.this$1 = r1;
            }

            /* synthetic */ MapEntryTransformer(KeysMultiSet r1, AnonymousClass1 r2) {
                this(r1);
            }

            @Override // org.apache.commons.collections4.Transformer
            public /* synthetic */ Object transform(Object r3) {
                return transform((Map.Entry) ZeusTransformUtils.preCheckCast(r3, Map.Entry.class, "com.obric.memorydata.plugin"));
            }

            public MultiSet.Entry<K> transform(Map.Entry<K, Collection<V>> r3) {
                final Map.Entry r4 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r3, Map.Entry.class, "com.obric.memorydata.plugin");
                return new AnonymousClass1(this, r4);
            }
        }

        private KeysMultiSet(AbstractMultiValuedMap r1) {
            this.this$0 = r1;
        }

        /* synthetic */ KeysMultiSet(AbstractMultiValuedMap r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // org.apache.commons.collections4.multiset.AbstractMultiSet, java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object r1) {
            return this.this$0.getMap().containsKey(r1);
        }

        @Override // org.apache.commons.collections4.multiset.AbstractMultiSet
        public Iterator<MultiSet.Entry<K>> createEntrySetIterator() {
            MapEntryTransformer r0 = new MapEntryTransformer(this, null);
            return IteratorUtils.transformedIterator(AbstractMultiValuedMap.access$300(this.this$0).entrySet().iterator(), r0);
        }

        @Override // org.apache.commons.collections4.multiset.AbstractMultiSet, org.apache.commons.collections4.MultiSet
        public int getCount(Object r2) {
            Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(this.this$0.getMap().get(r2), Collection.class, "com.obric.memorydata.plugin");
            if (r1 != null) goto L7;
            return 0;
        L7:
            return r1.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.this$0.getMap().isEmpty();
        }

        @Override // org.apache.commons.collections4.multiset.AbstractMultiSet, java.util.AbstractCollection, java.util.Collection, org.apache.commons.collections4.MultiSet
        public int size() {
            return this.this$0.size();
        }

        @Override // org.apache.commons.collections4.multiset.AbstractMultiSet
        public int uniqueElements() {
            return this.this$0.getMap().size();
        }
    }

    private class MultiValuedMapEntry extends AbstractMapEntry<K, V> {
        final /* synthetic */ AbstractMultiValuedMap this$0;

        public MultiValuedMapEntry(AbstractMultiValuedMap r1, K r2, V r3) {
            this.this$0 = r1;
            super(r2, r3);
        }

        @Override // org.apache.commons.collections4.keyvalue.AbstractMapEntry, org.apache.commons.collections4.keyvalue.AbstractKeyValue, java.util.Map.Entry
        public V setValue(V r1) {
            throw new UnsupportedOperationException();
        }
    }

    private class MultiValuedMapIterator implements MapIterator<K, V> {
        private Map.Entry<K, V> current;
        private final Iterator<Map.Entry<K, V>> it;
        final /* synthetic */ AbstractMultiValuedMap this$0;

        public MultiValuedMapIterator(AbstractMultiValuedMap r2) {
            this.this$0 = r2;
            this.current = null;
            this.it = r2.entries().iterator();
        }

        @Override // org.apache.commons.collections4.MapIterator
        public V getValue() {
            Map.Entry<K, V> r0 = this.current;
            if (r0 == null) goto L7;
            return r0.getValue();
        L7:
            throw new IllegalStateException();
        }

        @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
        public boolean hasNext() {
            return this.it.hasNext();
        }

        @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
        public K next() {
            Map.Entry<K, V> r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(this.it.next(), Map.Entry.class, "com.obric.memorydata.plugin");
            this.current = r0;
            return r0.getKey();
        }

        @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
        public void remove() {
            this.it.remove();
        }
    }

    private class Values extends AbstractCollection<V> {
        final /* synthetic */ AbstractMultiValuedMap this$0;

        private Values(AbstractMultiValuedMap r1) {
            this.this$0 = r1;
        }

        /* synthetic */ Values(AbstractMultiValuedMap r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            this.this$0.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            IteratorChain r0 = new IteratorChain();
            Iterator<K> r1 = this.this$0.keySet().iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            K r2 = r1.next();
            r0.addIterator(new ValuesIterator(this.this$0, r2));
            goto L4
        L6:
            return r0;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.this$0.size();
        }
    }

    private class ValuesIterator implements Iterator<V> {
        private final Iterator<V> iterator;
        private final Object key;
        final /* synthetic */ AbstractMultiValuedMap this$0;
        private final Collection<V> values;

        public ValuesIterator(AbstractMultiValuedMap r2, Object r3) {
            this.this$0 = r2;
            this.key = r3;
            Collection<V> r4 = (Collection) ZeusTransformUtils.preCheckCast(r2.getMap().get(r3), Collection.class, "com.obric.memorydata.plugin");
            this.values = r4;
            this.iterator = r4.iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        @Override // java.util.Iterator
        public V next() {
            return this.iterator.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.iterator.remove();
            if (this.values.isEmpty() == false) goto L6;
            this.this$0.remove(this.key);
            return;
        }
    }

    class WrappedCollection implements Collection<V> {
        protected final K key;
        final /* synthetic */ AbstractMultiValuedMap this$0;

        public WrappedCollection(AbstractMultiValuedMap r1, K r2) {
            this.this$0 = r1;
            this.key = r2;
        }

        @Override // java.util.Collection
        public boolean add(V r3) {
            Collection<V> r0 = getMapping();
            if (r0 != null) goto L6;
            r0 = this.this$0.createCollection();
            AbstractMultiValuedMap.access$300(this.this$0).put(this.key, r0);
        L6:
            return r0.add(r3);
        }

        @Override // java.util.Collection
        public boolean addAll(Collection<? extends V> r3) {
            Collection<? extends V> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
            Collection<V> r0 = getMapping();
            if (r0 != null) goto L6;
            r0 = this.this$0.createCollection();
            AbstractMultiValuedMap.access$300(this.this$0).put(this.key, r0);
        L6:
            return r0.addAll(r4);
        }

        @Override // java.util.Collection
        public void clear() {
            Collection<V> r0 = getMapping();
            if (r0 == null) goto L6;
            r0.clear();
            this.this$0.remove(this.key);
            return;
        }

        @Override // java.util.Collection
        public boolean contains(Object r1) {
            Collection<V> r0 = getMapping();
            if (r0 != null) goto L5;
        L7:
            return false;
        L5:
            if (r0.contains(r1) == false) goto L7;
            return true;
        }

        @Override // java.util.Collection
        public boolean containsAll(Collection<?> r3) {
            Collection<?> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
            Collection<V> r2 = getMapping();
            if (r2 != null) goto L5;
        L7:
            return false;
        L5:
            if (r2.containsAll(r4) == false) goto L7;
            return true;
        }

        public Collection<V> getMapping() {
            return (Collection) ZeusTransformUtils.preCheckCast(this.this$0.getMap().get(this.key), Collection.class, "com.obric.memorydata.plugin");
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            Collection<V> r0 = getMapping();
            if (r0 != null) goto L5;
        L8:
            return true;
        L5:
            if (r0.isEmpty() == true) goto L8;
            return false;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            if (getMapping() != null) goto L7;
            return IteratorUtils.EMPTY_ITERATOR;
        L7:
            return new ValuesIterator(this.this$0, this.key);
        }

        @Override // java.util.Collection
        public boolean remove(Object r2) {
            Collection<V> r0 = getMapping();
            if (r0 != null) goto L6;
            return false;
        L6:
            boolean r3 = r0.remove(r2);
            if (r0.isEmpty() == false) goto L9;
            this.this$0.remove(this.key);
        L9:
            return r3;
        }

        @Override // java.util.Collection
        public boolean removeAll(Collection<?> r3) {
            Collection<?> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
            Collection<V> r0 = getMapping();
            if (r0 != null) goto L6;
            return false;
        L6:
            boolean r5 = r0.removeAll(r4);
            if (r0.isEmpty() == false) goto L9;
            this.this$0.remove(this.key);
        L9:
            return r5;
        }

        @Override // java.util.Collection
        public boolean retainAll(Collection<?> r3) {
            Collection<?> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
            Collection<V> r0 = getMapping();
            if (r0 != null) goto L6;
            return false;
        L6:
            boolean r5 = r0.retainAll(r4);
            if (r0.isEmpty() == false) goto L9;
            this.this$0.remove(this.key);
        L9:
            return r5;
        }

        @Override // java.util.Collection
        public int size() {
            Collection<V> r0 = getMapping();
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.size();
        }

        @Override // java.util.Collection
        public Object[] toArray() {
            Collection<V> r0 = getMapping();
            if (r0 != null) goto L7;
            return CollectionUtils.EMPTY_COLLECTION.toArray();
        L7:
            return r0.toArray();
        }

        @Override // java.util.Collection
        public <T> T[] toArray(T[] r2) {
            Collection<V> r1 = getMapping();
            if (r1 != null) goto L7;
            return (T[]) ((Object[]) ZeusTransformUtils.preCheckCast(CollectionUtils.EMPTY_COLLECTION.toArray(r2), Object[].class, "com.obric.memorydata.plugin"));
        L7:
            return (T[]) r1.toArray(r2);
        }

        public String toString() {
            Collection<V> r0 = getMapping();
            if (r0 != null) goto L7;
            return CollectionUtils.EMPTY_COLLECTION.toString();
        L7:
            return r0.toString();
        }
    }

    public AbstractMultiValuedMap() {
    }

    public AbstractMultiValuedMap(Map<K, ? extends Collection<V>> r3) {
        Map<K, Collection<V>> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r4, "Map must not be null.");
        this.map = r4;
    }

    static /* synthetic */ Map access$300(AbstractMultiValuedMap r0) {
        return r0.map;
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    public Map<K, Collection<V>> asMap() {
        AbstractMultiValuedMap<K, V>.AsMap r0 = this.asMapView;
        if (r0 != null) goto L7;
        AbstractMultiValuedMap<K, V>.AsMap r1 = new AsMap(this, this.map);
        this.asMapView = r1;
        return r1;
    L7:
        return r0;
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    public void clear() {
        getMap().clear();
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    public boolean containsKey(Object r1) {
        return getMap().containsKey(r1);
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    public boolean containsMapping(Object r2, Object r3) {
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(getMap().get(r2), Collection.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L5;
    L7:
        return false;
    L5:
        if (r1.contains(r3) == false) goto L7;
        return true;
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    public boolean containsValue(Object r1) {
        return values().contains(r1);
    }

    public abstract Collection<V> createCollection();

    /* JADX WARN: Multi-variable type inference failed */
    public void doReadObject(ObjectInputStream r8) {
        int r0 = r8.readInt();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L8;
        Collection r3 = get(r8.readObject());
        int r4 = r8.readInt();
        int r5 = 0;
    L5:
        if (r5 >= r4) goto L7;
        r3.add(r8.readObject());
        r5 = r5 + 1;
        goto L5
    L7:
        r2 = r2 + 1;
        goto L3
    }

    public void doWriteObject(ObjectOutputStream r5) {
        r5.writeInt(this.map.size());
        Iterator<Map.Entry<K, Collection<V>>> r4 = this.map.entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L9;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r5.writeObject(r0.getKey());
        r5.writeInt(((Collection) ZeusTransformUtils.preCheckCast(r0.getValue(), Collection.class, "com.obric.memorydata.plugin")).size());
        Iterator r1 = ((Collection) ZeusTransformUtils.preCheckCast(r0.getValue(), Collection.class, "com.obric.memorydata.plugin")).iterator();
    L7:
        if (r1.hasNext() == false) goto L4;
        r5.writeObject(r1.next());
        goto L7
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    public Collection<Map.Entry<K, V>> entries() {
        AbstractMultiValuedMap<K, V>.EntryValues r0 = this.entryValuesView;
        if (r0 != null) goto L7;
        AbstractMultiValuedMap<K, V>.EntryValues r1 = new EntryValues(this, null);
        this.entryValuesView = r1;
        return r1;
    L7:
        return r0;
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r3, MultiValuedMap.class) == true) goto L8;
        return false;
    L8:
        return asMap().equals(((MultiValuedMap) ZeusTransformUtils.preCheckCast(r3, MultiValuedMap.class, "com.obric.memorydata.plugin")).asMap());
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    public Collection<V> get(K r1) {
        return wrappedCollection(r1);
    }

    public Map<K, ? extends Collection<V>> getMap() {
        return this.map;
    }

    public int hashCode() {
        return getMap().hashCode();
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    public boolean isEmpty() {
        return getMap().isEmpty();
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    public Set<K> keySet() {
        return getMap().keySet();
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    public MultiSet<K> keys() {
        if (this.keysMultiSetView != null) goto L6;
        this.keysMultiSetView = UnmodifiableMultiSet.unmodifiableMultiSet(new KeysMultiSet(this, null));
    L6:
        return this.keysMultiSetView;
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    public MapIterator<K, V> mapIterator() {
        if (size() != 0) goto L7;
        return EmptyMapIterator.emptyMapIterator();
    L7:
        return new MultiValuedMapIterator(this);
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    public boolean put(K r4, V r5) {
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(getMap().get(r4), Collection.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L11;
        Collection<V> r1 = createCollection();
        if (r1.add(r5) == false) goto L8;
        this.map.put(r4, r1);
        return true;
    L8:
        return false;
    L11:
        return r0.add(r5);
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    public boolean putAll(K r5, Iterable<? extends V> r6) {
        Iterable r7 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r6, Iterable.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r7, "Values must not be null.");
        if (ZeusTransformUtils.instanceOf(r7, Collection.class) == false) goto L11;
        Collection<? extends V> r8 = (Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.memorydata.plugin");
        if (r8.isEmpty() == true) goto L10;
        if (get(r5).addAll(r8) == false) goto L10;
        return true;
    L10:
        return false;
    L11:
        Iterator r9 = r7.iterator();
        if (r9.hasNext() == false) goto L17;
        if (CollectionUtils.addAll(get(r5), r9) == false) goto L17;
        return true;
    L17:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.collections4.MultiValuedMap
    public boolean putAll(Map<? extends K, ? extends V> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r6, "Map must not be null.");
        boolean r0 = false;
        Iterator<Map.Entry<K, V>> r7 = r6.entrySet().iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r0 = r0 | put(r2.getKey(), r2.getValue());
        goto L4
    L6:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.collections4.MultiValuedMap
    public boolean putAll(MultiValuedMap<? extends K, ? extends V> r5) {
        MultiValuedMap r6 = (MultiValuedMap) ZeusTransformUtils.wrapperContextForParams(r5, MultiValuedMap.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r6, "Map must not be null.");
        boolean r0 = false;
        Iterator<Map.Entry<K, V>> r7 = r6.entries().iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r0 = r0 | put(r2.getKey(), r2.getValue());
        goto L4
    L6:
        return r0;
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    public Collection<V> remove(Object r2) {
        return CollectionUtils.emptyIfNull((Collection) ZeusTransformUtils.preCheckCast(getMap().remove(r2), Collection.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    public boolean removeMapping(Object r4, Object r5) {
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(getMap().get(r4), Collection.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L6;
        return false;
    L6:
        boolean r6 = r0.remove(r5);
        if (r0.isEmpty() == false) goto L9;
        getMap().remove(r4);
    L9:
        return r6;
    }

    public void setMap(Map<K, ? extends Collection<V>> r3) {
        this.map = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    public int size() {
        Iterator<? extends Collection<V>> r4 = getMap().values().iterator();
        int r0 = 0;
    L4:
        if (r4.hasNext() == false) goto L6;
        r0 = r0 + ((Collection) ZeusTransformUtils.preCheckCast(r4.next(), Collection.class, "com.obric.memorydata.plugin")).size();
        goto L4
    L6:
        return r0;
    }

    public String toString() {
        return getMap().toString();
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    public Collection<V> values() {
        Collection<V> r0 = this.valuesView;
        if (r0 != null) goto L7;
        Values r1 = new Values(this, null);
        this.valuesView = r1;
        return r1;
    L7:
        return r0;
    }

    Collection<V> wrappedCollection(K r2) {
        return new WrappedCollection(this, r2);
    }
}
