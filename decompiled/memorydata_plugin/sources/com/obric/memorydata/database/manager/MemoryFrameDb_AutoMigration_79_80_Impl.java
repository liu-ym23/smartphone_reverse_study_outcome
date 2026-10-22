package com.obric.memorydata.database.manager;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
class MemoryFrameDb_AutoMigration_79_80_Impl extends Migration {
    public MemoryFrameDb_AutoMigration_79_80_Impl() {
        super(79, 80);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(SupportSQLiteDatabase r2) {
        SupportSQLiteDatabase r1 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        r1.execSQL("ALTER TABLE `ShortMemory` ADD COLUMN `productType` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `ScreenObservation` ADD COLUMN `filter_result` INTEGER NOT NULL DEFAULT 2");
        r1.execSQL("ALTER TABLE `ScreenObservation` ADD COLUMN `is_image_filter_finish` INTEGER NOT NULL DEFAULT 1");
        r1.execSQL("ALTER TABLE `UnionSemanticMemoryHistoryEntity` ADD COLUMN `semantic_logId` TEXT DEFAULT NULL");
        r1.execSQL("ALTER TABLE `UnionSemanticMemory` ADD COLUMN `logId` TEXT DEFAULT NULL");
        r1.execSQL("ALTER TABLE `AutoMemoryPro` ADD COLUMN `trace_id` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `AutoMemoryPro` ADD COLUMN `episodic_ids` TEXT DEFAULT NULL");
        r1.execSQL("ALTER TABLE `AutoMemoryPro` ADD COLUMN `semantic_ids` TEXT DEFAULT NULL");
        r1.execSQL("ALTER TABLE `BackUpEpisodicMemoryEntity` ADD COLUMN `backup_productType` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `EpisodicMemoryHistoryEntity` ADD COLUMN `episodic_memory_productType` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `BackUpUnionSemanticMemory` ADD COLUMN `backup_logId` TEXT DEFAULT NULL");
        r1.execSQL("ALTER TABLE `AutoMemoryProHistoryEntity` ADD COLUMN `auto_memory_pro_trace_id` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `AutoMemoryProHistoryEntity` ADD COLUMN `auto_memory_pro_episodic_ids` TEXT DEFAULT NULL");
        r1.execSQL("ALTER TABLE `AutoMemoryProHistoryEntity` ADD COLUMN `auto_memory_pro_semantic_ids` TEXT DEFAULT NULL");
        r1.execSQL("ALTER TABLE `BackUpAutoMemoryProEntity` ADD COLUMN `backup_trace_id` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `BackUpAutoMemoryProEntity` ADD COLUMN `backup_episodic_ids` TEXT DEFAULT NULL");
        r1.execSQL("ALTER TABLE `BackUpAutoMemoryProEntity` ADD COLUMN `backup_semantic_ids` TEXT DEFAULT NULL");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `AutoMemoryProSlmPersonalInfo` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `data` TEXT NOT NULL DEFAULT '')");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `AutoMemoryProSlmEpisodicMemory` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `data` TEXT NOT NULL DEFAULT '', `targetRuleId` TEXT NOT NULL DEFAULT '', `createTimestamp` INTEGER NOT NULL DEFAULT 0, `userActionTimestamp` INTEGER NOT NULL DEFAULT 0, `location` TEXT NOT NULL DEFAULT '', `locationState` TEXT NOT NULL DEFAULT '', `packageNames` TEXT NOT NULL DEFAULT '', `retryCount` INTEGER NOT NULL DEFAULT 0, `stepState` INTEGER NOT NULL DEFAULT 0, `enableState` INTEGER NOT NULL DEFAULT 0, `batch_id` TEXT DEFAULT NULL)");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `SlmAutoMemoryProTempResult` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `batch_id` TEXT NOT NULL DEFAULT '', `ruleId` TEXT NOT NULL DEFAULT '', `app_packges` TEXT NOT NULL DEFAULT '', `enable_index` INTEGER NOT NULL DEFAULT 0, `timeStamp` INTEGER NOT NULL DEFAULT 0, `data` TEXT NOT NULL DEFAULT '')");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `AutoMemoryProEvaluationStats` (`uuid` TEXT NOT NULL DEFAULT '', `stat` TEXT NOT NULL DEFAULT '', PRIMARY KEY(`uuid`))");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `BackUpAutoMemoryProSlmPersonalInfo` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `backupUserId` TEXT NOT NULL, `backupDbVersion` INTEGER NOT NULL DEFAULT 0, `backup_id` INTEGER NOT NULL, `backup_data` TEXT NOT NULL DEFAULT '')");
        r1.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_BackUpAutoMemoryProSlmPersonalInfo_backupUserId_backup_id` ON `BackUpAutoMemoryProSlmPersonalInfo` (`backupUserId`, `backup_id`)");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `BackUpAutoMemoryProSlmEpisodicMemory` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `backupUserId` TEXT NOT NULL, `backupDbVersion` INTEGER NOT NULL DEFAULT 0, `backup_id` INTEGER NOT NULL, `backup_data` TEXT NOT NULL DEFAULT '', `backup_targetRuleId` TEXT NOT NULL DEFAULT '', `backup_createTimestamp` INTEGER NOT NULL DEFAULT 0, `backup_userActionTimestamp` INTEGER NOT NULL DEFAULT 0, `backup_location` TEXT NOT NULL DEFAULT '', `backup_locationState` TEXT NOT NULL DEFAULT '', `backup_packageNames` TEXT NOT NULL DEFAULT '', `backup_retryCount` INTEGER NOT NULL DEFAULT 0, `backup_stepState` INTEGER NOT NULL DEFAULT 0, `backup_enableState` INTEGER NOT NULL DEFAULT 0, `backup_batch_id` TEXT DEFAULT NULL)");
        r1.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_BackUpAutoMemoryProSlmEpisodicMemory_backupUserId_backup_id` ON `BackUpAutoMemoryProSlmEpisodicMemory` (`backupUserId`, `backup_id`)");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `BackUpSlmAutoMemoryProTempResult` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `backupUserId` TEXT NOT NULL, `backupDbVersion` INTEGER NOT NULL DEFAULT 0, `backup_id` INTEGER NOT NULL, `backup_batch_id` TEXT NOT NULL DEFAULT '', `backup_ruleId` TEXT NOT NULL DEFAULT '', `backup_app_packges` TEXT NOT NULL DEFAULT '', `backup_enable_index` INTEGER NOT NULL DEFAULT 0, `backup_timeStamp` INTEGER NOT NULL DEFAULT 0, `backup_data` TEXT NOT NULL DEFAULT '')");
        r1.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_BackUpSlmAutoMemoryProTempResult_backupUserId_backup_id` ON `BackUpSlmAutoMemoryProTempResult` (`backupUserId`, `backup_id`)");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `BackUpAgentWatermark` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `backupUserId` TEXT NOT NULL, `backupDbVersion` INTEGER NOT NULL DEFAULT 0, `backup_rule_id` INTEGER NOT NULL, `backup_episodic_ts` INTEGER NOT NULL, `backup_semantic_ts` INTEGER NOT NULL, `backup_last_run_ms` INTEGER NOT NULL DEFAULT 0, `backup_next_run_ms` INTEGER NOT NULL DEFAULT 0, `backup_update_time_ms` INTEGER NOT NULL)");
        r1.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_BackUpAgentWatermark_backupUserId_backup_rule_id` ON `BackUpAgentWatermark` (`backupUserId`, `backup_rule_id`)");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `BackUpSlmAgentWatermark` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `backupUserId` TEXT NOT NULL, `backupDbVersion` INTEGER NOT NULL DEFAULT 0, `backup_rule_id` INTEGER NOT NULL, `backup_batch_id` TEXT NOT NULL DEFAULT '', `backup_last_run_ms` INTEGER NOT NULL DEFAULT 0, `backup_next_run_ms` INTEGER NOT NULL DEFAULT 0, `backup_update_time_ms` INTEGER NOT NULL DEFAULT 0)");
        r1.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_BackUpSlmAgentWatermark_backupUserId_backup_rule_id` ON `BackUpSlmAgentWatermark` (`backupUserId`, `backup_rule_id`)");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `AutoMemoryEpisodicRelevantData` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `memoryId` INTEGER NOT NULL, `ruleId` INTEGER NOT NULL, `createTime` INTEGER NOT NULL)");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `AutoMemorySemanticRelevantData` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `memoryId` INTEGER NOT NULL, `ruleId` INTEGER NOT NULL, `createTime` INTEGER NOT NULL)");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `BackUpAutoMemoryEpisodicRelevantData` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `backupUserId` TEXT NOT NULL, `backupDbVersion` INTEGER NOT NULL, `backup_id` INTEGER NOT NULL, `backup_memoryId` INTEGER NOT NULL, `backup_ruleId` INTEGER NOT NULL, `backup_createTime` INTEGER NOT NULL)");
        r1.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_BackUpAutoMemoryEpisodicRelevantData_backupUserId_backup_id` ON `BackUpAutoMemoryEpisodicRelevantData` (`backupUserId`, `backup_id`)");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `BackUpAutoMemorySemanticRelevantData` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `backupUserId` TEXT NOT NULL, `backupDbVersion` INTEGER NOT NULL, `backup_id` INTEGER NOT NULL, `backup_memoryId` INTEGER NOT NULL, `backup_ruleId` INTEGER NOT NULL, `backup_createTime` INTEGER NOT NULL)");
        r1.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_BackUpAutoMemorySemanticRelevantData_backupUserId_backup_id` ON `BackUpAutoMemorySemanticRelevantData` (`backupUserId`, `backup_id`)");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `AgentWatermark` (`rule_id` INTEGER NOT NULL, `episodic_ts` INTEGER NOT NULL, `semantic_ts` INTEGER NOT NULL, `last_run_ms` INTEGER NOT NULL DEFAULT 0, `next_run_ms` INTEGER NOT NULL DEFAULT 0, `update_time_ms` INTEGER NOT NULL, PRIMARY KEY(`rule_id`))");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `SlmAgentWatermark` (`rule_id` INTEGER NOT NULL, `batch_id` TEXT NOT NULL DEFAULT '', `last_run_ms` INTEGER NOT NULL DEFAULT 0, `next_run_ms` INTEGER NOT NULL DEFAULT 0, `update_time_ms` INTEGER NOT NULL DEFAULT 0, PRIMARY KEY(`rule_id`))");
        r1.execSQL("CREATE INDEX IF NOT EXISTS `index_SlmAgentWatermark_batch_id` ON `SlmAgentWatermark` (`batch_id`)");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `AutoMemoryTrace` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `timestamp` INTEGER NOT NULL, `trace` TEXT NOT NULL, `batchScreenshot` TEXT NOT NULL, `historyIds` TEXT NOT NULL)");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `_new_MemoryRule` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `title` TEXT NOT NULL, `content` TEXT NOT NULL, `appPackages` TEXT NOT NULL, `imageFilterQuery` TEXT NOT NULL DEFAULT '', `imageFilterModelVersion` TEXT NOT NULL DEFAULT '', `clientModelQuery` TEXT NOT NULL DEFAULT '', `clientModelVersion` TEXT NOT NULL DEFAULT '', `useClientModel` INTEGER NOT NULL DEFAULT 0, `memoryCount` INTEGER NOT NULL, `source` TEXT NOT NULL DEFAULT '', `triggerMode` TEXT NOT NULL DEFAULT '', `cronExpression` TEXT NOT NULL DEFAULT '')");
        r1.execSQL("INSERT INTO `_new_MemoryRule` (`id`,`title`,`content`,`appPackages`,`memoryCount`,`source`) SELECT `id`,`title`,`content`,`appPackages`,`memoryCount`,`source` FROM `MemoryRule`");
        r1.execSQL("DROP TABLE `MemoryRule`");
        r1.execSQL("ALTER TABLE `_new_MemoryRule` RENAME TO `MemoryRule`");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `_new_BacupMemoryRule` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `backupUserId` TEXT NOT NULL, `backupDbVersion` INTEGER NOT NULL DEFAULT 0, `backup_id` INTEGER NOT NULL, `backup_title` TEXT NOT NULL, `backup_content` TEXT NOT NULL, `backup_appPackages` TEXT NOT NULL, `backup_imageFilterQuery` TEXT NOT NULL DEFAULT '', `backup_imageFilterModelVersion` TEXT NOT NULL DEFAULT '', `backup_clientModelQuery` TEXT NOT NULL DEFAULT '', `backup_clientModelVersion` TEXT NOT NULL DEFAULT '', `backup_useClientModel` INTEGER NOT NULL DEFAULT 0, `backup_memoryCount` INTEGER NOT NULL, `backup_source` TEXT NOT NULL DEFAULT '', `backup_triggerMode` TEXT NOT NULL DEFAULT '', `backup_cronExpression` TEXT NOT NULL DEFAULT '')");
        r1.execSQL("INSERT INTO `_new_BacupMemoryRule` (`id`,`backupUserId`,`backupDbVersion`,`backup_id`,`backup_title`,`backup_content`,`backup_appPackages`,`backup_memoryCount`,`backup_source`) SELECT `id`,`backupUserId`,`backupDbVersion`,`backup_id`,`backup_title`,`backup_content`,`backup_appPackages`,`backup_memoryCount`,`backup_source` FROM `BacupMemoryRule`");
        r1.execSQL("DROP TABLE `BacupMemoryRule`");
        r1.execSQL("ALTER TABLE `_new_BacupMemoryRule` RENAME TO `BacupMemoryRule`");
        r1.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_BacupMemoryRule_backupUserId_backup_id` ON `BacupMemoryRule` (`backupUserId`, `backup_id`)");
    }
}
