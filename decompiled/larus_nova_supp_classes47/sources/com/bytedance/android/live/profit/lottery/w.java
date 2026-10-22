package com.bytedance.android.live.profit.lottery;

import com.bytedance.android.live.network.response.ExtraResponse;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class w<T, R> implements Function {
    public static final w a = null;

    static {
        a = new w();
    }

    public w() {
    }

    public final Object apply(Object r4) {
        ExtraResponse r5 = (ExtraResponse) r4;
        Intrinsics.checkNotNullParameter(r5, "res");
        v.c r0 = v.a;
        com.bytedance.android.live.profit.lottery.model.a r6 = (com.bytedance.android.live.profit.lottery.model.a) r5.data;
        int r1 = r6.a();
        if (r1 != 1) goto L5;
        ParticipateStatus r2 = ParticipateStatus.NOTPARTICIPATED;
    L12:
        s r3 = new s(r2, r6.b());
        if (r3.a == ParticipateStatus.UNKNOWN) goto L16;
        return r3;
    L16:
        throw new Throwable("unknown");
    L5:
        if (r1 != 2) goto L7;
        r2 = ParticipateStatus.PARTICIPATEINSUCCESS;
        goto L12
    L7:
        if (r1 == 3) goto L9;
        r2 = ParticipateStatus.UNKNOWN;
        goto L12
    L9:
        r2 = ParticipateStatus.ISLUCKY;
        goto L12
    }
}
