package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes3.dex */
public final class p0 extends mt.n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f17903a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Callable f17904b;

    public /* synthetic */ p0(Callable r5, int r10) {
        this.f17903a = r10;
        this.f17904b = r5;
    }

    @Override // mt.n
    public final void subscribeActual(mt.u r5) {
        switch(this.f17903a) {
            case 0: goto L17;
            default: goto L15;
        };
    L15:
        Object r10 = this.f17904b.call();     // Catch: Throwable -> L6
        io.reactivex.internal.functions.e.d(r10, "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");     // Catch: Throwable -> L6
        th = (Throwable) r10;     // Catch: Throwable -> L6
    L8:
        EmptyDisposable.error(th, r5);
        return;
    L6:
        th = th;
        com.lynx.jsbridge.a.t(th);
        goto L8
    L17:
        Object r11 = this.f17904b.call();     // Catch: Throwable -> L12
        io.reactivex.internal.functions.e.d(r11, "null ObservableSource supplied");     // Catch: Throwable -> L12
        ((mt.s) r11).subscribe(r5);
        return;
    L12:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        EmptyDisposable.error(th, r5);
    }
}
