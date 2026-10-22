package io.reactivex.internal.operators.flowable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.a.f;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.v;
import io.reactivex.x;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes6.dex */
public final class FlowableSequenceEqualSingle<T> extends v<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final org.a.b<? extends T> f16793a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final org.a.b<? extends T> f16794b;
    final io.reactivex.b.d<? super T, ? super T> c;
    final int d;

    static final class EqualCoordinator<T> extends AtomicInteger implements io.reactivex.disposables.b, FlowableSequenceEqual.a {
        private static final long serialVersionUID = -6178010334400373240L;
        final io.reactivex.b.d<? super T, ? super T> comparer;
        final x<? super Boolean> downstream;
        final AtomicThrowable error;
        final FlowableSequenceEqual.EqualSubscriber<T> first;
        final FlowableSequenceEqual.EqualSubscriber<T> second;
        T v1;
        T v2;

        EqualCoordinator(x<? super Boolean> r3, int r4, io.reactivex.b.d<? super T, ? super T> r5) {
            x<? super Boolean> r6 = (x) ZeusTransformUtils.wrapperContextForParams(r3, x.class, "com.obric.memorydata.plugin");
            io.reactivex.b.d<? super T, ? super T> r7 = (io.reactivex.b.d) ZeusTransformUtils.wrapperContextForParams(r5, io.reactivex.b.d.class, "com.obric.memorydata.plugin");
            this.downstream = r6;
            this.comparer = r7;
            this.first = new FlowableSequenceEqual.EqualSubscriber(this, r4);
            this.second = new FlowableSequenceEqual.EqualSubscriber(this, r4);
            this.error = new AtomicThrowable();
        }

        void cancelAndClear() {
            this.first.cancel();
            this.first.clear();
            this.second.cancel();
            this.second.clear();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.first.cancel();
            this.second.cancel();
            if (getAndIncrement() != 0) goto L6;
            this.first.clear();
            this.second.clear();
            return;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSequenceEqual.a
        public void drain() {
            if (getAndIncrement() == 0) goto L5;
            return;
        L5:
            int r1 = 1;
        L6:
            f<T> r2 = this.first.queue;
            f<T> r3 = this.second.queue;
            if (r2 == null) goto L61;
            if (r3 == null) goto L61;
        L10:
            if (isDisposed() == true) goto L11;
            if (((Throwable) ZeusTransformUtils.preCheckCast(this.error.get(), Throwable.class, "com.obric.memorydata.plugin")) != null) goto L15;
            boolean r5 = this.first.done;
            T r6 = this.v1;
            if (r6 != null) goto L25;
            r6 = r2.poll();     // Catch: Throwable -> L21
            this.v1 = r6;
        L21:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            cancelAndClear();
            this.error.addThrowable(th);
            this.downstream.onError(this.error.terminate());
            return;
        L25:
            if (r6 != null) goto L27;
            boolean r8 = true;
        L28:
            boolean r9 = this.second.done;
            T r10 = this.v2;
            if (r10 == null) goto L73;
        L35:
            if (r10 != null) goto L37;
            boolean r11 = true;
        L38:
            if (r5 == false) goto L44;
            if (r9 == false) goto L44;
            if (r8 == false) goto L44;
            if (r11 == false) goto L44;
            this.downstream.onSuccess(true);
            return;
        L44:
            if (r5 == false) goto L49;
            if (r9 == false) goto L49;
            if (r8 == r11) goto L49;
            cancelAndClear();
            this.downstream.onSuccess(false);
            return;
        L49:
            if (r8 == true) goto L68;
            if (r11 == true) goto L68;
            if (this.comparer.a(r6, r10) == false) goto L54;
            this.v1 = null;
            this.v2 = null;
            this.first.request();
            this.second.request();
            goto L10
        L54:
            cancelAndClear();
            this.downstream.onSuccess(false);
            return;
        L57:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            cancelAndClear();
            this.error.addThrowable(th);
            this.downstream.onError(this.error.terminate());
            return;
        L68:
            r1 = addAndGet(-r1);
            if (r1 != 0) goto L6;
            return;
        L37:
            r11 = false;
            goto L38
        L73:
            r10 = r3.poll();     // Catch: Throwable -> L32
            this.v2 = r10;
        L32:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            cancelAndClear();
            this.error.addThrowable(th);
            this.downstream.onError(this.error.terminate());
            return;
        L27:
            r8 = false;
            goto L28
        L15:
            cancelAndClear();
            this.downstream.onError(this.error.terminate());
            return;
        L11:
            this.first.clear();
            this.second.clear();
            return;
        L61:
            if (isDisposed() == true) goto L62;
            if (((Throwable) ZeusTransformUtils.preCheckCast(this.error.get(), Throwable.class, "com.obric.memorydata.plugin")) == null) goto L68;
            cancelAndClear();
            this.downstream.onError(this.error.terminate());
            return;
        L62:
            this.first.clear();
            this.second.clear();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSequenceEqual.a
        public void innerError(Throwable r2) {
            if (this.error.addThrowable(r2) == false) goto L5;
            drain();
            return;
        L5:
            io.reactivex.d.a.a(r2);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            if (this.first.get() != SubscriptionHelper.CANCELLED) goto L5;
            return true;
        L5:
            return false;
        }

        void subscribe(org.a.b<? extends T> r3, org.a.b<? extends T> r4) {
            org.a.b r5 = (org.a.b) ZeusTransformUtils.wrapperContextForParams(r3, org.a.b.class, "com.obric.memorydata.plugin");
            org.a.b r6 = (org.a.b) ZeusTransformUtils.wrapperContextForParams(r4, org.a.b.class, "com.obric.memorydata.plugin");
            r5.subscribe(this.first);
            r6.subscribe(this.second);
        }
    }

    @Override // io.reactivex.v
    public void b(x<? super Boolean> r4) {
        x r5 = (x) ZeusTransformUtils.wrapperContextForParams(r4, x.class, "com.obric.memorydata.plugin");
        EqualCoordinator r0 = new EqualCoordinator(r5, this.d, this.c);
        r5.onSubscribe(r0);
        r0.subscribe(this.f16793a, this.f16794b);
    }
}
