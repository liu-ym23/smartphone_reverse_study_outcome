package com.bytedance.android.live.liveinteract.feedv2.feedview;

import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j implements com.bytedance.android.live.liveinteract.plantform.commonwindow.g {
    public final /* synthetic */ MultiLinkCommonVoiceFeedPreview a;

    public j(MultiLinkCommonVoiceFeedPreview r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.g
    public final void b(com.bytedance.android.live.liveinteract.plantform.commonwindow.h r3) {
        Intrinsics.checkNotNullParameter(r3, "request");
        ALogger.e("MultiLinkCommonVoiceFeedPreview", "adjustMicSeat loadLayoutConfig failed, " + r3.c.a);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.g
    public final void a(com.bytedance.android.live.liveinteract.plantform.commonwindow.h r2, com.bytedance.android.live.liveinteract.plantform.commonwindow.i r3) {
        Intrinsics.checkNotNullParameter(r2, "request");
        Intrinsics.checkNotNullParameter(r3, "response");
        MultiLinkCommonVoiceFeedPreview r4 = this.a;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r5 = r3.a;
        int r0 = MultiLinkCommonVoiceFeedPreview.h2;
        r4.d0(r5);
    }
}
