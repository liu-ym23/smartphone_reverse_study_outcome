package com.obric.memorydata.union.build;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.google.gson.reflect.TypeToken;
import com.obric.capabilitykit.EntityProvider;
import com.obric.capabilitykit.entity.app.EntityType;
import com.obric.memorydata.constants.OsTeaTrackerEventId;
import com.obric.memorydata.database.entity.EpisodicMemoryEntity;
import com.obric.memorydata.database.entity.RawMemoryEntity;
import com.obric.memorydata.database.entity.ScreenObservationEntity;
import com.obric.memorydata.database.entity.bi;
import com.obric.memorydata.database.entity.es;
import com.obric.memorydata.database.entity.iq;
import com.obric.memorydata.database.entity.iz;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.memory.api.MemoryService;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.bdtracker.Tracker;
import com.obric.memorydata.middleware.api.bridge.IUnionMemoryBuildBridgeAPI;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.api.EntityManager;
import com.obric.memorydata.union.build.storage.SemanticBatchCommitResult;
import com.obric.memorydata.union.build.storage.SemanticBatchFailure;
import com.obric.memorydata.utils.GsonUtil;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.CharsKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001&B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0000H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0012\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0002J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0005H\u0016J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0005H\u0016J\u0016\u0010\u0013\u001a\u00020\b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u0015H\u0016J\u0016\u0010\u0016\u001a\u00020\b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00170\u0015H\u0016J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0005H\u0016J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0005H\u0016J\u0010\u0010 \u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0005H\u0016J\u0016\u0010!\u001a\u00020\b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00170\u0015H\u0002J\u0016\u0010#\u001a\u00020\b2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u0015H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/obric/memorydata/union/build/UnionMemoryBuildBridgeAPIImpl;", "Lcom/obric/memorydata/middleware/api/bridge/IUnionMemoryBuildBridgeAPI;", "<init>", "()V", "TAG", "", "getInst", "onSemanticMemoryBuildResult", "", "data", "onSemanticMemoryBuildResultV2", "logV1HitForCutoverAudit", "api", "onUserInsightResult", "onUserPersonaResult", "onSemanticTypeSummaryResult", "onSemanticMemoryProcessed", "ids", "onSemanticMemoryPersonaProcessed", "failbackIndexMemoryEntity", "entityIds", "", "clearScreenObservation", "", "onEpisodicMemoryBuildResult", "commitUpgrade", "payload", "computeCommitOpShape", "Lcom/obric/memorydata/union/build/UnionMemoryBuildBridgeAPIImpl$MigrationOpShape;", "operations", "Lorg/json/JSONArray;", "recordUpgradeFailure", "finishRebuild", "updateScreenObservationEntityState", "idList", "trackerScreenObservationGenerateMemory", "entities", "Lcom/obric/memorydata/database/entity/ScreenObservationEntity;", "MigrationOpShape", "memory_build_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class UnionMemoryBuildBridgeAPIImpl implements IUnionMemoryBuildBridgeAPI {
    public static final UnionMemoryBuildBridgeAPIImpl INSTANCE = null;
    private static final String TAG = "UnionMemoryBuildBridgeAPI";

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J;\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/obric/memorydata/union/build/UnionMemoryBuildBridgeAPIImpl$MigrationOpShape;", "", "mergeCount", "", "mergedRows", "splitCount", "splitNewRows", "deleteCount", "<init>", "(IIIII)V", "getMergeCount", "()I", "getMergedRows", "getSplitCount", "getSplitNewRows", "getDeleteCount", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "memory_build_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f13064a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f13065b;
        private final int c;
        private final int d;
        private final int e;

        public a(int r1, int r2, int r3, int r4, int r5) {
            this.f13064a = r1;
            this.f13065b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        public final int a() {
            return this.f13064a;
        }

        public final int b() {
            return this.f13065b;
        }

        public final int c() {
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
            if (this.f13064a == r6.f13064a) goto L12;
            return false;
        L12:
            if (this.f13065b == r6.f13065b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
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
            return (((((((Integer.hashCode(this.f13064a) * 31) + Integer.hashCode(this.f13065b)) * 31) + Integer.hashCode(this.c)) * 31) + Integer.hashCode(this.d)) * 31) + Integer.hashCode(this.e);
        }

        public String toString() {
            return "MigrationOpShape(mergeCount=" + this.f13064a + ", mergedRows=" + this.f13065b + ", splitCount=" + this.c + ", splitNewRows=" + this.d + ", deleteCount=" + this.e + ')';
        }
    }

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001¨\u0006\u0003¸\u0006\u0000"}, d2 = {"com/obric/memorydata/utils/GsonUtil$fromJsonArray$2$1", "Lcom/google/gson/reflect/TypeToken;", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b extends TypeToken<List<? extends Long>> {
        public b() {
        }
    }

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001¨\u0006\u0003¸\u0006\u0000"}, d2 = {"com/obric/memorydata/utils/GsonUtil$fromJsonArray$2$1", "Lcom/google/gson/reflect/TypeToken;", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c extends TypeToken<List<? extends Long>> {
        public c() {
        }
    }

    static {
        INSTANCE = new UnionMemoryBuildBridgeAPIImpl();
    }

    private UnionMemoryBuildBridgeAPIImpl() {
    }

    private final a computeCommitOpShape(JSONArray r21) {
        Map r0 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        int r1 = r21.length();
        int r4 = 0;
        int r10 = 0;
    L4:
        if (r4 >= r1) goto L22;
        JSONObject r7 = r21.optJSONObject(r4);
        if (r7 == null) goto L21;
        if (Intrinsics.areEqual(r7.optString("operate_type"), "delete") == false) goto L11;
        r10 = r10 + 1;
    L11:
        JSONArray r5 = r7.optJSONArray(EntityProvider.KEY_ENTITY_IDS);
        if (r5 == null) goto L21;
        List r8 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        int r9 = r5.length();
        int r11 = 0;
    L15:
        if (r11 >= r9) goto L17;
        String r12 = r5.optString(r11);
        Intrinsics.checkNotNullExpressionValue(r12, "optString(...)");
        r8.add(r12);
        r11 = r11 + 1;
        goto L15
    L17:
        String r6 = CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.sorted((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("\u0000", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null);
        Object r13 = r0.get(r6);
        if (r13 != null) goto L20;
        r13 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        r0.put(r6, r13);
    L20:
        ((List) ZeusTransformUtils.preCheckCast(r13, List.class, "com.obric.memorydata.plugin")).add(r7);
    L21:
        r4 = r4 + 1;
        goto L4
    L22:
        Iterator r2 = r0.entrySet().iterator();
        int r14 = 0;
        int r15 = 0;
        int r16 = 0;
        int r17 = 0;
    L24:
        if (r2.hasNext() == false) goto L41;
        List r3 = (List) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r2.next(), Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), List.class, "com.obric.memorydata.plugin");
        if (r3.size() != 1) goto L38;
        JSONArray r18 = ((JSONObject) ZeusTransformUtils.preCheckCast(CollectionsKt.first(r3), JSONObject.class, "com.obric.memorydata.plugin")).optJSONArray(EntityProvider.KEY_ENTITY_IDS);
        if (r18 == null) goto L30;
        int r19 = r18.length();
    L31:
        if (r19 <= 1) goto L38;
        r14 = r14 + 1;
        JSONArray r20 = ((JSONObject) ZeusTransformUtils.preCheckCast(CollectionsKt.first(r3), JSONObject.class, "com.obric.memorydata.plugin")).optJSONArray(EntityProvider.KEY_ENTITY_IDS);
        if (r20 == null) goto L35;
        int r22 = r20.length();
    L36:
        r15 = r15 + (r22 - 1);
        goto L38
    L35:
        r22 = 1;
        goto L36
    L30:
        r19 = 0;
    L38:
        if (r3.size() <= 1) goto L24;
        r16 = r16 + 1;
        r17 = r17 + (r3.size() - 1);
        goto L24
    L41:
        return new a(r14, r15, r16, r17, r10);
    }

    @JvmStatic
    public static final UnionMemoryBuildBridgeAPIImpl getInst() {
        return INSTANCE;
    }

    public static /* synthetic */ CharSequence lambda$TP443VnBe9yFWFuzzodwyC4FXHs(StackTraceElement r0) {
        return logV1HitForCutoverAudit$lambda$1$lambda$0(r0);
    }

    private final void logV1HitForCutoverAudit(String r12, String r13) {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L13
        UnionMemoryBuildBridgeAPIImpl r11 = (UnionMemoryBuildBridgeAPIImpl) ZeusTransformUtils.preCheckCast(this, UnionMemoryBuildBridgeAPIImpl.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        MatchResult r14 = Regex.find$default(new Regex("\"content\"\\s*:\\s*\"((?:[^\"\\\\]|\\\\.)*)\""), (CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin"), 0, 2, null);     // Catch: Throwable -> L13
        if (r14 == null) goto L10;
        List<String> r15 = r14.getGroupValues();     // Catch: Throwable -> L13
        if (r15 == null) goto L10;
        String r16 = (String) ZeusTransformUtils.preCheckCast(CollectionsKt.getOrNull(r15, 1), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        if (r16 == null) goto L10;
    L11:
        StackTraceElement[] r2 = Thread.currentThread().getStackTrace();     // Catch: Throwable -> L13
        Intrinsics.checkNotNullExpressionValue(r2, "getStackTrace(...)");     // Catch: Throwable -> L13
        String r3 = CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.take((Iterable) ZeusTransformUtils.preCheckCast(ArraysKt.drop((Object[]) ZeusTransformUtils.preCheckCast(r2, Object[].class, "com.obric.memorydata.plugin"), 2), Iterable.class, "com.obric.memorydata.plugin"), 8), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(" <- ", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$UnionMemoryBuildBridgeAPIImpl$TP443VnBe9yFWFuzzodwyC4FXHs.INSTANCE, 30, null);     // Catch: Throwable -> L13
        String r4 = Integer.toString(r16.hashCode(), CharsKt.checkRadix(16));     // Catch: Throwable -> L13
        Intrinsics.checkNotNullExpressionValue(r4, "toString(...)");     // Catch: Throwable -> L13
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "[STREAM_DEBUG][V1_HIT!] api=" + r12 + " dataLen=" + r13.length() + " contentLen=" + r16.length() + " contentHash=" + r4 + " stack=[" + r3 + ']', null, 4, null);     // Catch: Throwable -> L13
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L13
        return;
    L10:
        r16 = "";
    L13:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
    }

    private static final CharSequence logV1HitForCutoverAudit$lambda$1$lambda$0(StackTraceElement r5) {
        StringBuilder r0 = new StringBuilder();
        String r1 = r5.getClassName();
        Intrinsics.checkNotNullExpressionValue(r1, "getClassName(...)");
        return (CharSequence) ZeusTransformUtils.preCheckCast(r0.append(StringsKt.substringAfterLast$default(r1, '.', null, 2, null)).append('.').append(r5.getMethodName()).append(':').append(r5.getLineNumber()).toString(), CharSequence.class, "com.obric.memorydata.plugin");
    }

    private final void trackerScreenObservationGenerateMemory(List<ScreenObservationEntity> r9) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        if (r8.isEmpty() == false) goto L6;
        com.bytedance.services.apm.api.a.a("entities can not be empty");
        return;
    L6:
        long r1 = System.currentTimeMillis();
        long r3 = 0;
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L8:
        if (r10.hasNext() == false) goto L10;
        r3 = r3 + ((ScreenObservationEntity) ZeusTransformUtils.preCheckCast(r10.next(), ScreenObservationEntity.class, "com.obric.memorydata.plugin")).getTimestamp();
        goto L8
    L10:
        Tracker r11 = Tracker.INSTANCE;
        String r0 = OsTeaTrackerEventId.IMAGE_TO_MEMORY_EVENT.getValue();
        JSONObject r5 = new JSONObject();
        r5.put("delta", r1 - (r3 / ((long) r8.size())));
        r5.put(CommonConsts.COUNT_TYPE, r8.size());
        Unit r12 = Unit.INSTANCE;
        r11.reportEvent(r0, r5);
    }

    private final void updateScreenObservationEntityState(List<Long> r4) {
        List<Long> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        List<ScreenObservationEntity> r5 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getScreenObservationDao().queryByIds(r3);
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        ScreenObservationEntity r1 = (ScreenObservationEntity) ZeusTransformUtils.preCheckCast(r6.next(), ScreenObservationEntity.class, "com.obric.memorydata.plugin");
        r1.setState(2);
        MemoryDbEngine.INSTANCE.getGlobalDbEngine().getScreenObservationDao().update(r1);
        goto L4
    L6:
        INSTANCE.trackerScreenObservationGenerateMemory(r5);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IUnionMemoryBuildBridgeAPI
    public void clearScreenObservation(List<Long> r3) {
        List<Long> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "ids");
        updateScreenObservationEntityState(r4);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IUnionMemoryBuildBridgeAPI
    public String commitUpgrade(String r29) {
        Intrinsics.checkNotNullParameter(r29, "payload");
        JSONObject r1 = new JSONObject(r29);
        JSONArray r2 = r1.optJSONArray("operations");
        if (r2 != null) goto L5;
        r2 = new JSONArray();
    L5:
        String r4 = r1.optString("trace_id");
        String r6 = r1.optString("log_id");
        int r7 = r1.optInt("row_count", r2.length());
        int r11 = r1.optInt("retry_round", 0);
        long r15 = r1.optLong("llm_duration_ms", 0);
        if (r2.length() != 0) goto L14;
        com.obric.memorydata.database.manager.q.a r0 = com.obric.memorydata.database.manager.q.f9592a.c();
        if (r0.a() == true) goto L10;
    L12:
        String r3 = new JSONObject().put("applied_count", 0).put("failed_operations", new JSONArray()).put("gate_passed", r0.a()).toString();
        Intrinsics.checkNotNullExpressionValue(r3, "toString(...)");
        return r3;
    L10:
        if (r0.b() == true) goto L12;
        MemoryService.INSTANCE.onSemanticMigrationUnblocked();
        goto L12
    L14:
        long r12 = com.obric.memorydata.database.manager.t.f9598a.b();
        com.obric.memorydata.database.manager.t r5 = com.obric.memorydata.database.manager.t.f9598a;
        JSONObject r8 = new JSONObject().put("batch_index", r12).put("row_count", r7).put("batch_kind", "python_bridge").put("semantic_type", "mixed").put("trace_id", r4).put("log_id", r6);
        Intrinsics.checkNotNullExpressionValue(r8, "put(...)");
        r5.a("l2_mig_batch_start", r8);
        long r24 = System.currentTimeMillis();
        SemanticBatchCommitResult r9 = com.obric.memorydata.union.build.storage.h.f13122a.b(r29);     // Catch: Throwable -> L30
        String r10 = "put(...)";
        long r13 = RangesKt.coerceAtLeast(System.currentTimeMillis() - r24, 0) + r15;
        JSONArray r14 = new JSONArray();
        String r16 = "com.obric.memorydata.plugin";
        Iterator r17 = ((Iterable) ZeusTransformUtils.preCheckCast(r9.getFailedOperations(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L18:
        if (r17.hasNext() == false) goto L20;
        Iterator r18 = r17;
        SemanticBatchFailure r19 = (SemanticBatchFailure) ZeusTransformUtils.preCheckCast(r17.next(), SemanticBatchFailure.class, r16);
        String r110 = r16;
        String r111 = r10;
        r14.put(new JSONObject().put("operation_id", r19.getOperationId()).put("error", r19.getError()));
        r17 = r18;
        r16 = r110;
        r10 = r111;
        goto L18
    L20:
        String r112 = r10;
        if (r9.getFailedOperations().isEmpty() == true) goto L23;
    L25:
        boolean r20 = false;
    L26:
        if (r20 == false) goto L28;
        com.obric.memorydata.database.manager.q.f9592a.d();
        com.obric.memorydata.database.manager.t r21 = com.obric.memorydata.database.manager.t.f9598a;
        JSONObject r22 = new JSONObject().put("batch_index", r12).put("row_count_in", r7).put("op_count_out", r9.getAppliedCount()).put("duration_ms", r13).put("retry_round", r11).put("trace_id", r4).put("log_id", r6);
        Intrinsics.checkNotNullExpressionValue(r22, r112);
        r21.a("l2_mig_batch_success", r22);
        a r23 = computeCommitOpShape(r2);
        com.obric.memorydata.database.manager.t r25 = com.obric.memorydata.database.manager.t.f9598a;
        JSONObject r26 = new JSONObject().put("batch_index", r12).put("merge_count", r23.a()).put("merged_rows", r23.b()).put("split_count", r23.c()).put("split_new_rows", r23.d()).put("delete_count", r23.e()).put("trace_id", r4).put("log_id", r6);
        Intrinsics.checkNotNullExpressionValue(r26, r112);
        r25.a("l2_mig_op_shape", r26);
    L28:
        String r27 = new JSONObject().put("applied_count", r9.getAppliedCount()).put("failed_operations", r14).put("gate_passed", false).toString();
        Intrinsics.checkNotNullExpressionValue(r27, "toString(...)");
        return r27;
    L23:
        if (r9.getAppliedCount() != r2.length()) goto L25;
        r20 = true;
    L30:
        th = move-exception;
        com.obric.memorydata.database.manager.t r28 = com.obric.memorydata.database.manager.t.f9598a;
        JSONObject r30 = new JSONObject().put(TypedValues.CycleType.S_WAVE_PHASE, "upgrade").put("error_class", th.getClass().getSimpleName()).put("batch_index", r12).put("trace_id", r4).put("log_id", r6);
        Intrinsics.checkNotNullExpressionValue(r30, "put(...)");
        r28.a("l2_mig_error", r30);
        throw th;
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IUnionMemoryBuildBridgeAPI
    public void failbackIndexMemoryEntity(List<String> r62) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r62, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r0, "entityIds");
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        boolean r3 = false;
    L4:
        if (r1.hasNext() == false) goto L23;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L4;
        iz r6 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getUpdateUnionSemanticMemoryDao().queryByEntityId(r4);
        if (r6 == null) goto L4;
        String r5 = "semantic_fail_back_" + r6.b();
        RawMemoryEntity r60 = new RawMemoryEntity(0, r5, r6.c(), r6.d(), 0, 0, AppContext.INSTANCE.getPackageName(), 0, r6.h(), EntityType.MEMORY_COMMON_TEXT, r6.q(), null, null, null, null, null, null, null, null, null, r6.k(), null, r6.k(), "用户的" + iq.b(r6.i()), null, null, null, null, null, null, null, null, null, null, null, null, null, AppContext.INSTANCE.getPackageName(), "豆包", null, null, r6.k(), 0, null, r6.o(), -13633359, 2463, null);
        EpisodicMemoryEntity r2 = bi.a(r60);
        es r7 = bi.b(r60);
        if (r2 == null) goto L16;
        boolean r14 = false;
        if (com.obric.memorydata.database.a.C0451a.a((com.obric.memorydata.database.a) ZeusTransformUtils.preCheckCast(r2, com.obric.memorydata.database.a.class, "com.obric.memorydata.plugin"), false, 1, null) != true) goto L17;
        boolean r8 = true;
    L18:
        if (r8 == true) goto L19;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "failback index skipped, entityId=" + r4, false, 4, null);
        goto L4
    L19:
        if (r7 == null) goto L21;
        MemoryDbEngine.INSTANCE.getPersonalDbEngine().getProactiveEpisodicRelevantDataDao().insert(r7);
    L21:
        MemoryDbEngine.INSTANCE.getPersonalDbEngine().getUpdateUnionSemanticMemoryDao().update(iz.a(r6, 0, null, 0, 0, 0, 0, null, 0, null, null, null, null, null, null, null, false, 0, 0, false, 0.0f, "兜底到收藏，id为\"" + r5 + Typography.quote, true, 0, 0, 13631487, null));
        r3 = true;
    L17:
        r8 = r14;
        goto L18
    L16:
        r14 = false;
        goto L17
    L23:
        if (r3 == false) goto L36;
        EntityManager.INSTANCE.launchIndexTask();
        return;
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IUnionMemoryBuildBridgeAPI
    public String finishRebuild(String r3) {
        Intrinsics.checkNotNullParameter(r3, "payload");
        long r2 = new JSONObject(r3).optLong(TypedValues.AttributesType.S_TARGET, 0);
        boolean r4 = com.obric.memorydata.database.manager.q.f9592a.a(r2);
        String r5 = new JSONObject().put("finished", r4).toString();
        Intrinsics.checkNotNullExpressionValue(r5, "toString(...)");
        return r5;
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IUnionMemoryBuildBridgeAPI
    public String onEpisodicMemoryBuildResult(String r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        logV1HitForCutoverAudit("onEpisodicMemoryBuildResult", r2);
        return new k(r2).a();
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IUnionMemoryBuildBridgeAPI
    public void onSemanticMemoryBuildResult(String r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        logV1HitForCutoverAudit("onSemanticMemoryBuildResult", r2);
        new n(r2).a();
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IUnionMemoryBuildBridgeAPI
    public String onSemanticMemoryBuildResultV2(String r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        logV1HitForCutoverAudit("onSemanticMemoryBuildResultV2", r2);
        return new o(r2).a();
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IUnionMemoryBuildBridgeAPI
    public void onSemanticMemoryPersonaProcessed(String r4) {
        Intrinsics.checkNotNullParameter(r4, "ids");
        GsonUtil r3 = GsonUtil.INSTANCE;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L5;
        boolean r5 = true;
    L6:
        List<Long> r2 = null;
        if (r5 == true) goto L10;
        r4 = null;
    L10:
        if (r4 == null) goto L13;
        r2 = (List) ZeusTransformUtils.preCheckCast(GsonUtil.INSTANCE.getGSON().fromJson(r4, new b().getType()), List.class, "com.obric.memorydata.plugin");
    L13:
        if (com.obric.memorydata.utils.b.b(r2) == false) goto L18;
        Intrinsics.checkNotNull(r2);
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L19;
        MemoryDbEngine.INSTANCE.getPersonalDbEngine().getSemanticMemoryDao().updateUseForPersona(r2);
        return;
    L19:
        return;
    L18:
        return;
    L5:
        r5 = false;
        goto L6
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IUnionMemoryBuildBridgeAPI
    public void onSemanticMemoryProcessed(String r4) {
        Intrinsics.checkNotNullParameter(r4, "ids");
        GsonUtil r3 = GsonUtil.INSTANCE;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L5;
        boolean r5 = true;
    L6:
        List<Long> r2 = null;
        if (r5 == true) goto L10;
        r4 = null;
    L10:
        if (r4 == null) goto L13;
        r2 = (List) ZeusTransformUtils.preCheckCast(GsonUtil.INSTANCE.getGSON().fromJson(r4, new c().getType()), List.class, "com.obric.memorydata.plugin");
    L13:
        if (com.obric.memorydata.utils.b.b(r2) == false) goto L18;
        Intrinsics.checkNotNull(r2);
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L19;
        MemoryDbEngine.INSTANCE.getPersonalDbEngine().getSemanticMemoryDao().updateUseForInsight(r2);
        return;
    L19:
        return;
    L18:
        return;
    L5:
        r5 = false;
        goto L6
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IUnionMemoryBuildBridgeAPI
    public void onSemanticTypeSummaryResult(String r1) {
        Intrinsics.checkNotNullParameter(r1, "data");
        new p(r1).a();
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IUnionMemoryBuildBridgeAPI
    public void onUserInsightResult(String r1) {
        Intrinsics.checkNotNullParameter(r1, "data");
        new q(r1).a();
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IUnionMemoryBuildBridgeAPI
    public void onUserPersonaResult(String r1) {
        Intrinsics.checkNotNullParameter(r1, "data");
        new t(r1).a();
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IUnionMemoryBuildBridgeAPI
    public String recordUpgradeFailure(String r13) {
        Intrinsics.checkNotNullParameter(r13, "payload");
        JSONObject r12 = new JSONObject(r13);
        JSONArray r14 = r12.optJSONArray(EntityProvider.KEY_ENTITY_IDS);
        if (r14 != null) goto L5;
        r14 = new JSONArray();
    L5:
        String r1 = r12.optString("fail_reason", "other");
        String r3 = r12.optString("trace_id");
        String r15 = r12.optString("log_id");
        List r5 = CollectionsKt.createListBuilder();
        int r6 = r14.length();
        int r8 = 0;
    L6:
        if (r8 >= r6) goto L17;
        String r9 = r14.optString(r8);
        Intrinsics.checkNotNull(r9);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L10;
        boolean r10 = true;
    L11:
        if (r10 == true) goto L14;
        r9 = null;
    L14:
        if (r9 == null) goto L16;
        r5.add(r9);
    L16:
        r8 = r8 + 1;
        goto L6
    L10:
        r10 = false;
        goto L11
    L17:
        com.obric.memorydata.database.manager.h r16 = com.obric.memorydata.database.manager.q.f9592a.a(CollectionsKt.build(r5));
        com.obric.memorydata.database.manager.t r7 = com.obric.memorydata.database.manager.t.f9598a;
        JSONObject r11 = new JSONObject().put("batch_index", -1).put("fail_reason", r1).put("consecutive_fail_count", r16.b()).put("trace_id", r3).put("log_id", r15);
        Intrinsics.checkNotNullExpressionValue(r11, "put(...)");
        r7.a("l2_mig_batch_fail", r11);
        if (r16.a() == true) goto L20;
    L22:
        String r17 = new JSONObject().put("fallback_applied", r16.a()).put("consecutive_failures", r16.b()).put("fallback_row_count", r16.c()).toString();
        Intrinsics.checkNotNullExpressionValue(r17, "toString(...)");
        return r17;
    L20:
        if (r16.c() <= 0) goto L22;
        com.obric.memorydata.database.manager.t r18 = com.obric.memorydata.database.manager.t.f9598a;
        JSONObject r19 = new JSONObject().put("batch_index", -1).put("row_count", r16.c()).put("fail_reason", r1).put("trace_id", r3).put("log_id", r15);
        Intrinsics.checkNotNullExpressionValue(r19, "put(...)");
        r18.a("l2_mig_batch_fallback", r19);
        goto L22
    }
}
