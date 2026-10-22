package com.obric.memorydata.database.manager;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
class MemoryFrameDb_AutoMigration_45_46_Impl extends Migration {
    public MemoryFrameDb_AutoMigration_45_46_Impl() {
        super(45, 46);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(SupportSQLiteDatabase r2) {
        SupportSQLiteDatabase r1 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `PendingMemoryCalendar` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `title` TEXT NOT NULL, `location` TEXT, `eventType` TEXT NOT NULL, `description` TEXT, `dtstart` INTEGER, `dtend` INTEGER, `rrule` TEXT, `sourceAppPackage` TEXT NOT NULL, `sourceAppName` TEXT NOT NULL, `memoryUuid` TEXT, `entityType` INTEGER, `status` INTEGER NOT NULL DEFAULT 0, FOREIGN KEY(`memoryUuid`) REFERENCES `RawMemoryEntity`(`uuid`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        r1.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_PendingMemoryCalendar_title_dtstart_dtend_sourceAppPackage_memoryUuid_entityType` ON `PendingMemoryCalendar` (`title`, `dtstart`, `dtend`, `sourceAppPackage`, `memoryUuid`, `entityType`)");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `MemoryEntityToCalendar` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `memoryEntityId` TEXT NOT NULL)");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `RawICSProtocolEntity` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `entityId` TEXT NOT NULL, `createTime` INTEGER NOT NULL, `modifyTime` INTEGER NOT NULL, `type` INTEGER NOT NULL, `timestamp` INTEGER NOT NULL, `packageName` TEXT NOT NULL, `hashCodeValue` INTEGER NOT NULL, `uuid` TEXT, `doubaoUid` TEXT NOT NULL, `iCal` TEXT)");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `RawDoubaoAccountEntity` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `entityId` TEXT NOT NULL, `createTime` INTEGER NOT NULL, `modifyTime` INTEGER NOT NULL, `type` INTEGER NOT NULL, `timestamp` INTEGER NOT NULL, `packageName` TEXT NOT NULL, `hashCodeValue` INTEGER NOT NULL, `uuid` TEXT, `doubaoUid` TEXT NOT NULL)");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `_new_RawMemoryEntity` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `entityId` TEXT NOT NULL, `createTime` INTEGER NOT NULL, `modifyTime` INTEGER NOT NULL, `type` INTEGER NOT NULL, `timestamp` INTEGER NOT NULL, `packageName` TEXT NOT NULL, `hashCodeValue` INTEGER NOT NULL, `uuid` TEXT, `memoryType` INTEGER NOT NULL, `productType` INTEGER NOT NULL, `startDate` INTEGER, `startTime` INTEGER, `endDate` INTEGER, `endTime` INTEGER, `sourceLinkType` TEXT, `sourceLink` TEXT, `screenshot` TEXT, `locations` TEXT, `summary` TEXT, `fullContent` TEXT, `key1` TEXT, `key2` TEXT, `key3` TEXT, `key4` TEXT, `key5` TEXT, `keyword1` TEXT, `keyword2` TEXT, `keyword3` TEXT, `keyword4` TEXT, `keyword5` TEXT, `keyword6` TEXT, `semantic1` TEXT, `semantic2` TEXT, `keywordAndSemantic1` TEXT, `keywordAndSemantic2` TEXT, `sourceText` TEXT, `sourcePackageName` TEXT, `sourceAppName` TEXT, `logId` TEXT)");
        r1.execSQL("INSERT INTO `_new_RawMemoryEntity` (`id`,`entityId`,`createTime`,`modifyTime`,`type`,`timestamp`,`packageName`,`hashCodeValue`,`uuid`,`memoryType`,`productType`,`startDate`,`startTime`,`endDate`,`endTime`,`sourceLinkType`,`sourceLink`,`screenshot`,`locations`,`summary`,`fullContent`,`key1`,`key2`,`key3`,`key4`,`key5`,`keyword1`,`keyword2`,`keyword3`,`keyword4`,`keyword5`,`keyword6`,`semantic1`,`semantic2`,`keywordAndSemantic1`,`keywordAndSemantic2`,`sourceText`,`sourcePackageName`,`sourceAppName`,`logId`) SELECT `id`,`entityId`,`createTime`,`modifyTime`,`type`,`timestamp`,`packageName`,`hashCodeValue`,`uuid`,`memoryType`,`productType`,`startDate`,`startTime`,`endDate`,`endTime`,`sourceLinkType`,`sourceLink`,`screenshot`,`locations`,`summary`,`fullContent`,`key1`,`key2`,`key3`,`key4`,`key5`,`keyword1`,`keyword2`,`keyword3`,`keyword4`,`keyword5`,`keyword6`,`semantic1`,`semantic2`,`keywordAndSemantic1`,`keywordAndSemantic2`,`sourceText`,`sourcePackageName`,`sourceAppName`,`logId` FROM `RawMemoryEntity`");
        r1.execSQL("DROP TABLE `RawMemoryEntity`");
        r1.execSQL("ALTER TABLE `_new_RawMemoryEntity` RENAME TO `RawMemoryEntity`");
        r1.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_RawMemoryEntity_entityId` ON `RawMemoryEntity` (`entityId`)");
        r1.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_RawMemoryEntity_uuid` ON `RawMemoryEntity` (`uuid`)");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `_new_RawScheduleEntity` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `entityId` TEXT NOT NULL, `createTime` INTEGER NOT NULL, `modifyTime` INTEGER NOT NULL, `type` INTEGER NOT NULL, `timestamp` INTEGER NOT NULL, `packageName` TEXT NOT NULL, `hashCodeValue` INTEGER NOT NULL, `uuid` TEXT, `name` TEXT NOT NULL, `address` TEXT, `attendeesIds` TEXT, `repeatDescription` TEXT, `allDay` INTEGER NOT NULL, `note` TEXT, `completed` INTEGER, `isFavorite` INTEGER NOT NULL, `reminderDesc` TEXT, `fullContent` TEXT, `url` TEXT, `attendeesText` TEXT, `organizer` TEXT, `priority` TEXT, `categories` TEXT, `icsId` TEXT, `recurrenceId` TEXT, `calendarType` TEXT, `startTimestamp` INTEGER NOT NULL, `endTimestamp` INTEGER NOT NULL, `startDateTimestamp` INTEGER NOT NULL DEFAULT 0, `endDateTimestamp` INTEGER NOT NULL DEFAULT 0, `deltaDay` INTEGER, `deltaMonth` INTEGER, `deltaYear` INTEGER)");
        r1.execSQL("INSERT INTO `_new_RawScheduleEntity` (`id`,`entityId`,`createTime`,`modifyTime`,`type`,`timestamp`,`packageName`,`hashCodeValue`,`uuid`,`name`,`address`,`attendeesIds`,`repeatDescription`,`allDay`,`note`,`completed`,`isFavorite`,`reminderDesc`,`fullContent`,`startTimestamp`,`endTimestamp`) SELECT `id`,`entityId`,`createTime`,`modifyTime`,`type`,`timestamp`,`packageName`,`hashCodeValue`,`uuid`,`name`,`address`,`attendeesIds`,`repeatDescription`,`allDay`,`note`,`completed`,`isFavorite`,`reminderDesc`,`fullContent`,`startTimestamp`,`endTimestamp` FROM `RawScheduleEntity`");
        r1.execSQL("DROP TABLE `RawScheduleEntity`");
        r1.execSQL("ALTER TABLE `_new_RawScheduleEntity` RENAME TO `RawScheduleEntity`");
    }
}
