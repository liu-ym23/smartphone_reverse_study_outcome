package com.obric.memorydata.database.manager;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
class PersonalMemoryFrameDb_AutoMigration_2_3_Impl extends Migration {
    public PersonalMemoryFrameDb_AutoMigration_2_3_Impl() {
        super(2, 3);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(SupportSQLiteDatabase r2) {
        SupportSQLiteDatabase r1 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `MemorySourceEpisodicImageRelation` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `source_image_hash` TEXT NOT NULL, `product_type` INTEGER NOT NULL, `episodic_id` TEXT, `remembered_time` INTEGER NOT NULL)");
        r1.execSQL("CREATE INDEX IF NOT EXISTS `index_MemorySourceEpisodicImageRelation_source_image_hash` ON `MemorySourceEpisodicImageRelation` (`source_image_hash`)");
        r1.execSQL("CREATE INDEX IF NOT EXISTS `index_MemorySourceEpisodicImageRelation_episodic_id` ON `MemorySourceEpisodicImageRelation` (`episodic_id`)");
        r1.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_MemorySourceEpisodicImageRelation_source_image_hash_episodic_id` ON `MemorySourceEpisodicImageRelation` (`source_image_hash`, `episodic_id`)");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `MemorySourceSemanticImageRelation` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `source_image_hash` TEXT NOT NULL, `product_type` INTEGER NOT NULL, `semantic_id` TEXT, `remembered_time` INTEGER NOT NULL)");
        r1.execSQL("CREATE INDEX IF NOT EXISTS `index_MemorySourceSemanticImageRelation_source_image_hash` ON `MemorySourceSemanticImageRelation` (`source_image_hash`)");
        r1.execSQL("CREATE INDEX IF NOT EXISTS `index_MemorySourceSemanticImageRelation_semantic_id` ON `MemorySourceSemanticImageRelation` (`semantic_id`)");
        r1.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_MemorySourceSemanticImageRelation_source_image_hash_semantic_id` ON `MemorySourceSemanticImageRelation` (`source_image_hash`, `semantic_id`)");
    }
}
