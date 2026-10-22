package com.obric.assistant.frontier;

import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class d$a implements com.larus.platform.api.b {
    public d$a() {
    }

    public final void b(com.larus.platform.api.c r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
    }

    public final void a(com.larus.platform.api.c r4) {
        Intrinsics.checkNotNullParameter(r4, "event");
        FLogger.a.i("ObricFrontierStatusMonitor", "reconnect Frontier after login, scene=" + r4.e);
        Lazy r5 = d.a;
        com.larus.im.f r6 = d.c();
        if (r6 == null) goto L6;
        r6.l(null, "onUserDidOnline");
        return;
    }
}
