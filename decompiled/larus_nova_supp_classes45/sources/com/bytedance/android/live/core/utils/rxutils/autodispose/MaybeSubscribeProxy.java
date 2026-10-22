package com.bytedance.android.live.core.utils.rxutils.autodispose;

import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.TestObserver;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface MaybeSubscribeProxy<T> {
    Disposable subscribe();

    Disposable subscribe(Consumer<? super T> r1);

    Disposable subscribe(Consumer<? super T> r1, Consumer<? super Throwable> r2);

    Disposable subscribe(Consumer<? super T> r1, Consumer<? super Throwable> r2, Action r3);

    void subscribe(io.reactivex.k<? super T> r1);

    @CheckReturnValue
    <E extends io.reactivex.k<? super T>> E subscribeWith(E r1);

    @CheckReturnValue
    TestObserver<T> test();

    @CheckReturnValue
    TestObserver<T> test(boolean r1);
}
