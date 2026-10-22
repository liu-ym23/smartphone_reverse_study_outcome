package org.apache.commons.collections4.iterators;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import org.apache.commons.collections4.ResettableListIterator;

/* JADX INFO: loaded from: classes6.dex */
public class ListIteratorWrapper<E> implements ResettableListIterator<E> {
    private int currentIndex;
    private final Iterator<? extends E> iterator;
    private final List<E> list;
    private boolean removeState;
    private int wrappedIteratorIndex;

    public ListIteratorWrapper(Iterator<? extends E> r3) {
        Iterator<? extends E> r4 = (Iterator) ZeusTransformUtils.wrapperContextForParams(r3, Iterator.class, "com.obric.memorydata.plugin");
        this.list = new ArrayList();
        this.currentIndex = 0;
        this.wrappedIteratorIndex = 0;
        Objects.requireNonNull(r4, "Iterator must not be null");
        this.iterator = r4;
    }

    @Override // java.util.ListIterator
    public void add(E r3) {
        if (ZeusTransformUtils.instanceOf(this.iterator, ListIterator.class) == false) goto L7;
        ((ListIterator) ZeusTransformUtils.preCheckCast(this.iterator, ListIterator.class, "com.obric.memorydata.plugin")).add(r3);
        return;
    L7:
        throw new UnsupportedOperationException("ListIteratorWrapper does not support optional operations of ListIterator.");
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public boolean hasNext() {
        if (this.currentIndex == this.wrappedIteratorIndex) goto L10;
        if (ZeusTransformUtils.instanceOf(this.iterator, ListIterator.class) == true) goto L10;
        return true;
    L10:
        return this.iterator.hasNext();
    }

    @Override // java.util.ListIterator
    public boolean hasPrevious() {
        if (ZeusTransformUtils.instanceOf(this.iterator, ListIterator.class) == false) goto L7;
        return ((ListIterator) ZeusTransformUtils.preCheckCast(this.iterator, ListIterator.class, "com.obric.memorydata.plugin")).hasPrevious();
    L7:
        if (this.currentIndex <= 0) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public E next() {
        if (ZeusTransformUtils.instanceOf(this.iterator, ListIterator.class) == true) goto L5;
        int r0 = this.currentIndex;
        if (r0 >= this.wrappedIteratorIndex) goto L10;
        int r1 = r0 + 1;
        this.currentIndex = r1;
        return this.list.get(r1 - 1);
    L10:
        E r2 = this.iterator.next();
        this.list.add(r2);
        this.currentIndex++;
        this.wrappedIteratorIndex++;
        this.removeState = true;
        return r2;
    L5:
        return this.iterator.next();
    }

    @Override // java.util.ListIterator
    public int nextIndex() {
        if (ZeusTransformUtils.instanceOf(this.iterator, ListIterator.class) == false) goto L7;
        return ((ListIterator) ZeusTransformUtils.preCheckCast(this.iterator, ListIterator.class, "com.obric.memorydata.plugin")).nextIndex();
    L7:
        return this.currentIndex;
    }

    @Override // java.util.ListIterator
    public E previous() {
        if (ZeusTransformUtils.instanceOf(this.iterator, ListIterator.class) == true) goto L5;
        int r0 = this.currentIndex;
        if (r0 == 0) goto L15;
        if (this.wrappedIteratorIndex != r0) goto L11;
        boolean r1 = true;
    L12:
        this.removeState = r1;
        List<E> r2 = this.list;
        int r3 = r0 - 1;
        this.currentIndex = r3;
        return r2.get(r3);
    L11:
        r1 = false;
        goto L12
    L15:
        throw new NoSuchElementException();
    L5:
        return (E) ((ListIterator) ZeusTransformUtils.preCheckCast(this.iterator, ListIterator.class, "com.obric.memorydata.plugin")).previous();
    }

    @Override // java.util.ListIterator
    public int previousIndex() {
        if (ZeusTransformUtils.instanceOf(this.iterator, ListIterator.class) == false) goto L7;
        return ((ListIterator) ZeusTransformUtils.preCheckCast(this.iterator, ListIterator.class, "com.obric.memorydata.plugin")).previousIndex();
    L7:
        return this.currentIndex - 1;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public void remove() {
        if (ZeusTransformUtils.instanceOf(this.iterator, ListIterator.class) == false) goto L6;
        this.iterator.remove();
        return;
    L6:
        int r0 = this.currentIndex;
        int r1 = this.wrappedIteratorIndex;
        if (r0 != r1) goto L9;
        int r2 = r0 - 1;
    L11:
        if (this.removeState == false) goto L17;
        if ((r1 - r0) > 1) goto L17;
        this.iterator.remove();
        this.list.remove(r2);
        this.currentIndex = r2;
        this.wrappedIteratorIndex--;
        this.removeState = false;
        return;
    L17:
        throw new IllegalStateException(MessageFormat.format("Cannot remove element at index {0}.", new Object[]{Integer.valueOf(r2)}));
    L9:
        r2 = r0;
        goto L11
    }

    @Override // java.util.ListIterator
    public void set(E r3) {
        if (ZeusTransformUtils.instanceOf(this.iterator, ListIterator.class) == false) goto L7;
        ((ListIterator) ZeusTransformUtils.preCheckCast(this.iterator, ListIterator.class, "com.obric.memorydata.plugin")).set(r3);
        return;
    L7:
        throw new UnsupportedOperationException("ListIteratorWrapper does not support optional operations of ListIterator.");
    }
}
