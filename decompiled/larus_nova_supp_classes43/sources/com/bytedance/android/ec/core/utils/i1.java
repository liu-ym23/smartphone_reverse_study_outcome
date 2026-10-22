package com.bytedance.android.ec.core.utils;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.internal.functions.Functions;
import io.reactivex.plugins.RxJavaPlugins;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class i1 {
    @SchedulerSupport("none")
    @CheckReturnValue
    public static final Observable b(Observable r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$retryCompat");
        return RxJavaPlugins.onAssembly(new ObservableRetryPredicate(r10, Functions.alwaysTrue()));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static final <T, R> Observable<R> a(Observable<T> r1, Function1<? super T, ? extends ObservableSource<R>> r10) {
        Intrinsics.checkNotNullParameter(r1, "$this$concatMapCompat");
        Intrinsics.checkNotNullParameter(r10, "mapper");
        return r1.concatMap(new h1(r10), 2);
    }
}
