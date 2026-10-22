package kotlin.reflect.jvm.internal.pcollections;

import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
final class ConsPStack<E> implements Iterable<E> {
    private static final ConsPStack<Object> EMPTY = null;
    final E first;
    final ConsPStack<E> rest;
    private final int size;

    private static class Itr<E> implements Iterator<E> {
        private ConsPStack<E> next;

        public Itr(ConsPStack<E> r10) {
            this.next = r10;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (ConsPStack.access$000(this.next) <= 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Iterator
        public E next() {
            ConsPStack<E> r10 = this.next;
            E r11 = r10.first;
            this.next = r10.rest;
            return r11;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    static {
        EMPTY = new ConsPStack();
    }

    private ConsPStack() {
        this.size = 0;
        this.first = null;
        this.rest = null;
    }

    private ConsPStack(E r10, ConsPStack<E> r11) {
        this.first = r10;
        this.rest = r11;
        this.size = r11.size + 1;
    }

    static /* synthetic */ int access$000(ConsPStack r10) {
        return r10.size;
    }

    public static <E> ConsPStack<E> empty() {
        return (ConsPStack<E>) EMPTY;
    }

    private Iterator<E> iterator(int r10) {
        return new Itr(subList(r10));
    }

    private ConsPStack<E> minus(Object r10) {
        if (this.size != 0) goto L6;
        return this;
    L6:
        if (this.first.equals(r10) == true) goto L8;
        ConsPStack<E> r11 = this.rest.minus(r10);
        if (r11 != this.rest) goto L13;
        return this;
    L13:
        return new ConsPStack(this.first, r11);
    L8:
        return this.rest;
    }

    private ConsPStack<E> subList(int r10) {
        if (r10 < 0) goto L10;
        if (r10 > this.size) goto L10;
        if (r10 != 0) goto L8;
        return this;
    L8:
        return this.rest.subList(r10 - 1);
    L10:
        throw new IndexOutOfBoundsException();
    }

    public E get(int r10) {
        if (r10 < 0) goto L10;
        if (r10 > this.size) goto L10;
        return iterator(r10).next();
    L8:
        throw new IndexOutOfBoundsException("Index: " + r10);
    L10:
        throw new IndexOutOfBoundsException();
    }

    @Override // java.lang.Iterable
    public Iterator<E> iterator() {
        return iterator(0);
    }

    public ConsPStack<E> minus(int r10) {
        return minus(get(r10));
    }

    public ConsPStack<E> plus(E r10) {
        return new ConsPStack(r10, this);
    }

    public int size() {
        return this.size;
    }
}
