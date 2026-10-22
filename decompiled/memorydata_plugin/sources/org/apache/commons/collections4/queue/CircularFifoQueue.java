package org.apache.commons.collections4.queue;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Queue;
import org.apache.commons.collections4.BoundedCollection;

/* JADX INFO: loaded from: classes6.dex */
public class CircularFifoQueue<E> extends AbstractCollection<E> implements Serializable, Queue<E>, BoundedCollection<E> {
    private static final long serialVersionUID = -8423413834657610406L;
    private transient E[] elements;
    private transient int end;
    private transient boolean full;
    private final int maxElements;
    private transient int start;

    public CircularFifoQueue() {
        this(32);
    }

    public CircularFifoQueue(int r3) {
        this.start = 0;
        this.end = 0;
        this.full = false;
        if (r3 <= 0) goto L7;
        E[] r4 = (E[]) ((Object[]) ZeusTransformUtils.preCheckCast(new Object[r3], Object[].class, "com.obric.memorydata.plugin"));
        this.elements = r4;
        this.maxElements = r4.length;
        return;
    L7:
        throw new IllegalArgumentException("The size must be greater than 0");
    }

    public CircularFifoQueue(Collection<? extends E> r3) {
        Collection<? extends E> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        this(r4.size());
        addAll(r4);
    }

    static /* synthetic */ int access$000(CircularFifoQueue r0) {
        return r0.start;
    }

    static /* synthetic */ boolean access$100(CircularFifoQueue r0) {
        return r0.full;
    }

    static /* synthetic */ boolean access$102(CircularFifoQueue r0, boolean r1) {
        r0.full = r1;
        return r1;
    }

    static /* synthetic */ int access$200(CircularFifoQueue r0) {
        return r0.end;
    }

    static /* synthetic */ int access$202(CircularFifoQueue r0, int r1) {
        r0.end = r1;
        return r1;
    }

    static /* synthetic */ int access$300(CircularFifoQueue r0, int r1) {
        return r0.increment(r1);
    }

    static /* synthetic */ Object[] access$400(CircularFifoQueue r0) {
        return r0.elements;
    }

    static /* synthetic */ int access$500(CircularFifoQueue r0) {
        return r0.maxElements;
    }

    static /* synthetic */ int access$600(CircularFifoQueue r0, int r1) {
        return r0.decrement(r1);
    }

    private int decrement(int r1) {
        int r2 = r1 - 1;
        if (r2 < 0) goto L5;
        return r2;
    L5:
        return this.maxElements - 1;
    }

    private int increment(int r1) {
        int r2 = r1 + 1;
        if (r2 < this.maxElements) goto L6;
        return 0;
    L6:
        return r2;
    }

    private void readObject(ObjectInputStream r6) {
        r6.defaultReadObject();
        this.elements = (E[]) ((Object[]) ZeusTransformUtils.preCheckCast(new Object[this.maxElements], Object[].class, "com.obric.memorydata.plugin"));
        int r0 = r6.readInt();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        ((E[]) this.elements)[r2] = r6.readObject();
        r2 = r2 + 1;
        goto L3
    L5:
        this.start = 0;
        if (r0 != this.maxElements) goto L8;
        boolean r7 = true;
    L9:
        this.full = r7;
        if (r7 == false) goto L12;
        this.end = 0;
        return;
    L12:
        this.end = r0;
        return;
    L8:
        r7 = false;
        goto L9
    }

    private void writeObject(ObjectOutputStream r2) {
        r2.defaultWriteObject();
        r2.writeInt(size());
        Iterator<E> r1 = iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r2.writeObject(r1.next());
        goto L4
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Queue
    public boolean add(E r4) {
        Objects.requireNonNull(r4, "Attempted to add null object to queue");
        if (isAtFullCapacity() == false) goto L5;
        remove();
    L5:
        E[] r0 = this.elements;
        int r1 = this.end;
        int r2 = r1 + 1;
        this.end = r2;
        r0[r1] = r4;
        if (r2 < this.maxElements) goto L9;
        this.end = 0;
    L9:
        if (this.end != this.start) goto L11;
        this.full = true;
    L11:
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
        this.full = false;
        this.start = 0;
        this.end = 0;
        Arrays.fill(this.elements, null);
    }

    @Override // java.util.Queue
    public E element() {
        if (isEmpty() == true) goto L7;
        return peek();
    L7:
        throw new NoSuchElementException("queue is empty");
    }

    public E get(int r4) {
        int r0 = size();
        if (r4 < 0) goto L8;
        if (r4 >= r0) goto L8;
        return this.elements[(this.start + r4) % this.maxElements];
    L8:
        throw new NoSuchElementException(String.format("The specified index (%1$d) is outside the available range [0, %2$d)", new Object[]{Integer.valueOf(r4), Integer.valueOf(r0)}));
    }

    public boolean isAtFullCapacity() {
        if (size() != this.maxElements) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        if (size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.apache.commons.collections4.BoundedCollection
    public boolean isFull() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return new AnonymousClass1(this);
    }

    @Override // org.apache.commons.collections4.BoundedCollection
    public int maxSize() {
        return this.maxElements;
    }

    @Override // java.util.Queue
    public boolean offer(E r1) {
        return add(r1);
    }

    @Override // java.util.Queue
    public E peek() {
        if (isEmpty() == false) goto L7;
        return null;
    L7:
        return this.elements[this.start];
    }

    @Override // java.util.Queue
    public E poll() {
        if (isEmpty() == false) goto L7;
        return null;
    L7:
        return remove();
    }

    @Override // java.util.Queue
    public E remove() {
        if (isEmpty() == true) goto L12;
        E[] r0 = this.elements;
        int r1 = this.start;
        E r2 = r0[r1];
        if (r2 == null) goto L10;
        int r3 = r1 + 1;
        this.start = r3;
        r0[r1] = null;
        if (r3 < this.maxElements) goto L9;
        this.start = 0;
    L9:
        this.full = false;
    L10:
        return r2;
    L12:
        throw new NoSuchElementException("queue is empty");
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        int r0 = this.end;
        int r1 = this.start;
        if (r0 < r1) goto L12;
        if (r0 != r1) goto L11;
        if (this.full == true) goto L13;
        return 0;
    L13:
        return this.maxElements;
    L11:
        return r0 - r1;
    L12:
        return (this.maxElements - r1) + r0;
    }
}
