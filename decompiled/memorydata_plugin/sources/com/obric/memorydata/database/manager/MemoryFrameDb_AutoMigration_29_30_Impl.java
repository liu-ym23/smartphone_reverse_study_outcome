package com.obric.memorydata.database.manager;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
class MemoryFrameDb_AutoMigration_29_30_Impl extends Migration {
    public MemoryFrameDb_AutoMigration_29_30_Impl() {
        super(29, 30);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(SupportSQLiteDatabase r2) {
        SupportSQLiteDatabase r1 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        r1.execSQL("ALTER TABLE `AppEntityIndexPending` ADD COLUMN `createTimeStamp` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `AppEntityIndexPending` ADD COLUMN `isScheduledSlowTask` INTEGER NOT NULL DEFAULT 0");
    }
}
