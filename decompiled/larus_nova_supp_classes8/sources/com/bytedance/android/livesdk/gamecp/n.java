package com.bytedance.android.livesdk.gamecp;

import android.content.Context;
import com.bytedance.android.gamecp.host_api.GameCpTargetUtils;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.business.IHostGameCpConfig;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class n implements bw.e {

    public static final class a {
    }

    static {
    }

    public n() {
    }

    public final void E() {
    }

    public final void F() {
    }

    public final void t() {
    }

    public final void x1() {
    }

    public final boolean o2() {
        if (GameCpTargetUtils.g() == false) goto L6;
        return false;
    L6:
        return true;
    }

    public final boolean useGameCPDownloaderConfig() {
        IHostGameCpConfig r0 = TTLiveSDK.hostService().hostGameCpConfig();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.useGameCPDownloaderConfig();
    }

    public final void X(Context r2, JSONObject r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "params");
        com.bytedance.gamecenter.base.q.l().d(r2, r3);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        yr.c.b("HostDownloadServiceImpl", "cancelOrder exception = " + e);
    }

    public final void f0(String r2, dw.e r3) {
        Intrinsics.checkNotNullParameter(r2, "gameId");
        Intrinsics.checkNotNullParameter(r3, "permissionCallback");
        r3.onGranted();
    }

    public final void orderGame(Context r4, JSONObject r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "params");
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L5
        r0.put("action_type", 1);     // Catch: Exception -> L5
        r0.put("order_info", r5);     // Catch: Exception -> L5
        com.bytedance.gamecenter.base.q.l().n(r4, r0);     // Catch: Exception -> L5
        return;
    }
}
