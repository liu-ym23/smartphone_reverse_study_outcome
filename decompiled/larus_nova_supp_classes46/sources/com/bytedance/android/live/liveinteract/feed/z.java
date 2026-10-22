package com.bytedance.android.live.liveinteract.feed;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.BaseLinkSeatWindowView;
import com.bytedance.android.livesdkapi.feed.IPreviewPlayerContainerAbility;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class z implements com.bytedance.android.live.liveinteract.plantform.commonwindow.k {
    public final /* synthetic */ MultiLinkVoiceChatFeedView a;
    public final /* synthetic */ int b;

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.k
    public final void onFailed() {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.k
    public final void a(com.bytedance.android.live.liveinteract.plantform.commonwindow.m r4) {
        Intrinsics.checkNotNullParameter(r4, "layoutConfigV1");
        r4.toString();
        BaseLinkSeatWindowView r0 = this.a.getBaseWindowView();
        if (r0 == null) goto L5;
        r0.U3(r4, MultiLinkVoiceChatFeedView.h(this.a), MultiLinkVoiceChatFeedView.f(this.a));
    L5:
        com.bytedance.android.live.liveinteract.plantform.datamerge.k r1 = new com.bytedance.android.live.liveinteract.plantform.datamerge.k(this.b);
        com.bytedance.android.live.liveinteract.feed.datamerge.i r2 = this.a.u;
        if (r2 == null) goto L8;
        r2.A(r1, r4);
    L8:
        IPreviewPlayerContainerAbility r3 = this.a.G;
        if (r3 == null) goto L13;
        Integer r5 = r3.getWidth();
        if (r5 == null) goto L13;
        int r6 = r5.intValue();
    L14:
        IPreviewPlayerContainerAbility r7 = this.a.G;
        if (r7 == null) goto L19;
        Integer r8 = r7.getHeight();
        if (r8 == null) goto L19;
        int r9 = r8.intValue();
    L20:
        MultiLinkVoiceChatFeedView r10 = this.a;
        r10.D = r10.A(r4, r6, r9);
        return;
    L19:
        r9 = s1.w();
    L13:
        r6 = s1.y();
        goto L14
    }

    public z(MultiLinkVoiceChatFeedView r1, int r2) {
        this.a = r1;
        this.b = r2;
    }
}
