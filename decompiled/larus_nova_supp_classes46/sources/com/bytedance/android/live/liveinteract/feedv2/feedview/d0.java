package com.bytedance.android.live.liveinteract.feedv2.feedview;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.config.kb0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d0 implements com.bytedance.android.live.liveinteract.plantform.commonwindow.g {
    public final /* synthetic */ MultiLinkGameFeedPreview a;

    public d0(MultiLinkGameFeedPreview r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.g
    public final void b(com.bytedance.android.live.liveinteract.plantform.commonwindow.h r2) {
        Intrinsics.checkNotNullParameter(r2, "request");
        ALogger.e("MultiLinkGameFeedPreview", "tryAdjustWindowUI loadLayoutConfig onFailed");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.g
    public final void a(com.bytedance.android.live.liveinteract.plantform.commonwindow.h r2, com.bytedance.android.live.liveinteract.plantform.commonwindow.i r3) {
        Intrinsics.checkNotNullParameter(r2, "request");
        Intrinsics.checkNotNullParameter(r3, "response");
        ALogger.i("MultiLinkGameFeedPreview", "tryAdjustWindowUI loadLayoutConfig success");
        MultiLinkGameFeedPreview r4 = this.a;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r5 = r3.a;
        int r0 = MultiLinkCommonVideoFeedPreview.H;
        r4.F(r5);
        if (((Boolean) kb0.a.getValue()).booleanValue() == false) goto L11;
        this.a.A();
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r6 = this.a.getLayoutConfig();
        if (r6 == null) goto L7;
        this.a.G(null, r6);
    L7:
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.a r7 = this.a.getDynamicWidget();
        if (r7 == null) goto L12;
        r7.onViewHolderSelected();
        return;
    L12:
        return;
    }
}
