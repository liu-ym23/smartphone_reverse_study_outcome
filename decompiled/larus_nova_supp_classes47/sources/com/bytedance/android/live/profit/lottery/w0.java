package com.bytedance.android.live.profit.lottery;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.monitor.trace.TraceMonitor;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class w0<T> implements Consumer {
    public final /* synthetic */ LotteryIconModel a;

    public w0(LotteryIconModel r1) {
        this.a = r1;
    }

    public final void accept(Object r22) {
        Long r0 = (Long) r22;
        LinkedHashMap<String, String> r1 = LotteryTraceMonitor.a;
        LotteryIconModel r2 = this.a;
        yz0.k r3 = r2.s;
        Lottery r4 = (Lottery) r2.p.getCurrentLottery().getValue();
        if (r4 == null) goto L9;
        LotteryState r5 = r4.getState();
        if (r5 == null) goto L9;
        t r6 = l.a(r5);
        if (r6 == null) goto L9;
        long r7 = r6.a;
    L10:
        String r8 = String.valueOf(r7);
        Intrinsics.checkNotNullParameter(r3, "roomDataService");
        Intrinsics.checkNotNullParameter("ttlive_lottery_result_trace", "eventType");
        Intrinsics.checkNotNullParameter("fudai", "businessType");
        Intrinsics.checkNotNullParameter("webcast_client_community", "productId");
        Intrinsics.checkNotNullParameter(r8, "lotteryId");
        LinkedHashMap<String, String> r9 = LotteryTraceMonitor.a;
        if (r9 != null) goto L13;
        return;
    L13:
        if (r9.isEmpty() == true) goto L100;
        JSONObject r10 = new JSONObject();
        ArrayList r12 = new ArrayList(r9.size());
        Iterator<Map.Entry<String, String>> r13 = r9.entrySet().iterator();
    L17:
        if (r13.hasNext() == false) goto L19;
        Map.Entry<String, String> r14 = r13.next();
        LotteryTraceMonitor.c(r10, r14.getKey(), r14.getValue());
        r12.add(Unit.INSTANCE);
        goto L17
    L19:
        Intrinsics.checkNotNullParameter(r10, "$this$injectCommonParams");
        Intrinsics.checkNotNullParameter(r3, "roomDataService");
        IRoom r15 = r3.getRoom();
        if (r15 == null) goto L22;
        LotteryTraceMonitor.c(r10, "room_id", String.valueOf(r15.getId()));
    L22:
        LotteryTraceMonitor.c(r10, "user_id", r3.getUser().getIdString().toString());
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L60
        LinkedHashMap<String, String> r17 = LotteryTraceMonitor.a;     // Catch: Throwable -> L60
        Intrinsics.checkNotNull(r17);     // Catch: Throwable -> L60
        ArrayList r18 = new ArrayList(r17.keySet());     // Catch: Throwable -> L60
        if (r18.size() > 0) goto L27;
        r3 = r3;
        String r20 = "ttlive_lottery_result_trace";
        String r19 = "fudai";
        String r110 = "webcast_client_community";
        mz0.n r23 = new mz0.n();     // Catch: Throwable -> L52
        Map<String, String> r24 = r23.a;     // Catch: Throwable -> L52
        Intrinsics.checkNotNullParameter(r24, "map");     // Catch: Throwable -> L52
        Intrinsics.checkNotNullParameter("extra", "key");     // Catch: Throwable -> L52
        Intrinsics.checkNotNullParameter("key is null", "value");     // Catch: Throwable -> L52
        r24.put("extra", "key is null");     // Catch: Throwable -> L52
        Intrinsics.checkNotNullParameter("lottery_id", "key");     // Catch: Throwable -> L52
        Intrinsics.checkNotNullParameter(r8, "value");     // Catch: Throwable -> L52
        r24.put("lottery_id", r8);     // Catch: Throwable -> L52
        Intrinsics.checkNotNullParameter("status", "key");     // Catch: Throwable -> L52
        Intrinsics.checkNotNullParameter(DataType.FALSE, "value");     // Catch: Throwable -> L52
        r24.put("status", DataType.FALSE);     // Catch: Throwable -> L52
        mz0.m r25 = new mz0.m();     // Catch: Throwable -> L52
        r25.b(LogCommon.ROOM);     // Catch: Throwable -> L52
        r25.b(LogCommon.PAGE_SOURCE_LOG);     // Catch: Throwable -> L52
        ((ArrayList) r23.b).addAll(r25.a);     // Catch: Throwable -> L52
        cy0.e.a.getClass();     // Catch: Throwable -> L52
        cy0.j r26 = cy0.e.a.a;     // Catch: Throwable -> L52
        com.bytedance.android.scope.m.e.getClass();     // Catch: Throwable -> L52
        Object r27 = com.bytedance.android.scope.m.b(r26).a(Reflection.getOrCreateKotlinClass(mz0.i.class));     // Catch: Throwable -> L52
        Intrinsics.checkNotNull(r27);     // Catch: Throwable -> L52
        ((mz0.i) ((f80.a) r27)).w3("lottery_trace_fail", r23.a, r23.b);     // Catch: Throwable -> L52
    L63:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L52
    L66:
        LinkedHashMap r28 = new LinkedHashMap();
        IRoom r29 = r3.getRoom();
        IBaseUser r30 = r3.getUser();
        if (r29 == null) goto L70;
        if (r30 == null) goto L70;
        int r32 = com.bytedance.android.live.core.monitor.trace.e.m;
        com.bytedance.android.live.core.monitor.trace.e.a r33 = com.bytedance.android.live.core.monitor.trace.e.b.a(r20, r19);
        r33.c = r110;
        r33.e = String.valueOf(r29.getRoomId());
        r33.f = r29.getAnchorId();
        r33.g = r30.getIdString();
        r33.a = r8;
        Intrinsics.checkNotNullParameter(r28, "index");
        r33.j = r28;
        com.bytedance.android.live.core.monitor.trace.e r34 = r33.a();
        r10.toString();
        JSONObject r35 = new JSONObject();
        LotteryTraceMonitor.c(r35, "link", r10.toString());
        TraceMonitor.h(r34, r35);
        r10.toString();
    L85:
        LinkedHashMap<String, String> r36 = LotteryTraceMonitor.a;
        if (r36 == null) goto L99;
        r36.clear();
        return;
    L99:
        return;
    L70:
        StringBuilder r37 = new StringBuilder("room or user is null roomid = ");
        if (r29 == null) goto L73;
        Long r38 = Long.valueOf(r29.getId());
    L74:
        r37.append(r38.longValue());
        r37.append("  userid = ");
        if (r30 == null) goto L77;
        String r39 = r30.getIdString();
    L78:
        r37.append(r39);
        SafetyGuard.a(null, null, r37.toString());
        if (r29 == null) goto L81;
        Long r40 = Long.valueOf(r29.getId());
    L82:
        r40.longValue();
        if (r30 == null) goto L85;
        r30.getIdString();
        goto L85
    L81:
        r40 = null;
        goto L82
    L77:
        r39 = null;
        goto L78
    L73:
        r38 = null;
        goto L74
    L27:
        r110 = "webcast_client_community";
    L58:
        th = th;
        r20 = "ttlive_lottery_result_trace";
    L57:
        r19 = "fudai";
    L65:
        Result.Companion r42 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L66
    L30:
        if (Intrinsics.areEqual((String) ListProtector.get(r18, 0), LotteryTraceMonitor.EventName.lottery_init_im.name()) == false) goto L32;
    L37:
        boolean r43 = true;
    L38:
        r20 = "ttlive_lottery_result_trace";
    L55:
        th = th;
        goto L57
    L41:
        if (Intrinsics.areEqual((String) ListProtector.get(r18, r18.size() - 1), LotteryTraceMonitor.EventName.lottery_is_terminalState.name()) == true) goto L48;
        r3 = r3;
        r19 = "fudai";
        if (StringsKt.contains$default((CharSequence) ListProtector.get(r18, r18.size() - 1), LotteryTraceMonitor.EventName.lottery_draw_open_schema_final.name(), false, 2, null) == true) goto L49;
        boolean r111 = false;
    L50:
        if (r111 == false) goto L54;
        mz0.n r44 = new mz0.n();     // Catch: Throwable -> L52
        Map<String, String> r45 = r44.a;     // Catch: Throwable -> L52
        Intrinsics.checkNotNullParameter(r45, "map");     // Catch: Throwable -> L52
        String r46 = r10.toString();     // Catch: Throwable -> L52
        Intrinsics.checkNotNullParameter("extra", "key");     // Catch: Throwable -> L52
        Intrinsics.checkNotNullParameter(r46, "value");     // Catch: Throwable -> L52
        r45.put("extra", r46);     // Catch: Throwable -> L52
        Intrinsics.checkNotNullParameter("lottery_id", "key");     // Catch: Throwable -> L52
        Intrinsics.checkNotNullParameter(r8, "value");     // Catch: Throwable -> L52
        r45.put("lottery_id", r8);     // Catch: Throwable -> L52
        Intrinsics.checkNotNullParameter("status", "key");     // Catch: Throwable -> L52
        Intrinsics.checkNotNullParameter(DataType.TRUE, "value");     // Catch: Throwable -> L52
        r45.put("status", DataType.TRUE);     // Catch: Throwable -> L52
        mz0.m r47 = new mz0.m();     // Catch: Throwable -> L52
        r47.b(LogCommon.ROOM);     // Catch: Throwable -> L52
        r47.b(LogCommon.PAGE_SOURCE_LOG);     // Catch: Throwable -> L52
        ((ArrayList) r44.b).addAll(r47.a);     // Catch: Throwable -> L52
        cy0.e.a.getClass();     // Catch: Throwable -> L52
        cy0.j r48 = cy0.e.a.a;     // Catch: Throwable -> L52
        com.bytedance.android.scope.m.e.getClass();     // Catch: Throwable -> L52
        Object r49 = com.bytedance.android.scope.m.b(r48).a(Reflection.getOrCreateKotlinClass(mz0.i.class));     // Catch: Throwable -> L52
        Intrinsics.checkNotNull(r49);     // Catch: Throwable -> L52
        ((mz0.i) ((f80.a) r49)).w3("lottery_trace_success", r44.a, r44.b);     // Catch: Throwable -> L52
        goto L63
    L54:
        mz0.n r50 = new mz0.n();     // Catch: Throwable -> L52
        Map<String, String> r52 = r50.a;     // Catch: Throwable -> L52
        Intrinsics.checkNotNullParameter(r52, "map");     // Catch: Throwable -> L52
        String r53 = r10.toString();     // Catch: Throwable -> L52
        Intrinsics.checkNotNullParameter("extra", "key");     // Catch: Throwable -> L52
        Intrinsics.checkNotNullParameter(r53, "value");     // Catch: Throwable -> L52
        r52.put("extra", r53);     // Catch: Throwable -> L52
        String r54 = String.valueOf(r43);     // Catch: Throwable -> L52
        Intrinsics.checkNotNullParameter("start", "key");     // Catch: Throwable -> L52
        Intrinsics.checkNotNullParameter(r54, "value");     // Catch: Throwable -> L52
        r52.put("start", r54);     // Catch: Throwable -> L52
        String r55 = String.valueOf(r111);     // Catch: Throwable -> L52
        Intrinsics.checkNotNullParameter("end", "key");     // Catch: Throwable -> L52
        Intrinsics.checkNotNullParameter(r55, "value");     // Catch: Throwable -> L52
        r52.put("end", r55);     // Catch: Throwable -> L52
        Intrinsics.checkNotNullParameter("lottery_id", "key");     // Catch: Throwable -> L52
        Intrinsics.checkNotNullParameter(r8, "value");     // Catch: Throwable -> L52
        r52.put("lottery_id", r8);     // Catch: Throwable -> L52
        Intrinsics.checkNotNullParameter("status", "key");     // Catch: Throwable -> L52
        Intrinsics.checkNotNullParameter(DataType.FALSE, "value");     // Catch: Throwable -> L52
        r52.put("status", DataType.FALSE);     // Catch: Throwable -> L52
        mz0.m r56 = new mz0.m();     // Catch: Throwable -> L52
        r56.b(LogCommon.ROOM);     // Catch: Throwable -> L52
        r56.b(LogCommon.PAGE_SOURCE_LOG);     // Catch: Throwable -> L52
        ((ArrayList) r50.b).addAll(r56.a);     // Catch: Throwable -> L52
        cy0.e.a.getClass();     // Catch: Throwable -> L52
        cy0.j r57 = cy0.e.a.a;     // Catch: Throwable -> L52
        com.bytedance.android.scope.m.e.getClass();     // Catch: Throwable -> L52
        Object r58 = com.bytedance.android.scope.m.b(r57).a(Reflection.getOrCreateKotlinClass(mz0.i.class));     // Catch: Throwable -> L52
        Intrinsics.checkNotNull(r58);     // Catch: Throwable -> L52
        ((mz0.i) ((f80.a) r58)).w3("lottery_trace_fail", r50.a, r50.b);     // Catch: Throwable -> L52
    L49:
        r111 = true;
        goto L50
    L48:
        r3 = r3;
        r19 = "fudai";
        goto L49
    L32:
        if (Intrinsics.areEqual((String) ListProtector.get(r18, 0), LotteryTraceMonitor.EventName.lottery_init_api.name()) == true) goto L37;
        if (Intrinsics.areEqual((String) ListProtector.get(r18, 0), LotteryTraceMonitor.EventName.lottery_init_api_backend.name()) == true) goto L37;
        r43 = false;
    L52:
        th = th;
    L60:
        th = th;
        r3 = r3;
        r20 = "ttlive_lottery_result_trace";
        r19 = "fudai";
        r110 = "webcast_client_community";
        goto L65
    L100:
        return;
    L9:
        r7 = 0;
        goto L10
    }
}
