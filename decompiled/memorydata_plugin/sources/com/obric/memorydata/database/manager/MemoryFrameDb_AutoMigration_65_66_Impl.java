package com.obric.memorydata.database.manager;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
class MemoryFrameDb_AutoMigration_65_66_Impl extends Migration {
    public MemoryFrameDb_AutoMigration_65_66_Impl() {
        super(65, 66);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(SupportSQLiteDatabase r2) {
        SupportSQLiteDatabase r1 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `AssistantChatEntity` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `logId` TEXT NOT NULL, `messages` TEXT NOT NULL, `createdAt` INTEGER NOT NULL, `updatedAt` INTEGER NOT NULL)");
        r1.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_AssistantChatEntity_logId` ON `AssistantChatEntity` (`logId`)");
    }
}
