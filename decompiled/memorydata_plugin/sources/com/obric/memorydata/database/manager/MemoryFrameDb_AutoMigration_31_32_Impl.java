package com.obric.memorydata.database.manager;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
class MemoryFrameDb_AutoMigration_31_32_Impl extends Migration {
    public MemoryFrameDb_AutoMigration_31_32_Impl() {
        super(31, 32);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(SupportSQLiteDatabase r2) {
        ((SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin")).execSQL("ALTER TABLE `RawCallHistoryEntity` ADD COLUMN `transcriptTitle` TEXT DEFAULT NULL");
    }
}
