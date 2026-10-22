package com.obric.memorydata.database.manager;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
class MemoryFrameDb_AutoMigration_96_97_Impl extends Migration {
    public MemoryFrameDb_AutoMigration_96_97_Impl() {
        super(96, 97);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(SupportSQLiteDatabase r2) {
        SupportSQLiteDatabase r1 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        r1.execSQL("ALTER TABLE `AppEntityIndexPending` ADD COLUMN `retryCount` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("ALTER TABLE `AppEntityIndexPending` ADD COLUMN `nextRetryAt` INTEGER NOT NULL DEFAULT 0");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `LocationAddressCache` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `latitudeE5` INTEGER NOT NULL, `longitudeE5` INTEGER NOT NULL, `localeTag` TEXT NOT NULL, `resolverVersion` INTEGER NOT NULL, `country` TEXT, `stateOrProvince` TEXT, `administrativeArea` TEXT, `locality` TEXT, `subLocality` TEXT, `thoroughfare` TEXT, `subThoroughfare` TEXT, `namedLocation` TEXT, `fullAddress` TEXT, `isEmptyResult` INTEGER NOT NULL, `expiresAt` INTEGER NOT NULL, `updatedAt` INTEGER NOT NULL)");
        r1.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_LocationAddressCache_latitudeE5_longitudeE5_localeTag_resolverVersion` ON `LocationAddressCache` (`latitudeE5`, `longitudeE5`, `localeTag`, `resolverVersion`)");
    }
}
