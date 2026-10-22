package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ListIterator;

/* JADX INFO: loaded from: classes2.dex */
abstract class bi<F, T> extends bh<F, T> implements ListIterator<T> {
    bi(ListIterator<? extends F> r3) {
        super((ListIterator) ZeusTransformUtils.wrapperContextForParams(r3, ListIterator.class, "com.obric.memorydata.plugin"));
    }

    private ListIterator<? extends F> a() {
        return Iterators.j(this.f4673b);
    }

    @Override // java.util.ListIterator
    public void add(T r1) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return a().hasPrevious();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return a().nextIndex();
    }

    @Override // java.util.ListIterator
    public final T previous() {
        return a(a().previous());
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return a().previousIndex();
    }

    public void set(T r1) {
        throw new UnsupportedOperationException();
    }
}
