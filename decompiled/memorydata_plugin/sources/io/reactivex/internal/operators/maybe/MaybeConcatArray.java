package io.reactivex.internal.operators.maybe;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.g;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.m;
import io.reactivex.o;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.a.c;
import org.a.d;

/* JADX INFO: loaded from: classes6.dex */
public final class MaybeConcatArray<T> extends g<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final o<? extends T>[] f16817b;

    static final class ConcatMaybeObserver<T> extends AtomicInteger implements m<T>, d {
        private static final long serialVersionUID = 3520831347801429610L;
        final AtomicReference<Object> current;
        final SequentialDisposable disposables;
        final c<? super T> downstream;
        int index;
        long produced;
        final AtomicLong requested;
        final o<? extends T>[] sources;

        ConcatMaybeObserver(c<? super T> r3, o<? extends T>[] r4) {
            this.downstream = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
            this.sources = r4;
            this.requested = new AtomicLong();
            this.disposables = new SequentialDisposable();
            this.current = new AtomicReference(NotificationLite.COMPLETE);
        }

        @Override // org.a.d
        public void cancel() {
            this.disposables.dispose();
        }

        void drain() {
            if (getAndIncrement() == 0) goto L5;
            return;
        L5:
            AtomicReference<Object> r0 = this.current;
            c<? super T> r1 = this.downstream;
            SequentialDisposable r2 = this.disposables;
        L7:
            if (r2.isDisposed() == true) goto L8;
            Object r3 = r0.get();
            if (r3 == null) goto L28;
            boolean r6 = true;
            if (r3 == NotificationLite.COMPLETE) goto L18;
            long r7 = this.produced;
            if (r7 == this.requested.get()) goto L17;
            this.produced = r7 + 1;
            r0.lazySet(null);
            r1.onNext(r3);
        L19:
            if (r6 == false) goto L28;
            if (r2.isDisposed() == true) goto L28;
            int r4 = this.index;
            o<? extends T>[] r5 = this.sources;
            if (r4 == r5.length) goto L24;
            this.index = r4 + 1;
            r5[r4].a(this);
            goto L28
        L24:
            r1.onComplete();
            return;
        L17:
            r6 = false;
            goto L19
        L18:
            r0.lazySet(null);
        L28:
            if (decrementAndGet() != 0) goto L7;
            return;
        L8:
            r0.lazySet(null);
        }

        @Override // io.reactivex.m
        public void onComplete() {
            this.current.lazySet(NotificationLite.COMPLETE);
            drain();
        }

        @Override // io.reactivex.m
        public void onError(Throwable r1) {
            this.downstream.onError(r1);
        }

        @Override // io.reactivex.m
        public void onSubscribe(io.reactivex.disposables.b r3) {
            io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
            this.disposables.replace(r4);
        }

        @Override // io.reactivex.m
        public void onSuccess(T r2) {
            this.current.lazySet(r2);
            drain();
        }

        @Override // org.a.d
        public void request(long r2) {
            if (SubscriptionHelper.validate(r2) == false) goto L6;
            io.reactivex.internal.util.b.a(this.requested, r2);
            drain();
            return;
        }
    }

    @Override // io.reactivex.g
    public void a(c<? super T> r3) {
        c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
        ConcatMaybeObserver r0 = new ConcatMaybeObserver(r4, this.f16817b);
        r4.onSubscribe(r0);
        r0.drain();
    }
}
