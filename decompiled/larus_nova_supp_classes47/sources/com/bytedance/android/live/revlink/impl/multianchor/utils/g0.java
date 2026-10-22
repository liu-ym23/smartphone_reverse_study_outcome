package com.bytedance.android.live.revlink.impl.multianchor.utils;

import com.bytedance.android.live.revlink.impl.global.LinkFakeGlobalService;
import com.bytedance.android.live.revlink.impl.multianchor.connect.AnchorRtcConnectUtilsKt;
import com.bytedance.android.livesdk.link.model.bridge.v1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g0 extends e {

    public static final class a {
    }

    static {
    }

    public final v o() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.d;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getMultiLinkMonitor();
    }

    public final void m(f21.a r5) {
        if (r5 == null) goto L5;
        v1 r1 = r5.q;
    L6:
        if (r1 != null) goto L8;
    L9:
        jy0.b.c("ttlive_anchor_connect", "empty rtc liveCore data when enter link", null, 4);
        JSONObject r0 = new JSONObject();
        y50.b.a.d(r0, "connection_context", String.valueOf(r5));
        v r6 = o();
        if (r6 == null) goto L14;
        r6.I("empty_rtc_live_core_info_when_enter_link", r0, true);
        return;
    L14:
        return;
    L8:
        if (r5.p == null) goto L9;
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void n(String r6) {
        Intrinsics.checkNotNullParameter(r6, "source");
        com.bytedance.android.live.revenuelink.rtc.f r4 = null;
        jy0.b.c("ttlive_anchor_connect", "empty forward room when join link, source=".concat(r6), null, 4);
        com.bytedance.android.live.revlink.impl.global.c r1 = this.d;
        if (r1 == null) goto L5;
        r4 = r1.m0();
    L5:
        if (r4 == null) goto L15;
        com.bytedance.android.live.revenuelink.rtc.i r2 = r4.getRtcManager();
        if (r2 != null) goto L9;
        return;
    L9:
        if (r2.isEngineOn() != true) goto L18;
        JSONObject r3 = new JSONObject();
        y50.b.a.d(r3, "source", r6);
        v r7 = o();
        if (r7 == null) goto L17;
        r7.I("empty_forward_room_when_join_link", r3, true);
        return;
    L17:
        return;
    L18:
        return;
    }

    public final boolean p(String r4) {
        Intrinsics.checkNotNullParameter(r4, "linkmicId");
        if (((Boolean) AnchorRtcConnectUtilsKt.b.getValue()).booleanValue() == true) goto L5;
        return false;
    L5:
        com.bytedance.android.live.revlink.impl.global.c r0 = this.d;
        com.bytedance.android.livesdk.link.model.bridge.j r2 = null;
        if (r0 == null) goto L8;
        i11.b r1 = r0.c8();
    L9:
        if (r1 == null) goto L13;
        com.bytedance.android.livesdk.link.model.p r5 = r1.v(r4);
        if (r5 == null) goto L13;
        r2 = com.bytedance.android.livesdk.link.model.q.b(r5);
    L13:
        if (r2 == null) goto L16;
        return true;
    L16:
        return false;
    L8:
        r1 = null;
        goto L9
    }

    public g0(ld.a r1, com.bytedance.android.livesdk.revenue.service.room.c r2, LinkFakeGlobalService r3) {
        super(r1, r2, r3);
    }
}
