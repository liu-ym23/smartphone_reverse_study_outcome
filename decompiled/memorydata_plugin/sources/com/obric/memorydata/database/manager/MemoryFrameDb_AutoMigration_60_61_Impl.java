package com.obric.memorydata.database.manager;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
class MemoryFrameDb_AutoMigration_60_61_Impl extends Migration {
    public MemoryFrameDb_AutoMigration_60_61_Impl() {
        super(60, 61);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(SupportSQLiteDatabase r2) {
        SupportSQLiteDatabase r1 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        r1.execSQL("ALTER TABLE `RawMemoryEntity` ADD COLUMN `contentWithTime` TEXT DEFAULT NULL");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `MemoryEntityContentTime` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `rawDbId` INTEGER NOT NULL, `rawDbColumn` TEXT NOT NULL, `startTimestamp` INTEGER NOT NULL, `endTimestamp` INTEGER NOT NULL, `startDateTimestamp` INTEGER NOT NULL, `endDateTimestamp` INTEGER NOT NULL, `deltaDay` INTEGER, `deltaMonth` INTEGER, `deltaYear` INTEGER)");
    }
}
