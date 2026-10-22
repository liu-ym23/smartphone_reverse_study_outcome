package com.larus.dora.impl.bridge;

import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class k implements t39.w {
    public k() {
    }

    public final void a(boolean r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "msg");
        FLogger.a.i("DoraDeviceDownloadEarbudsTraceMethod", "dora.debug.downloadEarbudsTrace upload log result success=" + r4 + ", msg=" + r5);
    }
}
