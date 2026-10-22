package com.ss.android.lark.officesdk.minutes.service.recording.common.statistics;

import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSession;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.data.TerminateReason;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.upload.ErrorType;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.upload.MmRecordingUploadResponse;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.upload.MmRecordingUploadTask;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Triple;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class n {
    public static final /* synthetic */ int m = 0;
    public final d a;
    public final Function0<Long> b;
    public final Function1<String, Long> c;
    public final Object d;
    public final List<JSONObject> e;
    public final Map<Integer, Integer> f;
    public final Set<Integer> g;
    public final Set<Integer> h;
    public int i;
    public int j;
    public int k;
    public boolean l;

    public static final class a {
    }

    public static final class b {
        public final int a;
        public final String b;
        public final List<JSONObject> c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.a * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
        }

        public final String toString() {
            return "PendingBatch(sequence=" + this.a + ", flushReason=" + this.b + ", events=" + this.c + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(int r2, String r3, List<? extends JSONObject> r4) {
            Intrinsics.checkNotNullParameter(r3, "flushReason");
            Intrinsics.checkNotNullParameter(r4, "events");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class c implements d {
        public final l a;

        public c(l r2) {
            Intrinsics.checkNotNullParameter(r2, "sessionReporter");
            this.a = r2;
        }

        @Override // com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.n.d
        public final void b(int r11, int r12, String r13, String r14) {
            Intrinsics.checkNotNullParameter(r13, "flushReason");
            Intrinsics.checkNotNullParameter(r14, "segmentEvents");
            l r2 = this.a;
            r2.getClass();
            Intrinsics.checkNotNullParameter(r13, "flushReason");
            Intrinsics.checkNotNullParameter(r14, "segmentEvents");
            i r9 = r2.b;
            MmRecordingSession r4 = r2.a;
            String r6 = r2.c();
            long r7 = r2.d;
            r9.getClass();
            Intrinsics.checkNotNullParameter(r4, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
            Intrinsics.checkNotNullParameter(r13, "flushReason");
            Intrinsics.checkNotNullParameter(r14, "segmentEvents");
            Intrinsics.checkNotNullParameter(r6, "latestStateName");
            com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d r0 = i.a(r9, r4, "recording_upload_segment_batch", r6, r7);
            r0.b("batch_sequence", r11);
            r0.b("batch_size", r12);
            r0.e("flush_reason", r13);
            r0.e("segment_events", r14);
            r9.b(r0.a());
        }

        @Override // com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.n.d
        public final void c(Integer r12, String r13, Integer r14, Integer r15, Integer r16, String r17) {
            Intrinsics.checkNotNullParameter("upload", "exceptionStage");
            Intrinsics.checkNotNullParameter("error", "severity");
            Intrinsics.checkNotNullParameter(r13, "errorMsg");
            Intrinsics.checkNotNullParameter(r17, "responseName");
            l.i(this.a, "upload", r12, r13, r14, r15, null, r16, r17, 912);
        }

        @Override // com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.n.d
        public final void a(String r18, int r19, int r20, int r21, int r22, int r23, float r24, String r25, String r26) {
            Intrinsics.checkNotNullParameter(r18, "summaryStage");
            Intrinsics.checkNotNullParameter(r25, "responseName");
            Intrinsics.checkNotNullParameter(r26, "terminateReason");
            l r9 = this.a;
            r9.getClass();
            Intrinsics.checkNotNullParameter(r18, "summaryStage");
            Intrinsics.checkNotNullParameter(r25, "responseName");
            Intrinsics.checkNotNullParameter(r26, "terminateReason");
            i r14 = r9.b;
            MmRecordingSession r11 = r9.a;
            String r13 = r9.c();
            long r10 = r9.d;
            r14.getClass();
            Intrinsics.checkNotNullParameter(r11, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
            Intrinsics.checkNotNullParameter(r18, "summaryStage");
            Intrinsics.checkNotNullParameter(r25, "responseName");
            Intrinsics.checkNotNullParameter(r26, "terminateReason");
            Intrinsics.checkNotNullParameter(r13, "latestStateName");
            com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d r12 = i.a(r14, r11, "recording_upload_summary", r13, r10);
            Intrinsics.checkNotNullParameter(r12, "params");
            Intrinsics.checkNotNullParameter(r18, "summaryStage");
            Intrinsics.checkNotNullParameter(r25, "responseName");
            Intrinsics.checkNotNullParameter(r26, "terminateReason");
            r12.e("summary_stage", r18);
            boolean r5 = true;
            if (Intrinsics.areEqual(r18, "started") == true) goto L10;
            r12.b("total_count", r19);
            r12.b("success_count", r20);
            r12.b("failed_count", r21);
            r12.b("retry_count", r22);
            r12.b("discard_count", r23);
            r12.d("progress", Float.valueOf(r24));
            if (r20 >= r19) goto L7;
            int r0 = 1;
        L8:
            r12.b("is_incomplete", r0);
            goto L10
        L7:
            r0 = 0;
        L10:
            if (r25.length() <= 0) goto L12;
            boolean r1 = true;
        L13:
            if (r1 == false) goto L16;
            r12.e("response_name", r25);
        L16:
            if (r26.length() > 0) goto L19;
            r5 = false;
        L19:
            if (r5 == false) goto L21;
            r12.e("terminate_reason", r26);
        L21:
            r14.b(r12.a());
            return;
        L12:
            r1 = false;
            goto L13
        }
    }

    public interface d {
        void a(String r1, int r2, int r3, int r4, int r5, int r6, float r7, String r8, String r9);

        void b(int r1, int r2, String r3, String r4);

        void c(Integer r1, String r2, Integer r3, Integer r4, Integer r5, String r6);
    }

    static {
    }

    public n() {
        throw null;
    }

    public n(l r4) {
        Intrinsics.checkNotNullParameter(r4, "sessionReporter");
        c r0 = new c(r4);
        MmRecordingUploadDiagnosisReporter$1 r5 = MmRecordingUploadDiagnosisReporter$1.INSTANCE;
        MmRecordingUploadDiagnosisReporter$2 r1 = MmRecordingUploadDiagnosisReporter$2.INSTANCE;
        Intrinsics.checkNotNullParameter(r0, "sink");
        Intrinsics.checkNotNullParameter(r5, "eventTimeMsProvider");
        Intrinsics.checkNotNullParameter(r1, "fileSizeProvider");
        this.a = r0;
        this.b = r5;
        this.c = r1;
        this.d = new Object();
        this.e = new ArrayList();
        this.f = new LinkedHashMap();
        this.g = new LinkedHashSet();
        this.h = new LinkedHashSet();
    }

    public final int a(MmRecordingUploadTask r3) {
        Object r0 = this.d;
        monitor-enter(r0);
        Map<Integer, Integer> r1 = this.f;     // Catch: Throwable -> L11
        LinkedHashMap r2 = (LinkedHashMap) r1;     // Catch: Throwable -> L11
        Integer r4 = (Integer) r2.get(Integer.valueOf(r3.b));     // Catch: Throwable -> L11
        if (r4 == null) goto L8;
        int r5 = r4.intValue();     // Catch: Throwable -> L11
    L9:
        monitor-exit(r0);
        return r5;
    L8:
        r5 = 1;
    L11:
        th = move-exception;
        throw th;
    }

    public final void b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "reason");
        Object r0 = this.d;
        monitor-enter(r0);
        b r3 = j(r2);     // Catch: Throwable -> L9
        monitor-exit(r0);
        if (r3 == null) goto L14;
        i(r3);
        return;
    L14:
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public final void i(b r5) {
        JSONArray r0 = new JSONArray();
        Iterator<T> r1 = r5.c.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r0.put((JSONObject) r1.next());
        goto L4
    L6:
        this.a.b(r5.a, r0.length(), r5.b, r0.toString());
    }

    public final b j(String r4) {
        if (((ArrayList) this.e).isEmpty() == false) goto L6;
        return null;
    L6:
        List r0 = CollectionsKt.toList(this.e);
        ((ArrayList) this.e).clear();
        int r1 = this.i + 1;
        this.i = r1;
        return new b(r1, r4, r0);
    }

    public final void c(List r3, o r4) {
        Intrinsics.checkNotNullParameter(r3, "tasks");
        Intrinsics.checkNotNullParameter("standalone_ai_interpretation_save_artifact_disabled", "reason");
        Intrinsics.checkNotNullParameter(r4, "snapshot");
        b("discard");
    }

    public final void e(MmRecordingUploadTask r12, o r13) {
        Intrinsics.checkNotNullParameter(r12, "task");
        Intrinsics.checkNotNullParameter(r13, "snapshot");
        Object r0 = this.d;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.l == false) goto L7;
        boolean r1 = false;
    L8:
        monitor-exit(r0);
        if (r1 == false) goto L11;
        m("started", r13, "", "");
    L11:
        h(this, "enqueue", r12, 0, r13, null, null, null, 112);
        return;
    L7:
        r1 = true;
        this.l = true;     // Catch: Throwable -> L13
        goto L8
    }

    public final void d(MmRecordingUploadTask r12, MmRecordingUploadResponse r13, o r14) {
        Intrinsics.checkNotNullParameter(r12, "task");
        Intrinsics.checkNotNullParameter(r13, "response");
        Intrinsics.checkNotNullParameter(r14, "snapshot");
        Object r0 = this.d;
        monitor-enter(r0);
        this.k++;     // Catch: Throwable -> L8
        monitor-exit(r0);
        h(this, "drop", r12, a(r12), r14, r13, null, "drop", 32);
        l(this, r12, r13, "upload_segment_dropped");
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final void f(MmRecordingUploadTask r13, MmRecordingUploadResponse r14, o r15) {
        Intrinsics.checkNotNullParameter(r13, "task");
        Intrinsics.checkNotNullParameter(r15, "snapshot");
        Object r0 = this.d;
        monitor-enter(r0);
        this.g.add(Integer.valueOf(r13.b));     // Catch: Throwable -> L8
        monitor-exit(r0);
        h(this, "fail", r13, a(r13), r15, r14, null, "fail", 32);
        l(this, r13, r14, "upload_retry_exhausted");
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ void l(n r1, MmRecordingUploadTask r2, MmRecordingUploadResponse r3, String r4) {
        if (r3 == null) goto L4;
        String r0 = r3.name();
    L5:
        if (r0 != null) goto L7;
        r0 = "";
    L7:
        r1.k(r2, r3, r4, r0);
        return;
    L4:
        r0 = null;
        goto L5
    }

    public final void g(MmRecordingUploadTask r4, MmRecordingUploadResponse r5, TerminateReason r6, o r7) {
        Intrinsics.checkNotNullParameter(r4, "task");
        Intrinsics.checkNotNullParameter(r5, "response");
        Intrinsics.checkNotNullParameter(r6, "terminateReason");
        Intrinsics.checkNotNullParameter(r7, "snapshot");
        b("terminated");
        String r1 = r5.name();
        Set<String> r2 = l.i;
        m("terminated", r7, r1, l.a.a(r6));
        if (r5 != MmRecordingUploadResponse.SUCCESS) goto L5;
    L14:
        boolean r8 = true;
    L15:
        if (r8 == true) goto L18;
        l(this, r4, r5, "upload_abnormal_terminated");
        return;
    L18:
        return;
    L5:
        if (r5 == MmRecordingUploadResponse.INTERRUPTED) goto L14;
        if (r5 == MmRecordingUploadResponse.UPLOAD_COMPLETED) goto L14;
        if (r5 == MmRecordingUploadResponse.REACH_MAX_DURATION) goto L14;
        if (r5 == MmRecordingUploadResponse.OBJECT_DELETED) goto L14;
        r8 = false;
        goto L15
    }

    public final void k(MmRecordingUploadTask r10, MmRecordingUploadResponse r11, String r12, String r13) {
        Object r0 = this.d;
        monitor-enter(r0);
        boolean r1 = this.h.add(Integer.valueOf(r10.b));     // Catch: Throwable -> L24
        monitor-exit(r0);
        if (r1 == true) goto L8;
        return;
    L8:
        d r2 = this.a;
        if (r11 == null) goto L12;
        Integer r3 = r11.getStatusCode();
        if (r3 == null) goto L12;
    L14:
        Integer r4 = r3;
    L16:
        if (r11 == null) goto L18;
        Integer r5 = r11.getHttpCode();
    L19:
        if (r11 == null) goto L21;
        Integer r6 = r11.getStatusCode();
    L22:
        r2.c(r4, r12, r5, r6, Integer.valueOf(r10.b), r13);
        return;
    L21:
        r6 = null;
        goto L22
    L18:
        r5 = null;
    L12:
        if (r11 == null) goto L15;
        r3 = r11.getHttpCode();
        goto L14
    L15:
        r4 = null;
    L24:
        th = move-exception;
        throw th;
    }

    public final void m(String r18, o r19, String r20, String r21) {
        Object r2 = this.d;
        monitor-enter(r2);
        Triple r3 = new Triple(Integer.valueOf(this.g.size()), Integer.valueOf(this.j), Integer.valueOf(this.k));     // Catch: Throwable -> L8
        monitor-exit(r2);
        this.a.a(r18, r19.a, r19.b, ((Number) r3.getFirst()).intValue(), ((Number) r3.getSecond()).intValue(), ((Number) r3.getThird()).intValue(), r19.e, r20, r21);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public static void h(n r4, String r5, MmRecordingUploadTask r6, int r7, o r8, MmRecordingUploadResponse r9, String r10, String r11, int r12) {
        b r1 = null;
        if ((r12 & 16) == 0) goto L6;
        r9 = null;
    L6:
        if ((r12 & 32) == 0) goto L13;
        if (r9 == null) goto L9;
        r10 = r9.name();
    L10:
        if (r10 != null) goto L13;
        r10 = "";
        goto L13
    L9:
        r10 = null;
    L13:
        if ((r12 & 64) == 0) goto L15;
        r11 = null;
    L15:
        r4.getClass();
        JSONObject r13 = new JSONObject().put("upload_stage", r5).put("event_time_ms", ((Number) r4.b.invoke()).longValue()).put("seg_index", r6.b);
        Long r0 = StringsKt.toLongOrNull(r6.d);
        if (r0 == null) goto L18;
        long r2 = r0.longValue();
    L19:
        JSONObject r14 = r13.put("start_time_ms", r2).put("part_duration_ms", r6.e).put("file_size", ((Number) r4.c.invoke(r6.a)).longValue()).put("attempt", r7).put("queue_size", r8.c).put("running_count", r8.d);
        if (r9 == null) goto L25;
        r14.put("http_code", r9.getHttpCode()).put("status_code", r9.getStatusCode());
        ErrorType r15 = r9.getErrorType();
        if (r15 == null) goto L25;
        r14.put("error_type", r15.name());
    L25:
        if (r10.length() <= 0) goto L27;
        boolean r16 = true;
    L28:
        if (r16 == false) goto L30;
        r14.put("response_name", r10);
    L30:
        Object r17 = r4.d;
        monitor-enter(r17);
        List<JSONObject> r18 = r4.e;     // Catch: Throwable -> L42
        Intrinsics.checkNotNull(r14);     // Catch: Throwable -> L42
        ((ArrayList) r18).add(r14);     // Catch: Throwable -> L42
        if (r11 == null) goto L36;
        r1 = r4.j(r11);     // Catch: Throwable -> L42
    L38:
        monitor-exit(r17);
        if (r1 == null) goto L46;
        r4.i(r1);
        return;
    L46:
        return;
    L36:
        if (((ArrayList) r4.e).size() < 30) goto L38;
        r1 = r4.j("batch_size");     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        throw th;
    L27:
        r16 = false;
        goto L28
    L18:
        r2 = -1;
        goto L19
    }
}
