package com.bytedance.android.live.profit.redpacket;

import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revenue.model.extension.IMainRoom;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomCart;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomSpecificSceneTypeInfo;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class o {
    public static final String c() {
        yz0.k r0 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r0 == null) goto L5;
        IRoom r1 = r0.getRoom();
    L7:
        if (r1 == null) goto L13;
        IRoomCart r2 = r1.getRoomCart();
        if (r2 == null) goto L13;
        if (r2.getShowCartExt() != 1) goto L13;
        return "ecom";
    L13:
        if (r1 == null) goto L21;
        IMainRoom r3 = iy0.e.a(r1);
        if (r3 == null) goto L21;
        IRoomSpecificSceneTypeInfo r4 = r3.getSceneTypeInfo();
        if (r4 == null) goto L21;
        if (r4.isLife() != true) goto L21;
        return "life";
    L21:
        if (r1 != null) goto L23;
    L25:
        return "other";
    L23:
        if (r1.getLiveRoomMode() != 1) goto L25;
        return "game";
    L5:
        r1 = null;
        goto L7
    }

    public static final String b(String r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "activityId");
        boolean r2 = true;
        if (r4.length() <= 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L12;
        if (r5 != 0) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == false) goto L12;
        return "vou_money";
    L9:
        r3 = false;
    L12:
        Intrinsics.checkNotNullParameter(r4, "activityId");
        if (r4.length() <= 0) goto L15;
        boolean r6 = true;
    L16:
        if (r6 == false) goto L22;
        if (r5 != 1) goto L19;
        boolean r7 = true;
    L20:
        if (r7 == false) goto L22;
        return "vou_gift";
    L19:
        r7 = false;
    L22:
        if (r5 != 0) goto L24;
        boolean r8 = true;
    L25:
        if (r8 == false) goto L27;
        return "money";
    L27:
        if (r5 == 1) goto L30;
        r2 = false;
    L30:
        if (r2 == false) goto L33;
        return "gift";
    L33:
        return String.valueOf(r5);
    L24:
        r8 = false;
        goto L25
    L15:
        r6 = false;
        goto L16
    L5:
        r1 = false;
        goto L6
    }

    public static final String f(String r3, long r4) {
        if (r3 != null) goto L15;
    L13:
        return "";
    L15:
        k r5 = (k) new Gson().fromJson(r3, k.class);     // Catch: Exception -> L14
        if (r5 == null) goto L13;
        Map<String, String> r6 = r5.a();     // Catch: Exception -> L14
        if (r6 == null) goto L13;
        String r7 = r6.get(String.valueOf(r4));     // Catch: Exception -> L14
        if (r7 != null) goto L12;
        return "";
    L12:
        return r7;
    }

    public static final void a(Map<String, String> r2, n0 r3, boolean r4) {
        r2.put("room_type", c());
        r2.put("redpackage_id", r3.d.toString());
        r2.put("redpackage_content", b(r3.q, r3.getType()));
        Intrinsics.checkNotNullParameter(r3, "$this$redPacketType");
        if (r3.g.a(com.bytedance.android.live.revenue.common.u0.f) <= 0) goto L5;
        String r0 = "countdown_five";
    L6:
        r2.put("redpackage_type", r0);
        r2.put("biz_type_id", String.valueOf(r3.l));
        r2.put("params_for_special", "tppp");
        if (r4 == false) goto L9;
        String r5 = DataType.TRUE;
    L10:
        r2.put("is_anchor", r5);
        return;
    L9:
        r5 = DataType.FALSE;
        goto L10
    L5:
        r0 = "immediate";
        goto L6
    }

    public static final void e(n0 r4, boolean r5, RedPacketMissReason r6) {
        Intrinsics.checkNotNullParameter(r4, "currentPacket");
        Intrinsics.checkNotNullParameter(r6, "reason");
        r4.getType();
        Intrinsics.checkNotNullParameter(r4, "redPacket");
        Intrinsics.checkNotNullParameter(r6, "reason");
        Pair[] r1 = new Pair[3];
        if (r5 == false) goto L5;
        String r2 = DataType.TRUE;
    L6:
        r1[0] = TuplesKt.to("is_anchor", r2);
        r1[1] = TuplesKt.to("reason", r6.getReasonString());
        r1[2] = TuplesKt.to("redpackage_send_num", f(r4.s, r4.l));
        Map<? extends String, ? extends String> r7 = MapsKt.mutableMapOf(r1);
        a(r7, r4, r5);
        mz0.n r8 = new mz0.n();
        Map<String, String> r9 = r8.a;
        Intrinsics.checkNotNullParameter(r9, "map");
        Intrinsics.checkNotNullParameter(r7, "map");
        r9.putAll(r7);
        mz0.m r10 = new mz0.m();
        r10.b(LogCommon.PAGE_SOURCE_LOG);
        r10.b(LogCommon.ROOM);
        List<Object> r12 = r8.b;
        ArrayList r13 = (ArrayList) r12;
        r13.addAll(r10.a);
        cy0.e.a.getClass();
        cy0.j r14 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r15 = com.bytedance.android.scope.m.b(r14).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r15);
        ((mz0.i) ((f80.a) r15)).w3("livesdk_redpackage_grab_disappear", r8.a, r8.b);
        return;
    L5:
        r2 = DataType.FALSE;
        goto L6
    }

    public static final void d(String r4, String r5, String r6, String r7) {
        com.bytedance.android.livesdk.revenue.service.room.c r0 = (dy0.b) com.bytedance.android.live.revenue.core.util.e.c(com.bytedance.android.live.revenue.core.util.j.C0.a(), com.bytedance.android.livesdk.revenue.service.room.c.class);
        if (r0 == null) goto L11;
        com.bytedance.android.livesdk.revenue.room.a r1 = r0.getRoomContext();
        if (r1 == null) goto L11;
        com.bytedance.live.datacontext.i r2 = r1.isAnchor();
        if (r2 == null) goto L11;
        Boolean r3 = (Boolean) r2.getValue();
        if (r3 == null) goto L11;
        boolean r8 = r3.booleanValue();
    L12:
        Map<? extends String, ? extends String> r9 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("is_anchor", String.valueOf(r8)), TuplesKt.to("is_success", DataType.FALSE), TuplesKt.to("redpackage_prize_result", "nop"), TuplesKt.to("redpackage_type", "countdown_five")});
        r9.put("redpackage_id_list", r4);
        r9.put("redpackage_content_list", r5);
        r9.put("redpackage_cnt", r6);
        if (r7 == null) goto L15;
        r9.put("redpackage_send_num_list", r7);
    L15:
        mz0.n r10 = new mz0.n();
        Map<String, String> r12 = r10.a;
        Intrinsics.checkNotNullParameter(r12, "map");
        Intrinsics.checkNotNullParameter(r9, "map");
        r12.putAll(r9);
        mz0.m r13 = new mz0.m();
        r13.b(LogCommon.PAGE_SOURCE_LOG);
        r13.b(LogCommon.ROOM);
        ((ArrayList) r10.b).addAll(r13.a);
        cy0.e.a.getClass();
        cy0.j r14 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r15 = com.bytedance.android.scope.m.b(r14).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r15);
        ((mz0.i) ((f80.a) r15)).w3("livesdk_redpackage_result_toast_show", r10.a, r10.b);
        return;
    L11:
        r8 = false;
        goto L12
    }
}
