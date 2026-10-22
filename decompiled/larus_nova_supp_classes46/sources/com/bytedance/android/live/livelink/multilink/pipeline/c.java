package com.bytedance.android.live.livelink.multilink.pipeline;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.chatroom.model.LinkFinishResult;
import com.bytedance.kmp.live.livelink.api.multilink.config.MultiLinkConfig;
import com.bytedance.kmp.live.livelink.api.multilink.monitor.LinkMonitor;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import xb6.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c implements wb6.a.b {
    public final /* synthetic */ MultiLinkConfig a;
    public final /* synthetic */ LinkPipelineManager b;

    public c(MultiLinkConfig r1, LinkPipelineManager r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void bp(long r9, ExtraResponse<LinkFinishResult, Extra> r11) {
        Intrinsics.checkNotNullParameter(r11, "response");
        LinkMonitor.a("PipeLineM", "startFinishReq", "onFinishSuccess duration " + r9, null, null, false, 120);
        Iterator r0 = this.a.k.iterator();
    L4:
        if (r0.hasNext() == false) goto L7;
        ((f) r0.next()).a.bp(r9, r11);
        goto L4
    L7:
        if (this.b.s.p() == false) goto L9;
        this.b.s.L("unMuteAudio");
    L9:
        this.b.N0("AnchorFinishSuccess");
    }

    public final void yp(long r9, Throwable r11) {
        Intrinsics.checkNotNullParameter(r11, "throwable");
        LinkMonitor.a("PipeLineM", "startFinishReq", "onFinishFailed", null, null, false, 120);
        this.b.v0().f(false, "finish failed");
        Iterator r0 = this.a.k.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((f) r0.next()).a.yp(r9, r11);
        goto L4
    }
}
