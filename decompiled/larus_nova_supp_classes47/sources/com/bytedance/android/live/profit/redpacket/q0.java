package com.bytedance.android.live.profit.redpacket;

import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.profile.monitor.DataType;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class q0 {
    public static final void a(r0 r3, JSONObject r4) {
        BaseMonitor.add(r4, "room_id", r3.w.getRoom().getId());
        BaseMonitor.add(r4, "is_anchor", String.valueOf(r3.w.isAnchor()));
        BaseMonitor.add(r4, "user_id", ((l01.d) com.bytedance.android.live.revenue.core.util.f.a(l01.d.class)).getCurrentUserId());
    }

    public static final void b(JSONObject r6, n0 r7) {
        String r0 = r7.j.getWebcastUid();
        BaseMonitor.add(r6, "red_packet_id", r7.d);
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == true) goto L15;
        String r2 = r7.j.getWebcastUid();
        if (r2 != null) goto L14;
        r2 = "";
    L14:
        BaseMonitor.add(r6, "red_packet_sender_id", r2);
    L17:
        if (r7.o != RedPacketDataSource.API) goto L19;
        String r3 = "API";
    L20:
        BaseMonitor.add(r6, "red_packet_data_source", r3);
        BaseMonitor.add(r6, "red_packet_is_risk_sender", String.valueOf(r7.p));
        BaseMonitor.add(r6, "red_packet_send_time", r7.f.a);
        BaseMonitor.add(r6, "red_packet_delay_time", r7.g.a / com.bytedance.android.live.revenue.common.u0.b);
        BaseMonitor.add(r6, "red_packet_availableAt", r7.h.a);
        Long r4 = (Long) ((LinkedHashMap) r7.a).get("local_time");
        long r5 = 0;
        if (r4 == null) goto L23;
        long r8 = r4.longValue();
    L24:
        BaseMonitor.add(r6, "local_time", r8);
        Long r9 = (Long) ((LinkedHashMap) r7.a).get("server_time");
        if (r9 == null) goto L27;
        r5 = r9.longValue();
    L27:
        BaseMonitor.add(r6, "server_time", r5);
        return;
    L23:
        r8 = 0;
        goto L24
    L19:
        r3 = "IM";
        goto L20
    L15:
        BaseMonitor.add(r6, "red_packet_sender_id", r7.j.getIdString());
        goto L17
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L10
    }

    public static final void f(r0 r8, List<n0> r9) {
        Intrinsics.checkNotNullParameter(r8, "$this$monitorRedPacketFetchedSuccess");
        Intrinsics.checkNotNullParameter(r9, "redPacketList");
        JSONObject r7 = new JSONObject();
        BaseMonitor.add(r7, "red_packet_list_count", r9.size());
        a(r8, r7);
        if ((!r9.isEmpty()) == false) goto L8;
        Iterator<T> r10 = r9.iterator();
        int r12 = 0;
    L6:
        if (r10.hasNext() == false) goto L8;
        n0 r0 = (n0) r10.next();
        JSONObject r1 = new JSONObject();
        b(r1, r0);
        StringBuilder r2 = new StringBuilder("redpacketInfo");
        r2.append(r12);
        BaseMonitor.add(r7, r2.toString(), r1);
        r12 = r12 + 1;
    L8:
        JSONObject r5 = new JSONObject();
        JSONObject r6 = new JSONObject();
        BaseMonitor.add(r5, "status_code", DataType.FALSE);
        LiveTracingMonitor.k("ttlive_redpacket_fetched_status", LiveTracingMonitor.EventModule.LIVE_PROFIT, 0, r5, r6, r7);
    }

    public static final void c(JSONObject r3, RedPacketRushResult r4, String r5) {
        boolean r0 = r4 instanceof RedPacketRushResult.e;
        if (r0 == true) goto L5;
        RedPacketRushResult r2 = null;
    L6:
        RedPacketRushResult.e r6 = (RedPacketRushResult.e) r2;
        if (r6 == null) goto L9;
        int r7 = r6.a;
    L10:
        if (r0 == true) goto L12;
        r4 = null;
    L12:
        RedPacketRushResult.e r8 = (RedPacketRushResult.e) r4;
        if (r8 == null) goto L15;
        long r1 = r8.c;
    L16:
        BaseMonitor.add(r3, "red_packet_rush_result_coin_count", r7);
        BaseMonitor.add(r3, "red_packet_rush_result_gift_id", r1);
        BaseMonitor.add(r3, "red_packet_rush_result_status", r5);
        return;
    L15:
        r1 = 0;
        goto L16
    L9:
        r7 = 0;
        goto L10
    L5:
        r2 = r4;
        goto L6
    }

    public static final void e(String r7, Throwable r8, JSONObject r9) {
        JSONObject r4 = new JSONObject();
        JSONObject r5 = new JSONObject();
        BaseMonitor.add(r4, "status_code", "-1");
        BaseMonitor.add(r9, "error_code", com.bytedance.android.live.revenue.common.r0.a(r8));
        String r0 = com.bytedance.android.live.revenue.common.q0.a(r8);
        if (r0 != null) goto L5;
        r0 = r8.toString();
    L5:
        BaseMonitor.add(r9, "error_msg", r0);
        LiveTracingMonitor.k(r7, LiveTracingMonitor.EventModule.LIVE_PROFIT, 0, r4, r5, r9);
    }

    public static final void g(r0 r1, n0 r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "$this$monitorRedPacketFromIMDataSource");
        Intrinsics.checkNotNullParameter(r2, "redPacketInfo");
        Intrinsics.checkNotNullParameter(r3, "statusMsg");
        JSONObject r0 = new JSONObject();
        a(r1, r0);
        b(r0, r2);
        BaseMonitor.add(r0, "red_packet_from_im_status", r3);
        d("ttlive_redpacket_from_im_status", "red_packet_from_im_status", r3, r0);
    }

    public static final void d(String r7, String r8, String r9, JSONObject r10) {
        JSONObject r4 = new JSONObject();
        JSONObject r5 = new JSONObject();
        BaseMonitor.add(r4, "status_code", DataType.FALSE);
        BaseMonitor.add(r4, r8, r9);
        LiveTracingMonitor.k(r7, LiveTracingMonitor.EventModule.LIVE_PROFIT, 0, r4, r5, r10);
    }
}
