package com.bytedance.android.live.livelink.multilink.pipeline;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.kmp.live.livelink.api.multilink.monitor.LinkMonitor;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e implements wb6.a.f {
    public e() {
    }

    public final void a(Throwable r9) {
        Intrinsics.checkNotNullParameter(r9, "throwable");
        LinkMonitor.a("PipeLineM", "startNotifyJoinRtc", "failed " + r9.getMessage(), null, LinkMonitor.LogLevel.ERROR, true, 40);
    }

    public final void b(long r9, ExtraResponse<Unit, Extra> r11) {
        Intrinsics.checkNotNullParameter(r11, "response");
        LinkMonitor.a("PipeLineM", "startNotifyJoinRtc", "success duration " + r9, null, null, true, 56);
    }
}
