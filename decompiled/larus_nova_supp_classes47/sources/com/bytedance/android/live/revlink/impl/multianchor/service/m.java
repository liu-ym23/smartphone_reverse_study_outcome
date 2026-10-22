package com.bytedance.android.live.revlink.impl.multianchor.service;

import com.bytedance.android.live.revlink.impl.multianchor.utils.z;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class m<T> implements Consumer {
    public final /* synthetic */ RevLinkPreloadService a;
    public final /* synthetic */ long b;
    public final /* synthetic */ String c;

    public m(RevLinkPreloadService r1, long r2, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
    }

    public final void accept(Object r9) {
        Throwable r7 = (Throwable) r9;
        this.a.l = false;
        z r0 = com.bytedance.android.live.revlink.impl.global.b.J();
        if (r0 == null) goto L5;
        r0.o(1, this.b, null, "", this.c, r7);
    L5:
        h.c r10 = this.a.j;
        if (r10 == null) goto L9;
        r10.a();
        return;
    }
}
