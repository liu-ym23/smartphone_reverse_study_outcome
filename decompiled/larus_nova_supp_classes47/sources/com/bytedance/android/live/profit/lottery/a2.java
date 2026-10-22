package com.bytedance.android.live.profit.lottery;

import com.bytedance.android.livesdk.revenue.log.LogCommon;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a2<T> implements Consumer {
    public final /* synthetic */ b2 a;

    public a2(b2 r1) {
        this.a = r1;
    }

    public final void accept(Object r8) {
        Long r9 = (Long) r8;
        LinkedHashMap<String, String> r10 = LotteryTraceMonitor.a;
        LotteryTraceMonitor.EventName r12 = LotteryTraceMonitor.EventName.lottery_countdown_time;
        StringBuilder r0 = new StringBuilder("lotteryid = ");
        Lottery r1 = this.a.b;
        if (r1 == null) goto L9;
        LotteryState r2 = r1.getState();
        if (r2 == null) goto L9;
        t r3 = l.a(r2);
        if (r3 == null) goto L9;
        Long r4 = Long.valueOf(r3.a);
    L10:
        r0.append(r4);
        LotteryTraceMonitor.a(r12, r0.toString());
        this.a.b.b(LotteryAction.d.a);
        mz0.n r13 = new mz0.n();
        Map<String, String> r5 = r13.a;
        Intrinsics.checkNotNullParameter(r5, "map");
        Lottery r6 = this.a.b;
        long r7 = 0;
        if (r6 == null) goto L17;
        LotteryState r14 = r6.getState();
        if (r14 == null) goto L17;
        t r15 = l.a(r14);
        if (r15 == null) goto L17;
        long r16 = r15.a;
    L18:
        String r17 = String.valueOf(r16);
        Intrinsics.checkNotNullParameter("lottery_id", "key");
        Intrinsics.checkNotNullParameter(r17, "value");
        r5.put("lottery_id", r17);
        Lottery r18 = this.a.b;
        if (r18 == null) goto L25;
        LotteryState r19 = r18.getState();
        if (r19 == null) goto L25;
        t r20 = l.a(r19);
        if (r20 == null) goto L25;
        Number r22 = Integer.valueOf(r20.d);
    L26:
        String r23 = r22.toString();
        Intrinsics.checkNotNullParameter("prize_type", "key");
        Intrinsics.checkNotNullParameter(r23, "value");
        r5.put("prize_type", r23);
        Lottery r24 = this.a.b;
        if (r24 == null) goto L33;
        LotteryState r25 = r24.getState();
        if (r25 == null) goto L33;
        t r26 = l.a(r25);
        if (r26 == null) goto L33;
        Number r27 = Integer.valueOf(r26.b);
    L34:
        String r28 = r27.toString();
        Intrinsics.checkNotNullParameter("status", "key");
        Intrinsics.checkNotNullParameter(r28, "value");
        r5.put("status", r28);
        Lottery r29 = this.a.b;
        if (r29 == null) goto L41;
        LotteryState r30 = r29.getState();
        if (r30 == null) goto L41;
        t r32 = l.a(r30);
        if (r32 == null) goto L41;
        r7 = r32.c;
    L41:
        String r33 = String.valueOf(r7);
        Intrinsics.checkNotNullParameter("local_draw_time", "key");
        Intrinsics.checkNotNullParameter(r33, "value");
        r5.put("local_draw_time", r33);
        mz0.m r34 = new mz0.m();
        r34.b(LogCommon.ROOM);
        r34.b(LogCommon.PAGE_SOURCE_LOG);
        ((ArrayList) r13.b).addAll(r34.a);
        cy0.e.a.getClass();
        cy0.j r35 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r36 = com.bytedance.android.scope.m.b(r35).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r36);
        ((mz0.i) ((f80.a) r36)).w3("lottery_countdown_ends", r13.a, r13.b);
        return;
    L33:
        r27 = 0L;
    L25:
        r22 = 0L;
    L17:
        r16 = 0;
    L9:
        r4 = null;
        goto L10
    }
}
