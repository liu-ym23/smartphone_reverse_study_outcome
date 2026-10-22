package com.lynx.canvas.telemetry;

import com.lynx.canvas.KryptonService;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public abstract class KryptonTelemetryService extends KryptonService {
    public abstract void reportEvent(String r1, Map<String, String> r2);

    public KryptonTelemetryService() {
    }
}
