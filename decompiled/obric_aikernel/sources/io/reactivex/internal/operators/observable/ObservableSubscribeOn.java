package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class ObservableSubscribeOn<T> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final xb.p f9554g;

    static final class SubscribeOnObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements xb.o<T>, io.reactivex.disposables.b {
        private static final long serialVersionUID = 8094547886072529208L;
        final xb.o<? super T> downstream;
        final AtomicReference<io.reactivex.disposables.b> upstream;

        SubscribeOnObserver(xb.o<? super T> r10) {
            this.downstream = r10;
            this.upstream = new AtomicReference();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this.upstream);
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // xb.o
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // xb.o
        public void onError(Throwable r10) {
            this.downstream.onError(r10);
        }

        @Override // xb.o
        public void onNext(T r10) {
            this.downstream.onNext(r10);
        }

        @Override // xb.o
        public void onSubscribe(io.reactivex.disposables.b r10) {
            DisposableHelper.setOnce(this.upstream, r10);
        }

        void setDisposable(io.reactivex.disposables.b r10) {
            DisposableHelper.setOnce(this, r10);
        }
    }

    final class a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final SubscribeOnObserver<T> f9555c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ ObservableSubscribeOn f9556g;

        a(ObservableSubscribeOn r10, SubscribeOnObserver<T> r11) {
            this.f9556g = r10;
            this.f9555c = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f9556g.f9558c.subscribe(this.f9555c);
        }
    }

    public ObservableSubscribeOn(xb.n<T> r10, xb.p r11) {
        super(r10);
        this.f9554g = r11;
    }

    @Override // io.reactivex.Observable
    public void f(xb.o<? super T> r10) {
        SubscribeOnObserver r11 = new SubscribeOnObserver(r10);
        r10.onSubscribe(r11);
        r11.setDisposable(this.f9554g.c(new a(this, r11)));
    }
}
