package com.bytedance.android.live.revlink.impl.multianchor.service;

import com.bytedance.android.live.revlink.impl.multianchor.utils.v;
import com.bytedance.android.live.revlink.impl.utils.t;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class k<T> implements Consumer {
    public final /* synthetic */ RevLinkPreloadService a;
    public final /* synthetic */ long b;
    public final /* synthetic */ long c;

    public k(RevLinkPreloadService r1, long r2, long r4) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
    }

    public final void accept(Object r9) {
        Throwable r10 = (Throwable) r9;
        v r0 = com.bytedance.android.live.revlink.impl.global.b.C();
        if (r0 == null) goto L5;
        r0.z(7, this.b, "revlink_preload", t.a(this.c), r10);
    L5:
        this.a.k = false;
        jy0.b.c("ttlive_anchor_link_users_v2", r10.toString(), null, 4);
        h.b r12 = this.a.i;
        if (r12 == null) goto L9;
        r12.a();
        return;
    }
}
