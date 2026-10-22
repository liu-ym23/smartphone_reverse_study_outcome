package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ab<E> extends v<E> implements an<E> {
    public ab() {
    }

    public int add(E r1, int r2) {
        return delegate().add(r1, r2);
    }

    @Override // com.google.common.collect.an
    public int count(Object r1) {
        return delegate().count(r1);
    }

    @Override // com.google.common.collect.v, com.google.common.collect.ac
    public abstract an<E> delegate();

    @Override // com.google.common.collect.v, com.google.common.collect.ac
    public /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.v, com.google.common.collect.ac
    public /* bridge */ /* synthetic */ Collection delegate() {
        return delegate();
    }

    public Set<E> elementSet() {
        return delegate().elementSet();
    }

    public Set<an.a<E>> entrySet() {
        return delegate().entrySet();
    }

    @Override // java.util.Collection, com.google.common.collect.an
    public boolean equals(Object r1) {
        if (r1 != this) goto L4;
    L7:
        return true;
    L4:
        if (delegate().equals(r1) == true) goto L7;
        return false;
    }

    @Override // java.util.Collection, com.google.common.collect.an
    public int hashCode() {
        return delegate().hashCode();
    }

    public int remove(Object r1, int r2) {
        return delegate().remove(r1, r2);
    }

    public int setCount(E r1, int r2) {
        return delegate().setCount(r1, r2);
    }

    public boolean setCount(E r1, int r2, int r3) {
        return delegate().setCount(r1, r2, r3);
    }

    public boolean standardAdd(E r2) {
        add(r2, 1);
        return true;
    }

    @Override // com.google.common.collect.v
    public boolean standardAddAll(Collection<? extends E> r3) {
        return Multisets.a(this, (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.google.common.collect.v
    public void standardClear() {
        Iterators.h(entrySet().iterator());
    }

    @Override // com.google.common.collect.v
    public boolean standardContains(Object r1) {
        if (count(r1) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public int standardCount(Object r4) {
        Iterator<an.a<E>> r3 = entrySet().iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        an.a r0 = (an.a) ZeusTransformUtils.preCheckCast(r3.next(), an.a.class, "com.obric.memorydata.plugin");
        if (com.google.common.base.k.a(r0.getElement(), r4) == false) goto L4;
        return r0.getCount();
    L9:
        return 0;
    }

    public boolean standardEquals(Object r1) {
        return Multisets.a(this, r1);
    }

    public int standardHashCode() {
        return entrySet().hashCode();
    }

    public Iterator<E> standardIterator() {
        return Multisets.b(this);
    }

    @Override // com.google.common.collect.v
    public boolean standardRemove(Object r2) {
        if (remove(r2, 1) > 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.google.common.collect.v
    public boolean standardRemoveAll(Collection<?> r3) {
        return Multisets.b(this, (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.google.common.collect.v
    public boolean standardRetainAll(Collection<?> r3) {
        return Multisets.c(this, (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin"));
    }

    public int standardSetCount(E r1, int r2) {
        return Multisets.a(this, r1, r2);
    }

    public boolean standardSetCount(E r1, int r2, int r3) {
        return Multisets.a(this, r1, r2, r3);
    }

    public int standardSize() {
        return Multisets.d(this);
    }

    @Override // com.google.common.collect.v
    public String standardToString() {
        return entrySet().toString();
    }
}
