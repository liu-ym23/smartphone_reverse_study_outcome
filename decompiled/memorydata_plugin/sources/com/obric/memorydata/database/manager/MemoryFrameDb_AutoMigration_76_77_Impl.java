package com.obric.memorydata.database.manager;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
class MemoryFrameDb_AutoMigration_76_77_Impl extends Migration {
    public MemoryFrameDb_AutoMigration_76_77_Impl() {
        super(76, 77);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(SupportSQLiteDatabase r2) {
        SupportSQLiteDatabase r1 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        r1.execSQL("ALTER TABLE `UnionSemanticMemoryHistoryEntity` ADD COLUMN `semantic_use_for_insight` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `UnionSemanticMemoryHistoryEntity` ADD COLUMN `semantic_confidence` REAL NOT NULL DEFAULT 0.0");
        r1.execSQL("ALTER TABLE `UnionSemanticMemory` ADD COLUMN `use_for_insight` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `UnionSemanticMemory` ADD COLUMN `confidence` REAL NOT NULL DEFAULT 0.0");
        r1.execSQL("ALTER TABLE `BackUpBlockMemoryContent` ADD COLUMN `backupDbVersion` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `BackUpEpisodicMemoryEntity` ADD COLUMN `backupDbVersion` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `BackUpEpisodicTopicMemory` ADD COLUMN `backupDbVersion` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `BackUpLifelog` ADD COLUMN `backupDbVersion` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `BackUpRawMemoryEntityCorrelation` ADD COLUMN `backupDbVersion` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `BackUpMemoryEntityToCalendar` ADD COLUMN `backupDbVersion` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `BackUpMemoryKeyInfoEntity` ADD COLUMN `backupDbVersion` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `BackUpPendingMemoryCalendar` ADD COLUMN `backupDbVersion` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `BackUpRawMemoryEntity` ADD COLUMN `backupDbVersion` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `BackUpRawUserProfileEntity` ADD COLUMN `backupDbVersion` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `BackUpProactiveSemanticRelevantData` ADD COLUMN `backupDbVersion` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `BackUpUnionSemanticMemory` ADD COLUMN `backupDbVersion` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `BackUpUnionSemanticMemory` ADD COLUMN `backup_use_for_insight` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `BackUpUnionSemanticMemory` ADD COLUMN `backup_confidence` REAL NOT NULL DEFAULT 0.0");
        r1.execSQL("ALTER TABLE `BackUpAutoMemoryProEntity` ADD COLUMN `backupDbVersion` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `BacupMemoryRule` ADD COLUMN `backupDbVersion` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `UpdateUnionSemanticMemory` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `entityId` TEXT NOT NULL, `createTime` INTEGER NOT NULL, `modifyTime` INTEGER NOT NULL, `type` INTEGER NOT NULL, `timestamp` INTEGER NOT NULL, `packageName` TEXT NOT NULL, `hashCodeValue` INTEGER NOT NULL, `uuid` TEXT, `semantic_type` TEXT NOT NULL, `tag_path` TEXT NOT NULL, `key_phrase` TEXT NOT NULL, `description` TEXT NOT NULL, `embedding_content` TEXT NOT NULL, `sources` TEXT NOT NULL, `user_edit` INTEGER NOT NULL, `evidence_count` INTEGER NOT NULL, `product_type` INTEGER NOT NULL, `use_for_insight` INTEGER NOT NULL DEFAULT 0, `confidence` REAL NOT NULL DEFAULT 0.0, `updateResult` TEXT NOT NULL DEFAULT '', `isUpdated` INTEGER NOT NULL DEFAULT 0, `retryTime` INTEGER NOT NULL DEFAULT 0, `lastExecuteUpdateTimestamp` INTEGER NOT NULL DEFAULT 0)");
        r1.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_UpdateUnionSemanticMemory_entityId` ON `UpdateUnionSemanticMemory` (`entityId`)");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `UpdateProactiveSemanticRelevantData` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `semantic_id` TEXT NOT NULL, `source_query` TEXT, `source_text` TEXT, `source_screenshot` TEXT, `source_app_name` TEXT, `source_package_name` TEXT, `detail_status` INTEGER NOT NULL, FOREIGN KEY(`semantic_id`) REFERENCES `UpdateUnionSemanticMemory`(`entityId`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        r1.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_UpdateProactiveSemanticRelevantData_semantic_id` ON `UpdateProactiveSemanticRelevantData` (`semantic_id`)");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `BackUpUpdateUnionSemanticMemory` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `backupUserId` TEXT NOT NULL, `backupDbVersion` INTEGER NOT NULL DEFAULT 0, `backup_id` INTEGER NOT NULL, `backup_entityId` TEXT NOT NULL, `backup_createTime` INTEGER NOT NULL, `backup_modifyTime` INTEGER NOT NULL, `backup_type` INTEGER NOT NULL, `backup_timestamp` INTEGER NOT NULL, `backup_packageName` TEXT NOT NULL, `backup_hashCodeValue` INTEGER NOT NULL, `backup_uuid` TEXT, `backup_semantic_type` TEXT NOT NULL, `backup_tag_path` TEXT NOT NULL, `backup_key_phrase` TEXT NOT NULL, `backup_description` TEXT NOT NULL, `backup_embedding_content` TEXT NOT NULL, `backup_sources` TEXT NOT NULL, `backup_user_edit` INTEGER NOT NULL, `backup_evidence_count` INTEGER NOT NULL, `backup_product_type` INTEGER NOT NULL, `backup_use_for_insight` INTEGER NOT NULL DEFAULT 0, `backup_confidence` REAL NOT NULL DEFAULT 0.0, `backup_updateResult` TEXT NOT NULL DEFAULT '', `backup_isUpdated` INTEGER NOT NULL DEFAULT 0, `backup_retryTime` INTEGER NOT NULL DEFAULT 0, `backup_lastExecuteUpdateTimestamp` INTEGER NOT NULL DEFAULT 0)");
        r1.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_BackUpUpdateUnionSemanticMemory_backupUserId_backup_id` ON `BackUpUpdateUnionSemanticMemory` (`backupUserId`, `backup_id`)");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `BackUpUpdateProactiveSemanticRelevantData` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `backupUserId` TEXT NOT NULL, `backupDbVersion` INTEGER NOT NULL DEFAULT 0, `backup_id` INTEGER NOT NULL, `backup_semantic_id` TEXT NOT NULL, `backup_source_query` TEXT, `backup_source_text` TEXT, `backup_source_screenshot` TEXT, `backup_source_app_name` TEXT, `backup_source_package_name` TEXT, `backup_detail_status` INTEGER NOT NULL)");
        r1.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_BackUpUpdateProactiveSemanticRelevantData_backupUserId_backup_id` ON `BackUpUpdateProactiveSemanticRelevantData` (`backupUserId`, `backup_id`)");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `UnionSemanticTypeSummary` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `type` TEXT NOT NULL, `treePath` TEXT NOT NULL, `summary` TEXT NOT NULL, `description` TEXT NOT NULL, `count` INTEGER NOT NULL, `createTime` INTEGER NOT NULL, `modifyTime` INTEGER NOT NULL)");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `UnionUserInsight` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `summary` TEXT NOT NULL, `description` TEXT NOT NULL, `createTime` INTEGER NOT NULL)");
    }
}
