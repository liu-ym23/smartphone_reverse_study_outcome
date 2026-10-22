package com.obric.memorydata.database.manager;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
class MemoryFrameDb_AutoMigration_84_85_Impl extends Migration {
    public MemoryFrameDb_AutoMigration_84_85_Impl() {
        super(84, 85);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(SupportSQLiteDatabase r2) {
        SupportSQLiteDatabase r1 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        r1.execSQL("ALTER TABLE `ScreenObservation` ADD COLUMN `rule_ids` TEXT NOT NULL DEFAULT 'ALL'");
        r1.execSQL("ALTER TABLE `ScreenObservation` ADD COLUMN `activity_name` TEXT DEFAULT NULL");
        r1.execSQL("ALTER TABLE `MemoryRule` ADD COLUMN `memoryInfoJson` TEXT NOT NULL DEFAULT ''");
        r1.execSQL("ALTER TABLE `MemoryRule` ADD COLUMN `isPaused` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `MemoryRule` ADD COLUMN `isFromPreset` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `MemoryRule` ADD COLUMN `canDisplay` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `MemoryRule` ADD COLUMN `ruleSettingsVersion` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `MemoryRule` ADD COLUMN `activeStartMinute` INTEGER NOT NULL DEFAULT -1");
        r1.execSQL("ALTER TABLE `MemoryRule` ADD COLUMN `activeEndMinute` INTEGER NOT NULL DEFAULT -1");
        r1.execSQL("ALTER TABLE `MemoryRule` ADD COLUMN `iconKey` TEXT NOT NULL DEFAULT ''");
        r1.execSQL("ALTER TABLE `MemoryRule` ADD COLUMN `iconColorKey` TEXT NOT NULL DEFAULT ''");
        r1.execSQL("ALTER TABLE `MemoryRule` ADD COLUMN `iconGenerateVersion` TEXT NOT NULL DEFAULT ''");
        r1.execSQL("ALTER TABLE `MemoryRule` ADD COLUMN `lastExposedAutoMemoryId` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `BacupMemoryRule` ADD COLUMN `backup_memoryInfoJson` TEXT NOT NULL DEFAULT ''");
        r1.execSQL("ALTER TABLE `BacupMemoryRule` ADD COLUMN `backup_isPaused` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `BacupMemoryRule` ADD COLUMN `backup_isFromPreset` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `BacupMemoryRule` ADD COLUMN `backup_canDisplay` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `BacupMemoryRule` ADD COLUMN `backup_ruleSettingsVersion` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `BacupMemoryRule` ADD COLUMN `backup_activeStartMinute` INTEGER NOT NULL DEFAULT -1");
        r1.execSQL("ALTER TABLE `BacupMemoryRule` ADD COLUMN `backup_activeEndMinute` INTEGER NOT NULL DEFAULT -1");
        r1.execSQL("ALTER TABLE `BacupMemoryRule` ADD COLUMN `backup_iconKey` TEXT NOT NULL DEFAULT ''");
        r1.execSQL("ALTER TABLE `BacupMemoryRule` ADD COLUMN `backup_iconColorKey` TEXT NOT NULL DEFAULT ''");
        r1.execSQL("ALTER TABLE `BacupMemoryRule` ADD COLUMN `backup_iconGenerateVersion` TEXT NOT NULL DEFAULT ''");
        r1.execSQL("ALTER TABLE `BacupMemoryRule` ADD COLUMN `backup_lastExposedAutoMemoryId` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `AutoMemoryEpisodicRelevantData` ADD COLUMN `sourceType` TEXT NOT NULL DEFAULT 'screen_observation'");
        r1.execSQL("ALTER TABLE `AutoMemorySemanticRelevantData` ADD COLUMN `sourceType` TEXT NOT NULL DEFAULT 'screen_observation'");
        r1.execSQL("ALTER TABLE `BackUpAutoMemoryEpisodicRelevantData` ADD COLUMN `backup_sourceType` TEXT NOT NULL DEFAULT 'screen_observation'");
        r1.execSQL("ALTER TABLE `BackUpAutoMemorySemanticRelevantData` ADD COLUMN `backup_sourceType` TEXT NOT NULL DEFAULT 'screen_observation'");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `AutoMemoryProRawSource` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `target` TEXT NOT NULL DEFAULT 'cloud_model', `sourceType` TEXT NOT NULL, `sourceKey` TEXT NOT NULL, `query` TEXT NOT NULL, `contentPartsJson` TEXT NOT NULL, `timestamp` INTEGER NOT NULL, `state` TEXT NOT NULL, `retryCount` INTEGER NOT NULL, `lastErrorCode` INTEGER NOT NULL, `logId` TEXT NOT NULL, `updateTime` INTEGER NOT NULL)");
        r1.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_AutoMemoryProRawSource_target_sourceType_sourceKey` ON `AutoMemoryProRawSource` (`target`, `sourceType`, `sourceKey`)");
    }
}
