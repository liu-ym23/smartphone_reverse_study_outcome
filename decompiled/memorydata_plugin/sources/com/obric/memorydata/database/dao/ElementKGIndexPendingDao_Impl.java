package com.obric.memorydata.database.dao;

import android.database.Cursor;
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
import com.obric.memorydata.database.entity.az;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class ElementKGIndexPendingDao_Impl implements ElementKGIndexPendingDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<az> __deletionAdapterOfElementKGIndexPendingEntity;
    private final EntityInsertionAdapter<az> __insertionAdapterOfElementKGIndexPendingEntity;
    private final SharedSQLiteStatement __preparedStmtOfDeleteByRawDb;
    private final SharedSQLiteStatement __preparedStmtOfDeleteItemsWithIndexed;
    private final SharedSQLiteStatement __preparedStmtOfUpdateAsLowPowerIndexed;
    private final EntityDeletionOrUpdateAdapter<az> __updateAdapterOfElementKGIndexPendingEntity;

    public ElementKGIndexPendingDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfElementKGIndexPendingEntity = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfElementKGIndexPendingEntity = new AnonymousClass2(this, r2);
        this.__updateAdapterOfElementKGIndexPendingEntity = new AnonymousClass3(this, r2);
        this.__preparedStmtOfUpdateAsLowPowerIndexed = new AnonymousClass4(this, r2);
        this.__preparedStmtOfDeleteByRawDb = new AnonymousClass5(this, r2);
        this.__preparedStmtOfDeleteItemsWithIndexed = new AnonymousClass6(this, r2);
    }

    private az __entityCursorConverter_comObricMemorydataDatabaseEntityElementKGIndexPendingEntity(Cursor r23) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r23, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r2 = CursorUtil.getColumnIndex(r0, "rawDbId");
        int r3 = CursorUtil.getColumnIndex(r0, "entityId");
        int r4 = CursorUtil.getColumnIndex(r0, "entityType");
        int r5 = CursorUtil.getColumnIndex(r0, "state");
        int r6 = CursorUtil.getColumnIndex(r0, "timestamp");
        long r7 = 0;
        if (r1 != (-1)) goto L5;
        long r13 = 0;
    L6:
        if (r2 != (-1)) goto L8;
        long r15 = 0;
    L9:
        String r8 = null;
        if (r3 != (-1)) goto L13;
    L11:
        String r17 = r8;
        int r9 = 0;
        if (r4 != (-1)) goto L19;
        int r18 = 0;
    L20:
        if (r5 == (-1)) goto L23;
        r9 = r0.getInt(r5);
    L23:
        int r19 = r9;
        if (r6 == (-1)) goto L28;
        r7 = r0.getLong(r6);
    L28:
        return new az(r13, r15, r17, r18, r19, r7);
    L19:
        r18 = r0.getInt(r4);
        goto L20
    L13:
        if (r0.isNull(r3) == true) goto L11;
        r8 = r0.getString(r3);
        goto L11
    L8:
        r15 = r0.getLong(r2);
        goto L9
    L5:
        r13 = r0.getLong(r1);
        goto L6
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<az> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfElementKGIndexPendingEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<az> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfElementKGIndexPendingEntity.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    /* JADX INFO: renamed from: delete, reason: avoid collision after fix types in other method */
    public int delete2(az r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfElementKGIndexPendingEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int delete(az r3) {
        return delete2((az) ZeusTransformUtils.preCheckCast(r3, az.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return ElementKGIndexPendingDao.DefaultImpls.deleteAll(this);
    }

    @Override // com.obric.memorydata.database.dao.ElementKGIndexPendingDao
    public int deleteByRawDb(long r3, int r5) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfDeleteByRawDb.acquire();
        r0.bindLong(1, r3);
        r0.bindLong(2, r5);
        this.__db.beginTransaction();
        int r4 = r0.executeUpdateDelete();     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteByRawDb.release(r0);
        return r4;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteByRawDb.release(r0);
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.ElementKGIndexPendingDao
    public void deleteItemsWithIndexed() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfDeleteItemsWithIndexed.acquire();
        this.__db.beginTransaction();
        r0.executeUpdateDelete();     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteItemsWithIndexed.release(r0);
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteItemsWithIndexed.release(r0);
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.ElementKGIndexPendingDao
    public List<az> getAllItems() {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM ElementKGIndexPending", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor r2 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r2, OaidModel.KEY_ID);     // Catch: Throwable -> L14
        int r4 = CursorUtil.getColumnIndexOrThrow(r2, "rawDbId");     // Catch: Throwable -> L14
        int r5 = CursorUtil.getColumnIndexOrThrow(r2, "entityId");     // Catch: Throwable -> L14
        int r6 = CursorUtil.getColumnIndexOrThrow(r2, "entityType");     // Catch: Throwable -> L14
        int r7 = CursorUtil.getColumnIndexOrThrow(r2, "state");     // Catch: Throwable -> L14
        int r8 = CursorUtil.getColumnIndexOrThrow(r2, "timestamp");     // Catch: Throwable -> L14
        ArrayList r9 = new ArrayList(r2.getCount());     // Catch: Throwable -> L14
    L4:
        if (r2.moveToNext() == false) goto L12;
        long r12 = r2.getLong(r0);     // Catch: Throwable -> L14
        long r14 = r2.getLong(r4);     // Catch: Throwable -> L14
        if (r2.isNull(r5) == false) goto L9;
        String r16 = null;
    L10:
        r9.add(new az(r12, r14, r16, r2.getInt(r6), r2.getInt(r7), r2.getLong(r8)));     // Catch: Throwable -> L14
        goto L4
    L9:
        r16 = r2.getString(r5);     // Catch: Throwable -> L14
        goto L10
    L12:
        r2.close();
        r1.release();
        return r9;
    L14:
        th = move-exception;
        r2.close();
        r1.release();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.ElementKGIndexPendingDao, com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return ElementKGIndexPendingDao.DefaultImpls.getTableName(this);
    }

    @Override // com.obric.memorydata.database.dao.ElementKGIndexPendingDao
    public int getTotalCount() {
        int r1 = 0;
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM ElementKGIndexPending", 0);
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

    /* JADX INFO: renamed from: insert, reason: avoid collision after fix types in other method */
    public long insert2(az r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfElementKGIndexPendingEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ long insert(az r3) {
        return insert2((az) ZeusTransformUtils.preCheckCast(r3, az.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<az> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfElementKGIndexPendingEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<az> queryAll() {
        return ElementKGIndexPendingDao.DefaultImpls.queryAll(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return ElementKGIndexPendingDao.DefaultImpls.queryAllCount(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public az queryById(long r1) {
        return ElementKGIndexPendingDao.DefaultImpls.queryById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ az queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<az> queryByIds(List<Long> r3) {
        return ElementKGIndexPendingDao.DefaultImpls.queryByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public az queryByUUID(String r1) {
        return ElementKGIndexPendingDao.DefaultImpls.queryByUUID(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ az queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    @Override // com.obric.memorydata.database.dao.ElementKGIndexPendingDao
    public List<az> queryIndexed(long r22, int r24) {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM ElementKGIndexPending WHERE rawDbId = ? AND entityType = ? AND state != 0", 2);
        r1.bindLong(1, r22);
        r1.bindLong(2, r24);
        this.__db.assertNotSuspendingTransaction();
        Cursor r2 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r2, OaidModel.KEY_ID);     // Catch: Throwable -> L14
        int r4 = CursorUtil.getColumnIndexOrThrow(r2, "rawDbId");     // Catch: Throwable -> L14
        int r5 = CursorUtil.getColumnIndexOrThrow(r2, "entityId");     // Catch: Throwable -> L14
        int r6 = CursorUtil.getColumnIndexOrThrow(r2, "entityType");     // Catch: Throwable -> L14
        int r7 = CursorUtil.getColumnIndexOrThrow(r2, "state");     // Catch: Throwable -> L14
        int r8 = CursorUtil.getColumnIndexOrThrow(r2, "timestamp");     // Catch: Throwable -> L14
        ArrayList r9 = new ArrayList(r2.getCount());     // Catch: Throwable -> L14
    L4:
        if (r2.moveToNext() == false) goto L12;
        long r12 = r2.getLong(r0);     // Catch: Throwable -> L14
        long r14 = r2.getLong(r4);     // Catch: Throwable -> L14
        if (r2.isNull(r5) == false) goto L9;
        String r16 = null;
    L10:
        r9.add(new az(r12, r14, r16, r2.getInt(r6), r2.getInt(r7), r2.getLong(r8)));     // Catch: Throwable -> L14
        goto L4
    L9:
        r16 = r2.getString(r5);     // Catch: Throwable -> L14
        goto L10
    L12:
        r2.close();
        r1.release();
        return r9;
    L14:
        th = move-exception;
        r2.close();
        r1.release();
        throw th;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public az queryOne() {
        return ElementKGIndexPendingDao.DefaultImpls.queryOne(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ az queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.ElementKGIndexPendingDao
    public List<az> queryWithId(List<Long> r22) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r22, List.class, "com.obric.memorydata.plugin");
        StringBuilder r3 = StringUtil.newStringBuilder();
        r3.append("SELECT * FROM ElementKGIndexPending WHERE id IN (");
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
        int r0 = CursorUtil.getColumnIndexOrThrow(r7, OaidModel.KEY_ID);     // Catch: Throwable -> L18
        int r8 = CursorUtil.getColumnIndexOrThrow(r7, "rawDbId");     // Catch: Throwable -> L18
        int r9 = CursorUtil.getColumnIndexOrThrow(r7, "entityId");     // Catch: Throwable -> L18
        int r10 = CursorUtil.getColumnIndexOrThrow(r7, "entityType");     // Catch: Throwable -> L18
        int r11 = CursorUtil.getColumnIndexOrThrow(r7, "state");     // Catch: Throwable -> L18
        int r12 = CursorUtil.getColumnIndexOrThrow(r7, "timestamp");     // Catch: Throwable -> L18
        ArrayList r13 = new ArrayList(r7.getCount());     // Catch: Throwable -> L18
    L8:
        if (r7.moveToNext() == false) goto L16;
        long r14 = r7.getLong(r0);     // Catch: Throwable -> L18
        long r15 = r7.getLong(r8);     // Catch: Throwable -> L18
        if (r7.isNull(r9) == false) goto L13;
        String r16 = null;
    L14:
        r13.add(new az(r14, r15, r16, r7.getInt(r10), r7.getInt(r11), r7.getLong(r12)));     // Catch: Throwable -> L18
        goto L8
    L13:
        r16 = r7.getString(r9);     // Catch: Throwable -> L18
        goto L14
    L16:
        r7.close();
        r5.release();
        return r13;
    L18:
        th = move-exception;
        r7.close();
        r5.release();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<az> queryWithLimitAndOffset(int r1, int r2) {
        return ElementKGIndexPendingDao.DefaultImpls.queryWithLimitAndOffset(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.ElementKGIndexPendingDao
    public List<az> queryWithRawDb(long r22, int r24) {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM ElementKGIndexPending WHERE rawDbId = ? AND entityType = ?", 2);
        r1.bindLong(1, r22);
        r1.bindLong(2, r24);
        this.__db.assertNotSuspendingTransaction();
        Cursor r2 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r2, OaidModel.KEY_ID);     // Catch: Throwable -> L14
        int r4 = CursorUtil.getColumnIndexOrThrow(r2, "rawDbId");     // Catch: Throwable -> L14
        int r5 = CursorUtil.getColumnIndexOrThrow(r2, "entityId");     // Catch: Throwable -> L14
        int r6 = CursorUtil.getColumnIndexOrThrow(r2, "entityType");     // Catch: Throwable -> L14
        int r7 = CursorUtil.getColumnIndexOrThrow(r2, "state");     // Catch: Throwable -> L14
        int r8 = CursorUtil.getColumnIndexOrThrow(r2, "timestamp");     // Catch: Throwable -> L14
        ArrayList r9 = new ArrayList(r2.getCount());     // Catch: Throwable -> L14
    L4:
        if (r2.moveToNext() == false) goto L12;
        long r12 = r2.getLong(r0);     // Catch: Throwable -> L14
        long r14 = r2.getLong(r4);     // Catch: Throwable -> L14
        if (r2.isNull(r5) == false) goto L9;
        String r16 = null;
    L10:
        r9.add(new az(r12, r14, r16, r2.getInt(r6), r2.getInt(r7), r2.getLong(r8)));     // Catch: Throwable -> L14
        goto L4
    L9:
        r16 = r2.getString(r5);     // Catch: Throwable -> L14
        goto L10
    L12:
        r2.close();
        r1.release();
        return r9;
    L14:
        th = move-exception;
        r2.close();
        r1.release();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<az> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntityElementKGIndexPendingEntity(r6));     // Catch: Throwable -> L10
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
    public int update2(az r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfElementKGIndexPendingEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int update(az r3) {
        return update2((az) ZeusTransformUtils.preCheckCast(r3, az.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<az> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfElementKGIndexPendingEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.ElementKGIndexPendingDao
    public void updateAsLowPowerIndexed(long r3) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfUpdateAsLowPowerIndexed.acquire();
        r0.bindLong(1, r3);
        this.__db.beginTransaction();
        r0.executeUpdateDelete();     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        this.__preparedStmtOfUpdateAsLowPowerIndexed.release(r0);
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfUpdateAsLowPowerIndexed.release(r0);
        throw th;
    }
}
