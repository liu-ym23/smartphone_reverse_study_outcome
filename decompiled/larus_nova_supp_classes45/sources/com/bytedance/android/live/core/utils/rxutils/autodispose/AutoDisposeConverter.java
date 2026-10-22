package com.bytedance.android.live.core.utils.rxutils.autodispose;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface AutoDisposeConverter<T> extends io.reactivex.e<T, v<T>>, io.reactivex.p<T, ObservableSubscribeProxy<T>>, io.reactivex.i<T, MaybeSubscribeProxy<T>>, io.reactivex.r<T, SingleSubscribeProxy<T>>, io.reactivex.a<u> {
    /* synthetic */ Object apply(Completable r1);

    /* synthetic */ Object apply(Flowable r1);

    /* synthetic */ Object apply(Maybe r1);

    /* synthetic */ Object apply(Observable r1);

    /* synthetic */ Object apply(Single r1);

    /* synthetic */ Object apply(wtc.a r1);
}
