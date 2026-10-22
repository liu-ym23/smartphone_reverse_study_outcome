package org.apache.commons.collections4.collection;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.iterators.EmptyIterator;
import org.apache.commons.collections4.iterators.IteratorChain;
import org.apache.commons.collections4.list.UnmodifiableList;

/* JADX INFO: loaded from: classes6.dex */
public class CompositeCollection<E> implements Serializable, Collection<E> {
    private static final long serialVersionUID = 8417515734108306801L;
    private final List<Collection<E>> all;
    private CollectionMutator<E> mutator;

    public interface CollectionMutator<E> extends Serializable {
        boolean add(CompositeCollection<E> r1, List<Collection<E>> r2, E r3);

        boolean addAll(CompositeCollection<E> r1, List<Collection<E>> r2, Collection<? extends E> r3);

        boolean remove(CompositeCollection<E> r1, List<Collection<E>> r2, Object r3);
    }

    public CompositeCollection() {
        this.all = new ArrayList();
    }

    public CompositeCollection(Collection<E> r3) {
        Collection<E> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        this.all = new ArrayList();
        addComposited(r4);
    }

    public CompositeCollection(Collection<E> r3, Collection<E> r4) {
        Collection<E> r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        Collection<E> r6 = (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.memorydata.plugin");
        this.all = new ArrayList();
        addComposited(r5, r6);
    }

    public CompositeCollection(Collection<E>... r2) {
        this.all = new ArrayList();
        addComposited(r2);
    }

    @Override // java.util.Collection
    public boolean add(E r3) {
        CollectionMutator<E> r0 = this.mutator;
        if (r0 == null) goto L7;
        return r0.add(this, this.all, r3);
    L7:
        throw new UnsupportedOperationException("add() is not supported on CompositeCollection without a CollectionMutator strategy");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends E> r3) {
        Collection<? extends E> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        CollectionMutator<E> r0 = this.mutator;
        if (r0 == null) goto L7;
        return r0.addAll(this, this.all, r4);
    L7:
        throw new UnsupportedOperationException("addAll() is not supported on CompositeCollection without a CollectionMutator strategy");
    }

    public void addComposited(Collection<E> r3) {
        Collection<E> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L6;
        this.all.add(r4);
        return;
    }

    public void addComposited(Collection<E> r3, Collection<E> r4) {
        Collection<E> r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        Collection<E> r6 = (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L5;
        this.all.add(r5);
    L5:
        if (r6 == null) goto L8;
        this.all.add(r6);
        return;
    }

    public void addComposited(Collection<E>... r5) {
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        Collection<E> r2 = r5[r1];
        if (r2 == null) goto L7;
        this.all.add(r2);
    L7:
        r1 = r1 + 1;
        goto L3
    }

    @Override // java.util.Collection
    public void clear() {
        Iterator<Collection<E>> r3 = this.all.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((Collection) ZeusTransformUtils.preCheckCast(r3.next(), Collection.class, "com.obric.memorydata.plugin")).clear();
        goto L4
    }

    @Override // java.util.Collection
    public boolean contains(Object r4) {
        Iterator<Collection<E>> r3 = this.all.iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        if (((Collection) ZeusTransformUtils.preCheckCast(r3.next(), Collection.class, "com.obric.memorydata.plugin")).contains(r4) == false) goto L4;
        return true;
    L9:
        return false;
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<?> r3) {
        Collection r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        return false;
    L5:
        Iterator<E> r5 = r4.iterator();
    L7:
        if (r5.hasNext() == false) goto L11;
        if (contains(r5.next()) == true) goto L7;
        return false;
    L11:
        return true;
    }

    public List<Collection<E>> getCollections() {
        return UnmodifiableList.unmodifiableList(this.all);
    }

    public CollectionMutator<E> getMutator() {
        return this.mutator;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        Iterator<Collection<E>> r3 = this.all.iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        if (((Collection) ZeusTransformUtils.preCheckCast(r3.next(), Collection.class, "com.obric.memorydata.plugin")).isEmpty() == true) goto L4;
        return false;
    L9:
        return true;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        if (this.all.isEmpty() == true) goto L5;
        IteratorChain r0 = new IteratorChain();
        Iterator<Collection<E>> r4 = this.all.iterator();
    L8:
        if (r4.hasNext() == false) goto L10;
        r0.addIterator(((Collection) ZeusTransformUtils.preCheckCast(r4.next(), Collection.class, "com.obric.memorydata.plugin")).iterator());
        goto L8
    L10:
        return r0;
    L5:
        return EmptyIterator.emptyIterator();
    }

    @Override // java.util.Collection
    public boolean remove(Object r3) {
        CollectionMutator<E> r0 = this.mutator;
        if (r0 == null) goto L7;
        return r0.remove(this, this.all, r3);
    L7:
        throw new UnsupportedOperationException("remove() is not supported on CompositeCollection without a CollectionMutator strategy");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<?> r5) {
        Collection<?> r6 = (Collection) ZeusTransformUtils.wrapperContextForParams(r5, Collection.class, "com.obric.memorydata.plugin");
        boolean r2 = false;
        if (CollectionUtils.isEmpty(r6) == false) goto L5;
        return false;
    L5:
        Iterator<Collection<E>> r4 = this.all.iterator();
    L7:
        if (r4.hasNext() == false) goto L9;
        r2 = r2 | ((Collection) ZeusTransformUtils.preCheckCast(r4.next(), Collection.class, "com.obric.memorydata.plugin")).removeAll(r6);
        goto L7
    L9:
        return r2;
    }

    public void removeComposited(Collection<E> r3) {
        Collection r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        this.all.remove(r4);
    }

    @Override // java.util.Collection
    public boolean removeIf(Predicate<? super E> r5) {
        Predicate<? super E> r6 = (Predicate) ZeusTransformUtils.wrapperContextForParams(r5, Predicate.class, "com.obric.memorydata.plugin");
        boolean r2 = false;
        if (Objects.isNull(r6) == false) goto L5;
        return false;
    L5:
        Iterator<Collection<E>> r4 = this.all.iterator();
    L7:
        if (r4.hasNext() == false) goto L9;
        r2 = r2 | ((Collection) ZeusTransformUtils.preCheckCast(r4.next(), Collection.class, "com.obric.memorydata.plugin")).removeIf(r6);
        goto L7
    L9:
        return r2;
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<?> r5) {
        Collection<?> r6 = (Collection) ZeusTransformUtils.wrapperContextForParams(r5, Collection.class, "com.obric.memorydata.plugin");
        boolean r0 = false;
        if (r6 == null) goto L8;
        Iterator<Collection<E>> r4 = this.all.iterator();
    L6:
        if (r4.hasNext() == false) goto L8;
        r0 = r0 | ((Collection) ZeusTransformUtils.preCheckCast(r4.next(), Collection.class, "com.obric.memorydata.plugin")).retainAll(r6);
    L8:
        return r0;
    }

    public void setMutator(CollectionMutator<E> r3) {
        this.mutator = (CollectionMutator) ZeusTransformUtils.wrapperContextForParams(r3, CollectionMutator.class, "com.obric.memorydata.plugin");
    }

    @Override // java.util.Collection
    public int size() {
        Iterator<Collection<E>> r4 = this.all.iterator();
        int r0 = 0;
    L4:
        if (r4.hasNext() == false) goto L6;
        r0 = r0 + ((Collection) ZeusTransformUtils.preCheckCast(r4.next(), Collection.class, "com.obric.memorydata.plugin")).size();
        goto L4
    L6:
        return r0;
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        Object[] r0 = new Object[size()];
        Iterator<E> r3 = iterator();
        int r1 = 0;
    L4:
        if (r3.hasNext() == false) goto L6;
        r0[r1] = r3.next();
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Collection
    public <T> T[] toArray(T[] r7) {
        int r0 = size();
        int r1 = r7.length;
        Object[] r8 = r7;
        if (r1 >= r0) goto L6;
        r8 = (T[]) ((Object[]) ZeusTransformUtils.preCheckCast((Object[]) ZeusTransformUtils.preCheckCast(Array.newInstance(r7.getClass().getComponentType(), r0), Object[].class, "com.obric.memorydata.plugin"), Object[].class, "com.obric.memorydata.plugin"));
    L6:
        int r2 = 0;
        Iterator<Collection<E>> r6 = this.all.iterator();
    L8:
        if (r6.hasNext() == false) goto L14;
        Iterator<E> r3 = ((Collection) ZeusTransformUtils.preCheckCast(r6.next(), Collection.class, "com.obric.memorydata.plugin")).iterator();
    L11:
        if (r3.hasNext() == false) goto L8;
        r8[r2] = r3.next();
        r2 = r2 + 1;
        goto L11
    L14:
        if (r8.length <= r0) goto L17;
        r8[r0] = 0;
    L17:
        return (T[]) ((Object[]) ZeusTransformUtils.preCheckCast(r8, Object[].class, "com.obric.memorydata.plugin"));
    }

    public Collection<E> toCollection() {
        return new ArrayList(this);
    }
}
