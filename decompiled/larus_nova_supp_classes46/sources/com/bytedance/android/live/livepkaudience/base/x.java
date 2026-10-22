package com.bytedance.android.live.livepkaudience.base;

import com.bytedance.android.live.liveinteract.api.MultiLinkOpenSource;
import com.bytedance.android.livesdk.chatroom.interact.model.LinkInviteResult;
import com.bytedance.android.livesdk.message.model.xe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class x implements g {
    public x() {
    }

    @Override // com.bytedance.android.live.livepkaudience.base.g
    public final void Em(xe r2) {
        Intrinsics.checkNotNullParameter(r2, MultiLinkOpenSource.MESSAGE);
    }

    @Override // com.bytedance.android.live.livepkaudience.base.g
    public final void L2(String r1, Throwable r2) {
        Intrinsics.checkNotNullParameter(r1, "uid");
    }

    @Override // com.bytedance.android.live.livepkaudience.base.g
    public void V6(String r2, LinkInviteResult r3) {
        Intrinsics.checkNotNullParameter(r2, "uid");
        Intrinsics.checkNotNullParameter(r3, "result");
    }

    @Override // com.bytedance.android.live.livepkaudience.base.g
    public final void c7(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "uid");
    }

    @Override // com.bytedance.android.live.livepkaudience.base.g
    public final void k5(String r1, Throwable r2) {
        Intrinsics.checkNotNullParameter(r1, "uid");
    }

    @Override // com.bytedance.android.live.livepkaudience.base.g
    public void l(String r1, Throwable r2) {
        Intrinsics.checkNotNullParameter(r1, "uid");
    }

    @Override // com.bytedance.android.live.livepkaudience.base.g
    public final void l0(Throwable r1) {
    }

    @Override // com.bytedance.android.live.livepkaudience.base.g
    public final void nm(xe r2) {
        Intrinsics.checkNotNullParameter(r2, MultiLinkOpenSource.MESSAGE);
    }

    @Override // com.bytedance.android.live.livepkaudience.base.g
    public void onPermitSuccess(String r2) {
        Intrinsics.checkNotNullParameter(r2, "uid");
    }

    @Override // com.bytedance.android.live.livepkaudience.base.g
    public final void u0() {
    }
}
