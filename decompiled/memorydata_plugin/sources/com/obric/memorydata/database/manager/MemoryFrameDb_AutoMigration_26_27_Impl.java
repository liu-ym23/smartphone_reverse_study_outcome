package com.obric.memorydata.database.manager;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
class MemoryFrameDb_AutoMigration_26_27_Impl extends Migration {
    public MemoryFrameDb_AutoMigration_26_27_Impl() {
        super(26, 27);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(SupportSQLiteDatabase r2) {
        ((SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin")).execSQL("CREATE TABLE IF NOT EXISTS `RawPhotoHistoryEntity` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `photo_id` INTEGER NOT NULL, `photo_entityId` TEXT NOT NULL, `photo_createTime` INTEGER NOT NULL, `photo_modifyTime` INTEGER NOT NULL, `photo_type` INTEGER NOT NULL, `photo_timestamp` INTEGER NOT NULL, `photo_packageName` TEXT NOT NULL, `photo_hashCodeValue` INTEGER NOT NULL, `photo_name` TEXT NOT NULL, `photo_file` TEXT NOT NULL, `photo_assetType` TEXT NOT NULL, `photo_inAlbum` TEXT NOT NULL, `photo_resolution` TEXT NOT NULL, `photo_fileSize` INTEGER NOT NULL, `photo_isFavorite` INTEGER NOT NULL, `photo_tags` TEXT, `photo_faces` TEXT, `photo_location` TEXT, `photo_caption` TEXT, `photo_ocr` TEXT, `photo_sourceAppName` TEXT, `photo_sourcePackageName` TEXT)");
    }
}
