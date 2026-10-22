package com.bytedance.android.live.anchormodelink.livelink;

import com.bytedance.kmp.live.livelink.api.multilink.monitor.LinkMonitor;
import io.reactivex.functions.Consumer;
import yb6.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ LiveLinkWrapper a;
    public final /* synthetic */ m b;

    public a(LiveLinkWrapper r1, d r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r8) {
        Long r9 = (Long) r8;
        this.a.g().c = false;
        this.a.h().H(this.a.d, -1, -12301, new Exception("start rtc time out"));
        LinkMonitor.a(this.a.a, "start rtc time out", null, null, LinkMonitor.LogLevel.ERROR, false, 108);
    }
}
