package com.bytedance.android.live.liveinteract.plantform.core;

import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class p<T> implements Consumer {
    public final /* synthetic */ long a;

    public p(long r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        long r0 = System.currentTimeMillis() - this.a;
        InteractLinkFullLinkMonitor.w("live_end", r0, (Throwable) r5);
    }
}
