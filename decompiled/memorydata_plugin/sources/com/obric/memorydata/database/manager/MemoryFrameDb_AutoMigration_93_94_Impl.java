package com.obric.memorydata.database.manager;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
class MemoryFrameDb_AutoMigration_93_94_Impl extends Migration {
    public MemoryFrameDb_AutoMigration_93_94_Impl() {
        super(93, 94);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(SupportSQLiteDatabase r2) {
        SupportSQLiteDatabase r1 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        r1.execSQL("ALTER TABLE `ComplexRecommendQuery` ADD COLUMN `personalDbSplitMigrated` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `AssistantChatEntity` ADD COLUMN `personalDbSplitMigrated` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `PendingContext` ADD COLUMN `personalDbSplitMigrated` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `PendingSemantic` ADD COLUMN `personalDbSplitMigrated` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `AutoMemoryProEvaluationStats` ADD COLUMN `personalDbSplitMigrated` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `UnionUserInsight` ADD COLUMN `personalDbSplitMigrated` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `UnionUserPersona` ADD COLUMN `personalDbSplitMigrated` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `AutoMemoryProRawSource` ADD COLUMN `personalDbSplitMigrated` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `MemoryProcessUserInsight` ADD COLUMN `personalDbSplitMigrated` INTEGER NOT NULL DEFAULT 0");
    }
}
