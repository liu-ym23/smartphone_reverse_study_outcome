package com.bytedance.android.livesdk.gamecp.impl;

import com.bytedance.android.gamecp.business.download.GameCenterStrategy;
import com.bytedance.android.livehostapi.business.depend.ad.GameDownloadInfo;
import com.bytedance.android.livehostapi.business.depend.ad.IAdDownloadListener;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h implements IAdDownloadListener {
    public final /* synthetic */ dw.c a;

    public h(GameCenterStrategy.doSubscribe.1 r1) {
        this.a = r1;
    }

    public final void downloadStateChange(GameDownloadInfo r25) {
        Intrinsics.checkNotNullParameter(r25, "gameDownloadInfo");
        dw.a r0 = new dw.a(0, 0, 0, 0, 0, null, 0, false, null, null, 0, null, 0, 0, null, 32767);
        r0.c = r25.getCurrentBytes();
        r0.j = r25.getEnableFeature();
        r0.g = r25.getFailStatus();
        r0.f = r25.getFileName();
        r0.h = r25.getOnlyWifi();
        r0.i = r25.getReserveInfo();
        r0.a = r25.getStatus();
        r0.b = r25.getTotalBytes();
        dw.c r2 = this.a;
        if (r2 == null) goto L6;
        r2.a(r0);
        return;
    }
}
