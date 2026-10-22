package com.bytedance.android.live.core.utils.rxutils.autodispose;

import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class r implements io.reactivex.b, Disposable {
    public final AtomicReference<Disposable> a;
    public final AtomicReference<Disposable> b;
    public final CompletableSource c;
    public final io.reactivex.b d;

    public class a extends io.reactivex.observers.b {
        public final /* synthetic */ r b;

        public final void onComplete() {
            this.b.b.lazySet(AutoDisposableHelper.DISPOSED);
            AutoDisposableHelper.dispose(this.b.a);
        }

        public a(r r1) {
            this.b = r1;
        }

        public final void onError(Throwable r3) {
            this.b.b.lazySet(AutoDisposableHelper.DISPOSED);
            this.b.onError(r3);
        }
    }

    public final void dispose() {
        AutoDisposableHelper.dispose(this.b);
        AutoDisposableHelper.dispose(this.a);
    }

    public final boolean isDisposed() {
        if (this.a.get() != AutoDisposableHelper.DISPOSED) goto L5;
        return true;
    L5:
        return false;
    }

    public final void onComplete() {
        if (isDisposed() == true) goto L6;
        this.a.lazySet(AutoDisposableHelper.DISPOSED);
        AutoDisposableHelper.dispose(this.b);
        this.d.onComplete();
        return;
    }

    public final void onError(Throwable r3) {
        if (isDisposed() == true) goto L6;
        this.a.lazySet(AutoDisposableHelper.DISPOSED);
        AutoDisposableHelper.dispose(this.b);
        this.d.onError(r3);
        return;
    }

    public final void onSubscribe(Disposable r4) {
        a r0 = new a(this);
        if (l.b(this.b, r0, r.class) == false) goto L6;
        this.d.onSubscribe(this);
        this.c.subscribe(r0);
        l.b(this.a, r4, r.class);
        return;
    }

    public r(CompletableSource r2, io.reactivex.b r3) {
        this.a = new AtomicReference();
        this.b = new AtomicReference();
        this.c = r2;
        this.d = r3;
    }
}
