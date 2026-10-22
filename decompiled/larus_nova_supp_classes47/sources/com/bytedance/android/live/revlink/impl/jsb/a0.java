package com.bytedance.android.live.revlink.impl.jsb;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revlink.impl.monitor.LiveFullLinkPKMonitor;
import com.bytedance.android.live.revlink.impl.region.RevLinkWindowRegionContext;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.cn.registry.core.RevenueSendStreamXEventResultModel;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a0 extends wy0.b<me7.m, RevenueSendStreamXEventResultModel> {
    public final Type a;
    public final com.bytedance.android.livesdk.revenue.service.room.c b;
    public final com.bytedance.android.live.revlink.impl.global.c c;

    public static final class a {
    }

    static {
    }

    public final com.bytedance.android.live.revlink.impl.multianchor.service.g m() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.c;
        if (r0 == null) goto L9;
        RevLinkWindowRegionContext r1 = r0.P8();
        if (r1 == null) goto L9;
        com.bytedance.live.datacontext.j<com.bytedance.android.live.revlink.impl.multianchor.service.g> r2 = r1.getPartnerService();
        if (r2 == null) goto L9;
        return (com.bytedance.android.live.revlink.impl.multianchor.service.g) r2.getValue();
    L9:
        return null;
    }

    @Override // wy0.b
    public final Type k() {
        return this.a;
    }

    public a0(com.bytedance.android.livesdk.revenue.service.room.c r1, com.bytedance.android.live.revlink.impl.global.c r2) {
        this.b = r1;
        this.c = r2;
        this.a = TypesJVMKt.getJavaType(Reflection.typeOf(me7.m.class));
    }

    @Override // wy0.b
    public final void l(vh7.j r13, CallContext r14) {
        me7.m r15 = (me7.m) r13;
        Intrinsics.checkNotNullParameter(r15, "param");
        Intrinsics.checkNotNullParameter(r14, "callContext");
        RevenueSendStreamXEventResultModel r16 = new RevenueSendStreamXEventResultModel();
        Integer r0 = r15.getEvent();
        if (r0 == null) goto L5;
        int r1 = r0.intValue();
    L6:
        JSONObject r2 = new JSONObject(String.valueOf(r15.getExtra()));
        String r3 = r15.G();
        String r4 = "";
        if (r3 != null) goto L9;
        r3 = "";
    L9:
        String r5 = r15.c();
        if (r5 != null) goto L12;
        r5 = "";
    L12:
        JSONObject r6 = new JSONObject();
        com.bytedance.android.livesdk.revenue.service.room.c r7 = this.b;
        if (r7 == null) goto L22;
        com.bytedance.android.livesdk.revenue.room.a r8 = r7.getRoomContext();
        if (r8 == null) goto L22;
        IRoomBase r9 = r8.getCommonRoom();
        if (r9 == null) goto L22;
        IBaseUser r10 = r9.getOwnerKt();
        if (r10 == null) goto L22;
        String r12 = r10.getIdString();
        if (r12 == null) goto L22;
    L23:
        LinkedHashMap r17 = new LinkedHashMap();
        r17.put("event", Integer.valueOf(r1));
        r17.put("extra", String.valueOf(r2));
        r17.put("rtcKey", r3);
        r17.put("layoutKey", r5);
        com.bytedance.android.live.revlink.impl.global.c r18 = this.c;
        if (r18 == null) goto L28;
        LiveFullLinkPKMonitor r19 = r18.getLiveFullLinkPKMonitor();
        if (r19 == null) goto L28;
        LiveFullLinkPKMonitor.t(r19, "send_stream_x_event", null, r17, 2);
    L28:
        jy0.b.c("RevenueSendStreamXEventMethod", "SendSteamXEvent event: " + r1 + ", extra: " + r2 + ", rtcKey: " + r3 + ", layoutKey: " + r5 + ", self = " + r12, null, 4);
        if (r1 == 0) goto L45;
        if (r1 == 1) goto L39;
        if (r1 != 2) goto L84;
        com.bytedance.android.live.revlink.impl.multianchor.service.g r110 = m();
        if (r110 == null) goto L36;
        r110.k(null, null, null);
    L36:
        com.bytedance.android.live.revlink.impl.multianchor.service.g r111 = m();
        if (r111 == null) goto L84;
        r111.x(false);
    L84:
        r16.a(RevenueSendStreamXEventResultModel.Code.Success);
        finishWithSuccess();
        return;
    L39:
        r6.put("action", "send_effect_info");
        r6.put(Constants.Keys.DATA, r2);
        com.bytedance.android.live.revlink.impl.multianchor.service.g r20 = m();
        if (r20 == null) goto L42;
        r20.k(r5, r3, String.valueOf(r15.getExtra()));
    L42:
        com.bytedance.android.live.revlink.impl.multianchor.service.g r112 = m();
        if (r112 == null) goto L84;
        r112.A("director_view_stream_x_".concat(r12), r6.toString());
        goto L84
    L45:
        com.bytedance.android.live.revlink.impl.multianchor.service.g r22 = m();
        if (r22 == null) goto L48;
        r22.k(r5, r3, String.valueOf(r15.getExtra()));
    L48:
        com.bytedance.android.live.revlink.impl.multianchor.service.g r113 = m();
        if (r113 == null) goto L51;
        r113.e(r12);
    L51:
        com.bytedance.android.live.revlink.impl.multianchor.service.g r114 = m();
        if (r114 != null) goto L54;
    L68:
        com.bytedance.android.live.revlink.impl.multianchor.service.g r115 = m();
        if (r115 == null) goto L71;
        r115.h();
    L71:
        com.bytedance.android.live.revlink.impl.multianchor.service.g r116 = m();
        if (r116 == null) goto L84;
        com.bytedance.android.livesdk.revenue.service.room.c r23 = this.b;
        if (r23 == null) goto L83;
        com.bytedance.android.livesdk.revenue.room.a r24 = r23.getRoomContext();
        if (r24 == null) goto L83;
        IRoomBase r25 = r24.getCommonRoom();
        if (r25 == null) goto L83;
        String r26 = r25.getIdStr();
        if (r26 == null) goto L83;
        r4 = r26;
    L83:
        r116.f(r4, "output_view_stream_x_".concat(r12));
        goto L84
    L54:
        if (r114.l() != true) goto L68;
        com.bytedance.android.live.revlink.impl.multianchor.service.g r117 = m();
        if (r117 == null) goto L86;
        com.bytedance.android.livesdk.revenue.service.room.c r118 = this.b;
        if (r118 == null) goto L67;
        com.bytedance.android.livesdk.revenue.room.a r119 = r118.getRoomContext();
        if (r119 == null) goto L67;
        IRoomBase r120 = r119.getCommonRoom();
        if (r120 == null) goto L67;
        String r121 = r120.getIdStr();
        if (r121 == null) goto L67;
        r4 = r121;
    L67:
        r117.f(r4, "output_view_stream_x_".concat(r12));
        return;
    L86:
        return;
    L22:
        r12 = DataType.FALSE;
        goto L23
    L5:
        r1 = -1;
        goto L6
    }
}
