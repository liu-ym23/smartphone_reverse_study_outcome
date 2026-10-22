package com.bytedance.ai.applet.app.foundation.performance;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class n extends k {
    public final String h;
    public boolean i;

    @Override // com.bytedance.ai.applet.app.foundation.performance.k
    public final e b(AppletPerformanceOutcome r1, long r10, AppletPerformanceErrorCode r11, String r12) {
        Intrinsics.checkNotNullParameter(r1, "outcome");
        Intrinsics.checkNotNullParameter(r11, "errorCode");
        return null;
    }

    public n(c r10, long r11) {
        Intrinsics.checkNotNullParameter(r10, "owner");
        Intrinsics.checkNotNullParameter("__APP__", "moduleName");
        super(r10, r11);
        this.h = "__APP__";
    }
}
