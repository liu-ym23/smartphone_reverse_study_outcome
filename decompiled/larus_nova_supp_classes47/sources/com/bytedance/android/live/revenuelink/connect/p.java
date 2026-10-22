package com.bytedance.android.live.revenuelink.connect;

import com.bytedance.android.live.core.monitor.LiveTracingMonitorKt;
import com.bytedance.android.livesdk.link.model.bridge.h1;
import com.bytedance.android.livesdk.link.model.q5;
import com.bytedance.android.livesdk.link.model.v4;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface p {
    void a(d11.f r1, com.bytedance.android.livesdk.link.model.v r2, long r3, JSONObject r5);

    void b(d11.d r1, v4 r2, JSONObject r3);

    void c(JSONObject r1, LiveTracingMonitorKt.EventModule r2);

    void d(d11.g r1, q5 r2, long r3, JSONObject r5);

    void e(h1 r1, JSONObject r2);
}
