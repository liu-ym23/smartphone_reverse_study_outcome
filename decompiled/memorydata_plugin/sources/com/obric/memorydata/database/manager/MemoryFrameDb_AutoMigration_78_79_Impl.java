package com.obric.memorydata.database.manager;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
class MemoryFrameDb_AutoMigration_78_79_Impl extends Migration {
    public MemoryFrameDb_AutoMigration_78_79_Impl() {
        super(78, 79);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(SupportSQLiteDatabase r2) {
        SupportSQLiteDatabase r1 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `UnionSemanticMemoryExt` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `memory_id` TEXT NOT NULL, `use_for_keyword` INTEGER NOT NULL, FOREIGN KEY(`memory_id`) REFERENCES `UnionSemanticMemory`(`entityId`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        r1.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_UnionSemanticMemoryExt_memory_id` ON `UnionSemanticMemoryExt` (`memory_id`)");
    }
}
