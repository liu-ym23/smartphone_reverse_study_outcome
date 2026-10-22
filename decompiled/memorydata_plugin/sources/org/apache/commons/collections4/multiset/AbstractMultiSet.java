package org.apache.commons.collections4.multiset;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import org.apache.commons.collections4.IteratorUtils;
import org.apache.commons.collections4.MultiSet;
import org.apache.commons.collections4.Transformer;

/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractMultiSet<E> extends AbstractCollection<E> implements MultiSet<E> {
    private transient Set<MultiSet.Entry<E>> entrySet;
    private transient Set<E> uniqueSet;

    protected static abstract class AbstractEntry<E> implements MultiSet.Entry<E> {
        public AbstractEntry() {
        }

        public boolean equals(Object r4) {
            if (ZeusTransformUtils.instanceOf(r4, MultiSet.Entry.class) == false) goto L12;
            MultiSet.Entry r5 = (MultiSet.Entry) ZeusTransformUtils.preCheckCast(r4, MultiSet.Entry.class, "com.obric.memorydata.plugin");
            E r0 = getElement();
            Object r2 = r5.getElement();
            if (getCount() != r5.getCount()) goto L13;
            if (r0 == r2) goto L10;
            if (r0 != null) goto L9;
            return false;
        L9:
            if (r0.equals(r2) == true) goto L10;
            return false;
        L10:
            return true;
        L13:
            return false;
        L12:
            return false;
        }

        public int hashCode() {
            E r0 = getElement();
            if (r0 != null) goto L5;
            int r1 = 0;
        L7:
            return getCount() ^ r1;
        L5:
            r1 = r0.hashCode();
            goto L7
        }

        public String toString() {
            return String.format("%s:%d", new Object[]{getElement(), Integer.valueOf(getCount())});
        }
    }

    protected static class EntrySet<E> extends AbstractSet<MultiSet.Entry<E>> {
        private final AbstractMultiSet<E> parent;

        public EntrySet(AbstractMultiSet<E> r1) {
            this.parent = r1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r4) {
            if (ZeusTransformUtils.instanceOf(r4, MultiSet.Entry.class) == true) goto L5;
            return false;
        L5:
            MultiSet.Entry r5 = (MultiSet.Entry) ZeusTransformUtils.preCheckCast(r4, MultiSet.Entry.class, "com.obric.memorydata.plugin");
            Object r0 = r5.getElement();
            if (this.parent.getCount(r0) != r5.getCount()) goto L9;
            return true;
        L9:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<MultiSet.Entry<E>> iterator() {
            return this.parent.createEntrySetIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object r4) {
            if (ZeusTransformUtils.instanceOf(r4, MultiSet.Entry.class) == true) goto L5;
            return false;
        L5:
            MultiSet.Entry r5 = (MultiSet.Entry) ZeusTransformUtils.preCheckCast(r4, MultiSet.Entry.class, "com.obric.memorydata.plugin");
            Object r0 = r5.getElement();
            if (this.parent.contains(r0) == false) goto L11;
            int r2 = this.parent.getCount(r0);
            if (r5.getCount() != r2) goto L11;
            this.parent.remove(r0, r2);
            return true;
        L11:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.parent.uniqueElements();
        }
    }

    private static class MultiSetIterator<E> implements Iterator<E> {
        private boolean canRemove;
        private MultiSet.Entry<E> current;
        private final Iterator<MultiSet.Entry<E>> entryIterator;
        private int itemCount;
        private final AbstractMultiSet<E> parent;

        public MultiSetIterator(AbstractMultiSet<E> r1) {
            this.parent = r1;
            this.entryIterator = r1.entrySet().iterator();
            this.current = null;
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
            if (this.itemCount != 0) goto L5;
            MultiSet.Entry<E> r0 = (MultiSet.Entry) ZeusTransformUtils.preCheckCast(this.entryIterator.next(), MultiSet.Entry.class, "com.obric.memorydata.plugin");
            this.current = r0;
            this.itemCount = r0.getCount();
        L5:
            this.canRemove = true;
            this.itemCount--;
            return this.current.getElement();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.canRemove == false) goto L11;
            if (this.current.getCount() <= 1) goto L7;
            this.parent.remove(this.current.getElement());
        L8:
            this.canRemove = false;
            return;
        L7:
            this.entryIterator.remove();
            goto L8
        L11:
            throw new IllegalStateException();
        }
    }

    protected static class UniqueSet<E> extends AbstractSet<E> {
        protected final AbstractMultiSet<E> parent;

        public UniqueSet(AbstractMultiSet<E> r1) {
            this.parent = r1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.parent.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r1) {
            return this.parent.contains(r1);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> r3) {
            Collection<?> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
            return this.parent.containsAll(r4);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<E> iterator() {
            return this.parent.createUniqueSetIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object r2) {
            AbstractMultiSet<E> r1 = this.parent;
            if (r1.remove(r2, r1.getCount(r2)) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.parent.uniqueElements();
        }
    }

    public AbstractMultiSet() {
    }

    public int add(E r1, int r2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean add(E r2) {
        add(r2, 1);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
        Iterator<MultiSet.Entry<E>> r1 = entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next();
        r1.remove();
        goto L4
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object r1) {
        if (getCount(r1) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public Set<MultiSet.Entry<E>> createEntrySet() {
        return new EntrySet(this);
    }

    public abstract Iterator<MultiSet.Entry<E>> createEntrySetIterator();

    public Set<E> createUniqueSet() {
        return new UniqueSet(this);
    }

    public Iterator<E> createUniqueSetIterator() {
        Transformer<MultiSet.Entry<E>, E> r0 = new AnonymousClass1(this);
        return IteratorUtils.transformedIterator(entrySet().iterator(), r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void doReadObject(ObjectInputStream r5) {
        int r0 = r5.readInt();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        setCount(r5.readObject(), r5.readInt());
        r1 = r1 + 1;
        goto L3
    }

    public void doWriteObject(ObjectOutputStream r4) {
        r4.writeInt(entrySet().size());
        Iterator<MultiSet.Entry<E>> r3 = entrySet().iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        MultiSet.Entry r0 = (MultiSet.Entry) ZeusTransformUtils.preCheckCast(r3.next(), MultiSet.Entry.class, "com.obric.memorydata.plugin");
        r4.writeObject(r0.getElement());
        r4.writeInt(r0.getCount());
        goto L4
    }

    @Override // org.apache.commons.collections4.MultiSet
    public Set<MultiSet.Entry<E>> entrySet() {
        if (this.entrySet != null) goto L6;
        this.entrySet = createEntrySet();
    L6:
        return this.entrySet;
    }

    @Override // java.util.Collection, org.apache.commons.collections4.MultiSet
    public boolean equals(Object r7) {
        if (r7 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, MultiSet.class) == true) goto L8;
        return false;
    L8:
        MultiSet r8 = (MultiSet) ZeusTransformUtils.preCheckCast(r7, MultiSet.class, "com.obric.memorydata.plugin");
        if (r8.size() == size()) goto L11;
        return false;
    L11:
        Iterator<MultiSet.Entry<E>> r1 = entrySet().iterator();
    L13:
        if (r1.hasNext() == false) goto L17;
        MultiSet.Entry r4 = (MultiSet.Entry) ZeusTransformUtils.preCheckCast(r1.next(), MultiSet.Entry.class, "com.obric.memorydata.plugin");
        if (r8.getCount(r4.getElement()) == getCount(r4.getElement())) goto L13;
        return false;
    L17:
        return true;
    }

    public int getCount(Object r4) {
        Iterator<MultiSet.Entry<E>> r3 = entrySet().iterator();
    L4:
        if (r3.hasNext() == false) goto L12;
        MultiSet.Entry r0 = (MultiSet.Entry) ZeusTransformUtils.preCheckCast(r3.next(), MultiSet.Entry.class, "com.obric.memorydata.plugin");
        Object r1 = r0.getElement();
        if (r1 == r4) goto L11;
        if (r1 == null) goto L4;
        if (r1.equals(r4) == false) goto L4;
    L11:
        return r0.getCount();
    L12:
        return 0;
    }

    @Override // java.util.Collection, org.apache.commons.collections4.MultiSet
    public int hashCode() {
        return entrySet().hashCode();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, org.apache.commons.collections4.MultiSet
    public Iterator<E> iterator() {
        return new MultiSetIterator(this);
    }

    public int remove(Object r1, int r2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean remove(Object r2) {
        if (remove(r2, 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean removeAll(Collection<?> r5) {
        Iterator<E> r6 = ((Collection) ZeusTransformUtils.wrapperContextForParams(r5, Collection.class, "com.obric.memorydata.plugin")).iterator();
    L3:
        boolean r1 = false;
    L5:
        if (r6.hasNext() == false) goto L13;
        E r2 = r6.next();
        if (remove(r2, getCount(r2)) == 0) goto L9;
        boolean r3 = true;
    L10:
        if (r1 == true) goto L12;
        if (r3 == false) goto L3;
    L12:
        r1 = true;
        goto L5
    L9:
        r3 = false;
        goto L10
    L13:
        return r1;
    }

    @Override // org.apache.commons.collections4.MultiSet
    public int setCount(E r2, int r3) {
        if (r3 < 0) goto L9;
        int r0 = getCount(r2);
        if (r0 >= r3) goto L6;
        add(r2, r3 - r0);
    L7:
        return r0;
    L6:
        remove(r2, r0 - r3);
        goto L7
    L9:
        throw new IllegalArgumentException("Count must not be negative.");
    }

    @Override // java.util.AbstractCollection, java.util.Collection, org.apache.commons.collections4.MultiSet
    public int size() {
        Iterator<MultiSet.Entry<E>> r4 = entrySet().iterator();
        int r0 = 0;
    L4:
        if (r4.hasNext() == false) goto L6;
        r0 = r0 + ((MultiSet.Entry) ZeusTransformUtils.preCheckCast(r4.next(), MultiSet.Entry.class, "com.obric.memorydata.plugin")).getCount();
        goto L4
    L6:
        return r0;
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return entrySet().toString();
    }

    public abstract int uniqueElements();

    @Override // org.apache.commons.collections4.MultiSet
    public Set<E> uniqueSet() {
        if (this.uniqueSet != null) goto L6;
        this.uniqueSet = createUniqueSet();
    L6:
        return this.uniqueSet;
    }
}
