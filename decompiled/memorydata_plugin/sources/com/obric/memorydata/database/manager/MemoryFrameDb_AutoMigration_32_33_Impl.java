package com.obric.memorydata.database.manager;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
class MemoryFrameDb_AutoMigration_32_33_Impl extends Migration {
    public MemoryFrameDb_AutoMigration_32_33_Impl() {
        super(32, 33);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(SupportSQLiteDatabase r2) {
        SupportSQLiteDatabase r1 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        r1.execSQL("ALTER TABLE `ShortMemory` ADD COLUMN `usedForPortrait` INTEGER DEFAULT NULL");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `ScreenObservation` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `timestamp` INTEGER NOT NULL, `trigger_type` TEXT NOT NULL, `app_name` TEXT NOT NULL, `package_name` TEXT NOT NULL, `screenshot_path` TEXT NOT NULL, `image_tos_key` TEXT NOT NULL, `location` TEXT NOT NULL, `location_state` TEXT NOT NULL, `movement_state` TEXT NOT NULL, `click_detail` TEXT NOT NULL, `scroll_detail` TEXT NOT NULL, `extra` TEXT NOT NULL, `state` INTEGER NOT NULL)");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `ProactiveMemoryProcessInfo` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `timestamp` INTEGER NOT NULL, `type` INTEGER NOT NULL, `content` TEXT NOT NULL)");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `ProactiveMemorySyncPending` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `timestamp` INTEGER NOT NULL, `type` INTEGER NOT NULL, `entityId` TEXT NOT NULL, `status` INTEGER NOT NULL)");
    }
}
