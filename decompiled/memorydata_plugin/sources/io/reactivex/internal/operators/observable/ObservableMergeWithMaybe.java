package io.reactivex.internal.operators.observable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import defpackage.$$Lambda$g$NFitCGeARaziAziawMJBYS968oA;
import io.reactivex.Observable;
import io.reactivex.internal.a.e;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.m;
import io.reactivex.o;
import io.reactivex.t;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class ObservableMergeWithMaybe<T> extends a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final o<? extends T> f16958b;

    static final class MergeWithObserver<T> extends AtomicInteger implements io.reactivex.disposables.b, t<T> {
        static final int OTHER_STATE_CONSUMED_OR_EMPTY = 2;
        static final int OTHER_STATE_HAS_VALUE = 1;
        private static final long serialVersionUID = -4592979584110982903L;
        volatile boolean disposed;
        final t<? super T> downstream;
        final AtomicThrowable error;
        final AtomicReference<io.reactivex.disposables.b> mainDisposable;
        volatile boolean mainDone;
        final OtherObserver<T> otherObserver;
        volatile int otherState;
        volatile e<T> queue;
        T singleItem;

        static final class OtherObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements m<T> {
            private static final long serialVersionUID = -2935427570954647017L;
            final MergeWithObserver<T> parent;

            OtherObserver(MergeWithObserver<T> r1) {
                this.parent = r1;
            }

            @Override // io.reactivex.m
            public void onComplete() {
                this.parent.otherComplete();
            }

            @Override // io.reactivex.m
            public void onError(Throwable r1) {
                this.parent.otherError(r1);
            }

            @Override // io.reactivex.m
            public void onSubscribe(io.reactivex.disposables.b r3) {
                DisposableHelper.setOnce(this, (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin"));
            }

            @Override // io.reactivex.m
            public void onSuccess(T r1) {
                this.parent.otherSuccess(r1);
            }
        }

        MergeWithObserver(t<? super T> r3) {
            this.downstream = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
            this.mainDisposable = new AtomicReference();
            this.otherObserver = new OtherObserver(this);
            this.error = new AtomicThrowable();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.disposed = true;
            DisposableHelper.dispose(this.mainDisposable);
            DisposableHelper.dispose(this.otherObserver);
            if (getAndIncrement() != 0) goto L6;
            this.queue = null;
            this.singleItem = null;
            return;
        }

        void drain() {
            if (getAndIncrement() != 0) goto L6;
            drainLoop();
            return;
        }

        void drainLoop() {
            t<? super T> r0 = this.downstream;
            int r2 = 1;
        L4:
            if (this.disposed == true) goto L5;
            if (this.error.get() != null) goto L9;
            int r3 = this.otherState;
            if (r3 != 1) goto L14;
            T r4 = this.singleItem;
            this.singleItem = null;
            this.otherState = 2;
            r0.onNext(r4);
            r3 = 2;
        L14:
            boolean r6 = this.mainDone;
            e<T> r7 = this.queue;
            if (r7 == null) goto L17;
            $$Lambda$g$NFitCGeARaziAziawMJBYS968oA r8 = r7.poll();
        L18:
            if (r8 != null) goto L20;
            boolean r9 = true;
        L21:
            if (r6 == false) goto L26;
            if (r9 == false) goto L26;
            if (r3 != 2) goto L26;
            this.queue = null;
            r0.onComplete();
            return;
        L26:
            if (r9 == true) goto L27;
            r0.onNext(r8);
            goto L4
        L27:
            r2 = addAndGet(-r2);
            if (r2 != 0) goto L4;
            return;
        L20:
            r9 = false;
            goto L21
        L17:
            r8 = null;
            goto L18
        L9:
            this.singleItem = null;
            this.queue = null;
            r0.onError(this.error.terminate());
            return;
        L5:
            this.singleItem = null;
            this.queue = null;
        }

        e<T> getOrCreateQueue() {
            e<T> r0 = this.queue;
            if (r0 != null) goto L6;
            io.reactivex.internal.queue.a r1 = new io.reactivex.internal.queue.a(Observable.a());
            this.queue = r1;
            return r1;
        L6:
            return r0;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed((io.reactivex.disposables.b) ZeusTransformUtils.preCheckCast(this.mainDisposable.get(), io.reactivex.disposables.b.class, "com.obric.memorydata.plugin"));
        }

        @Override // io.reactivex.t
        public void onComplete() {
            this.mainDone = true;
            drain();
        }

        @Override // io.reactivex.t
        public void onError(Throwable r2) {
            if (this.error.addThrowable(r2) == false) goto L5;
            DisposableHelper.dispose(this.otherObserver);
            drain();
            return;
        L5:
            io.reactivex.d.a.a(r2);
        }

        @Override // io.reactivex.t
        public void onNext(T r3) {
            if (compareAndSet(0, 1) == false) goto L7;
            this.downstream.onNext(r3);
            if (decrementAndGet() != 0) goto L10;
            return;
        L10:
            drainLoop();
            return;
        L7:
            getOrCreateQueue().offer(r3);
            if (getAndIncrement() == 0) goto L10;
        }

        @Override // io.reactivex.t
        public void onSubscribe(io.reactivex.disposables.b r3) {
            io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
            DisposableHelper.setOnce(this.mainDisposable, r4);
        }

        void otherComplete() {
            this.otherState = 2;
            drain();
        }

        void otherError(Throwable r2) {
            if (this.error.addThrowable(r2) == false) goto L5;
            DisposableHelper.dispose(this.mainDisposable);
            drain();
            return;
        L5:
            io.reactivex.d.a.a(r2);
        }

        void otherSuccess(T r3) {
            if (compareAndSet(0, 1) == false) goto L5;
            this.downstream.onNext(r3);
            this.otherState = 2;
        L8:
            drainLoop();
            return;
        L5:
            this.singleItem = r3;
            this.otherState = 1;
            if (getAndIncrement() == 0) goto L8;
        }
    }

    @Override // io.reactivex.Observable
    public void a(t<? super T> r3) {
        t r4 = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
        MergeWithObserver r0 = new MergeWithObserver(r4);
        r4.onSubscribe(r0);
        this.f17034a.subscribe(r0);
        this.f16958b.a(r0.otherObserver);
    }
}
