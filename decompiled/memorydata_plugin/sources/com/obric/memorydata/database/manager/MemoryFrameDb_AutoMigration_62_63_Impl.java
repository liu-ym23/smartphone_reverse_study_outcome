package com.obric.memorydata.database.manager;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
class MemoryFrameDb_AutoMigration_62_63_Impl extends Migration {
    public MemoryFrameDb_AutoMigration_62_63_Impl() {
        super(62, 63);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(SupportSQLiteDatabase r2) {
        SupportSQLiteDatabase r1 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `MemoryKeyInfoEntity` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `sourceEntityId` TEXT NOT NULL, `key` TEXT NOT NULL, `value` TEXT NOT NULL, FOREIGN KEY(`sourceEntityId`) REFERENCES `RawMemoryEntity`(`entityId`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        r1.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_MemoryKeyInfoEntity_sourceEntityId_key` ON `MemoryKeyInfoEntity` (`sourceEntityId`, `key`)");
        r1.execSQL("CREATE INDEX IF NOT EXISTS `index_MemoryKeyInfoEntity_key` ON `MemoryKeyInfoEntity` (`key`)");
    }
}
