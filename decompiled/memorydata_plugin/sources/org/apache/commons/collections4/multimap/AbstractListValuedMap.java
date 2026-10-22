package org.apache.commons.collections4.multimap;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import org.apache.commons.collections4.ListUtils;
import org.apache.commons.collections4.ListValuedMap;

/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractListValuedMap<K, V> extends AbstractMultiValuedMap<K, V> implements ListValuedMap<K, V> {

    private class ValuesListIterator implements ListIterator<V> {
        private ListIterator<V> iterator;
        private final K key;
        final /* synthetic */ AbstractListValuedMap this$0;
        private List<V> values;

        public ValuesListIterator(AbstractListValuedMap r2, K r3) {
            this.this$0 = r2;
            this.key = r3;
            List<V> r4 = ListUtils.emptyIfNull((List) ZeusTransformUtils.preCheckCast(r2.getMap().get(r3), List.class, "com.obric.memorydata.plugin"));
            this.values = r4;
            this.iterator = r4.listIterator();
        }

        public ValuesListIterator(AbstractListValuedMap r2, K r3, int r4) {
            this.this$0 = r2;
            this.key = r3;
            List<V> r5 = ListUtils.emptyIfNull((List) ZeusTransformUtils.preCheckCast(r2.getMap().get(r3), List.class, "com.obric.memorydata.plugin"));
            this.values = r5;
            this.iterator = r5.listIterator(r4);
        }

        @Override // java.util.ListIterator
        public void add(V r4) {
            if (this.this$0.getMap().get(this.key) != null) goto L5;
            List<V> r0 = this.this$0.createCollection();
            this.this$0.getMap().put(this.key, r0);
            this.values = r0;
            this.iterator = r0.listIterator();
        L5:
            this.iterator.add(r4);
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.iterator.hasPrevious();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public V next() {
            return this.iterator.next();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.iterator.nextIndex();
        }

        @Override // java.util.ListIterator
        public V previous() {
            return this.iterator.previous();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.iterator.previousIndex();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            this.iterator.remove();
            if (this.values.isEmpty() == false) goto L6;
            this.this$0.getMap().remove(this.key);
            return;
        }

        @Override // java.util.ListIterator
        public void set(V r1) {
            this.iterator.set(r1);
        }
    }

    private class WrappedList extends AbstractMultiValuedMap<K, V>.WrappedCollection implements List<V> {
        final /* synthetic */ AbstractListValuedMap this$0;

        public WrappedList(AbstractListValuedMap r1, K r2) {
            this.this$0 = r1;
            super(r1, r2);
        }

        @Override // java.util.List
        public void add(int r3, V r4) {
            List<V> r0 = getMapping();
            if (r0 != null) goto L5;
            r0 = this.this$0.createCollection();
            this.this$0.getMap().put(this.key, r0);
        L5:
            r0.add(r3, r4);
        }

        @Override // java.util.List
        public boolean addAll(int r3, Collection<? extends V> r4) {
            Collection<? extends V> r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.memorydata.plugin");
            List<V> r0 = getMapping();
            if (r0 != null) goto L9;
            List<V> r1 = this.this$0.createCollection();
            boolean r6 = r1.addAll(r3, r5);
            if (r6 == false) goto L7;
            this.this$0.getMap().put(this.key, r1);
        L7:
            return r6;
        L9:
            return r0.addAll(r3, r5);
        }

        @Override // java.util.Collection, java.util.List
        public boolean equals(Object r3) {
            List<V> r2 = getMapping();
            if (r2 != null) goto L7;
            return Collections.emptyList().equals(r3);
        L7:
            if (ZeusTransformUtils.instanceOf(r3, List.class) == true) goto L11;
            return false;
        L11:
            return ListUtils.isEqualList(r2, (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin"));
        }

        @Override // java.util.List
        public V get(int r1) {
            return (V) ListUtils.emptyIfNull(getMapping()).get(r1);
        }

        @Override // org.apache.commons.collections4.multimap.AbstractMultiValuedMap.WrappedCollection
        public /* bridge */ /* synthetic */ Collection getMapping() {
            return getMapping();
        }

        @Override // org.apache.commons.collections4.multimap.AbstractMultiValuedMap.WrappedCollection
        public List<V> getMapping() {
            return (List) ZeusTransformUtils.preCheckCast(this.this$0.getMap().get(this.key), List.class, "com.obric.memorydata.plugin");
        }

        @Override // java.util.Collection, java.util.List
        public int hashCode() {
            return ListUtils.hashCodeForList(getMapping());
        }

        @Override // java.util.List
        public int indexOf(Object r1) {
            return ListUtils.emptyIfNull(getMapping()).indexOf(r1);
        }

        @Override // java.util.List
        public int lastIndexOf(Object r1) {
            return ListUtils.emptyIfNull(getMapping()).lastIndexOf(r1);
        }

        @Override // java.util.List
        public ListIterator<V> listIterator() {
            return new ValuesListIterator(this.this$0, this.key);
        }

        @Override // java.util.List
        public ListIterator<V> listIterator(int r3) {
            return new ValuesListIterator(this.this$0, this.key, r3);
        }

        @Override // java.util.List
        public V remove(int r2) {
            List r0 = ListUtils.emptyIfNull(getMapping());
            V r3 = (V) r0.remove(r2);
            if (r0.isEmpty() == false) goto L5;
            this.this$0.remove(this.key);
        L5:
            return r3;
        }

        @Override // java.util.List
        public V set(int r1, V r2) {
            return (V) ListUtils.emptyIfNull(getMapping()).set(r1, r2);
        }

        @Override // java.util.List
        public List<V> subList(int r1, int r2) {
            return ListUtils.emptyIfNull(getMapping()).subList(r1, r2);
        }
    }

    public AbstractListValuedMap() {
    }

    public AbstractListValuedMap(Map<K, ? extends List<V>> r3) {
        super((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.commons.collections4.multimap.AbstractMultiValuedMap
    public /* bridge */ /* synthetic */ Collection createCollection() {
        return createCollection();
    }

    @Override // org.apache.commons.collections4.multimap.AbstractMultiValuedMap
    public abstract List<V> createCollection();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.collections4.multimap.AbstractMultiValuedMap, org.apache.commons.collections4.MultiValuedMap
    public /* bridge */ /* synthetic */ Collection get(Object r1) {
        return get(r1);
    }

    @Override // org.apache.commons.collections4.multimap.AbstractMultiValuedMap, org.apache.commons.collections4.MultiValuedMap
    public List<V> get(K r1) {
        return wrappedCollection(r1);
    }

    @Override // org.apache.commons.collections4.multimap.AbstractMultiValuedMap
    public Map<K, List<V>> getMap() {
        return super.getMap();
    }

    @Override // org.apache.commons.collections4.multimap.AbstractMultiValuedMap, org.apache.commons.collections4.MultiValuedMap
    public /* bridge */ /* synthetic */ Collection remove(Object r1) {
        return remove(r1);
    }

    @Override // org.apache.commons.collections4.multimap.AbstractMultiValuedMap, org.apache.commons.collections4.MultiValuedMap
    public List<V> remove(Object r2) {
        return ListUtils.emptyIfNull((List) ZeusTransformUtils.preCheckCast(getMap().remove(r2), List.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.collections4.multimap.AbstractMultiValuedMap
    /* bridge */ /* synthetic */ Collection wrappedCollection(Object r1) {
        return wrappedCollection(r1);
    }

    @Override // org.apache.commons.collections4.multimap.AbstractMultiValuedMap
    List<V> wrappedCollection(K r2) {
        return new WrappedList(this, r2);
    }
}
