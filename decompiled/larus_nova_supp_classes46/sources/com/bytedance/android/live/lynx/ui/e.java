package com.bytedance.android.live.lynx.ui;

import com.ss.android.ugc.aweme.live.alphaplayer.listener.IMonitor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e implements IMonitor {
    public final /* synthetic */ LiveLynxAlphaPlayer a;

    public e(LiveLynxAlphaPlayer r1) {
        this.a = r1;
    }

    public final void a(String r4, Exception r5) {
        Intrinsics.checkNotNullParameter(r4, "player");
        Intrinsics.checkNotNullParameter(r5, "e");
        this.a.Q("failed when init media player, and player is " + r4 + ", error msg is " + r5 + ' ', this.a.g, -8);
        throw null;
    }

    public final void monitor(boolean r4, String r5, int r6, int r7, String r8) {
        Intrinsics.checkNotNullParameter(r5, "playerType");
        Intrinsics.checkNotNullParameter(r8, "errorInfo");
        this.a.Q("failed when monitor: state = " + r4 + ", playerType = " + r5 + ", what = " + r6 + ", extra = " + r7 + ", errorInfo = " + r8, this.a.g, -9);
        throw null;
    }
}
