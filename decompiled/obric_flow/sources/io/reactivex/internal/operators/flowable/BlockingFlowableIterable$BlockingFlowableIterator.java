package io.reactivex.internal.operators.flowable;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes3.dex */
final class BlockingFlowableIterable$BlockingFlowableIterator<T> extends AtomicReference<zu.d> implements mt.g, Iterator<T>, Runnable, Disposable {
    private static final long serialVersionUID = 6695226475494099826L;
    final long batchSize;
    final Condition condition;
    volatile boolean done;
    Throwable error;
    final long limit;
    final Lock lock;
    long produced;
    final SpscArrayQueue<T> queue;

    public BlockingFlowableIterable$BlockingFlowableIterator(int r5) {
        this.queue = new SpscArrayQueue(r5);
        this.batchSize = r5;
        this.limit = r5 - (r5 >> 2);
        ReentrantLock r10 = new ReentrantLock();
        this.lock = r10;
        this.condition = r10.newCondition();
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        SubscriptionHelper.cancel(this);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
    L2:
        boolean r5 = this.done;
        boolean r10 = this.queue.isEmpty();
        if (r5 == false) goto L11;
        Throwable r11 = this.error;
        if (r11 != null) goto L10;
        if (r10 == false) goto L11;
        return false;
    L10:
        throw io.reactivex.internal.util.d.d(r11);
    L11:
        if (r10 == false) goto L28;
        this.lock.lock();
    L30:
    L19:
        th = move-exception;
        this.lock.unlock();
        throw th;
    L21:
        e = move-exception;
        run();     // Catch: Throwable -> L19
        throw io.reactivex.internal.util.d.d(e);     // Catch: Throwable -> L19
    L14:
        if (this.done == true) goto L23;
        if (this.queue.isEmpty() == false) goto L23;
        this.condition.await();     // Catch: Throwable -> L19 InterruptedException -> L21
    L23:
        this.lock.unlock();
        goto L2
    L28:
        return true;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        if (get() != SubscriptionHelper.CANCELLED) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Iterator
    public T next() {
        if (hasNext() == false) goto L10;
        T r5 = this.queue.poll();
        long r10 = this.produced + 1;
        if (r10 != this.limit) goto L7;
        this.produced = 0;
        get().request(r10);
    L8:
        return r5;
    L7:
        this.produced = r10;
        goto L8
    L10:
        throw new NoSuchElementException();
    }

    @Override // zu.c
    public void onComplete() {
        this.done = true;
        signalConsumer();
    }

    @Override // zu.c
    public void onError(Throwable r5) {
        this.error = r5;
        this.done = true;
        signalConsumer();
    }

    @Override // zu.c
    public void onNext(T r5) {
        if (this.queue.offer(r5) == true) goto L5;
        SubscriptionHelper.cancel(this);
        onError(new MissingBackpressureException("Queue full?!"));
        return;
    L5:
        signalConsumer();
    }

    @Override // zu.c
    public void onSubscribe(zu.d r5) {
        SubscriptionHelper.setOnce(this, r5, this.batchSize);
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("remove");
    }

    @Override // java.lang.Runnable
    public void run() {
        SubscriptionHelper.cancel(this);
        signalConsumer();
    }

    public void signalConsumer() {
        this.lock.lock();
        this.condition.signalAll();     // Catch: Throwable -> L6
        this.lock.unlock();
        return;
    L6:
        th = move-exception;
        this.lock.unlock();
        throw th;
    }
}
