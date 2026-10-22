package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.obric.memorydata.database.entity.GlassesSyncStateEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class GlassesSyncStateDao_Impl implements GlassesSyncStateDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<GlassesSyncStateEntity> __insertionAdapterOfGlassesSyncStateEntity;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAll;
    private final SharedSQLiteStatement __preparedStmtOfResetLastSuccessWindowEnd;
    private final EntityDeletionOrUpdateAdapter<GlassesSyncStateEntity> __updateAdapterOfGlassesSyncStateEntity;

    public GlassesSyncStateDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfGlassesSyncStateEntity = new AnonymousClass1(this, r2);
        this.__updateAdapterOfGlassesSyncStateEntity = new AnonymousClass2(this, r2);
        this.__preparedStmtOfResetLastSuccessWindowEnd = new AnonymousClass3(this, r2);
        this.__preparedStmtOfDeleteAll = new AnonymousClass4(this, r2);
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.GlassesSyncStateDao
    public int deleteAll() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfDeleteAll.acquire();
        this.__db.beginTransaction();
        int r1 = r0.executeUpdateDelete();     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteAll.release(r0);
        return r1;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteAll.release(r0);
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.GlassesSyncStateDao
    public long insert(GlassesSyncStateEntity r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfGlassesSyncStateEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.GlassesSyncStateDao
    public List<GlassesSyncStateEntity> queryAll() {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM GlassesSyncState", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor r9 = DBUtil.query(this.__db, r0, false, null);
        int r1 = CursorUtil.getColumnIndexOrThrow(r9, "account_scope");     // Catch: Throwable -> L14
        int r3 = CursorUtil.getColumnIndexOrThrow(r9, "last_success_window_end");     // Catch: Throwable -> L14
        ArrayList r4 = new ArrayList(r9.getCount());     // Catch: Throwable -> L14
    L4:
        if (r9.moveToNext() == false) goto L12;
        if (r9.isNull(r1) == false) goto L9;
        String r5 = null;
    L10:
        r4.add(new GlassesSyncStateEntity(r5, r9.getLong(r3)));     // Catch: Throwable -> L14
        goto L4
    L9:
        r5 = r9.getString(r1);     // Catch: Throwable -> L14
        goto L10
    L12:
        r9.close();
        r0.release();
        return r4;
    L14:
        th = move-exception;
        r9.close();
        r0.release();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.GlassesSyncStateDao
    public GlassesSyncStateEntity queryByAccountScope(String r5) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM GlassesSyncState WHERE account_scope = ? LIMIT 1", 1);
        if (r5 != null) goto L5;
        r0.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        GlassesSyncStateEntity r1 = null;
        String r2 = null;
        Cursor r4 = DBUtil.query(this.__db, r0, false, null);
        int r6 = CursorUtil.getColumnIndexOrThrow(r4, "account_scope");     // Catch: Throwable -> L17
        int r3 = CursorUtil.getColumnIndexOrThrow(r4, "last_success_window_end");     // Catch: Throwable -> L17
        if (r4.moveToFirst() == true) goto L10;
    L15:
        r4.close();
        r0.release();
        return r1;
    L10:
        if (r4.isNull(r6) == true) goto L13;
        r2 = r4.getString(r6);     // Catch: Throwable -> L17
    L13:
        r1 = new GlassesSyncStateEntity(r2, r4.getLong(r3));     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        r4.close();
        r0.release();
        throw th;
    L5:
        r0.bindString(1, r5);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.GlassesSyncStateDao
    public int resetLastSuccessWindowEnd(String r3) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfResetLastSuccessWindowEnd.acquire();
        if (r3 != null) goto L5;
        r0.bindNull(1);
    L6:
        this.__db.beginTransaction();
        int r4 = r0.executeUpdateDelete();     // Catch: Throwable -> L10
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.__db.endTransaction();
        this.__preparedStmtOfResetLastSuccessWindowEnd.release(r0);
        return r4;
    L10:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfResetLastSuccessWindowEnd.release(r0);
        throw th;
    L5:
        r0.bindString(1, r3);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.GlassesSyncStateDao
    public int update(GlassesSyncStateEntity r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfGlassesSyncStateEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
