package com.obric.memorydata.utils;

import com.obric.memorydata.constants.DevTrackerEventId;
import com.obric.memorydata.middleware.api.bdtracker.Tracker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"reportDevEvent", "", "event", "Lcom/obric/memorydata/constants/DevTrackerEventId;", "data", "Lorg/json/JSONObject;", "utils_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ah {
    public static final void a(DevTrackerEventId r1, JSONObject r2) {
        Intrinsics.checkNotNullParameter(r1, "event");
        Intrinsics.checkNotNullParameter(r2, "data");
        Tracker.INSTANCE.reportDevEvent(r1.getValue(), r2);
    }
}
