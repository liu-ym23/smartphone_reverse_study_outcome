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
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.database.entity.af;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class BluetoothDeviceDao_Impl implements BluetoothDeviceDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<af> __deletionAdapterOfBluetoothDeviceEntity;
    private final EntityInsertionAdapter<af> __insertionAdapterOfBluetoothDeviceEntity;
    private final EntityDeletionOrUpdateAdapter<af> __updateAdapterOfBluetoothDeviceEntity;

    public BluetoothDeviceDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfBluetoothDeviceEntity = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfBluetoothDeviceEntity = new AnonymousClass2(this, r2);
        this.__updateAdapterOfBluetoothDeviceEntity = new AnonymousClass3(this, r2);
    }

    private af __entityCursorConverter_comObricMemorydataDatabaseEntityBluetoothDeviceEntity(Cursor r25) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r25, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, "dataId");
        int r2 = CursorUtil.getColumnIndex(r0, "dataVersion");
        int r3 = CursorUtil.getColumnIndex(r0, "timestamp");
        int r4 = CursorUtil.getColumnIndex(r0, "state");
        int r5 = CursorUtil.getColumnIndex(r0, "mac");
        int r6 = CursorUtil.getColumnIndex(r0, ActivityLifecycle.NAME);
        int r7 = CursorUtil.getColumnIndex(r0, "type");
        int r8 = CursorUtil.getColumnIndex(r0, "enable");
        int r9 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r10 = 0;
        if (r1 != (-1)) goto L5;
        int r13 = 0;
    L6:
        if (r2 != (-1)) goto L8;
        int r14 = 0;
    L10:
        if (r3 != (-1)) goto L12;
        long r15 = 0;
    L13:
        if (r4 != (-1)) goto L15;
        int r17 = 0;
    L16:
        String r11 = null;
        if (r5 != (-1)) goto L20;
    L18:
        String r18 = null;
    L23:
        if (r6 != (-1)) goto L26;
    L24:
        String r19 = null;
    L29:
        if (r7 != (-1)) goto L32;
    L30:
        String r20 = r11;
        if (r8 == (-1)) goto L38;
        r10 = r0.getInt(r8);
    L38:
        int r21 = r10;
        if (r9 != (-1)) goto L41;
        long r22 = 0;
    L43:
        return new af(r13, r14, r15, r17, r18, r19, r20, r21, r22);
    L41:
        r22 = r0.getLong(r9);
        goto L43
    L32:
        if (r0.isNull(r7) == true) goto L30;
        r11 = r0.getString(r7);
        goto L30
    L26:
        if (r0.isNull(r6) == true) goto L24;
        r19 = r0.getString(r6);
        goto L29
    L20:
        if (r0.isNull(r5) == true) goto L18;
        r18 = r0.getString(r5);
        goto L23
    L15:
        r17 = r0.getInt(r4);
        goto L16
    L12:
        r15 = r0.getLong(r3);
        goto L13
    L8:
        r14 = r0.getInt(r2);
        goto L10
    L5:
        r13 = r0.getInt(r1);
        goto L6
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<af> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfBluetoothDeviceEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<af> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfBluetoothDeviceEntity.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    /* JADX INFO: renamed from: delete, reason: avoid collision after fix types in other method */
    public int delete2(af r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfBluetoothDeviceEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int delete(af r3) {
        return delete2((af) ZeusTransformUtils.preCheckCast(r3, af.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return BluetoothDeviceDao.DefaultImpls.deleteAll(this);
    }

    @Override // com.obric.memorydata.database.dao.BluetoothDeviceDao, com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return BluetoothDeviceDao.DefaultImpls.getTableName(this);
    }

    /* JADX INFO: renamed from: insert, reason: avoid collision after fix types in other method */
    public long insert2(af r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfBluetoothDeviceEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ long insert(af r3) {
        return insert2((af) ZeusTransformUtils.preCheckCast(r3, af.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<af> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfBluetoothDeviceEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<af> queryAll() {
        return BluetoothDeviceDao.DefaultImpls.queryAll(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return BluetoothDeviceDao.DefaultImpls.queryAllCount(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public af queryById(long r1) {
        return BluetoothDeviceDao.DefaultImpls.queryById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ af queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<af> queryByIds(List<Long> r3) {
        return BluetoothDeviceDao.DefaultImpls.queryByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public af queryByUUID(String r1) {
        return BluetoothDeviceDao.DefaultImpls.queryByUUID(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ af queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    @Override // com.obric.memorydata.database.dao.BluetoothDeviceDao
    public af queryLastRecords(long r26, long r28) {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM RawBluetoothDevice WHERE timestamp >= ? AND timestamp < ? ORDER BY timestamp DESC LIMIT 1", 2);
        r1.bindLong(1, r26);
        r1.bindLong(2, r28);
        this.__db.assertNotSuspendingTransaction();
        af r3 = null;
        String r4 = null;
        Cursor r2 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r2, "dataId");     // Catch: Throwable -> L20
        int r5 = CursorUtil.getColumnIndexOrThrow(r2, "dataVersion");     // Catch: Throwable -> L20
        int r6 = CursorUtil.getColumnIndexOrThrow(r2, "timestamp");     // Catch: Throwable -> L20
        int r7 = CursorUtil.getColumnIndexOrThrow(r2, "state");     // Catch: Throwable -> L20
        int r8 = CursorUtil.getColumnIndexOrThrow(r2, "mac");     // Catch: Throwable -> L20
        int r9 = CursorUtil.getColumnIndexOrThrow(r2, ActivityLifecycle.NAME);     // Catch: Throwable -> L20
        int r10 = CursorUtil.getColumnIndexOrThrow(r2, "type");     // Catch: Throwable -> L20
        int r11 = CursorUtil.getColumnIndexOrThrow(r2, "enable");     // Catch: Throwable -> L20
        int r12 = CursorUtil.getColumnIndexOrThrow(r2, OaidModel.KEY_ID);     // Catch: Throwable -> L20
        if (r2.moveToFirst() == false) goto L18;
        int r14 = r2.getInt(r0);     // Catch: Throwable -> L20
        int r15 = r2.getInt(r5);     // Catch: Throwable -> L20
        long r16 = r2.getLong(r6);     // Catch: Throwable -> L20
        int r18 = r2.getInt(r7);     // Catch: Throwable -> L20
        if (r2.isNull(r8) == false) goto L8;
        String r19 = null;
    L10:
        if (r2.isNull(r9) == false) goto L12;
        String r20 = null;
    L14:
        if (r2.isNull(r10) == true) goto L17;
        r4 = r2.getString(r10);     // Catch: Throwable -> L20
    L17:
        r3 = new af(r14, r15, r16, r18, r19, r20, r4, r2.getInt(r11), r2.getLong(r12));     // Catch: Throwable -> L20
        goto L18
    L12:
        r20 = r2.getString(r9);     // Catch: Throwable -> L20
        goto L14
    L8:
        r19 = r2.getString(r8);     // Catch: Throwable -> L20
    L18:
        r2.close();
        r1.release();
        return r3;
    L20:
        th = move-exception;
        r2.close();
        r1.release();
        throw th;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public af queryOne() {
        return BluetoothDeviceDao.DefaultImpls.queryOne(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ af queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BluetoothDeviceDao
    public List<af> queryRecords(long r27, long r29) {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM RawBluetoothDevice WHERE timestamp >= ? AND timestamp < ?", 2);
        r1.bindLong(1, r27);
        r1.bindLong(2, r29);
        this.__db.assertNotSuspendingTransaction();
        Cursor r2 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r2, "dataId");     // Catch: Throwable -> L22
        int r4 = CursorUtil.getColumnIndexOrThrow(r2, "dataVersion");     // Catch: Throwable -> L22
        int r5 = CursorUtil.getColumnIndexOrThrow(r2, "timestamp");     // Catch: Throwable -> L22
        int r6 = CursorUtil.getColumnIndexOrThrow(r2, "state");     // Catch: Throwable -> L22
        int r7 = CursorUtil.getColumnIndexOrThrow(r2, "mac");     // Catch: Throwable -> L22
        int r8 = CursorUtil.getColumnIndexOrThrow(r2, ActivityLifecycle.NAME);     // Catch: Throwable -> L22
        int r9 = CursorUtil.getColumnIndexOrThrow(r2, "type");     // Catch: Throwable -> L22
        int r10 = CursorUtil.getColumnIndexOrThrow(r2, "enable");     // Catch: Throwable -> L22
        int r11 = CursorUtil.getColumnIndexOrThrow(r2, OaidModel.KEY_ID);     // Catch: Throwable -> L22
        ArrayList r12 = new ArrayList(r2.getCount());     // Catch: Throwable -> L22
    L4:
        if (r2.moveToNext() == false) goto L20;
        int r15 = r2.getInt(r0);     // Catch: Throwable -> L22
        int r16 = r2.getInt(r4);     // Catch: Throwable -> L22
        long r17 = r2.getLong(r5);     // Catch: Throwable -> L22
        int r19 = r2.getInt(r6);     // Catch: Throwable -> L22
        if (r2.isNull(r7) == false) goto L9;
        String r20 = null;
    L11:
        if (r2.isNull(r8) == false) goto L13;
        String r21 = null;
    L15:
        if (r2.isNull(r9) == false) goto L17;
        String r22 = null;
    L18:
        r12.add(new af(r15, r16, r17, r19, r20, r21, r22, r2.getInt(r10), r2.getLong(r11)));     // Catch: Throwable -> L22
        goto L4
    L17:
        r22 = r2.getString(r9);     // Catch: Throwable -> L22
        goto L18
    L13:
        r21 = r2.getString(r8);     // Catch: Throwable -> L22
        goto L15
    L9:
        r20 = r2.getString(r7);     // Catch: Throwable -> L22
        goto L11
    L20:
        r2.close();
        r1.release();
        return r12;
    L22:
        th = move-exception;
        r2.close();
        r1.release();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<af> queryWithLimitAndOffset(int r1, int r2) {
        return BluetoothDeviceDao.DefaultImpls.queryWithLimitAndOffset(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<af> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntityBluetoothDeviceEntity(r6));     // Catch: Throwable -> L10
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
    public int update2(af r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfBluetoothDeviceEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int update(af r3) {
        return update2((af) ZeusTransformUtils.preCheckCast(r3, af.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<af> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfBluetoothDeviceEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
