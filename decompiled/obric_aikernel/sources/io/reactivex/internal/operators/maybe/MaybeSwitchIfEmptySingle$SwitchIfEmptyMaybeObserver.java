package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import xb.j;
import xb.r;
import xb.s;

/* JADX INFO: loaded from: classes2.dex */
final class MaybeSwitchIfEmptySingle$SwitchIfEmptyMaybeObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements j<T>, io.reactivex.disposables.b {
    private static final long serialVersionUID = 4603919676453758899L;
    final r<? super T> downstream;
    final s<? extends T> other;

    static final class a<T> implements r<T> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final r<? super T> f9537c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final AtomicReference<io.reactivex.disposables.b> f9538g;

        a(r<? super T> r10, AtomicReference<io.reactivex.disposables.b> r11) {
            this.f9537c = r10;
            this.f9538g = r11;
        }

        @Override // xb.r
        public void onError(Throwable r10) {
            this.f9537c.onError(r10);
        }

        @Override // xb.r
        public void onSubscribe(io.reactivex.disposables.b r10) {
            DisposableHelper.setOnce(this.f9538g, r10);
        }

        @Override // xb.r
        public void onSuccess(T r10) {
            this.f9537c.onSuccess(r10);
        }
    }

    MaybeSwitchIfEmptySingle$SwitchIfEmptyMaybeObserver(r<? super T> r10, s<? extends T> r11) {
        this.downstream = r10;
        this.other = r11;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // xb.j
    public void onComplete() {
        io.reactivex.disposables.b r10 = get();
        if (r10 != DisposableHelper.DISPOSED) goto L5;
        return;
    L5:
        if (compareAndSet(r10, null) == false) goto L9;
        this.other.a(new a(this.downstream, this));
        return;
    }

    @Override // xb.j
    public void onError(Throwable r10) {
        this.downstream.onError(r10);
    }

    @Override // xb.j
    public void onSubscribe(io.reactivex.disposables.b r10) {
        if (DisposableHelper.setOnce(this, r10) == false) goto L6;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // xb.j
    public void onSuccess(T r10) {
        this.downstream.onSuccess(r10);
    }
}
