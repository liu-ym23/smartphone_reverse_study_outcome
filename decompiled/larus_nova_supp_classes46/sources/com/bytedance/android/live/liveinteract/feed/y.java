package com.bytedance.android.live.liveinteract.feed;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class y implements com.bytedance.android.live.liveinteract.plantform.commonwindow.g {
    public final /* synthetic */ MultiLinkVoiceChatFeedView a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.g
    public final void b(com.bytedance.android.live.liveinteract.plantform.commonwindow.h r4) {
        Intrinsics.checkNotNullParameter(r4, "request");
        f2.g();
        if (vm2.d.T0() == true) goto L5;
        return;
    L5:
        if (r4.a == 21) goto L9;
        ALogger.i("VoiceChatFeedView", "loadLayoutConfigFailed try to load 1v8, uiLayout=" + r4.a + ", traceInfo=" + r4.c.a);
        this.a.updateSeiVerAndUiLayout(21, 3);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.g
    public final void a(com.bytedance.android.live.liveinteract.plantform.commonwindow.h r4, com.bytedance.android.live.liveinteract.plantform.commonwindow.i r5) {
        Intrinsics.checkNotNullParameter(r4, "request");
        Intrinsics.checkNotNullParameter(r5, "response");
        MultiLinkVoiceChatFeedView r6 = this.a;
        r6.O(r6.j, r5.a);
        MultiLinkVoiceChatFeedView r7 = this.a;
        int r0 = this.b;
        int r1 = this.c;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r8 = r5.a;
        int r2 = r7.y1;
        r7.y(r0, r1, r8);
    }

    public y(MultiLinkVoiceChatFeedView r1, int r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
