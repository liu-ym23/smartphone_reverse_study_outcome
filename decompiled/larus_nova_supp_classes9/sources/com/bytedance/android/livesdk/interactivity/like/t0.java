package com.bytedance.android.livesdk.interactivity.like;

import com.bytedance.android.live.network.response.Response;
import io.reactivex.functions.BiFunction;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class t0<T1, T2, R> implements BiFunction {
    public static final t0 a = null;

    static {
        a = new t0();
    }

    public t0() {
    }

    public final Object apply(Object r2, Object r3) {
        Integer r4 = (Integer) r2;
        Response r5 = (Response) r3;
        Intrinsics.checkNotNullParameter(r4, "t1");
        Intrinsics.checkNotNullParameter(r5, "t2");
        return new Pair(r4, r5);
    }
}
