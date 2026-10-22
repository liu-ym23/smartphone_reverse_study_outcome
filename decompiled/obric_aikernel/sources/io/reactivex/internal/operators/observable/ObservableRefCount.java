package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class ObservableRefCount<T> extends Observable<T> {

    static final class RefConnection extends AtomicReference<io.reactivex.disposables.b> implements Runnable, zb.g<io.reactivex.disposables.b> {
        private static final long serialVersionUID = -4552101107598366241L;
        boolean connected;
        boolean disconnectedEarly;
        final ObservableRefCount<?> parent;
        long subscriberCount;
        io.reactivex.disposables.b timer;

        RefConnection(ObservableRefCount<?> r10) {
        }

        /* JADX INFO: renamed from: accept, reason: avoid collision after fix types in other method */
        public void accept2(io.reactivex.disposables.b r10) {
            DisposableHelper.replace(this, r10);
            throw null;
        }

        @Override // zb.g
        public /* bridge */ /* synthetic */ void accept(io.reactivex.disposables.b r10) {
            accept2(r10);
        }

        @Override // java.lang.Runnable
        public void run() {
            throw null;
        }
    }

    static final class RefCountObserver<T> extends AtomicBoolean implements xb.o<T>, io.reactivex.disposables.b {
        private static final long serialVersionUID = -7419642935409022375L;
        final RefConnection connection;
        final xb.o<? super T> downstream;
        final ObservableRefCount<T> parent;
        io.reactivex.disposables.b upstream;

        RefCountObserver(xb.o<? super T> r10, ObservableRefCount<T> r11, RefConnection r12) {
            this.downstream = r10;
            this.connection = r12;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.upstream.dispose();
            if (compareAndSet(false, true) == true) goto L6;
            return;
        L6:
            throw null;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // xb.o
        public void onComplete() {
            if (compareAndSet(false, true) == true) goto L6;
            return;
        L6:
            throw null;
        }

        @Override // xb.o
        public void onError(Throwable r10) {
            if (compareAndSet(false, true) == true) goto L7;
            dc.a.n(r10);
            return;
        L7:
            throw null;
        }

        @Override // xb.o
        public void onNext(T r10) {
            this.downstream.onNext(r10);
        }

        @Override // xb.o
        public void onSubscribe(io.reactivex.disposables.b r10) {
            if (DisposableHelper.validate(this.upstream, r10) == false) goto L6;
            this.upstream = r10;
            this.downstream.onSubscribe(this);
            return;
        }
    }
}
