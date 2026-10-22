package io.reactivex.internal.operators.observable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.Observable;
import io.reactivex.b.h;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.s;
import io.reactivex.t;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class ObservableCombineLatest<T, R> extends Observable<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final s<? extends T>[] f16931a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Iterable<? extends s<? extends T>> f16932b;
    final h<? super Object[], ? extends R> c;
    final int d;
    final boolean e;

    static final class CombinerObserver<T, R> extends AtomicReference<io.reactivex.disposables.b> implements t<T> {
        private static final long serialVersionUID = -4823716997131257941L;
        final int index;
        final LatestCoordinator<T, R> parent;

        CombinerObserver(LatestCoordinator<T, R> r1, int r2) {
            this.parent = r1;
            this.index = r2;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.t
        public void onComplete() {
            this.parent.innerComplete(this.index);
        }

        @Override // io.reactivex.t
        public void onError(Throwable r2) {
            this.parent.innerError(this.index, r2);
        }

        @Override // io.reactivex.t
        public void onNext(T r2) {
            this.parent.innerNext(this.index, r2);
        }

        @Override // io.reactivex.t
        public void onSubscribe(io.reactivex.disposables.b r3) {
            DisposableHelper.setOnce(this, (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin"));
        }
    }

    static final class LatestCoordinator<T, R> extends AtomicInteger implements io.reactivex.disposables.b {
        private static final long serialVersionUID = 8567835998786448817L;
        int active;
        volatile boolean cancelled;
        final h<? super Object[], ? extends R> combiner;
        int complete;
        final boolean delayError;
        volatile boolean done;
        final t<? super R> downstream;
        final AtomicThrowable errors;
        Object[] latest;
        final CombinerObserver<T, R>[] observers;
        final io.reactivex.internal.queue.a<Object[]> queue;

        LatestCoordinator(t<? super R> r3, h<? super Object[], ? extends R> r4, int r5, int r6, boolean r7) {
            t<? super R> r8 = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
            h<? super Object[], ? extends R> r9 = (h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.memorydata.plugin");
            this.errors = new AtomicThrowable();
            this.downstream = r8;
            this.combiner = r9;
            this.delayError = r7;
            this.latest = new Object[r5];
            CombinerObserver<T, R>[] r10 = new CombinerObserver[r5];
            int r11 = 0;
        L3:
            if (r11 >= r5) goto L5;
            r10[r11] = new CombinerObserver(this, r11);
            r11 = r11 + 1;
            goto L3
        L5:
            this.observers = r10;
            this.queue = new io.reactivex.internal.queue.a(r6);
        }

        void cancelSources() {
            CombinerObserver<T, R>[] r3 = this.observers;
            int r0 = r3.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            r3[r1].dispose();
            r1 = r1 + 1;
            goto L3
        }

        void clear(io.reactivex.internal.queue.a<?> r2) {
            monitor-enter(this);
            this.latest = null;     // Catch: Throwable -> L8
            monitor-exit(this);     // Catch: Throwable -> L8
            r2.clear();
            return;
        L8:
            th = move-exception;
            throw th;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.cancelled == true) goto L8;
            this.cancelled = true;
            cancelSources();
            if (getAndIncrement() != 0) goto L9;
            clear(this.queue);
            return;
        L9:
            return;
        }

        void drain() {
            if (getAndIncrement() == 0) goto L5;
            return;
        L5:
            io.reactivex.internal.queue.a<Object[]> r0 = this.queue;
            t<? super R> r1 = this.downstream;
            boolean r2 = this.delayError;
            int r4 = 1;
        L7:
            if (this.cancelled == true) goto L8;
            if (r2 == false) goto L12;
        L15:
            boolean r5 = this.done;
            Object[] r6 = (Object[]) ZeusTransformUtils.preCheckCast(r0.poll(), Object[].class, "com.obric.memorydata.plugin");
            if (r6 != null) goto L18;
            boolean r7 = true;
        L19:
            if (r5 == false) goto L26;
            if (r7 == false) goto L26;
            clear(r0);
            Throwable r9 = this.errors.terminate();
            if (r9 != null) goto L24;
            r1.onComplete();
            return;
        L24:
            r1.onError(r9);
            return;
        L26:
            if (r7 == true) goto L27;
            r1.onNext((Object) io.reactivex.internal.functions.a.a(this.combiner.apply(r6), "The combiner returned a null value"));
        L32:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            this.errors.addThrowable(th);
        L13:
            cancelSources();
            clear(r0);
            r1.onError(this.errors.terminate());
            return;
        L27:
            r4 = addAndGet(-r4);
            if (r4 != 0) goto L7;
            return;
        L18:
            r7 = false;
            goto L19
        L12:
            if (this.errors.get() == null) goto L15;
        L8:
            clear(r0);
        }

        void innerComplete(int r4) {
            monitor-enter(this);
            Object[] r0 = this.latest;     // Catch: Throwable -> L20
            if (r0 != null) goto L8;
            monitor-exit(this);     // Catch: Throwable -> L20
            return;
        L8:
            if (r0[r4] != null) goto L10;
            boolean r5 = true;
        L11:
            if (r5 == true) goto L14;
            int r2 = this.complete + 1;     // Catch: Throwable -> L20
            this.complete = r2;     // Catch: Throwable -> L20
            if (r2 == r0.length) goto L14;
        L15:
            monitor-exit(this);     // Catch: Throwable -> L20
            if (r5 == false) goto L18;
            cancelSources();
        L18:
            drain();
            return;
        L14:
            this.done = true;     // Catch: Throwable -> L20
            goto L15
        L10:
            r5 = false;
        L20:
            th = move-exception;
            throw th;
        }

        void innerError(int r3, Throwable r4) {
            if (this.errors.addThrowable(r4) == false) goto L27;
            boolean r0 = true;
            if (this.delayError == false) goto L24;
            monitor-enter(this);
            Object[] r5 = this.latest;     // Catch: Throwable -> L21
            if (r5 != null) goto L12;
            monitor-exit(this);     // Catch: Throwable -> L21
            return;
        L12:
            if (r5[r3] != null) goto L14;
            boolean r6 = true;
        L15:
            if (r6 == true) goto L18;
            int r1 = this.complete + 1;     // Catch: Throwable -> L21
            this.complete = r1;     // Catch: Throwable -> L21
            if (r1 == r5.length) goto L18;
        L19:
            monitor-exit(this);     // Catch: Throwable -> L21
            r0 = r6;
        L18:
            this.done = true;     // Catch: Throwable -> L21
            goto L19
        L14:
            r6 = false;
        L21:
            th = move-exception;
            throw th;
        L24:
            if (r0 == false) goto L26;
            cancelSources();
        L26:
            drain();
            return;
        L27:
            io.reactivex.d.a.a(r4);
        }

        void innerNext(int r4, T r5) {
            monitor-enter(this);
            Object[] r0 = this.latest;     // Catch: Throwable -> L18
            if (r0 != null) goto L7;
            monitor-exit(this);     // Catch: Throwable -> L18
            return;
        L7:
            Object r1 = r0[r4];     // Catch: Throwable -> L18
            int r2 = this.active;     // Catch: Throwable -> L18
            if (r1 != null) goto L10;
            r2 = r2 + 1;     // Catch: Throwable -> L18
            this.active = r2;     // Catch: Throwable -> L18
        L10:
            r0[r4] = r5;     // Catch: Throwable -> L18
            if (r2 != r0.length) goto L13;
            this.queue.offer((Object[]) r0.clone());     // Catch: Throwable -> L18
            boolean r6 = true;
        L14:
            monitor-exit(this);     // Catch: Throwable -> L18
            if (r6 == false) goto L22;
            drain();
            return;
        L22:
            return;
        L13:
            r6 = false;
        L18:
            th = move-exception;
            throw th;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.cancelled;
        }

        public void subscribe(s<? extends T>[] r6) {
            CombinerObserver<T, R>[] r0 = this.observers;
            int r1 = r0.length;
            this.downstream.onSubscribe(this);
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L10;
            if (this.done == true) goto L14;
            if (this.cancelled == true) goto L15;
            r6[r2].subscribe(r0[r2]);
            r2 = r2 + 1;
            goto L3
        L15:
            return;
        L14:
            return;
        }
    }

    @Override // io.reactivex.Observable
    public void a(t<? super R> r9) {
        t r3 = (t) ZeusTransformUtils.wrapperContextForParams(r9, t.class, "com.obric.memorydata.plugin");
        s<? extends T>[] r10 = this.f16931a;
        if (r10 != null) goto L12;
        r10 = new s[8];
        Iterator<? extends s<? extends T>> r0 = this.f16932b.iterator();
        int r4 = 0;
    L6:
        if (r0.hasNext() == false) goto L11;
        s<? extends T> r5 = (s) ZeusTransformUtils.preCheckCast(r0.next(), s.class, "com.obric.memorydata.plugin");
        if (r4 != r10.length) goto L10;
        s<? extends T>[] r6 = new s[(r4 >> 2) + r4];
        System.arraycopy(r10, 0, r6, 0, r4);
        r10 = r6;
    L10:
        r10[r4] = r5;
        r4 = r4 + 1;
        goto L6
    L11:
        int r7 = r4;
    L13:
        if (r7 != 0) goto L16;
        EmptyDisposable.complete(r3);
        return;
    L16:
        new LatestCoordinator(r3, this.c, r7, this.d, this.e).subscribe(r10);
        return;
    L12:
        r7 = r10.length;
        goto L13
    }
}
