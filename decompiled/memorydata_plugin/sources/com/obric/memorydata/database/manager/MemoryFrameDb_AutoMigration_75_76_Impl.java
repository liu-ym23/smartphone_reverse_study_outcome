package com.obric.memorydata.database.manager;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
class MemoryFrameDb_AutoMigration_75_76_Impl extends Migration {
    public MemoryFrameDb_AutoMigration_75_76_Impl() {
        super(75, 76);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(SupportSQLiteDatabase r2) {
        SupportSQLiteDatabase r1 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        r1.execSQL("ALTER TABLE `MemoryRule` ADD COLUMN `source` TEXT NOT NULL DEFAULT ''");
        r1.execSQL("ALTER TABLE `BacupMemoryRule` ADD COLUMN `backup_source` TEXT NOT NULL DEFAULT ''");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `ProactiveOsNotification` (`timestamp` INTEGER NOT NULL, `packageName` TEXT NOT NULL, `title` TEXT NOT NULL, `text` TEXT NOT NULL, `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `post_timestamp` INTEGER NOT NULL, `notificationId` INTEGER NOT NULL, `appName` TEXT NOT NULL, `flags` INTEGER NOT NULL, `subTitle` TEXT, `channel` TEXT)");
    }
}
