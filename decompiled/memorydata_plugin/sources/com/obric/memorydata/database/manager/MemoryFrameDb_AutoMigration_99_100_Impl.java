package com.obric.memorydata.database.manager;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
class MemoryFrameDb_AutoMigration_99_100_Impl extends Migration {
    public MemoryFrameDb_AutoMigration_99_100_Impl() {
        super(99, 100);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(SupportSQLiteDatabase r2) {
        SupportSQLiteDatabase r1 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `EntityIndexLifecycle` (`rawDbId` INTEGER NOT NULL, `entityType` INTEGER NOT NULL, `firstCompletionStartedAt` INTEGER NOT NULL DEFAULT 0, `backlogRoundStartedAt` INTEGER NOT NULL DEFAULT 0, `firstCompletionFinished` INTEGER NOT NULL DEFAULT 0, `backlogRoundId` INTEGER NOT NULL DEFAULT 0, `updatedAt` INTEGER NOT NULL DEFAULT 0, `coveragePolicyVersion` INTEGER NOT NULL DEFAULT 0, `coverageSourceTimestamp` INTEGER NOT NULL DEFAULT 0, `coverageRequiredCount` INTEGER NOT NULL DEFAULT -1, `coverageSuccessCount` INTEGER NOT NULL DEFAULT 0, `coverageTerminalFailureCount` INTEGER NOT NULL DEFAULT 0, `coverageState` INTEGER NOT NULL DEFAULT 0, PRIMARY KEY(`rawDbId`, `entityType`))");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `_new_AppEntityIndexPending` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `rawDbId` INTEGER NOT NULL, `entityType` INTEGER NOT NULL, `timestamp` INTEGER NOT NULL, `createTimeStamp` INTEGER NOT NULL DEFAULT 0, `state` INTEGER NOT NULL, `progress` INTEGER NOT NULL, `columnContent` TEXT NOT NULL, `buildType` TEXT NOT NULL, `indexProgress` INTEGER NOT NULL, `total` INTEGER NOT NULL, `extra` TEXT NOT NULL, `isScheduledSlowTask` INTEGER NOT NULL DEFAULT 0, `retryCount` INTEGER NOT NULL DEFAULT 0, `nextRetryAt` INTEGER NOT NULL DEFAULT 0)");
        r1.execSQL("INSERT INTO `_new_AppEntityIndexPending` (`id`,`rawDbId`,`entityType`,`timestamp`,`createTimeStamp`,`state`,`progress`,`columnContent`,`buildType`,`indexProgress`,`total`,`extra`,`isScheduledSlowTask`,`retryCount`,`nextRetryAt`) SELECT `id`,`rawDbId`,`entityType`,`timestamp`,`createTimeStamp`,`state`,`progress`,`columnContent`,`buildType`,`indexProgress`,`total`,`extra`,`isScheduledSlowTask`,`retryCount`,`nextRetryAt` FROM `AppEntityIndexPending`");
        r1.execSQL("DROP TABLE `AppEntityIndexPending`");
        r1.execSQL("ALTER TABLE `_new_AppEntityIndexPending` RENAME TO `AppEntityIndexPending`");
        r1.execSQL("CREATE INDEX IF NOT EXISTS `index_AppEntityIndexPending_rawDbId_entityType` ON `AppEntityIndexPending` (`rawDbId`, `entityType`)");
    }
}
