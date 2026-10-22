package com.bytedance.android.live.liveinteract.linkpanel.util;

import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData$TraceBusiness;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData$TraceEvent;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class v {
    static {
    }

    public static void a(String r8) {
        Intrinsics.checkNotNullParameter(r8, "panelType");
        JSONObject r6 = new JSONObject();
        r6.put("scene", String.valueOf(o.c()));
        r6.put("ui_layout", String.valueOf(o.d()));
        r6.put("index", r8);
        int r9 = rd0.a.a;
        rd0.a.b(MultiTraceData$TraceBusiness.ChatRoom, MultiTraceData$TraceEvent.LinkmicPanelOpen, "open", 0, null, r6, 88);
    }
}
