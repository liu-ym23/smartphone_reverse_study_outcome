package com.bytedance.android.live.revlink.impl.multianchor.network;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revlink.impl.monitor.LiveFullLinkPKMonitor;
import com.bytedance.android.live.revlink.impl.multianchor.utils.z;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class i<T> implements Consumer {
    public final /* synthetic */ j a;
    public final /* synthetic */ long b;

    public i(j r1, long r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r10) {
        Throwable r12 = (Throwable) r10;
        LiveFullLinkPKMonitor r0 = com.bytedance.android.live.revlink.impl.global.b.q();
        if (r0 == null) goto L5;
        LiveFullLinkPKMonitor.r(r0, "linkmic/change_multi_pk_team", r12, System.currentTimeMillis() - this.b, 0, 0, null, 56);
    L5:
        z r1 = com.bytedance.android.live.revlink.impl.global.b.J();
        if (r1 == null) goto L12;
        com.bytedance.android.live.revlink.impl.multianchor.vm.g r2 = com.bytedance.android.live.revlink.impl.global.b.u();
        if (r2 == null) goto L10;
        long r3 = r2.a();
    L11:
        r1.n(r3, r12);
        goto L12
    L10:
        r3 = 0;
    L12:
        com.bytedance.android.live.revenue.common.k.a(s1.getContext(), r12);
        c r13 = this.a.c;
        if (r13 == null) goto L16;
        r13.onRequestChangeMultiTeamFailed();
        return;
    }
}
