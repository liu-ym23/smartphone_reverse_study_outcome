package com.obric.memorydata.database.manager;

import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
class MemoryFrameDb_AutoMigration_36_37_Impl extends Migration {
    private final AutoMigrationSpec callback;

    public MemoryFrameDb_AutoMigration_36_37_Impl() {
        super(36, 37);
        this.callback = new MemoryFrameDb.AutoMigration37();
    }

    @Override // androidx.room.migration.Migration
    public void migrate(SupportSQLiteDatabase r3) {
        SupportSQLiteDatabase r4 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        r4.execSQL("CREATE TABLE IF NOT EXISTS `RawCommonPhotoEntity` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `entityId` TEXT NOT NULL, `createTime` INTEGER NOT NULL, `modifyTime` INTEGER NOT NULL, `type` INTEGER NOT NULL, `timestamp` INTEGER NOT NULL, `packageName` TEXT NOT NULL, `hashCodeValue` INTEGER NOT NULL, `uuid` TEXT, `file` TEXT NOT NULL, `assetType` TEXT NOT NULL, `caption` TEXT, `ocr` TEXT, `rawDbType` INTEGER NOT NULL, `rawEntityId` TEXT NOT NULL, `rawDbColumn` TEXT NOT NULL)");
        r4.execSQL("CREATE TABLE IF NOT EXISTS `RawCommonVideoFrameEntity` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `entityId` TEXT NOT NULL, `createTime` INTEGER NOT NULL, `modifyTime` INTEGER NOT NULL, `type` INTEGER NOT NULL, `timestamp` INTEGER NOT NULL, `packageName` TEXT NOT NULL, `hashCodeValue` INTEGER NOT NULL, `startTime` INTEGER NOT NULL, `endTime` INTEGER NOT NULL, `frameTime` INTEGER NOT NULL, `caption` TEXT, `ocr` TEXT, `photoEntityDbId` INTEGER NOT NULL, `uuid` TEXT)");
        r4.execSQL("CREATE TABLE IF NOT EXISTS `CommonPhotoEntityTextVectorCopilot` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `rawDbId` INTEGER NOT NULL, `rawDbColumn` TEXT NOT NULL, `text` TEXT NOT NULL)");
        r4.execSQL("CREATE TABLE IF NOT EXISTS `CommonPhotoEntityImageVectorCopilot` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `rawDbId` INTEGER NOT NULL, `rawDbColumn` TEXT NOT NULL)");
        r4.execSQL("CREATE TABLE IF NOT EXISTS `CommonVideoFrameEntityImageVectorCopilot` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `rawDbId` INTEGER NOT NULL, `rawDbColumn` TEXT NOT NULL)");
        r4.execSQL("CREATE TABLE IF NOT EXISTS `CommonVideoFrameEntityTextVectorCopilot` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `rawDbId` INTEGER NOT NULL, `rawDbColumn` TEXT NOT NULL, `text` TEXT NOT NULL)");
        r4.execSQL("CREATE TABLE IF NOT EXISTS `_new_RawMessageEntity` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `entityId` TEXT NOT NULL, `createTime` INTEGER NOT NULL, `modifyTime` INTEGER NOT NULL, `type` INTEGER NOT NULL, `timestamp` INTEGER NOT NULL, `packageName` TEXT NOT NULL, `hashCodeValue` INTEGER NOT NULL, `uuid` TEXT, `telephones` TEXT NOT NULL, `text` TEXT NOT NULL, `textConversion` TEXT, `files` TEXT, `contactIds` TEXT, `messageType` TEXT, `messageStatusType` TEXT, `fullContent` TEXT, `telephoneStandardMap` TEXT)");
        r4.execSQL("INSERT INTO `_new_RawMessageEntity` (`id`,`entityId`,`createTime`,`modifyTime`,`type`,`timestamp`,`packageName`,`hashCodeValue`,`uuid`,`telephones`,`text`,`textConversion`,`files`,`contactIds`,`messageType`,`messageStatusType`,`fullContent`,`telephoneStandardMap`) SELECT `id`,`entityId`,`createTime`,`modifyTime`,`type`,`timestamp`,`packageName`,`hashCodeValue`,`uuid`,`telephones`,`text`,`textConversion`,`files`,`contactIds`,`messageType`,`messageStatusType`,`fullContent`,`telephoneStandardMap` FROM `RawMessageEntity`");
        r4.execSQL("DROP TABLE `RawMessageEntity`");
        r4.execSQL("ALTER TABLE `_new_RawMessageEntity` RENAME TO `RawMessageEntity`");
        r4.execSQL("CREATE TABLE IF NOT EXISTS `_new_RawNoteEntity` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `entityId` TEXT NOT NULL, `createTime` INTEGER NOT NULL, `modifyTime` INTEGER NOT NULL, `type` INTEGER NOT NULL, `timestamp` INTEGER NOT NULL, `packageName` TEXT NOT NULL, `hashCodeValue` INTEGER NOT NULL, `uuid` TEXT, `title` TEXT NOT NULL, `text` TEXT NOT NULL, `textConversion` TEXT, `formatMode` TEXT, `noteFolder` TEXT, `isFavorite` INTEGER NOT NULL, `files` TEXT, `fullContent` TEXT, `recordingIds` TEXT)");
        r4.execSQL("INSERT INTO `_new_RawNoteEntity` (`id`,`entityId`,`createTime`,`modifyTime`,`type`,`timestamp`,`packageName`,`hashCodeValue`,`uuid`,`title`,`text`,`textConversion`,`formatMode`,`noteFolder`,`isFavorite`,`files`,`fullContent`,`recordingIds`) SELECT `id`,`entityId`,`createTime`,`modifyTime`,`type`,`timestamp`,`packageName`,`hashCodeValue`,`uuid`,`title`,`text`,`textConversion`,`formatMode`,`noteFolder`,`isFavorite`,`files`,`fullContent`,`recordingIds` FROM `RawNoteEntity`");
        r4.execSQL("DROP TABLE `RawNoteEntity`");
        r4.execSQL("ALTER TABLE `_new_RawNoteEntity` RENAME TO `RawNoteEntity`");
        this.callback.onPostMigrate(r4);
    }
}
