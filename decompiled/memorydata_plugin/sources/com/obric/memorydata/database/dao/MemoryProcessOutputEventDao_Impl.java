package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.obric.memorydata.database.entity.cx;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class MemoryProcessOutputEventDao_Impl implements MemoryProcessOutputEventDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<cx> __insertionAdapterOfMemoryProcessOutputEventEntity;
    private final SharedSQLiteStatement __preparedStmtOfAck;

    public MemoryProcessOutputEventDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfMemoryProcessOutputEventEntity = new AnonymousClass1(this, r2);
        this.__preparedStmtOfAck = new AnonymousClass2(this, r2);
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.MemoryProcessOutputEventDao
    public int ack(String r3, long r4) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfAck.acquire();
        r0.bindLong(1, r4);
        if (r3 != null) goto L5;
        r0.bindNull(2);
    L6:
        this.__db.beginTransaction();
        int r5 = r0.executeUpdateDelete();     // Catch: Throwable -> L10
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.__db.endTransaction();
        this.__preparedStmtOfAck.release(r0);
        return r5;
    L10:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfAck.release(r0);
        throw th;
    L5:
        r0.bindString(2, r3);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.MemoryProcessOutputEventDao
    public long insert(cx r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfMemoryProcessOutputEventEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.MemoryProcessOutputEventDao
    public List<cx> queryPending(int r29) {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM MemoryProcessOutputEvent WHERE status = 'PENDING' ORDER BY createTime ASC LIMIT ?", 1);
        r1.bindLong(1, r29);
        this.__db.assertNotSuspendingTransaction();
        Cursor r2 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r2, "eventId");     // Catch: Throwable -> L42
        int r4 = CursorUtil.getColumnIndexOrThrow(r2, "businessId");     // Catch: Throwable -> L42
        int r5 = CursorUtil.getColumnIndexOrThrow(r2, "outputType");     // Catch: Throwable -> L42
        int r6 = CursorUtil.getColumnIndexOrThrow(r2, "outputEntityIds");     // Catch: Throwable -> L42
        int r7 = CursorUtil.getColumnIndexOrThrow(r2, "operationRecordId");     // Catch: Throwable -> L42
        int r8 = CursorUtil.getColumnIndexOrThrow(r2, "status");     // Catch: Throwable -> L42
        int r9 = CursorUtil.getColumnIndexOrThrow(r2, "logId");     // Catch: Throwable -> L42
        int r10 = CursorUtil.getColumnIndexOrThrow(r2, "payload");     // Catch: Throwable -> L42
        int r11 = CursorUtil.getColumnIndexOrThrow(r2, "createTime");     // Catch: Throwable -> L42
        int r12 = CursorUtil.getColumnIndexOrThrow(r2, "updateTime");     // Catch: Throwable -> L42
        ArrayList r13 = new ArrayList(r2.getCount());     // Catch: Throwable -> L42
    L4:
        if (r2.moveToNext() == false) goto L40;
        if (r2.isNull(r0) == false) goto L9;
        String r16 = null;
    L11:
        if (r2.isNull(r4) == false) goto L13;
        String r17 = null;
    L15:
        if (r2.isNull(r5) == false) goto L17;
        String r18 = null;
    L19:
        if (r2.isNull(r6) == false) goto L21;
        String r19 = null;
    L23:
        if (r2.isNull(r7) == false) goto L25;
        String r20 = null;
    L27:
        if (r2.isNull(r8) == false) goto L29;
        String r21 = null;
    L31:
        if (r2.isNull(r9) == false) goto L33;
        String r22 = null;
    L35:
        if (r2.isNull(r10) == false) goto L37;
        String r23 = null;
    L38:
        r13.add(new cx(r16, r17, r18, r19, r20, r21, r22, r23, r2.getLong(r11), r2.getLong(r12)));     // Catch: Throwable -> L42
        goto L4
    L37:
        r23 = r2.getString(r10);     // Catch: Throwable -> L42
        goto L38
    L33:
        r22 = r2.getString(r9);     // Catch: Throwable -> L42
        goto L35
    L29:
        r21 = r2.getString(r8);     // Catch: Throwable -> L42
        goto L31
    L25:
        r20 = r2.getString(r7);     // Catch: Throwable -> L42
        goto L27
    L21:
        r19 = r2.getString(r6);     // Catch: Throwable -> L42
        goto L23
    L17:
        r18 = r2.getString(r5);     // Catch: Throwable -> L42
        goto L19
    L13:
        r17 = r2.getString(r4);     // Catch: Throwable -> L42
        goto L15
    L9:
        r16 = r2.getString(r0);     // Catch: Throwable -> L42
        goto L11
    L40:
        r2.close();
        r1.release();
        return r13;
    L42:
        th = move-exception;
        r2.close();
        r1.release();
        throw th;
    }
}
