package com.ss.android.lark.officesdk.minutes.service.recording.common.perf.appreciable;

import com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.MmRecordingCommonParam;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    public static final b a = null;
    public static final c b = null;
    public static final d c = null;
    public static final MmRecordingSubtitleAppreciable d = null;

    static {
        a = new b();
        b = new c();
        c = new d();
        d = new MmRecordingSubtitleAppreciable();
    }

    public static void a(String r3, MmRecordingCommonParam r4, JSONObject r5) {
        Intrinsics.checkNotNullParameter(r3, "actionName");
        Intrinsics.checkNotNullParameter(r4, "commonParam");
        Intrinsics.checkNotNullParameter(r5, "extras");
        lvb.a.e("MmRecordingCoreMetrics", "[sendEvent] actionName=" + r3 + ", extras=" + r5);     // Catch: Exception -> L5
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d r1 = new com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d();     // Catch: Exception -> L5
        r1.f(r5);     // Catch: Exception -> L5
        r1.f(r4.asRecordingDevTrackerParams().a());     // Catch: Exception -> L5
        r1.e("action_name", r3);     // Catch: Exception -> L5
        JSONObject r6 = r1.a();     // Catch: Exception -> L5
        int r7 = com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.c.n;     // Catch: Exception -> L5
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.c.a.b(r6);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        lvb.a.b("MmRecordingCoreMetrics", "[sendEvent] failed, actionName=" + r3 + ", error=" + e);
    }
}
