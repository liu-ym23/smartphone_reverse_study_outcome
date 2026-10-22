package com.bytedance.android.live.core.utils.rxutils;

import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Maybe;
import io.reactivex.MaybeSource;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class CommonLifecycleTransformer<T> implements ObservableTransformer<T, T>, io.reactivex.t<T, T>, io.reactivex.n<T, T>, io.reactivex.d {
    private CompositeDisposable compositeDisposable;

    public static /* synthetic */ void a(CommonLifecycleTransformer r0, Disposable r1) {
        r0.lambda$apply$3(r1);
    }

    public static /* synthetic */ void b(CommonLifecycleTransformer r0, Disposable r1) {
        r0.lambda$apply$1(r1);
    }

    public static /* synthetic */ void c(CommonLifecycleTransformer r0, Disposable r1) {
        r0.lambda$apply$2(r1);
    }

    public static /* synthetic */ void d(CommonLifecycleTransformer r0, Disposable r1) {
        r0.lambda$apply$0(r1);
    }

    public CommonLifecycleTransformer(CompositeDisposable r1) {
        this.compositeDisposable = r1;
    }

    private /* synthetic */ void lambda$apply$0(Disposable r2) throws Exception {
        this.compositeDisposable.add(r2);
    }

    private /* synthetic */ void lambda$apply$1(Disposable r2) throws Exception {
        this.compositeDisposable.add(r2);
    }

    private /* synthetic */ void lambda$apply$2(Disposable r2) throws Exception {
        this.compositeDisposable.add(r2);
    }

    private /* synthetic */ void lambda$apply$3(Disposable r2) throws Exception {
        this.compositeDisposable.add(r2);
    }

    public CompletableSource apply(Completable r2) {
        return r2.doOnSubscribe(new a(this));
    }

    public MaybeSource<T> apply(Maybe<T> r2) {
        return r2.doOnSubscribe(new d(this));
    }

    public ObservableSource<T> apply(Observable<T> r2) {
        return r2.doOnSubscribe(new b(this));
    }

    public SingleSource<T> apply(Single<T> r2) {
        return r2.doOnSubscribe(new c(this));
    }
}
