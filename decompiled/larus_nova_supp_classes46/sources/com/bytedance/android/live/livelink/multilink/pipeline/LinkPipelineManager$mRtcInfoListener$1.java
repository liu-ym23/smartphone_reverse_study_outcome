package com.bytedance.android.live.livelink.multilink.pipeline;

import kotlin.jvm.internal.Intrinsics;
import yb6.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class LinkPipelineManager$mRtcInfoListener$1 implements o {
    public final /* synthetic */ LinkPipelineManager a;

    public LinkPipelineManager$mRtcInfoListener$1(LinkPipelineManager r1) {
        this.a = r1;
    }

    public final void Am(final ei6.a r9, final int r10, final long r11, final Exception r13) {
        com.bytedance.live.kmp.util.d.b(0, false, new LinkPipelineManager$mRtcInfoListener$1$onRtcError$1(this, r10, r11, r13, r9), 7);
    }

    public final void vc(final ei6.a r9, final int r10, final long r11, final Object... r13) {
        Intrinsics.checkNotNullParameter(r13, "params");
        com.bytedance.live.kmp.util.d.b(0, false, new LinkPipelineManager$mRtcInfoListener$1$onRtcInfo$1(this, r10, r13, r9, r11), 7);
    }
}
