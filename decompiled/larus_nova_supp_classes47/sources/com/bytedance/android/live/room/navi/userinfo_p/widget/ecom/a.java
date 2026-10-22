package com.bytedance.android.live.room.navi.userinfo_p.widget.ecom;

import com.bytedance.android.live.profit.fansclub.o;
import com.bytedance.android.live.revenue.core.util.h;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.j;
import com.larus.apm.impl.protector.RunnableProtector;
import yt0.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements Runnable {
    public final /* synthetic */ ECLiveUserInfoWidget a;

    public a(ECLiveUserInfoWidget r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ECLiveUserInfoWidget r0 = this.a;     // Catch: Throwable -> L10
        MiddlewareRoomContext r1 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, ((Widget) r0).dataCenter, 0, 2);     // Catch: Throwable -> L10
        if (r1 == null) goto L7;
        j r2 = r1.getRevenueInstance();     // Catch: Throwable -> L10
        if (r2 == null) goto L7;
        com.bytedance.android.live.revenue.core.b r3 = (com.bytedance.android.live.revenue.core.b) r2.getValue();     // Catch: Throwable -> L10
    L8:
        int r4 = c.a;     // Catch: Throwable -> L10
        boolean r5 = h.a;     // Catch: Throwable -> L10
        r0.g = (o) h.b(r3, o.class);     // Catch: Throwable -> L10
        return;
    L7:
        r3 = null;
    L10:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L14;
        return;
    L14:
        throw th;
    }
}
