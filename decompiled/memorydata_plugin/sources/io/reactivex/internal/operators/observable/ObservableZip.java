package io.reactivex.internal.operators.observable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.Observable;
import io.reactivex.b.h;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.s;
import io.reactivex.t;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class ObservableZip<T, R> extends Observable<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final s<? extends T>[] f17030a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Iterable<? extends s<? extends T>> f17031b;
    final h<? super Object[], ? extends R> c;
    final int d;
    final boolean e;

    static final class ZipCoordinator<T, R> extends AtomicInteger implements io.reactivex.disposables.b {
        private static final long serialVersionUID = 2983708048395377667L;
        volatile boolean cancelled;
        final boolean delayError;
        final t<? super R> downstream;
        final a<T, R>[] observers;
        final T[] row;
        final h<? super Object[], ? extends R> zipper;

        ZipCoordinator(t<? super R> r3, h<? super Object[], ? extends R> r4, int r5, boolean r6) {
            t<? super R> r7 = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
            h<? super Object[], ? extends R> r8 = (h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.memorydata.plugin");
            this.downstream = r7;
            this.zipper = r8;
            this.observers = new a[r5];
            this.row = (T[]) ((Object[]) ZeusTransformUtils.preCheckCast(new Object[r5], Object[].class, "com.obric.memorydata.plugin"));
            this.delayError = r6;
        }

        void cancel() {
            clear();
            cancelSources();
        }

        void cancelSources() {
            a<T, R>[] r3 = this.observers;
            int r0 = r3.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            r3[r1].a();
            r1 = r1 + 1;
            goto L3
        }

        boolean checkTerminated(boolean r3, boolean r4, t<? super R> r5, boolean r6, a<?, ?> r7) {
            t r8 = (t) ZeusTransformUtils.wrapperContextForParams(r5, t.class, "com.obric.memorydata.plugin");
            if (this.cancelled == false) goto L6;
            cancel();
            return true;
        L6:
            if (r3 == false) goto L21;
            if (r6 == false) goto L14;
            if (r4 == false) goto L23;
            Throwable r9 = r7.d;
            this.cancelled = true;
            cancel();
            if (r9 == null) goto L12;
            r8.onError(r9);
        L13:
            return true;
        L12:
            r8.onComplete();
            goto L13
        L23:
            return false;
        L14:
            Throwable r10 = r7.d;
            if (r10 == null) goto L18;
            this.cancelled = true;
            cancel();
            r8.onError(r10);
            return true;
        L18:
            if (r4 == false) goto L24;
            this.cancelled = true;
            cancel();
            r8.onComplete();
            return true;
        L24:
            return false;
        L21:
            return false;
        }

        void clear() {
            a<T, R>[] r3 = this.observers;
            int r0 = r3.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            r3[r1].f17033b.clear();
            r1 = r1 + 1;
            goto L3
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.cancelled == true) goto L8;
            this.cancelled = true;
            cancelSources();
            if (getAndIncrement() != 0) goto L9;
            clear();
            return;
        L9:
            return;
        }

        public void drain() {
            if (getAndIncrement() == 0) goto L5;
            return;
        L5:
            a<T, R>[] r0 = this.observers;
            t<? super R> r8 = this.downstream;
            T[] r9 = this.row;
            boolean r10 = this.delayError;
            int r12 = 1;
        L6:
            int r13 = r0.length;
            int r15 = 0;
            int r16 = 0;
            int r17 = 0;
        L7:
            if (r15 >= r13) goto L28;
            a<T, R> r6 = r0[r15];
            if (r9[r17] != null) goto L21;
            boolean r2 = r6.c;
            T r18 = r6.f17033b.poll();
            if (r18 != null) goto L13;
            boolean r19 = true;
        L15:
            if (checkTerminated(r2, r19, r8, r10, r6) == true) goto L16;
            if (r19 == true) goto L19;
            r9[r17] = r18;
        L27:
            r17 = r17 + 1;
            r15 = r15 + 1;
            goto L7
        L19:
            r16 = r16 + 1;
            goto L27
        L16:
            return;
        L13:
            r19 = false;
            goto L15
        L21:
            if (r6.c == false) goto L27;
            if (r10 == true) goto L27;
            Throwable r1 = r6.d;
            if (r1 == null) goto L27;
            this.cancelled = true;
            cancel();
            r8.onError(r1);
            return;
        L28:
            if (r16 != 0) goto L29;
            r8.onNext((Object) io.reactivex.internal.functions.a.a(this.zipper.apply(r9.clone()), "The zipper returned a null value"));
            Arrays.fill(r9, null);
        L34:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            cancel();
            r8.onError(th);
            return;
        L29:
            r12 = addAndGet(-r12);
            if (r12 != 0) goto L6;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.cancelled;
        }

        public void subscribe(s<? extends T>[] r6, int r7) {
            a<T, R>[] r0 = this.observers;
            int r1 = r0.length;
            int r2 = 0;
            int r3 = 0;
        L3:
            if (r3 >= r1) goto L5;
            r0[r3] = new a(this, r7);
            r3 = r3 + 1;
            goto L3
        L5:
            lazySet(0);
            this.downstream.onSubscribe(this);
        L6:
            if (r2 >= r1) goto L11;
            if (this.cancelled == true) goto L9;
            r6[r2].subscribe(r0[r2]);
            r2 = r2 + 1;
            goto L6
        L9:
            return;
        }
    }

    static final class a<T, R> implements t<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ZipCoordinator<T, R> f17032a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final io.reactivex.internal.queue.a<T> f17033b;
        volatile boolean c;
        Throwable d;
        final AtomicReference<io.reactivex.disposables.b> e;

        a(ZipCoordinator<T, R> r2, int r3) {
            this.e = new AtomicReference();
            this.f17032a = r2;
            this.f17033b = new io.reactivex.internal.queue.a(r3);
        }

        public void a() {
            DisposableHelper.dispose(this.e);
        }

        @Override // io.reactivex.t
        public void onComplete() {
            this.c = true;
            this.f17032a.drain();
        }

        @Override // io.reactivex.t
        public void onError(Throwable r1) {
            this.d = r1;
            this.c = true;
            this.f17032a.drain();
        }

        @Override // io.reactivex.t
        public void onNext(T r2) {
            this.f17033b.offer(r2);
            this.f17032a.drain();
        }

        @Override // io.reactivex.t
        public void onSubscribe(io.reactivex.disposables.b r3) {
            io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
            DisposableHelper.setOnce(this.e, r4);
        }
    }

    @Override // io.reactivex.Observable
    public void a(t<? super R> r8) {
        t r9 = (t) ZeusTransformUtils.wrapperContextForParams(r8, t.class, "com.obric.memorydata.plugin");
        s<? extends T>[] r0 = this.f17030a;
        if (r0 != null) goto L11;
        r0 = new s[8];
        Iterator<? extends s<? extends T>> r2 = this.f17031b.iterator();
        int r4 = 0;
    L6:
        if (r2.hasNext() == false) goto L12;
        s<? extends T> r5 = (s) ZeusTransformUtils.preCheckCast(r2.next(), s.class, "com.obric.memorydata.plugin");
        if (r4 != r0.length) goto L10;
        s<? extends T>[] r6 = new s[(r4 >> 2) + r4];
        System.arraycopy(r0, 0, r6, 0, r4);
        r0 = r6;
    L10:
        r0[r4] = r5;
        r4 = r4 + 1;
    L12:
        if (r4 != 0) goto L15;
        EmptyDisposable.complete(r9);
        return;
    L15:
        new ZipCoordinator(r9, this.c, r4, this.e).subscribe(r0, this.d);
        return;
    L11:
        r4 = r0.length;
        goto L12
    }
}
