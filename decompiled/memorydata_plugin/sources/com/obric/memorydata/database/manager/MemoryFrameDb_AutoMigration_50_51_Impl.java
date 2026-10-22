package com.obric.memorydata.database.manager;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
class MemoryFrameDb_AutoMigration_50_51_Impl extends Migration {
    public MemoryFrameDb_AutoMigration_50_51_Impl() {
        super(50, 51);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(SupportSQLiteDatabase r2) {
        ((SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin")).execSQL("ALTER TABLE `ComplexRecommendQuery` ADD COLUMN `sources` TEXT NOT NULL DEFAULT '[]'");
    }
}
