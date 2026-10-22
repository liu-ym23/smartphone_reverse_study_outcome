package com.obric.memorydata.database.manager;

import android.database.Cursor;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0015\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000¢\u0006\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/database/manager/PersonalMemoryInAppMigration;", "Landroidx/room/migration/Migration;", "<init>", "()V", "migrate", "", "db", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "ensureMainlineV12Tables", "ensureInAppColumns", "ensureInAppColumns$database_obricRelease", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PersonalMemoryInAppMigration extends Migration {
    public static final PersonalMemoryInAppMigration INSTANCE = null;

    static {
        INSTANCE = new PersonalMemoryInAppMigration();
    }

    private PersonalMemoryInAppMigration() {
        super(12, 13);
    }

    private final void ensureMainlineV12Tables(SupportSQLiteDatabase r2) {
        SupportSQLiteDatabase r1 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `MemorySynthesisRun` (`runId` TEXT NOT NULL, `requestId` TEXT NOT NULL, `requestHash` TEXT NOT NULL, `attempt` INTEGER NOT NULL, `status` TEXT NOT NULL, `nowMs` INTEGER NOT NULL, `startedAt` INTEGER NOT NULL, `deadlineAt` INTEGER NOT NULL, `finishedAt` INTEGER, `updatedAt` INTEGER NOT NULL, `configJson` TEXT NOT NULL, `statsJson` TEXT NOT NULL, `reviewHistoryJson` TEXT NOT NULL, `errorCode` TEXT, PRIMARY KEY(`runId`))");
        r1.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_MemorySynthesisRun_requestId` ON `MemorySynthesisRun` (`requestId`)");
        r1.execSQL("CREATE TABLE IF NOT EXISTS `MemorySynthesisTaskCard` (`taskId` TEXT NOT NULL, `runId` TEXT NOT NULL, `schemaVersion` INTEGER NOT NULL, `query` TEXT NOT NULL, `reason` TEXT NOT NULL, `taskDesignJson` TEXT NOT NULL, `memoryRefsJson` TEXT NOT NULL, `checkpointsJson` TEXT NOT NULL, `queryStyleJson` TEXT NOT NULL, `reviewJson` TEXT NOT NULL, `status` TEXT NOT NULL, `createTime` INTEGER NOT NULL, PRIMARY KEY(`taskId`))");
        r1.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_MemorySynthesisTaskCard_runId` ON `MemorySynthesisTaskCard` (`runId`)");
        r1.execSQL("CREATE INDEX IF NOT EXISTS `index_MemorySynthesisTaskCard_status_createTime_taskId` ON `MemorySynthesisTaskCard` (`status`, `createTime`, `taskId`)");
    }

    public final void ensureInAppColumns$database_obricRelease(SupportSQLiteDatabase r6) {
        SupportSQLiteDatabase r5 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r6, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "db");
        Set r7 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        Closeable r1 = (Closeable) ZeusTransformUtils.preCheckCast(r5.query("PRAGMA table_info(`ProactiveEpisodicRelevantData`)"), Closeable.class, "com.obric.memorydata.plugin");
        Cursor r0 = (Cursor) ZeusTransformUtils.preCheckCast(r1, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
        int r2 = r0.getColumnIndexOrThrow(ActivityLifecycle.NAME);     // Catch: Throwable -> L22
    L5:
        if (r0.moveToNext() == false) goto L7;
        String r3 = r0.getString(r2);     // Catch: Throwable -> L22
        Intrinsics.checkNotNullExpressionValue(r3, "getString(...)");     // Catch: Throwable -> L22
        r7.add(r3);     // Catch: Throwable -> L22
        goto L5
    L7:
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L22
        CloseableKt.closeFinally(r1, null);
        if (r7.contains("in_app_object_id") == true) goto L12;
        r5.execSQL("ALTER TABLE `ProactiveEpisodicRelevantData` ADD COLUMN `in_app_object_id` TEXT");
    L12:
        if (r7.contains("in_app_rule_family") == true) goto L15;
        r5.execSQL("ALTER TABLE `ProactiveEpisodicRelevantData` ADD COLUMN `in_app_rule_family` TEXT");
    L15:
        if (r7.contains("in_app_activity_name") == true) goto L18;
        r5.execSQL("ALTER TABLE `ProactiveEpisodicRelevantData` ADD COLUMN `in_app_activity_name` TEXT");
    L18:
        if (r7.contains("in_app_event_time") == true) goto L20;
        r5.execSQL("ALTER TABLE `ProactiveEpisodicRelevantData` ADD COLUMN `in_app_event_time` INTEGER");
    L20:
        r5.execSQL("CREATE INDEX IF NOT EXISTS `index_ProactiveEpisodicRelevantData_source_package_name_in_app_object_id` ON `ProactiveEpisodicRelevantData` (`source_package_name`, `in_app_object_id`)");
        r5.execSQL("CREATE INDEX IF NOT EXISTS `index_ProactiveEpisodicRelevantData_source_package_name_in_app_activity_name_in_app_rule_family_in_app_event_time` ON `ProactiveEpisodicRelevantData` (`source_package_name`, `in_app_activity_name`, `in_app_rule_family`, `in_app_event_time`)");
        r5.execSQL("CREATE TABLE IF NOT EXISTS `MemoryContextSyncPending` (`uuid` TEXT NOT NULL, `operation` INTEGER NOT NULL, `source_update_time` INTEGER NOT NULL, PRIMARY KEY(`uuid`))");
        r5.execSQL("CREATE TABLE IF NOT EXISTS `MemoryContextSyncState` (`id` INTEGER NOT NULL, `last_reported_reference_memory` INTEGER NOT NULL, `last_reported_personal_info` INTEGER NOT NULL, `last_reported_collection` INTEGER NOT NULL, `batch_not_before_ms` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        PersonalMemoryContextSyncMigration.f9558a.a(r5);
        return;
    L22:
        th = move-exception;
        throw th;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        CloseableKt.closeFinally(r1, th);
        throw th;
    }

    @Override // androidx.room.migration.Migration
    public void migrate(SupportSQLiteDatabase r3) {
        SupportSQLiteDatabase r4 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "db");
        ensureMainlineV12Tables(r4);
        ensureInAppColumns$database_obricRelease(r4);
    }
}
