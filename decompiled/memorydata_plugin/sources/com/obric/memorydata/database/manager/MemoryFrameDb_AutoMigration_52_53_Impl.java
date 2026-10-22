package com.obric.memorydata.database.manager;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
class MemoryFrameDb_AutoMigration_52_53_Impl extends Migration {
    public MemoryFrameDb_AutoMigration_52_53_Impl() {
        super(52, 53);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(SupportSQLiteDatabase r2) {
        SupportSQLiteDatabase r1 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        r1.execSQL("ALTER TABLE `RawMemoryEntity` ADD COLUMN `sourceQuery` TEXT DEFAULT NULL");
        r1.execSQL("ALTER TABLE `RawMemoryEntity` ADD COLUMN `detail` TEXT DEFAULT NULL");
        r1.execSQL("ALTER TABLE `RawMemoryEntity` ADD COLUMN `detailStatus` INTEGER NOT NULL DEFAULT 0");
    }
}
