package com.obric.memorydata.awareness.audio;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.memorydata.database.entity.AuditoryAsrTaskEntity;
import com.obric.memorydata.database.entity.RawObservationEntity;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.ttnet.org.chromium.base.BaseSwitches;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010 \n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001EB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006J\u0016\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u0006J&\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0006J\u0016\u0010\u0019\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0016J\u000e\u0010\u001b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006J\u0016\u0010\u001c\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\f\u001a\u00020\u0006J\u0016\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0006J\u001e\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020$2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\u0006J\u0015\u0010&\u001a\u00020\u00162\u0006\u0010'\u001a\u00020\u0006H\u0000¢\u0006\u0002\b(J\u001a\u0010)\u001a\u00020*2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010+\u001a\u0004\u0018\u00010,H\u0002J \u0010-\u001a\u00020*2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020$2\u0006\u0010.\u001a\u00020/H\u0002J\u0010\u00100\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\u000fH\u0002J\u0010\u00102\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\u000fH\u0002J\u0010\u00103\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\u000fH\u0002J\u0010\u00104\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\u000fH\u0002J\u001a\u00105\u001a\u00020\u00162\u0006\u0010.\u001a\u00020/2\b\u00106\u001a\u0004\u0018\u00010\u000fH\u0002J*\u00107\u001a\u0004\u0018\u00010,2\u0006\u0010#\u001a\u00020$2\u0006\u0010.\u001a\u00020/2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u00108\u001a\u00020\u0016H\u0002J\u0018\u00109\u001a\u00020\u001e2\u0006\u0010:\u001a\u00020\u00062\u0006\u0010.\u001a\u00020/H\u0002J\u0010\u0010;\u001a\u00020\u00162\u0006\u0010.\u001a\u00020/H\u0002J\u0018\u0010<\u001a\u00020\u00162\u0006\u0010.\u001a\u00020/2\u0006\u0010=\u001a\u00020\u0006H\u0002J\u001a\u0010>\u001a\u0004\u0018\u00010\u000f2\u0006\u0010.\u001a\u00020/2\u0006\u0010=\u001a\u00020\u0006H\u0002J\u0010\u0010?\u001a\u00020\u001e2\u0006\u0010.\u001a\u00020/H\u0002J\u0018\u0010@\u001a\u00020\u00162\u0006\u0010A\u001a\u00020\u00162\u0006\u0010B\u001a\u00020\u0016H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00060DX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006F"}, d2 = {"Lcom/obric/memorydata/awareness/audio/AuditoryTelemetryTrace;", "", "<init>", "()V", "v2Stages", "", "", "regularResults", "terminalResults", "detailKeys", "serverTimingKeys", "normalizeInitialTrace", "raw", "appendV2", "event", "Lorg/json/JSONObject;", "containsPipelineTerminal", "", "terminalEntry", "decision", "Lcom/obric/memorydata/awareness/audio/AuditoryTelemetryTrace$TerminalDecision;", "startAtMs", "", "endAtMs", "logId", "lastTraceEnd", "fallback", "lastLogId", "terminalLogId", "l1OutputCount", "", "stableTerminalError", "rawError", "rawTrace", "buildEvent", "task", "Lcom/obric/memorydata/database/entity/AuditoryAsrTaskEntity;", "traceRaw", "mergedAudioDurationMs", "manifestRaw", "mergedAudioDurationMs$awareness_obricRelease", "appendStageCosts", "", "boundaries", "", "appendDiagnosticCosts", "trace", "Lorg/json/JSONArray;", "normalizeV2", AILabCheckPermissionTask.KEY_SOURCE, "sanitizeDetails", "sanitizeWarningCounts", "sanitizeServerTiming", "durationBasedScheduleCost", "timing", "resolveBoundaries", "terminalAt", "failureStage", "errorCode", "asrTerminalEnd", "boundaryEnd", "stage", "latest", "countRetries", "validDelta", CommonConsts.APM_INNER_EVENT_COST_START, "end", "stageCostKeys", "", "TerminalDecision", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f8528a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Set<String> f8529b = null;
    private static final Set<String> c = null;
    private static final Set<String> d = null;
    private static final Set<String> e = null;
    private static final Set<String> f = null;
    private static final List<String> g = null;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001d"}, d2 = {"Lcom/obric/memorydata/awareness/audio/AuditoryTelemetryTrace$TerminalDecision;", "", "resultCode", "", "result", "", "errorCode", "rawCount", "l1OutputCount", "<init>", "(ILjava/lang/String;Ljava/lang/String;II)V", "getResultCode", "()I", "getResult", "()Ljava/lang/String;", "getErrorCode", "getRawCount", "getL1OutputCount", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f8530a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f8531b;
        private final String c;
        private final int d;
        private final int e;

        public a(int r2, String r3, String r4, int r5, int r6) {
            Intrinsics.checkNotNullParameter(r3, "result");
            Intrinsics.checkNotNullParameter(r4, "errorCode");
            this.f8530a = r2;
            this.f8531b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }

        public final int a() {
            return this.f8530a;
        }

        public final String b() {
            return this.f8531b;
        }

        public final String c() {
            return this.c;
        }

        public final int d() {
            return this.d;
        }

        public final int e() {
            return this.e;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (this.f8530a == r6.f8530a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f8531b, r6.f8531b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L21;
            return false;
        L21:
            if (this.e == r6.e) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            return (((((((Integer.hashCode(this.f8530a) * 31) + this.f8531b.hashCode()) * 31) + this.c.hashCode()) * 31) + Integer.hashCode(this.d)) * 31) + Integer.hashCode(this.e);
        }

        public String toString() {
            return "TerminalDecision(resultCode=" + this.f8530a + ", result=" + this.f8531b + ", errorCode=" + this.c + ", rawCount=" + this.d + ", l1OutputCount=" + this.e + ')';
        }
    }

    static {
        f8528a = new e();
        f8529b = SetsKt.setOf(new String[]{"DATACENTER_QUERY", "SOURCE_COPY", "WAV_MERGE", "TASK_PERSIST", "IMAGE_UPLOAD", "ASR_SUBMIT", "ASR_QUERY", "L0_COMMIT", "SPEAKER_MAPPING", "L1_BUILD", "PIPELINE_TERMINAL"});
        c = SetsKt.setOf(new String[]{"SUCCESS", "RETRY", "PENDING", "PROCESSING", "SKIPPED", RawObservationEntity.STATE_FAILED});
        d = SetsKt.setOf(new String[]{"SUCCESS_L1", "SUCCESS_NO_L1", "SUCCESS_NO_ASR", RawObservationEntity.STATE_FAILED, "EXPIRED"});
        e = SetsKt.setOf(new String[]{"segment_count", "source_ready_at_ms", "remote_state", "raw_count", "embedding_count", "l1_output_count", "raw_observation_ids", "l1_output_ids", "server_timing", "warning_counts"});
        f = SetsKt.setOf(new String[]{"accepted_at_ms", "asr_started_at_ms", "asr_finished_at_ms", "result_ready_at_ms", "query_handled_at_ms", "total_duration_ms", "asr_duration_ms", "log_id"});
        g = CollectionsKt.listOf(new String[]{"cost_stage_audio_ready_ms", "cost_stage_audio_process_ms", "cost_stage_upload_ms", "cost_stage_asr_ms", "cost_stage_l0_ms", "cost_stage_l1_ms", "cost_total_ms"});
    }

    private e() {
    }

    private final int a(String r5, JSONArray r6) {
        switch(r5.hashCode()) {
            case -1990365125: goto L34;
            case -1959232721: goto L31;
            case -1643215177: goto L28;
            case 2402104: goto L26;
            case 50597975: goto L24;
            case 717031594: goto L21;
            case 1367558478: goto L18;
            case 1636414027: goto L9;
            case 1887841957: goto L6;
            default: goto L38;
        };
    L24:
        String r4 = "L1_FAILED";
    L25:
        r5.equals(r4);
        goto L38
    L26:
        r4 = "NONE";
        goto L25
    L6:
        if (r5.equals("ASR_SUBMIT_FAILED") == false) goto L38;
        return 3;
    L9:
        if (r5.equals("TASK_EXPIRED") == false) goto L38;
        if (b(r6, "L0_COMMIT") != null) goto L38;
        if (b(r6, "IMAGE_UPLOAD") == null) goto L43;
        return 3;
    L43:
        return 2;
    L18:
        if (r5.equals("SPEAKER_MAPPING_FAILED") == false) goto L38;
    L23:
        return 4;
    L21:
        if (r5.equals("L0_COMMIT_FAILED") == true) goto L23;
    L28:
        if (r5.equals("ASR_REMOTE_FAILED") == false) goto L38;
        return 3;
    L31:
        if (r5.equals("ASR_PROTOCOL_INVALID") == false) goto L38;
        return 3;
    L34:
        if (r5.equals("UPLOAD_FAILED") == true) goto L43;
    L38:
        return 5;
    }

    private final long a(long r3, long r5) {
        if (r3 >= 0) goto L5;
    L7:
        return -1;
    L5:
        if (r5 < r3) goto L7;
        return r5 - r3;
    }

    private final long a(JSONArray r9) {
        int r8 = r9.length() - 1;
    L4:
        if ((-1) >= r8) goto L21;
        JSONObject r1 = r9.optJSONObject(r8);
        if (r1 == null) goto L20;
        if (Intrinsics.areEqual(r1.optString("stage"), "ASR_QUERY") == false) goto L20;
        JSONObject r4 = r1.optJSONObject("details");
        if (r4 == null) goto L13;
        String r5 = r4.optString("remote_state");
    L15:
        if (CollectionsKt.contains((Iterable) ZeusTransformUtils.preCheckCast(SetsKt.setOf(new String[]{"DONE", RawObservationEntity.STATE_FAILED}), Iterable.class, "com.obric.memorydata.plugin"), r5) == false) goto L20;
        if (r1.optBoolean("time_valid", true) == true) goto L19;
        return -1;
    L19:
        return r1.optLong("end_at_ms", -1);
    L13:
        r5 = null;
    L20:
        r8 = r8 - 1;
        goto L4
    L21:
        return -1;
    }

    private final long a(JSONArray r3, String r4) {
        JSONObject r2 = b(r3, r4);
        if (r2 != null) goto L6;
        return -1;
    L6:
        if (r2.optBoolean("time_valid", true) == true) goto L9;
        return -1;
    L9:
        return r2.optLong("end_at_ms", -1);
    }

    private final long a(JSONArray r9, JSONObject r10) {
        if (r10 == null) goto L16;
        long r2 = r10.optLong("total_duration_ms", -1);
        long r4 = r10.optLong("asr_duration_ms", -1);
        if (r2 < 0) goto L16;
        if (r4 > r2) goto L16;
        long r5 = a(r9, "ASR_SUBMIT");
        long r11 = a(r9);
        if (r5 < 0) goto L16;
        if (r2 > (Long.MAX_VALUE - r5)) goto L16;
        return a(r5 + r2, r11);
    L16:
        return -1;
    }

    private final JSONObject a(JSONObject r27) {
        String r2 = r27.getString("stage");
        String r4 = r27.getString("result");
        long r6 = r27.getLong("start_at_ms");
        long r9 = r27.getLong("end_at_ms");
        long r12 = r27.getLong("cost_ms");
        int r15 = r27.getInt("attempt");
        String r11 = r27.optString("log_id");
        String r8 = r27.optString("error_code");
        if (f8529b.contains(r2) == false) goto L43;
        boolean r22 = false;
        if (c.contains(r4) == false) goto L7;
    L12:
        boolean r14 = true;
    L13:
        if (r14 == false) goto L41;
        if (r6 >= 0) goto L17;
    L22:
        boolean r16 = false;
    L23:
        if (r16 == false) goto L39;
        if (r11.length() > 200) goto L29;
        Intrinsics.checkNotNull(r8);
        String r25 = r8;
        if (new Regex("[A-Z0-9_]{0,80}").matches((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L30;
        r22 = true;
    L30:
        if (r22 == false) goto L37;
        JSONObject r10 = r27.optJSONObject("details");
        if (r10 != null) goto L34;
        r10 = new JSONObject();
    L34:
        JSONObject r0 = new JSONObject().put(BaseSwitches.V, 2).put("stage", r2).put("result", r4).put("start_at_ms", r6).put("end_at_ms", r9).put("cost_ms", r12).put("time_valid", r27.optBoolean("time_valid", true)).put("attempt", r15).put("log_id", r11).put("error_code", r25).put("details", b(r10));
        Intrinsics.checkNotNullExpressionValue(r0, "put(...)");
        return r0;
    L37:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L29:
        r25 = r8;
        goto L30
    L39:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L17:
        if (r9 < r6) goto L22;
        if (r12 != (r9 - r6)) goto L22;
        if (r15 <= 0) goto L22;
        r16 = true;
        goto L23
    L41:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L7:
        if (Intrinsics.areEqual(r2, "PIPELINE_TERMINAL") == true) goto L9;
    L11:
        r14 = false;
        goto L13
    L9:
        if (d.contains(r4) == false) goto L11;
    L43:
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    private final void a(JSONObject r13, AuditoryAsrTaskEntity r14, JSONArray r15) {
        long r1 = a(r15, "DATACENTER_QUERY");
        JSONObject r0 = b(r15, "DATACENTER_QUERY");
        long r4 = -1;
        if (r0 == null) goto L7;
        JSONObject r2 = r0.optJSONObject("details");
        if (r2 == null) goto L7;
        long r6 = r2.optLong("source_ready_at_ms", -1);
    L8:
        r13.put("cost_audio_persist_ms", a(r14.getAudioEndMs(), r6));
        r13.put("cost_schedule_audio_query_ms", a(r6, r1));
        JSONObject r16 = b(r15, "ASR_QUERY");
        Long r3 = null;
        if (r16 == null) goto L13;
        JSONObject r17 = r16.optJSONObject("details");
        if (r17 == null) goto L13;
        JSONObject r18 = r17.optJSONObject("server_timing");
    L14:
        if (r18 == null) goto L16;
        long r5 = r18.optLong("asr_started_at_ms", -1);
    L17:
        if (r18 == null) goto L19;
        long r7 = r18.optLong("asr_finished_at_ms", -1);
    L20:
        long r8 = a(r5, r7);
        if (r18 == null) goto L23;
        long r9 = r18.optLong("asr_duration_ms", -1);
    L24:
        Long r10 = Long.valueOf(r9);
        boolean r11 = true;
        if (((Number) ZeusTransformUtils.preCheckCast(r10, Number.class, "com.obric.memorydata.plugin")).longValue() < 0) goto L27;
        boolean r12 = true;
    L28:
        if (r12 == true) goto L31;
        r10 = null;
    L31:
        if (r10 == null) goto L33;
        r8 = r10.longValue();
    L33:
        r13.put("cost_server_asr_ms", r8);
        if (r18 == null) goto L36;
        long r19 = r18.optLong("result_ready_at_ms", -1);
    L37:
        if (r18 == null) goto L39;
        r4 = r18.optLong("query_handled_at_ms", -1);
    L39:
        Long r20 = Long.valueOf(a(r19, r4));
        if (((Number) ZeusTransformUtils.preCheckCast(r20, Number.class, "com.obric.memorydata.plugin")).longValue() >= 0) goto L43;
        r11 = false;
    L43:
        if (r11 == false) goto L45;
        r3 = r20;
    L45:
        if (r3 == null) goto L47;
        long r110 = r3.longValue();
    L48:
        r13.put("cost_schedule_asr_query_ms", r110);
        return;
    L47:
        r110 = a(r15, r18);
        goto L48
    L36:
        r19 = -1;
        goto L37
    L27:
        r12 = false;
        goto L28
    L23:
        r9 = -1;
        goto L24
    L19:
        r7 = -1;
        goto L20
    L16:
        r5 = -1;
    L13:
        r18 = null;
    L7:
        r6 = -1;
        goto L8
    }

    private final void a(JSONObject r10, long[] r11) {
        if (r11 != null) goto L9;
        Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast(g, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L6:
        if (r12.hasNext() == false) goto L8;
        r10.put((String) ZeusTransformUtils.preCheckCast(r12.next(), String.class, "com.obric.memorydata.plugin"), -1);
        goto L6
    L8:
        return;
    L9:
        long[] r1 = new long[6];
        int r2 = 0;
        int r3 = 0;
    L10:
        if (r3 >= 6) goto L12;
        int r4 = r3 + 1;
        r1[r3] = r11[r4] - r11[r3];
        r3 = r4;
        goto L10
    L12:
        Iterator r13 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.take((Iterable) ZeusTransformUtils.preCheckCast(g, Iterable.class, "com.obric.memorydata.plugin"), 6), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L14:
        if (r13.hasNext() == false) goto L19;
        Object r0 = r13.next();
        int r5 = r2 + 1;
        if (r2 >= 0) goto L18;
        CollectionsKt.throwIndexOverflow();
    L18:
        r10.put((String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin"), r1[r2]);
        r2 = r5;
        goto L14
    L19:
        r10.put("cost_total_ms", ArraysKt.sum(r1));
    }

    private final long[] a(AuditoryAsrTaskEntity r18, JSONArray r19, a r20, long r21) {
        long[] r3 = new long[7];
        boolean r4 = false;
        int r5 = 0;
    L3:
        if (r5 >= 7) goto L5;
        r3[r5] = -1;
        r5 = r5 + 1;
        goto L3
    L5:
        r3[0] = r18.getAudioEndMs();
        r3[1] = a(r19, "DATACENTER_QUERY");
        r3[2] = a(r19, "TASK_PERSIST");
        int r6 = a(r20.c(), r19);
        if (r6 != 2) goto L8;
        long r9 = r21;
    L9:
        r3[3] = r9;
        if (r6 != 3) goto L12;
        long r10 = r21;
    L13:
        r3[4] = r10;
        if (r6 != 4) goto L16;
        long r0 = r21;
    L26:
        r3[5] = r0;
        r3[6] = r21;
        if (r6 < 0) goto L30;
        if (r6 >= 2) goto L30;
        boolean r1 = true;
    L31:
        if (r1 == false) goto L33;
        return null;
    L33:
        if (r6 == 2) goto L37;
        if (r6 != 3) goto L39;
        r3[5] = r21;
    L39:
        if (r20.a() != 2) goto L51;
        Long r2 = Long.valueOf(r3[5]);
        if (((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.memorydata.plugin")).longValue() < 0) goto L43;
        boolean r7 = true;
    L44:
        if (r7 == true) goto L47;
        r2 = null;
    L47:
        if (r2 == null) goto L49;
        long r8 = r2.longValue();
    L50:
        r3[6] = r8;
        goto L51
    L49:
        r8 = r21;
        goto L50
    L43:
        r7 = false;
    L51:
        int r11 = 0;
    L52:
        if (r11 >= 7) goto L60;
        if (r3[r11] >= 0) goto L56;
        boolean r12 = true;
    L57:
        if (r12 == true) goto L58;
        r11 = r11 + 1;
        goto L52
    L58:
        boolean r13 = true;
    L61:
        if (r13 == false) goto L63;
        return null;
    L63:
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(RangesKt.until(0, ArraysKt.getLastIndex(r3)), Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r14, Collection.class) == true) goto L66;
    L68:
        Iterator r15 = r14.iterator();
    L70:
        if (r15.hasNext() == false) goto L77;
        int r16 = ((IntIterator) ZeusTransformUtils.preCheckCast(r15, IntIterator.class, "com.obric.memorydata.plugin")).nextInt();
        if (r3[r16 + 1] >= r3[r16]) goto L74;
        boolean r17 = true;
    L75:
        if (r17 == false) goto L70;
        r4 = true;
        goto L77
    L74:
        r17 = false;
    L77:
        if (r4 == false) goto L79;
        return null;
    L79:
        return r3;
    L66:
        if (((Collection) ZeusTransformUtils.preCheckCast(r14, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L68;
    L56:
        r12 = false;
        goto L57
    L60:
        r13 = false;
        goto L61
    L37:
        r3[4] = r21;
        r3[5] = r21;
    L30:
        r1 = false;
        goto L31
    L16:
        Long r110 = Long.valueOf(a(r19, "SPEAKER_MAPPING"));
        if (((Number) ZeusTransformUtils.preCheckCast(r110, Number.class, "com.obric.memorydata.plugin")).longValue() < 0) goto L19;
        boolean r111 = true;
    L20:
        if (r111 == true) goto L23;
        r110 = null;
    L23:
        if (r110 == null) goto L25;
        r0 = r110.longValue();
        goto L26
    L25:
        r0 = a(r19, "L0_COMMIT");
        goto L26
    L19:
        r111 = false;
        goto L20
    L12:
        r10 = a(r19);
        goto L13
    L8:
        r9 = a(r19, "IMAGE_UPLOAD");
        goto L9
    }

    private final int b(JSONArray r5) {
        int r0 = 0;
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(RangesKt.until(0, r5.length()), Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, Collection.class) == true) goto L5;
    L7:
        Iterator r6 = r4.iterator();
    L9:
        if (r6.hasNext() == false) goto L19;
        JSONObject r1 = r5.optJSONObject(((IntIterator) ZeusTransformUtils.preCheckCast(r6, IntIterator.class, "com.obric.memorydata.plugin")).nextInt());
        if (r1 == null) goto L13;
        String r2 = r1.optString("result");
    L15:
        if (Intrinsics.areEqual(r2, "RETRY") == false) goto L9;
        r0 = r0 + 1;
        if (r0 >= 0) goto L9;
        CollectionsKt.throwCountOverflow();
        goto L9
    L13:
        r2 = null;
    L19:
        return r0;
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L7;
        goto L7
    }

    private final JSONObject b(JSONArray r3, String r4) {
        int r2 = r3.length();
    L3:
        r2 = r2 - 1;
        if ((-1) >= r2) goto L12;
        JSONObject r0 = r3.optJSONObject(r2);
        if (r0 == null) goto L3;
        if (Intrinsics.areEqual(r0.optString("stage"), r4) == false) goto L3;
        return r0;
    L12:
        return null;
    }

    private final JSONObject b(JSONObject r15) {
        JSONObject r14 = new JSONObject();
        Iterator<String> r0 = r15.keys();
        Intrinsics.checkNotNullExpressionValue(r0, "keys(...)");
    L4:
        if (r0.hasNext() == false) goto L63;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin");
        if (e.contains(r1) == false) goto L62;
        boolean r2 = true;
        if (r1 == null) goto L53;
        switch(r1.hashCode()) {
            case -923691193: goto L49;
            case 222114228: goto L28;
            case 298603352: goto L20;
            case 1145478342: goto L16;
            case 2113234446: goto L13;
            default: goto L53;
        };
    L16:
        if (r1.equals("server_timing") == false) goto L53;
        e r3 = f8528a;
        JSONObject r4 = r15.getJSONObject(r1);
        Intrinsics.checkNotNullExpressionValue(r4, "getJSONObject(...)");
        Object r5 = r3.d(r4);
    L52:
        r14.put(r1, r5);
        goto L4
    L20:
        if (r1.equals("remote_state") == false) goto L53;
        r5 = r15.getString(r1);
        if (SetsKt.setOf(new String[]{"PENDING", "PROCESSING", "DONE", RawObservationEntity.STATE_FAILED}).contains(r5) == true) goto L52;
        throw new IllegalArgumentException("Failed requirement.".toString());
    L49:
        if (r1.equals("warning_counts") == false) goto L53;
        e r6 = f8528a;
        JSONObject r7 = r15.getJSONObject(r1);
        Intrinsics.checkNotNullExpressionValue(r7, "getJSONObject(...)");
        r5 = r6.c(r7);
        goto L52
    L13:
        if (r1.equals("raw_observation_ids") == false) goto L53;
    L30:
        JSONArray r8 = r15.getJSONArray(r1);
        if (r8.length() > 1000) goto L33;
        boolean r9 = true;
    L34:
        if (r9 == false) goto L47;
        JSONArray r10 = new JSONArray();
        int r11 = r8.length();
        int r12 = 0;
    L36:
        if (r12 >= r11) goto L45;
        long r13 = r8.getLong(r12);
        if (r13 < 0) goto L40;
        boolean r16 = true;
    L41:
        if (r16 == false) goto L44;
        r10.put(r13);
        r12 = r12 + 1;
        goto L36
    L44:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L40:
        r16 = false;
        goto L41
    L45:
        r14.put(r1, r10);
        goto L4
    L47:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L33:
        r9 = false;
        goto L34
    L28:
        if (r1.equals("l1_output_ids") == true) goto L30;
    L53:
        long r17 = r15.getLong(r1);
        if (r17 >= 0) goto L57;
        r2 = false;
    L57:
        if (r2 == false) goto L60;
        r14.put(r1, r17);
        goto L4
    L60:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L62:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L63:
        return r14;
    }

    private final JSONObject c(JSONObject r6) {
        JSONObject r5 = new JSONObject();
        Iterator<String> r0 = r6.keys();
        Intrinsics.checkNotNullExpressionValue(r0, "keys(...)");
    L4:
        if (r0.hasNext() == false) goto L17;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r1);
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin");
        if (new Regex("[A-Z0-9_]{1,64}").matches(r2) == false) goto L16;
        int r3 = r6.getInt(r1);
        if (r3 <= 0) goto L10;
        boolean r4 = true;
    L11:
        if (r4 == false) goto L14;
        r5.put(r1, r3);
        goto L4
    L14:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L10:
        r4 = false;
        goto L11
    L16:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L17:
        return r5;
    }

    private final JSONObject d(JSONObject r11) {
        JSONObject r10 = new JSONObject();
        Iterator<String> r0 = r11.keys();
        Intrinsics.checkNotNullExpressionValue(r0, "keys(...)");
    L4:
        if (r0.hasNext() == false) goto L27;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin");
        if (f.contains(r1) == false) goto L26;
        boolean r4 = true;
        if (Intrinsics.areEqual(r1, "log_id") == true) goto L9;
        long r6 = r11.getLong(r1);
        if (r6 >= 0) goto L21;
        r4 = false;
    L21:
        if (r4 == false) goto L24;
        r10.put(r1, r6);
        goto L4
    L24:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L9:
        String r2 = r11.getString(r1);
        if (r2.length() <= 200) goto L13;
        r4 = false;
    L13:
        if (r4 == false) goto L16;
        r10.put(r1, r2);
        goto L4
    L16:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L26:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L27:
        return r10;
    }

    public final long a(String r5, long r6) {
        Intrinsics.checkNotNullParameter(r5, "raw");
        JSONArray r4 = new JSONArray(r5);
        int r7 = r4.length();
    L3:
        r7 = r7 - 1;
        if ((-1) >= r7) goto L13;
        JSONObject r0 = r4.optJSONObject(r7);
        if (r0 == null) goto L3;
        long r1 = r0.optLong("end_at_ms", -1);
        if (r1 < 0) goto L3;
        return Math.min(r1, r6);
    L13:
        return r6;
    }

    public final String a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "raw");
        JSONArray r0 = new JSONArray(r5);
        JSONArray r6 = new JSONArray();
        int r1 = r0.length();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        JSONObject r3 = r0.getJSONObject(r2);
        Intrinsics.checkNotNull(r3);
        r6.put(a(r3));
        r2 = r2 + 1;
        goto L3
    L5:
        String r4 = r6.toString();
        Intrinsics.checkNotNullExpressionValue(r4, "toString(...)");
        return r4;
    }

    public final String a(String r6, a r7) {
        Intrinsics.checkNotNullParameter(r6, "raw");
        Intrinsics.checkNotNullParameter(r7, "decision");
        boolean r0 = Intrinsics.areEqual(r7.c(), "L1_FAILED");
        if (r0 == false) goto L5;
    L8:
        JSONArray r5 = new JSONArray(r6);
        if (r0 == false) goto L11;
        Set r8 = SetsKt.setOf(RawObservationEntity.STATE_FAILED);
    L12:
        int r9 = r5.length() - 1;
    L14:
        if ((-1) >= r9) goto L25;
        JSONObject r1 = r5.optJSONObject(r9);
        if (r1 == null) goto L24;
        if (Intrinsics.areEqual(r1.optString("stage"), "L1_BUILD") == false) goto L24;
        if (r8.contains(r1.optString("result")) == false) goto L24;
        String r10 = r1.optString("log_id");
        Intrinsics.checkNotNullExpressionValue(r10, "optString(...)");
        return r10;
    L24:
        r9 = r9 - 1;
        goto L14
    L25:
        return "";
    L11:
        r8 = SetsKt.setOf(new String[]{"SUCCESS", "SKIPPED"});
        goto L12
    L5:
        if (CollectionsKt.listOf(new Integer[]{0, 1}).contains(Integer.valueOf(r7.a())) == true) goto L8;
        return c(r6);
    }

    public final String a(String r18, String r19) {
        Intrinsics.checkNotNullParameter(r18, "rawError");
        Intrinsics.checkNotNullParameter(r19, "rawTrace");
        JSONArray r2 = new JSONArray(r19);
        int r3 = 1;
        int r1 = r2.length() - 1;
    L4:
        if ((-1) >= r1) goto L58;
        JSONObject r11 = r2.optJSONObject(r1);
        if (r11 == null) goto L56;
        if (r11.optInt(BaseSwitches.V, r3) != 2) goto L56;
        if (Intrinsics.areEqual(r11.optString("result"), RawObservationEntity.STATE_FAILED) == false) goto L56;
        String r14 = r11.optString("stage");
        if (r14 == null) goto L56;
        switch(r14.hashCode()) {
            case -1831516457: goto L52;
            case -1765050254: goto L48;
            case -1664034060: goto L44;
            case -757274546: goto L41;
            case -338019831: goto L22;
            case 1456113029: goto L19;
            default: goto L56;
        };
    L19:
        if (r14.equals("IMAGE_UPLOAD") == false) goto L56;
        return "UPLOAD_FAILED";
    L22:
        if (r14.equals("ASR_QUERY") == false) goto L56;
        JSONObject r0 = r11.optJSONObject("details");
        if (r0 == null) goto L27;
        String r4 = r0.optString("remote_state");
    L28:
        String r5 = r11.optString("error_code");
        if (Intrinsics.areEqual(r4, RawObservationEntity.STATE_FAILED) == true) goto L105;
        Intrinsics.checkNotNull(r5);
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("PROTOCOL", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == true) goto L106;
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("RESULT", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == true) goto L106;
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("SOURCE", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == true) goto L106;
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("ACCOUNT", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == false) goto L105;
    L106:
        return "ASR_PROTOCOL_INVALID";
    L105:
        return "ASR_REMOTE_FAILED";
    L27:
        r4 = null;
        goto L28
    L41:
        if (r14.equals("SPEAKER_MAPPING") == false) goto L56;
        return "SPEAKER_MAPPING_FAILED";
    L44:
        if (r14.equals("L1_BUILD") == false) goto L56;
        return "L1_FAILED";
    L48:
        if (r14.equals("L0_COMMIT") == false) goto L56;
        return "L0_COMMIT_FAILED";
    L52:
        if (r14.equals("ASR_SUBMIT") == false) goto L56;
        return "ASR_SUBMIT_FAILED";
    L56:
        r1 = r1 - 1;
        r3 = 1;
        goto L4
    L58:
        if (StringsKt.contains((CharSequence) ZeusTransformUtils.preCheckCast(r18, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("UPLOAD", CharSequence.class, "com.obric.memorydata.plugin"), true) == false) goto L61;
        return "UPLOAD_FAILED";
    L61:
        if (StringsKt.contains((CharSequence) ZeusTransformUtils.preCheckCast(r18, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("SUBMIT", CharSequence.class, "com.obric.memorydata.plugin"), true) == false) goto L64;
        return "ASR_SUBMIT_FAILED";
    L64:
        if (StringsKt.contains((CharSequence) ZeusTransformUtils.preCheckCast(r18, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("REMOTE", CharSequence.class, "com.obric.memorydata.plugin"), true) == false) goto L67;
        return "ASR_REMOTE_FAILED";
    L67:
        if (StringsKt.contains((CharSequence) ZeusTransformUtils.preCheckCast(r18, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("QUERY_RESULT", CharSequence.class, "com.obric.memorydata.plugin"), true) == true) goto L85;
        if (StringsKt.contains((CharSequence) ZeusTransformUtils.preCheckCast(r18, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("PROTOCOL", CharSequence.class, "com.obric.memorydata.plugin"), true) == true) goto L85;
        if (StringsKt.contains((CharSequence) ZeusTransformUtils.preCheckCast(r18, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("L0", CharSequence.class, "com.obric.memorydata.plugin"), true) == true) goto L115;
        if (StringsKt.contains((CharSequence) ZeusTransformUtils.preCheckCast(r18, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("COMMIT", CharSequence.class, "com.obric.memorydata.plugin"), true) == true) goto L115;
        if (StringsKt.contains((CharSequence) ZeusTransformUtils.preCheckCast(r18, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("SPEAKER", CharSequence.class, "com.obric.memorydata.plugin"), true) == false) goto L80;
        return "SPEAKER_MAPPING_FAILED";
    L80:
        if (StringsKt.contains((CharSequence) ZeusTransformUtils.preCheckCast(r18, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("L1", CharSequence.class, "com.obric.memorydata.plugin"), true) == true) goto L113;
        return "UNKNOWN_TERMINAL";
    L113:
        return "L1_FAILED";
    L115:
        return "L0_COMMIT_FAILED";
    L85:
        return "ASR_PROTOCOL_INVALID";
    }

    public final String a(String r2, JSONObject r3) {
        Intrinsics.checkNotNullParameter(r2, "raw");
        Intrinsics.checkNotNullParameter(r3, "event");
        String r1 = new JSONArray(a(r2)).put(a(r3)).toString();
        Intrinsics.checkNotNullExpressionValue(r1, "toString(...)");
        return r1;
    }

    public final JSONObject a(a r4, long r5, long r7, String r9) {
        Intrinsics.checkNotNullParameter(r4, "decision");
        Intrinsics.checkNotNullParameter(r9, "logId");
        JSONObject r3 = new JSONObject().put(BaseSwitches.V, 2).put("stage", "PIPELINE_TERMINAL").put("result", r4.b()).put("start_at_ms", r5).put("end_at_ms", r7).put("cost_ms", r7 - r5);
        if (r7 < r5) goto L5;
        boolean r6 = true;
    L6:
        JSONObject r8 = r3.put("time_valid", r6).put("attempt", 1).put("log_id", r9).put("error_code", r4.c()).put("details", new JSONObject().put("raw_count", r4.d()).put("l1_output_count", r4.e()));
        Intrinsics.checkNotNullExpressionValue(r8, "put(...)");
        return r8;
    L5:
        r6 = false;
        goto L6
    }

    public final JSONObject a(AuditoryAsrTaskEntity r8, a r9, String r10) {
        Intrinsics.checkNotNullParameter(r8, "task");
        Intrinsics.checkNotNullParameter(r9, "decision");
        Intrinsics.checkNotNullParameter(r10, "traceRaw");
        JSONArray r0 = new JSONArray(r10);
        JSONObject r11 = b(r0, "PIPELINE_TERMINAL");
        if (r11 == null) goto L11;
        long[] r1 = a(r8, r0, r9, r11.getLong("end_at_ms"));
        JSONObject r12 = new JSONObject().put("task_id", r8.getTaskId()).put("result_code", r9.a()).put("error_code", r9.c()).put("retry_count", b(r0)).put("log_id", r11.optString("log_id"));
        if (r1 == null) goto L7;
        int r13 = 1;
    L8:
        JSONObject r14 = r12.put("time_valid", r13).put("audio_start_at_ms", r8.getAudioStartMs()).put("audio_end_at_ms", r8.getAudioEndMs()).put("cost_audio_physical_span_ms", a(r8.getAudioStartMs(), r8.getAudioEndMs())).put("merged_audio_duration_ms", e(r8.getManifest()));
        Intrinsics.checkNotNull(r14);
        a(r14, r1);
        a(r14, r8, r0);
        return r14;
    L7:
        r13 = 0;
        goto L8
    L11:
        throw new IllegalStateException("PIPELINE_TERMINAL_MISSING".toString());
    }

    public final boolean b(String r5) {
        Intrinsics.checkNotNullParameter(r5, "raw");
        JSONArray r4 = new JSONArray(r5);
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(RangesKt.until(0, r4.length()), Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, Collection.class) == true) goto L5;
    L7:
        Iterator r7 = r6.iterator();
    L9:
        if (r7.hasNext() == false) goto L22;
        JSONObject r1 = r4.optJSONObject(((IntIterator) ZeusTransformUtils.preCheckCast(r7, IntIterator.class, "com.obric.memorydata.plugin")).nextInt());
        if (r1 == null) goto L13;
        String r2 = r1.optString("stage");
    L15:
        if (Intrinsics.areEqual(r2, "PIPELINE_TERMINAL") == false) goto L9;
        return true;
    L13:
        r2 = null;
        goto L15
    L22:
        return false;
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L7;
        return false;
    }

    public final String c(String r4) {
        Intrinsics.checkNotNullParameter(r4, "raw");
        JSONArray r3 = new JSONArray(r4);
        int r5 = r3.length();
    L3:
        r5 = r5 - 1;
        String r0 = "";
        if ((-1) >= r5) goto L16;
        JSONObject r1 = r3.optJSONObject(r5);
        if (r1 == null) goto L8;
        String r2 = r1.optString("log_id");
    L9:
        if (r2 == null) goto L13;
        r0 = r2;
    L13:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L3;
        return r0;
    L8:
        r2 = null;
        goto L9
    L16:
        return "";
    }

    public final int d(String r7) {
        Intrinsics.checkNotNullParameter(r7, "raw");
        JSONArray r6 = new JSONArray(r7);
        int r8 = r6.length();
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r1 >= r8) goto L18;
        JSONObject r3 = r6.optJSONObject(r1);
        if (r3 == null) goto L17;
        if (Intrinsics.areEqual(r3.optString("stage"), "L1_BUILD") == false) goto L17;
        if (Intrinsics.areEqual(r3.optString("result"), "SUCCESS") == false) goto L17;
        JSONObject r4 = r3.optJSONObject("details");
        if (r4 == null) goto L15;
        int r5 = r4.optInt("l1_output_count", 0);
    L16:
        r2 = r2 + r5;
        goto L17
    L15:
        r5 = 0;
    L17:
        r1 = r1 + 1;
        goto L3
    L18:
        return r2;
    }

    public final long e(String r8) {
        Intrinsics.checkNotNullParameter(r8, "manifestRaw");
        JSONArray r7 = new JSONObject(r8).optJSONArray("segments");     // Catch: JSONException -> L16
        if (r7 != null) goto L6;
        return -1;
    L6:
        int r9 = 0;
        int r2 = r7.length();     // Catch: JSONException -> L16
        long r3 = -1;
    L7:
        if (r9 >= r2) goto L15;
        JSONObject r5 = r7.optJSONObject(r9);     // Catch: JSONException -> L16
        if (r5 == null) goto L11;
        long r6 = r5.optLong("audio_end_ms", -1);     // Catch: JSONException -> L16
    L12:
        r3 = Math.max(r3, r6);     // Catch: JSONException -> L16
        r9 = r9 + 1;
        goto L7
    L11:
        r6 = -1;
        goto L12
    L15:
        return r3;
    L20:
        return -1;
    }
}
