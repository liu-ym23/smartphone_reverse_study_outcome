package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
public final class u2 implements mt.u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f17984a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference f17985b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final mt.u f17986c;

    public /* synthetic */ u2(mt.u r5, AtomicReference r10, int r11) {
        this.f17984a = r11;
        this.f17986c = r5;
        this.f17985b = r10;
    }

    @Override // mt.u
    public final void onComplete() {
        switch(this.f17984a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        this.f17986c.onComplete();
        return;
    L6:
        ((io.reactivex.subjects.d) this.f17986c).onComplete();
    }

    @Override // mt.u
    public final void onError(Throwable r5) {
        switch(this.f17984a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        this.f17986c.onError(r5);
        return;
    L6:
        ((io.reactivex.subjects.d) this.f17986c).onError(r5);
    }

    @Override // mt.u
    public final void onNext(Object r5) {
        switch(this.f17984a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        this.f17986c.onNext(r5);
        return;
    L6:
        ((io.reactivex.subjects.d) this.f17986c).onNext(r5);
    }

    @Override // mt.u
    public final void onSubscribe(Disposable r5) {
        switch(this.f17984a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        DisposableHelper.replace(this.f17985b, r5);
        return;
    L6:
        DisposableHelper.setOnce(this.f17985b, r5);
    }
}
