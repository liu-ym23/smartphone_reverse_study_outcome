package emc;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d<E extends Delayed> extends AbstractQueue<E> implements BlockingQueue<E> {
    public final transient ReentrantLock a;
    public final PriorityQueue<E> b;
    public Thread c;
    public final Condition d;

    public class a implements Iterator<E> {
        public final Object[] a;
        public int b;
        public int c;
        public final /* synthetic */ d d;

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.b >= this.a.length) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Iterator
        public final Object next() {
            int r0 = this.b;
            Object[] r1 = this.a;
            if (r0 >= r1.length) goto L7;
            this.c = r0;
            this.b = r0 + 1;
            return (Delayed) r1[r0];
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public final void remove() {
            int r0 = this.c;
            if (r0 < 0) goto L17;
            d r1 = this.d;
            Object r2 = this.a[r0];
            ReentrantLock r3 = r1.a;
            r3.lock();
            Iterator<E> r4 = r1.b.iterator();     // Catch: Throwable -> L13
        L7:
            if (r4.hasNext() == false) goto L11;
            if (r2 != r4.next()) goto L7;
            r4.remove();     // Catch: Throwable -> L13
        L11:
            r3.unlock();
            this.c = -1;
            return;
        L13:
            th = move-exception;
            r3.unlock();
            throw th;
        L17:
            throw new IllegalStateException();
        }

        public a(d r1, Object[] r2) {
            this.d = r1;
            this.c = -1;
            this.a = r2;
        }
    }

    @Override // java.util.concurrent.BlockingQueue
    public final int remainingCapacity() {
        return Integer.MAX_VALUE;
    }

    public final E c() throws InterruptedException {
        ReentrantLock r0 = this.a;
        r0.lockInterruptibly();
    L41:
        E r1 = this.b.peek();     // Catch: Throwable -> L33
        if (r1 == null) goto L5;
        TimeUnit r2 = TimeUnit.NANOSECONDS;     // Catch: Throwable -> L33
        long r3 = r1.getDelay(r2);     // Catch: Throwable -> L33
        if (r3 <= 0) goto L8;
        if (this.c != null) goto L18;
        Thread r4 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L33
        this.c = r4;     // Catch: Throwable -> L33
        long r6 = r2.convert(200, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L28
        if (r3 <= r6) goto L24;
        this.d.awaitNanos(r6);     // Catch: Throwable -> L28
    L26:
        if (this.c != r4) goto L41;
        this.c = null;     // Catch: Throwable -> L33
        goto L41
    L24:
        this.d.awaitNanos(r3);     // Catch: Throwable -> L28
        goto L26
    L28:
        th = move-exception;
        if (this.c != r4) goto L32;
        this.c = null;     // Catch: Throwable -> L33
    L32:
        throw th;     // Catch: Throwable -> L33
    L18:
        this.d.await();     // Catch: Throwable -> L33
        goto L41
    L8:
        E r5 = this.b.poll();     // Catch: Throwable -> L33
        if (this.c == null) goto L12;
    L14:
        r0.unlock();
        return r5;
    L12:
        if (this.b.peek() == null) goto L14;
        this.d.signal();
        goto L14
    L5:
        this.d.await();     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        if (this.c == null) goto L37;
    L39:
        r0.unlock();
        throw th;
    L37:
        if (this.b.peek() == null) goto L39;
        this.d.signal();
        goto L39
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        ReentrantLock r0 = this.a;
        r0.lock();
        this.b.clear();     // Catch: Throwable -> L6
        r0.unlock();
        return;
    L6:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        return new a(this, toArray());
    }

    @Override // java.util.Queue
    public final Object peek() {
        ReentrantLock r0 = this.a;
        r0.lock();
        E r1 = this.b.peek();     // Catch: Throwable -> L6
        r0.unlock();
        return r1;
    L6:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    @Override // java.util.Queue
    public final Object poll() {
        ReentrantLock r0 = this.a;
        r0.lock();
        E r1 = this.b.peek();     // Catch: Throwable -> L13
        if (r1 != null) goto L6;
    L10:
        E r2 = null;
    L11:
        r0.unlock();
        return r2;
    L6:
        if (r1.getDelay(TimeUnit.NANOSECONDS) > 0) goto L10;
        r2 = this.b.poll();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        ReentrantLock r0 = this.a;
        r0.lock();
        int r1 = this.b.size();     // Catch: Throwable -> L6
        r0.unlock();
        return r1;
    L6:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray() {
        ReentrantLock r0 = this.a;
        r0.lock();
        Object[] r1 = this.b.toArray();     // Catch: Throwable -> L6
        r0.unlock();
        return r1;
    L6:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    public d() {
        ReentrantLock r0 = new ReentrantLock();
        this.a = r0;
        this.b = new PriorityQueue();
        this.d = r0.newCondition();
    }

    @Override // java.util.concurrent.BlockingQueue
    public final /* bridge */ /* synthetic */ Object take() throws InterruptedException {
        return c();
    }

    public final void a(Delayed r3) {
        ReentrantLock r0 = this.a;
        r0.lock();
        this.b.offer(r3);     // Catch: Throwable -> L8
        if (this.b.peek() != r3) goto L6;
        this.c = null;     // Catch: Throwable -> L8
        this.d.signal();     // Catch: Throwable -> L8
    L6:
        r0.unlock();
        return;
    L8:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Queue, java.util.concurrent.BlockingQueue
    public final boolean add(Object r1) {
        a((Delayed) r1);
        return true;
    }

    @Override // java.util.concurrent.BlockingQueue
    public final int drainTo(Collection<? super E> r9) {
        r9.getClass();
        if (r9 == this) goto L20;
        ReentrantLock r0 = this.a;
        r0.lock();
        int r1 = 0;
    L21:
        E r2 = this.b.peek();     // Catch: Throwable -> L13
        if (r2 != null) goto L8;
    L9:
        r2 = null;
    L10:
        if (r2 == null) goto L15;
        r9.add(r2);     // Catch: Throwable -> L13
        this.b.poll();     // Catch: Throwable -> L13
        r1 = r1 + 1;
        goto L21
    L15:
        r0.unlock();
        return r1;
    L8:
        if (r2.getDelay(TimeUnit.NANOSECONDS) <= 0) goto L10;
    L13:
        th = move-exception;
        r0.unlock();
        throw th;
    L20:
        throw new IllegalArgumentException();
    }

    @Override // java.util.Queue, java.util.concurrent.BlockingQueue
    public final /* bridge */ /* synthetic */ boolean offer(Object r1) {
        a((Delayed) r1);
        return true;
    }

    @Override // java.util.concurrent.BlockingQueue
    public final void put(Object r1) throws InterruptedException {
        a((Delayed) r1);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.concurrent.BlockingQueue
    public final boolean remove(Object r3) {
        ReentrantLock r0 = this.a;
        r0.lock();
        boolean r4 = this.b.remove(r3);     // Catch: Throwable -> L6
        r0.unlock();
        return r4;
    L6:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final <T> T[] toArray(T[] r3) {
        ReentrantLock r0 = this.a;
        r0.lock();
        T[] r4 = (T[]) this.b.toArray(r3);
        r0.unlock();
        return r4;
    L6:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    @Override // java.util.concurrent.BlockingQueue
    public final int drainTo(Collection<? super E> r9, int r10) {
        r9.getClass();
        if (r9 == this) goto L23;
        int r0 = 0;
        if (r10 > 0) goto L7;
        return 0;
    L7:
        ReentrantLock r1 = this.a;
        r1.lock();
    L8:
        if (r0 >= r10) goto L20;
        E r2 = this.b.peek();     // Catch: Throwable -> L17
        if (r2 != null) goto L12;
    L13:
        r2 = null;
    L14:
        if (r2 == null) goto L20;
        r9.add(r2);     // Catch: Throwable -> L17
        this.b.poll();     // Catch: Throwable -> L17
        r0 = r0 + 1;
        goto L8
    L12:
        if (r2.getDelay(TimeUnit.NANOSECONDS) <= 0) goto L14;
    L17:
        th = move-exception;
        r1.unlock();
        throw th;
    L20:
        r1.unlock();
        return r0;
    L23:
        throw new IllegalArgumentException();
    }

    @Override // java.util.concurrent.BlockingQueue
    public final Object poll(long r7, TimeUnit r9) throws InterruptedException {
        long r8 = r9.toNanos(r7);
        ReentrantLock r10 = this.a;
        r10.lockInterruptibly();
    L59:
        E r0 = this.b.peek();     // Catch: Throwable -> L49
        E r3 = null;
        if (r0 == null) goto L7;
        long r4 = r0.getDelay(TimeUnit.NANOSECONDS);     // Catch: Throwable -> L49
        if (r4 <= 0) goto L17;
        if (r8 <= 0) goto L26;
        if (r8 < r4) goto L47;
        if (this.c != null) goto L47;
        Thread r1 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L49
        this.c = r1;     // Catch: Throwable -> L49
        r8 = r8 - (r4 - this.d.awaitNanos(r4));
        if (this.c != r1) goto L59;
        this.c = null;     // Catch: Throwable -> L49
        goto L59
    L42:
        th = move-exception;
        if (this.c != r1) goto L46;
        this.c = null;     // Catch: Throwable -> L49
    L46:
        throw th;     // Catch: Throwable -> L49
    L47:
        r8 = this.d.awaitNanos(r8);     // Catch: Throwable -> L49
        goto L59
    L26:
        if (this.c == null) goto L28;
    L13:
        r10.unlock();
        return r3;
    L28:
        if (this.b.peek() == null) goto L13;
    L12:
        this.d.signal();
        goto L13
    L17:
        r3 = this.b.poll();     // Catch: Throwable -> L49
        if (this.c != null) goto L13;
        if (this.b.peek() == null) goto L13;
    L7:
        if (r8 <= 0) goto L9;
        r8 = this.d.awaitNanos(r8);     // Catch: Throwable -> L49
        goto L59
    L9:
        if (this.c != null) goto L13;
        if (this.b.peek() == null) goto L13;
    L49:
        th = move-exception;
        if (this.c == null) goto L53;
    L55:
        r10.unlock();
        throw th;
    L53:
        if (this.b.peek() == null) goto L55;
        this.d.signal();
        goto L55
    }

    @Override // java.util.concurrent.BlockingQueue
    public final boolean offer(Object r1, long r2, TimeUnit r4) throws InterruptedException {
        a((Delayed) r1);
        return true;
    }
}
