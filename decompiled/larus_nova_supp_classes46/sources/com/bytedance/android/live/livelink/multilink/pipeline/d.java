package com.bytedance.android.live.livelink.multilink.pipeline;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.chatroom.model.g1;
import com.bytedance.kmp.live.livelink.api.multilink.config.MultiLinkConfig;
import com.bytedance.kmp.live.livelink.api.multilink.monitor.LinkMonitor;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import xb6.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d implements wb6.a.e {
    public final /* synthetic */ MultiLinkConfig a;
    public final /* synthetic */ LinkPipelineManager b;

    public d(MultiLinkConfig r1, LinkPipelineManager r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void F2(long r9, Throwable r11) {
        Intrinsics.checkNotNullParameter(r11, "throwable");
        LinkMonitor.a("PipeLineM", "startLeaveChannelReq", "onLeaveFailed", null, null, false, 120);
        this.b.v0().f(false, "leave channel failed");
        Iterator r0 = this.a.k.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((f) r0.next()).a.F2(r9, r11);
        goto L4
    }

    public final void Xf(long r9, ExtraResponse<? extends g1, Extra> r11) {
        Intrinsics.checkNotNullParameter(r11, "response");
        LinkMonitor.a("PipeLineM", "startLeaveChannelReq", "leave channel success duration " + r9, null, null, false, 120);
        Iterator r0 = this.a.k.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((f) r0.next()).a.Xf(r9, r11);
        goto L4
    L6:
        this.b.N0("LeaveChannel");
    }
}
