package com.obric.memorydata.database.manager;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
class MemoryFrameDb_AutoMigration_59_60_Impl extends Migration {
    public MemoryFrameDb_AutoMigration_59_60_Impl() {
        super(59, 60);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(SupportSQLiteDatabase r2) {
        SupportSQLiteDatabase r1 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        r1.execSQL("ALTER TABLE `ShortMemory` ADD COLUMN `useForUserKeyword` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `UserKeyword` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT NOT NULL, `summary` TEXT NOT NULL, `sources` TEXT NOT NULL, `user_edit` INTEGER NOT NULL, `create_time` INTEGER NOT NULL, `update_time` INTEGER NOT NULL)");
    }
}
