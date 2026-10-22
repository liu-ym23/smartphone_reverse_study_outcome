package com.bytedance.android.live.revenuelink.connect;

import com.bytedance.android.livesdk.link.model.bridge.h1;
import com.bytedance.android.livesdk.link.model.bridge.i1;
import com.bytedance.android.livesdk.link.model.i6;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class t implements com.bytedance.android.live.revenuelink.multimsg.c {
    public final /* synthetic */ LinkOutManager a;

    public t(LinkOutManager r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.revenuelink.multimsg.c
    public final void a(yh6.c r12, boolean r13) {
        if (r13 == true) goto L4;
        return;
    L4:
        if ((r12 instanceof h1) == false) goto L8;
        i6 r2 = ((vh7.c) r12).castTo(i6.class);
        MultiLinkServerMonitor r0 = this.a.d;
        long r3 = i1.a(r2);
        Intrinsics.checkNotNullParameter(r2, "$this$typeExt");
        int r5 = (int) r2.getType2();
        i97.a r14 = i97.a.a;
        MultiLinkServerMonitor.h(r0, 1, r2, r3, r5, System.currentTimeMillis(), true, 128);
        return;
    }
}
