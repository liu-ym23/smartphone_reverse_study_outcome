package com.bytedance.android.live.revlink.impl.utils;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.monitor.LiveTracingMonitorKt;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.monitor.LiveFullLinkPKMonitor;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class v extends y50.b {
    public final com.bytedance.android.livesdk.revenue.service.room.c b;
    public final com.bytedance.android.live.revlink.impl.global.c c;

    public v(com.bytedance.android.livesdk.revenue.service.room.c r1, com.bytedance.android.live.revlink.link.infra.lifecontrol.context.b r2) {
        this.b = r1;
        this.c = r2;
    }

    public final void b(String r9, JSONObject r10) {
        Intrinsics.checkNotNullParameter(r10, "extra");
        LiveTracingMonitorKt.EventModule r0 = LiveTracingMonitorKt.EventModule.PK;
        com.bytedance.android.live.revlink.impl.global.c r1 = this.c;
        com.bytedance.android.live.revenuelink.f r2 = null;
        if (r1 == null) goto L5;
        LiveFullLinkPKMonitor r3 = r1.getLiveFullLinkPKMonitor();
    L6:
        if (r3 == null) goto L8;
        r3.d(r10);
    L8:
        com.bytedance.android.live.revlink.impl.global.c r4 = this.c;
        if (r4 == null) goto L11;
        LinkCrossRoomDataHolder r5 = r4.getLinkCrossRoomDataHolder();
    L12:
        if (r5 == null) goto L14;
        Long r6 = Long.valueOf(r5.c());
    L15:
        y50.b.a.d(r10, "channel_id", String.valueOf(r6));
        com.bytedance.android.livesdk.revenue.service.room.c r7 = this.b;
        if (r7 == null) goto L20;
        com.bytedance.android.livesdk.revenue.room.a r8 = r7.getRoomContext();
        if (r8 == null) goto L20;
        IRoomBase r12 = r8.getCommonRoom();
    L21:
        IRoomBase r13 = (IRoom) r12;
        if (r13 != null) goto L24;
    L26:
        boolean r14 = false;
    L27:
        if (r14 == false) goto L29;
        IRoomBase r15 = r13;
    L30:
        String r16 = "";
        if (r15 == null) goto L47;
        if (r13 != null) goto L34;
    L36:
        String r17 = "";
    L37:
        y50.b.a.d(r10, "room_id", r17);
        if (r13 != null) goto L40;
    L45:
        String r18 = "";
    L46:
        y50.b.a.d(r10, "anchor_id", r18);
        goto L47
    L40:
        if (com.bytedance.android.live.revlink.impl.monitor.a.a(r13) != true) goto L45;
        IBaseUser r19 = r15.getOwnerKt();
        if (r19 == null) goto L45;
        r18 = r19.getIdString();
        if (r18 != null) goto L46;
    L34:
        if (com.bytedance.android.live.revlink.impl.monitor.a.a(r13) != true) goto L36;
        r17 = r15.getIdStr();
    L47:
        com.bytedance.android.live.revlink.impl.global.c r20 = this.c;
        if (r20 == null) goto L50;
        w31.c r22 = r20.getPkLinkUtils();
    L51:
        if (r22 == null) goto L63;
        IRoomBase r23 = r22.k();
        if (r23 == null) goto L63;
        y50.b.a.d(r10, "to_room_id", String.valueOf(IRoomKtKt.getId(r23)));
        if (r23.getOwnerKt() == null) goto L63;
        IBaseUser r24 = r23.getOwnerKt();
        if (r24 == null) goto L62;
        Intrinsics.checkNotNullParameter(r24, "$this$secUidExt");
        String r25 = r24.getCastSecUid();
        if (r25 == null) goto L62;
        r16 = r25;
    L62:
        y50.b.a.d(r10, "set_to_user_id", r16);
    L63:
        y50.b.a.d(r10, "business_api_name", r9);
        HashMap r26 = new HashMap();
        r26.put("android_event_key", "ttlive_link_business_api_call");
        r26.put("business_api_name", r9);
        com.bytedance.android.live.revlink.impl.global.c r27 = this.c;
        if (r27 == null) goto L66;
        r2 = r27.getRevenueLinkTraceMonitor();
    L66:
        if (r2 == null) goto L69;
        com.bytedance.android.live.revenuelink.f.a.a(r2, "ttlive_link_business_api_call", r0, r26, r10);
        return;
    L69:
        return;
    L50:
        r22 = null;
        goto L51
    L29:
        r15 = null;
        goto L30
    L24:
        if (com.bytedance.android.live.revlink.impl.monitor.a.a(r13) != true) goto L26;
        r14 = true;
    L20:
        r12 = null;
        goto L21
    L14:
        r6 = null;
        goto L15
    L11:
        r5 = null;
        goto L12
    L5:
        r3 = null;
        goto L6
    }
}
