package com.bytedance.android.live.profit.redpacket;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class s0<T> implements Predicate {
    public static final s0 a = null;

    static {
        a = new s0();
    }

    public s0() {
    }

    public final boolean test(Object r2) {
        k1 r3 = (k1) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        return !(r3.c instanceof RedPacketState.Waiting);
    }
}
