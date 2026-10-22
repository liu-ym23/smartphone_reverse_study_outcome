package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public abstract class v<E> extends ac implements Collection<E> {
    public v() {
    }

    public boolean add(E r1) {
        return delegate().add(r1);
    }

    public boolean addAll(Collection<? extends E> r3) {
        Collection<? extends E> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        return delegate().addAll(r4);
    }

    public void clear() {
        delegate().clear();
    }

    public boolean contains(Object r1) {
        return delegate().contains(r1);
    }

    public boolean containsAll(Collection<?> r3) {
        Collection<?> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        return delegate().containsAll(r4);
    }

    @Override // com.google.common.collect.ac
    public /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.ac
    public abstract Collection<E> delegate();

    @Override // java.util.Collection
    public boolean isEmpty() {
        return delegate().isEmpty();
    }

    public Iterator<E> iterator() {
        return delegate().iterator();
    }

    public boolean remove(Object r1) {
        return delegate().remove(r1);
    }

    public boolean removeAll(Collection<?> r3) {
        Collection<?> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        return delegate().removeAll(r4);
    }

    public boolean retainAll(Collection<?> r3) {
        Collection<?> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        return delegate().retainAll(r4);
    }

    @Override // java.util.Collection
    public int size() {
        return delegate().size();
    }

    public boolean standardAddAll(Collection<? extends E> r3) {
        return Iterators.a(this, ((Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin")).iterator());
    }

    public void standardClear() {
        Iterators.h(iterator());
    }

    public boolean standardContains(Object r1) {
        return Iterators.a(iterator(), r1);
    }

    public boolean standardContainsAll(Collection<?> r3) {
        return q.a(this, (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin"));
    }

    public boolean standardIsEmpty() {
        return !iterator().hasNext();
    }

    public boolean standardRemove(Object r2) {
        Iterator<E> r1 = iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        if (com.google.common.base.k.a(r1.next(), r2) == false) goto L4;
        r1.remove();
        return true;
    L9:
        return false;
    }

    public boolean standardRemoveAll(Collection<?> r3) {
        Collection r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        return Iterators.a(iterator(), r4);
    }

    public boolean standardRetainAll(Collection<?> r3) {
        Collection r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        return Iterators.b(iterator(), r4);
    }

    public Object[] standardToArray() {
        return toArray(new Object[size()]);
    }

    public <T> T[] standardToArray(T[] r1) {
        return (T[]) ap.a(this, r1);
    }

    public String standardToString() {
        return q.a(this);
    }

    public Object[] toArray() {
        return delegate().toArray();
    }

    public <T> T[] toArray(T[] r1) {
        return (T[]) delegate().toArray(r1);
    }
}
