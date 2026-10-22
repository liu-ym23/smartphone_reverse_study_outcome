package io.reactivex.internal.operators.completable;

import io.reactivex.disposables.b;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import xb.c;
import zb.h;

/* JADX INFO: loaded from: classes2.dex */
final class CompletableResumeNext$ResumeNextObserver extends AtomicReference<b> implements xb.b, b {
    private static final long serialVersionUID = 5018523762564524046L;
    final xb.b downstream;
    final h<? super Throwable, ? extends c> errorMapper;
    boolean once;

    CompletableResumeNext$ResumeNextObserver(xb.b r10, h<? super Throwable, ? extends c> r11) {
        this.downstream = r10;
        this.errorMapper = r11;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // xb.b
    public void onComplete() {
        this.downstream.onComplete();
    }

    @Override // xb.b
    public void onError(Throwable r10) {
        if (this.once == false) goto L6;
        this.downstream.onError(r10);
        return;
    L6:
        this.once = true;
        ((c) io.reactivex.internal.functions.a.d(this.errorMapper.apply(r10), "The errorMapper returned a null CompletableSource")).a(this);
        return;
    L10:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.downstream.onError(new CompositeException(new Throwable[]{r10, th}));
    }

    @Override // xb.b
    public void onSubscribe(b r10) {
        DisposableHelper.replace(this, r10);
    }
}
