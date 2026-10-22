package org.apache.commons.collections4.iterators;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/* JADX INFO: loaded from: classes6.dex */
public class IteratorChain<E> implements Iterator<E> {
    private Iterator<? extends E> currentIterator;
    private boolean isLocked;
    private final Queue<Iterator<? extends E>> iteratorChain;
    private Iterator<? extends E> lastUsedIterator;

    public IteratorChain() {
        this.iteratorChain = new LinkedList();
        this.currentIterator = null;
        this.lastUsedIterator = null;
        this.isLocked = false;
    }

    private void checkLocked() {
        if (this.isLocked == true) goto L6;
        return;
    L6:
        throw new UnsupportedOperationException("IteratorChain cannot be changed after the first use of a method from the Iterator interface");
    }

    private void lockChain() {
        if (this.isLocked == true) goto L6;
        this.isLocked = true;
        return;
    }

    public void addIterator(Iterator<? extends E> r3) {
        Iterator<? extends E> r4 = (Iterator) ZeusTransformUtils.wrapperContextForParams(r3, Iterator.class, "com.obric.memorydata.plugin");
        checkLocked();
        Objects.requireNonNull(r4, "Iterator must not be null");
        this.iteratorChain.add(r4);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        lockChain();
        updateCurrentIterator();
        Iterator<? extends E> r0 = this.currentIterator;
        this.lastUsedIterator = r0;
        return r0.hasNext();
    }

    @Override // java.util.Iterator
    public E next() {
        lockChain();
        updateCurrentIterator();
        Iterator<? extends E> r0 = this.currentIterator;
        this.lastUsedIterator = r0;
        return r0.next();
    }

    @Override // java.util.Iterator
    public void remove() {
        lockChain();
        if (this.currentIterator != null) goto L5;
        updateCurrentIterator();
    L5:
        this.lastUsedIterator.remove();
    }

    public void updateCurrentIterator() {
        if (this.currentIterator != null) goto L10;
        if (this.iteratorChain.isEmpty() == false) goto L7;
        Iterator<? extends E> r0 = EmptyIterator.emptyIterator();
    L8:
        this.currentIterator = r0;
        this.lastUsedIterator = this.currentIterator;
        goto L10
    L7:
        r0 = (Iterator) ZeusTransformUtils.preCheckCast(this.iteratorChain.remove(), Iterator.class, "com.obric.memorydata.plugin");
    L10:
        if (this.currentIterator.hasNext() == true) goto L14;
        if (this.iteratorChain.isEmpty() == true) goto L18;
        this.currentIterator = (Iterator) ZeusTransformUtils.preCheckCast(this.iteratorChain.remove(), Iterator.class, "com.obric.memorydata.plugin");
        goto L10
    L18:
        return;
    }
}
