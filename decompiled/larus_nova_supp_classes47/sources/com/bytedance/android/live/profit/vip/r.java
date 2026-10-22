package com.bytedance.android.live.profit.vip;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class r<T> implements Consumer {
    public static final r a = null;

    static {
        a = new r();
    }

    public r() {
    }

    public final void accept(Object r3) {
        Throwable r4 = (Throwable) r3;
        int r0 = w51.a.a;
        StringBuilder r1 = new StringBuilder("reportVipRechargeStrategy failed: ");
        if (r4 == null) goto L5;
        String r5 = r4.getMessage();
    L6:
        r1.append(r5);
        w51.a.C0337a.a(r1.toString());
        return;
    L5:
        r5 = null;
        goto L6
    }
}
