package com.bytedance.android.live.liveinteract.feed;

import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d implements com.bytedance.android.live.liveinteract.plantform.commonwindow.g {
    public final /* synthetic */ CommonMultiLinkFeedView a;

    public d(CommonMultiLinkFeedView r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.g
    public final void b(com.bytedance.android.live.liveinteract.plantform.commonwindow.h r3) {
        Intrinsics.checkNotNullParameter(r3, "request");
        ALogger.e("CommonMultiLinkFeedView", "adjustMicSeat loadLayoutConfig failed, " + r3.c.a);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.g
    public final void a(com.bytedance.android.live.liveinteract.plantform.commonwindow.h r3, com.bytedance.android.live.liveinteract.plantform.commonwindow.i r4) {
        Intrinsics.checkNotNullParameter(r3, "request");
        Intrinsics.checkNotNullParameter(r4, "response");
        CommonMultiLinkFeedView r5 = this.a;
        r5.j(r5.getContainerWidth(), this.a.getContainerHeight(), r4.a);
    }
}
