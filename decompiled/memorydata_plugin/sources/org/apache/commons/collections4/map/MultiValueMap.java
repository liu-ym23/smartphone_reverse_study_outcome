package org.apache.commons.collections4.map;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Factory;
import org.apache.commons.collections4.FunctorException;
import org.apache.commons.collections4.MultiMap;
import org.apache.commons.collections4.iterators.EmptyIterator;
import org.apache.commons.collections4.iterators.IteratorChain;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public class MultiValueMap<K, V> extends AbstractMapDecorator<K, Object> implements Serializable, MultiMap<K, V> {
    private static final long serialVersionUID = -2214159910087182007L;
    private final Factory<? extends Collection<V>> collectionFactory;
    private transient Collection<V> valuesView;

    private static class ReflectionFactory<T extends Collection<?>> implements Serializable, Factory<T> {
        private static final long serialVersionUID = 2986114157496788874L;
        private final Class<T> clazz;

        public ReflectionFactory(Class<T> r1) {
            this.clazz = r1;
        }

        private void readObject(ObjectInputStream r1) {
            r1.defaultReadObject();
            Class<T> r0 = this.clazz;
            if (r0 != null) goto L5;
            return;
        L5:
            if (Collection.class.isAssignableFrom(r0) == false) goto L8;
            return;
        L8:
            throw new UnsupportedOperationException();
        }

        @Override // org.apache.commons.collections4.Factory
        public /* bridge */ /* synthetic */ Object create() {
            return create();
        }

        @Override // org.apache.commons.collections4.Factory
        public T create() {
            return (T) ZeusTransformUtils.preCheckCast(this.clazz.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]), Collection.class, "com.obric.memorydata.plugin");
        L4:
            e = move-exception;
            throw new FunctorException("Cannot instantiate class: " + this.clazz, e);
        }
    }

    private class Values extends AbstractCollection<V> {
        final /* synthetic */ MultiValueMap this$0;

        private Values(MultiValueMap r1) {
            this.this$0 = r1;
        }

        /* synthetic */ Values(MultiValueMap r1, AnonymousClass1 r2) {
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
            return this.this$0.totalSize();
        }
    }

    private class ValuesIterator implements Iterator<V> {
        private final Iterator<V> iterator;
        private final Object key;
        final /* synthetic */ MultiValueMap this$0;
        private final Collection<V> values;

        public ValuesIterator(MultiValueMap r1, Object r2) {
            this.this$0 = r1;
            this.key = r2;
            Collection<V> r3 = r1.getCollection(r2);
            this.values = r3;
            this.iterator = r3.iterator();
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

    public MultiValueMap() {
        this(new HashMap(), new ReflectionFactory(ArrayList.class));
    }

    public <C extends Collection<V>> MultiValueMap(Map<K, ? super C> r3, Factory<C> r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        Factory<? extends Collection<V>> r6 = (Factory) ZeusTransformUtils.wrapperContextForParams(r4, Factory.class, "com.obric.memorydata.plugin");
        super(r5);
        if (r6 == null) goto L7;
        this.collectionFactory = r6;
        return;
    L7:
        throw new IllegalArgumentException("The factory must not be null");
    }

    public static <K, V> MultiValueMap<K, V> multiValueMap(Map<K, ? super Collection<V>> r2) {
        return multiValueMap((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin"), ArrayList.class);
    }

    public static <K, V, C extends Collection<V>> MultiValueMap<K, V> multiValueMap(Map<K, ? super C> r2, Class<C> r3) {
        return new MultiValueMap((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin"), new ReflectionFactory(r3));
    }

    public static <K, V, C extends Collection<V>> MultiValueMap<K, V> multiValueMap(Map<K, ? super C> r2, Factory<C> r3) {
        return new MultiValueMap((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin"), (Factory) ZeusTransformUtils.wrapperContextForParams(r3, Factory.class, "com.obric.memorydata.plugin"));
    }

    private void readObject(ObjectInputStream r3) {
        r3.defaultReadObject();
        this.map = (Map) ZeusTransformUtils.preCheckCast(r3.readObject(), Map.class, "com.obric.memorydata.plugin");
    }

    private void writeObject(ObjectOutputStream r1) {
        r1.defaultWriteObject();
        r1.writeObject(this.map);
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map
    public void clear() {
        decorated().clear();
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map
    public boolean containsValue(Object r4) {
        Set<Map.Entry<K, V>> r3 = decorated().entrySet();
        if (r3 == null) goto L11;
        Iterator<Map.Entry<K, V>> r5 = r3.iterator();
    L6:
        if (r5.hasNext() == false) goto L16;
        if (((Collection) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), Collection.class, "com.obric.memorydata.plugin")).contains(r4) == false) goto L6;
        return true;
    L16:
        return false;
    L11:
        return false;
    }

    public boolean containsValue(Object r1, Object r2) {
        Collection<V> r0 = getCollection(r1);
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.contains(r2);
    }

    public Collection<V> createCollection(int r2) {
        return (Collection) ZeusTransformUtils.preCheckCast(this.collectionFactory.create(), Collection.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map
    public Set<Map.Entry<K, Object>> entrySet() {
        return super.entrySet();
    }

    public Collection<V> getCollection(Object r2) {
        return (Collection) ZeusTransformUtils.preCheckCast(decorated().get(r2), Collection.class, "com.obric.memorydata.plugin");
    }

    public Iterator<Map.Entry<K, V>> iterator() {
        final Iterator r0 = new ArrayList(keySet()).iterator();
        return new AnonymousClass1(this, r0);
    }

    public Iterator<V> iterator(Object r2) {
        if (containsKey(r2) == true) goto L7;
        return EmptyIterator.emptyIterator();
    L7:
        return new ValuesIterator(this, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map
    public Object put(K r4, Object r5) {
        Collection<V> r0 = getCollection(r4);
        boolean r1 = true;
        if (r0 != null) goto L8;
        Collection<V> r2 = createCollection(1);
        r2.add(r5);
        if (r2.size() <= 0) goto L7;
        decorated().put(r4, r2);
    L9:
        if (r1 == true) goto L13;
        return null;
    L13:
        return r5;
    L7:
        r1 = false;
        goto L9
    L8:
        r1 = r0.add(r5);
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map
    public void putAll(Map<? extends K, ?> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, MultiMap.class) == false) goto L8;
        Iterator r7 = ((MultiMap) ZeusTransformUtils.preCheckCast(r6, MultiMap.class, "com.obric.memorydata.plugin")).entrySet().iterator();
    L6:
        if (r7.hasNext() == false) goto L12;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        putAll(r0.getKey(), (Collection) ZeusTransformUtils.preCheckCast(r0.getValue(), Collection.class, "com.obric.memorydata.plugin"));
        goto L6
    L12:
        return;
    L8:
        Iterator<Map.Entry<K, V>> r8 = r6.entrySet().iterator();
    L10:
        if (r8.hasNext() == false) goto L15;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        put(r1.getKey(), r1.getValue());
        goto L10
    }

    public boolean putAll(K r3, Collection<V> r4) {
        Collection<? extends V> r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L5;
        return false;
    L5:
        if (r5.size() == 0) goto L17;
        Collection<V> r1 = getCollection(r3);
        if (r1 != null) goto L13;
        Collection<V> r2 = createCollection(r5.size());
        r2.addAll(r5);
        if (r2.size() <= 0) goto L15;
        decorated().put(r3, r2);
        return true;
    L15:
        return false;
    L13:
        return r1.addAll(r5);
    L17:
        return false;
    }

    public boolean removeMapping(Object r3, Object r4) {
        Collection<V> r0 = getCollection(r3);
        if (r0 != null) goto L6;
        return false;
    L6:
        if (r0.remove(r4) == true) goto L9;
        return false;
    L9:
        if (r0.isEmpty() == false) goto L13;
        remove(r3);
        return true;
    L13:
        return true;
    }

    public int size(Object r1) {
        Collection<V> r0 = getCollection(r1);
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.size();
    }

    public int totalSize() {
        Iterator<V> r2 = decorated().values().iterator();
        int r0 = 0;
    L4:
        if (r2.hasNext() == false) goto L6;
        r0 = r0 + CollectionUtils.size(r2.next());
        goto L4
    L6:
        return r0;
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map
    public Collection<Object> values() {
        Collection<V> r0 = this.valuesView;
        if (r0 != null) goto L7;
        Values r1 = new Values(this, null);
        this.valuesView = r1;
        return r1;
    L7:
        return r0;
    }
}
