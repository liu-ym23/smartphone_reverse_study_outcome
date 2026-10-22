package com.obric.memorydata.database.manager;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
class PersonalMemoryFrameDb_AutoMigration_1_2_Impl extends Migration {
    public PersonalMemoryFrameDb_AutoMigration_1_2_Impl() {
        super(1, 2);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(SupportSQLiteDatabase r2) {
        SupportSQLiteDatabase r1 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `AssistantChatEntity` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `logId` TEXT NOT NULL, `messages` TEXT NOT NULL, `createdAt` INTEGER NOT NULL, `updatedAt` INTEGER NOT NULL)");
        r1.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_AssistantChatEntity_logId` ON `AssistantChatEntity` (`logId`)");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `AutoMemoryProEvaluationStats` (`uuid` TEXT NOT NULL DEFAULT '', `stat` TEXT NOT NULL DEFAULT '', PRIMARY KEY(`uuid`))");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `AutoMemoryProRawSource` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `target` TEXT NOT NULL DEFAULT 'cloud_model', `sourceType` TEXT NOT NULL, `sourceKey` TEXT NOT NULL, `query` TEXT NOT NULL, `contentPartsJson` TEXT NOT NULL, `timestamp` INTEGER NOT NULL, `state` TEXT NOT NULL, `retryCount` INTEGER NOT NULL, `lastErrorCode` INTEGER NOT NULL, `logId` TEXT NOT NULL, `updateTime` INTEGER NOT NULL)");
        r1.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_AutoMemoryProRawSource_target_sourceType_sourceKey` ON `AutoMemoryProRawSource` (`target`, `sourceType`, `sourceKey`)");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `ComplexRecommendQuery` (`query` TEXT NOT NULL, `createTime` INTEGER NOT NULL, `priority` INTEGER NOT NULL, `reason` TEXT NOT NULL, `expireTime` INTEGER NOT NULL, `sources` TEXT NOT NULL DEFAULT '[]', `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL)");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `MemoryProcessUserInsight` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `profileKey` TEXT NOT NULL, `summary` TEXT NOT NULL, `description` TEXT NOT NULL, `profileJson` TEXT NOT NULL, `evidenceRefs` TEXT NOT NULL, `sourceEventIds` TEXT NOT NULL, `processedForUnion` INTEGER NOT NULL DEFAULT 0, `logId` TEXT NOT NULL DEFAULT '', `createTime` INTEGER NOT NULL, `updateTime` INTEGER NOT NULL)");
        r1.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_MemoryProcessUserInsight_profileKey` ON `MemoryProcessUserInsight` (`profileKey`)");
        r1.execSQL("CREATE INDEX IF NOT EXISTS `index_MemoryProcessUserInsight_processedForUnion_updateTime` ON `MemoryProcessUserInsight` (`processedForUnion`, `updateTime`)");
        r1.execSQL("CREATE INDEX IF NOT EXISTS `index_MemoryProcessUserInsight_logId` ON `MemoryProcessUserInsight` (`logId`)");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `PendingContext` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `context_id` TEXT NOT NULL, `source_type` TEXT NOT NULL, `messages_json` TEXT NOT NULL, `expires_at_ms` INTEGER NOT NULL, `state` TEXT NOT NULL, `session_id` TEXT NOT NULL DEFAULT '', `pre_build_time` INTEGER NOT NULL DEFAULT 0, `extra` TEXT NOT NULL DEFAULT '')");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `PendingSemantic` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `context_id` TEXT NOT NULL, `state` TEXT NOT NULL, `lease_until_ms` INTEGER NOT NULL, `retry_count` INTEGER NOT NULL, `last_error_code` INTEGER NOT NULL, `business_type` TEXT NOT NULL DEFAULT '')");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `UnionUserInsight` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `summary` TEXT NOT NULL, `description` TEXT NOT NULL, `createTime` INTEGER NOT NULL)");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `UnionUserPersona` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `summary` TEXT NOT NULL, `description` TEXT NOT NULL, `createTime` INTEGER NOT NULL)");
    }
}
