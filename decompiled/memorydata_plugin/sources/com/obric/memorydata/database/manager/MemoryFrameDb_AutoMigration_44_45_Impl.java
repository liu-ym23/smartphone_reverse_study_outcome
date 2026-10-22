package com.obric.memorydata.database.manager;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
class MemoryFrameDb_AutoMigration_44_45_Impl extends Migration {
    public MemoryFrameDb_AutoMigration_44_45_Impl() {
        super(44, 45);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(SupportSQLiteDatabase r2) {
        SupportSQLiteDatabase r1 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        r1.execSQL("ALTER TABLE `RawBluetoothDevice` ADD COLUMN `enable` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `RawStreamVolume` ADD COLUMN `assistantVolume` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `RawStreamVolume` ADD COLUMN `vibrationEnable` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `RawBatteryState` ADD COLUMN `timeRemaining` INTEGER NOT NULL DEFAULT -1");
    }
}
