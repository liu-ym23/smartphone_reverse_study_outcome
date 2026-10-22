package com.bytedance.android.live.revlink.impl.multianchor.service;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.link.model.r;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class j<T> implements Consumer {
    public final /* synthetic */ RevLinkPreloadService a;
    public final /* synthetic */ long b;
    public final /* synthetic */ long c;
    public final /* synthetic */ long d;

    public j(RevLinkPreloadService r1, long r2, long r4, long r6) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
        this.d = r6;
    }

    public final void accept(Object r9) {
        ExtraResponse<r, Extra> r5 = (ExtraResponse) r9;
        StringBuilder r10 = new StringBuilder("preload linkmic/list success channelID: ");
        r10.append(this.b);
        r10.append(" roomID: ");
        r10.append(this.c);
        r10.append(" logId=");
        if (r5 == null) goto L5;
        String r0 = r5.logId;
    L6:
        r10.append(r0);
        jy0.b.c("MultiLinkPreloadWidget", r10.toString(), null, 4);
        RevLinkPreloadService r12 = this.a;
        i97.a r1 = i97.a.a;
        r12.q = System.currentTimeMillis() - this.d;
        RevLinkPreloadService r13 = this.a;
        r13.k = false;
        r13.b = r5;
        h.b r2 = r13.i;
        if (r2 == null) goto L10;
        r2.b(r13.q, r13.o, r5, false);
        RevLinkPreloadService r14 = this.a;
        r14.b = null;
        r14.o = 0;
        r14.q = 0;
        return;
    L10:
        return;
    L5:
        r0 = null;
        goto L6
    }
}
