package com.bytedance.android.live.liveinteract.revenue.battle;

import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h implements zt0.b {
    public h() {
    }

    public final void a(String r3) {
        ALogger.i("CommonWidgetResouce", "#DressResourceDebug# [scoreIconMoveUri] onSyncSuccess id " + r3);
    }

    public final void b(String r1, String r2, int r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "version");
        ALogger.i("CommonWidgetResouce", "#DressResourceDebug# [scoreIconMoveUri] onSyncFailed id " + r1);
    }
}
