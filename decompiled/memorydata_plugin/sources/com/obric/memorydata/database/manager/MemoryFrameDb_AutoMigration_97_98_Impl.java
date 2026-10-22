package com.obric.memorydata.database.manager;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
class MemoryFrameDb_AutoMigration_97_98_Impl extends Migration {
    public MemoryFrameDb_AutoMigration_97_98_Impl() {
        super(97, 98);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(SupportSQLiteDatabase r2) {
        SupportSQLiteDatabase r1 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `InAppTraceUpload` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `file_id` TEXT NOT NULL, `trace_session_id` TEXT NOT NULL, `local_path` TEXT NOT NULL, `start_timestamp` INTEGER NOT NULL, `end_timestamp` INTEGER NOT NULL, `event_count` INTEGER NOT NULL, `zip_size` INTEGER NOT NULL, `sha256` TEXT NOT NULL, `state` TEXT NOT NULL, `tos_uri` TEXT NOT NULL, `retry_count` INTEGER NOT NULL, `next_retry_at` INTEGER NOT NULL, `last_error` TEXT NOT NULL, `created_at` INTEGER NOT NULL, `updated_at` INTEGER NOT NULL, `lease_until` INTEGER NOT NULL, `observation_id` INTEGER NOT NULL DEFAULT 0)");
        r1.execSQL("CREATE INDEX IF NOT EXISTS `index_InAppTraceUpload_state_next_retry_at` ON `InAppTraceUpload` (`state`, `next_retry_at`)");
        r1.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_InAppTraceUpload_local_path` ON `InAppTraceUpload` (`local_path`)");
        r1.execSQL("CREATE INDEX IF NOT EXISTS `index_InAppTraceUpload_start_timestamp_end_timestamp` ON `InAppTraceUpload` (`start_timestamp`, `end_timestamp`)");
        r1.execSQL("CREATE INDEX IF NOT EXISTS `index_InAppTraceUpload_observation_id_state` ON `InAppTraceUpload` (`observation_id`, `state`)");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `InAppTraceObservation` (`trace_row_id` INTEGER NOT NULL, `observation_id` INTEGER NOT NULL, `created_at` INTEGER NOT NULL, PRIMARY KEY(`trace_row_id`, `observation_id`))");
        r1.execSQL("CREATE INDEX IF NOT EXISTS `index_InAppTraceObservation_observation_id` ON `InAppTraceObservation` (`observation_id`)");
    }
}
