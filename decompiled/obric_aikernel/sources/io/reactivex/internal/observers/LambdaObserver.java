package io.reactivex.internal.observers;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.Functions;
import java.util.concurrent.atomic.AtomicReference;
import xb.o;
import zb.g;

/* JADX INFO: loaded from: classes2.dex */
public final class LambdaObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements o<T>, io.reactivex.disposables.b {
    private static final long serialVersionUID = -7251123623727029452L;
    final zb.a onComplete;
    final g<? super Throwable> onError;
    final g<? super T> onNext;
    final g<? super io.reactivex.disposables.b> onSubscribe;

    public LambdaObserver(g<? super T> r10, g<? super Throwable> r11, zb.a r12, g<? super io.reactivex.disposables.b> r13) {
        this.onNext = r10;
        this.onError = r11;
        this.onComplete = r12;
        this.onSubscribe = r13;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean hasCustomOnError() {
        if (this.onError == Functions.f9489d) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        if (get() != DisposableHelper.DISPOSED) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // xb.o
    public void onComplete() {
        if (isDisposed() == true) goto L12;
        lazySet(DisposableHelper.DISPOSED);
        this.onComplete.run();     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        dc.a.n(th);
        return;
    }

    @Override // xb.o
    public void onError(Throwable r10) {
        if (isDisposed() == true) goto L9;
        lazySet(DisposableHelper.DISPOSED);
        this.onError.accept(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        dc.a.n(new CompositeException(new Throwable[]{r10, th}));
        return;
    L9:
        dc.a.n(r10);
    }

    @Override // xb.o
    public void onNext(T r10) {
        if (isDisposed() == true) goto L11;
        this.onNext.accept(r10);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        get().dispose();
        onError(th);
        return;
    }

    @Override // xb.o
    public void onSubscribe(io.reactivex.disposables.b r10) {
        if (DisposableHelper.setOnce(this, r10) == false) goto L11;
        this.onSubscribe.accept(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        r10.dispose();
        onError(th);
        return;
    }
}
