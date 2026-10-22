package com.bytedance.android.live.core.utils.rxutils;

import android.os.Handler;
import android.os.Looper;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.MaybeSource;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.schedulers.Schedulers;
import org.reactivestreams.Publisher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h<T> implements CommonTransformer<T> {
    public static final q80.a a = null;

    public h() {
    }

    static {
        a = new q80.a(new Handler(Looper.getMainLooper()), true);
    }

    @Override // com.bytedance.android.live.core.utils.rxutils.CommonTransformer
    public final CompletableSource apply(Completable r2) {
        return r2.subscribeOn(Schedulers.io()).observeOn(a);
    }

    @Override // com.bytedance.android.live.core.utils.rxutils.CommonTransformer
    public final MaybeSource<T> apply(Maybe<T> r2) {
        return r2.subscribeOn(Schedulers.io()).observeOn(a);
    }

    public final ObservableSource<T> apply(Observable<T> r2) {
        return r2.subscribeOn(Schedulers.io()).observeOn(a);
    }

    @Override // com.bytedance.android.live.core.utils.rxutils.CommonTransformer
    public final SingleSource<T> apply(Single<T> r2) {
        return r2.subscribeOn(Schedulers.io()).observeOn(a);
    }

    @Override // com.bytedance.android.live.core.utils.rxutils.CommonTransformer
    public final Publisher<T> apply(Flowable<T> r2) {
        return r2.subscribeOn(Schedulers.io()).observeOn(a);
    }
}
