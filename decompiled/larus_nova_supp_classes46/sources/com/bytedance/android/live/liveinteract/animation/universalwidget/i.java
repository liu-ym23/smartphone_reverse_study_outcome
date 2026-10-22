package com.bytedance.android.live.liveinteract.animation.universalwidget;

import com.ss.android.ugc.aweme.live.alphaplayer.listener.IMonitor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i implements IMonitor {
    public i() {
    }

    public final void a(String r2, Exception r3) {
        Intrinsics.checkNotNullParameter(r2, "player");
        Intrinsics.checkNotNullParameter(r3, "e");
    }

    public final void monitor(boolean r1, String r2, int r3, int r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "playerType");
        Intrinsics.checkNotNullParameter(r5, "errorInfo");
    }
}
