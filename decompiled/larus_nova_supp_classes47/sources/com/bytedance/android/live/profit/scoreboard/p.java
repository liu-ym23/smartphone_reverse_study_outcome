package com.bytedance.android.live.profit.scoreboard;

import com.bytedance.android.live.network.response.ExtraResponse;
import io.reactivex.functions.Function;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class p<T, R> implements Function {
    public final /* synthetic */ ScoreboardApiClient a;

    public p(ScoreboardApiClient r1) {
        this.a = r1;
    }

    public final Object apply(Object r10) {
        com.bytedance.android.live.network.response.e r12 = (com.bytedance.android.live.network.response.e) r10;
        Intrinsics.checkNotNullParameter(r12, "it");
        ScoreboardApiClient r0 = this.a;
        com.bytedance.android.live.profit.scoreboard.dto.l r13 = (com.bytedance.android.live.profit.scoreboard.dto.l) ((ExtraResponse) r12).data;
        r0.getClass();
        com.bytedance.android.live.profit.scoreboard.dto.a r1 = r13.getConfig();
        if (r1 == null) goto L8;
        com.bytedance.android.live.profit.scoreboard.dto.p r2 = r1.getLinkmicInfo();
        if (r2 == null) goto L8;
        List<com.bytedance.android.live.profit.scoreboard.dto.q> r3 = r2.getUsers();
        if (r3 == null) goto L8;
    L9:
        Iterator<T> r4 = r3.iterator();
    L11:
        if (r4.hasNext() == false) goto L18;
        T r5 = r4.next();
        if (((com.bytedance.android.live.profit.scoreboard.dto.q) r5).getRoomId() == r0.b.getRoom().getId()) goto L15;
        boolean r6 = true;
    L16:
        if (r6 == false) goto L11;
    L19:
        com.bytedance.android.live.profit.scoreboard.dto.q r7 = (com.bytedance.android.live.profit.scoreboard.dto.q) r5;
        if (r7 == null) goto L22;
        long r8 = r7.getRoomId();
    L23:
        com.bytedance.android.live.profit.scoreboard.dto.a r14 = r13.getConfig();
        if (r14 != null) goto L27;
        r14 = (com.bytedance.android.live.profit.scoreboard.dto.a) vh7.f.c(com.bytedance.android.live.profit.scoreboard.dto.a.class);
    L27:
        return new dv0.a(r14, r3.size(), r8);
    L22:
        r8 = 0;
        goto L23
    L15:
        r6 = false;
        goto L16
    L18:
        r5 = null;
    L8:
        r3 = CollectionsKt.emptyList();
        goto L9
    }
}
