package com.obric.memorydata.database.manager;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
class MemoryFrameDb_AutoMigration_92_93_Impl extends Migration {
    public MemoryFrameDb_AutoMigration_92_93_Impl() {
        super(92, 93);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(SupportSQLiteDatabase r2) {
        SupportSQLiteDatabase r1 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        r1.execSQL("ALTER TABLE `MiddleUserProfile` ADD COLUMN `personalDbSplitMigrated` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `UserProfile` ADD COLUMN `personalDbSplitMigrated` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `ShortMemory` ADD COLUMN `personalDbSplitMigrated` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `ShortMemoryTextVectorCopilot` ADD COLUMN `personalDbSplitMigrated` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `RawMemoryEntityCorrelation` ADD COLUMN `personalDbSplitMigrated` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `ShortMemoryContentTime` ADD COLUMN `personalDbSplitMigrated` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `Lifelog` ADD COLUMN `personalDbSplitMigrated` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `UserProfileMemoryEntity` ADD COLUMN `personalDbSplitMigrated` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `PendingMemoryCalendar` ADD COLUMN `personalDbSplitMigrated` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `MemoryEntityToCalendar` ADD COLUMN `personalDbSplitMigrated` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `BlockMemoryContent` ADD COLUMN `personalDbSplitMigrated` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `UnionSemanticMemoryHistoryEntity` ADD COLUMN `semantic_personalDbSplitMigrated` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `EpisodicTopicMemory` ADD COLUMN `personalDbSplitMigrated` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `EpisodicTopicMemoryTextVectorCopilot` ADD COLUMN `personalDbSplitMigrated` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `UserProfileEntityTextVectorCopilot` ADD COLUMN `personalDbSplitMigrated` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `RawUserProfileEntity` ADD COLUMN `personalDbSplitMigrated` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `LifeLogEntityTextVectorCopilot` ADD COLUMN `personalDbSplitMigrated` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `MemoryKeyInfoEntity` ADD COLUMN `personalDbSplitMigrated` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `UserKeyword` ADD COLUMN `personalDbSplitMigrated` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `AssistantChatMessageEntity` ADD COLUMN `personalDbSplitMigrated` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `UnionSemanticMemory` ADD COLUMN `personalDbSplitMigrated` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `UnionSemanticMemoryExt` ADD COLUMN `personalDbSplitMigrated` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `ProactiveEpisodicRelevantData` ADD COLUMN `personalDbSplitMigrated` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `ProactiveSemanticRelevantData` ADD COLUMN `personalDbSplitMigrated` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `UpdateUnionSemanticMemory` ADD COLUMN `personalDbSplitMigrated` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `UpdateProactiveSemanticRelevantData` ADD COLUMN `personalDbSplitMigrated` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `SemanticTextCopilot` ADD COLUMN `personalDbSplitMigrated` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `PendingEpisodic` ADD COLUMN `personalDbSplitMigrated` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `MemoryRule` ADD COLUMN `personalDbSplitMigrated` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `AutoMemoryPro` ADD COLUMN `personalDbSplitMigrated` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `AutoMemoryProSlmPersonalInfo` ADD COLUMN `personalDbSplitMigrated` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `AutoMemoryProSlmEpisodicMemory` ADD COLUMN `personalDbSplitMigrated` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `SlmAutoMemoryProTempResult` ADD COLUMN `personalDbSplitMigrated` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `BackUpBlockMemoryContent` ADD COLUMN `backup_personalDbSplitMigrated` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `BackUpEpisodicMemoryEntity` ADD COLUMN `backup_personalDbSplitMigrated` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `BackUpEpisodicTopicMemory` ADD COLUMN `backup_personalDbSplitMigrated` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `BackUpLifelog` ADD COLUMN `backup_personalDbSplitMigrated` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `BackUpRawMemoryEntityCorrelation` ADD COLUMN `backup_personalDbSplitMigrated` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `BackUpMemoryEntityToCalendar` ADD COLUMN `backup_personalDbSplitMigrated` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `BackUpMemoryKeyInfoEntity` ADD COLUMN `backup_personalDbSplitMigrated` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `BackUpPendingMemoryCalendar` ADD COLUMN `backup_personalDbSplitMigrated` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `BackUpRawUserProfileEntity` ADD COLUMN `backup_personalDbSplitMigrated` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `EpisodicMemoryHistoryEntity` ADD COLUMN `episodic_memory_personalDbSplitMigrated` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `EpisodicTopicMemoryHistoryEntity` ADD COLUMN `episodic_topic_memory_personalDbSplitMigrated` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `LifelogHistoryEntity` ADD COLUMN `lifelog_personalDbSplitMigrated` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `RawUserProfileHistoryEntity` ADD COLUMN `user_profile_personalDbSplitMigrated` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `BackUpProactiveSemanticRelevantData` ADD COLUMN `backup_personalDbSplitMigrated` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `BackUpProactiveEpisodicRelevantData` ADD COLUMN `backup_personalDbSplitMigrated` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `BackUpUnionSemanticMemory` ADD COLUMN `backup_personalDbSplitMigrated` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `BackUpUpdateUnionSemanticMemory` ADD COLUMN `backup_personalDbSplitMigrated` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `BackUpUpdateProactiveSemanticRelevantData` ADD COLUMN `backup_personalDbSplitMigrated` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `AutoMemoryProHistoryEntity` ADD COLUMN `auto_memory_pro_personalDbSplitMigrated` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `AutoMemoryProTextVectorCopilot` ADD COLUMN `personalDbSplitMigrated` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `BackUpAutoMemoryProEntity` ADD COLUMN `backup_personalDbSplitMigrated` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `BackUpAutoMemoryProSlmPersonalInfo` ADD COLUMN `backup_personalDbSplitMigrated` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `BackUpAutoMemoryProSlmEpisodicMemory` ADD COLUMN `backup_personalDbSplitMigrated` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `BackUpSlmAutoMemoryProTempResult` ADD COLUMN `backup_personalDbSplitMigrated` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `BackUpAgentWatermark` ADD COLUMN `backup_personalDbSplitMigrated` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `BackUpSlmAgentWatermark` ADD COLUMN `backup_personalDbSplitMigrated` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `BacupMemoryRule` ADD COLUMN `backup_personalDbSplitMigrated` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `UnionSemanticTypeSummary` ADD COLUMN `personalDbSplitMigrated` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `AutoMemoryEpisodicRelevantData` ADD COLUMN `personalDbSplitMigrated` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `AutoMemorySemanticRelevantData` ADD COLUMN `personalDbSplitMigrated` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `MemoryBaseScene` ADD COLUMN `personalDbSplitMigrated` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `MemoryBaseRequirement` ADD COLUMN `personalDbSplitMigrated` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `AutoMemoryProSnapShot` ADD COLUMN `personalDbSplitMigrated` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `UnionSemanticMemorySnapShot` ADD COLUMN `personalDbSplitMigrated` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `MemoryReviewFeedback` ADD COLUMN `personalDbSplitMigrated` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `AgentWatermark` ADD COLUMN `personalDbSplitMigrated` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `SlmAgentWatermark` ADD COLUMN `personalDbSplitMigrated` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `_new_MetaFullContentKeywordCopilot` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `type` INTEGER NOT NULL, `rawDbId` INTEGER NOT NULL, `uid` TEXT NOT NULL DEFAULT '')");
        r1.execSQL("INSERT INTO `_new_MetaFullContentKeywordCopilot` (`id`,`type`,`rawDbId`) SELECT `id`,`type`,`rawDbId` FROM `MetaFullContentKeywordCopilot`");
        r1.execSQL("DROP TABLE `MetaFullContentKeywordCopilot`");
        r1.execSQL("ALTER TABLE `_new_MetaFullContentKeywordCopilot` RENAME TO `MetaFullContentKeywordCopilot`");
        r1.execSQL("CREATE INDEX IF NOT EXISTS `index_MetaFullContentKeywordCopilot_rawDbId_type_uid` ON `MetaFullContentKeywordCopilot` (`rawDbId`, `type`, `uid`)");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `_new_BackUpAutoMemoryEpisodicRelevantData` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `backupUserId` TEXT NOT NULL, `backupDbVersion` INTEGER NOT NULL DEFAULT 0, `backup_id` INTEGER NOT NULL, `backup_memoryId` INTEGER NOT NULL, `backup_ruleId` INTEGER NOT NULL, `backup_createTime` INTEGER NOT NULL, `backup_sourceType` TEXT NOT NULL DEFAULT 'screen_observation', `backup_personalDbSplitMigrated` INTEGER NOT NULL DEFAULT 0)");
        r1.execSQL("INSERT INTO `_new_BackUpAutoMemoryEpisodicRelevantData` (`id`,`backupUserId`,`backupDbVersion`,`backup_id`,`backup_memoryId`,`backup_ruleId`,`backup_createTime`,`backup_sourceType`) SELECT `id`,`backupUserId`,`backupDbVersion`,`backup_id`,`backup_memoryId`,`backup_ruleId`,`backup_createTime`,`backup_sourceType` FROM `BackUpAutoMemoryEpisodicRelevantData`");
        r1.execSQL("DROP TABLE `BackUpAutoMemoryEpisodicRelevantData`");
        r1.execSQL("ALTER TABLE `_new_BackUpAutoMemoryEpisodicRelevantData` RENAME TO `BackUpAutoMemoryEpisodicRelevantData`");
        r1.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_BackUpAutoMemoryEpisodicRelevantData_backupUserId_backup_id` ON `BackUpAutoMemoryEpisodicRelevantData` (`backupUserId`, `backup_id`)");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `_new_BackUpAutoMemorySemanticRelevantData` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `backupUserId` TEXT NOT NULL, `backupDbVersion` INTEGER NOT NULL DEFAULT 0, `backup_id` INTEGER NOT NULL, `backup_memoryId` INTEGER NOT NULL, `backup_ruleId` INTEGER NOT NULL, `backup_createTime` INTEGER NOT NULL, `backup_sourceType` TEXT NOT NULL DEFAULT 'screen_observation', `backup_personalDbSplitMigrated` INTEGER NOT NULL DEFAULT 0)");
        r1.execSQL("INSERT INTO `_new_BackUpAutoMemorySemanticRelevantData` (`id`,`backupUserId`,`backupDbVersion`,`backup_id`,`backup_memoryId`,`backup_ruleId`,`backup_createTime`,`backup_sourceType`) SELECT `id`,`backupUserId`,`backupDbVersion`,`backup_id`,`backup_memoryId`,`backup_ruleId`,`backup_createTime`,`backup_sourceType` FROM `BackUpAutoMemorySemanticRelevantData`");
        r1.execSQL("DROP TABLE `BackUpAutoMemorySemanticRelevantData`");
        r1.execSQL("ALTER TABLE `_new_BackUpAutoMemorySemanticRelevantData` RENAME TO `BackUpAutoMemorySemanticRelevantData`");
        r1.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_BackUpAutoMemorySemanticRelevantData_backupUserId_backup_id` ON `BackUpAutoMemorySemanticRelevantData` (`backupUserId`, `backup_id`)");
    }
}
