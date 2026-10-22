package com.obric.memorydata.database.manager;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
class PersonalMemoryFrameDb_AutoMigration_5_6_Impl extends Migration {
    public PersonalMemoryFrameDb_AutoMigration_5_6_Impl() {
        super(5, 6);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(SupportSQLiteDatabase r2) {
        SupportSQLiteDatabase r1 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `PersonAudioProfile` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `profileId` TEXT NOT NULL DEFAULT '', `embedding` TEXT NOT NULL DEFAULT '[]', `dim` INTEGER NOT NULL DEFAULT 0, `resourceId` TEXT, `modelVersion` TEXT NOT NULL DEFAULT '', `durationMs` INTEGER NOT NULL DEFAULT 0, `createdAt` INTEGER NOT NULL DEFAULT 0)");
        r1.execSQL("CREATE INDEX IF NOT EXISTS `index_PersonAudioProfile_profileId` ON `PersonAudioProfile` (`profileId`)");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `PersonImageProfile` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `profileId` TEXT NOT NULL DEFAULT '', `embedding` TEXT NOT NULL DEFAULT '[]', `dim` INTEGER NOT NULL DEFAULT 0, `resourceId` TEXT, `modelVersion` TEXT NOT NULL DEFAULT '', `confidence` TEXT, `profileImageType` TEXT NOT NULL DEFAULT 'face', `createdAt` INTEGER NOT NULL DEFAULT 0)");
        r1.execSQL("CREATE INDEX IF NOT EXISTS `index_PersonImageProfile_profileId` ON `PersonImageProfile` (`profileId`)");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `PersonProfile` (`profileId` TEXT NOT NULL, `alias` TEXT NOT NULL DEFAULT '', `aliasConfidence` TEXT, `summary` TEXT NOT NULL DEFAULT '', `summaryConfidence` TEXT, `l1RefIds` TEXT NOT NULL DEFAULT '[]', `createdAt` INTEGER NOT NULL DEFAULT 0, `updatedAt` INTEGER NOT NULL DEFAULT 0, PRIMARY KEY(`profileId`))");
        r1.execSQL("CREATE INDEX IF NOT EXISTS `index_PersonProfile_updatedAt` ON `PersonProfile` (`updatedAt`)");
    }
}
