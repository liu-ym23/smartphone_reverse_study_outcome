package org.apache.commons.collections4.multiset;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import org.apache.commons.collections4.MultiSet;
import org.apache.commons.collections4.iterators.AbstractIteratorDecorator;

/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractMapMultiSet<E> extends AbstractMultiSet<E> {
    private transient Map<E, MutableInteger> map;
    private transient int modCount;
    private transient int size;

    protected static class EntrySetIterator<E> implements Iterator<MultiSet.Entry<E>> {
        protected boolean canRemove;
        protected final Iterator<Map.Entry<E, MutableInteger>> decorated;
        protected MultiSet.Entry<E> last;
        protected final AbstractMapMultiSet<E> parent;

        public EntrySetIterator(Iterator<Map.Entry<E, MutableInteger>> r3, AbstractMapMultiSet<E> r4) {
            Iterator<Map.Entry<E, MutableInteger>> r5 = (Iterator) ZeusTransformUtils.wrapperContextForParams(r3, Iterator.class, "com.obric.memorydata.plugin");
            this.last = null;
            this.canRemove = false;
            this.decorated = r5;
            this.parent = r4;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.decorated.hasNext();
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return next();
        }

        @Override // java.util.Iterator
        public MultiSet.Entry<E> next() {
            MultiSetEntry r0 = new MultiSetEntry((Map.Entry) ZeusTransformUtils.preCheckCast(this.decorated.next(), Map.Entry.class, "com.obric.memorydata.plugin"));
            this.last = r0;
            this.canRemove = true;
            return r0;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.canRemove == false) goto L7;
            this.decorated.remove();
            this.last = null;
            this.canRemove = false;
            return;
        L7:
            throw new IllegalStateException("Iterator remove() can only be called once after next()");
        }
    }

    private static class MapBasedMultiSetIterator<E> implements Iterator<E> {
        private boolean canRemove;
        private Map.Entry<E, MutableInteger> current;
        private final Iterator<Map.Entry<E, MutableInteger>> entryIterator;
        private int itemCount;
        private final int mods;
        private final AbstractMapMultiSet<E> parent;

        public MapBasedMultiSetIterator(AbstractMapMultiSet<E> r2) {
            this.parent = r2;
            this.entryIterator = AbstractMapMultiSet.access$000(r2).entrySet().iterator();
            this.current = null;
            this.mods = AbstractMapMultiSet.access$100(r2);
            this.canRemove = false;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.itemCount <= 0) goto L5;
        L8:
            return true;
        L5:
            if (this.entryIterator.hasNext() == true) goto L8;
            return false;
        }

        @Override // java.util.Iterator
        public E next() {
            if (AbstractMapMultiSet.access$100(this.parent) != this.mods) goto L10;
            if (this.itemCount != 0) goto L7;
            Map.Entry<E, MutableInteger> r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(this.entryIterator.next(), Map.Entry.class, "com.obric.memorydata.plugin");
            this.current = r0;
            this.itemCount = ((MutableInteger) ZeusTransformUtils.preCheckCast(r0.getValue(), MutableInteger.class, "com.obric.memorydata.plugin")).value;
        L7:
            this.canRemove = true;
            this.itemCount--;
            return this.current.getKey();
        L10:
            throw new ConcurrentModificationException();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (AbstractMapMultiSet.access$100(this.parent) != this.mods) goto L15;
            if (this.canRemove == false) goto L13;
            MutableInteger r0 = (MutableInteger) ZeusTransformUtils.preCheckCast(this.current.getValue(), MutableInteger.class, "com.obric.memorydata.plugin");
            if (r0.value <= 1) goto L9;
            r0.value--;
        L10:
            AbstractMapMultiSet.access$210(this.parent);
            this.canRemove = false;
            return;
        L9:
            this.entryIterator.remove();
            goto L10
        L13:
            throw new IllegalStateException();
        L15:
            throw new ConcurrentModificationException();
        }
    }

    protected static class MultiSetEntry<E> extends AbstractMultiSet.AbstractEntry<E> {
        protected final Map.Entry<E, MutableInteger> parentEntry;

        public MultiSetEntry(Map.Entry<E, MutableInteger> r3) {
            this.parentEntry = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r3, Map.Entry.class, "com.obric.memorydata.plugin");
        }

        @Override // org.apache.commons.collections4.MultiSet.Entry
        public int getCount() {
            return ((MutableInteger) ZeusTransformUtils.preCheckCast(this.parentEntry.getValue(), MutableInteger.class, "com.obric.memorydata.plugin")).value;
        }

        @Override // org.apache.commons.collections4.MultiSet.Entry
        public E getElement() {
            return this.parentEntry.getKey();
        }
    }

    protected static class MutableInteger {
        protected int value;

        MutableInteger(int r1) {
            this.value = r1;
        }

        public boolean equals(Object r4) {
            if (ZeusTransformUtils.instanceOf(r4, MutableInteger.class) == true) goto L6;
            return false;
        L6:
            if (((MutableInteger) ZeusTransformUtils.preCheckCast(r4, MutableInteger.class, "com.obric.memorydata.plugin")).value != this.value) goto L9;
            return true;
        L9:
            return false;
        }

        public int hashCode() {
            return this.value;
        }
    }

    protected static class UniqueSetIterator<E> extends AbstractIteratorDecorator<E> {
        protected boolean canRemove;
        protected E lastElement;
        protected final AbstractMapMultiSet<E> parent;

        public UniqueSetIterator(Iterator<E> r3, AbstractMapMultiSet<E> r4) {
            super((Iterator) ZeusTransformUtils.wrapperContextForParams(r3, Iterator.class, "com.obric.memorydata.plugin"));
            this.lastElement = null;
            this.canRemove = false;
            this.parent = r4;
        }

        @Override // org.apache.commons.collections4.iterators.AbstractIteratorDecorator, java.util.Iterator
        public E next() {
            E r0 = (E) super.next();
            this.lastElement = r0;
            this.canRemove = true;
            return r0;
        }

        @Override // org.apache.commons.collections4.iterators.AbstractUntypedIteratorDecorator, java.util.Iterator
        public void remove() {
            if (this.canRemove == false) goto L7;
            int r0 = this.parent.getCount(this.lastElement);
            super.remove();
            this.parent.remove(this.lastElement, r0);
            this.lastElement = null;
            this.canRemove = false;
            return;
        L7:
            throw new IllegalStateException("Iterator remove() can only be called once after next()");
        }
    }

    public AbstractMapMultiSet() {
    }

    public AbstractMapMultiSet(Map<E, MutableInteger> r3) {
        this.map = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
    }

    static /* synthetic */ Map access$000(AbstractMapMultiSet r0) {
        return r0.map;
    }

    static /* synthetic */ int access$100(AbstractMapMultiSet r0) {
        return r0.modCount;
    }

    static /* synthetic */ int access$210(AbstractMapMultiSet r2) {
        int r0 = r2.size;
        r2.size = r0 - 1;
        return r0;
    }

    @Override // org.apache.commons.collections4.multiset.AbstractMultiSet, org.apache.commons.collections4.MultiSet
    public int add(E r4, int r5) {
        if (r5 < 0) goto L14;
        MutableInteger r0 = (MutableInteger) ZeusTransformUtils.preCheckCast(this.map.get(r4), MutableInteger.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L6;
        int r1 = r0.value;
    L7:
        if (r5 <= 0) goto L12;
        this.modCount++;
        this.size += r5;
        if (r0 != null) goto L11;
        this.map.put(r4, new MutableInteger(r5));
        goto L12
    L11:
        r0.value += r5;
    L12:
        return r1;
    L6:
        r1 = 0;
        goto L7
    L14:
        throw new IllegalArgumentException("Occurrences must not be negative.");
    }

    @Override // org.apache.commons.collections4.multiset.AbstractMultiSet, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        this.modCount++;
        this.map.clear();
        this.size = 0;
    }

    @Override // org.apache.commons.collections4.multiset.AbstractMultiSet, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object r1) {
        return this.map.containsKey(r1);
    }

    @Override // org.apache.commons.collections4.multiset.AbstractMultiSet
    public Iterator<MultiSet.Entry<E>> createEntrySetIterator() {
        return new EntrySetIterator(this.map.entrySet().iterator(), this);
    }

    @Override // org.apache.commons.collections4.multiset.AbstractMultiSet
    public Iterator<E> createUniqueSetIterator() {
        return new UniqueSetIterator(getMap().keySet().iterator(), this);
    }

    @Override // org.apache.commons.collections4.multiset.AbstractMultiSet
    public void doReadObject(ObjectInputStream r7) {
        int r0 = r7.readInt();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        Object r2 = r7.readObject();
        int r3 = r7.readInt();
        this.map.put((E) r2, new MutableInteger(r3));
        this.size += r3;
        r1 = r1 + 1;
        goto L3
    }

    @Override // org.apache.commons.collections4.multiset.AbstractMultiSet
    public void doWriteObject(ObjectOutputStream r4) {
        r4.writeInt(this.map.size());
        Iterator<Map.Entry<E, MutableInteger>> r3 = this.map.entrySet().iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r4.writeObject(r0.getKey());
        r4.writeInt(((MutableInteger) ZeusTransformUtils.preCheckCast(r0.getValue(), MutableInteger.class, "com.obric.memorydata.plugin")).value);
        goto L4
    }

    @Override // org.apache.commons.collections4.multiset.AbstractMultiSet, java.util.Collection, org.apache.commons.collections4.MultiSet
    public boolean equals(Object r6) {
        if (r6 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r6, MultiSet.class) == true) goto L8;
        return false;
    L8:
        MultiSet r7 = (MultiSet) ZeusTransformUtils.preCheckCast(r6, MultiSet.class, "com.obric.memorydata.plugin");
        if (r7.size() == size()) goto L11;
        return false;
    L11:
        Iterator<E> r1 = this.map.keySet().iterator();
    L13:
        if (r1.hasNext() == false) goto L17;
        E r3 = r1.next();
        if (r7.getCount(r3) == getCount(r3)) goto L13;
        return false;
    L17:
        return true;
    }

    @Override // org.apache.commons.collections4.multiset.AbstractMultiSet, org.apache.commons.collections4.MultiSet
    public int getCount(Object r2) {
        MutableInteger r1 = (MutableInteger) ZeusTransformUtils.preCheckCast(this.map.get(r2), MutableInteger.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L5;
        return 0;
    L5:
        return r1.value;
    }

    public Map<E, MutableInteger> getMap() {
        return this.map;
    }

    @Override // org.apache.commons.collections4.multiset.AbstractMultiSet, java.util.Collection, org.apache.commons.collections4.MultiSet
    public int hashCode() {
        Iterator<Map.Entry<E, MutableInteger>> r6 = this.map.entrySet().iterator();
        int r1 = 0;
    L4:
        if (r6.hasNext() == false) goto L10;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r6.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        Object r3 = r2.getKey();
        MutableInteger r4 = (MutableInteger) ZeusTransformUtils.preCheckCast(r2.getValue(), MutableInteger.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L8;
        int r5 = 0;
    L9:
        r1 = r1 + (r4.value ^ r5);
        goto L4
    L8:
        r5 = r3.hashCode();
        goto L9
    L10:
        return r1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    @Override // org.apache.commons.collections4.multiset.AbstractMultiSet, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, org.apache.commons.collections4.MultiSet
    public Iterator<E> iterator() {
        return new MapBasedMultiSetIterator(this);
    }

    @Override // org.apache.commons.collections4.multiset.AbstractMultiSet, org.apache.commons.collections4.MultiSet
    public int remove(Object r5, int r6) {
        if (r6 < 0) goto L14;
        MutableInteger r0 = (MutableInteger) ZeusTransformUtils.preCheckCast(this.map.get(r5), MutableInteger.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L6;
        return 0;
    L6:
        int r2 = r0.value;
        if (r6 <= 0) goto L12;
        this.modCount++;
        if (r6 >= r0.value) goto L11;
        r0.value -= r6;
        this.size -= r6;
        goto L12
    L11:
        this.map.remove(r5);
        this.size -= r0.value;
        r0.value = 0;
    L12:
        return r2;
    L14:
        throw new IllegalArgumentException("Occurrences must not be negative.");
    }

    public void setMap(Map<E, MutableInteger> r3) {
        this.map = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.commons.collections4.multiset.AbstractMultiSet, java.util.AbstractCollection, java.util.Collection, org.apache.commons.collections4.MultiSet
    public int size() {
        return this.size;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        Object[] r0 = new Object[size()];
        Iterator<Map.Entry<E, MutableInteger>> r6 = this.map.entrySet().iterator();
        int r1 = 0;
    L4:
        if (r6.hasNext() == false) goto L8;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r6.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        Object r3 = r2.getKey();
        int r4 = ((MutableInteger) ZeusTransformUtils.preCheckCast(r2.getValue(), MutableInteger.class, "com.obric.memorydata.plugin")).value;
    L6:
        if (r4 <= 0) goto L4;
        r0[r1] = r3;
        r4 = r4 - 1;
        r1 = r1 + 1;
        goto L6
    L8:
        return r0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public <T> T[] toArray(T[] r6) {
        int r0 = size();
        if (r6.length >= r0) goto L5;
        r6 = (T[]) ((Object[]) ZeusTransformUtils.preCheckCast((Object[]) ZeusTransformUtils.preCheckCast(Array.newInstance(r6.getClass().getComponentType(), r0), Object[].class, "com.obric.memorydata.plugin"), Object[].class, "com.obric.memorydata.plugin"));
    L5:
        int r1 = 0;
        Iterator<Map.Entry<E, MutableInteger>> r5 = this.map.entrySet().iterator();
    L7:
        if (r5.hasNext() == false) goto L12;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        Object r3 = r2.getKey();
        int r4 = ((MutableInteger) ZeusTransformUtils.preCheckCast(r2.getValue(), MutableInteger.class, "com.obric.memorydata.plugin")).value;
    L9:
        if (r4 <= 0) goto L7;
        r6[r1] = r3;
        r4 = r4 - 1;
        r1 = r1 + 1;
    L12:
        if (r1 >= r6.length) goto L14;
        r6[r1] = null;
        r1 = r1 + 1;
        goto L12
    L14:
        return r6;
    }

    @Override // org.apache.commons.collections4.multiset.AbstractMultiSet
    public int uniqueElements() {
        return this.map.size();
    }
}
