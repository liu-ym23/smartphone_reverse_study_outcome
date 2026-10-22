package com.bytedance.android.livesdk.chatroom.ui;

import android.view.ScaleGestureDetector;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h7 implements ScaleGestureDetector.OnScaleGestureListener {
    public final com.bytedance.android.live.pushstream.d a;
    public final DataCenter b;

    public static final class a {
    }

    static {
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public final boolean onScale(ScaleGestureDetector r9) {
        Intrinsics.checkNotNullParameter(r9, "detector");
        double r0 = r9.getScaleFactor();
        if (Math.abs(r0 - 1.0d) >= 0.03d) goto L7;
        return false;
    L7:
        if (r0 <= 1.0d) goto L9;
        float r10 = 0.1f;
    L10:
        com.bytedance.android.live.broadcast.api.model.y1 r1 = (com.bytedance.android.live.broadcast.api.model.y1) this.b.get("cmd_anchor_broadcast_start_zoom", new com.bytedance.android.live.broadcast.api.model.y1());
        com.bytedance.android.live.broadcast.api.model.z1 r2 = com.bytedance.android.live.broadcast.api.model.r.a;
        Intrinsics.checkNotNullParameter(r1, "currentRatioEntry");
        boolean r3 = com.bytedance.android.live.broadcast.api.model.r.c();
        if (r3 == false) goto L13;
        float r4 = r1.a;
    L14:
        float r5 = r4 + r10;
        com.bytedance.android.live.broadcast.api.model.a2 r11 = com.bytedance.android.live.broadcast.api.model.r.b(((Integer) com.bytedance.android.livesdk.sharedpref.b.a.a()).intValue());
        if (r11 == null) goto L22;
        float r6 = r11.a;
        if (r5 < r6) goto L19;
        r5 = r6;
    L23:
        ALogger.i("CameraZoomManager", "currentRatio:" + r5);
        if (r3 == false) goto L26;
        r1.a = r5;
    L27:
        r1.c = r5;
        this.b.put("cmd_anchor_broadcast_start_zoom", r1);
        return true;
    L26:
        r1.b = r5;
        goto L27
    L19:
        float r12 = r11.b;
        if (r5 > r12) goto L23;
        r5 = r12;
        goto L23
    L22:
        r5 = 1.0f;
        goto L23
    L13:
        r4 = r1.b;
        goto L14
    L9:
        r10 = -0.1f;
        goto L10
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public final boolean onScaleBegin(ScaleGestureDetector r5) {
        Intrinsics.checkNotNullParameter(r5, "detector");
        com.bytedance.android.live.pushstream.d r6 = this.a;
        if (r6 == null) goto L32;
        com.bytedance.android.live.pushstream.b.b r7 = r6.getStatus();
        if (r7 == null) goto L32;
        int r8 = r7.a;
        if (r8 == 2) goto L11;
        if (r8 == 1) goto L11;
        boolean r9 = false;
    L12:
        if (r9 != true) goto L32;
        Integer r10 = (Integer) this.b.get("data_link_state", 0);
        if (r10 == null) goto L17;
        int r11 = r10.intValue();
    L19:
        if (r11 <= 0) goto L22;
        ALogger.i("LiveFocusScaleGestureListener", "link state not allow scale");
        return false;
    L22:
        com.bytedance.android.live.broadcast.api.model.z1 r12 = com.bytedance.android.live.broadcast.api.model.r.a;
        com.bytedance.android.live.broadcast.api.model.a2 r13 = com.bytedance.android.live.broadcast.api.model.r.b(((Integer) com.bytedance.android.livesdk.sharedpref.b.a.a()).intValue());
        if (r13 != null) goto L25;
    L27:
        boolean r14 = false;
    L28:
        if (r14 == true) goto L31;
        ALogger.i("LiveFocusScaleGestureListener", "not allow zoom");
        return false;
    L31:
        return true;
    L25:
        if (r13.a <= 1.0f) goto L27;
        r14 = true;
        goto L28
    L17:
        r11 = 0;
    L11:
        r9 = true;
    L32:
        return false;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public final void onScaleEnd(ScaleGestureDetector r8) {
        Intrinsics.checkNotNullParameter(r8, "detector");
        float r9 = r8.getScaleFactor();
        HashMap r0 = new HashMap();
        r0.put("event_page", "live_take_detail");
        if (r9 < 1.0d) goto L5;
        String r1 = "zoom_in";
    L6:
        r0.put("zoom_type", r1);
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_pinch_zoom", r0, new Object[]{Room.class});
        ALogger.i("LiveFocusScaleGestureListener", "onScaleEnd");
        LinkedHashMap r2 = new LinkedHashMap();
        r2.put("zoom_type", r1);
        r2.put("ratio", String.valueOf(r9));
        NewBroadcastMonitor.g("ttlive_camera_start_zoom", r2);
        return;
    L5:
        r1 = "zoom_out";
        goto L6
    }

    public h7(com.bytedance.android.live.pushstream.d r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        this.a = r2;
        this.b = r3;
    }
}
