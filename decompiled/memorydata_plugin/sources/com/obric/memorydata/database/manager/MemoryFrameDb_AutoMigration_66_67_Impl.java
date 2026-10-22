package com.obric.memorydata.database.manager;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
class MemoryFrameDb_AutoMigration_66_67_Impl extends Migration {
    public MemoryFrameDb_AutoMigration_66_67_Impl() {
        super(66, 67);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(SupportSQLiteDatabase r2) {
        SupportSQLiteDatabase r1 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `UnionSemanticMemory` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `entityId` TEXT NOT NULL, `createTime` INTEGER NOT NULL, `modifyTime` INTEGER NOT NULL, `type` INTEGER NOT NULL, `timestamp` INTEGER NOT NULL, `packageName` TEXT NOT NULL, `hashCodeValue` INTEGER NOT NULL, `uuid` TEXT, `semantic_type` TEXT NOT NULL, `tag_path` TEXT NOT NULL, `key_phrase` TEXT NOT NULL, `description` TEXT NOT NULL, `embedding_content` TEXT NOT NULL, `sources` TEXT NOT NULL, `user_edit` INTEGER NOT NULL, `evidence_count` INTEGER NOT NULL, `product_type` INTEGER NOT NULL)");
        r1.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_UnionSemanticMemory_entityId` ON `UnionSemanticMemory` (`entityId`)");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `ProactiveSemanticRelevantData` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `semantic_id` TEXT NOT NULL, `source_query` TEXT, `source_text` TEXT, `source_screenshot` TEXT, `source_app_name` TEXT, `source_package_name` TEXT, `detail_status` INTEGER NOT NULL, FOREIGN KEY(`semantic_id`) REFERENCES `UnionSemanticMemory`(`entityId`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        r1.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_ProactiveSemanticRelevantData_semantic_id` ON `ProactiveSemanticRelevantData` (`semantic_id`)");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `SemanticTextCopilot` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `rawDbId` INTEGER NOT NULL, `rawDbColumn` TEXT NOT NULL, `text` TEXT NOT NULL)");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `PendingContext` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `context_id` TEXT NOT NULL, `source_type` TEXT NOT NULL, `messages_json` TEXT NOT NULL, `expires_at_ms` INTEGER NOT NULL, `state` TEXT NOT NULL, `session_id` TEXT NOT NULL DEFAULT '', `pre_build_time` INTEGER NOT NULL DEFAULT 0, `extra` TEXT NOT NULL DEFAULT '')");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `PendingEpisodic` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `context_id` TEXT NOT NULL, `state` TEXT NOT NULL, `lease_until_ms` INTEGER NOT NULL, `retry_count` INTEGER NOT NULL, `last_error_code` INTEGER NOT NULL, `business_type` TEXT NOT NULL DEFAULT '')");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `PendingSemantic` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `context_id` TEXT NOT NULL, `state` TEXT NOT NULL, `lease_until_ms` INTEGER NOT NULL, `retry_count` INTEGER NOT NULL, `last_error_code` INTEGER NOT NULL, `business_type` TEXT NOT NULL DEFAULT '')");
    }
}
