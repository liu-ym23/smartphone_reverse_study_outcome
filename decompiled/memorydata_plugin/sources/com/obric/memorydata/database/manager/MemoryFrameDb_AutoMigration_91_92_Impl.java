package com.obric.memorydata.database.manager;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
class MemoryFrameDb_AutoMigration_91_92_Impl extends Migration {
    public MemoryFrameDb_AutoMigration_91_92_Impl() {
        super(91, 92);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(SupportSQLiteDatabase r2) {
        SupportSQLiteDatabase r1 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        r1.execSQL("ALTER TABLE `RawAuditoryRecordingEntity` ADD COLUMN `did` TEXT DEFAULT NULL");
        r1.execSQL("ALTER TABLE `RawAuditoryRecordingHistoryEntity` ADD COLUMN `auditorydid` TEXT DEFAULT NULL");
    }
}
