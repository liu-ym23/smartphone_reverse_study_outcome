package com.bytedance.android.live.broadcastgame.opengame.view;

import com.bytedance.common.utility.Logger;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class y implements Runnable {
    public final /* synthetic */ RewardMsgContainer a;

    public y(RewardMsgContainer r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.c();     // Catch: Throwable -> L6
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L9;
        Logger.d("RewardMsgContainer", "RewardMsgContainer,  延时 2s 到，尝试拉取新消息");     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
