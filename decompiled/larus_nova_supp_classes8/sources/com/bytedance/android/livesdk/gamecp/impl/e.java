package com.bytedance.android.livesdk.gamecp.impl;

import com.bytedance.android.livehostapi.business.depend.gamecp.IGameCPWhiteBoxTestService;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import xr.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e implements IGameCPWhiteBoxTestService {
    public e() {
    }

    public final void executeToolbarCase() {
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 == null) goto L8;
        q r1 = r0.getWhiteBoxTestService();
        if (r1 == null) goto L9;
        r1.executeToolbarCase();
        return;
    L9:
        return;
    }

    public final void unRegisterToolbarCase() {
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 == null) goto L8;
        q r1 = r0.getWhiteBoxTestService();
        if (r1 == null) goto L9;
        r1.unRegisterToolbarCase();
        return;
    L9:
        return;
    }

    public final void enterScene(String r2) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        xr.f r3 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r3 == null) goto L8;
        q r4 = r3.getWhiteBoxTestService();
        if (r4 == null) goto L9;
        r4.K0();
        return;
    L9:
        return;
    }

    public final void exitScene(String r2) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        xr.f r3 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r3 == null) goto L8;
        q r4 = r3.getWhiteBoxTestService();
        if (r4 == null) goto L9;
        r4.s();
        return;
    L9:
        return;
    }

    public final void registerToolbarCase(Map<String, String> r2) {
        Intrinsics.checkNotNullParameter(r2, "map");
        xr.f r3 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r3 == null) goto L8;
        q r4 = r3.getWhiteBoxTestService();
        if (r4 == null) goto L9;
        r4.v0();
        return;
    L9:
        return;
    }

    public final void onFail(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "desc");
        Intrinsics.checkNotNullParameter(r3, "content");
        xr.f r4 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r4 == null) goto L8;
        q r5 = r4.getWhiteBoxTestService();
        if (r5 == null) goto L9;
        r5.onFail();
        return;
    L9:
        return;
    }
}
