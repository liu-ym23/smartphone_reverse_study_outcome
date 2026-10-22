package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.obric.memorydata.database.entity.AuditorySyncStateEntity;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class AuditorySyncStateDao_Impl implements AuditorySyncStateDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<AuditorySyncStateEntity> __insertionAdapterOfAuditorySyncStateEntity;
    private final SharedSQLiteStatement __preparedStmtOfDeleteByAccount;

    public AuditorySyncStateDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfAuditorySyncStateEntity = new AnonymousClass1(this, r2);
        this.__preparedStmtOfDeleteByAccount = new AnonymousClass2(this, r2);
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.AuditorySyncStateDao
    public int deleteByAccount(String r3) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfDeleteByAccount.acquire();
        if (r3 != null) goto L5;
        r0.bindNull(1);
    L6:
        this.__db.beginTransaction();
        int r4 = r0.executeUpdateDelete();     // Catch: Throwable -> L10
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteByAccount.release(r0);
        return r4;
    L10:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteByAccount.release(r0);
        throw th;
    L5:
        r0.bindString(1, r3);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.AuditorySyncStateDao
    public AuditorySyncStateEntity query(String r11) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM AuditorySyncState WHERE account_scope = ? LIMIT 1", 1);
        if (r11 != null) goto L5;
        r0.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        AuditorySyncStateEntity r1 = null;
        String r2 = null;
        Cursor r10 = DBUtil.query(this.__db, r0, false, null);
        int r12 = CursorUtil.getColumnIndexOrThrow(r10, "account_scope");     // Catch: Throwable -> L16
        int r3 = CursorUtil.getColumnIndexOrThrow(r10, "last_file_end_ms");     // Catch: Throwable -> L16
        int r4 = CursorUtil.getColumnIndexOrThrow(r10, "last_query_end_ms");     // Catch: Throwable -> L16
        if (r10.moveToFirst() == true) goto L10;
    L14:
        r10.close();
        r0.release();
        return r1;
    L10:
        if (r10.isNull(r12) == false) goto L12;
    L11:
        String r5 = r2;
        r1 = new AuditorySyncStateEntity(r5, r10.getLong(r3), r10.getLong(r4));     // Catch: Throwable -> L16
        goto L14
    L12:
        r2 = r10.getString(r12);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        r10.close();
        r0.release();
        throw th;
    L5:
        r0.bindString(1, r11);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.AuditorySyncStateDao
    public void upsert(AuditorySyncStateEntity r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfAuditorySyncStateEntity.insert(r2);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
