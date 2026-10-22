package com.bytedance.android.live.profit.redpacket;

import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class u0<T> implements Consumer {
    public final /* synthetic */ r0.p a;
    public final /* synthetic */ RedPacketState b;

    public u0(r0.p r1, RedPacketState r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r12) {
        RedPacketRushResult r13 = (RedPacketRushResult) r12;
        Intrinsics.checkNotNullParameter(r13, "result");
        this.a.b.b(new RedPacketAction.MarkRushed(r13));
        n0 r0 = this.b.getInfo();
        boolean r1 = this.a.a.w.isAnchor();
        Intrinsics.checkNotNullParameter(r0, "currentPacket");
        Intrinsics.checkNotNullParameter(r13, "rushResult");
        boolean r3 = r13 instanceof RedPacketRushResult.e;
        if (r3 == true) goto L5;
        RedPacketRushResult r4 = null;
    L6:
        RedPacketRushResult.e r5 = (RedPacketRushResult.e) r4;
        if (r5 == null) goto L9;
        long r6 = r5.c;
    L10:
        int r7 = r0.m;
        if (r3 == false) goto L13;
    L16:
        boolean r9 = true;
    L17:
        Intrinsics.checkNotNullParameter(r0, "currentPacket");
        Pair[] r2 = new Pair[3];
        if (r9 == false) goto L20;
        String r10 = DataType.TRUE;
    L21:
        r2[0] = TuplesKt.to("is_success", r10);
        r2[1] = TuplesKt.to("gift_id", String.valueOf(r6));
        r2[2] = TuplesKt.to("money", String.valueOf(r7));
        Map<? extends String, ? extends String> r8 = MapsKt.mutableMapOf(r2);
        o.a(r8, r0, r1);
        mz0.n r14 = new mz0.n();
        Map<String, String> r15 = r14.a;
        Intrinsics.checkNotNullParameter(r15, "map");
        Intrinsics.checkNotNullParameter(r8, "map");
        r15.putAll(r8);
        mz0.m r16 = new mz0.m();
        r16.b(LogCommon.PAGE_SOURCE_LOG);
        r16.b(LogCommon.ROOM);
        List<Object> r17 = r14.b;
        ArrayList r18 = (ArrayList) r17;
        r18.addAll(r16.a);
        cy0.e.a.getClass();
        cy0.j r19 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r20 = com.bytedance.android.scope.m.b(r19).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r20);
        ((mz0.i) ((f80.a) r20)).w3("livesdk_redpackage_grab", r14.a, r14.b);
        r0 r22 = this.a.a;
        n0 r23 = this.b.getInfo();
        Intrinsics.checkNotNullParameter(r22, "$this$monitorRedPacketRushedSuccess");
        Intrinsics.checkNotNullParameter(r23, "redPacketInfo");
        Intrinsics.checkNotNullParameter(r13, "redPacketRushResult");
        JSONObject r24 = new JSONObject();
        q0.a(r22, r24);
        q0.b(r24, r23);
        if (r3 == false) goto L25;
        RushResultStatus r25 = RushResultStatus.RUSH_RESULT_SUCCESSED;
        q0.c(r24, r13, r25.getStatusMsg());
        q0.d("ttlive_redpacket_rushed_status", "red_packet_rush_result_status", r25.getStatusMsg(), r24);
        return;
    L25:
        if ((r13 instanceof RedPacketRushResult.d) == false) goto L28;
        RushResultStatus r26 = RushResultStatus.RUSH_RESULT_FAILED;
        q0.c(r24, r13, r26.getStatusMsg());
        q0.d("ttlive_redpacket_rushed_status", "red_packet_rush_result_status", r26.getStatusMsg(), r24);
        return;
    L28:
        if ((r13 instanceof RedPacketRushResult.c) == false) goto L31;
        RushResultStatus r27 = RushResultStatus.RUSH_RESULT_EXPIRED;
        q0.c(r24, r13, r27.getStatusMsg());
        q0.d("ttlive_redpacket_rushed_status", "red_packet_rush_result_status", r27.getStatusMsg(), r24);
        return;
    L31:
        if ((r13 instanceof RedPacketRushResult.a) == false) goto L37;
        RushResultStatus r28 = RushResultStatus.RUSH_RESULT_LYNX;
        q0.c(r24, r13, r28.getStatusMsg());
        q0.d("ttlive_redpacket_rushed_status", "red_packet_rush_result_status", r28.getStatusMsg(), r24);
        return;
    L37:
        return;
    L20:
        r10 = DataType.FALSE;
        goto L21
    L13:
        if ((r13 instanceof RedPacketRushResult.b) == true) goto L16;
        r9 = false;
        goto L17
    L9:
        r6 = 0;
        goto L10
    L5:
        r4 = r13;
        goto L6
    }
}
