package io.reactivex.internal.operators.mixed;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicReference;
import mt.u;
import pt.o;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements u, Disposable {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ObservableSwitchMapCompletable$SwitchMapCompletableObserver$SwitchMapInnerObserver f17687h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final mt.b f17688a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o f17689b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f17690c;
    public final AtomicThrowable d;
    public final AtomicReference e;
    public volatile boolean f;
    public Disposable g;

    static {
        f17687h = new ObservableSwitchMapCompletable$SwitchMapCompletableObserver$SwitchMapInnerObserver(null);
    }

    public d(mt.b r5, o r10, boolean r11) {
        this.f17688a = r5;
        this.f17689b = r10;
        this.f17690c = r11;
        this.d = new AtomicThrowable();
        this.e = new AtomicReference();
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        this.g.dispose();
        AtomicReference r5 = this.e;
        ObservableSwitchMapCompletable$SwitchMapCompletableObserver$SwitchMapInnerObserver r10 = f17687h;
        ObservableSwitchMapCompletable$SwitchMapCompletableObserver$SwitchMapInnerObserver r11 = (ObservableSwitchMapCompletable$SwitchMapCompletableObserver$SwitchMapInnerObserver) r5.getAndSet(r10);
        if (r11 == null) goto L7;
        if (r11 == r10) goto L8;
        r11.dispose();
        return;
    L8:
        return;
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        if (this.e.get() != f17687h) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // mt.u
    public final void onComplete() {
        this.f = true;
        if (this.e.get() != null) goto L9;
        Throwable r5 = this.d.terminate();
        if (r5 != null) goto L7;
        this.f17688a.onComplete();
        return;
    L7:
        this.f17688a.onError(r5);
        return;
    }

    @Override // mt.u
    public final void onError(Throwable r5) {
        AtomicThrowable r10 = this.d;
        if (r10.addThrowable(r5) == true) goto L5;
        wn.f.k(r5);
        return;
    L5:
        if (this.f17690c == false) goto L7;
        onComplete();
        return;
    L7:
        AtomicReference r11 = this.e;
        ObservableSwitchMapCompletable$SwitchMapCompletableObserver$SwitchMapInnerObserver r12 = f17687h;
        ObservableSwitchMapCompletable$SwitchMapCompletableObserver$SwitchMapInnerObserver r13 = (ObservableSwitchMapCompletable$SwitchMapCompletableObserver$SwitchMapInnerObserver) r11.getAndSet(r12);
        if (r13 == null) goto L11;
        if (r13 == r12) goto L11;
        r13.dispose();
    L11:
        Throwable r14 = r10.terminate();
        if (r14 == io.reactivex.internal.util.d.f18173a) goto L17;
        this.f17688a.onError(r14);
        return;
    }

    @Override // mt.u
    public final void onNext(Object r5) {
        Object r10 = this.f17689b.apply(r5);     // Catch: Throwable -> L16
        io.reactivex.internal.functions.e.d(r10, "The mapper returned a null CompletableSource");     // Catch: Throwable -> L16
        mt.c r11 = (mt.c) r10;     // Catch: Throwable -> L16
        ObservableSwitchMapCompletable$SwitchMapCompletableObserver$SwitchMapInnerObserver r12 = new ObservableSwitchMapCompletable$SwitchMapCompletableObserver$SwitchMapInnerObserver(this);
    L4:
        AtomicReference r13 = this.e;
        ObservableSwitchMapCompletable$SwitchMapCompletableObserver$SwitchMapInnerObserver r14 = (ObservableSwitchMapCompletable$SwitchMapCompletableObserver$SwitchMapInnerObserver) r13.get();
        if (r14 == f17687h) goto L25;
    L8:
        if (r13.compareAndSet(r14, r12) == true) goto L9;
        if (r13.get() == r14) goto L8;
    L9:
        if (r14 == null) goto L11;
        r14.dispose();
    L11:
        ((mt.a) r11).b(r12);
        return;
    L25:
        return;
    L16:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.g.dispose();
        onError(th);
    }

    @Override // mt.u
    public final void onSubscribe(Disposable r5) {
        if (DisposableHelper.validate(this.g, r5) == false) goto L6;
        this.g = r5;
        this.f17688a.onSubscribe(this);
        return;
    }
}
