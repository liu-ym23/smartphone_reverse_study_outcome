package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes3.dex */
final class BlockingObservableIterable$BlockingObservableIterator<T> extends AtomicReference<Disposable> implements mt.u, Iterator<T>, Disposable {
    private static final long serialVersionUID = 6695226475494099826L;
    final Condition condition;
    volatile boolean done;
    Throwable error;
    final Lock lock;
    final io.reactivex.internal.queue.b queue;

    public BlockingObservableIterable$BlockingObservableIterator(int r5) {
        this.queue = new io.reactivex.internal.queue.b(r5);
        ReentrantLock r10 = new ReentrantLock();
        this.lock = r10;
        this.condition = r10.newCondition();
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this);
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
        this.lock.lock();     // Catch: InterruptedException -> L22
    L30:
    L19:
        th = move-exception;
        this.lock.unlock();     // Catch: InterruptedException -> L22
        throw th;     // Catch: InterruptedException -> L22
    L14:
        if (this.done == true) goto L21;
        if (this.queue.isEmpty() == false) goto L21;
        this.condition.await();     // Catch: Throwable -> L19
    L21:
        this.lock.unlock();     // Catch: InterruptedException -> L22
    L22:
        e = move-exception;
        DisposableHelper.dispose(this);
        signalConsumer();
        throw io.reactivex.internal.util.d.d(e);
    L28:
        return true;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // java.util.Iterator
    public T next() {
        if (hasNext() == false) goto L7;
        return (T) this.queue.poll();
    L7:
        throw new NoSuchElementException();
    }

    @Override // mt.u
    public void onComplete() {
        this.done = true;
        signalConsumer();
    }

    @Override // mt.u
    public void onError(Throwable r5) {
        this.error = r5;
        this.done = true;
        signalConsumer();
    }

    @Override // mt.u
    public void onNext(T r5) {
        this.queue.offer(r5);
        signalConsumer();
    }

    @Override // mt.u
    public void onSubscribe(Disposable r5) {
        DisposableHelper.setOnce(this, r5);
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("remove");
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
