package com.bytedance.android.livesdk.interactivity.api.chatchannel.utils;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class p {

    public static final class a<T> implements Consumer {
        public final /* synthetic */ Function1 a;

        public a(Function1 r1) {
            this.a = r1;
        }

        public final void accept(T r2) {
            this.a.invoke(r2);
        }
    }

    public static final <T> Disposable a(com.bytedance.android.live.core.arch.mvvm.d<T> r1, Function1<? super T, Unit> r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$subscribeChangeWithNotify");
        Intrinsics.checkNotNullParameter(r2, "notify");
        r2.invoke(r1.getValue());
        return r1.subscribe(new a(r2));
    }
}
