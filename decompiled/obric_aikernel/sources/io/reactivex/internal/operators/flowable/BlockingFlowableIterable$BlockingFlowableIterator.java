package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes2.dex */
final class BlockingFlowableIterable$BlockingFlowableIterator<T> extends AtomicReference<tc.d> implements xb.g<T>, Iterator<T>, Runnable, io.reactivex.disposables.b {
    private static final long serialVersionUID = 6695226475494099826L;
    final long batchSize;
    final Condition condition;
    volatile boolean done;
    Throwable error;
    final long limit;
    final Lock lock;
    long produced;
    final SpscArrayQueue<T> queue;

    BlockingFlowableIterable$BlockingFlowableIterator(int r10) {
        this.queue = new SpscArrayQueue(r10);
        this.batchSize = r10;
        this.limit = r10 - (r10 >> 2);
        ReentrantLock r11 = new ReentrantLock();
        this.lock = r11;
        this.condition = r11.newCondition();
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        SubscriptionHelper.cancel(this);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
    L2:
        boolean r10 = this.done;
        boolean r11 = this.queue.isEmpty();
        if (r10 == false) goto L11;
        Throwable r12 = this.error;
        if (r12 != null) goto L10;
        if (r11 == false) goto L11;
        return false;
    L10:
        throw ExceptionHelper.d(r12);
    L11:
        if (r11 == false) goto L27;
        io.reactivex.internal.util.c.a();
        this.lock.lock();
    L29:
    L20:
        th = move-exception;
        this.lock.unlock();
        throw th;
    L22:
        e = move-exception;
        run();     // Catch: Throwable -> L20
        throw ExceptionHelper.d(e);     // Catch: Throwable -> L20
    L14:
        if (this.done == true) goto L19;
        if (this.queue.isEmpty() == false) goto L19;
        this.condition.await();     // Catch: Throwable -> L20 InterruptedException -> L22
    L19:
        this.lock.unlock();
        goto L2
    L27:
        return true;
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        if (get() != SubscriptionHelper.CANCELLED) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Iterator
    public T next() {
        if (hasNext() == false) goto L10;
        T r10 = this.queue.poll();
        long r11 = this.produced + 1;
        if (r11 != this.limit) goto L7;
        this.produced = 0;
        get().request(r11);
    L8:
        return r10;
    L7:
        this.produced = r11;
        goto L8
    L10:
        throw new NoSuchElementException();
    }

    @Override // tc.c
    public void onComplete() {
        this.done = true;
        signalConsumer();
    }

    @Override // tc.c
    public void onError(Throwable r10) {
        this.error = r10;
        this.done = true;
        signalConsumer();
    }

    @Override // tc.c
    public void onNext(T r10) {
        if (this.queue.offer(r10) == true) goto L5;
        SubscriptionHelper.cancel(this);
        onError(new MissingBackpressureException("Queue full?!"));
        return;
    L5:
        signalConsumer();
    }

    @Override // xb.g, tc.c
    public void onSubscribe(tc.d r10) {
        SubscriptionHelper.setOnce(this, r10, this.batchSize);
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

    void signalConsumer() {
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
