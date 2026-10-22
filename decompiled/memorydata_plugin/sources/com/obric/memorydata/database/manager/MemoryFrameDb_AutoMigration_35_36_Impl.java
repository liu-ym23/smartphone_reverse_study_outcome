package com.obric.memorydata.database.manager;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
class MemoryFrameDb_AutoMigration_35_36_Impl extends Migration {
    public MemoryFrameDb_AutoMigration_35_36_Impl() {
        super(35, 36);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(SupportSQLiteDatabase r2) {
        ((SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin")).execSQL("CREATE TABLE IF NOT EXISTS `Lifelog` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `timestamp` INTEGER NOT NULL, `uid` INTEGER NOT NULL, `title` TEXT NOT NULL, `contentAM` TEXT NOT NULL, `contentPM` TEXT NOT NULL, `finalContent` TEXT NOT NULL, `imageUrl` TEXT NOT NULL, `retryTime` INTEGER NOT NULL, `status` INTEGER NOT NULL)");
    }
}
