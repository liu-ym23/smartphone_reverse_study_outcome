package com.obric.memorydata.database.manager;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
class PersonalMemoryFrameDb_AutoMigration_4_5_Impl extends Migration {
    public PersonalMemoryFrameDb_AutoMigration_4_5_Impl() {
        super(4, 5);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(SupportSQLiteDatabase r2) {
        SupportSQLiteDatabase r1 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        r1.execSQL("ALTER TABLE `AppEntityIndexPending` ADD COLUMN `retryCount` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `AppEntityIndexPending` ADD COLUMN `nextRetryAt` INTEGER NOT NULL DEFAULT 0");
    }
}
