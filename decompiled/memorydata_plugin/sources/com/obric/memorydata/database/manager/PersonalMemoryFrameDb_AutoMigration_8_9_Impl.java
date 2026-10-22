package com.obric.memorydata.database.manager;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
class PersonalMemoryFrameDb_AutoMigration_8_9_Impl extends Migration {
    public PersonalMemoryFrameDb_AutoMigration_8_9_Impl() {
        super(8, 9);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(SupportSQLiteDatabase r2) {
        SupportSQLiteDatabase r1 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        r1.execSQL("ALTER TABLE `ShortMemory` ADD COLUMN `eventName` TEXT DEFAULT NULL");
        r1.execSQL("ALTER TABLE `ShortMemory` ADD COLUMN `rawTableName` TEXT DEFAULT NULL");
        r1.execSQL("ALTER TABLE `ShortMemory` ADD COLUMN `rawDbId` INTEGER DEFAULT NULL");
        r1.execSQL("ALTER TABLE `ShortMemory` ADD COLUMN `eventData` TEXT NOT NULL DEFAULT '{}'");
        r1.execSQL("ALTER TABLE `EpisodicMemoryHistoryEntity` ADD COLUMN `episodic_memory_eventName` TEXT DEFAULT NULL");
        r1.execSQL("ALTER TABLE `EpisodicMemoryHistoryEntity` ADD COLUMN `episodic_memory_rawTableName` TEXT DEFAULT NULL");
        r1.execSQL("ALTER TABLE `EpisodicMemoryHistoryEntity` ADD COLUMN `episodic_memory_rawDbId` INTEGER DEFAULT NULL");
        r1.execSQL("ALTER TABLE `EpisodicMemoryHistoryEntity` ADD COLUMN `episodic_memory_eventData` TEXT NOT NULL DEFAULT '{}'");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `_new_PersonAudioProfile` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `profileId` TEXT NOT NULL DEFAULT '', `source` TEXT NOT NULL DEFAULT 'glasses', `embedding` TEXT NOT NULL DEFAULT '[]', `dim` INTEGER NOT NULL DEFAULT 0, `resourceId` TEXT, `modelVersion` TEXT NOT NULL DEFAULT '', `durationMs` INTEGER NOT NULL DEFAULT 0, `createdAt` INTEGER NOT NULL DEFAULT 0)");
        r1.execSQL("INSERT INTO `_new_PersonAudioProfile` (`id`,`profileId`,`embedding`,`dim`,`resourceId`,`modelVersion`,`durationMs`,`createdAt`) SELECT `id`,`profileId`,`embedding`,`dim`,`resourceId`,`modelVersion`,`durationMs`,`createdAt` FROM `PersonAudioProfile`");
        r1.execSQL("DROP TABLE `PersonAudioProfile`");
        r1.execSQL("ALTER TABLE `_new_PersonAudioProfile` RENAME TO `PersonAudioProfile`");
        r1.execSQL("CREATE INDEX IF NOT EXISTS `index_PersonAudioProfile_profileId_source_modelVersion` ON `PersonAudioProfile` (`profileId`, `source`, `modelVersion`)");
    }
}
