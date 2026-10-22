package com.bytedance.android.live.anchormodelink.impl;

import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.kmp.live.livelink.api.multilink.monitor.LinkMonitor;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ AnchorModeLinkDynamicWidget a;
    public final /* synthetic */ long b;

    public b(AnchorModeLinkDynamicWidget r1, long r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r8) {
        ExtraResponse r9 = (ExtraResponse) r8;
        LinkMonitor.a(this.a.a, "finish success, use time: " + (System.currentTimeMillis() - this.b), null, null, null, false, 124);
    }
}
