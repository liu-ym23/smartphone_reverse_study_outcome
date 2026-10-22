package com.obric.memorydata.database.manager;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
class MemoryFrameDb_AutoMigration_18_19_Impl extends Migration {
    public MemoryFrameDb_AutoMigration_18_19_Impl() {
        super(18, 19);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(SupportSQLiteDatabase r2) {
        SupportSQLiteDatabase r1 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `_new_ShortMemory` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `actionTimestamp` INTEGER NOT NULL, `uid` INTEGER NOT NULL, `content` TEXT NOT NULL, `observation` TEXT NOT NULL, `location` TEXT NOT NULL, `appNames` TEXT NOT NULL, `entityId` TEXT NOT NULL, `createTime` INTEGER NOT NULL, `modifyTime` INTEGER NOT NULL, `type` INTEGER NOT NULL, `timestamp` INTEGER NOT NULL, `packageName` TEXT NOT NULL, `hashCodeValue` INTEGER NOT NULL)");
        r1.execSQL("INSERT INTO `_new_ShortMemory` (`id`,`actionTimestamp`,`uid`,`content`,`observation`,`location`,`appNames`,`entityId`,`createTime`,`modifyTime`,`type`,`timestamp`,`packageName`,`hashCodeValue`) SELECT `id`,`actionTimestamp`,`uid`,`content`,`observation`,`location`,`appNames`,`entityId`,`createTime`,`modifyTime`,`type`,`timestamp`,`packageName`,`hashCodeValue` FROM `ShortMemory`");
        r1.execSQL("DROP TABLE `ShortMemory`");
        r1.execSQL("ALTER TABLE `_new_ShortMemory` RENAME TO `ShortMemory`");
    }
}
