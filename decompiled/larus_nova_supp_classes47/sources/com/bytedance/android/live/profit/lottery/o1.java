package com.bytedance.android.live.profit.lottery;

import com.bytedance.android.live.core.monitor.BaseMonitor;
import io.reactivex.functions.Consumer;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class o1<T> implements Consumer {
    public final /* synthetic */ LotteryRepository a;
    public final /* synthetic */ Lottery b;
    public final /* synthetic */ l01.d c;
    public final /* synthetic */ com.bytedance.android.live.revenue.common.g d;
    public final /* synthetic */ LotteryState.a e;

    public o1(LotteryRepository r1, Lottery r2, l01.d r3, com.bytedance.android.live.revenue.common.g r4, LotteryState.a r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public final void accept(Object r10) {
        v.a r12 = (v.a) r10;
        LinkedHashMap<String, String> r0 = LotteryTraceMonitor.a;
        LotteryTraceMonitor.EventName r1 = LotteryTraceMonitor.EventName.lottery_old_draw_interaction_success;
        StringBuilder r2 = new StringBuilder("lotteryid = ");
        Lottery r3 = this.b;
        if (r3 == null) goto L9;
        LotteryState r4 = r3.getState();
        if (r4 == null) goto L9;
        t r5 = l.a(r4);
        if (r5 == null) goto L9;
        Long r6 = Long.valueOf(r5.a);
    L10:
        r2.append(r6);
        LotteryTraceMonitor.a(r1, r2.toString());
        String r7 = this.c.b().getIdString();
        r12.getClass();
        Intrinsics.checkNotNullParameter(r7, "userId");
        List<d> r8 = r12.b.getCandidateUsers();
        boolean r9 = true;
        if ((r8 instanceof Collection) == true) goto L13;
    L15:
        Iterator<T> r13 = r8.iterator();
    L17:
        if (r13.hasNext() == false) goto L21;
        d r14 = (d) r13.next();
        Intrinsics.checkNotNullParameter(r14, "$this$userIdString");
        com.bytedance.android.live.base.model.user.o0.a r15 = com.bytedance.android.live.base.model.user.o0.a;
        Long r16 = Long.valueOf(r14.get_userId());
        String r17 = r14.get_userOpenId();
        r15.getClass();
        if (Intrinsics.areEqual(com.bytedance.android.live.base.model.user.o0.a.g(r16, r17), r7) == false) goto L17;
        boolean r18 = true;
    L23:
        if (r12.b.getUserLuckyInfo() != null) goto L26;
        r9 = false;
    L26:
        p0 r19 = new p0(r18, r9, this.a.g(), r12.a);
        this.a.d(this.b, r19);
        this.d.b(r19.toString());
        LotteryRepository r110 = this.a;
        t r20 = this.e.a;
        Intrinsics.checkNotNullParameter(r110, "$this$monitorLotteryFetchedResultSuccess");
        Intrinsics.checkNotNullParameter(r20, "lotteryInfo");
        Intrinsics.checkNotNullParameter(r19, "lotteryFinishInfo");
        JSONObject r22 = new JSONObject();
        d1.a(r110, r22);
        BaseMonitor.add(r22, "lottery_id", r20.a);
        BaseMonitor.add(r22, "is_participate", String.valueOf(r19.a));
        BaseMonitor.add(r22, "is_lucky", String.valueOf(r19.b));
        d1.e("ttlive_lottery_participate_status", r22);
        return;
    L21:
        r18 = false;
        goto L23
    L13:
        if (r8.isEmpty() == false) goto L15;
    L9:
        r6 = null;
        goto L10
    }
}
