package com.obric.memorydata.database.index;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.obric.memorydata.middleware.api.bdtracker.Tracker;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ\u0018\u0010\u001e\u001a\u00020\u001b2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"J\u001e\u0010#\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020&2\u0006\u0010!\u001a\u00020\"J\u0016\u0010'\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)J\u0014\u0010+\u001a\b\u0012\u0004\u0012\u00020)0\u00182\u0006\u0010*\u001a\u00020)J\u0014\u0010,\u001a\u00020)*\u00020-2\u0006\u0010!\u001a\u00020\"H\u0002J\u001c\u0010.\u001a\u00020\u001b*\u00020)2\u0006\u0010/\u001a\u00020\u00052\u0006\u00100\u001a\u000201H\u0002J\u001c\u00102\u001a\u00020\u001b*\u00020)2\u0006\u0010/\u001a\u00020\u00052\u0006\u00103\u001a\u00020)H\u0002J\u0014\u00104\u001a\u00020\u001b*\u00020)2\u0006\u0010/\u001a\u00020\u0005H\u0002J\u0014\u00105\u001a\u00020)*\u00020)2\u0006\u00106\u001a\u00020\u0005H\u0002J!\u00107\u001a\u00020\u001b*\u00020)2\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u001b09H\u0082\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u0018X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/obric/memorydata/database/index/IndexDashboardLatencyEventReporter;", "", "<init>", "()V", "EVENT_NAME", "", "SCHEMA_VERSION", "", "TAG", "BUILD_TYPE_MULTI", "BUILD_TYPE_DETAILS", "ENTITY_ROUND_COUNT", "BUILD_TYPE_TASK_COUNT", "SAMPLE_TYPE", "SAMPLE_TYPE_ENTITY_ROUND", "SAMPLE_TYPE_BUILD_TYPE_DETAIL", "SAMPLE_TYPE_BUILD_TYPE_ONLY", "SAMPLE_TYPE_ENTITY_ROUND_WITH_BUILD_TYPE", "ENTITY_ROUND_STATE", "ENTITY_ROUND_STATE_OBSERVED", "ENTITY_ROUND_STATE_NOT_OBSERVED", "ENTITY_ROUND_MISSING_REASON", "MISSING_REASON_FIRST_COMPLETION_NOT_CLOSED", "durationPrefixes", "", "diagnosticOutcomeFields", "registerRejectedEventHandler", "", "handler", "Lcom/obric/memorydata/middleware/api/bdtracker/ReportEventRejectedHandler;", "report", "samples", "Lcom/obric/memorydata/database/index/IndexDashboardLatencyTracker$SettledSamples;", "outcome", "Lcom/obric/memorydata/database/index/IndexExecutionOutcome;", "reportCoverageOnlyFirstCompletion", "entityType", "waitDurationMs", "", "mergeRejected", "eventParams", "Lorg/json/JSONObject;", "mergeJson", "materialize", "toPayload", "Lcom/obric/memorydata/database/index/IndexDashboardLatencyTracker$Snapshot;", "putDuration", "prefix", "stats", "Lcom/obric/memorydata/database/index/DurationStats;", "addDuration", AILabCheckPermissionTask.KEY_SOURCE, "putDurationAverage", "objectAt", "key", "forEachObject", "block", "Lkotlin/Function1;", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ah {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ah f9339a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final List<String> f9340b = null;
    private static final List<String> c = null;

    static {
        f9339a = new ah();
        f9340b = CollectionsKt.listOf(new String[]{"userWaitDuration", "entityExecutionDuration", "buildTypeDuration", "modelDuration"});
        c = CollectionsKt.listOf(new String[]{"terminalSuccessCount", "terminalFailureCount", "nonTerminalRetryCount", "nonTerminalThermalDeferredCount", "nonTerminalLocationDeferredCount"});
    }

    private ah() {
    }

    private final JSONObject a(ai.j r7, IndexExecutionOutcome r8) {
        JSONObject r6 = new JSONObject();
        r6.put("schemaVersion", 2);
        if (Intrinsics.areEqual(r7.c(), "NOT_APPLICABLE") == false) goto L5;
        String r0 = "OVERALL";
    L6:
        r6.put(TypedValues.Custom.S_DIMENSION, r0);
        r6.put("entityType", r7.a());
        r6.put(ObricMemoryConstants.KEY_PACKAGE_NAME, r7.b());
        r6.put("buildType", r7.c());
        r6.put("runMode", r7.d());
        r6.put(CommonConsts.COUNT_TYPE, r7.e());
        boolean r1 = !Intrinsics.areEqual(r7.c(), "NOT_APPLICABLE");
        if (r1 == false) goto L9;
        String r2 = "BUILD_TYPE_DETAIL";
    L10:
        r6.put("sampleType", r2);
        if (r1 == false) goto L13;
        String r3 = "NOT_OBSERVED";
    L14:
        r6.put("entityRoundState", r3);
        if (r1 == false) goto L17;
        r6.put("entityRoundMissingReason", "FIRST_COMPLETION_NOT_CLOSED");
    L17:
        ah r4 = f9339a;
        r4.a(r6, "userWaitDuration", r7.f());
        r4.a(r6, "entityExecutionDuration", r7.g());
        r4.a(r6, "buildTypeDuration", r7.h());
        r4.a(r6, "modelDuration", r7.i());
        long r5 = 0;
        if (r1 == true) goto L20;
    L22:
        long r9 = 0;
    L23:
        r6.put("terminalSuccessCount", r9);
        if (r1 == true) goto L26;
    L28:
        long r10 = 0;
    L29:
        r6.put("terminalFailureCount", r10);
        if (r1 == true) goto L32;
    L34:
        long r11 = 0;
    L35:
        r6.put("nonTerminalRetryCount", r11);
        if (r1 == true) goto L38;
    L40:
        long r12 = 0;
    L41:
        r6.put("nonTerminalThermalDeferredCount", r12);
        if (r1 == true) goto L44;
    L46:
        r6.put("nonTerminalLocationDeferredCount", r5);
        return r6;
    L44:
        if (r8 != IndexExecutionOutcome.LOCATION_DEFERRED) goto L46;
        r5 = r7.e();
        goto L46
    L38:
        if (r8 != IndexExecutionOutcome.THERMAL_DEFERRED) goto L40;
        r12 = r7.e();
        goto L41
    L32:
        if (r8 != IndexExecutionOutcome.NON_TERMINAL_RETRY) goto L34;
        r11 = r7.e();
        goto L35
    L26:
        if (r8 != IndexExecutionOutcome.TERMINAL_FAILURE) goto L28;
        r10 = r7.e();
        goto L29
    L20:
        if (r8 != IndexExecutionOutcome.TERMINAL_SUCCESS) goto L22;
        r9 = r7.e();
        goto L23
    L13:
        r3 = "OBSERVED";
        goto L14
    L9:
        r2 = "ENTITY_ROUND";
        goto L10
    L5:
        r0 = "BUILD_TYPE";
        goto L6
    }

    private final void a(JSONObject r7, String r8) {
        long r0 = 0;
        long r2 = r7.optLong(r8 + "SumMs", 0);
        long r4 = r7.optLong(r8 + "Count", 0);
        String r6 = r8 + "AverageMs";
        if (r4 == 0) goto L6;
        r0 = r2 / r4;
    L6:
        r7.put(r6, r0);
    }

    private final void a(JSONObject r3, String r4, r r5) {
        r3.put(r4 + "SumMs", r5.a());
        r3.put(r4 + "Count", r5.b());
        r3.put(r4 + "AverageMs", r5.c());
    }

    private final void a(JSONObject r7, String r8, JSONObject r9) {
        r7.put(r8 + "SumMs", r7.optLong(r8 + "SumMs", 0) + r9.optLong(r8 + "SumMs", 0));
        r7.put(r8 + "Count", r7.optLong(r8 + "Count", 0) + r9.optLong(r8 + "Count", 0));
    }

    private final JSONObject b(JSONObject r1, String r2) {
        JSONObject r0 = r1.optJSONObject(r2);
        if (r0 != null) goto L6;
        JSONObject r3 = new JSONObject();
        r1.put(r2, r3);
        return r3;
    L6:
        return r0;
    }

    public final List<JSONObject> a(JSONObject r29) {
        JSONObject r0 = r29;
        Intrinsics.checkNotNullParameter(r0, "mergeJson");
        List<JSONObject> r1 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator<String> r2 = r29.keys();
    L4:
        if (r2.hasNext() == false) goto L68;
        JSONObject r4 = r0.optJSONObject((String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.memorydata.plugin"));
        if (r4 == null) goto L67;
        Iterator<String> r5 = r4.keys();
    L9:
        if (r5.hasNext() == false) goto L67;
        JSONObject r6 = r4.optJSONObject((String) ZeusTransformUtils.preCheckCast(r5.next(), String.class, "com.obric.memorydata.plugin"));
        if (r6 == null) goto L9;
        Iterator<String> r7 = r6.keys();
    L14:
        if (r7.hasNext() == false) goto L9;
        JSONObject r8 = r6.optJSONObject((String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.memorydata.plugin"));
        if (r8 == null) goto L14;
        if (r8.optInt("schemaVersion", 0) != 2) goto L63;
        String r9 = "entityRoundCount";
        long r12 = r8.optLong("entityRoundCount", 0);
        long r15 = r8.optLong("buildTypeTaskCount", 0);
        if (r12 <= 0) goto L22;
    L23:
        if (r12 > 0) goto L25;
    L27:
        if (r12 <= 0) goto L29;
        String r18 = "ENTITY_ROUND";
    L30:
        String r11 = "sampleType";
        r8.put("sampleType", r18);
        String r10 = "NOT_OBSERVED";
        if (r12 <= 0) goto L33;
        Object r3 = "OBSERVED";
    L34:
        r8.put("entityRoundState", r3);
        String r13 = "entityRoundMissingReason";
        JSONObject r19 = r4;
        if (r12 > 0) goto L37;
        r8.put("entityRoundMissingReason", "FIRST_COMPLETION_NOT_CLOSED");
    L38:
        Iterator<String> r110 = r5;
        Iterator r14 = ((Iterable) ZeusTransformUtils.preCheckCast(f9340b, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L40:
        if (r14.hasNext() == false) goto L42;
        Iterator r20 = r14;
        f9339a.a(r8, (String) ZeusTransformUtils.preCheckCast(r14.next(), String.class, "com.obric.memorydata.plugin"));
        r14 = r20;
        goto L40
    L42:
        JSONObject r16 = new JSONObject(r8.toString());
        if (r12 > 0) goto L46;
        r12 = r15;
    L46:
        String r17 = CommonConsts.COUNT_TYPE;
        r16.put(CommonConsts.COUNT_TYPE, r12);
        r16.remove("__buildTypeDetails");
        r16.put(TypedValues.Custom.S_DIMENSION, "OVERALL");
        ((Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.memorydata.plugin")).add(r16);
        JSONObject r21 = r8.optJSONObject("__buildTypeDetails");
        if (r21 == null) goto L64;
        Iterator<String> r111 = r21.keys();
    L50:
        if (r111.hasNext() == false) goto L64;
        r6 = r6;
        JSONObject r22 = r21.optJSONObject((String) ZeusTransformUtils.preCheckCast(r111.next(), String.class, "com.obric.memorydata.plugin"));
        if (r22 == null) goto L50;
        Collection r112 = (Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.memorydata.plugin");
        Iterator<String> r113 = r7;
        JSONObject r23 = r21;
        JSONObject r24 = new JSONObject(r16.toString());
        r24.put(TypedValues.Custom.S_DIMENSION, "BUILD_TYPE");
        JSONObject r25 = r16;
        r24.put("buildType", r22.getString("buildType"));
        r24.put(r11, "BUILD_TYPE_DETAIL");
        r24.put("entityRoundState", r10);
        r24.remove(r13);
        String r26 = r10;
        String r27 = r11;
        r24.put(r9, 0);
        String r28 = r9;
        r24.put("buildTypeTaskCount", r22.optLong(r17, 0));
        r24.put(r17, r22.optLong(r17, 0));
        Iterator r30 = ((Iterable) ZeusTransformUtils.preCheckCast(f9340b, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L55:
        if (r30.hasNext() == false) goto L57;
        String r31 = (String) ZeusTransformUtils.preCheckCast(r30.next(), String.class, "com.obric.memorydata.plugin");
        r24.put(r31 + "SumMs", r22.optLong(r31 + "SumMs", 0));
        r24.put(r31 + "Count", r22.optLong(r31 + "Count", 0));
        f9339a.a(r24, r31);
        r13 = r13;
        r27 = r27;
        r111 = r111;
        r17 = r17;
        goto L55
    L57:
        String r210 = r13;
        String r211 = r27;
        String r212 = r17;
        Iterator<String> r213 = r111;
        Iterator r32 = ((Iterable) ZeusTransformUtils.preCheckCast(c, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L59:
        if (r32.hasNext() == false) goto L61;
        String r33 = (String) ZeusTransformUtils.preCheckCast(r32.next(), String.class, "com.obric.memorydata.plugin");
        r24.put(r33, r22.optLong(r33, 0));
        goto L59
    L61:
        r112.add(r24);
        r7 = r113;
        r21 = r23;
        r16 = r25;
        r9 = r28;
        r10 = r26;
        r13 = r210;
        r11 = r211;
        r111 = r213;
        r17 = r212;
    L64:
        r2 = r2;
        r6 = r6;
        r7 = r7;
        r4 = r19;
        r5 = r110;
        goto L14
    L37:
        r8.remove("entityRoundMissingReason");
        goto L38
    L33:
        r3 = "NOT_OBSERVED";
        goto L34
    L29:
        r18 = "BUILD_TYPE_ONLY";
        goto L30
    L25:
        if (r15 <= 0) goto L27;
        r18 = "ENTITY_ROUND_WITH_BUILD_TYPE";
        goto L30
    L22:
        if (r15 > 0) goto L23;
    L63:
        r2 = r2;
        r19 = r4;
        r110 = r5;
    L67:
        r0 = r29;
        goto L4
    L68:
        return r1;
    }

    public final void a(int r17, long r18, IndexExecutionOutcome r20) {
        Intrinsics.checkNotNullParameter(r20, "outcome");
        q r1 = q.f9432a.a(r18);
        if (r1 == null) goto L6;
        long r2 = r1.a();
        a(new ai.i(null, new ai.j(r17, "UNKNOWN", "NOT_APPLICABLE", "NOT_APPLICABLE", 1, r.f9434a.a(r2), r.f9434a.a(), r.f9434a.a(), r.f9434a.a())), r20);
        return;
    }

    public final void a(ai.i r5, IndexExecutionOutcome r6) {
        Intrinsics.checkNotNullParameter(r6, "outcome");
        if (r5 == null) goto L5;
        List<ai.j> r4 = r5.c();
    L6:
        if (r4 != null) goto L8;
        r4 = CollectionsKt.emptyList();
    L8:
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L10:
        if (r7.hasNext() == false) goto L16;
        ai.j r8 = (ai.j) ZeusTransformUtils.preCheckCast(r7.next(), ai.j.class, "com.obric.memorydata.plugin");
        Tracker.INSTANCE.reportEvent("entity_index_dashboard_latency", f9339a.a(r8, r6));     // Catch: RuntimeException -> L14
    L14:
        e = move-exception;
        RunLog.INSTANCE.error("IndexDashboardLatencyEventReporter", "report dashboard latency failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        goto L10
    L16:
        return;
    L5:
        r4 = null;
        goto L6
    }

    public final void a(com.obric.memorydata.middleware.api.bdtracker.b r2) {
        com.obric.memorydata.middleware.api.bdtracker.b r1 = (com.obric.memorydata.middleware.api.bdtracker.b) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.memorydata.middleware.api.bdtracker.b.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "handler");
        Tracker.INSTANCE.registerReportEventRejectedHandler("entity_index_dashboard_latency", r1);
    }

    public final void a(JSONObject r22, JSONObject r23) {
        Intrinsics.checkNotNullParameter(r22, "eventParams");
        Intrinsics.checkNotNullParameter(r23, "mergeJson");
        if (r22.optInt("schemaVersion", 0) == 2) goto L5;
        return;
    L5:
        long r9 = r22.optLong(CommonConsts.COUNT_TYPE, 0);
        if (r9 > 0) goto L8;
        return;
    L8:
        String r12 = String.valueOf(r22.optInt("entityType", 0));
        String r14 = r22.optString(ObricMemoryConstants.KEY_PACKAGE_NAME, "");
        String r8 = r22.optString("buildType", "UNKNOWN");
        String r7 = r22.optString("runMode", "UNKNOWN");
        JSONObject r2 = b(r23, r12);
        Intrinsics.checkNotNull(r14);
        JSONObject r3 = b(r2, r14);
        Intrinsics.checkNotNull(r7);
        JSONObject r4 = b(r3, r7);
        if (r4.length() != 0) goto L18;
        r4.put("schemaVersion", 2);
        boolean r5 = false;
        r4.put("entityType", r22.optInt("entityType", 0));
        r4.put(ObricMemoryConstants.KEY_PACKAGE_NAME, r14);
        r4.put("buildType", "MULTI");
        r4.put("runMode", r7);
        r4.put("entityRoundCount", 0);
        r4.put("buildTypeTaskCount", 0);
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(f9340b, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L12:
        if (r6.hasNext() == false) goto L14;
        String r10 = (String) ZeusTransformUtils.preCheckCast(r6.next(), String.class, "com.obric.memorydata.plugin");
        r4.put(r10 + "SumMs", 0);
        r4.put(r10 + "Count", 0);
        goto L12
    L14:
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(c, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L16:
        if (r11.hasNext() == false) goto L20;
        r4.put((String) ZeusTransformUtils.preCheckCast(r11.next(), String.class, "com.obric.memorydata.plugin"), 0);
    L20:
        if (Intrinsics.areEqual(r8, "NOT_APPLICABLE") == false) goto L37;
        r4.put("sampleType", "ENTITY_ROUND");
        r4.put("entityRoundState", "OBSERVED");
        r4.remove("entityRoundMissingReason");
        r4.put("entityRoundCount", r4.optLong("entityRoundCount", 0) + r9);
        Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(f9340b, Iterable.class, "com.obric.memorydata.plugin");
        Collection r15 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r16 = r13.iterator();
    L23:
        if (r16.hasNext() == false) goto L33;
        Object r17 = r16.next();
        String r18 = (String) ZeusTransformUtils.preCheckCast(r17, String.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r18, "buildTypeDuration") == false) goto L27;
    L30:
        boolean r19 = true;
    L31:
        if (r19 == true) goto L23;
        r15.add(r17);
        goto L23
    L27:
        if (Intrinsics.areEqual(r18, "modelDuration") == true) goto L30;
        r19 = r5;
        goto L31
    L33:
        Iterator r20 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r15, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L35:
        if (r20.hasNext() == false) goto L45;
        f9339a.a(r4, (String) ZeusTransformUtils.preCheckCast(r20.next(), String.class, "com.obric.memorydata.plugin"), r22);
        goto L35
    L45:
        return;
    L37:
        r4.put("buildTypeTaskCount", r4.optLong("buildTypeTaskCount", 0) + r9);
        a(r4, "buildTypeDuration", r22);
        a(r4, "modelDuration", r22);
        Iterator r21 = ((Iterable) ZeusTransformUtils.preCheckCast(c, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L39:
        if (r21.hasNext() == false) goto L41;
        String r24 = (String) ZeusTransformUtils.preCheckCast(r21.next(), String.class, "com.obric.memorydata.plugin");
        r4.put(r24, r4.optLong(r24, 0) + r22.optLong(r24, 0));
        goto L39
    L41:
        JSONObject r25 = b(r4, "__buildTypeDetails");
        Intrinsics.checkNotNull(r8);
        JSONObject r26 = b(r25, r8);
        r26.put("buildType", r8);
        r26.put(CommonConsts.COUNT_TYPE, r26.optLong(CommonConsts.COUNT_TYPE, 0) + r9);
        a(r26, "buildTypeDuration", r22);
        a(r26, "modelDuration", r22);
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(c, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L43:
        if (r0.hasNext() == false) goto L56;
        String r27 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin");
        r26.put(r27, r26.optLong(r27, 0) + r22.optLong(r27, 0));
        goto L43
    L56:
        return;
    L18:
        r5 = false;
        goto L20
    }
}
