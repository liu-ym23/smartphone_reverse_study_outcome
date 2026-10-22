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
import com.obric.memorydata.database.entity.aw;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class AlarmDao_Impl implements AlarmDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<aw> __deletionAdapterOfDeviceAlarmEntity;
    private final EntityInsertionAdapter<aw> __insertionAdapterOfDeviceAlarmEntity;
    private final EntityDeletionOrUpdateAdapter<aw> __updateAdapterOfDeviceAlarmEntity;

    public AlarmDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfDeviceAlarmEntity = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfDeviceAlarmEntity = new AnonymousClass2(this, r2);
        this.__updateAdapterOfDeviceAlarmEntity = new AnonymousClass3(this, r2);
    }

    private aw __entityCursorConverter_comObricMemorydataDatabaseEntityDeviceAlarmEntity(Cursor r13) {
        Cursor r12 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r13, Cursor.class, "com.obric.memorydata.plugin");
        int r14 = CursorUtil.getColumnIndex(r12, "dataId");
        int r0 = CursorUtil.getColumnIndex(r12, "dataVersion");
        int r1 = CursorUtil.getColumnIndex(r12, "timestamp");
        int r2 = CursorUtil.getColumnIndex(r12, OaidModel.KEY_ID);
        int r3 = 0;
        if (r14 != (-1)) goto L5;
        int r6 = 0;
    L6:
        if (r0 == (-1)) goto L9;
        r3 = r12.getInt(r0);
    L9:
        int r7 = r3;
        if (r1 != (-1)) goto L12;
        long r4 = 0;
    L13:
        if (r2 != (-1)) goto L15;
        long r10 = 0;
    L17:
        return new aw(r6, r7, r4, r10);
    L15:
        r10 = r12.getLong(r2);
        goto L17
    L12:
        r4 = r12.getLong(r1);
        goto L13
    L5:
        r6 = r12.getInt(r14);
        goto L6
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<aw> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfDeviceAlarmEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<aw> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfDeviceAlarmEntity.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    /* JADX INFO: renamed from: delete, reason: avoid collision after fix types in other method */
    public int delete2(aw r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfDeviceAlarmEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int delete(aw r3) {
        return delete2((aw) ZeusTransformUtils.preCheckCast(r3, aw.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return AlarmDao.DefaultImpls.deleteAll(this);
    }

    @Override // com.obric.memorydata.database.dao.AlarmDao, com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return AlarmDao.DefaultImpls.getTableName(this);
    }

    /* JADX INFO: renamed from: insert, reason: avoid collision after fix types in other method */
    public long insert2(aw r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfDeviceAlarmEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ long insert(aw r3) {
        return insert2((aw) ZeusTransformUtils.preCheckCast(r3, aw.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<aw> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfDeviceAlarmEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<aw> queryAll() {
        return AlarmDao.DefaultImpls.queryAll(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return AlarmDao.DefaultImpls.queryAllCount(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public aw queryById(long r1) {
        return AlarmDao.DefaultImpls.queryById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ aw queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<aw> queryByIds(List<Long> r3) {
        return AlarmDao.DefaultImpls.queryByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public aw queryByUUID(String r1) {
        return AlarmDao.DefaultImpls.queryByUUID(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ aw queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public aw queryOne() {
        return AlarmDao.DefaultImpls.queryOne(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ aw queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.AlarmDao
    public List<aw> queryRecords(long r11, long r13) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM RawAlarm WHERE timestamp >= ? AND timestamp < ?", 2);
        r0.bindLong(1, r11);
        r0.bindLong(2, r13);
        this.__db.assertNotSuspendingTransaction();
        Cursor r10 = DBUtil.query(this.__db, r0, false, null);
        int r12 = CursorUtil.getColumnIndexOrThrow(r10, "dataId");     // Catch: Throwable -> L10
        int r14 = CursorUtil.getColumnIndexOrThrow(r10, "dataVersion");     // Catch: Throwable -> L10
        int r15 = CursorUtil.getColumnIndexOrThrow(r10, "timestamp");     // Catch: Throwable -> L10
        int r16 = CursorUtil.getColumnIndexOrThrow(r10, OaidModel.KEY_ID);     // Catch: Throwable -> L10
        ArrayList r1 = new ArrayList(r10.getCount());     // Catch: Throwable -> L10
    L5:
        if (r10.moveToNext() == false) goto L8;
        r1.add(new aw(r10.getInt(r12), r10.getInt(r14), r10.getLong(r15), r10.getLong(r16)));     // Catch: Throwable -> L10
        goto L5
    L8:
        r10.close();
        r0.release();
        return r1;
    L10:
        th = move-exception;
        r10.close();
        r0.release();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<aw> queryWithLimitAndOffset(int r1, int r2) {
        return AlarmDao.DefaultImpls.queryWithLimitAndOffset(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<aw> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntityDeviceAlarmEntity(r6));     // Catch: Throwable -> L10
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
    public int update2(aw r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfDeviceAlarmEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int update(aw r3) {
        return update2((aw) ZeusTransformUtils.preCheckCast(r3, aw.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<aw> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfDeviceAlarmEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
