package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Queue;

/* JADX INFO: loaded from: classes2.dex */
public final class EvictingQueue<E> extends ad<E> implements Serializable {
    private static final long serialVersionUID = 0;
    private final Queue<E> delegate;
    final int maxSize;

    private EvictingQueue(int r3) {
        if (r3 < 0) goto L5;
        boolean r0 = true;
    L6:
        com.google.common.base.n.a(r0, "maxSize (%s) must >= 0", r3);
        this.delegate = new ArrayDeque(r3);
        this.maxSize = r3;
        return;
    L5:
        r0 = false;
        goto L6
    }

    public static <E> EvictingQueue<E> create(int r1) {
        return new EvictingQueue(r1);
    }

    @Override // com.google.common.collect.v, java.util.Collection, java.util.Queue
    public boolean add(E r4) {
        com.google.common.base.n.a(r4);
        if (this.maxSize != 0) goto L6;
        return true;
    L6:
        if (size() != this.maxSize) goto L8;
        this.delegate.remove();
    L8:
        this.delegate.add(r4);
        return true;
    }

    @Override // com.google.common.collect.v, java.util.Collection
    public boolean addAll(Collection<? extends E> r3) {
        Collection<? extends E> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        int r0 = r4.size();
        if (r0 < this.maxSize) goto L7;
        clear();
        return aj.a(this, aj.a(r4, r0 - this.maxSize));
    L7:
        return standardAddAll(r4);
    }

    @Override // com.google.common.collect.ad, com.google.common.collect.v, com.google.common.collect.ac
    public /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.ad, com.google.common.collect.v, com.google.common.collect.ac
    public /* bridge */ /* synthetic */ Collection delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.ad, com.google.common.collect.v, com.google.common.collect.ac
    public Queue<E> delegate() {
        return this.delegate;
    }

    @Override // com.google.common.collect.ad, java.util.Queue
    public boolean offer(E r1) {
        return add(r1);
    }

    public int remainingCapacity() {
        return this.maxSize - size();
    }

    @Override // com.google.common.collect.v, java.util.Collection, java.util.Set
    public Object[] toArray() {
        return super.toArray();
    }
}
