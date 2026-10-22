package com.ss.android.lark.officesdk.minutes.service.recording.common.statistics;

import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSession;
import com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.MmRecordingCommonParam;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.passport.signinsdk_api.base.log.UniContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class i {
    public static final List<String> b = null;
    public static final List<String> c = null;
    public static final List<String> d = null;
    public static final List<String> e = null;
    public static final Set<String> f = null;
    public final com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.c a;

    public static final class a {
        public a() {
        }

        public static void b(JSONObject r10) {
            Intrinsics.checkNotNullParameter(r10, "params");
            if (Intrinsics.areEqual(OfficeSDKManager.isDebug(), Boolean.TRUE) == true) goto L5;
            return;
        L5:
            String r0 = r10.optString("action_name");
            if (r0 != null) goto L8;
        L32:
            List<String> r1 = CollectionsKt.emptyList();
        L33:
            List r2 = CollectionsKt.plus(i.b, r1);
            ArrayList r3 = new ArrayList();
            Iterator r4 = r2.iterator();
        L35:
            if (r4.hasNext() == false) goto L54;
            String r5 = (String) r4.next();
            List<String> r6 = i.b;
            String r7 = null;
            if (r10.has(r5) == false) goto L52;
            Object r8 = r10.opt(r5);
            if (r8 == null) goto L42;
            String r9 = r8.toString();
        L43:
            if (r9 != null) goto L46;
            r9 = "";
        L46:
            if (r9.length() != 0) goto L48;
            boolean r11 = true;
        L49:
            if (r11 == true) goto L52;
            r7 = r5 + '=' + r9;
            goto L52
        L48:
            r11 = false;
            goto L49
        L42:
            r9 = null;
        L52:
            if (r7 == null) goto L35;
            r3.add(r7);
            goto L35
        L54:
            lvb.a.e("MmRecordingDiagnosisTracker", "[diagnosis_event] " + CollectionsKt.joinToString$default(r3, ", ", null, null, 0, null, null, 62, null));
            return;
        L8:
            switch(r0.hashCode()) {
                case -737346698: goto L29;
                case -600415528: goto L26;
                case 294297342: goto L22;
                case 1228886738: goto L18;
                case 1295680288: goto L15;
                case 1801277313: goto L11;
                default: goto L32;
            };
        L11:
            if (r0.equals("recording_exception") == false) goto L32;
            r1 = i.e;
            goto L33
        L15:
            if (r0.equals("recording_lifecycle_invalid_transition") == false) goto L32;
        L27:
            r1 = i.c;
            goto L33
        L18:
            if (r0.equals("recording_rtc_stage") == false) goto L32;
            r1 = CollectionsKt.listOf(new String[]{"rtc_stage", "stage_status", "result_code", "result_source"});
            goto L33
        L22:
            if (r0.equals("recording_upload_segment_batch") == false) goto L32;
            r1 = CollectionsKt.listOf(new String[]{"batch_sequence", "batch_size", "flush_reason"});
            goto L33
        L26:
            if (r0.equals("recording_lifecycle_transition") == false) goto L32;
        L29:
            if (r0.equals("recording_upload_summary") == false) goto L32;
            r1 = i.d;
            goto L33
        }

        public static void c(MmRecordingCommonParam r21, String r22, String r23, String r24, Integer r25, String r26, String r27, Integer r28, Integer r29, String r30, Integer r31, String r32, Boolean r33, String r34, Long r35, int r36) {
            List<String> r1 = i.b;
            if ((r36 & 16) == 0) goto L5;
            Integer r7 = null;
        L7:
            if ((r36 & 32) == 0) goto L9;
            String r8 = "";
        L11:
            if ((r36 & 64) == 0) goto L13;
            String r9 = "";
        L15:
            if ((r36 & 128) == 0) goto L17;
            Integer r10 = null;
        L19:
            if ((r36 & 256) == 0) goto L21;
            Integer r11 = null;
        L23:
            if ((r36 & 512) == 0) goto L25;
            String r12 = "";
        L27:
            if ((r36 & 1024) == 0) goto L29;
            Integer r13 = null;
        L31:
            if ((r36 & 2048) == 0) goto L33;
            String r14 = "";
        L35:
            if ((r36 & 4096) == 0) goto L37;
            Boolean r15 = null;
        L39:
            if ((r36 & 8192) == 0) goto L41;
            String r2 = "";
        L43:
            if ((32768 & r36) == 0) goto L45;
            String r6 = "";
        L47:
            if ((r36 & 65536) == 0) goto L49;
            Long r19 = null;
        L50:
            Intrinsics.checkNotNullParameter(r21, "commonParam");
            Intrinsics.checkNotNullParameter(r22, "source");
            Intrinsics.checkNotNullParameter(r23, "exceptionStage");
            Intrinsics.checkNotNullParameter(r24, "severity");
            Intrinsics.checkNotNullParameter(r8, "errorMsg");
            Intrinsics.checkNotNullParameter(r9, "requestPath");
            Intrinsics.checkNotNullParameter(r12, "logId");
            Intrinsics.checkNotNullParameter(r14, "errorMessage");
            Intrinsics.checkNotNullParameter(r2, "state");
            Intrinsics.checkNotNullParameter(r6, "responseName");
            String r16 = r2;
            JSONObject r0 = a(r21, r22, r23, r24, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, null, r6, r19, 131072);
            b(r0);
            new com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.c(null, 3);
            com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.c.h("minutes_recording_dev", r0);
            return;
        L49:
            r19 = r35;
            goto L50
        L45:
            r6 = r34;
            goto L47
        L41:
            r2 = null;
            goto L43
        L37:
            r15 = r33;
            goto L39
        L33:
            r14 = r32;
            goto L35
        L29:
            r13 = r31;
            goto L31
        L25:
            r12 = r30;
            goto L27
        L21:
            r11 = r29;
            goto L23
        L17:
            r10 = r28;
            goto L19
        L13:
            r9 = r27;
            goto L15
        L9:
            r8 = r26;
            goto L11
        L5:
            r7 = r25;
            goto L7
        }

        public static JSONObject a(MmRecordingCommonParam r21, String r22, String r23, String r24, Integer r25, String r26, String r27, Integer r28, Integer r29, String r30, Integer r31, String r32, Boolean r33, String r34, Integer r35, String r36, Long r37, int r38) {
            List<String> r4 = i.b;
            Long r5 = null;
            if ((r38 & 32) == 0) goto L5;
            Integer r6 = null;
        L6:
            String r7 = "";
            if ((r38 & 64) == 0) goto L9;
            String r8 = "";
        L11:
            if ((r38 & 128) == 0) goto L13;
            String r9 = "";
        L15:
            if ((r38 & 256) == 0) goto L17;
            Integer r10 = null;
        L19:
            if ((r38 & 512) == 0) goto L21;
            Integer r11 = null;
        L23:
            if ((r38 & 1024) == 0) goto L25;
            String r12 = "";
        L27:
            if ((r38 & 2048) == 0) goto L29;
            Integer r13 = null;
        L31:
            if ((r38 & 4096) == 0) goto L33;
            String r14 = "";
        L35:
            if ((r38 & 8192) == 0) goto L37;
            Boolean r15 = null;
        L39:
            if ((r38 & 16384) == 0) goto L41;
            String r16 = "";
        L43:
            if ((r38 & 32768) == 0) goto L45;
            Integer r17 = null;
        L47:
            if ((r38 & 65536) != 0) goto L51;
            r7 = r36;
        L51:
            if ((r38 & 131072) == 0) goto L53;
            long r18 = System.currentTimeMillis();
        L54:
            long r19 = r18;
            if ((r38 & 262144) != 0) goto L58;
            r5 = r37;
        L58:
            Long r210 = r5;
            Intrinsics.checkNotNullParameter("recording_exception", "actionName");
            Boolean r211 = r15;
            Intrinsics.checkNotNullParameter(r21, "commonParam");
            Intrinsics.checkNotNullParameter(r22, "source");
            Intrinsics.checkNotNullParameter(r23, "exceptionStage");
            Intrinsics.checkNotNullParameter(r24, "severity");
            Integer r212 = r11;
            Intrinsics.checkNotNullParameter(r8, "errorMsg");
            Intrinsics.checkNotNullParameter(r9, "requestPath");
            Intrinsics.checkNotNullParameter(r12, "logId");
            Intrinsics.checkNotNullParameter(r14, "errorMessage");
            Intrinsics.checkNotNullParameter(r16, "state");
            Intrinsics.checkNotNullParameter(r7, "responseName");
            com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d r110 = r21.asRecordingDevTrackerParams();
            Integer r213 = r10;
            r110.e("action_name", "recording_exception");
            Integer r214 = r13;
            String r20 = r14;
            r110.c("event_time_ms", r19);
            r110.e("source", r22);
            r110.e("exception_stage", r23);
            r110.e("severity", r24);
            r110.e(UniContext.KEY_OF_ERROR_MSG, r8);
            r110.e("request_path", r9);
            r110.e("logid", r12);
            boolean r1 = true;
            if (r7.length() <= 0) goto L61;
            boolean r0 = true;
        L62:
            if (r0 == false) goto L65;
            r110.e("response_name", r7);
        L65:
            if (r16.length() <= 0) goto L67;
            boolean r2 = true;
        L68:
            if (r2 == false) goto L70;
            r110.e("latest_state", r16);
        L70:
            if (r6 == null) goto L72;
            r110.b(UniContext.KEY_OF_ERROR_CODE, r6.intValue());
        L72:
            if (r214 == null) goto L75;
            r110.b("error_status", r214.intValue());
        L75:
            if (r20.length() > 0) goto L78;
            r1 = false;
        L78:
            if (r1 == false) goto L80;
            r110.e("error_message", r20);
        L80:
            if (r213 == null) goto L82;
            r110.b("http_error_code", r213.intValue());
        L82:
            if (r212 == null) goto L84;
            r110.b("biz_error_code", r212.intValue());
        L84:
            if (r211 == null) goto L86;
            r110.b("network_available", r211.booleanValue() ? 1 : 0);
        L86:
            if (r17 == null) goto L88;
            r110.b("seg_index", r17.intValue());
        L88:
            if (r210 == null) goto L91;
            r110.c("latency_ms", r210.longValue());
        L91:
            return r110.a();
        L67:
            r2 = false;
            goto L68
        L61:
            r0 = false;
            goto L62
        L53:
            r18 = 0;
            goto L54
        L45:
            r17 = r35;
            goto L47
        L41:
            r16 = r34;
            goto L43
        L37:
            r15 = r33;
            goto L39
        L33:
            r14 = r32;
            goto L35
        L29:
            r13 = r31;
            goto L31
        L25:
            r12 = r30;
            goto L27
        L21:
            r11 = r29;
            goto L23
        L17:
            r10 = r28;
            goto L19
        L13:
            r9 = r27;
            goto L15
        L9:
            r8 = r26;
            goto L11
        L5:
            r6 = r25;
            goto L6
        }
    }

    static {
        new a();
        b = CollectionsKt.listOf(new String[]{"action_name", "recording_trace_id", "record_id", "event_time_ms"});
        c = CollectionsKt.listOf(new String[]{"state_sequence", "from_state", "to_state", "event", "terminate_reason"});
        d = CollectionsKt.listOf(new String[]{"summary_stage", "total_count", "success_count", "failed_count", "retry_count", "discard_count", "progress", "terminate_reason"});
        e = CollectionsKt.listOf(new String[]{"exception_stage", "severity", UniContext.KEY_OF_ERROR_CODE, "error_status", "error_message", "response_name", "seg_index"});
        f = SetsKt.setOf(new String[]{"event_time_ms", "recording_start_time_ms", "state_sequence", "duration_in_state_ms", "latency_ms", "result_code", "batch_sequence", "batch_size", "seg_index", "start_time_ms", "part_duration_ms", "file_size", "attempt", "http_code", "status_code", "queue_size", "running_count", "total_count", "success_count", "failed_count", "retry_count", "discard_count", "progress", "is_incomplete", UniContext.KEY_OF_ERROR_CODE, "error_status", "http_error_code", "biz_error_code", "network_available"});
    }

    public i(com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.c r2) {
        Intrinsics.checkNotNullParameter(r2, "businessTracker");
        this.a = r2;
    }

    public final void b(JSONObject r2) {
        a.b(r2);
        this.a.getClass();
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.c.h("minutes_recording_dev", r2);
    }

    public static com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d a(i r23, MmRecordingSession r24, String r25, String r26, long r27) {
        long r3 = System.currentTimeMillis();
        Intrinsics.checkNotNullParameter(r24, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r25, "actionName");
        Intrinsics.checkNotNullParameter(r26, "latestStateName");
        ovb.b r5 = r24.w;
        MmRecordingCommonParam r6 = r24.j();
        String r8 = r6.getRecordId();
        boolean r20 = true;
        if (r8.length() != 0) goto L5;
        boolean r9 = true;
    L6:
        if (r9 == false) goto L9;
        r8 = r5.a;
    L9:
        if (r8.length() != 0) goto L11;
        boolean r10 = true;
    L12:
        if (r10 == false) goto L15;
        r8 = r5.g;
    L15:
        if (r8.length() != 0) goto L17;
        boolean r11 = true;
    L18:
        if (r11 == false) goto L20;
        r8 = r24.e();
    L20:
        String r12 = r6.getMeetingId();
        if (r12.length() != 0) goto L23;
        boolean r13 = true;
    L24:
        if (r13 == false) goto L26;
        r12 = r5.a;
    L26:
        String r14 = r24.c;
        MmRecordingSource r15 = r6.getSource();
        Long r22 = null;
        if (r15 != null) goto L32;
        iub.k r16 = r24.f;
        if (r16 == null) goto L31;
        r15 = r16.a;
        goto L32
    L31:
        r15 = null;
    L32:
        String r17 = r6.getSessionType();
        if (r17.length() != 0) goto L35;
        boolean r18 = true;
    L36:
        if (r18 == false) goto L38;
        r17 = r24.a.name();
    L38:
        MmRecordingCommonParam r7 = MmRecordingCommonParam.copy$default(r6, null, r8, false, null, r12, null, r14, r15, null, null, r17, 813, null);
        MmRecordingSource r19 = r7.getSource();
        if (r19 == null) goto L42;
        String r21 = r19.getValue();
        if (r21 == null) goto L42;
    L50:
        Long r0 = Long.valueOf(r5.b);
        if (r0.longValue() > 0) goto L54;
        r20 = false;
    L54:
        if (r20 == false) goto L56;
        r22 = r0;
    L56:
        if (r22 == null) goto L58;
        long r28 = r22.longValue();
    L59:
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d r1 = r7.asRecordingDevTrackerParams();
        r1.e("action_name", r25);
        r1.c("event_time_ms", r3);
        r1.e("meeting_id", r7.getMeetingId());
        r1.e("minutes_token", r7.getToken());
        r1.e("source", r21);
        r1.e("is_hardware", String.valueOf(r7.isHardware()));
        r1.c("recording_start_time_ms", r28);
        r1.e("latest_state", r26);
        return r1;
    L58:
        r28 = r27;
    L42:
        iub.k r2 = r24.f;
        if (r2 == null) goto L47;
        MmRecordingSource r4 = r2.a;
        if (r4 == null) goto L47;
        r21 = r4.getValue();
    L48:
        if (r21 != null) goto L50;
        r21 = "";
    L47:
        r21 = null;
        goto L48
    L35:
        r18 = false;
        goto L36
    L23:
        r13 = false;
        goto L24
    L17:
        r11 = false;
        goto L18
    L11:
        r10 = false;
        goto L12
    L5:
        r9 = false;
        goto L6
    }
}
