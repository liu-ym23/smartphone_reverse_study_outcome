package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
abstract class bh<F, T> implements Iterator<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Iterator<? extends F> f4673b;

    bh(Iterator<? extends F> r3) {
        this.f4673b = (Iterator) ZeusTransformUtils.preCheckCast(com.google.common.base.n.a((Iterator) ZeusTransformUtils.wrapperContextForParams(r3, Iterator.class, "com.obric.memorydata.plugin")), Iterator.class, "com.obric.memorydata.plugin");
    }

    abstract T a(F r1);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f4673b.hasNext();
    }

    @Override // java.util.Iterator
    public final T next() {
        return a(this.f4673b.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f4673b.remove();
    }
}
