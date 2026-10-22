package com.bytedance.android.live.revlink.impl.multianchor.service;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revlink.impl.multianchor.utils.z;
import com.bytedance.android.livesdk.link.model.r;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class l<T> implements Consumer {
    public final /* synthetic */ RevLinkPreloadService a;
    public final /* synthetic */ long b;
    public final /* synthetic */ long c;
    public final /* synthetic */ String d;

    public l(RevLinkPreloadService r1, long r2, long r4, String r6) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
        this.d = r6;
    }

    public final void accept(Object r9) {
        ExtraResponse<r, Extra> r10 = (ExtraResponse) r9;
        RevLinkPreloadService r0 = this.a;
        i97.a r1 = i97.a.a;
        r0.r = System.currentTimeMillis() - this.b;
        RevLinkPreloadService r2 = this.a;
        r2.l = false;
        r2.c = r10;
        z r3 = com.bytedance.android.live.revlink.impl.global.b.J();
        if (r3 == null) goto L5;
        long r4 = this.c;
        String r6 = this.d;
        int r5 = z.f;
        r3.o(1, r4, r10, "", r6, null);
    L5:
        RevLinkPreloadService r7 = this.a;
        h.c r8 = r7.j;
        if (r8 == null) goto L9;
        r8.b(r7.r, r7.p, r10, false);
        RevLinkPreloadService r12 = this.a;
        r12.c = null;
        r12.p = 0;
        r12.r = 0;
        return;
    }
}
