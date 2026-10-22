package com.google.common.collect;

import java.util.Collection;
import java.util.Queue;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ad<E> extends v<E> implements Queue<E> {
    public ad() {
    }

    @Override // com.google.common.collect.v, com.google.common.collect.ac
    public /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.v, com.google.common.collect.ac
    public /* bridge */ /* synthetic */ Collection delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.v, com.google.common.collect.ac
    public abstract Queue<E> delegate();

    @Override // java.util.Queue
    public E element() {
        return delegate().element();
    }

    public boolean offer(E r1) {
        return delegate().offer(r1);
    }

    @Override // java.util.Queue
    public E peek() {
        return delegate().peek();
    }

    @Override // java.util.Queue
    public E poll() {
        return delegate().poll();
    }

    @Override // java.util.Queue
    public E remove() {
        return delegate().remove();
    }

    public boolean standardOffer(E r1) {
        return add(r1);
    L4:
        return false;
    }

    public E standardPeek() {
        return element();
    L4:
        return null;
    }

    public E standardPoll() {
        return remove();
    L4:
        return null;
    }
}
