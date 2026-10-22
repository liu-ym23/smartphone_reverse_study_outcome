package com.obric.memorydata.database.manager;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
class MemoryFrameDb_AutoMigration_94_95_Impl extends Migration {
    public MemoryFrameDb_AutoMigration_94_95_Impl() {
        super(94, 95);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(SupportSQLiteDatabase r2) {
        ((SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin")).execSQL("ALTER TABLE `RawScheduleEntity` ADD COLUMN `rawRrule` TEXT DEFAULT NULL");
    }
}
