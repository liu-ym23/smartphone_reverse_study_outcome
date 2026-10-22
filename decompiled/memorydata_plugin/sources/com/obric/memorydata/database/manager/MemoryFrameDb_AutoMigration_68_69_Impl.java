package com.obric.memorydata.database.manager;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
class MemoryFrameDb_AutoMigration_68_69_Impl extends Migration {
    public MemoryFrameDb_AutoMigration_68_69_Impl() {
        super(68, 69);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(SupportSQLiteDatabase r2) {
        SupportSQLiteDatabase r1 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        r1.execSQL("ALTER TABLE `ScreenObservation` ADD COLUMN `target` TEXT NOT NULL DEFAULT 'screenObservation'");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `MemoryRule` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `title` TEXT NOT NULL, `content` TEXT NOT NULL, `appPackages` TEXT NOT NULL, `memoryCount` INTEGER NOT NULL DEFAULT 0)");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `AutoMemoryPro` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `rule_id` INTEGER NOT NULL, `timestamp` INTEGER NOT NULL, `title` TEXT NOT NULL, `content` TEXT NOT NULL, `reason` TEXT NOT NULL, `log_id` TEXT NOT NULL, `package_names` TEXT NOT NULL)");
    }
}
