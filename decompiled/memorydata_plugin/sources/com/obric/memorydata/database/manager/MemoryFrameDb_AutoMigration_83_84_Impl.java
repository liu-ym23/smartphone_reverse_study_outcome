package com.obric.memorydata.database.manager;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
class MemoryFrameDb_AutoMigration_83_84_Impl extends Migration {
    public MemoryFrameDb_AutoMigration_83_84_Impl() {
        super(83, 84);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(SupportSQLiteDatabase r2) {
        SupportSQLiteDatabase r1 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        r1.execSQL("ALTER TABLE `UnionSemanticMemoryHistoryEntity` ADD COLUMN `semantic_use_for_persona` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `UnionSemanticMemory` ADD COLUMN `use_for_persona` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `BackUpUnionSemanticMemory` ADD COLUMN `backup_use_for_persona` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `UnionUserPersona` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `summary` TEXT NOT NULL, `description` TEXT NOT NULL, `createTime` INTEGER NOT NULL)");
    }
}
