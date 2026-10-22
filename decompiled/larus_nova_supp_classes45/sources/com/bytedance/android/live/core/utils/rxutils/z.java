package com.bytedance.android.live.core.utils.rxutils;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class z<T> implements ObservableTransformer<T, y<T>> {
    public T a;

    public static final class a<T, R> implements Function {
        public final /* synthetic */ z a;

        public a(z r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final Object apply(Object r4) {
            z r1 = this.a;
            y r0 = new y(r1.a, r4);
            r1.a = r4;
            return r0;
        }
    }

    public z() {
    }

    public final ObservableSource<y<T>> apply(Observable<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "upstream");
        return r2.map(new a(this));
    }
}
