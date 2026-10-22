package com.ss.android.lark.officesdk.minutes.service.recording.common.statistics;

import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSession;
import com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.MmRecordingCommonParam;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class q {
    public final com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.c a;
    public final Object b;
    public final Set<String> c;
    public final Map<String, String> d;

    public static final class a {
    }

    static {
    }

    public q(com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.c r2) {
        Intrinsics.checkNotNullParameter(r2, "businessTracker");
        this.a = r2;
        this.b = new Object();
        this.c = new LinkedHashSet();
        this.d = new LinkedHashMap();
    }

    public final void b(MmRecordingSession r4, String r5) {
        if (r4 == null) goto L16;
        MmRecordingCommonParam r6 = r4.j();
        if (r6 == null) goto L17;
        Intrinsics.checkNotNullParameter(r6, "commonParam");
        Intrinsics.checkNotNullParameter(r5, PickerReporterConstants.KEY.CLICK);
        JSONObject r2 = null;
        if (r6.isValid() == true) goto L9;
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d r7 = null;
    L10:
        if (r7 == null) goto L12;
        r7.e(PickerReporterConstants.KEY.CLICK, r5);
        r2 = r7.a();
    L12:
        if (r2 != null) goto L14;
        return;
    L14:
        this.a.getClass();
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.c.h("vc_solo_ai_si_click", r2);
        return;
    L9:
        r7 = r6.asTrackerParams();
        goto L10
    L17:
        return;
    }

    public final void a(String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "recordingId");
        Intrinsics.checkNotNullParameter(r4, "windowType");
        Intrinsics.checkNotNullParameter(r5, "aiSiTime");
        if (StringsKt.isBlank(r3) == false) goto L5;
        return;
    L5:
        Object r0 = this.b;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (Intrinsics.areEqual(r5, "start") == false) goto L10;
        this.c.add(r3);     // Catch: Throwable -> L13
    L10:
        this.d.put(r3, r4);     // Catch: Throwable -> L13
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(r0);
    }

    public final boolean c(MmRecordingSession r4, p r5, String r6, String r7) {
        MmRecordingCommonParam r8 = r4.j();
        Intrinsics.checkNotNullParameter(r8, "commonParam");
        Intrinsics.checkNotNullParameter(r5, "state");
        Intrinsics.checkNotNullParameter(r6, "aiSiTime");
        Intrinsics.checkNotNullParameter(r7, "windowType");
        JSONObject r1 = null;
        String r2 = null;
        if (r8.isValid() == true) goto L5;
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d r9 = null;
    L7:
        if (r9 == null) goto L14;
        r9.e("ai_si_time", r6);
        String r10 = r5.a;
        if ((!StringsKt.isBlank(r10)) == false) goto L11;
        r2 = r10;
    L11:
        if (r2 != null) goto L13;
        r2 = "auto";
    L13:
        r9.e("speak_language", r2);
        r9.e("translation_language", r5.b);
        r9.e("show_translation_both", String.valueOf(r5.c));
        r9.e("save_notes", String.valueOf(r5.d));
        r9.e("ai_si_voice", String.valueOf(r5.e));
        r9.e("window_type", r7);
        r1 = r9.a();
    L14:
        if (r1 != null) goto L17;
        return false;
    L17:
        this.a.getClass();
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.c.h("vc_solo_ai_si_view", r1);
        return true;
    L5:
        r9 = r8.asTrackerParams();
        goto L7
    }
}
