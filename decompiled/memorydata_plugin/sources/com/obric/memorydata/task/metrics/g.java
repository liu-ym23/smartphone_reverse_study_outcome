package com.obric.memorydata.task.metrics;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"toEventJson", "Lorg/json/JSONObject;", "Lcom/obric/memorydata/task/metrics/IndexPowerMetricSample;", "task_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class g {
    public static final JSONObject a(a r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        JSONObject r0 = new JSONObject();
        r0.put("schemaVersion", r4.a());
        r0.put("windowStartUtcMs", r4.b());
        r0.put("windowEndUtcMs", r4.c());
        r0.put("snapshotAtMs", r4.d());
        r0.put("runMode", r4.e().name());
        r0.put("powerKnownDurationMs", r4.f());
        r0.put("powerSatisfiedDurationMs", r4.g());
        r0.put("taskWaitingKnownDurationMs", r4.h());
        r0.put("taskWaitingUnsatisfiedDurationMs", r4.i());
        return r0;
    }
}
