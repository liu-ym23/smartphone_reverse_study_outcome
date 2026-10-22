package com.obric.memorydata.database.manager;

import android.database.Cursor;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u0010\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u001d\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u001e0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/obric/memorydata/database/manager/SemanticRestoreProtocol;", "", "<init>", "()V", "STATE_TABLE", "", "SEMANTIC_TABLE", "RETRACTION_TABLE", "KEYWORD_REF_TABLE", "sourceTables", "", "getSourceTables", "()Ljava/util/Set;", "appliesTo", "", "requestedTables", "", "begin", "", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "startedAtMs", "", "complete", "completeIfInterrupted", "ensureStateRows", "CONSUMER_CURSOR_KEYS", "", "MIGRATION_PROGRESS_KEYS", "REQUIRED_STATES", "Lkotlin/Triple;", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u f9600a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Set<String> f9601b = null;
    private static final List<String> c = null;
    private static final List<String> d = null;
    private static final List<Triple<String, Long, String>> e = null;

    static {
        f9600a = new u();
        f9601b = SetsKt.setOf(new String[]{"UnionSemanticMemory", "SemanticRetraction", "UserKeywordRef"});
        c = CollectionsKt.listOf(new String[]{"cursor:user_insight", "cursor:interest_summary", "cursor:dreaming"});
        d = CollectionsKt.listOf(new String[]{"migration_upgrade_fence", "migration_rebuild_target"});
        e = CollectionsKt.listOf(new Triple[]{new Triple("change_seq", 0L, null), new Triple("restore_phase", 0L, "completed"), new Triple("migration_phase", 0L, "completed"), new Triple("cursor:user_insight", 0L, null), new Triple("cursor:interest_summary", 0L, null), new Triple("cursor:dreaming", 0L, null), new Triple("migration_upgrade_fence", 0L, null), new Triple("migration_rebuild_target", 0L, null)});
    }

    private u() {
    }

    public static /* synthetic */ void a(u r1, SupportSQLiteDatabase r2, long r3, int r5, Object r6) {
        SupportSQLiteDatabase r4 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L5;
        r3 = System.currentTimeMillis();
    L5:
        r1.a(r4, r3);
    }

    private final void c(SupportSQLiteDatabase r8) {
        SupportSQLiteDatabase r7 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r8, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(e, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r9.hasNext() == false) goto L6;
        Triple r1 = (Triple) ZeusTransformUtils.preCheckCast(r9.next(), Triple.class, "com.obric.memorydata.plugin");
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.component1(), String.class, "com.obric.memorydata.plugin");
        long r3 = ((Number) ZeusTransformUtils.preCheckCast(r1.component2(), Number.class, "com.obric.memorydata.plugin")).longValue();
        r7.execSQL("INSERT OR IGNORE INTO SemanticState(`key`, num, txt) VALUES (?, ?, ?)", new Object[]{r2, Long.valueOf(r3), (String) ZeusTransformUtils.preCheckCast(r1.component3(), String.class, "com.obric.memorydata.plugin")});
        goto L4
    }

    public final void a(SupportSQLiteDatabase r6) {
        SupportSQLiteDatabase r7 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r6, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "database");
        c(r7);
        String r5 = s.f9596a.b();
        r7.execSQL("UPDATE SemanticState SET num = MAX(\n                num,\n                COALESCE((SELECT MAX(change_seq) FROM UnionSemanticMemory), 0),\n                COALESCE((SELECT MAX(change_seq) FROM SemanticRetraction), 0)\n            ) WHERE `key` = 'change_seq'");
        r7.execSQL(StringsKt.trimIndent("UPDATE SemanticState SET num = num + 1\n                WHERE `key` = 'change_seq'\n                  AND EXISTS (\n                    SELECT 1 FROM UnionSemanticMemory\n                    WHERE product_type = 1003\n                      AND (confidence != 4.0\n                        OR confirmation_state != 'none'\n                        OR description != '用户主动记忆'\n                        OR migration_version < 1\n                        OR tag_path != (" + r5 + "))\n                  )"));
        r7.execSQL(StringsKt.trimIndent("UPDATE UnionSemanticMemory\n                SET confidence = 4.0,\n                    confirmation_state = 'none',\n                    description = '用户主动记忆',\n                    migration_version = MAX(migration_version, 1),\n                    tag_path = " + r5 + ",\n                    change_seq = (SELECT num FROM SemanticState WHERE `key` = 'change_seq')\n                WHERE product_type = 1003\n                  AND (confidence != 4.0\n                    OR confirmation_state != 'none'\n                    OR description != '用户主动记忆'\n                    OR migration_version < 1\n                    OR tag_path != (" + r5 + "))"));
        r7.execSQL("DELETE FROM MemoryProcessUserInsight");
        r7.execSQL("DELETE FROM UnionSemanticTypeSummary");
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(c, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        r7.execSQL("UPDATE SemanticState SET num = 0 WHERE `key` = '" + ((String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.memorydata.plugin")) + '\'');
        goto L4
    L6:
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(d, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L8:
        if (r9.hasNext() == false) goto L10;
        r7.execSQL("UPDATE SemanticState SET num = 0 WHERE `key` = '" + ((String) ZeusTransformUtils.preCheckCast(r9.next(), String.class, "com.obric.memorydata.plugin")) + '\'');
        goto L8
    L10:
        r7.execSQL("UPDATE SemanticState SET txt = 'schema'\n                WHERE `key` = 'migration_phase'\n                  AND EXISTS (SELECT 1 FROM UnionSemanticMemory WHERE migration_version < 1)");
        r7.execSQL("UPDATE SemanticState SET txt = 'completed' WHERE `key` = 'restore_phase'");
    }

    public final void a(SupportSQLiteDatabase r3, long r4) {
        SupportSQLiteDatabase r5 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "database");
        c(r5);
        r5.execSQL("INSERT OR REPLACE INTO SemanticState(`key`, num) SELECT ?, ? WHERE NOT EXISTS (SELECT 1 FROM SemanticState WHERE `key` = 'restore_phase' AND txt = 'running')", new Object[]{"migration_started_at_ms", Long.valueOf(r4)});
        r5.execSQL("UPDATE SemanticState SET txt = 'running' WHERE `key` = 'restore_phase'");
        r5.execSQL("DELETE FROM UserKeywordRef");
        r5.execSQL("DELETE FROM SemanticRetraction");
        r5.execSQL("DELETE FROM UnionSemanticMemory");
    }

    public final boolean a(Collection<String> r2) {
        Collection r1 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "requestedTables");
        return r1.contains("UnionSemanticMemory");
    }

    public final void b(SupportSQLiteDatabase r5) {
        SupportSQLiteDatabase r6 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r5, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "database");
        Closeable r0 = (Closeable) ZeusTransformUtils.preCheckCast(r6.query("SELECT txt FROM SemanticState WHERE `key` = 'restore_phase' LIMIT 1"), Closeable.class, "com.obric.memorydata.plugin");
        Cursor r1 = (Cursor) ZeusTransformUtils.preCheckCast(r0, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
        if (r1.moveToNext() == false) goto L7;
        String r2 = r1.getString(0);     // Catch: Throwable -> L12
    L8:
        CloseableKt.closeFinally(r0, null);
        if (Intrinsics.areEqual(r2, "running") == false) goto L21;
        a(r6);
        return;
    L21:
        return;
    L7:
        r2 = null;
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        CloseableKt.closeFinally(r0, th);
        throw th;
    }
}
