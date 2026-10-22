package io.reactivex.internal.operators.observable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.b.h;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.e;
import io.reactivex.s;
import io.reactivex.t;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: loaded from: classes6.dex */
public final class ObservableWithLatestFromMany<T, R> extends io.reactivex.internal.operators.observable.a<T, R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final s<?>[] f17028b;
    final Iterable<? extends s<?>> c;
    final h<? super Object[], R> d;

    static final class WithLatestFromObserver<T, R> extends AtomicInteger implements io.reactivex.disposables.b, t<T> {
        private static final long serialVersionUID = 1577321883966341961L;
        final h<? super Object[], R> combiner;
        volatile boolean done;
        final t<? super R> downstream;
        final AtomicThrowable error;
        final WithLatestInnerObserver[] observers;
        final AtomicReference<io.reactivex.disposables.b> upstream;
        final AtomicReferenceArray<Object> values;

        WithLatestFromObserver(t<? super R> r3, h<? super Object[], R> r4, int r5) {
            t<? super R> r6 = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
            h<? super Object[], R> r7 = (h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.memorydata.plugin");
            this.downstream = r6;
            this.combiner = r7;
            WithLatestInnerObserver[] r8 = new WithLatestInnerObserver[r5];
            int r9 = 0;
        L3:
            if (r9 >= r5) goto L5;
            r8[r9] = new WithLatestInnerObserver(this, r9);
            r9 = r9 + 1;
            goto L3
        L5:
            this.observers = r8;
            this.values = new AtomicReferenceArray(r5);
            this.upstream = new AtomicReference();
            this.error = new AtomicThrowable();
        }

        void cancelAllBut(int r3) {
            WithLatestInnerObserver[] r2 = this.observers;
            int r0 = 0;
        L4:
            if (r0 >= r2.length) goto L8;
            if (r0 == r3) goto L7;
            r2[r0].dispose();
        L7:
            r0 = r0 + 1;
            goto L4
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this.upstream);
            WithLatestInnerObserver[] r3 = this.observers;
            int r0 = r3.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            r3[r1].dispose();
            r1 = r1 + 1;
            goto L3
        }

        void innerComplete(int r1, boolean r2) {
            if (r2 == true) goto L5;
            this.done = true;
            cancelAllBut(r1);
            e.a(this.downstream, this, this.error);
            return;
        }

        void innerError(int r2, Throwable r3) {
            this.done = true;
            DisposableHelper.dispose(this.upstream);
            cancelAllBut(r2);
            e.a(this.downstream, r3, this, this.error);
        }

        void innerNext(int r1, Object r2) {
            this.values.set(r1, r2);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed((io.reactivex.disposables.b) ZeusTransformUtils.preCheckCast(this.upstream.get(), io.reactivex.disposables.b.class, "com.obric.memorydata.plugin"));
        }

        @Override // io.reactivex.t
        public void onComplete() {
            if (this.done == true) goto L6;
            this.done = true;
            cancelAllBut(-1);
            e.a(this.downstream, this, this.error);
            return;
        }

        @Override // io.reactivex.t
        public void onError(Throwable r3) {
            if (this.done == false) goto L6;
            io.reactivex.d.a.a(r3);
            return;
        L6:
            this.done = true;
            cancelAllBut(-1);
            e.a(this.downstream, r3, this, this.error);
        }

        @Override // io.reactivex.t
        public void onNext(T r5) {
            if (this.done == false) goto L5;
            return;
        L5:
            AtomicReferenceArray<Object> r0 = this.values;
            int r1 = r0.length();
            Object[] r2 = new Object[r1 + 1];
            int r3 = 0;
            r2[0] = r5;
        L6:
            if (r3 >= r1) goto L17;
            Object r6 = r0.get(r3);
            if (r6 == null) goto L9;
            r3 = r3 + 1;
            r2[r3] = r6;
            goto L6
        L9:
            return;
        L17:
            Object r7 = io.reactivex.internal.functions.a.a(this.combiner.apply(r2), "combiner returned a null value");     // Catch: Throwable -> L14
            e.a(this.downstream, r7, this, this.error);
            return;
        L14:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            dispose();
            onError(th);
        }

        @Override // io.reactivex.t
        public void onSubscribe(io.reactivex.disposables.b r3) {
            io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
            DisposableHelper.setOnce(this.upstream, r4);
        }

        void subscribe(s<?>[] r7, int r8) {
            WithLatestInnerObserver[] r0 = this.observers;
            AtomicReference<io.reactivex.disposables.b> r1 = this.upstream;
            int r2 = 0;
        L3:
            if (r2 >= r8) goto L10;
            if (DisposableHelper.isDisposed((io.reactivex.disposables.b) ZeusTransformUtils.preCheckCast(r1.get(), io.reactivex.disposables.b.class, "com.obric.memorydata.plugin")) == true) goto L14;
            if (this.done == true) goto L15;
            r7[r2].subscribe(r0[r2]);
            r2 = r2 + 1;
            goto L3
        L15:
            return;
        L14:
            return;
        }
    }

    static final class WithLatestInnerObserver extends AtomicReference<io.reactivex.disposables.b> implements t<Object> {
        private static final long serialVersionUID = 3256684027868224024L;
        boolean hasValue;
        final int index;
        final WithLatestFromObserver<?, ?> parent;

        WithLatestInnerObserver(WithLatestFromObserver<?, ?> r1, int r2) {
            this.parent = r1;
            this.index = r2;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.t
        public void onComplete() {
            this.parent.innerComplete(this.index, this.hasValue);
        }

        @Override // io.reactivex.t
        public void onError(Throwable r2) {
            this.parent.innerError(this.index, r2);
        }

        @Override // io.reactivex.t
        public void onNext(Object r2) {
            if (this.hasValue == true) goto L5;
            this.hasValue = true;
        L5:
            this.parent.innerNext(this.index, r2);
        }

        @Override // io.reactivex.t
        public void onSubscribe(io.reactivex.disposables.b r3) {
            DisposableHelper.setOnce(this, (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin"));
        }
    }

    final class a implements h<T, R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ObservableWithLatestFromMany f17029a;

        a(ObservableWithLatestFromMany r1) {
            this.f17029a = r1;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, java.lang.Object[]] */
        @Override // io.reactivex.b.h
        public R apply(T r3) {
            return (R) io.reactivex.internal.functions.a.a(this.f17029a.d.apply(new Object[]{r3}), "The combiner returned a null value");
        }
    }

    @Override // io.reactivex.Observable
    public void a(t<? super R> r7) {
        t r8 = (t) ZeusTransformUtils.wrapperContextForParams(r7, t.class, "com.obric.memorydata.plugin");
        s<?>[] r0 = this.f17028b;
        if (r0 != null) goto L16;
        r0 = new s[8];
        Iterator<? extends s<?>> r2 = this.c.iterator();     // Catch: Throwable -> L13
        int r3 = 0;
    L6:
        if (r2.hasNext() == false) goto L17;
        s<?> r4 = (s) ZeusTransformUtils.preCheckCast(r2.next(), s.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        if (r3 != r0.length) goto L11;
        r0 = (s[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r0, (r3 >> 1) + r3), s[].class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
    L11:
        int r5 = r3 + 1;     // Catch: Throwable -> L13
        r0[r3] = r4;     // Catch: Throwable -> L13
        r3 = r5;
    L17:
        if (r3 != 0) goto L20;
        new b(this.f17034a, new a(this)).a(r8);
        return;
    L20:
        WithLatestFromObserver r1 = new WithLatestFromObserver(r8, this.d, r3);
        r8.onSubscribe(r1);
        r1.subscribe(r0, r3);
        this.f17034a.subscribe(r1);
        return;
    L13:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        EmptyDisposable.error(th, r8);
        return;
    L16:
        r3 = r0.length;
        goto L17
    }
}
