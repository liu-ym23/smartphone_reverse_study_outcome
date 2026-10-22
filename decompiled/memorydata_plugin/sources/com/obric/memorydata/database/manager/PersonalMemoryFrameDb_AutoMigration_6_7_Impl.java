package com.obric.memorydata.database.manager;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
class PersonalMemoryFrameDb_AutoMigration_6_7_Impl extends Migration {
    public PersonalMemoryFrameDb_AutoMigration_6_7_Impl() {
        super(6, 7);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(SupportSQLiteDatabase r2) {
        SupportSQLiteDatabase r1 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `GlassesEpisodicRelevantData` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `episodic_id` TEXT NOT NULL, `speaker_summary` TEXT NOT NULL, FOREIGN KEY(`episodic_id`) REFERENCES `ShortMemory`(`entityId`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        r1.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_GlassesEpisodicRelevantData_episodic_id` ON `GlassesEpisodicRelevantData` (`episodic_id`)");
    }
}
