package io.reactivex.internal.operators.mixed;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import mt.j;
import mt.s;
import mt.u;
import pt.o;

/* JADX INFO: loaded from: classes3.dex */
final class MaybeFlatMapObservable$FlatMapObserver<T, R> extends AtomicReference<Disposable> implements u, j, Disposable {
    private static final long serialVersionUID = -8948264376121066672L;
    final u downstream;
    final o mapper;

    public MaybeFlatMapObservable$FlatMapObserver(u r5, o r10) {
        this.downstream = r5;
        this.mapper = r10;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // mt.u
    public void onComplete() {
        this.downstream.onComplete();
    }

    @Override // mt.u
    public void onError(Throwable r5) {
        this.downstream.onError(r5);
    }

    @Override // mt.u
    public void onNext(R r5) {
        this.downstream.onNext(r5);
    }

    @Override // mt.u
    public void onSubscribe(Disposable r5) {
        DisposableHelper.replace(this, r5);
    }

    @Override // mt.j
    public void onSuccess(T r5) {
        Object r10 = this.mapper.apply(r5);     // Catch: Throwable -> L5
        io.reactivex.internal.functions.e.d(r10, "The mapper returned a null Publisher");     // Catch: Throwable -> L5
        ((s) r10).subscribe(this);
        return;
    L5:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.downstream.onError(th);
    }
}
