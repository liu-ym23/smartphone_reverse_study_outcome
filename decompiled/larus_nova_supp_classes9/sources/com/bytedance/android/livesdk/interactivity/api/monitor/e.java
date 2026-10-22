package com.bytedance.android.livesdk.interactivity.api.monitor;

import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e {
    public static final InteractivityMonitor.Event a = null;

    static {
        a = InteractivityMonitor.Event.CommentUserSendSelfShow;
    }

    @JvmStatic
    public static final void a(String r2, String r3, long r4, long r6) {
        Intrinsics.checkNotNullParameter(r2, "sendType");
        Intrinsics.checkNotNullParameter(r3, "showType");
        JSONObject r0 = new JSONObject();
        r0.put("send_type", r2);
        r0.put("show_type", r3);
        JSONObject r5 = new JSONObject();
        r5.put("use_time", r4);
        r5.put("api_use_time", r6);
        InteractivityMonitor.Event r7 = a;
        LiveTracingMonitor.f(r7.getEventName(), r7.getEventModule(), r0, r5, new JSONObject());
    }
}
