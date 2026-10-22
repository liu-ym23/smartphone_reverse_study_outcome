package com.bytedance.android.live.revlink.impl.multianchor.pk.logger;

import com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class BreakThroughPkLog {
    public final b a;
    public final com.bytedance.android.livesdk.revenue.service.room.c b;
    public final com.bytedance.android.live.revlink.impl.global.c c;

    public final void a(boolean r3) {
        this.a.b(r3, new BreakThroughPkLog$onPkEnd$1(this));
    }

    public final void b(boolean r3) {
        this.a.c(r3, BreakThroughPkLog$onPkStart$1.INSTANCE);
    }

    public BreakThroughPkLog(com.bytedance.android.livesdk.revenue.service.room.c r2, d r3) {
        this.b = r2;
        this.c = r3;
        this.a = new b(r2, r3);
    }
}
