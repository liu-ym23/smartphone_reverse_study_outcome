package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes2.dex */
final class BlockingObservableIterable$BlockingObservableIterator<T> extends AtomicReference<io.reactivex.disposables.b> implements xb.o<T>, Iterator<T>, io.reactivex.disposables.b {
    private static final long serialVersionUID = 6695226475494099826L;
    final Condition condition;
    volatile boolean done;
    Throwable error;
    final Lock lock;
    final io.reactivex.internal.queue.a<T> queue;

    BlockingObservableIterable$BlockingObservableIterator(int r10) {
        this.queue = new io.reactivex.internal.queue.a(r10);
        ReentrantLock r11 = new ReentrantLock();
        this.lock = r11;
        this.condition = r11.newCondition();
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        DisposableHelper.dispose(this);
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
        if (r11 == false) goto L26;
        io.reactivex.internal.util.c.a();     // Catch: InterruptedException -> L23
        this.lock.lock();     // Catch: InterruptedException -> L23
    L30:
    L20:
        th = move-exception;
        this.lock.unlock();     // Catch: InterruptedException -> L23
        throw th;     // Catch: InterruptedException -> L23
    L14:
        if (this.done == true) goto L19;
        if (this.queue.isEmpty() == false) goto L19;
        this.condition.await();     // Catch: Throwable -> L20
    L19:
        this.lock.unlock();     // Catch: InterruptedException -> L23
    L23:
        e = move-exception;
        DisposableHelper.dispose(this);
        signalConsumer();
        throw ExceptionHelper.d(e);
    L26:
        return true;
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // java.util.Iterator
    public T next() {
        if (hasNext() == false) goto L7;
        return this.queue.poll();
    L7:
        throw new NoSuchElementException();
    }

    @Override // xb.o
    public void onComplete() {
        this.done = true;
        signalConsumer();
    }

    @Override // xb.o
    public void onError(Throwable r10) {
        this.error = r10;
        this.done = true;
        signalConsumer();
    }

    @Override // xb.o
    public void onNext(T r10) {
        this.queue.offer(r10);
        signalConsumer();
    }

    @Override // xb.o
    public void onSubscribe(io.reactivex.disposables.b r10) {
        DisposableHelper.setOnce(this, r10);
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("remove");
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
