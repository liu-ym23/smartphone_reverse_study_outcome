package com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.api.recording.doubao.DoubaoStatisticInfo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSession;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.data.RecordingSessionType;
import com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.g;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.statistics.Statistics;
import iub.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c {
    public static final /* synthetic */ int n = 0;
    public final Function0<kub.d> a;
    public final b b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;
    public final Lazy l;
    public final Lazy m;

    public static final class a {

        /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.c$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0049a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[RecordingSessionType.values().length];
                r0[RecordingSessionType.HARDWARE_RECORDING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
            L19:
                r0[RecordingSessionType.HARDWARE_LIVE_RECORDING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
            L27:
                r0[RecordingSessionType.STANDALONE_AI_INTERPRETATION.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
            L21:
                r0[RecordingSessionType.SOFTWARE_RECORDING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
            L23:
                r0[RecordingSessionType.HISTORY_RECORDING.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
            L17:
                r0[RecordingSessionType.PRE_MEETING_NATIVE_RECORDING.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
            L9:
                a = r0;
            }
        }

        public static void b(JSONObject r3) {
            Intrinsics.checkNotNullParameter("minutes_recording_dev", "eventName");
            d r0 = new d();
            r0.f(r3);
            JSONObject r4 = r0.a();
            lvb.a.a("MmRecordingBusinessTracker", "[sendGlobalEvent] eventName=minutes_recording_dev, params=" + r4);
            Statistics.sendEvent("minutes_recording_dev", r4);
        }

        public static String a(RecordingSessionType r3, k r4) {
            Intrinsics.checkNotNullParameter(r3, "sessionType");
            switch(C0049a.a[r3.ordinal()]) {
                case 1: goto L30;
                case 2: goto L30;
                case 3: goto L6;
                case 4: goto L6;
                case 5: goto L32;
                case 6: goto L32;
                default: goto L5;
            };
        L6:
            if (r4 == null) goto L33;
            MmRecordingSource r5 = r4.a;
            if (r5 == MmRecordingSource.FEISHU) goto L16;
            boolean r1 = false;
            if (r5 != null) goto L12;
        L14:
            boolean r6 = false;
        L15:
            if (r6 == true) goto L16;
        L17:
            if (r1 == true) goto L20;
            r4 = null;
        L20:
            if (r4 == null) goto L34;
            Object r7 = r4.b.get("from_source");
            if (r7 == null) goto L24;
            String r8 = r7.toString();
        L25:
            if (r8 != null) goto L28;
            r8 = "";
        L28:
            if ((!StringsKt.isBlank(r8)) == true) goto L36;
            return null;
        L36:
            return r8;
        L24:
            r8 = null;
            goto L25
        L34:
            return null;
        L12:
            if (r5.isStandaloneAIInterpretationSource() != true) goto L14;
            r6 = true;
        L16:
            r1 = true;
            goto L17
        L33:
            return null;
        L30:
            return "hardware";
        L32:
            return null;
        L5:
            throw new NoWhenBranchMatchedException();
        }
    }

    static {
    }

    public c() {
        this(null, 3);
    }

    public final g a() {
        return (g) this.k.getValue();
    }

    public final MmRecordingCommonParam b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "sessionId");
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.a r3 = c(r2);
        if (r3 != null) goto L7;
        return null;
    L7:
        return r3.b;
    }

    public final com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.a c(String r2) {
        Intrinsics.checkNotNullParameter(r2, "sessionId");
        return this.b.getContext(r2);
    }

    public final boolean d(String r2) {
        Intrinsics.checkNotNullParameter(r2, "sessionId");
        MmRecordingCommonParam r3 = b(r2);
        if (r3 != null) goto L5;
    L7:
        return false;
    L5:
        if (r3.isValid() != true) goto L7;
        return true;
    }

    public final void e(String r5) {
        Intrinsics.checkNotNullParameter(r5, "sessionId");
        b r1 = this.b;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r5, "sessionId");
        r1.b(r5, null, Boolean.TRUE, "markEndWindowClosed");
    }

    public final void f(String r5) {
        Intrinsics.checkNotNullParameter(r5, "sessionId");
        b r1 = this.b;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r5, "sessionId");
        r1.b(r5, Boolean.TRUE, null, "markSessionEnded");
    }

    public c(Function0 r2, int r3) {
        if ((r3 & 1) == 0) goto L6;
        r2 = MmRecordingBusinessTracker$1.INSTANCE;
    L6:
        if ((r3 & 2) == 0) goto L8;
        b r4 = new b();
    L9:
        Intrinsics.checkNotNullParameter(r2, "hostTrackerProvider");
        Intrinsics.checkNotNullParameter(r4, "contextStore");
        this.a = r2;
        this.b = r4;
        this.c = LazyKt.lazy(new MmRecordingBusinessTracker$recordingPageTracker$2(this));
        this.d = LazyKt.lazy(new MmRecordingBusinessTracker$recordFloatWindowTracker$2(this));
        this.e = LazyKt.lazy(new MmRecordingBusinessTracker$backgroundRunTracker$2(this));
        this.f = LazyKt.lazy(new MmRecordingBusinessTracker$aiInterpretationTracker$2(this));
        this.g = LazyKt.lazy(new MmRecordingBusinessTracker$doubaoBusinessTracker$2(this));
        this.h = LazyKt.lazy(new MmRecordingBusinessTracker$voicePrintTracker$2(this));
        this.i = LazyKt.lazy(new MmRecordingBusinessTracker$subtitleTracker$2(this));
        this.j = LazyKt.lazy(new MmRecordingBusinessTracker$quotaCtaTracker$2(this));
        this.k = LazyKt.lazy(new MmRecordingBusinessTracker$aiNoteTracker$2(this));
        this.l = LazyKt.lazy(new MmRecordingBusinessTracker$diagnosisTracker$2(this));
        new com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.d(this);
        this.m = LazyKt.lazy(new MmRecordingBusinessTracker$standaloneAIInterpretationTracker$2(this));
        return;
    L8:
        r4 = null;
        goto L9
    }

    public static void h(String r2, JSONObject r3) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        d r0 = new d();
        r0.f(r3);
        JSONObject r4 = r0.a();
        lvb.a.a("MmRecordingBusinessTracker", "[sendEvent] eventName=" + r2 + ", params=" + r4);
        Statistics.sendEvent(r2, r4);
    }

    public final void k(MmRecordingSession r12, MmRecordingCommonParam r13) {
        Intrinsics.checkNotNullParameter(r12, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r13, "commonParam");
        b r2 = this.b;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r12, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r13, "commonParam");
        String r0 = r12.e();
        if (StringsKt.isBlank(r0) == false) goto L5;
        lvb.a.h("MmRecordingBusinessTrackContextStore", "[updateContext] skip: sessionId is blank");
        return;
    L5:
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.a r1 = r2.a.get(r0);
        k r14 = r12.f;
        if (r14 == null) goto L8;
        DoubaoStatisticInfo r15 = r14.a();
    L9:
        DoubaoStatisticInfo r6 = r15;
        boolean r16 = false;
        if (r1 == null) goto L12;
        boolean r7 = r1.d;
    L13:
        if (r1 == null) goto L15;
        boolean r8 = r1.e;
    L16:
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.a r10 = new com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.a(r0, r13, r6, r7, r8);
        r2.a.put(r0, r10);
        StringBuilder r17 = new StringBuilder("[updateContext] sessionId=");
        r17.append(r0);
        r17.append(", hasDoubaoInfo=");
        if (r10.c == null) goto L19;
        r16 = true;
    L19:
        r17.append(r16);
        lvb.a.e("MmRecordingBusinessTrackContextStore", r17.toString());
        r2.a(r0);
        return;
    L15:
        r8 = false;
        goto L16
    L12:
        r7 = false;
        goto L13
    L8:
        r15 = null;
        goto L9
    }

    public static void j(MmRecordingCommonParam r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "commonParam");
        Intrinsics.checkNotNullParameter(r3, "fromSource");
        Intrinsics.checkNotNullParameter(r4, "scene");
        d r5 = r2.asTrackerParams();
        r5.e("from_source", r3);
        r5.e("scene", r4);
        h("vc_record_upload_minutes_create_status", r5.a());
    }

    public final void g(String r5, String r6, JSONObject r7) {
        Intrinsics.checkNotNullParameter(r5, "sessionId");
        Intrinsics.checkNotNullParameter(r6, "eventName");
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.a r0 = c(r5);
        if (r0 != null) goto L6;
        lvb.a.h("MmRecordingBusinessTracker", "[sendEvent] skip: context missing, eventName=" + r6 + ", sessionId=" + r5);
        return;
    L6:
        d r3 = new d();
        r3.f(r7);
        r3.f(r0.b.asTrackerParams().a());
        JSONObject r8 = r3.a();
        lvb.a.a("MmRecordingBusinessTracker", "[sendEvent] eventName=" + r6 + ", sessionId=" + r5 + ", params=" + r8);
        Statistics.sendEvent(r6, r8);
    }

    public final void i(String r5, String r6, JSONObject r7) {
        Intrinsics.checkNotNullParameter(r5, "sessionId");
        Intrinsics.checkNotNullParameter(r6, "eventName");
        Intrinsics.checkNotNullParameter(r7, "eventParams");
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.a r0 = c(r5);
        if (r0 != null) goto L7;
        lvb.a.h("MmRecordingBusinessTracker", "[sendWebEvent] skip: context missing, eventName=" + r6 + ", sessionId=" + r5);
        return;
    L7:
        if (r0.b.isValid() == true) goto L10;
        lvb.a.h("MmRecordingBusinessTracker", "[sendWebEvent] skip: commonParam invalid, eventName=" + r6 + ", sessionId=" + r5);
        return;
    L10:
        r0.b.putCommonParamsTo(r7, "webview");
        g(r5, r6, r7);
    }
}
