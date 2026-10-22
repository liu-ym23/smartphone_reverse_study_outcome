package com.bytedance.android.ec.core.utils;

import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class ObservableInterval extends Observable<Long> {
    public final Scheduler a;
    public final long b;
    public final long c;
    public final TimeUnit d;

    public static final class IntervalObserver extends AtomicReference<Disposable> implements Disposable, Runnable {
        private static final long serialVersionUID = 346773832286157679L;
        long count;
        final Observer<? super Long> downstream;

        @Override // java.lang.Runnable
        public void run() {
            com_bytedance_android_ec_core_utils_ObservableInterval$IntervalObserver_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_bytedance_android_ec_core_utils_ObservableInterval$IntervalObserver__run$___twin___() {
            if (get() == DisposableHelper.DISPOSED) goto L6;
            Observer<? super Long> r0 = this.downstream;
            long r1 = this.count;
            this.count = 1 + r1;
            r0.onNext(Long.valueOf(r1));
            return;
        }

        public boolean isDisposed() {
            if (get() != DisposableHelper.DISPOSED) goto L5;
            return true;
        L5:
            return false;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public IntervalObserver(Observer<? super Long> r1) {
            this.downstream = r1;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_bytedance_android_ec_core_utils_ObservableInterval$IntervalObserver_com_larus_apm_impl_protector_RunnableLancet_run(IntervalObserver r1) {
            r1.com_bytedance_android_ec_core_utils_ObservableInterval$IntervalObserver__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public void setResource(Disposable r1) {
            DisposableHelper.setOnce(this, r1);
        }
    }

    public final void subscribeActual(Observer<? super Long> r10) {
        IntervalObserver r11 = new IntervalObserver(r10);
        r10.onSubscribe(r11);
        Scheduler r0 = this.a;
        if ((r0 instanceof io.reactivex.internal.schedulers.k) == false) goto L5;
        Scheduler.Worker r1 = r0.createWorker();
        r11.setResource(r1);
        r1.schedulePeriodically(r11, this.b, this.c, this.d);
        return;
    L5:
        r11.setResource(r0.schedulePeriodicallyDirect(r11, this.b, this.c, this.d));
    }

    public ObservableInterval(long r1, long r10, TimeUnit r11, Scheduler r12) {
        this.b = r1;
        this.c = r10;
        this.d = r11;
        this.a = r12;
    }
}
