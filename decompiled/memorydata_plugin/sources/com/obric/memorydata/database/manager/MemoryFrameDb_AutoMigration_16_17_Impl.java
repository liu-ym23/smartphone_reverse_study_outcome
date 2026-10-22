package com.obric.memorydata.database.manager;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
class MemoryFrameDb_AutoMigration_16_17_Impl extends Migration {
    public MemoryFrameDb_AutoMigration_16_17_Impl() {
        super(16, 17);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(SupportSQLiteDatabase r2) {
        SupportSQLiteDatabase r1 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `AppEntityToMemoryTable` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `entityType` INTEGER NOT NULL, `entityRawDbId` INTEGER NOT NULL, `memoryRawDbId` INTEGER, `triggerTimeType` INTEGER NOT NULL DEFAULT 0, `retryTime` INTEGER NOT NULL DEFAULT 0, `isModified` INTEGER NOT NULL, `createTimeStamp` INTEGER NOT NULL, `packageName` TEXT NOT NULL)");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `RawMemoryEntityCorrelation` (`sourceEntityId` TEXT NOT NULL, `targetEntityId` TEXT NOT NULL, `targetMemoryType` INTEGER NOT NULL, `targetExpireTime` INTEGER, `score` REAL NOT NULL, PRIMARY KEY(`sourceEntityId`, `targetEntityId`), FOREIGN KEY(`sourceEntityId`) REFERENCES `RawMemoryEntity`(`entityId`) ON UPDATE NO ACTION ON DELETE CASCADE , FOREIGN KEY(`targetEntityId`) REFERENCES `RawMemoryEntity`(`entityId`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        r1.execSQL("CREATE INDEX IF NOT EXISTS `index_RawMemoryEntityCorrelation_sourceEntityId` ON `RawMemoryEntityCorrelation` (`sourceEntityId`)");
        r1.execSQL("CREATE INDEX IF NOT EXISTS `index_RawMemoryEntityCorrelation_targetEntityId` ON `RawMemoryEntityCorrelation` (`targetEntityId`)");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `_new_RawMemoryEntity` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `entityId` TEXT NOT NULL, `createTime` INTEGER NOT NULL, `modifyTime` INTEGER NOT NULL, `type` INTEGER NOT NULL, `timestamp` INTEGER NOT NULL, `packageName` TEXT NOT NULL, `hashCodeValue` INTEGER NOT NULL, `memoryType` INTEGER NOT NULL, `productType` INTEGER NOT NULL, `startDate` INTEGER, `startTime` INTEGER, `endDate` INTEGER, `endTime` INTEGER, `sourceLinkType` TEXT, `sourceLink` TEXT, `screenshot` TEXT, `locations` TEXT, `summary` TEXT, `fullContent` TEXT, `key1` TEXT, `key2` TEXT, `key3` TEXT, `key4` TEXT, `key5` TEXT, `keyword1` TEXT, `keyword2` TEXT, `keyword3` TEXT, `keyword4` TEXT, `keyword5` TEXT, `keyword6` TEXT, `semantic1` TEXT, `semantic2` TEXT, `keywordAndSemantic1` TEXT, `keywordAndSemantic2` TEXT)");
        r1.execSQL("INSERT INTO `_new_RawMemoryEntity` (`id`,`entityId`,`createTime`,`modifyTime`,`type`,`timestamp`,`packageName`,`hashCodeValue`,`memoryType`,`productType`,`startDate`,`startTime`,`endDate`,`endTime`,`sourceLinkType`,`sourceLink`,`screenshot`,`locations`,`summary`,`fullContent`,`key1`,`key2`,`key3`,`key4`,`key5`,`keyword1`,`keyword2`,`keyword3`,`keyword4`,`keyword5`,`keyword6`,`semantic1`,`semantic2`,`keywordAndSemantic1`,`keywordAndSemantic2`) SELECT `id`,`entityId`,`createTime`,`modifyTime`,`type`,`timestamp`,`packageName`,`hashCodeValue`,`memoryType`,`productType`,`startDate`,`startTime`,`endDate`,`endTime`,`sourceLinkType`,`sourceLink`,`screenshot`,`locations`,`summary`,`fullContent`,`key1`,`key2`,`key3`,`key4`,`key5`,`keyword1`,`keyword2`,`keyword3`,`keyword4`,`keyword5`,`keyword6`,`semantic1`,`semantic2`,`keywordAndSemantic1`,`keywordAndSemantic2` FROM `RawMemoryEntity`");
        r1.execSQL("DROP TABLE `RawMemoryEntity`");
        r1.execSQL("ALTER TABLE `_new_RawMemoryEntity` RENAME TO `RawMemoryEntity`");
        r1.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_RawMemoryEntity_entityId` ON `RawMemoryEntity` (`entityId`)");
    }
}
