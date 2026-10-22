package com.obric.memorydata.database.manager;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
class MemoryFrameDb_AutoMigration_103_104_Impl extends Migration {
    public MemoryFrameDb_AutoMigration_103_104_Impl() {
        super(103, 104);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(SupportSQLiteDatabase r2) {
        ((SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin")).execSQL("CREATE TABLE IF NOT EXISTS `in_app_l1_rule` (`package_name` TEXT NOT NULL, `rule_id` TEXT NOT NULL, `engine_version` INTEGER NOT NULL, `rule_version` TEXT NOT NULL, `min_app_version_code` INTEGER NOT NULL DEFAULT -1, `max_app_version_code` INTEGER NOT NULL DEFAULT -1, `rule_json` TEXT NOT NULL, `business` TEXT NOT NULL, PRIMARY KEY(`package_name`, `rule_id`))");
    }
}
