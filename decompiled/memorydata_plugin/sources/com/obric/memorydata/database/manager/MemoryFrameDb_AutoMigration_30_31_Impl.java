package com.obric.memorydata.database.manager;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
class MemoryFrameDb_AutoMigration_30_31_Impl extends Migration {
    public MemoryFrameDb_AutoMigration_30_31_Impl() {
        super(30, 31);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(SupportSQLiteDatabase r2) {
        SupportSQLiteDatabase r1 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        r1.execSQL("ALTER TABLE `RawMemoryEntity` ADD COLUMN `sourceText` TEXT DEFAULT NULL");
        r1.execSQL("ALTER TABLE `RawMemoryEntity` ADD COLUMN `sourcePackageName` TEXT DEFAULT NULL");
        r1.execSQL("ALTER TABLE `RawMemoryEntity` ADD COLUMN `sourceAppName` TEXT DEFAULT NULL");
        r1.execSQL("ALTER TABLE `RawMemoryEntity` ADD COLUMN `logId` TEXT DEFAULT NULL");
    }
}
