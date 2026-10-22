package com.bytedance.android.live.core.monitor.trace;

import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import kotlin.Deprecated;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Deprecated(message = "user TraceMonitor")
public final class c {
    public static final a60.e a = null;

    static {
        a = LiveInfraSettingKeys.LIVE_TRACE_MONITOR_CONFIG.getValue();
    }

    @JvmStatic
    public static final boolean a() {
        return a.e();
    }

    @JvmStatic
    public static final void b(e r1, JSONObject r2) {
        Intrinsics.checkNotNullParameter(r1, "traceMeta");
        Intrinsics.checkNotNullParameter(r1, "traceMeta");
        TraceMonitor.i(r1, null, null, r2);
    }
}
