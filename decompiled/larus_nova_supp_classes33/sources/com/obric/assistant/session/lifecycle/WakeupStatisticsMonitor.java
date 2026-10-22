package com.obric.assistant.session.lifecycle;

import android.content.Context;
import com.obric.assistant.wakeup.statistics.api.IWakeupStatisticsAPI;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class WakeupStatisticsMonitor extends a {
    public static final WakeupStatisticsMonitor b = null;

    static {
        b = new WakeupStatisticsMonitor();
    }

    @Override // bga.i
    public final void onDestroy() {
        IWakeupStatisticsAPI r0 = wha.a.a();
        if (r0 == null) goto L6;
        r0.destroy();
        return;
    }

    public WakeupStatisticsMonitor() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.obric.assistant.session.lifecycle.f] */
    @Override // bga.i
    public final void a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r2, "context");
        IWakeupStatisticsAPI r3 = wha.a.a();
        if (r3 == 0) goto L6;
        r3.a(new f());
        return;
    }
}
