package com.bytedance.android.live.broadcastgame.xplay;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h0<T> implements Consumer {
    public final /* synthetic */ XplayMainService a;

    public h0(XplayMainService r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        Long r5 = (Long) r4;
        XplayMainService r6 = this.a;
        int r0 = XplayMainService.m;
        r6.getClass();
        int r1 = XplayLog.a;
        XplayLog.c("XplayMainService", "switchBackToSingleCastInGaming, isEnableSeverMergeStream: " + q1.d());
        if (q1.d() == false) goto L14;
        XplayGlobalServiceImpl r2 = XplayGlobalServiceImpl.c;
        com.bytedance.android.live.broadcastgame.api.xplay.f r3 = r2.n();
        if (r3 == null) goto L9;
        IXplayCoreService r7 = (IXplayCoreService) r3.getService(IXplayCoreService.class);
        if (r7 == null) goto L9;
        r7.updateEnableVideoFrame(false);
    L9:
        com.bytedance.android.live.broadcastgame.api.xplay.f r8 = r2.n();
        if (r8 == null) goto L24;
        IXplayCoreService r9 = (IXplayCoreService) r8.getService(IXplayCoreService.class);
        if (r9 == null) goto L24;
        r9.R();
    L24:
        r6.d();
        return;
    L14:
        XplayGlobalServiceImpl r11 = XplayGlobalServiceImpl.c;
        com.bytedance.android.live.broadcastgame.api.xplay.f r12 = r11.n();
        if (r12 == null) goto L19;
        IXplayCoreService r13 = (IXplayCoreService) r12.getService(IXplayCoreService.class);
        if (r13 == null) goto L19;
        r13.updateEnableVideoFrame(true);
    L19:
        com.bytedance.android.live.broadcastgame.api.xplay.f r14 = r11.n();
        if (r14 == null) goto L24;
        IXplayCoreService r15 = (IXplayCoreService) r14.getService(IXplayCoreService.class);
        if (r15 == null) goto L24;
        r15.R();
        goto L24
    }
}
