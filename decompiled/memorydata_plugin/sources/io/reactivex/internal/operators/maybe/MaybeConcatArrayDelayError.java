package io.reactivex.internal.operators.maybe;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.g;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.m;
import io.reactivex.o;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.a.c;
import org.a.d;

/* JADX INFO: loaded from: classes6.dex */
public final class MaybeConcatArrayDelayError<T> extends g<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final o<? extends T>[] f16818b;

    static final class ConcatMaybeObserver<T> extends AtomicInteger implements m<T>, d {
        private static final long serialVersionUID = 3520831347801429610L;
        final AtomicReference<Object> current;
        final SequentialDisposable disposables;
        final c<? super T> downstream;
        final AtomicThrowable errors;
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
            this.errors = new AtomicThrowable();
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
            if (r3 == null) goto L31;
            boolean r6 = true;
            if (r3 == NotificationLite.COMPLETE) goto L18;
            long r7 = this.produced;
            if (r7 == this.requested.get()) goto L17;
            this.produced = r7 + 1;
            r0.lazySet(null);
            r1.onNext(r3);
        L19:
            if (r6 == false) goto L31;
            if (r2.isDisposed() == true) goto L31;
            int r4 = this.index;
            o<? extends T>[] r5 = this.sources;
            if (r4 == r5.length) goto L25;
            this.index = r4 + 1;
            r5[r4].a(this);
            goto L31
        L25:
            if (((Throwable) ZeusTransformUtils.preCheckCast(this.errors.get(), Throwable.class, "com.obric.memorydata.plugin")) == null) goto L27;
            r1.onError(this.errors.terminate());
            return;
        L27:
            r1.onComplete();
            return;
        L17:
            r6 = false;
            goto L19
        L18:
            r0.lazySet(null);
        L31:
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
        public void onError(Throwable r3) {
            this.current.lazySet(NotificationLite.COMPLETE);
            if (this.errors.addThrowable(r3) == false) goto L5;
            drain();
            return;
        L5:
            io.reactivex.d.a.a(r3);
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
        ConcatMaybeObserver r0 = new ConcatMaybeObserver(r4, this.f16818b);
        r4.onSubscribe(r0);
        r0.drain();
    }
}
