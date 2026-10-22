package com.bytedance.android.live.componentsmarket.impl.components.close;

import am2.x;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d implements Runnable {
    public final /* synthetic */ Map a;

    public d(Map r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        u.l().sendLog("livesdk_leave_icon_show", this.a, new Object[]{IRoom.class, x.class});     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
