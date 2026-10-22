package com.obric.memorydata.database.manager;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
class MemoryFrameDb_AutoMigration_87_88_Impl extends Migration {
    public MemoryFrameDb_AutoMigration_87_88_Impl() {
        super(87, 88);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(SupportSQLiteDatabase r2) {
        SupportSQLiteDatabase r1 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `AssistantChatMessageEntity` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `messageId` TEXT NOT NULL, `replyId` TEXT, `collectionId` TEXT, `createTime` INTEGER NOT NULL, `timestamp` INTEGER NOT NULL, `type` TEXT NOT NULL, `omniId` TEXT, `omniState` TEXT, `content` TEXT NOT NULL)");
        r1.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_AssistantChatMessageEntity_messageId` ON `AssistantChatMessageEntity` (`messageId`)");
    }
}
