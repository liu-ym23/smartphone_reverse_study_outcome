package com.obric.memorydata.database.manager;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
class MemoryFrameDb_AutoMigration_101_102_Impl extends Migration {
    public MemoryFrameDb_AutoMigration_101_102_Impl() {
        super(101, 102);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(SupportSQLiteDatabase r2) {
        SupportSQLiteDatabase r1 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        r1.execSQL("ALTER TABLE `RawCallHistoryEntity` ADD COLUMN `source_number` TEXT DEFAULT NULL");
        r1.execSQL("ALTER TABLE `RawCallHistoryHistoryEntity` ADD COLUMN `call_source_number` TEXT DEFAULT NULL");
    }
}
