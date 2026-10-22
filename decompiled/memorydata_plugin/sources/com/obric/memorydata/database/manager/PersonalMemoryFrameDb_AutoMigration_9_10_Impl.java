package com.obric.memorydata.database.manager;

import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
class PersonalMemoryFrameDb_AutoMigration_9_10_Impl extends Migration {
    private final AutoMigrationSpec callback;

    public PersonalMemoryFrameDb_AutoMigration_9_10_Impl() {
        super(9, 10);
        this.callback = new PersonalMemoryContextSyncMigration.AutoMigration9To10();
    }

    @Override // androidx.room.migration.Migration
    public void migrate(SupportSQLiteDatabase r3) {
        SupportSQLiteDatabase r4 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        r4.execSQL("CREATE TABLE IF NOT EXISTS `MemoryContextSyncPending` (`uuid` TEXT NOT NULL, `operation` INTEGER NOT NULL, `source_update_time` INTEGER NOT NULL, PRIMARY KEY(`uuid`))");
        r4.execSQL("CREATE TABLE IF NOT EXISTS `MemoryContextSyncState` (`id` INTEGER NOT NULL, `last_reported_reference_memory` INTEGER NOT NULL, `last_reported_personal_info` INTEGER NOT NULL, `last_reported_collection` INTEGER NOT NULL, `batch_not_before_ms` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        this.callback.onPostMigrate(r4);
    }
}
