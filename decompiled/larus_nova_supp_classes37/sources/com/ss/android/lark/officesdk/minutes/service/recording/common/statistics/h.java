package com.ss.android.lark.officesdk.minutes.service.recording.common.statistics;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class h {
    public final com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.c a;
    public final Map<String, b> b;

    public static final class a {
    }

    public static final class b {
        public long a;

        public b() {
        }
    }

    static {
    }

    public h(com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.c r2) {
        Intrinsics.checkNotNullParameter(r2, "businessTracker");
        this.a = r2;
        this.b = new LinkedHashMap();
    }

    public final void a(String r6, b r7) {
        if (r7.a <= 0) goto L5;
        return;
    L5:
        r7.a = System.currentTimeMillis();
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d r8 = new com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d();
        r8.e("scene", "record");
        r8.e("action_name", "start_main_window_dismiss");
        JSONObject r9 = r8.a();
        lvb.a.e("MmRecordingBackgroundRunTracker", "[sendStartStatusEvent] sessionId=".concat(r6));
        this.a.g(r6, "vc_background_run_status", r9);
    }

    public final void b(String r10, b r11) {
        long r0 = r11.a;
        if (r0 > 0) goto L5;
        return;
    L5:
        long r4 = RangesKt.coerceAtLeast(System.currentTimeMillis() - r0, 0);
        r11.a = 0;
        if (r4 >= 1000) goto L9;
        lvb.a.e("MmRecordingBackgroundRunTracker", "[stopIfNeeded] skip short duration, sessionId=" + r10 + ", startTime=" + r0 + ", duration=" + r4);
        return;
    L9:
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d r2 = new com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d();
        r2.e("scene", "record");
        r2.e("action_name", "stop_main_window_dismiss");
        r2.c("start_time", r0);
        r2.c("duration", r4);
        JSONObject r3 = r2.a();
        lvb.a.e("MmRecordingBackgroundRunTracker", "[sendStopStatusEvent] sessionId=" + r10 + ", startTime=" + r0 + ", duration=" + r4);
        this.a.g(r10, "vc_background_run_status", r3);
    }
}
