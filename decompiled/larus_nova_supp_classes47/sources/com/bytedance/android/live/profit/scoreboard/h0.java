package com.bytedance.android.live.profit.scoreboard;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h0<T1, T2> implements ttc.a {
    public final /* synthetic */ dv0.n a;
    public final /* synthetic */ m1 b;

    public h0(dv0.n r1, com.bytedance.android.live.broadcastgame.opengame.openapi.b1.a r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r3, Object r4) {
        com.bytedance.android.live.profit.scoreboard.dto.g r5 = (com.bytedance.android.live.profit.scoreboard.dto.g) r3;
        Throwable r6 = (Throwable) r4;
        if (r6 == null) goto L10;
        dv0.n r7 = this.a;
        r7.getClass();
        Intrinsics.checkNotNullParameter(r6, "throwable");
        r7.a.onError(r6);
        m1 r8 = this.b;
        int r0 = com.bytedance.android.live.revenue.common.r0.a(r6);
        String r1 = com.bytedance.android.live.revenue.common.q0.a(r6);
        if (r1 != null) goto L7;
        r1 = r6.getMessage();
    L7:
        if (r1 != null) goto L9;
        r1 = "";
    L9:
        r8.onFailed(r0, r1);
        return;
    L10:
        dv0.n r9 = this.a;
        long r2 = r5.getRoundId();
        r9.a.onSuccess(Long.valueOf(r2));
        this.b.onSuccess(String.valueOf(r5.getRoundId()));
    }
}
