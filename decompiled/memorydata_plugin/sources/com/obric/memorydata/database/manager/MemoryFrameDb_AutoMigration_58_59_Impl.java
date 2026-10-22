package com.obric.memorydata.database.manager;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
class MemoryFrameDb_AutoMigration_58_59_Impl extends Migration {
    public MemoryFrameDb_AutoMigration_58_59_Impl() {
        super(58, 59);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(SupportSQLiteDatabase r2) {
        SupportSQLiteDatabase r1 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `har_state` (`state` INTEGER NOT NULL, `timestamp` INTEGER NOT NULL, `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL)");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `cell_info` (`uniqueId` TEXT NOT NULL, `cellId` INTEGER NOT NULL, `pci` INTEGER NOT NULL, `tac` INTEGER NOT NULL, `arfcn` INTEGER NOT NULL, `bands` TEXT NOT NULL, `level` INTEGER NOT NULL, `signalQuality` INTEGER NOT NULL, `signalStrength` INTEGER NOT NULL, `mcc` TEXT NOT NULL, `mnc` TEXT NOT NULL, `standard` TEXT NOT NULL, `registered` INTEGER NOT NULL, `timestamp` INTEGER NOT NULL, `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL)");
    }
}
