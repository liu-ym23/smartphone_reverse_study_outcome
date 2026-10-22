package io.reactivex.internal.operators.observable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.Observable;
import io.reactivex.b.f;
import io.reactivex.internal.disposables.CancellableDisposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.q;
import io.reactivex.r;
import io.reactivex.t;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class ObservableCreate<T> extends Observable<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final r<T> f16938a;

    static final class CreateEmitter<T> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, q<T> {
        private static final long serialVersionUID = -3434801548987643227L;
        final t<? super T> observer;

        CreateEmitter(t<? super T> r3) {
            this.observer = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed((io.reactivex.disposables.b) ZeusTransformUtils.preCheckCast(get(), io.reactivex.disposables.b.class, "com.obric.memorydata.plugin"));
        }

        @Override // io.reactivex.f
        public void onComplete() {
            if (isDisposed() == false) goto L10;
            return;
        L10:
            this.observer.onComplete();     // Catch: Throwable -> L6
            dispose();
            return;
        L6:
            th = move-exception;
            dispose();
            throw th;
        }

        @Override // io.reactivex.f
        public void onError(Throwable r1) {
            if (tryOnError(r1) == true) goto L6;
            io.reactivex.d.a.a(r1);
            return;
        }

        @Override // io.reactivex.f
        public void onNext(T r2) {
            if (r2 != null) goto L6;
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        L6:
            if (isDisposed() == true) goto L9;
            this.observer.onNext(r2);
            return;
        }

        public q<T> serialize() {
            return new SerializedEmitter(this);
        }

        @Override // io.reactivex.q
        public void setCancellable(f r3) {
            setDisposable(new CancellableDisposable((f) ZeusTransformUtils.wrapperContextForParams(r3, f.class, "com.obric.memorydata.plugin")));
        }

        @Override // io.reactivex.q
        public void setDisposable(io.reactivex.disposables.b r3) {
            DisposableHelper.set(this, (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin"));
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public String toString() {
            return String.format("%s{%s}", new Object[]{getClass().getSimpleName(), super.toString()});
        }

        public boolean tryOnError(Throwable r2) {
            if (r2 != null) goto L5;
            r2 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        L5:
            if (isDisposed() == false) goto L14;
            return false;
        L14:
            this.observer.onError(r2);     // Catch: Throwable -> L9
            dispose();
            return true;
        L9:
            th = move-exception;
            dispose();
            throw th;
        }
    }

    static final class SerializedEmitter<T> extends AtomicInteger implements q<T> {
        private static final long serialVersionUID = 4883307006032401862L;
        volatile boolean done;
        final q<T> emitter;
        final AtomicThrowable error;
        final io.reactivex.internal.queue.a<T> queue;

        SerializedEmitter(q<T> r3) {
            this.emitter = (q) ZeusTransformUtils.wrapperContextForParams(r3, q.class, "com.obric.memorydata.plugin");
            this.error = new AtomicThrowable();
            this.queue = new io.reactivex.internal.queue.a(16);
        }

        void drain() {
            if (getAndIncrement() != 0) goto L6;
            drainLoop();
            return;
        }

        void drainLoop() {
            q<T> r0 = this.emitter;
            io.reactivex.internal.queue.a<T> r1 = this.queue;
            AtomicThrowable r2 = this.error;
            int r4 = 1;
        L4:
            if (r0.isDisposed() == true) goto L5;
            if (r2.get() != null) goto L9;
            boolean r5 = this.done;
            T r6 = r1.poll();
            if (r6 != null) goto L14;
            boolean r7 = true;
        L15:
            if (r5 == false) goto L19;
            if (r7 == false) goto L19;
            r0.onComplete();
            return;
        L19:
            if (r7 == true) goto L20;
            r0.onNext(r6);
            goto L4
        L20:
            r4 = addAndGet(-r4);
            if (r4 != 0) goto L4;
            return;
        L14:
            r7 = false;
            goto L15
        L9:
            r1.clear();
            r0.onError(r2.terminate());
            return;
        L5:
            r1.clear();
        }

        @Override // io.reactivex.q
        public boolean isDisposed() {
            return this.emitter.isDisposed();
        }

        @Override // io.reactivex.f
        public void onComplete() {
            if (this.emitter.isDisposed() == false) goto L5;
            return;
        L5:
            if (this.done == true) goto L10;
            this.done = true;
            drain();
            return;
        }

        @Override // io.reactivex.f
        public void onError(Throwable r1) {
            if (tryOnError(r1) == true) goto L6;
            io.reactivex.d.a.a(r1);
            return;
        }

        @Override // io.reactivex.f
        public void onNext(T r3) {
            if (this.emitter.isDisposed() == false) goto L5;
            return;
        L5:
            if (this.done == true) goto L32;
            if (r3 != null) goto L11;
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        L11:
            if (get() == 0) goto L13;
        L17:
            io.reactivex.internal.queue.a<T> r0 = this.queue;
            monitor-enter(r0);
            r0.offer(r3);     // Catch: Throwable -> L26
            monitor-exit(r0);     // Catch: Throwable -> L26
            if (getAndIncrement() == 0) goto L24;
            return;
        L24:
            drainLoop();
            return;
        L26:
            th = move-exception;
            throw th;
        L13:
            if (compareAndSet(0, 1) == false) goto L17;
            this.emitter.onNext(r3);
            if (decrementAndGet() != 0) goto L24;
            return;
        }

        public q<T> serialize() {
            return this;
        }

        @Override // io.reactivex.q
        public void setCancellable(f r3) {
            f r4 = (f) ZeusTransformUtils.wrapperContextForParams(r3, f.class, "com.obric.memorydata.plugin");
            this.emitter.setCancellable(r4);
        }

        @Override // io.reactivex.q
        public void setDisposable(io.reactivex.disposables.b r3) {
            io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
            this.emitter.setDisposable(r4);
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public String toString() {
            return this.emitter.toString();
        }

        public boolean tryOnError(Throwable r3) {
            if (this.emitter.isDisposed() == false) goto L5;
        L13:
            return false;
        L5:
            if (this.done == true) goto L13;
            if (r3 != null) goto L10;
            r3 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        L10:
            if (this.error.addThrowable(r3) == false) goto L13;
            this.done = true;
            drain();
            return true;
        }
    }

    @Override // io.reactivex.Observable
    public void a(t<? super T> r3) {
        t r4 = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
        CreateEmitter r0 = new CreateEmitter(r4);
        r4.onSubscribe(r0);
        this.f16938a.a(r0);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        r0.onError(th);
    }
}
