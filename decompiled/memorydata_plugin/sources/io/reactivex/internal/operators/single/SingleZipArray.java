package io.reactivex.internal.operators.single;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.b.h;
import io.reactivex.disposables.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.v;
import io.reactivex.x;
import io.reactivex.z;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class SingleZipArray<T, R> extends v<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final z<? extends T>[] f17098a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h<? super Object[], ? extends R> f17099b;

    static final class ZipCoordinator<T, R> extends AtomicInteger implements b {
        private static final long serialVersionUID = -5556924161382950569L;
        final x<? super R> downstream;
        final ZipSingleObserver<T>[] observers;
        final Object[] values;
        final h<? super Object[], ? extends R> zipper;

        ZipCoordinator(x<? super R> r3, int r4, h<? super Object[], ? extends R> r5) {
            x<? super R> r6 = (x) ZeusTransformUtils.wrapperContextForParams(r3, x.class, "com.obric.memorydata.plugin");
            h<? super Object[], ? extends R> r7 = (h) ZeusTransformUtils.wrapperContextForParams(r5, h.class, "com.obric.memorydata.plugin");
            super(r4);
            this.downstream = r6;
            this.zipper = r7;
            ZipSingleObserver<T>[] r8 = new ZipSingleObserver[r4];
            int r9 = 0;
        L3:
            if (r9 >= r4) goto L5;
            r8[r9] = new ZipSingleObserver(this, r9);
            r9 = r9 + 1;
            goto L3
        L5:
            this.observers = r8;
            this.values = new Object[r4];
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            int r0 = 0;
            if (getAndSet(0) <= 0) goto L7;
            ZipSingleObserver<T>[] r3 = this.observers;
            int r1 = r3.length;
        L5:
            if (r0 >= r1) goto L9;
            r3[r0].dispose();
            r0 = r0 + 1;
            goto L5
        L9:
            return;
        }

        void disposeExcept(int r4) {
            ZipSingleObserver<T>[] r3 = this.observers;
            int r0 = r3.length;
            int r1 = 0;
        L3:
            if (r1 >= r4) goto L5;
            r3[r1].dispose();
            r1 = r1 + 1;
        L5:
            r4 = r4 + 1;
            if (r4 >= r0) goto L8;
            r3[r4].dispose();
            goto L5
        }

        void innerError(Throwable r2, int r3) {
            if (getAndSet(0) <= 0) goto L5;
            disposeExcept(r3);
            this.downstream.onError(r2);
            return;
        L5:
            io.reactivex.d.a.a(r2);
        }

        void innerSuccess(T r2, int r3) {
            this.values[r3] = r2;
            if (decrementAndGet() != 0) goto L11;
            Object r4 = io.reactivex.internal.functions.a.a(this.zipper.apply(this.values), "The zipper returned a null value");     // Catch: Throwable -> L6
            this.downstream.onSuccess(r4);
            return;
        L6:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            this.downstream.onError(th);
            return;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            if (get() > 0) goto L5;
            return true;
        L5:
            return false;
        }
    }

    static final class ZipSingleObserver<T> extends AtomicReference<b> implements x<T> {
        private static final long serialVersionUID = 3323743579927613702L;
        final int index;
        final ZipCoordinator<T, ?> parent;

        ZipSingleObserver(ZipCoordinator<T, ?> r1, int r2) {
            this.parent = r1;
            this.index = r2;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.x
        public void onError(Throwable r2) {
            this.parent.innerError(r2, this.index);
        }

        @Override // io.reactivex.x
        public void onSubscribe(b r3) {
            DisposableHelper.setOnce(this, (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin"));
        }

        @Override // io.reactivex.x
        public void onSuccess(T r2) {
            this.parent.innerSuccess(r2, this.index);
        }
    }

    final class a implements h<T, R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ SingleZipArray f17100a;

        a(SingleZipArray r1) {
            this.f17100a = r1;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, java.lang.Object[]] */
        @Override // io.reactivex.b.h
        public R apply(T r3) {
            return (R) io.reactivex.internal.functions.a.a(this.f17100a.f17099b.apply(new Object[]{r3}), "The zipper returned a null value");
        }
    }

    @Override // io.reactivex.v
    public void b(x<? super R> r5) {
        x r6 = (x) ZeusTransformUtils.wrapperContextForParams(r5, x.class, "com.obric.memorydata.plugin");
        z<? extends T>[] r0 = this.f17098a;
        int r1 = r0.length;
        int r2 = 0;
        if (r1 != 1) goto L6;
        r0[0].a(new io.reactivex.internal.operators.single.a.C0874a(r6, new a(this)));
        return;
    L6:
        ZipCoordinator r3 = new ZipCoordinator(r6, r1, this.f17099b);
        r6.onSubscribe(r3);
    L7:
        if (r2 >= r1) goto L16;
        if (r3.isDisposed() == true) goto L10;
        z<? extends T> r4 = r0[r2];
        if (r4 == null) goto L13;
        r4.a(r3.observers[r2]);
        r2 = r2 + 1;
        goto L7
    L13:
        r3.innerError(new NullPointerException("One of the sources is null"), r2);
        return;
    L10:
        return;
    }
}
