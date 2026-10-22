package org.apache.commons.collections4.iterators;

import java.util.Iterator;

/* JADX INFO: loaded from: classes6.dex */
public abstract class LazyIteratorChain<E> implements Iterator<E> {
    private int callCounter;
    private boolean chainExhausted;
    private Iterator<? extends E> currentIterator;
    private Iterator<? extends E> lastUsedIterator;

    public LazyIteratorChain() {
        this.callCounter = 0;
        this.chainExhausted = false;
        this.currentIterator = null;
        this.lastUsedIterator = null;
    }

    private void updateCurrentIterator() {
        int r0 = this.callCounter;
        if (r0 != 0) goto L9;
        int r1 = r0 + 1;
        this.callCounter = r1;
        Iterator<? extends E> r2 = nextIterator(r1);
        this.currentIterator = r2;
        if (r2 != null) goto L7;
        this.currentIterator = EmptyIterator.emptyIterator();
        this.chainExhausted = true;
    L7:
        this.lastUsedIterator = this.currentIterator;
    L9:
        if (this.currentIterator.hasNext() == true) goto L16;
        if (this.chainExhausted == true) goto L25;
        int r3 = this.callCounter + 1;
        this.callCounter = r3;
        Iterator<? extends E> r4 = nextIterator(r3);
        if (r4 != null) goto L14;
        this.chainExhausted = true;
        goto L9
    L14:
        this.currentIterator = r4;
        goto L9
    L25:
        return;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        updateCurrentIterator();
        Iterator<? extends E> r0 = this.currentIterator;
        this.lastUsedIterator = r0;
        return r0.hasNext();
    }

    @Override // java.util.Iterator
    public E next() {
        updateCurrentIterator();
        Iterator<? extends E> r0 = this.currentIterator;
        this.lastUsedIterator = r0;
        return r0.next();
    }

    public abstract Iterator<? extends E> nextIterator(int r1);

    @Override // java.util.Iterator
    public void remove() {
        if (this.currentIterator != null) goto L5;
        updateCurrentIterator();
    L5:
        this.lastUsedIterator.remove();
    }
}
