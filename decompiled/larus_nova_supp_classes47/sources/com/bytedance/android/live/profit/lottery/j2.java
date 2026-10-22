package com.bytedance.android.live.profit.lottery;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class j2<T> implements Consumer {
    public final /* synthetic */ t a;
    public final /* synthetic */ LotteryRepository b;
    public final /* synthetic */ Lottery c;
    public final /* synthetic */ e1 d;
    public final /* synthetic */ com.bytedance.android.live.revenue.common.g e;
    public final /* synthetic */ LotteryState f;

    public j2(t r1, LotteryRepository r2, Lottery r3, e1 r4, com.bytedance.android.live.revenue.common.g r5, LotteryState.a r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }

    public final void accept(Object r12) {
        s r13 = (s) r12;
        LinkedHashMap<String, String> r0 = LotteryTraceMonitor.a;
        LotteryTraceMonitor.EventName r1 = LotteryTraceMonitor.EventName.lottery_draw_compensate_request_success;
        StringBuilder r2 = new StringBuilder("lotteryid = ");
        Lottery r3 = this.c;
        if (r3 == null) goto L9;
        LotteryState r4 = r3.getState();
        if (r4 == null) goto L9;
        t r5 = l.a(r4);
        if (r5 == null) goto L9;
        Long r6 = Long.valueOf(r5.a);
    L10:
        r2.append(r6);
        LotteryTraceMonitor.a(r1, r2.toString());
        this.b.g.a(r13.a);
        if (((Boolean) w2.n.getValue(null, w2.a[12])).booleanValue() == false) goto L13;
        ALogger.i("LotteryRepository", "from checkCandidateState");
        Map<String, String> r7 = b1.a;
        String r8 = String.valueOf(this.a.a);
        String r9 = r13.b;
        Intrinsics.checkNotNullParameter(r8, "key");
        Intrinsics.checkNotNullParameter(r9, "value");
        b1.a.put(r8, r9);
    L13:
        ParticipateStatus r10 = r13.a;
        ParticipateStatus r14 = ParticipateStatus.PARTICIPATEINSUCCESS;
        boolean r15 = false;
        if (r10 != r14) goto L16;
    L19:
        boolean r16 = true;
    L20:
        ParticipateStatus r17 = ParticipateStatus.ISLUCKY;
        if (r10 != r17) goto L23;
        r15 = true;
    L23:
        boolean r18 = this.b.g();
        JsonObject r19 = new JsonObject();
        Gson r20 = new Gson();
        Object r22 = this.d;
        if (r22 != null) goto L26;
        r22 = "";
    L26:
        r19.add("rawRes", GsonProtectorUtils.toJsonTree(r20, r22));
        Unit r23 = Unit.INSTANCE;
        p0 r24 = new p0(r16, r15, r18, r19);
        this.b.d(this.c, r24);
        this.e.b(r24.toString());
        LotteryState r25 = this.f;
        if (r25 != null) goto L29;
    L31:
        ParticipateStatus r110 = r13.a;
        if (r110 == r14) goto L34;
        if (r110 == r17) goto L34;
        return;
    L34:
        mz0.n r111 = new mz0.n();
        Map<String, String> r26 = r111.a;
        Intrinsics.checkNotNullParameter(r26, "map");
        String r27 = String.valueOf(this.a.a);
        Intrinsics.checkNotNullParameter("lottery_id", "key");
        Intrinsics.checkNotNullParameter(r27, "value");
        r26.put("lottery_id", r27);
        mz0.m r28 = new mz0.m();
        r28.b(LogCommon.ROOM);
        r28.b(LogCommon.PAGE_SOURCE_LOG);
        ((ArrayList) r111.b).addAll(r28.a);
        cy0.e.a.getClass();
        cy0.j r29 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r30 = com.bytedance.android.scope.m.b(r29).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r30);
        ((mz0.i) ((f80.a) r30)).w3("lottery_check_candidate_state", r111.a, r111.b);
        return;
    L29:
        if (l.a(r25) == null) goto L31;
        LotteryRepository r32 = this.b;
        t r33 = l.a(this.f);
        Intrinsics.checkNotNull(r33);
        Intrinsics.checkNotNullParameter(r32, "$this$monitorLotteryCheckCandidateStateSuccess");
        Intrinsics.checkNotNullParameter(r33, "lotteryInfo");
        Intrinsics.checkNotNullParameter(r24, "lotteryFinishInfo");
        JSONObject r34 = new JSONObject();
        d1.a(r32, r34);
        BaseMonitor.add(r34, "lottery_id", r33.a);
        BaseMonitor.add(r34, "is_participate", String.valueOf(r24.a));
        BaseMonitor.add(r34, "is_lucky", String.valueOf(r24.b));
        d1.e("ttlive_lottery_participate_status_new", r34);
        goto L31
    L16:
        if (r10 == ParticipateStatus.ISLUCKY) goto L19;
        r16 = false;
    L9:
        r6 = null;
        goto L10
    }
}
