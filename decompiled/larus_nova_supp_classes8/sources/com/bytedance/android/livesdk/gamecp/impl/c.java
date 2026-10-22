package com.bytedance.android.livesdk.gamecp.impl;

import com.bytedance.android.livehostapi.business.depend.gamecp.IGameCPFmpMonitorService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c implements IGameCPFmpMonitorService {
    public c() {
    }

    public final void markActionEnd(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "trackId");
        Intrinsics.checkNotNullParameter(r3, "action");
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 == null) goto L8;
        xr.d r1 = r0.getGameCPFmpMonitorService();
        if (r1 == null) goto L9;
        r1.markActionEnd(r2, r3);
        return;
    L9:
        return;
    }

    public final void startComponentFmp(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "trackId");
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 == null) goto L8;
        xr.d r1 = r0.getGameCPFmpMonitorService();
        if (r1 == null) goto L9;
        r1.startComponentFmp(r2, r3);
        return;
    L9:
        return;
    }

    public final void startFmpTrack(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "trackEvent");
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 == null) goto L8;
        xr.d r1 = r0.getGameCPFmpMonitorService();
        if (r1 == null) goto L9;
        r1.startFmpTrack(r2, r3);
        return;
    L9:
        return;
    }

    public final void stopFmpTrack(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "trackId");
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 == null) goto L8;
        xr.d r1 = r0.getGameCPFmpMonitorService();
        if (r1 == null) goto L9;
        r1.stopFmpTrack(r2, r3);
        return;
    L9:
        return;
    }

    public final void addTrackExtra(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "trackId");
        Intrinsics.checkNotNullParameter(r3, "field");
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 == null) goto L8;
        xr.d r1 = r0.getGameCPFmpMonitorService();
        if (r1 == null) goto L9;
        r1.addTrackExtra(r2, r3, r4);
        return;
    L9:
        return;
    }

    public final void addTrackField(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "trackId");
        Intrinsics.checkNotNullParameter(r3, "field");
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 == null) goto L8;
        xr.d r1 = r0.getGameCPFmpMonitorService();
        if (r1 == null) goto L9;
        r1.addTrackField(r2, r3, r4);
        return;
    L9:
        return;
    }

    public final void endComponentFmp(String r2, String r3, long r4) {
        Intrinsics.checkNotNullParameter(r2, "trackId");
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 == null) goto L8;
        xr.d r1 = r0.getGameCPFmpMonitorService();
        if (r1 == null) goto L9;
        r1.endComponentFmp(r2, r3, r4);
        return;
    L9:
        return;
    }

    public final void markEventActionEnd(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "trackId");
        Intrinsics.checkNotNullParameter(r3, "eventName");
        Intrinsics.checkNotNullParameter(r4, "action");
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 == null) goto L8;
        xr.d r1 = r0.getGameCPFmpMonitorService();
        if (r1 == null) goto L9;
        r1.markEventActionEnd(r2, r3, r4);
        return;
    L9:
        return;
    }

    public final void addEventExtra(String r2, String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "trackId");
        Intrinsics.checkNotNullParameter(r3, "event");
        Intrinsics.checkNotNullParameter(r4, "field");
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 == null) goto L8;
        xr.d r1 = r0.getGameCPFmpMonitorService();
        if (r1 == null) goto L9;
        r1.addEventExtra(r2, r3, r4, r5);
        return;
    L9:
        return;
    }

    public final void addEventField(String r2, String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "trackId");
        Intrinsics.checkNotNullParameter(r3, "event");
        Intrinsics.checkNotNullParameter(r4, "field");
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 == null) goto L8;
        xr.d r1 = r0.getGameCPFmpMonitorService();
        if (r1 == null) goto L9;
        r1.addEventField(r2, r3, r4, r5);
        return;
    L9:
        return;
    }

    public final void markActionStart(String r2, String r3, String r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "trackId");
        Intrinsics.checkNotNullParameter(r3, "action");
        Intrinsics.checkNotNullParameter(r4, "durationKey");
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 == null) goto L8;
        xr.d r1 = r0.getGameCPFmpMonitorService();
        if (r1 == null) goto L9;
        r1.markActionStart(r2, r3, r4, r5);
        return;
    L9:
        return;
    }

    public final void markEventActionStart(String r2, String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "trackId");
        Intrinsics.checkNotNullParameter(r3, "eventName");
        Intrinsics.checkNotNullParameter(r4, "action");
        Intrinsics.checkNotNullParameter(r5, "durationKey");
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 == null) goto L8;
        xr.d r1 = r0.getGameCPFmpMonitorService();
        if (r1 == null) goto L9;
        r1.markEventActionStart(r2, r3, r4, r5);
        return;
    L9:
        return;
    }
}
