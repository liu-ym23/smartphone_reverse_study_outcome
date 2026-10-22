package com.bytedance.android.live.core.arch.mvvm;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import java.util.concurrent.Callable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f {

    public static final class a<V> implements Callable {
        public final /* synthetic */ d a;

        public a(d r1) {
            this.a = r1;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }

        @Override // java.util.concurrent.Callable
        public final ObservableSource<? extends T> call() {
            d r0 = this.a;
            return r0.startWith(r0.getValue());
        }
    }

    public static final <T> T a(d<sh6.b<T>> r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$valueNullable");
        return (T) sh6.c.b(r1.getValue());
    }

    public static final <T> Observable<T> b(d<T> r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$withLatest");
        return Observable.defer(new a(r1));
    }
}
