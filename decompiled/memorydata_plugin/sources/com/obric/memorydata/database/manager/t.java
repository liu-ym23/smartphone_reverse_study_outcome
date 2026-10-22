package com.obric.memorydata.database.manager;

import android.database.Cursor;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.memorydata.database.dao.SemanticStateDao;
import com.obric.memorydata.database.entity.ik;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.bdtracker.Tracker;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\rJ\u0016\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0005J\u0006\u0010\u001a\u001a\u00020\u000eJ\u000e\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u001dJ%\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!H\u0000¢\u0006\u0002\b#J\u0015\u0010$\u001a\u00020%2\u0006\u0010\u001c\u001a\u00020\u001dH\u0000¢\u0006\u0002\b&J\u0015\u0010'\u001a\u00020%2\u0006\u0010\u001c\u001a\u00020\u001dH\u0000¢\u0006\u0002\b(J%\u0010)\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020%H\u0000¢\u0006\u0002\b-J\u001d\u0010.\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010/\u001a\u000200H\u0000¢\u0006\u0002\b1J\u0006\u00102\u001a\u00020%J'\u00103\u001a\u00020\u000e2\u0018\u00104\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fH\u0000¢\u0006\u0002\b5J\u0015\u00106\u001a\u00020\u000e2\u0006\u00107\u001a\u00020\u0013H\u0000¢\u0006\u0002\b8J\r\u00109\u001a\u00020\u000eH\u0000¢\u0006\u0002\b:J\u0010\u0010;\u001a\u00020%2\u0006\u0010<\u001a\u00020\u0005H\u0002J\u0018\u0010=\u001a\u00020\u00112\u0006\u0010>\u001a\u00020\u00052\u0006\u0010?\u001a\u00020\u0005H\u0002J\u0018\u0010@\u001a\u00020%2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010A\u001a\u00020\u0005H\u0002J \u0010B\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010<\u001a\u00020\u00052\u0006\u0010C\u001a\u00020%H\u0002J \u0010D\u001a\u00020%2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010<\u001a\u00020\u00052\u0006\u0010E\u001a\u00020%H\u0002J\u0018\u0010F\u001a\u00020%2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010<\u001a\u00020\u0005H\u0002J\u001a\u0010G\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010<\u001a\u00020\u0005H\u0002J(\u0010H\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010I\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010J\u001a\u00020\rH\u0002J!\u0010K\u001a\u0013\u0012\u0004\u0012\u00020M\u0012\u0004\u0012\u00020\u000e0L¢\u0006\u0002\bN2\u0006\u0010J\u001a\u00020\rH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fX\u0082\u000e¢\u0006\u0002\n\u0000R,\u0010\u000f\u001a \u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006O"}, d2 = {"Lcom/obric/memorydata/database/manager/SemanticMigrationTracker;", "", "<init>", "()V", "TEA_EVENT", "", "debugLog", "Lcom/obric/memorydata/middleware/api/logging/ModuleLogger;", "allowedFields", "", "", "eventReporter", "Lkotlin/Function2;", "Lorg/json/JSONObject;", "", "traceReporter", "Lkotlin/Function4;", "", "failureStore", "Lcom/obric/memorydata/database/manager/MigrationFailureMarkerStore;", "report", "event", "fields", "recordMigration10To11Failure", "errorClass", "step", "reportPendingMigration10To11Failure", "markMigrationStarted", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "onDatabaseOpened", "reportPhaseTransition", "from", "Lcom/obric/memorydata/database/manager/SemanticMigrationPhase;", TypedValues.TransitionType.S_TO, "reportPhaseTransition$database_obricRelease", "nextGateAttempt", "", "nextGateAttempt$database_obricRelease", "elapsedSinceStart", "elapsedSinceStart$database_obricRelease", "recordPrepareBatch", "metrics", "Lcom/obric/memorydata/database/manager/PrepareBatchMetrics;", "durationMs", "recordPrepareBatch$database_obricRelease", "reportPrepareDone", "cleanupCounts", "Lcom/obric/memorydata/database/manager/SemanticMigrationPrepareCleanup$CleanupCounts;", "reportPrepareDone$database_obricRelease", "nextUpgradeBatchIndex", "setEventReporterForTest", "reporter", "setEventReporterForTest$database_obricRelease", "setFailureStoreForTest", "store", "setFailureStoreForTest$database_obricRelease", "resetTestOverrides", "resetTestOverrides$database_obricRelease", "nextRoomCounter", "key", "reportPhaseEnter", TypedValues.CycleType.S_WAVE_PHASE, "fromPhase", CommonConsts.COUNT_TYPE, "condition", "putState", "num", "addState", "amount", "queryNum", "queryText", "reportTrace", "isError", "payload", "traceFields", "Lkotlin/Function1;", "Lcom/obric/memorydata/middleware/api/logging/LogFieldsBuilder;", "Lkotlin/ExtensionFunctionType;", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t f9598a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final com.obric.memorydata.middleware.api.logging.o f9599b = null;
    private static final Map<String, Set<String>> c = null;
    private static Function2<? super String, ? super JSONObject, Unit> d;
    private static Function4<? super String, ? super Boolean, ? super String, ? super JSONObject, Unit> e;
    private static g f;

    static {
        t r0 = new t();
        f9598a = r0;
        f9599b = com.obric.memorydata.middleware.api.logging.n.f11627a.a("SemanticMigrationTracker");
        c = MapsKt.mapOf(new Pair[]{TuplesKt.to("l2_mig_phase_enter", SetsKt.setOf(new String[]{TypedValues.CycleType.S_WAVE_PHASE, "from_phase", "ts"})), TuplesKt.to("l2_mig_phase_duration", SetsKt.setOf(new String[]{TypedValues.CycleType.S_WAVE_PHASE, "duration_ms", "session_count"})), TuplesKt.to("l2_mig_start", SetsKt.setOf(new String[]{"total_rows", "rows_1003", "rows_user_edit", "db_version_from"})), TuplesKt.to("l2_mig_gate_open", SetsKt.setOf(new String[]{"elapsed_ms_since_start", "total_rows"})), TuplesKt.to("l2_mig_completed", SetsKt.setOf("elapsed_ms_since_start")), TuplesKt.to("l2_mig_prepare_batch", SetsKt.setOf(new String[]{"batch_index", "row_count", "duration_ms"})), TuplesKt.to("l2_mig_prepare_done", SetsKt.setOf(new String[]{"rows_type_converged", "rows_mapped", "rows_kept_原值", "rows_user_edit_finalized", "rows_pruned_1004", "rows_deduplicated"})), TuplesKt.to("l2_mig_batch_start", SetsKt.setOf(new String[]{"batch_index", "row_count", "batch_kind", "semantic_type", "tag_path", "trace_id", "log_id"})), TuplesKt.to("l2_mig_batch_success", SetsKt.setOf(new String[]{"batch_index", "row_count_in", "op_count_out", "duration_ms", "retry_round", "trace_id", "log_id"})), TuplesKt.to("l2_mig_batch_fail", SetsKt.setOf(new String[]{"batch_index", "fail_reason", "consecutive_fail_count", "trace_id", "log_id"})), TuplesKt.to("l2_mig_batch_fallback", SetsKt.setOf(new String[]{"batch_index", "row_count", "fail_reason", "trace_id", "log_id"})), TuplesKt.to("l2_mig_op_shape", SetsKt.setOf(new String[]{"batch_index", "merge_count", "merged_rows", "split_count", "split_new_rows", "delete_count", "trace_id", "log_id"})), TuplesKt.to("l2_mig_confidence_violation", SetsKt.setOf(new String[]{"entity_id", "product_type", "model_confidence"})), TuplesKt.to("l2_mig_confirmation_seed", SetsKt.setOf(new String[]{"pending_count", "c3_total"})), TuplesKt.to("l2_mig_gate_check", SetsKt.setOf(new String[]{"v1_interests_rows", "v2_confidence_zero_rows", "v3_unmigrated_rows", "v4_1003_bad_confidence_rows", "v5_useredit_bad_confidence_rows", "v6_illegal_c4_rows", "passed", "attempt", "m_c4_from_1002_rows", "m_glasses_audio_rows", "m_fallback_batches", "m_fallback_rows", "m_subtype_其他_rows"})), TuplesKt.to("l2_mig_summary_count_shrink", SetsKt.setOf(new String[]{"groups_total", "groups_count_decreased", "count_sum_before", "count_sum_after"})), TuplesKt.to("l2_mig_error", SetsKt.setOf(new String[]{TypedValues.CycleType.S_WAVE_PHASE, "error_class", "batch_index", "trace_id", "log_id"})), TuplesKt.to("l2_mig_migration_10_11_fail", SetsKt.setOf(new String[]{"error_class", "step"}))});
        d = $$Lambda$t$bbBsfIY94H0nSRnMBURSYBQBKF4.INSTANCE;
        e = (Function4) ZeusTransformUtils.preCheckCast(new SemanticMigrationTracker$traceReporter$1(r0), Function4.class, "com.obric.memorydata.plugin");
        f = (g) ZeusTransformUtils.preCheckCast(b.f9560a, g.class, "com.obric.memorydata.plugin");
    }

    private t() {
    }

    private final long a(SupportSQLiteDatabase r3, String r4) {
        Closeable r2 = (Closeable) ZeusTransformUtils.preCheckCast(((SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin")).query("SELECT COUNT(*) FROM UnionSemanticMemory WHERE " + r4), Closeable.class, "com.obric.memorydata.plugin");
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

    private final long a(String r9) {
        SemanticStateDao r8 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getSemanticStateDao();
        r8.insertIfAbsent(new ik(r9, 0, null, 6, null));
        r8.increment(r9);
        Long r10 = r8.queryNum(r9);
        if (r10 != null) goto L7;
        return 0;
    L7:
        return r10.longValue();
    }

    private static final Unit a(JSONObject r4, com.obric.memorydata.middleware.api.logging.g r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Iterator<String> r0 = r4.keys();
        Intrinsics.checkNotNullExpressionValue(r0, "keys(...)");
    L4:
        if (r0.hasNext() == false) goto L7;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r1);
        r5.a(r1, r4.opt(r1));
        goto L4
    L7:
        return Unit.INSTANCE;
    }

    private final Function1<com.obric.memorydata.middleware.api.logging.g, Unit> a(final JSONObject r1) {
        return new $$Lambda$t$VPQXEGM9E80QzDryh3Sc0Dy0YLM(r1);
    }

    private final void a(SupportSQLiteDatabase r2, String r3, long r4) {
        ((SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin")).execSQL("INSERT OR REPLACE INTO SemanticState(`key`, num, txt) VALUES (?, ?, NULL)", new Object[]{r3, Long.valueOf(r4)});
    }

    public static final /* synthetic */ void a(t r0, String r1, boolean r2, String r3, JSONObject r4) {
        r0.a(r1, r2, r3, r4);
    }

    private final void a(String r10, boolean r11, String r12, JSONObject r13) {
        Function1<com.obric.memorydata.middleware.api.logging.g, Unit> r9 = a(r13);
        if (r11 == false) goto L8;
        com.obric.memorydata.middleware.api.logging.o r0 = (com.obric.memorydata.middleware.api.logging.o) ZeusTransformUtils.preCheckCast(com.obric.memorydata.middleware.api.logging.n.f11627a, com.obric.memorydata.middleware.api.logging.o.class, "com.obric.memorydata.plugin");
        CharSequence r14 = (CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank(r14) == false) goto L7;
        r14 = r10;
    L7:
        com.obric.memorydata.middleware.api.logging.o.a(r0, "L2 semantic migration event", r10, (String) ZeusTransformUtils.preCheckCast(r14, String.class, "com.obric.memorydata.plugin"), null, null, r9, 24, null);
        return;
    L8:
        com.obric.memorydata.middleware.api.logging.o.a((com.obric.memorydata.middleware.api.logging.o) ZeusTransformUtils.preCheckCast(com.obric.memorydata.middleware.api.logging.n.f11627a, com.obric.memorydata.middleware.api.logging.o.class, "com.obric.memorydata.plugin"), "L2 semantic migration event", r10, null, r9, null, 20, null);
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

    private final long b(SupportSQLiteDatabase r5, String r6, long r7) {
        SupportSQLiteDatabase r8 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r5, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        r8.execSQL("INSERT OR IGNORE INTO SemanticState(`key`, num) VALUES (?, 0)", new String[]{r6});
        r8.execSQL("UPDATE SemanticState SET num = num + ? WHERE `key` = ?", new Object[]{Long.valueOf(r7), r6});
        return b(r8, r6);
    }

    private static final Unit b(String r1, JSONObject r2) {
        Intrinsics.checkNotNullParameter(r1, "event");
        Intrinsics.checkNotNullParameter(r2, "payload");
        Tracker.INSTANCE.reportEvent(r1, r2);
        return Unit.INSTANCE;
    }

    private final boolean b(String r3, String r4) {
        JSONObject r5 = new JSONObject().put(TypedValues.CycleType.S_WAVE_PHASE, r3).put("from_phase", r4).put("ts", System.currentTimeMillis());
        Intrinsics.checkNotNullExpressionValue(r5, "put(...)");
        return a("l2_mig_phase_enter", r5);
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

    public static /* synthetic */ Unit lambda$VPQXEGM9E80QzDryh3Sc0Dy0YLM(JSONObject r0, com.obric.memorydata.middleware.api.logging.g r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ Unit lambda$bbBsfIY94H0nSRnMBURSYBQBKF4(String r0, JSONObject r1) {
        return b(r0, r1);
    }

    public final void a() {
        String r1 = f.a();     // Catch: Throwable -> L30
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L7;
    L10:
        boolean r3 = true;
    L11:
        if (r3 == false) goto L31;
        return;
    L31:
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L15
        t r5 = (t) ZeusTransformUtils.preCheckCast(this, t.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        Object r6 = Result.m1421constructorimpl(new JSONObject(r1));     // Catch: Throwable -> L15
    L18:
        if (Result.m1427isFailureimpl(r6) == false) goto L20;
        r6 = null;
    L20:
        JSONObject r7 = (JSONObject) ZeusTransformUtils.preCheckCast(r6, JSONObject.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L23;
        return;
    L23:
        JSONObject r8 = new JSONObject().put("error_class", r7.optString("error_class", "Unknown")).put("step", r7.optString("step", "unknown"));
        Intrinsics.checkNotNullExpressionValue(r8, "put(...)");
        if (a("l2_mig_migration_10_11_fail", r8) == false) goto L37;
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L27
        t r10 = (t) ZeusTransformUtils.preCheckCast(this, t.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L27
        f.b();     // Catch: Throwable -> L27
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L27
        return;
    L27:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        return;
    L37:
        return;
    L15:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r6 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L18
    L7:
        if (StringsKt.isBlank(r2) == true) goto L10;
        r3 = false;
    }

    public final void a(SupportSQLiteDatabase r7) {
        SupportSQLiteDatabase r8 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r7, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "database");
        long r2 = System.currentTimeMillis();
        a(r8, "migration_metric_start_at", r2);
        a(r8, "migration_metric_start_reported", 0);
        a(r8, "migration_metric_session_count", 0);
        a(r8, "migration_metric_phase_start_at", r2);
        a(r8, "migration_metric_phase_start_session", 1);
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.listOf(new String[]{"migration_metric_batch_index", "migration_metric_gate_attempt", "migration_metric_prepare_batch_index"}), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        String r0 = (String) ZeusTransformUtils.preCheckCast(r6.next(), String.class, "com.obric.memorydata.plugin");
        f9598a.a(r8, r0, 0);
        goto L4
    L6:
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.listOf(new String[]{"migration_metric_prepare_type", "migration_metric_prepare_mapped", "migration_metric_prepare_kept", "migration_metric_prepare_user_edit"}), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L8:
        if (r9.hasNext() == false) goto L10;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r9.next(), String.class, "com.obric.memorydata.plugin");
        f9598a.a(r8, r1, 0);
        goto L8
    }

    public final void a(SupportSQLiteDatabase r18, SemanticMigrationPhase r19, SemanticMigrationPhase r20) {
        SupportSQLiteDatabase r1 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r18, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "database");
        Intrinsics.checkNotNullParameter(r19, "from");
        Intrinsics.checkNotNullParameter(r20, TypedValues.TransitionType.S_TO);
        long r5 = System.currentTimeMillis();
        long r7 = RangesKt.coerceAtLeast(b(r1, "migration_metric_session_count"), 1);
        long r11 = RangesKt.coerceAtLeast(b(r1, "migration_metric_phase_start_session"), 1);
        JSONObject r3 = new JSONObject().put(TypedValues.CycleType.S_WAVE_PHASE, r19.getValue()).put("duration_ms", RangesKt.coerceAtLeast(r5 - b(r1, "migration_metric_phase_start_at"), 0)).put("session_count", RangesKt.coerceAtLeast((r7 - r11) + 1, 1));
        Intrinsics.checkNotNullExpressionValue(r3, "put(...)");
        a("l2_mig_phase_duration", r3);
        b(r20.getValue(), r19.getValue());
        a(r1, "migration_metric_phase_start_at", r5);
        a(r1, "migration_metric_phase_start_session", r7);
    }

    public final void a(SupportSQLiteDatabase r6, l r7, long r8) {
        SupportSQLiteDatabase r9 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r6, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "database");
        Intrinsics.checkNotNullParameter(r7, "metrics");
        long r0 = b(r9, "migration_metric_prepare_batch_index", 1);
        b(r9, "migration_metric_prepare_type", r7.b());
        b(r9, "migration_metric_prepare_mapped", r7.c());
        b(r9, "migration_metric_prepare_kept", r7.d());
        b(r9, "migration_metric_prepare_user_edit", r7.e());
        JSONObject r10 = new JSONObject().put("batch_index", r0).put("row_count", r7.a()).put("duration_ms", r8);
        Intrinsics.checkNotNullExpressionValue(r10, "put(...)");
        a("l2_mig_prepare_batch", r10);
    }

    public final void a(SupportSQLiteDatabase r5, p.a r6) {
        SupportSQLiteDatabase r7 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r5, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "database");
        Intrinsics.checkNotNullParameter(r6, "cleanupCounts");
        JSONObject r8 = new JSONObject().put("rows_type_converged", b(r7, "migration_metric_prepare_type")).put("rows_mapped", b(r7, "migration_metric_prepare_mapped")).put("rows_kept_原值", b(r7, "migration_metric_prepare_kept")).put("rows_user_edit_finalized", b(r7, "migration_metric_prepare_user_edit")).put("rows_pruned_1004", r6.a()).put("rows_deduplicated", r6.b());
        Intrinsics.checkNotNullExpressionValue(r8, "put(...)");
        a("l2_mig_prepare_done", r8);
    }

    public final void a(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "errorClass");
        Intrinsics.checkNotNullParameter(r5, "step");
        g r0 = f;     // Catch: Throwable -> L5
        String r3 = new JSONObject().put("error_class", r4).put("step", r5).toString();     // Catch: Throwable -> L5
        Intrinsics.checkNotNullExpressionValue(r3, "toString(...)");     // Catch: Throwable -> L5
        r0.a(r3);     // Catch: Throwable -> L5
        return;
    }

    public final boolean a(String r18, JSONObject r19) {
        Intrinsics.checkNotNullParameter(r18, "event");
        Intrinsics.checkNotNullParameter(r19, "fields");
        Set<String> r1 = c.get(r18);
        if (r1 == null) goto L66;
        Set r2 = (Set) ZeusTransformUtils.preCheckCast(r1, Set.class, "com.obric.memorydata.plugin");
        JSONObject r3 = new JSONObject(r19.toString());
        if (Intrinsics.areEqual(r18, "l2_mig_batch_start") == true) goto L7;
    L9:
        Iterator<String> r4 = r3.keys();
        Intrinsics.checkNotNullExpressionValue(r4, "keys(...)");
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(SequencesKt.toSet(SequencesKt.asSequence(r4)), Iterable.class, "com.obric.memorydata.plugin");
        boolean r7 = true;
        if (ZeusTransformUtils.instanceOf(r5, Collection.class) == true) goto L12;
    L14:
        Iterator r6 = r5.iterator();
    L16:
        if (r6.hasNext() == false) goto L13;
        if (r2.contains((String) ZeusTransformUtils.preCheckCast(r6.next(), String.class, "com.obric.memorydata.plugin")) == true) goto L16;
        boolean r8 = false;
    L20:
        if (r8 == false) goto L64;
        JSONObject r9 = new JSONObject(r3.toString());
        if (Intrinsics.areEqual(r18, "l2_mig_batch_success") == false) goto L26;
        JSONObject r10 = r9.put("action", "batch_final");
        String r11 = "success";
    L24:
        r10.put("result", r11);
    L69:
        d.invoke("l2_semantic_migration", r9);     // Catch: Throwable -> L31
        boolean r12 = true;
    L67:
        Function4<? super String, ? super Boolean, ? super String, ? super JSONObject, Unit> r13 = e;     // Catch: Throwable -> L44
        if (StringsKt.endsWith$default(r18, "_fail", false, 2, null) == false) goto L35;
    L38:
        boolean r14 = true;
    L39:
        Boolean r15 = Boolean.valueOf(r14);     // Catch: Throwable -> L44
        CharSequence r16 = (CharSequence) ZeusTransformUtils.preCheckCast(r3.optString("error_class"), CharSequence.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L44
        if (StringsKt.isBlank(r16) == false) goto L42;
        r16 = r3.optString("fail_reason");     // Catch: Throwable -> L44
    L42:
        Intrinsics.checkNotNullExpressionValue(r16, "ifBlank(...)");     // Catch: Throwable -> L44
        r13.invoke(r18, r15, r16, r3);     // Catch: Throwable -> L44
    L71:
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L60
        t r20 = (t) ZeusTransformUtils.preCheckCast(this, t.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L60
        com.obric.memorydata.middleware.api.logging.o r21 = f9599b;     // Catch: Throwable -> L60
        com.obric.memorydata.middleware.api.logging.e r22 = new com.obric.memorydata.middleware.api.logging.e(null, null, null, 7, null);     // Catch: Throwable -> L60
        if (AppContext.INSTANCE.isDebug() == false) goto L58;
        String r0 = "迁移事件 event=" + r18 + " event_delivered=" + r12 + " trace_delivered=" + r7;     // Catch: Throwable -> L60
        com.obric.memorydata.middleware.api.logging.g r23 = new com.obric.memorydata.middleware.api.logging.g();     // Catch: Throwable -> L60
        Iterator<String> r24 = r3.keys();     // Catch: Throwable -> L60
        Intrinsics.checkNotNullExpressionValue(r24, "keys(...)");     // Catch: Throwable -> L60
    L49:
        if (r24.hasNext() == false) goto L57;
        String r25 = (String) ZeusTransformUtils.preCheckCast(r24.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L60
        Object r26 = r3.opt(r25);     // Catch: Throwable -> L60
        if (ZeusTransformUtils.instanceOf(r26, Number.class) == true) goto L56;
        if (ZeusTransformUtils.instanceOf(r26, Boolean.class) == true) goto L56;
        if (SetsKt.setOf(new String[]{TypedValues.CycleType.S_WAVE_PHASE, "from_phase", "batch_kind", "fail_reason", "error_class", "step"}).contains(r25) == false) goto L49;
    L56:
        Intrinsics.checkNotNull(r25);     // Catch: Throwable -> L60
        r23.a(r25, r26);     // Catch: Throwable -> L60
        goto L49
    L57:
        Unit r27 = Unit.INSTANCE;     // Catch: Throwable -> L60
        r21.a(r0, r22, r23.a());     // Catch: Throwable -> L60
    L58:
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L60
    L62:
        return r12;
    L60:
        th = move-exception;
        Result.Companion r28 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L62
    L35:
        if (StringsKt.endsWith$default(r18, "_error", false, 2, null) == true) goto L38;
        r14 = false;
    L44:
        r7 = false;
    L31:
        r12 = false;
        goto L67
    L26:
        if (Intrinsics.areEqual(r18, "l2_mig_batch_fallback") == false) goto L28;
        r10 = r9.put("action", "batch_final");
        r11 = "failure";
        goto L24
    L28:
        r9.put("action", StringsKt.removePrefix(r18, (CharSequence) ZeusTransformUtils.preCheckCast("l2_mig_", CharSequence.class, "com.obric.memorydata.plugin")));
        goto L69
    L64:
        throw new IllegalArgumentException("unsafe migration metric field".toString());
    L13:
        r8 = true;
        goto L20
    L12:
        if (((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L14;
    L7:
        if (Intrinsics.areEqual(r3.optString("batch_kind"), "tail") == false) goto L9;
        r3.remove("tag_path");
        goto L9
    L66:
        throw new IllegalArgumentException("unknown migration event".toString());
    }

    public final long b() {
        return a("migration_metric_batch_index");
    }

    public final void b(SupportSQLiteDatabase r10) {
        SupportSQLiteDatabase r11 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r10, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "database");
        a();
        String r0 = c(r11, "migration_phase");
        if (r0 != null) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(r0, SemanticMigrationPhase.COMPLETED.getValue()) == false) goto L9;
        return;
    L9:
        if (b(r11, "migration_metric_start_at") != 0) goto L11;
        a(r11);
    L11:
        b(r11, "migration_metric_session_count", 1);
        if (b(r11, "migration_metric_start_reported") == 0) goto L14;
        return;
    L14:
        JSONObject r2 = new JSONObject().put("total_rows", a(r11, "1")).put("rows_1003", a(r11, "product_type = 1003")).put("rows_user_edit", a(r11, "user_edit = 1")).put("db_version_from", 10);
        Intrinsics.checkNotNullExpressionValue(r2, "put(...)");
        boolean r3 = a("l2_mig_start", r2);
        b(r0, "");
        if (r3 == false) goto L18;
        a(r11, "migration_metric_start_reported", 1);
        return;
    }

    public final long c(SupportSQLiteDatabase r4) {
        SupportSQLiteDatabase r5 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "database");
        return b(r5, "migration_metric_gate_attempt", 1);
    }

    public final long d(SupportSQLiteDatabase r4) {
        SupportSQLiteDatabase r5 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "database");
        return RangesKt.coerceAtLeast(System.currentTimeMillis() - b(r5, "migration_metric_start_at"), 0);
    }
}
