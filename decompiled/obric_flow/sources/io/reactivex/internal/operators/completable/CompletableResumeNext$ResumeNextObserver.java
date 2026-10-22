package io.reactivex.internal.operators.completable;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.e;
import java.util.concurrent.atomic.AtomicReference;
import mt.b;
import mt.c;
import pt.o;

/* JADX INFO: loaded from: classes3.dex */
final class CompletableResumeNext$ResumeNextObserver extends AtomicReference<Disposable> implements b, Disposable {
    private static final long serialVersionUID = 5018523762564524046L;
    final b downstream;
    final o errorMapper;
    boolean once;

    public CompletableResumeNext$ResumeNextObserver(b r5, o r10) {
        this.downstream = r5;
        this.errorMapper = r10;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // mt.b
    public void onComplete() {
        this.downstream.onComplete();
    }

    @Override // mt.b
    public void onError(Throwable r5) {
        if (this.once == false) goto L6;
        this.downstream.onError(r5);
        return;
    L6:
        this.once = true;
        Object r10 = this.errorMapper.apply(r5);     // Catch: Throwable -> L10
        e.d(r10, "The errorMapper returned a null CompletableSource");     // Catch: Throwable -> L10
        ((mt.a) ((c) r10)).b(this);
        return;
    L10:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.downstream.onError(new CompositeException(new Throwable[]{r5, th}));
    }

    @Override // mt.b
    public void onSubscribe(Disposable r5) {
        DisposableHelper.replace(this, r5);
    }
}
