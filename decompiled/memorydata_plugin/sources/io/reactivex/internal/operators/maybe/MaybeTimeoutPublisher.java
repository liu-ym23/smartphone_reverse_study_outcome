package io.reactivex.internal.operators.maybe;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import io.reactivex.m;
import io.reactivex.o;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import org.a.d;

/* JADX INFO: loaded from: classes6.dex */
public final class MaybeTimeoutPublisher<T, U> extends a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final org.a.b<U> f16871b;
    final o<? extends T> c;

    static final class TimeoutFallbackMaybeObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements m<T> {
        private static final long serialVersionUID = 8663801314800248617L;
        final m<? super T> downstream;

        TimeoutFallbackMaybeObserver(m<? super T> r3) {
            this.downstream = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.memorydata.plugin");
        }

        @Override // io.reactivex.m
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.m
        public void onError(Throwable r1) {
            this.downstream.onError(r1);
        }

        @Override // io.reactivex.m
        public void onSubscribe(io.reactivex.disposables.b r3) {
            DisposableHelper.setOnce(this, (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin"));
        }

        @Override // io.reactivex.m
        public void onSuccess(T r1) {
            this.downstream.onSuccess(r1);
        }
    }

    static final class TimeoutMainMaybeObserver<T, U> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, m<T> {
        private static final long serialVersionUID = -5955289211445418871L;
        final m<? super T> downstream;
        final o<? extends T> fallback;
        final TimeoutOtherMaybeObserver<T, U> other;
        final TimeoutFallbackMaybeObserver<T> otherObserver;

        TimeoutMainMaybeObserver(m<? super T> r3, o<? extends T> r4) {
            m<? super T> r5 = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.memorydata.plugin");
            o<? extends T> r6 = (o) ZeusTransformUtils.wrapperContextForParams(r4, o.class, "com.obric.memorydata.plugin");
            this.downstream = r5;
            this.other = new TimeoutOtherMaybeObserver(this);
            this.fallback = r6;
            if (r6 == null) goto L5;
            TimeoutFallbackMaybeObserver<T> r7 = new TimeoutFallbackMaybeObserver(r5);
        L6:
            this.otherObserver = r7;
            return;
        L5:
            r7 = null;
            goto L6
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
            SubscriptionHelper.cancel(this.other);
            TimeoutFallbackMaybeObserver<T> r1 = this.otherObserver;
            if (r1 == null) goto L6;
            DisposableHelper.dispose(r1);
            return;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed((io.reactivex.disposables.b) ZeusTransformUtils.preCheckCast(get(), io.reactivex.disposables.b.class, "com.obric.memorydata.plugin"));
        }

        @Override // io.reactivex.m
        public void onComplete() {
            SubscriptionHelper.cancel(this.other);
            if (getAndSet(DisposableHelper.DISPOSED) == DisposableHelper.DISPOSED) goto L6;
            this.downstream.onComplete();
            return;
        }

        @Override // io.reactivex.m
        public void onError(Throwable r3) {
            SubscriptionHelper.cancel(this.other);
            if (getAndSet(DisposableHelper.DISPOSED) == DisposableHelper.DISPOSED) goto L5;
            this.downstream.onError(r3);
            return;
        L5:
            io.reactivex.d.a.a(r3);
        }

        @Override // io.reactivex.m
        public void onSubscribe(io.reactivex.disposables.b r3) {
            DisposableHelper.setOnce(this, (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin"));
        }

        @Override // io.reactivex.m
        public void onSuccess(T r3) {
            SubscriptionHelper.cancel(this.other);
            if (getAndSet(DisposableHelper.DISPOSED) == DisposableHelper.DISPOSED) goto L6;
            this.downstream.onSuccess(r3);
            return;
        }

        public void otherComplete() {
            if (DisposableHelper.dispose(this) == false) goto L9;
            o<? extends T> r0 = this.fallback;
            if (r0 != null) goto L7;
            this.downstream.onError(new TimeoutException());
            return;
        L7:
            r0.a(this.otherObserver);
            return;
        }

        public void otherError(Throwable r2) {
            if (DisposableHelper.dispose(this) == false) goto L5;
            this.downstream.onError(r2);
            return;
        L5:
            io.reactivex.d.a.a(r2);
        }
    }

    static final class TimeoutOtherMaybeObserver<T, U> extends AtomicReference<d> implements j<Object> {
        private static final long serialVersionUID = 8663801314800248617L;
        final TimeoutMainMaybeObserver<T, U> parent;

        TimeoutOtherMaybeObserver(TimeoutMainMaybeObserver<T, U> r1) {
            this.parent = r1;
        }

        @Override // org.a.c
        public void onComplete() {
            this.parent.otherComplete();
        }

        @Override // org.a.c
        public void onError(Throwable r1) {
            this.parent.otherError(r1);
        }

        @Override // org.a.c
        public void onNext(Object r3) {
            ((d) ZeusTransformUtils.preCheckCast(get(), d.class, "com.obric.memorydata.plugin")).cancel();
            this.parent.otherComplete();
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(d r3) {
            SubscriptionHelper.setOnce(this, (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin"), Long.MAX_VALUE);
        }
    }

    @Override // io.reactivex.k
    public void b(m<? super T> r3) {
        m r4 = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.memorydata.plugin");
        TimeoutMainMaybeObserver r0 = new TimeoutMainMaybeObserver(r4, this.c);
        r4.onSubscribe(r0);
        this.f16871b.subscribe(r0.other);
        this.f16882a.a(r0);
    }
}
