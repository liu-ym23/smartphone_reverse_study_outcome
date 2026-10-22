package com.bytedance.android.live.liveinteract.plantform.core;

import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class o<T> implements Consumer {
    public final /* synthetic */ long a;

    public o(long r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        InteractLinkFullLinkMonitor.x("live_end", System.currentTimeMillis() - this.a, ((com.bytedance.android.live.network.response.e) r5).logId);
    }
}
