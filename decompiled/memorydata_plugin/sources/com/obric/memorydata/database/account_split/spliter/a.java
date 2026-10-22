package com.obric.memorydata.database.account_split.spliter;

import android.database.Cursor;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.database.account_split.w;
import com.obric.memorydata.database.account_split.x;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.obric.memorydata.middleware.database.i;
import com.obric.memorydata.utils.q;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH\u0007J(\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005H\u0003J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0010H\u0002J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0005H\u0002J\u0018\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0005H\u0002J\u0018\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0005H\u0002J\u0018\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0005H\u0002J \u0010\u001b\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0010H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/obric/memorydata/database/account_split/spliter/PersonalDbSplitAutoIncrementReserver;", "", "<init>", "()V", "TAG", "", "PRIMARY_KEY_ID", "reserveCurrentProfileAutoIncrementIfNeededBlocking", "", "reserveTableAutoIncrementIfNeeded", "sourceDb", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "targetDb", "sourceTableName", "targetTableName", "calculateReservedSequence", "", "sourceMaxId", "targetMaxId", "currentSeq", "hasIdPrimaryKey", "", "db", "tableName", "isAutoIncrementTable", "queryMaxId", "querySqliteSequence", "updateSqliteSequence", "reservedSeq", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8818a = null;

    static {
        f8818a = new a();
    }

    private a() {
    }

    private final long a(long r1, long r3, long r5) {
        return Math.max(r1, Math.max(r3, r5));
    }

    private final void a(SupportSQLiteDatabase r22, SupportSQLiteDatabase r23, String r24, String r25) {
        SupportSQLiteDatabase r0 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r22, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        SupportSQLiteDatabase r10 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r23, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        if (a(r10, r25) == true) goto L7;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "db_iso_PersonalDbSplitAutoIncrementReserver", "reserve auto increment skipped, table=" + r25 + ", reason=no_id_primary_key", false, 4, null);
        return;
    L7:
        if (b(r10, r25) == true) goto L11;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "db_iso_PersonalDbSplitAutoIncrementReserver", "reserve auto increment skipped, table=" + r25 + ", reason=not_autoincrement", false, 4, null);
        return;
    L11:
        if (d.f8821a.a(r10) == true) goto L14;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "db_iso_PersonalDbSplitAutoIncrementReserver", "reserve auto increment skipped, table=" + r25 + ", reason=no_sqlite_sequence", null, 4, null);
        return;
    L14:
        long r11 = c(r0, r24);
        long r13 = c(r10, r25);
        long r5 = d(r10, r25);
        long r1 = a(r11, r13, r5);
        if (r1 > r5) goto L18;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "db_iso_PersonalDbSplitAutoIncrementReserver", "reserve auto increment unchanged, table=" + r25 + ", sourceMaxId=" + r11 + ", targetMaxId=" + r13 + ", currentSeq=" + r5, false, 4, null);
        return;
    L18:
        a(r10, r25, r1);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "db_iso_PersonalDbSplitAutoIncrementReserver", "reserve auto increment finished, table=" + r25 + ", sourceMaxId=" + r11 + ", targetMaxId=" + r13 + ", oldSeq=" + r5 + ", newSeq=" + r1, false, 4, null);
    }

    private final void a(SupportSQLiteDatabase r2, String r3, long r4) {
        ((SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin")).execSQL("INSERT OR REPLACE INTO sqlite_sequence(name, seq) VALUES(?, ?)", new Object[]{r3, Long.valueOf(r4)});
    }

    private final boolean a(SupportSQLiteDatabase r8, String r9) {
        Closeable r7 = (Closeable) ZeusTransformUtils.preCheckCast(((SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r8, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin")).query("PRAGMA table_info(" + d.f8821a.a(r9) + ')'), Closeable.class, "com.obric.memorydata.plugin");
        Cursor r10 = (Cursor) ZeusTransformUtils.preCheckCast(r7, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        int r11 = r10.getColumnIndex(ActivityLifecycle.NAME);     // Catch: Throwable -> L16
        int r0 = r10.getColumnIndex("pk");     // Catch: Throwable -> L16
        boolean r1 = false;
        boolean r3 = false;
        int r4 = 0;
    L5:
        if (r10.moveToNext() == false) goto L11;
        if (r10.getInt(r0) <= 0) goto L5;
        r4 = r4 + 1;     // Catch: Throwable -> L16
        if (Intrinsics.areEqual(r10.getString(r11), OaidModel.KEY_ID) == false) goto L5;
        r3 = true;
        goto L5
    L11:
        if (r3 == false) goto L14;
        if (r4 != 1) goto L14;
        r1 = true;
    L14:
        CloseableKt.closeFinally(r7, null);
        return r1;
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        CloseableKt.closeFinally(r7, th);
        throw th;
    }

    private final boolean b(SupportSQLiteDatabase r5, String r6) {
        SupportSQLiteDatabase r4 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r5, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        boolean r7 = true;
        Closeable r8 = (Closeable) ZeusTransformUtils.preCheckCast(r4.query("SELECT sql FROM sqlite_master WHERE type = 'table' AND name = ?", new String[]{r6}), Closeable.class, "com.obric.memorydata.plugin");
        Cursor r9 = (Cursor) ZeusTransformUtils.preCheckCast(r8, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r9.moveToFirst() == false) goto L8;
        String r10 = r9.getString(0);     // Catch: Throwable -> L11
        Intrinsics.checkNotNullExpressionValue(r10, "getString(...)");     // Catch: Throwable -> L11
        if (StringsKt.contains((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("AUTOINCREMENT", CharSequence.class, "com.obric.memorydata.plugin"), true) == false) goto L8;
    L9:
        CloseableKt.closeFinally(r8, null);
        return r7;
    L8:
        r7 = false;
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        CloseableKt.closeFinally(r8, th);
        throw th;
    }

    private final long c(SupportSQLiteDatabase r4, String r5) {
        Closeable r3 = (Closeable) ZeusTransformUtils.preCheckCast(((SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin")).query("SELECT COALESCE(MAX(" + d.f8821a.a(OaidModel.KEY_ID) + "), 0) FROM " + d.f8821a.a(r5)), Closeable.class, "com.obric.memorydata.plugin");
        Cursor r6 = (Cursor) ZeusTransformUtils.preCheckCast(r3, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r6.moveToFirst() == false) goto L7;
        long r7 = r6.getLong(0);     // Catch: Throwable -> L10
    L8:
        CloseableKt.closeFinally(r3, null);
        return r7;
    L7:
        r7 = 0;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        CloseableKt.closeFinally(r3, th);
        throw th;
    }

    private final long d(SupportSQLiteDatabase r3, String r4) {
        Closeable r2 = (Closeable) ZeusTransformUtils.preCheckCast(((SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin")).query("SELECT seq FROM sqlite_sequence WHERE name = ?", new String[]{r4}), Closeable.class, "com.obric.memorydata.plugin");
        Cursor r5 = (Cursor) ZeusTransformUtils.preCheckCast(r2, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r5.moveToFirst() == false) goto L7;
        long r6 = r5.getLong(0);     // Catch: Throwable -> L10
    L8:
        CloseableKt.closeFinally(r2, null);
        return r6;
    L7:
        r6 = 0;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        CloseableKt.closeFinally(r2, th);
        throw th;
    }

    public final void a() {
        if (IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getBoolean("personal_sql_split_migration_done_v2", false) == false) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "db_iso_PersonalDbSplitAutoIncrementReserver", "reserve auto increment skipped, migration already done", false, 4, null);
        return;
    L6:
        i r10 = c.f8820a.a();
        SupportSQLiteDatabase r0 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getOpenHelper().getWritableDatabase();
        SupportSQLiteDatabase r2 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getOpenHelper().getWritableDatabase();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "db_iso_PersonalDbSplitAutoIncrementReserver", "reserve auto increment start, profileId=" + q.f13259a.b(r10.a()) + ", anonymous=" + r10.c(), false, 4, null);
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(w.f8834a.a(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L8:
        if (r11.hasNext() == false) goto L10;
        x r3 = (x) ZeusTransformUtils.preCheckCast(r11.next(), x.class, "com.obric.memorydata.plugin");
        f8818a.a(r0, r2, r3.e().getTableName(), r3.f().getTableName());
        goto L8
    }
}
