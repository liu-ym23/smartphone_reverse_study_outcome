package com.bytedance.android.livesdk.gamecp.impl;

import com.bytedance.android.livehostapi.business.depend.gamecp.cloudgame.IGameCPCloudGameService;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a implements IGameCPCloudGameService {
    public a() {
    }

    public final void closeAllGame() {
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 == null) goto L8;
        xr.g r1 = r0.getCloudGameService();
        if (r1 == null) goto L9;
        r1.closeAllGame();
        return;
    L9:
        return;
    }

    public final boolean isPluginReady() {
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 == null) goto L9;
        xr.g r1 = r0.getCloudGameService();
        if (r1 == null) goto L9;
        if (r1.isPluginReady() != true) goto L9;
        return true;
    L9:
        return false;
    }

    public final String getRtcLibraConfig(String r1) {
        xr.f r2 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r2 == null) goto L7;
        xr.g r3 = r2.getCloudGameService();
        if (r3 == null) goto L7;
        return r3.b1();
    L7:
        return null;
    }

    public final void closeGame(String r1, String r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "gameId");
        Intrinsics.checkNotNullParameter(r2, "from");
        xr.f r4 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r4 == null) goto L8;
        xr.g r5 = r4.getCloudGameService();
        if (r5 == null) goto L9;
        r5.N();
        return;
    L9:
        return;
    }

    public final <T> T getTrackParams(long r1, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "gameId");
        Intrinsics.checkNotNullParameter(r4, "key");
        xr.f r2 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r2 == null) goto L7;
        xr.g r5 = r2.getCloudGameService();
        if (r5 == null) goto L7;
        return (T) r5.g0();
    L7:
        return null;
    }

    public final void initMonitor(long r1, String r3, Map<String, String> r4) {
        Intrinsics.checkNotNullParameter(r3, "gameId");
        Intrinsics.checkNotNullParameter(r4, "map");
        xr.f r2 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r2 == null) goto L8;
        xr.g r5 = r2.getCloudGameService();
        if (r5 == null) goto L9;
        r5.G0();
        return;
    L9:
        return;
    }

    public final void monitorEvent(long r1, String r3, String r4, Map<String, String> r5) {
        Intrinsics.checkNotNullParameter(r3, "gameId");
        Intrinsics.checkNotNullParameter(r4, "key");
        Intrinsics.checkNotNullParameter(r5, "extra");
        xr.f r2 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r2 == null) goto L8;
        xr.g r6 = r2.getCloudGameService();
        if (r6 == null) goto L9;
        r6.z();
        return;
    L9:
        return;
    }

    public final <T> void setTrackValue(long r1, String r3, String r4, T r5) {
        Intrinsics.checkNotNullParameter(r3, "gameId");
        Intrinsics.checkNotNullParameter(r4, "key");
        xr.f r2 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r2 == null) goto L8;
        xr.g r6 = r2.getCloudGameService();
        if (r6 == null) goto L9;
        r6.h1();
        return;
    L9:
        return;
    }

    public final void trackEvent(long r1, String r3, String r4, Map<String, String> r5) {
        Intrinsics.checkNotNullParameter(r3, "gameId");
        Intrinsics.checkNotNullParameter(r4, "key");
        Intrinsics.checkNotNullParameter(r5, "extra");
        xr.f r2 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r2 == null) goto L8;
        xr.g r6 = r2.getCloudGameService();
        if (r6 == null) goto L9;
        r6.T0();
        return;
    L9:
        return;
    }

    public final Map<String, Object> createStartParams(String r1, String r2, String r3, String r4, List<? extends Pair<String, ? extends Object>> r5, Map<String, String> r6, int r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r1, "gameName");
        Intrinsics.checkNotNullParameter(r2, "gameIcon");
        Intrinsics.checkNotNullParameter(r3, "gameId");
        Intrinsics.checkNotNullParameter(r4, "channelId");
        xr.f r9 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r9 == null) goto L7;
        xr.g r10 = r9.getCloudGameService();
        if (r10 == null) goto L7;
        return r10.I0();
    L7:
        return null;
    }
}
