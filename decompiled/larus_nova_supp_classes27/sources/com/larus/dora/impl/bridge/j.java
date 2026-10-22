package com.larus.dora.impl.bridge;

import com.larus.dora.api.IDoraService;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class j implements t39.u {
    public final /* synthetic */ IDoraService a;
    public final /* synthetic */ k b;

    public final void b() {
    }

    public j(IDoraService r1, k r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a(boolean r5, String r6, String r7, boolean r8, int r9) {
        Intrinsics.checkNotNullParameter(r6, "msg");
        Intrinsics.checkNotNullParameter(r7, "filePath");
        boolean r1 = true;
        if (r9 != 2) goto L12;
        if (r6.length() == 0) goto L8;
        r1 = false;
    L8:
        if (r1 == false) goto L10;
        r6 = "unknown";
    L10:
        FLogger.a.i("DoraDeviceDownloadEarbudsTraceMethod", "dora.debug.downloadEarbudsTrace point log result success=" + r5 + ", msg=" + r6);
        return;
    L12:
        if (r6.length() > 0) goto L15;
        r1 = false;
    L15:
        if (r1 == false) goto L17;
        FLogger.a.i("DoraDeviceDownloadEarbudsTraceMethod", "dora.debug.downloadEarbudsTrace key log result success=" + r5 + ", msg=" + r6);
    L17:
        FLogger.a.d("DoraDeviceDownloadEarbudsTraceMethod", "dora.debug.downloadEarbudsTrace startUploadLog " + r7 + ". success: " + r5 + ", curLogType: " + r9);
        this.a.k0(r7, r9, this.b);
    }
}
