package com.obric.memorydata.database.manager;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
class MemoryFrameDb_AutoMigration_74_75_Impl extends Migration {
    public MemoryFrameDb_AutoMigration_74_75_Impl() {
        super(74, 75);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(SupportSQLiteDatabase r2) {
        SupportSQLiteDatabase r1 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        r1.execSQL("ALTER TABLE `RawPhotoEntity` ADD COLUMN `contentWithTime` TEXT DEFAULT NULL");
        r1.execSQL("ALTER TABLE `RawPhotoHistoryEntity` ADD COLUMN `photo_contentWithTime` TEXT DEFAULT NULL");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `PhotoEntityContentTime` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `rawDbId` INTEGER NOT NULL, `rawDbColumn` TEXT NOT NULL, `startTimestamp` INTEGER NOT NULL, `endTimestamp` INTEGER NOT NULL, `startDateTimestamp` INTEGER NOT NULL, `endDateTimestamp` INTEGER NOT NULL, `deltaDay` INTEGER, `deltaMonth` INTEGER, `deltaYear` INTEGER)");
    }
}
