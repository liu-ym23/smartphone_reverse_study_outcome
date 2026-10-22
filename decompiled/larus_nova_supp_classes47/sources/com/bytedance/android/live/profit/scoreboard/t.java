package com.bytedance.android.live.profit.scoreboard;

import com.bytedance.android.live.network.response.ExtraResponse;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class t<T, R> implements Function {
    public final /* synthetic */ ScoreboardApiClient a;
    public final /* synthetic */ String b;

    public t(ScoreboardApiClient r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object apply(Object r20) {
        com.bytedance.android.live.network.response.e r1 = (com.bytedance.android.live.network.response.e) r20;
        Intrinsics.checkNotNullParameter(r1, "it");
        ScoreboardApiClient r2 = this.a;
        com.bytedance.android.live.profit.scoreboard.dto.d r3 = ((com.bytedance.android.live.profit.scoreboard.dto.m) ((ExtraResponse) r1).data).getCounterInfo();
        Intrinsics.checkNotNull(r3);
        String r4 = this.b;
        long r5 = this.a.b.getRoom().getId();
        r2.getClass();
        Iterator<T> r6 = r3.getPlayers().iterator();
    L3:
        String r7 = null;
        if (r6.hasNext() == false) goto L8;
        T r8 = r6.next();
        if (((com.bytedance.android.live.profit.scoreboard.dto.e) r8).getCreator() == false) goto L3;
    L9:
        com.bytedance.android.live.profit.scoreboard.dto.e r9 = (com.bytedance.android.live.profit.scoreboard.dto.e) r8;
        long r10 = r3.getCounterId();
        if (r9 == null) goto L12;
        r7 = r9.getOpenId();
    L12:
        if (r7 != null) goto L14;
        String r12 = "";
    L16:
        if (r9 != null) goto L18;
    L20:
        boolean r13 = false;
    L21:
        dv0.i r14 = new dv0.i(r4, r10, null, r12, new com.bytedance.android.live.profit.scoreboard.dto.r(r13, 6));
        long r15 = r3.getStartTime();
        long r16 = r3.getUpdateTime();
        long r17 = r3.getExpectFinishTime();
        List<com.bytedance.android.live.profit.scoreboard.dto.e> r18 = r3.getPlayers();
        ArrayList r19 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r18, 10));
        Iterator<T> r22 = r18.iterator();
    L23:
        if (r22.hasNext() == false) goto L25;
        com.bytedance.android.live.profit.scoreboard.dto.e r23 = (com.bytedance.android.live.profit.scoreboard.dto.e) r22.next();
        r19.add(new dv0.g(r23.getRoomId(), r23.getPoints()));
        goto L23
    L25:
        if (r9 == null) goto L27;
        long r24 = r9.getRoomId();
    L29:
        return new dv0.k(r14, r15, r16, r17, r19, r24);
    L27:
        r24 = 0;
        goto L29
    L18:
        if (r9.getRoomId() != r5) goto L20;
        r13 = true;
        goto L21
    L14:
        r12 = r7;
        goto L16
    L8:
        r8 = null;
        goto L9
    }
}
