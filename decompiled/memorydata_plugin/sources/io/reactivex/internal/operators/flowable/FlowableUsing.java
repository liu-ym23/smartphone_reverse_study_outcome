package io.reactivex.internal.operators.flowable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.b.h;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.g;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes6.dex */
public final class FlowableUsing<T, D> extends g<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Callable<? extends D> f16803b;
    final h<? super D, ? extends org.a.b<? extends T>> c;
    final io.reactivex.b.g<? super D> d;
    final boolean e;

    static final class UsingSubscriber<T, D> extends AtomicBoolean implements j<T>, org.a.d {
        private static final long serialVersionUID = 5904473792286235046L;
        final io.reactivex.b.g<? super D> disposer;
        final org.a.c<? super T> downstream;
        final boolean eager;
        final D resource;
        org.a.d upstream;

        UsingSubscriber(org.a.c<? super T> r3, D r4, io.reactivex.b.g<? super D> r5, boolean r6) {
            org.a.c<? super T> r7 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
            io.reactivex.b.g<? super D> r8 = (io.reactivex.b.g) ZeusTransformUtils.wrapperContextForParams(r5, io.reactivex.b.g.class, "com.obric.memorydata.plugin");
            this.downstream = r7;
            this.resource = r4;
            this.disposer = r8;
            this.eager = r6;
        }

        @Override // org.a.d
        public void cancel() {
            disposeAfter();
            this.upstream.cancel();
        }

        void disposeAfter() {
            if (compareAndSet(false, true) == false) goto L11;
            this.disposer.accept(this.resource);     // Catch: Throwable -> L6
            return;
        L6:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            io.reactivex.d.a.a(th);
            return;
        }

        @Override // org.a.c
        public void onComplete() {
            if (this.eager == true) goto L5;
            this.downstream.onComplete();
            this.upstream.cancel();
            disposeAfter();
            return;
        L5:
            if (compareAndSet(false, true) == true) goto L14;
        L11:
            this.upstream.cancel();
            this.downstream.onComplete();
            return;
        L14:
            this.disposer.accept(this.resource);     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            this.downstream.onError(th);
        }

        @Override // org.a.c
        public void onError(Throwable r6) {
            if (this.eager == false) goto L14;
            Throwable th = null;
            if (compareAndSet(false, true) == true) goto L16;
        L10:
            this.upstream.cancel();
            org.a.c<? super T> r5 = this.downstream;
            if (th == null) goto L13;
            r5.onError(new CompositeException(new Throwable[]{r6, th}));
            return;
        L13:
            r5.onError(r6);
            return;
        L16:
            this.disposer.accept(this.resource);     // Catch: Throwable -> L8
        L8:
            th = th;
            io.reactivex.exceptions.a.a(th);
            goto L10
        L14:
            this.downstream.onError(r6);
            this.upstream.cancel();
            disposeAfter();
        }

        @Override // org.a.c
        public void onNext(T r1) {
            this.downstream.onNext(r1);
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d r3) {
            org.a.d r4 = (org.a.d) ZeusTransformUtils.wrapperContextForParams(r3, org.a.d.class, "com.obric.memorydata.plugin");
            if (SubscriptionHelper.validate(this.upstream, r4) == false) goto L6;
            this.upstream = r4;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // org.a.d
        public void request(long r1) {
            this.upstream.request(r1);
        }
    }

    @Override // io.reactivex.g
    public void a(org.a.c<? super T> r5) {
        org.a.c r6 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r5, org.a.c.class, "com.obric.memorydata.plugin");
        D r0 = this.f16803b.call();     // Catch: Throwable -> L15
        ((org.a.b) ZeusTransformUtils.preCheckCast(io.reactivex.internal.functions.a.a(this.c.apply(r0), "The sourceSupplier returned a null Publisher"), org.a.b.class, "com.obric.memorydata.plugin")).subscribe(new UsingSubscriber(r6, r0, this.d, this.e));
        return;
    L7:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.d.accept(r0);     // Catch: Throwable -> L12
        EmptySubscription.error(th, r6);
        return;
    L12:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        EmptySubscription.error(new CompositeException(new Throwable[]{th, th}), r6);
        return;
    L15:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        EmptySubscription.error(th, r6);
    }
}
