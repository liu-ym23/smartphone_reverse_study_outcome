package com.bytedance.android.live.profit.lottery;

import com.bytedance.android.live.base.exception.ApiException;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f0<T, R> implements Function {
    public static final f0 a = null;

    static {
        a = new f0();
    }

    public f0() {
    }

    public final Object apply(Object r3) {
        ApiException r4 = (Throwable) r3;
        Intrinsics.checkNotNullParameter(r4, "t");
        v.c r0 = v.a;
        if ((r4 instanceof ApiException) == true) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L11;
        return Observable.just(sh6.a.a);
    L11:
        return Observable.error(r4);
    L5:
        if (r4.getErrorCode() != 43913) goto L7;
        r1 = true;
        goto L8
    }
}
