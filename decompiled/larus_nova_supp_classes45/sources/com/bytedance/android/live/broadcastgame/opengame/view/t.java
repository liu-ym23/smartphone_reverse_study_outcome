package com.bytedance.android.live.broadcastgame.opengame.view;

import com.bytedance.common.utility.Logger;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class t implements Runnable {
    public final /* synthetic */ PayFlowView a;

    public t(PayFlowView r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    L3:
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L5;
        Logger.d("PayFlowView", "PayFlowView,  延时 2s 到，尝试拉取新消息");     // Catch: Throwable -> L7
    L5:
        PayFlowView r0 = this.a;     // Catch: Throwable -> L7
        int r1 = PayFlowView.i;     // Catch: Throwable -> L7
        r0.S5();     // Catch: Throwable -> L7
    }
}
