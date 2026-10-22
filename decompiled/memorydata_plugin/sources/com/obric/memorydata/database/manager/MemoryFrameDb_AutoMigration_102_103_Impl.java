package com.obric.memorydata.database.manager;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
class MemoryFrameDb_AutoMigration_102_103_Impl extends Migration {
    public MemoryFrameDb_AutoMigration_102_103_Impl() {
        super(102, 103);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(SupportSQLiteDatabase r2) {
        SupportSQLiteDatabase r1 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        r1.execSQL("ALTER TABLE `RawPhotoEntity` ADD COLUMN `sourceDevice` TEXT DEFAULT NULL");
        r1.execSQL("ALTER TABLE `RawRecordingEntity` ADD COLUMN `fullContent` TEXT DEFAULT NULL");
        r1.execSQL("ALTER TABLE `RawRecordingEntity` ADD COLUMN `sourceDevice` TEXT DEFAULT NULL");
        r1.execSQL("ALTER TABLE `RawPhotoHistoryEntity` ADD COLUMN `photo_sourceDevice` TEXT DEFAULT NULL");
        r1.execSQL("ALTER TABLE `RawRecordingHistoryEntity` ADD COLUMN `recording_fullContent` TEXT DEFAULT NULL");
        r1.execSQL("ALTER TABLE `RawRecordingHistoryEntity` ADD COLUMN `recording_sourceDevice` TEXT DEFAULT NULL");
    }
}
