package io.reactivex.internal.operators.observable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.b.g;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.s;
import io.reactivex.t;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class ObservablePublish<T> extends io.reactivex.c.a<T> implements c<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final s<T> f16961a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final AtomicReference<a<T>> f16962b;
    final s<T> c;

    static final class InnerDisposable<T> extends AtomicReference<Object> implements io.reactivex.disposables.b {
        private static final long serialVersionUID = -1100270633763673112L;
        final t<? super T> child;

        InnerDisposable(t<? super T> r3) {
            this.child = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            Object r0 = getAndSet(this);
            if (r0 == null) goto L7;
            if (r0 == this) goto L8;
            ((a) ZeusTransformUtils.preCheckCast(r0, a.class, "com.obric.memorydata.plugin")).a(this);
            return;
        L8:
            return;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            if (get() != this) goto L5;
            return true;
        L5:
            return false;
        }

        void setParent(a<T> r2) {
            if (compareAndSet(null, r2) == true) goto L6;
            r2.a(this);
            return;
        }
    }

    static final class a<T> implements io.reactivex.disposables.b, t<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final InnerDisposable[] f16963b = null;
        static final InnerDisposable[] c = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final AtomicReference<a<T>> f16964a;
        final AtomicReference<InnerDisposable<T>[]> d;
        final AtomicBoolean e;
        final AtomicReference<io.reactivex.disposables.b> f;

        static {
            f16963b = new InnerDisposable[0];
            c = new InnerDisposable[0];
        }

        a(AtomicReference<a<T>> r3) {
            this.f = new AtomicReference();
            this.d = new AtomicReference(f16963b);
            this.f16964a = r3;
            this.e = new AtomicBoolean();
        }

        void a(InnerDisposable<T> r7) {
        L2:
            InnerDisposable<T>[] r0 = (InnerDisposable[]) ZeusTransformUtils.preCheckCast(this.d.get(), InnerDisposable[].class, "com.obric.memorydata.plugin");
            int r1 = r0.length;
            if (r1 == 0) goto L4;
            int r2 = -1;
            int r4 = 0;
        L6:
            if (r4 >= r1) goto L11;
            if (r0[r4].equals(r7) == true) goto L9;
            r4 = r4 + 1;
            goto L6
        L9:
            r2 = r4;
        L11:
            if (r2 < 0) goto L12;
            if (r1 != 1) goto L16;
            InnerDisposable<T>[] r3 = f16963b;
        L18:
            if (this.d.compareAndSet(r0, r3) == false) goto L2;
            return;
        L16:
            InnerDisposable<T>[] r5 = new InnerDisposable[r1 - 1];
            System.arraycopy(r0, 0, r5, 0, r2);
            System.arraycopy(r0, r2 + 1, r5, r2, (r1 - r2) - 1);
            r3 = r5;
            goto L18
        L12:
            return;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            AtomicReference<InnerDisposable<T>[]> r0 = this.d;
            InnerDisposable<T>[] r1 = c;
            if (((InnerDisposable[]) ZeusTransformUtils.preCheckCast(r0.getAndSet(r1), InnerDisposable[].class, "com.obric.memorydata.plugin")) == r1) goto L6;
            this.f16964a.compareAndSet(this, null);
            DisposableHelper.dispose(this.f);
            return;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            if (this.d.get() != c) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // io.reactivex.t
        public void onComplete() {
            this.f16964a.compareAndSet(this, null);
            InnerDisposable[] r3 = (InnerDisposable[]) ZeusTransformUtils.preCheckCast(this.d.getAndSet(c), InnerDisposable[].class, "com.obric.memorydata.plugin");
            int r0 = r3.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            r3[r1].child.onComplete();
            r1 = r1 + 1;
            goto L3
        }

        @Override // io.reactivex.t
        public void onError(Throwable r4) {
            this.f16964a.compareAndSet(this, null);
            InnerDisposable[] r3 = (InnerDisposable[]) ZeusTransformUtils.preCheckCast(this.d.getAndSet(c), InnerDisposable[].class, "com.obric.memorydata.plugin");
            if (r3.length == 0) goto L7;
            int r0 = r3.length;
            int r1 = 0;
        L5:
            if (r1 >= r0) goto L10;
            r3[r1].child.onError(r4);
            r1 = r1 + 1;
            goto L5
        L10:
            return;
        L7:
            io.reactivex.d.a.a(r4);
        }

        @Override // io.reactivex.t
        public void onNext(T r4) {
            InnerDisposable[] r3 = (InnerDisposable[]) ZeusTransformUtils.preCheckCast(this.d.get(), InnerDisposable[].class, "com.obric.memorydata.plugin");
            int r0 = r3.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            r3[r1].child.onNext(r4);
            r1 = r1 + 1;
            goto L3
        }

        @Override // io.reactivex.t
        public void onSubscribe(io.reactivex.disposables.b r3) {
            io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
            DisposableHelper.setOnce(this.f, r4);
        }
    }

    @Override // io.reactivex.c.a
    public void a(g<? super io.reactivex.disposables.b> r5) {
        g r6 = (g) ZeusTransformUtils.wrapperContextForParams(r5, g.class, "com.obric.memorydata.plugin");
    L3:
        a<T> r0 = (a) ZeusTransformUtils.preCheckCast(this.f16962b.get(), a.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L6;
    L7:
        a<T> r2 = new a(this.f16962b);
        if (this.f16962b.compareAndSet(r0, r2) == false) goto L3;
        r0 = r2;
    L11:
        boolean r3 = true;
        if (r0.e.get() == false) goto L14;
    L16:
        r3 = false;
    L24:
        r6.accept(r0);     // Catch: Throwable -> L21
        if (r3 == false) goto L29;
        this.f16961a.subscribe(r0);
        return;
    L29:
        return;
    L21:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        throw ExceptionHelper.a(th);
    L14:
        if (r0.e.compareAndSet(false, true) == false) goto L16;
    L6:
        if (r0.isDisposed() == false) goto L11;
        goto L7
    }

    @Override // io.reactivex.Observable
    public void a(t<? super T> r3) {
        t<? super T> r4 = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
        this.c.subscribe(r4);
    }
}
