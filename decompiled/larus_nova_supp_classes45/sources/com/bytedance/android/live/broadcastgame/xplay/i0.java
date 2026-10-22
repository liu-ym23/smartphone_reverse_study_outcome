package com.bytedance.android.live.broadcastgame.xplay;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i0<T, R> implements Function {
    public static final i0 a = null;

    static {
        a = new i0();
    }

    public i0() {
    }

    public final Object apply(Object r2) {
        c1 r3 = (c1) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        return r3.b.startWith(Float.valueOf(r3.a));
    }
}
