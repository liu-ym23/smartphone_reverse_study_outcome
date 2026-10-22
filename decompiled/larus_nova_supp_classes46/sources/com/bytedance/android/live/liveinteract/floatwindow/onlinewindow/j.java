package com.bytedance.android.live.liveinteract.floatwindow.onlinewindow;

import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j<T> implements Consumer {
    public final /* synthetic */ long a;
    public final /* synthetic */ gm2.i b;

    public j(long r1, gm2.i r3) {
        this.a = r1;
        this.b = r3;
    }

    public final void accept(Object r5) {
        com.bytedance.android.live.network.response.a r6 = (com.bytedance.android.live.network.response.a) r5;
        Intrinsics.checkNotNullParameter(r6, "response");
        long r0 = this.a;
        long r2 = System.currentTimeMillis() - r0;
        String r1 = r6.logId;
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        InteractLinkFullLinkMonitor.U(100102, r2, r1);
        int r3 = nd0.g.a;
        nd0.g.i(this.b, this.a, r6.logId);
    }
}
