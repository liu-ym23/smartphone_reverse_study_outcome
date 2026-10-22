package com.bytedance.android.live.liveinteract.animation.universalwidget;

import com.bytedance.android.live.core.log.ALogger;
import com.ss.android.ugc.aweme.live.alphaplayer.listener.IMonitor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f implements IMonitor {
    public f() {
    }

    public final void a(String r2, Exception r3) {
        Intrinsics.checkNotNullParameter(r2, "player");
        Intrinsics.checkNotNullParameter(r3, "e");
    }

    public final void monitor(boolean r3, String r4, int r5, int r6, String r7) {
        Intrinsics.checkNotNullParameter(r4, "playerType");
        Intrinsics.checkNotNullParameter(r7, "errorInfo");
        ALogger.i("MultiLinkEffect.Widget", "monitor:  state = " + r3 + "  playerType = " + r4 + "  what = " + r5 + "  extra = " + r6 + "  errorInfo = " + r7);
    }
}
