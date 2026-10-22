package io.reactivex.internal.operators.observable;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes3.dex */
public final class l4 extends mt.n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Callable f17856a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final pt.o f17857b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final pt.g f17858c;
    public final boolean d;

    public l4(Callable r5, pt.o r10, pt.g r11, boolean r12) {
        this.f17856a = r5;
        this.f17857b = r10;
        this.f17858c = r11;
        this.d = r12;
    }

    @Override // mt.n
    public final void subscribeActual(mt.u r5) {
        pt.g r10 = this.f17858c;
        Object r11 = this.f17856a.call();     // Catch: Throwable -> L15
        Object r12 = this.f17857b.apply(r11);     // Catch: Throwable -> L7
        io.reactivex.internal.functions.e.d(r12, "The sourceSupplier returned a null ObservableSource");     // Catch: Throwable -> L7
        mt.s r13 = (mt.s) r12;     // Catch: Throwable -> L7
        r13.subscribe(new ObservableUsing$UsingObserver(r5, r11, r10, this.d));
        return;
    L7:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        r10.accept(r11);     // Catch: Throwable -> L12
        EmptyDisposable.error(th, r5);
        return;
    L12:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        EmptyDisposable.error(new CompositeException(new Throwable[]{th, th}), r5);
        return;
    L15:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        EmptyDisposable.error(th, r5);
    }
}
