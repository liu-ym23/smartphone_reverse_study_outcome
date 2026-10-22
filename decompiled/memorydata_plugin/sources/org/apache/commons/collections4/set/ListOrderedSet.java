package org.apache.commons.collections4.set;

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
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.OrderedIterator;
import org.apache.commons.collections4.functors.UniquePredicate;
import org.apache.commons.collections4.iterators.AbstractIteratorDecorator;
import org.apache.commons.collections4.list.UnmodifiableList;

/* JADX INFO: loaded from: classes6.dex */
public class ListOrderedSet<E> extends AbstractSerializableSetDecorator<E> {
    private static final long serialVersionUID = -228664372470420141L;
    private final List<E> setOrder;

    /* JADX INFO: renamed from: org.apache.commons.collections4.set.ListOrderedSet$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    static class OrderedSetIterator<E> extends AbstractIteratorDecorator<E> implements OrderedIterator<E> {
        private E last;
        private final Collection<E> set;

        private OrderedSetIterator(ListIterator<E> r3, Collection<E> r4) {
            ListIterator r5 = (ListIterator) ZeusTransformUtils.wrapperContextForParams(r3, ListIterator.class, "com.obric.memorydata.plugin");
            Collection<E> r6 = (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.memorydata.plugin");
            super(r5);
            this.set = r6;
        }

        /* synthetic */ OrderedSetIterator(ListIterator r2, Collection r3, AnonymousClass1 r4) {
            this((ListIterator) ZeusTransformUtils.wrapperContextForParams(r2, ListIterator.class, "com.obric.memorydata.plugin"), (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin"));
        }

        @Override // org.apache.commons.collections4.iterators.AbstractIteratorDecorator, java.util.Iterator
        public E next() {
            E r0 = getIterator().next();
            this.last = r0;
            return r0;
        }

        @Override // org.apache.commons.collections4.iterators.AbstractUntypedIteratorDecorator, java.util.Iterator
        public void remove() {
            this.set.remove(this.last);
            getIterator().remove();
            this.last = null;
        }
    }

    public ListOrderedSet() {
        super(new HashSet());
        this.setOrder = new ArrayList();
    }

    public ListOrderedSet(Set<E> r3) {
        Set r4 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
        super(r4);
        this.setOrder = new ArrayList(r4);
    }

    public ListOrderedSet(Set<E> r3, List<E> r4) {
        Set r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
        List<E> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        super(r5);
        Objects.requireNonNull(r6, "List must not be null");
        this.setOrder = r6;
    }

    public static <E> ListOrderedSet<E> listOrderedSet(List<E> r2) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r3, "List must not be null");
        CollectionUtils.filter(r3, UniquePredicate.uniquePredicate());
        return new ListOrderedSet(new HashSet(r3), r3);
    }

    public static <E> ListOrderedSet<E> listOrderedSet(Set<E> r2) {
        return new ListOrderedSet((Set) ZeusTransformUtils.wrapperContextForParams(r2, Set.class, "com.obric.memorydata.plugin"));
    }

    public static <E> ListOrderedSet<E> listOrderedSet(Set<E> r2, List<E> r3) {
        Set r4 = (Set) ZeusTransformUtils.wrapperContextForParams(r2, Set.class, "com.obric.memorydata.plugin");
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r4, "Set must not be null");
        Objects.requireNonNull(r5, "List must not be null");
        if (r4.size() > 0) goto L9;
        if (r5.size() > 0) goto L9;
        return new ListOrderedSet(r4, r5);
    L9:
        throw new IllegalArgumentException("Set and List must be empty");
    }

    public void add(int r2, E r3) {
        if (contains(r3) == true) goto L6;
        decorated().add(r3);
        this.setOrder.add(r2, r3);
        return;
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection
    public boolean add(E r2) {
        if (decorated().add(r2) == false) goto L6;
        this.setOrder.add(r2);
        return true;
    L6:
        return false;
    }

    public boolean addAll(int r5, Collection<? extends E> r6) {
        Collection r7 = (Collection) ZeusTransformUtils.wrapperContextForParams(r6, Collection.class, "com.obric.memorydata.plugin");
        ArrayList r0 = new ArrayList();
        Iterator<E> r8 = r7.iterator();
        boolean r1 = false;
    L4:
        if (r8.hasNext() == false) goto L9;
        E r2 = r8.next();
        if (contains(r2) == true) goto L4;
        decorated().add(r2);
        r0.add(r2);
        r1 = true;
        goto L4
    L9:
        if (r1 == false) goto L11;
        this.setOrder.addAll(r5, r0);
    L11:
        return r1;
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection
    public boolean addAll(Collection<? extends E> r3) {
        Iterator<E> r4 = ((Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin")).iterator();
        boolean r0 = false;
    L4:
        if (r4.hasNext() == false) goto L6;
        r0 = r0 | add(r4.next());
        goto L4
    L6:
        return r0;
    }

    public List<E> asList() {
        return UnmodifiableList.unmodifiableList(this.setOrder);
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection
    public void clear() {
        decorated().clear();
        this.setOrder.clear();
    }

    public E get(int r1) {
        return this.setOrder.get(r1);
    }

    public int indexOf(Object r1) {
        return this.setOrder.indexOf(r1);
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, java.lang.Iterable, org.apache.commons.collections4.Bag
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return iterator();
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, java.lang.Iterable, org.apache.commons.collections4.Bag
    public OrderedIterator<E> iterator() {
        return new OrderedSetIterator(this.setOrder.listIterator(), decorated(), null);
    }

    public E remove(int r2) {
        E r3 = this.setOrder.remove(r2);
        remove(r3);
        return r3;
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection
    public boolean remove(Object r2) {
        boolean r0 = decorated().remove(r2);
        if (r0 == false) goto L5;
        this.setOrder.remove(r2);
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
        if (Objects.isNull(r4) == false) goto L6;
        return false;
    L6:
        boolean r0 = decorated().removeIf(r4);
        if (r0 == false) goto L9;
        this.setOrder.removeIf(r4);
    L9:
        return r0;
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections4.Bag
    public boolean retainAll(Collection<?> r4) {
        Collection<?> r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.memorydata.plugin");
        boolean r6 = decorated().retainAll(r5);
        if (r6 == true) goto L7;
        return false;
    L7:
        if (decorated().size() != 0) goto L9;
        this.setOrder.clear();
    L15:
        return r6;
    L9:
        Iterator<E> r0 = this.setOrder.iterator();
    L11:
        if (r0.hasNext() == false) goto L15;
        if (decorated().contains(r0.next()) == true) goto L11;
        r0.remove();
        goto L11
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection
    public Object[] toArray() {
        return this.setOrder.toArray();
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection
    public <T> T[] toArray(T[] r1) {
        return (T[]) this.setOrder.toArray(r1);
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator
    public String toString() {
        return this.setOrder.toString();
    }
}
