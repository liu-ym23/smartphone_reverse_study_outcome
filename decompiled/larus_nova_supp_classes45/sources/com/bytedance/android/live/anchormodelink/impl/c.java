package com.bytedance.android.live.anchormodelink.impl;

import com.bytedance.kmp.live.livelink.api.multilink.monitor.LinkMonitor;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ AnchorModeLinkDynamicWidget a;
    public final /* synthetic */ long b;

    public c(AnchorModeLinkDynamicWidget r1, long r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r8) {
        Throwable r9 = (Throwable) r8;
        LinkMonitor.a(this.a.a, "finish failed, use time: " + (System.currentTimeMillis() - this.b), null, null, null, false, 124);
    }
}
