package com.lynx.canvas;

import com.lynx.canvas.telemetry.KryptonTelemetryService;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.eventreport.LynxEventReporter;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxKryptonTelemetryService extends KryptonTelemetryService {
    private static final String TAG = "LynxKryptonTelemetryService";
    private final int mInstanceId;

    public LynxKryptonTelemetryService(WeakReference<LynxContext> r2) {
        LynxContext r3 = r2.get();
        if (r3 == null) goto L5;
        this.mInstanceId = r3.getInstanceId();
        return;
    L5:
        this.mInstanceId = -1;
        LLog.e(TAG, "LynxKryptonTelemetryService created with invalid context");
    }

    @Override // com.lynx.canvas.telemetry.KryptonTelemetryService
    public void reportEvent(String r3, Map<String, String> r4) {
        if (this.mInstanceId <= (-1)) goto L6;
        LLog.e(TAG, "report " + r3 + " " + r4);
        StringBuilder r0 = new StringBuilder("lynxsdk_krypton_");
        r0.append(r3);
        LynxEventReporter.onEvent(r0.toString(), new HashMap(r4), this.mInstanceId);
        return;
    }
}
