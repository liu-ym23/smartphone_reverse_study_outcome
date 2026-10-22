package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.obric.memorydata.database.entity.cy;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class MemoryProcessSourceEventDao_Impl implements MemoryProcessSourceEventDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<cy> __insertionAdapterOfMemoryProcessSourceEventEntity;
    private final EntityDeletionOrUpdateAdapter<cy> __updateAdapterOfMemoryProcessSourceEventEntity;

    public MemoryProcessSourceEventDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfMemoryProcessSourceEventEntity = new AnonymousClass1(this, r2);
        this.__updateAdapterOfMemoryProcessSourceEventEntity = new AnonymousClass2(this, r2);
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.MemoryProcessSourceEventDao
    public long insertIgnore(cy r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfMemoryProcessSourceEventEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.MemoryProcessSourceEventDao
    public List<cy> queryByEventIds(List<String> r36) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r36, List.class, "com.obric.memorydata.plugin");
        StringBuilder r3 = StringUtil.newStringBuilder();
        r3.append("SELECT * FROM MemoryProcessSourceEvent WHERE eventId IN (");
        int r4 = r1.size();
        StringUtil.appendPlaceholders(r3, r4);
        r3.append(")");
        RoomSQLiteQuery r5 = RoomSQLiteQuery.acquire(r3.toString(), r4 + 0);
        Iterator r2 = r1.iterator();
        int r6 = 1;
    L4:
        if (r2.hasNext() == false) goto L10;
        String r7 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L8;
        r5.bindNull(r6);
    L9:
        r6 = r6 + 1;
        goto L4
    L8:
        r5.bindString(r6, r7);
        goto L9
    L10:
        this.__db.assertNotSuspendingTransaction();
        Cursor r8 = DBUtil.query(this.__db, r5, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r8, "eventId");     // Catch: Throwable -> L66
        int r9 = CursorUtil.getColumnIndexOrThrow(r8, "l1OutputEventId");     // Catch: Throwable -> L66
        int r10 = CursorUtil.getColumnIndexOrThrow(r8, "businessId");     // Catch: Throwable -> L66
        int r11 = CursorUtil.getColumnIndexOrThrow(r8, "triggerMode");     // Catch: Throwable -> L66
        int r12 = CursorUtil.getColumnIndexOrThrow(r8, "sourceMemoryType");     // Catch: Throwable -> L66
        int r13 = CursorUtil.getColumnIndexOrThrow(r8, "sourceEntityId");     // Catch: Throwable -> L66
        int r14 = CursorUtil.getColumnIndexOrThrow(r8, "eventTime");     // Catch: Throwable -> L66
        int r15 = CursorUtil.getColumnIndexOrThrow(r8, "groupKey");     // Catch: Throwable -> L66
        int r16 = CursorUtil.getColumnIndexOrThrow(r8, "payload");     // Catch: Throwable -> L66
        int r17 = CursorUtil.getColumnIndexOrThrow(r8, "meta");     // Catch: Throwable -> L66
        int r18 = CursorUtil.getColumnIndexOrThrow(r8, "state");     // Catch: Throwable -> L66
        int r19 = CursorUtil.getColumnIndexOrThrow(r8, "logId");     // Catch: Throwable -> L66
        int r110 = CursorUtil.getColumnIndexOrThrow(r8, "createTime");     // Catch: Throwable -> L66
        RoomSQLiteQuery r37 = r5;
        int r111 = CursorUtil.getColumnIndexOrThrow(r8, "updateTime");     // Catch: Throwable -> L66
        ArrayList r20 = new ArrayList(r8.getCount());     // Catch: Throwable -> L64
    L14:
        if (r8.moveToNext() == false) goto L62;
        if (r8.isNull(r0) == false) goto L19;
        String r112 = null;
    L21:
        if (r8.isNull(r9) == false) goto L23;
        String r113 = null;
    L25:
        if (r8.isNull(r10) == false) goto L27;
        String r21 = null;
    L29:
        if (r8.isNull(r11) == false) goto L31;
        String r22 = null;
    L33:
        if (r8.isNull(r12) == false) goto L35;
        String r23 = null;
    L37:
        if (r8.isNull(r13) == false) goto L39;
        String r24 = null;
    L40:
        long r25 = r8.getLong(r14);     // Catch: Throwable -> L64
        if (r8.isNull(r15) == false) goto L43;
        String r26 = null;
    L45:
        if (r8.isNull(r16) == false) goto L47;
        String r27 = null;
    L49:
        if (r8.isNull(r17) == false) goto L51;
        String r28 = null;
    L53:
        if (r8.isNull(r18) == false) goto L55;
        String r29 = null;
    L57:
        if (r8.isNull(r19) == false) goto L59;
        String r30 = null;
    L60:
        int r31 = r111;
        int r114 = r0;
        r20.add(new cy(r112, r113, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r8.getLong(r110), r8.getLong(r31)));     // Catch: Throwable -> L64
        r0 = r114;
        r111 = r31;
        goto L14
    L59:
        r30 = r8.getString(r19);     // Catch: Throwable -> L64
        goto L60
    L55:
        r29 = r8.getString(r18);     // Catch: Throwable -> L64
        goto L57
    L51:
        r28 = r8.getString(r17);     // Catch: Throwable -> L64
        goto L53
    L47:
        r27 = r8.getString(r16);     // Catch: Throwable -> L64
        goto L49
    L43:
        r26 = r8.getString(r15);     // Catch: Throwable -> L64
        goto L45
    L39:
        r24 = r8.getString(r13);     // Catch: Throwable -> L64
        goto L40
    L35:
        r23 = r8.getString(r12);     // Catch: Throwable -> L64
        goto L37
    L31:
        r22 = r8.getString(r11);     // Catch: Throwable -> L64
        goto L33
    L27:
        r21 = r8.getString(r10);     // Catch: Throwable -> L64
        goto L29
    L23:
        r113 = r8.getString(r9);     // Catch: Throwable -> L64
        goto L25
    L19:
        r112 = r8.getString(r0);     // Catch: Throwable -> L64
        goto L21
    L62:
        r8.close();
        r37.release();
        return r20;
    L64:
        th = th;
    L68:
        r8.close();
        r37.release();
        throw th;
    L66:
        th = th;
        r37 = r5;
        goto L68
    }

    @Override // com.obric.memorydata.database.dao.MemoryProcessSourceEventDao
    public List<cy> queryPendingByBusiness(String r36, int r37) {
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire("SELECT * FROM MemoryProcessSourceEvent WHERE businessId = ? AND state = 'PENDING' ORDER BY eventTime ASC LIMIT ?", 2);
        if (r36 != null) goto L5;
        r2.bindNull(1);
    L6:
        r2.bindLong(2, r37);
        this.__db.assertNotSuspendingTransaction();
        Cursor r1 = DBUtil.query(this.__db, r2, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r1, "eventId");     // Catch: Throwable -> L62
        int r4 = CursorUtil.getColumnIndexOrThrow(r1, "l1OutputEventId");     // Catch: Throwable -> L62
        int r5 = CursorUtil.getColumnIndexOrThrow(r1, "businessId");     // Catch: Throwable -> L62
        int r6 = CursorUtil.getColumnIndexOrThrow(r1, "triggerMode");     // Catch: Throwable -> L62
        int r7 = CursorUtil.getColumnIndexOrThrow(r1, "sourceMemoryType");     // Catch: Throwable -> L62
        int r8 = CursorUtil.getColumnIndexOrThrow(r1, "sourceEntityId");     // Catch: Throwable -> L62
        int r9 = CursorUtil.getColumnIndexOrThrow(r1, "eventTime");     // Catch: Throwable -> L62
        int r10 = CursorUtil.getColumnIndexOrThrow(r1, "groupKey");     // Catch: Throwable -> L62
        int r11 = CursorUtil.getColumnIndexOrThrow(r1, "payload");     // Catch: Throwable -> L62
        int r12 = CursorUtil.getColumnIndexOrThrow(r1, "meta");     // Catch: Throwable -> L62
        int r13 = CursorUtil.getColumnIndexOrThrow(r1, "state");     // Catch: Throwable -> L62
        int r14 = CursorUtil.getColumnIndexOrThrow(r1, "logId");     // Catch: Throwable -> L62
        int r15 = CursorUtil.getColumnIndexOrThrow(r1, "createTime");     // Catch: Throwable -> L62
        RoomSQLiteQuery r16 = r2;
        int r38 = CursorUtil.getColumnIndexOrThrow(r1, "updateTime");     // Catch: Throwable -> L62
        ArrayList r3 = new ArrayList(r1.getCount());     // Catch: Throwable -> L60
    L10:
        if (r1.moveToNext() == false) goto L58;
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
    L36:
        long r24 = r1.getLong(r9);     // Catch: Throwable -> L60
        if (r1.isNull(r10) == false) goto L39;
        String r26 = null;
    L41:
        if (r1.isNull(r11) == false) goto L43;
        String r27 = null;
    L45:
        if (r1.isNull(r12) == false) goto L47;
        String r28 = null;
    L49:
        if (r1.isNull(r13) == false) goto L51;
        String r29 = null;
    L53:
        if (r1.isNull(r14) == false) goto L55;
        String r30 = null;
    L56:
        int r17 = r38;
        int r39 = r0;
        r3.add(new cy(r18, r19, r20, r21, r22, r23, r24, r26, r27, r28, r29, r30, r1.getLong(r15), r1.getLong(r17)));     // Catch: Throwable -> L60
        r0 = r39;
        r38 = r17;
        goto L10
    L55:
        r30 = r1.getString(r14);     // Catch: Throwable -> L60
        goto L56
    L51:
        r29 = r1.getString(r13);     // Catch: Throwable -> L60
        goto L53
    L47:
        r28 = r1.getString(r12);     // Catch: Throwable -> L60
        goto L49
    L43:
        r27 = r1.getString(r11);     // Catch: Throwable -> L60
        goto L45
    L39:
        r26 = r1.getString(r10);     // Catch: Throwable -> L60
        goto L41
    L35:
        r23 = r1.getString(r8);     // Catch: Throwable -> L60
        goto L36
    L31:
        r22 = r1.getString(r7);     // Catch: Throwable -> L60
        goto L33
    L27:
        r21 = r1.getString(r6);     // Catch: Throwable -> L60
        goto L29
    L23:
        r20 = r1.getString(r5);     // Catch: Throwable -> L60
        goto L25
    L19:
        r19 = r1.getString(r4);     // Catch: Throwable -> L60
        goto L21
    L15:
        r18 = r1.getString(r0);     // Catch: Throwable -> L60
        goto L17
    L58:
        r1.close();
        r16.release();
        return r3;
    L60:
        th = th;
    L64:
        r1.close();
        r16.release();
        throw th;
    L62:
        th = th;
        r16 = r2;
        goto L64
    L5:
        r2.bindString(1, r36);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.MemoryProcessSourceEventDao
    public List<cy> queryPendingByBusinessAndTrigger(String r36, String r37, int r38) {
        RoomSQLiteQuery r3 = RoomSQLiteQuery.acquire("SELECT * FROM MemoryProcessSourceEvent WHERE businessId = ? AND triggerMode = ? AND state = 'PENDING' ORDER BY eventTime ASC LIMIT ?", 3);
        if (r36 != null) goto L5;
        r3.bindNull(1);
    L7:
        if (r37 != null) goto L9;
        r3.bindNull(2);
    L10:
        r3.bindLong(3, r38);
        this.__db.assertNotSuspendingTransaction();
        Cursor r1 = DBUtil.query(this.__db, r3, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r1, "eventId");     // Catch: Throwable -> L66
        int r4 = CursorUtil.getColumnIndexOrThrow(r1, "l1OutputEventId");     // Catch: Throwable -> L66
        int r5 = CursorUtil.getColumnIndexOrThrow(r1, "businessId");     // Catch: Throwable -> L66
        int r6 = CursorUtil.getColumnIndexOrThrow(r1, "triggerMode");     // Catch: Throwable -> L66
        int r7 = CursorUtil.getColumnIndexOrThrow(r1, "sourceMemoryType");     // Catch: Throwable -> L66
        int r8 = CursorUtil.getColumnIndexOrThrow(r1, "sourceEntityId");     // Catch: Throwable -> L66
        int r9 = CursorUtil.getColumnIndexOrThrow(r1, "eventTime");     // Catch: Throwable -> L66
        int r10 = CursorUtil.getColumnIndexOrThrow(r1, "groupKey");     // Catch: Throwable -> L66
        int r11 = CursorUtil.getColumnIndexOrThrow(r1, "payload");     // Catch: Throwable -> L66
        int r12 = CursorUtil.getColumnIndexOrThrow(r1, "meta");     // Catch: Throwable -> L66
        int r13 = CursorUtil.getColumnIndexOrThrow(r1, "state");     // Catch: Throwable -> L66
        int r14 = CursorUtil.getColumnIndexOrThrow(r1, "logId");     // Catch: Throwable -> L66
        int r15 = CursorUtil.getColumnIndexOrThrow(r1, "createTime");     // Catch: Throwable -> L66
        RoomSQLiteQuery r16 = r3;
        int r39 = CursorUtil.getColumnIndexOrThrow(r1, "updateTime");     // Catch: Throwable -> L66
        ArrayList r17 = new ArrayList(r1.getCount());     // Catch: Throwable -> L64
    L14:
        if (r1.moveToNext() == false) goto L62;
        if (r1.isNull(r0) == false) goto L19;
        String r18 = null;
    L21:
        if (r1.isNull(r4) == false) goto L23;
        String r19 = null;
    L25:
        if (r1.isNull(r5) == false) goto L27;
        String r20 = null;
    L29:
        if (r1.isNull(r6) == false) goto L31;
        String r21 = null;
    L33:
        if (r1.isNull(r7) == false) goto L35;
        String r22 = null;
    L37:
        if (r1.isNull(r8) == false) goto L39;
        String r23 = null;
    L40:
        long r24 = r1.getLong(r9);     // Catch: Throwable -> L64
        if (r1.isNull(r10) == false) goto L43;
        String r26 = null;
    L45:
        if (r1.isNull(r11) == false) goto L47;
        String r27 = null;
    L49:
        if (r1.isNull(r12) == false) goto L51;
        String r28 = null;
    L53:
        if (r1.isNull(r13) == false) goto L55;
        String r29 = null;
    L57:
        if (r1.isNull(r14) == false) goto L59;
        String r30 = null;
    L60:
        int r2 = r39;
        int r310 = r0;
        r17.add(new cy(r18, r19, r20, r21, r22, r23, r24, r26, r27, r28, r29, r30, r1.getLong(r15), r1.getLong(r2)));     // Catch: Throwable -> L64
        r0 = r310;
        r39 = r2;
        goto L14
    L59:
        r30 = r1.getString(r14);     // Catch: Throwable -> L64
        goto L60
    L55:
        r29 = r1.getString(r13);     // Catch: Throwable -> L64
        goto L57
    L51:
        r28 = r1.getString(r12);     // Catch: Throwable -> L64
        goto L53
    L47:
        r27 = r1.getString(r11);     // Catch: Throwable -> L64
        goto L49
    L43:
        r26 = r1.getString(r10);     // Catch: Throwable -> L64
        goto L45
    L39:
        r23 = r1.getString(r8);     // Catch: Throwable -> L64
        goto L40
    L35:
        r22 = r1.getString(r7);     // Catch: Throwable -> L64
        goto L37
    L31:
        r21 = r1.getString(r6);     // Catch: Throwable -> L64
        goto L33
    L27:
        r20 = r1.getString(r5);     // Catch: Throwable -> L64
        goto L29
    L23:
        r19 = r1.getString(r4);     // Catch: Throwable -> L64
        goto L25
    L19:
        r18 = r1.getString(r0);     // Catch: Throwable -> L64
        goto L21
    L62:
        r1.close();
        r16.release();
        return r17;
    L64:
        th = th;
    L68:
        r1.close();
        r16.release();
        throw th;
    L66:
        th = th;
        r16 = r3;
        goto L68
    L9:
        r3.bindString(2, r37);
        goto L10
    L5:
        r3.bindString(1, r36);
        goto L7
    }

    @Override // com.obric.memorydata.database.dao.MemoryProcessSourceEventDao
    public int update(cy r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfMemoryProcessSourceEventEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.MemoryProcessSourceEventDao
    public int updateState(List<String> r5, String r6, long r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("UPDATE MemoryProcessSourceEvent SET state = ");
        r0.append("?");
        r0.append(", updateTime = ");
        r0.append("?");
        r0.append(" WHERE eventId IN (");
        StringUtil.appendPlaceholders(r0, r8.size());
        r0.append(")");
        String r1 = r0.toString();
        SupportSQLiteStatement r2 = this.__db.compileStatement(r1);
        if (r6 != null) goto L5;
        r2.bindNull(1);
    L6:
        r2.bindLong(2, r7);
        int r9 = 3;
        Iterator r10 = r8.iterator();
    L8:
        if (r10.hasNext() == false) goto L14;
        String r11 = (String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.memorydata.plugin");
        if (r11 != null) goto L12;
        r2.bindNull(r9);
    L13:
        r9 = r9 + 1;
        goto L8
    L12:
        r2.bindString(r9, r11);
        goto L13
    L14:
        this.__db.beginTransaction();
        int r12 = r2.executeUpdateDelete();     // Catch: Throwable -> L18
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L18
        this.__db.endTransaction();
        return r12;
    L18:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    L5:
        r2.bindString(1, r6);
        goto L6
    }
}
