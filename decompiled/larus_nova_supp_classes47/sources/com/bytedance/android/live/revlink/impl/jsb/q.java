package com.bytedance.android.live.revlink.impl.jsb;

import com.bytedance.android.live.base.model.message.m0;
import com.bytedance.android.live.browser.jsbridge.base.MonitorPKEventResultModel;
import com.bytedance.android.live.core.monitor.LiveTracingMonitorKt;
import com.bytedance.android.live.revlink.impl.monitor.LiveFullLinkPKMonitor;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.google.gson.JsonObject;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;
import org.json.JSONObject;
import w20.ub;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class q extends wy0.b<ub, MonitorPKEventResultModel> {
    public final Type a;
    public final boolean b;
    public final com.bytedance.android.live.revlink.impl.global.c c;

    @Override // wy0.b
    public final Type k() {
        return this.a;
    }

    public q(com.bytedance.android.livesdk.revenue.service.room.c r1, com.bytedance.android.live.revlink.impl.global.c r2) {
        this.c = r2;
        this.a = TypesJVMKt.getJavaType(Reflection.typeOf(ub.class));
        if (r1 == null) goto L7;
        com.bytedance.android.livesdk.revenue.room.a r3 = r1.getRoomContext();
        if (r3 == null) goto L7;
        boolean r4 = r3.getCommonIsAnchor();
    L8:
        this.b = r4;
        return;
    L7:
        r4 = false;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // wy0.b
    public final void l(vh7.j r20, CallContext r22) {
        ub r1 = (ub) r20;
        Intrinsics.checkNotNullParameter(r1, "param");
        Intrinsics.checkNotNullParameter(r22, "callContext");
        Intrinsics.checkNotNullParameter(r1, "$this$eventParamsEx");
        JsonObject r2 = r1.getEventParams();
        y50.b r3 = null;
        if (r2 == null) goto L7;
        String r4 = r2.toString();
        if (r4 == null) goto L7;
        JSONObject r5 = new JSONObject(r4);
    L8:
        jy0.b.d("ttlive_pk_monitor", "MonitorPKEventMethod invoke eventType = " + r1.getEventType() + ", eventParamsStr = " + r5 + ", isAnchor = " + this.b);
        if (r1.getEventType() != 0) goto L19;
        if (r5 == null) goto L12;
        Object r6 = r5.get("business_name");
    L13:
        com.bytedance.android.live.revlink.impl.global.c r7 = this.c;
        if (r7 == null) goto L16;
        LiveFullLinkPKMonitor r8 = r7.getLiveFullLinkPKMonitor();
    L17:
        if (r8 == null) goto L116;
        LiveFullLinkPKMonitor.t(r8, String.valueOf(r6), r5, null, 4);
    L116:
        MonitorPKEventResultModel r9 = new MonitorPKEventResultModel();
        r9.a(MonitorPKEventResultModel.Code.Success);
        finishWithResult(r9);
        return;
    L16:
        r8 = null;
        goto L17
    L12:
        r6 = null;
        goto L13
    L19:
        boolean r10 = true;
        long r12 = 0;
        String r13 = "";
        if (r1.getEventType() != 1) goto L81;
        HashMap r14 = new HashMap();
        if (r5 == null) goto L31;
        String r15 = JSONObjectProtectorUtils.getString(r5, "scene");
        if (r15 == null) goto L31;
        if (r15.length() <= 0) goto L28;
        boolean r16 = true;
    L29:
        if (r16 != true) goto L31;
        int r17 = JSONObjectProtectorUtils.getInt(r5, "scene");
    L32:
        if (r5 != null) goto L34;
    L36:
        String r18 = "";
    L37:
        if (r5 == null) goto L39;
        Iterator<String> r19 = r5.keys();
    L40:
        if (r19 == null) goto L45;
    L42:
        if (r19.hasNext() == false) goto L45;
        String r110 = r19.next();
        r14.put(r110, r5.get(r110).toString());
    L45:
        if (r18.length() > 0) goto L49;
        r10 = false;
    L49:
        if (r10 == false) goto L68;
        com.bytedance.android.live.revlink.impl.global.c r23 = this.c;
        if (r23 == null) goto L53;
        r3 = r23.getLiveFullLinkPKMonitor();
    L53:
        if (r3 == null) goto L116;
        if (r5 == null) goto L57;
        String r24 = JSONObjectProtectorUtils.getString(r5, "path");
        if (r24 == null) goto L57;
    L58:
        int r111 = CastIntegerProtector.parseInt(r18);
        if (r5 == null) goto L64;
        String r25 = JSONObjectProtectorUtils.getString(r5, "error_msg");
        if (r25 == null) goto L64;
        String r112 = r25;
    L65:
        if (r5 == null) goto L67;
        r12 = JSONObjectProtectorUtils.getLong(r5, Constants.Keys.duration);
    L67:
        Intrinsics.checkNotNullParameter(r24, "apiPath");
        Intrinsics.checkNotNullParameter(r112, Constants.Keys.ERROR);
        LiveFullLinkPKMonitor.q(r3, r24, r111, r112, r12, 0, r17, r14);
    L64:
        r112 = "";
    L57:
        r24 = "";
        goto L58
    L68:
        com.bytedance.android.live.revlink.impl.global.c r26 = this.c;
        if (r26 == null) goto L71;
        r3 = r26.getLiveFullLinkPKMonitor();
    L71:
        LiveFullLinkPKMonitor r27 = r3;
        if (r27 == 0) goto L116;
        if (r5 == null) goto L76;
        String r28 = JSONObjectProtectorUtils.getString(r5, "path");
        if (r28 == null) goto L76;
    L77:
        if (r5 == null) goto L79;
        r12 = JSONObjectProtectorUtils.getLong(r5, Constants.Keys.duration);
    L79:
        Intrinsics.checkNotNullParameter(r28, "apiPath");
        LiveFullLinkPKMonitor.q(r27, r28, 0, "", r12, 0, r17, r14);
    L76:
        r28 = "";
        goto L77
    L39:
        r19 = null;
        goto L40
    L34:
        if (r5.has("error_code") != true) goto L36;
        r18 = r5.get("error_code").toString();
        goto L37
    L28:
        r16 = false;
    L31:
        r17 = 1;
        goto L32
    L81:
        if (r1.getEventType() != 2) goto L116;
        if (r5 == null) goto L85;
        String r29 = JSONObjectProtectorUtils.getString(r5, "common");
        if (r29 == null) goto L85;
    L86:
        m0 r30 = (m0) GsonProtectorUtils.fromJson(l97.a.a, r29, TypesJVMKt.getJavaType(Reflection.typeOf(m0.class)));
        com.bytedance.android.live.revlink.impl.global.c r32 = this.c;
        if (r32 == null) goto L89;
        LiveFullLinkPKMonitor r33 = r32.getLiveFullLinkPKMonitor();
    L90:
        if (r33 == null) goto L116;
        com.bytedance.android.live.revlink.impl.global.c r34 = this.c;
        if (r34 == null) goto L94;
        r3 = r34.getLinkCrossRoomDataHolder();
    L94:
        if (r3 == null) goto L96;
        r12 = r3.c();
    L96:
        i97.a r35 = i97.a.a;
        long r36 = System.currentTimeMillis();
        if (r5 == null) goto L100;
        String r37 = JSONObjectProtectorUtils.getString(r5, "message");
        if (r37 == null) goto L100;
    L101:
        Intrinsics.checkNotNullParameter(r30, "commonData");
        Intrinsics.checkNotNullParameter(r37, "messageString");
        String r38 = r30.getMethod();
        com.bytedance.android.live.revenuelink.f r113 = r33.i();
        if (r113 != null) goto L104;
    L106:
        JSONObject r39 = new JSONObject();
        int r40 = y50.b.a;
        Intrinsics.checkNotNullParameter(r30, "$this$messageIdKt");
        y50.b.a.c(r39, "server_message_id", r30.getMessageId());
        Intrinsics.checkNotNullParameter(r30, "$this$createTimeKt");
        y50.b.a.c(r39, "server_message_fetch_time", r30.getCreateTime());
        y50.b.a.c(r39, "server_message_process_time", r36);
        Intrinsics.checkNotNullParameter(r30, "$this$logIdKt");
        String r42 = r30.getLogId();
        if (r42 != null) goto L109;
        r42 = "";
    L109:
        y50.b.a.d(r39, "server_message_log_id", r42);
        y50.b.a.c(r39, "server_message_channel_id", r12);
        String r43 = r30.getMethod();
        if (r43 == null) goto L113;
        r13 = r43;
    L113:
        y50.b.a.d(r39, "server_message_name", r13);
        y50.b.a.d(r39, "message_data", r37);
        r33.d(r39);
        HashMap r114 = new HashMap();
        r114.put("server_message_name", r30.getMethod());
        r114.put("android_event_key", r30.getMethod());
        com.bytedance.android.live.revenuelink.f r115 = r33.i();
        if (r115 == null) goto L116;
        LiveTracingMonitorKt.EventModule r116 = LiveTracingMonitorKt.EventModule.PK;
        Intrinsics.checkNotNullParameter(r30, "$this$logIdKt");
        r115.a0("ttlive_pk_server_message_receive", r116, r30.getLogId(), r114, r39, 0);
        goto L116
    L104:
        if (r113.X(r38) != true) goto L106;
    L100:
        r37 = "";
        goto L101
    L89:
        r33 = null;
    L85:
        r29 = "";
    L7:
        r5 = null;
        goto L8
    }
}
