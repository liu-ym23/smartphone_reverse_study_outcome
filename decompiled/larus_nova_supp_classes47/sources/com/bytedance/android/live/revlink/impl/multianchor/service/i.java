package com.bytedance.android.live.revlink.impl.multianchor.service;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class i<T> implements Consumer {
    public final /* synthetic */ long a;

    public i(long r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        ((Number) r3).longValue();
        RevLinkLayoutPreloadContext r4 = RevLinkLayoutPreloadContext.Companion.getContext(Long.valueOf(this.a));
        if (r4 == null) goto L10;
        com.bytedance.live.datacontext.j<f> r5 = r4.getService();
        if (r5 == null) goto L11;
        f r6 = (f) r5.getValue();
        if (r6 == null) goto L12;
        r6.d("timer");
        return;
    L12:
        return;
    L11:
        return;
    }
}
