package com.bytedance.android.live.liveinteract.feedv2.feedview;

import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c implements com.bytedance.android.live.liveinteract.plantform.commonwindow.g {
    public final /* synthetic */ MultiLinkCommonVideoFeedPreview a;

    public c(MultiLinkCommonVideoFeedPreview r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.g
    public final void b(com.bytedance.android.live.liveinteract.plantform.commonwindow.h r3) {
        Intrinsics.checkNotNullParameter(r3, "request");
        ALogger.e("CommonVideoFeedPreview", "adjustMicSeat loadLayoutConfig failed, " + r3.c.a);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.g
    public final void a(com.bytedance.android.live.liveinteract.plantform.commonwindow.h r2, com.bytedance.android.live.liveinteract.plantform.commonwindow.i r3) {
        Intrinsics.checkNotNullParameter(r2, "request");
        Intrinsics.checkNotNullParameter(r3, "response");
        this.a.F(r3.a);
    }
}
