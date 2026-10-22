package com.bytedance.android.live.profit.scoreboard;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g0<T1, T2> implements ttc.a {
    public final /* synthetic */ f a;

    public g0(com.bytedance.android.live.broadcastgame.opengame.openapi.r.a r1) {
        this.a = r1;
    }

    public final void accept(Object r20, Object r22) {
        com.bytedance.android.live.profit.scoreboard.dto.m r1 = (com.bytedance.android.live.profit.scoreboard.dto.m) r20;
        Throwable r2 = (Throwable) r22;
        if (r2 == null) goto L10;
        f r3 = this.a;
        int r4 = com.bytedance.android.live.revenue.common.r0.a(r2);
        String r5 = com.bytedance.android.live.revenue.common.q0.a(r2);
        if (r5 != null) goto L7;
        r5 = r2.getMessage();
    L7:
        if (r5 != null) goto L9;
        r5 = "";
    L9:
        r3.onFailed(r4, r5);
        return;
    L10:
        com.bytedance.android.live.profit.scoreboard.dto.d r6 = r1.getCounterInfo();
        f r7 = this.a;
        if (r6 == null) goto L25;
        ScoreboardExternalServiceFacade.e.getClass();
        String r8 = String.valueOf(r6.getCounterId());
        long r9 = r6.getUpdateTime();
        long r10 = r6.getStartTime();
        long r12 = r6.getExpectFinishTime();
        long r13 = r6.getActualFinishTime();
        com.bytedance.android.live.profit.scoreboard.dto.f r14 = r6.getRule();
        if (r14 == null) goto L15;
        n r15 = ScoreboardExternalServiceFacade.a.b(r14);
    L16:
        n r16 = r15;
        List<com.bytedance.android.live.profit.scoreboard.dto.b> r17 = r6.getTopContributors();
        ArrayList r18 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r17, 10));
        Iterator r0 = r17.iterator();
    L18:
        if (r0.hasNext() == false) goto L20;
        com.bytedance.android.live.profit.scoreboard.dto.b r19 = (com.bytedance.android.live.profit.scoreboard.dto.b) r0.next();
        ScoreboardExternalServiceFacade.e.getClass();
        Iterator r23 = r0;
        f r110 = r7;
        r18.add(new n1(r19.getName(), r19.getAvatar(), r19.getPoints()));
        r0 = r23;
        r7 = r110;
        goto L18
    L20:
        f r111 = r7;
        List<com.bytedance.android.live.profit.scoreboard.dto.e> r24 = r6.getPlayers();
        ArrayList r25 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r24, 10));
        Iterator r26 = r24.iterator();
    L22:
        if (r26.hasNext() == false) goto L24;
        com.bytedance.android.live.profit.scoreboard.dto.e r27 = (com.bytedance.android.live.profit.scoreboard.dto.e) r26.next();
        ScoreboardExternalServiceFacade.e.getClass();
        r25.add(new m(String.valueOf(r27.getRoomId()), r27.getPoints(), 9));
        r26 = r26;
        goto L22
    L24:
        b r28 = new b(r8, r9, r10, r12, r13, r16, r18, r25);
    L26:
        r111.a(r28);
        return;
    L15:
        r15 = new n(0);
        goto L16
    L25:
        r111 = r7;
        r28 = null;
        goto L26
    }
}
