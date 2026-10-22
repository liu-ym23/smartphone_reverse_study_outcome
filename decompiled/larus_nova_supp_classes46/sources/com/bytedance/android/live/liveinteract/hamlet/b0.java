package com.bytedance.android.live.liveinteract.hamlet;

import io.reactivex.functions.BiFunction;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b0<T1, T2, R> implements BiFunction {
    public static final b0 a = null;

    static {
        a = new b0();
    }

    public b0() {
    }

    public final Object apply(Object r2, Object r3) {
        Boolean r4 = (Boolean) r2;
        Boolean r5 = (Boolean) r3;
        Intrinsics.checkNotNullParameter(r4, "xplyStartMessageRecived");
        Intrinsics.checkNotNullParameter(r5, "isRtcClientInitialized");
        if (r4.booleanValue() == true) goto L5;
    L7:
        boolean r6 = false;
    L9:
        return Boolean.valueOf(r6);
    L5:
        if (r5.booleanValue() == false) goto L7;
        r6 = true;
        goto L9
    }
}
