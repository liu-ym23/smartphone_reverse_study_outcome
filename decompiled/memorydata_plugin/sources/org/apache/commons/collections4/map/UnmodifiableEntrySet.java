package org.apache.commons.collections4.map;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import org.apache.commons.collections4.Unmodifiable;
import org.apache.commons.collections4.iterators.AbstractIteratorDecorator;
import org.apache.commons.collections4.keyvalue.AbstractMapEntryDecorator;
import org.apache.commons.collections4.set.AbstractSetDecorator;

/* JADX INFO: loaded from: classes6.dex */
public final class UnmodifiableEntrySet<K, V> extends AbstractSetDecorator<Map.Entry<K, V>> implements Unmodifiable {
    private static final long serialVersionUID = 1678353579659253473L;

    private class UnmodifiableEntry extends AbstractMapEntryDecorator<K, V> {
        final /* synthetic */ UnmodifiableEntrySet this$0;

        public UnmodifiableEntry(UnmodifiableEntrySet r3, Map.Entry<K, V> r4) {
            Map.Entry r5 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r4, Map.Entry.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // org.apache.commons.collections4.keyvalue.AbstractMapEntryDecorator, java.util.Map.Entry
        public V setValue(V r1) {
            throw new UnsupportedOperationException();
        }
    }

    private class UnmodifiableEntrySetIterator extends AbstractIteratorDecorator<Map.Entry<K, V>> {
        final /* synthetic */ UnmodifiableEntrySet this$0;

        public UnmodifiableEntrySetIterator(UnmodifiableEntrySet r3, Iterator<Map.Entry<K, V>> r4) {
            Iterator r5 = (Iterator) ZeusTransformUtils.wrapperContextForParams(r4, Iterator.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // org.apache.commons.collections4.iterators.AbstractIteratorDecorator, java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return next();
        }

        @Override // org.apache.commons.collections4.iterators.AbstractIteratorDecorator, java.util.Iterator
        public Map.Entry<K, V> next() {
            return new UnmodifiableEntry(this.this$0, (Map.Entry) ZeusTransformUtils.preCheckCast(getIterator().next(), Map.Entry.class, "com.obric.memorydata.plugin"));
        }

        @Override // org.apache.commons.collections4.iterators.AbstractUntypedIteratorDecorator, java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private UnmodifiableEntrySet(Set<Map.Entry<K, V>> r3) {
        super((Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin"));
    }

    public static <K, V> Set<Map.Entry<K, V>> unmodifiableEntrySet(Set<Map.Entry<K, V>> r2) {
        Set<Map.Entry<K, V>> r3 = (Set) ZeusTransformUtils.wrapperContextForParams(r2, Set.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, Unmodifiable.class) == false) goto L6;
        return r3;
    L6:
        return new UnmodifiableEntrySet(r3);
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection
    public /* synthetic */ boolean add(Object r3) {
        return add((Map.Entry) ZeusTransformUtils.preCheckCast(r3, Map.Entry.class, "com.obric.memorydata.plugin"));
    }

    public boolean add(Map.Entry<K, V> r2) {
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r2, Map.Entry.class, "com.obric.memorydata.plugin");
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection
    public boolean addAll(Collection<? extends Map.Entry<K, V>> r2) {
        Collection r1 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, java.lang.Iterable, org.apache.commons.collections4.Bag
    public Iterator<Map.Entry<K, V>> iterator() {
        return new UnmodifiableEntrySetIterator(this, decorated().iterator());
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection
    public boolean remove(Object r1) {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections4.Bag
    public boolean removeAll(Collection<?> r2) {
        Collection r1 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection
    public boolean removeIf(Predicate<? super Map.Entry<K, V>> r2) {
        Predicate r1 = (Predicate) ZeusTransformUtils.wrapperContextForParams(r2, Predicate.class, "com.obric.memorydata.plugin");
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections4.Bag
    public boolean retainAll(Collection<?> r2) {
        Collection r1 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection
    public Object[] toArray() {
        Object[] r0 = decorated().toArray();
        int r1 = 0;
    L4:
        if (r1 >= r0.length) goto L6;
        r0[r1] = new UnmodifiableEntry(this, (Map.Entry) ZeusTransformUtils.preCheckCast(r0[r1], Map.Entry.class, "com.obric.memorydata.plugin"));
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection
    public <T> T[] toArray(T[] r8) {
        if (r8.length <= 0) goto L5;
        Object[] r0 = (Object[]) ZeusTransformUtils.preCheckCast((Object[]) ZeusTransformUtils.preCheckCast(Array.newInstance(r8.getClass().getComponentType(), 0), Object[].class, "com.obric.memorydata.plugin"), Object[].class, "com.obric.memorydata.plugin");
    L6:
        Object[] r1 = decorated().toArray(r0);
        int r3 = 0;
    L8:
        if (r3 >= r1.length) goto L11;
        r1[r3] = new UnmodifiableEntry(this, (Map.Entry) ZeusTransformUtils.preCheckCast(r1[r3], Map.Entry.class, "com.obric.memorydata.plugin"));
        r3 = r3 + 1;
        goto L8
    L11:
        if (r1.length > r8.length) goto L13;
        System.arraycopy(r1, 0, r8, 0, r1.length);
        if (r8.length <= r1.length) goto L17;
        r8[r1.length] = null;
    L17:
        return r8;
    L13:
        return (T[]) ((Object[]) ZeusTransformUtils.preCheckCast(r1, Object[].class, "com.obric.memorydata.plugin"));
    L5:
        r0 = r8;
        goto L6
    }
}
