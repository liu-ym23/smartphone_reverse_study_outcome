package io.reactivex;

import ec.a;
import io.reactivex.disposables.b;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.observers.LambdaObserver;
import io.reactivex.internal.operators.observable.ObservableInterval;
import io.reactivex.internal.operators.observable.ObservableSubscribeOn;
import java.util.concurrent.TimeUnit;
import xb.e;
import xb.n;
import xb.o;
import xb.p;
import zb.g;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Observable<T> implements n<T> {
    public Observable() {
    }

    public static int a() {
        return e.a();
    }

    public static Observable<Long> b(long r10, long r11, TimeUnit r12) {
        return c(r10, r11, r12, a.a());
    }

    public static Observable<Long> c(long r10, long r11, TimeUnit r12, p r13) {
        io.reactivex.internal.functions.a.d(r12, "unit is null");
        io.reactivex.internal.functions.a.d(r13, "scheduler is null");
        return dc.a.k(new ObservableInterval(Math.max(0, r10), Math.max(0, r11), r12, r13));
    }

    public final b d(g<? super T> r10) {
        return e(r10, Functions.f9489d, Functions.f9487b, Functions.a());
    }

    public final b e(g<? super T> r10, g<? super Throwable> r11, zb.a r12, g<? super b> r13) {
        io.reactivex.internal.functions.a.d(r10, "onNext is null");
        io.reactivex.internal.functions.a.d(r11, "onError is null");
        io.reactivex.internal.functions.a.d(r12, "onComplete is null");
        io.reactivex.internal.functions.a.d(r13, "onSubscribe is null");
        LambdaObserver r14 = new LambdaObserver(r10, r11, r12, r13);
        subscribe(r14);
        return r14;
    }

    protected abstract void f(o<? super T> r10);

    public final Observable<T> g(p r10) {
        io.reactivex.internal.functions.a.d(r10, "scheduler is null");
        return dc.a.k(new ObservableSubscribeOn(this, r10));
    }

    @Override // xb.n
    public final void subscribe(o<? super T> r10) {
        io.reactivex.internal.functions.a.d(r10, "observer is null");
        o<? super T> r11 = dc.a.t(this, r10);     // Catch: Throwable -> L5 NullPointerException -> L8
        io.reactivex.internal.functions.a.d(r11, "The RxJavaPlugins.onSubscribe hook returned a null Observer. Please change the handler provided to RxJavaPlugins.setOnObservableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");     // Catch: Throwable -> L5 NullPointerException -> L8
        f(r11);     // Catch: Throwable -> L5 NullPointerException -> L8
        return;
    L8:
        e = move-exception;
        throw e;
    L5:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        dc.a.n(th);
        NullPointerException r12 = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
        r12.initCause(th);
        throw r12;
    }
}
