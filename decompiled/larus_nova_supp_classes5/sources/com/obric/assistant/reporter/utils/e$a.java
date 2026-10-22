package com.obric.assistant.reporter.utils;

import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class e$a implements f09.a.b {
    public e$a() {
    }

    public final void onAppForeground() {
    }

    public final void onAllActivityDestroyed() {
        e r0 = e.a;
        e.c = AppStartState.WarmStart;
        FLogger.a.i("ObricAppStartManager", "onAllActivityDestroyed: state=" + e.c);
    }

    public final void onAppBackground() {
        int r0 = AppHost.a.a().g().size();
        if (r0 <= 0) goto L5;
        e r1 = e.a;
        e.c = AppStartState.HotStart;
    L5:
        FLogger.a.i("ObricAppStartManager", "onAppBackground: aliveActivityCount=" + r0 + ", state=" + e.c);
    }
}
