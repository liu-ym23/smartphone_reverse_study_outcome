package com.bytedance.android.live.revenuelink;

import com.bytedance.android.live.core.monitor.LiveTracingMonitorKt;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface f {

    public static final class a {
        public static /* synthetic */ void a(f r7, String r8, LiveTracingMonitorKt.EventModule r9, Map r10, JSONObject r12) {
            r7.Z(r8, r9, r10, r12, 0);
        }

        public static /* synthetic */ void b(f r9, LiveTracingMonitorKt.EventModule r10, int r12, String r13, Map r14, JSONObject r15) {
            r9.Y("ttlive_pk_business_api_call", r10, r12, r13, r14, r15, null, null);
        }
    }

    boolean X(String r1);

    void Y(String r1, LiveTracingMonitorKt.EventModule r2, int r3, String r4, Map<String, Object> r5, JSONObject r6, JSONObject r7, JSONObject r8);

    void Z(String r1, LiveTracingMonitorKt.EventModule r2, Map<String, Object> r3, JSONObject r4, long r5);

    void a0(String r1, LiveTracingMonitorKt.EventModule r2, String r3, Map<String, Object> r4, JSONObject r5, long r6);

    void b0(String r1, LiveTracingMonitorKt.EventModule r2, JSONObject r3);

    void c0(String r1, LiveTracingMonitorKt.EventModule r2, int r3, String r4, Map<String, Object> r5, JSONObject r6);
}
