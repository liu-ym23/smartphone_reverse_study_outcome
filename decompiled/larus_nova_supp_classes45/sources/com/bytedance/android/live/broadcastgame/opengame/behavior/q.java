package com.bytedance.android.live.broadcastgame.opengame.behavior;

import com.bytedance.android.live.broadcastgame.xplay.XplayLog;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class q implements Runnable {
    public final /* synthetic */ g a;
    public final /* synthetic */ long b;

    public q(g r1, long r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        JSONObject r0 = new JSONObject();
        r0.put("service", "ttlive_open_platform_audience_entrance_show");
        JSONObject r1 = new JSONObject();
        r1.put("duration", this.b);
        Unit r2 = Unit.INSTANCE;
        r0.put("metric", r1);
        String r3 = com.bytedance.android.live.broadcastgame.api.h.a(this.a.getContext(), r0.toString());
        int r4 = XplayLog.a;
        XplayLog.c("MiniGameComponentConfig", "storageEntranceShowDuration, path " + r3);
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
