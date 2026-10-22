package com.obric.memorydata.migration.sdk.internal.db;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.migration.sdk.MigrationStep;
import com.obric.memorydata.migration.sdk.m;
import com.obric.memorydata.migration.sdk.p;
import com.obric.memorydata.migration.sdk.t;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a\u0010\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\nH\u0002\u001a\u0010\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\rH\u0002\u001a\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\f\u001a\u00020\rH\u0002\u001a\u0010\u0010\u0011\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\rH\u0002¨\u0006\u0012"}, d2 = {"clearTargetDbDataBeforeLocalPackageImport", "", "restoreDir", "Ljava/io/File;", "backupConfig", "Lcom/obric/memorydata/migration/sdk/BackupConfig;", "callback", "Lcom/obric/memorydata/migration/sdk/MigrationCallback;", "clearOneTargetDb", "dbConfig", "Lcom/obric/memorydata/migration/sdk/DbConfig;", "clearAllUserTables", "db", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "listUserTables", "", "", "checkpoint", "migration_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class d {
    private static final void a(SupportSQLiteDatabase r9) {
        SupportSQLiteDatabase r10 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r9, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        boolean r1 = a.a(r10);
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L5
        r10.execSQL("PRAGMA foreign_keys=OFF");     // Catch: Throwable -> L5
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L8:
        if (a.a(r10) == false) goto L54;
        t.f11981a.a("sqlite pragma foreign_keys=OFF not applied (maybe inside a transaction)");
    L54:
        r10.beginTransaction();     // Catch: Throwable -> L37
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(b(r10), Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L34
    L13:
        if (r4.hasNext() == false) goto L26;
        String r5 = (String) ZeusTransformUtils.preCheckCast(r4.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L34
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L17
        r10.execSQL("DELETE FROM `" + r5 + '`');     // Catch: Throwable -> L17
        Object r7 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L17
    L19:
        Throwable r8 = Result.m1424exceptionOrNullimpl(r7);     // Catch: Throwable -> L34
        if (r8 == null) goto L48;
        t.f11981a.a("local package import: clear table failed, table=" + r5, r8);     // Catch: Throwable -> L34
    L48:
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L24
        r10.execSQL("DELETE FROM sqlite_sequence WHERE name='" + r5 + '\'');     // Catch: Throwable -> L24
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L34
        Result.m1421constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L34
        goto L13
    L17:
        th = move-exception;
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L34
        r7 = Result.m1421constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L34
        goto L19
    L26:
        r10.setTransactionSuccessful();     // Catch: Throwable -> L34
        r10.endTransaction();     // Catch: Throwable -> L37
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L37
        if (r1 == false) goto L61;
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L31
        r10.execSQL("PRAGMA foreign_keys=ON");     // Catch: Throwable -> L31
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L31
        return;
    L31:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        return;
    L61:
        return;
    L34:
        th = move-exception;
        r10.endTransaction();     // Catch: Throwable -> L37
        throw th;     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        if (r1 == true) goto L46;
    L43:
        throw th;
    L46:
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L41
        r10.execSQL("PRAGMA foreign_keys=ON");     // Catch: Throwable -> L41
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
    L5:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    private static final void a(com.obric.memorydata.migration.sdk.g r6) {
        Pair<RoomDatabase, SupportSQLiteDatabase> r0 = a.c(r6);
        RoomDatabase r1 = (RoomDatabase) ZeusTransformUtils.preCheckCast(r0.component1(), RoomDatabase.class, "com.obric.memorydata.plugin");
        SupportSQLiteDatabase r2 = (SupportSQLiteDatabase) ZeusTransformUtils.preCheckCast(r0.component2(), SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        Unit r3 = null;
        t.f11981a.a("local package import: clear target db start, db=" + r6.a());     // Catch: Throwable -> L12
        c(r2);     // Catch: Throwable -> L12
        a(r2);     // Catch: Throwable -> L12
        c(r2);     // Catch: Throwable -> L12
        t.f11981a.a("local package import: clear target db end, db=" + r6.a());     // Catch: Throwable -> L12
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L9
        if (r1 == null) goto L7;
        r1.close();     // Catch: Throwable -> L9
        r3 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        Result.m1421constructorimpl(r3);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        return;
    L12:
        th = move-exception;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L18
        if (r1 == null) goto L16;
        r1.close();     // Catch: Throwable -> L18
        r3 = Unit.INSTANCE;     // Catch: Throwable -> L18
    L16:
        Result.m1421constructorimpl(r3);     // Catch: Throwable -> L18
    L20:
        throw th;
    L18:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L20
    }

    public static final void a(File r7, com.obric.memorydata.migration.sdk.b r8, m r9) {
        m r10 = (m) ZeusTransformUtils.wrapperContextForParams(r9, m.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "restoreDir");
        Intrinsics.checkNotNullParameter(r8, "backupConfig");
        Intrinsics.checkNotNullParameter(r10, "callback");
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(r8.a(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r12 = r11.iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        Object r2 = r12.next();
        if (new File(r7, "dbs/" + a.a(((com.obric.memorydata.migration.sdk.g) ZeusTransformUtils.preCheckCast(r2, com.obric.memorydata.migration.sdk.g.class, "com.obric.memorydata.plugin")).a())).exists() == false) goto L4;
        r0.add(r2);
        goto L4
    L8:
        List r13 = (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");
        if (r13.isEmpty() == false) goto L12;
        t.f11981a.a("local package import: no snapshot db found, skip target db cleanup");
        return;
    L12:
        r10.onEvent((p) ZeusTransformUtils.preCheckCast(new p.e(MigrationStep.RESTORING, "清理本地旧数据"), p.class, "com.obric.memorydata.plugin"));
        Iterator r14 = ((Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L14:
        if (r14.hasNext() == false) goto L16;
        a((com.obric.memorydata.migration.sdk.g) ZeusTransformUtils.preCheckCast(r14.next(), com.obric.memorydata.migration.sdk.g.class, "com.obric.memorydata.plugin"));
        goto L14
    }

    private static final List<String> b(SupportSQLiteDatabase r8) {
        SupportSQLiteDatabase r9 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r8, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        List r0 = CollectionsKt.createListBuilder();
        Closeable r10 = (Closeable) ZeusTransformUtils.preCheckCast(r9.query("SELECT name FROM sqlite_master WHERE type='table'"), Closeable.class, "com.obric.memorydata.plugin");
        Cursor r1 = (Cursor) ZeusTransformUtils.preCheckCast(r10, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        int r2 = r1.getColumnIndex(ActivityLifecycle.NAME);     // Catch: Throwable -> L20
    L5:
        if (r1.moveToNext() == false) goto L17;
        String r3 = r1.getString(r2);     // Catch: Throwable -> L20
        if (r3 == null) goto L5;
        if (StringsKt.startsWith$default(r3, "sqlite_", false, 2, null) == true) goto L5;
        if (Intrinsics.areEqual(r3, "android_metadata") == true) goto L5;
        if (Intrinsics.areEqual(r3, "room_master_table") == true) goto L5;
        r0.add(r3);     // Catch: Throwable -> L20
        goto L5
    L17:
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L20
        CloseableKt.closeFinally(r10, null);
        return CollectionsKt.build(r0);
    L20:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        CloseableKt.closeFinally(r10, th);
        throw th;
    }

    private static final void c(SupportSQLiteDatabase r2) {
        SupportSQLiteDatabase r3 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        r3.execSQL("PRAGMA wal_checkpoint(FULL)");     // Catch: Throwable -> L5
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
    }
}
