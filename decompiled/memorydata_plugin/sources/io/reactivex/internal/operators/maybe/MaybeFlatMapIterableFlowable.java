package io.reactivex.internal.operators.maybe;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.b.h;
import io.reactivex.g;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.m;
import io.reactivex.o;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import org.a.c;

/* JADX INFO: loaded from: classes6.dex */
public final class MaybeFlatMapIterableFlowable<T, R> extends g<R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final o<T> f16840b;
    final h<? super T, ? extends Iterable<? extends R>> c;

    static final class FlatMapIterableObserver<T, R> extends BasicIntQueueSubscription<R> implements m<T> {
        private static final long serialVersionUID = -8938804753851907758L;
        volatile boolean cancelled;
        final c<? super R> downstream;
        volatile Iterator<? extends R> it;
        final h<? super T, ? extends Iterable<? extends R>> mapper;
        boolean outputFused;
        final AtomicLong requested;
        io.reactivex.disposables.b upstream;

        FlatMapIterableObserver(c<? super R> r3, h<? super T, ? extends Iterable<? extends R>> r4) {
            c<? super R> r5 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
            h<? super T, ? extends Iterable<? extends R>> r6 = (h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.memorydata.plugin");
            this.downstream = r5;
            this.mapper = r6;
            this.requested = new AtomicLong();
        }

        @Override // org.a.d
        public void cancel() {
            this.cancelled = true;
            this.upstream.dispose();
            this.upstream = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.internal.a.f
        public void clear() {
            this.it = null;
        }

        void drain() {
            if (getAndIncrement() == 0) goto L5;
            return;
        L5:
            c<? super R> r0 = this.downstream;
            Iterator<? extends R> r1 = this.it;
            if (this.outputFused == false) goto L10;
            if (r1 == null) goto L10;
            r0.onNext(null);
            r0.onComplete();
            return;
        L10:
            int r2 = 1;
        L11:
            if (r1 == null) goto L40;
            long r3 = this.requested.get();
            if (r3 == Long.MAX_VALUE) goto L14;
            long r7 = 0;
        L18:
            if (r7 == r3) goto L38;
            if (this.cancelled == true) goto L21;
            r0.onNext((Object) io.reactivex.internal.functions.a.a(r1.next(), "The iterator returned a null value"));
            if (this.cancelled == true) goto L25;
            r7 = r7 + 1;
            if (r1.hasNext() == true) goto L18;
            r0.onComplete();
            return;
        L31:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            r0.onError(th);
            return;
        L25:
            return;
        L34:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            r0.onError(th);
            return;
        L21:
            return;
        L38:
            if (r7 == 0) goto L40;
            io.reactivex.internal.util.b.c(this.requested, r7);
            goto L40
        L14:
            fastPath(r0, r1);
            return;
        L40:
            r2 = addAndGet(-r2);
            if (r2 == 0) goto L42;
            if (r1 != null) goto L11;
            r1 = this.it;
            goto L11
        }

        /* JADX WARN: Multi-variable type inference failed */
        void fastPath(c<? super R> r3, Iterator<? extends R> r4) {
            c r5 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
            Iterator r6 = (Iterator) ZeusTransformUtils.wrapperContextForParams(r4, Iterator.class, "com.obric.memorydata.plugin");
        L4:
            if (this.cancelled == true) goto L5;
        L14:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            r5.onError(th);
            return;
        L7:
            r5.onNext(r6.next());
            if (this.cancelled == true) goto L9;
            if (r6.hasNext() == true) goto L4;
            r5.onComplete();
            return;
        L9:
            return;
        }

        @Override // io.reactivex.internal.a.f
        public boolean isEmpty() {
            if (this.it != null) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // io.reactivex.m
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.m
        public void onError(Throwable r2) {
            this.upstream = DisposableHelper.DISPOSED;
            this.downstream.onError(r2);
        }

        @Override // io.reactivex.m
        public void onSubscribe(io.reactivex.disposables.b r3) {
            io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
            if (DisposableHelper.validate(this.upstream, r4) == false) goto L6;
            this.upstream = r4;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.m
        public void onSuccess(T r3) {
            Iterator<? extends R> r4 = ((Iterable) ZeusTransformUtils.preCheckCast(this.mapper.apply(r3), Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L8
            if (r4.hasNext() == true) goto L6;
            this.downstream.onComplete();
            return;
        L6:
            this.it = r4;
            drain();
            return;
        L8:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            this.downstream.onError(th);
        }

        @Override // io.reactivex.internal.a.f
        public R poll() {
            Iterator<? extends R> r0 = this.it;
            if (r0 == null) goto L8;
            R r2 = (R) io.reactivex.internal.functions.a.a(r0.next(), "The iterator returned a null value");
            if (r0.hasNext() == true) goto L7;
            this.it = null;
        L7:
            return r2;
        L8:
            return null;
        }

        @Override // org.a.d
        public void request(long r2) {
            if (SubscriptionHelper.validate(r2) == false) goto L6;
            io.reactivex.internal.util.b.a(this.requested, r2);
            drain();
            return;
        }

        @Override // io.reactivex.internal.a.c
        public int requestFusion(int r2) {
            if ((r2 & 2) == 0) goto L6;
            this.outputFused = true;
            return 2;
        L6:
            return 0;
        }
    }

    @Override // io.reactivex.g
    public void a(c<? super R> r3) {
        c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
        this.f16840b.a(new FlatMapIterableObserver(r4, this.c));
    }
}
