package com.bytedance.android.live.revlink.impl.player;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class n<T> implements Consumer {
    public final /* synthetic */ j a;

    public n(j r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Integer r3 = (Integer) r2;
        j r4 = this.a;
        if (r4.l.i == true) goto L8;
        wq2.f r5 = r4.E();
        if (r5 == null) goto L9;
        r5.y6();
        return;
    L9:
        return;
    }
}
