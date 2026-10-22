package com.bytedance.android.live.profit.lottery;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.core.utils.rxutils.RxCompatKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.revenue.platform.network.api.INetworkService;
import com.google.gson.JsonObject;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c2<T> implements Consumer {
    public final /* synthetic */ LotteryRepository a;
    public final /* synthetic */ Lottery b;

    public c2(LotteryRepository r1, Lottery r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r26) {
        LotteryState.a r1 = (LotteryState.a) r26;
        LinkedHashMap<String, String> r2 = LotteryTraceMonitor.a;
        LotteryTraceMonitor.EventName r3 = LotteryTraceMonitor.EventName.lottery_start_draw;
        StringBuilder r4 = new StringBuilder("lotteryid = ");
        Lottery r5 = this.b;
        Long r6 = null;
        if (r5 == null) goto L9;
        LotteryState r7 = r5.getState();
        if (r7 == null) goto L9;
        t r8 = l.a(r7);
        if (r8 == null) goto L9;
        Long r9 = Long.valueOf(r8.a);
    L10:
        r4.append(r9);
        LotteryTraceMonitor.a(r3, r4.toString());
        LotteryRepository r10 = this.a;
        Lottery r12 = this.b;
        r10.getClass();
        com.bytedance.android.live.revenue.common.g r13 = new com.bytedance.android.live.revenue.common.g("ttlive_lottery", "handleLotteryDraw " + r12.c);
        if ((r12.getState() instanceof LotteryState.a) == true) goto L13;
        LotteryTraceMonitor.a(LotteryTraceMonitor.EventName.lottery_draw_open_error_3, "lottery.state = " + r12.getState());
        return;
    L13:
        LotteryState r14 = r12.getState();
        if ((r14 instanceof LotteryState.a) == true) goto L16;
        r14 = null;
    L16:
        LotteryState.a r15 = (LotteryState.a) r14;
        if (r15 == null) goto L43;
        l01.d r16 = (l01.d) com.bytedance.android.live.revenue.core.util.f.a(l01.d.class);
        if (r15.a.h == true) goto L33;
        LotteryTraceMonitor.EventName r17 = LotteryTraceMonitor.EventName.lottery_old_draw_interaction;
        StringBuilder r18 = new StringBuilder("lotteryid = ");
        LotteryState r19 = r12.getState();
        if (r19 == null) goto L26;
        t r20 = l.a(r19);
        if (r20 == null) goto L26;
        r6 = Long.valueOf(r20.a);
    L26:
        r18.append(r6);
        LotteryTraceMonitor.a(r17, r18.toString());
        r13.a("begin");
        v.c r22 = v.a;
        long r23 = r10.q.getRoom().getId();
        long r110 = r15.a.a;
        com.bytedance.android.live.revenue.common.g r24 = new com.bytedance.android.live.revenue.common.g("ttlive_lottery", "fetchLotteryResult roomId=" + r23 + " lotteryId=" + r110);
        r24.a("start");
        int r25 = LotteryApi.a;
        tz0.b r27 = tz0.b.a;
        uz0.c r111 = new uz0.c();
        r27.getClass();
        Intrinsics.checkNotNullParameter(r111, "$this$beforeConfigureRequest");
        com.bytedance.android.live.revenue.common.x.a(r111, false);
        r111.a(qx0.a.a);
        Map<String, String> r28 = r111.b;
        Intrinsics.checkNotNullParameter(r28, "queriesMap");
        String r29 = Long.valueOf(r23).toString();
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        if (r29 == null) goto L29;
        r28.put("room_id", r29);
    L29:
        String r30 = Long.valueOf(r110).toString();
        Intrinsics.checkNotNullParameter("lottery_id", "$this$setTo");
        if (r30 == null) goto L32;
        r28.put("lottery_id", r30);
    L32:
        Intrinsics.checkNotNullParameter(r111, "$this$afterConfigureRequest");
        RxUtilKt.c(RxUtilKt.h(RxCompatKt.b(((INetworkService) com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/lottery/melon/check_user_right/", TypesJVMKt.getJavaType(Reflection.typeOf(JsonObject.class)), Extra.class, r111.d, r111.a, r111.b, r111.c).map(b0.a).doOnNext(c0.a), new com.bytedance.android.live.core.utils.rxutils.l(10, 1000, v.a))).singleOrError().doOnEvent(new d0(r24)).subscribe(new o1(r10, r12, r16, r13, r15), new p1(r10, r12, r13)), r10.b);
        return;
    L33:
        r13.a("begin_v2");
        boolean r32 = r10.g();
        if (((ParticipateStatus) r10.g.a) == ParticipateStatus.NOTPARTICIPATED) goto L38;
        if (r32 == true) goto L38;
        RxUtilKt.c(RxUtilKt.d(3000, 1000).takeUntil(r10.k.filter(new q1(r15))).filter(r1.a).take(1).subscribe(new s1(r10, r13, r15, r12)), r10.b);
        RxUtilKt.c(r10.k.filter(new t1(r15, r12)).subscribe(new u1(r10, r16, r32, r12, r13, r15)), r10.b);
        return;
    L38:
        p0 r33 = new p0(false, false, r32, new JsonObject());
        r10.d(r12, r33);
        r13.b(r33.toString());
        return;
    L43:
        return;
    L9:
        r9 = null;
        goto L10
    }
}
