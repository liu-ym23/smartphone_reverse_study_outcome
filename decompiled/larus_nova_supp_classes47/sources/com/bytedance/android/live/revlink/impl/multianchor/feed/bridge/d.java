package com.bytedance.android.live.revlink.impl.multianchor.feed.bridge;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ c a;

    public d(c r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        Long r6 = (Long) r5;
        Long r7 = (Long) this.a.j.getValue();
        if (r7 == null) goto L5;
        long r0 = r7.longValue();
    L6:
        this.a.p.setValue(String.valueOf(r0 + 1));
        return;
    L5:
        r0 = 0;
        goto L6
    }
}
