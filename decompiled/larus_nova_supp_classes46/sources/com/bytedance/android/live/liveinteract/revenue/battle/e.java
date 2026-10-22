package com.bytedance.android.live.liveinteract.revenue.battle;

import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e implements zt0.b {
    public e() {
    }

    public final void a(String r3) {
        ALogger.i("CommonWidgetResouce", "#DressResourceDebug# [getSponsorBgColorByDressId] onSyncSuccess id " + r3);
    }

    public final void b(String r1, String r2, int r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "version");
        ALogger.i("CommonWidgetResouce", "#DressResourceDebug# [getSponsorBgColorByDressId] onSyncFailed id " + r1);
    }
}
