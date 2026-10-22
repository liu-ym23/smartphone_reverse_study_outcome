package com.bytedance.android.live.liveinteract.floatwindow.onlinewindow;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i<T> implements Consumer {
    public final /* synthetic */ long a;
    public final /* synthetic */ gm2.i b;

    public i(long r1, gm2.i r3) {
        this.a = r1;
        this.b = r3;
    }

    public final void accept(Object r5) {
        Throwable r6 = (Throwable) r5;
        Intrinsics.checkNotNullParameter(r6, "throwable");
        long r0 = this.a;
        InteractLinkFullLinkMonitor.T(100101, System.currentTimeMillis() - r0, r6);
        int r1 = nd0.g.a;
        nd0.g.h(this.b, this.a, r6);
        ALogger.stacktrace(6, "LinkmicOnlineFloatWindowManager", r6.getStackTrace());
    }
}
