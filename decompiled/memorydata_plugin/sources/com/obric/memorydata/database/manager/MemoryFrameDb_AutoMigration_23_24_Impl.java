package com.obric.memorydata.database.manager;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
class MemoryFrameDb_AutoMigration_23_24_Impl extends Migration {
    public MemoryFrameDb_AutoMigration_23_24_Impl() {
        super(23, 24);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(SupportSQLiteDatabase r2) {
        SupportSQLiteDatabase r1 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        r1.execSQL("ALTER TABLE `ShortMemory` ADD COLUMN `category` INTEGER DEFAULT NULL");
        r1.execSQL("ALTER TABLE `ShortMemory` ADD COLUMN `profileType` INTEGER DEFAULT NULL");
        r1.execSQL("ALTER TABLE `ShortMemory` ADD COLUMN `profileTag` TEXT DEFAULT NULL");
        r1.execSQL("ALTER TABLE `ShortMemory` ADD COLUMN `tagOther` TEXT DEFAULT NULL");
    }
}
