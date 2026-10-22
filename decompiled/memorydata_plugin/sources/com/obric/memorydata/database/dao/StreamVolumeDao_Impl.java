package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.database.entity.io;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class StreamVolumeDao_Impl implements StreamVolumeDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<io> __deletionAdapterOfStreamVolumeEntity;
    private final EntityInsertionAdapter<io> __insertionAdapterOfStreamVolumeEntity;
    private final EntityDeletionOrUpdateAdapter<io> __updateAdapterOfStreamVolumeEntity;

    public StreamVolumeDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfStreamVolumeEntity = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfStreamVolumeEntity = new AnonymousClass2(this, r2);
        this.__updateAdapterOfStreamVolumeEntity = new AnonymousClass3(this, r2);
    }

    private io __entityCursorConverter_comObricMemorydataDatabaseEntityStreamVolumeEntity(Cursor r33) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r33, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, "dataId");
        int r2 = CursorUtil.getColumnIndex(r0, "dataVersion");
        int r3 = CursorUtil.getColumnIndex(r0, "timestamp");
        int r4 = CursorUtil.getColumnIndex(r0, "voiceCallVolume");
        int r5 = CursorUtil.getColumnIndex(r0, "systemStreamVolume");
        int r6 = CursorUtil.getColumnIndex(r0, "ringStreamVolume");
        int r7 = CursorUtil.getColumnIndex(r0, "musicStreamVolume");
        int r8 = CursorUtil.getColumnIndex(r0, "alarmStreamVolume");
        int r9 = CursorUtil.getColumnIndex(r0, "notificationStreamVolume");
        int r10 = CursorUtil.getColumnIndex(r0, "ringerMode");
        int r11 = CursorUtil.getColumnIndex(r0, "assistantVolume");
        int r12 = CursorUtil.getColumnIndex(r0, "vibrationEnable");
        int r13 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r14 = 0;
        if (r1 != (-1)) goto L5;
        int r17 = 0;
    L6:
        if (r2 != (-1)) goto L8;
        int r18 = 0;
    L10:
        if (r3 != (-1)) goto L12;
        long r19 = 0;
    L13:
        if (r4 != (-1)) goto L15;
        int r21 = 0;
    L16:
        if (r5 != (-1)) goto L18;
        int r22 = 0;
    L19:
        if (r6 != (-1)) goto L21;
        int r23 = 0;
    L22:
        if (r7 != (-1)) goto L24;
        int r24 = 0;
    L25:
        if (r8 != (-1)) goto L27;
        int r25 = 0;
    L28:
        if (r9 != (-1)) goto L30;
        int r26 = 0;
    L31:
        if (r10 != (-1)) goto L33;
        int r27 = 0;
    L34:
        if (r11 != (-1)) goto L36;
        int r28 = 0;
    L37:
        if (r12 == (-1)) goto L40;
        r14 = r0.getInt(r12);
    L40:
        int r29 = r14;
        if (r13 != (-1)) goto L43;
        long r30 = 0;
    L45:
        return new io(r17, r18, r19, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30);
    L43:
        r30 = r0.getLong(r13);
        goto L45
    L36:
        r28 = r0.getInt(r11);
        goto L37
    L33:
        r27 = r0.getInt(r10);
        goto L34
    L30:
        r26 = r0.getInt(r9);
        goto L31
    L27:
        r25 = r0.getInt(r8);
        goto L28
    L24:
        r24 = r0.getInt(r7);
        goto L25
    L21:
        r23 = r0.getInt(r6);
        goto L22
    L18:
        r22 = r0.getInt(r5);
        goto L19
    L15:
        r21 = r0.getInt(r4);
        goto L16
    L12:
        r19 = r0.getLong(r3);
        goto L13
    L8:
        r18 = r0.getInt(r2);
        goto L10
    L5:
        r17 = r0.getInt(r1);
        goto L6
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<io> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfStreamVolumeEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<io> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfStreamVolumeEntity.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    /* JADX INFO: renamed from: delete, reason: avoid collision after fix types in other method */
    public int delete2(io r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfStreamVolumeEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int delete(io r3) {
        return delete2((io) ZeusTransformUtils.preCheckCast(r3, io.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return StreamVolumeDao.DefaultImpls.deleteAll(this);
    }

    @Override // com.obric.memorydata.database.dao.StreamVolumeDao, com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return StreamVolumeDao.DefaultImpls.getTableName(this);
    }

    /* JADX INFO: renamed from: insert, reason: avoid collision after fix types in other method */
    public long insert2(io r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfStreamVolumeEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ long insert(io r3) {
        return insert2((io) ZeusTransformUtils.preCheckCast(r3, io.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<io> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfStreamVolumeEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<io> queryAll() {
        return StreamVolumeDao.DefaultImpls.queryAll(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return StreamVolumeDao.DefaultImpls.queryAllCount(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public io queryById(long r1) {
        return StreamVolumeDao.DefaultImpls.queryById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ io queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<io> queryByIds(List<Long> r3) {
        return StreamVolumeDao.DefaultImpls.queryByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public io queryByUUID(String r1) {
        return StreamVolumeDao.DefaultImpls.queryByUUID(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ io queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public io queryOne() {
        return StreamVolumeDao.DefaultImpls.queryOne(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ io queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<io> queryWithLimitAndOffset(int r1, int r2) {
        return StreamVolumeDao.DefaultImpls.queryWithLimitAndOffset(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<io> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntityStreamVolumeEntity(r6));     // Catch: Throwable -> L10
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
    public int update2(io r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfStreamVolumeEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int update(io r3) {
        return update2((io) ZeusTransformUtils.preCheckCast(r3, io.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<io> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfStreamVolumeEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
