package com.obric.memorydata.database.manager;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
class MemoryFrameDb_AutoMigration_55_56_Impl extends Migration {
    public MemoryFrameDb_AutoMigration_55_56_Impl() {
        super(55, 56);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(SupportSQLiteDatabase r2) {
        SupportSQLiteDatabase r1 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        r1.execSQL("ALTER TABLE `RawMessageEntity` ADD COLUMN `contentWithTime` TEXT DEFAULT NULL");
        r1.execSQL("ALTER TABLE `RawCallHistoryEntity` ADD COLUMN `contentWithTime` TEXT DEFAULT NULL");
        r1.execSQL("ALTER TABLE `RawNoteEntity` ADD COLUMN `contentWithTime` TEXT DEFAULT NULL");
        r1.execSQL("ALTER TABLE `RawRecordingEntity` ADD COLUMN `contentWithTime` TEXT DEFAULT NULL");
        r1.execSQL("ALTER TABLE `RawMessageHistoryEntity` ADD COLUMN `message_contentWithTime` TEXT DEFAULT NULL");
        r1.execSQL("ALTER TABLE `RawCallHistoryHistoryEntity` ADD COLUMN `call_contentWithTime` TEXT DEFAULT NULL");
        r1.execSQL("ALTER TABLE `RawNoteHistoryEntity` ADD COLUMN `note_contentWithTime` TEXT DEFAULT NULL");
        r1.execSQL("ALTER TABLE `RawRecordingHistoryEntity` ADD COLUMN `recording_contentWithTime` TEXT DEFAULT NULL");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `MessageEntityContentTime` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `rawDbId` INTEGER NOT NULL, `rawDbColumn` TEXT NOT NULL, `startTimestamp` INTEGER NOT NULL, `endTimestamp` INTEGER NOT NULL, `startDateTimestamp` INTEGER NOT NULL, `endDateTimestamp` INTEGER NOT NULL, `deltaDay` INTEGER, `deltaMonth` INTEGER, `deltaYear` INTEGER)");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `CallHistoryEntityContentTime` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `rawDbId` INTEGER NOT NULL, `rawDbColumn` TEXT NOT NULL, `startTimestamp` INTEGER NOT NULL, `endTimestamp` INTEGER NOT NULL, `startDateTimestamp` INTEGER NOT NULL, `endDateTimestamp` INTEGER NOT NULL, `deltaDay` INTEGER, `deltaMonth` INTEGER, `deltaYear` INTEGER)");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `NoteEntityContentTime` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `rawDbId` INTEGER NOT NULL, `rawDbColumn` TEXT NOT NULL, `startTimestamp` INTEGER NOT NULL, `endTimestamp` INTEGER NOT NULL, `startDateTimestamp` INTEGER NOT NULL, `endDateTimestamp` INTEGER NOT NULL, `deltaDay` INTEGER, `deltaMonth` INTEGER, `deltaYear` INTEGER)");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `RecordingEntityContentTime` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `rawDbId` INTEGER NOT NULL, `rawDbColumn` TEXT NOT NULL, `startTimestamp` INTEGER NOT NULL, `endTimestamp` INTEGER NOT NULL, `startDateTimestamp` INTEGER NOT NULL, `endDateTimestamp` INTEGER NOT NULL, `deltaDay` INTEGER, `deltaMonth` INTEGER, `deltaYear` INTEGER)");
    }
}
