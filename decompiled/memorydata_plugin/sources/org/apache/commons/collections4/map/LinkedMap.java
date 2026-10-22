package org.apache.commons.collections4.map;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.function.Predicate;
import org.apache.commons.collections4.iterators.UnmodifiableIterator;
import org.apache.commons.collections4.iterators.UnmodifiableListIterator;
import org.apache.commons.collections4.list.UnmodifiableList;

/* JADX INFO: loaded from: classes6.dex */
public class LinkedMap<K, V> extends AbstractLinkedMap<K, V> implements Serializable, Cloneable {
    private static final long serialVersionUID = 9077234323521161066L;

    static class LinkedMapList<K> extends AbstractList<K> {
        private final LinkedMap<K, ?> parent;

        LinkedMapList(LinkedMap<K, ?> r1) {
            this.parent = r1;
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object r1) {
            return this.parent.containsKey(r1);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean containsAll(Collection<?> r3) {
            Collection<?> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
            return this.parent.keySet().containsAll(r4);
        }

        @Override // java.util.AbstractList, java.util.List
        public K get(int r1) {
            return this.parent.get(r1);
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object r1) {
            return this.parent.indexOf(r1);
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public Iterator<K> iterator() {
            return UnmodifiableIterator.unmodifiableIterator(this.parent.keySet().iterator());
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object r1) {
            return this.parent.indexOf(r1);
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator<K> listIterator() {
            return UnmodifiableListIterator.umodifiableListIterator(super.listIterator());
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator<K> listIterator(int r1) {
            return UnmodifiableListIterator.umodifiableListIterator(super.listIterator(r1));
        }

        @Override // java.util.AbstractList, java.util.List
        public K remove(int r1) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean remove(Object r1) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean removeAll(Collection<?> r2) {
            Collection r1 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public boolean removeIf(Predicate<? super K> r2) {
            Predicate r1 = (Predicate) ZeusTransformUtils.wrapperContextForParams(r2, Predicate.class, "com.obric.memorydata.plugin");
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean retainAll(Collection<?> r2) {
            Collection r1 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.parent.size();
        }

        @Override // java.util.AbstractList, java.util.List
        public List<K> subList(int r1, int r2) {
            return UnmodifiableList.unmodifiableList(super.subList(r1, r2));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public Object[] toArray() {
            return this.parent.keySet().toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public <T> T[] toArray(T[] r1) {
            return (T[]) this.parent.keySet().toArray(r1);
        }
    }

    public LinkedMap() {
        super(16, 0.75f, 12);
    }

    public LinkedMap(int r1) {
        super(r1);
    }

    public LinkedMap(int r1, float r2) {
        super(r1, r2);
    }

    public LinkedMap(Map<? extends K, ? extends V> r3) {
        super((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin"));
    }

    private void readObject(ObjectInputStream r1) {
        r1.defaultReadObject();
        doReadObject(r1);
    }

    private void writeObject(ObjectOutputStream r1) {
        r1.defaultWriteObject();
        doWriteObject(r1);
    }

    public List<K> asList() {
        return new LinkedMapList(this);
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap, java.util.AbstractMap
    public /* bridge */ /* synthetic */ Object clone() {
        return clone();
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap, java.util.AbstractMap
    public /* bridge */ /* synthetic */ AbstractHashedMap clone() {
        return clone();
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap, java.util.AbstractMap
    public LinkedMap<K, V> clone() {
        return (LinkedMap) ZeusTransformUtils.preCheckCast(super.clone(), LinkedMap.class, "com.obric.memorydata.plugin");
    }

    public K get(int r1) {
        return getEntry(r1).getKey();
    }

    public V getValue(int r1) {
        return getEntry(r1).getValue();
    }

    public int indexOf(Object r4) {
        Object r5 = convertKey(r4);
        AbstractLinkedMap.LinkEntry<K, V> r0 = this.header.after;
        int r1 = 0;
    L4:
        if (r0 == this.header) goto L9;
        if (isEqualKey(r5, r0.key) == true) goto L7;
        r0 = r0.after;
        r1 = r1 + 1;
        goto L4
    L7:
        return r1;
    L9:
        return -1;
    }

    public V remove(int r1) {
        return remove(get(r1));
    }
}
