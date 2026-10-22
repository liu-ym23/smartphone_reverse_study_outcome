package com.ss.android.lark.officesdk.minutes.service.recording.common.statistics;

import com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.MmRecordingCommonParam;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class j {
    public final com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.c a;

    public static final class a {
    }

    static {
    }

    public j(com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.c r2) {
        Intrinsics.checkNotNullParameter(r2, "businessTracker");
        this.a = r2;
    }

    public final void a(String r4, String r5, Map<String, ? extends Object> r6) {
        Intrinsics.checkNotNullParameter(r4, "sessionId");
        Intrinsics.checkNotNullParameter(r5, PickerReporterConstants.KEY.CLICK);
        MmRecordingCommonParam r1 = this.a.b(r4);
        if (r1 == null) goto L7;
        boolean r2 = true;
        if (r1.isValid() != true) goto L7;
    L8:
        if (r2 == true) goto L11;
        lvb.a.b("MmRecordingPageTracker", "[trackClick] commonParam invalid, " + r5);
        return;
    L11:
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d r3 = new com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d();
        r3.e(PickerReporterConstants.KEY.CLICK, r5);
        if (r6 == null) goto L17;
        Iterator<Map.Entry<String, ? extends Object>> r7 = r6.entrySet().iterator();
    L15:
        if (r7.hasNext() == false) goto L17;
        Map.Entry<String, ? extends Object> r8 = r7.next();
        r3.d(r8.getKey(), r8.getValue());
    L17:
        this.a.g(r4, "vc_navigation_minutes_recording_click", r3.a());
        return;
    L7:
        r2 = false;
        goto L8
    }
}
