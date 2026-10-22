package com.obric.memorydata.database.manager;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
class MemoryFrameDb_AutoMigration_100_101_Impl extends Migration {
    public MemoryFrameDb_AutoMigration_100_101_Impl() {
        super(100, 101);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(SupportSQLiteDatabase r2) {
        SupportSQLiteDatabase r1 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `AuditoryAsrTask` (`task_id` TEXT NOT NULL, `account_scope` TEXT NOT NULL, `status` TEXT NOT NULL, `audio_start_ms` INTEGER NOT NULL, `audio_end_ms` INTEGER NOT NULL DEFAULT 0, `audio_start_time` TEXT NOT NULL DEFAULT '', `audio_end_time` TEXT NOT NULL DEFAULT '', `audio_timezone` TEXT NOT NULL DEFAULT '', `audio_path` TEXT NOT NULL DEFAULT '', `manifest` TEXT NOT NULL DEFAULT '{}', `audio_sha256` TEXT NOT NULL DEFAULT '', `tos_key` TEXT, `retry_count` INTEGER NOT NULL DEFAULT 0, `last_error` TEXT NOT NULL DEFAULT '', `terminal_at` INTEGER NOT NULL DEFAULT 0, `observation_id` TEXT NOT NULL DEFAULT '', `raw_observation_ids` TEXT NOT NULL DEFAULT '[]', `submit_log_id` TEXT NOT NULL DEFAULT '', `result_log_id` TEXT NOT NULL DEFAULT '', `request_log_ids` TEXT NOT NULL DEFAULT '[]', `evidence_state` TEXT NOT NULL DEFAULT 'NONE', `created_at` INTEGER NOT NULL, `updated_at` INTEGER NOT NULL, PRIMARY KEY(`task_id`))");
        r1.execSQL("CREATE INDEX IF NOT EXISTS `index_AuditoryAsrTask_account_scope_status_audio_start_ms` ON `AuditoryAsrTask` (`account_scope`, `status`, `audio_start_ms`)");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `AuditorySyncState` (`account_scope` TEXT NOT NULL, `last_file_end_ms` INTEGER NOT NULL DEFAULT 0, `last_query_end_ms` INTEGER NOT NULL DEFAULT 0, PRIMARY KEY(`account_scope`))");
    }
}
