package com.bytedance.android.live.revlink.impl.multianchor.network;

import com.bytedance.android.livesdk.link.model.p;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class l implements m {
    public final /* synthetic */ k a;

    @Override // com.bytedance.android.live.revlink.impl.multianchor.network.m
    public final void onSuccess() {
        k r0 = this.a;
        r0.getClass();
        com.bytedance.android.live.revlink.impl.service.internal.a r1 = com.bytedance.android.live.revlink.impl.global.b.n();
        if (r1 != null) goto L5;
    L13:
        i11.b r2 = r0.b;
        if (r2 == null) goto L22;
        List<p> r3 = r2.getOnlineUserList();
        if (r3 != null) goto L18;
        return;
    L18:
        if ((!r3.isEmpty()) != true) goto L24;
        jy0.b.f("ttlive_anchor_link_panel", "intercept link fetchLinkList", null, 4);
        r0.d.b(7, null);
        return;
    L24:
        return;
    L22:
        return;
    L5:
        if (r1.k0(4) != true) goto L13;
        i11.b r4 = r0.c;
        if (r4 == null) goto L13;
        List<p> r5 = r4.getOnlineUserList();
        if (r5 == null) goto L13;
        if ((!r5.isEmpty()) != true) goto L13;
        jy0.b.f("ttlive_anchor_link_panel", "intercept pk fetchLinkList", null, 4);
        r0.e.a(1, null);
    }

    public l(k r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.network.m
    public final void onFailed(int r2) {
        d r0 = this.a.f;
        if (r0 == null) goto L6;
        r0.onInitPageFailed(r2);
        return;
    }
}
