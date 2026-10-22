package com.bytedance.android.live.revenue.common;

import io.reactivex.Observable;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class PropertyOwnersKt {
    public static final Object a(com.bytedance.revenue.platform.api.core.rx.n r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$valueNullable");
        Intrinsics.checkNotNullParameter(r1, "$this$valueNullable");
        return sh6.c.b((sh6.b) r1.d);
    }

    public static final <T> com.bytedance.revenue.platform.api.core.rx.n<T> b(T r2) {
        Intrinsics.checkNotNullParameter(r2, "initialValue");
        return new com.bytedance.revenue.platform.api.core.rx.n(r2, PropertyOwnersKt$propertyOwner$1.INSTANCE);
    }

    public static final <T> Observable<T> c(final com.bytedance.revenue.platform.api.core.rx.m<T> r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$withLatest");
        com.bytedance.revenue.platform.api.core.rx.l r0 = com.bytedance.revenue.platform.api.core.rx.l.a;
        final Function0<Observable<T>> r2 = new PropertyOwnersKt$withLatest$1(r1);
        return Observable.defer(new a0(r2));
    }
}
