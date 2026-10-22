package com.obric.memorydata.database.manager;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
class MemoryFrameDb_AutoMigration_69_70_Impl extends Migration {
    public MemoryFrameDb_AutoMigration_69_70_Impl() {
        super(69, 70);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(SupportSQLiteDatabase r2) {
        SupportSQLiteDatabase r1 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `UnionSemanticMemoryHistoryEntity` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `semantic_id` INTEGER NOT NULL, `semantic_entityId` TEXT NOT NULL, `semantic_createTime` INTEGER NOT NULL, `semantic_modifyTime` INTEGER NOT NULL, `semantic_type` INTEGER NOT NULL, `semantic_timestamp` INTEGER NOT NULL, `semantic_packageName` TEXT NOT NULL, `semantic_hashCodeValue` INTEGER NOT NULL, `semantic_uuid` TEXT, `semantic_semantic_type` TEXT NOT NULL, `semantic_tag_path` TEXT NOT NULL, `semantic_key_phrase` TEXT NOT NULL, `semantic_description` TEXT NOT NULL, `semantic_embedding_content` TEXT NOT NULL, `semantic_sources` TEXT NOT NULL, `semantic_user_edit` INTEGER NOT NULL, `semantic_evidence_count` INTEGER NOT NULL, `semantic_product_type` INTEGER NOT NULL)");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `RawMemoryHistoryEntity` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `memory_id` INTEGER NOT NULL, `memory_entityId` TEXT NOT NULL, `memory_createTime` INTEGER NOT NULL, `memory_modifyTime` INTEGER NOT NULL, `memory_type` INTEGER NOT NULL, `memory_timestamp` INTEGER NOT NULL, `memory_packageName` TEXT NOT NULL, `memory_hashCodeValue` INTEGER NOT NULL, `memory_uuid` TEXT, `memory_memoryType` INTEGER NOT NULL, `memory_productType` INTEGER NOT NULL, `memory_startDate` INTEGER, `memory_startTime` INTEGER, `memory_endDate` INTEGER, `memory_endTime` INTEGER, `memory_sourceLinkType` TEXT, `memory_sourceLink` TEXT, `memory_screenshot` TEXT, `memory_locations` TEXT, `memory_summary` TEXT, `memory_fullContent` TEXT, `memory_key1` TEXT, `memory_key2` TEXT, `memory_key3` TEXT, `memory_key4` TEXT, `memory_key5` TEXT, `memory_keyword1` TEXT, `memory_keyword2` TEXT, `memory_keyword3` TEXT, `memory_keyword4` TEXT, `memory_keyword5` TEXT, `memory_keyword6` TEXT, `memory_semantic1` TEXT, `memory_semantic2` TEXT, `memory_keywordAndSemantic1` TEXT, `memory_keywordAndSemantic2` TEXT, `memory_sourceText` TEXT, `memory_sourcePackageName` TEXT, `memory_sourceAppName` TEXT, `memory_logId` TEXT, `memory_sourceQuery` TEXT, `memory_detail` TEXT, `memory_detailStatus` INTEGER NOT NULL DEFAULT 0, `memory_contentWithTime` TEXT, `memory_userEdit` INTEGER NOT NULL DEFAULT 0)");
    }
}
