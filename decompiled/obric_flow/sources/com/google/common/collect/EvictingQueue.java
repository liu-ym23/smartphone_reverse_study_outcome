package com.google.common.collect;

import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Queue;

/* JADX INFO: loaded from: classes2.dex */
public final class EvictingQueue<E> extends a3 implements Serializable {
    private static final long serialVersionUID = 0;
    private final Queue<E> delegate;
    final int maxSize;

    public EvictingQueue(int r5) {
        if (r5 < 0) goto L5;
        boolean r10 = true;
    L6:
        com.google.common.base.b0.d(r5, "maxSize (%s) must >= 0", r10);
        this.delegate = new ArrayDeque(r5);
        this.maxSize = r5;
        return;
    L5:
        r10 = false;
        goto L6
    }

    public static <E> EvictingQueue<E> create(int r5) {
        return new EvictingQueue(r5);
    }

    @Override // com.google.common.collect.t2, java.util.Collection, java.util.Queue
    public boolean add(E r5) {
        r5.getClass();
        if (this.maxSize != 0) goto L6;
        return true;
    L6:
        if (size() != this.maxSize) goto L8;
        this.delegate.remove();
    L8:
        this.delegate.add(r5);
        return true;
    }

    @Override // com.google.common.collect.t2, java.util.Collection
    public boolean addAll(Collection<? extends E> r5) {
        int r10 = r5.size();
        if (r10 < this.maxSize) goto L11;
        clear();
        int r11 = r10 - this.maxSize;
        if (r11 < 0) goto L7;
        boolean r12 = true;
    L8:
        com.google.common.base.b0.g("number to skip cannot be negative", r12);
        return p7.i(this, new c5(r5, r11));
    L7:
        r12 = false;
        goto L8
    L11:
        return standardAddAll(r5);
    }

    @Override // com.google.common.collect.z2
    public /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    @Override // java.util.Queue
    public boolean offer(E r5) {
        return add(r5);
    }

    public int remainingCapacity() {
        return this.maxSize - size();
    }

    @Override // com.google.common.collect.t2, java.util.Collection
    public Object[] toArray() {
        return super.toArray();
    }

    @Override // com.google.common.collect.t2, com.google.common.collect.z2
    public /* bridge */ /* synthetic */ Collection delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.a3, com.google.common.collect.t2, com.google.common.collect.z2
    public Queue<E> delegate() {
        return this.delegate;
    }
}
