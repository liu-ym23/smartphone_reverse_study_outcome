package com.bytedance.android.live.livelink.multilink.pipeline;

import com.bytedance.android.livesdk.link.model.bridge.h1;
import com.bytedance.android.livesdk.link.model.bridge.z0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class LinkPipelineManager$mMsgListener$1 implements ac6.a.a {
    public final /* synthetic */ LinkPipelineManager a;

    public LinkPipelineManager$mMsgListener$1(LinkPipelineManager r1) {
        this.a = r1;
    }

    public final void A2(final z0 r5) {
        Intrinsics.checkNotNullParameter(r5, "msg");
        com.bytedance.live.kmp.util.d.b(0, true, new LinkPipelineManager$mMsgListener$1$onKickOutMsg$1(this, r5), 3);
    }

    public final void B2(final h1 r5) {
        Intrinsics.checkNotNullParameter(r5, "msg");
        com.bytedance.live.kmp.util.d.b(0, true, new LinkPipelineManager$mMsgListener$1$onMediaInfoChange$1(this, r5), 3);
    }

    public final void C2(z0 r3) {
        Intrinsics.checkNotNullParameter(r3, "msg");
        LinkPipelineManager r0 = this.a;
        r0.getClass();
        r0.w0(r3.getBizTag(), "finish msg");
    }

    public final void D2(z0 r3) {
        Intrinsics.checkNotNullParameter(r3, "msg");
        LinkPipelineManager r0 = this.a;
        r0.getClass();
        r0.w0(r3.getBizTag(), "switch scene msg");
    }

    public final void E2(z0 r3) {
        Intrinsics.checkNotNullParameter(r3, "msg");
        LinkPipelineManager r0 = this.a;
        r0.getClass();
        r0.w0(r3.getBizTag(), "turn on msg");
    }

    public final void F2(final h1 r5) {
        Intrinsics.checkNotNullParameter(r5, "msg");
        com.bytedance.live.kmp.util.d.b(0, true, new LinkPipelineManager$mMsgListener$1$onSysKickOutMsg$1(this, r5), 3);
    }

    public final void G2(final h1 r5) {
        Intrinsics.checkNotNullParameter(r5, "msg");
        com.bytedance.live.kmp.util.d.b(0, true, new LinkPipelineManager$mMsgListener$1$onPermitMsg$1(this, r5), 3);
    }

    public final void H2(final h1 r5) {
        Intrinsics.checkNotNullParameter(r5, "msg");
        com.bytedance.live.kmp.util.d.b(0, true, new LinkPipelineManager$mMsgListener$1$onRtcActionMsg$1(this, r5), 3);
    }

    public final void I2(final z0 r5) {
        Intrinsics.checkNotNullParameter(r5, "msg");
        com.bytedance.live.kmp.util.d.b(0, true, new LinkPipelineManager$mMsgListener$1$onAnchorOrAdminInviteMsg$1(this, r5), 3);
    }

    public final void J2(final z0 r5) {
        Intrinsics.checkNotNullParameter(r5, "msg");
        com.bytedance.live.kmp.util.d.b(0, true, new LinkPipelineManager$mMsgListener$1$onPermitMsg$2(this, r5), 3);
    }

    public final void y1(final z0 r5) {
        Intrinsics.checkNotNullParameter(r5, "msg");
        com.bytedance.live.kmp.util.d.b(0, true, new LinkPipelineManager$mMsgListener$1$onAdminFirstInviteMsg$1(this, r5), 3);
    }

    public final void z2(final z0 r5) {
        Intrinsics.checkNotNullParameter(r5, "msg");
        com.bytedance.live.kmp.util.d.b(0, true, new LinkPipelineManager$mMsgListener$1$onAudienceReplyMsg$1(this, r5), 3);
    }
}
