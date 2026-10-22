package com.bytedance.android.ec.core.utils;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a1 {
    public static final /* synthetic */ int a = 0;

    public static final class a extends Observable<Object> {
        public a() {
        }

        public final void subscribeActual(Observer<? super Object> r10) {
            Intrinsics.checkNotNullParameter(r10, "observer");
            r10.onSubscribe(EmptyDisposable.NEVER);
        }
    }

    static {
        new a();
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public static Observable a(long r10, long r11, TimeUnit r12, Scheduler r13) {
        Intrinsics.checkNotNullParameter(r12, "unit");
        Intrinsics.checkNotNullParameter(r13, "scheduler");
        ObjectHelper.requireNonNull(r12, "unit is null");
        ObjectHelper.requireNonNull(r13, "scheduler is null");
        return RxJavaPlugins.onAssembly(new ObservableInterval(Math.max(0, r10), Math.max(0, r11), r12, r13));
    }
}
