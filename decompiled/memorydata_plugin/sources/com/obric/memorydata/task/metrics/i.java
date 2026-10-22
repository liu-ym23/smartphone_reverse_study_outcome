package com.obric.memorydata.task.metrics;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0005J\f\u0010\u0017\u001a\u00020\u0018*\u00020\u0019H\u0002J\f\u0010\u001a\u001a\u00020\u0019*\u00020\u0018H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/obric/memorydata/task/metrics/IndexPowerMetricsStateJsonCodec;", "", "<init>", "()V", "BUCKETS", "", "WINDOW_START_UTC_MS", "LAST_ATTEMPTED_WINDOW_START_UTC_MS", "PENDING_WINDOW_START_UTC_MS", "PENDING_REPORTED_TASK_TYPES", "COMMON_KNOWN", "COMMON_SATISFIED", "STRICTLY_KNOWN", "STRICTLY_SATISFIED", "FAST_WAITING_KNOWN", "FAST_WAITING_UNSATISFIED", "SLOW_WAITING_KNOWN", "SLOW_WAITING_UNSATISFIED", "encode", "state", "Lcom/obric/memorydata/task/metrics/IndexPowerMetricsState;", "decode", "encoded", "toJson", "Lorg/json/JSONObject;", "Lcom/obric/memorydata/task/metrics/IndexPowerMetricsTotals;", "toTotals", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f12947a = null;

    static {
        f12947a = new i();
    }

    private i() {
    }

    private final k a(JSONObject r22) {
        return new k(r22.optLong("commonKnownDurationMs", 0), r22.optLong("commonSatisfiedDurationMs", 0), r22.optLong("strictlyKnownDurationMs", 0), r22.optLong("strictlySatisfiedDurationMs", 0), r22.optLong("fastTaskWaitingKnownDurationMs", 0), r22.optLong("fastTaskWaitingUnsatisfiedDurationMs", 0), r22.optLong("slowTaskWaitingKnownDurationMs", 0), r22.optLong("slowTaskWaitingUnsatisfiedDurationMs", 0));
    }

    private final JSONObject a(k r4) {
        JSONObject r3 = new JSONObject();
        r3.put("commonKnownDurationMs", r4.a());
        r3.put("commonSatisfiedDurationMs", r4.b());
        r3.put("strictlyKnownDurationMs", r4.c());
        r3.put("strictlySatisfiedDurationMs", r4.d());
        r3.put("fastTaskWaitingKnownDurationMs", r4.e());
        r3.put("fastTaskWaitingUnsatisfiedDurationMs", r4.f());
        r3.put("slowTaskWaitingKnownDurationMs", r4.g());
        r3.put("slowTaskWaitingUnsatisfiedDurationMs", r4.h());
        return r3;
    }

    public final h a(String r12) {
        Intrinsics.checkNotNullParameter(r12, "encoded");
        JSONObject r11 = new JSONObject(r12);
        JSONArray r13 = r11.optJSONArray("buckets");
        if (r13 != null) goto L5;
        r13 = new JSONArray();
    L5:
        Map r0 = MapsKt.createMapBuilder();
        int r1 = r13.length();
        int r2 = 0;
        int r3 = 0;
    L6:
        if (r3 >= r1) goto L8;
        JSONObject r4 = r13.getJSONObject(r3);
        Long r5 = Long.valueOf(r4.getLong("windowStartUtcMs"));
        i r6 = f12947a;
        Intrinsics.checkNotNull(r4);
        r0.put(r5, r6.a(r4));
        r3 = r3 + 1;
        goto L6
    L8:
        Map r14 = MapsKt.build(r0);
        if (r11.isNull("lastAttemptedWindowStartUtcMs") == false) goto L11;
        Long r7 = null;
    L13:
        if (r11.isNull("pendingWindowStartUtcMs") == false) goto L15;
        Long r8 = null;
    L16:
        Set r9 = SetsKt.createSetBuilder();
        JSONArray r15 = r11.optJSONArray("pendingReportedTaskTypes");
        if (r15 != null) goto L19;
        r15 = new JSONArray();
    L19:
        int r10 = r15.length();
    L20:
        if (r2 >= r10) goto L32;
        Iterator r16 = ((Iterable) ZeusTransformUtils.preCheckCast(IndexPowerTaskType.getEntries(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L23:
        if (r16.hasNext() == false) goto L27;
        Object r17 = r16.next();
        if (Intrinsics.areEqual(((IndexPowerTaskType) ZeusTransformUtils.preCheckCast(r17, IndexPowerTaskType.class, "com.obric.memorydata.plugin")).name(), r15.optString(r2)) == false) goto L23;
    L28:
        IndexPowerTaskType r18 = (IndexPowerTaskType) ZeusTransformUtils.preCheckCast(r17, IndexPowerTaskType.class, "com.obric.memorydata.plugin");
        if (r18 == null) goto L31;
        r9.add(r18);
    L31:
        r2 = r2 + 1;
        goto L20
    L27:
        r17 = null;
        goto L28
    L32:
        Unit r19 = Unit.INSTANCE;
        return new h(r14, r7, r8, SetsKt.build(r9));
    L15:
        r8 = Long.valueOf(r11.getLong("pendingWindowStartUtcMs"));
        goto L16
    L11:
        r7 = Long.valueOf(r11.getLong("lastAttemptedWindowStartUtcMs"));
        goto L13
    }

    public final String a(h r7) {
        Intrinsics.checkNotNullParameter(r7, "state");
        JSONObject r6 = new JSONObject();
        r6.put("lastAttemptedWindowStartUtcMs", r7.b());
        r6.put("pendingWindowStartUtcMs", r7.c());
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(r7.d(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r1.add(((IndexPowerTaskType) ZeusTransformUtils.preCheckCast(r2.next(), IndexPowerTaskType.class, "com.obric.memorydata.plugin")).name());
        goto L4
    L6:
        r6.put("pendingReportedTaskTypes", new JSONArray((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin")));
        JSONArray r3 = new JSONArray();
        Iterator r8 = ((Map) ZeusTransformUtils.preCheckCast(MapsKt.toSortedMap(r7.a()), Map.class, "com.obric.memorydata.plugin")).entrySet().iterator();
    L8:
        if (r8.hasNext() == false) goto L10;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        Long r5 = (Long) ZeusTransformUtils.preCheckCast(r4.getKey(), Long.class, "com.obric.memorydata.plugin");
        k r9 = (k) ZeusTransformUtils.preCheckCast(r4.getValue(), k.class, "com.obric.memorydata.plugin");
        i r10 = f12947a;
        Intrinsics.checkNotNull(r9);
        JSONObject r11 = r10.a(r9);
        Intrinsics.checkNotNull(r5);
        r11.put("windowStartUtcMs", r5.longValue());
        r3.put(r11);
        goto L8
    L10:
        Unit r12 = Unit.INSTANCE;
        r6.put("buckets", r3);
        String r13 = r6.toString();
        Intrinsics.checkNotNullExpressionValue(r13, "toString(...)");
        return r13;
    }
}
