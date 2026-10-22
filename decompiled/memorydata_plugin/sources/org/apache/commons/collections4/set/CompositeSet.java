package org.apache.commons.collections4.set;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Predicate;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.iterators.EmptyIterator;
import org.apache.commons.collections4.iterators.IteratorChain;
import org.apache.commons.collections4.list.UnmodifiableList;

/* JADX INFO: loaded from: classes6.dex */
public class CompositeSet<E> implements Serializable, Set<E> {
    private static final long serialVersionUID = 5185069727540378940L;
    private final List<Set<E>> all;
    private SetMutator<E> mutator;

    public interface SetMutator<E> extends Serializable {
        boolean add(CompositeSet<E> r1, List<Set<E>> r2, E r3);

        boolean addAll(CompositeSet<E> r1, List<Set<E>> r2, Collection<? extends E> r3);

        void resolveCollision(CompositeSet<E> r1, Set<E> r2, Set<E> r3, Collection<E> r4);
    }

    public CompositeSet() {
        this.all = new ArrayList();
    }

    public CompositeSet(Set<E> r3) {
        Set<E> r4 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
        this.all = new ArrayList();
        addComposited(r4);
    }

    public CompositeSet(Set<E>... r2) {
        this.all = new ArrayList();
        addComposited(r2);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean add(E r3) {
        SetMutator<E> r0 = this.mutator;
        if (r0 == null) goto L7;
        return r0.add(this, this.all, r3);
    L7:
        throw new UnsupportedOperationException("add() is not supported on CompositeSet without a SetMutator strategy");
    }

    @Override // java.util.Set, java.util.Collection
    public boolean addAll(Collection<? extends E> r3) {
        Collection<? extends E> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        SetMutator<E> r0 = this.mutator;
        if (r0 == null) goto L7;
        return r0.addAll(this, this.all, r4);
    L7:
        throw new UnsupportedOperationException("addAll() is not supported on CompositeSet without a SetMutator strategy");
    }

    public synchronized void addComposited(Set<E> r5) {
        monitor-enter(this);
        Set<E> r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
        if (r6 == null) goto L20;
        Iterator<Set<E>> r0 = getSets().iterator();     // Catch: Throwable -> L22
    L7:
        if (r0.hasNext() == false) goto L19;
        Set<E> r1 = (Set) ZeusTransformUtils.preCheckCast(r0.next(), Set.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
        Collection<E> r2 = CollectionUtils.intersection(r1, r6);     // Catch: Throwable -> L22
        if (r2.size() <= 0) goto L7;
        if (this.mutator == null) goto L18;
        getMutator().resolveCollision(this, r1, r6, r2);     // Catch: Throwable -> L22
        if (CollectionUtils.intersection(r1, r6).size() <= 0) goto L7;
        throw new IllegalArgumentException("Attempt to add illegal entry unresolved by SetMutator.resolveCollision()");     // Catch: Throwable -> L22
    L18:
        throw new UnsupportedOperationException("Collision adding composited set with no SetMutator set");     // Catch: Throwable -> L22
    L19:
        this.all.add(r6);     // Catch: Throwable -> L22
    L20:
        monitor-exit(this);
        return;
    L22:
        th = move-exception;
        throw th;
    }

    public void addComposited(Set<E> r3, Set<E> r4) {
        Set<E> r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
        Set<E> r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
        addComposited(r5);
        addComposited(r6);
    }

    public void addComposited(Set<E>... r4) {
        if (r4 == null) goto L6;
        int r0 = r4.length;
        int r1 = 0;
    L4:
        if (r1 >= r0) goto L8;
        addComposited(r4[r1]);
        r1 = r1 + 1;
        goto L4
    L8:
        return;
    }

    @Override // java.util.Set, java.util.Collection
    public void clear() {
        Iterator<Set<E>> r3 = this.all.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((Collection) ZeusTransformUtils.preCheckCast(r3.next(), Collection.class, "com.obric.memorydata.plugin")).clear();
        goto L4
    }

    @Override // java.util.Set, java.util.Collection
    public boolean contains(Object r4) {
        Iterator<Set<E>> r3 = this.all.iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        if (((Set) ZeusTransformUtils.preCheckCast(r3.next(), Set.class, "com.obric.memorydata.plugin")).contains(r4) == false) goto L4;
        return true;
    L9:
        return false;
    }

    @Override // java.util.Set, java.util.Collection
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

    @Override // java.util.Set, java.util.Collection
    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, Set.class) == false) goto L10;
        Set r5 = (Set) ZeusTransformUtils.preCheckCast(r4, Set.class, "com.obric.memorydata.plugin");
        if (r5.size() == size()) goto L7;
        return false;
    L7:
        if (r5.containsAll(this) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    public SetMutator<E> getMutator() {
        return this.mutator;
    }

    public List<Set<E>> getSets() {
        return UnmodifiableList.unmodifiableList(this.all);
    }

    @Override // java.util.Set, java.util.Collection
    public int hashCode() {
        Iterator<E> r3 = iterator();
        int r1 = 0;
    L4:
        if (r3.hasNext() == false) goto L10;
        E r2 = r3.next();
        if (r2 != null) goto L8;
        int r4 = 0;
    L9:
        r1 = r1 + r4;
        goto L4
    L8:
        r4 = r2.hashCode();
        goto L9
    L10:
        return r1;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean isEmpty() {
        Iterator<Set<E>> r3 = this.all.iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        if (((Set) ZeusTransformUtils.preCheckCast(r3.next(), Set.class, "com.obric.memorydata.plugin")).isEmpty() == true) goto L4;
        return false;
    L9:
        return true;
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        if (this.all.isEmpty() == true) goto L5;
        IteratorChain r0 = new IteratorChain();
        Iterator<Set<E>> r4 = this.all.iterator();
    L8:
        if (r4.hasNext() == false) goto L10;
        r0.addIterator(((Set) ZeusTransformUtils.preCheckCast(r4.next(), Set.class, "com.obric.memorydata.plugin")).iterator());
        goto L8
    L10:
        return r0;
    L5:
        return EmptyIterator.emptyIterator();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean remove(Object r4) {
        Iterator<Set<E>> r3 = getSets().iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        Set r0 = (Set) ZeusTransformUtils.preCheckCast(r3.next(), Set.class, "com.obric.memorydata.plugin");
        if (r0.contains(r4) == false) goto L4;
        return r0.remove(r4);
    L9:
        return false;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(Collection<?> r5) {
        Collection<?> r6 = (Collection) ZeusTransformUtils.wrapperContextForParams(r5, Collection.class, "com.obric.memorydata.plugin");
        boolean r2 = false;
        if (CollectionUtils.isEmpty(r6) == false) goto L5;
        return false;
    L5:
        Iterator<Set<E>> r4 = this.all.iterator();
    L7:
        if (r4.hasNext() == false) goto L9;
        r2 = r2 | ((Collection) ZeusTransformUtils.preCheckCast(r4.next(), Collection.class, "com.obric.memorydata.plugin")).removeAll(r6);
        goto L7
    L9:
        return r2;
    }

    public void removeComposited(Set<E> r3) {
        Set r4 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
        this.all.remove(r4);
    }

    @Override // java.util.Collection
    public boolean removeIf(Predicate<? super E> r5) {
        Predicate<? super E> r6 = (Predicate) ZeusTransformUtils.wrapperContextForParams(r5, Predicate.class, "com.obric.memorydata.plugin");
        boolean r2 = false;
        if (Objects.isNull(r6) == false) goto L5;
        return false;
    L5:
        Iterator<Set<E>> r4 = this.all.iterator();
    L7:
        if (r4.hasNext() == false) goto L9;
        r2 = r2 | ((Collection) ZeusTransformUtils.preCheckCast(r4.next(), Collection.class, "com.obric.memorydata.plugin")).removeIf(r6);
        goto L7
    L9:
        return r2;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(Collection<?> r5) {
        Collection<?> r6 = (Collection) ZeusTransformUtils.wrapperContextForParams(r5, Collection.class, "com.obric.memorydata.plugin");
        Iterator<Set<E>> r4 = this.all.iterator();
        boolean r0 = false;
    L4:
        if (r4.hasNext() == false) goto L6;
        r0 = r0 | ((Collection) ZeusTransformUtils.preCheckCast(r4.next(), Collection.class, "com.obric.memorydata.plugin")).retainAll(r6);
        goto L4
    L6:
        return r0;
    }

    public void setMutator(SetMutator<E> r3) {
        this.mutator = (SetMutator) ZeusTransformUtils.wrapperContextForParams(r3, SetMutator.class, "com.obric.memorydata.plugin");
    }

    @Override // java.util.Set, java.util.Collection
    public int size() {
        Iterator<Set<E>> r4 = this.all.iterator();
        int r0 = 0;
    L4:
        if (r4.hasNext() == false) goto L6;
        r0 = r0 + ((Set) ZeusTransformUtils.preCheckCast(r4.next(), Set.class, "com.obric.memorydata.plugin")).size();
        goto L4
    L6:
        return r0;
    }

    @Override // java.util.Set, java.util.Collection
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
    @Override // java.util.Set, java.util.Collection
    public <T> T[] toArray(T[] r7) {
        int r0 = size();
        int r1 = r7.length;
        Object[] r8 = r7;
        if (r1 >= r0) goto L6;
        r8 = (T[]) ((Object[]) ZeusTransformUtils.preCheckCast((Object[]) ZeusTransformUtils.preCheckCast(Array.newInstance(r7.getClass().getComponentType(), r0), Object[].class, "com.obric.memorydata.plugin"), Object[].class, "com.obric.memorydata.plugin"));
    L6:
        int r2 = 0;
        Iterator<Set<E>> r6 = this.all.iterator();
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

    public Set<E> toSet() {
        return new HashSet(this);
    }
}
