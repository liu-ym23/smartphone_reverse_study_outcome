package com.bytedance.android.live.revenuelink.connect;

import com.bytedance.android.live.core.monitor.LiveTracingMonitorKt;
import com.bytedance.android.live.revenuelink.withroom.LinkStoreService;
import com.bytedance.android.livesdk.link.model.bridge.g1;
import com.bytedance.android.livesdk.link.model.i6;
import com.bytedance.android.livesdk.message.model.qj;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.live.kmp.statemachine.StateMachine;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e implements k {
    public final com.bytedance.android.live.revenuelink.withroom.a a;

    public static final class a {
    }

    static {
    }

    public e(LinkStoreService r2) {
        Intrinsics.checkNotNullParameter(r2, "linkStoreService");
        this.a = r2;
    }

    @Override // com.bytedance.android.live.revenuelink.connect.k
    public final void a(StateMachine.c.b<? extends ey.f, ? extends ey.e, ? extends ey.l> r12) {
        Intrinsics.checkNotNullParameter(r12, "validTransition");
        JSONObject r7 = new JSONObject();
        r7.put("from_state", ((ey.f) r12.a).d);
        r7.put("to_state", ((ey.f) r12.c).d);
        r7.put("channel_id", ((ey.f) r12.c).a);
        r7.put("to_scene", ((ey.f) r12.c).b);
        r7.put("to_biz_type", ((ey.f) r12.c).c);
        r7.put("linkmic_id", ((ey.f) r12.c).e);
        r7.put("rtc_info", ((ey.f) r12.c).f);
        ey.f r0 = (ey.f) r12.c;
        int r4 = r0.d;
        char r1 = 0;
        if (r4 == 0) goto L8;
        if (r0.a > 0) goto L8;
        String r2 = "invalid_channelID";
    L22:
        String r5 = r2;
        ey.f r13 = (ey.f) r12.c;
        Intrinsics.checkNotNullParameter(r13, "$this$classicScene");
        int r14 = r13.c;
        if (r14 == 0) goto L31;
        if (r14 != 1) goto L26;
    L30:
        r1 = 1;
    L32:
        HashMap r6 = new HashMap();
        if (r1 != 1) goto L35;
        LiveTracingMonitorKt.EventModule r15 = LiveTracingMonitorKt.EventModule.PK;
    L36:
        LiveTracingMonitorKt.EventModule r3 = r15;
        r6.put("android_event_key", "link_connect_state_change");
        com.bytedance.android.live.revenuelink.withroom.a r16 = this.a;
        if (r16 == null) goto L39;
        com.bytedance.android.live.revenuelink.f r17 = r16.getRevenueLinkTraceMonitor();
    L40:
        com.bytedance.android.live.revenuelink.f r8 = r17;
        if (r8 == null) goto L44;
        r8.Y("link_connect_state_change", r3, r4, r5, r6, r7, null, null);
        return;
    L44:
        return;
    L39:
        r17 = null;
        goto L40
    L35:
        r15 = LiveTracingMonitorKt.EventModule.MULTI_LINKER;
        goto L36
    L26:
        if (r14 == 2) goto L30;
        if (r14 != 3) goto L32;
    L31:
        r1 = 7;
    L8:
        if (r4 == 4) goto L10;
    L21:
        r2 = "";
        goto L22
    L10:
        if (r0.e.length() != 0) goto L12;
        boolean r9 = true;
    L13:
        if (r9 == false) goto L16;
        r2 = "invalid_linkMicId_linking";
        goto L22
    L16:
        if (((ey.f) r12.c).f.length() != 0) goto L18;
        boolean r10 = true;
    L19:
        if (r10 == false) goto L21;
        r2 = "invalid_rtcInfo_linking";
        goto L22
    L18:
        r10 = false;
        goto L19
    L12:
        r9 = false;
        goto L13
    }

    @Override // com.bytedance.android.live.revenuelink.connect.k
    public final void b(StateMachine.c<? extends ey.f, ? extends ey.e, ? extends ey.l> r12) {
        Intrinsics.checkNotNullParameter(r12, "validTransition");
        LiveTracingMonitorKt.EventModule r0 = LiveTracingMonitorKt.EventModule.MULTI_LINKER;
        HashMap r1 = new HashMap();
        r1.put("android_event_key", "link_connect_event");
        JSONObject r2 = new JSONObject();
        r2.put("connect_event", ((ey.e) r12.a()).a);
        com.bytedance.android.live.revenuelink.f r6 = null;
        if (((ey.e) r12.a()).a != 10) goto L11;
        Object r4 = r12.a();
        if ((r4 instanceof ey.e.n) == true) goto L7;
        r4 = null;
    L7:
        ey.e.n r5 = (ey.e.n) r4;
        if (r5 == null) goto L11;
        r2.put("time_out_type", r5.c.b.getType());
    L11:
        if ((r12 instanceof StateMachine.c.a) == false) goto L18;
        if (((ey.f) r12.b()).d != 4) goto L15;
        r2.put("connect_event_type", "linking_event");
    L16:
        r2.put("from_state", ((ey.f) r12.b()).d);
    L24:
        jy0.b.c("ConnectDataContext", "link_connect_event mode: " + r0 + " index: " + r1 + " extra: " + r2, null, 4);
        com.bytedance.android.live.revenuelink.withroom.a r13 = this.a;
        if (r13 == null) goto L27;
        r6 = r13.getRevenueLinkTraceMonitor();
    L27:
        if (r6 == null) goto L30;
        com.bytedance.android.live.revenuelink.f.a.a(r6, "link_connect_event", r0, r1, r2);
        return;
    L30:
        return;
    L15:
        r2.put("connect_event_type", "error");
        goto L16
    L18:
        if ((r12 instanceof StateMachine.c.b) == false) goto L24;
        StateMachine.c.b r9 = (StateMachine.c.b) r12;
        if (((ey.f) r12.b()).d != ((ey.f) r9.c).d) goto L22;
        r2.put("connect_event_type", "empty");
    L23:
        r2.put("from_state", ((ey.f) r12.b()).d);
        r2.put("to_state", ((ey.f) r9.c).d);
        goto L24
    L22:
        r2.put("connect_event_type", "valid");
        goto L23
    }

    @Override // com.bytedance.android.live.revenuelink.connect.k
    public final void c(ConnectAutoRejectType r10, i6 r12) {
        Intrinsics.checkNotNullParameter(r10, "rejectType");
        Intrinsics.checkNotNullParameter(r12, Constants.OperatorKey.MSG);
        JSONObject r0 = new JSONObject();
        r0.put("msg_id", qj.a(r12));
        Intrinsics.checkNotNullParameter(r12, "$this$linkerIdExt");
        r0.put("msg_linker_id", r12.getLinkerId());
        Intrinsics.checkNotNullParameter(r12, "$this$sceneExt");
        r0.put("msg_scene", r12.getScene());
        g1 r2 = r12.getInvite();
        if (r2 == null) goto L5;
        g1 r3 = r2;
        Intrinsics.checkNotNullParameter(r3, "$this$fromUid");
        r0.put("invite_from_user", r3.get_fromUid());
        r0.put("invite_from_room", r2.getFromRoomId());
        r0.put("invite_source", r2.getInviteSource());
    L5:
        r0.put("error_code", r10.ordinal());
        r0.put("error_msg", r10.getType());
        HashMap r6 = new HashMap();
        r6.put("android_event_key", "connect_auto_reject_invite");
        com.bytedance.android.live.revenuelink.withroom.a r4 = this.a;
        if (r4 == null) goto L8;
        com.bytedance.android.live.revenuelink.f r5 = r4.getRevenueLinkTraceMonitor();
    L9:
        if (r5 == null) goto L11;
        LiveTracingMonitorKt r7 = LiveTracingMonitorKt.a;
        Intrinsics.checkNotNullParameter(r12, "$this$sceneExt");
        r5.c0("connect_auto_reject_invite", LiveTracingMonitorKt.a((int) r12.getScene()), r10.ordinal(), r10.name(), r6, r0);
    L11:
        jy0.b.c(ConnectDataContext.TAG, "connect_auto_reject_invite " + r10 + ' ' + r0, null, 4);
        return;
    L8:
        r5 = null;
        goto L9
    }
}
