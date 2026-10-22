package org.apache.commons.collections4.iterators;

import java.util.NoSuchElementException;
import org.apache.commons.collections4.ResettableIterator;

/* JADX INFO: loaded from: classes6.dex */
public class SingletonIterator<E> implements ResettableIterator<E> {
    private boolean beforeFirst;
    private E object;
    private final boolean removeAllowed;
    private boolean removed;

    public SingletonIterator(E r2, boolean r3) {
        this.beforeFirst = true;
        this.removed = false;
        this.object = r2;
        this.removeAllowed = r3;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.beforeFirst == true) goto L5;
    L7:
        return false;
    L5:
        if (this.removed == true) goto L7;
        return true;
    }

    @Override // java.util.Iterator
    public E next() {
        if (this.beforeFirst == false) goto L9;
        if (this.removed == true) goto L9;
        this.beforeFirst = false;
        return this.object;
    L9:
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public void remove() {
        if (this.removeAllowed == false) goto L13;
        if (this.removed == true) goto L11;
        if (this.beforeFirst == true) goto L11;
        this.object = null;
        this.removed = true;
        return;
    L11:
        throw new IllegalStateException();
    L13:
        throw new UnsupportedOperationException();
    }
}
