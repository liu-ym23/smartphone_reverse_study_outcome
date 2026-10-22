package io.reactivex.internal.operators.observable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.s;
import io.reactivex.t;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes6.dex */
public final class BlockingObservableIterable<T> implements Iterable<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final s<? extends T> f16918a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f16919b;

    static final class BlockingObservableIterator<T> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, t<T>, Iterator<T> {
        private static final long serialVersionUID = 6695226475494099826L;
        final Condition condition;
        volatile boolean done;
        volatile Throwable error;
        final Lock lock;
        final io.reactivex.internal.queue.a<T> queue;

        BlockingObservableIterator(int r2) {
            this.queue = new io.reactivex.internal.queue.a(r2);
            ReentrantLock r3 = new ReentrantLock();
            this.lock = r3;
            this.condition = r3.newCondition();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
            signalConsumer();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
        L3:
            if (isDisposed() == true) goto L4;
            boolean r0 = this.done;
            boolean r2 = this.queue.isEmpty();
            if (r0 == false) goto L17;
            Throwable r1 = this.error;
            if (r1 != null) goto L16;
            if (r2 == false) goto L17;
            return false;
        L16:
            throw ExceptionHelper.a(r1);
        L17:
            if (r2 == false) goto L34;
            io.reactivex.internal.util.c.a();     // Catch: InterruptedException -> L31
            this.lock.lock();     // Catch: InterruptedException -> L31
        L38:
        L28:
            th = move-exception;
            this.lock.unlock();     // Catch: InterruptedException -> L31
            throw th;     // Catch: InterruptedException -> L31
        L20:
            if (this.done == true) goto L27;
            if (this.queue.isEmpty() == false) goto L27;
            if (isDisposed() == true) goto L27;
            this.condition.await();     // Catch: Throwable -> L28
        L27:
            this.lock.unlock();     // Catch: InterruptedException -> L31
        L31:
            e = move-exception;
            DisposableHelper.dispose(this);
            signalConsumer();
            throw ExceptionHelper.a(e);
        L34:
            return true;
        L4:
            Throwable r3 = this.error;
            if (r3 != null) goto L8;
            return false;
        L8:
            throw ExceptionHelper.a(r3);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed((io.reactivex.disposables.b) ZeusTransformUtils.preCheckCast(get(), io.reactivex.disposables.b.class, "com.obric.memorydata.plugin"));
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext() == false) goto L7;
            return this.queue.poll();
        L7:
            throw new NoSuchElementException();
        }

        @Override // io.reactivex.t
        public void onComplete() {
            this.done = true;
            signalConsumer();
        }

        @Override // io.reactivex.t
        public void onError(Throwable r1) {
            this.error = r1;
            this.done = true;
            signalConsumer();
        }

        @Override // io.reactivex.t
        public void onNext(T r2) {
            this.queue.offer(r2);
            signalConsumer();
        }

        @Override // io.reactivex.t
        public void onSubscribe(io.reactivex.disposables.b r3) {
            DisposableHelper.setOnce(this, (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin"));
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

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        BlockingObservableIterator r0 = new BlockingObservableIterator(this.f16919b);
        this.f16918a.subscribe(r0);
        return r0;
    }
}
