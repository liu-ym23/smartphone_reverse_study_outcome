package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
final class ReverseOrdering<T> extends Ordering<T> implements Serializable {
    private static final long serialVersionUID = 0;
    final Ordering<? super T> forwardOrder;

    ReverseOrdering(Ordering<? super T> r3) {
        this.forwardOrder = (Ordering) ZeusTransformUtils.preCheckCast(com.google.common.base.n.a(r3), Ordering.class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(T r1, T r2) {
        return this.forwardOrder.compare(r2, r1);
    }

    @Override // java.util.Comparator
    public boolean equals(Object r3) {
        if (r3 != this) goto L7;
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r3, ReverseOrdering.class) == false) goto L10;
        ReverseOrdering r4 = (ReverseOrdering) ZeusTransformUtils.preCheckCast(r3, ReverseOrdering.class, "com.obric.memorydata.plugin");
        return this.forwardOrder.equals(r4.forwardOrder);
    L10:
        return false;
    }

    public int hashCode() {
        return -this.forwardOrder.hashCode();
    }

    @Override // com.google.common.collect.Ordering
    public <E extends T> E max(Iterable<E> r3) {
        Iterable<E> r4 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.memorydata.plugin");
        return (E) this.forwardOrder.min(r4);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends T> E max(E r1, E r2) {
        return (E) this.forwardOrder.min(r1, r2);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends T> E max(E r1, E r2, E r3, E... r4) {
        return (E) this.forwardOrder.min(r1, r2, r3, r4);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends T> E max(Iterator<E> r3) {
        Iterator<E> r4 = (Iterator) ZeusTransformUtils.wrapperContextForParams(r3, Iterator.class, "com.obric.memorydata.plugin");
        return (E) this.forwardOrder.min(r4);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends T> E min(Iterable<E> r3) {
        Iterable<E> r4 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.memorydata.plugin");
        return (E) this.forwardOrder.max(r4);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends T> E min(E r1, E r2) {
        return (E) this.forwardOrder.max(r1, r2);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends T> E min(E r1, E r2, E r3, E... r4) {
        return (E) this.forwardOrder.max(r1, r2, r3, r4);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends T> E min(Iterator<E> r3) {
        Iterator<E> r4 = (Iterator) ZeusTransformUtils.wrapperContextForParams(r3, Iterator.class, "com.obric.memorydata.plugin");
        return (E) this.forwardOrder.max(r4);
    }

    @Override // com.google.common.collect.Ordering
    public <S extends T> Ordering<S> reverse() {
        return this.forwardOrder;
    }

    public String toString() {
        return this.forwardOrder + ".reverse()";
    }
}
