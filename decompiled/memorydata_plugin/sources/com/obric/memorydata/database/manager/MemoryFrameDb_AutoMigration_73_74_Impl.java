package com.obric.memorydata.database.manager;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
class MemoryFrameDb_AutoMigration_73_74_Impl extends Migration {
    public MemoryFrameDb_AutoMigration_73_74_Impl() {
        super(73, 74);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(SupportSQLiteDatabase r2) {
        SupportSQLiteDatabase r1 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        r1.execSQL("ALTER TABLE `ScreenObservation` ADD COLUMN `retry_time` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `AutoMemoryPro` ADD COLUMN `entityId` TEXT NOT NULL DEFAULT ''");
        r1.execSQL("ALTER TABLE `AutoMemoryPro` ADD COLUMN `createTime` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `AutoMemoryPro` ADD COLUMN `modifyTime` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `AutoMemoryPro` ADD COLUMN `type` INTEGER NOT NULL DEFAULT -403");
        r1.execSQL("ALTER TABLE `AutoMemoryPro` ADD COLUMN `packageName` TEXT NOT NULL DEFAULT ''");
        r1.execSQL("ALTER TABLE `AutoMemoryPro` ADD COLUMN `hashCodeValue` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `AutoMemoryPro` ADD COLUMN `uuid` TEXT DEFAULT ''");
        r1.execSQL("ALTER TABLE `AutoMemoryPro` ADD COLUMN `subtitle` TEXT NOT NULL DEFAULT ''");
        r1.execSQL("ALTER TABLE `AutoMemoryPro` ADD COLUMN `fullContent` TEXT DEFAULT NULL");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `AutoMemoryProHistoryEntity` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `auto_memory_pro_id` INTEGER NOT NULL, `auto_memory_pro_entityId` TEXT NOT NULL DEFAULT '', `auto_memory_pro_createTime` INTEGER NOT NULL DEFAULT 0, `auto_memory_pro_modifyTime` INTEGER NOT NULL DEFAULT 0, `auto_memory_pro_type` INTEGER NOT NULL DEFAULT -403, `auto_memory_pro_packageName` TEXT NOT NULL DEFAULT '', `auto_memory_pro_hashCodeValue` INTEGER NOT NULL DEFAULT 0, `auto_memory_pro_uuid` TEXT DEFAULT '', `auto_memory_pro_rule_id` INTEGER NOT NULL, `auto_memory_pro_timestamp` INTEGER NOT NULL, `auto_memory_pro_title` TEXT NOT NULL, `auto_memory_pro_content` TEXT NOT NULL, `auto_memory_pro_subtitle` TEXT NOT NULL DEFAULT '', `auto_memory_pro_reason` TEXT NOT NULL, `auto_memory_pro_log_id` TEXT NOT NULL, `auto_memory_pro_package_names` TEXT NOT NULL, `auto_memory_pro_fullContent` TEXT)");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `AutoMemoryProTextVectorCopilot` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `rawDbId` INTEGER NOT NULL, `rawDbColumn` TEXT NOT NULL, `text` TEXT NOT NULL)");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `BackUpAutoMemoryProEntity` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `backupUserId` TEXT NOT NULL, `backup_id` INTEGER NOT NULL, `backup_entityId` TEXT NOT NULL DEFAULT '', `backup_createTime` INTEGER NOT NULL DEFAULT 0, `backup_modifyTime` INTEGER NOT NULL DEFAULT 0, `backup_type` INTEGER NOT NULL DEFAULT -403, `backup_packageName` TEXT NOT NULL DEFAULT '', `backup_hashCodeValue` INTEGER NOT NULL DEFAULT 0, `backup_uuid` TEXT DEFAULT '', `backup_rule_id` INTEGER NOT NULL, `backup_timestamp` INTEGER NOT NULL, `backup_title` TEXT NOT NULL, `backup_content` TEXT NOT NULL, `backup_subtitle` TEXT NOT NULL DEFAULT '', `backup_reason` TEXT NOT NULL, `backup_log_id` TEXT NOT NULL, `backup_package_names` TEXT NOT NULL, `backup_fullContent` TEXT)");
        r1.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_BackUpAutoMemoryProEntity_backupUserId_backup_id` ON `BackUpAutoMemoryProEntity` (`backupUserId`, `backup_id`)");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `BacupMemoryRule` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `backupUserId` TEXT NOT NULL, `backup_id` INTEGER NOT NULL, `backup_title` TEXT NOT NULL, `backup_content` TEXT NOT NULL, `backup_appPackages` TEXT NOT NULL, `backup_memoryCount` INTEGER NOT NULL DEFAULT 0)");
        r1.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_BacupMemoryRule_backupUserId_backup_id` ON `BacupMemoryRule` (`backupUserId`, `backup_id`)");
    }
}
