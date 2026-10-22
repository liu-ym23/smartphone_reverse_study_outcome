package com.obric.memorydata.database.manager;

import android.database.Cursor;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.amap.api.fence.GeoFence;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.database.dao.SemanticStateDao;
import com.obric.memorydata.database.entity.ik;
import com.obric.memorydata.personalcontext.api.EntityManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SpreadBuilder;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001VB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0005J\u0006\u0010\u001f\u001a\u00020 J\u0006\u0010!\u001a\u00020\"J\u0014\u0010#\u001a\u00020$2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00050&J\u0006\u0010'\u001a\u00020 J\u0015\u0010(\u001a\u00020\u001d2\u0006\u0010)\u001a\u00020*H\u0000¢\u0006\u0002\b+J\u0010\u0010,\u001a\u00020-2\u0006\u0010)\u001a\u00020*H\u0002J\u0016\u0010.\u001a\b\u0012\u0004\u0012\u00020/0&2\u0006\u0010)\u001a\u00020*H\u0002J\u0016\u00100\u001a\b\u0012\u0004\u0012\u00020/0&2\u0006\u0010)\u001a\u00020*H\u0002J\u0010\u00101\u001a\u00020 2\u0006\u0010)\u001a\u00020*H\u0002J\u0018\u00102\u001a\u00020 2\u0006\u0010)\u001a\u00020*2\u0006\u00103\u001a\u00020/H\u0002J\u0018\u00104\u001a\u00020 2\u0006\u0010)\u001a\u00020*2\u0006\u00105\u001a\u00020-H\u0002J+\u00106\u001a\u00020$2\u0006\u0010)\u001a\u00020*2\u0006\u00107\u001a\u00020\u00052\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00050&H\u0000¢\u0006\u0002\b8J\u0018\u00109\u001a\u00020/2\u0006\u0010)\u001a\u00020*2\u0006\u00107\u001a\u00020\u0005H\u0002J$\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00050&2\u0006\u0010)\u001a\u00020*2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00050&H\u0002J\u001e\u0010<\u001a\u00020 2\u0006\u0010)\u001a\u00020*2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00050&H\u0002J\u0015\u0010=\u001a\u00020\b2\u0006\u0010)\u001a\u00020*H\u0000¢\u0006\u0002\b>J\u0010\u0010?\u001a\u00020 2\u0006\u0010)\u001a\u00020*H\u0002J\u0010\u0010'\u001a\u00020 2\u0006\u0010)\u001a\u00020*H\u0002J\u000e\u0010@\u001a\u00020\u001d2\u0006\u0010A\u001a\u00020/J\u001d\u0010B\u001a\u00020\u001d2\u0006\u0010)\u001a\u00020*2\u0006\u0010A\u001a\u00020/H\u0000¢\u0006\u0002\bCJ\u0018\u0010D\u001a\u00020/2\u0006\u0010)\u001a\u00020*2\u0006\u0010E\u001a\u00020\u0005H\u0002J\u001a\u0010F\u001a\u0004\u0018\u00010\u00052\u0006\u0010)\u001a\u00020*2\u0006\u0010E\u001a\u00020\u0005H\u0002J%\u0010G\u001a\u00020\u001d2\u0006\u0010)\u001a\u00020*2\u000e\b\u0002\u0010H\u001a\b\u0012\u0004\u0012\u00020 0IH\u0000¢\u0006\u0002\bJJ\u001e\u0010K\u001a\u00020L2\u0006\u0010)\u001a\u00020*2\f\u0010H\u001a\b\u0012\u0004\u0012\u00020 0IH\u0002J\u001e\u0010M\u001a\u00020N2\u0006\u0010)\u001a\u00020*2\f\u0010O\u001a\b\u0012\u0004\u0012\u00020/0&H\u0002J\u0018\u0010P\u001a\u00020/2\u0006\u0010)\u001a\u00020*2\u0006\u0010Q\u001a\u00020\u0005H\u0002J\u0016\u0010R\u001a\b\u0012\u0004\u0012\u00020/0&2\u0006\u0010)\u001a\u00020*H\u0002J\u0010\u0010S\u001a\u00020/2\u0006\u0010)\u001a\u00020*H\u0002J&\u0010T\u001a\u00020 2\u0006\u0010)\u001a\u00020*2\f\u0010O\u001a\b\u0012\u0004\u0012\u00020/0&2\u0006\u0010U\u001a\u00020/H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u0015X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u000e\u0010;\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006W"}, d2 = {"Lcom/obric/memorydata/database/manager/SemanticMigrationStateMachine;", "", "<init>", "()V", "MIGRATION_UNPROTECTED_SQL", "", "STARTED_AT_KEY", "PREPARE_BATCH_SIZE", "", "PHASE_KEY", "CHANGE_SEQ_KEY", "UPGRADE_FENCE_KEY", "REBUILD_TARGET_KEY", "DREAMING_CURSOR_KEY", "USER_INSIGHT_CURSOR_KEY", "INTEREST_SUMMARY_CURSOR_KEY", "FAILURE_BATCH_KEY", "FAILURE_COUNT_KEY", "FALLBACK_BATCH_COUNT_KEY", "FALLBACK_ROW_COUNT_KEY", "migratedSubtypeValues", "", "getMigratedSubtypeValues$database_obricRelease", "()Ljava/util/Set;", "normalizedTagPathSql", "uiBlockedPhases", "Lcom/obric/memorydata/database/manager/SemanticMigrationPhase;", "getUiBlockedPhases", "isUiBlocked", "", EventBody.KEY_VALUE, "runPrepareIfNeeded", "", "finishUpgradeIfValidWithSkip", "Lcom/obric/memorydata/database/manager/SemanticMigrationStateMachine$FinishUpgradeGateResult;", "recordUpgradeFailureAndMaybeFallback", "Lcom/obric/memorydata/database/manager/MigrationFallbackResult;", "entityIds", "", "clearUpgradeFailure", "applyUpgradeGate", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "applyUpgradeGate$database_obricRelease", "applyUpgradeGateWithMetrics", "Lcom/obric/memorydata/database/manager/MigrationGateMetrics;", "queryUpgradeInvalidCounts", "", "queryUpgradeMonitorCounts", "openUpgradeGate", "prepareDreamingCursor", GeoFence.BUNDLE_KEY_FENCE, "reportUpgradeGate", "metrics", "applyUpgradeFailure", "batchIdentity", "applyUpgradeFailure$database_obricRelease", "recordConsecutiveFailure", "queryFallbackEligibleIds", "INITIAL_CONFIDENCE_SQL", "applyFallbackRows", "applyInitialConfirmationSeed", "applyInitialConfirmationSeed$database_obricRelease", "ensureFailureStateRows", "finishRebuildIfValid", "targetCursor", "applyFinishRebuild", "applyFinishRebuild$database_obricRelease", "queryNum", "key", "queryText", "applyPrepareBatch", "cleanupPreparedRows", "Lkotlin/Function0;", "applyPrepareBatch$database_obricRelease", "executePrepareBatch", "Lcom/obric/memorydata/database/manager/PrepareBatchExecution;", "collectPrepareBatchMetrics", "Lcom/obric/memorydata/database/manager/PrepareBatchMetrics;", "rowIds", "queryCount", "sql", "queryPrepareRowIds", "nextChangeSequence", "normalizePrepareRows", "changeSeq", "FinishUpgradeGateResult", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q f9592a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Set<String> f9593b = null;
    private static final String c = null;
    private static final Set<SemanticMigrationPhase> d = null;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/obric/memorydata/database/manager/SemanticMigrationStateMachine$FinishUpgradeGateResult;", "", "passed", "", "skipped", "<init>", "(ZZ)V", "getPassed", "()Z", "getSkipped", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f9594a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f9595b;

        public a(boolean r1, boolean r2) {
            this.f9594a = r1;
            this.f9595b = r2;
        }

        public final boolean a() {
            return this.f9594a;
        }

        public final boolean b() {
            return this.f9595b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (this.f9594a == r6.f9594a) goto L12;
            return false;
        L12:
            if (this.f9595b == r6.f9595b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (Boolean.hashCode(this.f9594a) * 31) + Boolean.hashCode(this.f9595b);
        }

        public String toString() {
            return "FinishUpgradeGateResult(passed=" + this.f9594a + ", skipped=" + this.f9595b + ')';
        }
    }

    static {
        f9592a = new q();
        f9593b = s.f9596a.a();
        c = s.f9596a.c();
        d = SetsKt.setOf(new SemanticMigrationPhase[]{SemanticMigrationPhase.SCHEMA, SemanticMigrationPhase.PREPARE, SemanticMigrationPhase.UPGRADE});
    }

    private q() {
    }

    private final long a(SupportSQLiteDatabase r6, String r7) {
        SupportSQLiteDatabase r8 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r6, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        long r1 = 1;
        if (Intrinsics.areEqual(c(r8, "migration_failure_batch"), r7) == false) goto L5;
        r1 = 1 + b(r8, "migration_failure_count");
    L5:
        r8.execSQL("UPDATE SemanticState SET txt = ? WHERE `key` = 'migration_failure_batch'", new String[]{r7});
        r8.execSQL("UPDATE SemanticState SET num = ? WHERE `key` = 'migration_failure_count'", new Long[]{Long.valueOf(r1)});
        return r1;
    }

    private static final h a(PersonalMemoryFrameDb r2, String r3, List r4) {
        List<String> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        return f9592a.a(r2.getOpenHelper().getWritableDatabase(), r3, r5);
    }

    private static final i a(PersonalMemoryFrameDb r1) {
        return f9592a.b(r1.getOpenHelper().getWritableDatabase());
    }

    private final k a(SupportSQLiteDatabase r4, Function0<Unit> r5) {
        SupportSQLiteDatabase r6 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        Function0 r7 = (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin");
        List<Long> r0 = h(r6);
        if (r0.isEmpty() == true) goto L5;
        l r8 = c(r6, r0);
        a(r6, r0, i(r6));
        return new k(false, r8);
    L5:
        if (Intrinsics.areEqual(c(r6, "migration_phase"), SemanticMigrationPhase.PREPARE.getValue()) == false) goto L7;
        r7.invoke();
    L7:
        r6.execSQL("UPDATE SemanticState SET txt = 'upgrade' WHERE `key` = 'migration_phase'");
        return new k(true, null);
    }

    private static final k a(final PersonalMemoryFrameDb r3, final Ref.ObjectRef r4) {
        return f9592a.a(r3.getOpenHelper().getWritableDatabase(), new $$Lambda$q$Ai3VvKj6DL2IDxTCD6SehSusCsE(r4, r3));
    }

    private static final Boolean a(PersonalMemoryFrameDb r1, long r2) {
        return Boolean.valueOf(f9592a.a(r1.getOpenHelper().getWritableDatabase(), r2));
    }

    private final List<String> a(SupportSQLiteDatabase r6, List<String> r7) {
        SupportSQLiteDatabase r5 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r6, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r10 = r8.iterator();
    L4:
        if (r10.hasNext() == false) goto L16;
        Object r1 = r10.next();
        Closeable r2 = (Closeable) ZeusTransformUtils.preCheckCast(r5.query("SELECT 1 FROM UnionSemanticMemory WHERE entityId = ? AND migration_version < 1 LIMIT 1", new String[]{(String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.memorydata.plugin")}), Closeable.class, "com.obric.memorydata.plugin");
        boolean r4 = ((Cursor) ZeusTransformUtils.preCheckCast(r2, Cursor.class, "com.obric.memorydata.plugin")).moveToNext();     // Catch: Throwable -> L10
        CloseableKt.closeFinally(r2, null);
        if (r4 == false) goto L4;
        r9.add(r1);
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        CloseableKt.closeFinally(r2, th);
        throw th;
    L16:
        return (List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.memorydata.plugin");
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [T, com.obric.memorydata.database.manager.p$a] */
    private static final Unit a(Ref.ObjectRef r1, PersonalMemoryFrameDb r2) {
        r1.element = p.f9587a.a(r2.getOpenHelper().getWritableDatabase());
        return Unit.INSTANCE;
    }

    private final void a(SupportSQLiteDatabase r14, i r15) {
        SupportSQLiteDatabase r16 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r14, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        if (r15.g() == false) goto L5;
        return;
    L5:
        long r2 = t.f9598a.c(r16);
        List<Long> r0 = r15.b();
        List<Long> r4 = r15.c();
        t r5 = t.f9598a;
        JSONObject r13 = new JSONObject().put("v1_interests_rows", ((Number) ZeusTransformUtils.preCheckCast(r0.get(0), Number.class, "com.obric.memorydata.plugin")).longValue()).put("v2_confidence_zero_rows", ((Number) ZeusTransformUtils.preCheckCast(r0.get(1), Number.class, "com.obric.memorydata.plugin")).longValue()).put("v3_unmigrated_rows", ((Number) ZeusTransformUtils.preCheckCast(r0.get(2), Number.class, "com.obric.memorydata.plugin")).longValue()).put("v4_1003_bad_confidence_rows", ((Number) ZeusTransformUtils.preCheckCast(r0.get(3), Number.class, "com.obric.memorydata.plugin")).longValue()).put("v5_useredit_bad_confidence_rows", ((Number) ZeusTransformUtils.preCheckCast(r0.get(4), Number.class, "com.obric.memorydata.plugin")).longValue()).put("v6_illegal_c4_rows", ((Number) ZeusTransformUtils.preCheckCast(r0.get(5), Number.class, "com.obric.memorydata.plugin")).longValue()).put("passed", r15.a()).put("attempt", r2).put("m_c4_from_1002_rows", ((Number) ZeusTransformUtils.preCheckCast(r4.get(0), Number.class, "com.obric.memorydata.plugin")).longValue()).put("m_glasses_audio_rows", ((Number) ZeusTransformUtils.preCheckCast(r4.get(1), Number.class, "com.obric.memorydata.plugin")).longValue()).put("m_fallback_batches", b(r16, "migration_fallback_batches")).put("m_fallback_rows", b(r16, "migration_fallback_rows")).put("m_subtype_其他_rows", ((Number) ZeusTransformUtils.preCheckCast(r4.get(2), Number.class, "com.obric.memorydata.plugin")).longValue());
        Intrinsics.checkNotNullExpressionValue(r13, "put(...)");
        r5.a("l2_mig_gate_check", r13);
        if (r15.a() == true) goto L8;
        return;
    L8:
        t r17 = t.f9598a;
        JSONObject r1 = new JSONObject().put("pending_count", r15.e()).put("c3_total", r15.f());
        Intrinsics.checkNotNullExpressionValue(r1, "put(...)");
        r17.a("l2_mig_confirmation_seed", r1);
        t r18 = t.f9598a;
        JSONObject r19 = new JSONObject().put("elapsed_ms_since_start", t.f9598a.d(r16)).put("total_rows", r15.d());
        Intrinsics.checkNotNullExpressionValue(r19, "put(...)");
        r18.a("l2_mig_gate_open", r19);
        t.f9598a.a(r16, SemanticMigrationPhase.UPGRADE, SemanticMigrationPhase.REBUILD);
    }

    private final void a(SupportSQLiteDatabase r11, List<Long> r12, long r13) {
        SupportSQLiteDatabase r10 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r11, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        List r14 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
        String r15 = CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$q$eH4GXzOIKbm_oVa9tAna9zjNUg.INSTANCE, 30, null);
        String r1 = StringsKt.trimIndent("UPDATE UnionSemanticMemory\n                SET semantic_type = CASE\n                        WHEN semantic_type = 'interests' THEN 'preference'\n                        ELSE semantic_type\n                    END,\n                    tag_path = " + c + ",\n                    confidence = CASE\n        WHEN product_type = 1003 OR user_edit = 1 THEN 4.0\n        WHEN product_type = 1002 AND evidence_count >= 5 THEN 4.0\n        WHEN product_type = 1002 AND evidence_count < 2 THEN 2.0\n        ELSE 3.0 END,\n                    change_seq = ?\n                WHERE id IN (" + r15 + ')');
        SpreadBuilder r2 = new SpreadBuilder(2);
        r2.add(Long.valueOf(r13));
        r2.addSpread(((Collection) ZeusTransformUtils.preCheckCast(r14, Collection.class, "com.obric.memorydata.plugin")).toArray(new Long[0]));
        r10.execSQL(r1, r2.toArray(new Long[r2.size()]));
        String r16 = StringsKt.trimIndent("UPDATE UnionSemanticMemory\n                SET confidence = 4.0,\n                    confirmation_state = 'none',\n                    migration_version = 1,\n                    change_seq = ?\n                WHERE id IN (" + r15 + ")\n                  AND product_type != 1003\n                  AND user_edit = 1");
        SpreadBuilder r3 = new SpreadBuilder(2);
        r3.add(Long.valueOf(r13));
        r3.addSpread(((Collection) ZeusTransformUtils.preCheckCast(r14, Collection.class, "com.obric.memorydata.plugin")).toArray(new Long[0]));
        r10.execSQL(r16, r3.toArray(new Long[r3.size()]));
    }

    private final long b(SupportSQLiteDatabase r3, String r4) {
        Closeable r2 = (Closeable) ZeusTransformUtils.preCheckCast(((SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin")).query("SELECT num FROM SemanticState WHERE `key` = ? LIMIT 1", new String[]{r4}), Closeable.class, "com.obric.memorydata.plugin");
        Cursor r5 = (Cursor) ZeusTransformUtils.preCheckCast(r2, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r5.moveToNext() == false) goto L7;
        long r6 = r5.getLong(0);     // Catch: Throwable -> L10
    L8:
        CloseableKt.closeFinally(r2, null);
        return r6;
    L7:
        r6 = 0;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        CloseableKt.closeFinally(r2, th);
        throw th;
    }

    private final i b(SupportSQLiteDatabase r26) {
        SupportSQLiteDatabase r1 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r26, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(c(r1, "migration_phase"), SemanticMigrationPhase.UPGRADE.getValue()) == false) goto L5;
        List<Long> r15 = c(r1);
        List<Long> r16 = d(r1);
        long r17 = d(r1, "SELECT COUNT(*) FROM UnionSemanticMemory");
        long r20 = d(r1, "SELECT COUNT(*) FROM UnionSemanticMemory WHERE confidence = 3.0");
        int r19 = a(r1);
        e(r1);
        return new i(true, r15, r16, r17, r19, r20, false, 64, null);
    L5:
        return new i(true, CollectionsKt.listOf(new Long[]{0L, 0L, 0L, 0L, 0L, 0L}), CollectionsKt.listOf(new Long[]{0L, 0L, 0L}), 0, 0, 0, true);
    }

    private static final CharSequence b(long r1) {
        return (CharSequence) ZeusTransformUtils.preCheckCast("?", CharSequence.class, "com.obric.memorydata.plugin");
    }

    private static final CharSequence b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return (CharSequence) ZeusTransformUtils.preCheckCast("?", CharSequence.class, "com.obric.memorydata.plugin");
    }

    private final void b(SupportSQLiteDatabase r10, long r11) {
        SupportSQLiteDatabase r9 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r10, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        Closeable r12 = (Closeable) ZeusTransformUtils.preCheckCast(r9.query("SELECT num FROM SemanticState WHERE `key` = 'migration_started_at_ms'"), Closeable.class, "com.obric.memorydata.plugin");
        Cursor r1 = (Cursor) ZeusTransformUtils.preCheckCast(r12, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L24
        if (r1.moveToNext() == false) goto L22;
        long r3 = r1.getLong(0);     // Catch: Throwable -> L24
        CloseableKt.closeFinally(r12, null);
        r9.execSQL("UPDATE SemanticState SET num = ? WHERE `key` = 'cursor:dreaming'", new Long[]{Long.valueOf(r11)});
        r9.execSQL("DELETE FROM SemanticState WHERE `key` IN ('cursor:dreaming:target', 'cursor:dreaming:stall_seq', 'cursor:dreaming:stall_count')");
        Closeable r13 = (Closeable) ZeusTransformUtils.preCheckCast(r9.query("SELECT id FROM UnionSemanticMemory WHERE (product_type = 1003 OR user_edit = 1) AND modifyTime >= ? ORDER BY modifyTime ASC, id ASC", new Long[]{Long.valueOf(r3)}), Closeable.class, "com.obric.memorydata.plugin");
        Cursor r14 = (Cursor) ZeusTransformUtils.preCheckCast(r13, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
        List r4 = CollectionsKt.createListBuilder();     // Catch: Throwable -> L17
    L9:
        if (r14.moveToNext() == false) goto L11;
        r4.add(Long.valueOf(r14.getLong(0)));     // Catch: Throwable -> L17
        goto L9
    L11:
        List r15 = CollectionsKt.build(r4);     // Catch: Throwable -> L17
        CloseableKt.closeFinally(r13, null);
        Iterator r16 = ((Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L14:
        if (r16.hasNext() == false) goto L16;
        r9.execSQL("UPDATE UnionSemanticMemory SET change_seq = ? WHERE id = ?", new Long[]{Long.valueOf(f9592a.i(r9)), Long.valueOf(((Number) ZeusTransformUtils.preCheckCast(r16.next(), Number.class, "com.obric.memorydata.plugin")).longValue())});
        goto L14
    L16:
        return;
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        CloseableKt.closeFinally(r13, th);
        throw th;
    L22:
        com.obric.memorydata.middleware.api.logging.o.a((com.obric.memorydata.middleware.api.logging.o) ZeusTransformUtils.preCheckCast(com.obric.memorydata.middleware.api.logging.n.f11627a, com.obric.memorydata.middleware.api.logging.o.class, "com.obric.memorydata.plugin"), "Migration start time missing during upgrade gate", "l2_mig_gate_fail", "MIGRATION_START_TIME_MISSING", null, null, null, 56, null);     // Catch: Throwable -> L24
        throw new IllegalStateException("migration start time is unavailable".toString());     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        CloseableKt.closeFinally(r12, th);
        throw th;
    }

    private final void b(SupportSQLiteDatabase r14, List<String> r15) {
        SupportSQLiteDatabase r16 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r14, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        List r17 = (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.memorydata.plugin");
        long r2 = i(r16);
        String r13 = StringsKt.trimIndent("UPDATE UnionSemanticMemory\n                SET confidence = CASE WHEN confidence = 0 THEN CASE\n        WHEN product_type = 1003 OR user_edit = 1 THEN 4.0\n        WHEN product_type = 1002 AND evidence_count >= 5 THEN 4.0\n        WHEN product_type = 1002 AND evidence_count < 2 THEN 2.0\n        ELSE 3.0 END ELSE confidence END,\n                    confirmation_state = 'none',\n                    migration_version = 1,\n                    change_seq = ?\n                WHERE entityId IN (" + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r17, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$q$_8vNgulYmYVPWV79BR6XX1iywaU.INSTANCE, 30, null) + ") AND migration_version < 1");
        SpreadBuilder r0 = new SpreadBuilder(2);
        r0.add(Long.valueOf(r2));
        r0.addSpread(((Collection) ZeusTransformUtils.preCheckCast(r17, Collection.class, "com.obric.memorydata.plugin")).toArray(new String[0]));
        r16.execSQL(r13, r0.toArray(new Object[r0.size()]));
    }

    private static final void b(PersonalMemoryFrameDb r1) {
        f9592a.g(r1.getOpenHelper().getWritableDatabase());
    }

    private final l c(SupportSQLiteDatabase r11, List<Long> r12) {
        SupportSQLiteDatabase r10 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r11, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
        Closeable r14 = (Closeable) ZeusTransformUtils.preCheckCast(r10.query("SELECT semantic_type, tag_path, product_type, user_edit, (" + c + ") FROM UnionSemanticMemory WHERE id IN (" + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$q$5Ob4vtoNC8SaztcOTQBM4o6IV_0.INSTANCE, 30, null) + ')', ((Collection) ZeusTransformUtils.preCheckCast(r13, Collection.class, "com.obric.memorydata.plugin")).toArray(new Long[0])), Closeable.class, "com.obric.memorydata.plugin");
        Cursor r15 = (Cursor) ZeusTransformUtils.preCheckCast(r14, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L29
        int r5 = 0;
        int r6 = 0;
        int r7 = 0;
        int r8 = 0;
    L5:
        if (r15.moveToNext() == false) goto L26;
        String r0 = r15.getString(0);     // Catch: Throwable -> L29
        boolean r1 = true;
        String r3 = r15.getString(1);     // Catch: Throwable -> L29
        int r4 = r15.getInt(2);     // Catch: Throwable -> L29
        if (r15.getInt(3) == 1) goto L9;
    L11:
        r1 = false;
    L12:
        String r9 = r15.getString(4);     // Catch: Throwable -> L29
        if (Intrinsics.areEqual(r0, "interests") == false) goto L16;
        r5 = r5 + 1;     // Catch: Throwable -> L29
    L16:
        if (Intrinsics.areEqual(r3, r9) == true) goto L18;
        r6 = r6 + 1;     // Catch: Throwable -> L29
    L18:
        if (r1 == false) goto L20;
    L24:
        if (r1 == false) goto L5;
        r8 = r8 + 1;     // Catch: Throwable -> L29
        goto L5
    L20:
        if (Intrinsics.areEqual(r3, r9) == false) goto L24;
        if (f9593b.contains(r3) == true) goto L24;
        r7 = r7 + 1;     // Catch: Throwable -> L29
        goto L24
    L9:
        if (r4 == 1003) goto L11;
    L26:
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L29
        CloseableKt.closeFinally(r14, null);
        return new l(r13.size(), r5, r6, r7, r8);
    L29:
        th = move-exception;
        throw th;     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        CloseableKt.closeFinally(r14, th);
        throw th;
    }

    private static final CharSequence c(long r1) {
        return (CharSequence) ZeusTransformUtils.preCheckCast("?", CharSequence.class, "com.obric.memorydata.plugin");
    }

    private final String c(SupportSQLiteDatabase r3, String r4) {
        Closeable r2 = (Closeable) ZeusTransformUtils.preCheckCast(((SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin")).query("SELECT txt FROM SemanticState WHERE `key` = ? LIMIT 1", new String[]{r4}), Closeable.class, "com.obric.memorydata.plugin");
        Cursor r5 = (Cursor) ZeusTransformUtils.preCheckCast(r2, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r5.moveToNext() == false) goto L7;
        String r6 = r5.getString(0);     // Catch: Throwable -> L10
    L8:
        CloseableKt.closeFinally(r2, null);
        return r6;
    L7:
        r6 = null;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        CloseableKt.closeFinally(r2, th);
        throw th;
    }

    private final List<Long> c(SupportSQLiteDatabase r8) {
        SupportSQLiteDatabase r7 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r8, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.listOf(new String[]{"SELECT COUNT(*) FROM UnionSemanticMemory WHERE semantic_type = 'interests'", "SELECT COUNT(*) FROM UnionSemanticMemory WHERE confidence = 0", "SELECT COUNT(*) FROM UnionSemanticMemory WHERE migration_version < 1", "SELECT COUNT(*) FROM UnionSemanticMemory WHERE product_type = 1003 AND confidence != 4.0", "SELECT COUNT(*) FROM UnionSemanticMemory WHERE user_edit = 1 AND confidence != 4.0", "SELECT COUNT(*) FROM UnionSemanticMemory WHERE confidence = 4.0 AND product_type NOT IN (1002, 1003) AND user_edit != 1"}), Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r10 = r9.iterator();
    L4:
        if (r10.hasNext() == false) goto L7;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.memorydata.plugin");
        r1.add(Long.valueOf(f9592a.d(r7, r2)));
        goto L4
    L7:
        return (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin");
    }

    private final long d(SupportSQLiteDatabase r2, String r3) {
        Closeable r1 = (Closeable) ZeusTransformUtils.preCheckCast(((SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin")).query(r3), Closeable.class, "com.obric.memorydata.plugin");
        Cursor r4 = (Cursor) ZeusTransformUtils.preCheckCast(r1, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r4.moveToNext() == false) goto L9;
        long r5 = r4.getLong(0);     // Catch: Throwable -> L10
        CloseableKt.closeFinally(r1, null);
        return r5;
    L9:
        throw new IllegalStateException("semantic migration count query failed".toString());     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        CloseableKt.closeFinally(r1, th);
        throw th;
    }

    private static final CharSequence d(long r1) {
        return (CharSequence) ZeusTransformUtils.preCheckCast("?", CharSequence.class, "com.obric.memorydata.plugin");
    }

    private final List<Long> d(SupportSQLiteDatabase r5) {
        SupportSQLiteDatabase r4 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r5, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.listOf(new String[]{"SELECT COUNT(*) FROM UnionSemanticMemory WHERE confidence = 4.0 AND product_type = 1002", "SELECT COUNT(*) FROM UnionSemanticMemory WHERE product_type IN (1005, 1006)", "SELECT COUNT(*) FROM UnionSemanticMemory WHERE tag_path = '其他'"}), Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L7;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.memorydata.plugin");
        r1.add(Long.valueOf(f9592a.d(r4, r2)));
        goto L4
    L7:
        return (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin");
    }

    private final void e(SupportSQLiteDatabase r5) {
        SupportSQLiteDatabase r6 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r5, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        r6.execSQL("INSERT OR IGNORE INTO SemanticState(`key`, num) VALUES ('migration_upgrade_fence', 0)");
        r6.execSQL("UPDATE SemanticState SET num = COALESCE((SELECT num FROM SemanticState WHERE `key` = 'change_seq'), 0) WHERE `key` = 'migration_upgrade_fence'");
        long r2 = b(r6, "migration_upgrade_fence");
        b(r6, r2);
        r6.execSQL("INSERT OR IGNORE INTO SemanticState(`key`, num) VALUES ('migration_rebuild_target', 0)");
        r6.execSQL("UPDATE SemanticState SET num = ? WHERE `key` = 'migration_rebuild_target'", new Long[]{Long.valueOf(r2)});
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.listOf(new String[]{"cursor:user_insight", "cursor:interest_summary"}), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        String r0 = (String) ZeusTransformUtils.preCheckCast(r4.next(), String.class, "com.obric.memorydata.plugin");
        r6.execSQL("INSERT OR IGNORE INTO SemanticState(`key`, num) VALUES ('" + r0 + "', 0)");
        r6.execSQL("UPDATE SemanticState SET num = 0 WHERE `key` = '" + r0 + '\'');
        goto L4
    L6:
        r6.execSQL("UPDATE SemanticState SET txt = 'rebuild' WHERE `key` = 'migration_phase'");
    }

    private final void f(SupportSQLiteDatabase r11) {
        SupportSQLiteDatabase r10 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r11, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.listOf(new Triple[]{new Triple("migration_failure_batch", 0L, ""), new Triple("migration_failure_count", 0L, null), new Triple("migration_fallback_batches", 0L, null), new Triple("migration_fallback_rows", 0L, null)}), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        Triple r1 = (Triple) ZeusTransformUtils.preCheckCast(r12.next(), Triple.class, "com.obric.memorydata.plugin");
        String r5 = (String) ZeusTransformUtils.preCheckCast(r1.component1(), String.class, "com.obric.memorydata.plugin");
        long r7 = ((Number) ZeusTransformUtils.preCheckCast(r1.component2(), Number.class, "com.obric.memorydata.plugin")).longValue();
        r10.execSQL("INSERT OR IGNORE INTO SemanticState(`key`, num, txt) VALUES (?, ?, ?)", new Object[]{r5, Long.valueOf(r7), (String) ZeusTransformUtils.preCheckCast(r1.component3(), String.class, "com.obric.memorydata.plugin")});
        goto L4
    }

    private final void g(SupportSQLiteDatabase r3) {
        SupportSQLiteDatabase r4 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        f(r4);
        r4.execSQL("UPDATE SemanticState SET txt = '' WHERE `key` = 'migration_failure_batch'");
        r4.execSQL("UPDATE SemanticState SET num = 0 WHERE `key` = 'migration_failure_count'");
    }

    private final List<Long> h(SupportSQLiteDatabase r6) {
        SupportSQLiteDatabase r5 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r6, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        List<Long> r7 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Closeable r8 = (Closeable) ZeusTransformUtils.preCheckCast(r5.query("SELECT id FROM UnionSemanticMemory WHERE semantic_type = 'interests' OR (migration_version < 1 AND confidence = 0) OR (product_type != 1003 AND tag_path != (" + c + ")) OR (product_type != 1003 AND user_edit = 1 AND migration_version < 1) ORDER BY id LIMIT 500"), Closeable.class, "com.obric.memorydata.plugin");
        Cursor r1 = (Cursor) ZeusTransformUtils.preCheckCast(r8, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
    L5:
        if (r1.moveToNext() == false) goto L7;
        ((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.memorydata.plugin")).add(Long.valueOf(r1.getLong(0)));     // Catch: Throwable -> L10
        goto L5
    L7:
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L10
        CloseableKt.closeFinally(r8, null);
        return r7;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        CloseableKt.closeFinally(r8, th);
        throw th;
    }

    private final long i(SupportSQLiteDatabase r3) {
        SupportSQLiteDatabase r2 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        r2.execSQL("INSERT OR IGNORE INTO SemanticState(`key`, num) VALUES ('change_seq', 0)");
        r2.execSQL("UPDATE SemanticState SET num = num + 1 WHERE `key` = 'change_seq'");
        Closeable r4 = (Closeable) ZeusTransformUtils.preCheckCast(r2.query("SELECT num FROM SemanticState WHERE `key` = 'change_seq' LIMIT 1"), Closeable.class, "com.obric.memorydata.plugin");
        Cursor r5 = (Cursor) ZeusTransformUtils.preCheckCast(r4, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r5.moveToNext() == false) goto L9;
        long r0 = r5.getLong(0);     // Catch: Throwable -> L10
        CloseableKt.closeFinally(r4, null);
        return r0;
    L9:
        throw new IllegalStateException("change_seq state row is unavailable".toString());     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        CloseableKt.closeFinally(r4, th);
        throw th;
    }

    public static /* synthetic */ CharSequence lambda$5Ob4vtoNC8SaztcOTQBM4o6IV_0(long r0) {
        return c(r0);
    }

    public static /* synthetic */ Unit lambda$Ai3VvKj6DL2IDxTCD6SehSusCsE(Ref.ObjectRef r0, PersonalMemoryFrameDb r1) {
        return a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$J9eok1hBIspQ_eObENWbvG--lKA, reason: not valid java name */
    public static /* synthetic */ void m572lambda$J9eok1hBIspQ_eObENWbvGlKA(PersonalMemoryFrameDb r0) {
        b(r0);
    }

    public static /* synthetic */ h lambda$QXTZxHF1EKN0QvO2Vdy2gR1Cxfc(PersonalMemoryFrameDb r0, String r1, List r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ Boolean lambda$UrzertxkYBy_8jTgDdsfkR4lRss(PersonalMemoryFrameDb r0, long r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ k lambda$_8JRIg8YgWRc4eqm896aIr0qPCA(PersonalMemoryFrameDb r0, Ref.ObjectRef r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ CharSequence lambda$_8vNgulYmYVPWV79BR6XX1iywaU(String r0) {
        return b(r0);
    }

    public static /* synthetic */ i lambda$ctCGo9nlz2TKG3QR80KZFAoh_H4(PersonalMemoryFrameDb r0) {
        return a(r0);
    }

    /* JADX INFO: renamed from: lambda$eH4GXzOIKbm_oVa9tAna-9zjNUg, reason: not valid java name */
    public static /* synthetic */ CharSequence m573lambda$eH4GXzOIKbm_oVa9tAna9zjNUg(long r0) {
        return d(r0);
    }

    public static /* synthetic */ CharSequence lambda$nlemzam8X0Qi5gU0VWQhvvHNzOk(long r0) {
        return b(r0);
    }

    public final int a(SupportSQLiteDatabase r21) {
        SupportSQLiteDatabase r1 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r21, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "database");
        long r5 = d(r1, "SELECT COUNT(*) FROM UnionSemanticMemory WHERE NOT (product_type = 1003 OR user_edit = 1) AND confidence = 3.0");
        Closeable r3 = (Closeable) ZeusTransformUtils.preCheckCast(r1.query("SELECT id FROM UnionSemanticMemory WHERE NOT (product_type = 1003 OR user_edit = 1) AND confidence = 3.0 ORDER BY modifyTime DESC, id DESC LIMIT 100"), Closeable.class, "com.obric.memorydata.plugin");
        Cursor r7 = (Cursor) ZeusTransformUtils.preCheckCast(r3, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        List r8 = CollectionsKt.createListBuilder();     // Catch: Throwable -> L16
    L5:
        if (r7.moveToNext() == false) goto L7;
        r8.add(Long.valueOf(r7.getLong(0)));     // Catch: Throwable -> L16
        goto L5
    L7:
        List r9 = CollectionsKt.build(r8);     // Catch: Throwable -> L16
        CloseableKt.closeFinally(r3, null);
        if (r9.isEmpty() == false) goto L11;
        return 0;
    L11:
        long r10 = i(r1);
        if (r5 <= 100) goto L14;
        r1.execSQL("UPDATE UnionSemanticMemory SET confidence = 2.0, confirmation_state = 'none', change_seq = ? WHERE NOT (product_type = 1003 OR user_edit = 1) AND confidence = 3.0", new Long[]{Long.valueOf(r10)});
    L14:
        String r0 = "UPDATE UnionSemanticMemory SET confidence = 3.0, confirmation_state = 'pending', change_seq = ? WHERE id IN (" + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$q$nlemzam8X0Qi5gU0VWQhvvHNzOk.INSTANCE, 30, null) + ')';
        SpreadBuilder r4 = new SpreadBuilder(2);
        r4.add(Long.valueOf(r10));
        r4.addSpread(((Collection) ZeusTransformUtils.preCheckCast(r9, Collection.class, "com.obric.memorydata.plugin")).toArray(new Long[0]));
        r1.execSQL(r0, r4.toArray(new Long[r4.size()]));
        return r9.size();
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        CloseableKt.closeFinally(r3, th);
        throw th;
    }

    public final h a(SupportSQLiteDatabase r7, String r8, List<String> r9) {
        SupportSQLiteDatabase r10 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r7, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        List<String> r11 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "database");
        Intrinsics.checkNotNullParameter(r8, "batchIdentity");
        Intrinsics.checkNotNullParameter(r11, "entityIds");
        f(r10);
        long r2 = a(r10, r8);
        if (r2 < 3) goto L5;
        List<String> r12 = a(r10, r11);
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r12, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L9;
        b(r10, r12);
        r10.execSQL("UPDATE SemanticState SET num = num + 1 WHERE `key` = 'migration_fallback_batches'");
        r10.execSQL("UPDATE SemanticState SET num = num + ? WHERE `key` = 'migration_fallback_rows'", new Integer[]{Integer.valueOf(r12.size())});
    L9:
        g(r10);
        return new h(true, 3, r12.size());
    L5:
        return new h(false, (int) r2, 0);
    }

    public final h a(List<String> r4) {
        final List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "entityIds");
        final String r5 = r.a(r3);
        final PersonalMemoryFrameDb r1 = MemoryDbEngine.INSTANCE.getPersonalDbEngine();
        return (h) ZeusTransformUtils.preCheckCast(r1.runInTransaction(new $$Lambda$q$QXTZxHF1EKN0QvO2Vdy2gR1Cxfc(r1, r5, r3)), h.class, "com.obric.memorydata.plugin");
    }

    public final Set<SemanticMigrationPhase> a() {
        return d;
    }

    public final boolean a(final long r5) {
        final PersonalMemoryFrameDb r4 = MemoryDbEngine.INSTANCE.getPersonalDbEngine();
        boolean r6 = ((Boolean) ZeusTransformUtils.preCheckCast(r4.runInTransaction(new $$Lambda$q$UrzertxkYBy_8jTgDdsfkR4lRss(r4, r5)), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        if (r6 == false) goto L5;
        SupportSQLiteDatabase r7 = r4.getOpenHelper().getWritableDatabase();
        t r8 = t.f9598a;
        JSONObject r0 = new JSONObject().put("elapsed_ms_since_start", t.f9598a.d(r7));
        Intrinsics.checkNotNullExpressionValue(r0, "put(...)");
        r8.a("l2_mig_completed", r0);
        t.f9598a.a(r7, SemanticMigrationPhase.REBUILD, SemanticMigrationPhase.COMPLETED);
    L5:
        return r6;
    }

    public final boolean a(SupportSQLiteDatabase r5, long r6) {
        SupportSQLiteDatabase r7 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r5, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "database");
        if (Intrinsics.areEqual(c(r7, "migration_phase"), SemanticMigrationPhase.REBUILD.getValue()) == true) goto L5;
    L15:
        return false;
    L5:
        if (b(r7, "migration_rebuild_target") != r6) goto L15;
        if (b(r7, "cursor:user_insight") >= r6) goto L11;
        return false;
    L11:
        if (b(r7, "cursor:interest_summary") >= r6) goto L13;
        return false;
    L13:
        r7.execSQL("UPDATE SemanticState SET txt = 'completed' WHERE `key` = 'migration_phase'");
        return true;
    }

    public final boolean a(String r2) {
        return d.contains(SemanticMigrationPhase.Companion.a(r2));
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [T, com.obric.memorydata.database.manager.p$a] */
    public final void b() {
        final PersonalMemoryFrameDb r10 = MemoryDbEngine.INSTANCE.getPersonalDbEngine();
        SemanticStateDao r0 = r10.getSemanticStateDao();
        r0.insertIfAbsent(new ik("migration_phase", 0, SemanticMigrationPhase.SCHEMA.getValue(), 2, null));
        SemanticMigrationPhase r1 = SemanticMigrationPhase.Companion.a(r0.queryText("migration_phase"));
        if (r1 != SemanticMigrationPhase.SCHEMA) goto L6;
        r0.updateText("migration_phase", SemanticMigrationPhase.PREPARE.getValue());
        t.f9598a.a(r10.getOpenHelper().getWritableDatabase(), SemanticMigrationPhase.SCHEMA, SemanticMigrationPhase.PREPARE);
    L6:
        if (r1 == SemanticMigrationPhase.SCHEMA) goto L10;
        if (r1 == SemanticMigrationPhase.PREPARE) goto L10;
        return;
    L10:
        long r2 = System.currentTimeMillis();
        final Ref.ObjectRef r3 = new Ref.ObjectRef();
        int r6 = 0;
        r3.element = new p.a(r6, r6, 3, null);
        k r4 = (k) ZeusTransformUtils.preCheckCast(r10.runInTransaction(new $$Lambda$q$_8JRIg8YgWRc4eqm896aIr0qPCA(r10, r3)), k.class, "com.obric.memorydata.plugin");
        if (((p.a) ZeusTransformUtils.preCheckCast(r3.element, p.a.class, "com.obric.memorydata.plugin")).c() <= 0) goto L13;
        EntityManager.INSTANCE.launchIndexTask();
    L13:
        l r5 = r4.b();
        if (r5 == null) goto L17;
        t.f9598a.a(r10.getOpenHelper().getWritableDatabase(), r5, RangesKt.coerceAtLeast(System.currentTimeMillis() - r2, 0));
    L17:
        if (r4.a() == false) goto L10;
        t.f9598a.a(r10.getOpenHelper().getWritableDatabase(), (p.a) ZeusTransformUtils.preCheckCast(r3.element, p.a.class, "com.obric.memorydata.plugin"));
        t.f9598a.a(r10.getOpenHelper().getWritableDatabase(), SemanticMigrationPhase.PREPARE, SemanticMigrationPhase.UPGRADE);
    }

    public final a c() {
        final PersonalMemoryFrameDb r0 = MemoryDbEngine.INSTANCE.getPersonalDbEngine();
        i r1 = (i) ZeusTransformUtils.preCheckCast(r0.runInTransaction(new $$Lambda$q$ctCGo9nlz2TKG3QR80KZFAoh_H4(r0)), i.class, "com.obric.memorydata.plugin");
        a(r0.getOpenHelper().getWritableDatabase(), r1);
        return new a(r1.a(), r1.g());
    }

    public final void d() {
        final PersonalMemoryFrameDb r1 = MemoryDbEngine.INSTANCE.getPersonalDbEngine();
        r1.runInTransaction(new $$Lambda$q$J9eok1hBIspQ_eObENWbvGlKA(r1));
    }
}
