package com.ss.android.lark.lynxkit.monitor;

import com.bytedance.framwork.core.monitor.MonitorUtils;
import com.ss.android.lark.log.Log;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements ILynxKitMonitorReporter {
    public static final a a = null;

    static {
        a = new a();
    }

    public a() {
    }

    @Override // com.ss.android.lark.lynxkit.monitor.ILynxKitMonitorReporter
    public final void report(String r3, int r4, JSONObject r5, JSONObject r6) {
        if (r3 != null) goto L4;
    L7:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L17;
        Log.w("LynxKitMonitorReporter", "report skipped because serviceName is empty");
        return;
    L17:
        MonitorUtils.monitorStatusAndDuration(r3, r4, r5, r6);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        Log.e("LynxKitMonitorReporter", "report failed", th);
        return;
    L4:
        if (r3.length() == 0) goto L7;
        r0 = false;
        goto L9
    }
}
