package com.obric.memorydata.database.manager;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
class PersonalMemoryFrameDb_AutoMigration_11_12_Impl extends Migration {
    public PersonalMemoryFrameDb_AutoMigration_11_12_Impl() {
        super(11, 12);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(SupportSQLiteDatabase r2) {
        SupportSQLiteDatabase r1 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `MemorySynthesisRun` (`runId` TEXT NOT NULL, `requestId` TEXT NOT NULL, `requestHash` TEXT NOT NULL, `attempt` INTEGER NOT NULL, `status` TEXT NOT NULL, `nowMs` INTEGER NOT NULL, `startedAt` INTEGER NOT NULL, `deadlineAt` INTEGER NOT NULL, `finishedAt` INTEGER, `updatedAt` INTEGER NOT NULL, `configJson` TEXT NOT NULL, `statsJson` TEXT NOT NULL, `reviewHistoryJson` TEXT NOT NULL, `errorCode` TEXT, PRIMARY KEY(`runId`))");
        r1.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_MemorySynthesisRun_requestId` ON `MemorySynthesisRun` (`requestId`)");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `MemorySynthesisTaskCard` (`taskId` TEXT NOT NULL, `runId` TEXT NOT NULL, `schemaVersion` INTEGER NOT NULL, `query` TEXT NOT NULL, `reason` TEXT NOT NULL, `taskDesignJson` TEXT NOT NULL, `memoryRefsJson` TEXT NOT NULL, `checkpointsJson` TEXT NOT NULL, `queryStyleJson` TEXT NOT NULL, `reviewJson` TEXT NOT NULL, `status` TEXT NOT NULL, `createTime` INTEGER NOT NULL, PRIMARY KEY(`taskId`))");
        r1.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_MemorySynthesisTaskCard_runId` ON `MemorySynthesisTaskCard` (`runId`)");
        r1.execSQL("CREATE INDEX IF NOT EXISTS `index_MemorySynthesisTaskCard_status_createTime_taskId` ON `MemorySynthesisTaskCard` (`status`, `createTime`, `taskId`)");
    }
}
