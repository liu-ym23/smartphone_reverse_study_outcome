package com.bytedance.android.live.revenuelink.connect;

import androidx.lifecycle.LiveData;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.message.m0;
import com.bytedance.android.live.core.monitor.LiveTracingMonitorKt;
import com.bytedance.android.live.core.network.CustomApiServerException;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.saas.middleware.fresco.DefaultConfig;
import com.bytedance.android.livesdk.link.model.i6;
import com.bytedance.android.livesdk.link.model.k6;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.badger.collect.impl.constants.Constants;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class MultiLinkServerMonitor extends y50.b {
    public static final /* synthetic */ int e = 0;
    public final ArrayList<p> b;
    public final com.bytedance.android.live.revenuelink.withroom.a c;
    public final IRoomBase d;

    public static final class a {
    }

    static {
    }

    public MultiLinkServerMonitor(com.bytedance.android.live.revenuelink.withroom.a r1, IRoomBase r2) {
        this.c = r1;
        this.d = r2;
        this.b = new ArrayList();
    }

    public final void b(JSONObject r7, int r8, LiveTracingMonitorKt.EventModule r9) {
        Iterator<p> r0 = this.b.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().c(r7, r9);
        goto L4
    L6:
        com.bytedance.android.live.revenuelink.withroom.a r10 = this.c;
        long r1 = 0;
        if (r10 == null) goto L11;
        g r12 = r10.getAnchorConnectUtils();
        if (r12 == null) goto L11;
        long r2 = r12.getChannelId();
    L12:
        y50.b.a.c(r7, "channel_id", r2);
        com.bytedance.android.live.revenuelink.withroom.a r13 = this.c;
        if (r13 == null) goto L17;
        g r14 = r13.getAnchorConnectUtils();
        if (r14 == null) goto L17;
        long r3 = r14.getChannelId();
    L18:
        y50.b.a.c(r7, "event_session_id", r3);
        IRoomBase r15 = this.d;
        if (r15 != null) goto L21;
    L23:
        boolean r4 = false;
    L24:
        if (r4 == true) goto L27;
        r15 = null;
    L27:
        String r5 = DataType.FALSE;
        if (r15 == null) goto L42;
        IRoomBase r6 = this.d;
        if (r6 != null) goto L32;
    L34:
        String r16 = DataType.FALSE;
    L35:
        y50.b.a.d(r7, "room_id", r16);
        IRoomBase r17 = this.d;
        if (r17 != null) goto L38;
    L40:
        String r18 = "";
    L41:
        y50.b.a.d(r7, "anchor_id", r18);
        goto L42
    L38:
        if (x.a(r17) != true) goto L40;
        r18 = String.valueOf(iz.a.a(r15.getOwnerKt()));
        goto L41
    L32:
        if (x.a(r6) != true) goto L34;
        r16 = r15.getIdStr();
    L42:
        com.bytedance.android.live.revenuelink.withroom.a r19 = this.c;
        if (r19 == null) goto L52;
        com.bytedance.android.live.revenuelink.rtc.f r20 = r19.m0();
        if (r20 == null) goto L52;
        com.bytedance.android.live.revenuelink.rtc.i r22 = r20.getRtcManager();
        if (r22 == null) goto L52;
        if (r22.F() != true) goto L51;
        r1 = 1;
    L51:
        y50.b.a.c(r7, "is_client_mixstream", r1);
        y50.b.a.d(r7, "linker_session_id", r22.c0());
    L52:
        y50.b.a.b(r7, "scene", r8);
        com.bytedance.android.live.revenuelink.withroom.a r23 = this.c;
        if (r23 == null) goto L64;
        g r24 = r23.getAnchorConnectUtils();
        if (r24 == null) goto L64;
        LiveData<ey.f> r25 = r24.connectState();
        if (r25 == null) goto L64;
        ey.f r26 = (ey.f) r25.getValue();
        if (r26 == null) goto L64;
        String r27 = String.valueOf(r26.c);
        if (r27 == null) goto L64;
        r5 = r27;
    L64:
        y50.b.a.d(r7, "biz_type", r5);
        cy0.e.a.getClass();
        cy0.j r28 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r29 = com.bytedance.android.scope.m.b(r28).b(com.bytedance.android.livesdk.revenue.service.user.a.class);
        Intrinsics.checkNotNull(r29);
        y50.b.a.d(r7, "inviter_id", String.valueOf(iz.a.a(((com.bytedance.live.kmp.core.c) r29).b())));
        return;
    L21:
        if (x.a(r15) != true) goto L23;
        r4 = true;
    L17:
        r3 = 0;
    L11:
        r2 = 0;
        goto L12
    }

    public final void g(int r15, String r16, long r17, final String r19) {
        Intrinsics.checkNotNullParameter(r16, "apiPath");
        Intrinsics.checkNotNullParameter(r19, "reqFrom");
        LiveTracingMonitorKt r1 = LiveTracingMonitorKt.a;
        c(this, LiveTracingMonitorKt.a(r15), r15, r16, 0, "", r17, 0, new MultiLinkServerMonitor$monitorApiCallSuccess$1(r19), null, 320);
    }

    public static /* synthetic */ void e(MultiLinkServerMonitor r7, int r8, String r9, Throwable r10, long r12) {
        r7.d(r8, r9, r10, r12, MultiLinkServerMonitor$monitorApiCallFaild$1.INSTANCE);
    }

    public final void d(int r13, String r14, Throwable r15, long r16, Function1<? super JSONObject, Unit> r18) {
        Intrinsics.checkNotNullParameter(r14, "apiPath");
        Intrinsics.checkNotNullParameter(r18, "putExtra");
        LiveTracingMonitorKt r0 = LiveTracingMonitorKt.a;
        LiveTracingMonitorKt.EventModule r1 = LiveTracingMonitorKt.a(r13);
        if ((r15 instanceof ApiServerException) == false) goto L8;
        ApiServerException r2 = (ApiServerException) r15;
        int r4 = r2.getErrorCode();
        String r3 = r2.getErrorMsg();
        if (r3 != null) goto L7;
        r3 = "";
    L7:
        c(this, r1, r13, r14, r4, r3, r16, 0, r18, r15, 64);
        return;
    L8:
        c(this, r1, r13, r14, 1, String.valueOf(r15), r16, 0, r18, r15, 64);
    }

    public final void f(int r14, String r15, long r16, int r18, Function1<? super JSONObject, Unit> r19) {
        Intrinsics.checkNotNullParameter(r15, "apiPath");
        Intrinsics.checkNotNullParameter(r19, "putExtra");
        LiveTracingMonitorKt r0 = LiveTracingMonitorKt.a;
        c(this, LiveTracingMonitorKt.a(r14), r14, r15, 0, "", r16, r18, r19, null, DefaultConfig.MAX_CACHE_ENTRIES);
    }

    public static void h(MultiLinkServerMonitor r18, int r19, i6 r20, long r22, int r23, long r24, boolean r26, int r27) {
        if ((r27 & 64) == 0) goto L5;
        int r3 = 1;
    L7:
        if ((r27 & 128) == 0) goto L9;
        MultiLinkServerMonitor$monitorMessageReceive$1 r2 = MultiLinkServerMonitor$monitorMessageReceive$1.INSTANCE;
    L10:
        r18.getClass();
        Intrinsics.checkNotNullParameter(r20, "baseMessage");
        Intrinsics.checkNotNullParameter(r2, "putExtra");
        m0 r6 = r20.getCommonData();
        if (r6 == null) goto L56;
        String r7 = r6.getMethod();
        com.bytedance.android.live.revenuelink.withroom.a r8 = r18.c;
        if (r8 == null) goto L20;
        com.bytedance.android.live.revenuelink.f r9 = r8.getRevenueLinkTraceMonitor();
        if (r9 == null) goto L20;
        if (r9.X(r7) != true) goto L20;
        return;
    L20:
        LiveTracingMonitorKt r10 = LiveTracingMonitorKt.a;
        LiveTracingMonitorKt.EventModule r12 = LiveTracingMonitorKt.a(r19);
        JSONObject r13 = new JSONObject();
        Iterator<p> r14 = r18.b.iterator();
    L22:
        if (r14.hasNext() == false) goto L24;
        r14.next().e(r20, r13);
        goto L22
    L24:
        y50.b.a.c(r13, "server_message_type", r23);
        Long r15 = yh6.d.a(r20);
        if (r15 == null) goto L27;
        long r16 = r15.longValue();
    L28:
        y50.b.a.c(r13, "server_message_id", r16);
        Intrinsics.checkNotNullParameter(r6, "$this$createTimeKt");
        y50.b.a.c(r13, "server_message_fetch_time", r6.getCreateTime());
        y50.b.a.c(r13, "server_message_process_time", r24);
        Intrinsics.checkNotNullParameter(r6, "$this$logIdKt");
        y50.b.a.d(r13, "server_message_log_id", r6.getLogId());
        y50.b.a.c(r13, "server_message_channel_id", r22);
        y50.b.a.d(r13, "server_message_name", r6.getMethod());
        y50.b.a.b(r13, "is_trigger", r3);
        Intrinsics.checkNotNullParameter(r20, "$this$fromChannelFlexExt");
        if (r20.getFromChannelFlex() != 1) goto L31;
        String r4 = "rtm";
    L32:
        y50.b.a.d(r13, "msg_source", r4);
        SimpleDateFormat r5 = com.bytedance.live.kmp.util.e.a;
        long r17 = com.bytedance.android.livesdk.utils.ntp.a.a;
        Intrinsics.checkNotNullParameter(r20, "$this$getReceiveNtpTimeFlexEx");
        long r25 = r20.getReceiveNtpTimeFlex(r17);
        Intrinsics.checkNotNullParameter(r6, "$this$createTimeKt");
        y50.b.a.c(r13, Constants.Keys.duration, r25 - r6.getCreateTime());
        String r28 = DataType.FALSE;
        if (r26 == false) goto L35;
        String r29 = DataType.FALSE;
    L36:
        y50.b.a.d(r13, "from_status", r29);
        Intrinsics.checkNotNullParameter(r20, "$this$sceneExt");
        y50.b.a.d(r13, "scene", String.valueOf(r20.getScene()));
        k6 r30 = r20.getReply();
        if (r30 == null) goto L47;
        y50.b.a.d(r13, "reply_type", String.valueOf(r30.getReplyStatus()));
        if (Intrinsics.areEqual(b.d(), r30.getFromUid()) == false) goto L41;
        r28 = DataType.TRUE;
    L41:
        y50.b.a.d(r13, "to_self", r28);
        y50.b.a.d(r13, "to_biz_type", String.valueOf(r30.getToBizType()));
        Intrinsics.checkNotNullParameter(r20, "$this$isPermit");
        Intrinsics.checkNotNullParameter(r20, "$this$typeExt");
        if (((int) r20.getType2()) != 8) goto L44;
        boolean r32 = true;
    L45:
        if (r32 == false) goto L47;
        y50.b.a.d(r13, "permit_type", String.valueOf(r30.getReplyStatus()));
        goto L47
    L44:
        r32 = false;
    L47:
        r18.b(r13, r19, r12);
        r2.invoke(r13);
        HashMap r110 = new HashMap();
        r110.put("server_message_name", r6.getMethod());
        r110.put("android_event_key", r6.getMethod() + "_" + r20.getType2());
        com.bytedance.android.live.revenuelink.withroom.a r0 = r18.c;
        if (r0 == null) goto L54;
        com.bytedance.android.live.revenuelink.f r1 = r0.getRevenueLinkTraceMonitor();
        if (r1 == null) goto L55;
        Intrinsics.checkNotNullParameter(r6, "$this$logIdKt");
        r1.a0("ttlive_interact_message_receive", r12, r6.getLogId(), r110, r13, r22);
        return;
    L55:
        return;
    L54:
        return;
    L35:
        r29 = DataType.TRUE;
        goto L36
    L31:
        r4 = "ttlive";
        goto L32
    L27:
        r16 = 0;
        goto L28
    L56:
        return;
    L9:
        r2 = null;
        goto L10
    L5:
        r3 = 0;
        goto L7
    }

    public static void c(MultiLinkServerMonitor r14, LiveTracingMonitorKt.EventModule r15, int r16, String r17, int r18, String r19, long r20, int r22, Function1 r23, Throwable r24, int r25) {
        if ((r25 & 64) == 0) goto L5;
        int r3 = -1;
    L7:
        if ((r25 & 128) == 0) goto L9;
        Function1 r4 = MultiLinkServerMonitor$monitorApiCall$1.INSTANCE;
    L11:
        if ((r25 & DefaultConfig.MAX_CACHE_ENTRIES) == 0) goto L13;
        Throwable r2 = null;
    L14:
        com.bytedance.android.live.revenuelink.withroom.a r5 = r14.c;
        if (r5 == null) goto L21;
        com.bytedance.android.live.revenuelink.f r6 = r5.getRevenueLinkTraceMonitor();
        if (r6 == null) goto L21;
        if (r6.X(r17) != true) goto L21;
        return;
    L21:
        JSONObject r13 = new JSONObject();
        r14.b(r13, r16, r15);
        y50.b.a.c(r13, Constants.Keys.duration, r20);
        y50.b.a.d(r13, "server_api_name", r17);
        if (Intrinsics.areEqual(r17, "linkmic/invite/") == false) goto L45;
        com.bytedance.android.live.revenuelink.withroom.a r8 = r14.c;
        if (r8 == null) goto L44;
        g r9 = r8.getAnchorConnectUtils();
        if (r9 == null) goto L44;
        LiveData<ey.f> r10 = r9.connectState();
        if (r10 == null) goto L44;
        ey.f r12 = (ey.f) r10.getValue();
        if (r12 == null) goto L44;
        if (r12.d != 4) goto L44;
        com.bytedance.android.live.revenuelink.withroom.a r26 = r14.c;
        if (r26 == null) goto L44;
        g r27 = r26.getAnchorConnectUtils();
        if (r27 == null) goto L44;
        LiveData<ey.f> r28 = r27.connectState();
        if (r28 == null) goto L44;
        ey.f r29 = (ey.f) r28.getValue();
        if (r29 == null) goto L44;
        if (r29.b != 1) goto L44;
        y50.b.a.b(r13, "is_pk_to_multi", 1);
    L44:
        y50.b.a.b(r13, "is_pk_to_multi", 0);
    L45:
        if (r3 < 0) goto L47;
        y50.b.a.b(r13, "request_type", r3);
    L47:
        if (r2 != null) goto L49;
    L51:
        r4.invoke(r13);
        HashMap r110 = new HashMap();
        r110.put("server_api_name", r17);
        r110.put("android_event_key", r17);
        com.bytedance.android.live.revenuelink.withroom.a r0 = r14.c;
        if (r0 == null) goto L57;
        com.bytedance.android.live.revenuelink.f r7 = r0.getRevenueLinkTraceMonitor();
        if (r7 == null) goto L58;
        r7.c0("ttlive_interact_server_api_call", r15, r18, r19, r110, r13);
        return;
    L58:
        return;
    L57:
        return;
    L49:
        if ((r2 instanceof CustomApiServerException) == false) goto L51;
        y50.b.a.d(r13, "log_id", ((CustomApiServerException) r2).getXTtLogId());
        goto L51
    L13:
        r2 = r24;
        goto L14
    L9:
        r4 = r23;
        goto L11
    L5:
        r3 = r22;
        goto L7
    }
}
