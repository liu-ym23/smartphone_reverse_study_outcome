package com.obric.memorydata.database.manager;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
class MemoryFrameDb_AutoMigration_34_35_Impl extends Migration {
    public MemoryFrameDb_AutoMigration_34_35_Impl() {
        super(34, 35);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(SupportSQLiteDatabase r2) {
        SupportSQLiteDatabase r1 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        r1.execSQL("ALTER TABLE `RawMessageEntity` ADD COLUMN `uuid` TEXT DEFAULT NULL");
        r1.execSQL("ALTER TABLE `RawContactEntity` ADD COLUMN `uuid` TEXT DEFAULT NULL");
        r1.execSQL("ALTER TABLE `RawCallHistoryEntity` ADD COLUMN `uuid` TEXT DEFAULT NULL");
        r1.execSQL("ALTER TABLE `RawNoteEntity` ADD COLUMN `uuid` TEXT DEFAULT NULL");
        r1.execSQL("ALTER TABLE `RawAlbumEntity` ADD COLUMN `uuid` TEXT DEFAULT NULL");
        r1.execSQL("ALTER TABLE `RawPhotoEntity` ADD COLUMN `uuid` TEXT DEFAULT NULL");
        r1.execSQL("ALTER TABLE `RawPhotoFaceEntity` ADD COLUMN `uuid` TEXT DEFAULT NULL");
        r1.execSQL("ALTER TABLE `RawMetaLocationEntity` ADD COLUMN `uuid` TEXT DEFAULT NULL");
        r1.execSQL("ALTER TABLE `RawMetaTagEntity` ADD COLUMN `uuid` TEXT DEFAULT NULL");
        r1.execSQL("ALTER TABLE `RawAlarmEntity` ADD COLUMN `uuid` TEXT DEFAULT NULL");
        r1.execSQL("ALTER TABLE `RawVideoFrameEntity` ADD COLUMN `uuid` TEXT DEFAULT NULL");
        r1.execSQL("ALTER TABLE `ShortMemory` ADD COLUMN `uuid` TEXT DEFAULT NULL");
        r1.execSQL("ALTER TABLE `RawMemoryEntity` ADD COLUMN `uuid` TEXT DEFAULT NULL");
        r1.execSQL("ALTER TABLE `RawMemoryLocationEntity` ADD COLUMN `uuid` TEXT DEFAULT NULL");
        r1.execSQL("ALTER TABLE `RawRecordingEntity` ADD COLUMN `uuid` TEXT DEFAULT NULL");
        r1.execSQL("ALTER TABLE `RawNoteRecordingEntity` ADD COLUMN `uuid` TEXT DEFAULT NULL");
        r1.execSQL("ALTER TABLE `RawBrowserBookmarkEntity` ADD COLUMN `uuid` TEXT DEFAULT NULL");
        r1.execSQL("ALTER TABLE `RawFileEntity` ADD COLUMN `uuid` TEXT DEFAULT NULL");
        r1.execSQL("ALTER TABLE `RawScheduleEntity` ADD COLUMN `uuid` TEXT DEFAULT NULL");
        r1.execSQL("ALTER TABLE `RawNoteRecordingTextEntity` ADD COLUMN `uuid` TEXT DEFAULT NULL");
        r1.execSQL("ALTER TABLE `RawRecordingTextEntity` ADD COLUMN `uuid` TEXT DEFAULT NULL");
        r1.execSQL("ALTER TABLE `RawFileTextEntity` ADD COLUMN `uuid` TEXT DEFAULT NULL");
        r1.execSQL("ALTER TABLE `RawCountdownEntity` ADD COLUMN `uuid` TEXT DEFAULT NULL");
        r1.execSQL("ALTER TABLE `RawPhotoHistoryEntity` ADD COLUMN `photo_uuid` TEXT DEFAULT NULL");
    }
}
