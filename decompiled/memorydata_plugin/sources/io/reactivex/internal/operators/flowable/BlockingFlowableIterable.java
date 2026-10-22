package io.reactivex.internal.operators.flowable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.g;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.j;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes6.dex */
public final class BlockingFlowableIterable<T> implements Iterable<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final g<T> f16754a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f16755b;

    static final class BlockingFlowableIterator<T> extends AtomicReference<org.a.d> implements io.reactivex.disposables.b, j<T>, Runnable, Iterator<T> {
        private static final long serialVersionUID = 6695226475494099826L;
        final long batchSize;
        final Condition condition;
        volatile boolean done;
        volatile Throwable error;
        final long limit;
        final Lock lock;
        long produced;
        final SpscArrayQueue<T> queue;

        BlockingFlowableIterator(int r3) {
            this.queue = new SpscArrayQueue(r3);
            this.batchSize = r3;
            this.limit = r3 - (r3 >> 2);
            ReentrantLock r4 = new ReentrantLock();
            this.lock = r4;
            this.condition = r4.newCondition();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            SubscriptionHelper.cancel(this);
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
            if (r2 == false) goto L35;
            io.reactivex.internal.util.c.a();
            this.lock.lock();
        L37:
        L30:
            e = move-exception;
            run();     // Catch: Throwable -> L28
            throw ExceptionHelper.a(e);     // Catch: Throwable -> L28
        L28:
            th = move-exception;
            this.lock.unlock();
            throw th;
        L20:
            if (this.done == true) goto L27;
            if (this.queue.isEmpty() == false) goto L27;
            if (isDisposed() == true) goto L27;
            this.condition.await();     // Catch: Throwable -> L28 InterruptedException -> L30
        L27:
            this.lock.unlock();
            goto L3
        L35:
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
            if (get() != SubscriptionHelper.CANCELLED) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext() == false) goto L10;
            T r0 = this.queue.poll();
            long r1 = this.produced + 1;
            if (r1 != this.limit) goto L7;
            this.produced = 0;
            ((org.a.d) ZeusTransformUtils.preCheckCast(get(), org.a.d.class, "com.obric.memorydata.plugin")).request(r1);
        L8:
            return r0;
        L7:
            this.produced = r1;
            goto L8
        L10:
            throw new NoSuchElementException();
        }

        @Override // org.a.c
        public void onComplete() {
            this.done = true;
            signalConsumer();
        }

        @Override // org.a.c
        public void onError(Throwable r1) {
            this.error = r1;
            this.done = true;
            signalConsumer();
        }

        @Override // org.a.c
        public void onNext(T r2) {
            if (this.queue.offer(r2) == true) goto L5;
            SubscriptionHelper.cancel(this);
            onError(new MissingBackpressureException("Queue full?!"));
            return;
        L5:
            signalConsumer();
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d r3) {
            SubscriptionHelper.setOnce(this, (org.a.d) ZeusTransformUtils.wrapperContextForParams(r3, org.a.d.class, "com.obric.memorydata.plugin"), this.batchSize);
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

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        BlockingFlowableIterator r0 = new BlockingFlowableIterator(this.f16755b);
        this.f16754a.a(r0);
        return r0;
    }
}
