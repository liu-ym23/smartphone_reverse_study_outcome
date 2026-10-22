package com.obric.memorydata.database.index;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.crash.entity.EventBody;
import com.obric.aiproactive.impl.livecard.ProactiveLiveCardDisplayTool;
import com.obric.cae.userAware.WifiScanStateMachine;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\tJ\"\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00100\tJ\u0014\u0010\u0011\u001a\u00020\u0012*\u00020\n2\u0006\u0010\u0013\u001a\u00020\fH\u0002J\u0014\u0010\u0014\u001a\u00020\u0012*\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0010H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/database/index/IndexDashboardPeriodicPayloads;", "", "<init>", "()V", "SCHEMA_VERSION", "", "SAMPLE_TYPE", "", "coverage", "", "Lorg/json/JSONObject;", "metrics", "Lcom/obric/memorydata/database/index/CoverageMetric;", "backlog", "snapshotAtMs", "", "Lcom/obric/memorydata/database/index/BacklogMetric;", "putCoverageMetric", "", EventBody.KEY_METRIC, "putBacklogMetric", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class aj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final aj f9360a = null;

    static {
        f9360a = new aj();
    }

    private aj() {
    }

    private final void a(JSONObject r5, b r6) {
        r5.put("backlogEntityCount", r6.d());
        r5.put("ageLt1hCount", ((Number) ZeusTransformUtils.preCheckCast(MapsKt.getValue(r6.e(), BacklogAgeBucket.LT_1H), Number.class, "com.obric.memorydata.plugin")).longValue());
        r5.put("age1To6hCount", ((Number) ZeusTransformUtils.preCheckCast(MapsKt.getValue(r6.e(), BacklogAgeBucket.H1_TO_6H), Number.class, "com.obric.memorydata.plugin")).longValue());
        r5.put("age6To24hCount", ((Number) ZeusTransformUtils.preCheckCast(MapsKt.getValue(r6.e(), BacklogAgeBucket.H6_TO_24H), Number.class, "com.obric.memorydata.plugin")).longValue());
        r5.put("age1To3dCount", ((Number) ZeusTransformUtils.preCheckCast(MapsKt.getValue(r6.e(), BacklogAgeBucket.D1_TO_3D), Number.class, "com.obric.memorydata.plugin")).longValue());
        r5.put("age3To7dCount", ((Number) ZeusTransformUtils.preCheckCast(MapsKt.getValue(r6.e(), BacklogAgeBucket.D3_TO_7D), Number.class, "com.obric.memorydata.plugin")).longValue());
        r5.put("age7To30dCount", ((Number) ZeusTransformUtils.preCheckCast(MapsKt.getValue(r6.e(), BacklogAgeBucket.D7_TO_30D), Number.class, "com.obric.memorydata.plugin")).longValue());
        r5.put("ageGe30dCount", ((Number) ZeusTransformUtils.preCheckCast(MapsKt.getValue(r6.e(), BacklogAgeBucket.GE_30D), Number.class, "com.obric.memorydata.plugin")).longValue());
        r5.put("ageUnknownCount", r6.f());
    }

    private final void a(JSONObject r7, h r8) {
        r7.put("expectedCount", r8.c());
        r7.put("completedCount", r8.d());
        if (r8.c() <= 0) goto L11;
        long r0 = r8.c();
        long r4 = r8.d();
        boolean r2 = false;
        if (0 <= r4) goto L7;
    L9:
        if (r2 == false) goto L11;
        r7.put("coverageRatio", r8.d() / r8.c());
        goto L11
    L7:
        if (r4 > r0) goto L9;
        r2 = true;
    L11:
        r7.put("incompleteCount", r8.e());
        r7.put("unknownCount", r8.f());
        r7.put("unknownPolicyMismatchCount", r8.g());
        r7.put("unknownStateCount", r8.h());
        r7.put("historicalLifecycleMissingCount", r8.i());
        r7.put("backlogEntityCount", r8.j());
    }

    public final List<JSONObject> a(long r17, List<b> r19) {
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r19, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "metrics");
        long r6 = Math.floorDiv(r17, WifiScanStateMachine.WAKE_LOCK_TIMEOUT_1_DATE_MS) * WifiScanStateMachine.WAKE_LOCK_TIMEOUT_1_DATE_MS;
        String r8 = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(r8, "toString(...)");
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin");
        Collection r10 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r11 = r9.iterator();
        int r12 = 0;
    L4:
        if (r11.hasNext() == false) goto L16;
        Object r13 = r11.next();
        int r14 = r12 + 1;
        if (r12 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        b r15 = (b) ZeusTransformUtils.preCheckCast(r13, b.class, "com.obric.memorydata.plugin");
        JSONObject r16 = new JSONObject();
        r16.put("schemaVersion", 2);
        r16.put("sampleType", "AGGREGATED_WINDOW");
        r16.put("windowStartUtcMs", r6);
        Iterator r110 = r11;
        Collection r18 = r10;
        r16.put("windowEndUtcMs", r6 + WifiScanStateMachine.WAKE_LOCK_TIMEOUT_1_DATE_MS);
        r16.put("snapshotAtMs", r17);
        r16.put("snapshotId", r8);
        r16.put("snapshotRowIndex", r12);
        r16.put("snapshotRowCount", r2.size());
        r16.put(TypedValues.Custom.S_DIMENSION, r15.a().name());
        Integer r20 = r15.b();
        if (r20 == null) goto L11;
        r16.put("entityType", ((Number) ZeusTransformUtils.preCheckCast(r20, Number.class, "com.obric.memorydata.plugin")).intValue());
    L11:
        String r21 = r15.c();
        if (r21 == null) goto L14;
        r16.put("buildType", r21);
    L14:
        f9360a.a(r16, r15);
        r10 = r18;
        r10.add(r16);
        r11 = r110;
        r12 = r14;
        goto L4
    L16:
        return (List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.memorydata.plugin");
    }

    public final List<JSONObject> a(List<h> r17) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r17, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r0, "metrics");
        h r2 = (h) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(r0), h.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L5;
        long r3 = r2.l();
    L6:
        long r6 = Math.floorDiv(r3, ProactiveLiveCardDisplayTool.DEFAULT_AUTO_DISMISS_DURATION_MS) * ProactiveLiveCardDisplayTool.DEFAULT_AUTO_DISMISS_DURATION_MS;
        String r8 = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(r8, "toString(...)");
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        Collection r10 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10)), Collection.class, "com.obric.memorydata.plugin");
        int r11 = 0;
        Iterator r12 = r9.iterator();
    L8:
        if (r12.hasNext() == false) goto L24;
        Object r13 = r12.next();
        int r14 = r11 + 1;
        if (r11 >= 0) goto L12;
        CollectionsKt.throwIndexOverflow();
    L12:
        h r15 = (h) ZeusTransformUtils.preCheckCast(r13, h.class, "com.obric.memorydata.plugin");
        JSONObject r16 = new JSONObject();
        r16.put("schemaVersion", 2);
        r16.put("sampleType", "AGGREGATED_WINDOW");
        r16.put("windowStartUtcMs", r6);
        Iterator r18 = r12;
        Collection r19 = r10;
        r16.put("windowEndUtcMs", r6 + ProactiveLiveCardDisplayTool.DEFAULT_AUTO_DISMISS_DURATION_MS);
        r16.put("snapshotAtMs", r3);
        r16.put("snapshotId", r8);
        r16.put("snapshotRowIndex", r11);
        r16.put("snapshotRowCount", r0.size());
        if (r15.b() != null) goto L15;
        String r20 = "OVERALL";
    L16:
        r16.put(TypedValues.Custom.S_DIMENSION, r20);
        Integer r21 = r15.b();
        if (r21 == null) goto L19;
        r16.put("entityType", ((Number) ZeusTransformUtils.preCheckCast(r21, Number.class, "com.obric.memorydata.plugin")).intValue());
    L19:
        r16.put("policyVersion", r15.a());
        Long r22 = r15.k();
        if (r22 == null) goto L22;
        r16.put("unknownPolicyEntityCount", ((Number) ZeusTransformUtils.preCheckCast(r22, Number.class, "com.obric.memorydata.plugin")).longValue());
    L22:
        f9360a.a(r16, r15);
        r10 = r19;
        r10.add(r16);
        r12 = r18;
        r11 = r14;
        goto L8
    L15:
        r20 = "ENTITY_TYPE";
        goto L16
    L24:
        return (List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.memorydata.plugin");
    L5:
        r3 = 0;
        goto L6
    }
}
