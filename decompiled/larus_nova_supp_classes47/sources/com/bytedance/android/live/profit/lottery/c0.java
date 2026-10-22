package com.bytedance.android.live.profit.lottery;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c0<T> implements Consumer {
    public static final c0 a = null;

    static {
        a = new c0();
    }

    public c0() {
    }

    public final void accept(Object r2) {
        k r3 = ((v.a) r2).b.getLotteryInfo();
        if (r3 != null) goto L5;
    L7:
        boolean r4 = false;
    L8:
        if (r4 == false) goto L11;
        return;
    L11:
        throw new IllegalStateException("lottery is not finished".toString());
    L5:
        if (r3.getStatus() != 2) goto L7;
        r4 = true;
        goto L8
    }
}
