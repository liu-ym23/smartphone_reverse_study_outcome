package com.bytedance.android.live.revlink.impl.multianchor.connect;

import android.view.SurfaceView;
import android.view.TextureView;
import com.bytedance.android.livesdk.link.model.bridge.b2;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e {
    public AnchorRtcConnectModel a;
    public final HashMap<String, g21.a> b;
    public final com.bytedance.android.live.revlink.impl.global.c c;

    public static final class a {
    }

    static {
    }

    public final String a() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.c;
        if (r0 == null) goto L5;
        com.bytedance.android.live.revenuelink.connect.g r1 = r0.getAnchorConnectUtils();
    L6:
        if (r1 == null) goto L9;
        String r2 = r1.getLinkMicId();
        if (r2 == null) goto L9;
        return r2;
    L9:
        return "";
    L5:
        r1 = null;
        goto L6
    }

    public final void c() {
        AnchorRtcConnectModel r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("rtcConnectModel");
    L5:
        com.bytedance.live.datacontext.n<Map<String, Boolean>> r1 = r0.getFrameRenderState();
        HashMap<String, g21.a> r2 = this.b;
        LinkedHashMap r3 = new LinkedHashMap(MapsKt.mapCapacity(r2.size()));
        Iterator<T> r4 = r2.entrySet().iterator();
    L7:
        if (r4.hasNext() == false) goto L9;
        Map.Entry r5 = (Map.Entry) r4.next();
        r3.put(r5.getKey(), Boolean.valueOf(((g21.a) r5.getValue()).b));
        goto L7
    L9:
        r1.setValue(r3);
    }

    public final String toString() {
        StringBuilder r0 = new StringBuilder("{");
        r0.append("self=" + a() + ',');
        StringBuilder r1 = new StringBuilder("remote=");
        r1.append(this.b);
        r0.append(r1.toString());
        r0.append("}");
        return r0.toString();
    }

    public e(com.bytedance.android.live.revlink.impl.global.c r1) {
        this.c = r1;
        this.b = new HashMap();
    }

    public final void b(String r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "linkmicId");
        jy0.b.c("ttlive_anchor_connect_frame", "notifyFrameCanRender " + r5 + ' ' + r6, null, 4);
        g21.a r0 = this.b.get(r5);
        if (r0 == null) goto L10;
        r0.b = r6;
        if (r6 == false) goto L10;
        AnchorRtcConnectModel r7 = this.a;
        if (r7 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("rtcConnectModel");
    L9:
        r7.getOnNewFrameRenderEvent().post(TuplesKt.to(r5, r0));
    L10:
        c();
    }

    public final void d(com.bytedance.android.live.revenuelink.rtc.p r7, b2 r8) {
        Intrinsics.checkNotNullParameter(r7, "rtcUserList");
        this.b.clear();
        Iterator<T> r9 = r7.l().iterator();
    L3:
        g21.a r2 = null;
        if (r9.hasNext() == false) goto L20;
        com.bytedance.android.live.revenuelink.rtc.o r0 = (com.bytedance.android.live.revenuelink.rtc.o) r9.next();
        int r3 = g21.a.c;
        Object r4 = r0.c;
        if ((r4 instanceof fr2.l) == false) goto L9;
        r2 = new g21.b((fr2.l) r4, true);
    L14:
        if (r2 == null) goto L3;
        this.b.put(r0.b, r2);
        if (r8 == null) goto L19;
        if (AnchorRtcConnectUtilsKt.e(r8, r0.b) == true) goto L3;
    L19:
        r2.b = false;
        jy0.b.d("ttlive_anchor_connect_frame", "pk frame " + r0.b + " not online");
        goto L3
    L9:
        if ((r4 instanceof SurfaceView) == false) goto L12;
        r2 = new g21.c((SurfaceView) r4);
        goto L14
    L12:
        if ((r4 instanceof TextureView) == false) goto L14;
        r2 = new g21.d((TextureView) r4, true);
        goto L14
    L20:
        c();
        jy0.b.f("ttlive_anchor_connect_frame", "onPkSwitchLink " + this, null, 4);
    }

    public final void e(String r4, b2 r5) {
        Intrinsics.checkNotNullParameter(r4, "linkmicId");
        if (Intrinsics.areEqual(r4, a()) == false) goto L5;
        return;
    L5:
        g21.a r0 = this.b.get(r4);
        if (r0 != null) goto L8;
    L18:
        c();
        return;
    L8:
        if (r0.b != true) goto L18;
        if (r5 == null) goto L18;
        if (AnchorRtcConnectUtilsKt.e(r5, r4) == true) goto L18;
        jy0.b.f("ttlive_anchor_connect_frame", "rendered frame " + r4 + " become invalid since leaveMsg", null, 4);
        y41.f r6 = y41.f.N;
        r6.getClass();
        if (((Boolean) y41.f.i.getValue(r6, y41.f.a[7])).booleanValue() == false) goto L18;
        this.b.remove(r4);
        AnchorRtcConnectModel r7 = this.a;
        if (r7 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("rtcConnectModel");
    L17:
        r7.getOnRenderedFrameInvalidEvent().post(r4);
        goto L18
    }
}
