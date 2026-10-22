package com.bytedance.android.live.liveinteract.plantform.core;

import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c0<T> implements Consumer {
    public final /* synthetic */ long a;

    public c0(long r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        com.bytedance.android.live.network.response.e r6 = (com.bytedance.android.live.network.response.e) r5;
        long r0 = this.a;
        long r2 = System.currentTimeMillis() - r0;
        if (r6 == null) goto L6;
        String r7 = r6.logId;
        if (r7 == null) goto L6;
    L7:
        InteractLinkFullLinkMonitor.x("optimize_first_enter_in_list", r2, r7);
        return;
    L6:
        r7 = "";
        goto L7
    }
}
