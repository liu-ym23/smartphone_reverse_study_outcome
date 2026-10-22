package com.bytedance.android.live.revlink.impl.multianchor.connect;

import com.bytedance.android.live.revlink.impl.multianchor.utils.g0;
import com.bytedance.android.live.revlink.impl.multianchor.utils.v;
import com.bytedance.android.live.revlink.impl.multianchor.utils.w;
import com.bytedance.android.livesdk.link.model.bridge.z1;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class f {
    public final com.bytedance.android.live.revenuelink.rtc.i a;
    public final AnchorRtcConnectModel b;
    public final com.bytedance.android.live.revlink.impl.multianchor.vm.b c;
    public final yz0.g d;
    public final w e;
    public final g0 f;

    public abstract d.a d();

    public final void a() {
        com.bytedance.android.live.revenuelink.rtc.i r0 = this.a;
        if (r0 == null) goto L6;
        r0.g1(d());
        return;
    }

    public final boolean b(String r5) {
        Intrinsics.checkNotNullParameter(r5, "linkId");
        w r0 = this.e;
        if (r0 != null) goto L5;
    L7:
        Map r1 = (Map) this.b.getPreRtcInfoMap().getValue();
        if (r1 == null) goto L16;
        Iterator r2 = r1.entrySet().iterator();
    L11:
        if (r2.hasNext() == false) goto L16;
        z1 r3 = (z1) ((Map.Entry) r2.next()).getValue();
        if (Intrinsics.areEqual(r3.getLinkmicIdStr(), r5) == false) goto L11;
        return AnchorRtcConnectUtilsKt.d(r3);
    L16:
        g0 r4 = this.f;
        if (r4 == null) goto L22;
        if (r4.p(r5) != true) goto L22;
        return true;
    L22:
        if (n41.a.a(r5) == null) goto L24;
        return true;
    L24:
        return false;
    L5:
        if (r0.c() == true) goto L7;
        return false;
    }

    public final void c(String r4) {
        Intrinsics.checkNotNullParameter(r4, "linkId");
        w r1 = this.e;
        if (r1 != null) goto L5;
        return;
    L5:
        if (r1.c() == true) goto L13;
        g0 r2 = this.f;
        if (r2 == null) goto L14;
        Intrinsics.checkNotNullParameter(r4, "linkId");
        JSONObject r0 = new JSONObject();
        int r3 = y50.b.a;
        y50.b.a.d(r0, "frame_uid", r4);
        v r5 = r2.o();
        if (r5 == null) goto L15;
        r5.I("unexpected_first_frame_render", r0, true);
        return;
    L15:
        return;
    L14:
        return;
    }

    public f(com.bytedance.android.live.revenuelink.rtc.i r2, AnchorRtcConnectManager r3, AnchorRtcConnectModel r4, com.bytedance.android.live.revlink.impl.multianchor.vm.b r5, yz0.g r6, w r7, g0 r8) {
        Intrinsics.checkNotNullParameter(r3, "rtcConnectionManager");
        Intrinsics.checkNotNullParameter(r4, "rtcConnectModel");
        this.a = r2;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
    }
}
