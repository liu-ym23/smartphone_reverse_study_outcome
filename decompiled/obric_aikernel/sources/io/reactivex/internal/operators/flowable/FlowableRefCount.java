package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class FlowableRefCount<T> extends xb.e<T> {

    static final class RefConnection extends AtomicReference<io.reactivex.disposables.b> implements Runnable, zb.g<io.reactivex.disposables.b> {
        private static final long serialVersionUID = -4552101107598366241L;
        boolean connected;
        boolean disconnectedEarly;
        final FlowableRefCount<?> parent;
        long subscriberCount;
        io.reactivex.disposables.b timer;

        RefConnection(FlowableRefCount<?> r10) {
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

    static final class RefCountSubscriber<T> extends AtomicBoolean implements xb.g<T>, tc.d {
        private static final long serialVersionUID = -7419642935409022375L;
        final RefConnection connection;
        final tc.c<? super T> downstream;
        final FlowableRefCount<T> parent;
        tc.d upstream;

        RefCountSubscriber(tc.c<? super T> r10, FlowableRefCount<T> r11, RefConnection r12) {
            this.downstream = r10;
            this.connection = r12;
        }

        @Override // tc.d
        public void cancel() {
            this.upstream.cancel();
            if (compareAndSet(false, true) == true) goto L6;
            return;
        L6:
            throw null;
        }

        @Override // tc.c
        public void onComplete() {
            if (compareAndSet(false, true) == true) goto L6;
            return;
        L6:
            throw null;
        }

        @Override // tc.c
        public void onError(Throwable r10) {
            if (compareAndSet(false, true) == true) goto L7;
            dc.a.n(r10);
            return;
        L7:
            throw null;
        }

        @Override // tc.c
        public void onNext(T r10) {
            this.downstream.onNext(r10);
        }

        @Override // xb.g, tc.c
        public void onSubscribe(tc.d r10) {
            if (SubscriptionHelper.validate(this.upstream, r10) == false) goto L6;
            this.upstream = r10;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // tc.d
        public void request(long r10) {
            this.upstream.request(r10);
        }
    }
}
