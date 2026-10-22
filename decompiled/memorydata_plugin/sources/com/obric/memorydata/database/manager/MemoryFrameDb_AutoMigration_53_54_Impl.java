package com.obric.memorydata.database.manager;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
class MemoryFrameDb_AutoMigration_53_54_Impl extends Migration {
    public MemoryFrameDb_AutoMigration_53_54_Impl() {
        super(53, 54);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(SupportSQLiteDatabase r2) {
        SupportSQLiteDatabase r1 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        r1.execSQL("ALTER TABLE `Lifelog` ADD COLUMN `entityId` TEXT NOT NULL DEFAULT ''");
        r1.execSQL("ALTER TABLE `Lifelog` ADD COLUMN `createTime` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `Lifelog` ADD COLUMN `modifyTime` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `Lifelog` ADD COLUMN `type` INTEGER NOT NULL DEFAULT 1401");
        r1.execSQL("ALTER TABLE `Lifelog` ADD COLUMN `entityTimestamp` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `Lifelog` ADD COLUMN `packageName` TEXT NOT NULL DEFAULT ''");
        r1.execSQL("ALTER TABLE `Lifelog` ADD COLUMN `hashCodeValue` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `Lifelog` ADD COLUMN `uuid` TEXT DEFAULT ''");
        r1.execSQL("ALTER TABLE `Lifelog` ADD COLUMN `fullContent` TEXT DEFAULT NULL");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `UserProfileEntityTextVectorCopilot` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `rawDbId` INTEGER NOT NULL, `rawDbColumn` TEXT NOT NULL, `text` TEXT NOT NULL)");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `RawUserProfileEntity` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `entityId` TEXT NOT NULL, `createTime` INTEGER NOT NULL, `modifyTime` INTEGER NOT NULL, `type` INTEGER NOT NULL, `timestamp` INTEGER NOT NULL, `packageName` TEXT NOT NULL, `hashCodeValue` INTEGER NOT NULL, `uuid` TEXT, `profileKey` TEXT NOT NULL, `profileValue` TEXT NOT NULL, `isFromAutoLearn` INTEGER NOT NULL, `fullContent` TEXT)");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `LifeLogEntityTextVectorCopilot` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `rawDbId` INTEGER NOT NULL, `rawDbColumn` TEXT NOT NULL, `text` TEXT NOT NULL)");
    }
}
