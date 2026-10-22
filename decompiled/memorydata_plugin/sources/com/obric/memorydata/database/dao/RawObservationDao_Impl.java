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
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.database.entity.RawObservationEntity;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.flow.i;

/* JADX INFO: loaded from: classes4.dex */
public final class RawObservationDao_Impl implements RawObservationDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<RawObservationEntity> __deletionAdapterOfRawObservationEntity;
    private final EntityInsertionAdapter<RawObservationEntity> __insertionAdapterOfRawObservationEntity;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAll;
    private final SharedSQLiteStatement __preparedStmtOfMarkRetry;
    private final SharedSQLiteStatement __preparedStmtOfUpdateMeta;
    private final EntityDeletionOrUpdateAdapter<RawObservationEntity> __updateAdapterOfRawObservationEntity;

    public RawObservationDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfRawObservationEntity = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfRawObservationEntity = new AnonymousClass2(this, r2);
        this.__updateAdapterOfRawObservationEntity = new AnonymousClass3(this, r2);
        this.__preparedStmtOfDeleteAll = new AnonymousClass4(this, r2);
        this.__preparedStmtOfMarkRetry = new AnonymousClass5(this, r2);
        this.__preparedStmtOfUpdateMeta = new AnonymousClass6(this, r2);
    }

    private RawObservationEntity __entityCursorConverter_comObricMemorydataDatabaseEntityRawObservationEntity(Cursor r36) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r36, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r2 = CursorUtil.getColumnIndex(r0, "device_id");
        int r3 = CursorUtil.getColumnIndex(r0, AILabCheckPermissionTask.KEY_SOURCE);
        int r4 = CursorUtil.getColumnIndex(r0, "timestamp");
        int r5 = CursorUtil.getColumnIndex(r0, "span_start");
        int r6 = CursorUtil.getColumnIndex(r0, "span_end");
        int r7 = CursorUtil.getColumnIndex(r0, "payload");
        int r8 = CursorUtil.getColumnIndex(r0, "meta");
        int r9 = CursorUtil.getColumnIndex(r0, "state");
        int r10 = CursorUtil.getColumnIndex(r0, "client_state");
        int r11 = CursorUtil.getColumnIndex(r0, "retry_count");
        int r12 = CursorUtil.getColumnIndex(r0, "last_error_code");
        long r13 = 0;
        if (r1 != (-1)) goto L5;
        long r19 = 0;
    L6:
        String r14 = null;
        if (r2 != (-1)) goto L10;
    L8:
        String r21 = null;
    L13:
        if (r3 != (-1)) goto L16;
    L14:
        String r22 = null;
    L19:
        if (r4 != (-1)) goto L21;
        long r23 = 0;
    L22:
        if (r5 != (-1)) goto L24;
        long r25 = 0;
    L25:
        if (r6 == (-1)) goto L28;
        r13 = r0.getLong(r6);
    L28:
        long r27 = r13;
        if (r7 != (-1)) goto L32;
    L30:
        String r29 = null;
    L35:
        if (r8 != (-1)) goto L38;
    L36:
        String r30 = null;
    L41:
        if (r9 != (-1)) goto L44;
    L42:
        String r31 = null;
    L47:
        if (r10 != (-1)) goto L50;
    L48:
        String r32 = r14;
        if (r11 != (-1)) goto L56;
        int r33 = 0;
    L57:
        if (r12 != (-1)) goto L59;
        int r34 = 0;
    L61:
        return new RawObservationEntity(r19, r21, r22, r23, r25, r27, r29, r30, r31, r32, r33, r34);
    L59:
        r34 = r0.getInt(r12);
        goto L61
    L56:
        r33 = r0.getInt(r11);
        goto L57
    L50:
        if (r0.isNull(r10) == true) goto L48;
        r14 = r0.getString(r10);
        goto L48
    L44:
        if (r0.isNull(r9) == true) goto L42;
        r31 = r0.getString(r9);
        goto L47
    L38:
        if (r0.isNull(r8) == true) goto L36;
        r30 = r0.getString(r8);
        goto L41
    L32:
        if (r0.isNull(r7) == true) goto L30;
        r29 = r0.getString(r7);
        goto L35
    L24:
        r25 = r0.getLong(r5);
        goto L25
    L21:
        r23 = r0.getLong(r4);
        goto L22
    L16:
        if (r0.isNull(r3) == true) goto L14;
        r22 = r0.getString(r3);
        goto L19
    L10:
        if (r0.isNull(r2) == true) goto L8;
        r21 = r0.getString(r2);
        goto L13
    L5:
        r19 = r0.getLong(r1);
        goto L6
    }

    static /* synthetic */ RoomDatabase access$000(RawObservationDao_Impl r0) {
        return r0.__db;
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<RawObservationEntity> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfRawObservationEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<RawObservationEntity> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfRawObservationEntity.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.RawObservationDao
    public int countGlassesForDebug() {
        int r1 = 0;
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM RawObservation WHERE source = 'glasses'", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor r3 = DBUtil.query(this.__db, r0, false, null);
    L8:
        th = move-exception;
        r3.close();
        r0.release();
        throw th;
    L4:
        if (r3.moveToFirst() == false) goto L6;
        r1 = r3.getInt(0);     // Catch: Throwable -> L8
    L6:
        r3.close();
        r0.release();
        return r1;
    }

    /* JADX INFO: renamed from: delete, reason: avoid collision after fix types in other method */
    public int delete2(RawObservationEntity r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfRawObservationEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int delete(RawObservationEntity r3) {
        return delete2((RawObservationEntity) ZeusTransformUtils.preCheckCast(r3, RawObservationEntity.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.RawObservationDao, com.obric.memorydata.database.dao.BaseDao
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

    @Override // com.obric.memorydata.database.dao.RawObservationDao, com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return RawObservationDao.DefaultImpls.getTableName(this);
    }

    /* JADX INFO: renamed from: insert, reason: avoid collision after fix types in other method */
    public long insert2(RawObservationEntity r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfRawObservationEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ long insert(RawObservationEntity r3) {
        return insert2((RawObservationEntity) ZeusTransformUtils.preCheckCast(r3, RawObservationEntity.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<RawObservationEntity> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfRawObservationEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.RawObservationDao
    public void markClientStateForStates(List<Long> r7, String r8, String r9, List<String> r10) {
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("UPDATE RawObservation SET client_state = ");
        r0.append("?");
        r0.append(" WHERE id IN (");
        int r3 = r11.size();
        StringUtil.appendPlaceholders(r0, r3);
        r0.append(") AND client_state = ");
        r0.append("?");
        r0.append(" AND state IN (");
        StringUtil.appendPlaceholders(r0, r12.size());
        r0.append(")");
        String r1 = r0.toString();
        SupportSQLiteStatement r2 = this.__db.compileStatement(r1);
        if (r9 != null) goto L5;
        r2.bindNull(1);
    L6:
        Iterator r13 = r11.iterator();
        int r14 = 2;
    L8:
        if (r13.hasNext() == false) goto L10;
        r2.bindLong(r14, ((Long) ZeusTransformUtils.preCheckCast(r13.next(), Long.class, "com.obric.memorydata.plugin")).longValue());
        r14 = r14 + 1;
        goto L8
    L10:
        int r15 = r3 + 2;
        if (r8 != null) goto L13;
        r2.bindNull(r15);
    L14:
        int r4 = r3 + 3;
        Iterator r16 = r12.iterator();
    L16:
        if (r16.hasNext() == false) goto L22;
        String r17 = (String) ZeusTransformUtils.preCheckCast(r16.next(), String.class, "com.obric.memorydata.plugin");
        if (r17 != null) goto L20;
        r2.bindNull(r4);
    L21:
        r4 = r4 + 1;
        goto L16
    L20:
        r2.bindString(r4, r17);
        goto L21
    L22:
        this.__db.beginTransaction();
        r2.executeUpdateDelete();     // Catch: Throwable -> L26
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L26
        this.__db.endTransaction();
        return;
    L26:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    L13:
        r2.bindString(r15, r8);
        goto L14
    L5:
        r2.bindString(1, r9);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.RawObservationDao
    public void markRetry(long r4, int r6, int r7) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfMarkRetry.acquire();
        r0.bindLong(1, r6);
        r0.bindLong(2, r7);
        r0.bindLong(3, r4);
        this.__db.beginTransaction();
        r0.executeUpdateDelete();     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        this.__preparedStmtOfMarkRetry.release(r0);
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfMarkRetry.release(r0);
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.RawObservationDao
    public void markState(List<Long> r6, String r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("UPDATE RawObservation SET state = ");
        r0.append("?");
        r0.append(" WHERE id IN (");
        StringUtil.appendPlaceholders(r0, r8.size());
        r0.append(")");
        String r1 = r0.toString();
        SupportSQLiteStatement r2 = this.__db.compileStatement(r1);
        if (r7 != null) goto L5;
        r2.bindNull(1);
    L6:
        int r9 = 2;
        Iterator r10 = r8.iterator();
    L8:
        if (r10.hasNext() == false) goto L10;
        r2.bindLong(r9, ((Long) ZeusTransformUtils.preCheckCast(r10.next(), Long.class, "com.obric.memorydata.plugin")).longValue());
        r9 = r9 + 1;
        goto L8
    L10:
        this.__db.beginTransaction();
        r2.executeUpdateDelete();     // Catch: Throwable -> L14
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L14
        this.__db.endTransaction();
        return;
    L14:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    L5:
        r2.bindString(1, r7);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.RawObservationDao
    public void markStateForStates(List<Long> r7, List<String> r8, String r9, int r10) {
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("UPDATE RawObservation SET state = ");
        r0.append("?");
        r0.append(", last_error_code = ");
        r0.append("?");
        r0.append(" WHERE id IN (");
        int r2 = r11.size();
        StringUtil.appendPlaceholders(r0, r2);
        r0.append(") AND state IN (");
        StringUtil.appendPlaceholders(r0, r12.size());
        r0.append(")");
        SupportSQLiteStatement r1 = this.__db.compileStatement(r0.toString());
        if (r9 != null) goto L5;
        r1.bindNull(1);
    L6:
        r1.bindLong(2, r10);
        Iterator r13 = r11.iterator();
        int r14 = 3;
    L8:
        if (r13.hasNext() == false) goto L10;
        r1.bindLong(r14, ((Long) ZeusTransformUtils.preCheckCast(r13.next(), Long.class, "com.obric.memorydata.plugin")).longValue());
        r14 = r14 + 1;
        goto L8
    L10:
        int r3 = r2 + 3;
        Iterator r15 = r12.iterator();
    L12:
        if (r15.hasNext() == false) goto L18;
        String r16 = (String) ZeusTransformUtils.preCheckCast(r15.next(), String.class, "com.obric.memorydata.plugin");
        if (r16 != null) goto L16;
        r1.bindNull(r3);
    L17:
        r3 = r3 + 1;
        goto L12
    L16:
        r1.bindString(r3, r16);
        goto L17
    L18:
        this.__db.beginTransaction();
        r1.executeUpdateDelete();     // Catch: Throwable -> L22
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L22
        this.__db.endTransaction();
        return;
    L22:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    L5:
        r1.bindString(1, r9);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.RawObservationDao
    public i<RawObservationEntity> observeOldestUnfinishedObservation(List<String> r8, List<String> r9, long r10) {
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("SELECT * FROM RawObservation WHERE source IN (");
        int r2 = r11.size();
        StringUtil.appendPlaceholders(r0, r2);
        r0.append(") AND state NOT IN (");
        int r3 = r12.size();
        StringUtil.appendPlaceholders(r0, r3);
        r0.append(") AND timestamp <= ");
        r0.append("?");
        r0.append(" ORDER BY timestamp ASC LIMIT 1");
        int r4 = 1;
        int r5 = r2 + 1;
        int r6 = r3 + r5;
        final RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire(r0.toString(), r6);
        Iterator r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L10;
        String r7 = (String) ZeusTransformUtils.preCheckCast(r13.next(), String.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L8;
        r1.bindNull(r4);
    L9:
        r4 = r4 + 1;
        goto L4
    L8:
        r1.bindString(r4, r7);
        goto L9
    L10:
        Iterator r14 = r12.iterator();
    L12:
        if (r14.hasNext() == false) goto L18;
        String r15 = (String) ZeusTransformUtils.preCheckCast(r14.next(), String.class, "com.obric.memorydata.plugin");
        if (r15 != null) goto L16;
        r1.bindNull(r5);
    L17:
        r5 = r5 + 1;
        goto L12
    L16:
        r1.bindString(r5, r15);
        goto L17
    L18:
        r1.bindLong(r6, r10);
        return CoroutinesRoom.createFlow(this.__db, false, new String[]{"RawObservation"}, new AnonymousClass7(this, r1));
    }

    @Override // com.obric.memorydata.database.dao.RawObservationDao
    public i<Integer> observeUnfinishedObservationCount(List<String> r10, List<String> r11, long r12, long r14) {
        List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        List r15 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("SELECT COUNT(*) FROM RawObservation WHERE source IN (");
        int r2 = r13.size();
        StringUtil.appendPlaceholders(r0, r2);
        r0.append(") AND state NOT IN (");
        int r3 = r15.size();
        StringUtil.appendPlaceholders(r0, r3);
        r0.append(") AND timestamp >= ");
        r0.append("?");
        r0.append(" AND timestamp < ");
        r0.append("?");
        int r4 = (r2 + 2) + r3;
        final RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire(r0.toString(), r4);
        Iterator r16 = r13.iterator();
        int r6 = 1;
    L4:
        if (r16.hasNext() == false) goto L10;
        String r7 = (String) ZeusTransformUtils.preCheckCast(r16.next(), String.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L8;
        r1.bindNull(r6);
    L9:
        r6 = r6 + 1;
        goto L4
    L8:
        r1.bindString(r6, r7);
        goto L9
    L10:
        int r5 = r2 + 1;
        Iterator r17 = r15.iterator();
        int r18 = r5;
    L12:
        if (r17.hasNext() == false) goto L18;
        String r8 = (String) ZeusTransformUtils.preCheckCast(r17.next(), String.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L16;
        r1.bindNull(r18);
    L17:
        r18 = r18 + 1;
        goto L12
    L16:
        r1.bindString(r18, r8);
        goto L17
    L18:
        r1.bindLong(r5 + r3, r12);
        r1.bindLong(r4, r14);
        return CoroutinesRoom.createFlow(this.__db, false, new String[]{"RawObservation"}, new AnonymousClass8(this, r1));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<RawObservationEntity> queryAll() {
        return RawObservationDao.DefaultImpls.queryAll(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return RawObservationDao.DefaultImpls.queryAllCount(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.RawObservationDao, com.obric.memorydata.database.dao.BaseDao
    public RawObservationEntity queryById(long r34) {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM RawObservation WHERE id = ? LIMIT 1", 1);
        r1.bindLong(1, r34);
        this.__db.assertNotSuspendingTransaction();
        RawObservationEntity r3 = null;
        String r4 = null;
        Cursor r2 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r2, OaidModel.KEY_ID);     // Catch: Throwable -> L32
        int r5 = CursorUtil.getColumnIndexOrThrow(r2, "device_id");     // Catch: Throwable -> L32
        int r6 = CursorUtil.getColumnIndexOrThrow(r2, AILabCheckPermissionTask.KEY_SOURCE);     // Catch: Throwable -> L32
        int r7 = CursorUtil.getColumnIndexOrThrow(r2, "timestamp");     // Catch: Throwable -> L32
        int r8 = CursorUtil.getColumnIndexOrThrow(r2, "span_start");     // Catch: Throwable -> L32
        int r9 = CursorUtil.getColumnIndexOrThrow(r2, "span_end");     // Catch: Throwable -> L32
        int r10 = CursorUtil.getColumnIndexOrThrow(r2, "payload");     // Catch: Throwable -> L32
        int r11 = CursorUtil.getColumnIndexOrThrow(r2, "meta");     // Catch: Throwable -> L32
        int r12 = CursorUtil.getColumnIndexOrThrow(r2, "state");     // Catch: Throwable -> L32
        int r13 = CursorUtil.getColumnIndexOrThrow(r2, "client_state");     // Catch: Throwable -> L32
        int r14 = CursorUtil.getColumnIndexOrThrow(r2, "retry_count");     // Catch: Throwable -> L32
        int r15 = CursorUtil.getColumnIndexOrThrow(r2, "last_error_code");     // Catch: Throwable -> L32
        if (r2.moveToFirst() == false) goto L30;
        long r17 = r2.getLong(r0);     // Catch: Throwable -> L32
        if (r2.isNull(r5) == false) goto L8;
        String r19 = null;
    L10:
        if (r2.isNull(r6) == false) goto L12;
        String r20 = null;
    L13:
        long r21 = r2.getLong(r7);     // Catch: Throwable -> L32
        long r23 = r2.getLong(r8);     // Catch: Throwable -> L32
        long r25 = r2.getLong(r9);     // Catch: Throwable -> L32
        if (r2.isNull(r10) == false) goto L16;
        String r27 = null;
    L18:
        if (r2.isNull(r11) == false) goto L20;
        String r28 = null;
    L22:
        if (r2.isNull(r12) == false) goto L24;
        String r29 = null;
    L26:
        if (r2.isNull(r13) == true) goto L29;
        r4 = r2.getString(r13);     // Catch: Throwable -> L32
    L29:
        r3 = new RawObservationEntity(r17, r19, r20, r21, r23, r25, r27, r28, r29, r4, r2.getInt(r14), r2.getInt(r15));     // Catch: Throwable -> L32
        goto L30
    L24:
        r29 = r2.getString(r12);     // Catch: Throwable -> L32
        goto L26
    L20:
        r28 = r2.getString(r11);     // Catch: Throwable -> L32
        goto L22
    L16:
        r27 = r2.getString(r10);     // Catch: Throwable -> L32
        goto L18
    L12:
        r20 = r2.getString(r6);     // Catch: Throwable -> L32
        goto L13
    L8:
        r19 = r2.getString(r5);     // Catch: Throwable -> L32
    L30:
        r2.close();
        r1.release();
        return r3;
    L32:
        th = move-exception;
        r2.close();
        r1.release();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ RawObservationEntity queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<RawObservationEntity> queryByIds(List<Long> r3) {
        return RawObservationDao.DefaultImpls.queryByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public RawObservationEntity queryByUUID(String r1) {
        return RawObservationDao.DefaultImpls.queryByUUID(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ RawObservationEntity queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    @Override // com.obric.memorydata.database.dao.RawObservationDao
    public RawObservationEntity queryFirstScreenshotInWindow(long r34, long r36) {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM RawObservation WHERE source = 'screenshot' AND timestamp >= ? AND timestamp <= ? ORDER BY timestamp ASC LIMIT 1", 2);
        r1.bindLong(1, r34);
        r1.bindLong(2, r36);
        this.__db.assertNotSuspendingTransaction();
        RawObservationEntity r3 = null;
        String r4 = null;
        Cursor r2 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r2, OaidModel.KEY_ID);     // Catch: Throwable -> L32
        int r5 = CursorUtil.getColumnIndexOrThrow(r2, "device_id");     // Catch: Throwable -> L32
        int r6 = CursorUtil.getColumnIndexOrThrow(r2, AILabCheckPermissionTask.KEY_SOURCE);     // Catch: Throwable -> L32
        int r7 = CursorUtil.getColumnIndexOrThrow(r2, "timestamp");     // Catch: Throwable -> L32
        int r8 = CursorUtil.getColumnIndexOrThrow(r2, "span_start");     // Catch: Throwable -> L32
        int r9 = CursorUtil.getColumnIndexOrThrow(r2, "span_end");     // Catch: Throwable -> L32
        int r10 = CursorUtil.getColumnIndexOrThrow(r2, "payload");     // Catch: Throwable -> L32
        int r11 = CursorUtil.getColumnIndexOrThrow(r2, "meta");     // Catch: Throwable -> L32
        int r12 = CursorUtil.getColumnIndexOrThrow(r2, "state");     // Catch: Throwable -> L32
        int r13 = CursorUtil.getColumnIndexOrThrow(r2, "client_state");     // Catch: Throwable -> L32
        int r14 = CursorUtil.getColumnIndexOrThrow(r2, "retry_count");     // Catch: Throwable -> L32
        int r15 = CursorUtil.getColumnIndexOrThrow(r2, "last_error_code");     // Catch: Throwable -> L32
        if (r2.moveToFirst() == false) goto L30;
        long r17 = r2.getLong(r0);     // Catch: Throwable -> L32
        if (r2.isNull(r5) == false) goto L8;
        String r19 = null;
    L10:
        if (r2.isNull(r6) == false) goto L12;
        String r20 = null;
    L13:
        long r21 = r2.getLong(r7);     // Catch: Throwable -> L32
        long r23 = r2.getLong(r8);     // Catch: Throwable -> L32
        long r25 = r2.getLong(r9);     // Catch: Throwable -> L32
        if (r2.isNull(r10) == false) goto L16;
        String r27 = null;
    L18:
        if (r2.isNull(r11) == false) goto L20;
        String r28 = null;
    L22:
        if (r2.isNull(r12) == false) goto L24;
        String r29 = null;
    L26:
        if (r2.isNull(r13) == true) goto L29;
        r4 = r2.getString(r13);     // Catch: Throwable -> L32
    L29:
        r3 = new RawObservationEntity(r17, r19, r20, r21, r23, r25, r27, r28, r29, r4, r2.getInt(r14), r2.getInt(r15));     // Catch: Throwable -> L32
        goto L30
    L24:
        r29 = r2.getString(r12);     // Catch: Throwable -> L32
        goto L26
    L20:
        r28 = r2.getString(r11);     // Catch: Throwable -> L32
        goto L22
    L16:
        r27 = r2.getString(r10);     // Catch: Throwable -> L32
        goto L18
    L12:
        r20 = r2.getString(r6);     // Catch: Throwable -> L32
        goto L13
    L8:
        r19 = r2.getString(r5);     // Catch: Throwable -> L32
    L30:
        r2.close();
        r1.release();
        return r3;
    L32:
        th = move-exception;
        r2.close();
        r1.release();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.RawObservationDao
    public List<RawObservationEntity> queryGlassesAfterIdForDebug(long r34, int r36) {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM RawObservation WHERE source = 'glasses' AND id > ? ORDER BY id ASC LIMIT ?", 2);
        r1.bindLong(1, r34);
        r1.bindLong(2, r36);
        this.__db.assertNotSuspendingTransaction();
        Cursor r2 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r2, OaidModel.KEY_ID);     // Catch: Throwable -> L34
        int r4 = CursorUtil.getColumnIndexOrThrow(r2, "device_id");     // Catch: Throwable -> L34
        int r5 = CursorUtil.getColumnIndexOrThrow(r2, AILabCheckPermissionTask.KEY_SOURCE);     // Catch: Throwable -> L34
        int r6 = CursorUtil.getColumnIndexOrThrow(r2, "timestamp");     // Catch: Throwable -> L34
        int r7 = CursorUtil.getColumnIndexOrThrow(r2, "span_start");     // Catch: Throwable -> L34
        int r8 = CursorUtil.getColumnIndexOrThrow(r2, "span_end");     // Catch: Throwable -> L34
        int r9 = CursorUtil.getColumnIndexOrThrow(r2, "payload");     // Catch: Throwable -> L34
        int r10 = CursorUtil.getColumnIndexOrThrow(r2, "meta");     // Catch: Throwable -> L34
        int r11 = CursorUtil.getColumnIndexOrThrow(r2, "state");     // Catch: Throwable -> L34
        int r12 = CursorUtil.getColumnIndexOrThrow(r2, "client_state");     // Catch: Throwable -> L34
        int r13 = CursorUtil.getColumnIndexOrThrow(r2, "retry_count");     // Catch: Throwable -> L34
        int r14 = CursorUtil.getColumnIndexOrThrow(r2, "last_error_code");     // Catch: Throwable -> L34
        ArrayList r15 = new ArrayList(r2.getCount());     // Catch: Throwable -> L34
    L4:
        if (r2.moveToNext() == false) goto L32;
        long r17 = r2.getLong(r0);     // Catch: Throwable -> L34
        if (r2.isNull(r4) == false) goto L9;
        String r19 = null;
    L11:
        if (r2.isNull(r5) == false) goto L13;
        String r20 = null;
    L14:
        long r21 = r2.getLong(r6);     // Catch: Throwable -> L34
        long r23 = r2.getLong(r7);     // Catch: Throwable -> L34
        long r25 = r2.getLong(r8);     // Catch: Throwable -> L34
        if (r2.isNull(r9) == false) goto L17;
        String r27 = null;
    L19:
        if (r2.isNull(r10) == false) goto L21;
        String r28 = null;
    L23:
        if (r2.isNull(r11) == false) goto L25;
        String r29 = null;
    L27:
        if (r2.isNull(r12) == false) goto L29;
        String r30 = null;
    L30:
        r15.add(new RawObservationEntity(r17, r19, r20, r21, r23, r25, r27, r28, r29, r30, r2.getInt(r13), r2.getInt(r14)));     // Catch: Throwable -> L34
        goto L4
    L29:
        r30 = r2.getString(r12);     // Catch: Throwable -> L34
        goto L30
    L25:
        r29 = r2.getString(r11);     // Catch: Throwable -> L34
        goto L27
    L21:
        r28 = r2.getString(r10);     // Catch: Throwable -> L34
        goto L23
    L17:
        r27 = r2.getString(r9);     // Catch: Throwable -> L34
        goto L19
    L13:
        r20 = r2.getString(r5);     // Catch: Throwable -> L34
        goto L14
    L9:
        r19 = r2.getString(r4);     // Catch: Throwable -> L34
        goto L11
    L32:
        r2.close();
        r1.release();
        return r15;
    L34:
        th = move-exception;
        r2.close();
        r1.release();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.RawObservationDao
    public List<RawObservationEntity> queryGlassesBeforeIdForDebug(long r34, int r36) {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM RawObservation WHERE source = 'glasses' AND id < ? ORDER BY id DESC LIMIT ?", 2);
        r1.bindLong(1, r34);
        r1.bindLong(2, r36);
        this.__db.assertNotSuspendingTransaction();
        Cursor r2 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r2, OaidModel.KEY_ID);     // Catch: Throwable -> L34
        int r4 = CursorUtil.getColumnIndexOrThrow(r2, "device_id");     // Catch: Throwable -> L34
        int r5 = CursorUtil.getColumnIndexOrThrow(r2, AILabCheckPermissionTask.KEY_SOURCE);     // Catch: Throwable -> L34
        int r6 = CursorUtil.getColumnIndexOrThrow(r2, "timestamp");     // Catch: Throwable -> L34
        int r7 = CursorUtil.getColumnIndexOrThrow(r2, "span_start");     // Catch: Throwable -> L34
        int r8 = CursorUtil.getColumnIndexOrThrow(r2, "span_end");     // Catch: Throwable -> L34
        int r9 = CursorUtil.getColumnIndexOrThrow(r2, "payload");     // Catch: Throwable -> L34
        int r10 = CursorUtil.getColumnIndexOrThrow(r2, "meta");     // Catch: Throwable -> L34
        int r11 = CursorUtil.getColumnIndexOrThrow(r2, "state");     // Catch: Throwable -> L34
        int r12 = CursorUtil.getColumnIndexOrThrow(r2, "client_state");     // Catch: Throwable -> L34
        int r13 = CursorUtil.getColumnIndexOrThrow(r2, "retry_count");     // Catch: Throwable -> L34
        int r14 = CursorUtil.getColumnIndexOrThrow(r2, "last_error_code");     // Catch: Throwable -> L34
        ArrayList r15 = new ArrayList(r2.getCount());     // Catch: Throwable -> L34
    L4:
        if (r2.moveToNext() == false) goto L32;
        long r17 = r2.getLong(r0);     // Catch: Throwable -> L34
        if (r2.isNull(r4) == false) goto L9;
        String r19 = null;
    L11:
        if (r2.isNull(r5) == false) goto L13;
        String r20 = null;
    L14:
        long r21 = r2.getLong(r6);     // Catch: Throwable -> L34
        long r23 = r2.getLong(r7);     // Catch: Throwable -> L34
        long r25 = r2.getLong(r8);     // Catch: Throwable -> L34
        if (r2.isNull(r9) == false) goto L17;
        String r27 = null;
    L19:
        if (r2.isNull(r10) == false) goto L21;
        String r28 = null;
    L23:
        if (r2.isNull(r11) == false) goto L25;
        String r29 = null;
    L27:
        if (r2.isNull(r12) == false) goto L29;
        String r30 = null;
    L30:
        r15.add(new RawObservationEntity(r17, r19, r20, r21, r23, r25, r27, r28, r29, r30, r2.getInt(r13), r2.getInt(r14)));     // Catch: Throwable -> L34
        goto L4
    L29:
        r30 = r2.getString(r12);     // Catch: Throwable -> L34
        goto L30
    L25:
        r29 = r2.getString(r11);     // Catch: Throwable -> L34
        goto L27
    L21:
        r28 = r2.getString(r10);     // Catch: Throwable -> L34
        goto L23
    L17:
        r27 = r2.getString(r9);     // Catch: Throwable -> L34
        goto L19
    L13:
        r20 = r2.getString(r5);     // Catch: Throwable -> L34
        goto L14
    L9:
        r19 = r2.getString(r4);     // Catch: Throwable -> L34
        goto L11
    L32:
        r2.close();
        r1.release();
        return r15;
    L34:
        th = move-exception;
        r2.close();
        r1.release();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.RawObservationDao
    public List<RawObservationEntity> queryLatestGlassesForDebug(int r34) {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM RawObservation WHERE source = 'glasses' ORDER BY id DESC LIMIT ?", 1);
        r1.bindLong(1, r34);
        this.__db.assertNotSuspendingTransaction();
        Cursor r2 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r2, OaidModel.KEY_ID);     // Catch: Throwable -> L34
        int r4 = CursorUtil.getColumnIndexOrThrow(r2, "device_id");     // Catch: Throwable -> L34
        int r5 = CursorUtil.getColumnIndexOrThrow(r2, AILabCheckPermissionTask.KEY_SOURCE);     // Catch: Throwable -> L34
        int r6 = CursorUtil.getColumnIndexOrThrow(r2, "timestamp");     // Catch: Throwable -> L34
        int r7 = CursorUtil.getColumnIndexOrThrow(r2, "span_start");     // Catch: Throwable -> L34
        int r8 = CursorUtil.getColumnIndexOrThrow(r2, "span_end");     // Catch: Throwable -> L34
        int r9 = CursorUtil.getColumnIndexOrThrow(r2, "payload");     // Catch: Throwable -> L34
        int r10 = CursorUtil.getColumnIndexOrThrow(r2, "meta");     // Catch: Throwable -> L34
        int r11 = CursorUtil.getColumnIndexOrThrow(r2, "state");     // Catch: Throwable -> L34
        int r12 = CursorUtil.getColumnIndexOrThrow(r2, "client_state");     // Catch: Throwable -> L34
        int r13 = CursorUtil.getColumnIndexOrThrow(r2, "retry_count");     // Catch: Throwable -> L34
        int r14 = CursorUtil.getColumnIndexOrThrow(r2, "last_error_code");     // Catch: Throwable -> L34
        ArrayList r15 = new ArrayList(r2.getCount());     // Catch: Throwable -> L34
    L4:
        if (r2.moveToNext() == false) goto L32;
        long r17 = r2.getLong(r0);     // Catch: Throwable -> L34
        if (r2.isNull(r4) == false) goto L9;
        String r19 = null;
    L11:
        if (r2.isNull(r5) == false) goto L13;
        String r20 = null;
    L14:
        long r21 = r2.getLong(r6);     // Catch: Throwable -> L34
        long r23 = r2.getLong(r7);     // Catch: Throwable -> L34
        long r25 = r2.getLong(r8);     // Catch: Throwable -> L34
        if (r2.isNull(r9) == false) goto L17;
        String r27 = null;
    L19:
        if (r2.isNull(r10) == false) goto L21;
        String r28 = null;
    L23:
        if (r2.isNull(r11) == false) goto L25;
        String r29 = null;
    L27:
        if (r2.isNull(r12) == false) goto L29;
        String r30 = null;
    L30:
        r15.add(new RawObservationEntity(r17, r19, r20, r21, r23, r25, r27, r28, r29, r30, r2.getInt(r13), r2.getInt(r14)));     // Catch: Throwable -> L34
        goto L4
    L29:
        r30 = r2.getString(r12);     // Catch: Throwable -> L34
        goto L30
    L25:
        r29 = r2.getString(r11);     // Catch: Throwable -> L34
        goto L27
    L21:
        r28 = r2.getString(r10);     // Catch: Throwable -> L34
        goto L23
    L17:
        r27 = r2.getString(r9);     // Catch: Throwable -> L34
        goto L19
    L13:
        r20 = r2.getString(r5);     // Catch: Throwable -> L34
        goto L14
    L9:
        r19 = r2.getString(r4);     // Catch: Throwable -> L34
        goto L11
    L32:
        r2.close();
        r1.release();
        return r15;
    L34:
        th = move-exception;
        r2.close();
        r1.release();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.RawObservationDao
    public Long queryLatestGlassesTimestampForDebug() {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT MAX(timestamp) FROM RawObservation WHERE source = 'glasses'", 0);
        this.__db.assertNotSuspendingTransaction();
        Long r2 = null;
        Cursor r4 = DBUtil.query(this.__db, r0, false, null);
    L12:
        th = move-exception;
        r4.close();
        r0.release();
        throw th;
    L4:
        if (r4.moveToFirst() == true) goto L6;
    L10:
        r4.close();
        r0.release();
        return r2;
    L6:
        if (r4.isNull(0) == true) goto L10;
        r2 = Long.valueOf(r4.getLong(0));     // Catch: Throwable -> L12
        goto L10
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public RawObservationEntity queryOne() {
        return RawObservationDao.DefaultImpls.queryOne(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ RawObservationEntity queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.RawObservationDao
    public List<RawObservationEntity> queryPending(String r34, String r35, int r36) {
        RoomSQLiteQuery r3 = RoomSQLiteQuery.acquire("SELECT * FROM RawObservation WHERE device_id = ? AND source = ? AND state = 'PENDING' ORDER BY timestamp ASC LIMIT ?", 3);
        if (r34 != null) goto L5;
        r3.bindNull(1);
    L7:
        if (r35 != null) goto L9;
        r3.bindNull(2);
    L10:
        r3.bindLong(3, r36);
        this.__db.assertNotSuspendingTransaction();
        Cursor r1 = DBUtil.query(this.__db, r3, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r1, OaidModel.KEY_ID);     // Catch: Throwable -> L42
        int r4 = CursorUtil.getColumnIndexOrThrow(r1, "device_id");     // Catch: Throwable -> L42
        int r5 = CursorUtil.getColumnIndexOrThrow(r1, AILabCheckPermissionTask.KEY_SOURCE);     // Catch: Throwable -> L42
        int r6 = CursorUtil.getColumnIndexOrThrow(r1, "timestamp");     // Catch: Throwable -> L42
        int r7 = CursorUtil.getColumnIndexOrThrow(r1, "span_start");     // Catch: Throwable -> L42
        int r8 = CursorUtil.getColumnIndexOrThrow(r1, "span_end");     // Catch: Throwable -> L42
        int r9 = CursorUtil.getColumnIndexOrThrow(r1, "payload");     // Catch: Throwable -> L42
        int r10 = CursorUtil.getColumnIndexOrThrow(r1, "meta");     // Catch: Throwable -> L42
        int r11 = CursorUtil.getColumnIndexOrThrow(r1, "state");     // Catch: Throwable -> L42
        int r12 = CursorUtil.getColumnIndexOrThrow(r1, "client_state");     // Catch: Throwable -> L42
        int r13 = CursorUtil.getColumnIndexOrThrow(r1, "retry_count");     // Catch: Throwable -> L42
        int r14 = CursorUtil.getColumnIndexOrThrow(r1, "last_error_code");     // Catch: Throwable -> L42
        ArrayList r15 = new ArrayList(r1.getCount());     // Catch: Throwable -> L42
    L12:
        if (r1.moveToNext() == false) goto L40;
        long r17 = r1.getLong(r0);     // Catch: Throwable -> L42
        if (r1.isNull(r4) == false) goto L17;
        String r19 = null;
    L19:
        if (r1.isNull(r5) == false) goto L21;
        String r20 = null;
    L22:
        long r21 = r1.getLong(r6);     // Catch: Throwable -> L42
        long r23 = r1.getLong(r7);     // Catch: Throwable -> L42
        long r25 = r1.getLong(r8);     // Catch: Throwable -> L42
        if (r1.isNull(r9) == false) goto L25;
        String r27 = null;
    L27:
        if (r1.isNull(r10) == false) goto L29;
        String r28 = null;
    L31:
        if (r1.isNull(r11) == false) goto L33;
        String r29 = null;
    L35:
        if (r1.isNull(r12) == false) goto L37;
        String r30 = null;
    L38:
        r15.add(new RawObservationEntity(r17, r19, r20, r21, r23, r25, r27, r28, r29, r30, r1.getInt(r13), r1.getInt(r14)));     // Catch: Throwable -> L42
        goto L12
    L37:
        r30 = r1.getString(r12);     // Catch: Throwable -> L42
        goto L38
    L33:
        r29 = r1.getString(r11);     // Catch: Throwable -> L42
        goto L35
    L29:
        r28 = r1.getString(r10);     // Catch: Throwable -> L42
        goto L31
    L25:
        r27 = r1.getString(r9);     // Catch: Throwable -> L42
        goto L27
    L21:
        r20 = r1.getString(r5);     // Catch: Throwable -> L42
        goto L22
    L17:
        r19 = r1.getString(r4);     // Catch: Throwable -> L42
        goto L19
    L40:
        r1.close();
        r3.release();
        return r15;
    L42:
        th = move-exception;
        r1.close();
        r3.release();
        throw th;
    L9:
        r3.bindString(2, r35);
        goto L10
    L5:
        r3.bindString(1, r34);
        goto L7
    }

    @Override // com.obric.memorydata.database.dao.RawObservationDao
    public int queryPendingScreenshotCount() {
        int r1 = 0;
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM RawObservation WHERE source = 'screenshot' AND state != 'DONE'", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor r3 = DBUtil.query(this.__db, r0, false, null);
    L8:
        th = move-exception;
        r3.close();
        r0.release();
        throw th;
    L4:
        if (r3.moveToFirst() == false) goto L6;
        r1 = r3.getInt(0);     // Catch: Throwable -> L8
    L6:
        r3.close();
        r0.release();
        return r1;
    }

    @Override // com.obric.memorydata.database.dao.RawObservationDao
    public List<WorkKey> queryPendingWorkKeys() {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT device_id, source FROM RawObservation WHERE state = 'PENDING' GROUP BY device_id, source ORDER BY MIN(timestamp) ASC", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor r7 = DBUtil.query(this.__db, r0, false, null);
        ArrayList r3 = new ArrayList(r7.getCount());     // Catch: Throwable -> L18
    L4:
        if (r7.moveToNext() == false) goto L16;
        if (r7.isNull(0) == false) goto L9;
        String r4 = null;
    L11:
        if (r7.isNull(1) == false) goto L13;
        String r5 = null;
    L14:
        r3.add(new WorkKey(r4, r5));     // Catch: Throwable -> L18
        goto L4
    L13:
        r5 = r7.getString(1);     // Catch: Throwable -> L18
        goto L14
    L9:
        r4 = r7.getString(0);     // Catch: Throwable -> L18
        goto L11
    L16:
        r7.close();
        r0.release();
        return r3;
    L18:
        th = move-exception;
        r7.close();
        r0.release();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.RawObservationDao
    public List<RawObservationEntity> queryScreenshotByIds(List<Long> r34) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r34, List.class, "com.obric.memorydata.plugin");
        StringBuilder r3 = StringUtil.newStringBuilder();
        r3.append("SELECT * FROM RawObservation WHERE source = 'screenshot' AND id IN (");
        int r4 = r1.size();
        StringUtil.appendPlaceholders(r3, r4);
        r3.append(")");
        RoomSQLiteQuery r5 = RoomSQLiteQuery.acquire(r3.toString(), r4 + 0);
        Iterator r2 = r1.iterator();
        int r6 = 1;
    L4:
        if (r2.hasNext() == false) goto L6;
        r5.bindLong(r6, ((Long) ZeusTransformUtils.preCheckCast(r2.next(), Long.class, "com.obric.memorydata.plugin")).longValue());
        r6 = r6 + 1;
        goto L4
    L6:
        this.__db.assertNotSuspendingTransaction();
        Cursor r7 = DBUtil.query(this.__db, r5, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r7, OaidModel.KEY_ID);     // Catch: Throwable -> L38
        int r8 = CursorUtil.getColumnIndexOrThrow(r7, "device_id");     // Catch: Throwable -> L38
        int r9 = CursorUtil.getColumnIndexOrThrow(r7, AILabCheckPermissionTask.KEY_SOURCE);     // Catch: Throwable -> L38
        int r10 = CursorUtil.getColumnIndexOrThrow(r7, "timestamp");     // Catch: Throwable -> L38
        int r11 = CursorUtil.getColumnIndexOrThrow(r7, "span_start");     // Catch: Throwable -> L38
        int r12 = CursorUtil.getColumnIndexOrThrow(r7, "span_end");     // Catch: Throwable -> L38
        int r13 = CursorUtil.getColumnIndexOrThrow(r7, "payload");     // Catch: Throwable -> L38
        int r14 = CursorUtil.getColumnIndexOrThrow(r7, "meta");     // Catch: Throwable -> L38
        int r15 = CursorUtil.getColumnIndexOrThrow(r7, "state");     // Catch: Throwable -> L38
        int r16 = CursorUtil.getColumnIndexOrThrow(r7, "client_state");     // Catch: Throwable -> L38
        int r17 = CursorUtil.getColumnIndexOrThrow(r7, "retry_count");     // Catch: Throwable -> L38
        int r18 = CursorUtil.getColumnIndexOrThrow(r7, "last_error_code");     // Catch: Throwable -> L38
        ArrayList r19 = new ArrayList(r7.getCount());     // Catch: Throwable -> L38
    L8:
        if (r7.moveToNext() == false) goto L36;
        long r110 = r7.getLong(r0);     // Catch: Throwable -> L38
        if (r7.isNull(r8) == false) goto L13;
        String r111 = null;
    L15:
        if (r7.isNull(r9) == false) goto L17;
        String r20 = null;
    L18:
        long r21 = r7.getLong(r10);     // Catch: Throwable -> L38
        long r23 = r7.getLong(r11);     // Catch: Throwable -> L38
        long r25 = r7.getLong(r12);     // Catch: Throwable -> L38
        if (r7.isNull(r13) == false) goto L21;
        String r27 = null;
    L23:
        if (r7.isNull(r14) == false) goto L25;
        String r28 = null;
    L27:
        if (r7.isNull(r15) == false) goto L29;
        String r29 = null;
    L31:
        if (r7.isNull(r16) == false) goto L33;
        String r30 = null;
    L34:
        r19.add(new RawObservationEntity(r110, r111, r20, r21, r23, r25, r27, r28, r29, r30, r7.getInt(r17), r7.getInt(r18)));     // Catch: Throwable -> L38
        goto L8
    L33:
        r30 = r7.getString(r16);     // Catch: Throwable -> L38
        goto L34
    L29:
        r29 = r7.getString(r15);     // Catch: Throwable -> L38
        goto L31
    L25:
        r28 = r7.getString(r14);     // Catch: Throwable -> L38
        goto L27
    L21:
        r27 = r7.getString(r13);     // Catch: Throwable -> L38
        goto L23
    L17:
        r20 = r7.getString(r9);     // Catch: Throwable -> L38
        goto L18
    L13:
        r111 = r7.getString(r8);     // Catch: Throwable -> L38
        goto L15
    L36:
        r7.close();
        r5.release();
        return r19;
    L38:
        th = move-exception;
        r7.close();
        r5.release();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.RawObservationDao
    public List<String> queryScreenshotPayloads() {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT payload FROM RawObservation WHERE source = 'screenshot' AND payload != ''", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor r5 = DBUtil.query(this.__db, r0, false, null);
        ArrayList r3 = new ArrayList(r5.getCount());     // Catch: Throwable -> L14
    L4:
        if (r5.moveToNext() == false) goto L12;
        if (r5.isNull(0) == false) goto L9;
        String r4 = null;
    L10:
        r3.add(r4);     // Catch: Throwable -> L14
        goto L4
    L9:
        r4 = r5.getString(0);     // Catch: Throwable -> L14
        goto L10
    L12:
        r5.close();
        r0.release();
        return r3;
    L14:
        th = move-exception;
        r5.close();
        r0.release();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.RawObservationDao
    public List<RawObservationEntity> queryScreenshotsInWindow(long r34, long r36) {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM RawObservation WHERE source = 'screenshot' AND timestamp >= ? AND timestamp <= ? ORDER BY timestamp ASC", 2);
        r1.bindLong(1, r34);
        r1.bindLong(2, r36);
        this.__db.assertNotSuspendingTransaction();
        Cursor r2 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r2, OaidModel.KEY_ID);     // Catch: Throwable -> L34
        int r4 = CursorUtil.getColumnIndexOrThrow(r2, "device_id");     // Catch: Throwable -> L34
        int r5 = CursorUtil.getColumnIndexOrThrow(r2, AILabCheckPermissionTask.KEY_SOURCE);     // Catch: Throwable -> L34
        int r6 = CursorUtil.getColumnIndexOrThrow(r2, "timestamp");     // Catch: Throwable -> L34
        int r7 = CursorUtil.getColumnIndexOrThrow(r2, "span_start");     // Catch: Throwable -> L34
        int r8 = CursorUtil.getColumnIndexOrThrow(r2, "span_end");     // Catch: Throwable -> L34
        int r9 = CursorUtil.getColumnIndexOrThrow(r2, "payload");     // Catch: Throwable -> L34
        int r10 = CursorUtil.getColumnIndexOrThrow(r2, "meta");     // Catch: Throwable -> L34
        int r11 = CursorUtil.getColumnIndexOrThrow(r2, "state");     // Catch: Throwable -> L34
        int r12 = CursorUtil.getColumnIndexOrThrow(r2, "client_state");     // Catch: Throwable -> L34
        int r13 = CursorUtil.getColumnIndexOrThrow(r2, "retry_count");     // Catch: Throwable -> L34
        int r14 = CursorUtil.getColumnIndexOrThrow(r2, "last_error_code");     // Catch: Throwable -> L34
        ArrayList r15 = new ArrayList(r2.getCount());     // Catch: Throwable -> L34
    L4:
        if (r2.moveToNext() == false) goto L32;
        long r17 = r2.getLong(r0);     // Catch: Throwable -> L34
        if (r2.isNull(r4) == false) goto L9;
        String r19 = null;
    L11:
        if (r2.isNull(r5) == false) goto L13;
        String r20 = null;
    L14:
        long r21 = r2.getLong(r6);     // Catch: Throwable -> L34
        long r23 = r2.getLong(r7);     // Catch: Throwable -> L34
        long r25 = r2.getLong(r8);     // Catch: Throwable -> L34
        if (r2.isNull(r9) == false) goto L17;
        String r27 = null;
    L19:
        if (r2.isNull(r10) == false) goto L21;
        String r28 = null;
    L23:
        if (r2.isNull(r11) == false) goto L25;
        String r29 = null;
    L27:
        if (r2.isNull(r12) == false) goto L29;
        String r30 = null;
    L30:
        r15.add(new RawObservationEntity(r17, r19, r20, r21, r23, r25, r27, r28, r29, r30, r2.getInt(r13), r2.getInt(r14)));     // Catch: Throwable -> L34
        goto L4
    L29:
        r30 = r2.getString(r12);     // Catch: Throwable -> L34
        goto L30
    L25:
        r29 = r2.getString(r11);     // Catch: Throwable -> L34
        goto L27
    L21:
        r28 = r2.getString(r10);     // Catch: Throwable -> L34
        goto L23
    L17:
        r27 = r2.getString(r9);     // Catch: Throwable -> L34
        goto L19
    L13:
        r20 = r2.getString(r5);     // Catch: Throwable -> L34
        goto L14
    L9:
        r19 = r2.getString(r4);     // Catch: Throwable -> L34
        goto L11
    L32:
        r2.close();
        r1.release();
        return r15;
    L34:
        th = move-exception;
        r2.close();
        r1.release();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<RawObservationEntity> queryWithLimitAndOffset(int r1, int r2) {
        return RawObservationDao.DefaultImpls.queryWithLimitAndOffset(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<RawObservationEntity> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntityRawObservationEntity(r6));     // Catch: Throwable -> L10
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

    /* JADX INFO: renamed from: update, reason: avoid collision after fix types in other method */
    public int update2(RawObservationEntity r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfRawObservationEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int update(RawObservationEntity r3) {
        return update2((RawObservationEntity) ZeusTransformUtils.preCheckCast(r3, RawObservationEntity.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<RawObservationEntity> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfRawObservationEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.RawObservationDao
    public int updateMeta(long r3, String r5) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfUpdateMeta.acquire();
        if (r5 != null) goto L5;
        r0.bindNull(1);
    L6:
        r0.bindLong(2, r3);
        this.__db.beginTransaction();
        int r4 = r0.executeUpdateDelete();     // Catch: Throwable -> L10
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.__db.endTransaction();
        this.__preparedStmtOfUpdateMeta.release(r0);
        return r4;
    L10:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfUpdateMeta.release(r0);
        throw th;
    L5:
        r0.bindString(1, r5);
        goto L6
    }
}
