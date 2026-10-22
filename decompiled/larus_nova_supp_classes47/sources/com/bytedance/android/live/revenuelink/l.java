package com.bytedance.android.live.revenuelink;

import androidx.lifecycle.LiveData;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.monitor.LiveTracingMonitorKt;
import com.bytedance.android.live.core.monitor.trace.TraceMonitor;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revenue.platform.trace.api.ProductId;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class l {
    public static final void a(com.bytedance.android.live.revenuelink.withroom.a r16, g r17, JSONObject r18, JSONObject r19, JSONObject r20) {
        Intrinsics.checkNotNullParameter(r17, "meta");
        String r4 = r17.a;
        LiveTracingMonitorKt.EventModule r5 = r17.b;
        Map<String, Object> r6 = r17.c;
        int r7 = r17.d;
        String r8 = r17.e;
        String r9 = r17.f;
        long r10 = r17.g;
        com.bytedance.android.live.revenue.core.util.j.a r12 = com.bytedance.android.live.revenue.core.util.j.C0;
        com.bytedance.android.livesdk.revenue.service.room.c r13 = (dy0.b) com.bytedance.android.live.revenue.core.util.e.c(r12.a(), com.bytedance.android.livesdk.revenue.service.room.c.class);
        if (r13 == null) goto L7;
        com.bytedance.android.livesdk.revenue.room.a r14 = r13.getRoomContext();
        if (r14 == null) goto L7;
        IRoomBase r15 = r14.getCommonRoom();
    L8:
        IRoom r110 = (IRoom) r15;
        r6.put("app_id", Integer.valueOf(vh6.c.b(wh6.a.class).getAppId()));
        if (r6.containsKey("role_type") == true) goto L30;
        com.bytedance.android.livesdk.revenue.service.room.c r111 = (dy0.b) com.bytedance.android.live.revenue.core.util.e.c(r12.a(), com.bytedance.android.livesdk.revenue.service.room.c.class);
        if (r111 == null) goto L15;
        com.bytedance.android.livesdk.revenue.room.a r112 = r111.getRoomContext();
        if (r112 == null) goto L15;
        IRoomBase r113 = r112.getCommonRoom();
    L16:
        IRoom r114 = (IRoom) r113;
        IBaseUser r115 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.user.a.class).b();
        if (r115 == null) goto L19;
        String r116 = r115.getIdString();
    L20:
        if (r114 == null) goto L24;
        IBaseUser r117 = r114.getOwner();
        if (r117 == null) goto L24;
        String r118 = r117.getIdString();
    L26:
        if (Intrinsics.areEqual(r118, r116) == false) goto L28;
        String r119 = "2";
    L29:
        r6.put("role_type", r119);
        goto L30
    L28:
        r119 = DataType.TRUE;
    L24:
        r118 = null;
        goto L26
    L19:
        r116 = null;
    L15:
        r113 = null;
    L30:
        int r120 = com.bytedance.android.live.core.monitor.trace.e.m;
        com.bytedance.android.live.core.monitor.trace.e.a r22 = com.bytedance.android.live.core.monitor.trace.e.b.a(r4, r5.getTypeName());
        if (r10 != 0) goto L42;
        if (r16 == null) goto L40;
        com.bytedance.android.live.revenuelink.connect.f r23 = r16.Z0();
        if (r23 == null) goto L40;
        LiveData<ey.f> r24 = r23.connectState();
        if (r24 == null) goto L40;
        ey.f r25 = (ey.f) r24.getValue();
        if (r25 == null) goto L40;
        Long r26 = Long.valueOf(r25.a);
    L41:
        String r27 = String.valueOf(r26);
    L43:
        r22.a = r27;
        r22.c = ProductId.REVENUE_LINK.getString();
        r22.g = vh6.c.b(com.bytedance.android.livesdk.revenue.service.user.a.class).getCurrentUserId();
        Intrinsics.checkNotNullParameter(r6, "index");
        r22.j = r6;
        r22.h = Integer.valueOf(r7);
        r22.i = r8;
        if (r110 == null) goto L48;
        IBaseUser r28 = r110.getOwner();
        if (r28 == null) goto L48;
        String r29 = r28.getIdString();
    L49:
        r22.f = r29;
        if (r110 == null) goto L52;
        String r30 = r110.getIdStr();
    L53:
        r22.e = r30;
        r22.b = r9;
        com.bytedance.android.live.core.monitor.trace.e r32 = r22.a();
        if (xa1.f.a() == true) goto L56;
    L60:
        a60.e r0 = com.bytedance.android.live.core.monitor.trace.c.a;
        Intrinsics.checkNotNullParameter(r32, "traceMeta");
        TraceMonitor.i(r32, r18, r19, r20);
        return;
    L56:
        if (Intrinsics.areEqual(r17.c.get("sdk_api_name"), "start_interact_streaming") == false) goto L58;
    L59:
        jy0.b.c("rev_kibana_log", "do monitor with event: " + r17.a + ", module: " + r17.b + ", sdk_api_name: " + r17.c.get("sdk_api_name") + ", statusCode: " + r17.d + ", statusMsg: " + r17.e + ", logID: " + r17.f + ", channelID: " + r17.g + "category: " + r18 + ", metric: " + r19 + ", extra: " + r20, null, 4);
        goto L60
    L58:
        if (Intrinsics.areEqual(r17.c.get("sdk_api_name"), "join_channel_in_advance") == false) goto L60;
    L52:
        r30 = null;
    L48:
        r29 = null;
    L40:
        r26 = null;
        goto L41
    L42:
        r27 = String.valueOf(r10);
    L7:
        r15 = null;
        goto L8
    }
}
