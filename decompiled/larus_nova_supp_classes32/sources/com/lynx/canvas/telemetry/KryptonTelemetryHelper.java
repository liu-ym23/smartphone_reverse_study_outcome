package com.lynx.canvas.telemetry;

import com.lynx.canvas.KryptonApp;
import com.lynx.canvas.KryptonLLog;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class KryptonTelemetryHelper {
    private static final String SEPARATOR_PARAM = ",";
    private static final String TAG = "KryptonTelemetryHelper";

    public KryptonTelemetryHelper() {
    }

    public static void reportEvent(KryptonApp r4, String r5, String r6) {
        KryptonTelemetryService r7 = (KryptonTelemetryService) r4.getService(KryptonTelemetryService.class);
        if (r7 != null) goto L6;
        KryptonLLog.e(TAG, "no service found");
        return;
    L6:
        HashMap r1 = new HashMap();
        if (r6 != null) goto L9;
    L18:
        r7.reportEvent(r5, r1);
        return;
    L9:
        if (r6.isEmpty() == true) goto L18;
        String[] r8 = r6.split(SEPARATOR_PARAM);
        if ((r8.length % 2) != 0) goto L16;
        int r0 = 0;
    L14:
        if (r0 >= r8.length) goto L18;
        r1.put(r8[r0], r8[r0 + 1]);
        r0 = r0 + 2;
        goto L14
    L16:
        KryptonLLog.e(TAG, "params format error, length should be even");
    }
}
