package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.database.entity.PendingMemoryCalendar;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlinx.coroutines.flow.i;

/* JADX INFO: loaded from: classes4.dex */
public final class PendingMemoryCalendarDao_Impl implements PendingMemoryCalendarDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<PendingMemoryCalendar> __deletionAdapterOfPendingMemoryCalendar;
    private final EntityInsertionAdapter<PendingMemoryCalendar> __insertionAdapterOfPendingMemoryCalendar;
    private final EntityInsertionAdapter<PendingMemoryCalendar> __insertionAdapterOfPendingMemoryCalendar_1;
    private final SharedSQLiteStatement __preparedStmtOfDelete;
    private final SharedSQLiteStatement __preparedStmtOfDeleteExpired;
    private final EntityDeletionOrUpdateAdapter<PendingMemoryCalendar> __updateAdapterOfPendingMemoryCalendar;

    public PendingMemoryCalendarDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfPendingMemoryCalendar = new AnonymousClass1(this, r2);
        this.__insertionAdapterOfPendingMemoryCalendar_1 = new AnonymousClass2(this, r2);
        this.__deletionAdapterOfPendingMemoryCalendar = new AnonymousClass3(this, r2);
        this.__updateAdapterOfPendingMemoryCalendar = new AnonymousClass4(this, r2);
        this.__preparedStmtOfDelete = new AnonymousClass5(this, r2);
        this.__preparedStmtOfDeleteExpired = new AnonymousClass6(this, r2);
    }

    private PendingMemoryCalendar __entityCursorConverter_comObricMemorydataDatabaseEntityPendingMemoryCalendar(Cursor r33) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r33, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r2 = CursorUtil.getColumnIndex(r0, "title");
        int r3 = CursorUtil.getColumnIndex(r0, "location");
        int r4 = CursorUtil.getColumnIndex(r0, "eventType");
        int r5 = CursorUtil.getColumnIndex(r0, "description");
        int r6 = CursorUtil.getColumnIndex(r0, "dtstart");
        int r7 = CursorUtil.getColumnIndex(r0, "dtend");
        int r8 = CursorUtil.getColumnIndex(r0, "rrule");
        int r9 = CursorUtil.getColumnIndex(r0, "sourceAppPackage");
        int r10 = CursorUtil.getColumnIndex(r0, "sourceAppName");
        int r11 = CursorUtil.getColumnIndex(r0, "memoryUuid");
        int r12 = CursorUtil.getColumnIndex(r0, "entityType");
        int r13 = CursorUtil.getColumnIndex(r0, "status");
        if (r1 != (-1)) goto L5;
        long r15 = 0;
    L6:
        long r18 = r15;
        Integer r14 = null;
        if (r2 != (-1)) goto L10;
    L8:
        String r20 = null;
    L13:
        if (r3 != (-1)) goto L16;
    L14:
        String r21 = null;
    L19:
        if (r4 != (-1)) goto L22;
    L20:
        String r22 = null;
    L25:
        if (r5 != (-1)) goto L28;
    L26:
        String r23 = null;
    L31:
        if (r6 != (-1)) goto L34;
    L32:
        Long r24 = null;
    L37:
        if (r7 != (-1)) goto L40;
    L38:
        Long r25 = null;
    L43:
        if (r8 != (-1)) goto L46;
    L44:
        String r26 = null;
    L49:
        if (r9 != (-1)) goto L52;
    L50:
        String r27 = null;
    L55:
        if (r10 != (-1)) goto L58;
    L56:
        String r28 = null;
    L61:
        if (r11 != (-1)) goto L64;
    L62:
        String r29 = null;
    L67:
        if (r12 != (-1)) goto L70;
    L68:
        Integer r30 = r14;
        if (r13 != (-1)) goto L75;
        int r16 = 0;
    L77:
        return new PendingMemoryCalendar(r18, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r16);
    L75:
        r16 = r0.getInt(r13);
        goto L77
    L70:
        if (r0.isNull(r12) == true) goto L68;
        r14 = Integer.valueOf(r0.getInt(r12));
        goto L68
    L64:
        if (r0.isNull(r11) == true) goto L62;
        r29 = r0.getString(r11);
        goto L67
    L58:
        if (r0.isNull(r10) == true) goto L56;
        r28 = r0.getString(r10);
        goto L61
    L52:
        if (r0.isNull(r9) == true) goto L50;
        r27 = r0.getString(r9);
        goto L55
    L46:
        if (r0.isNull(r8) == true) goto L44;
        r26 = r0.getString(r8);
        goto L49
    L40:
        if (r0.isNull(r7) == true) goto L38;
        r25 = Long.valueOf(r0.getLong(r7));
        goto L43
    L34:
        if (r0.isNull(r6) == true) goto L32;
        r24 = Long.valueOf(r0.getLong(r6));
        goto L37
    L28:
        if (r0.isNull(r5) == true) goto L26;
        r23 = r0.getString(r5);
        goto L31
    L22:
        if (r0.isNull(r4) == true) goto L20;
        r22 = r0.getString(r4);
        goto L25
    L16:
        if (r0.isNull(r3) == true) goto L14;
        r21 = r0.getString(r3);
        goto L19
    L10:
        if (r0.isNull(r2) == true) goto L8;
        r20 = r0.getString(r2);
        goto L13
    L5:
        r15 = r0.getLong(r1);
        goto L6
    }

    static /* synthetic */ RoomDatabase access$000(PendingMemoryCalendarDao_Impl r0) {
        return r0.__db;
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.PendingMemoryCalendarDao
    public List<Long> batchInsert(List<PendingMemoryCalendar> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfPendingMemoryCalendar.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<PendingMemoryCalendar> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfPendingMemoryCalendar.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<PendingMemoryCalendar> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfPendingMemoryCalendar_1.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.PendingMemoryCalendarDao
    public int delete(PendingMemoryCalendar r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfPendingMemoryCalendar.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int delete(PendingMemoryCalendar r3) {
        return delete((PendingMemoryCalendar) ZeusTransformUtils.preCheckCast(r3, PendingMemoryCalendar.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.PendingMemoryCalendarDao
    public void delete(String r3) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfDelete.acquire();
        if (r3 != null) goto L5;
        r0.bindNull(1);
    L6:
        this.__db.beginTransaction();
        r0.executeUpdateDelete();     // Catch: Throwable -> L10
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.__db.endTransaction();
        this.__preparedStmtOfDelete.release(r0);
        return;
    L10:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfDelete.release(r0);
        throw th;
    L5:
        r0.bindString(1, r3);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return PendingMemoryCalendarDao.DefaultImpls.deleteAll(this);
    }

    @Override // com.obric.memorydata.database.dao.PendingMemoryCalendarDao
    public int deleteExpired(long r3) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfDeleteExpired.acquire();
        r0.bindLong(1, r3);
        this.__db.beginTransaction();
        int r4 = r0.executeUpdateDelete();     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteExpired.release(r0);
        return r4;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteExpired.release(r0);
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.PendingMemoryCalendarDao, com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return PendingMemoryCalendarDao.DefaultImpls.getTableName(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.PendingMemoryCalendarDao
    public long insert(PendingMemoryCalendar r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfPendingMemoryCalendar.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ long insert(PendingMemoryCalendar r3) {
        return insert((PendingMemoryCalendar) ZeusTransformUtils.preCheckCast(r3, PendingMemoryCalendar.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<PendingMemoryCalendar> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfPendingMemoryCalendar_1.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<PendingMemoryCalendar> queryAll() {
        return PendingMemoryCalendarDao.DefaultImpls.queryAll(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return PendingMemoryCalendarDao.DefaultImpls.queryAllCount(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public PendingMemoryCalendar queryById(long r1) {
        return PendingMemoryCalendarDao.DefaultImpls.queryById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ PendingMemoryCalendar queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<PendingMemoryCalendar> queryByIds(List<Long> r3) {
        return PendingMemoryCalendarDao.DefaultImpls.queryByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.PendingMemoryCalendarDao
    public i<List<PendingMemoryCalendar>> queryByMemoryUUID(String r5) {
        final RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM PendingMemoryCalendar WHERE memoryUuid = ?", 1);
        if (r5 != null) goto L5;
        r0.bindNull(1);
    L7:
        return CoroutinesRoom.createFlow(this.__db, false, new String[]{"PendingMemoryCalendar"}, new AnonymousClass7(this, r0));
    L5:
        r0.bindString(1, r5);
        goto L7
    }

    @Override // com.obric.memorydata.database.dao.PendingMemoryCalendarDao
    public i<List<PendingMemoryCalendar>> queryByMemoryUUIDGroupedAndSorted(String r5) {
        final RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("\n        SELECT * FROM PendingMemoryCalendar \n        WHERE memoryUuid = ?\n        ORDER BY \n            CASE WHEN eventType = 'EVENT' THEN 0 ELSE 1 END,\n            CASE \n                WHEN dtstart IS NULL AND dtend IS NULL THEN 1\n                ELSE 0\n            END,\n            COALESCE(dtstart, dtend) ASC,\n            dtend ASC\n    ", 1);
        if (r5 != null) goto L5;
        r0.bindNull(1);
    L7:
        return CoroutinesRoom.createFlow(this.__db, false, new String[]{"PendingMemoryCalendar"}, new AnonymousClass9(this, r0));
    L5:
        r0.bindString(1, r5);
        goto L7
    }

    @Override // com.obric.memorydata.database.dao.PendingMemoryCalendarDao
    public List<PendingMemoryCalendar> queryByMemoryUUIDSync(String r33) {
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire("SELECT * FROM PendingMemoryCalendar WHERE memoryUuid = ?", 1);
        if (r33 != null) goto L5;
        r2.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        Cursor r1 = DBUtil.query(this.__db, r2, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r1, OaidModel.KEY_ID);     // Catch: Throwable -> L62
        int r4 = CursorUtil.getColumnIndexOrThrow(r1, "title");     // Catch: Throwable -> L62
        int r5 = CursorUtil.getColumnIndexOrThrow(r1, "location");     // Catch: Throwable -> L62
        int r6 = CursorUtil.getColumnIndexOrThrow(r1, "eventType");     // Catch: Throwable -> L62
        int r7 = CursorUtil.getColumnIndexOrThrow(r1, "description");     // Catch: Throwable -> L62
        int r8 = CursorUtil.getColumnIndexOrThrow(r1, "dtstart");     // Catch: Throwable -> L62
        int r9 = CursorUtil.getColumnIndexOrThrow(r1, "dtend");     // Catch: Throwable -> L62
        int r10 = CursorUtil.getColumnIndexOrThrow(r1, "rrule");     // Catch: Throwable -> L62
        int r11 = CursorUtil.getColumnIndexOrThrow(r1, "sourceAppPackage");     // Catch: Throwable -> L62
        int r12 = CursorUtil.getColumnIndexOrThrow(r1, "sourceAppName");     // Catch: Throwable -> L62
        int r13 = CursorUtil.getColumnIndexOrThrow(r1, "memoryUuid");     // Catch: Throwable -> L62
        int r14 = CursorUtil.getColumnIndexOrThrow(r1, "entityType");     // Catch: Throwable -> L62
        int r15 = CursorUtil.getColumnIndexOrThrow(r1, "status");     // Catch: Throwable -> L62
        RoomSQLiteQuery r16 = r2;
        ArrayList r3 = new ArrayList(r1.getCount());     // Catch: Throwable -> L60
    L10:
        if (r1.moveToNext() == false) goto L58;
        long r18 = r1.getLong(r0);     // Catch: Throwable -> L60
        if (r1.isNull(r4) == false) goto L15;
        String r20 = null;
    L17:
        if (r1.isNull(r5) == false) goto L19;
        String r21 = null;
    L21:
        if (r1.isNull(r6) == false) goto L23;
        String r22 = null;
    L25:
        if (r1.isNull(r7) == false) goto L27;
        String r23 = null;
    L29:
        if (r1.isNull(r8) == false) goto L31;
        Long r24 = null;
    L33:
        if (r1.isNull(r9) == false) goto L35;
        Long r25 = null;
    L37:
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
        Integer r30 = null;
    L56:
        r3.add(new PendingMemoryCalendar(r18, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r1.getInt(r15)));     // Catch: Throwable -> L60
        goto L10
    L55:
        r30 = Integer.valueOf(r1.getInt(r14));     // Catch: Throwable -> L60
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
        r25 = Long.valueOf(r1.getLong(r9));     // Catch: Throwable -> L60
        goto L37
    L31:
        r24 = Long.valueOf(r1.getLong(r8));     // Catch: Throwable -> L60
        goto L33
    L27:
        r23 = r1.getString(r7);     // Catch: Throwable -> L60
        goto L29
    L23:
        r22 = r1.getString(r6);     // Catch: Throwable -> L60
        goto L25
    L19:
        r21 = r1.getString(r5);     // Catch: Throwable -> L60
        goto L21
    L15:
        r20 = r1.getString(r4);     // Catch: Throwable -> L60
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
        r2.bindString(1, r33);
        goto L6
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public PendingMemoryCalendar queryByUUID(String r1) {
        return PendingMemoryCalendarDao.DefaultImpls.queryByUUID(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ PendingMemoryCalendar queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public PendingMemoryCalendar queryOne() {
        return PendingMemoryCalendarDao.DefaultImpls.queryOne(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ PendingMemoryCalendar queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.PendingMemoryCalendarDao
    public i<List<PendingMemoryCalendar>> queryValidByMemoryUUID(String r4, long r5) {
        final RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM PendingMemoryCalendar WHERE memoryUuid = ? AND (dtend is null OR dtend > ?)", 2);
        if (r4 != null) goto L5;
        r0.bindNull(1);
    L6:
        r0.bindLong(2, r5);
        return CoroutinesRoom.createFlow(this.__db, false, new String[]{"PendingMemoryCalendar"}, new AnonymousClass8(this, r0));
    L5:
        r0.bindString(1, r4);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.PendingMemoryCalendarDao
    public i<List<PendingMemoryCalendar>> queryValidByMemoryUUIDGroupedAndSorted(String r4, long r5) {
        final RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("\n        SELECT * FROM PendingMemoryCalendar \n        WHERE memoryUuid = ? \n        AND (dtend IS NULL OR dtend > ?)\n        ORDER BY \n            CASE WHEN eventType = 'EVENT' THEN 0 ELSE 1 END,\n            CASE \n                WHEN dtstart IS NULL AND dtend IS NULL THEN 1\n                ELSE 0\n            END,\n            COALESCE(dtstart, dtend) ASC,\n            dtend ASC\n    ", 2);
        if (r4 != null) goto L5;
        r0.bindNull(1);
    L6:
        r0.bindLong(2, r5);
        return CoroutinesRoom.createFlow(this.__db, false, new String[]{"PendingMemoryCalendar"}, new AnonymousClass10(this, r0));
    L5:
        r0.bindString(1, r4);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<PendingMemoryCalendar> queryWithLimitAndOffset(int r1, int r2) {
        return PendingMemoryCalendarDao.DefaultImpls.queryWithLimitAndOffset(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<PendingMemoryCalendar> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntityPendingMemoryCalendar(r6));     // Catch: Throwable -> L10
        goto L5
    L8:
        r6.close();
        return r0;
    L10:
        th = move-exception;
        r6.close();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public Cursor rawQueryForCursor(SupportSQLiteQuery r3) {
        SupportSQLiteQuery r4 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        return this.__db.query(r4);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int rawQueryForInt(SupportSQLiteQuery r3) {
        SupportSQLiteQuery r4 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        int r0 = 0;
        Cursor r2 = DBUtil.query(this.__db, r4, false, null);
    L8:
        th = move-exception;
        r2.close();
        throw th;
    L4:
        if (r2.moveToFirst() == false) goto L6;
        r0 = r2.getInt(0);     // Catch: Throwable -> L8
    L6:
        r2.close();
        return r0;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public long rawQueryForLong(SupportSQLiteQuery r3) {
        SupportSQLiteQuery r4 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r2 = DBUtil.query(this.__db, r4, false, null);
    L10:
        th = move-exception;
        r2.close();
        throw th;
    L4:
        if (r2.moveToFirst() == false) goto L7;
        long r0 = r2.getLong(0);     // Catch: Throwable -> L10
    L8:
        r2.close();
        return r0;
    L7:
        r0 = 0;
        goto L8
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.PendingMemoryCalendarDao
    public int update(PendingMemoryCalendar r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfPendingMemoryCalendar.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int update(PendingMemoryCalendar r3) {
        return update((PendingMemoryCalendar) ZeusTransformUtils.preCheckCast(r3, PendingMemoryCalendar.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<PendingMemoryCalendar> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfPendingMemoryCalendar.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
