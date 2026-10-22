package com.ss.android.lark.officesdk.minutes.service.recording.common.statistics;

import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c {
    public final com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.c a;
    public final String b;
    public String c;
    public long d;
    public boolean e;

    public static final class a {
    }

    static {
    }

    public final void a() {
        Intrinsics.checkNotNullParameter("close", PickerReporterConstants.KEY.CLICK);
        if (this.a.d(this.c) == true) goto L6;
        lvb.a.b(this.b, "[trackClick] commonParam invalid, sessionId=" + this.c + ", click=close");
        return;
    L6:
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.c r2 = this.a;
        String r3 = this.c;
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d r4 = new com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d();
        r4.e(PickerReporterConstants.KEY.CLICK, "close");
        r4.e("source", "native");
        r2.g(r3, "vc_record_tail_window_click", r4.a());
    }

    public c(com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.c r2) {
        Intrinsics.checkNotNullParameter(r2, "businessTracker");
        this.a = r2;
        this.b = "MmRecordingTracker_EndWindow";
        this.c = "";
    }
}
