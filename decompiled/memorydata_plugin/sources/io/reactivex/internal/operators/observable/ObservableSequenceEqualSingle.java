package io.reactivex.internal.operators.observable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.b.d;
import io.reactivex.internal.disposables.ArrayCompositeDisposable;
import io.reactivex.s;
import io.reactivex.t;
import io.reactivex.v;
import io.reactivex.x;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes6.dex */
public final class ObservableSequenceEqualSingle<T> extends v<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final s<? extends T> f16991a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final s<? extends T> f16992b;
    final d<? super T, ? super T> c;
    final int d;

    static final class EqualCoordinator<T> extends AtomicInteger implements io.reactivex.disposables.b {
        private static final long serialVersionUID = -6178010334400373240L;
        volatile boolean cancelled;
        final d<? super T, ? super T> comparer;
        final x<? super Boolean> downstream;
        final s<? extends T> first;
        final a<T>[] observers;
        final ArrayCompositeDisposable resources;
        final s<? extends T> second;
        T v1;
        T v2;

        EqualCoordinator(x<? super Boolean> r3, int r4, s<? extends T> r5, s<? extends T> r6, d<? super T, ? super T> r7) {
            x<? super Boolean> r8 = (x) ZeusTransformUtils.wrapperContextForParams(r3, x.class, "com.obric.memorydata.plugin");
            s<? extends T> r9 = (s) ZeusTransformUtils.wrapperContextForParams(r5, s.class, "com.obric.memorydata.plugin");
            s<? extends T> r10 = (s) ZeusTransformUtils.wrapperContextForParams(r6, s.class, "com.obric.memorydata.plugin");
            d<? super T, ? super T> r11 = (d) ZeusTransformUtils.wrapperContextForParams(r7, d.class, "com.obric.memorydata.plugin");
            this.downstream = r8;
            this.first = r9;
            this.second = r10;
            this.comparer = r11;
            this.observers = new a[]{new a(this, 0, r4), new a(this, 1, r4)};
            this.resources = new ArrayCompositeDisposable(2);
        }

        void cancel(io.reactivex.internal.queue.a<T> r2, io.reactivex.internal.queue.a<T> r3) {
            this.cancelled = true;
            r2.clear();
            r3.clear();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.cancelled == true) goto L8;
            this.cancelled = true;
            this.resources.dispose();
            if (getAndIncrement() != 0) goto L9;
            a<T>[] r2 = this.observers;
            r2[0].f16994b.clear();
            r2[1].f16994b.clear();
            return;
        L9:
            return;
        }

        void drain() {
            if (getAndIncrement() == 0) goto L5;
            return;
        L5:
            a<T>[] r0 = this.observers;
            a<T> r2 = r0[0];
            io.reactivex.internal.queue.a<T> r3 = r2.f16994b;
            a<T> r1 = r0[1];
            io.reactivex.internal.queue.a<T> r5 = r1.f16994b;
            int r6 = 1;
        L7:
            if (this.cancelled == true) goto L8;
            boolean r7 = r2.d;
            if (r7 == false) goto L16;
            Throwable r8 = r2.e;
            if (r8 == null) goto L16;
            cancel(r3, r5);
            this.downstream.onError(r8);
            return;
        L16:
            boolean r9 = r1.d;
            if (r9 == false) goto L23;
            Throwable r10 = r1.e;
            if (r10 == null) goto L23;
            cancel(r3, r5);
            this.downstream.onError(r10);
            return;
        L23:
            if (this.v1 != null) goto L26;
            this.v1 = r3.poll();
        L26:
            if (this.v1 != null) goto L28;
            boolean r11 = true;
        L30:
            if (this.v2 != null) goto L32;
            this.v2 = r5.poll();
        L32:
            T r12 = this.v2;
            if (r12 != null) goto L35;
            boolean r13 = true;
        L36:
            if (r7 == false) goto L42;
            if (r9 == false) goto L42;
            if (r11 == false) goto L42;
            if (r13 == false) goto L42;
            this.downstream.onSuccess(true);
            return;
        L42:
            if (r7 == false) goto L47;
            if (r9 == false) goto L47;
            if (r11 == r13) goto L47;
            cancel(r3, r5);
            this.downstream.onSuccess(false);
            return;
        L47:
            if (r11 == true) goto L57;
            if (r13 == true) goto L57;
            if (this.comparer.a(this.v1, r12) == false) goto L51;
            this.v1 = null;
            this.v2 = null;
            goto L57
        L51:
            cancel(r3, r5);
            this.downstream.onSuccess(false);
            return;
        L54:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            cancel(r3, r5);
            this.downstream.onError(th);
            return;
        L57:
            if (r11 == true) goto L59;
            if (r13 == false) goto L7;
        L59:
            r6 = addAndGet(-r6);
            if (r6 != 0) goto L7;
            return;
        L35:
            r13 = false;
            goto L36
        L28:
            r11 = false;
            goto L30
        L8:
            r3.clear();
            r5.clear();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.cancelled;
        }

        boolean setDisposable(io.reactivex.disposables.b r3, int r4) {
            io.reactivex.disposables.b r5 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
            return this.resources.setResource(r4, r5);
        }

        void subscribe() {
            a<T>[] r0 = this.observers;
            this.first.subscribe(r0[0]);
            this.second.subscribe(r0[1]);
        }
    }

    static final class a<T> implements t<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final EqualCoordinator<T> f16993a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final io.reactivex.internal.queue.a<T> f16994b;
        final int c;
        volatile boolean d;
        Throwable e;

        a(EqualCoordinator<T> r1, int r2, int r3) {
            this.f16993a = r1;
            this.c = r2;
            this.f16994b = new io.reactivex.internal.queue.a(r3);
        }

        @Override // io.reactivex.t
        public void onComplete() {
            this.d = true;
            this.f16993a.drain();
        }

        @Override // io.reactivex.t
        public void onError(Throwable r1) {
            this.e = r1;
            this.d = true;
            this.f16993a.drain();
        }

        @Override // io.reactivex.t
        public void onNext(T r2) {
            this.f16994b.offer(r2);
            this.f16993a.drain();
        }

        @Override // io.reactivex.t
        public void onSubscribe(io.reactivex.disposables.b r3) {
            io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
            this.f16993a.setDisposable(r4, this.c);
        }
    }

    @Override // io.reactivex.v
    public void b(x<? super Boolean> r8) {
        x r9 = (x) ZeusTransformUtils.wrapperContextForParams(r8, x.class, "com.obric.memorydata.plugin");
        EqualCoordinator r6 = new EqualCoordinator(r9, this.d, this.f16991a, this.f16992b, this.c);
        r9.onSubscribe(r6);
        r6.subscribe();
    }
}
