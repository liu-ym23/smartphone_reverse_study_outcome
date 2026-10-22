package com.google.common.collect;

import java.util.Queue;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a3 extends t2 implements Queue {
    public a3() {
    }

    @Override // com.google.common.collect.t2, com.google.common.collect.z2
    public abstract Queue delegate();

    @Override // java.util.Queue
    public Object element() {
        return delegate().element();
    }

    @Override // java.util.Queue
    public Object peek() {
        return delegate().peek();
    }

    @Override // java.util.Queue
    public Object poll() {
        return delegate().poll();
    }

    @Override // java.util.Queue
    public Object remove() {
        return delegate().remove();
    }

    public boolean standardOffer(Object r5) {
        return add(r5);
    L4:
        return false;
    }

    public Object standardPeek() {
        return element();
    L4:
        return null;
    }

    public Object standardPoll() {
        return remove();
    L4:
        return null;
    }
}
