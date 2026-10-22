package com.bytedance.android.ec.core.rxjava;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    @SchedulerSupport("io.reactivex:computation")
    @CheckReturnValue
    public static Observable<Long> a(long r10, long r11, TimeUnit r12) {
        return b(r10, r11, r12, Schedulers.computation());
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public static Observable<Long> b(long r10, long r11, TimeUnit r12, Scheduler r13) {
        ObjectHelper.requireNonNull(r12, "unit is null");
        ObjectHelper.requireNonNull(r13, "scheduler is null");
        return RxJavaPlugins.onAssembly(new ECObservableInterval(Math.max(0, r10), Math.max(0, r11), r12, r13));
    }
}
