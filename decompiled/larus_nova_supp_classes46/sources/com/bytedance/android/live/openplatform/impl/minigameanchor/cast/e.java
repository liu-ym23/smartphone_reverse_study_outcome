package com.bytedance.android.live.openplatform.impl.minigameanchor.cast;

import android.os.Bundle;
import com.bytedance.android.live.openplatform.impl.minigamecommon.event.BridgeContextService;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e implements Runnable {
    public final /* synthetic */ LiveMgCastContextService a;

    public e(LiveMgCastContextService r1) {
        this.a = r1;
    }

    public final void a() {
        LiveMgCastContextService r0 = this.a;
        int r1 = LiveMgCastContextService.o;
        BridgeContextService r2 = (BridgeContextService) r0.getOpenPlatformContext().getService(BridgeContextService.class);
        Bundle r3 = new Bundle();
        r3.putBoolean("key_recast", true);
        r3.putInt("key_live_link_num", 0);
        r3.putInt("key_live_apply_num", 0);
        Unit r4 = Unit.INSTANCE;
        r2.g("command_live_cast_linkmic_status", r3);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
