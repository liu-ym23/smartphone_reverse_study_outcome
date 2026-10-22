package com.bytedance.android.live.core.utils.rxutils;

import com.bytedance.android.livesdkapi.util.JavaCalls;
import io.reactivex.Observable;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.observable.ObservableRetryWhen;
import io.reactivex.plugins.RxJavaPlugins;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class RxCompatKt {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(RxCompatKt$shareOpt$2.INSTANCE);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static final <T> f<T> a(Observable<T> r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$publishCompat");
        return new f((Observable) JavaCalls.callStaticMethodOrThrow("io.reactivex.internal.operators.observable.ObservablePublish", "create", new Object[]{r3}));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static final <T> Observable<T> c(Observable<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$shareCompat");
        if (tb1.c.a == false) goto L9;
        if (((Boolean) a.getValue()).booleanValue() == false) goto L9;
        return r2.share();
    L9:
        return (Observable) JavaCalls.callMethodOrThrow(a(r2).a, "refCount", new Object[0]);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static final Observable b(Observable r1, l r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$retryWhenCompat");
        Intrinsics.checkNotNullParameter(r2, "handler");
        ObjectHelper.requireNonNull(r2, "handler is null");
        return RxJavaPlugins.onAssembly(new ObservableRetryWhen(r1, r2));
    }
}
