package com.bytedance.android.live.liveinteract.utils;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h0 extends com.bytedance.android.live.liveinteract.plantform.base.i.a<ILinkPlayerInfoBridge> {
    public final /* synthetic */ g0 a;

    public h0(g0 r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.i.b
    public final void onOnlineListChanged(List<ILinkPlayerInfoBridge> r5) {
        if (r5 == null) goto L15;
        g0 r6 = this.a;
        if (r6.c == true) goto L16;
        int r0 = r6.f.b();
        ALogger.i("LinkInfoReportHelper", "onLinkListChange: curLinkCount = " + r6.b + ", newLinkCount=" + r0);
        int r1 = r6.b;
        if (r1 != 0) goto L10;
        if (r0 <= 0) goto L10;
        r6.e(0, null);
    L13:
        r6.b = r0;
        return;
    L10:
        if (r1 <= 0) goto L13;
        if (r0 != 0) goto L13;
        r6.d(0, null);
        goto L13
    L16:
        return;
    }
}
