package com.bytedance.android.live.revlink.impl.multianchor.connect;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class l<T> implements Consumer {
    public final /* synthetic */ MultiAnchorRelinkService a;
    public final /* synthetic */ d11.o b;

    public l(MultiAnchorRelinkService r1, d11.o r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r12) {
        Long r13 = (Long) r12;
        jy0.b.c("ttlive_anchor_link_relink", "relink invite time out " + this.b, null, 4);
        RelinkBackendService r14 = this.a.c;
        if (r14 == null) goto L5;
        d11.o r0 = this.b;
        r14.switchChannelCancel(new d11.n(r0.a, r0.e, r0.d, r0.b, r0.c, "timeout"));
    L5:
        this.a.j("inviteTimeout", true);
    }
}
