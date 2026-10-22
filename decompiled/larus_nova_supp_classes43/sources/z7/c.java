package z7;

import com.bytedance.android.monitorV2.listener.f;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c implements f {
    public c() {
    }

    public void onEventCreated(com.bytedance.android.monitorV2.event.c r10) {
        Intrinsics.checkNotNullParameter(r10, "eventInfo");
    }

    public void onEventSampled(com.bytedance.android.monitorV2.event.c r10) {
        Intrinsics.checkNotNullParameter(r10, "eventInfo");
    }

    public void onEventTerminated(com.bytedance.android.monitorV2.event.c r10) {
        Intrinsics.checkNotNullParameter(r10, "eventInfo");
    }

    public void onEventUploaded(com.bytedance.android.monitorV2.event.c r10) {
        Intrinsics.checkNotNullParameter(r10, "eventInfo");
    }

    public void onEventUpdated(com.bytedance.android.monitorV2.event.c r10) {
        Intrinsics.checkNotNullParameter(r10, "eventInfo");
        if (Intrinsics.areEqual(r10.a, "performance") == false) goto L5;
    L6:
        ConcurrentHashMap<String, com.bytedance.android.monitorV2.event.c> r0 = e.a;
        Intrinsics.checkNotNullParameter(r10, "event");
        Object r1 = r10.d.get("containerBase");
        String r11 = null;
        if ((r1 instanceof JSONObject) == false) goto L9;
        JSONObject r12 = (JSONObject) r1;
    L10:
        if (r12 == null) goto L14;
        JSONArray r13 = r12.optJSONArray("container_ids");
        if (r13 == null) goto L14;
        r11 = r13.optString(0);
    L14:
        if (r11 != null) goto L16;
        return;
    L16:
        if ((!StringsKt.isBlank(r11)) == false) goto L21;
        e.a.put(r11, r10);
        return;
    L21:
        return;
    L9:
        r12 = null;
        goto L10
    L5:
        if (Intrinsics.areEqual(r10.a, "perf") == true) goto L6;
    }
}
