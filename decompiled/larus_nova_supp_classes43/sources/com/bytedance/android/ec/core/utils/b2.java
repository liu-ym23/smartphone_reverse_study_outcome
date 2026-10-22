package com.bytedance.android.ec.core.utils;

import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b2 {

    public static final class a implements com.bytedance.android.ec.opt.asynctask.w {
        public final /* synthetic */ Function0 a;

        public final com.bytedance.android.ec.opt.asynctask.k r() {
            com.bytedance.android.ec.opt.asynctask.r r0 = new com.bytedance.android.ec.opt.asynctask.r();
            r0.b = true;
            return r0.f;
        }

        public final void run() {
            this.a.invoke();
        }

        public a(Function0 r1) {
            this.a = r1;
        }
    }

    public static final class b<V> implements Callable {
        public final /* synthetic */ Function0 a;

        public b(Function0 r1) {
            this.a = r1;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            call();
            return Unit.INSTANCE;
        }

        @Override // java.util.concurrent.Callable
        public final void call() {
            this.a.invoke();
        }
    }

    public static final class c<T> implements Consumer {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Unit r10 = (Unit) r1;
        }
    }

    public static final class d<T> implements Consumer {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r10 = (Throwable) r1;
        }
    }

    public static final void a(Function0<Unit> r1) {
        Intrinsics.checkNotNullParameter(r1, "action");
        com.bytedance.android.ec.opt.asynctask.t.b(new a(r1));
    }

    public static final Disposable b(Function0<Unit> r10) {
        Intrinsics.checkNotNullParameter(r10, "action");
        return Single.fromCallable(new b(r10)).subscribeOn(Schedulers.io()).subscribe(c.a, d.a);
    }
}
