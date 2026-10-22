package com.obric.memorydata.database.manager;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
class MemoryFrameDb_AutoMigration_98_99_Impl extends Migration {
    public MemoryFrameDb_AutoMigration_98_99_Impl() {
        super(98, 99);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(SupportSQLiteDatabase r2) {
        SupportSQLiteDatabase r1 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `GlassesSyncState` (`account_scope` TEXT NOT NULL, `last_success_window_end` INTEGER NOT NULL DEFAULT 0, PRIMARY KEY(`account_scope`))");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `SpeakerEmbeddingPending` (`embedding_id` TEXT NOT NULL, `session_id` TEXT NOT NULL, `local_speaker_id` TEXT NOT NULL, `model_version` TEXT NOT NULL, `vector` TEXT NOT NULL, `raw_observation_ids` TEXT NOT NULL, `phase_state` TEXT NOT NULL DEFAULT 'PREPARED', `created_at` INTEGER NOT NULL DEFAULT 0, `updated_at` INTEGER NOT NULL DEFAULT 0, PRIMARY KEY(`embedding_id`))");
    }
}
