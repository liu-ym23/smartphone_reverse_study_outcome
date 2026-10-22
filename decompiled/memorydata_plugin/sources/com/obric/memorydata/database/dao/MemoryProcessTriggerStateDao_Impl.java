package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import com.obric.memorydata.database.entity.cz;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class MemoryProcessTriggerStateDao_Impl implements MemoryProcessTriggerStateDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<cz> __insertionAdapterOfMemoryProcessTriggerStateEntity;
    private final EntityDeletionOrUpdateAdapter<cz> __updateAdapterOfMemoryProcessTriggerStateEntity;

    public MemoryProcessTriggerStateDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfMemoryProcessTriggerStateEntity = new AnonymousClass1(this, r2);
        this.__updateAdapterOfMemoryProcessTriggerStateEntity = new AnonymousClass2(this, r2);
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.MemoryProcessTriggerStateDao
    public int countPendingSources(String r4, String r5, String r6) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM MemoryProcessSourceEvent WHERE businessId = ? AND groupKey = ? AND triggerMode = ? AND state = 'PENDING'", 3);
        if (r4 != null) goto L5;
        r0.bindNull(1);
    L7:
        if (r5 != null) goto L9;
        r0.bindNull(2);
    L10:
        if (r6 != null) goto L12;
        r0.bindNull(3);
    L13:
        this.__db.assertNotSuspendingTransaction();
        int r7 = 0;
        Cursor r3 = DBUtil.query(this.__db, r0, false, null);
    L19:
        th = move-exception;
        r3.close();
        r0.release();
        throw th;
    L15:
        if (r3.moveToFirst() == false) goto L17;
        r7 = r3.getInt(0);     // Catch: Throwable -> L19
    L17:
        r3.close();
        r0.release();
        return r7;
    L12:
        r0.bindString(3, r6);
        goto L13
    L9:
        r0.bindString(2, r5);
        goto L10
    L5:
        r0.bindString(1, r4);
        goto L7
    }

    @Override // com.obric.memorydata.database.dao.MemoryProcessTriggerStateDao
    public long insert(cz r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfMemoryProcessTriggerStateEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.MemoryProcessTriggerStateDao
    public cz queryByGroup(String r33, String r34, String r35) {
        RoomSQLiteQuery r4 = RoomSQLiteQuery.acquire("SELECT * FROM MemoryProcessTriggerState WHERE businessId = ? AND groupKey = ? AND triggerMode = ? LIMIT 1", 3);
        if (r33 != null) goto L5;
        r4.bindNull(1);
    L7:
        if (r34 != null) goto L9;
        r4.bindNull(2);
    L10:
        if (r35 != null) goto L12;
        r4.bindNull(3);
    L13:
        this.__db.assertNotSuspendingTransaction();
        cz r2 = null;
        String r3 = null;
        Cursor r1 = DBUtil.query(this.__db, r4, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r1, "stateId");     // Catch: Throwable -> L47
        int r5 = CursorUtil.getColumnIndexOrThrow(r1, "businessId");     // Catch: Throwable -> L47
        int r6 = CursorUtil.getColumnIndexOrThrow(r1, "groupKey");     // Catch: Throwable -> L47
        int r7 = CursorUtil.getColumnIndexOrThrow(r1, "triggerMode");     // Catch: Throwable -> L47
        int r8 = CursorUtil.getColumnIndexOrThrow(r1, "state");     // Catch: Throwable -> L47
        int r9 = CursorUtil.getColumnIndexOrThrow(r1, "firstEventTime");     // Catch: Throwable -> L47
        int r10 = CursorUtil.getColumnIndexOrThrow(r1, "lastEventTime");     // Catch: Throwable -> L47
        int r11 = CursorUtil.getColumnIndexOrThrow(r1, "nextRunTime");     // Catch: Throwable -> L47
        int r12 = CursorUtil.getColumnIndexOrThrow(r1, "runMode");     // Catch: Throwable -> L47
        int r13 = CursorUtil.getColumnIndexOrThrow(r1, "pendingCount");     // Catch: Throwable -> L47
        int r14 = CursorUtil.getColumnIndexOrThrow(r1, "logId");     // Catch: Throwable -> L47
        int r15 = CursorUtil.getColumnIndexOrThrow(r1, "updateTime");     // Catch: Throwable -> L47
        if (r1.moveToFirst() == true) goto L17;
    L45:
        r1.close();
        r4.release();
        return r2;
    L17:
        if (r1.isNull(r0) == false) goto L19;
        String r16 = null;
    L21:
        if (r1.isNull(r5) == false) goto L23;
        String r17 = null;
    L25:
        if (r1.isNull(r6) == false) goto L27;
        String r18 = null;
    L29:
        if (r1.isNull(r7) == false) goto L31;
        String r19 = null;
    L33:
        if (r1.isNull(r8) == false) goto L35;
        String r20 = null;
    L36:
        long r21 = r1.getLong(r9);     // Catch: Throwable -> L47
        long r23 = r1.getLong(r10);     // Catch: Throwable -> L47
        long r25 = r1.getLong(r11);     // Catch: Throwable -> L47
        if (r1.isNull(r12) == false) goto L39;
        String r27 = null;
    L40:
        int r28 = r1.getInt(r13);     // Catch: Throwable -> L47
        if (r1.isNull(r14) == true) goto L44;
        r3 = r1.getString(r14);     // Catch: Throwable -> L47
    L44:
        r2 = new cz(r16, r17, r18, r19, r20, r21, r23, r25, r27, r28, r3, r1.getLong(r15));     // Catch: Throwable -> L47
        goto L45
    L39:
        r27 = r1.getString(r12);     // Catch: Throwable -> L47
        goto L40
    L35:
        r20 = r1.getString(r8);     // Catch: Throwable -> L47
        goto L36
    L31:
        r19 = r1.getString(r7);     // Catch: Throwable -> L47
        goto L33
    L27:
        r18 = r1.getString(r6);     // Catch: Throwable -> L47
        goto L29
    L23:
        r17 = r1.getString(r5);     // Catch: Throwable -> L47
        goto L25
    L19:
        r16 = r1.getString(r0);     // Catch: Throwable -> L47
    L47:
        th = move-exception;
        r1.close();
        r4.release();
        throw th;
    L12:
        r4.bindString(3, r35);
        goto L13
    L9:
        r4.bindString(2, r34);
        goto L10
    L5:
        r4.bindString(1, r33);
        goto L7
    }

    @Override // com.obric.memorydata.database.dao.MemoryProcessTriggerStateDao
    public List<cz> queryByState(String r34, int r35) {
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire("SELECT * FROM MemoryProcessTriggerState WHERE state = ? ORDER BY nextRunTime ASC LIMIT ?", 2);
        if (r34 != null) goto L5;
        r2.bindNull(1);
    L6:
        r2.bindLong(2, r35);
        this.__db.assertNotSuspendingTransaction();
        Cursor r1 = DBUtil.query(this.__db, r2, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r1, "stateId");     // Catch: Throwable -> L42
        int r4 = CursorUtil.getColumnIndexOrThrow(r1, "businessId");     // Catch: Throwable -> L42
        int r5 = CursorUtil.getColumnIndexOrThrow(r1, "groupKey");     // Catch: Throwable -> L42
        int r6 = CursorUtil.getColumnIndexOrThrow(r1, "triggerMode");     // Catch: Throwable -> L42
        int r7 = CursorUtil.getColumnIndexOrThrow(r1, "state");     // Catch: Throwable -> L42
        int r8 = CursorUtil.getColumnIndexOrThrow(r1, "firstEventTime");     // Catch: Throwable -> L42
        int r9 = CursorUtil.getColumnIndexOrThrow(r1, "lastEventTime");     // Catch: Throwable -> L42
        int r10 = CursorUtil.getColumnIndexOrThrow(r1, "nextRunTime");     // Catch: Throwable -> L42
        int r11 = CursorUtil.getColumnIndexOrThrow(r1, "runMode");     // Catch: Throwable -> L42
        int r12 = CursorUtil.getColumnIndexOrThrow(r1, "pendingCount");     // Catch: Throwable -> L42
        int r13 = CursorUtil.getColumnIndexOrThrow(r1, "logId");     // Catch: Throwable -> L42
        int r14 = CursorUtil.getColumnIndexOrThrow(r1, "updateTime");     // Catch: Throwable -> L42
        ArrayList r15 = new ArrayList(r1.getCount());     // Catch: Throwable -> L42
    L8:
        if (r1.moveToNext() == false) goto L40;
        if (r1.isNull(r0) == false) goto L13;
        String r17 = null;
    L15:
        if (r1.isNull(r4) == false) goto L17;
        String r18 = null;
    L19:
        if (r1.isNull(r5) == false) goto L21;
        String r19 = null;
    L23:
        if (r1.isNull(r6) == false) goto L25;
        String r20 = null;
    L27:
        if (r1.isNull(r7) == false) goto L29;
        String r21 = null;
    L30:
        long r22 = r1.getLong(r8);     // Catch: Throwable -> L42
        long r24 = r1.getLong(r9);     // Catch: Throwable -> L42
        long r26 = r1.getLong(r10);     // Catch: Throwable -> L42
        if (r1.isNull(r11) == false) goto L33;
        String r28 = null;
    L34:
        int r29 = r1.getInt(r12);     // Catch: Throwable -> L42
        if (r1.isNull(r13) == false) goto L37;
        String r30 = null;
    L38:
        r15.add(new cz(r17, r18, r19, r20, r21, r22, r24, r26, r28, r29, r30, r1.getLong(r14)));     // Catch: Throwable -> L42
        goto L8
    L37:
        r30 = r1.getString(r13);     // Catch: Throwable -> L42
        goto L38
    L33:
        r28 = r1.getString(r11);     // Catch: Throwable -> L42
        goto L34
    L29:
        r21 = r1.getString(r7);     // Catch: Throwable -> L42
        goto L30
    L25:
        r20 = r1.getString(r6);     // Catch: Throwable -> L42
        goto L27
    L21:
        r19 = r1.getString(r5);     // Catch: Throwable -> L42
        goto L23
    L17:
        r18 = r1.getString(r4);     // Catch: Throwable -> L42
        goto L19
    L13:
        r17 = r1.getString(r0);     // Catch: Throwable -> L42
        goto L15
    L40:
        r1.close();
        r2.release();
        return r15;
    L42:
        th = move-exception;
        r1.close();
        r2.release();
        throw th;
    L5:
        r2.bindString(1, r34);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.MemoryProcessTriggerStateDao
    public cz queryByStateId(String r33) {
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire("SELECT * FROM MemoryProcessTriggerState WHERE stateId = ? LIMIT 1", 1);
        if (r33 != null) goto L5;
        r2.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        cz r3 = null;
        String r4 = null;
        Cursor r1 = DBUtil.query(this.__db, r2, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r1, "stateId");     // Catch: Throwable -> L40
        int r5 = CursorUtil.getColumnIndexOrThrow(r1, "businessId");     // Catch: Throwable -> L40
        int r6 = CursorUtil.getColumnIndexOrThrow(r1, "groupKey");     // Catch: Throwable -> L40
        int r7 = CursorUtil.getColumnIndexOrThrow(r1, "triggerMode");     // Catch: Throwable -> L40
        int r8 = CursorUtil.getColumnIndexOrThrow(r1, "state");     // Catch: Throwable -> L40
        int r9 = CursorUtil.getColumnIndexOrThrow(r1, "firstEventTime");     // Catch: Throwable -> L40
        int r10 = CursorUtil.getColumnIndexOrThrow(r1, "lastEventTime");     // Catch: Throwable -> L40
        int r11 = CursorUtil.getColumnIndexOrThrow(r1, "nextRunTime");     // Catch: Throwable -> L40
        int r12 = CursorUtil.getColumnIndexOrThrow(r1, "runMode");     // Catch: Throwable -> L40
        int r13 = CursorUtil.getColumnIndexOrThrow(r1, "pendingCount");     // Catch: Throwable -> L40
        int r14 = CursorUtil.getColumnIndexOrThrow(r1, "logId");     // Catch: Throwable -> L40
        int r15 = CursorUtil.getColumnIndexOrThrow(r1, "updateTime");     // Catch: Throwable -> L40
        if (r1.moveToFirst() == true) goto L10;
    L38:
        r1.close();
        r2.release();
        return r3;
    L10:
        if (r1.isNull(r0) == false) goto L12;
        String r16 = null;
    L14:
        if (r1.isNull(r5) == false) goto L16;
        String r17 = null;
    L18:
        if (r1.isNull(r6) == false) goto L20;
        String r18 = null;
    L22:
        if (r1.isNull(r7) == false) goto L24;
        String r19 = null;
    L26:
        if (r1.isNull(r8) == false) goto L28;
        String r20 = null;
    L29:
        long r21 = r1.getLong(r9);     // Catch: Throwable -> L40
        long r23 = r1.getLong(r10);     // Catch: Throwable -> L40
        long r25 = r1.getLong(r11);     // Catch: Throwable -> L40
        if (r1.isNull(r12) == false) goto L32;
        String r27 = null;
    L33:
        int r28 = r1.getInt(r13);     // Catch: Throwable -> L40
        if (r1.isNull(r14) == true) goto L37;
        r4 = r1.getString(r14);     // Catch: Throwable -> L40
    L37:
        r3 = new cz(r16, r17, r18, r19, r20, r21, r23, r25, r27, r28, r4, r1.getLong(r15));     // Catch: Throwable -> L40
        goto L38
    L32:
        r27 = r1.getString(r12);     // Catch: Throwable -> L40
        goto L33
    L28:
        r20 = r1.getString(r8);     // Catch: Throwable -> L40
        goto L29
    L24:
        r19 = r1.getString(r7);     // Catch: Throwable -> L40
        goto L26
    L20:
        r18 = r1.getString(r6);     // Catch: Throwable -> L40
        goto L22
    L16:
        r17 = r1.getString(r5);     // Catch: Throwable -> L40
        goto L18
    L12:
        r16 = r1.getString(r0);     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        r1.close();
        r2.release();
        throw th;
    L5:
        r2.bindString(1, r33);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.MemoryProcessTriggerStateDao
    public int update(cz r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfMemoryProcessTriggerStateEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
