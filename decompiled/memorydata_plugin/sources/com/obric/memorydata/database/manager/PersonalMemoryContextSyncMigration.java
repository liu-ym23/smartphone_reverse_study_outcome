package com.obric.memorydata.database.manager;

import androidx.room.migration.AutoMigrationSpec;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0011B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0000¢\u0006\u0002\b\u000bJ\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/database/manager/PersonalMemoryContextSyncMigration;", "", "<init>", "()V", "OPERATION_UPSERT", "", "OPERATION_DELETE", "ensureSemanticTriggers", "", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "ensureSemanticTriggers$database_obricRelease", "dropSemanticTriggers", "createInsertTrigger", "createUpdateDeleteOldTrigger", "createUpdateUpsertNewTrigger", "createDeleteTrigger", "AutoMigration9To10", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PersonalMemoryContextSyncMigration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PersonalMemoryContextSyncMigration f9558a = null;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/database/manager/PersonalMemoryContextSyncMigration$AutoMigration9To10;", "Landroidx/room/migration/AutoMigrationSpec;", "<init>", "()V", "onPostMigrate", "", "db", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class AutoMigration9To10 implements AutoMigrationSpec {
        public AutoMigration9To10() {
        }

        @Override // androidx.room.migration.AutoMigrationSpec
        public void onPostMigrate(SupportSQLiteDatabase r2) {
            SupportSQLiteDatabase r1 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r1, "db");
            PersonalMemoryContextSyncMigration.f9558a.a(r1);
        }
    }

    static {
        f9558a = new PersonalMemoryContextSyncMigration();
    }

    private PersonalMemoryContextSyncMigration() {
    }

    private final void b(SupportSQLiteDatabase r2) {
        SupportSQLiteDatabase r1 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        r1.execSQL("DROP TRIGGER IF EXISTS `memory_context_sync_semantic_insert`");
        r1.execSQL("DROP TRIGGER IF EXISTS `memory_context_sync_semantic_update_delete_old`");
        r1.execSQL("DROP TRIGGER IF EXISTS `memory_context_sync_semantic_update_upsert_new`");
        r1.execSQL("DROP TRIGGER IF EXISTS `memory_context_sync_semantic_delete`");
    }

    private final void c(SupportSQLiteDatabase r2) {
        ((SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin")).execSQL("CREATE TRIGGER IF NOT EXISTS `memory_context_sync_semantic_insert`\nAFTER INSERT ON `UnionSemanticMemory`\nWHEN NEW.`uuid` IS NOT NULL AND NEW.`uuid` != ''\n     AND (\n        (\n            NEW.`product_type` = 1002\n            AND NEW.`evidence_count` >= 5\n        )\n        OR NEW.`product_type` = 1003\n     )\nBEGIN\n    INSERT OR REPLACE INTO `MemoryContextSyncPending`\n        (`uuid`, `operation`, `source_update_time`)\n    VALUES (\n        NEW.`uuid`,\n        1,\n        MAX(\n            NEW.`modifyTime`,\n            CAST((julianday('now') - 2440587.5) * 86400000 AS INTEGER),\n            COALESCE((\n                SELECT `source_update_time` + 1\n                FROM `MemoryContextSyncPending`\n                WHERE `uuid` = NEW.`uuid`\n            ), 0)\n        )\n    );\nEND");
    }

    private final void d(SupportSQLiteDatabase r2) {
        ((SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin")).execSQL("CREATE TRIGGER IF NOT EXISTS `memory_context_sync_semantic_update_delete_old`\nAFTER UPDATE OF `uuid`, `product_type`, `evidence_count` ON `UnionSemanticMemory`\nWHEN OLD.`uuid` IS NOT NULL AND OLD.`uuid` != ''\n     AND (\n        (\n            OLD.`product_type` = 1002\n            AND OLD.`evidence_count` >= 5\n        )\n        OR OLD.`product_type` = 1003\n     )\n     AND (\n        NOT (\n            (\n                NEW.`product_type` = 1002\n                AND NEW.`evidence_count` >= 5\n            )\n            OR NEW.`product_type` = 1003\n        )\n        OR COALESCE(NEW.`uuid`, '') != OLD.`uuid`\n     )\nBEGIN\n    INSERT OR REPLACE INTO `MemoryContextSyncPending`\n        (`uuid`, `operation`, `source_update_time`)\n    VALUES (\n        OLD.`uuid`,\n        2,\n        MAX(\n            NEW.`modifyTime`,\n            CAST((julianday('now') - 2440587.5) * 86400000 AS INTEGER),\n            COALESCE((\n                SELECT `source_update_time` + 1\n                FROM `MemoryContextSyncPending`\n                WHERE `uuid` = OLD.`uuid`\n            ), 0)\n        )\n    );\nEND");
    }

    private final void e(SupportSQLiteDatabase r2) {
        ((SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin")).execSQL("CREATE TRIGGER IF NOT EXISTS `memory_context_sync_semantic_update_upsert_new`\nAFTER UPDATE OF `uuid`, `product_type`, `evidence_count`, `key_phrase`, `semantic_type`, `tag_path`, `user_edit`\nON `UnionSemanticMemory`\nWHEN NEW.`uuid` IS NOT NULL AND NEW.`uuid` != ''\n     AND (\n        (\n            NEW.`product_type` = 1002\n            AND NEW.`evidence_count` >= 5\n        )\n        OR NEW.`product_type` = 1003\n     )\n     AND (\n        NOT (\n            (\n                OLD.`product_type` = 1002\n                AND OLD.`evidence_count` >= 5\n            )\n            OR OLD.`product_type` = 1003\n        )\n        OR COALESCE(OLD.`uuid`, '') != NEW.`uuid`\n        OR OLD.`product_type` != NEW.`product_type`\n        OR OLD.`key_phrase` != NEW.`key_phrase`\n        OR OLD.`semantic_type` != NEW.`semantic_type`\n        OR OLD.`tag_path` != NEW.`tag_path`\n        OR OLD.`user_edit` != NEW.`user_edit`\n     )\nBEGIN\n    INSERT OR REPLACE INTO `MemoryContextSyncPending`\n        (`uuid`, `operation`, `source_update_time`)\n    VALUES (\n        NEW.`uuid`,\n        1,\n        MAX(\n            NEW.`modifyTime`,\n            CAST((julianday('now') - 2440587.5) * 86400000 AS INTEGER),\n            COALESCE((\n                SELECT `source_update_time` + 1\n                FROM `MemoryContextSyncPending`\n                WHERE `uuid` = NEW.`uuid`\n            ), 0)\n        )\n    );\nEND");
    }

    private final void f(SupportSQLiteDatabase r2) {
        ((SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin")).execSQL("CREATE TRIGGER IF NOT EXISTS `memory_context_sync_semantic_delete`\nAFTER DELETE ON `UnionSemanticMemory`\nWHEN OLD.`uuid` IS NOT NULL AND OLD.`uuid` != ''\n     AND (\n        (\n            OLD.`product_type` = 1002\n            AND OLD.`evidence_count` >= 5\n        )\n        OR OLD.`product_type` = 1003\n     )\nBEGIN\n    INSERT OR REPLACE INTO `MemoryContextSyncPending`\n        (`uuid`, `operation`, `source_update_time`)\n    VALUES (\n        OLD.`uuid`,\n        2,\n        MAX(\n            OLD.`modifyTime`,\n            CAST((julianday('now') - 2440587.5) * 86400000 AS INTEGER),\n            COALESCE((\n                SELECT `source_update_time` + 1\n                FROM `MemoryContextSyncPending`\n                WHERE `uuid` = OLD.`uuid`\n            ), 0)\n        )\n    );\nEND");
    }

    public final void a(SupportSQLiteDatabase r3) {
        SupportSQLiteDatabase r4 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "database");
        b(r4);
        c(r4);
        d(r4);
        e(r4);
        f(r4);
    }
}
