package com.bytedance.android.live.revenue.platform.room.impl;

import com.bytedance.android.live.core.utils.rxutils.RxCompatKt;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f<T, R> implements Function {
    public final /* synthetic */ Class a;
    public final /* synthetic */ String b;

    public f(Class r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object apply(Object r2) {
        sh6.b r3 = (sh6.b) r2;
        Intrinsics.checkNotNullParameter(r3, "optional");
        wlc.c r4 = (wlc.c) sh6.c.b(r3);
        if (r4 != null) goto L7;
        Observable<tlc.d> r5 = BaseRoomMessageService.j;
        if (r5 == null) goto L9;
        return r5;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type io.reactivex.Observable<T>");
    L7:
        return RxCompatKt.c(Observable.create(new e(this, r4)));
    }
}
