package io.reactivex.internal.operators.mixed;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.Observable;
import io.reactivex.b.h;
import io.reactivex.c;
import io.reactivex.disposables.b;
import io.reactivex.e;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.t;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class ObservableSwitchMapCompletable<T> extends io.reactivex.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Observable<T> f16908a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h<? super T, ? extends e> f16909b;
    final boolean c;

    static final class SwitchMapCompletableObserver<T> implements b, t<T> {
        static final SwitchMapInnerObserver f = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final c f16910a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final h<? super T, ? extends e> f16911b;
        final boolean c;
        final AtomicThrowable d;
        final AtomicReference<SwitchMapInnerObserver> e;
        volatile boolean g;
        b h;

        static final class SwitchMapInnerObserver extends AtomicReference<b> implements c {
            private static final long serialVersionUID = -8003404460084760287L;
            final SwitchMapCompletableObserver<?> parent;

            SwitchMapInnerObserver(SwitchMapCompletableObserver<?> r1) {
                this.parent = r1;
            }

            void dispose() {
                DisposableHelper.dispose(this);
            }

            @Override // io.reactivex.c
            public void onComplete() {
                this.parent.a(this);
            }

            @Override // io.reactivex.c
            public void onError(Throwable r2) {
                this.parent.a(this, r2);
            }

            @Override // io.reactivex.c
            public void onSubscribe(b r3) {
                DisposableHelper.setOnce(this, (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin"));
            }
        }

        static {
            f = new SwitchMapInnerObserver(null);
        }

        SwitchMapCompletableObserver(c r3, h<? super T, ? extends e> r4, boolean r5) {
            c r6 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
            h<? super T, ? extends e> r7 = (h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.memorydata.plugin");
            this.f16910a = r6;
            this.f16911b = r7;
            this.c = r5;
            this.d = new AtomicThrowable();
            this.e = new AtomicReference();
        }

        void a() {
            AtomicReference<SwitchMapInnerObserver> r3 = this.e;
            SwitchMapInnerObserver r0 = f;
            SwitchMapInnerObserver r4 = (SwitchMapInnerObserver) ZeusTransformUtils.preCheckCast(r3.getAndSet(r0), SwitchMapInnerObserver.class, "com.obric.memorydata.plugin");
            if (r4 == null) goto L7;
            if (r4 == r0) goto L8;
            r4.dispose();
            return;
        L8:
            return;
        }

        void a(SwitchMapInnerObserver r3) {
            if (this.e.compareAndSet(r3, null) == true) goto L5;
            return;
        L5:
            if (this.g == false) goto L12;
            Throwable r4 = this.d.terminate();
            c r2 = this.f16910a;
            if (r4 != null) goto L9;
            r2.onComplete();
            return;
        L9:
            r2.onError(r4);
            return;
        }

        void a(SwitchMapInnerObserver r3, Throwable r4) {
            if (this.e.compareAndSet(r3, null) == true) goto L5;
        L15:
            io.reactivex.d.a.a(r4);
            return;
        L5:
            if (this.d.addThrowable(r4) == false) goto L15;
            if (this.c == true) goto L9;
            dispose();
            Throwable r5 = this.d.terminate();
            if (r5 == ExceptionHelper.f17150a) goto L18;
        L13:
            this.f16910a.onError(r5);
            return;
        L18:
            return;
        L9:
            if (this.g == false) goto L17;
            r5 = this.d.terminate();
            goto L13
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.h.dispose();
            a();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            if (this.e.get() != f) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // io.reactivex.t
        public void onComplete() {
            this.g = true;
            if (this.e.get() != null) goto L9;
            Throwable r0 = this.d.terminate();
            c r1 = this.f16910a;
            if (r0 != null) goto L7;
            r1.onComplete();
            return;
        L7:
            r1.onError(r0);
            return;
        }

        @Override // io.reactivex.t
        public void onError(Throwable r2) {
            if (this.d.addThrowable(r2) == true) goto L5;
            io.reactivex.d.a.a(r2);
            return;
        L5:
            if (this.c == false) goto L7;
            onComplete();
            return;
        L7:
            a();
            Throwable r3 = this.d.terminate();
            if (r3 == ExceptionHelper.f17150a) goto L13;
            this.f16910a.onError(r3);
            return;
        }

        @Override // io.reactivex.t
        public void onNext(T r5) {
            e r6 = (e) ZeusTransformUtils.preCheckCast(io.reactivex.internal.functions.a.a(this.f16911b.apply(r5), "The mapper returned a null CompletableSource"), e.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
            SwitchMapInnerObserver r1 = new SwitchMapInnerObserver(this);
        L5:
            SwitchMapInnerObserver r2 = (SwitchMapInnerObserver) ZeusTransformUtils.preCheckCast(this.e.get(), SwitchMapInnerObserver.class, "com.obric.memorydata.plugin");
            if (r2 == f) goto L22;
            if (this.e.compareAndSet(r2, r1) == false) goto L5;
            if (r2 == null) goto L12;
            r2.dispose();
        L12:
            r6.a(r1);
            return;
        L22:
            return;
        L14:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            this.h.dispose();
            onError(th);
        }

        @Override // io.reactivex.t
        public void onSubscribe(b r3) {
            b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
            if (DisposableHelper.validate(this.h, r4) == false) goto L6;
            this.h = r4;
            this.f16910a.onSubscribe(this);
            return;
        }
    }

    @Override // io.reactivex.a
    public void b(c r4) {
        c r5 = (c) ZeusTransformUtils.wrapperContextForParams(r4, c.class, "com.obric.memorydata.plugin");
        if (a.a(this.f16908a, this.f16909b, r5) == true) goto L6;
        this.f16908a.subscribe(new SwitchMapCompletableObserver(r5, this.f16909b, this.c));
        return;
    }
}
