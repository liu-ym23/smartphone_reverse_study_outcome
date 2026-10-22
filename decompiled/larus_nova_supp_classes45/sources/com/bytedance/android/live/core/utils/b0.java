package com.bytedance.android.live.core.utils;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b0 {

    public static final class a<T> implements Consumer {
        public final /* synthetic */ Function1 a;

        public a(Function1 r1) {
            this.a = r1;
        }

        public final void accept(T r2) {
            this.a.invoke(r2);
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ Function1 a;

        public b(Function1 r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            this.a.invoke(sh6.c.b((sh6.b) r2));
        }
    }

    public static final <T> Disposable a(com.bytedance.live.datacontext.m<T> r1, Function1<? super T, Unit> r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$subscribeChangeWithNotify");
        Intrinsics.checkNotNullParameter(r2, "notify");
        r2.invoke(r1.getValue());
        return r1.a().subscribe(new a(r2));
    }

    public static final <T> Disposable b(com.bytedance.live.datacontext.n<T> r1, Function1<? super T, Unit> r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$subscribeChangeWithNotify");
        Intrinsics.checkNotNullParameter(r2, "notify");
        r2.invoke(r1.getValue());
        return r1.a().subscribe(new b(r2));
    }
}
