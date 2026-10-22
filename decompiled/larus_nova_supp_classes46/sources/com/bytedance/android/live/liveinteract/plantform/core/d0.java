package com.bytedance.android.live.liveinteract.plantform.core;

import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d0<T> implements Consumer {
    public final /* synthetic */ y a;
    public final /* synthetic */ long b;

    public d0(y r1, long r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r5) {
        Throwable r6 = (Throwable) r5;
        if (r6 == null) goto L5;
        y.e(this.a, r6);
    L5:
        long r0 = this.b;
        InteractLinkFullLinkMonitor.w("optimize_first_enter_in_list", System.currentTimeMillis() - r0, r6);
    }
}
