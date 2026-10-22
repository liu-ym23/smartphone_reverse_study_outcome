package com.bytedance.android.live.schema.api.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class OptimizeMainThreadScheduler {
    public static final Lazy a = null;

    public static final class a extends Scheduler.Worker {
        public volatile boolean a;
        public final Handler b;

        public final void dispose() {
            this.a = true;
            this.b.removeCallbacksAndMessages(this);
        }

        public final boolean isDisposed() {
            return this.a;
        }

        public a(Handler r2) {
            Intrinsics.checkNotNullParameter(r2, "handler");
            this.b = r2;
        }

        public final Disposable schedule(Runnable r4, long r5, TimeUnit r7) {
            Intrinsics.checkNotNullParameter(r4, "run");
            Intrinsics.checkNotNullParameter(r7, "unit");
            if (this.a == true) goto L5;
            Runnable r6 = RxJavaPlugins.onSchedule(r4);
            Lazy r0 = OptimizeMainThreadScheduler.a;
            if (Looper.myLooper() != Looper.getMainLooper()) goto L9;
            boolean r1 = true;
        L10:
            if (r1 == true) goto L12;
        L15:
            c r2 = new c(this.b, r6);
            Message r8 = Message.obtain(this.b, r2);
            r8.obj = this;
            this.b.sendMessageDelayed(r8, r7.toMillis(r5));
            if (this.a == false) goto L19;
            this.b.removeCallbacks(r2);
            return Disposables.disposed();
        L19:
            return r2;
        L12:
            if (r5 != 0) goto L15;
            r6.run();
            return Disposables.disposed();
        L9:
            r1 = false;
            goto L10
        L5:
            return Disposables.disposed();
        }
    }

    public static final class b extends Scheduler {
        public final Handler a;

        public b() {
            Handler r0 = new Handler(Looper.getMainLooper());
            Intrinsics.checkNotNullParameter(r0, "handler");
            this.a = r0;
        }

        public final Scheduler.Worker createWorker() {
            return new a(this.a);
        }

        public final Disposable scheduleDirect(Runnable r4, long r5, TimeUnit r7) {
            Intrinsics.checkNotNullParameter(r4, "run");
            Intrinsics.checkNotNullParameter(r7, "unit");
            Runnable r6 = RxJavaPlugins.onSchedule(r4);
            Lazy r0 = OptimizeMainThreadScheduler.a;
            if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
            boolean r1 = true;
        L6:
            if (r1 == true) goto L8;
        L11:
            c r2 = new c(this.a, r6);
            Message r8 = Message.obtain(this.a, r2);
            this.a.sendMessageDelayed(r8, r7.toMillis(r5));
            return r2;
        L8:
            if (r5 != 0) goto L11;
            r6.run();
            return Disposables.disposed();
        L5:
            r1 = false;
            goto L6
        }
    }

    public static final class c implements Runnable, Disposable {
        public volatile boolean a;
        public final Handler b;
        public final Runnable c;

        public final void dispose() {
            this.b.removeCallbacks(this);
            this.a = true;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.c.run();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            RxJavaPlugins.onError(th);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }

        public final boolean isDisposed() {
            return this.a;
        }

        public c(Handler r2, Runnable r3) {
            Intrinsics.checkNotNullParameter(r2, "handler");
            Intrinsics.checkNotNullParameter(r3, "delegate");
            this.b = r2;
            this.c = r3;
        }
    }

    public OptimizeMainThreadScheduler() {
    }

    static {
        a = LazyKt.lazy(OptimizeMainThreadScheduler$mainThread$2.INSTANCE);
    }
}
