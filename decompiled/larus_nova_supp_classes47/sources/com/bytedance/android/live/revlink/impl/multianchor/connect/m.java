package com.bytedance.android.live.revlink.impl.multianchor.connect;

import com.bytedance.android.live.revlink.impl.multianchor.utils.s;
import com.bytedance.android.live.revlink.impl.multianchor.utils.w;
import com.bytedance.android.live.revlink.impl.multianchor.vm.MultiLinkAnchorControlContext;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class m implements com.bytedance.android.live.revenuelink.rtc.h {
    public final com.bytedance.android.live.revlink.impl.global.c a;

    @Override // com.bytedance.android.live.revenuelink.rtc.h
    public final void b(String r2, JSONObject r3) {
        Intrinsics.checkNotNullParameter(r2, "sdkApiName");
        Intrinsics.checkNotNullParameter(r3, "extra");
    }

    public m(com.bytedance.android.live.revlink.impl.global.c r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.h
    public final void a(String r17, String r18, String r19, JSONObject r20, boolean r22) {
        Intrinsics.checkNotNullParameter(r17, "rtcCallBackName");
        Intrinsics.checkNotNullParameter(r18, "linkmicId");
        Intrinsics.checkNotNullParameter(r19, "statusMsg");
        Intrinsics.checkNotNullParameter(r20, "extra");
        int r4 = 0;
        Object r8 = null;
        if (r22 == false) goto L30;
        if (r18.length() <= 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == false) goto L27;
        com.bytedance.android.live.revlink.impl.global.c r2 = this.a;
        if (r2 == null) goto L16;
        com.bytedance.android.live.revenuelink.rtc.f r3 = r2.m0();
        if (r3 == null) goto L16;
        com.bytedance.android.live.revenuelink.rtc.i r5 = r3.getRtcManager();
        if (r5 == null) goto L16;
        String r6 = r5.f0();
    L18:
        if ((!Intrinsics.areEqual(r18, r6)) == false) goto L27;
        com.bytedance.android.live.revlink.impl.global.c r7 = this.a;
        if (r7 == null) goto L25;
        w31.c r9 = r7.getPkLinkUtils();
        if (r9 == null) goto L25;
        r8 = r9.b();
    L25:
        if ((!Intrinsics.areEqual(r18, r8)) == false) goto L27;
        r4 = 1;
    L16:
        r6 = null;
    L27:
        r20.put("interact_has_guest", r4);
        return;
    L7:
        r1 = false;
        goto L8
    L30:
        if (Intrinsics.areEqual(r17, "first_remote_video_frame_render") == false) goto L65;
        com.bytedance.android.live.revlink.impl.global.c r10 = this.a;
        if (r10 == null) goto L34;
        MultiLinkAnchorControlContext r12 = r10.ua();
    L35:
        if (r12 == null) goto L37;
        s r13 = r12.getConnectMonitor();
    L38:
        if (r13 == null) goto L65;
        HashMap r14 = new HashMap();
        Intrinsics.checkNotNullParameter(r18, "linkId");
        Intrinsics.checkNotNullParameter(r14, "common");
        if (u41.d.n.a() == false) goto L61;
        com.bytedance.android.live.revlink.impl.multianchor.utils.g r15 = r13.f(r18);
        LinkedHashMap r16 = new LinkedHashMap();
        Iterator r23 = r14.entrySet().iterator();
    L44:
        if (r23.hasNext() == false) goto L47;
        Map.Entry r110 = (Map.Entry) r23.next();
        r16.put(r110.getKey(), r110.getValue());
        goto L44
    L47:
        if (r15 == null) goto L49;
        i97.a r24 = i97.a.a;
        long r111 = System.currentTimeMillis();
        r16.put("is_pk_to_multi", Integer.valueOf(r15.k ? 1 : 0));
        r16.put("connection_id", r15.g);
        r16.put("connect_build_role", Integer.valueOf(r15.e.b));
        r16.put("first_frame_index", Integer.valueOf(r15.a));
        r16.put("first_frame_duration", Long.valueOf(r111 - r15.f));
        r16.put("connect_build_success", Integer.valueOf((!r15.b.isEmpty() ? 1 : 0) ^ 1));
        r16.put("from_status", Integer.valueOf(!r15.h ? 1 : 0));
        r16.put("opposite_status", Integer.valueOf(!r15.i ? 1 : 0));
        r16.put("wait_frame_total_count", Integer.valueOf(r15.c));
        r16.put("is_not_match_connect", 0);
    L58:
        if (Intrinsics.areEqual(r16.get("connect_build_success"), 1) == false) goto L60;
        jy0.b.d("ttlive_anchor_connect", "logFilter firstVideoFrameRender " + r18 + ' ' + r15 + ' ' + r16);
    L60:
        r14 = r16;
        goto L61
    L49:
        r16.put("is_not_match_connect", 1);
        com.bytedance.android.live.revlink.impl.global.c r25 = r13.c;
        if (r25 == null) goto L52;
        w r26 = r25.getMultiLinkUtil();
    L53:
        if (r26 != null) goto L55;
    L56:
        r16.put("is_pk_to_multi", 0);
        goto L58
    L55:
        if (r26.e() == true) goto L58;
    L52:
        r26 = null;
    L61:
        Iterator r27 = r14.keySet().iterator();
    L63:
        if (r27.hasNext() == false) goto L65;
        String r28 = (String) r27.next();
        r20.put(r28, String.valueOf(r14.get(r28)));
        goto L63
    L37:
        r13 = null;
        goto L38
    L34:
        r12 = null;
    L65:
        com.bytedance.android.live.revlink.impl.global.c r29 = this.a;
        if (r29 == null) goto L68;
        com.bytedance.android.live.revenuelink.connect.g r30 = r29.getAnchorConnectUtils();
    L69:
        if (r30 != null) goto L71;
        return;
    L71:
        if (r30.w1() != true) goto L83;
        r20.put("is_first_frame_optimize", AnchorRtcConnectUtilsKt.a(this.a) ? 1 : 0);
        com.bytedance.android.live.revlink.impl.global.c r32 = this.a;
        if (r32 == null) goto L75;
        r8 = r32.Hb();
    L75:
        if (r8 == null) goto L77;
        int r33 = 1;
    L78:
        r20.put("is_new_multi_channel_data", r33);
        return;
    L77:
        r33 = 0;
        goto L78
    L83:
        return;
    L68:
        r30 = null;
        goto L69
    }
}
