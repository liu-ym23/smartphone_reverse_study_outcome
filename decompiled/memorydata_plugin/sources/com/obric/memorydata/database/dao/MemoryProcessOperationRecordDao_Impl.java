package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import com.obric.memorydata.database.entity.cw;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class MemoryProcessOperationRecordDao_Impl implements MemoryProcessOperationRecordDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<cw> __insertionAdapterOfMemoryProcessOperationRecordEntity;

    public MemoryProcessOperationRecordDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfMemoryProcessOperationRecordEntity = new AnonymousClass1(this, r2);
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.MemoryProcessOperationRecordDao
    public long insert(cw r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfMemoryProcessOperationRecordEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.MemoryProcessOperationRecordDao
    public List<Long> insertAll(List<cw> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfMemoryProcessOperationRecordEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.MemoryProcessOperationRecordDao
    public List<cw> queryByBusiness(String r33, int r34) {
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire("SELECT * FROM MemoryProcessOperationRecord WHERE businessId = ? ORDER BY createTime DESC LIMIT ?", 2);
        if (r33 != null) goto L5;
        r2.bindNull(1);
    L6:
        r2.bindLong(2, r34);
        this.__db.assertNotSuspendingTransaction();
        Cursor r1 = DBUtil.query(this.__db, r2, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r1, "recordId");     // Catch: Throwable -> L66
        int r4 = CursorUtil.getColumnIndexOrThrow(r1, "businessId");     // Catch: Throwable -> L66
        int r5 = CursorUtil.getColumnIndexOrThrow(r1, "sourceEventIds");     // Catch: Throwable -> L66
        int r6 = CursorUtil.getColumnIndexOrThrow(r1, "operateType");     // Catch: Throwable -> L66
        int r7 = CursorUtil.getColumnIndexOrThrow(r1, "outputType");     // Catch: Throwable -> L66
        int r8 = CursorUtil.getColumnIndexOrThrow(r1, "outputEntityIds");     // Catch: Throwable -> L66
        int r9 = CursorUtil.getColumnIndexOrThrow(r1, "status");     // Catch: Throwable -> L66
        int r10 = CursorUtil.getColumnIndexOrThrow(r1, "logId");     // Catch: Throwable -> L66
        int r11 = CursorUtil.getColumnIndexOrThrow(r1, "toolName");     // Catch: Throwable -> L66
        int r12 = CursorUtil.getColumnIndexOrThrow(r1, "skipReason");     // Catch: Throwable -> L66
        int r13 = CursorUtil.getColumnIndexOrThrow(r1, "payload");     // Catch: Throwable -> L66
        int r14 = CursorUtil.getColumnIndexOrThrow(r1, "metrics");     // Catch: Throwable -> L66
        int r15 = CursorUtil.getColumnIndexOrThrow(r1, "createTime");     // Catch: Throwable -> L66
        RoomSQLiteQuery r16 = r2;
        ArrayList r3 = new ArrayList(r1.getCount());     // Catch: Throwable -> L64
    L10:
        if (r1.moveToNext() == false) goto L62;
        if (r1.isNull(r0) == false) goto L15;
        String r18 = null;
    L17:
        if (r1.isNull(r4) == false) goto L19;
        String r19 = null;
    L21:
        if (r1.isNull(r5) == false) goto L23;
        String r20 = null;
    L25:
        if (r1.isNull(r6) == false) goto L27;
        String r21 = null;
    L29:
        if (r1.isNull(r7) == false) goto L31;
        String r22 = null;
    L33:
        if (r1.isNull(r8) == false) goto L35;
        String r23 = null;
    L37:
        if (r1.isNull(r9) == false) goto L39;
        String r24 = null;
    L41:
        if (r1.isNull(r10) == false) goto L43;
        String r25 = null;
    L45:
        if (r1.isNull(r11) == false) goto L47;
        String r26 = null;
    L49:
        if (r1.isNull(r12) == false) goto L51;
        String r27 = null;
    L53:
        if (r1.isNull(r13) == false) goto L55;
        String r28 = null;
    L57:
        if (r1.isNull(r14) == false) goto L59;
        String r29 = null;
    L60:
        r3.add(new cw(r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r1.getLong(r15)));     // Catch: Throwable -> L64
        goto L10
    L59:
        r29 = r1.getString(r14);     // Catch: Throwable -> L64
        goto L60
    L55:
        r28 = r1.getString(r13);     // Catch: Throwable -> L64
        goto L57
    L51:
        r27 = r1.getString(r12);     // Catch: Throwable -> L64
        goto L53
    L47:
        r26 = r1.getString(r11);     // Catch: Throwable -> L64
        goto L49
    L43:
        r25 = r1.getString(r10);     // Catch: Throwable -> L64
        goto L45
    L39:
        r24 = r1.getString(r9);     // Catch: Throwable -> L64
        goto L41
    L35:
        r23 = r1.getString(r8);     // Catch: Throwable -> L64
        goto L37
    L31:
        r22 = r1.getString(r7);     // Catch: Throwable -> L64
        goto L33
    L27:
        r21 = r1.getString(r6);     // Catch: Throwable -> L64
        goto L29
    L23:
        r20 = r1.getString(r5);     // Catch: Throwable -> L64
        goto L25
    L19:
        r19 = r1.getString(r4);     // Catch: Throwable -> L64
        goto L21
    L15:
        r18 = r1.getString(r0);     // Catch: Throwable -> L64
        goto L17
    L62:
        r1.close();
        r16.release();
        return r3;
    L64:
        th = th;
    L68:
        r1.close();
        r16.release();
        throw th;
    L66:
        th = th;
        r16 = r2;
        goto L68
    L5:
        r2.bindString(1, r33);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.MemoryProcessOperationRecordDao
    public List<cw> queryRecent(int r33) {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM MemoryProcessOperationRecord ORDER BY createTime DESC LIMIT ?", 1);
        r1.bindLong(1, r33);
        this.__db.assertNotSuspendingTransaction();
        Cursor r2 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r2, "recordId");     // Catch: Throwable -> L62
        int r4 = CursorUtil.getColumnIndexOrThrow(r2, "businessId");     // Catch: Throwable -> L62
        int r5 = CursorUtil.getColumnIndexOrThrow(r2, "sourceEventIds");     // Catch: Throwable -> L62
        int r6 = CursorUtil.getColumnIndexOrThrow(r2, "operateType");     // Catch: Throwable -> L62
        int r7 = CursorUtil.getColumnIndexOrThrow(r2, "outputType");     // Catch: Throwable -> L62
        int r8 = CursorUtil.getColumnIndexOrThrow(r2, "outputEntityIds");     // Catch: Throwable -> L62
        int r9 = CursorUtil.getColumnIndexOrThrow(r2, "status");     // Catch: Throwable -> L62
        int r10 = CursorUtil.getColumnIndexOrThrow(r2, "logId");     // Catch: Throwable -> L62
        int r11 = CursorUtil.getColumnIndexOrThrow(r2, "toolName");     // Catch: Throwable -> L62
        int r12 = CursorUtil.getColumnIndexOrThrow(r2, "skipReason");     // Catch: Throwable -> L62
        int r13 = CursorUtil.getColumnIndexOrThrow(r2, "payload");     // Catch: Throwable -> L62
        int r14 = CursorUtil.getColumnIndexOrThrow(r2, "metrics");     // Catch: Throwable -> L62
        int r15 = CursorUtil.getColumnIndexOrThrow(r2, "createTime");     // Catch: Throwable -> L62
        RoomSQLiteQuery r16 = r1;
        ArrayList r3 = new ArrayList(r2.getCount());     // Catch: Throwable -> L60
    L6:
        if (r2.moveToNext() == false) goto L58;
        if (r2.isNull(r0) == false) goto L11;
        String r18 = null;
    L13:
        if (r2.isNull(r4) == false) goto L15;
        String r19 = null;
    L17:
        if (r2.isNull(r5) == false) goto L19;
        String r20 = null;
    L21:
        if (r2.isNull(r6) == false) goto L23;
        String r21 = null;
    L25:
        if (r2.isNull(r7) == false) goto L27;
        String r22 = null;
    L29:
        if (r2.isNull(r8) == false) goto L31;
        String r23 = null;
    L33:
        if (r2.isNull(r9) == false) goto L35;
        String r24 = null;
    L37:
        if (r2.isNull(r10) == false) goto L39;
        String r25 = null;
    L41:
        if (r2.isNull(r11) == false) goto L43;
        String r26 = null;
    L45:
        if (r2.isNull(r12) == false) goto L47;
        String r27 = null;
    L49:
        if (r2.isNull(r13) == false) goto L51;
        String r28 = null;
    L53:
        if (r2.isNull(r14) == false) goto L55;
        String r29 = null;
    L56:
        r3.add(new cw(r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r2.getLong(r15)));     // Catch: Throwable -> L60
        goto L6
    L55:
        r29 = r2.getString(r14);     // Catch: Throwable -> L60
        goto L56
    L51:
        r28 = r2.getString(r13);     // Catch: Throwable -> L60
        goto L53
    L47:
        r27 = r2.getString(r12);     // Catch: Throwable -> L60
        goto L49
    L43:
        r26 = r2.getString(r11);     // Catch: Throwable -> L60
        goto L45
    L39:
        r25 = r2.getString(r10);     // Catch: Throwable -> L60
        goto L41
    L35:
        r24 = r2.getString(r9);     // Catch: Throwable -> L60
        goto L37
    L31:
        r23 = r2.getString(r8);     // Catch: Throwable -> L60
        goto L33
    L27:
        r22 = r2.getString(r7);     // Catch: Throwable -> L60
        goto L29
    L23:
        r21 = r2.getString(r6);     // Catch: Throwable -> L60
        goto L25
    L19:
        r20 = r2.getString(r5);     // Catch: Throwable -> L60
        goto L21
    L15:
        r19 = r2.getString(r4);     // Catch: Throwable -> L60
        goto L17
    L11:
        r18 = r2.getString(r0);     // Catch: Throwable -> L60
        goto L13
    L58:
        r2.close();
        r16.release();
        return r3;
    L60:
        th = th;
    L64:
        r2.close();
        r16.release();
        throw th;
    L62:
        th = th;
        r16 = r1;
        goto L64
    }
}
