package com.obric.memorydata.database.manager;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
class MemoryFrameDb_AutoMigration_46_47_Impl extends Migration {
    public MemoryFrameDb_AutoMigration_46_47_Impl() {
        super(46, 47);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(SupportSQLiteDatabase r2) {
        ((SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin")).execSQL("CREATE TABLE IF NOT EXISTS `LocalMemorySyncToDoubaoPending` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `type` INTEGER NOT NULL, `entityId` TEXT NOT NULL, `timestamp` INTEGER NOT NULL, `content` TEXT, `alreadySyncDoubaoUid` TEXT, `syncToDoubaoUid` TEXT)");
    }
}
