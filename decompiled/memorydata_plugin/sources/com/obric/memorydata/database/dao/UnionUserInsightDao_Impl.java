package com.obric.memorydata.database.dao;

import android.database.Cursor;
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
import com.obric.memorydata.database.entity.iw;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class UnionUserInsightDao_Impl implements UnionUserInsightDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<iw> __deletionAdapterOfUnionUserInsightEntity;
    private final EntityInsertionAdapter<iw> __insertionAdapterOfUnionUserInsightEntity;
    private final EntityInsertionAdapter<iw> __insertionAdapterOfUnionUserInsightEntity_1;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAll;
    private final EntityDeletionOrUpdateAdapter<iw> __updateAdapterOfUnionUserInsightEntity;

    public UnionUserInsightDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfUnionUserInsightEntity = new AnonymousClass1(this, r2);
        this.__insertionAdapterOfUnionUserInsightEntity_1 = new AnonymousClass2(this, r2);
        this.__deletionAdapterOfUnionUserInsightEntity = new AnonymousClass3(this, r2);
        this.__updateAdapterOfUnionUserInsightEntity = new AnonymousClass4(this, r2);
        this.__preparedStmtOfDeleteAll = new AnonymousClass5(this, r2);
    }

    private iw __entityCursorConverter_comObricMemorydataDatabaseEntityUnionUserInsightEntity(Cursor r8) {
        Cursor r7 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r8, Cursor.class, "com.obric.memorydata.plugin");
        int r9 = CursorUtil.getColumnIndex(r7, OaidModel.KEY_ID);
        int r0 = CursorUtil.getColumnIndex(r7, "summary");
        int r1 = CursorUtil.getColumnIndex(r7, "description");
        int r2 = CursorUtil.getColumnIndex(r7, "createTime");
        int r3 = 0;
        if (r9 != (-1)) goto L5;
        int r10 = 0;
    L6:
        String r5 = null;
        if (r0 != (-1)) goto L10;
    L8:
        String r4 = null;
    L13:
        if (r1 != (-1)) goto L16;
    L19:
        if (r2 == (-1)) goto L23;
        r3 = r7.getInt(r2);
    L23:
        return new iw(r10, r4, r5, r3);
    L16:
        if (r7.isNull(r1) == true) goto L19;
        r5 = r7.getString(r1);
        goto L19
    L10:
        if (r7.isNull(r0) == true) goto L8;
        r4 = r7.getString(r0);
        goto L13
    L5:
        r10 = r7.getInt(r9);
        goto L6
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<iw> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfUnionUserInsightEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<iw> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfUnionUserInsightEntity_1.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    /* JADX INFO: renamed from: delete, reason: avoid collision after fix types in other method */
    public int delete2(iw r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfUnionUserInsightEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int delete(iw r3) {
        return delete2((iw) ZeusTransformUtils.preCheckCast(r3, iw.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.UnionUserInsightDao, com.obric.memorydata.database.dao.BaseDao
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

    @Override // com.obric.memorydata.database.dao.UnionUserInsightDao
    public iw getLatest() {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM UnionUserInsight ORDER BY id DESC LIMIT 1", 0);
        this.__db.assertNotSuspendingTransaction();
        iw r2 = null;
        String r3 = null;
        Cursor r7 = DBUtil.query(this.__db, r0, false, null);
        int r1 = CursorUtil.getColumnIndexOrThrow(r7, OaidModel.KEY_ID);     // Catch: Throwable -> L17
        int r4 = CursorUtil.getColumnIndexOrThrow(r7, "summary");     // Catch: Throwable -> L17
        int r5 = CursorUtil.getColumnIndexOrThrow(r7, "description");     // Catch: Throwable -> L17
        int r6 = CursorUtil.getColumnIndexOrThrow(r7, "createTime");     // Catch: Throwable -> L17
        if (r7.moveToFirst() == false) goto L15;
        int r8 = r7.getInt(r1);     // Catch: Throwable -> L17
        if (r7.isNull(r4) == false) goto L8;
        String r9 = null;
    L10:
        if (r7.isNull(r5) == true) goto L13;
        r3 = r7.getString(r5);     // Catch: Throwable -> L17
    L13:
        r2 = new iw(r8, r9, r3, r7.getInt(r6));     // Catch: Throwable -> L17
        goto L15
    L8:
        r9 = r7.getString(r4);     // Catch: Throwable -> L17
    L15:
        r7.close();
        r0.release();
        return r2;
    L17:
        th = move-exception;
        r7.close();
        r0.release();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.UnionUserInsightDao, com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return UnionUserInsightDao.DefaultImpls.getTableName(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.UnionUserInsightDao
    public long insert(iw r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfUnionUserInsightEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ long insert(iw r3) {
        return insert((iw) ZeusTransformUtils.preCheckCast(r3, iw.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<iw> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfUnionUserInsightEntity_1.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<iw> queryAll() {
        return UnionUserInsightDao.DefaultImpls.queryAll(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return UnionUserInsightDao.DefaultImpls.queryAllCount(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public iw queryById(long r1) {
        return UnionUserInsightDao.DefaultImpls.queryById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ iw queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<iw> queryByIds(List<Long> r3) {
        return UnionUserInsightDao.DefaultImpls.queryByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public iw queryByUUID(String r1) {
        return UnionUserInsightDao.DefaultImpls.queryByUUID(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ iw queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public iw queryOne() {
        return UnionUserInsightDao.DefaultImpls.queryOne(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ iw queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<iw> queryWithLimitAndOffset(int r1, int r2) {
        return UnionUserInsightDao.DefaultImpls.queryWithLimitAndOffset(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<iw> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntityUnionUserInsightEntity(r6));     // Catch: Throwable -> L10
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
    public int update2(iw r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfUnionUserInsightEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int update(iw r3) {
        return update2((iw) ZeusTransformUtils.preCheckCast(r3, iw.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<iw> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfUnionUserInsightEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
