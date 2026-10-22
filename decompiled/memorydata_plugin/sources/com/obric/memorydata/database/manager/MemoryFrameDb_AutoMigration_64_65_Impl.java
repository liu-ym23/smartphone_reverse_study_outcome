package com.obric.memorydata.database.manager;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
class MemoryFrameDb_AutoMigration_64_65_Impl extends Migration {
    public MemoryFrameDb_AutoMigration_64_65_Impl() {
        super(64, 65);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(SupportSQLiteDatabase r2) {
        SupportSQLiteDatabase r1 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        r1.execSQL("ALTER TABLE `RawLocation` ADD COLUMN `accuracy` REAL DEFAULT NULL");
        r1.execSQL("ALTER TABLE `RawLocation` ADD COLUMN `speed` REAL DEFAULT NULL");
        r1.execSQL("ALTER TABLE `RawLocation` ADD COLUMN `harState` INTEGER DEFAULT NULL");
    }
}
