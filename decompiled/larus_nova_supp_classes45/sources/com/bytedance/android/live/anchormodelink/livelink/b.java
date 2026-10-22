package com.bytedance.android.live.anchormodelink.livelink;

import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.kmp.live.livelink.api.multilink.monitor.LinkMonitor;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ ei6.a a;
    public final /* synthetic */ LiveLinkWrapper b;

    public b(ei6.a r1, LiveLinkWrapper r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r11) {
        Long r12 = (Long) r11;
        this.b.g().a("stop_time_out");
        long r7 = -12302;
        this.b.h().H(this.a, -2, r7, new Exception("stop_time_out"));
        LinkMonitor.a(this.b.a, "stop rtc time out", null, null, LinkMonitor.LogLevel.ERROR, false, 108);
        InteractLinkFullLinkMonitor.i0(r7, "stop rtc time out");
    }
}
