package com.obric.memorydata.database.manager;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
class PersonalMemoryFrameDb_AutoMigration_3_4_Impl extends Migration {
    public PersonalMemoryFrameDb_AutoMigration_3_4_Impl() {
        super(3, 4);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(SupportSQLiteDatabase r2) {
        SupportSQLiteDatabase r1 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        r1.execSQL("ALTER TABLE `AutoMemoryPro` ADD COLUMN `poison_label` INTEGER DEFAULT NULL");
        r1.execSQL("ALTER TABLE `AutoMemoryPro` ADD COLUMN `poison_label_version` INTEGER DEFAULT NULL");
        r1.execSQL("ALTER TABLE `AutoMemoryPro` ADD COLUMN `content_hash` TEXT DEFAULT NULL");
        r1.execSQL("ALTER TABLE `AutoMemoryProHistoryEntity` ADD COLUMN `auto_memory_pro_poison_label` INTEGER DEFAULT NULL");
        r1.execSQL("ALTER TABLE `AutoMemoryProHistoryEntity` ADD COLUMN `auto_memory_pro_poison_label_version` INTEGER DEFAULT NULL");
        r1.execSQL("ALTER TABLE `AutoMemoryProHistoryEntity` ADD COLUMN `auto_memory_pro_content_hash` TEXT DEFAULT NULL");
        r1.execSQL("ALTER TABLE `ShortMemory` ADD COLUMN `poison_label` INTEGER DEFAULT NULL");
        r1.execSQL("ALTER TABLE `ShortMemory` ADD COLUMN `poison_label_version` INTEGER DEFAULT NULL");
        r1.execSQL("ALTER TABLE `ShortMemory` ADD COLUMN `content_hash` TEXT DEFAULT NULL");
        r1.execSQL("ALTER TABLE `EpisodicMemoryHistoryEntity` ADD COLUMN `episodic_memory_poison_label` INTEGER DEFAULT NULL");
        r1.execSQL("ALTER TABLE `EpisodicMemoryHistoryEntity` ADD COLUMN `episodic_memory_poison_label_version` INTEGER DEFAULT NULL");
        r1.execSQL("ALTER TABLE `EpisodicMemoryHistoryEntity` ADD COLUMN `episodic_memory_content_hash` TEXT DEFAULT NULL");
        r1.execSQL("ALTER TABLE `EpisodicTopicMemory` ADD COLUMN `poison_label` INTEGER DEFAULT NULL");
        r1.execSQL("ALTER TABLE `EpisodicTopicMemory` ADD COLUMN `poison_label_version` INTEGER DEFAULT NULL");
        r1.execSQL("ALTER TABLE `EpisodicTopicMemory` ADD COLUMN `content_hash` TEXT DEFAULT NULL");
        r1.execSQL("ALTER TABLE `EpisodicTopicMemoryHistoryEntity` ADD COLUMN `episodic_topic_memory_poison_label` INTEGER DEFAULT NULL");
        r1.execSQL("ALTER TABLE `EpisodicTopicMemoryHistoryEntity` ADD COLUMN `episodic_topic_memory_poison_label_version` INTEGER DEFAULT NULL");
        r1.execSQL("ALTER TABLE `EpisodicTopicMemoryHistoryEntity` ADD COLUMN `episodic_topic_memory_content_hash` TEXT DEFAULT NULL");
        r1.execSQL("ALTER TABLE `Lifelog` ADD COLUMN `poison_label` INTEGER DEFAULT NULL");
        r1.execSQL("ALTER TABLE `Lifelog` ADD COLUMN `poison_label_version` INTEGER DEFAULT NULL");
        r1.execSQL("ALTER TABLE `Lifelog` ADD COLUMN `content_hash` TEXT DEFAULT NULL");
        r1.execSQL("ALTER TABLE `LifelogHistoryEntity` ADD COLUMN `lifelog_poison_label` INTEGER DEFAULT NULL");
        r1.execSQL("ALTER TABLE `LifelogHistoryEntity` ADD COLUMN `lifelog_poison_label_version` INTEGER DEFAULT NULL");
        r1.execSQL("ALTER TABLE `LifelogHistoryEntity` ADD COLUMN `lifelog_content_hash` TEXT DEFAULT NULL");
        r1.execSQL("ALTER TABLE `RawUserProfileEntity` ADD COLUMN `poison_label` INTEGER DEFAULT NULL");
        r1.execSQL("ALTER TABLE `RawUserProfileEntity` ADD COLUMN `poison_label_version` INTEGER DEFAULT NULL");
        r1.execSQL("ALTER TABLE `RawUserProfileEntity` ADD COLUMN `content_hash` TEXT DEFAULT NULL");
        r1.execSQL("ALTER TABLE `RawUserProfileHistoryEntity` ADD COLUMN `user_profile_poison_label` INTEGER DEFAULT NULL");
        r1.execSQL("ALTER TABLE `RawUserProfileHistoryEntity` ADD COLUMN `user_profile_poison_label_version` INTEGER DEFAULT NULL");
        r1.execSQL("ALTER TABLE `RawUserProfileHistoryEntity` ADD COLUMN `user_profile_content_hash` TEXT DEFAULT NULL");
        r1.execSQL("ALTER TABLE `UnionSemanticMemory` ADD COLUMN `poison_label` INTEGER DEFAULT NULL");
        r1.execSQL("ALTER TABLE `UnionSemanticMemory` ADD COLUMN `poison_label_version` INTEGER DEFAULT NULL");
        r1.execSQL("ALTER TABLE `UnionSemanticMemory` ADD COLUMN `content_hash` TEXT DEFAULT NULL");
        r1.execSQL("ALTER TABLE `UnionSemanticMemoryHistoryEntity` ADD COLUMN `semantic_poison_label` INTEGER DEFAULT NULL");
        r1.execSQL("ALTER TABLE `UnionSemanticMemoryHistoryEntity` ADD COLUMN `semantic_poison_label_version` INTEGER DEFAULT NULL");
        r1.execSQL("ALTER TABLE `UnionSemanticMemoryHistoryEntity` ADD COLUMN `semantic_content_hash` TEXT DEFAULT NULL");
    }
}
