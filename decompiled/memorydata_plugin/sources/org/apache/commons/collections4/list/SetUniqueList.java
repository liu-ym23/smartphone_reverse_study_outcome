package org.apache.commons.collections4.list;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.Set;
import java.util.function.Predicate;
import org.apache.commons.collections4.ListUtils;
import org.apache.commons.collections4.iterators.AbstractIteratorDecorator;
import org.apache.commons.collections4.iterators.AbstractListIteratorDecorator;
import org.apache.commons.collections4.set.UnmodifiableSet;

/* JADX INFO: loaded from: classes6.dex */
public class SetUniqueList<E> extends AbstractSerializableListDecorator<E> {
    private static final long serialVersionUID = 7196982186153478694L;
    private final Set<E> set;

    static class SetListIterator<E> extends AbstractIteratorDecorator<E> {
        private E last;
        private final Set<E> set;

        public SetListIterator(Iterator<E> r3, Set<E> r4) {
            Iterator r5 = (Iterator) ZeusTransformUtils.wrapperContextForParams(r3, Iterator.class, "com.obric.memorydata.plugin");
            Set<E> r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
            super(r5);
            this.last = null;
            this.set = r6;
        }

        @Override // org.apache.commons.collections4.iterators.AbstractIteratorDecorator, java.util.Iterator
        public E next() {
            E r0 = (E) super.next();
            this.last = r0;
            return r0;
        }

        @Override // org.apache.commons.collections4.iterators.AbstractUntypedIteratorDecorator, java.util.Iterator
        public void remove() {
            super.remove();
            this.set.remove(this.last);
            this.last = null;
        }
    }

    static class SetListListIterator<E> extends AbstractListIteratorDecorator<E> {
        private E last;
        private final Set<E> set;

        public SetListListIterator(ListIterator<E> r3, Set<E> r4) {
            ListIterator r5 = (ListIterator) ZeusTransformUtils.wrapperContextForParams(r3, ListIterator.class, "com.obric.memorydata.plugin");
            Set<E> r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
            super(r5);
            this.last = null;
            this.set = r6;
        }

        @Override // org.apache.commons.collections4.iterators.AbstractListIteratorDecorator, java.util.ListIterator
        public void add(E r2) {
            if (this.set.contains(r2) == true) goto L6;
            super.add(r2);
            this.set.add(r2);
            return;
        }

        @Override // org.apache.commons.collections4.iterators.AbstractListIteratorDecorator, java.util.ListIterator, java.util.Iterator
        public E next() {
            E r0 = (E) super.next();
            this.last = r0;
            return r0;
        }

        @Override // org.apache.commons.collections4.iterators.AbstractListIteratorDecorator, java.util.ListIterator
        public E previous() {
            E r0 = (E) super.previous();
            this.last = r0;
            return r0;
        }

        @Override // org.apache.commons.collections4.iterators.AbstractListIteratorDecorator, java.util.ListIterator, java.util.Iterator
        public void remove() {
            super.remove();
            this.set.remove(this.last);
            this.last = null;
        }

        @Override // org.apache.commons.collections4.iterators.AbstractListIteratorDecorator, java.util.ListIterator
        public void set(E r1) {
            throw new UnsupportedOperationException("ListIterator does not support set");
        }
    }

    public SetUniqueList(List<E> r3, Set<E> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Set<E> r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
        super(r5);
        Objects.requireNonNull(r6, "Set must not be null");
        this.set = r6;
    }

    public static <E> SetUniqueList<E> setUniqueList(List<E> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r4, "List must not be null");
        if (r4.isEmpty() == true) goto L5;
        ArrayList r0 = new ArrayList(r4);
        r4.clear();
        SetUniqueList<E> r1 = new SetUniqueList(r4, new HashSet());
        r1.addAll(r0);
        return r1;
    L5:
        return new SetUniqueList(r4, new HashSet());
    }

    @Override // org.apache.commons.collections4.list.AbstractListDecorator, java.util.List
    public void add(int r2, E r3) {
        if (this.set.contains(r3) == true) goto L6;
        this.set.add(r3);
        super.add(r2, r3);
        return;
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection
    public boolean add(E r3) {
        int r0 = size();
        add(size(), r3);
        if (r0 == size()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.apache.commons.collections4.list.AbstractListDecorator, java.util.List
    public boolean addAll(int r4, Collection<? extends E> r5) {
        Collection r6 = (Collection) ZeusTransformUtils.wrapperContextForParams(r5, Collection.class, "com.obric.memorydata.plugin");
        ArrayList r0 = new ArrayList();
        Iterator<E> r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L9;
        E r1 = r7.next();
        if (this.set.add(r1) == false) goto L4;
        r0.add(r1);
        goto L4
    L9:
        return super.addAll(r4, r0);
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection
    public boolean addAll(Collection<? extends E> r3) {
        Collection<? extends E> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        return addAll(size(), r4);
    }

    public Set<E> asSet() {
        return UnmodifiableSet.unmodifiableSet(this.set);
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection
    public void clear() {
        super.clear();
        this.set.clear();
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, java.util.Set
    public boolean contains(Object r1) {
        return this.set.contains(r1);
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection
    public boolean containsAll(Collection<?> r3) {
        Collection<?> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        return this.set.containsAll(r4);
    }

    public Set<E> createSetBasedOnList(Set<E> r5, List<E> r6) {
        Set r4 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin");
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        if (r4.getClass().equals(HashSet.class) == true) goto L11;
        return (Set) ZeusTransformUtils.preCheckCast(r4.getClass().getDeclaredConstructor(new Class[]{r4.getClass()}).newInstance(new Object[]{r4}), Set.class, "com.obric.memorydata.plugin");
    L8:
        return new HashSet();
    L11:
        return new HashSet(r7.size());
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, java.lang.Iterable, org.apache.commons.collections4.Bag
    public Iterator<E> iterator() {
        return new SetListIterator(super.iterator(), this.set);
    }

    @Override // org.apache.commons.collections4.list.AbstractListDecorator, java.util.List
    public ListIterator<E> listIterator() {
        return new SetListListIterator(super.listIterator(), this.set);
    }

    @Override // org.apache.commons.collections4.list.AbstractListDecorator, java.util.List
    public ListIterator<E> listIterator(int r2) {
        return new SetListListIterator(super.listIterator(r2), this.set);
    }

    @Override // org.apache.commons.collections4.list.AbstractListDecorator, java.util.List
    public E remove(int r1) {
        E r2 = (E) super.remove(r1);
        this.set.remove(r2);
        return r2;
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection
    public boolean remove(Object r2) {
        boolean r0 = this.set.remove(r2);
        if (r0 == false) goto L5;
        super.remove(r2);
    L5:
        return r0;
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections4.Bag
    public boolean removeAll(Collection<?> r3) {
        Iterator<E> r4 = ((Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin")).iterator();
        boolean r0 = false;
    L4:
        if (r4.hasNext() == false) goto L6;
        r0 = r0 | remove(r4.next());
        goto L4
    L6:
        return r0;
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection
    public boolean removeIf(Predicate<? super E> r3) {
        Predicate<? super E> r4 = (Predicate) ZeusTransformUtils.wrapperContextForParams(r3, Predicate.class, "com.obric.memorydata.plugin");
        boolean r0 = super.removeIf(r4);
        this.set.removeIf(r4);
        return r0;
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections4.Bag
    public boolean retainAll(Collection<?> r3) {
        Collection<?> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        boolean r5 = this.set.retainAll(r4);
        if (r5 == true) goto L7;
        return false;
    L7:
        if (this.set.size() != 0) goto L9;
        super.clear();
    L10:
        return r5;
    L9:
        super.retainAll(this.set);
        goto L10
    }

    @Override // org.apache.commons.collections4.list.AbstractListDecorator, java.util.List
    public E set(int r4, E r5) {
        int r0 = indexOf(r5);
        E r1 = (E) super.set(r4, r5);
        if (r0 == (-1)) goto L6;
        if (r0 == r4) goto L6;
        super.remove(r0);
    L6:
        this.set.remove(r1);
        this.set.add(r5);
        return r1;
    }

    @Override // org.apache.commons.collections4.list.AbstractListDecorator, java.util.List
    public List<E> subList(int r1, int r2) {
        List<E> r3 = super.subList(r1, r2);
        return ListUtils.unmodifiableList(new SetUniqueList(r3, createSetBasedOnList(this.set, r3)));
    }
}
