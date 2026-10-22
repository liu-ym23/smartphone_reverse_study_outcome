package com.bytedance.android.live.revenuelink.rtc;

import com.bytedance.android.live.core.monitor.LiveTracingMonitorKt;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revenuelink.connect.x;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class m extends y50.b {
    public final HashMap<LiveTracingMonitorKt.EventModule, h> b;
    public final IRoomBase c;
    public final boolean d;
    public final com.bytedance.android.live.revenuelink.withroom.a e;

    public static final class a {
    }

    static {
    }

    public final void e(String r7) {
        Intrinsics.checkNotNullParameter(r7, "sdkApiName");
        if (this.e.getRevenueLinkTraceMonitor().X(r7) == false) goto L5;
        return;
    L5:
        JSONObject r0 = new JSONObject();
        y50.b.a.d(r0, "sdk_api_name", r7);
        f r2 = this.e.m0();
        String r3 = "";
        if (r2 == null) goto L11;
        i r4 = r2.getRtcManager();
        if (r4 == null) goto L11;
        String r5 = r4.O();
        if (r5 == null) goto L11;
    L12:
        y50.b.a.d(r0, "channel_id", r5);
        y50.b.a.d(r0, "event_session_id", r5);
        f r6 = this.e.m0();
        if (r6 == null) goto L18;
        i r8 = r6.getRtcManager();
        if (r8 == null) goto L18;
        String r9 = r8.c0();
        if (r9 == null) goto L18;
    L19:
        y50.b.a.d(r0, "linker_session_id", r9);
        IRoomBase r10 = this.c;
        if (x.a(r10) == true) goto L23;
        r10 = null;
    L23:
        if (r10 != null) goto L25;
    L32:
        HashMap r12 = new HashMap();
        r12.put("sdk_api_name", r7);
        r12.put("business_api_name", r7);
        r12.put("android_event_key", "rtc_".concat(r7));
        if (this.d == false) goto L35;
        String r13 = "2";
    L36:
        r12.put("role_type", r13);
        com.bytedance.android.live.revenuelink.f.a.a(this.e.getRevenueLinkTraceMonitor(), "ttlive_interact_sdk_api_call", LiveTracingMonitorKt.EventModule.MULTI_LINKER, r12, r0);
        return;
    L35:
        r13 = "3";
        goto L36
    L25:
        if (x.a(this.c) == false) goto L27;
        String r14 = r10.getIdStr();
    L28:
        y50.b.a.d(r0, "room_id", r14);
        if (x.a(this.c) == false) goto L31;
        r3 = String.valueOf(iz.a.a(r10.getOwnerKt()));
    L31:
        y50.b.a.d(r0, "anchor_id", r3);
        goto L32
    L27:
        r14 = DataType.FALSE;
    L18:
        r9 = "";
    L11:
        r5 = "";
        goto L12
    }

    public m(IRoomBase r2, com.bytedance.android.live.revenuelink.withroom.a r3) {
        Intrinsics.checkNotNullParameter(r2, "room");
        Intrinsics.checkNotNullParameter(r3, "storeService");
        this.c = r2;
        this.d = true;
        this.e = r3;
        this.b = new HashMap();
    }

    public final void b(JSONObject r5, LiveTracingMonitorKt.EventModule r6) {
        f r7 = this.e.m0();
        String r0 = "";
        if (r7 == null) goto L8;
        i r8 = r7.getRtcManager();
        if (r8 == null) goto L8;
        String r9 = r8.O();
        if (r9 == null) goto L8;
    L9:
        y50.b.a.d(r5, "channel_id", r9);
        y50.b.a.d(r5, "event_session_id", r9);
        f r10 = this.e.m0();
        if (r10 == null) goto L15;
        i r12 = r10.getRtcManager();
        if (r12 == null) goto L15;
        String r13 = r12.c0();
        if (r13 == null) goto L15;
    L16:
        y50.b.a.d(r5, "linker_session_id", r13);
        IRoomBase r14 = this.c;
        if (x.a(r14) == true) goto L20;
        r14 = null;
    L20:
        String r1 = DataType.FALSE;
        if (r14 != null) goto L23;
    L30:
        f r15 = this.e.m0();
        if (r15 == null) goto L39;
        i r16 = r15.getRtcManager();
        if (r16 == null) goto L39;
        if (r16.F() == false) goto L37;
        long r2 = 1;
    L38:
        y50.b.a.c(r5, "is_client_mixstream", r2);
        goto L39
    L37:
        r2 = 0;
    L39:
        com.bytedance.android.live.revenuelink.connect.f r17 = this.e.Z0();
        if (r17 == null) goto L49;
        ey.f r18 = (ey.f) r17.connectState().getValue();
        if (r18 == null) goto L47;
        String r19 = String.valueOf(r18.c);
        if (r19 == null) goto L47;
        r1 = r19;
    L47:
        y50.b.a.d(r5, "biz_type", r1);
        return;
    L49:
        return;
    L23:
        if (x.a(this.c) == false) goto L25;
        String r3 = r14.getIdStr();
    L26:
        y50.b.a.d(r5, "room_id", r3);
        if (x.a(this.c) == false) goto L29;
        r0 = String.valueOf(iz.a.a(r14.getOwnerKt()));
    L29:
        y50.b.a.d(r5, "anchor_id", r0);
        goto L30
    L25:
        r3 = DataType.FALSE;
    L15:
        r13 = "";
    L8:
        r9 = "";
        goto L9
    }

    public final void c(LiveTracingMonitorKt.EventModule r5, String r6, Map<String, ? extends Object> r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r5, "eventModule");
        Intrinsics.checkNotNullParameter(r6, "sdkApiName");
        if (this.e.getRevenueLinkTraceMonitor().X(r6) == false) goto L5;
        return;
    L5:
        JSONObject r0 = new JSONObject();
        y50.b.a.d(r0, "sdk_api_name", r6);
        if (r7 == null) goto L11;
        Iterator<Map.Entry<String, ? extends Object>> r9 = r7.entrySet().iterator();
    L9:
        if (r9.hasNext() == false) goto L11;
        Map.Entry<String, ? extends Object> r2 = r9.next();
        r0.put(r2.getKey(), r2.getValue());
    L11:
        if (r8 == true) goto L15;
        b(r0, r5);
        h r10 = this.b.get(r5);
        if (r10 == null) goto L15;
        r10.b(r6, r0);
    L15:
        HashMap r12 = new HashMap();
        r12.put("sdk_api_name", r6);
        if (xa1.f.a() == false) goto L18;
        r12.put("business_api_name", "biz_".concat(r6));
    L18:
        r12.put("android_event_key", "rtc_".concat(r6));
        if (this.d == false) goto L21;
        String r13 = "2";
    L22:
        r12.put("role_type", r13);
        com.bytedance.android.live.revenuelink.f.a.a(this.e.getRevenueLinkTraceMonitor(), "ttlive_interact_sdk_api_call", r5, r12, r0);
        return;
    L21:
        r13 = "3";
        goto L22
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void d(m r0, LiveTracingMonitorKt.EventModule r1, String r2, Map r3, int r4) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        r0.c(r1, r2, r3, false);
    }

    public static /* synthetic */ void i(m r7, LiveTracingMonitorKt.EventModule r8, String r9, Map r10, String r12) {
        r7.h(r8, r9, r10, 0, r12, new HashMap());
    }

    public final void f(LiveTracingMonitorKt.EventModule r9, String r10, String r12, Map<String, ? extends Object> r13, int r14, String r15) {
        Intrinsics.checkNotNullParameter(r9, "eventModule");
        Intrinsics.checkNotNullParameter(r10, "rtcCallBackName");
        Intrinsics.checkNotNullParameter(r12, "linkmicId");
        Intrinsics.checkNotNullParameter(r15, "statusMsg");
        if (this.e.getRevenueLinkTraceMonitor().X(r10) == false) goto L5;
        return;
    L5:
        JSONObject r7 = new JSONObject();
        y50.b.a.d(r7, "rtc_callback_name", r10);
        y50.b.a.d(r7, "linkmic_id", r12);
        b(r7, r9);
        if (r13 == null) goto L11;
        Iterator<Map.Entry<String, ? extends Object>> r16 = r13.entrySet().iterator();
    L9:
        if (r16.hasNext() == false) goto L11;
        Map.Entry<String, ? extends Object> r0 = r16.next();
        r7.put(r0.getKey(), r0.getValue());
    L11:
        h r1 = this.b.get(LiveTracingMonitorKt.EventModule.MULTI_LINKER);
        if (r1 != null) goto L14;
    L18:
        HashMap r6 = new HashMap();
        r6.put("sdk_callback_name", r10);
        if (this.d == false) goto L21;
        String r17 = "2";
    L22:
        r6.put("role_type", r17);
        r6.put("android_event_key", "callback_".concat(r10));
        this.e.getRevenueLinkTraceMonitor().c0("ttlive_interact_sdk_callback", r9, r14, r15, r6, r7);
        return;
    L21:
        r17 = "3";
        goto L22
    L14:
        if (r9 != LiveTracingMonitorKt.EventModule.PK) goto L16;
        boolean r8 = true;
    L17:
        r1.a(r10, r12, r15, r7, r8);
        goto L18
    L16:
        r8 = false;
        goto L17
    }

    public final void h(LiveTracingMonitorKt.EventModule r9, String r10, Map<String, ? extends Object> r12, int r13, String r14, Map<String, Object> r15) {
        Intrinsics.checkNotNullParameter(r9, "eventModule");
        Intrinsics.checkNotNullParameter(r10, "eventName");
        Intrinsics.checkNotNullParameter(r14, "statusMsg");
        Intrinsics.checkNotNullParameter(r15, "index");
        if (this.e.getRevenueLinkTraceMonitor().X(r10) == false) goto L5;
        return;
    L5:
        JSONObject r7 = new JSONObject();
        b(r7, r9);
        if (r12 == null) goto L11;
        Iterator<Map.Entry<String, ? extends Object>> r16 = r12.entrySet().iterator();
    L9:
        if (r16.hasNext() == false) goto L11;
        Map.Entry<String, ? extends Object> r0 = r16.next();
        r7.put(r0.getKey(), r0.getValue());
    L11:
        r15.put("android_event_key", r10);
        this.e.getRevenueLinkTraceMonitor().c0(r10, r9, r13, r14, r15, r7);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void g(m r9, LiveTracingMonitorKt.EventModule r10, String r12, String r13, Map r14, int r15, int r16) {
        String r1 = null;
        if ((r16 & 8) == 0) goto L5;
        Map r6 = null;
    L7:
        if ((r16 & 16) == 0) goto L9;
        int r7 = 0;
    L11:
        if ((r16 & 32) == 0) goto L13;
        r1 = "";
    L13:
        r9.f(r10, r12, r13, r6, r7, r1);
        return;
    L9:
        r7 = r15;
        goto L11
    L5:
        r6 = r14;
        goto L7
    }
}
