package com.bytedance.android.live.revlink.impl.multianchor.utils;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.j1;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revenuelink.connect.ConnectDataContext;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.global.LinkFakeGlobalService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.MapsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class l {
    public final com.bytedance.android.livesdk.revenue.service.room.c a;
    public final com.bytedance.android.live.revlink.impl.global.c b;

    public static final class a {
    }

    static {
    }

    public final void b(Map<String, String> r5) {
        com.bytedance.android.livesdk.revenue.service.room.c r0 = this.a;
        if (r0 == null) goto L27;
        com.bytedance.android.livesdk.revenue.room.a r1 = r0.getRoomContext();
        if (r1 == null) goto L28;
        IRoomBase r2 = r1.getCommonRoom();
        if (r2 == null) goto L29;
        IRoomBase r3 = (IRoom) r2;
        r5.put("room_id", String.valueOf(IRoomKtKt.getId(r3)));
        IBaseUser r4 = r3.getOwnerKt();
        Long r6 = null;
        if (r4 == null) goto L11;
        String r7 = iz.a.a(r4);
    L12:
        r5.put("anchor_id", String.valueOf(r7));
        r5.put("live_type", j1.a(IRoomKtKt.getStreamType(r3)));
        com.bytedance.android.live.revlink.impl.global.c r8 = this.b;
        if (r8 == null) goto L15;
        d31.d r9 = r8.getRevLinkLogHelper();
    L16:
        if (r9 == null) goto L18;
        String r10 = r9.c();
    L19:
        r5.put("connection_type", r10);
        com.bytedance.android.live.revlink.impl.global.c r12 = this.b;
        if (r12 == null) goto L22;
        LinkCrossRoomDataHolder r13 = r12.getLinkCrossRoomDataHolder();
    L23:
        if (r13 == null) goto L25;
        r6 = Long.valueOf(r13.c());
    L25:
        r5.put("channel_id", String.valueOf(r6));
        return;
    L22:
        r13 = null;
        goto L23
    L18:
        r10 = "";
        goto L19
    L15:
        r9 = null;
        goto L16
    L11:
        r7 = null;
        goto L12
    L29:
        return;
    L28:
        return;
    }

    public l(com.bytedance.android.livesdk.revenue.service.room.c r1, LinkFakeGlobalService r2) {
        this.a = r1;
        this.b = r2;
    }

    public static void a(Map r4, f21.a r5) {
        r4.put("connection_enter_from", r5.c.toString());
        boolean r0 = r5.j;
        String r1 = DataType.TRUE;
        if (r0 == false) goto L5;
        Object r2 = DataType.TRUE;
    L6:
        r4.put("switch_channel", r2);
        r4.put("match_type", String.valueOf(r5.d));
        r4.put("invitee_list", r5.e);
        if (r5.k == false) goto L9;
        Object r3 = DataType.TRUE;
    L10:
        r4.put("multi_to_multi", r3);
        if (r5.h == true) goto L14;
        r1 = DataType.FALSE;
    L14:
        r4.put("from_pk_multi_invite", r1);
        return;
    L9:
        r3 = DataType.FALSE;
        goto L10
    L5:
        r2 = DataType.FALSE;
        goto L6
    }

    public final void c(String r12, Map<String, String> r13) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r1 = Result.constructor-impl(new JSONObject(MapsKt.toMap(r13)));     // Catch: Throwable -> L4
    L6:
        v r2 = null;
        if (Result.isFailure-impl(r1) == false) goto L9;
        r1 = null;
    L9:
        JSONObject r3 = (JSONObject) r1;
        if (r3 != null) goto L12;
        r3 = new JSONObject();
    L12:
        JSONObject r5 = r3;
        String r7 = (String) ((LinkedHashMap) r13).get("error_msg");
        jy0.b.f(ConnectDataContext.TAG, r12 + ' ' + r13, null, 4);
        com.bytedance.android.live.revlink.impl.global.c r14 = this.b;
        if (r14 == null) goto L15;
        v r15 = r14.getMultiLinkMonitor();
    L16:
        if (r15 == null) goto L18;
        r15.g(r5);
    L18:
        com.bytedance.android.live.revlink.impl.global.c r16 = this.b;
        if (r16 == null) goto L21;
        v r17 = r16.getMultiLinkMonitor();
    L22:
        if (r17 == null) goto L24;
        r17.c(r5);
    L24:
        com.bytedance.android.live.revlink.impl.global.c r18 = this.b;
        if (r18 == null) goto L27;
        r2 = r18.getMultiLinkMonitor();
    L27:
        v r4 = r2;
        if (r4 == null) goto L33;
        v.x(r4, r12, r5, 0, r7, null, 52);
        return;
    L33:
        return;
    L21:
        r17 = null;
        goto L22
    L15:
        r15 = null;
    L4:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L6
    }
}
