package com.obric.memorydata.database.manager;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
class MemoryFrameDb_AutoMigration_86_87_Impl extends Migration {
    public MemoryFrameDb_AutoMigration_86_87_Impl() {
        super(86, 87);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(SupportSQLiteDatabase r2) {
        SupportSQLiteDatabase r1 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        r1.execSQL("ALTER TABLE `MemoryRule` ADD COLUMN `autoCaptureEnabled` INTEGER NOT NULL DEFAULT 1");
        r1.execSQL("ALTER TABLE `BacupMemoryRule` ADD COLUMN `backup_autoCaptureEnabled` INTEGER NOT NULL DEFAULT 1");
    }
}
