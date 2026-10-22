package com.bytedance.android.live.profit.scoreboard;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f0<T1, T2> implements ttc.a {
    public final /* synthetic */ ScoreboardExternalServiceFacade.ScoreboardExternalServiceImpl a;
    public final /* synthetic */ e b;

    public f0(ScoreboardExternalServiceFacade.ScoreboardExternalServiceImpl r1, com.bytedance.android.live.broadcastgame.opengame.openapi.s.a r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r6, Object r7) {
        dv0.a r8 = (dv0.a) r6;
        Throwable r9 = (Throwable) r7;
        if (r9 == null) goto L10;
        e r10 = this.b;
        int r0 = com.bytedance.android.live.revenue.common.r0.a(r9);
        String r1 = com.bytedance.android.live.revenue.common.q0.a(r9);
        if (r1 != null) goto L7;
        r1 = r9.getMessage();
    L7:
        if (r1 != null) goto L9;
        r1 = "";
    L9:
        r10.onFailed(r0, r1);
        return;
    L10:
        ScoreboardExternalServiceFacade.ScoreboardExternalServiceImpl r12 = this.a;
        r12.c = Long.valueOf(r8.c);
        e r13 = this.b;
        ScoreboardExternalServiceFacade.e.getClass();
        List<Long> r2 = r8.a.getDurationChoices();
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator<T> r4 = r2.iterator();
    L12:
        if (r4.hasNext() == false) goto L14;
        r3.add(Integer.valueOf((int) ((Number) r4.next()).longValue()));
        goto L12
    L14:
        int r5 = r8.b;
        int r14 = 1;
        if (r5 == 0) goto L20;
        if (r5 == 1) goto L20;
        r14 = 2;
        if (r5 == 2) goto L20;
        r14 = -1;
    L20:
        List<com.bytedance.android.live.profit.scoreboard.dto.f> r15 = r8.a.getRules();
        ArrayList r16 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10));
        Iterator<T> r17 = r15.iterator();
    L22:
        if (r17.hasNext() == false) goto L24;
        com.bytedance.android.live.profit.scoreboard.dto.f r18 = (com.bytedance.android.live.profit.scoreboard.dto.f) r17.next();
        ScoreboardExternalServiceFacade.e.getClass();
        r16.add(ScoreboardExternalServiceFacade.a.b(r18));
        goto L22
    L24:
        r13.a(new a(r3, r14, r16, 4));
    }
}
