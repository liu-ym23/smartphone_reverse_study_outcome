package io.reactivex.internal.operators.observable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.Observable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.subjects.UnicastSubject;
import io.reactivex.t;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes6.dex */
public final class ObservableWindow<T> extends a<T, Observable<T>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f17018b;
    final long c;
    final int d;

    static final class WindowExactObserver<T> extends AtomicInteger implements io.reactivex.disposables.b, t<T>, Runnable {
        private static final long serialVersionUID = -7481782523886138128L;
        volatile boolean cancelled;
        final int capacityHint;
        final long count;
        final t<? super Observable<T>> downstream;
        long size;
        io.reactivex.disposables.b upstream;
        UnicastSubject<T> window;

        WindowExactObserver(t<? super Observable<T>> r3, long r4, int r6) {
            this.downstream = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
            this.count = r4;
            this.capacityHint = r6;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.cancelled = true;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.t
        public void onComplete() {
            UnicastSubject<T> r0 = this.window;
            if (r0 == null) goto L5;
            this.window = null;
            r0.onComplete();
        L5:
            this.downstream.onComplete();
        }

        @Override // io.reactivex.t
        public void onError(Throwable r3) {
            UnicastSubject<T> r0 = this.window;
            if (r0 == null) goto L5;
            this.window = null;
            r0.onError(r3);
        L5:
            this.downstream.onError(r3);
        }

        @Override // io.reactivex.t
        public void onNext(T r6) {
            UnicastSubject<T> r0 = this.window;
            if (r0 == null) goto L5;
        L7:
            if (r0 == null) goto L14;
            r0.onNext(r6);
            long r1 = this.size + 1;
            this.size = r1;
            if (r1 < this.count) goto L15;
            this.size = 0;
            this.window = null;
            r0.onComplete();
            if (this.cancelled == false) goto L16;
            this.upstream.dispose();
            return;
        L16:
            return;
        L15:
            return;
        L14:
            return;
        L5:
            if (this.cancelled == true) goto L7;
            r0 = UnicastSubject.a(this.capacityHint, this);
            this.window = r0;
            this.downstream.onNext(r0);
            goto L7
        }

        @Override // io.reactivex.t
        public void onSubscribe(io.reactivex.disposables.b r3) {
            io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
            if (DisposableHelper.validate(this.upstream, r4) == false) goto L6;
            this.upstream = r4;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.cancelled == false) goto L6;
            this.upstream.dispose();
            return;
        }
    }

    static final class WindowSkipObserver<T> extends AtomicBoolean implements io.reactivex.disposables.b, t<T>, Runnable {
        private static final long serialVersionUID = 3366976432059579510L;
        volatile boolean cancelled;
        final int capacityHint;
        final long count;
        final t<? super Observable<T>> downstream;
        long firstEmission;
        long index;
        final long skip;
        io.reactivex.disposables.b upstream;
        final ArrayDeque<UnicastSubject<T>> windows;
        final AtomicInteger wip;

        WindowSkipObserver(t<? super Observable<T>> r3, long r4, long r6, int r8) {
            t<? super Observable<T>> r5 = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
            this.wip = new AtomicInteger();
            this.downstream = r5;
            this.count = r4;
            this.skip = r6;
            this.capacityHint = r8;
            this.windows = new ArrayDeque();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.cancelled = true;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.t
        public void onComplete() {
            ArrayDeque<UnicastSubject<T>> r0 = this.windows;
        L4:
            if (r0.isEmpty() == true) goto L6;
            ((UnicastSubject) ZeusTransformUtils.preCheckCast(r0.poll(), UnicastSubject.class, "com.obric.memorydata.plugin")).onComplete();
            goto L4
        L6:
            this.downstream.onComplete();
        }

        @Override // io.reactivex.t
        public void onError(Throwable r5) {
            ArrayDeque<UnicastSubject<T>> r0 = this.windows;
        L4:
            if (r0.isEmpty() == true) goto L6;
            ((UnicastSubject) ZeusTransformUtils.preCheckCast(r0.poll(), UnicastSubject.class, "com.obric.memorydata.plugin")).onError(r5);
            goto L4
        L6:
            this.downstream.onError(r5);
        }

        @Override // io.reactivex.t
        public void onNext(T r14) {
            ArrayDeque<UnicastSubject<T>> r0 = this.windows;
            long r1 = this.index;
            long r3 = this.skip;
            if ((r1 % r3) == 0) goto L5;
        L7:
            long r5 = this.firstEmission + 1;
            Iterator<UnicastSubject<T>> r9 = r0.iterator();
        L9:
            if (r9.hasNext() == false) goto L12;
            ((UnicastSubject) ZeusTransformUtils.preCheckCast(r9.next(), UnicastSubject.class, "com.obric.memorydata.plugin")).onNext(r14);
            goto L9
        L12:
            if (r5 < this.count) goto L20;
            ((UnicastSubject) ZeusTransformUtils.preCheckCast(r0.poll(), UnicastSubject.class, "com.obric.memorydata.plugin")).onComplete();
            if (r0.isEmpty() == true) goto L16;
        L19:
            r5 = r5 - r3;
            goto L20
        L16:
            if (this.cancelled == false) goto L19;
            this.upstream.dispose();
            return;
        L20:
            this.firstEmission = r5;
            this.index = r1 + 1;
            return;
        L5:
            if (this.cancelled == true) goto L7;
            this.wip.getAndIncrement();
            UnicastSubject<T> r6 = UnicastSubject.a(this.capacityHint, this);
            r0.offer(r6);
            this.downstream.onNext(r6);
            goto L7
        }

        @Override // io.reactivex.t
        public void onSubscribe(io.reactivex.disposables.b r3) {
            io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
            if (DisposableHelper.validate(this.upstream, r4) == false) goto L6;
            this.upstream = r4;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.wip.decrementAndGet() == 0) goto L5;
            return;
        L5:
            if (this.cancelled == false) goto L9;
            this.upstream.dispose();
            return;
        }
    }

    @Override // io.reactivex.Observable
    public void a(t<? super Observable<T>> r9) {
        t r1 = (t) ZeusTransformUtils.wrapperContextForParams(r9, t.class, "com.obric.memorydata.plugin");
        if (this.f17018b != this.c) goto L5;
        this.f17034a.subscribe(new WindowExactObserver(r1, this.f17018b, this.d));
        return;
    L5:
        this.f17034a.subscribe(new WindowSkipObserver(r1, this.f17018b, this.c, this.d));
    }
}
