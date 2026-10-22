package com.bytedance.android.live.service.prerequest;

import io.reactivex.functions.Consumer;
import kc0.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ b a;

    public e(b r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Long r3 = (Long) r2;
        boolean r4 = com.bytedance.android.live.revenue.core.util.h.a;
        kc0.e r5 = com.bytedance.android.live.revenue.core.util.h.d(j.class).getRevLinkControlService();
        if (r5 == null) goto L6;
        r5.l(this.a.g);
        return;
    }
}
