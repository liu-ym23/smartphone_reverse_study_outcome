package io.reactivex.internal.operators.observable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.Observable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.s;
import io.reactivex.t;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class ObservableAmb<T> extends Observable<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final s<? extends T>[] f16920a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Iterable<? extends s<? extends T>> f16921b;

    static final class AmbInnerObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements t<T> {
        private static final long serialVersionUID = -1185974347409665484L;
        final t<? super T> downstream;
        final int index;
        final a<T> parent;
        boolean won;

        AmbInnerObserver(a<T> r3, int r4, t<? super T> r5) {
            t<? super T> r6 = (t) ZeusTransformUtils.wrapperContextForParams(r5, t.class, "com.obric.memorydata.plugin");
            this.parent = r3;
            this.index = r4;
            this.downstream = r6;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.t
        public void onComplete() {
            if (this.won == false) goto L6;
        L4:
            this.downstream.onComplete();
            return;
        L6:
            if (this.parent.a(this.index) == false) goto L9;
            this.won = true;
            goto L4
        }

        @Override // io.reactivex.t
        public void onError(Throwable r3) {
            if (this.won == false) goto L6;
        L4:
            this.downstream.onError(r3);
            return;
        L6:
            if (this.parent.a(this.index) == false) goto L8;
            this.won = true;
            goto L4
        L8:
            io.reactivex.d.a.a(r3);
        }

        @Override // io.reactivex.t
        public void onNext(T r3) {
            if (this.won == false) goto L6;
        L4:
            this.downstream.onNext(r3);
            return;
        L6:
            if (this.parent.a(this.index) == false) goto L8;
            this.won = true;
            goto L4
        L8:
            ((io.reactivex.disposables.b) ZeusTransformUtils.preCheckCast(get(), io.reactivex.disposables.b.class, "com.obric.memorydata.plugin")).dispose();
        }

        @Override // io.reactivex.t
        public void onSubscribe(io.reactivex.disposables.b r3) {
            DisposableHelper.setOnce(this, (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin"));
        }
    }

    static final class a<T> implements io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final t<? super T> f16922a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final AmbInnerObserver<T>[] f16923b;
        final AtomicInteger c;

        a(t<? super T> r3, int r4) {
            t<? super T> r5 = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
            this.c = new AtomicInteger();
            this.f16922a = r5;
            this.f16923b = new AmbInnerObserver[r4];
        }

        public void a(s<? extends T>[] r8) {
            AmbInnerObserver<T>[] r0 = this.f16923b;
            int r1 = r0.length;
            int r2 = 0;
            int r3 = 0;
        L3:
            if (r3 >= r1) goto L5;
            int r5 = r3 + 1;
            r0[r3] = new AmbInnerObserver(this, r5, this.f16922a);
            r3 = r5;
            goto L3
        L5:
            this.c.lazySet(0);
            this.f16922a.onSubscribe(this);
        L6:
            if (r2 >= r1) goto L11;
            if (this.c.get() != 0) goto L9;
            r8[r2].subscribe(r0[r2]);
            r2 = r2 + 1;
            goto L6
        L9:
            return;
        }

        public boolean a(int r5) {
            int r0 = this.c.get();
            int r2 = 0;
            if (r0 == 0) goto L5;
            if (r0 != r5) goto L17;
            return true;
        L17:
            return false;
        L5:
            if (this.c.compareAndSet(0, r5) == false) goto L13;
            AmbInnerObserver<T>[] r4 = this.f16923b;
            int r1 = r4.length;
        L7:
            if (r2 >= r1) goto L12;
            int r3 = r2 + 1;
            if (r3 == r5) goto L11;
            r4[r2].dispose();
        L11:
            r2 = r3;
            goto L7
        L12:
            return true;
        L13:
            return false;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.c.get() == (-1)) goto L7;
            this.c.lazySet(-1);
            AmbInnerObserver<T>[] r3 = this.f16923b;
            int r0 = r3.length;
            int r1 = 0;
        L5:
            if (r1 >= r0) goto L9;
            r3[r1].dispose();
            r1 = r1 + 1;
            goto L5
        L9:
            return;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            if (this.c.get() != (-1)) goto L5;
            return true;
        L5:
            return false;
        }
    }

    @Override // io.reactivex.Observable
    public void a(t<? super T> r7) {
        t<? super Object> r8 = (t) ZeusTransformUtils.wrapperContextForParams(r7, t.class, "com.obric.memorydata.plugin");
        s<? extends T>[] r0 = this.f16920a;
        if (r0 != null) goto L20;
        r0 = new s[8];
        Iterator<? extends s<? extends T>> r6 = this.f16921b.iterator();     // Catch: Throwable -> L17
        int r3 = 0;
    L7:
        if (r6.hasNext() == false) goto L21;
        s<? extends T> r4 = (s) ZeusTransformUtils.preCheckCast(r6.next(), s.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
        if (r4 == null) goto L10;
        if (r3 != r0.length) goto L15;
        s<? extends T>[] r5 = new s[(r3 >> 2) + r3];     // Catch: Throwable -> L17
        System.arraycopy(r0, 0, r5, 0, r3);     // Catch: Throwable -> L17
        r0 = r5;
    L15:
        int r9 = r3 + 1;     // Catch: Throwable -> L17
        r0[r3] = r4;     // Catch: Throwable -> L17
        r3 = r9;
        goto L7
    L10:
        EmptyDisposable.error(new NullPointerException("One of the sources is null"), r8);     // Catch: Throwable -> L17
        return;
    L21:
        if (r3 != 0) goto L25;
        EmptyDisposable.complete(r8);
        return;
    L25:
        if (r3 != 1) goto L28;
        r0[0].subscribe(r8);
        return;
    L28:
        new a(r8, r3).a(r0);
        return;
    L17:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        EmptyDisposable.error(th, r8);
        return;
    L20:
        r3 = r0.length;
        goto L21
    }
}
