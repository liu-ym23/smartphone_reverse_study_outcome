package com.obric.memorydata.database.manager;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
class MemoryFrameDb_AutoMigration_17_18_Impl extends Migration {
    public MemoryFrameDb_AutoMigration_17_18_Impl() {
        super(17, 18);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(SupportSQLiteDatabase r2) {
        SupportSQLiteDatabase r1 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        r1.execSQL("ALTER TABLE `RawRecordingEntity` ADD COLUMN `docNodeJson` TEXT DEFAULT NULL");
        r1.execSQL("ALTER TABLE `RawNoteRecordingEntity` ADD COLUMN `docNodeJson` TEXT DEFAULT NULL");
        r1.execSQL("ALTER TABLE `RawFileEntity` ADD COLUMN `docNodeJson` TEXT DEFAULT NULL");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `RawNoteRecordingTextEntity` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `entityId` TEXT NOT NULL, `createTime` INTEGER NOT NULL, `modifyTime` INTEGER NOT NULL, `type` INTEGER NOT NULL, `timestamp` INTEGER NOT NULL, `packageName` TEXT NOT NULL, `hashCodeValue` INTEGER NOT NULL, `parentEntityId` TEXT NOT NULL, `content` TEXT NOT NULL, `passageDocNodeTreeJson` TEXT NOT NULL)");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `RawRecordingTextEntity` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `entityId` TEXT NOT NULL, `createTime` INTEGER NOT NULL, `modifyTime` INTEGER NOT NULL, `type` INTEGER NOT NULL, `timestamp` INTEGER NOT NULL, `packageName` TEXT NOT NULL, `hashCodeValue` INTEGER NOT NULL, `parentEntityId` TEXT NOT NULL, `content` TEXT NOT NULL, `passageDocNodeTreeJson` TEXT NOT NULL)");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `RawFileTextEntity` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `entityId` TEXT NOT NULL, `createTime` INTEGER NOT NULL, `modifyTime` INTEGER NOT NULL, `type` INTEGER NOT NULL, `timestamp` INTEGER NOT NULL, `packageName` TEXT NOT NULL, `hashCodeValue` INTEGER NOT NULL, `parentEntityId` TEXT NOT NULL, `content` TEXT NOT NULL, `passageDocNodeTreeJson` TEXT NOT NULL)");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `NoteRecordingTextEntityTextVectorCopilot` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `rawDbId` INTEGER NOT NULL, `rawDbColumn` TEXT NOT NULL, `text` TEXT NOT NULL)");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `RecordingTextEntityTextVectorCopilot` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `rawDbId` INTEGER NOT NULL, `rawDbColumn` TEXT NOT NULL, `text` TEXT NOT NULL)");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `RecordingEntityTextVectorCopilot` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `rawDbId` INTEGER NOT NULL, `rawDbColumn` TEXT NOT NULL, `text` TEXT NOT NULL)");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `FileEntityTextVectorCopilot` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `rawDbId` INTEGER NOT NULL, `rawDbColumn` TEXT NOT NULL, `text` TEXT NOT NULL)");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `FileTextEntityTextVectorCopilot` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `rawDbId` INTEGER NOT NULL, `rawDbColumn` TEXT NOT NULL, `text` TEXT NOT NULL)");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `NoteRecordingEntityTextVectorCopilot` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `rawDbId` INTEGER NOT NULL, `rawDbColumn` TEXT NOT NULL, `text` TEXT NOT NULL)");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `ScheduleEntityTextVectorCopilot` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `rawDbId` INTEGER NOT NULL, `rawDbColumn` TEXT NOT NULL, `text` TEXT NOT NULL)");
    }
}
