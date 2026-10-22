package y50;

import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.setting.SettingKey;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class n implements wm0.a {
    public n() {
    }

    public final void a(JSONObject r3) {
        LiveSlardarMonitor.monitorStatusAndDuration("ttlive_audience_enter_room_all", 1, r3);
    }

    public final void monitorCommonLog(String r2, JSONObject r3) {
        LiveSlardarMonitor.monitorCommonLog(r2, null, r3);
    }

    public final void c(int r2, long r3, JSONObject r5) {
        LiveSlardarMonitor.monitorStatusAndDuration("ttlive_audience_enter_room_all", r2, r3, r5);
    }

    public final void monitorStatus(String r1, int r2, JSONObject r3) {
        LiveSlardarMonitor.monitorStatus(r1, r2, r3);
    }

    public final void d(String r2, JSONObject r3, JSONObject r4, JSONObject r5) {
        Intrinsics.checkNotNullParameter(r2, "serviceName");
        LiveTracingMonitor.i(r2, r3, r4, r5);
    }

    public final void g(String r2, String r3, String r4, JSONObject r5, JSONObject r6, JSONObject r7) {
        Intrinsics.checkNotNullParameter(r2, "serviceName");
        Intrinsics.checkNotNullParameter(r3, "eventModule");
        Intrinsics.checkNotNullParameter(r4, "eventType");
        LiveTracingMonitor.g(r2, r3, r4, r5, r6, r7);
    }

    public final void b(String r7, String r8, int r9, String r11, JSONObject r12, JSONObject r13, JSONObject r14) {
        Intrinsics.checkNotNullParameter("ttlive_schema_process_error", "serviceName");
        Intrinsics.checkNotNullParameter(r7, "eventModule");
        Intrinsics.checkNotNullParameter(r8, "eventType");
        SettingKey<Boolean> r1 = LiveTracingMonitor.a;
        if (h.a("ttlive_schema_process_error") == true) goto L7;
        LiveTracingMonitor.l(r14, "status_code", String.valueOf(r9));
        LiveTracingMonitor.l(r14, "status_msg", String.valueOf(r11));
        LiveTracingMonitor.g("ttlive_schema_process_error", r7, r8, r12, r13, r14);
        return;
    }
}
