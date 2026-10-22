package com.bytedance.android.live.livelink.multilink.media;

import com.bytedance.android.live.livelink.multilink.pipeline.LinkPipelineManager;
import com.bytedance.kmp.live.livelink.api.multilink.monitor.LinkMonitor;
import io.reactivex.functions.Consumer;
import yb6.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ LinkMediaManager a;
    public final /* synthetic */ m b;

    public b(LinkMediaManager r1, LinkPipelineManager.l r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r14) {
        Long r15 = (Long) r14;
        this.a.v0().c = false;
        this.a.w0().H(this.a.d, -1, -12301, new Exception("start rtc time out"));
        LinkMonitor.a("LinkMediaM", "start rtc time out", null, null, LinkMonitor.LogLevel.ERROR, false, 108);
    }
}
