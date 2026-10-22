package com.obric.memorydata.database.manager;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
class MemoryFrameDb_AutoMigration_38_39_Impl extends Migration {
    public MemoryFrameDb_AutoMigration_38_39_Impl() {
        super(38, 39);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(SupportSQLiteDatabase r2) {
        SupportSQLiteDatabase r1 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `RawAuditoryRecordingEntity` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `entityId` TEXT NOT NULL, `createTime` INTEGER NOT NULL, `modifyTime` INTEGER NOT NULL, `type` INTEGER NOT NULL, `timestamp` INTEGER NOT NULL, `packageName` TEXT NOT NULL, `hashCodeValue` INTEGER NOT NULL, `name` TEXT NOT NULL, `state` INTEGER NOT NULL, `file` TEXT NOT NULL, `duration` INTEGER NOT NULL, `transcript` TEXT, `summary` TEXT, `todoList` TEXT, `markers` TEXT, `sourceAppName` TEXT, `sourceAppPackage` TEXT, `docNodeJson` TEXT, `uuid` TEXT)");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `RawAuditoryRecordingTextEntity` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `entityId` TEXT NOT NULL, `createTime` INTEGER NOT NULL, `modifyTime` INTEGER NOT NULL, `type` INTEGER NOT NULL, `timestamp` INTEGER NOT NULL, `packageName` TEXT NOT NULL, `hashCodeValue` INTEGER NOT NULL, `parentEntityId` TEXT NOT NULL, `content` TEXT NOT NULL, `passageDocNodeTreeJson` TEXT NOT NULL, `uuid` TEXT)");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `AuditoryRecordingTextEntityTextVectorCopilot` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `rawDbId` INTEGER NOT NULL, `rawDbColumn` TEXT NOT NULL, `text` TEXT NOT NULL)");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `AuditoryRecordingEntityTextVectorCopilot` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `rawDbId` INTEGER NOT NULL, `rawDbColumn` TEXT NOT NULL, `text` TEXT NOT NULL)");
    }
}
