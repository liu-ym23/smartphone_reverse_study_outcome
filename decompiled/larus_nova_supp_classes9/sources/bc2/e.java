package bc2;

import com.bytedance.android.live.base.BaseServices;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livehostapi.platform.IHostMonitor;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import vlc.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e implements g {
    public e() {
    }

    public final void b(String r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r2, "message");
        SettingKey r0 = LiveTracingMonitor.a;
        IHostMonitor r1 = (IHostMonitor) BaseServices.as(IHostMonitor.class);
        if (r1 == null) goto L6;
        r1.ensureNotReachHere(r3, r2);
        return;
    }

    public final void d(long r10, JSONObject r13, JSONObject r14, JSONObject r15) {
        String r1 = "uplink_status_all";
        Intrinsics.checkNotNullParameter("uplink_status_all", "serviceName");
        if (StringsKt.startsWith$default("uplink_status_all", "ttlive", false, 2, null) == true) goto L6;
        r1 = "ttlive_uplink_status_all";
    L6:
        LiveTracingMonitor.k(r1, LiveTracingMonitor.EventModule.LIVE_MESSAGE, r10, r13, r14, r15);
    }

    public final void e(String r5, JSONObject r6, JSONObject r7, JSONObject r8) {
        Intrinsics.checkNotNullParameter(r5, "serviceName");
        if (StringsKt.startsWith$default(r5, "ttlive", false, 2, null) == true) goto L6;
        r5 = "ttlive_" + r5;
    L6:
        LiveTracingMonitor.EventModule r0 = LiveTracingMonitor.EventModule.LIVE_MESSAGE;
        if (r7 != null) goto L9;
        r7 = new JSONObject();
    L9:
        if (r8 != null) goto L11;
        r8 = new JSONObject();
    L11:
        LiveTracingMonitor.f(r5, r0, r6, r7, r8);
    }
}
