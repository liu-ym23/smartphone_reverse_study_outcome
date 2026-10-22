package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.database.entity.dq;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class MovementStateDao_Impl implements MovementStateDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<dq> __deletionAdapterOfMovementStateEntity;
    private final EntityInsertionAdapter<dq> __insertionAdapterOfMovementStateEntity;
    private final EntityDeletionOrUpdateAdapter<dq> __updateAdapterOfMovementStateEntity;

    public MovementStateDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfMovementStateEntity = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfMovementStateEntity = new AnonymousClass2(this, r2);
        this.__updateAdapterOfMovementStateEntity = new AnonymousClass3(this, r2);
    }

    private dq __entityCursorConverter_comObricMemorydataDatabaseEntityMovementStateEntity(Cursor r21) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r21, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, "dataId");
        int r2 = CursorUtil.getColumnIndex(r0, "dataVersion");
        int r3 = CursorUtil.getColumnIndex(r0, "timestamp");
        int r4 = CursorUtil.getColumnIndex(r0, "state");
        int r5 = CursorUtil.getColumnIndex(r0, "stateV1");
        int r6 = CursorUtil.getColumnIndex(r0, "deviceOrientation");
        int r7 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r8 = 0;
        if (r1 != (-1)) goto L5;
        int r11 = 0;
    L6:
        if (r2 != (-1)) goto L8;
        int r12 = 0;
    L10:
        if (r3 != (-1)) goto L12;
        long r13 = 0;
    L13:
        if (r4 != (-1)) goto L15;
        int r15 = 0;
    L16:
        if (r5 != (-1)) goto L18;
        int r16 = 0;
    L19:
        if (r6 == (-1)) goto L22;
        r8 = r0.getInt(r6);
    L22:
        int r17 = r8;
        if (r7 != (-1)) goto L25;
        long r18 = 0;
    L27:
        return new dq(r11, r12, r13, r15, r16, r17, r18);
    L25:
        r18 = r0.getLong(r7);
        goto L27
    L18:
        r16 = r0.getInt(r5);
        goto L19
    L15:
        r15 = r0.getInt(r4);
        goto L16
    L12:
        r13 = r0.getLong(r3);
        goto L13
    L8:
        r12 = r0.getInt(r2);
        goto L10
    L5:
        r11 = r0.getInt(r1);
        goto L6
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<dq> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfMovementStateEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<dq> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfMovementStateEntity.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    /* JADX INFO: renamed from: delete, reason: avoid collision after fix types in other method */
    public int delete2(dq r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfMovementStateEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int delete(dq r3) {
        return delete2((dq) ZeusTransformUtils.preCheckCast(r3, dq.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return MovementStateDao.DefaultImpls.deleteAll(this);
    }

    @Override // com.obric.memorydata.database.dao.MovementStateDao, com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return MovementStateDao.DefaultImpls.getTableName(this);
    }

    /* JADX INFO: renamed from: insert, reason: avoid collision after fix types in other method */
    public long insert2(dq r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfMovementStateEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ long insert(dq r3) {
        return insert2((dq) ZeusTransformUtils.preCheckCast(r3, dq.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<dq> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfMovementStateEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<dq> queryAll() {
        return MovementStateDao.DefaultImpls.queryAll(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return MovementStateDao.DefaultImpls.queryAllCount(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public dq queryById(long r1) {
        return MovementStateDao.DefaultImpls.queryById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ dq queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<dq> queryByIds(List<Long> r3) {
        return MovementStateDao.DefaultImpls.queryByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public dq queryByUUID(String r1) {
        return MovementStateDao.DefaultImpls.queryByUUID(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ dq queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    @Override // com.obric.memorydata.database.dao.MovementStateDao
    public dq queryLastRecord() {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM RawMovementState ORDER BY timestamp DESC LIMIT 1", 0);
        this.__db.assertNotSuspendingTransaction();
        dq r3 = null;
        Cursor r2 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r2, "dataId");     // Catch: Throwable -> L8
        int r4 = CursorUtil.getColumnIndexOrThrow(r2, "dataVersion");     // Catch: Throwable -> L8
        int r5 = CursorUtil.getColumnIndexOrThrow(r2, "timestamp");     // Catch: Throwable -> L8
        int r6 = CursorUtil.getColumnIndexOrThrow(r2, "state");     // Catch: Throwable -> L8
        int r7 = CursorUtil.getColumnIndexOrThrow(r2, "stateV1");     // Catch: Throwable -> L8
        int r8 = CursorUtil.getColumnIndexOrThrow(r2, "deviceOrientation");     // Catch: Throwable -> L8
        int r9 = CursorUtil.getColumnIndexOrThrow(r2, OaidModel.KEY_ID);     // Catch: Throwable -> L8
        if (r2.moveToFirst() == false) goto L6;
        r3 = new dq(r2.getInt(r0), r2.getInt(r4), r2.getLong(r5), r2.getInt(r6), r2.getInt(r7), r2.getInt(r8), r2.getLong(r9));     // Catch: Throwable -> L8
    L6:
        r2.close();
        r1.release();
        return r3;
    L8:
        th = move-exception;
        r2.close();
        r1.release();
        throw th;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public dq queryOne() {
        return MovementStateDao.DefaultImpls.queryOne(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ dq queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.MovementStateDao
    public List<dq> queryRecords(long r22, long r24) {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM RawMovementState WHERE timestamp >= ? AND timestamp < ? ORDER BY timestamp ASC", 2);
        r1.bindLong(1, r22);
        r1.bindLong(2, r24);
        this.__db.assertNotSuspendingTransaction();
        Cursor r2 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r2, "dataId");     // Catch: Throwable -> L10
        int r3 = CursorUtil.getColumnIndexOrThrow(r2, "dataVersion");     // Catch: Throwable -> L10
        int r4 = CursorUtil.getColumnIndexOrThrow(r2, "timestamp");     // Catch: Throwable -> L10
        int r5 = CursorUtil.getColumnIndexOrThrow(r2, "state");     // Catch: Throwable -> L10
        int r6 = CursorUtil.getColumnIndexOrThrow(r2, "stateV1");     // Catch: Throwable -> L10
        int r7 = CursorUtil.getColumnIndexOrThrow(r2, "deviceOrientation");     // Catch: Throwable -> L10
        int r8 = CursorUtil.getColumnIndexOrThrow(r2, OaidModel.KEY_ID);     // Catch: Throwable -> L10
        ArrayList r9 = new ArrayList(r2.getCount());     // Catch: Throwable -> L10
    L5:
        if (r2.moveToNext() == false) goto L8;
        r9.add(new dq(r2.getInt(r0), r2.getInt(r3), r2.getLong(r4), r2.getInt(r5), r2.getInt(r6), r2.getInt(r7), r2.getLong(r8)));     // Catch: Throwable -> L10
        goto L5
    L8:
        r2.close();
        r1.release();
        return r9;
    L10:
        th = move-exception;
        r2.close();
        r1.release();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<dq> queryWithLimitAndOffset(int r1, int r2) {
        return MovementStateDao.DefaultImpls.queryWithLimitAndOffset(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<dq> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntityMovementStateEntity(r6));     // Catch: Throwable -> L10
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
    public int update2(dq r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfMovementStateEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int update(dq r3) {
        return update2((dq) ZeusTransformUtils.preCheckCast(r3, dq.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<dq> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfMovementStateEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
